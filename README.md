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

Login:
New User:
Home Screen:
My Profile:
My Reminders:
Medication Overview:
Admin Login:
Admin Home Screen:
Admin Patient Overview:
Admin Medication Overview:
Admin Reminders Overview:
Contact Us

One of MediPoke's main features is that the administrator can easily access the Patient Database. Through the "AdminPatientOverview" screen, the administrator can get an overview of all the patients listed in the database. Additionally, the administrator can easily add new patients to the database using the new patient form provided on the screen.

<img width="1165" alt="image" src="https://github.com/intern4life/medipoke-v1/assets/161694712/786b8502-1bfe-4068-b20c-e94b300bce70">

If the administrator is informed that a patient is obsolete in the database, they can select it. When the administrator clicks on the respective row a side panel is automatically opened for the deletion process. The details of the selected patient will be displayed in a new form within the side panel. The administrator can review the patient's information and choose to delete it or cancel the process. When the delete button is clicked, the administrator will receive a notification asking for confirmation to delete the entry. Upon acceptance, the patient entry is deleted, and the table is refreshed.

<img width="916" alt="image" src="https://github.com/intern4life/medipoke-v1/assets/161694712/7be77fc1-423c-4873-b1d3-c85a485746f3">


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






