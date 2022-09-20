keytool -genkey -keystore kafka.server.keystore.jks -validity 365 -storepass "123abc" -keypass "123abc" -dname "CN=kafka-server" -storetype pkcs12
keytool -keystore kafka.server.keystore.jks -certreq -file cert-file -storepass "123abc" -keypass "123abc"

openssl req -new -newkey rsa:4096 -days 365 -x509 -subj "/CN=Kafka-Security-CA" -keyout ca-key -out ca-cert -nodes

openssl x509 -req -CA ca-cert -CAkey ca-key -in localhost-cert-sign-request -out localhost-cert-signed -days 365 -CAcreateserial -passin pass:"123abc"

keytool -keystore kafka.server.truststore.jks -alias CARoot -import -file ca-cert -storepass "123abc" -keypass "123abc" -noprompt
keytool -keystore kafka.server.keystore.jks -alias CARoot -import -file ca-cert -storepass "123abc" -keypass "123abc" -noprompt
keytool -keystore kafka.server.keystore.jks -import -file cert-signed -storepass "123abc" -keypass "123abc" -noprompt


keytool -keystore kafka.client.truststore.jks -alias CARoot -import -file ca-cert -storepass "123abc" -keypass "123abc" -noprompt
keytool -keystore kafka.client.keystore.jks -alias CARoot -import -file ca-cert -storepass "123abc" -keypass "123abc" -noprompt

keytool -genkey -keystore kafka.client.keystore.jks -validity 365 -storepass "123abc" -keypass "123abc" -dname "CN=localhost" -storetype pkcs12
keytool -keystore kafka.client.keystore.jks -certreq -file client-cert-sign-request -storepass "123abc" -keypass "123abc"

keytool -keystore kafka.client.truststore.jks -alias CARoot -import -file ca-cert -storepass "123abc" -keypass "123abc" -noprompt
keytool -keystore kafka.client.keystore.jks -alias CARoot -import -file ca-cert -storepass "123abc" -keypass "123abc" -noprompt
keytool -keystore kafka.client.keystore.jks -import -file client-signed-cert -storepass "123abc" -keypass "123abc" -noprompt