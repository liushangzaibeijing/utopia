export JAVA_OPTS="$JAVA_OPTS ""-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=127.0.0.1:9008"
nohup java $JAVA_OPTS -jar utopia.jar & --spring.profiles.active=prod
