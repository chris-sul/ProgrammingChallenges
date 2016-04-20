from Processing import *
from random import *
#pic = makePicture("")
window(1300,800)
frameRate(60)
background(255,255,255)
flyList = []
frogList = []
#hitFrog = [xfrog,yfrog,fheight,fwidth]
#hitFly = [[fly1], [fly2], [fly3], [fly4], [fly5], [fly6]]
Invaderz = [1,1,1,1,1,1]


#make the list of flies with thier coordinates
for i in range(1,7):
    flyList.append([(i*200),50,40])

print("Here is the list of flies, :",flyList)

def printFlies():
    #make space invaders at the top of the screen
    stroke(255,128,128)
    fill(0,0,0)
    textFont( "courier new" )
    text("SWAMP INVADERS",500,50)
    for k in flyList:
        fill(255,255,255)
        rect(k[0] - 100,k[1],k[2],k[2])
        

change = 5
counter1 = 100
counter2 = 50  
sx = 600
sy = 600
ybull = 600
b = 640
sb = 600


def draw():
    global sx, sg, ybull, b,sb,change,counter1,counter2
    background(0,0,0)
    fill(225,0,0)
    rect(b,ybull,10,20)
    fill(255,0,0)
    rect(sx,sy,90,30)
    rect(sx + 35,sy - 10,20,10)
    

    if isKeyPressed() == True and keyCode() == "Left" and sx < 0:
        sx = 0 
        b = 40
    if isKeyPressed() == True and keyCode() == "Right" and sx > 1210:
        sx = 1210 
        b = 1250
    if isKeyPressed() == True and keyCode() == "Right":
        sx = sx + 5 
        b = b + 5
    if isKeyPressed() == True and keyCode() == "Left":
        sx = sx - 5
        b = b - 5     
    if isKeyPressed() == True and keyCode() == "Up":
        ybull = ybull - 10
    if ybull == 0:
        fill(0,0,0)
        rect(b,ybull,10,20)
    if ybull < 0:
        ybull = 580
        b = b  
     
    if(counter1 > 0):
        for k in range(0, len(flyList)):
                flyList[k][0] -= change
        counter1 -= 5
    elif(counter2 == 0):
        counter1 = 100
        counter2 = 50
        if (change == 5):
            change = -5
        else:
            change = 5
    else:
        for k in range(0, len(flyList)):
                flyList[k][1] += 5
        counter2 -= 5
    
    #check if the bullets are hitting
##     for iz in range(len(flyList)):
##         if flyList[iz][1] + 40>ybull and flyList[iz][1] - 40<ybull:
##             print("fly hit")
##             del flyList[iz]
    
    printFlies()
    
    if flyList[0][1] > 1100 - flyList[0][2]:
        stroke(0,200,0)
        textSize(75)
        text("ITS ALL OGRE NOW",140,400)

        
frameRate(100)
onLoop += draw
loop()                   
#the hitbox
#x in between x and x + size and y is in between y and y + size