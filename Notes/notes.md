# 

Now that we have the basic blocks to build our inheritance relationships for classes, we can now talk about the ways that these relationships can impact how we build objects. As a refresher from the last sections, we had built an inheritance relationship through the example of a library containing different kinds of books. We had the following classes:

- `Book` - the superclass, containing things common to all books: a `title` and an `author`.
- `Novel` - a subclass, containing things unique to novels: a `genre`.
- `PictureBook` - a subclass, containing things unique to picture books: an `illustrator`.
- `Textbook` - a subclass, containing things unique to textbooks: a `subject`, and an `edition`.

We discussed that this inheritance hierarchy is critically built on **"is-a" relationships**, that is subclasses are specific examples of the superclass, like a `Novel` is a `Book`, but a `Book` is not necessraily a `Novel`.

You can see our final implementations of these classes in the `Books` folder.

---

## Polymorphisms

We discussed how we can use the constructors for the subclasses, which in turn creates an internal object of the superclass to store everything correctly. Here is an example of us creating a `Novel` object:

```java
Novel favoriteNovel = new Novel("The Way of Kings", "Brandon Sanderson", 1001, "Fantasy");
```

The nice thing about inheritance is that to a user, this doesn't appear like there is anything complicated going on. As far as someone from the outside could tell, this appears to be a fully-implemented `Novel` class, with no hint about their being a `Book` superclass that controls some of the information.

While this is a strength of inheritance in Java, a classic question is whether we could have defined this `Novel` in a `Book` variable instead, because after all, a `Novel` is a `Book`. Turns out, we can do this, which would look like this:

```java
Book favoriteBook = new Novel("The Way of Kings", "Brandon Sanderson", 1001, "Fantasy");
```

Since a `Novel` is a `Book`, Java has no problem with storing a `Novel` object in a `Book` variable, even though it appears to us more like a type mismatch.

When we do this, we would describe Java as facilitating **polymorphism**, which means that Java is now going to treat this object with a certain amount of flexibility that opens up some doors for us.

This `favoriteBook` is a `Book` object as far as our syntax goes so we are limited to just things present in the `Book` class, and not the `Novel` class despite us knowing it actually stores a `Novel`. This means that we have access to methods like `toString`, `getTitle`, `getAuthor`, and `getPagecount`, because they are present in the `Book` class, but are missing access to methods like `toString` and `getGenre` because they are only present in the `Novel` class.

If you read carefully, you noticed that it said we have access to the `toString` method from `Book`, but don't have access to the `toString` method from Novel. How can we both have access and not have access to a method at the same time?

They key here is where we are in terms of the computer preparing to run the program:
- When we see the computer highlight syntax for us, we are seeing what we call **compile-time**, where the computer is processing the written code into a language the computer itself can comprehend, and it picks up on a lot of different types of errors that we refer to as **compile-time errors**. These are things like types not matching or a method not being available based on the type of a variable.
- Other issues happen at **run-time**, which is when the computer actually runs the compiled code to see what happens. In that scenario, things function a little bit differently because we are now just following instructions, and so different kinds of errors pop up: **run-time errors**. These are things like `StringIndexOutOfBoundsExceptions`, `ArrayIndexOutOfBoundsException`, and `ConcurrentModificationException`. We tend to notice that run-time errors are very specific, and would have required a lot of foresight from the computer to have predicted in advance (hence why they are not caught at compile-time).

Interestingly, compile-time and run-time play a critical role in how polymorphism functions. Essentially, at compile-time, Java treats the object like its declared type (in this case `Book`) very strictly to make sure nothing can go wrong. When we get to run-time though, Java now sees and understands that this is actually a subclass object (in this case `Novel`) and will utilize overridden versions of methods from the subclass where it can.

We can see this polymorphism facilitated by running the following lines:

```java
Book favoriteBook = new Novel("The Way of Kings", "Brandon Sanderson", 1001, "Fantasy");
System.out.println(favoriteBook.getTitle());
System.out.println(favoriteBook);
```

To understand what's happening, we are going to break down how the above code is perceived at compile-time versus at run-time:

Compile-Time - Since favoriteBook is a `Book`, the `getTitle()` method will return `The Way of Kings`, causing that to be printed out by the print method. On the next line, since `favoriteBook` is a `Book`, it automatically will call the `Book` `toString()` method which would return `"The Way of Kings" by Brandon Sanderson`, and print it as well. In summary, this would be the output at compile-time (if that was possible):

```
The Way of Kings
"The Way of Kings" by Brandon Sanderson
```

Run-Time - Since `favoriteBook` is holding a `Novel`, the `getTitle()` method is inherited from the `Book` superclass and will return `The Way of Kings`, causing that to be printed out. On the next line, since `favoriteBook` is holding a `Novel`, it would automatically call the `Novel` `toString()` method which would return `Fantasy Novel "The Way of Kings" by Brandon Sanderson`, and print it as well. In summary, this would be the actual output of the program at run-time (what we would actually see):

```
The Way of Kings
Fantasy Novel "The Way of Kings" by Brandon Sanderson
```

We can see from this example that the idea of polymorphism really changes what heppens when a method is overridden in a scenario like this, and methods that are not overridden (and therefore are just inherited) behave as we would expect.

It is important to mention again that due to compile-time treating the object as a `Book`, we would not have been able to call methods that are exclusive to a subclass (like the `getGenre` or `isLong` methods that `Novel` has in this case) as it doesn't believe they apply to the object, being declared as from the superclass.