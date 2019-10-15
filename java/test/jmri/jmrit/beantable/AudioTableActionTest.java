package jmri.jmrit.beantable;

import jmri.Audio;
import jmri.util.JUnitUtil;
import jmri.util.junit.annotations.*;
import org.junit.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017	
 */
public class AudioTableActionTest extends AbstractTableActionBase<Audio> {

    @Test
    public void testCTor() {
        Assert.assertNotNull("exists",a);
    }

    @Override
    public String getTableFrameName(){
        return Bundle.getMessage("TitleAudioTable");
    }

    @Test
    @Override
    @Ignore("Audio table will only be init if an audio manager is available")
    @ToDo("Complete Test Initialization, then remove overriden test so parent class can execute")
    public void testGetTableDataModel(){
    }

    /**
     * Check the return value of getPanel.  The tested class provides a panel.
     */
    @Override
    @Test
    public void testGetPanel(){
         Assert.assertNotNull("AudioTableAction getPanel returns null",a.getPanel());
    }

    @Override
    @Test
    public void testGetClassDescription(){
         Assert.assertEquals("Turnout Table Action class description","Audio Table",a.getClassDescription());
    }

    /**
     * Check the return value of includeAddButton.  The table generated by 
     * this action includes an Add Button.
     */
    @Override
    @Test
    public void testIncludeAddButton(){
         Assert.assertTrue("Default include add button",a.includeAddButton());
    }

    @Test
    @Ignore("Audio table does not have Add... button")
    @Override
    public void testAddButton() {
    }

    @Override
    public String getAddFrameName(){
        return "";
    }

    @Test
    @Override
    @Ignore("Audio table does not have Add... button")
    public void testAddThroughDialog() {
    }

    @Test
    @Override
    @Ignore("Audio table does not have Add... button, so test needs re-written")
    @ToDo("Re-write parent class test to use the right name, or add without dialog")
    public void testEditButton() {
    }

    // The minimal setup for log4J
    @Before
    @Override
    public void setUp() {
        JUnitUtil.setUp();
        jmri.util.JUnitUtil.resetProfileManager();
        jmri.util.JUnitUtil.initDefaultUserMessagePreferences();
        helpTarget = "package.jmri.jmrit.beantable.AudioTable";
	    a = new AudioTableAction();
    }

    @After
    @Override
    public void tearDown() {
        jmri.util.JUnitAppender.suppressWarnMessage("Initialised Null audio system - no sounds will be available.");
        JUnitUtil.tearDown();
        a = null;
    }

    // private final static Logger log = LoggerFactory.getLogger(AudioTableActionTest.class);

}
