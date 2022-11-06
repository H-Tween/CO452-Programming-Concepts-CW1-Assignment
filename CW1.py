import sys

array = [("The Adults Are Talking", "The Strokes", 234198458), 
("Shotgun", "George Ezra", 769385834), 
("Basket Case", "Green Day", 742442141), 
("Umbrella", "Rihanna", 983460195), 
("Rasputin", "Boney M", 413416677), 
("Dancing Queen", "ABBA", 821695747), 
("I'm Still Standing", "Elton John", 583098683), 
("Something Just Like This", "Cold Play", 1953346889), 
("Dynamite", "BTS", 1516134715), 
("What Makes You Beautiful", "One Direction", 803853615)]

CHOICES = ["Add Song", "Remove Song", "Print All Songs", "Print Songs With Listeners Higher Than Input", "Quit"]

def addSong(name, artist, listeners):
    new = (name, artist, listeners)
    array.append(new)

def removeSong(name):
    number = 1
    for i in array:
        if i[0].lower() == name.lower():
            array.remove(i)
            number = 0
            print()
            print("Song successfully removed...")

    if number == 1:
        print()
        print("Song Does Not Exist...")
            
def printArray():
    print()
    counter = 0
    for item in array:
        counter += 1
        print("Song", counter, ":", item[0], "|", item[1], "|", item[2])

def printOpt(listeners):
    newArray = []
    counter = 0
    print()
    for i in array:
        if listeners < i[2]:
            newArray.append(i)
            for item in newArray:
                counter += 1
                print("Song", counter, ":", item[0], "|", item[1], "|", item[2])

            

print("CO452 Programming Concepts 2022/23")
print("==================================")
print()
print("by Harrison Tween")

decision = 0
while decision != 4:


    print()
    print("MAIN MENU")
    print()

    for index, item in enumerate(CHOICES):
        print(index + 1, ":", item)

    print()
    decision = input("Enter option... : ")
    decision = int(decision)

    if decision <= 0 or decision > len(CHOICES):
        print("\n" + "Invalid response" + "\n")
        sys.exit()

    else:
        decision = decision - 1

    if decision == 0:
        name = input("Enter name of song... : ")
        artist = input("Enter artist of song... : ")
        listeners = int(input("Enter number of song listeners... : "))
        addSong(name, artist, listeners)

    elif decision == 1:
        name = input("Enter name of song to remove... : ")
        removeSong(name)

    elif decision == 3:
        listeners = int(input("Enter number of song listeners... : "))
        printOpt(listeners)

    elif decision == 4:
        print()
        print("Exiting...")
        print()
        sys.exit()

    if decision != 3:
        printArray()