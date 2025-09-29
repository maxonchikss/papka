package bikeproject.src.bikeproject; //в интерфейсе нет реализации, только то что должно быть в будущем

public interface MountainParts {
    String TERRAIN = "off_road";
    void setSuspension (String newValue);
    void setType (String newValue);
    String getSuspension ();
    String getType ();
}
