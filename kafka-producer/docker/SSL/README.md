1. Create own private Certificate Authority (CA)
openssl req -new -newkey rsa:4096 -days 365 -x509 -subj “/CN=Demo-Kafka” -keyout ca-key -out ca-cert -nodes

2. Create Kafka Server Certificate and store in KeyStore:
keytool -genkey -keystore kafka.server.keystore.jks -validity 365 -storepass 123abc -keypass 123abc -dname "CN=kafka-server" -storetype pkcs12 -keyalg RSA