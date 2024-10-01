public abstract class StudyActivities {
    public enum ActivityType {
        Datalogi,
        Informatik,
        Basis,
        GastronomiStudier,
        GeoMichealGrafi,
        Bachelor
    }
    String name;
    int ects;
    ActivityType activityType;

    public StudyActivities(String name, ActivityType activityType){
        this.name=name;
        this.activityType = activityType;

    }
}
