#!/bin/bash
#testing whether Hive API works

USER="aw22398"
set +o noclobber
read -s -p "Password: " password
curl -u "$USER:$password" 10.0.20.57:9000/api/case > cases.json
java JSONMain cases.json