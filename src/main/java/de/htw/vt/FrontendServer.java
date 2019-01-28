package de.htw.vt;

import java.rmi.RemoteException;

public interface FrontendServer extends java.rmi.Remote {

    public void receiveSensor(int id, Double x, Double y) throws java.rmi.RemoteException;
    public void receiveValue(Double v) throws java.rmi.RemoteException;
    public void receiveNewValue(int id, Double v) throws java.rmi.RemoteException;
    public void startRmi() throws RemoteException;
    Double getX()throws RemoteException;
    Double getY()throws RemoteException;
    Double getValue()throws RemoteException;
    void setValue(Double value)throws RemoteException;
    void setX(Double x)throws RemoteException;
    void setY(Double y)throws RemoteException;
    FrontendServer getObjekt()throws RemoteException;

}
