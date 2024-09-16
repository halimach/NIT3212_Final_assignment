# NIT3212 Final Assignment

## Overview

The NIT3212 Final Assignment is a mobile application designed to manage and display sports-related data. 
Users can log in to the app, view a dashboard listing various sports entities, and view detailed information about each entity. 
The application leverages Retrofit for network operations and Moshi for JSON parsing.

## Prerequisites

Before you start, ensure you have the following installed:

1. Android Studio: The official IDE for Android development.
2. Java Development Kit (JDK): Required for Android development.
3. Gradle: Build automation tool (usually bundled with Android Studio).
4. Internet Access: For downloading dependencies and running the application.

## Project Setup

1. Clone the Repository

   Open a terminal and run:
   ```sh
   git clone https://github.com/your-repository-url.git
2. Open the Project
- Launch Android Studio.
- Select "Open an existing project".
- Navigate to the cloned repository and open it.

3. Sync Project
- Android Studio should prompt you to sync the project with Gradle files. Click "Sync Now" to download the necessary dependencies.

4. Build and Run
- Connect an Android device or start an emulator. 
- Click the "Run" button (green play icon) in Android Studio to build and run the application.

## API Details 
1. Login Endpoint 
    URL: https://vu-nit3213-api.onrender.com/ort/auth
    Method: POST
    Request Body:
   {
    "Halima"
    "s4619972"
       }
     Response: LoginResponse containing a keypass string used for authentication.

2. Dashboard Data Endpoint
    URL: https://vu-nit3213-api.onrender.com/dashboard/{keypass}
    Method: GET
    Response: Dashboard_Output containing a list of Entity objects and the total number of entities.

## Activity Screens 
**Login Screen :** 
The login screen allows users to enter their credentials to access the application.
Fields:
- Username: Input field for the username.
- Password: Input field for the password.
Button:
- Login Button: Initiates the login process.
Upon successful login, the application retrieves a keypass and redirects the user to the dashboard screen. 
If login fails, an error message is displayed.

**Dashboard Screen**
The dashboard screen displays a list of sports entities retrieved from the API.

RecyclerView: Displays the list of entities.
- Each item shows basic information such as sport name, player count, field type, and whether it’s an Olympic sport.

Item Click: Clicking on an item navigates to the entity details screen.

## Application Run 
1. Ensure Prerequisites: Verify that you have Android Studio, JDK, and an emulator or physical device ready.
2. Open Project: Open the project in Android Studio by navigating to the cloned repository.
3. Build the Project:
- Click "Build" > "Rebuild Project" to ensure all dependencies are resolved.
4. Run the Application:
- Connect an Android device or start an emulator.
- Click the "Run" button (green play icon) in Android Studio.
5. Test Functionality:
- Use valid credentials to log in.
- Verify that you can view the dashboard and navigate to entity details.


