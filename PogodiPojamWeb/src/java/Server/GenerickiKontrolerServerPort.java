/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package Server;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Sreja
 */
@Path("generickikontrolerserverport")
public class GenerickiKontrolerServerPort {

    private Server_client.GenerickiKontrolerServer port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenerickiKontrolerServerPort
     */
    public GenerickiKontrolerServerPort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method registrujKorisnika
     * @param arg0 resource URI parameter
     * @param arg1 resource URI parameter
     * @param arg2 resource URI parameter
     * @param arg3 resource URI parameter
     */
    @PUT
    @Consumes("text/plain")
    @Path("registrujkorisnika/")
    public void putRegistrujKorisnika(@QueryParam("arg0") String arg0, @QueryParam("arg1") String arg1, @QueryParam("arg2") String arg2, @QueryParam("arg3") String arg3) {
        try {
            // Call Web Service Operation
            if (port != null) {
                port.registrujKorisnika(arg0, arg1, arg2, arg3);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

    /**
     *
     */
    private Server_client.GenerickiKontrolerServer getPort() {
        try {
            // Call Web Service Operation
            Server_client.GenerickiKontrolerServer_Service service = new Server_client.GenerickiKontrolerServer_Service();
            Server_client.GenerickiKontrolerServer p = service.getGenerickiKontrolerServerPort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
