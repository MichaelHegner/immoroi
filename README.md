# Immobilien Kalkulations Programm (ImmoRoi)
Dieses Programm soll Immobilieninteressierte Personen helfen, die Rendite einer Immobilie zu errechnen. 
Dabei soll die Applikation einfach gehalten und für jeden verständlich und nutzbar sein.


## Für Entwickler
Es handelt sich hierbei um eine Spring-Boot Applikation.

### Eclipse einrichten
#### Heroku Deployment
First you need to configure a Maven Task to deploy this application to Heroku. To configure the HEROKU_API_KEY
, you can execute the command '> heroku auth:token' to get the token. 

Then Create a new Maven Run Configuration, go to Environment and add a new Environment Variable
HEROKU_API_KEY : Token Key

The Maven Goal you configure heroku:deploy

You need to have Heroku Plugin in your project.

<plugin>
	<groupId>com.heroku.sdk</groupId>
	<artifactId>heroku-maven-plugin</artifactId>
	<version>1.1.3</version>
</plugin>

To start your application you need to run 
heroku ps:scale web=1

Source: https://devcenter.heroku.com/articles/deploying-java-applications-with-the-heroku-maven-plugin
 
 
## Für Tester



## Deploy and Start in Heroku
 