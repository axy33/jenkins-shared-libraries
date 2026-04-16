def call(String Project, String ImageTag, String DockerHubUser){
  withCredentials([usernamePassword(
                    'credentialsId':"docHubCred",
                    passwordVariable:"DocHubPass",
                    usernameVariable:"DocHubUser")]){
                sh "docker login -u ${env.DocHubUser} -p ${env.DocHubPass}"
                sh "docker image tag expense-tracker-app:latest ${env.DocHubUser}/expense-tracker-app:latest"
                sh "docker push ${env.DocHubUser}/expense-tracker-app:latest"
                }
}
