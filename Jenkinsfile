pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Check out the source code from your version control system (e.g., Git)
                git 'https://github.com/TrishantMaharjan/Jenkins_Demo.git'
            }
        }

        stage('Build') {
            steps {
                // Build the Java project using Apache Maven
                // Make sure you have Maven installed on your Jenkins agent
                sh 'mvn clean package'
            }
        }
      
    }

    post {
        always {
            // Clean up after the build, regardless of success or failure
            deleteDir()
        }

        success {
            // Actions to perform when the build is successful
            echo 'Build successful!'
        }

        failure {
            // Actions to perform when the build fails
            echo 'Build failed!'
        }
    }
}
