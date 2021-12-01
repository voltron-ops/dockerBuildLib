def call(Map config = [:]){
    checkout([
        $class: 'GitSCM',
        branches: [[name: config.branch ]],
        extensions: [],
        userRemoteConfigs: [[url: config.gitrepo ]]
    ])
}