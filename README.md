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
- 
# Documentation du projet

**Intérêt de déporter la configuration des micro-services ? :**
Déplacer la configuration des micro-services vers un système externe permet de gérer les réglages de tous les services depuis un seul endroit. Cela rend plus facile la mise à jour et la gestion des micro-services, car on n'a pas besoin de changer le code directement dans chaque service. C'est pratique pour garder les choses organisées et pour s'assurer que les changements sont appliqués partout en même temps. Nous en avions discuté lors du cours, en déportant la configuration des micro-services vers un système centralisé comme Spring Cloud Config, on peut facilement gérer et modifier les paramètres externes de nos services. Cela comprend les versions des librairies utilisées. Par exemple, si on a configuré la version d'une librairie dans nos fichiers de configuration externes, on peut simplement mettre à jour cette version dans le fichier de configuration centralisé. Une fois cette modification faite, tous les micro-services qui dépendent de cette configuration peuvent être automatiquement mis à jour pour utiliser la nouvelle version de la librairie lorsqu'ils redémarrent ou rafraîchissent leur configuration. Cela simplifie la gestion des dépendances et des mises à jour à travers notre architecture de micro-services, rendant le processus plus efficace et moins sujet à erreurs.

**Intérêt d’Eureka dans ce projet ? :**
Eureka aide les différents micro-services de votre projet à se trouver et à communiquer entre eux facilement. Il joue un rôle similaire à un annuaire téléphonique. Quand on ajoute ou enlève des services, Eureka met à jour la liste de ce qui est disponible. Cela est très utile pour que les services puissent toujours se joindre sans problème, même quand des changements sont faits. Un autre avantage à Eureka est la répartition des charges. En effet, en maintenant à jour une liste des instances de service disponibles, Eureka permet aux applications de distribuer les requêtes de manière équilibrée. Par exemple, lorsqu'une demande arrive, le système peut choisir une instance parmi celles disponibles enregistrées dans Eureka, en suivant une stratégie de répartition de charge. Pour l’utilisateur, cela signifie une durée de latence moins importante. 

**Intérêt de l’api gateway Zuul dans ce projet ? :**
Zuul agit comme un filtre pour l'application. Il reçoit toutes les demandes venant de l'extérieur et décide à quel service les envoyer. Zuul peut aussi ajouter des règles de sécurité ou d'autres contrôles sur ces demandes avant de les passer aux services appropriés. Par exemple, en utilisant des filtres, Zuul peut rejeter les requêtes qui semblent malveillantes ou qui ne respectent pas certaines règles de sécurité, réduisant ainsi le risque qu'une attaque DoS réussisse. De plus, il est également possible pour Zuul de configurer pour limiter le nombre de requêtes qu'un utilisateur peut envoyer sur une période donnée. Cette stratégie peut empêcher un utilisateur ou un script malveillant de submerger l'application avec un grand nombre de requêtes, ce qui est une tactique commune dans les attaques DoS et DDoS. En conclusion, cela aide à garder l'application sécurisée et à s'assurer que tout fonctionne bien ensemble.





