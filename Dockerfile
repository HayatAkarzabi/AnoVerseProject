# Utilisation d’une image officielle de Tomcat avec JDK
FROM tomcat:9.0.73-jdk11

# Définir le répertoire de travail
WORKDIR /usr/local/tomcat/webapps/

# Copier les fichiers du projet dans le conteneur (l’archive WAR de ton app "demo")
COPY target/demo-1.0-SNAPSHOT.war demo.war


# Exposer le port 8080 (port par défaut de Tomcat)
EXPOSE 8080

# Commande pour démarrer Tomcat
CMD ["catalina.sh", "run"]
