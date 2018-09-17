# instagram_oAuth
Simple application to demonstrate how to use oAuth with an application using instagram.

For creating the account please refer my blog.

Steps to run the project.

Clone repository to your machine.
Add your client id and client secret to application.properties (instagram_oAuth -> src -> main -> resources)
Go to instagram_oAuth folder. open command prompt and type "mvn clean package" and wait untill build complete.
Type "java -jar target\instagram_oAuth-0.0.1-SNAPSHOT -Dserver.port=8080" to run the project.(If "java.net.BindException: Address already in use: bind" Exception occured change server port.)
Open browser and navigate to "http://localhost:8080/" .
