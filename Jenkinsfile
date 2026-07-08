pipeline {

    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven 3.9'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/SanjayVerma83/AutomationFramework.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test --no-transfer-progress'
            }
        }
    }

    post {

        always {

            // Publish TestNG Results
            junit 'target/surefire-reports/*.xml'

            // Publish Allure Report
            allure results: [[path: 'allure-results']]

            // Publish Extent Report
            publishHTML([
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'Reports',
                reportFiles: 'AutomationReport.html',
                reportName: 'Automation Execution Report'
            ])

            // Archive Extent Report
            archiveArtifacts artifacts: 'Reports/*.html', fingerprint: true
        }

        success {
            emailext(
                subject: "SUCCESS : ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
Hello,

Automation execution completed successfully.

Build Status : SUCCESS
Job Name     : ${env.JOB_NAME}
Build Number : ${env.BUILD_NUMBER}

Please check the HTML Report in Jenkins for detailed execution results.

Thanks,
Jenkins
""",
                to: 'shalu.thakur15@gmail.com'
            )
        }

        failure {
            emailext(
                subject: "FAILED : ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
Hello,

Automation execution failed.

Build Status : FAILED
Job Name     : ${env.JOB_NAME}
Build Number : ${env.BUILD_NUMBER}

Please check the Jenkins Console Output and HTML Report for failure details.

Thanks,
Jenkins
""",
                to: 'shalu.thakur15@gmail.com'
            )
        }
    }
}