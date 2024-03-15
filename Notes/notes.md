# References and Polymorphisms

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

---

## Compile-Time and Run-Time for Polymorphisms

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

Why would we use polymorphism? In the above example, it seems obvious that if we know we are constructing a `Novel` object, that we should just make a `Novel` variable. For the most part, this is a fair sentiment and whenever possible, you should use the correct type for a variable. The one case where we would consider this to be appropriate is if we are planning to frequently change which object is stored in `favoriteBook`, acknowledging that it is possible for my favorite book to be a different type of `Book` in the future.

---

## Data Structures with Polymorphisms

A more appropriate use of polymorphism is in the case of data structures, like arrays or ArrayLists. When we intend to store many different `Book` objects, like maybe a library would, we would expect to get a wider variety, with some objects just being `Book` objects, but others being `Novel`, `PictureBook`, or `Textbook` objects. If this is the case, then we can define a data structure to hold the superclass (in this case `Book`), and then store a variety of subclass types to work with.

Here is an example of creating a `Book` `ArrayList` and storing different types of `Book` objects in it:

```java
ArrayList<Book> library = new ArrayList<Book>();
library.add(new Book("La machine de Turing", "Alan Turing", 174));
library.add(new Novel("The Way of Kings", "Brandon Sanderson", 1001, "Fantasy"));
library.add(new PictureBook("If You Give a Mouse a Cookie", "Laura Joffe Numeroff", 40, "Felicia Bond"));
library.add(new Textbook("Introduction to Algorithms", "Thomas H. Cormen", 1292, "Computer Science", 3));
```

So now we have an `ArrayList` called `library` that stores `Book` objects, but through polymorphism, we can use each object, even if they are a subclass of `Book`. This is a case where it makes a lot more sense why we can't use subclass-specific methods. Let's say I were to run the following loop:

```java
for (Book book : library) {
    System.out.println(book.getGenre());
}
```

We know that our `ArrayList` stores `Book` objects of all subclass types, so `getGenre()` is a terrible idea, as it only would work when the `Book` objects are specifically `Novel` objects. If we were to do something with every `Book` (or just any `Book` in this list), we would want to use things that work for all `Book` objects, regardless of subclass. Much more reasonable then would be forcing it to call the `toString` method like we saw above:

```java
for (Book book : library) {
    System.out.println(book);
}
```

As before, compile-time and run-time function differently still. If we got a printed result from compile-time (which we don't actually), this is what Java thinks is going to happen:

```
"La machine de Turing" by Alan Turing
"The Way of Kings" by Brandon Sanderson
"If You Give a Mouse a Cookie" by Laura Joffe Numeroff
"Introduction to Algorithms" by Thomas H. Cormen
```

At run-time though, we get this actual result:

```
"La machine de Turing" by Alan Turing
Fantasy Novel "The Way of Kings" by Brandon Sanderson
Picturebook "If You Give a Mouse a Cookie" written by Laura Joffe Numeroff and illustrated by Felicia Bond
Computer Science Textbook "Introduction to Algorithms", Edition 3 by Thomas H. Cormen
```

This is a great example of multiple polymorphisms being performed. For each object, Java approves this at compile-time because our code would work if everything was just straight `Book` objects, but successfully uses the subclass overriden versions of the `toString` method for the unique subclasses at run-time.

---

## `Object` Superclass

A minor, yet important, piece of information that we have left out so far is that every hierarchy we have looked at is actually slightly larger than we led you to believe.

When we make a custom class that is meant to stand on its own (like `Book`, where it doesn't have a superclass it relies on), it actually *does* extend something, the `Object` superclass.

The `Object` superclass is how Java defines how object works at the core level, and so every custom object we create uses some of that basis to function. The neat part about it is that we don't have to write `public class Book extends Object`, because Java understands that if `Book` doesn't extend anything else, then it should automatically do this.

What benefit does this give us? Without going too much into the weeds, objects as we know them just wouldn't work without it, which is reason enough to keep it.

Specific benefits though come from some really basic methods that we would often decide to overwrite for our custom classes. The two methods we would normally consider are `toString()` and `equals()`.

We have looked at `toString()` a lot in this unit so far, so we can let that rest for a while. Just understand that the `Object` superclass has a definition of the `toString()` method that prints the object type and the memory address (useful in some troubleshooting, but often not what we want). We almost always override it with our own version.

### `equals()` Method

The other method is one we haven't looked at, which is `equals()`. The `Object` superclass has an `equals()` method that we can use if we want, but it might not work the way we want. Right now, we have not overwritten the `equals()` method, so let's see how it works with this example:

```java
Book favBook1 = new Book("The Way of Kings", "Brandon Sanderson", 1001);
Book favBook2 = new Book("The Way of Kings", "Brandon Sanderson", 1001);
System.out.println(favBook1.equals(favBook2));
```

Oddly enough, the output of this code is `false`. How could these possibly be considered "not equal"? This comes down to the `Object` superclass having a very simple way to determine if two objects are the same: their memory addresses. Whenever we make an object, it is assigned a memory address. Since we made two objects above, they are assigned two memory addresses even though they produce an object with the same information.

This is a very rudimentary way of determining if two objects are the same, we know that we think these should be the same! Often then, we will override the `equals()` method as well, similar to how we can override the `toString()` method. Here is what an `equals()` method for `Book` might look like:

```java
public boolean equals(Book other) {
    if (this.title.equals(other.title) && this.author.equals(other.author)) {
        return true;
    }
    return false;
}
```

A few things to note about this `equals()` method:
- All `equals()` methods need to have a single parameter that is the same type as our class (to compare to). It is considered best practice to always name that variable `other`.
- We had to use `.equals()` inside of this `equals()` method to compare `String` objects, this is considered normal.
- I purposely did not include `pagecount` in this. When you make an `equals()` method, you can decide how much information needs to be the same to decide that they are the same object. In this case, I would argue different printings of a `Book` can often have different `pagecount`s, so it makes sense that if it is the right `title` and `author`, then it is the same.

Just like `Book` originally used the `Object` superclass `equals()` method, any subclasses of `Book` that don't override the `equals()` method will automatically use the `Book` `equals()` method. Here is an example with two `Novel` objects:

```java
Novel favNovel1 = new Novel("The Way of Kings", "Brandon Sanderson", 1001, "Fantasy");
Novel favNovel2 = new Novel("The Way of Kings", "Brandon Sanderson", 1036, "Fiction");
System.out.println(favNovel1.equals(favNovel2));
```

This produces the value `true`, because even though the `pagecount` and `genre` are labeled differently, the `Book` `equals()` method only looks at `title` and `author`, which are still the same.

You can override the `equals()` method in any class you create if you deem it necessary. We could argue that we really don't need to override it for `Novel` and `PictureBook` because they tend to just care about `title` and `author`. It could make more sense for `Textbook` since we care about edition as well. here is what an `equals` method for `Textbook` might look like:

```java
public boolean equals(Textbook other) {
    if (super.equals(other) && this.edition == other.edition) {
        return true;
    }
    return false;
}
```

A really interesting idea is that we can utilize the superclass `equals()` method if it would help us to determine if two objects are equal. In the case of a `Textbook`, we want the `title`, `author`, and `edition` to be the same, and we know that the `Book` superclass `equals()` method will determine if `title` and `author` are the same. With that then, we call `super.equals(other)` and combine it with a check of the `edition` values to make a final determination of whether or not two `Textbook` objects are the same. This saves us the effort of calling things like `this.getAuthor()`!

A great test of this will be to make two different editions of the same `Textbook`. If our `Textbook` `equals()` method is working, it should say they are not the same. On the other hand, if it is not working, the `Book` `equals()` method should take over and we know that it would say they are the same. Here is a test of this:

```java
Textbook favText1 = new Textbook("Introduction to Algorithms", "Thomas H. Cormen", 1292, "Computer Science", 3);
Textbook favText2 = new Textbook("Introduction to Algorithms", "Thomas H. Cormen", 1292, "Computer Science", 4);
System.out.println(favText1.equals(favText2));
```

And it produces the output `false`, indicating that our `Textbook` `equals()` method works!