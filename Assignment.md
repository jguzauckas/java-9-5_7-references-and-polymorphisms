# Assignment

You are going to build out a few classes that follow an inheritance hierarchy, and test them out with some polymorphisms.

This hierarchy is a new one that tries to bring more out of the `Person` class that we have utilized over the course of many units. Here is what it looks like:

```
                                    Person
                                      |   
                     ----------------------------------------
                     |                                      |
                   Child                                  Adult
                     |
          ---------------------------                
          |          |              |
        Baby        Kid         Teenager
```

Information about the lowest level classes (`Baby`, `Kid`, `Teenager`, and `Adult`) and their requirements are below. Use these requirements to determine what can be moved up into their respective superclasses (`Child`), and potentially what can move all the way up into the `Person` superclass.

The `Runner.java` file has a method called `runner` that is meant to thoroughly test everything about our class hierarchy. This involves trying each constructor and method to ensure everything is working properly. You should thoroughly test polymorphisms of objects by following the example of provided in `Runner.java`. This is meant to check that you know what you can appropriately access through a polymorphism.

The most important uses of these tests is that you should be predicting what the output should be so that when you run the `Runner.java` file, you can evaluate whether things were working correctly or not. For example, if the output was different than what you expected, what is wrong? Were your predictions wrong, or is something implemented wrong with the class being tested?

Use the notes examples for the `Book`-related classes as supporting material as you work on this if needed.

---

## `Baby` (subclass of `Child`)

Instance Variables:
- Name
- Birth Year
- Height in Inches
- Weight in Pounds
- Grade Level
- Whether or not they can walk

Constructors:
- Default/No-Argument Constructor
- All-Argument Constructor (values for all instance variables)

Methods:
- `toString` method for printing
- `equals` method
- Accessor and Mutator methods for all instance variables

## `Kid` (subclass of `Child`)

Instance Variables:
- Name
- Birth Year
- Height in Inches
- Weight in Pounds
- Grade Level
- Dream Job ("When I grow up, I wanna be...")

Constructors:
- Default/No-Argument Constructor
- All-Argument Constructor (values for all instance variables)

Methods:
- `toString` method for printing
- `equals` method
- Accessor and Mutator methods for all instance variables

## `Teenager` (subclass of `Child`)

Instance Variables:
- Name
- Birth Year
- Height in Inches
- Weight in Pounds
- Grade Level
- Job

Constructors:
- Default/No-Argument Constructor
- All-Argument Constructor (values for all instance variables)

Methods:
- `toString` method for printing
- `equals` method
- Accessor and Mutator methods for all instance variables

## `Adult` (subclass of `Person`)

Instance Variables:
- Name
- Birth Year
- Height in Inches
- Weight in Pounds
- Job

Constructors:
- Default/No-Argument Constructor
- All-Argument Constructor (values for all instance variables)

Methods:
- `toString` method for printing
- `equals` method
- Accessor and Mutator methods for all instance variables
