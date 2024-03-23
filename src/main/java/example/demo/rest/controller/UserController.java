package example.demo.rest.controller;

import example.demo.rest.business.services.UserServices;
import example.demo.rest.model.User;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/users")
public class UserController {
    
    @Inject  
    UserServices userServices;

    HttpSession session;


    @Path("/auth")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User auth(User user){
         return userServices.authenticateUser(user);
         //return user;

    }


    @Path("/createUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public User createUser(User newUser) {
        try {
            System.out.println(newUser);
            return userServices.createUser(newUser);
            //return newUser; 
           
        } catch (IllegalArgumentException e) {
        }
        
        System.out.println("hihih didnt work");
        return null;
    }

    // @DELETE
    // @Path("/deleteUser")
    // public void deleteUser(User userToDelete) {

    //     userServices.deleteUser(userToDelete);
       
    // }

    // @PUT
    // @Path("/updateUser")
    // @Consumes(MediaType.APPLICATION_JSON)
    // public Response updateUser(User user) {
    //     try {
    //         userServices.updateUser(user);
    //         return Response.ok().build();
    //     } catch (Exception e) {
    //         return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
    //     }
    // }


    // @GET
    // @Path("/findUser")
    // @Consumes(MediaType.APPLICATION_JSON)
    // @Produces(MediaType.APPLICATION_JSON)
    // public User findUserByEmail(User user) {
    //     try {
             
    //         if (userServices.findUserByEmail(user) != null) {
    //             System.out.println(user);
    //             //return Response.ok(email).build();
    //             return userServices.findUserByEmail(user);
    //         } else {
    //             System.out.println("user est null");
    //             return null;
               
    //         }
    //     } catch (Exception e) {
    //         return null;
    //     }
    // }

    //pas de return de page html que du backend 

    // public Response subscription(User user){
    //     userServices.subscription(user);
    //     return Response.ok().entity(user).build();
    // }
}
