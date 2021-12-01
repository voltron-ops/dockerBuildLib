def call(Map config = [:]){
    def dockerImage = docker.build("${config.repo}:${env.BUILD_ID}", '.')
    docker.withRegistry('', "${config.dockerCred}"){
        dockerImage.push()
    }
    sh "docker rmi ${config.repo}:${env.BUILD_ID}"
    // sh "docker rmi ${config.registry}/${config.repo}:${env.BUILD_ID}"
}