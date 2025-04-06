pipeline {
    agent any

    environment {
        // Remplace ceci par les chemins ou variables que tu utilises
        DOCKER_IMAGE = 'aniverseimg'
        DOCKER_TAG = 'latest'
    }

    tools {
        maven 'Maven 3.8.1'  // adapte si tu utilises un autre outil
        jdk 'JDK17'          // adapte selon ta version de Java
    }

    stages {
        stage('Checkout Code') {
            steps {
                echo '🔄 Clonage du dépôt Git...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo '🔧 Compilation du projet...'
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo '🧪 Lancement des tests unitaires...'
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo '📦 Création du fichier WAR...'
                sh 'mvn package'
            }
        }

        stage('Docker Build & Push') {
            steps {
                echo '🐳 Création de l’image Docker...'
                sh 'docker build -t $DOCKER_IMAGE:$DOCKER_TAG .'

                // Optionnel : push vers Docker Hub ou autre registry
                // sh 'docker login -u $DOCKER_USER -p $DOCKER_PASS'
                // sh 'docker push $DOCKER_IMAGE:$DOCKER_TAG'
            }
        }

        stage('Deploy to Server') {
            steps {
                echo '🚀 Déploiement sur le serveur...'
                // Ajoute ici ton script ou commande ssh/docker-compose
                // Exemple : sh 'scp target/aniverse.war user@server:/deploy/'
            }
        }
    }

    post {
        success {
            echo '✅ Pipeline terminé avec succès !'
        }
        failure {
            echo '❌ Échec du pipeline !'
        }
    }
}
