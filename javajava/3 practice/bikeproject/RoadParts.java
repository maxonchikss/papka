package bikeproject.src.bikeproject;

public interface RoadParts {
    String terrain = "track_racing";
    void setTyreWidth (int newValue);
    void setPostHeight (int newValue);
    int getPostHeight ();
    int getTyreWidth ();
}
