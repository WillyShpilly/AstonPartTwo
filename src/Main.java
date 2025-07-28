import One.CustomArrayList;
import One.CustomHashSet;
import Two.Book;
import Two.Student;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> library = List.of(
                new Book("Douglas Adams", "The Hitchhiker's Guide to the Galaxy", 1979, 224),
                new Book("Cormac McCarthy", "The Road", 2006, 304),
                new Book("Stephen King", "It", 1986, 1138),
                new Book("Philip Pullman", "Northern Lights", 1995, 400),
                new Book("Neil Gaiman", "American Gods", 2001, 634),
                new Book("Dan Brown", "Da Vinci Code", 2003, 454),
                new Book("Margaret Atwood", "The Handmaid's Tale", 1985, 311),
                new Book("Terry Pratchett", "Good Omens", 1990, 432),
                new Book("Vladimir Nabokov", "Lolita", 1955, 317),
                new Book("Isaac Asimov", "Foundation", 1951, 256),
                new Book("Arthur Conan Doyle", "Sherlock Holmes: The Complete Novels and Stories", 1887, 1456),
                new Book("Oscar Wilde", "The Picture of Dorian Gray", 1890, 208),
                new Book("Herman Melville", "Moby Dick", 1851, 635),
                new Book("Agatha Christie", "Murder on the Orient Express", 1934, 256),
                new Book("Victor Hugo", "Les Misérables", 1862, 1463),
                new Book("Virginia Woolf", "Mrs. Dalloway", 1925, 200),
                new Book("Chuck Palahniuk", "Fight Club", 1996, 208),
                new Book("Dante Alighieri", "Divine Comedy", 1320, 400),
                new Book("Robert Louis Stevenson", "Treasure Island", 1883, 256),
                new Book("Roald Dahl", "Charlie and the Chocolate Factory", 1964, 160)
        );

        List<Student> students = List.of(
                new Student("Leonardo", List.of(
                        library.get(9),
                        library.get(11),
                        library.get(13),
                        library.get(19),
                        library.get(17)
                )),
                new Student("Donatello", List.of(
                        library.get(1),
                        library.get(3),
                        library.get(17),
                        library.get(7),
                        library.get(10)
                        )),
                new Student("Raphael", List.of(
                        library.get(4),
                        library.get(8),
                        library.get(18),
                        library.get(6),
                        library.get(12)
                        )),
                new Student("Michelangelo", List.of(
                        library.get(14),
                        library.get(15),
                        library.get(16),
                        library.get(18),
                        library.get(1)
                        ))
        );

        students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(Collection::stream)
                .sorted(Comparator.comparingInt(Book::pages))
                .distinct()
                .filter(book -> book.yearOfPublication() > 2000)
                .limit(3)
                .peek(book -> System.out.println(book.title() + " опубликована в " +
                        book.yearOfPublication() + " году"))
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Такая книга отсутствует"));
        }
}
