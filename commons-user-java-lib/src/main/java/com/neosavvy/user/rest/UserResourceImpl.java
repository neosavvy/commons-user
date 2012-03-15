package com.neosavvy.user.rest;

import com.neosavvy.user.dto.UserDTO;
import com.neosavvy.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path(UserResourceImpl.USER_RESOURCE_URL)
public class UserResourceImpl {

    public static final String USER_RESOURCE_URL = "/users";

    @Autowired
    public UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("users")
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("users")
    public void saveUser(UserDTO user) {
        userService.saveUser(user);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("users/{id}")
    public UserDTO findUserById(@PathParam("id") int id) {
        return userService.findUserById(id);
    }

    public List<UserDTO> findUsers(UserDTO user) {
        return userService.findUsers(user);
    }

    @DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("users")
    public void deleteUser(UserDTO user) {
        userService.deleteUser(user);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("data/{userName}/{hashCode}")
    public ModelAndView confirmUser(@PathParam("userName") String userName, @PathParam("hashCode") String hashCode) {
        boolean confirmed = userService.confirmUser(userName, hashCode);
        String returnValue;
        if (confirmed) {
            returnValue = "Thanks for confirming your membership please visit http://localhost:8080/commons-user-webapp/ to login";
        } else {
            returnValue = "There was a problem confirming your membership please request a new registration token";
        }
        return new ModelAndView("registrationConfirmation", "confirmationMessage", returnValue);
    }

}
