package dosw.bitacora.Semana2.patrones.Iterator;

public class TourRoute implements Aggregate <Place>{

    private final Place[] places;

    public TourRoute(){
        places = new Place[]{
                new Place("Colosseum"),
                new Place("RomanForum"),
                new Place("Trevi Fountain"),
                new Place("Pantheon"),
                new Place("Spanish Steps")
        };
    }

    @Override
    public Iterator<Place> createIterator() {
        return new RomeIterator(places);
    }
}
