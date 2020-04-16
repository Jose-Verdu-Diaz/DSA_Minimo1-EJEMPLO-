package edu.upc.dsa.services;


import edu.upc.dsa.GameManager;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.models.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/game", description = "Endpoint to Game Service")
@Path("/game")
public class GameService {
    static final Logger logger = Logger.getLogger(GameService.class);
    private GameManager manager;

    public GameService() {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        this.manager = GameManagerImpl.getInstance();

        if (this.manager.numUsers() == 0) {
            this.manager.addUser("u001","User1");
            this.manager.addUser("u002","User2");
            this.manager.addUser("u003","User3");

            this.manager.addProduct("p001","Prodcut1");
            this.manager.addProduct("p002","Prodcut2");
            this.manager.addProduct("p003","Prodcut3");

            /*
            this.manager.addUserGameObject("001","01");
            this.manager.addUserGameObject("001","02");
            this.manager.addUserGameObject("002","02");
            this.manager.addUserGameObject("003","03");
             */
        }
    }

    @POST
    @ApiOperation(value = "Create new User", notes = "Add a new user providing and id and a name")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User added succesfuly", response= User.class),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @Path("/addUser/{id}/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response newUser(@PathParam("id") String id, @PathParam("name") String name ) {
        if (id.isEmpty() || name.isEmpty()){
            return Response.status(400).entity(new User()).build();
        }
        else{
            this.manager.addUser(id,name);
            return Response.status(201).entity(manager.getUser(id)).build();
        }

    }
}