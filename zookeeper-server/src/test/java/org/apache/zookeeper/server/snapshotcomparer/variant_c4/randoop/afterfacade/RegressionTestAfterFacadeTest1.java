package org.apache.zookeeper.server.snapshotcomparer.variant_c4.randoop.afterfacade;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTestAfterFacadeTest1 {

    public static boolean debug = false;

    public void assertBooleanArrayEquals(boolean[] expectedArray, boolean[] actualArray) {
        if (expectedArray.length != actualArray.length) {
            throw new AssertionError("Array lengths differ: " + expectedArray.length + " != " + actualArray.length);
        }
        for (int i = 0; i < expectedArray.length; i++) {
            if (expectedArray[i] != actualArray[i]) {
                throw new AssertionError("Arrays differ at index " + i + ": " + expectedArray[i] + " != " + actualArray[i]);
            }
        }
    }

    @Test
    public void test501() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test501");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) (byte) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test502() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test502");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test503() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test503");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test504() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test504");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test505() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test505");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, (int) (short) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test506() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test506");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) -1, 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test507() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test507");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) '#', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test508() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test508");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (-1), false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test509() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test509");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', (int) (short) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test510() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test510");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test511() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test511");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) (byte) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test512() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test512");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test513() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test513");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) '4', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test514() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test514");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 100, (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test515() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test515");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test516() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test516");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, (int) '4');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test517() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test517");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (short) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test518() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test518");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) (short) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test519() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test519");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) (short) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test520() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test520");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) (byte) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test521() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test521");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, (int) (byte) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test522() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test522");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (short) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test523() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test523");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, (int) (short) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test524() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test524");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test525() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test525");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test526() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test526");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) 'a', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test527() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test527");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) (short) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test528() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test528");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (short) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test529() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test529");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) (short) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test530() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test530");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', (int) (byte) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test531() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test531");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) (short) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test532() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test532");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) (short) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test533() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test533");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) 'a', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test534() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test534");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test535() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test535");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test536() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test536");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) -1, (int) (byte) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test537() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test537");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test538() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test538");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) (byte) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test539() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test539");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test540() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test540");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', (int) '4');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test541() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test541");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) '4', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test542() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test542");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) (short) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test543() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test543");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test544() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test544");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test545() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test545");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test546() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test546");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test547() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test547");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) ' ', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test548() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test548");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test549() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test549");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 100, 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test550() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test550");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (-1), true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test551() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test551");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) (short) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test552() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test552");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((-1), (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test553() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test553");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) (byte) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test554() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test554");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 10, 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test555() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test555");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) (short) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test556() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test556");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '4', (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test557() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test557");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, (int) (short) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test558() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test558");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (byte) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test559() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test559");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test560() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test560");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test561() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test561");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) (short) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test562() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test562");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test563() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test563");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test564() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test564");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) (short) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test565() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test565");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (-1), false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test566() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test566");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 0, 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test567() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test567");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test568() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test568");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test569() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test569");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, (int) (byte) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test570() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test570");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) (byte) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test571() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test571");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) -1, (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test572() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test572");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test573() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test573");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) (short) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test574() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test574");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) '#', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test575() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test575");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) (short) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test576() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test576");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) '4', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test577() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test577");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (byte) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test578() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test578");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test579() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test579");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, (int) (byte) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test580() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test580");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, (int) '4', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test581() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test581");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '4', (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test582() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test582");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test583() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test583");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) (short) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test584() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test584");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test585() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test585");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test586() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test586");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) ' ', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test587() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test587");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test588() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test588");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test589() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test589");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) (short) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test590() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test590");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) (short) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test591() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test591");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test592() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test592");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test593() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test593");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test594() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test594");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) (byte) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test595() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test595");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', (int) '4');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test596() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test596");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) (short) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test597() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test597");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, (int) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test598() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test598");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', (int) (short) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test599() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test599");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((-1), (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test600() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test600");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test601() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test601");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '4', 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test602() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test602");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, (int) (byte) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test603() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test603");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) (byte) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test604() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test604");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) 'a', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test605() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test605");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test606() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test606");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) (short) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test607() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test607");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test608() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test608");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, (int) (byte) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test609() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test609");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test610() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test610");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', (int) (short) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test611() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test611");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, (int) (short) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test612() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test612");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test613() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test613");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test614() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test614");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) 'a', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test615() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test615");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test616() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test616");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test617() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test617");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 100, (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test618() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test618");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test619() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test619");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test620() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test620");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) (short) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test621() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test621");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test622() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test622");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test623() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test623");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test624() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test624");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) (byte) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test625() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test625");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) -1, (int) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test626() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test626");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, (int) '4');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test627() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test627");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, (int) '#', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test628() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test628");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 0, (int) (short) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test629() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test629");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) (short) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test630() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test630");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) '#', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test631() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test631");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 10, 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test632() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test632");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test633() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test633");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) (short) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test634() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test634");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) (byte) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test635() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test635");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', (int) (byte) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test636() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test636");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test637() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test637");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test638() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test638");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) (short) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test639() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test639");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((-1), (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test640() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test640");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (-1), true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test641() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test641");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) '#', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test642() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test642");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test643() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test643");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) ' ', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test644() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test644");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) (short) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test645() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test645");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) (byte) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test646() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test646");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) (short) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test647() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test647");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test648() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test648");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, (int) (short) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test649() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test649");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (-1), false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test650() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test650");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test651() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test651");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test652() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test652");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (short) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test653() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test653");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test654() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test654");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', (int) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test655() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test655");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test656() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test656");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test657() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test657");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, (int) (short) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test658() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test658");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test659() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test659");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test660() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test660");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) (byte) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test661() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test661");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) (short) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test662() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test662");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) 'a', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test663() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test663");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) '4', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test664() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test664");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test665() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test665");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test666() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test666");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) (byte) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test667() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test667");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) (byte) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test668() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test668");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test669() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test669");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test670() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test670");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test671() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test671");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test672() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test672");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, (-1), true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test673() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test673");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test674() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test674");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test675() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test675");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (byte) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test676() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test676");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (-1), false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test677() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test677");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test678() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test678");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test679() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test679");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '4', (int) (byte) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test680() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test680");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, (int) (short) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test681() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test681");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', (int) (short) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test682() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test682");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) (byte) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test683() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test683");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) (short) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test684() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test684");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test685() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test685");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) (short) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test686() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test686");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, (int) (short) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test687() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test687");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, (int) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test688() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test688");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test689() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test689");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) ' ', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test690() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test690");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test691() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test691");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) (short) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test692() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test692");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) (short) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test693() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test693");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) (short) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test694() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test694");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test695() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test695");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) (short) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test696() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test696");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) (byte) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test697() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test697");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test698() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test698");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test699() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test699");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) 'a', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test700() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test700");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, (int) '#', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test701() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test701");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) 'a', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test702() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test702");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 0, (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test703() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test703");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test704() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test704");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test705() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test705");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) (byte) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test706() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test706");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) (byte) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test707() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test707");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) -1, (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test708() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test708");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) (byte) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test709() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test709");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test710() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test710");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 0, (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test711() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test711");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) (byte) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test712() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test712");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) '#', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test713() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test713");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) '4', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test714() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test714");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) (byte) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test715() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test715");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', (int) (byte) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test716() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test716");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) '4', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test717() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test717");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 10, (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test718() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test718");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 10, (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test719() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test719");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (byte) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test720() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test720");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', (int) (short) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test721() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test721");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, (int) 'a', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test722() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test722");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) (byte) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test723() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test723");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) ' ', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test724() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test724");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) 'a', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test725() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test725");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) (short) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test726() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test726");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (short) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test727() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test727");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test728() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test728");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) (byte) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test729() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test729");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, (int) (byte) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test730() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test730");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, (int) (short) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test731() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test731");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 0, (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test732() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test732");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test733() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test733");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, (int) (byte) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test734() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test734");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) -1, (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test735() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test735");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) '4', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test736() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test736");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test737() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test737");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test738() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test738");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) 'a', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test739() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test739");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 0, (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test740() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test740");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, (int) (byte) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test741() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test741");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) (byte) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test742() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test742");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) -1, (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test743() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test743");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) -1, (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test744() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test744");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, (int) (short) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test745() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test745");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, (int) (short) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test746() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test746");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) (byte) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test747() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test747");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test748() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test748");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test749() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test749");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((-1), (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test750() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test750");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test751() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test751");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) (short) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test752() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test752");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) 'a', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test753() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test753");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test754() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test754");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (-1), true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test755() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test755");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, (int) (byte) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test756() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test756");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '4', (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test757() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test757");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) '#', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test758() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test758");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) (byte) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test759() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test759");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) (short) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test760() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test760");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) (short) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test761() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test761");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test762() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test762");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) (short) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test763() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test763");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((-1), 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test764() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test764");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test765() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test765");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 0, (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test766() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test766");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) ' ', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test767() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test767");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test768() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test768");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) 'a', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test769() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test769");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) (byte) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test770() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test770");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) (short) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test771() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test771");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) (byte) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test772() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test772");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) '4', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test773() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test773");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) (byte) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test774() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test774");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test775() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test775");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) ' ', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test776() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test776");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) '4', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test777() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test777");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) (byte) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test778() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test778");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, (int) '4', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test779() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test779");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 0, (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test780() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test780");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) (byte) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test781() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test781");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 10, 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test782() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test782");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) (byte) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test783() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test783");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', (int) (byte) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test784() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test784");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) ' ', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test785() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test785");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) 'a', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test786() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test786");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((-1), (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test787() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test787");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) (byte) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test788() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test788");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) ' ', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test789() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test789");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '4', 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test790() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test790");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) (byte) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test791() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test791");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) -1, (int) '4');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test792() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test792");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) (short) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test793() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test793");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test794() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test794");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test795() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test795");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, (int) (short) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test796() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test796");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, (int) (byte) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test797() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test797");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 100, (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test798() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc4FacadeRandoopTest1.test798");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) (short) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }
}



