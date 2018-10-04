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

KIBANA_HOME=/usr/kibana/kibana-6.4.1-linux-x86_64
KIBANA_USER=root
KIBANA_LOGS=/usr/kibana/kibana-6.4.1-linux-x86_64/logs
# See how we were called.
case "$1" in

  start)
    echo -n "Starting Kibana:"
    /sbin/runuser $KIBANA_USER -c "nohup $KIBANA_HOME/bin/kibana > $KIBANA_LOGS/server.out 2> $KIBANA_LOGS/server.err &"
    echo " done."
    exit 0
    ;;

  stop)
    echo -n "Stopping Kibana: "
    echo `ps -ef | grep node | grep kibana | grep -v grep | awk '{print $2}'`
    /sbin/runuser  $KIBANA_USER  -c "ps -ef | grep node | grep kibana | grep -v grep | awk '{print \$2}' | xargs kill"
    echo " done."
    exit 0
    ;;
  hardstop)
    echo -n "Stopping (hard) Kafka: "
    echo `lsof -i :5601 | awk '{print $2}'`
    /sbin/runuser  $KIBANA_USER  -c "ps -ef | grep node | grep kibana | grep -v grep | awk '{print \$2}' | xargs kill -9"
    echo " done."
    exit 0
    ;;

  status)
    c_pid=`ps -ef | grep node | grep kibana | grep -v grep | awk '{print \$2}'`
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
