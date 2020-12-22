package by.tms.servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/info")
public class Info extends HttpServlet {
    private final InMemoryStorage inMemoryStorage=new InMemoryStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if( inMemoryStorage.getInfo()!=null){
            for(int i=0;i< inMemoryStorage.getInfo().size();i++){
                resp.getWriter().println("name - "+ inMemoryStorage.getInfo().get(i).getName()+
                        "id - "+inMemoryStorage.getInfo().get(i).getId()+
                        "login - "+ inMemoryStorage.getInfo().get(i).getLogin()+
                        "password - "+ inMemoryStorage.getInfo().get(i).getPassword());
            }
        } else{
            resp.getWriter().println("No user");
        }
    }
}
