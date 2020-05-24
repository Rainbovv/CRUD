
public class Main {
    private static Book[] libraryBooks;

    public static void main(String[] args) {

        libraryBooks = new Book[10];

        addBook(new Book("Java Development sucks!"));
        addBook(new Book("Java Testing Basics!"), 1);
        addBook(new Book("Basics of OOP!"), 7);
        addBook(new Book("Blabla"), true);
        deleteBook(7);

        updateTitle("Java Development is Great!", 0);
        swapBook("Java Development is Great!", new Book("Java Old Book"));

        readAll(true);

    }

    public static void addBook(Book book) {
        libraryBooks[0] = book;
    }

    public static void addBook(Book book, int index) {
        try{
            libraryBooks[index] = book;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.err.println("THERE IS NO SUCH A PLACE IN THE LIBRARY!");
        }
    }

    public static void addBook(Book book, boolean atTheEnd) {
        for(int i = libraryBooks.length; i >= 0; i--) {
            if ( libraryBooks[i - 1] != null || i == 0)
                try {
                    libraryBooks[i] = book;
                    break;
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.err.println("THE LAST PLACE IN THE LIBRARY IS OCCUPIED!");
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
        try{
            libraryBooks[index].setTitle(newTitle);
        }
        catch (NullPointerException e){
            System.err.println("THERE ARE NO BOOKS IN THIS PLACE!");
        }
    }

    public static void deleteBook(int index) {
        if (index >= 0 && index < libraryBooks.length) libraryBooks[index] = null;
    }

    public static int findByTitle(String title){
        for(int i = 0; i < libraryBooks.length; i++){
            if (libraryBooks[i] != null && libraryBooks[i].getTitle().equals(title)) {return i;}
        }
        System.err.println("THERE IS NO SUCH A BOOK IN THIS LIBRARY!");
        return -1;
    }

    public static void swapBook(String title, Book newBook) {

        if (findByTitle(title) != -1) libraryBooks[findByTitle(title)] = newBook;
    }
}
