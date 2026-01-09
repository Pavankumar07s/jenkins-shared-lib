def call(String project, String imageTag, String dockerHubUser) {
    withCredentials([usernamePassword(
        credentialsId: 'docker-hub-cred',
        usernameVariable: 'DOCKER_HUB_USER',
        passwordVariable: 'DOCKER_HUB_PASS'
    )]) {
        sh """
        echo "\$DOCKER_HUB_PASS" | docker login -u "\$DOCKER_HUB_USER" --password-stdin
        docker tag ${project}:${imageTag} ${dockerHubUser}/${project}:${imageTag}
        docker push ${dockerHubUser}/${project}:${imageTag}
        """
    }
}
