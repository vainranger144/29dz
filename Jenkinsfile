pipeline {
  agent any
  tools {
    jdk 'jdk21'
    maven 'Maven'
  }
  stages {
    stage('Checkout') {
      steps {
        git url: 'https://github.com/vainranger144/29dz.git', branch: 'master'
      }
    }
    stage('Build') {
      steps {
        sh 'mvn clean install'
      }
    }
    stage('Run') {
      steps {
        // пример запуска, если у вас jar
        sh 'java -jar target/your-app.jar'
      }
    }
  }
  post {
    success {
      archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
    }
    failure {
      mail to: 'dev-team@example.com',
           subject: "Сборка упала: ${currentBuild.fullDisplayName}",
           body: "Ссылка: ${env.BUILD_URL}"
    }
  }
}
