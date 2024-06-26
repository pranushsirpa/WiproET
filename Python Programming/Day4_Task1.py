# Write a Python program to read a file and print its content line by line.

with open('sample.txt') as file:
    for line in file:
        print(line.strip())