#Variables
PM = False
finalStr = ""
#get the input
a = raw_input("Enter time here:")
#break it into parts
b = a.split(":")

#Figure out if am or pm
if ((b[2])[2:] == "PM"):
    PM = True

#when PM
if (PM):
    first = int(b[0]) + 12
    finalStr = str(first)+ ":" + b[1]+ ":" + (b[2])[:2]
else:
    finalStr = b[0]+ ":" + b[1]+ ":" + (b[2])[:2]

print(finalStr)