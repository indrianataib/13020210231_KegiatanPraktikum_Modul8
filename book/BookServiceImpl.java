/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book;
import Config.Database;
import com.mysql.jdbc.PreparedStatement;
import com.sun.jdi.connect.spi.Connection;
    import java.sql.SQLException;
    import java.sql.ResultSet;
    import java.util.ArrayList;
    import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookServiceImpl implements BookService {
    private Connection connection = Database.DBConnection();
    private PreparedStatement statement;
    
    @Override
    public void addBook(Book book){
        try{
            String query = "INSERT INTO book VALUES (0, ?, ?)";
            statement = (PrepareStatement) connection.PrepareStatement(query);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthorName());
            statement.executeUpdate();
           
            System.out.println("Book has been added!\n");
            statement.close();
        }catch (SQLException exc){
            System.out.println("FAILED TO ADD BOOK "+ exc.getMessage());
        }
    }
    
    @Override
    public List<Book> findBookList(){
        List<Book> books = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM book";
            statement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next());
            Book book = new Book();
            book.SetId(result.getInt("id"));
            book.SetTitle(result.getString("Title"));
            book.SetAuthorName(result.getString("author_name"));
            
            books.add(book);
        }
        statement.close();
        return books;
    }catch (SQLException exc){
            System.out.println("FAILED TO GET BOOK LIST : " + exc.getMessage());
}
    return books;



@Override
public Book findBookById(int bookId){
    Book book = new Book();
    try{
        String query = "SELECT * FROM book WHERE id =?";
        statement = (PreparedStatement) connection.prepareStatement(query);
        statement.setInt(1, bookId);
        
        ResultSet result = statement.executeQuery();
        if (result.next());
            int id=result.getInt("id");
            String title = result.getNString("Title");
            String authorName = result.getString("author_name");
            
            book.SetId(id);
            book.SetTitle(title);
            book.SetAuthorName(authorName);
                    
    }   catch (SQLException ex) {
            Logger.getLogger(BookServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    statement.close();
    return book;
}catch (SQLException exc){
            System.out.println("FAILED TO GET BOOK :"+ exc.getMessage());
         
}
return book;

@Override
public void updateBook(Book book){
   try{
       String query = "UPDATE book title = ?, author_name=? WHERE id = ?";
       statement = (PrepareStatement) connection.PrepareStatement(query);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthorName());
            Statement.setInt(3, book.getId());
            statement.executeUpdate();
            
            System.out.println("Succesfully update the book with id = " + book.getId());
            System.out.println("\n");
            statement.close();
            
   }catch (SQLException exc){
       System.out.println("FAILED TO UPDATE TO DATA :" + exc.getMessage());
   }
}
@Override
public void removeBook(int id){
    try{
        String query = "DELETE FROM book WHERE id = ?";
        statement = (PreparedStatement) connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
        
        System.out.println("Sucessfully delete book!\n");
        statement.close();
    }catch (SQLException exc){
        System.out.println("FAILED TO DELETE TO DATA :" + exc.getMessage());
        
    }
}
}
