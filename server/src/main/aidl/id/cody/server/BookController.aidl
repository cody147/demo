// BookController.aidl
package id.cody.server;
import id.cody.server.Book;

// Declare any non-default types here with import statements

interface BookController {

   List<Book> getBookList();

   void addBookInOut(inout Book book);

}
