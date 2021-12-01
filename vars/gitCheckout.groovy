def call(Map config = [:]){
    sh checkout([$class: "GitSCM",
                 branches: [[name: "*/${config.branch}"]],
                 extensions: [],
                 userRemoteConfigs: [[url: "${config.gitrepo}"]]])
}