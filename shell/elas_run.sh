#!/bin/sh
#
# chkconfig: 345 99 01
# description: elasticsearch
#
# File : elasticsearch
#
# Description: Starts and stops the Kafka server
#

#source /etc/rc.d/init.d/functions

ELAS_HOME=/usr/elasticsearch/elasticsearch-6.4.1
ELAS_USER=esa
ELAS_LOGS=/usr/elasticsearch/elasticsearch-6.4.1/elas-log
# See how we were called.
case "$1" in

  start)
    echo -n "Starting elasticsearch:"
    /bin/su $ELAS_USER -c "nohup $ELAS_HOME/bin/elasticsearch > $ELAS_LOGS/server.out 2> $ELAS_LOGS/server.err &"
    echo " done."
    exit 0
    ;;
  stop)
    echo -n "Stopping elasticsearch: "
    echo `ps -ef | grep Elasticsearch | grep -v grep | grep java | awk '{print $2}'`
    /bin/su $ELAS_USER -c "ps -ef | grep Elasticsearch | grep -v grep | grep java | awk '{print \$2}' | xargs kill"
    echo " done."
    exit 0
    ;;
  hardstop)
    echo -n "Stopping (hard) elasticsearch: "
    echo `ps -ef | grep Elasticsearch | grep -v grep | grep java | awk '{print $2}'`
    /bin/su $ELAS_USER -c "ps -ef | grep Elasticsearch | grep -v grep | grep java | awk '{print \$2}' | xargs kill -9"
    echo " done."
    exit 0
    ;;

  status)
    c_pid=`ps -ef | grep Elasticsearch | grep -v grep | grep java | awk '{print $2}'`
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
