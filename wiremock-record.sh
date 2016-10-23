#!/bin/sh

if [[ ! -f wiremock-standalone-2.2.2.jar ]] ; then
    echo wiremock-standalone-2.2.2.jar does not exist!
    exit
fi

java -jar wiremock-standalone-2.2.2.jar --proxy-all="https://api.fyyd.de" --record-mappings --verbose

curl "http://localhost:8080/search-pdc/wrint"
curl "http://localhost:8080/search-pdc/wrint/5"
curl "http://localhost:8080/search-pdc/wrint,freakshow"
curl "http://localhost:8080/search-pdc/wrint,freakshow/5"

rm -rf src/test/resources/__files
rm -rf src/test/resources/mappings

mv __files src/test/resources/
mv mappings src/test/resources/
