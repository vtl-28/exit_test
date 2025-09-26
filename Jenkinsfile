pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',                  
                    credentialsId: '49e7e9cc-88f7-44ea-abbd-e43f66842192',
                    url: 'https://git-training.nagarro.com/nagarro_fresher_training/automation-manual-qa/vuisile-tlotliso-lehola.git'
            }
        }

        stage('Test Integration') {
            steps {
                echo "✅ Jenkins successfully pulled the repo!"
                sh 'ls -la' // List files to confirm workspace contents
            }
        }
    }
}
