package de.htw.vt;

import java.io.IOException;
import java.net.URI;
import java.rmi.RemoteException;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;


public class RestServer {

        public RestServer() throws RemoteException { }

        public static void main(String[] args) throws IOException {
            FrontendServer frontend = new FrontendServerImpl();
            frontend.startRmi();

            final ResourceConfig rc = new ResourceConfig().packages("de.htw.vt");
            HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create("http://localhost:8080"),
                    rc);
                    //new ResourceConfig(Frontend.class));

            System.out.println("Press any key to close");
            System.in.read();
            server.stop();
        }
}
