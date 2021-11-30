def call(MAP config = [:]){
    def dockerImage = docker.build("${config.registry}:${env.BUILD_ID}", '.')
    docker.withRegistry('https://registry.hub.docker.com', ${config.dockerID}){
        dockerImage.push()
    }
    sh "docker rmi ${config.registry}:${env.BUILD_ID}"
}