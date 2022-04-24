#! /usr/bin/env node
# create the SpringApp-0.0.1-SNAPSHOT.jar file
mvn package
cd src/frontend
# install node modules
npm install
