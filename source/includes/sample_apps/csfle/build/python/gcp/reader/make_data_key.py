from pymongo import MongoClient
from pymongo.encryption_options import AutoEncryptionOpts
from pymongo.encryption import ClientEncryption
import base64
import os
from bson.codec_options import CodecOptions
from bson.binary import STANDARD, UUID


# start-kmsproviders
provider = "gcp"
kms_providers = {
    provider: {"email": "<your GCP email>", "privateKey": "<your GCP private key>"}
}
# end-kmsproviders

# start-datakeyopts
master_key = {
    "projectId": "<GCP project identifier>",
    "location": "<GCP region>",
    "keyRing": "<GCP key ring name>",
    "keyName": "<GCP key name>",
}
# end-datakeyopts


# start-create-dek
connection_string = "<your connection string here>"
key_vault_namespace = "encryption.__keyVault"

client = MongoClient(connection_string)
client_encryption = ClientEncryption(
    kms_providers,  # pass in the kms_providers variable from the previous step
    key_vault_namespace,
    client,
    CodecOptions(uuid_representation=STANDARD),
)

data_key_id = client_encryption.create_data_key(provider, master_key)

base_64_data_key_id = base64.b64encode(data_key_id)
print("DataKeyId [base64]: ", base_64_data_key_id)
# end-create-dek