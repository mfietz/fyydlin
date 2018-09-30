#!/bin/sh

if [[ ! -f wiremock-standalone-2.19.0.jar ]] ; then
    echo wiremock-standalone-2.19.0.jar does not exist!
    exit
fi

java -jar wiremock-standalone-2.19.0.jar --proxy-all="https://api.fyyd.de/0.2/" --record-mappings --verbose &

sleep 5

curl "http://localhost:8080/search/podcast?title=wrint"
curl "http://localhost:8080/search/podcast?title=wrint&count=5"

kill $!

rm -rf src/test/resources/__files
rm -rf src/test/resources/mappings

mv __files src/test/resources/
mv mappings src/test/resources/
