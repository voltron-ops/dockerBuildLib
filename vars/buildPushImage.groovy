def call(Map config = [:]){
    def dockerImage = docker.build("${config.repo}:${env.BUILD_ID}", '.')
    docker.withRegistry("${config.registry}", "${config.dockerCred}"){
        dockerImage.push()
    }
    sh "docker rmi ${config.registry}:${env.BUILD_ID}"
    sh "docker rmi ${config.registry}/${config.repo}:${env.BUILD_ID}"
}