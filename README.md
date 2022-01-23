# Project Stage 2

## Design patterns used:

I used strategy pattern to override the method
sortChildren for every type of method to assign gifts to children.
For example, when the parameter strategy is "id" => 
we sort the children by their id,
we return an object of IdAssignGiftStrategy type that has the method sortChildren
implemented for the specific type of sort. I used factory pattern to define a function that
returns the right type of sorting strategy object. GiftsFactory class contains a function that creates a
specific type of strategy to sort the children list. The function takes two parameters, a String object, that specifies
the type of strategy we want to implement for sorting the children and a list of children that we want to sort using the
specified strategy.
In Main class we will just call the sortChildren method without verifying the strategy we have to use
for sorting, this aspect is verified by the factory and strategy patterns.

## Parse the input from json file

Nothing changed from the first stage of the project. The readInput method
stays the same.

InputData contains the numberOfYears, santaBudget, and also information about
initialData and the list with annualChanges.

InitialData contains the information needed at the first round
- a list of children
- a list with gifts
- a list of cities

AnnualChanges : A change specifies new data that needs to replace old data.
- newSantaBudget
- List with new gifts that need to be added
- list with new children that need to be added
- updates for children

ChildUpdate : Contains as parameters the properties of an object of child type
that need to be changed
- id, that specifies the child that we apply the updates on
- niceScore, a new value for the niceScore of the child
- giftsPreferences, a list with new preferences for gifts

Write the output to json file

I used separated classes to write the output into json files

ChildOutput : Contains all the information about a child that need to be written in
the json file.

CompleteOutput : Contains a list with objects of ChildOutput type.

GiftOutput : Contains all the properties of a gift except the quantity of the gift.

AnnualChildren : Contains a list with objects of CompleteOutput type.
An object of CompleteOutput type represents the list of children and their information
specific for a certain round.
