import re


def find_name(line):
    title = r"(?:[A-Z][a-z]*\.\s*)?"
    name1 = r"[A-Z][a-z]+,?\s+"
    middle = r"(?:[A-Z][a-z]*\.?\s*)?"
    name2 = r"[A-Z][a-z]+"
    pattern = title + name1 + middle + name2
    result = re.findall(pattern,line)

    pattern=r'(October|Oct|November|Nov)( [0-9]{1,2}, [0-9]{4})'
    result = result + re.findall(pattern,line)
    return result


f = open("names.txt")
for line in f.readlines():
    #print(line)
    result = find_name(line)
    if (len(result)>0):
        print(result)

