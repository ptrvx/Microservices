pipeline {
	agent any
	environment {
		DOCKER_IMAGE_NAME = "social:latest"
	}
	stages {
		stage('Checkout') {
			steps {
				git 'https://github.com/ptrvx/microservices'
			}
		}
		stage('Docker') {
			when {
				branch 'testDeploy'
			}
			steps {
				script {
					sh '''
						docker image build -t ${DOCKER_IMAGE_NAME}
					'''
				}
			}
		}
		stage('Deploy') {
			when {
				branch 'testDeploy'
			}
			steps {
				script {
					sh '''
						docker run -d --name social -p 8090:8081 ${DOCKER_IMAGE_NAME}
					'''
				}
			}

		}
	}
}
