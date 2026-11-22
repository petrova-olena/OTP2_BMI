pipeline {
agent any
tools {
maven 'Maven_config'   // Must match the name configured in Jenkins Global Tool Configuration
}
 environment {
            SONARQUBE_SERVER = 'SonarQube'
            DOCKERHUB_CREDENTIALS_ID = 'Docker_username_password'
            DOCKERHUB_REPO = 'olenape/bmi_test_3013'
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

        stage('SonarQube Analysis') {
            steps {
                script {
                    def scannerHome = tool 'SonarScanner'

                    withCredentials([string(credentialsId: 'sonarqube_token', variable: 'SONAR_TOKEN')]) {

                        sh """
                        ${scannerHome}/bin/sonar-scanner \
                        -Dsonar.host.url=http://host.docker.internal:9000 \
                        -Dsonar.projectKey=BMI_Cal \
                        -Dsonar.sources=src/main/java \
                        -Dsonar.tests=src/test/java \
                        -Dsonar.projectName=BMI_Cal \
                        -Dsonar.token=\$SONAR_TOKEN \
                        -Dsonar.java.binaries=target/classes \
                        -Dsonar.cpd.exclusions=src/test/** \
                        -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml \
                        -Dsonar.coverage.exclusions=**/BMIController.java,**/HelloApplication.java,**/LocalizationService.java,**/BMIResultService.java
                        """
                    }
                }
            }
        }

        stage('Check Dockerfile') {
            steps {
                sh 'ls -la'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                    // Or specify Dockerfile path explicitly if needed
                    // docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}", "-f ./Dockerfile .")
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