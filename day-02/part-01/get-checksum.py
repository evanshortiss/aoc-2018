lines = open('../input.txt').read().split('\n')

twos = 0
threes = 0

def getCharCountDictionary (line):
    charmap = {}
    for char in line:
        if char in charmap:
            charmap[char] = charmap[char] + 1
        else:
            charmap[char] = 1
    
    return charmap

for line in lines:
    charCountsDictionary = getCharCountDictionary(line)
    hasTwos = False
    hasThrees = False

    for char in charCountsDictionary:
        if charCountsDictionary[char] == 2:
            hasTwos = True
        elif charCountsDictionary[char] == 3:
            hasThrees = True
        if hasTwos & hasThrees:
            break
    
    if hasTwos:
        twos += 1
    if hasThrees:
        threes += 1

print('twos detected:' + str(twos))
print('threes detected:' + str(threes))
print('checksum is (twos * threes): ' + str(twos * threes))