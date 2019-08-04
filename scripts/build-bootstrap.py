import json
import glob
import os
import ntpath
import hashlib
import re
from shutil import copyfile

jar_folder = '../runelite-client/target/'
json_folder = '../../mutorials.github.io/'
json_file = json_folder + 'bootstrap.json'
url = 'https://github.com/Mutorials/mutorials.github.io/raw/master/'

list_of_files = glob.glob(jar_folder + '*-shaded.jar')
latest_file = max(list_of_files, key=os.path.getctime)

BUF_SIZE = 65536
sha256 = hashlib.sha256()
with open(latest_file, 'rb') as lf:
    while True:
        data = lf.read(BUF_SIZE)
        if not data:
            break
        sha256.update(data)

data = None
with open(json_file, 'r') as jf:
    data = json.load(jf)

art = data['artifacts'][0]

name = ntpath.basename(latest_file)
size = os.stat(latest_file).st_size
hash = sha256.hexdigest()

art['hash'] = hash
art['name'] = name
art['path'] = url + name
art['size'] = size

data['artifacts'][0] = art


client = data['client']

p = re.compile('client-(([0-9]+\.)+[0-9]+)-')
m = p.match(name)
version = m.group(1)
client['version'] = version 

data['client'] = client


copyfile(latest_file, json_folder + name)

os.remove(json_file)
with open(json_file, 'w') as f:
    json.dump(data, f, indent=4)