import re

def find_python_occurence(text):
    occurences=re.findall(r'\bpython\b',text)
    return occurences

text="python is a programming language,python doesnot have any syntax,python code can be easily written."
print("occurences of python : ",find_python_occurence(text))
