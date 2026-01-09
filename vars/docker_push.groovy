def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'docker-hub-cred', passwordVariable: 'DOCKER_HUB_PASS', usernameVariable: 'DOCKER_HUB_USER')]) {
      sh "docker login -u ${DOCKER_HUB_USER} -p ${DOCKER_HUB_PASS}"
  }
  sh "docker push ${DOCKER_HUB_USER}/${Project}:${ImageTag}"
}
