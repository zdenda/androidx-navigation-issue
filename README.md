# Example app for Jetpack (androidx) Navigation issue

https://issuetracker.google.com/issues/263870890

Steps to reproduce the issue:

1. Launch the app (Navigation Issue Example App)

2. Allow Notifications permission (if you are asked for it)

3. Click on "Create Notification" button
- a new notification from the app should be created (with text "Click on Me!")

4. Open android notification drawer and click on the notification
- the app should be re-launched, but this time on "Dashboard" screen

5. In a bottom navigation bar click on "Home"
- !!! it stays on the "Dashboard" screen
