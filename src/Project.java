public class Project extends StudyActivities{

    boolean bachelor;

        public Project(String name, int ects, boolean basic, boolean bachelor){
            super(name,ects,basic);
            this.bachelor=bachelor;
        }
}
