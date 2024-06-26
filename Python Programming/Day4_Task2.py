class Rectangle:
    def __init__(self,length,breadth):
        self.length=length
        self.breadth=breadth

    def calculate_area(self):
        return self.length * self.breadth
    
    def calculate_perimeter(self):
        return 2*(self.length+self.breadth)
rectangle = Rectangle(7,14)
print("Area : ",rectangle.calculate_area())
print("Perimeter : ",rectangle.calculate_perimeter())