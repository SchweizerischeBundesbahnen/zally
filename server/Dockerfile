#
# Build the java application in a separate container.
#
FROM registry.opensource.zalan.do/stups/openjdk:latest as builder
COPY . /src
WORKDIR /src
RUN ./gradlew build -x test --info


FROM registry.opensource.zalan.do/stups/openjdk:latest

MAINTAINER "http://zalando.github.io/"

COPY zally-server/src/main/resources/api/zally-api.yaml /zalando-apis/zally-api.yaml
COPY --from=builder /src/zally-server/build/libs/zally-server.jar /

EXPOSE 8080

CMD java $(java-dynamic-memory-opts) $(appdynamics-agent) -jar /zally-server.jar
