# Étape de build
# Séléction de l'image de base pour le build
FROM maven AS builder

# Définition du répertoire de travail dans le container
WORKDIR /app

# Copie du fichier pom.xml dans le container
COPY pom.xml .

# Installation des dépendances
RUN mvn dependency:go-offline

# Copie du code source dans le container
COPY src ./src

# Compilation du code source
RUN mvn package -DskipTests

# Étape d'exécution
# Séléction de l'image de base pour l'exécution
FROM openjdk

# Définition du répertoire de travail dans le container
WORKDIR /app

# Copie du fichier compilé dans le container
COPY --from=builder /app/target/Exercice3-0.0.1-SNAPSHOT.jar .

# Port 8080 pour accéder à l'application
EXPOSE 8080

# Commande d'exécution
CMD ["java", "-jar", "Exercice3-0.0.1-SNAPSHOT.jar"]