from Myro import *
from Graphics import *

pic = makePicture("tupac.png")
pixels = getPixels(pic)

Obama_DarkBlue = makeColor(0,51,76)
Obama_Red = makeColor(217, 26, 33)
Obama_Blue = makeColor(112,150,158)
Obama_Yellow = makeColor(252, 227, 166)

amount = 0
#loop and change values
for pix in pixels:
    amount = getGray(pix)
    if amount > 180:
        setColor(pix,Obama_Yellow)
    elif amount > 120:
        setColor(pix,Obama_Blue)
    elif amount > 60:
        setColor(pix,Obama_Red)
    else:
        setColor(pix,Obama_DarkBlue)

#add words to the bottom
shape = Picture(pic)
text = Text((140, 350), "Hope")
text.fill = Color("white")
text.fontSize = 90
text.fontFace = "impact"
win = Window("tupac", shape.width, shape.height)
shape.draw(win)
text.draw(win)



