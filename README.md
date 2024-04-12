# Architecture-MicroService

# Mise en place de cloudConfig
- générer le .jar de l'application SpringBoot : mvn clean package -DskipTests
- Créer l'image docker du Dockerfile : docker build -t cloudconfig .
- Lancer l'image docker : docker run -p 8888:8888 --name cloudconfigDocker cloudconfig
