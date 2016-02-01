#~/bin/bash

version=${1:latest}

docker run -it --rm -p 9090:8080 shopapp/keycloak:$version
