# Cloud Computing Assignment: Student Registration System

This repository contains the first component of a software application for student registration, which allows students to register their information and required courses. It also provides various statistics related to student registration. The application is designed using containerization concepts and consists of two main components.

## Components

### 1. Student Registration Component

This component repository contains the code for the first component of the student registration system. It provides the following functionalities:

1. **Main Menu**: Displays a menu on the screen with options for user interaction.
   ```
   1- Add student data
   2- Add batch students data
   ```

2. **Add Student Data**: Allows the user to register a single student by providing the following information:
   - Name
   - ID
   - Courses (comma-separated list)

   The user can follow the exact flow mentioned below to add a student with the given data:
   1. Run the component.
   2. The main menu will be displayed. Enter `1`.
   3. Enter the student's data in the following order: `Name`, `ID`, `Courses`. For example:
      ```
      Ahmed
      1
      AI, Math
      ```

3. **Add Batch Students Data**: Enables the user to bulk insert multiple student information from eligible files. The system will display the eligible files (files with the phrase "verified" in their name) located in the `/app/data/batch/` directory. The user can select one file to insert the students' info into the system.

   Technical Details:
   - Mount a specific folder in your operating system to the path `/app/data/batch/` in your Docker container.
   - Eligible files are those that contain the phrase "verified" in their name.

   Follow the exact flow mentioned below to add batch students' data to the system:
   1. Run the component.
   2. The main menu will be displayed. Enter `2`.
   3. The eligible files will be shown. For example:
      ```
      1_verified.csv
      3_verified.csv
      ```
   4. Assuming the user wants to enter the students' data from the `1_verified.csv` file, enter `1_verified.csv`.

For the second component of this student registration system, which provides statistics related to student registration, please refer to the [Second Component Repository](https://github.com/PeterIsaacc/comp-2).

---
*Note: In order to access the second component repository, please visit [https://github.com/PeterIsaacc/comp-2](https://github.com/PeterIsaacc/comp-2).*


### To run Docker-Compose follow these steps:
* Clone comp1 repo (this repo)
* Clone comp2 repo (link: https://github.com/PeterIsaacc/comp-2)
* Put the repos into the same directory
* Run this command: docker-compose up -d
* then this command: docker ps
* then choose id of the required component
* open new terminal and run this command: docker attach 'id'


### To run the DockerFiles alone 
* build the image locally
* run this command: docker run -it --mount type=bind,source=/path/to/Data,target=/app/data/patch {image name}


## PS USE sudo before any command if using linux || winpty before any command if windows

##
