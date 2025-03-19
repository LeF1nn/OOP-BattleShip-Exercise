public class Ship {


    private int size;
    private boolean horizontal;
    private int healthPercent;
    private Cordinate cordinate;


    public Ship(int size , boolean horizontal , int healthPercent , Cordinate cordinate){
        this.size = size;
        this.horizontal = horizontal;
        this.healthPercent = healthPercent;
        this.cordinate = cordinate;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public boolean isHorizontal() {
        return horizontal;
    }
    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }
    public int getHealthPercent() {
        return healthPercent;
    }
    public void setHealthPercent(int healthPercent) {
        this.healthPercent = healthPercent;
    }
    public Cordinate getCordinate() {
        return cordinate;
    }
    public void setCordinate(Cordinate cordinate) {
        this.cordinate = cordinate;
    }

}


