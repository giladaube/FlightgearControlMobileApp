# FlightGear-Control Android App
FlightGear-Control is Android app, developed with Kotlin.

## About the project
The app was built as an academic assigment. The application provides a way to flight a plane displayed by FlightGear simulator.
Using a custom joystick, is is possible to control and fly the plane from the mobile app.
***

## Let's get ready
In order to run this app on your computer, please follow the following steps:
1. Make sure you have Kotlin SDK and also an IDE to run the app from (I recommend using [Android Studio](https://developer.android.com/studio), Kotlin SDK is built-in).
2. Download and install [FlightGear simulator](https://www.flightgear.org/download/).
3. Git clone- you'll need to get a local copy of this project.
```bash
git clone https://github.com/giladaube/FlightgearControlApp.git
```
4. Open FlighGear app:
  * Under "Settings" section, look for "Additional Settings".
  * Copy&paste the following (into the text box):
    ```bash
    --telnet=socket,in,10,127.0.0.1,6400,tcp
    ```
  * Click on the "Fly!" button.
6. Run the FlightgearControlApp (from your IDE).
7. 
