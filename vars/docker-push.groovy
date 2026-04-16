def call(String Project, String ImageTag, String DockerHubUser){
  withCredentials([usernamePassword(
                    'credentialsId':"docHubCred",
                    passwordVariable:"DocHubPass",
                    usernameVariable:"DocHubUser")]){
                sh "docker login -u ${DocHubUser} -p ${DocHubPass}"
  }
                sh "docker push ${DocHubUser}/${Project}:${ImageTag}"
}
