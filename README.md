 # PARCIAL 1 AREP
## Description

 
  [![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://secret-spire-04197.herokuapp.com/)
 

## User's guide

  This is the guide that will setup this proyect at your local machine in order to be able to run it.
  
  ### Requisites
  
  It is necessary having these tools installed on your computer:
  
  * Maven 
  * Java 
  * Git
 
  ### Setting up
  
1. **Clone this repository:** 

   `git clone https://github.com/JohanS11/Parcial1Arep.git`

2. **Build the project with maven:**
  
    `cd Parcial1Arep && mvn package`

3. **Execute the project with maven:**

     ***Note***
     
     If you want to run this project locally you should change the url from the Client.java class
     to "http://localhost:4567/parcial1"

    `mvn exec:java -Dexec.mainClass="edu.eci.arep.logic.Client" `
    
    now you can see a Post request maded from this client to a Heroku Server
  

   ### Executing tests
   
     In order to run the tests developed with JUnit you have run the follow command:
     
     `mvn test`
   
  ## This project was built with:
  
   - Apache Maven 3.6.3 
   - Java 1.8.0_211
   - Git 2.26.2.
   - Heroku
   
  
  ## Java Documentation
  
  In order to generate javadoc execute `mvn javadoc:javadoc`
  
  ## Author
  
  Johan Sebastian Arias Amador ([JohanS11](https://github.com/JohanS11))
  
  ## License
  
  This project is licensed under the GNU General Public License v3.0 - see the [LICENSE](https://github.com/JohanS11/Parcial1Arep/blob/master/LICENSE) file for more details.

