#!/bin/sh
#
# chkconfig: 345 99 01
# description: logstash
#
# File : logstash
#
# Description: Starts and stops the Kafka server
#

#source /etc/rc.d/init.d/functions

LOGSTASH_HOME=/usr/logstash/logstash-6.4.1
LOGSTASH_USER=root
LOGSTASH_LOGS=/usr/logstash/logstash-6.4.1/logstash-log
# See how we were called.
case "$1" in

  start)
    echo -n "Starting logstash:"
    /bin/su $LOGSTASH_USER -c "nohup $LOGSTASH_HOME/bin/logstash -f $LOGSTASH_HOME/config/logstash.conf > $LOGSTASH_LOGS/server.out 2> $LOGSTASH_LOGS/server.err &"
    echo " done."
    exit 0
    ;;

  stop)
    echo -n "Stopping logstash: "
    echo `ps -ef | grep logstash | grep -v grep | grep java | grep logstash.conf | awk '{print $2}'`
    /bin/su $LOGSTASH_USER -c "ps -ef | grep logstash | grep -v grep | grep java | grep logstash.conf | awk '{print \$2}' | xargs kill -9"
    echo " done."
    exit 0
    ;;
  hardstop)
    echo -n "Stopping (hard) logstash: "
    echo `ps -ef | grep logstash | grep -v grep | grep java | grep logstash.conf | awk '{print $2}'`
    /bin/su $LOGSTASH_USER -c "ps -ef | grep logstash | grep -v grep | grep java | grep logstash | awk '{print \$2}' | xargs kill -9"
    echo " done."
    exit 0
    ;;

  status)
    c_pid=`ps -ef | grep logstash | grep -v grep | grep java | grep logstash.conf | awk '{print $2}'`
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
