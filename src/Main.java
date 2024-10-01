public class Main {


    public static void main(String[] args) {


        BachelorProgramme Hum = new BachelorProgramme("HumTekBachelor");

        Hum.addActivity("TSA", 5, StudyActivities.ActivityType.Datalogi);
        Hum.addActivity("STS", 10, StudyActivities.ActivityType.Datalogi);
        Hum.addActivity("Løg studier", 5, StudyActivities.ActivityType.GastronomiStudier);
        Hum.addActivity("Radikal radiseri", 5, StudyActivities.ActivityType.GastronomiStudier);
        Hum.addActivity("Zumba og zuccini", 10, StudyActivities.ActivityType.GastronomiStudier);
        Hum.addActivity("Basic bitch teori 101", 10, StudyActivities.ActivityType.Datalogi);
        Hum.addActivity("Meta meta Meta studier", 10, StudyActivities.ActivityType.Basis);
        Hum.addActivity("Basic bitch teori 102", 10, StudyActivities.ActivityType.Datalogi);
        Hum.addActivity("Basale bestandele af basilikum", 10, StudyActivities.ActivityType.Basis);
        Hum.addActivity("Basiske reaktioner i Baz Luhrmanns filmografi", 10, StudyActivities.ActivityType.Basis);
        Hum.addActivity("Banale basilisker begejstring for bananer", 10, StudyActivities.ActivityType.Basis);
        Hum.addActivity("Bagsiden af balaklavaen", 10, StudyActivities.ActivityType.Basis);

        Hum.addActivity("datalogiProjekt 1", StudyActivities.ActivityType.Datalogi );
        Hum.addActivity("Basics of basic", StudyActivities.ActivityType.Basis);
        Hum.addActivity("Hvordan vælter man den danske regering?", StudyActivities.ActivityType.GastronomiStudier);
        Hum.addActivity("Rebranding af rygning (sponsoreret af J.P.Morgan)", StudyActivities.ActivityType.Basis);
        Hum.addActivity("Hvem har skidt i mine bukser?", StudyActivities.ActivityType.Basis);
        Hum.addActivity("Komparativ analyse af 120 identiske McFlurries", StudyActivities.ActivityType.Bachelor);
        Hum.addActivity("Analyse og implementering af for mange projekter i et bachelor program", StudyActivities.ActivityType.Informatik);

        Hum.printProgramme();
        Hum.printIsValid();




    }
}