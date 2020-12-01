# gift-exchange

A tool for choosing recipients for a gift exchange. You supply N categories (classic version is wear,read,want,need). Each person will give N gifts and receive N gifts, one from each category. No gift-giver will have the same recipient twice, and you can specify edges in the graph that are not allowed (for instance, excluding significant others from getting each other).

PeopleFile contains a comma-separated list of people. You can specify a disallowed pairing (for example significant other) using a colon (see example PeopleFile)

The default gift categories are wear,read,want,need. Right now there are two other hardcoded options: 'experience' which swaps 'need' for an open-ended 'experience' category, and 'panedmic' which swaps 'eat' in for 'read' and turns 'experience' into 'pandemic feat' i.e. some kind of open-ended pandemic-friendly activity.

Generates a message to each gift-giver listing their recipients and get categories for each.

Known issues:
* Works best when the number of nodes is greater than the number of edges.
* Can get stuck on situations with no solution (stay tuned for that fix).

Todos:
* Automatically send emails to gift-givers
* Backtrack if stuck

Example Compilation (from the `gift-exchange/src` directory):

`javac com/candybutton/christmas/giftexchange/*.java`

`java com.candybutton.christmas.giftexchange/PeoplePickerController ../PeopleFile.txt`

also try

`java com.candybutton.christmas.giftexchange/PeoplePickerController ../PeopleFile.txt experience`

and 

`java com.candybutton.christmas.giftexchange/PeoplePickerController ../PeopleFile.txt pandemic`
