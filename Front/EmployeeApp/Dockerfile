# Étape de build
# Sélection de l'image de base pour le build
FROM node:16 AS builder

# Définition du répertoire de travail dans le container
WORKDIR /app

# Copie des fichiers package.json et package-lock.json dans le container
COPY package.json package-lock.json ./

# Installation des dépendances
RUN npm install

# Copie du code source dans le container
COPY . .

# Compilation du code source
RUN npm run build

# Étape d'exécution
# Sélection de l'image de base pour Nginx
FROM nginx:alpine

# Copie du code compilé dans le container Nginx
COPY --from=builder /app/dist /usr/share/nginx/html

# Port 80 pour accéder à l'application
EXPOSE 80

# Commande d'exécution pour Nginx
CMD ["nginx", "-g", "daemon off;"]
