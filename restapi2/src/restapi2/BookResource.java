package restapi2;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/books")
public class BookResource {
	
BookRepository repo=new BookRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Book> getBooks()
	{
		return repo.getBooks();
	}

	@GET
	@Path("/{title}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Book getBook(@PathParam("title") String title)
	{
		return repo.getBook(title);
	}

	@POST
	public Book createBook(Book a1)
	{
		repo.create(a1);
		return a1;
	}
	
	@PUT
	public void updateBook(Book a1)
	{
		repo.update(a1);

	}
	
	@DELETE
	public void deleteBooks()
	{
		repo.deleteAll();

	}
	
	@DELETE
	@Path("/{id}")
	public Book deleteOneBook(@PathParam("id") int id)
	{
		Book a=repo.getBookById(id);
		repo.deleteOne(id);
		return a;
	}
	
}
