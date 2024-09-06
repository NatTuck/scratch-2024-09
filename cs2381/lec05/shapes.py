
from math import pi

class Circle:
    def __init__(self, radius):
        self.radius = radius

    def area(self):
        return pi * pow(self.radius, 2)

class Square:
    def __init__(self, width):
        self.width = width

    def area(self):
        return pow(self.width, 2)


shapes = [Circle(7.0), Square(7.0)]

for shape in shapes:
    print(shape.area())
    
