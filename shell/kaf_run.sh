#!/bin/sh
#
# chkconfig: 345 99 01
# description: Kafka
#
# File : Kafka
#
# Description: Starts and stops the Kafka server
#

#source /etc/rc.d/init.d/functions

KAFKA_HOME=/usr/kafka/kafka_2.11-1.0.2
KAFKA_USER=root
KAFKA_LOGS=/usr/kafka/kafka_2.11-1.0.2/kafka/logs
# See how we were called.
case "$1" in

  start)
    echo -n "Starting Kafka:"
    /sbin/runuser $KAFKA_USER -c "nohup $KAFKA_HOME/bin/kafka-server-start.sh $KAFKA_HOME/config/server.properties > $KAFKA_LOGS/server.out 2> $KAFKA_LOGS/server.err &"
    echo " done."
    exit 0
    ;;

  stop)
    echo -n "Stopping Kafka: "
    echo `ps -ef | grep kafka | grep -v grep | grep java | grep kafkaServer | awk '{print $2}'`
    /sbin/runuser  $KAFKA_USER  -c "ps -ef | grep kafka.Kafka | grep -v grep | grep java | grep kafkaServer | awk '{print \$2}' | xargs kill"
    echo " done."
    exit 0
    ;;
  hardstop)
    echo -n "Stopping (hard) Kafka: "
    /sbin/runuser  $KAFKA_USER  -c "ps -ef | grep kafka.Kafka | grep -v grep | grep java | grep kafkaServer | awk '{print \$2}' | xargs kill -9"
    echo " done."
    exit 0
    ;;

  status)
    c_pid=`ps -ef | grep kafka.Kafka | grep -v grep | grep java | grep kafkaServer | awk '{print $2}'`
    if [ "$c_pid" = "" ] ; then
      echo "Stopped"
      exit 3
    else
      echo "Running $c_pid"
      exit 0
    fi
    ;;

  restart)
    stop
    start
    ;;

  *)
    echo "Usage: cassandra {start|stop|hardstop|status|restart}"
    exit 1
    ;;

esac
