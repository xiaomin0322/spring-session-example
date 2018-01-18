package com.jayway.springsessionexample;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

    private static final String NAME = "name";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    	/*Test t = new Test();
    	req.getSession().setAttribute("aaa", t);
    	req.getSession().setAttribute("bbb", t);
    	req.getSession().removeAttribute("aaa");
    	t= (Test)req.getSession().getAttribute("aaa");*/
    	
    	req.getSession().removeAttribute("aaa");
    	
    	//System.out.println(t.getT().getN());
    	
        String name = Optional.ofNullable(req.getSession(false))
                .map(session -> (String) session.getAttribute(NAME))
                .orElse("World");
        String greeting = String.format("Hello %s!", name);

        try (ServletOutputStream out = resp.getOutputStream()) {
            out.write(greeting.getBytes(StandardCharsets.UTF_8));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter(NAME);
        req.getSession().setAttribute(NAME, name);
    }
}