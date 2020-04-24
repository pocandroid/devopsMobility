node {
    try{
    stage('checkout'){
         checkout([$class: 'GitSCM', branches: [[name: '*/developer']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/pocandroid/devopsMobility.git']]])
	    }
    stage('Build'){
        withGradle{
            sh "chmod +x gradlew"
            sh "./gradlew clean assembleRelease"
        }
	 }
    stage('Archeive artifacts'){
	    archiveArtifacts artifacts: '**/*.apk', followSymlinks: false
	}
    stage('Nexus Repository'){
	    nexusArtifactUploader artifacts: [[artifactId: 'devops-mobility', classifier: '', file: 'app/build/outputs/apk/release/devops-mobility.apk', type: 'apk']], credentialsId: 'bcebae3d-4df0-4fb2-8ca4-6ee8af37cabb', groupId: 'com.android.devops', nexusUrl: 'localhost:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'devopsmobility', version: '1.0'
	}
    stage('App Center'){
	    appCenter apiToken: '6d4fa0a281c66babc047745a202a53076dc5ef01', appName: 'pocapp', distributionGroups: 'pocAndroid', notifyTesters: false, ownerName: 'pocandroid', pathToApp: 'app/build/outputs/apk/release/devops-mobility.apk', pathToDebugSymbols: '', pathToReleaseNotes: '', releaseNotes: 'devops-mobility apk stored in appCenter'
	}	
	emailext body: 'Build Success and APK file is generated successfully.', subject: 'Build Status', to: 'sivarajac1986@gmail.com', 'cjaiganesh@gmail.com'
    }catch(error){
      emailext body: "${error}", subject: "Build Failure-${currentBuild.fullDisplayName}", to: 'sivarajac1986@gmail.com' 
    }
 }
