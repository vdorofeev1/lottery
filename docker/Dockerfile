FROM openjdk:17-oracle

ARG VERSION
ARG NAME

ADD ./${NAME}-${VERSION}.jar /bin/
CMD java -jar /bin/${NAME}-${VERSION}.jar

EXPOSE 8080