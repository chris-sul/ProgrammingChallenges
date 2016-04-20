from Processing import *
from random import *

window(1300,800)
frameRate(60)
background(255,255,255)
flyList = []

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

def shootBullet():
    global shipX,buletList,bulletNum
    bulletList.append([shipX,shipY])
    while bulletList[bulletNum][1] > 0:
        bulletList[bulletNum][1] -= 2
        delay(50)
        fill(255,255,255)
        rect(bulletList[bulletNum][0],bulletList[bulletNum][1],30,10)
    bulletNum += 1


bulletList = []
bulletNum = 0
shipX = 600
shipY = 600
change = 5
counter1 = 100
counter2 = 50
def draw():
    global shipY,shipX,change,counter1,counter2
    #fill(255,0,0)
    background(0,0,0)
    rect(shipX,shipY,90,30)
    rect(shipX + 35,shipY - 10,20,10)
    if isKeyPressed() == True and keyCode() == "Left": 
        shipX -= 5
    if isKeyPressed() == True and keyCode() == "Right":
        shipX += 5
    if isKeyPressed() == True and keyCode() == "Up":
        #shoot the bullet
        shootBullet()
        delay(50)

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

    printFlies()

frameRate(100)
onLoop += draw
loop()