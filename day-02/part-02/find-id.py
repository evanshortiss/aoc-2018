lines = open('../input.txt').read().split('\n')

for currentLine in lines:
    for num in range(len(lines)):
        compareLine = lines[num]
        if currentLine == compareLine:
            continue
        else:
            differences = []
            for idx, char in enumerate(currentLine):
                if char != compareLine[idx]:
                    differences.append(idx)

            if len(differences) == 1:
                print "String A: " + str(currentLine)
                print "String B: " + str(compareLine)
                print "Result: " + currentLine[:differences[0]] + currentLine[differences[0] + 1:]
                exit(0)
                    
