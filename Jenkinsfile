pipeline {
    agent any
    tools {
        maven 'Maven 3.8.3'
        jdk 'jdk11'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building core package'
                checkout scm
                script{
                    bat(/mvn clean/)
//                    bat(/mvn compile/)
//                    bat(/mvn install/)
//                    bat(/mvn package/)
                }
//                script {
//                    bat("""mvn install:install-file \
//                        -Dfile=../hackett-automation-testing/target/AutomationTesting-1.0.0.jar \
//                        -DgroupId=com.hackett \
//                        -DartifactId=AutomationTesting \
//                        -Dversion=1.0.0 \
//                        -Dpackaging=jar \
//                        -DlocalRepositoryPath=C:/Windows/System32/config/systemprofile/AppData/Local/Jenkins/.jenkins/workspace/advisory-automation/target""")
//                }
            }
        }
        stage('Test') {
//            environment {
//                BASE_URL = "${BASE_URL}"
//                DTP_MIRROR = "${DTP_MIRROR}"
//            }
            steps {
                withMaven(maven: 'Maven 3.8.3') {
//                    bat("mvn -DADP_URL=%ADP_URL%")
//                    bat("mvn -DCLIENT=%CLIENT%")
//                    bat("mvn -DPROGRAM_NAME=%PROGRAM_NAME%")
//                    bat("mvn -DDTP_DEV=%DTP_DEV%")
//                    bat("mvn -DDTP_HELP_URL=%DTP_HELP_URL%")
//                    bat("mvn -DDTP_MIRROR=%DTP_MIRROR%")
//                    bat("mvn -DEMAIL=%EMAIL%")
//                    bat("mvn -DPASSWORD=%PASSWORD%")
                    bat("""mvn test -DTest=UiRunner""")
                }
            }
        }
    }
}