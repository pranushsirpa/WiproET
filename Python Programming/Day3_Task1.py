''' Write a function in Python that calculates and returns the factorial 
of a number provided as an argument.'''
def factorial(n):
    if n==0:
        return 1
    else:
        return n * factorial(n-1)
number=8
print("Factorial of", number, "is", factorial(number))