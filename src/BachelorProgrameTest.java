import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class BachelorProgrameTest {


    @Test
    public void isValidTestTrue(){
        BachelorProgramme Hum = new BachelorProgramme("Test");

        /*
        Hum.addActivity("TSA", 5, StudyActivities.ActivityType.Datalogi);
        Hum.addActivity("Basic bitch teori 102", 10, StudyActivities.ActivityType.Datalogi);

        Hum.addActivity("Analyse og implementering af for mange projekter i et bachelor program", StudyActivities.ActivityType.Informatik);
         */

        Hum.addActivity("STS", 10, StudyActivities.ActivityType.Datalogi);
        Hum.addActivity("Basic bitch teori 101", 10, StudyActivities.ActivityType.Datalogi);

        Hum.addActivity("Løg studier", 10, StudyActivities.ActivityType.GastronomiStudier);
        Hum.addActivity("Radikal radiseri", 5, StudyActivities.ActivityType.GastronomiStudier);
        Hum.addActivity("Zumba og zuccini", 10, StudyActivities.ActivityType.GastronomiStudier);

        Hum.addActivity("Meta meta Meta studier", 10, StudyActivities.ActivityType.Basis);
        Hum.addActivity("Basale bestandele af basilikum", 10, StudyActivities.ActivityType.Basis);
        Hum.addActivity("Basiske reaktioner i Baz Luhrmanns filmografi", 10, StudyActivities.ActivityType.Basis);
        Hum.addActivity("Banale basilisker begejstring for bananer", 10, StudyActivities.ActivityType.Basis);
        Hum.addActivity("Bagsiden af balaklavaen", 10, StudyActivities.ActivityType.Basis);


        Hum.addActivity("datalogiProjekt 1", StudyActivities.ActivityType.Datalogi );
        Hum.addActivity("Hvordan vælter man den danske regering?", StudyActivities.ActivityType.GastronomiStudier);
        Hum.addActivity("Komparativ analyse af 120 identiske McFlurries", StudyActivities.ActivityType.Bachelor);

        Hum.addActivity("Basics of basic", StudyActivities.ActivityType.Basis);
        Hum.addActivity("Rebranding af rygning (sponsoreret af J.P.Morgan)", StudyActivities.ActivityType.Basis);
        Hum.addActivity("Hvem har skidt i mine bukser?", StudyActivities.ActivityType.Basis);



        assertTrue(Hum.isValid());
    }
    @Test
    public void isValidTestFalse(){
        BachelorProgramme Hum = new BachelorProgramme("Test");

        assertFalse(Hum.isValid());
    }

    @Test
    public void subjectModuleTest(){
        BachelorProgramme Hum = new BachelorProgramme("Test");
        Course kursusTest = new Course("Test",10, StudyActivities.ActivityType.GastronomiStudier);
        Course kursusTest2 = new Course("Test",10, StudyActivities.ActivityType.GastronomiStudier);
        Course kursusTest3 = new Course("Test",10, StudyActivities.ActivityType.Informatik);
        Course kursusTest4 = new Course("Test",10, StudyActivities.ActivityType.Basis);
        Hum.addToModule(kursusTest);
        Hum.addToModule(kursusTest2);
        Hum.addToModule(kursusTest3);
        Hum.addToModule(kursusTest4);

        assertEquals(StudyActivities.ActivityType.GastronomiStudier.toString(),Hum.attachedModules[0].subjectModuleName);
        assertEquals(StudyActivities.ActivityType.Informatik.toString(),Hum.attachedModules[1].subjectModuleName);

    }


}
