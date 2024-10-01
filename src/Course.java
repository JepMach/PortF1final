import java.util.ArrayList;
import java.util.Arrays;

public class Course extends StudyActivities {

    boolean elective;

        public Course (String name, int ects, ActivityType activityType){
            super(name,activityType);
            this.ects=ects;

        }

}
