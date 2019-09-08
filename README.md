
# Quarkus Branch

NOTE: Must use Java 8 and at least Maven 3.5.4

## To run

$ mvn compile quarkus:dev
$ Navigate to localhost:80

## To build

$ mvn package

## To build docker image
S
$ docker build -f src/main/docker/Dockerfile.multistage -t [IMAGE NAME] .

## To run docker image

$ docker run -i --rm -p 80:80 [IMAGE NAME]

Note that image name can be whatever you want it to be

## Azure Deployment

Untested, notes for later

### Container Registry Instance Creation

$ az login
$ az group create --name \<resource-group-name> --location [location code]
$ az acr create --resource-group \<resource-group-name> --name \<registry-name> --sku Basic --admin-enabled true
$ az acr login --name \<registry-name>

### Uploading Docker Image

$ az acr show -n \<registry-name> --query loginServer
$ docker tag [IMAGE NAME] \<acr-login-server>/[IMAGE NAME]
$ docker push \<acr-login-server>/[IMAGE NAME]
$ az acr repository list -n <registry-name>

### Deploying to Azure Container Instances

$ az acr credential show --name \<registry-name>
$ az container create \
    --name [container name] \
    --resource-group \<resource-group> \
    --image \<acr-login-server>/[IMAGE NAME] \
    --registry-login-server \<acr-login-server> \
    --registry-username \<acr-username> \
    --registry-password \<acr-password> \
    --dns-name-label [container name]-\<random-number> \
    --query ipAddress.fqdn
