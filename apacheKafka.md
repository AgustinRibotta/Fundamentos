# Apache Kafka
Event messaging service

### Event - Driver architecture

Producer -> responsible for generating the message that will be received by the topic.

Topic -> Event manager that is hosted inside the broker.
    
- Append only. New event add at the end.
    
- Immutable
    
- Event are in order within a partition. Order across is not maintained.
    
- Using the same events ID allows Kafka topic to maintain a sequential order of events within the same partition.

Broker -> Container that stores the topics and their events.
    
- Can run locally or remotely.
    
- Supports data replication for fault tolerance.

Consumer -> Consumes the events produced by the producer and stored in topic.
