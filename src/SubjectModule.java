import java.util.ArrayList;

public class SubjectModule {

    String subjectModuleName;
    BachelorProgramme programme;
    ArrayList<Course> courses = new ArrayList<>();
    final Project[] projectName = new Project[1];
    boolean moduleComplete;

    public SubjectModule(StudyActivities.ActivityType subjectModuleName){
      this.subjectModuleName=subjectModuleName.toString();
    }

   public int getModuleECTS(){
        int ECTSsum=0;

        for(StudyActivities courseECTS: courses){
            ECTSsum+=courseECTS.ects;
        }
        if(!(projectName[0] ==null)){
            ECTSsum+=15;
        }
        return ECTSsum;
   }
}
