package org.apache.zookeeper.server;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

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
    public void test01() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test01");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean0 = SnapshotComparerTestFacade.mixedDifferencesAreReported();
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: The Security Manager is deprecated and will be removed in a future release");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
    }

    @Test
    public void test02() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test02");
        boolean boolean0 = SnapshotComparerTestFacade.gzAssetExists();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test03() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test03");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean0 = SnapshotComparerTestFacade.duplicateLeftFlagTerminatesOrRunsDeterministically();
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: The Security Manager is deprecated and will be removed in a future release");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
    }

    @Test
    public void test04() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test04");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean0 = SnapshotComparerTestFacade.nodeThresholdBelowDeltaReportsParentDelta();
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: The Security Manager is deprecated and will be removed in a future release");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
    }

    @Test
    public void test05() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test05");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean0 = SnapshotComparerTestFacade.pathOnlyInRightIsReported();
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: The Security Manager is deprecated and will be removed in a future release");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
    }

    @Test
    public void test06() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test06");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean0 = SnapshotComparerTestFacade.byteThresholdEqualToDeltaFiltersPayloadDelta();
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: The Security Manager is deprecated and will be removed in a future release");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
    }

    @Test
    public void test07() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test07");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean0 = SnapshotComparerTestFacade.pathOnlyInLeftIsReported();
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: The Security Manager is deprecated and will be removed in a future release");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
    }

    @Test
    public void test08() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test08");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean0 = SnapshotComparerTestFacade.samePhysicalFileProducesNoDelta();
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: The Security Manager is deprecated and will be removed in a future release");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
    }

    @Test
    public void test09() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test09");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean0 = SnapshotComparerTestFacade.byteThresholdBelowDeltaReportsPayloadDelta();
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: The Security Manager is deprecated and will be removed in a future release");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
    }

    @Test
    public void test10() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test10");
        boolean boolean0 = SnapshotComparerTestFacade.gzSnapshotIsSupported();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test11() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test11");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean0 = SnapshotComparerTestFacade.byteThresholdAboveDeltaFiltersPayloadDelta();
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: The Security Manager is deprecated and will be removed in a future release");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
    }

    @Test
    public void test12() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test12");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean0 = SnapshotComparerTestFacade.differentFilesSameTreeProducesNoDelta();
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: The Security Manager is deprecated and will be removed in a future release");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
    }

    @Test
    public void test13() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test13");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean0 = SnapshotComparerTestFacade.samePathsDifferentPayloadIsReported();
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: The Security Manager is deprecated and will be removed in a future release");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
    }

    @Test
    public void test14() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test14");
        boolean boolean0 = SnapshotComparerTestFacade.requiredCoreAssetsExist();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test15() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test15");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean0 = SnapshotComparerTestFacade.integerOverflowIsRejected();
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: The Security Manager is deprecated and will be removed in a future release");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
    }

    @Test
    public void test16() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test16");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean0 = SnapshotComparerTestFacade.missingNodeThresholdIsRejected();
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: The Security Manager is deprecated and will be removed in a future release");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
    }

    @Test
    public void test17() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test17");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean0 = SnapshotComparerTestFacade.compareBaselineFindsRightOnlyNode();
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: The Security Manager is deprecated and will be removed in a future release");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
    }

    @Test
    public void test18() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test18");
        Object obj0 = new Object();
        Class<?> wildcardClass1 = obj0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test19() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test19");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean0 = SnapshotComparerTestFacade.nodeThresholdEqualToDeltaFiltersParentDelta();
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: The Security Manager is deprecated and will be removed in a future release");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
    }

    @Test
    public void test20() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test20");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean0 = SnapshotComparerTestFacade.nodeThresholdAboveDeltaFiltersParentDelta();
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: The Security Manager is deprecated and will be removed in a future release");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
    }
}

