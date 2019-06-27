Welcome to Apache Kafka and Spring Boot Integration for producer as well as consumer.

Please visit https://kafka.apache.org/quickstart for running the instance of kafka and zookeeper.

In case if you are not able to get to the URl then below are the details:

1. To start the zookeeper
bin/zookeeper-server-start.sh config/zookeeper.properties

2. to start the kafka cluster server
bin/kafka-server-start.sh config/server.properties

3. to manually create a new topic
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test (replace test with your topic name)

4. to list the topics
bin/kafka-topics.sh --list --zookeeper localhost:2181 (This will display topics list)

5. to send a msg using producer
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test(replace test with your topic name)

6. to see the consumer consuming the message
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning(replace test with your topic name)

7. Remember to read about the group(s) in kafka, very useful information
https://cwiki.apache.org/confluence/display/KAFKA/Consumer+Group+Example

8. To delete the msgs from producer
seq 0 | ./bin/kafka-console-producer.sh --broker-list localhost:9092 --topic Kafka_Example_json
replace the number after seq to delete those number of msgs. Msgs after that number will be retained. Before that number will be deleted from queue.

My code uses lombok to avoid biler plate code.

There is active information in the code for your information.

----

bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 3 --partitions 3 --topic advice-topic
bin/kafka-topics.sh --list --zookeeper localhost:2181
./kafka-topics.sh --list --zookeeper localhost:2181
bin/kafka-topics.sh --describe --zookeeper 192.168.99.100:2181 --topic advice-topic
bin/kafka-console-producer.sh --broker-list 192.168.99.100:9092 --topic advice-topic
bin/kafka-topics.sh --zookeeper 192.168.99.100:2181 --delete --topic advice-topic

---

docker run --network mynetwork --detach --publish 4433:443 --publish 8080:80 --publish 2222:22 --name gitlab  gitlab/gitlab-ee:latest
docker run --network mynetwork --name nexus -d -p 8081:8081  -e CONTEXT_PATH=/ sonatype/docker-nexus3
docker run --network mynetwork --name jenkinsci -d -p 8080:8082 jenkins/jenkins:lts
docker run --network mynetwork --name sonarqube -d -p 9000:9000 sonarqube