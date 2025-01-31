package com.mongodb.csfle;
/*
 * Copyright 2008-present MongoDB, Inc.

 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

import java.util.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Base64;

import org.bson.BsonBinary;
import org.bson.BsonDocument;
import org.bson.BsonString;

import com.mongodb.ClientEncryptionSettings;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.model.vault.DataKeyOptions;
import com.mongodb.client.vault.ClientEncryption;
import com.mongodb.client.vault.ClientEncryptions;


/*
 * - Reads master key from file "master-key.txt" in root directory of project, or creates one on a KMS
 * - Locates existing local encryption key from encryption.__keyVault collection, or from a KMS
 * - Prints base 64-encoded value of the data encryption key
 */
public class makeDataKey {

    public static void main(String[] args) throws Exception {

        // start-kmsproviders
        String kmsProvider = "gcp";
        Map<String, Map<String, Object>> kmsProviders = new HashMap<String, Map<String, Object>>();
        Map<String, Object> providerDetails = new HashMap<>();
        providerDetails.put("email", "<Your GCP Email Address>");
        providerDetails.put("privateKey", "<Your GCP Private Key>");
        kmsProviders.put(kmsProvider, providerDetails);
        // end-kmsproviders

        // start-datakeyopts
        BsonDocument masterKeyProperties = new BsonDocument();
        masterKeyProperties.put("provider", new BsonString(kmsProvider));
        masterKeyProperties.put("projectId", new BsonString("<Your GCP Project ID>"));
        masterKeyProperties.put("location", new BsonString("<Your GCP Key Location>"));
        masterKeyProperties.put("keyRing", new BsonString("<Your GCP Key Ring>"));
        masterKeyProperties.put("keyName", new BsonString("<Your GCP Key Name>"));
        // end-datakeyopts

        // start-create-dek
        String connectionString = "<Your MongoDB URI>";
        String keyVaultNamespace = "encryption.__keyVault";
        ClientEncryptionSettings clientEncryptionSettings = ClientEncryptionSettings.builder()
                .keyVaultMongoClientSettings(MongoClientSettings.builder()
                        .applyConnectionString(new ConnectionString(connectionString))
                        .build())
                .keyVaultNamespace(keyVaultNamespace)
                .kmsProviders(kmsProviders)
                .build();
        ClientEncryption clientEncryption = ClientEncryptions.create(clientEncryptionSettings);
        BsonBinary dataKeyId = clientEncryption.createDataKey(kmsProvider, new DataKeyOptions().masterKey(masterKeyProperties));
        String base64DataKeyId = Base64.getEncoder().encodeToString(dataKeyId.getData());
        System.out.println("DataKeyId [base64]: " + base64DataKeyId);
        clientEncryption.close();
        // end-create-dek
    }
}
