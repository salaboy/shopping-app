#~/bin/bash

version=${1:latest}

docker build -t shopapp/keycloak:$version .


