.. procedure::
   :style: connected

   .. _field-level-encryption-data-key-retrieve:

   .. step:: Specify the {+key-vault-long-title+} Namespace

      Specify ``encryption.__keyVault`` as the {+key-vault-long+}
      namespace.

      .. tabs-drivers::

         .. tab::
            :tabid: nodejs

            .. literalinclude:: /includes/queryable-encryption/sample_apps/build/node-fle-2/local/reader/insert_encrypted_document.js
               :start-after: start-key-vault
               :end-before: end-key-vault
               :language: javascript
               :dedent:
               :caption: insert_encrypted_document.js

         .. tab::
            :tabid: python

            .. literalinclude:: /includes/queryable-encryption/sample_apps/build/python-fle-2/local/reader/insert_encrypted_document.py
               :start-after: start-key-vault
               :end-before: end-key-vault
               :language: python
               :dedent:
               :caption: insert_encrypted_document.py


   .. step:: Specify the Local {+cmk-long+}

      Specify the KMS provider and specify your key inline:

      .. tabs-drivers::

         .. tab::
            :tabid: nodejs

            .. literalinclude:: /includes/queryable-encryption/sample_apps/build/node-fle-2/local/reader/insert_encrypted_document.js
               :start-after: start-kmsproviders
               :end-before: end-kmsproviders
               :language: javascript
               :dedent:
               :caption: insert_encrypted_document.js

         .. tab::
            :tabid: python

            .. literalinclude:: /includes/queryable-encryption/sample_apps/build/python-fle-2/local/reader/insert_encrypted_document.py
               :start-after: start-kmsproviders
               :end-before: end-kmsproviders
               :language: python
               :dedent:
               :caption: insert_encrypted_document.py

   .. step:: Create an {+enc-fields-map-title+} For Your Collection

      .. _qe-quickstart-encrypted-fields-map:

      .. tabs-drivers::

         .. tab::
            :tabid: nodejs

            .. literalinclude:: /includes/queryable-encryption/sample_apps/build/node-fle-2/local/reader/insert_encrypted_document.js
               :start-after: start-schema
               :end-before: end-schema
               :language: javascript
               :dedent:
               :caption: insert_encrypted_document.js

         .. tab::
            :tabid: python

            .. literalinclude:: /includes/queryable-encryption/sample_apps/build/python-fle-2/local/reader/insert_encrypted_document.py
               :start-after: start-schema
               :end-before: end-schema
               :language: python
               :dedent:
               :caption: insert_encrypted_document.py

   .. step:: Specify the Location of the {+shared-library+}

      .. _qe-quick-start-shared-lib:

      .. tabs-drivers::

         .. tab::
            :tabid: nodejs

            .. literalinclude:: /includes/queryable-encryption/sample_apps/build/node-fle-2/local/reader/insert_encrypted_document.js
               :start-after: start-extra-options
               :end-before: end-extra-options
               :language: javascript
               :caption: insert_encrypted_document.js
               :dedent:

         .. tab::
            :tabid: python

            .. literalinclude:: /includes/queryable-encryption/sample_apps/build/python-fle-2/local/reader/insert_encrypted_document.py
               :start-after: start-extra-options
               :end-before: end-extra-options
               :language: python
               :dedent:
               :caption: insert_encrypted_document.py

      .. include:: /includes/queryable-encryption/shared-lib-learn-more.rst

   .. step:: Create the MongoClient

      Instantiate a MongoDB client object with the following
      automatic encryption settings:

      .. tabs-drivers::

         .. tab::
            :tabid: nodejs

            .. literalinclude:: /includes/queryable-encryption/sample_apps/build/node-fle-2/local/reader/insert_encrypted_document.js
               :start-after: start-client
               :end-before: end-client
               :language: javascript
               :dedent:
               :caption: insert_encrypted_document.js

         .. tab::
            :tabid: python

            .. literalinclude:: /includes/queryable-encryption/sample_apps/build/python-fle-2/local/reader/insert_encrypted_document.py
               :start-after: start-client
               :end-before: end-client
               :language: python
               :dedent:
               :caption: insert_encrypted_document.py
