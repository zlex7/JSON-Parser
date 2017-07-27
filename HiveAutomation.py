import subprocess
import json

user="aw22398"


open('cases.json', 'w+').close()

pretty = open('pretty_cases.json','w+')

subprocess.call("C:/Users/AW22398/Desktop/JSON-Parser/getHiveCases.sh",shell=True)


file = open('cases.json','r')

data = json.load(file)

print(data)


"""
hive_login = "10.0.20.57:9000/api/login?user="+user+"&password="+password

hive_general = "thehive.cyber.dps:9000/api"

hive_cases = "10.0.20.57:9000/api/case"

get=requests.get(hive_cases)

print(get.content)

session = requests.session()

#post = session.post(hive_login)

#print("did post go through? : " + post.ok)

#print("post content: " + post.content)


get = session.get(hive_cases)

print("get content: " + get.content)

"""
