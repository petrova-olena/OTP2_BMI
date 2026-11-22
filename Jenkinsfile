pipeline {
    agent any

    tools {
        maven 'Maven_config'   // Must match the name configured in Jenkins Global Tool Configuration
    }

    environment {
        // these are the environment variables (Amir's machine) that will be used in the pipeline
       PATH = "C:\\Program Files\\Docker\\Docker\\resources\\bin;${env.PATH}"
       JAVA_HOME = 'C:\\Program Files\\Java\\jdk-21.0.12.1'  // Adjust to your actual JDK path


        SONARQUBE_SERVER = 'SonarQube'
        SONAR_TOKEN = credentials('sonarqube_token') //make sure a right token is selected
        DOCKERHUB_CREDENTIALS_ID = 'Docker_username_password'
        DOCKERHUB_REPO = 'olenape/bmi_3013_olena'
        DOCKER_IMAGE_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/petrova-olena/OTP2_BMI'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
// Check the SonarQube analysis stage for the correct project key and name
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv("${env.SONARQUBE_SERVER}") {
                    sh """
                        sonar-scanner ^
                        -Dsonar.projectKey=OTP2_BMI ^
                        -Dsonar.sources=src ^
                        -Dsonar.projectName=OTP2_BMI ^
                        -Dsonar.host.url=http://localhost:9000 ^
                        -Dsonar.login=${env.SONAR_TOKEN} ^
                        -Dsonar.java.binaries=target/classes
                    """
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    def app = docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                    env.BUILT_IMAGE = app.id  // Optional: store image ID for reuse
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                       docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                    }
                }
            }
        }
    }


}
