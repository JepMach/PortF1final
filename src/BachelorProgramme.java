import java.util.ArrayList;
import java.util.Objects;

public class BachelorProgramme {

    String programmeName;
    int[] ECTS={5,10};
    final StudyActivities[] bachelorProject = new StudyActivities[1];
    ArrayList<Course> courses = new ArrayList<>();
    ArrayList<Project> projects = new ArrayList<>();
    final SubjectModule[] attachedModules = new SubjectModule[2];

    public BachelorProgramme(String programmeName){
        this.programmeName=programmeName;
    }

    public void printIsValid(){
        if(isValid()){
            System.out.println(this.programmeName+" is a valid programme");
        } else {
            System.out.println(this.programmeName+" does not fulfill the requirements of a valid bachelor programme");
        }
    }

    public boolean isValid(){
        try {
            for (SubjectModule attachedModule : this.attachedModules) {
                if (!attachedModule.moduleComplete) {
                    return false;
                }
            }
        } catch (NullPointerException n){
            return false;
        }
        return bachelorProject[0] != null &&
                this.getBasicNames(projects).size() >= 3 &&
                (this.getECTSSum()>=180) &&
                this.getBasisECTS(courses)>=40 && this.projects.size()==6;
    }

    public void addActivity(String name, int ects, StudyActivities.ActivityType module){
        int cEcts=0;
        for (int ect : ECTS) {
            if (ects == ect) {
                cEcts = ects;
                break;
            }
        }
        if(cEcts==0){
            System.out.println(ects+" is not a valid amount of ECTS for a course");
        } else {
            Course newCourse = new Course(name, cEcts, module);
            addToProgramme(newCourse);
        }
    }
    public void addActivity(String name, StudyActivities.ActivityType module){
        Project newProject = new Project(name,module);
        addToProgramme(newProject);
    }
    private void addToProgramme(Project project){
        if (getNames(this.projects).contains(project.name)) {
            System.out.println("Study activity is already part of this bachelor program");
            return;
        }

        if (this.projects.size() < 6) {
            switch (project.activityType) {
                case StudyActivities.ActivityType.Bachelor:
                    if (this.bachelorProject[0] == null) {
                        this.bachelorProject[0] = project;
                        this.projects.add(project);
                    } else {
                        System.out.println(project.name + " Cannot be added. This bachelor programme already contains a bachelor project");
                        System.out.println(" ");
                    }
                    break;

                case StudyActivities.ActivityType.Basis:
                    this.projects.add(project);
                    break;

                default:
                    addToModule(project);
                    break;
            }
        } else {
            System.out.println("This bachelor program already contains 6 projects");
        }

    }

    private void addToProgramme(Course course) {
        if (getNames(this.courses).contains(course.name)) {
            System.out.println("Study activity is already part of this bachelor program");
            return;
        } else {
            this.courses.add(course);
        }

        if (!(course.activityType == StudyActivities.ActivityType.Basis)) {
            addToModule(course);
            try{
                for (SubjectModule tModule: this.attachedModules) {
                    if (((tModule.getModuleECTS()-course.ects) >= 20 && Objects.equals(tModule.subjectModuleName, course.activityType.toString()))) {
                        for (Course t2Module: tModule.courses) {
                            if(t2Module.ects==5) {
                                t2Module.elective = true;
                                break;
                            } else {
                                course.elective = true;
                            }
                        }
                    }
                }
            } catch (NullPointerException ignored){
            }
        } else if (getBasisECTS(this.courses) >= 50) {
            course.elective = true;
        }
    }

    private  <T extends StudyActivities> void addToModule(T studyActivity) {
        try {
            for (SubjectModule modules : this.attachedModules) {
                addToModuleHelper(modules, studyActivity);
            }
        } catch(NullPointerException e){
                createModule(studyActivity);
        }
    }
    private <T extends StudyActivities> void addToModuleHelper(SubjectModule module, T activities){
        if (activities instanceof Course && Objects.equals(activities.activityType.toString(), module.subjectModuleName) && !getNames(module.courses).contains(activities.name)) {
            module.courses.add((Course) activities);
        }

        if (module.projectName[0] == null && activities instanceof Project && Objects.equals(module.subjectModuleName, activities.activityType.toString())) {
            module.projectName[0] = (Project) activities;
            this.projects.add((Project) activities);
        }

        if ( !(module.projectName[0] == null)) {
            if(module.getModuleECTS() >= 35) {
                module.moduleComplete = true;
            }
        }
    }

    private <T extends StudyActivities> void createModule(T activities){
        for(int i=0; i<this.attachedModules.length;i++){
            try {
                if (Objects.equals(this.attachedModules[i].subjectModuleName, activities.activityType.toString())) {
                    addToModuleHelper(this.attachedModules[i], activities);
                    return;
                }
            } catch (NullPointerException e){
                this.attachedModules[i] = new SubjectModule(activities.activityType);
                this.attachedModules[i].programme=this;
                addToModuleHelper(this.attachedModules[i], activities);
                return;
            }
        }
        System.out.println(activities.name+" cannot fit with this programmes subject modules");
    }

    private  int getECTSSum(){
        int ECTSSum=0;

        try {
            ECTSSum += getModuleECTS(this.attachedModules);
            ECTSSum+= bachelorProject[0].ects;
        }
        catch (NullPointerException ignored){
        }

        ECTSSum+=getBasisECTS(this.projects);
        ECTSSum+=getBasisECTS(this.courses);

        return ECTSSum;
    }

    private <T extends StudyActivities> int getBasisECTS (ArrayList<T> basicObj){
        int basisECTS=0;
        for(StudyActivities basics: basicObj){
            if(basics.activityType == StudyActivities.ActivityType.Basis){
                basisECTS+=basics.ects;
            }
        }
        return basisECTS;
    }

    private int getModuleECTS (SubjectModule[] modules){
        int moduleECTS=0;
        for(SubjectModule module: modules){
            moduleECTS+=module.getModuleECTS();
        }
        return moduleECTS;
    }

    private <T extends StudyActivities> ArrayList<String> getNames(ArrayList<T> courseObj){
        ArrayList<String> courseNames = new ArrayList<>();
        for(StudyActivities names: courseObj){
            courseNames.add(names.name);
        }
        return courseNames;
    }
    private ArrayList<String> getElectiveNames(){
        ArrayList<String> electiveNames = new ArrayList<>();
        for(Course courses: this.courses){
            if(courses.elective){
                electiveNames.add(courses.name);
            }
        }
        return electiveNames;
    }
    private <T extends StudyActivities>ArrayList<String> getBasicNames(ArrayList<T> basicObj){
        ArrayList<String> basicCourses = new ArrayList<>();
        for(StudyActivities basics: basicObj){
            if(basics.activityType == StudyActivities.ActivityType.Basis){
                basicCourses.add(basics.name);
            }
        }
        return basicCourses;
    }

    public  void printProgramme(){

        //Program
        System.out.println(" ");
        System.out.println(this.programmeName+": ");

        //Moduler
        System.out.println(" ");
        System.out.println("Moduler: ");
        System.out.println(" ");
        for(SubjectModule module: this.attachedModules){
            System.out.println(module.subjectModuleName);
            System.out.println("Projekt: "+module.projectName[0].name);
            System.out.println("Kurser: "+getNames(module.courses));
            System.out.println("Antal kurser: "+module.courses.size());
            System.out.println(" ");
        }

        //Kurser
        System.out.print("Basis kurser: ");
        System.out.println(getBasicNames(this.courses));
        System.out.println("Antal kurser: "+getBasicNames(this.courses).size());
        System.out.println("Ekstra kurser: "+getElectiveNames());

        //Projekter
        System.out.println(" ");
        System.out.print("Basis projekter: ");
        System.out.println(getBasicNames(this.projects));
        System.out.println("Antal basis projekter: "+getBasicNames(this.projects).size());
        System.out.println(" ");

        //ECTS
        System.out.println("Bahcelor projekt: "+this.bachelorProject[0].name);
        System.out.println(" ");
        System.out.println("ECTS fra bachelor projekt: "+this.bachelorProject[0].ects);
        System.out.println("ECTS fra modul kurser: "+this.getModuleECTS(this.attachedModules));
        System.out.println("ECTS fra basis projekter: "+this.getBasisECTS(projects));
        System.out.println("ECTS fra basis kurser: "+this.getBasisECTS(courses));
        System.out.println("ECTS i alt: "+this.getECTSSum());
        System.out.println(" ");
    }


}
