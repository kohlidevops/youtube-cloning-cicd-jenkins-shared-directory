def call() {
    sh 'trivy image latchudevops/youtube:latest > trivyimage.txt'
}