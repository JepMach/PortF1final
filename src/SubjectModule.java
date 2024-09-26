import java.util.ArrayList;

public class SubjectModule {

    String moduleName;
    int courses;
    int subjectCourseEcts;
    int subjectProjectEcts;
    ArrayList<String> courseName = new ArrayList<>();
    ArrayList<String> electiveCourses = new ArrayList<>();
    String projectName=null;

    public SubjectModule(String moduleName){
      this.moduleName=moduleName;
    }

    public void addToModule(Course course){

            if (!courseName.contains(course.name)) {
                if (!course.basic) {
                    subjectCourseEcts = +course.ects;
                    courses = +1;
                    courseName.add(course.name);

                    if (subjectCourseEcts >= 20) {
                        electiveCourses.add(course.name);
                    }

                } else {
                    System.out.println("Course is too basic");
                }
            } else {
                System.out.println("The course is already part of the subject module");
            }
    }

    public void addToModule(Project project){
        if(!project.basic && projectName==null){
            subjectProjectEcts=+project.ects;
            projectName=project.name;

        }else if(project.basic){
            System.out.println("Project is too basic");
        } else {
            System.out.println("This subject module already has a project attached");
        }
    }
}
