sudo sysctl -w vm.max_map_count=262144
#sudo docker exec connect -it /bin/bash
sudo chmod -cr 777 storage

sudo docker exec connect confluent-hub install --no-prompt confluentinc/kafka-connect-elasticsearch:5.4.1
sudo docker exec connect confluent-hub install --no-prompt jcustenborder/kafka-connect-twitter:0.3.33
sudo docker exec connect confluent-hub install  --no-prompt confluentinc/kafka-connect-azure-blob-storage:1.6.1
sudo docker exec connect confluent-hub install  --no-prompt confluentinc/kafka-connect-azure-blob-storage-source:latest
