public class MPD<V> {
    public boolean marked;
    public V previous;
    public double distance;

    public MPD(boolean marked, V previous, double distance) {
        this.marked = marked;
        this.previous = previous;
        this.distance = distance;
    }
}
