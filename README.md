# medipoke-v1 ![MEDIPOKE](https://github.com/intern4life/medipoke-v1/assets/168071156/7018ea06-df69-402c-a6c8-f1b8b336bbae)

#### Contents:
- [Analysis](#analysis)
  - [Scenario](#scenario)
  - [User Stories](#user-stories)
  - [Use Case](#use-case)
- [Design](#design)
  - [Prototype Design](#prototype-design)
  - [Domain Design](#domain-design)
  - [Business Logic](#business-logic)
- [Implementation](#implementation)
  - [Backend Technology](#backend-technology)
  - [Frontend Technology](#frontend-technology)
- [Project Management](#project-management)
  - [Roles](#roles)
  - [Milestones](#milestones)

## Analysis
### Scenario
MediPoke is an app that serves as a connecting link between patients and doctors. It enables doctors to monitor which patients have been reminded to take their medication. Essentially, MediPoke is a monitoring application designed for doctors and administrators (Health care providers). This centralized platform can help accelerate patient recovery time, identify trends, optimize the medication management processes and improve resource allocation.

### User Stories
1. As a public user (unauthenticated), I want to view all medications, so that I can see what is available in the Medipoke database.
2. As an admin (medical practitioner), I want to view/create/update/delete users (patients) via http request methods.
3. As an admin (medical practitioner), I want to view/create/delete all medications in the database so that available options can be managed.
4. As an admin (medical practitioner), I want to view/create/delete a medication reminder for a selected user.

### Use Case
![image](https://github.com/intern4life/medipoke-v1/assets/161694544/6ee6c063-c28b-44ec-a57b-855a8dcf2d2d)
![image](https://github.com/intern4life/medipoke-v1/assets/161694544/675f1f17-b653-4f9d-8880-a2eefa746eff)
![image](https://github.com/intern4life/medipoke-v1/assets/161694544/ad7c58f6-3c25-4810-8283-3cbcda5a1b49)
![image](https://github.com/intern4life/medipoke-v1/assets/161694544/d7188315-39fb-4e3b-a33a-a91baeb23a01)
![image](https://github.com/intern4life/medipoke-v1/assets/161694544/d19d2cba-1450-403b-9306-49a0385464d1)
![image](https://github.com/intern4life/medipoke-v1/assets/161694544/67ea5c7b-5afe-41b7-a19f-ec9e443963b0)



## Design
The design aims for intuitiveness and ease-of-use, so that every user can quickly understand where to find the information they are looking for. The color scheme is adquate for a health care environment, the different shades of blue are calming/soothing and convey trustworthyness.

### Prototype
![Wireframe_MediPoke_Welcome Screen](https://github.com/intern4life/medipoke-v1/assets/168071156/d9519d01-d1f4-42e0-a818-0d49d4364bfe)


### Domain Design
![image](https://github.com/intern4life/medipoke-v1/assets/161694544/16cc7bb5-86db-49f9-9175-2b5065a5b235)


### Business Logic
"Duplicate user creation" - The Medipoke API refuses the creation of users that already exist in the database. This is done by verifying the uniqueness of the new data entry and the exisitng email & phone number for exisitng users in the database. 
The reason that this verification happens on the email and phone number is because these must be unique. Multiple users could have the same names, but their contact details must be unique.

Method addUser() in the file UserService.java
```
public User addUser(User user) throws Exception {
        if (user.getFirstName() != null) {
            if (userRepository.findByEmail(user.getEmail()) == null || userRepository.findByPhoneNumber(user.getPhoneNumber()) == null)
                return userRepository.save(user);
            throw new Exception("User " + user.getFirstName() + " " + user.getLastName() + " with the birthdate " + user.getDateOfBirth() + " already exists");
        }
        throw new Exception("Invalid user entry");
    }
```


## Implementation
### Backend Technology
This Web application is relying on Spring Boot and the following dependencies:

    Spring Boot
    Spring Data
    Java Persistence API (JPA)
    H2 Database Engine

Then, the following further dependencies have been added to the project pom.xml:

    DB:

<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
</dependency>

    SWAGGER:

   <dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
      <version>2.3.0</version>
   </dependency>

### Frontend Technology

As mentioned before, for building the frontend we used Budibase as required. The picture below shows the home screen for the user "patient" of MediPoke.

![image](https://github.com/intern4life/medipoke-v1/assets/161694712/3d549c88-d1e8-43ed-aade-533ff795541b)

List of the different screens with the used Queries:

1. Login: GET Login test - if a patient already has an account they can log in and will be taken to the "Home Screen". If they don't have an account, they can click on the "Sign up" button and will be taken to the "New User" screen. The admin has to click on the "Admin Login" button, where they will be taken to the "Admin Login" screen.
2. New User: POST Create New User with Bindings - the patient has to fill in all the required information and click on the "Add" button, they will be taken to the "Home Screen".
3. Home Screen: The patient can navigate using the navigation pannel or the tiles.
4. Medication Overview: GET Medications - the patient has an overview of all medications in the MediPoke database.
6. Admin Home Screen: The admin can navigate using the navigation pannel or the tiles and will be taken to the respective screens, or they can log out.
7. Admin Patient Overview: GET medipoke-v1-latest_onrender_com users - admin sees the table where all patients and their information are listed. If they click on a patient (row) a side pannel will appear and there patient information can be deleted or updated (PUT Update Single User, DEL User).
8. Admin Medication Overview: GET/DEL Medications & POST Create Medication with Bindings, the admin has a table with all medications and they can add new medication and using the side pannel also delete medication entries.
9. Admin Reminders Overview: GET Reminders, the admin gets a list with all reminders (with timestamp).
10. Contact Us: Contains MediPoke contact details.

One of MediPoke's main features is that the administrator can easily access the Patient Database's entries. Through the "AdminPatientOverview" screen, the administrator can get an overview of all the patients listed in the database. Additionally, the administrator can easily add new patients to the database using the new patient form provided on the screen.

![image](https://github.com/intern4life/medipoke-v1/assets/161694712/5cf13508-2cde-4930-9ec3-f7812134d465)


If the administrator is informed that a patient is obsolete in the database, they can select it. When the administrator clicks on the respective row a side panel is automatically opened for the deletion process. The details of the selected patient will be displayed in a new form within the side panel. The administrator can review the patient's information and choose to delete it or cancel the process. When the delete button is clicked, the administrator will receive a notification asking for confirmation to delete the entry. Upon acceptance, the patient entry is deleted, and the table is refreshed.

<img width="916" alt="image" src="https://github.com/intern4life/medipoke-v1/assets/161694712/7be77fc1-423c-4873-b1d3-c85a485746f3">

The "Admin Medication Overview" shows all the medications available in the MediPoke database. As mentioned previously, the admin has the possibility to add to or delete medications from the database. With this screen we want to explain all the "Add" actions on the row click actions. The admin selects a row by clicking on it, the side pannel opens as this is the first click action in actions set. The subsequent actions set entries, 2 to 8, take the value from the "Medication Overview Table" and populates the side panel "Delete Medication Form". Action 9 updates the state of the "Row Id", making it dynamic.
<img width="1166" alt="image" src="https://github.com/intern4life/medipoke-v1/assets/161694712/98b5a597-4fbf-4f01-80fb-7b06738645da">

## Execution
1. Clone this repository to your local machine and open it in your IDE (we used IntelliJ)
2. Alternatively, you can just download our dockerized our app at https://hub.docker.com/r/bruderichhangnueg/medipoke-v1/tags
3. Ensure that your local application's Maven setup is in accordance with this repository's pom.xml file
4. Start the app from the IDE
5. The Medipoke webservice should be running locally at 127.0.0.1 on the port 8080
6. Open your prefered browser and navigate to [http:](localhost:8080/swagger-ui.html)
7. Perform any of the listed API requests either via cURL or Postman. We have hardcoded two users - adminboy:1234 and simpleboy:123

### Deployment to a PaaS
As suggested, Render was used to deploy the webapp API using a dockerized image of our local setup.
Below find the link to the Docker image:
https://hub.docker.com/r/bruderichhangnueg/medipoke-v1/tags
and to our application:
https://medipoke-v1-latest.onrender.com

IMPORTANT NOTICE: Render is a VERY slow Paas but it is free. Despite the Medipoke web serivce being published on Render, non-cached requests after a while will take an incredibly long time to load, if they load at all. It is advised, that you run the project locally. Alternatively, you can email either <david.duran@students.fhnw.ch> or <nathalie.meyer@students.fhnw.ch> to restart the render deployment and thereby accelerate API requests for a short while.

<img width="1146" alt="Screenshot 2024-03-05 at 13 33 59" src="https://github.com/intern4life/medipoke-v1/assets/161823256/48d0c9eb-f157-4086-bade-9c2d4ebfa41c">



## Project Management
### Roles
1. Back-end developer: David Duran
2. Front-end developer: Nathalie Meyer, Naomi Rocha dos Santos
3. Supporting Documentation: David Duran, Naomi Rocha dos Santos, Nathalie Meyer, Amit Jagubhai

### Milestones
1. **Analysis**: Scenario ideation, use case analysis and user story writing.
2. **Prototype Design**: Creation of wireframe and prototype.
3. **Domain Design**: Definition of domain model.
4. **Business Logic and API Design**: Definition of business logic and API.
5. **Data and API Implementation**: Implementation of data access and business logic layers, and API.
6. **Security and Frontend Implementation**: Integration of security framework and frontend realisation.

### Maintainer
David Duran, Nathalie Meyer, Naomi Rocha dos Santos, Amit Jagubhai

#### License
https://www.apache.org/licenses/LICENSE-2.0.html

![image](https://github.com/intern4life/medipoke-v1/assets/161694544/a82bdd1b-0cf2-49c4-a8ed-19cd8c0d7254)




