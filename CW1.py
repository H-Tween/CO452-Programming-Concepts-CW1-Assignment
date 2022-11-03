import sys

array = [("Beautiful", "Anne-Marie", 863015), 
("Bad Habits", "Ed Sheeran", 127191452), 
("Halo", "Beyonce", 991888598), 
("Clash",  "Dave (feat. Stormzy)", 7070513 ), 
("It Gets Better", "Swedish House Mafia", 7563930)]

CHOICES = ["Add Song", "Remove Song", "Print All Songs", "Print Songs with listners higher than input", "END"]

def addSong(name, artist, listners):
    new = (name, artist, listners)
    array.append(new)

def removeSong(name):
    for i in array:
        if i[0].lower() == name.lower():
            array.remove(i)

def printArray():
    print(array)

def printOpt(listners):
    for i in array:
        if listners < i[2]:
            print(i)



decision = 0
while decision != 4:

    print()
    for index, item in enumerate(CHOICES):
        print(index + 1, ":", item)

    print()
    decision = input("Enter option... : ")
    decision = int(decision)

    if decision <= 0 or decision > len(CHOICES):
        print("\n" + "Invalid response" + "\n")

    else:
        decision = decision - 1

    if decision == 0:
        name = input("Enter name of song... : ")
        artist = input("Enter artist of song... : ")
        listners = int(input("Enter number of song listners... : "))
        addSong(name, artist, listners)

    elif decision == 1:
        name = input("Enter name of song to remove... : ")
        removeSong(name)

    elif decision == 2:
        printArray()

    elif decision == 3:
        listners = int(input("Enter number of song listners... : "))
        printOpt(listners)

if decision == 4:
    sys.exit()