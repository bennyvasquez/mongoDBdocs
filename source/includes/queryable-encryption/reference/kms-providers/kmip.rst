Architecture
````````````

The following diagram describes the architecture of a
{+qe+} enabled application using a KMIP compliant
{+km-service-long+} provider.

.. image:: /images/CSFLE_Data_Key_KMIP.png
   :alt: Diagram

.. important:: Client Accesses {+cmk-long+}

   When your {+qe+} enabled application uses
   a KMIP compliant {+km-service-long+} provider, your application
   directly accesses your {+cmk-long+}.

kmsProviders Object
```````````````````

The following table presents the structure of a ``kmsProviders``
object for a KMIP compliant {+km-service-long+}:

.. note:: Authenticate through TLS/SSL

   Your {+qe+} enabled application authenticates through
   :abbr:`TLS/SSL (Transport Layer Security/Secure Sockets Layer)`
   when using KMIP.

.. list-table::
   :header-rows: 1
   :stub-columns: 1
   :widths: 20 12 68

   * - Field
     - Required
     - Description

   * - endpoint
     - Yes
     - Specifies a hostname and port number for the authentication server.

.. _qe-reference-kms-providers-kmip-datakeyopts:

dataKeyOpts Object
``````````````````

The following table presents the structure of a ``dataKeyOpts`` object
for a KMIP compliant {+km-service-long+}:

.. list-table::
    :header-rows: 1
    :stub-columns: 1
    :widths: 30 15 45

    * - Field
      - Required
      - Description

    * - keyId
      - No
      - The ``keyId`` field of a 96 byte
        `Secret Data managed object <http://docs.oasis-open.org/kmip/spec/v1.4/os/kmip-spec-v1.4-os.html#_Toc490660780>`__
        stored in your KMIP provider.

        If you do not specify the ``keyId`` field in the ``masterKey`` document
        you send to your KMIP provider, the driver creates a new
        96 Byte Secret Data managed object in your KMIP provider to act as your
        master key.

    * - endpoint
      - Yes
      - The URI of your KMIP provider.
