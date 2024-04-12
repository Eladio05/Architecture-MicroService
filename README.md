# Architecture-MicroService

# Mise en place de cloudConfig
- générer le .jar de l'application SpringBoot : mvn clean package -DskipTests
- Créer l'image docker du Dockerfile : docker build -t cloudconfig .
- Lancer l'image docker : docker run -p 8888:8888 --name cloudconfigDocker cloudconfig

# Connextion à la BDD
- Executer le docker compose
- se connecter à localhost:5050
- entrer le mail et mdp présent dans le docker compose
- entrer le fichier sql
