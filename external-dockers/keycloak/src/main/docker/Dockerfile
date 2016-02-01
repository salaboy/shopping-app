FROM java:8-jdk

ENV KEYCLOAK_VERSION 1.8.0.CR3

RUN curl -L http://downloads.jboss.org/keycloak/$KEYCLOAK_VERSION/keycloak-$KEYCLOAK_VERSION.tar.gz | tar zx

ADD files/shop.json /tmp/shop.json

WORKDIR /keycloak-$KEYCLOAK_VERSION/bin

RUN ./add-user.sh -r master -u admin -p admin

#CMD ["./standalone.sh", "-c", "standalone.xml",  "-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "-Djboss.socket.binding.port-offset=1010", "-Dkeycloak.migration.action=import", "-Dkeycloak.migration.provider=singleFile", "-Dkeycloak.migration.file=/tmp/shop.json", "-Dkeycloak.migration.strategy=OVERWRITE_EXISTING"]

CMD ["./standalone.sh", "-c", "standalone.xml",  "-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "-Dkeycloak.migration.action=import", "-Dkeycloak.migration.provider=singleFile", "-Dkeycloak.migration.file=/tmp/shop.json", "-Dkeycloak.migration.strategy=OVERWRITE_EXISTING"]
