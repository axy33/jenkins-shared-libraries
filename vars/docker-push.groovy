def call(String Project, String ImageTag, String DockerHubUser){
  withCredentials([usernamePassword(
                    'credentialsId':"docHubCred",
                    passwordVariable:"DocHubPass",
                    usernameVariable:"DocHubUser")]){
                sh "docker login -u ${env.DocHubUser} -p ${env.DocHubPass}"
  }
                sh "docker push ${env.DocHubUser}/${Project}:${ImageTag}"
}
