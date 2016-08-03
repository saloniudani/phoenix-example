Example that demonstrates how to connect to a local HBase instance through Phoenix in Java code.

1. Setup JAVA (Preferable java 8) and set $JAVA_HOME variable
2. Download Hbase and extract it in the $HOME directory.
 - https://www.apache.org/dist/hbase/1.1.5/hbase-1.1.5-bin.tar.gz
 - tar xzvf hbase-1.1.5-bin.tar.gz
3. cd hbase-1.1.5-bin
4. Edit conf/hbase-site.xml
 ```XML  
 <configuration>
     <property>
       <name>hbase.rootdir</name>
       <value>file://$HOME/hbase-1.1.5/data/hbase/</value>
     </property>
     <property>
       <name>hbase.zookeeper.property.dataDir</name>
       <value>$HOME/hbase-1.1.5/data/zookeeper</value>
     </property>
     <property>
          <name>hbase.regionserver.wal.codec</name>
          <value>org.apache.hadoop.hbase.regionserver.wal.IndexedWALEditCodec</value>
          <description>Factory to create the Phoenix RPC Scheduler that knows to put index updates into index queues</description>
      </property>
   </configuration>
 ```
5. Make data directory.
 - mkdir data
 - cd data
 - mkdir zookeeper
6. Download Phoenix and extract it in the $HOME directory.
 - http://www-eu.apache.org/dist/phoenix/phoenix-4.7.0-HBase-1.1/bin/phoenix-4.7.0-HBase-1.1-bin.tar.gz
 - tar xzvf phoenix-4.7.0-HBase-1.1-bin.tar.gz
7. Copy the $HOME/phoenix-4.7.0-HBase-1.1-bin/phoenix-phoenix-4.7.0-HBase-1.1-server.jar the $HOME/hbase-1.1.5/lib/ directory.
8. cd $HOME/hbase-1.1.5/bin/ and start hbase
 - ./start-hbase.sh
 - You can got to localhost:16010 to see HMaster is up and running.
9. Go to $HOME directory and pull the phoenix-example project from github
 - git clone https://github.com/saloniudani/phoenix-example.git
10. cd phoenix-example
11. Build the project with maven.A jar will be created inside target directory.
 - mvn clean install
12. Run the example
 - java -jar target/phoenix-example-1.0.jar
13. cd $HOME/phoenix-4.7.0-HBase-1.1-bin/bin
 - ./sqlline.py localhost
 - List tables: !tables.You will see STOCK_SYMBOL table created.
