# gift-exchange

A tool for choosing recipients for a gift exchange. You supply N categories (classic version is wear,read,want,need). Each person will give N gifts and receive N gifts, one from each category. No gift-giver will have the same recipient twice, and you can specify edges in the graph that are not allowed (for instance, excluding significant others from getting each other).

PeopleFile contains a comma-separated list of people. You can specify a disallowed pairing (for example significant other) using a colon (see example PeopleFile)

Generates a message to each gift-giver listing their recipients and get categories for each.

Known issues:
* Works best when the number of nodes is greater than the number of edges.
* Can get stuck (stay tuned for that fix).

Todos:
* Automatically send emails to gift-givers
* Backtrack if stuck
* Allow for more than one disallowed person per person

Example Compilation:

`javac src/com/candybutton/christmas/giftexchange/*.java`

`java src.com.candybutton.christmas.giftexchange/PeoplePickerController ../PeopleFile.txt`
