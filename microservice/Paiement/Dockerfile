# Utiliser une image de base Java
FROM openjdk:17

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le jar de votre application dans le conteneur
COPY microservice/Paiement/target/Paiement-0.0.1-SNAPSHOT.jar /app/paiement.jar

# Commande pour exécuter l'application Spring Boot quand le conteneur démarre
CMD ["java", "-jar", "paiement.jar"]
