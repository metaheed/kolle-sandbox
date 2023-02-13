# Kolle Sandbox

## Run

```
 docker-compose up -d  
 or   
 docker-compose up -d control-center ksqldb-server schema-registry broker zookeeper kolle  
 or   
 sudo docker-compose up -d control-center ksqldb-server connect schema-registry broker zookeeper adminer postgres kolle  
 or   
 sudo docker-compose up -d control-center ksqldb-server connect schema-registry broker zookeeper stardog kolle  
```

## URL
kolle: http://localhost:3000  
Confluent: http://localhost:9021  
Adminer: http://localhost:8080  
kibana: http://localhost:5601/  
Elasticsearch: http://localhost:9200/  
Stardog: https://cloud.stardog.com/ server address http://localhost:5820 


## Upload kolle connection url 
In left side kolle menu, update url   

kafka-schema-registry: http://schema-registry:8081  
kafka-connector:       http://connect:8083  
ksqldb:                http://ksqldb-server:8088  
broker:                broker:29092  



## License

Copyright © 2022-2023 Abdullah Mamun

Distributed under the EPL License. See LICENSE.
