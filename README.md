# gift-exchange

A tool for choosing recipients for a gift exchange. You supply N categories (classic version is wear,read,want,need). Each person will give N gifts and receive N gifts, one from each category. No gift-giver will have the same recipient twice, and you can specify edges in the graph that are not allowed (for instance, excluding significant others from getting each other).

Generates a message to each gift-giver listing their recipients and get categories for each.

Known issues:
* Works best when the number of nodes is greater than the number of edges.
* Can get stuck (stay tuned for that fix).

Todos:
* Automatically send emails to gift-givers
* Backtrack if stuck

Example Compilation:

`javac src/com/candybutton/christmas/giftexchange/*.java`

`java src.com.candybutton.christmas.giftexchange/PeoplePickerController ../PeopleFile.txt`
