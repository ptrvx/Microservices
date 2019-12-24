pipeline {
	agent any
	environment {
		DOCKER_IMAGE_NAME = "Zuul:latest"
	}
	stages {
		stage('Checkout') {
			steps {
				git 'https://github.com/ptrvx/microservices'
			}
		}
		stage('Docker') {
			when {
				branch 'demo'
			}
			steps {
				script {
					sh '''
						docker image build -t Zuul:latest
					'''
				}
			}
		}
	}
}
