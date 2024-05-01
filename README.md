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

# Docker
- Mettez vous à la racine du projet après l'avoir téléchargé et dezipper.
- Lancer la commande ```docker compose up --build``` (A noter que le lancement des différents images peuvent prendre un certains temps car certaines dépendent des autres)
- La base de donnée se remplira automatiquement
- Aller sur localhost:4200 pour avoir accès à l'Interface utilisateur
- Aller sur localhost:8761 pour avoir accès à Eurezia

# Problème possible
- Si vous arrivez sur la Welcome page de nginx en passant par localhost:4200, veuillez vider le cache de votre navigateur.

