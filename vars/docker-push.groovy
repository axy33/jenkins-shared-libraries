def call(String Project, String ImageTag, String DocHubUser){
  withCredentials([usernamePassword(
                    'credentialsId':"docHubCred",
                    passwordVariable:"DocPass",
                    usernameVariable:"DocUser")]){
                sh "docker login -u ${DocUser} -p ${DocPass}"
                sh "docker push ${DocUser}/${Project}:${ImageTag}"
  }
}
