
public class Main {
    private static Book[] libraryBooks;

    public static void main(String[] args) {

        libraryBooks = new Book[10];

        addBook(new Book("Java Development sucks!"));
        addBook(new Book("Java Testing Basics!"), 1);
        addBook(new Book("Basics of OOP!"), 11);
        addBook(new Book("Blabla"), true);
        deleteBook(7);

        updateTitle("Java Development is Great!", 0);
        swapBook("Java Development is Great!", new Book("Java Old Book"));

        readAll(true);

    }

    public static void addBook(Book book) {
        addBook(book,0);
    }

    public static void addBook(Book book, int index) {
        if (isIndexInBound(index)) {
            if (libraryBooks[index] != null)
                System.err.println("THE PLACE IS OCCUPIED!");
            else
                libraryBooks[index] = book;
        }
    }

    public static void addBook(Book book, boolean atTheEnd) {
        if (libraryBooks[libraryBooks.length - 1] != null)
            System.err.println("THE LAST PLACE IN THE LIBRARY IS OCCUPIED!");
        else
            for(int i = libraryBooks.length - 1; i >= 0; i--) {
                if (i == 0 || libraryBooks[i - 1] != null) {
                    libraryBooks[i] = book;
                    break;
                }
            }
    }

    public static void readAll() {
        for (Book book : libraryBooks) {
            System.out.println(book);
        }
    }

    public static void readAll(boolean ExcludeEmpty) {
        if (ExcludeEmpty){
            for (Book book:libraryBooks) {
                if (book != null) System.out.println(book);
            }
        } else readAll();
    }

    public static void updateTitle(String newTitle, int index) {
        if (isIndexInBound(index)) {
            if (libraryBooks[index] == null)
                System.err.println("THERE ARE NO ANY BOOKS IN THIS PLACE!");
            else
                libraryBooks[index].setTitle(newTitle);
        }
    }

    public static void deleteBook(int index) {
        if (isIndexInBound(index))
            libraryBooks[index] = null;
    }

    public static int findByTitle(String title){
        for(int i = 0; i < libraryBooks.length; i++){
            if (libraryBooks[i] != null && libraryBooks[i].getTitle().equals(title))
                return i;
        }
        System.err.println("THERE IS NO SUCH A BOOK IN THIS LIBRARY!");
        return -1;
    }

    public static void swapBook(String title, Book newBook) {
        int swappableBookIndex = findByTitle(title);

        if (swappableBookIndex != -1)
            libraryBooks[swappableBookIndex] = newBook;
    }

    public static boolean isIndexInBound(int index){
        if (index < 0 || index >= libraryBooks.length){
            System.err.println("THERE IS NO SUCH A PLACE IN THE LIBRARY!");
            return false;
        }
        else
            return true;
    }
}
