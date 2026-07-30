package org.apache.zookeeper.server.snapshotcomparer.variant_c0.randoop.afterfacade;

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
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test501");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) (byte) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test502() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test502");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test503() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test503");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test504() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test504");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test505() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test505");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, (int) (short) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test506() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test506");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) -1, 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test507() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test507");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) '#', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test508() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test508");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (-1), false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test509() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test509");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', (int) (short) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test510() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test510");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test511() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test511");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) (byte) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test512() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test512");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test513() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test513");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) '4', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test514() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test514");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 100, (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test515() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test515");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test516() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test516");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, (int) '4');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test517() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test517");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (short) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test518() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test518");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) (short) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test519() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test519");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) (short) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test520() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test520");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) (byte) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test521() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test521");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, (int) (byte) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test522() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test522");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (short) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test523() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test523");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, (int) (short) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test524() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test524");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test525() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test525");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test526() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test526");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) 'a', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test527() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test527");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) (short) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test528() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test528");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (short) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test529() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test529");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) (short) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test530() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test530");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', (int) (byte) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test531() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test531");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) (short) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test532() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test532");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) (short) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test533() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest1.test533");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) 'a', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }
}

