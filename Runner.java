public class Runner {
    public static void runner() {
        // Tests of a Baby stored as a Child
        System.out.println("Baby as Child Tests");
        Child child1 = new Baby("Name", 2023, 24.5, 32.4, 0, false);
        System.out.println("toString Test: " + child1);
        child1.setName("New Name");
        System.out.println("get/set Name Test: " + child1.getName());
        child1.setBirthYear(2022);
        System.out.println("get/set Birth Year Test: " + child1.getBirthYear());
        child1.setHeight(25.0);
        System.out.println("get/set Height Test: " + child1.getHeight());
        child1.setGradeLevel(-1);
        System.out.println("get/set Grade Level Test: " + child1.getGradeLevel());
        Child child2 = new Baby("Name", 2023, 24.5, 32.4, 0, false);
        System.out.println("equals Test: " + child1.equals(child2));
        
        // Tests of a Baby stored as a Person
        System.out.println("Baby as Person Tests");

        // Tests of a Kid stored as a Child
        System.out.println("Kid as Child Tests");

        // Tests of a Kid stored as a Person
        System.out.println("Kid as Person Tests");

        // Tests of a Teenager stored as a Child
        System.out.println("Teenager as Child Tests");

        // Tests of a Teenager stored as a Person
        System.out.println("Teenager as Person Tests");

        // Tests of an Adult stored as a Person
        System.out.println("Teenager as Person Tests");
    }
}
