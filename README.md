# Architecture-MicroService

# Mise en place de cloudConfig
- générer le .jar de l'application SpringBoot : mvn clean package -DskipTests
- Créer l'image docker du Dockerfile : docker build -t cloudconfig .
- Lancer l'image docker : docker run -p 8888:8888 --name cloudconfigDocker cloudconfig

# Connextion à la BDD
**Les données de la base (table et insert sont chargés au moment du build du docker)
- Executer le docker compose
- se connecter à localhost:5050
- entrer le mail et mdp présent dans le docker compose (email : admin@admin.com et mdp : root)
- Sur pgAdmin, clique droit sur Server et entrer un nom, puis dans la rubrique connexion remplissez les informations comme ceci : 
**Adress :** microserviceData
**Port :** 5432
**Maintenance Database :** test_db
**Username :**  dbuser
**Password :** password123
- Appuyez ensuite sur save et vous pourrez voir la bdd test_db

