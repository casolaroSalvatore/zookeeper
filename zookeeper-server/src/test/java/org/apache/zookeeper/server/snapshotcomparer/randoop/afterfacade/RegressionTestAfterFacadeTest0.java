package org.apache.zookeeper.server.snapshotcomparer.randoop.afterfacade;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTestAfterFacadeTest0 {

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
    public void test001() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test001");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.pathOnlyInRightIsReported();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test002");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.missingSnapshotFailsLoading();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test003");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.byteThresholdEqualToDeltaFiltersPayloadDelta();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test004");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.samePhysicalFileProducesNoDelta();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test005");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.ephemeralNodesAreIgnored();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test006");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.interactiveDepthBelowMinimumPrintsRangeError();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test007");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.byteThresholdAboveDeltaFiltersPayloadDelta();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test008");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.samePathsDifferentPayloadIsReported();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test009");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.byteThresholdBelowDeltaReportsPayloadDelta();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test010");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.corruptedSnapshotFailsDeserialization();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test011");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.pathOnlyInLeftIsReported();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test012");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.duplicateLeftFlagHasControlledBehavior();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test013");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.gzSnapshotIsSupported();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test014");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.nodeThresholdAboveDeltaFiltersParentDelta();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test015");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.differentFilesSameTreeProducesNoDelta();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test016");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.integerOverflowIsRejected();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test017");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareBaselineFindsRightOnlyNode();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test018");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) '4', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test019");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.nodeThresholdEqualToDeltaFiltersParentDelta();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test020");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.nodeThresholdBelowDeltaReportsParentDelta();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test021");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.flagWithoutArgumentFailsParsing();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test022");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.mixedDifferencesAreReported();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test023");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test024");
        Object obj0 = new Object();
        Class<?> wildcardClass1 = obj0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test025");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.interactiveInvalidAbsolutePathPrintsError();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test026");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.missingNodeThresholdIsRejected();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test027");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test028");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test029");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((-1), (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test030");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) -1, 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test031");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 10, (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test032");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test033");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test034");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 100, 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test035");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test036");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) -1, 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test037");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test038");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) (short) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test039");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) ' ', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test040");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test041");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test042");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) (byte) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test043");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test044");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) (byte) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test045");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test046");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (-1), true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test047");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) (byte) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test048");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (-1), false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test049");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 100, (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test050");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test051");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test052");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, (int) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test053");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) (byte) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test054");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, (int) (byte) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test055");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test056");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test057");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', (int) 'a', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test058");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '4', 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test059");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, (int) (byte) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test060");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) -1, 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test061");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test062");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) (byte) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test063");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test064");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test065");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test066");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test067");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) ' ', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test068");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test069");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test070");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) (byte) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test071");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test072");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) (short) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test073");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 10, (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test074");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((-1), (int) '4');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test075");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) (short) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test076");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) '4', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test077");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test078");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '4', (int) (short) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test079");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test080");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test081");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) (short) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test082");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) '#', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test083");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, (-1), true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test084");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, (-1), false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test085");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test086");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test087");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test088");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) (byte) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test089");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test090");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) '4', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test091");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) (byte) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test092");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) (short) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test093");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (-1), true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test094");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) (short) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test095");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) (byte) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test096");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) (short) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test097");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) '4');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test098");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test099");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test100");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test101");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, (int) (byte) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test102");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, (int) (byte) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test103");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test104");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) (byte) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test105");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test106");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 100, 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test107");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) (short) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test108");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 0, 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test109");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test110");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) (short) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test111");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test112");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test113");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test114");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test115");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) '4', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test116");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test117");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test118");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test119");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test120");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test121");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test122");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test123");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) -1, (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test124");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test125");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((-1), (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test126");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 100, (int) '4');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test127");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) '#', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test128");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) (byte) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test129");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test130");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, (int) (short) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test131");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, (int) (byte) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test132");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) '4', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test133");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test134");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test135");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test136");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test137");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 10, (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test138");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 0, 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test139");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test140");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '4', (int) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test141");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test142");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) (short) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test143");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) (short) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test144");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) (short) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test145");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (-1), true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test146");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) (short) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test147");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test148");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) (byte) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test149");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) '4', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test150");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test151");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) (byte) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test152");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test153");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test154");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, (int) (short) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test155");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test156");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) ' ', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test157");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test158");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 0, (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test159");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test160");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test161");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) '#', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test162");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) (short) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test163");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((-1), 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test164");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) (byte) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test165");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', (int) (short) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test166");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test167");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, (int) (short) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test168");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test169");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) '#', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test170");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test171");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test172");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test173");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) (byte) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test174");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test175");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((-1), (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test176");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (-1), true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test177");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) (byte) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test178");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test179");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) 'a', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test180");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, (int) (short) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test181");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, (int) (short) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test182");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) (short) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test183");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test184");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) (byte) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test185");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test186");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test187");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test188");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test189");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) (short) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test190");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test191");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) -1, (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test192");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) (byte) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test193");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test194");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test195");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test196");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', (int) (short) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test197");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) -1, (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test198");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) (short) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test199");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) '#', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test200");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test201");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 100, (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test202");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', (int) (short) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test203");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, (int) ' ', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test204");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 0, (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test205");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) (byte) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test206");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) (short) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test207");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test208");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test209");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test210");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test211");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) -1, (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test212");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) (byte) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test213");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((-1), 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test214");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (-1), false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test215");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test216");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) -1, (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test217");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, (int) (byte) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test218");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) (byte) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test219");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test220");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) (short) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test221");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test222");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) (short) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test223");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', (int) (short) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test224");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) (byte) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test225");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test226");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) -1, (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test227");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test228");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test229");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '4', (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test230");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, (int) (short) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test231");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, (int) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test232");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) (byte) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test233");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) (short) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test234");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test235");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test236");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test237");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) '4', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test238");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test239");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, (int) '4', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test240");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test241");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 0, (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test242");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, (int) (short) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test243");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (-1), true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test244");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) (byte) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test245");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test246");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (byte) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test247");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test248");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test249");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, (int) (short) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test250");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (-1), false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test251");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) (short) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test252");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, (int) (short) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test253");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) (short) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test254() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test254");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) 'a', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test255() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test255");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) -1, 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test256() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test256");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 100, (int) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test257() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test257");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, (int) (byte) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test258() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test258");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (byte) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test259() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test259");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test260() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test260");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) ' ', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test261() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test261");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 0, (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test262() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test262");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test263() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test263");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test264() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test264");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, (int) '#', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test265() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test265");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) (short) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test266() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test266");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test267() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test267");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (-1), true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test268() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test268");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) (byte) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test269() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test269");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '4', (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test270() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test270");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) (byte) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test271() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test271");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, (int) (short) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test272() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test272");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) -1, (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test273() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test273");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) (short) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test274() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test274");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) (short) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test275() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test275");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) ' ', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test276() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test276");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test277() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test277");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test278() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test278");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) (short) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test279() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test279");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) (byte) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test280() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test280");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) -1, (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test281() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test281");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test282() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test282");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) ' ', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test283() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test283");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) ' ', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test284() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test284");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test285() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test285");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', (int) (byte) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test286() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test286");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test287() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test287");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test288() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test288");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 10, 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test289() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test289");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) (byte) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test290() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test290");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test291() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test291");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test292() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test292");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test293() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test293");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) ' ', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test294() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test294");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, (int) (short) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test295() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test295");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', (int) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test296() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test296");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) (byte) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test297() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test297");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, (int) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test298() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test298");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test299() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test299");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test300() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test300");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test301() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test301");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) 'a', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test302() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test302");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test303() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test303");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test304() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test304");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, (int) (short) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test305() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test305");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test306() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test306");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test307() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test307");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test308() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test308");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, (int) '4');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test309() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test309");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (short) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test310() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test310");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test311() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test311");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test312() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test312");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) (byte) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test313() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test313");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test314() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test314");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) '#', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test315() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test315");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) 'a', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test316() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test316");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((-1), (int) (short) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test317() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test317");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '4', (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test318() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test318");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) '#', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test319() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test319");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) (short) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test320() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test320");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) (short) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test321() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test321");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) (short) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test322() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test322");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, (int) (byte) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test323() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test323");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) (short) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test324() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test324");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) (byte) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test325() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test325");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test326() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test326");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test327() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test327");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', (int) '4');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test328() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test328");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) (byte) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test329() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test329");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) (short) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test330() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test330");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test331() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test331");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test332() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test332");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test333() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test333");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test334() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test334");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test335() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test335");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) (byte) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test336() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test336");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test337() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test337");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test338() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test338");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 100, (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test339() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test339");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test340() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test340");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) -1, (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test341() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test341");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 0, (int) '4');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test342() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test342");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) (short) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test343() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test343");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, (int) (short) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test344() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test344");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '4', (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test345() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test345");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test346() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test346");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) (byte) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test347() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test347");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) -1, (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test348() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test348");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test349() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test349");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, (int) 'a', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test350() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test350");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test351() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test351");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) (short) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test352() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test352");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test353() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test353");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 10, (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test354() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test354");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 10, (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test355() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test355");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test356() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test356");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test357() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test357");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) (short) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test358() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test358");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) (byte) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test359() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test359");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test360() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test360");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test361() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test361");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, (int) ' ', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test362() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test362");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) (byte) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test363() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test363");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test364() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test364");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) '#', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test365() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test365");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test366() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test366");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, (int) 'a', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test367() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test367");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) -1, 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test368() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test368");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, (-1), false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test369() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test369");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, (int) (byte) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test370() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test370");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) (byte) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test371() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test371");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) '#', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test372() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test372");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', (int) (short) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test373() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test373");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) '4', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test374() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test374");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) (byte) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test375() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test375");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, (int) (short) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test376() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test376");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) (short) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test377() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test377");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (-1), false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test378() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test378");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) -1, (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test379() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test379");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test380() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test380");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) (short) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test381() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test381");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test382() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test382");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test383() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test383");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) (byte) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test384() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test384");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) '4', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test385() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test385");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test386() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test386");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) ' ', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test387() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test387");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, (int) (short) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test388() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test388");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) 'a', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test389() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test389");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test390() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test390");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', (int) (byte) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test391() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test391");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test392() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test392");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) '#', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test393() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test393");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test394() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test394");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test395() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test395");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 100, (int) (short) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test396() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test396");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (short) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test397() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test397");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test398() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test398");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) (short) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test399() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test399");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) (byte) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test400() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test400");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) (byte) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test401() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test401");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, (int) (short) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test402() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test402");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test403() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test403");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) -1, (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test404() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test404");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', (int) '4', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test405() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test405");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test406() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test406");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) (short) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test407() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test407");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 10, (int) (short) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test408() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test408");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test409() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test409");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test410() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test410");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) (short) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test411() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test411");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test412() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test412");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test413() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test413");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) ' ', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test414() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test414");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test415() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test415");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (byte) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test416() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test416");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (-1), true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test417() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test417");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, (int) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test418() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test418");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, (int) (byte) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test419() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test419");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, (int) '4');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test420() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test420");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test421() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test421");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) '4', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test422() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test422");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 10, (int) (short) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test423() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test423");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', (int) (byte) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test424() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test424");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', (int) '#', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test425() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test425");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 100, (int) (short) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test426() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test426");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 100, (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test427() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test427");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) -1, (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test428() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test428");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, (int) '4');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test429() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test429");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) -1, (int) (byte) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test430() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test430");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (-1), false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test431() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test431");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) (short) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test432() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test432");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test433() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test433");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) (short) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test434() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test434");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) (byte) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test435() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test435");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, (int) 'a', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test436() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test436");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) (short) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test437() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test437");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, (int) (short) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test438() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test438");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test439() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test439");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, (int) '4');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test440() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test440");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, (int) (short) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test441() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test441");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', (-1), true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test442() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test442");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test443() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test443");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) -1, 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test444() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test444");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((-1), (int) (byte) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test445() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test445");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test446() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test446");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) '#', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test447() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test447");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test448() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test448");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) '#', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test449() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test449");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (byte) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test450() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test450");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) (byte) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test451() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test451");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) 'a', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test452() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test452");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (-1), true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test453() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test453");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test454() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test454");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) (byte) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test455() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test455");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test456() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test456");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test457() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test457");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) (byte) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test458() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test458");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', (int) ' ', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test459() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test459");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) ' ', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test460() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test460");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 10, (int) '4');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test461() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test461");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) 'a', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test462() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test462");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) (byte) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test463() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test463");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test464() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test464");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 10, (int) (byte) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test465() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test465");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) (byte) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test466() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test466");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test467() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test467");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) (short) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test468() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test468");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test469() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test469");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) (short) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test470() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test470");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, (int) (byte) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test471() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test471");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) (byte) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test472() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test472");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test473() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test473");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 10, (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test474() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test474");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test475() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test475");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test476() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test476");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (short) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test477() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test477");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) (short) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test478() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test478");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, (int) (byte) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test479() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test479");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test480() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test480");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test481() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test481");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', (int) 'a', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test482() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test482");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) 'a', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test483() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test483");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test484() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test484");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test485() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test485");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test486() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test486");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test487() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test487");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) (short) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test488() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test488");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) -1, (int) (short) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test489() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test489");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) ' ', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test490() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test490");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test491() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test491");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) (byte) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test492() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test492");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) '#', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test493() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test493");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((-1), (int) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test494() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test494");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test495() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test495");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test496() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test496");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) (short) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test497() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test497");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', (int) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test498() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test498");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test499() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test499");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test500() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerFacadeRandoopTest0.test500");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '4', (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }
}

