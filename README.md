# Build
`mvn clean verify`

# Run
`cd target`  
`java -jar pseudotwitter-1.0.jar`

# Instructions
Once running, enter end-of-file character to exit the application (this will typically be Ctrl+D or Ctrl+Z depending on your OS).

Input is not particularly robust, it is assumed users will enter the right command... if not, the application will probably fail.

Usernames are case-insensitive.

# Notes
Code has been designed so the running class delegates to tested class as much logic as possible.

Since users have to share the same command line to enter commands, high workload is not expected, therefore performance hasn't been taken into account.
