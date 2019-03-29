package Interfaces;

import java.util.ArrayList;

public interface IOpzaovaniDel
{
    ArrayList<IOpazovalec> opazovalci = new ArrayList<>();
    public void prijavi(IOpazovalec o);
    public void odjavi (IOpazovalec o);
    public void obvesti ();
}
