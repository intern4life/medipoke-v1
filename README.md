# medipoke-v1 ![MEDIPOKE](https://github.com/intern4life/medipoke-v1/assets/168071156/7018ea06-df69-402c-a6c8-f1b8b336bbae)

MediPoke is a user-friendly application platform designed to help individuals manage their medication schedules effectively. Developed as a group project for the Internet Technology course at FHNW, MediPoke delivers personalised reminders to ensure users never miss a dose.
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
"MediPoke" is a web application designed to help users to manage their medication schedules effectively. The application allows users to receive reminders when it's time to take their medication. Administrators set the desired reminder for the particular user and can manage the medication database, ensuring all medications are up to date and consumed on time.

### User Stories
1. As a user, I want to view all my medications so that I can see what I need to take and when.
2. As a user, I want to view my reminders so that I can see my upcoming medication schedule.
3. As an admin, I want to create/update/delete new/existing users
4. As an admin, I want to view all medications in the database so that I can manage the available options.
5. As an admin, I want to set notification to a selected user for a medication in the database so that the user receives notification on the assigned time.

### Use Case

## Design

### Prototype
![Wireframe_MediPoke_Welcome Screen](https://github.com/intern4life/medipoke-v1/assets/168071156/d9519d01-d1f4-42e0-a818-0d49d4364bfe)


### Domain Design

### Business Logic

## Implementation
### Backend Technology

### Frontend Technology

As mentioned before, for building the frontend we used as demanded budibase. The picture below shows the home screen for the user "patient" of MediPoke.

![image](https://github.com/intern4life/medipoke-v1/assets/161694712/40967538-0028-4280-bc43-e4f44d907404)


List of the different screens with the used Queries:

1. Login: GET Login test - if a patient already has an account they can log in and will be taken to the "Home Screen". If they don't have an account, they can click on the "Sign up" button and will be taken to the "New User" screen. The admin has to click on the "Admin Login" button, where they will be taken to the "Admin Login" screen.
2. New User: POST Create New User with Bindings - the patient has to fill in all the required information and click on the "Add" button, they will be taken to the "Home Screen".
3. Home Screen: The patient can navigate using the navigation pannel or the tiles.
4. Medication Overview: GET Medications - the patient has an overview of all medications in the MediPoke database.
5. Admin Login: GET Admin Login test - the admin has to enter his credentials and will be taken to the "Admin Home Screen".
6. Admin Home Screen: The admin can navigate using the navigation pannel or the tiles and will be taken to the respective screens, or they can log out.
7. Admin Patient Overview: GET medipoke-v1-latest_onrender_com users - admin sees the table where all patients and their information are listed. If they click on a patient (row) a side pannel will appear and there patient information can be deleted or updated (PUT Update Single User, DEL User).
8. Admin Medication Overview: GET/DEL Medications & POST Create Medication with Bindings, the admin has a table with all medications and they can add new medication and using the side pannel also delete medication entries.
9. Admin Reminders Overview: GET Reminders, the admin gets a list with all reminders (with timestamp).
10. Contact Us: Contains MediPoke contact details.

One of MediPoke's main features is that the administrator can easily access the Patient Database. Through the "AdminPatientOverview" screen, the administrator can get an overview of all the patients listed in the database. Additionally, the administrator can easily add new patients to the database using the new patient form provided on the screen.

<img width="1165" alt="image" src="https://github.com/intern4life/medipoke-v1/assets/161694712/786b8502-1bfe-4068-b20c-e94b300bce70">

If the administrator is informed that a patient is obsolete in the database, they can select it. When the administrator clicks on the respective row a side panel is automatically opened for the deletion process. The details of the selected patient will be displayed in a new form within the side panel. The administrator can review the patient's information and choose to delete it or cancel the process. When the delete button is clicked, the administrator will receive a notification asking for confirmation to delete the entry. Upon acceptance, the patient entry is deleted, and the table is refreshed.

<img width="916" alt="image" src="https://github.com/intern4life/medipoke-v1/assets/161694712/7be77fc1-423c-4873-b1d3-c85a485746f3">

The "Admin Medication Overview" shows all the medications available in the MediPoke database. As mentioned previously, the admin has the possibility to add to or delete medications from the database. With this screen we want to explain all the "Add" actions on the row click actions. The admin selects a row by clicking on it, the side pannel opens as this is the first click action in actions set. The subsequent actions set entries, 2 to 8, take the value from the "Medication Overview Table" and populates the side panel "Delete Medication Form". Action 9 updates the state of the "Row Id", making it dynamic.
<img width="1166" alt="image" src="https://github.com/intern4life/medipoke-v1/assets/161694712/98b5a597-4fbf-4f01-80fb-7b06738645da">

## Execution

### Deployment to a PaaS

## Project Management

### Roles

### Milestones
1. **Analysis**: Scenario ideation, use case analysis and user story writing.
2. **Prototype Design**: Creation of wireframe and prototype.
3. **Domain Design**: Definition of domain model.
4. **Business Logic and API Design**: Definition of business logic and API.
5. **Data and API Implementation**: Implementation of data access and business logic layers, and API.
6. **Security and Frontend Implementation**: Integration of security framework and frontend realisation.
7. (optional) **Deployment**: Deployment of Web application on cloud infrastructure.

#### License






