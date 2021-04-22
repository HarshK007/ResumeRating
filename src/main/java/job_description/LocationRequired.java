package job_description;

public class LocationRequired {
    String location;
    int weight;

    public LocationRequired() {

    }

    public LocationRequired(String location, int weight) {
        this.location = location;
        this.weight = weight;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "" + location +
                ":" + weight +
                "";
    }
}
