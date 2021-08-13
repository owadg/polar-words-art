![Screenshot 2021-08-13 155605](https://user-images.githubusercontent.com/54370773/129425473-9a78eac4-3dbb-4a82-99f3-a2d24b1b8d0d.png)
# polar-words-art
It's an art project

I did this after being inspired by a 3Blue1Brown video on the spirals that are formed when graphing the primes on a polar graph. This program uses Swing. 
Ultimately it was supposed to be a hybrid of my interests in math, art, and programming. Because it was just for "art," the code style isn't exactly super clean.

It draws as many positive integers as it can on a polar graph, and then writes words on the "modulo" groups that form the arms of the spiral. It zooms in and out of this graph with text.

It's a relatively simple program. test is the main class. PGraph is a polar graph class. It also has a function to convert all of it's points into a cartesian graph basically, which is how I actually draw them. The last class is JPgraph, which is definitely the bulk of the program. This is the class that does all the drawing. It's basically just a custom jPanel with an action listener and a timer to control the pace of the zooming in and out.
