package dosw.bitacora.Corte1.Semana3.patrones.Iterator;

public class Tourist {

    public void exploreTour(Aggregate<Place> route){
        Iterator<Place> iterator = route.createIterator();

        while (iterator.hasNext()){
            Place p = iterator.next();
            System.out.println("Visiting" + p.getName());
        }
    }
}
