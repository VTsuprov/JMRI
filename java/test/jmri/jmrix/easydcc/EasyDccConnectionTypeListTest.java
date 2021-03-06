package jmri.jmrix.easydcc;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class EasyDccConnectionTypeListTest {

    @Test
    public void testCTor() {
        EasyDccConnectionTypeList t = new EasyDccConnectionTypeList();
        Assert.assertNotNull("exists", t);
    }

    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
    }

    @AfterEach
    public void tearDown() {
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(EasyDccConnectionTypeListTest.class);

}
