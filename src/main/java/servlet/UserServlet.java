package servlet;

import java.io.*;

import dto.UserCreate;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.Data;
import service.UserService;

@Data
@WebServlet("/add")
public class UserServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserCreate userDto = new UserCreate(req.getParameter("name"),
                req.getParameter("country"));

        userService.create(userDto);
    }
}