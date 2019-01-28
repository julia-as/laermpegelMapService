package de.htw.vt;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class FrontendServerImpl extends java.rmi.server.UnicastRemoteObject implements FrontendServer {

    private Double x;
    private Double y;
    private Double value;
    private int id;
    public FrontendServer frontend;

    public FrontendServerImpl() throws RemoteException {
        super();
    }

    public void receiveSensor(int id, Double x, Double y) throws RemoteException {
        this.setId(id);
        this.setX(x);
        this.setY(y);
        System.out.println("in frontend id: " + this.id + " x: " + this.x + "\n in frontend y: " + this.y);
    }

    public void receiveValue(Double value) throws RemoteException {
        this.setValue(value);
    }

    public void receiveNewValue(int id, Double value) throws RemoteException {
        this.setValue(value);
        System.out.println("New Sensor Value\n"
                + "Sensor ID: " + id
                + "\n new value: " + this.getValue());
    }

    public void startRmi() throws RemoteException {
        try {
            LocateRegistry.createRegistry(9876);
            System.out.println("rmi Registry: " + LocateRegistry.getRegistry().toString());

            frontend = new FrontendServerImpl();
            Naming.rebind("rmi://localhost:9876/FrontendServer", frontend);
            System.out.println("server2 created at rmi " + frontend.toString());
        }
        catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    public FrontendServer getObjekt() throws RemoteException {
        return frontend;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public Double getX() throws RemoteException {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY()throws RemoteException {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getValue()throws RemoteException {
//		return 100.15;
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}
