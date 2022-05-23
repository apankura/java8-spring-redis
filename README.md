# java8-spring-redis
java 8 spring redis 


sdk use java 8.0.312-zulu
sdk use gradle 5.6.3
gradle wrapper
./gradlew bootRun
./gradlew bootJar


java -jar ./build/libs/java8-aircraft-0.0.1-SNAPSHOT.jar 

# measure latency 
redis-cli --intrinsic-latency 100 -h localhost -p 6379
redis-benchmark -q -n 10 -t set,lpush -h localhost -p 10200

## use commands 
# memory 
redis-cli INFO MEMORY
redis-cli INFO CLIENTS
redis-cli INFO STATS
redis-cli CLIENT LIST
redis-cli INFO COMMANDSTATS
redis-cli INFO MEMORY|egrep "used_memory_human|maxmemory_human"
redis-cli --bigkeys



KEYS *
HGETALL KEY
MEMORY USAGE KEY