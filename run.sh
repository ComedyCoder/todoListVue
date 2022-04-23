#! /usr/bin/env node
cd target
java -jar SpringApp-0.0.1-SNAPSHOT.jar &
cd ..
cd src/frontend
npm run serve &
