#!/bin/bash


#plot graph, customization, range, titles, and labels
plot asin(x) with linespoints ls 5
set origin 0.0,0.0
set xrange [-5:5]
set yrange [-3:3]
set title "Graph of Sin^-1(x)"
set xlabel "X (radians)"
set ylabel "Y (Cos^-1(x))"
set object 1 rectangle from screen 0,0 to screen 1,1 fillcolor rgb "#b0e0e6"

