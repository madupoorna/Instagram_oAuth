# instagram_oAuth
Simple application to demonstrate how to use oAuth with an application using instagram.

For creating the account please refer my blog (https://trchworld.blogspot.com/2018/09/retrieve-instagram-profile-information.html).

Steps to run the project.

1.	Clone repository to your machine.
2.	Add your client id and client secret to application.properties (instagram_oAuth -> src -> main -> resources)
3.	Go to instagram_oAuth folder. open command prompt and type "mvn clean package" and wait until build complete.
4.	Type "java -jar target\instagram_oAuth-0.0.1-SNAPSHOT -Dserver.port=8080" to run the project.(If "java.net.BindException: Address already in use: bind" Exception occurred change server port.)
5.	Open browser and navigate to "http://localhost:8080/" .
