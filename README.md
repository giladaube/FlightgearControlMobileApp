# FlightGear-Control Android App
FlightGear-Control is Android app, developed with Kotlin.

## About the project
The app was built as an academic assignment. The application provides a way to fly a plane displayed by the FlightGear simulator. By using a custom joystick, it is possible to control and fly the plane from the mobile app.

## Let's get ready
To run this app on your computer, please follow the following steps:
### Installation
1. Make sure you have Kotlin SDK and also an IDE to run the app from (I recommend using [Android Studio](https://developer.android.com/studio), Kotlin SDK is built-in).
2. Download and install [FlightGear simulator](https://www.flightgear.org/download/).
3. Git clone- you'll need to get a local copy of this project
```bash
git clone https://github.com/giladaube/FlightgearControlApp.git
```
### Usage
1. Open FlighGear app:
   1. Under "Settings" section, look for "Additional Settings"
   2. Copy&paste the following (into the text box): 
    > --telnet=socket,in,10,127.0.0.1,6400,tcp
   4. Click on the "Fly!" button
2. Run the FlightgearControlApp (from your IDE).
   1. Connect to the simulator on port 6400.
3. Enjoy!

## Design
This project built using two main design patterns:
1. MVVM - divide between the UI and Logic.
2. Pool Thread - during run-time all assignments are executed by one thread.  

## Class Diagram
![image](https://user-images.githubusercontent.com/39123326/123260772-a3cf8500-d4fe-11eb-8c53-3753ecd45359.png)

## DEMO and Screenshot
### [Presentation and DEMO](https://github.com/giladaube/FlightgearControlApp/blob/0fe1fb08f4841c2c7e71e19c718cfec49eb43b32/FlightGear%20Joystick%20-DEMO.mp4)

### Screenshot
![image](https://user-images.githubusercontent.com/39123326/123268895-21978e80-d507-11eb-8c0a-08cee6bf212a.png)


