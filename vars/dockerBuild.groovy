def call(String dockerHubUsername, String imageName) {
    sh "docker build --build-arg REACT_APP_RAPID_API_KEY=2bbbd11fa5mshd9d9dd5bcb90345p1a2bcajsnec59f4c2374c -t ${imageName} ."
    sh "docker tag ${imageName} ${dockerHubUsername}/${imageName}:latest"
    withDockerRegistry([url: 'https://index.docker.io/v1/', credentialsId: 'docker']) {
        sh "docker push ${dockerHubUsername}/${imageName}:latest"
    }
}