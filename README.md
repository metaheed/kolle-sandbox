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
In left side kolle menu, update config url for sandbox   

```
{:runtime-config
 {:kafka-rest-url "http://localhost:8082",
  :kafka-schema-registry
  {:url "http://schema-registry:8081", :api-key nil, :secret nil},
  :kafka-connector
  {:url "http://connect:8083",
   :api-key nil,
   :secret nil,
   :environment-id nil,
   :cluster-id nil},
  :ksqldb {:url "http://ksqldb-server:8088", :api-key nil, :secret nil},
  :kafka-broker
  {:bootstrap.servers "broker:29092", :api-key nil, :secret nil},
  :offset "earliest",
  :query-id-m {}},
 :gen-config
 {:map-dv
  {:attr
   {:load_process 1, :record_source 2, :record_source_ou 20, :test 3},
   :fn nil},
  :distinct {:duration "10 MINUTES"},
  :replicas 1,
  :partitions 1,
  :join-window "WITHIN 5 MINUTES",
  :monitor-stream false, 
  :join-split false, 
  :error-stream-name "error"}}
```




## License

Copyright © 2022-2023 Abdullah Mamun

Distributed under the EPL License. See LICENSE.
