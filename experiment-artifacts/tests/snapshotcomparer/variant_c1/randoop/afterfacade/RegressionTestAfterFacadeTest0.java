package org.apache.zookeeper.server.snapshotcomparer.variant_c1.randoop.afterfacade;

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
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test001");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.pathOnlyInRightIsReported();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test002");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.missingSnapshotFailsLoading();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test003");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.byteThresholdEqualToDeltaFiltersPayloadDelta();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test004");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.samePhysicalFileProducesNoDelta();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test005");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.ephemeralNodesAreIgnored();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test006");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.interactiveDepthBelowMinimumPrintsRangeError();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test007");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.byteThresholdAboveDeltaFiltersPayloadDelta();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test008");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.samePathsDifferentPayloadIsReported();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test009");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.byteThresholdBelowDeltaReportsPayloadDelta();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test010");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.corruptedSnapshotFailsDeserialization();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test011");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.pathOnlyInLeftIsReported();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test012");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.duplicateLeftFlagHasControlledBehavior();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test013");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.gzSnapshotIsSupported();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test014");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.nodeThresholdAboveDeltaFiltersParentDelta();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test015");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.differentFilesSameTreeProducesNoDelta();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test016");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.integerOverflowIsRejected();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test017");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareBaselineFindsRightOnlyNode();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test018");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) '4', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test019");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.nodeThresholdEqualToDeltaFiltersParentDelta();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test020");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.nodeThresholdBelowDeltaReportsParentDelta();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test021");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.flagWithoutArgumentFailsParsing();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test022");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.mixedDifferencesAreReported();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test023");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test024");
        java.lang.Object obj0 = new java.lang.Object();
        java.lang.Class<?> wildcardClass1 = obj0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test025");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.interactiveInvalidAbsolutePathPrintsError();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test026");
        boolean boolean0 = org.apache.zookeeper.server.SnapshotComparerTestFacade.missingNodeThresholdIsRejected();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test027");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test028");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test029");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((-1), (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test030");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) -1, 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test031");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 10, (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test032");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test033");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test034");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 100, 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test035");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test036");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) -1, 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test037");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test038");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) (short) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test039");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) ' ', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test040");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test041");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test042");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) (byte) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test043");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test044");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) (byte) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test045");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test046");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (-1), true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test047");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) (byte) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test048");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (-1), false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test049");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 100, (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test050");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test051");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test052");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, (int) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test053");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) (byte) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test054");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, (int) (byte) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test055");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test056");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test057");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', (int) 'a', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test058");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '4', 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test059");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, (int) (byte) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test060");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) -1, 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test061");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test062");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) (byte) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test063");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test064");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test065");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test066");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test067");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) ' ', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test068");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test069");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test070");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) (byte) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test071");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test072");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) (short) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test073");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 10, (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test074");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((-1), (int) '4');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test075");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) (short) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test076");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) '4', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test077");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test078");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '4', (int) (short) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test079");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test080");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test081");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) (short) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test082");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) '#', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test083");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, (-1), true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test084");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, (-1), false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test085");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test086");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test087");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test088");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) (byte) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test089");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test090");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) '4', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test091");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) (byte) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test092");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) (short) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test093");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (-1), true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test094");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) (short) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test095");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) (byte) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test096");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) (short) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test097");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) '4');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test098");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test099");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test100");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test101");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, (int) (byte) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test102");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, (int) (byte) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test103");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test104");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) (byte) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test105");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test106");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 100, 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test107");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) (short) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test108");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 0, 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test109");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test110");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) (short) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test111");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test112");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test113");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test114");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test115");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) '4', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test116");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test117");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test118");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test119");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test120");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test121");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test122");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test123");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) -1, (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test124");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test125");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((-1), (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test126");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 100, (int) '4');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test127");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) '#', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test128");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) (byte) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test129");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test130");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, (int) (short) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test131");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, (int) (byte) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test132");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) '4', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test133");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test134");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test135");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test136");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test137");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 10, (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test138");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 0, 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test139");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test140");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '4', (int) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test141");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test142");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) (short) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test143");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) (short) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test144");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) (short) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test145");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (-1), true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test146");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) (short) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test147");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test148");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) (byte) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test149");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) '4', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test150");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test151");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) (byte) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test152");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test153");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test154");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, (int) (short) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test155");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test156");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (int) ' ', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test157");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test158");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 0, (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test159");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) 'a');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test160");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test161");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) '#', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test162");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) (short) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test163");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((-1), 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test164");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) (byte) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test165");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', (int) (short) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test166");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test167");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, (int) (short) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test168");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test169");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) '#', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test170");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test171");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test172");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test173");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) (byte) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test174");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test175");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((-1), (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test176");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (-1), true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test177");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) (byte) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test178");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test179");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) 'a', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test180");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, (int) (short) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test181");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, (int) (short) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test182");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) (short) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test183");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test184");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) 'a', (int) (byte) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test185");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test186");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test187");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test188");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test189");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) (short) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test190");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test191");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) -1, (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test192");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) (byte) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test193");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test194");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test195");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test196");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) 'a', (int) (short) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test197");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) -1, (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test198");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) (short) 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test199");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) '#', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test200");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test201");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 100, (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test202");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', (int) (short) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test203");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, (int) ' ', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test204");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 0, (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test205");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) (byte) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test206");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) (short) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test207");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test208");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test209");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test210");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test211");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) -1, (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test212");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) (byte) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test213");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((-1), 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test214");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (-1), false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test215");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test216");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) -1, (int) (short) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test217");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, (int) (byte) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test218");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 100, (int) (byte) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test219");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test220");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) (short) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test221");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) (byte) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test222");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) (short) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test223");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', (int) (short) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test224");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) (byte) 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test225");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test226");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) -1, (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test227");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test228");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test229");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '4', (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test230");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, (int) (short) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test231");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(100, (int) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test232");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((-1), (int) (byte) 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test233");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) (short) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test234");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test235");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, 100, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test236");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test237");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) '4', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test238");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test239");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, (int) '4', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test240");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test241");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 0, (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test242");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, (int) (short) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test243");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, (-1), true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test244");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) (byte) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test245");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, (int) '#');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test246");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (byte) 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test247");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test248");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test249");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, (int) (short) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test250");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (-1), false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test251");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) (short) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test252");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, (int) (short) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test253");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, (int) (short) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test254() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test254");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) 'a', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test255() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test255");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) -1, 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test256() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test256");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 100, (int) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test257() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test257");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, (int) (byte) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test258() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test258");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (byte) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test259() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test259");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 10, 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test260() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test260");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) ' ', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test261() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test261");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 0, (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test262() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test262");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test263() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test263");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test264() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test264");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 0, (int) '#', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test265() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test265");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) (short) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test266() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test266");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, (int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test267() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test267");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (-1), true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test268() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test268");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) (byte) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test269() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test269");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '4', (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test270() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test270");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, (int) (byte) 10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test271() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test271");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 100, (int) (short) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test272() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test272");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) -1, (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test273() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test273");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, (int) (short) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test274() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test274");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) (short) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test275() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test275");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) ' ', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test276() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test276");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(100, 1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test277() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test277");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', (int) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test278() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test278");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) 1, (int) (short) -1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test279() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test279");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) (byte) 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test280() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test280");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) -1, (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test281() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test281");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(10, (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test282() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test282");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '#', (int) ' ', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test283() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test283");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, (int) ' ', true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test284() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test284");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 0, (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test285() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test285");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) '4', (int) (byte) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test286() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test286");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(10, 1, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test287() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test287");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) '#', (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test288() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test288");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 10, 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test289() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test289");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) (byte) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test290() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test290");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, (int) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test291() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test291");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test292() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test292");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 10, 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test293() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test293");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) ' ', (int) ' ', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test294() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test294");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 1, (int) (short) 0, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test295() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test295");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) ' ', (int) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test296() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test296");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(1, (int) (byte) -1, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test297() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test297");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 10, (int) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test298() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test298");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test299() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test299");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test300() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test300");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) 0, 10, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test301() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test301");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (byte) -1, (int) 'a', false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test302() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test302");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal((int) (short) -1, 100, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test303() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test303");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 1, (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test304() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test304");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (short) 1, (int) (short) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test305() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test305");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(0, (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test306() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test306");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test307() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test307");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds((int) (byte) 100, (-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test308() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test308");
        boolean boolean2 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareMixedWithThresholds(1, (int) '4');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test309() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "SnapshotComparerc1FacadeRandoopTest0.test309");
        boolean boolean3 = org.apache.zookeeper.server.SnapshotComparerTestFacade.compareNominal(0, (int) (short) 0, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }
}



