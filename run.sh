#! /usr/bin/env node
cd target
# run spring boot server on port 8080
java -jar SpringApp-0.0.1-SNAPSHOT.jar &
cd ..
cd src/frontend
# run vue frontend
npm run serve &
