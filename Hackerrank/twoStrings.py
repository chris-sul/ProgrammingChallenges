testCases = int(raw_input())
temp = testCases
words = []
while temp > 0:
    words.append(raw_input())
    words.append(raw_input())
    temp -= 1
#this will give us a counter for each object in the array
temp = len(words)
while temp > 0:
    #go through each word and check for it in the other word, need to increment two each time
    # need to fix the problem of having this loop not ho through each word in the array
    i = 0
    while i < (len(words[i]) + 1):
        #loop through each letter in the word
        for letter in words[i]:
            for letters in words[i + 1]:
                if (letter == letters):
                    print("YES")
                    break
        i += 2
    print("NO")
    temp -= 1