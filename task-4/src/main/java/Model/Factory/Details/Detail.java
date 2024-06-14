package Model.Factory.Details;

public abstract class Detail {
    protected final int id;

    public Detail(int ID) {
        id = ID;
    }
    public int getID() {
        return id;
    }
}
