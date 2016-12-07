#!/bin/bash

# Need these on classpath
HBASE_CONFIG=/etc/hbase/conf/
PHOENIX_CLIENT=/usr/hdp/current/phoenix-client/phoenix-client.jar
HBASE_SERVER=/usr/hdp/current/hbase-client/lib/hbase-server.jar

# Our jar and our main class
JARFILE=/tmp/phoenixjdbc-1.0-SNAPSHOT.jar
MAINCLASS=org.apache.phoenixjdbc.App

# Display the classpath
export CLASSPATH=${HBASE_CONFIG}:${PHOENIX_CLIENT}:${HBASE_SERVER}:${JARFILE}
echo "CLASSPATH=${CLASSPATH}"
echo $CLASSPATH | sed "s/:/\n/g"

# Run it!
java -cp ${CLASSPATH} ${MAINCLASS}
exit ${?}

