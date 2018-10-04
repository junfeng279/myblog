#!/bin/sh
#
# chkconfig: 345 99 01
# description: zookeeper
#
# File : zookeeper
#
# Description: Starts and stops the Kafka server
#

#source /etc/rc.d/init.d/functions

ZOOKEEPER_HOME=/usr/kafka/kafka_2.11-1.0.2
ZOOKEEPER_USER=root
ZOOKEEPER_LOGS=/usr/kafka/kafka_2.11-1.0.2/zookeeper/log
# See how we were called.
case "$1" in

  start)
    echo -n "Starting zookeeper:"
    /sbin/runuser $ZOOKEEPER_USER -c "nohup $ZOOKEEPER_HOME/bin/zookeeper-server-start.sh $ZOOKEEPER_HOME/config/zookeeper.properties > $ZOOKEEPER_LOGS/server.out 2> $ZOOKEEPER_LOGS/server.err &"
    echo " done."
    exit 0
    ;;

  stop)
    echo -n "Stopping zookeeper: "
    echo `ps -ef | grep zookeeper | grep -v grep | grep java | grep zookeeper.properties  | awk '{print $2}'`
    #pid=`ps -ef | grep zookeeper | grep -v grep | grep java | awk '{print $2}'`
    #/sbin/runuser  $ZOOKEEPER_USER  -c kill $pid
    /sbin/runuser  $ZOOKEEPER_USER  -c "ps -ef | grep zookeeper | grep -v grep | grep java | grep zookeeper.properties | awk '{print \$2}' | xargs kill"
    #ps -ef | grep zookeeper | grep -v grep | awk '{print $2}' | xargs kill
    echo " done."
    exit 0
    ;;
  hardstop)
    echo -n "Stopping (hard) zookeeper: "
    # sleep 30
    echo `ps -ef | grep zookeeper | grep -v grep | grep java | grep zookeeper.properties | awk '{print $2}'`
    #echo $pid
    #/sbin/runuser  $ZOOKEEPER_USER  -c kill $pie
    /sbin/runuser  $ZOOKEEPER_USER  -c "ps -ef | grep zookeeper | grep -v grep | grep java | grep zookeeper.properties | awk '{print \$2}' | xargs kill -9"
    echo " done."
    exit 0
    ;;

  status)
    c_pid=`ps -ef | grep zookeeper | grep -v grep | grep java | grep zookeeper.properties | awk '{print $2}'`
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
