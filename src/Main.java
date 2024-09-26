public class Main {



    public static void main(String[] args) {

        Course SMC2 = new Course("TSA", 10,false);

        Project datalogiProjekt = new Project("datalogiProjekt", 15, false, false);




        SubjectModule datalogi = new SubjectModule("datalogi");

        datalogi.addToModule(SMC2);
        datalogi.addToModule(datalogiProjekt);



        BachelorProgramme HumTektBA = new BachelorProgramme("HumTektBachelor");

        HumTektBA.addActivity(datalogi);

        HumTektBA.isValid(HumTektBA);

        System.out.println("kurser: "+datalogi.courseName+"- projekt navn: "+datalogiProjekt.name+" ECTS = "+
                (datalogi.subjectCourseEcts+datalogi.subjectProjectEcts));






    }
}