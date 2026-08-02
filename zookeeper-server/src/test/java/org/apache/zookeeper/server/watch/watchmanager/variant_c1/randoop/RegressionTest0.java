package org.apache.zookeeper.server.watch.watchmanager.variant_c1.randoop;

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
    public void test001() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test001");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean10 = watchManager0.addWatch("", watcher8, watcherMode9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test002");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.Class<?> wildcardClass6 = watchesReport5.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test003");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean8 = watchManager0.addWatch("hi!", watcher6, watcherMode7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test004");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager12.triggerWatch("", eventType14, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet19);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet21 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = watchManager0.triggerWatch("null\n\t\n", eventType10, (long) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet21);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 7");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test005");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher.Event.EventType eventType6 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager8 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.data.ACL[] aCLArray12 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList13 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean14 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList13, aCLArray12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet15 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet16 = watchManager8.triggerWatch("", eventType10, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList13, watcherOrBitSet15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager0.triggerWatch("hi!", eventType6, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList13, watcherOrBitSet17);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(aCLArray12);
        org.junit.Assert.assertArrayEquals(aCLArray12, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNull(watcherOrBitSet16);
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test006");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean13 = watchManager0.addWatch("hi!", watcher11, watcherMode12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test007");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher5 = null;
        watchManager0.removeWatcher(watcher5);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test008");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("null\n\t\n", watcher3, watcherMode4);
        java.lang.Class<?> wildcardClass6 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test009");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport10 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test010");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary7 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean11 = watchManager0.addWatch("null\n\t\n", watcher9, watcherMode10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertNotNull(watchesSummary7);
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test011");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType8 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager10 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager10.triggerWatch("", eventType12, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("null\n\t\n", eventType8, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet19);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 7");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test012");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary7 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType9 = null;
        org.apache.zookeeper.data.ACL[] aCLArray11 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList12 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean13 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList12, aCLArray11);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet15 = watchManager0.triggerWatch("", eventType9, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList12, watcherOrBitSet14);
        org.apache.zookeeper.Watcher.Event.EventType eventType17 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager19 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType21 = null;
        org.apache.zookeeper.data.ACL[] aCLArray23 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList24 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean25 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList24, aCLArray23);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = watchManager19.triggerWatch("", eventType21, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList24, watcherOrBitSet26);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager0.triggerWatch("hi!", eventType17, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList24, watcherOrBitSet28);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertNotNull(watchesSummary7);
        org.junit.Assert.assertNotNull(aCLArray11);
        org.junit.Assert.assertArrayEquals(aCLArray11, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNull(watcherOrBitSet15);
        org.junit.Assert.assertNotNull(aCLArray23);
        org.junit.Assert.assertArrayEquals(aCLArray23, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNull(watcherOrBitSet27);
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test013");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.removeWatcher("", watcher14);
        java.lang.Class<?> wildcardClass16 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(wildcardClass16);
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test014");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("", watcher3);
        java.io.PrintWriter printWriter5 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter5, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.println(String)\" because \"writer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test015");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.removeWatcher("", watcher14);
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean19 = watchManager0.addWatch("null\n\t\n\tnull\n\t\n\n", watcher17, watcherMode18);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test016");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter13 = null;
        watchManager0.dumpWatches(printWriter13, true);
        java.lang.Class<?> wildcardClass16 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertNotNull(wildcardClass16);
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test017");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        java.lang.Class<?> wildcardClass10 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test018");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean13 = watchManager0.addWatch("", watcher11, watcherMode12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesPathReport9);
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test019");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter13 = null;
        watchManager0.dumpWatches(printWriter13, true);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport16 = watchManager0.getWatchesByPath();
        java.lang.Class<?> wildcardClass17 = watchesPathReport16.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertNotNull(watchesPathReport16);
        org.junit.Assert.assertNotNull(wildcardClass17);
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test020");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher10 = null;
        watchManager0.removeWatcher(watcher10);
        org.apache.zookeeper.Watcher watcher13 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode14 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean15 = watchManager0.addWatch("", watcher13, watcherMode14);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test021");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("", watcher3);
        java.io.PrintWriter printWriter5 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter5, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.print(String)\" because \"writer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test022");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("", watcher7, watcherMode8);
        int int10 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.containsWatcher("hi!", watcher12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean17 = watchManager0.addWatch("", watcher15, watcherMode16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test023");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("", watcher7, watcherMode8);
        int int10 = watchManager0.size();
        java.lang.Class<?> wildcardClass11 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test024");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test025");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.addWatch("null\n\t\n\tnull\n\t\n\n", watcher8);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertNotNull(watchesSummary10);
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test026");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean10 = watchManager0.addWatch("hi!", watcher8, watcherMode9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test027");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager13 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager13.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher20 = null;
        boolean boolean21 = watchManager18.addWatch("", watcher20);
        org.apache.zookeeper.Watcher watcher22 = null;
        watchManager18.removeWatcher(watcher22);
        java.lang.String str24 = watchManager18.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary25 = watchManager18.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.data.ACL[] aCLArray29 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList30 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList30, aCLArray29);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager18.triggerWatch("", eventType27, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30, watcherOrBitSet32);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager13.triggerWatch("", eventType16, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = watchManager0.triggerWatch("null\n\t\n", eventType11, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 7");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + true + "'", boolean21 == true);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "" + "'", str24, "");
        org.junit.Assert.assertNotNull(watchesSummary25);
        org.junit.Assert.assertNotNull(aCLArray29);
        org.junit.Assert.assertArrayEquals(aCLArray29, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertNull(watcherOrBitSet34);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test028");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        int int9 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 1 + "'", int9 == 1);
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test029");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean12 = watchManager0.addWatch("", watcher10, watcherMode11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test030");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher.Event.EventType eventType6 = null;
        java.util.List<org.apache.zookeeper.data.ACL> aCLList8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet10 = watchManager0.triggerWatch("null\n\t\n\tnull\n\t\n\n", eventType6, (long) '#', aCLList8, watcherOrBitSet9);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 16");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test031");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        int int12 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test032");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test033");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        java.lang.Class<?> wildcardClass7 = watchesReport6.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test034");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport10 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager14 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager14.addWatch("", watcher16);
        org.apache.zookeeper.Watcher watcher18 = null;
        watchManager14.removeWatcher(watcher18);
        java.lang.String str20 = watchManager14.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary21 = watchManager14.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType23 = null;
        org.apache.zookeeper.data.ACL[] aCLArray25 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList26 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean27 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList26, aCLArray25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager14.triggerWatch("", eventType23, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26, watcherOrBitSet28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager0.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26, watcherOrBitSet30);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Class<?> wildcardClass32 = watcherOrBitSet31.getClass();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "" + "'", str9, "");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "" + "'", str20, "");
        org.junit.Assert.assertNotNull(watchesSummary21);
        org.junit.Assert.assertNotNull(aCLArray25);
        org.junit.Assert.assertArrayEquals(aCLArray25, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNull(watcherOrBitSet29);
        org.junit.Assert.assertNull(watcherOrBitSet31);
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test035");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary7 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType9 = null;
        org.apache.zookeeper.data.ACL[] aCLArray11 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList12 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean13 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList12, aCLArray11);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet15 = watchManager0.triggerWatch("", eventType9, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList12, watcherOrBitSet14);
        org.apache.zookeeper.Watcher.Event.EventType eventType17 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager19 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager19.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher26 = null;
        boolean boolean27 = watchManager24.addWatch("", watcher26);
        org.apache.zookeeper.Watcher watcher28 = null;
        watchManager24.removeWatcher(watcher28);
        java.lang.String str30 = watchManager24.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary31 = watchManager24.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType33 = null;
        org.apache.zookeeper.data.ACL[] aCLArray35 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList36 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean37 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList36, aCLArray35);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet38 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = watchManager24.triggerWatch("", eventType33, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList36, watcherOrBitSet38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = watchManager19.triggerWatch("", eventType22, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList36);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager0.triggerWatch("null\n\t\n\tnull\n\t\n\n", eventType17, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList36, watcherOrBitSet41);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 16");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertNotNull(watchesSummary7);
        org.junit.Assert.assertNotNull(aCLArray11);
        org.junit.Assert.assertArrayEquals(aCLArray11, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNull(watcherOrBitSet15);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + true + "'", boolean27 == true);
        org.junit.Assert.assertEquals("'" + str30 + "' != '" + "" + "'", str30, "");
        org.junit.Assert.assertNotNull(watchesSummary31);
        org.junit.Assert.assertNotNull(aCLArray35);
        org.junit.Assert.assertArrayEquals(aCLArray35, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertNull(watcherOrBitSet39);
        org.junit.Assert.assertNull(watcherOrBitSet40);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test036");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("", watcher10);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport12 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test037");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("null\n\t\n", watcher3, watcherMode4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("null\n\t\n", watcher7, watcherMode8);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport10 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager14 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.data.ACL[] aCLArray18 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList19 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean20 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList19, aCLArray18);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet21 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = watchManager14.triggerWatch("", eventType16, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList19, watcherOrBitSet21);
        java.lang.String str23 = watchManager14.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport24 = watchManager14.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType26 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager28 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher30 = null;
        boolean boolean31 = watchManager28.addWatch("", watcher30);
        org.apache.zookeeper.Watcher watcher32 = null;
        watchManager28.removeWatcher(watcher32);
        java.lang.String str34 = watchManager28.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary35 = watchManager28.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType37 = null;
        org.apache.zookeeper.data.ACL[] aCLArray39 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList40 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean41 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList40, aCLArray39);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager28.triggerWatch("", eventType37, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList40, watcherOrBitSet42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = watchManager14.triggerWatch("", eventType26, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList40, watcherOrBitSet44);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet47 = watchManager0.triggerWatch("null\n\t\n", eventType12, (long) 'a', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList40, watcherOrBitSet46);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 7");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesPathReport10);
        org.junit.Assert.assertNotNull(aCLArray18);
        org.junit.Assert.assertArrayEquals(aCLArray18, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNull(watcherOrBitSet22);
        org.junit.Assert.assertEquals("'" + str23 + "' != '" + "" + "'", str23, "");
        org.junit.Assert.assertNotNull(watchesReport24);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + true + "'", boolean31 == true);
        org.junit.Assert.assertEquals("'" + str34 + "' != '" + "" + "'", str34, "");
        org.junit.Assert.assertNotNull(watchesSummary35);
        org.junit.Assert.assertNotNull(aCLArray39);
        org.junit.Assert.assertArrayEquals(aCLArray39, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertNull(watcherOrBitSet43);
        org.junit.Assert.assertNull(watcherOrBitSet45);
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test038");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("null\n\t\n", watcher3, watcherMode4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("null\n\t\n", watcher7, watcherMode8);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport10 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport11 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher.Event.EventType eventType13 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager15 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager15.addWatch("", watcher17);
        org.apache.zookeeper.Watcher watcher19 = null;
        watchManager15.removeWatcher(watcher19);
        java.lang.String str21 = watchManager15.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary22 = watchManager15.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.data.ACL[] aCLArray26 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList27 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean28 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList27, aCLArray26);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = watchManager15.triggerWatch("", eventType24, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList27, watcherOrBitSet29);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager0.triggerWatch("null\n\t\n", eventType13, (long) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList27);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 7");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesPathReport10);
        org.junit.Assert.assertNotNull(watchesPathReport11);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "" + "'", str21, "");
        org.junit.Assert.assertNotNull(watchesSummary22);
        org.junit.Assert.assertNotNull(aCLArray26);
        org.junit.Assert.assertArrayEquals(aCLArray26, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertNull(watcherOrBitSet30);
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test039");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter13 = null;
        watchManager0.dumpWatches(printWriter13, true);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport16 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.addWatch("", watcher18);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertNotNull(watchesPathReport16);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test040");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary7 = watchManager0.getWatchesSummary();
        java.lang.Class<?> wildcardClass8 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertNotNull(watchesSummary7);
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test041");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager0.removeWatcher("hi!", watcher15);
        org.apache.zookeeper.Watcher.Event.EventType eventType18 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager20 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher22 = null;
        boolean boolean23 = watchManager20.addWatch("", watcher22);
        org.apache.zookeeper.Watcher watcher24 = null;
        watchManager20.removeWatcher(watcher24);
        java.lang.String str26 = watchManager20.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary27 = watchManager20.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType29 = null;
        org.apache.zookeeper.data.ACL[] aCLArray31 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList32 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean33 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList32, aCLArray31);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = watchManager20.triggerWatch("", eventType29, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList32, watcherOrBitSet34);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet37 = watchManager0.triggerWatch("null\n\t\n", eventType18, (long) (byte) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList32, watcherOrBitSet36);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 7");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertEquals("'" + str26 + "' != '" + "" + "'", str26, "");
        org.junit.Assert.assertNotNull(watchesSummary27);
        org.junit.Assert.assertNotNull(aCLArray31);
        org.junit.Assert.assertArrayEquals(aCLArray31, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertNull(watcherOrBitSet35);
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test042");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.addWatch("null\n\t\n", watcher5);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test043");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager12.triggerWatch("", eventType14, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet19);
        java.lang.String str21 = watchManager12.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport22 = watchManager12.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager26 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher28 = null;
        boolean boolean29 = watchManager26.addWatch("", watcher28);
        org.apache.zookeeper.Watcher watcher30 = null;
        watchManager26.removeWatcher(watcher30);
        java.lang.String str32 = watchManager26.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary33 = watchManager26.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.data.ACL[] aCLArray37 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList38 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean39 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList38, aCLArray37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager26.triggerWatch("", eventType35, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager12.triggerWatch("", eventType24, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager0.triggerWatch("", eventType10, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38);
        org.apache.zookeeper.Watcher.Event.EventType eventType46 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager48 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType50 = null;
        org.apache.zookeeper.data.ACL[] aCLArray52 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList53 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean54 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList53, aCLArray52);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet55 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet56 = watchManager48.triggerWatch("", eventType50, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList53, watcherOrBitSet55);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet57 = watchManager0.triggerWatch("null\n\t\n\tnull\n\t\n\n", eventType46, (long) '#', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList53);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 16");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "" + "'", str21, "");
        org.junit.Assert.assertNotNull(watchesReport22);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + true + "'", boolean29 == true);
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "" + "'", str32, "");
        org.junit.Assert.assertNotNull(watchesSummary33);
        org.junit.Assert.assertNotNull(aCLArray37);
        org.junit.Assert.assertArrayEquals(aCLArray37, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNull(watcherOrBitSet41);
        org.junit.Assert.assertNull(watcherOrBitSet43);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertNotNull(aCLArray52);
        org.junit.Assert.assertArrayEquals(aCLArray52, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + false + "'", boolean54 == false);
        org.junit.Assert.assertNull(watcherOrBitSet56);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test044");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("null\n\t\n", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("null\n\t\n", watcher11);
        java.lang.Class<?> wildcardClass13 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(wildcardClass13);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test045");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType4 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager6 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        boolean boolean10 = watchManager6.containsWatcher("hi!", watcher8, watcherMode9);
        java.io.PrintWriter printWriter11 = null;
        watchManager6.dumpWatches(printWriter11, false);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager6.containsWatcher("hi!", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager6.containsWatcher("", watcher19);
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType26 = null;
        org.apache.zookeeper.data.ACL[] aCLArray28 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList29 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean30 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList29, aCLArray28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager24.triggerWatch("", eventType26, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList29, watcherOrBitSet31);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager6.triggerWatch("", eventType22, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList29);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = watchManager0.triggerWatch("hi!", eventType4, (long) (byte) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList29, watcherOrBitSet34);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(aCLArray28);
        org.junit.Assert.assertArrayEquals(aCLArray28, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertNull(watcherOrBitSet32);
        org.junit.Assert.assertNull(watcherOrBitSet33);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test046");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        java.lang.Class<?> wildcardClass18 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNotNull(wildcardClass18);
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test047");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("hi!", watcher3, watcherMode4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = watchManager0.addWatch("hi!", watcher7, watcherMode8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test048");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary7 = watchManager0.getWatchesSummary();
        int int8 = watchManager0.size();
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        boolean boolean16 = watchManager12.containsWatcher("hi!", watcher14, watcherMode15);
        java.io.PrintWriter printWriter17 = null;
        watchManager12.dumpWatches(printWriter17, false);
        org.apache.zookeeper.Watcher watcher21 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode22 = null;
        boolean boolean23 = watchManager12.containsWatcher("hi!", watcher21, watcherMode22);
        org.apache.zookeeper.Watcher watcher25 = null;
        boolean boolean26 = watchManager12.containsWatcher("", watcher25);
        org.apache.zookeeper.Watcher.Event.EventType eventType28 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager30 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType32 = null;
        org.apache.zookeeper.data.ACL[] aCLArray34 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList35 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean36 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList35, aCLArray34);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet37 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet38 = watchManager30.triggerWatch("", eventType32, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList35, watcherOrBitSet37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = watchManager12.triggerWatch("", eventType28, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList35);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = watchManager0.triggerWatch("null\n\t\n", eventType10, (long) (short) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList35);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 7");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertNotNull(watchesSummary7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertNotNull(aCLArray34);
        org.junit.Assert.assertArrayEquals(aCLArray34, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertNull(watcherOrBitSet38);
        org.junit.Assert.assertNull(watcherOrBitSet39);
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test049");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("", watcher13);
        java.lang.Class<?> wildcardClass15 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(wildcardClass15);
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test050");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.containsWatcher("hi!", watcher16);
        org.apache.zookeeper.Watcher.Event.EventType eventType19 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager21 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher23 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode24 = null;
        boolean boolean25 = watchManager21.containsWatcher("hi!", watcher23, watcherMode24);
        java.io.PrintWriter printWriter26 = null;
        watchManager21.dumpWatches(printWriter26, false);
        org.apache.zookeeper.Watcher watcher30 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode31 = null;
        boolean boolean32 = watchManager21.containsWatcher("hi!", watcher30, watcherMode31);
        org.apache.zookeeper.Watcher watcher34 = null;
        boolean boolean35 = watchManager21.containsWatcher("", watcher34);
        org.apache.zookeeper.Watcher.Event.EventType eventType37 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager39 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType41 = null;
        org.apache.zookeeper.data.ACL[] aCLArray43 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList44 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean45 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList44, aCLArray43);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet47 = watchManager39.triggerWatch("", eventType41, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList44, watcherOrBitSet46);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet48 = watchManager21.triggerWatch("", eventType37, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList44);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet49 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet50 = watchManager0.triggerWatch("null\n\t\n", eventType19, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList44, watcherOrBitSet49);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 7");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertNotNull(aCLArray43);
        org.junit.Assert.assertArrayEquals(aCLArray43, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
        org.junit.Assert.assertNull(watcherOrBitSet47);
        org.junit.Assert.assertNull(watcherOrBitSet48);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test051");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        java.io.PrintWriter printWriter10 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter10, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.println(String)\" because \"writer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(watchesSummary9);
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test052");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher4);
        int int6 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType9 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager11 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher13 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode14 = null;
        boolean boolean15 = watchManager11.containsWatcher("hi!", watcher13, watcherMode14);
        java.io.PrintWriter printWriter16 = null;
        watchManager11.dumpWatches(printWriter16, false);
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        boolean boolean22 = watchManager11.containsWatcher("hi!", watcher20, watcherMode21);
        org.apache.zookeeper.Watcher watcher24 = null;
        boolean boolean25 = watchManager11.containsWatcher("", watcher24);
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager29 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType31 = null;
        org.apache.zookeeper.data.ACL[] aCLArray33 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList34 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean35 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList34, aCLArray33);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet37 = watchManager29.triggerWatch("", eventType31, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList34, watcherOrBitSet36);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet38 = watchManager11.triggerWatch("", eventType27, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList34);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = watchManager0.triggerWatch("hi!", eventType9, (long) '#', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList34, watcherOrBitSet39);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(aCLArray33);
        org.junit.Assert.assertArrayEquals(aCLArray33, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertNull(watcherOrBitSet37);
        org.junit.Assert.assertNull(watcherOrBitSet38);
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test053");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.addWatch("null\n\t\n", watcher5);
        java.lang.String str7 = watchManager0.toString();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager12.triggerWatch("", eventType14, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet19);
        org.apache.zookeeper.Watcher watcher22 = null;
        boolean boolean23 = watchManager12.addWatch("null\n\t\n", watcher22);
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.data.ACL[] aCLArray27 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList28 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean29 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList28, aCLArray27);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = watchManager12.triggerWatch("", eventType25, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager0.triggerWatch("hi!", eventType10, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "null\n\t\n\tnull\n\t\n\n" + "'", str7, "null\n\t\n\tnull\n\t\n\n");
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertNotNull(aCLArray27);
        org.junit.Assert.assertArrayEquals(aCLArray27, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNull(watcherOrBitSet30);
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test054");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("null\n\t\n", watcher10, watcherMode11);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test055");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter13 = null;
        watchManager0.dumpWatches(printWriter13, true);
        java.lang.String str16 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean20 = watchManager0.addWatch("", watcher18, watcherMode19);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "" + "'", str16, "");
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test056");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("", watcher13);
        java.io.PrintWriter printWriter15 = null;
        watchManager0.dumpWatches(printWriter15, true);
        java.lang.String str18 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "" + "'", str18, "");
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test057");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.removeWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher14 = null;
        watchManager0.removeWatcher(watcher14);
        org.apache.zookeeper.Watcher.Event.EventType eventType17 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager19 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher21 = null;
        boolean boolean22 = watchManager19.addWatch("", watcher21);
        org.apache.zookeeper.Watcher watcher23 = null;
        watchManager19.removeWatcher(watcher23);
        java.lang.String str25 = watchManager19.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary26 = watchManager19.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType28 = null;
        org.apache.zookeeper.data.ACL[] aCLArray30 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList31 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean32 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList31, aCLArray30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager19.triggerWatch("", eventType28, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList31, watcherOrBitSet33);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = watchManager0.triggerWatch("null\n\t\n\tnull\n\t\n\n", eventType17, (long) (short) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList31);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 16");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "" + "'", str9, "");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
        org.junit.Assert.assertEquals("'" + str25 + "' != '" + "" + "'", str25, "");
        org.junit.Assert.assertNotNull(watchesSummary26);
        org.junit.Assert.assertNotNull(aCLArray30);
        org.junit.Assert.assertArrayEquals(aCLArray30, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNull(watcherOrBitSet34);
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test058");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport7 = watchManager0.getWatchesByPath();
        java.lang.Class<?> wildcardClass8 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesPathReport7);
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test059");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.removeWatcher("hi!", watcher13);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport15 = watchManager0.getWatches();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(watchesReport15);
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test060");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager12.triggerWatch("", eventType14, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet19);
        java.lang.String str21 = watchManager12.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport22 = watchManager12.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager26 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher28 = null;
        boolean boolean29 = watchManager26.addWatch("", watcher28);
        org.apache.zookeeper.Watcher watcher30 = null;
        watchManager26.removeWatcher(watcher30);
        java.lang.String str32 = watchManager26.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary33 = watchManager26.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.data.ACL[] aCLArray37 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList38 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean39 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList38, aCLArray37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager26.triggerWatch("", eventType35, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager12.triggerWatch("", eventType24, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager0.triggerWatch("", eventType10, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher47 = null;
        boolean boolean48 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher47);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary49 = watchManager0.getWatchesSummary();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport50 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "" + "'", str21, "");
        org.junit.Assert.assertNotNull(watchesReport22);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + true + "'", boolean29 == true);
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "" + "'", str32, "");
        org.junit.Assert.assertNotNull(watchesSummary33);
        org.junit.Assert.assertNotNull(aCLArray37);
        org.junit.Assert.assertArrayEquals(aCLArray37, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNull(watcherOrBitSet41);
        org.junit.Assert.assertNull(watcherOrBitSet43);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + false + "'", boolean48 == false);
        org.junit.Assert.assertNotNull(watchesSummary49);
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test061");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean12 = watchManager0.addWatch("null\n\t\n\tnull\n\t\n\n", watcher10, watcherMode11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test062");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType8 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager10 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager10.triggerWatch("", eventType12, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        java.lang.String str19 = watchManager10.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport20 = watchManager10.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher26 = null;
        boolean boolean27 = watchManager24.addWatch("", watcher26);
        org.apache.zookeeper.Watcher watcher28 = null;
        watchManager24.removeWatcher(watcher28);
        java.lang.String str30 = watchManager24.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary31 = watchManager24.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType33 = null;
        org.apache.zookeeper.data.ACL[] aCLArray35 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList36 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean37 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList36, aCLArray35);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet38 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = watchManager24.triggerWatch("", eventType33, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList36, watcherOrBitSet38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager10.triggerWatch("", eventType22, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList36, watcherOrBitSet40);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager0.triggerWatch("null\n\t\n\tnull\n\t\n\n", eventType8, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList36);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 16");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "" + "'", str19, "");
        org.junit.Assert.assertNotNull(watchesReport20);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + true + "'", boolean27 == true);
        org.junit.Assert.assertEquals("'" + str30 + "' != '" + "" + "'", str30, "");
        org.junit.Assert.assertNotNull(watchesSummary31);
        org.junit.Assert.assertNotNull(aCLArray35);
        org.junit.Assert.assertArrayEquals(aCLArray35, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertNull(watcherOrBitSet39);
        org.junit.Assert.assertNull(watcherOrBitSet41);
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test063");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport2 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        org.apache.zookeeper.Watcher.Event.EventType eventType6 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager8 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager8.containsWatcher("hi!", watcher10, watcherMode11);
        java.io.PrintWriter printWriter13 = null;
        watchManager8.dumpWatches(printWriter13, false);
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        boolean boolean19 = watchManager8.containsWatcher("hi!", watcher17, watcherMode18);
        org.apache.zookeeper.Watcher watcher21 = null;
        boolean boolean22 = watchManager8.containsWatcher("", watcher21);
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager26 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType28 = null;
        org.apache.zookeeper.data.ACL[] aCLArray30 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList31 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean32 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList31, aCLArray30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager26.triggerWatch("", eventType28, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList31, watcherOrBitSet33);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = watchManager8.triggerWatch("", eventType24, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList31);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet37 = watchManager0.triggerWatch("null\n\t\n\tnull\n\t\n\n", eventType6, (long) '#', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList31, watcherOrBitSet36);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 16");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertNotNull(watchesPathReport2);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(aCLArray30);
        org.junit.Assert.assertArrayEquals(aCLArray30, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNull(watcherOrBitSet34);
        org.junit.Assert.assertNull(watcherOrBitSet35);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test064");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("null\n\t\n", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean13 = watchManager0.addWatch("", watcher11, watcherMode12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test065");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.removeWatcher("", watcher14);
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.containsWatcher("null\n\t\n", watcher17);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary19 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNotNull(watchesSummary19);
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test066");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("", watcher11);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport13 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test067");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("", watcher3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport9 = watchManager0.getWatches();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "null\n\t\n" + "'", str5, "null\n\t\n");
        org.junit.Assert.assertNotNull(watchesReport9);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test068");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("", watcher7, watcherMode8);
        int int10 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher12 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode13 = null;
        boolean boolean14 = watchManager0.containsWatcher("hi!", watcher12, watcherMode13);
        java.io.PrintWriter printWriter15 = null;
        watchManager0.dumpWatches(printWriter15, false);
        java.lang.Class<?> wildcardClass18 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(wildcardClass18);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test069");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager17 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport18 = watchManager17.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher20 = null;
        boolean boolean21 = watchManager17.addWatch("hi!", watcher20);
        org.apache.zookeeper.Watcher watcher23 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode24 = null;
        boolean boolean25 = watchManager17.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher23, watcherMode24);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary26 = watchManager17.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType28 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager30 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType32 = null;
        org.apache.zookeeper.data.ACL[] aCLArray34 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList35 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean36 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList35, aCLArray34);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet37 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet38 = watchManager30.triggerWatch("", eventType32, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList35, watcherOrBitSet37);
        java.lang.String str39 = watchManager30.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport40 = watchManager30.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType42 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager44 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher46 = null;
        boolean boolean47 = watchManager44.addWatch("", watcher46);
        org.apache.zookeeper.Watcher watcher48 = null;
        watchManager44.removeWatcher(watcher48);
        java.lang.String str50 = watchManager44.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary51 = watchManager44.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType53 = null;
        org.apache.zookeeper.data.ACL[] aCLArray55 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList56 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean57 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList56, aCLArray55);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet58 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet59 = watchManager44.triggerWatch("", eventType53, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList56, watcherOrBitSet58);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet60 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet61 = watchManager30.triggerWatch("", eventType42, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList56, watcherOrBitSet60);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet62 = watchManager17.triggerWatch("", eventType28, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList56);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet63 = watchManager0.triggerWatch("null\n\t\n\tnull\n\t\n\n", eventType15, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList56);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 16");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesPathReport18);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + true + "'", boolean21 == true);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(watchesSummary26);
        org.junit.Assert.assertNotNull(aCLArray34);
        org.junit.Assert.assertArrayEquals(aCLArray34, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertNull(watcherOrBitSet38);
        org.junit.Assert.assertEquals("'" + str39 + "' != '" + "" + "'", str39, "");
        org.junit.Assert.assertNotNull(watchesReport40);
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + true + "'", boolean47 == true);
        org.junit.Assert.assertEquals("'" + str50 + "' != '" + "" + "'", str50, "");
        org.junit.Assert.assertNotNull(watchesSummary51);
        org.junit.Assert.assertNotNull(aCLArray55);
        org.junit.Assert.assertArrayEquals(aCLArray55, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + false + "'", boolean57 == false);
        org.junit.Assert.assertNull(watcherOrBitSet59);
        org.junit.Assert.assertNull(watcherOrBitSet61);
        org.junit.Assert.assertNull(watcherOrBitSet62);
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test070");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager5.addWatch("", watcher7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager5.removeWatcher(watcher9);
        java.lang.String str11 = watchManager5.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary12 = watchManager5.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager5.triggerWatch("", eventType14, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet19);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet21 = watchManager0.triggerWatch("", eventType3, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17);
        org.apache.zookeeper.Watcher watcher23 = null;
        boolean boolean24 = watchManager0.containsWatcher("hi!", watcher23);
        org.apache.zookeeper.Watcher.Event.EventType eventType26 = null;
        org.apache.zookeeper.data.ACL[] aCLArray28 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList29 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean30 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList29, aCLArray28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager0.triggerWatch("null\n\t\n\tnull\n\t\n\n", eventType26, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList29, watcherOrBitSet31);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 16");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "" + "'", str11, "");
        org.junit.Assert.assertNotNull(watchesSummary12);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNull(watcherOrBitSet21);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNotNull(aCLArray28);
        org.junit.Assert.assertArrayEquals(aCLArray28, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test071");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("null\n\t\n", watcher3, watcherMode4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("null\n\t\n", watcher7, watcherMode8);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport10 = watchManager0.getWatchesByPath();
        java.lang.Class<?> wildcardClass11 = watchesPathReport10.getClass();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesPathReport10);
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test072");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("null\n\t\n", watcher2, watcherMode3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test073");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        java.lang.Class<?> wildcardClass5 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test074");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher4);
        int int6 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType9 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager11 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType13 = null;
        org.apache.zookeeper.data.ACL[] aCLArray15 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList16 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean17 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList16, aCLArray15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager11.triggerWatch("", eventType13, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList16, watcherOrBitSet18);
        java.lang.String str20 = watchManager11.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport21 = watchManager11.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType23 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager25 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher27 = null;
        boolean boolean28 = watchManager25.addWatch("", watcher27);
        org.apache.zookeeper.Watcher watcher29 = null;
        watchManager25.removeWatcher(watcher29);
        java.lang.String str31 = watchManager25.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary32 = watchManager25.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType34 = null;
        org.apache.zookeeper.data.ACL[] aCLArray36 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList37 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean38 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList37, aCLArray36);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = watchManager25.triggerWatch("", eventType34, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37, watcherOrBitSet39);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager11.triggerWatch("", eventType23, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37, watcherOrBitSet41);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager0.triggerWatch("hi!", eventType9, (long) 'a', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37, watcherOrBitSet43);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(aCLArray15);
        org.junit.Assert.assertArrayEquals(aCLArray15, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "" + "'", str20, "");
        org.junit.Assert.assertNotNull(watchesReport21);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + true + "'", boolean28 == true);
        org.junit.Assert.assertEquals("'" + str31 + "' != '" + "" + "'", str31, "");
        org.junit.Assert.assertNotNull(watchesSummary32);
        org.junit.Assert.assertNotNull(aCLArray36);
        org.junit.Assert.assertArrayEquals(aCLArray36, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertNull(watcherOrBitSet40);
        org.junit.Assert.assertNull(watcherOrBitSet42);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test075");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport2 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean6 = watchManager0.addWatch("", watcher4, watcherMode5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertNotNull(watchesPathReport2);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test076");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean13 = watchManager0.addWatch("null\n\t\n", watcher11, watcherMode12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test077");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.removeWatcher("", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.Class<?> wildcardClass6 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test078");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.addWatch("null\n\t\n", watcher10);
        org.apache.zookeeper.Watcher.Event.EventType eventType13 = null;
        org.apache.zookeeper.data.ACL[] aCLArray15 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList16 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean17 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList16, aCLArray15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager0.triggerWatch("", eventType13, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList16);
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager22 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport23 = watchManager22.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher25 = null;
        boolean boolean26 = watchManager22.addWatch("hi!", watcher25);
        org.apache.zookeeper.Watcher watcher28 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode29 = null;
        boolean boolean30 = watchManager22.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher28, watcherMode29);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary31 = watchManager22.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType33 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager35 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType37 = null;
        org.apache.zookeeper.data.ACL[] aCLArray39 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList40 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean41 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList40, aCLArray39);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager35.triggerWatch("", eventType37, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList40, watcherOrBitSet42);
        java.lang.String str44 = watchManager35.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport45 = watchManager35.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType47 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager49 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher51 = null;
        boolean boolean52 = watchManager49.addWatch("", watcher51);
        org.apache.zookeeper.Watcher watcher53 = null;
        watchManager49.removeWatcher(watcher53);
        java.lang.String str55 = watchManager49.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary56 = watchManager49.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType58 = null;
        org.apache.zookeeper.data.ACL[] aCLArray60 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList61 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean62 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList61, aCLArray60);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet63 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet64 = watchManager49.triggerWatch("", eventType58, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList61, watcherOrBitSet63);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet65 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet66 = watchManager35.triggerWatch("", eventType47, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList61, watcherOrBitSet65);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet67 = watchManager22.triggerWatch("", eventType33, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList61);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet68 = watchManager0.triggerWatch("hi!", eventType20, (long) (short) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList61);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNotNull(aCLArray15);
        org.junit.Assert.assertArrayEquals(aCLArray15, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNotNull(watchesPathReport23);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + true + "'", boolean26 == true);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertNotNull(watchesSummary31);
        org.junit.Assert.assertNotNull(aCLArray39);
        org.junit.Assert.assertArrayEquals(aCLArray39, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertNull(watcherOrBitSet43);
        org.junit.Assert.assertEquals("'" + str44 + "' != '" + "" + "'", str44, "");
        org.junit.Assert.assertNotNull(watchesReport45);
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + true + "'", boolean52 == true);
        org.junit.Assert.assertEquals("'" + str55 + "' != '" + "" + "'", str55, "");
        org.junit.Assert.assertNotNull(watchesSummary56);
        org.junit.Assert.assertNotNull(aCLArray60);
        org.junit.Assert.assertArrayEquals(aCLArray60, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean62 + "' != '" + false + "'", boolean62 == false);
        org.junit.Assert.assertNull(watcherOrBitSet64);
        org.junit.Assert.assertNull(watcherOrBitSet66);
        org.junit.Assert.assertNull(watcherOrBitSet67);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test079");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.containsWatcher("", watcher19);
        java.lang.String str21 = watchManager0.toString();
        java.lang.String str22 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "" + "'", str21, "");
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "" + "'", str22, "");
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test080");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher6, watcherMode7);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean13 = watchManager0.addWatch("hi!", watcher11, watcherMode12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test081");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.addWatch("null\n\t\n", watcher5);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary7 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.containsWatcher("hi!", watcher9);
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.removeWatcher("hi!", watcher12);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertNotNull(watchesSummary7);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test082");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("", watcher3);
        java.lang.Class<?> wildcardClass5 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test083");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        int int2 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport3 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher5 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode6 = null;
        boolean boolean7 = watchManager0.containsWatcher("", watcher5, watcherMode6);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(watchesReport3);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test084");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport6 = watchManager5.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager5.addWatch("hi!", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager5.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager17 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType19 = null;
        org.apache.zookeeper.data.ACL[] aCLArray21 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList22 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean23 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList22, aCLArray21);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = watchManager17.triggerWatch("", eventType19, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22, watcherOrBitSet24);
        java.lang.String str26 = watchManager17.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport27 = watchManager17.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType29 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager31 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher33 = null;
        boolean boolean34 = watchManager31.addWatch("", watcher33);
        org.apache.zookeeper.Watcher watcher35 = null;
        watchManager31.removeWatcher(watcher35);
        java.lang.String str37 = watchManager31.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary38 = watchManager31.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType40 = null;
        org.apache.zookeeper.data.ACL[] aCLArray42 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList43 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean44 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList43, aCLArray42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = watchManager31.triggerWatch("", eventType40, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43, watcherOrBitSet45);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet47 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet48 = watchManager17.triggerWatch("", eventType29, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43, watcherOrBitSet47);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet49 = watchManager5.triggerWatch("", eventType15, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet50 = watchManager0.triggerWatch("null\n\t\n", eventType3, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 7");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(aCLArray21);
        org.junit.Assert.assertArrayEquals(aCLArray21, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNull(watcherOrBitSet25);
        org.junit.Assert.assertEquals("'" + str26 + "' != '" + "" + "'", str26, "");
        org.junit.Assert.assertNotNull(watchesReport27);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + true + "'", boolean34 == true);
        org.junit.Assert.assertEquals("'" + str37 + "' != '" + "" + "'", str37, "");
        org.junit.Assert.assertNotNull(watchesSummary38);
        org.junit.Assert.assertNotNull(aCLArray42);
        org.junit.Assert.assertArrayEquals(aCLArray42, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertNull(watcherOrBitSet46);
        org.junit.Assert.assertNull(watcherOrBitSet48);
        org.junit.Assert.assertNull(watcherOrBitSet49);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test085");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.addWatch("null\n\t\n\tnull\n\t\n\n", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean13 = watchManager0.addWatch("null\n\thi!\n", watcher11, watcherMode12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test086");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter13 = null;
        watchManager0.dumpWatches(printWriter13, true);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport16 = watchManager0.getWatchesByPath();
        java.lang.String str17 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.removeWatcher("hi!", watcher19);
        java.lang.Class<?> wildcardClass21 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertNotNull(watchesPathReport16);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "" + "'", str17, "");
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(wildcardClass21);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test087");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        org.junit.Assert.assertNotNull(watchesPathReport1);
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test088");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.removeWatcher("hi!", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        boolean boolean18 = watchManager0.removeWatcher("null\n\t\n", watcher16, watcherMode17);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test089");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport3 = watchManager0.getWatches();
        java.lang.Class<?> wildcardClass4 = watchesReport3.getClass();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertNotNull(watchesReport3);
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test090");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport2 = watchManager0.getWatchesByPath();
        java.lang.String str3 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.addWatch("null\n\t\n", watcher5);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport7 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test091");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary11 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
        org.junit.Assert.assertNotNull(watchesSummary11);
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test092");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("null\n\t\n", watcher10);
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test093");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesSummary6);
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test094");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        int int18 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean22 = watchManager0.addWatch("", watcher20, watcherMode21);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 0 + "'", int18 == 0);
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test095");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        java.lang.String str10 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(watchesSummary9);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "null\n\t\n" + "'", str10, "null\n\t\n");
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test096");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("null\n\t\n", watcher10);
        org.apache.zookeeper.Watcher watcher12 = null;
        watchManager0.removeWatcher(watcher12);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport14 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport14);
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test097");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.addWatch("null\n\t\n", watcher5);
        java.io.PrintWriter printWriter7 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter7, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.println(String)\" because \"writer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test098");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("null\n\thi!\n", watcher7, watcherMode8);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test099");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager12.triggerWatch("", eventType14, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet19);
        java.lang.String str21 = watchManager12.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport22 = watchManager12.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager26 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher28 = null;
        boolean boolean29 = watchManager26.addWatch("", watcher28);
        org.apache.zookeeper.Watcher watcher30 = null;
        watchManager26.removeWatcher(watcher30);
        java.lang.String str32 = watchManager26.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary33 = watchManager26.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.data.ACL[] aCLArray37 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList38 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean39 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList38, aCLArray37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager26.triggerWatch("", eventType35, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager12.triggerWatch("", eventType24, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager0.triggerWatch("", eventType10, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher47 = null;
        boolean boolean48 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher47);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary49 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher51 = null;
        boolean boolean52 = watchManager0.removeWatcher("hi!", watcher51);
        org.apache.zookeeper.Watcher watcher54 = null;
        boolean boolean55 = watchManager0.removeWatcher("null\n\thi!\n", watcher54);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "" + "'", str21, "");
        org.junit.Assert.assertNotNull(watchesReport22);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + true + "'", boolean29 == true);
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "" + "'", str32, "");
        org.junit.Assert.assertNotNull(watchesSummary33);
        org.junit.Assert.assertNotNull(aCLArray37);
        org.junit.Assert.assertArrayEquals(aCLArray37, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNull(watcherOrBitSet41);
        org.junit.Assert.assertNull(watcherOrBitSet43);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + false + "'", boolean48 == false);
        org.junit.Assert.assertNotNull(watchesSummary49);
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + true + "'", boolean52 == true);
        org.junit.Assert.assertTrue("'" + boolean55 + "' != '" + false + "'", boolean55 == false);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test100");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        java.util.List<org.apache.zookeeper.data.ACL> aCLList12 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager0.triggerWatch("hi!", eventType10, (long) (short) 100, aCLList12);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test101");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("", watcher7, watcherMode8);
        int int10 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.containsWatcher("hi!", watcher12);
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager0.containsWatcher("", watcher15);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport17 = watchManager0.getWatches();
        java.io.PrintWriter printWriter18 = null;
        watchManager0.dumpWatches(printWriter18, true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(watchesReport17);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test102");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.removeWatcher("hi!", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.containsWatcher("hi!", watcher16);
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.containsWatcher("null\n\tnull\n\t\n\tnull\n\t\n\n\n", watcher19);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test103");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("", watcher3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        watchManager0.shutdown();
        java.lang.String str9 = watchManager0.toString();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "null\n\t\n" + "'", str5, "null\n\t\n");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "" + "'", str9, "");
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test104");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("null\n\t\n", watcher10);
        org.apache.zookeeper.Watcher watcher12 = null;
        watchManager0.removeWatcher(watcher12);
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager0.addWatch("null\n\tnull\n\t\n\tnull\n\t\n\n\n", watcher15);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test105");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        watchManager0.shutdown();
        int int11 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher12 = null;
        watchManager0.removeWatcher(watcher12);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 1 + "'", int11 == 1);
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test106");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.addWatch("", watcher13);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test107");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.addWatch("null\n\t\n", watcher5);
        org.apache.zookeeper.Watcher.Event.EventType eventType8 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager10 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport11 = watchManager10.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager10.addWatch("hi!", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        boolean boolean18 = watchManager10.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher16, watcherMode17);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary19 = watchManager10.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType21 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager23 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.data.ACL[] aCLArray27 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList28 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean29 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList28, aCLArray27);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager23.triggerWatch("", eventType25, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28, watcherOrBitSet30);
        java.lang.String str32 = watchManager23.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport33 = watchManager23.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager37 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher39 = null;
        boolean boolean40 = watchManager37.addWatch("", watcher39);
        org.apache.zookeeper.Watcher watcher41 = null;
        watchManager37.removeWatcher(watcher41);
        java.lang.String str43 = watchManager37.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary44 = watchManager37.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType46 = null;
        org.apache.zookeeper.data.ACL[] aCLArray48 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList49 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean50 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList49, aCLArray48);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet51 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet52 = watchManager37.triggerWatch("", eventType46, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList49, watcherOrBitSet51);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet53 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet54 = watchManager23.triggerWatch("", eventType35, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList49, watcherOrBitSet53);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet55 = watchManager10.triggerWatch("", eventType21, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList49);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet56 = watchManager0.triggerWatch("null\n\tnull\n\t\n\tnull\n\t\n\n\n", eventType8, (long) (byte) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList49);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 23");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertNotNull(watchesPathReport11);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNotNull(watchesSummary19);
        org.junit.Assert.assertNotNull(aCLArray27);
        org.junit.Assert.assertArrayEquals(aCLArray27, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "" + "'", str32, "");
        org.junit.Assert.assertNotNull(watchesReport33);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + true + "'", boolean40 == true);
        org.junit.Assert.assertEquals("'" + str43 + "' != '" + "" + "'", str43, "");
        org.junit.Assert.assertNotNull(watchesSummary44);
        org.junit.Assert.assertNotNull(aCLArray48);
        org.junit.Assert.assertArrayEquals(aCLArray48, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean50 + "' != '" + false + "'", boolean50 == false);
        org.junit.Assert.assertNull(watcherOrBitSet52);
        org.junit.Assert.assertNull(watcherOrBitSet54);
        org.junit.Assert.assertNull(watcherOrBitSet55);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test108");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport10 = watchManager0.getWatches();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertNotNull(watchesSummary9);
        org.junit.Assert.assertNotNull(watchesReport10);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test109");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.addWatch("hi!", watcher5);
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test110");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher6, watcherMode7);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test111");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher6, watcherMode7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager13 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.data.ACL[] aCLArray17 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList18 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean19 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList18, aCLArray17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet21 = watchManager13.triggerWatch("", eventType15, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList18, watcherOrBitSet20);
        java.lang.String str22 = watchManager13.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport23 = watchManager13.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager27 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher29 = null;
        boolean boolean30 = watchManager27.addWatch("", watcher29);
        org.apache.zookeeper.Watcher watcher31 = null;
        watchManager27.removeWatcher(watcher31);
        java.lang.String str33 = watchManager27.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary34 = watchManager27.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType36 = null;
        org.apache.zookeeper.data.ACL[] aCLArray38 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList39 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean40 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList39, aCLArray38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager27.triggerWatch("", eventType36, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39, watcherOrBitSet41);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager13.triggerWatch("", eventType25, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39, watcherOrBitSet43);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = watchManager0.triggerWatch("", eventType11, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport46 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesSummary9);
        org.junit.Assert.assertNotNull(aCLArray17);
        org.junit.Assert.assertArrayEquals(aCLArray17, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNull(watcherOrBitSet21);
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "" + "'", str22, "");
        org.junit.Assert.assertNotNull(watchesReport23);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + true + "'", boolean30 == true);
        org.junit.Assert.assertEquals("'" + str33 + "' != '" + "" + "'", str33, "");
        org.junit.Assert.assertNotNull(watchesSummary34);
        org.junit.Assert.assertNotNull(aCLArray38);
        org.junit.Assert.assertArrayEquals(aCLArray38, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertNull(watcherOrBitSet42);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertNull(watcherOrBitSet45);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test112");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.removeWatcher("", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.containsWatcher("", watcher6);
        org.apache.zookeeper.Watcher.Event.EventType eventType9 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager11 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher13 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode14 = null;
        boolean boolean15 = watchManager11.containsWatcher("hi!", watcher13, watcherMode14);
        java.io.PrintWriter printWriter16 = null;
        watchManager11.dumpWatches(printWriter16, false);
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        boolean boolean22 = watchManager11.containsWatcher("hi!", watcher20, watcherMode21);
        org.apache.zookeeper.Watcher watcher24 = null;
        boolean boolean25 = watchManager11.containsWatcher("", watcher24);
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager29 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType31 = null;
        org.apache.zookeeper.data.ACL[] aCLArray33 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList34 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean35 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList34, aCLArray33);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet37 = watchManager29.triggerWatch("", eventType31, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList34, watcherOrBitSet36);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet38 = watchManager11.triggerWatch("", eventType27, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList34);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = watchManager0.triggerWatch("null\n\thi!\n", eventType9, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList34, watcherOrBitSet39);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 10");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(aCLArray33);
        org.junit.Assert.assertArrayEquals(aCLArray33, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertNull(watcherOrBitSet37);
        org.junit.Assert.assertNull(watcherOrBitSet38);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test113");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher4);
        int int6 = watchManager0.size();
        org.apache.zookeeper.Watcher.Event.EventType eventType8 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager10 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport11 = watchManager10.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager10.addWatch("hi!", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        boolean boolean18 = watchManager10.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher16, watcherMode17);
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager22 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.data.ACL[] aCLArray26 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList27 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean28 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList27, aCLArray26);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = watchManager22.triggerWatch("", eventType24, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList27, watcherOrBitSet29);
        java.lang.String str31 = watchManager22.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport32 = watchManager22.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType34 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager36 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher38 = null;
        boolean boolean39 = watchManager36.addWatch("", watcher38);
        org.apache.zookeeper.Watcher watcher40 = null;
        watchManager36.removeWatcher(watcher40);
        java.lang.String str42 = watchManager36.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary43 = watchManager36.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType45 = null;
        org.apache.zookeeper.data.ACL[] aCLArray47 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList48 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean49 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList48, aCLArray47);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet50 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet51 = watchManager36.triggerWatch("", eventType45, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList48, watcherOrBitSet50);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet52 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet53 = watchManager22.triggerWatch("", eventType34, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList48, watcherOrBitSet52);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet54 = watchManager10.triggerWatch("", eventType20, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList48);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet55 = watchManager0.triggerWatch("null\n\t\n", eventType8, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList48);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 7");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertNotNull(watchesPathReport11);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNotNull(aCLArray26);
        org.junit.Assert.assertArrayEquals(aCLArray26, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertNull(watcherOrBitSet30);
        org.junit.Assert.assertEquals("'" + str31 + "' != '" + "" + "'", str31, "");
        org.junit.Assert.assertNotNull(watchesReport32);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + true + "'", boolean39 == true);
        org.junit.Assert.assertEquals("'" + str42 + "' != '" + "" + "'", str42, "");
        org.junit.Assert.assertNotNull(watchesSummary43);
        org.junit.Assert.assertNotNull(aCLArray47);
        org.junit.Assert.assertArrayEquals(aCLArray47, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + false + "'", boolean49 == false);
        org.junit.Assert.assertNull(watcherOrBitSet51);
        org.junit.Assert.assertNull(watcherOrBitSet53);
        org.junit.Assert.assertNull(watcherOrBitSet54);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test114");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport2 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertNotNull(watchesPathReport2);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test115");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("null\n\t\n", watcher10);
        java.lang.Class<?> wildcardClass12 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(wildcardClass12);
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test116");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.addWatch("null\n\t\n", watcher12);
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager17 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager17.addWatch("", watcher19);
        org.apache.zookeeper.Watcher watcher21 = null;
        watchManager17.removeWatcher(watcher21);
        java.lang.String str23 = watchManager17.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary24 = watchManager17.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType26 = null;
        org.apache.zookeeper.data.ACL[] aCLArray28 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList29 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean30 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList29, aCLArray28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager17.triggerWatch("", eventType26, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList29, watcherOrBitSet31);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager0.triggerWatch("hi!", eventType15, (long) (byte) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList29);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
        org.junit.Assert.assertEquals("'" + str23 + "' != '" + "" + "'", str23, "");
        org.junit.Assert.assertNotNull(watchesSummary24);
        org.junit.Assert.assertNotNull(aCLArray28);
        org.junit.Assert.assertArrayEquals(aCLArray28, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertNull(watcherOrBitSet32);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test117");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter13 = null;
        watchManager0.dumpWatches(printWriter13, true);
        org.apache.zookeeper.Watcher watcher16 = null;
        watchManager0.removeWatcher(watcher16);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test118");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("", watcher7, watcherMode8);
        int int10 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher12 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode13 = null;
        boolean boolean14 = watchManager0.containsWatcher("hi!", watcher12, watcherMode13);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport15 = watchManager0.getWatches();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(watchesReport15);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test119");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter13 = null;
        watchManager0.dumpWatches(printWriter13, true);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport16 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher17 = null;
        watchManager0.removeWatcher(watcher17);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertNotNull(watchesReport16);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test120");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager13 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager13.addWatch("", watcher15);
        org.apache.zookeeper.Watcher watcher17 = null;
        watchManager13.removeWatcher(watcher17);
        java.lang.String str19 = watchManager13.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary20 = watchManager13.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.data.ACL[] aCLArray24 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList25 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean26 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList25, aCLArray24);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = watchManager13.triggerWatch("", eventType22, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList25, watcherOrBitSet27);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager0.triggerWatch("null\n\t\n\tnull\n\t\n\n", eventType11, (long) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList25);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 16");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesPathReport9);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "" + "'", str19, "");
        org.junit.Assert.assertNotNull(watchesSummary20);
        org.junit.Assert.assertNotNull(aCLArray24);
        org.junit.Assert.assertArrayEquals(aCLArray24, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertNull(watcherOrBitSet28);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test121");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.containsWatcher("", watcher19);
        java.lang.String str21 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher23 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode24 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean25 = watchManager0.addWatch("", watcher23, watcherMode24);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "" + "'", str21, "");
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test122");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager12.triggerWatch("", eventType14, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet19);
        java.lang.String str21 = watchManager12.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport22 = watchManager12.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager26 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher28 = null;
        boolean boolean29 = watchManager26.addWatch("", watcher28);
        org.apache.zookeeper.Watcher watcher30 = null;
        watchManager26.removeWatcher(watcher30);
        java.lang.String str32 = watchManager26.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary33 = watchManager26.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.data.ACL[] aCLArray37 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList38 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean39 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList38, aCLArray37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager26.triggerWatch("", eventType35, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager12.triggerWatch("", eventType24, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager0.triggerWatch("", eventType10, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher47 = null;
        boolean boolean48 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher47);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary49 = watchManager0.getWatchesSummary();
        watchManager0.shutdown();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport51 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "" + "'", str21, "");
        org.junit.Assert.assertNotNull(watchesReport22);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + true + "'", boolean29 == true);
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "" + "'", str32, "");
        org.junit.Assert.assertNotNull(watchesSummary33);
        org.junit.Assert.assertNotNull(aCLArray37);
        org.junit.Assert.assertArrayEquals(aCLArray37, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNull(watcherOrBitSet41);
        org.junit.Assert.assertNull(watcherOrBitSet43);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + false + "'", boolean48 == false);
        org.junit.Assert.assertNotNull(watchesSummary49);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test123");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary7 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType9 = null;
        org.apache.zookeeper.data.ACL[] aCLArray11 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList12 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean13 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList12, aCLArray11);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet15 = watchManager0.triggerWatch("", eventType9, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList12, watcherOrBitSet14);
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertNotNull(watchesSummary7);
        org.junit.Assert.assertNotNull(aCLArray11);
        org.junit.Assert.assertArrayEquals(aCLArray11, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNull(watcherOrBitSet15);
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test124");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.addWatch("", watcher9);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test125");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        java.lang.Class<?> wildcardClass8 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test126");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.addWatch("hi!", watcher9);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test127");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager16 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager16.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType19 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager21 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher23 = null;
        boolean boolean24 = watchManager21.addWatch("", watcher23);
        org.apache.zookeeper.Watcher watcher25 = null;
        watchManager21.removeWatcher(watcher25);
        java.lang.String str27 = watchManager21.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary28 = watchManager21.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType30 = null;
        org.apache.zookeeper.data.ACL[] aCLArray32 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList33 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean34 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList33, aCLArray32);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = watchManager21.triggerWatch("", eventType30, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList33, watcherOrBitSet35);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet37 = watchManager16.triggerWatch("", eventType19, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList33);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet38 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = watchManager0.triggerWatch("", eventType14, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList33, watcherOrBitSet38);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
        org.junit.Assert.assertEquals("'" + str27 + "' != '" + "" + "'", str27, "");
        org.junit.Assert.assertNotNull(watchesSummary28);
        org.junit.Assert.assertNotNull(aCLArray32);
        org.junit.Assert.assertArrayEquals(aCLArray32, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertNull(watcherOrBitSet36);
        org.junit.Assert.assertNull(watcherOrBitSet37);
        org.junit.Assert.assertNull(watcherOrBitSet39);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test128");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.containsWatcher("null\n\t\n", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean17 = watchManager0.addWatch("null\n\t\n", watcher15, watcherMode16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test129");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary8 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesSummary8);
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test130");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.containsWatcher("hi!", watcher16);
        java.lang.String str18 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean22 = watchManager0.addWatch("null\n\t\n\tnull\n\t\n\n", watcher20, watcherMode21);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "" + "'", str18, "");
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test131");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.addWatch("", watcher10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("hi!", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        boolean boolean18 = watchManager0.removeWatcher("", watcher16, watcherMode17);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test132");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("null\n\t\n", watcher10);
        org.apache.zookeeper.Watcher watcher12 = null;
        watchManager0.removeWatcher(watcher12);
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager17 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType19 = null;
        org.apache.zookeeper.data.ACL[] aCLArray21 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList22 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean23 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList22, aCLArray21);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = watchManager17.triggerWatch("", eventType19, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22, watcherOrBitSet24);
        java.lang.String str26 = watchManager17.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport27 = watchManager17.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType29 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager31 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher33 = null;
        boolean boolean34 = watchManager31.addWatch("", watcher33);
        org.apache.zookeeper.Watcher watcher35 = null;
        watchManager31.removeWatcher(watcher35);
        java.lang.String str37 = watchManager31.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary38 = watchManager31.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType40 = null;
        org.apache.zookeeper.data.ACL[] aCLArray42 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList43 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean44 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList43, aCLArray42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = watchManager31.triggerWatch("", eventType40, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43, watcherOrBitSet45);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet47 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet48 = watchManager17.triggerWatch("", eventType29, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43, watcherOrBitSet47);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet49 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet50 = watchManager0.triggerWatch("null\n\thi!\n", eventType15, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43, watcherOrBitSet49);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 10");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(aCLArray21);
        org.junit.Assert.assertArrayEquals(aCLArray21, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNull(watcherOrBitSet25);
        org.junit.Assert.assertEquals("'" + str26 + "' != '" + "" + "'", str26, "");
        org.junit.Assert.assertNotNull(watchesReport27);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + true + "'", boolean34 == true);
        org.junit.Assert.assertEquals("'" + str37 + "' != '" + "" + "'", str37, "");
        org.junit.Assert.assertNotNull(watchesSummary38);
        org.junit.Assert.assertNotNull(aCLArray42);
        org.junit.Assert.assertArrayEquals(aCLArray42, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertNull(watcherOrBitSet46);
        org.junit.Assert.assertNull(watcherOrBitSet48);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test133");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean5 = watchManager0.addWatch("null\n\t\n", watcher3, watcherMode4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test134");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher12 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode13 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean14 = watchManager0.addWatch("hi!", watcher12, watcherMode13);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test135");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.addWatch("null\n\t\n", watcher12);
        java.io.PrintWriter printWriter14 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter14, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.print(String)\" because \"writer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test136");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("null\n\t\n", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.containsWatcher("null\n\t\n", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.removeWatcher("hi!", watcher19);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesPathReport9);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test137");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.addWatch("null\n\t\n\tnull\n\t\n\n", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        boolean boolean16 = watchManager0.containsWatcher("null\n\tnull\n\t\n\tnull\n\t\n\n\n", watcher14, watcherMode15);
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.addWatch("null\n\t\n", watcher18);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test138");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean11 = watchManager0.addWatch("hi!", watcher9, watcherMode10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test139");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.addWatch("null\n\t\n", watcher5);
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        boolean boolean10 = watchManager0.containsWatcher("null\n\t\n", watcher8, watcherMode9);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test140");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("null\n\t\n", watcher3, watcherMode4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("null\n\t\n", watcher7, watcherMode8);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport10 = watchManager0.getWatchesByPath();
        int int11 = watchManager0.size();
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesPathReport10);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test141");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        int int2 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        boolean boolean6 = watchManager0.containsWatcher("", watcher4, watcherMode5);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(watchesReport7);
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test142");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("null\n\t\n", watcher10);
        org.apache.zookeeper.Watcher.Event.EventType eventType13 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager15 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        boolean boolean19 = watchManager15.containsWatcher("hi!", watcher17, watcherMode18);
        java.io.PrintWriter printWriter20 = null;
        watchManager15.dumpWatches(printWriter20, false);
        org.apache.zookeeper.Watcher watcher24 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode25 = null;
        boolean boolean26 = watchManager15.containsWatcher("hi!", watcher24, watcherMode25);
        org.apache.zookeeper.Watcher watcher28 = null;
        boolean boolean29 = watchManager15.containsWatcher("", watcher28);
        org.apache.zookeeper.Watcher.Event.EventType eventType31 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager33 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.data.ACL[] aCLArray37 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList38 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean39 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList38, aCLArray37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager33.triggerWatch("", eventType35, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager15.triggerWatch("", eventType31, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager0.triggerWatch("", eventType13, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport44 = watchManager0.getWatches();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNotNull(aCLArray37);
        org.junit.Assert.assertArrayEquals(aCLArray37, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNull(watcherOrBitSet41);
        org.junit.Assert.assertNull(watcherOrBitSet42);
        org.junit.Assert.assertNull(watcherOrBitSet43);
        org.junit.Assert.assertNotNull(watchesReport44);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test143");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager5.addWatch("", watcher7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager5.removeWatcher(watcher9);
        java.lang.String str11 = watchManager5.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary12 = watchManager5.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager5.triggerWatch("", eventType14, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet19);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet21 = watchManager0.triggerWatch("", eventType3, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17);
        org.apache.zookeeper.Watcher watcher23 = null;
        boolean boolean24 = watchManager0.containsWatcher("hi!", watcher23);
        org.apache.zookeeper.Watcher.Event.EventType eventType26 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager28 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport29 = watchManager28.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher31 = null;
        boolean boolean32 = watchManager28.addWatch("hi!", watcher31);
        org.apache.zookeeper.Watcher watcher34 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode35 = null;
        boolean boolean36 = watchManager28.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher34, watcherMode35);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary37 = watchManager28.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType39 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager41 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType43 = null;
        org.apache.zookeeper.data.ACL[] aCLArray45 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList46 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean47 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList46, aCLArray45);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet48 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet49 = watchManager41.triggerWatch("", eventType43, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList46, watcherOrBitSet48);
        java.lang.String str50 = watchManager41.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport51 = watchManager41.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType53 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager55 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher57 = null;
        boolean boolean58 = watchManager55.addWatch("", watcher57);
        org.apache.zookeeper.Watcher watcher59 = null;
        watchManager55.removeWatcher(watcher59);
        java.lang.String str61 = watchManager55.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary62 = watchManager55.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType64 = null;
        org.apache.zookeeper.data.ACL[] aCLArray66 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList67 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean68 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList67, aCLArray66);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet69 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet70 = watchManager55.triggerWatch("", eventType64, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList67, watcherOrBitSet69);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet71 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet72 = watchManager41.triggerWatch("", eventType53, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList67, watcherOrBitSet71);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet73 = watchManager28.triggerWatch("", eventType39, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList67);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet74 = watchManager0.triggerWatch("hi!", eventType26, (long) 'a', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList67);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "" + "'", str11, "");
        org.junit.Assert.assertNotNull(watchesSummary12);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNull(watcherOrBitSet21);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNotNull(watchesPathReport29);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + true + "'", boolean32 == true);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertNotNull(watchesSummary37);
        org.junit.Assert.assertNotNull(aCLArray45);
        org.junit.Assert.assertArrayEquals(aCLArray45, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + false + "'", boolean47 == false);
        org.junit.Assert.assertNull(watcherOrBitSet49);
        org.junit.Assert.assertEquals("'" + str50 + "' != '" + "" + "'", str50, "");
        org.junit.Assert.assertNotNull(watchesReport51);
        org.junit.Assert.assertTrue("'" + boolean58 + "' != '" + true + "'", boolean58 == true);
        org.junit.Assert.assertEquals("'" + str61 + "' != '" + "" + "'", str61, "");
        org.junit.Assert.assertNotNull(watchesSummary62);
        org.junit.Assert.assertNotNull(aCLArray66);
        org.junit.Assert.assertArrayEquals(aCLArray66, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean68 + "' != '" + false + "'", boolean68 == false);
        org.junit.Assert.assertNull(watcherOrBitSet70);
        org.junit.Assert.assertNull(watcherOrBitSet72);
        org.junit.Assert.assertNull(watcherOrBitSet73);
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test144");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.containsWatcher("hi!", watcher16);
        java.lang.String str18 = watchManager0.toString();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager22 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher24 = null;
        boolean boolean25 = watchManager22.addWatch("", watcher24);
        org.apache.zookeeper.Watcher watcher26 = null;
        watchManager22.removeWatcher(watcher26);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport28 = watchManager22.getWatches();
        org.apache.zookeeper.Watcher watcher29 = null;
        watchManager22.removeWatcher(watcher29);
        org.apache.zookeeper.Watcher watcher32 = null;
        boolean boolean33 = watchManager22.removeWatcher("null\n\t\n", watcher32);
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager37 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher39 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode40 = null;
        boolean boolean41 = watchManager37.containsWatcher("hi!", watcher39, watcherMode40);
        java.io.PrintWriter printWriter42 = null;
        watchManager37.dumpWatches(printWriter42, false);
        org.apache.zookeeper.Watcher watcher46 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode47 = null;
        boolean boolean48 = watchManager37.containsWatcher("hi!", watcher46, watcherMode47);
        org.apache.zookeeper.Watcher watcher50 = null;
        boolean boolean51 = watchManager37.containsWatcher("", watcher50);
        org.apache.zookeeper.Watcher.Event.EventType eventType53 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager55 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType57 = null;
        org.apache.zookeeper.data.ACL[] aCLArray59 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList60 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean61 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList60, aCLArray59);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet62 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet63 = watchManager55.triggerWatch("", eventType57, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList60, watcherOrBitSet62);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet64 = watchManager37.triggerWatch("", eventType53, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList60);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet65 = watchManager22.triggerWatch("", eventType35, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList60);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet66 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet67 = watchManager0.triggerWatch("null\n\tnull\n\t\n\tnull\n\t\n\n\n", eventType20, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList60, watcherOrBitSet66);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 23");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "" + "'", str18, "");
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + true + "'", boolean25 == true);
        org.junit.Assert.assertNotNull(watchesReport28);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + false + "'", boolean48 == false);
        org.junit.Assert.assertTrue("'" + boolean51 + "' != '" + false + "'", boolean51 == false);
        org.junit.Assert.assertNotNull(aCLArray59);
        org.junit.Assert.assertArrayEquals(aCLArray59, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean61 + "' != '" + false + "'", boolean61 == false);
        org.junit.Assert.assertNull(watcherOrBitSet63);
        org.junit.Assert.assertNull(watcherOrBitSet64);
        org.junit.Assert.assertNull(watcherOrBitSet65);
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test145");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter13 = null;
        watchManager0.dumpWatches(printWriter13, true);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary16 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertNotNull(watchesSummary16);
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test146");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("null\n\t\n", watcher10);
        org.apache.zookeeper.Watcher watcher12 = null;
        watchManager0.removeWatcher(watcher12);
        org.apache.zookeeper.Watcher watcher14 = null;
        watchManager0.removeWatcher(watcher14);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport16 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport16);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test147");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("null\n\t\n", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        java.util.List<org.apache.zookeeper.data.ACL> aCLList17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager0.triggerWatch("hi!", eventType15, (long) 10, aCLList17, watcherOrBitSet18);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesPathReport9);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test148");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.addWatch("null\n\t\n", watcher10);
        org.apache.zookeeper.Watcher.Event.EventType eventType13 = null;
        org.apache.zookeeper.data.ACL[] aCLArray15 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList16 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean17 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList16, aCLArray15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager0.triggerWatch("", eventType13, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList16);
        java.lang.String str19 = watchManager0.toString();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNotNull(aCLArray15);
        org.junit.Assert.assertArrayEquals(aCLArray15, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "null\n\tnull\n\t\n\n" + "'", str19, "null\n\tnull\n\t\n\n");
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test149");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.addWatch("null\n\t\n", watcher5);
        java.lang.String str7 = watchManager0.toString();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        java.io.PrintWriter printWriter11 = null;
        watchManager0.dumpWatches(printWriter11, true);
        org.apache.zookeeper.Watcher watcher14 = null;
        watchManager0.removeWatcher(watcher14);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "null\n\t\n\tnull\n\t\n\n" + "'", str7, "null\n\t\n\tnull\n\t\n\n");
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test150");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.removeWatcher("hi!", watcher13);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        boolean boolean20 = watchManager0.removeWatcher("hi!", watcher18, watcherMode19);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test151");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter10 = null;
        watchManager0.dumpWatches(printWriter10, true);
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        boolean boolean16 = watchManager0.removeWatcher("null\n\tnull\n\t\n\tnull\n\t\n\n\n", watcher14, watcherMode15);
        int int17 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesPathReport9);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test152");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport7 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport8 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesPathReport7);
        org.junit.Assert.assertNotNull(watchesPathReport8);
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test153");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher18 = null;
        watchManager0.removeWatcher(watcher18);
        org.apache.zookeeper.Watcher watcher21 = null;
        boolean boolean22 = watchManager0.addWatch("hi!", watcher21);
        java.lang.Class<?> wildcardClass23 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
        org.junit.Assert.assertNotNull(wildcardClass23);
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test154");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport10 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager14 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager14.addWatch("", watcher16);
        org.apache.zookeeper.Watcher watcher18 = null;
        watchManager14.removeWatcher(watcher18);
        java.lang.String str20 = watchManager14.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary21 = watchManager14.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType23 = null;
        org.apache.zookeeper.data.ACL[] aCLArray25 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList26 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean27 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList26, aCLArray25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager14.triggerWatch("", eventType23, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26, watcherOrBitSet28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager0.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26, watcherOrBitSet30);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport32 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType34 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager36 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher38 = null;
        boolean boolean39 = watchManager36.addWatch("", watcher38);
        org.apache.zookeeper.Watcher watcher40 = null;
        watchManager36.removeWatcher(watcher40);
        org.apache.zookeeper.Watcher watcher43 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode44 = null;
        boolean boolean45 = watchManager36.containsWatcher("null\n\t\n", watcher43, watcherMode44);
        org.apache.zookeeper.Watcher.Event.EventType eventType47 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager49 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport50 = watchManager49.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher52 = null;
        boolean boolean53 = watchManager49.addWatch("hi!", watcher52);
        org.apache.zookeeper.Watcher watcher55 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode56 = null;
        boolean boolean57 = watchManager49.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher55, watcherMode56);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary58 = watchManager49.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType60 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager62 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType64 = null;
        org.apache.zookeeper.data.ACL[] aCLArray66 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList67 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean68 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList67, aCLArray66);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet69 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet70 = watchManager62.triggerWatch("", eventType64, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList67, watcherOrBitSet69);
        java.lang.String str71 = watchManager62.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport72 = watchManager62.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType74 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager76 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher78 = null;
        boolean boolean79 = watchManager76.addWatch("", watcher78);
        org.apache.zookeeper.Watcher watcher80 = null;
        watchManager76.removeWatcher(watcher80);
        java.lang.String str82 = watchManager76.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary83 = watchManager76.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType85 = null;
        org.apache.zookeeper.data.ACL[] aCLArray87 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList88 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean89 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList88, aCLArray87);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet90 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet91 = watchManager76.triggerWatch("", eventType85, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList88, watcherOrBitSet90);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet92 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet93 = watchManager62.triggerWatch("", eventType74, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList88, watcherOrBitSet92);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet94 = watchManager49.triggerWatch("", eventType60, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList88);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet95 = watchManager36.triggerWatch("", eventType47, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList88);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet96 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet97 = watchManager0.triggerWatch("null\n\tnull\n\t\n\n", eventType34, (long) 2, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList88, watcherOrBitSet96);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 14");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "" + "'", str9, "");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "" + "'", str20, "");
        org.junit.Assert.assertNotNull(watchesSummary21);
        org.junit.Assert.assertNotNull(aCLArray25);
        org.junit.Assert.assertArrayEquals(aCLArray25, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNull(watcherOrBitSet29);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNotNull(watchesReport32);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + true + "'", boolean39 == true);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
        org.junit.Assert.assertNotNull(watchesPathReport50);
        org.junit.Assert.assertTrue("'" + boolean53 + "' != '" + true + "'", boolean53 == true);
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + false + "'", boolean57 == false);
        org.junit.Assert.assertNotNull(watchesSummary58);
        org.junit.Assert.assertNotNull(aCLArray66);
        org.junit.Assert.assertArrayEquals(aCLArray66, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean68 + "' != '" + false + "'", boolean68 == false);
        org.junit.Assert.assertNull(watcherOrBitSet70);
        org.junit.Assert.assertEquals("'" + str71 + "' != '" + "" + "'", str71, "");
        org.junit.Assert.assertNotNull(watchesReport72);
        org.junit.Assert.assertTrue("'" + boolean79 + "' != '" + true + "'", boolean79 == true);
        org.junit.Assert.assertEquals("'" + str82 + "' != '" + "" + "'", str82, "");
        org.junit.Assert.assertNotNull(watchesSummary83);
        org.junit.Assert.assertNotNull(aCLArray87);
        org.junit.Assert.assertArrayEquals(aCLArray87, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean89 + "' != '" + false + "'", boolean89 == false);
        org.junit.Assert.assertNull(watcherOrBitSet91);
        org.junit.Assert.assertNull(watcherOrBitSet93);
        org.junit.Assert.assertNull(watcherOrBitSet94);
        org.junit.Assert.assertNull(watcherOrBitSet95);
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test155");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.addWatch("hi!", watcher5);
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        boolean boolean10 = watchManager0.containsWatcher("", watcher8, watcherMode9);
        java.io.PrintWriter printWriter11 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter11, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.print(String)\" because \"writer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test156");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport2 = watchManager0.getWatchesByPath();
        int int3 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesPathReport2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test157");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("null\n\thi!\n", watcher11);
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("null\n\tnull\n\t\n\tnull\n\t\n\n\n", eventType14, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet19);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 23");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesPathReport9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test158");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertNotNull(watchesSummary9);
        org.junit.Assert.assertNotNull(watchesSummary10);
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test159");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher10);
        org.apache.zookeeper.Watcher watcher13 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode14 = null;
        boolean boolean15 = watchManager0.removeWatcher("null\n\thi!\n", watcher13, watcherMode14);
        java.io.PrintWriter printWriter16 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter16, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.println(String)\" because \"writer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test160");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager12.triggerWatch("", eventType14, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet19);
        java.lang.String str21 = watchManager12.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport22 = watchManager12.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager26 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher28 = null;
        boolean boolean29 = watchManager26.addWatch("", watcher28);
        org.apache.zookeeper.Watcher watcher30 = null;
        watchManager26.removeWatcher(watcher30);
        java.lang.String str32 = watchManager26.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary33 = watchManager26.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.data.ACL[] aCLArray37 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList38 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean39 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList38, aCLArray37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager26.triggerWatch("", eventType35, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager12.triggerWatch("", eventType24, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager0.triggerWatch("", eventType10, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher47 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode48 = null;
        boolean boolean49 = watchManager0.removeWatcher("", watcher47, watcherMode48);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "" + "'", str21, "");
        org.junit.Assert.assertNotNull(watchesReport22);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + true + "'", boolean29 == true);
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "" + "'", str32, "");
        org.junit.Assert.assertNotNull(watchesSummary33);
        org.junit.Assert.assertNotNull(aCLArray37);
        org.junit.Assert.assertArrayEquals(aCLArray37, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNull(watcherOrBitSet41);
        org.junit.Assert.assertNull(watcherOrBitSet43);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + false + "'", boolean49 == false);
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test161");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        int int2 = watchManager0.size();
        java.lang.Class<?> wildcardClass3 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test162");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager12.triggerWatch("", eventType14, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet19);
        java.lang.String str21 = watchManager12.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport22 = watchManager12.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager26 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher28 = null;
        boolean boolean29 = watchManager26.addWatch("", watcher28);
        org.apache.zookeeper.Watcher watcher30 = null;
        watchManager26.removeWatcher(watcher30);
        java.lang.String str32 = watchManager26.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary33 = watchManager26.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.data.ACL[] aCLArray37 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList38 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean39 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList38, aCLArray37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager26.triggerWatch("", eventType35, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager12.triggerWatch("", eventType24, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager0.triggerWatch("", eventType10, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher47 = null;
        boolean boolean48 = watchManager0.removeWatcher("hi!", watcher47);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher51 = null;
        boolean boolean52 = watchManager0.addWatch("null\n\thi!\n", watcher51);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "" + "'", str21, "");
        org.junit.Assert.assertNotNull(watchesReport22);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + true + "'", boolean29 == true);
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "" + "'", str32, "");
        org.junit.Assert.assertNotNull(watchesSummary33);
        org.junit.Assert.assertNotNull(aCLArray37);
        org.junit.Assert.assertArrayEquals(aCLArray37, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNull(watcherOrBitSet41);
        org.junit.Assert.assertNull(watcherOrBitSet43);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + true + "'", boolean48 == true);
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + true + "'", boolean52 == true);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test163");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport7 = watchManager0.getWatchesByPath();
        java.lang.Class<?> wildcardClass8 = watchesPathReport7.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesPathReport7);
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test164");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher10);
        org.apache.zookeeper.Watcher watcher13 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode14 = null;
        boolean boolean15 = watchManager0.removeWatcher("null\n\thi!\n", watcher13, watcherMode14);
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.removeWatcher("null\n\thi!\n", watcher17);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test165");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager0.removeWatcher("hi!", watcher15);
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test166");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("", watcher11);
        java.io.PrintWriter printWriter13 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter13, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.println(String)\" because \"writer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test167");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("", watcher13);
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.data.ACL[] aCLArray22 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList23 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean24 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList23, aCLArray22);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager18.triggerWatch("", eventType20, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23, watcherOrBitSet25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = watchManager0.triggerWatch("", eventType16, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23);
        java.io.PrintWriter printWriter28 = null;
        watchManager0.dumpWatches(printWriter28, false);
        org.apache.zookeeper.Watcher watcher32 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode33 = null;
        boolean boolean34 = watchManager0.removeWatcher("hi!", watcher32, watcherMode33);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport35 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(aCLArray22);
        org.junit.Assert.assertArrayEquals(aCLArray22, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNull(watcherOrBitSet26);
        org.junit.Assert.assertNull(watcherOrBitSet27);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertNotNull(watchesPathReport35);
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test168");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("null\n\t\n", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("hi!", watcher11);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test169");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.addWatch("null\n\t\n", watcher5);
        java.lang.String str7 = watchManager0.toString();
        watchManager0.shutdown();
        int int9 = watchManager0.size();
        int int10 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.addWatch("", watcher12);
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager17 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType19 = null;
        org.apache.zookeeper.data.ACL[] aCLArray21 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList22 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean23 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList22, aCLArray21);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = watchManager17.triggerWatch("", eventType19, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22, watcherOrBitSet24);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = watchManager0.triggerWatch("null\n\t\n", eventType15, (long) (short) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22, watcherOrBitSet26);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 7");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "null\n\t\n\tnull\n\t\n\n" + "'", str7, "null\n\t\n\tnull\n\t\n\n");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 2 + "'", int9 == 2);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 2 + "'", int10 == 2);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(aCLArray21);
        org.junit.Assert.assertArrayEquals(aCLArray21, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNull(watcherOrBitSet25);
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test170");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("", watcher13);
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.data.ACL[] aCLArray22 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList23 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean24 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList23, aCLArray22);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager18.triggerWatch("", eventType20, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23, watcherOrBitSet25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = watchManager0.triggerWatch("", eventType16, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23);
        java.io.PrintWriter printWriter28 = null;
        watchManager0.dumpWatches(printWriter28, false);
        org.apache.zookeeper.Watcher watcher32 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode33 = null;
        boolean boolean34 = watchManager0.removeWatcher("hi!", watcher32, watcherMode33);
        org.apache.zookeeper.Watcher.Event.EventType eventType36 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager38 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager38.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType41 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager43 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher45 = null;
        boolean boolean46 = watchManager43.addWatch("", watcher45);
        org.apache.zookeeper.Watcher watcher47 = null;
        watchManager43.removeWatcher(watcher47);
        java.lang.String str49 = watchManager43.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary50 = watchManager43.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType52 = null;
        org.apache.zookeeper.data.ACL[] aCLArray54 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList55 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean56 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList55, aCLArray54);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet57 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet58 = watchManager43.triggerWatch("", eventType52, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList55, watcherOrBitSet57);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet59 = watchManager38.triggerWatch("", eventType41, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList55);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet60 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet61 = watchManager0.triggerWatch("hi!", eventType36, (long) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList55, watcherOrBitSet60);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(aCLArray22);
        org.junit.Assert.assertArrayEquals(aCLArray22, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNull(watcherOrBitSet26);
        org.junit.Assert.assertNull(watcherOrBitSet27);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertTrue("'" + boolean46 + "' != '" + true + "'", boolean46 == true);
        org.junit.Assert.assertEquals("'" + str49 + "' != '" + "" + "'", str49, "");
        org.junit.Assert.assertNotNull(watchesSummary50);
        org.junit.Assert.assertNotNull(aCLArray54);
        org.junit.Assert.assertArrayEquals(aCLArray54, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean56 + "' != '" + false + "'", boolean56 == false);
        org.junit.Assert.assertNull(watcherOrBitSet58);
        org.junit.Assert.assertNull(watcherOrBitSet59);
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test171");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher18 = null;
        watchManager0.removeWatcher(watcher18);
        org.apache.zookeeper.Watcher watcher21 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode22 = null;
        boolean boolean23 = watchManager0.removeWatcher("hi!", watcher21, watcherMode22);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test172");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher11, watcherMode12);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertNotNull(watchesSummary9);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test173");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher19);
        org.apache.zookeeper.Watcher watcher22 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode23 = null;
        boolean boolean24 = watchManager0.containsWatcher("null\n\tnull\n\t\n\n", watcher22, watcherMode23);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test174");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.containsWatcher("", watcher19);
        java.io.PrintWriter printWriter21 = null;
        watchManager0.dumpWatches(printWriter21, false);
        org.apache.zookeeper.Watcher watcher25 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode26 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean27 = watchManager0.addWatch("null\n\t\n", watcher25, watcherMode26);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test175");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("", watcher7, watcherMode8);
        int int10 = watchManager0.size();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager14 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport15 = watchManager14.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager14.addWatch("hi!", watcher17);
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        boolean boolean22 = watchManager14.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher20, watcherMode21);
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager26 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType28 = null;
        org.apache.zookeeper.data.ACL[] aCLArray30 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList31 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean32 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList31, aCLArray30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager26.triggerWatch("", eventType28, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList31, watcherOrBitSet33);
        java.lang.String str35 = watchManager26.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport36 = watchManager26.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType38 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager40 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher42 = null;
        boolean boolean43 = watchManager40.addWatch("", watcher42);
        org.apache.zookeeper.Watcher watcher44 = null;
        watchManager40.removeWatcher(watcher44);
        java.lang.String str46 = watchManager40.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary47 = watchManager40.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType49 = null;
        org.apache.zookeeper.data.ACL[] aCLArray51 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList52 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean53 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList52, aCLArray51);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet54 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet55 = watchManager40.triggerWatch("", eventType49, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList52, watcherOrBitSet54);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet56 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet57 = watchManager26.triggerWatch("", eventType38, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList52, watcherOrBitSet56);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet58 = watchManager14.triggerWatch("", eventType24, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList52);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet59 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet60 = watchManager0.triggerWatch("null\n\tnull\n\t\n\n", eventType12, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList52, watcherOrBitSet59);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 14");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertNotNull(watchesPathReport15);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(aCLArray30);
        org.junit.Assert.assertArrayEquals(aCLArray30, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNull(watcherOrBitSet34);
        org.junit.Assert.assertEquals("'" + str35 + "' != '" + "" + "'", str35, "");
        org.junit.Assert.assertNotNull(watchesReport36);
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + true + "'", boolean43 == true);
        org.junit.Assert.assertEquals("'" + str46 + "' != '" + "" + "'", str46, "");
        org.junit.Assert.assertNotNull(watchesSummary47);
        org.junit.Assert.assertNotNull(aCLArray51);
        org.junit.Assert.assertArrayEquals(aCLArray51, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean53 + "' != '" + false + "'", boolean53 == false);
        org.junit.Assert.assertNull(watcherOrBitSet55);
        org.junit.Assert.assertNull(watcherOrBitSet57);
        org.junit.Assert.assertNull(watcherOrBitSet58);
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test176");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.containsWatcher("hi!", watcher16);
        java.lang.String str18 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher20 = null;
        boolean boolean21 = watchManager0.containsWatcher("null\n\thi!\n", watcher20);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "" + "'", str18, "");
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test177");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.addWatch("null\n\t\n", watcher10);
        watchManager0.shutdown();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test178");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("null\n\t\n", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher14 = null;
        watchManager0.removeWatcher(watcher14);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesPathReport9);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test179");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.removeWatcher("", watcher14);
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.removeWatcher("hi!", watcher17);
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean22 = watchManager0.addWatch("hi!", watcher20, watcherMode21);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test180");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport2 = watchManager0.getWatchesByPath();
        java.lang.String str3 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.addWatch("null\n\t\n", watcher5);
        int int7 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesPathReport2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 1 + "'", int7 == 1);
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test181");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher19);
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager24.shutdown();
        org.apache.zookeeper.Watcher watcher27 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode28 = null;
        boolean boolean29 = watchManager24.removeWatcher("null\n\t\n", watcher27, watcherMode28);
        org.apache.zookeeper.Watcher watcher31 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode32 = null;
        boolean boolean33 = watchManager24.removeWatcher("null\n\t\n", watcher31, watcherMode32);
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager37 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType39 = null;
        org.apache.zookeeper.data.ACL[] aCLArray41 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList42 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean43 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList42, aCLArray41);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = watchManager37.triggerWatch("", eventType39, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList42, watcherOrBitSet44);
        org.apache.zookeeper.Watcher watcher47 = null;
        boolean boolean48 = watchManager37.addWatch("null\n\t\n", watcher47);
        org.apache.zookeeper.Watcher.Event.EventType eventType50 = null;
        org.apache.zookeeper.data.ACL[] aCLArray52 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList53 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean54 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList53, aCLArray52);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet55 = watchManager37.triggerWatch("", eventType50, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList53);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet56 = watchManager24.triggerWatch("", eventType35, (long) (byte) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList53);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet57 = watchManager0.triggerWatch("hi!", eventType22, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList53);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertNotNull(aCLArray41);
        org.junit.Assert.assertArrayEquals(aCLArray41, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
        org.junit.Assert.assertNull(watcherOrBitSet45);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + true + "'", boolean48 == true);
        org.junit.Assert.assertNotNull(aCLArray52);
        org.junit.Assert.assertArrayEquals(aCLArray52, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + false + "'", boolean54 == false);
        org.junit.Assert.assertNull(watcherOrBitSet55);
        org.junit.Assert.assertNull(watcherOrBitSet56);
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test182");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.addWatch("null\n\t\n", watcher10);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager16 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType18 = null;
        org.apache.zookeeper.data.ACL[] aCLArray20 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList21 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean22 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList21, aCLArray20);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet23 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = watchManager16.triggerWatch("", eventType18, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList21, watcherOrBitSet23);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager0.triggerWatch("null\n\t\n\tnull\n\t\n\n", eventType14, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList21, watcherOrBitSet25);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 16");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNotNull(aCLArray20);
        org.junit.Assert.assertArrayEquals(aCLArray20, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNull(watcherOrBitSet24);
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test183");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("null\n\t\n", watcher10);
        org.apache.zookeeper.Watcher watcher12 = null;
        watchManager0.removeWatcher(watcher12);
        org.apache.zookeeper.Watcher watcher14 = null;
        watchManager0.removeWatcher(watcher14);
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        boolean boolean19 = watchManager0.containsWatcher("hi!", watcher17, watcherMode18);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test184");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("", watcher3);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("null\n\tnull\n\t\n\tnull\n\t\n\n\n", watcher7);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test185");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.addWatch("null\n\t\n", watcher5);
        java.lang.String str7 = watchManager0.toString();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport11 = watchManager0.getWatches();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "null\n\t\n\tnull\n\t\n\n" + "'", str7, "null\n\t\n\tnull\n\t\n\n");
        org.junit.Assert.assertNotNull(watchesReport11);
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test186");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher.Event.EventType eventType9 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager11 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager11.addWatch("", watcher13);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager11.removeWatcher(watcher15);
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        boolean boolean20 = watchManager11.containsWatcher("null\n\t\n", watcher18, watcherMode19);
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport25 = watchManager24.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher27 = null;
        boolean boolean28 = watchManager24.addWatch("hi!", watcher27);
        org.apache.zookeeper.Watcher watcher30 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode31 = null;
        boolean boolean32 = watchManager24.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher30, watcherMode31);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary33 = watchManager24.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager37 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType39 = null;
        org.apache.zookeeper.data.ACL[] aCLArray41 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList42 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean43 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList42, aCLArray41);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = watchManager37.triggerWatch("", eventType39, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList42, watcherOrBitSet44);
        java.lang.String str46 = watchManager37.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport47 = watchManager37.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType49 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager51 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher53 = null;
        boolean boolean54 = watchManager51.addWatch("", watcher53);
        org.apache.zookeeper.Watcher watcher55 = null;
        watchManager51.removeWatcher(watcher55);
        java.lang.String str57 = watchManager51.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary58 = watchManager51.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType60 = null;
        org.apache.zookeeper.data.ACL[] aCLArray62 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList63 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean64 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList63, aCLArray62);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet65 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet66 = watchManager51.triggerWatch("", eventType60, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList63, watcherOrBitSet65);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet67 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet68 = watchManager37.triggerWatch("", eventType49, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList63, watcherOrBitSet67);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet69 = watchManager24.triggerWatch("", eventType35, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList63);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet70 = watchManager11.triggerWatch("", eventType22, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList63);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet71 = watchManager0.triggerWatch("null\n\t\n\tnull\n\t\n\n", eventType9, (long) (byte) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList63);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 16");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(watchesPathReport25);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + true + "'", boolean28 == true);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNotNull(watchesSummary33);
        org.junit.Assert.assertNotNull(aCLArray41);
        org.junit.Assert.assertArrayEquals(aCLArray41, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
        org.junit.Assert.assertNull(watcherOrBitSet45);
        org.junit.Assert.assertEquals("'" + str46 + "' != '" + "" + "'", str46, "");
        org.junit.Assert.assertNotNull(watchesReport47);
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + true + "'", boolean54 == true);
        org.junit.Assert.assertEquals("'" + str57 + "' != '" + "" + "'", str57, "");
        org.junit.Assert.assertNotNull(watchesSummary58);
        org.junit.Assert.assertNotNull(aCLArray62);
        org.junit.Assert.assertArrayEquals(aCLArray62, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean64 + "' != '" + false + "'", boolean64 == false);
        org.junit.Assert.assertNull(watcherOrBitSet66);
        org.junit.Assert.assertNull(watcherOrBitSet68);
        org.junit.Assert.assertNull(watcherOrBitSet69);
        org.junit.Assert.assertNull(watcherOrBitSet70);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test187");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("", watcher3);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test188");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("null\n\t\n", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager0.containsWatcher("null\n\thi!\n", watcher15);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesPathReport9);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test189");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("null\n\t\n", watcher3, watcherMode4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("null\n\t\n", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher11);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test190");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("", watcher3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.removeWatcher("null\n\t\n", watcher9);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "null\n\t\n" + "'", str5, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test191");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.removeWatcher("hi!", watcher13);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test192");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        boolean boolean10 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher8, watcherMode9);
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.removeWatcher("null\n\t\n", watcher12);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test193");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.addWatch("", watcher10);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary12 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        boolean boolean16 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher14, watcherMode15);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNotNull(watchesSummary12);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test194");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport10 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager14 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager14.addWatch("", watcher16);
        org.apache.zookeeper.Watcher watcher18 = null;
        watchManager14.removeWatcher(watcher18);
        java.lang.String str20 = watchManager14.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary21 = watchManager14.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType23 = null;
        org.apache.zookeeper.data.ACL[] aCLArray25 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList26 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean27 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList26, aCLArray25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager14.triggerWatch("", eventType23, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26, watcherOrBitSet28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager0.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26, watcherOrBitSet30);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport32 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher33 = null;
        watchManager0.removeWatcher(watcher33);
        org.apache.zookeeper.Watcher.Event.EventType eventType36 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager38 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher40 = null;
        boolean boolean41 = watchManager38.addWatch("", watcher40);
        org.apache.zookeeper.Watcher watcher42 = null;
        watchManager38.removeWatcher(watcher42);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport44 = watchManager38.getWatches();
        org.apache.zookeeper.Watcher watcher45 = null;
        watchManager38.removeWatcher(watcher45);
        org.apache.zookeeper.Watcher watcher48 = null;
        boolean boolean49 = watchManager38.removeWatcher("null\n\t\n", watcher48);
        org.apache.zookeeper.Watcher.Event.EventType eventType51 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager53 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher55 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode56 = null;
        boolean boolean57 = watchManager53.containsWatcher("hi!", watcher55, watcherMode56);
        java.io.PrintWriter printWriter58 = null;
        watchManager53.dumpWatches(printWriter58, false);
        org.apache.zookeeper.Watcher watcher62 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode63 = null;
        boolean boolean64 = watchManager53.containsWatcher("hi!", watcher62, watcherMode63);
        org.apache.zookeeper.Watcher watcher66 = null;
        boolean boolean67 = watchManager53.containsWatcher("", watcher66);
        org.apache.zookeeper.Watcher.Event.EventType eventType69 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager71 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType73 = null;
        org.apache.zookeeper.data.ACL[] aCLArray75 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList76 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean77 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList76, aCLArray75);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet78 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet79 = watchManager71.triggerWatch("", eventType73, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList76, watcherOrBitSet78);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet80 = watchManager53.triggerWatch("", eventType69, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList76);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet81 = watchManager38.triggerWatch("", eventType51, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList76);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet82 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet83 = watchManager0.triggerWatch("null\n\tnull\n\t\n\tnull\n\t\n\n\n", eventType36, (long) 'a', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList76, watcherOrBitSet82);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 23");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "" + "'", str9, "");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "" + "'", str20, "");
        org.junit.Assert.assertNotNull(watchesSummary21);
        org.junit.Assert.assertNotNull(aCLArray25);
        org.junit.Assert.assertArrayEquals(aCLArray25, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNull(watcherOrBitSet29);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNotNull(watchesReport32);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + true + "'", boolean41 == true);
        org.junit.Assert.assertNotNull(watchesReport44);
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + false + "'", boolean49 == false);
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + false + "'", boolean57 == false);
        org.junit.Assert.assertTrue("'" + boolean64 + "' != '" + false + "'", boolean64 == false);
        org.junit.Assert.assertTrue("'" + boolean67 + "' != '" + false + "'", boolean67 == false);
        org.junit.Assert.assertNotNull(aCLArray75);
        org.junit.Assert.assertArrayEquals(aCLArray75, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean77 + "' != '" + false + "'", boolean77 == false);
        org.junit.Assert.assertNull(watcherOrBitSet79);
        org.junit.Assert.assertNull(watcherOrBitSet80);
        org.junit.Assert.assertNull(watcherOrBitSet81);
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test195");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter13 = null;
        watchManager0.dumpWatches(printWriter13, true);
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.addWatch("", watcher17);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test196");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("", watcher7, watcherMode8);
        int int10 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher12 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode13 = null;
        boolean boolean14 = watchManager0.containsWatcher("hi!", watcher12, watcherMode13);
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean18 = watchManager0.addWatch("", watcher16, watcherMode17);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test197");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager13 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager13.addWatch("", watcher15);
        org.apache.zookeeper.Watcher watcher17 = null;
        watchManager13.removeWatcher(watcher17);
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        boolean boolean22 = watchManager13.containsWatcher("null\n\t\n", watcher20, watcherMode21);
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager26 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport27 = watchManager26.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher29 = null;
        boolean boolean30 = watchManager26.addWatch("hi!", watcher29);
        org.apache.zookeeper.Watcher watcher32 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode33 = null;
        boolean boolean34 = watchManager26.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher32, watcherMode33);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary35 = watchManager26.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType37 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager39 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType41 = null;
        org.apache.zookeeper.data.ACL[] aCLArray43 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList44 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean45 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList44, aCLArray43);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet47 = watchManager39.triggerWatch("", eventType41, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList44, watcherOrBitSet46);
        java.lang.String str48 = watchManager39.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport49 = watchManager39.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType51 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager53 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher55 = null;
        boolean boolean56 = watchManager53.addWatch("", watcher55);
        org.apache.zookeeper.Watcher watcher57 = null;
        watchManager53.removeWatcher(watcher57);
        java.lang.String str59 = watchManager53.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary60 = watchManager53.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType62 = null;
        org.apache.zookeeper.data.ACL[] aCLArray64 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList65 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean66 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList65, aCLArray64);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet67 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet68 = watchManager53.triggerWatch("", eventType62, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList65, watcherOrBitSet67);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet69 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet70 = watchManager39.triggerWatch("", eventType51, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList65, watcherOrBitSet69);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet71 = watchManager26.triggerWatch("", eventType37, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList65);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet72 = watchManager13.triggerWatch("", eventType24, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList65);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet73 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet74 = watchManager0.triggerWatch("null\n\t\n", eventType11, (long) (byte) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList65, watcherOrBitSet73);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 7");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(watchesSummary9);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(watchesPathReport27);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + true + "'", boolean30 == true);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertNotNull(watchesSummary35);
        org.junit.Assert.assertNotNull(aCLArray43);
        org.junit.Assert.assertArrayEquals(aCLArray43, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
        org.junit.Assert.assertNull(watcherOrBitSet47);
        org.junit.Assert.assertEquals("'" + str48 + "' != '" + "" + "'", str48, "");
        org.junit.Assert.assertNotNull(watchesReport49);
        org.junit.Assert.assertTrue("'" + boolean56 + "' != '" + true + "'", boolean56 == true);
        org.junit.Assert.assertEquals("'" + str59 + "' != '" + "" + "'", str59, "");
        org.junit.Assert.assertNotNull(watchesSummary60);
        org.junit.Assert.assertNotNull(aCLArray64);
        org.junit.Assert.assertArrayEquals(aCLArray64, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean66 + "' != '" + false + "'", boolean66 == false);
        org.junit.Assert.assertNull(watcherOrBitSet68);
        org.junit.Assert.assertNull(watcherOrBitSet70);
        org.junit.Assert.assertNull(watcherOrBitSet71);
        org.junit.Assert.assertNull(watcherOrBitSet72);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test198");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.addWatch("null\n\t\n", watcher5);
        java.lang.String str7 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        watchManager0.removeWatcher(watcher8);
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "null\n\t\n\tnull\n\t\n\n" + "'", str7, "null\n\t\n\tnull\n\t\n\n");
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test199");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("", watcher7, watcherMode8);
        int int10 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary11 = watchManager0.getWatchesSummary();
        java.io.PrintWriter printWriter12 = null;
        watchManager0.dumpWatches(printWriter12, true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertNotNull(watchesSummary11);
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test200");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter13 = null;
        watchManager0.dumpWatches(printWriter13, true);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport16 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean20 = watchManager0.addWatch("null\n\tnull\n\t\n\tnull\n\t\n\n\n", watcher18, watcherMode19);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertNotNull(watchesReport16);
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test201");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("null\n\t\n", watcher10);
        org.apache.zookeeper.Watcher watcher12 = null;
        watchManager0.removeWatcher(watcher12);
        int int14 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        java.lang.Class<?> wildcardClass17 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
        org.junit.Assert.assertNotNull(wildcardClass17);
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test202");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.removeWatcher("", watcher14);
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.containsWatcher("null\n\t\n", watcher17);
        java.lang.String str19 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "" + "'", str19, "");
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test203");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("", watcher3);
        int int5 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test204");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("null\n\t\n", watcher10);
        org.apache.zookeeper.Watcher watcher12 = null;
        watchManager0.removeWatcher(watcher12);
        int int14 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean18 = watchManager0.addWatch("null\n\tnull\n\t\n\n", watcher16, watcherMode17);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test205");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("", watcher10);
        org.apache.zookeeper.Watcher.Event.EventType eventType13 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager15 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager15.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType18 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager20 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher22 = null;
        boolean boolean23 = watchManager20.addWatch("", watcher22);
        org.apache.zookeeper.Watcher watcher24 = null;
        watchManager20.removeWatcher(watcher24);
        java.lang.String str26 = watchManager20.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary27 = watchManager20.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType29 = null;
        org.apache.zookeeper.data.ACL[] aCLArray31 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList32 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean33 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList32, aCLArray31);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = watchManager20.triggerWatch("", eventType29, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList32, watcherOrBitSet34);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = watchManager15.triggerWatch("", eventType18, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList32);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet37 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet38 = watchManager0.triggerWatch("null\n\t\n\tnull\n\t\n\n", eventType13, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList32, watcherOrBitSet37);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 16");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertEquals("'" + str26 + "' != '" + "" + "'", str26, "");
        org.junit.Assert.assertNotNull(watchesSummary27);
        org.junit.Assert.assertNotNull(aCLArray31);
        org.junit.Assert.assertArrayEquals(aCLArray31, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertNull(watcherOrBitSet35);
        org.junit.Assert.assertNull(watcherOrBitSet36);
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test206");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.addWatch("null\n\t\n", watcher5);
        java.lang.String str7 = watchManager0.toString();
        watchManager0.shutdown();
        int int9 = watchManager0.size();
        java.lang.String str10 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "null\n\t\n\tnull\n\t\n\n" + "'", str7, "null\n\t\n\tnull\n\t\n\n");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 2 + "'", int9 == 2);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "null\n\t\n\tnull\n\t\n\n" + "'", str10, "null\n\t\n\tnull\n\t\n\n");
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test207");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager12.triggerWatch("", eventType14, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet19);
        java.lang.String str21 = watchManager12.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport22 = watchManager12.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager26 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher28 = null;
        boolean boolean29 = watchManager26.addWatch("", watcher28);
        org.apache.zookeeper.Watcher watcher30 = null;
        watchManager26.removeWatcher(watcher30);
        java.lang.String str32 = watchManager26.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary33 = watchManager26.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.data.ACL[] aCLArray37 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList38 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean39 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList38, aCLArray37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager26.triggerWatch("", eventType35, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager12.triggerWatch("", eventType24, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager0.triggerWatch("", eventType10, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher47 = null;
        boolean boolean48 = watchManager0.removeWatcher("hi!", watcher47);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport49 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "" + "'", str21, "");
        org.junit.Assert.assertNotNull(watchesReport22);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + true + "'", boolean29 == true);
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "" + "'", str32, "");
        org.junit.Assert.assertNotNull(watchesSummary33);
        org.junit.Assert.assertNotNull(aCLArray37);
        org.junit.Assert.assertArrayEquals(aCLArray37, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNull(watcherOrBitSet41);
        org.junit.Assert.assertNull(watcherOrBitSet43);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + true + "'", boolean48 == true);
        org.junit.Assert.assertNotNull(watchesPathReport49);
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test208");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        java.lang.String str13 = watchManager0.toString();
        java.lang.Class<?> wildcardClass14 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "" + "'", str13, "");
        org.junit.Assert.assertNotNull(wildcardClass14);
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test209");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport10 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager14 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager14.addWatch("", watcher16);
        org.apache.zookeeper.Watcher watcher18 = null;
        watchManager14.removeWatcher(watcher18);
        java.lang.String str20 = watchManager14.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary21 = watchManager14.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType23 = null;
        org.apache.zookeeper.data.ACL[] aCLArray25 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList26 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean27 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList26, aCLArray25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager14.triggerWatch("", eventType23, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26, watcherOrBitSet28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager0.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26, watcherOrBitSet30);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport32 = watchManager0.getWatches();
        int int33 = watchManager0.size();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "" + "'", str9, "");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "" + "'", str20, "");
        org.junit.Assert.assertNotNull(watchesSummary21);
        org.junit.Assert.assertNotNull(aCLArray25);
        org.junit.Assert.assertArrayEquals(aCLArray25, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNull(watcherOrBitSet29);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNotNull(watchesReport32);
        org.junit.Assert.assertTrue("'" + int33 + "' != '" + 0 + "'", int33 == 0);
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test210");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter13 = null;
        watchManager0.dumpWatches(printWriter13, true);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport16 = watchManager0.getWatches();
        java.lang.String str17 = watchManager0.toString();
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertNotNull(watchesReport16);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "" + "'", str17, "");
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test211");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher18 = null;
        watchManager0.removeWatcher(watcher18);
        java.lang.String str20 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher21 = null;
        watchManager0.removeWatcher(watcher21);
        org.apache.zookeeper.Watcher watcher24 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode25 = null;
        boolean boolean26 = watchManager0.removeWatcher("", watcher24, watcherMode25);
        java.io.PrintWriter printWriter27 = null;
        watchManager0.dumpWatches(printWriter27, false);
        org.apache.zookeeper.Watcher watcher31 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode32 = null;
        boolean boolean33 = watchManager0.removeWatcher("null\n\tnull\n\t\n\n", watcher31, watcherMode32);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "" + "'", str20, "");
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test212");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary7 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType9 = null;
        org.apache.zookeeper.data.ACL[] aCLArray11 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList12 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean13 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList12, aCLArray11);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet15 = watchManager0.triggerWatch("", eventType9, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList12, watcherOrBitSet14);
        org.apache.zookeeper.Watcher.Event.EventType eventType17 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager19 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager19.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher26 = null;
        boolean boolean27 = watchManager24.addWatch("", watcher26);
        org.apache.zookeeper.Watcher watcher28 = null;
        watchManager24.removeWatcher(watcher28);
        java.lang.String str30 = watchManager24.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary31 = watchManager24.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType33 = null;
        org.apache.zookeeper.data.ACL[] aCLArray35 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList36 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean37 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList36, aCLArray35);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet38 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = watchManager24.triggerWatch("", eventType33, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList36, watcherOrBitSet38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = watchManager19.triggerWatch("", eventType22, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList36);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager0.triggerWatch("null\n\t\n", eventType17, (long) (byte) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList36);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 7");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertNotNull(watchesSummary7);
        org.junit.Assert.assertNotNull(aCLArray11);
        org.junit.Assert.assertArrayEquals(aCLArray11, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNull(watcherOrBitSet15);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + true + "'", boolean27 == true);
        org.junit.Assert.assertEquals("'" + str30 + "' != '" + "" + "'", str30, "");
        org.junit.Assert.assertNotNull(watchesSummary31);
        org.junit.Assert.assertNotNull(aCLArray35);
        org.junit.Assert.assertArrayEquals(aCLArray35, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertNull(watcherOrBitSet39);
        org.junit.Assert.assertNull(watcherOrBitSet40);
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test213");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport10 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.containsWatcher("null\n\t\n", watcher12);
        org.apache.zookeeper.Watcher watcher14 = null;
        watchManager0.removeWatcher(watcher14);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesPathReport9);
        org.junit.Assert.assertNotNull(watchesPathReport10);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test214");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.containsWatcher("", watcher9);
        org.apache.zookeeper.Watcher watcher12 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode13 = null;
        boolean boolean14 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher12, watcherMode13);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test215");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("null\n\t\n", watcher3, watcherMode4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("null\n\t\n", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher11);
        java.lang.String str13 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "" + "'", str13, "");
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test216");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher18 = null;
        watchManager0.removeWatcher(watcher18);
        java.lang.String str20 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher22 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode23 = null;
        boolean boolean24 = watchManager0.removeWatcher("null\n\tnull\n\t\n\n", watcher22, watcherMode23);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "" + "'", str20, "");
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test217");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("null\n\t\n", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("hi!", watcher11);
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        java.util.List<org.apache.zookeeper.data.ACL> aCLList16 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = watchManager0.triggerWatch("hi!", eventType14, (long) (short) 0, aCLList16);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test218");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher8);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport10 = watchManager0.getWatchesByPath();
        int int11 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesPathReport10);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test219");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.removeWatcher("hi!", watcher14);
        java.lang.String str16 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.containsWatcher("null\n\thi!\n", watcher18);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "" + "'", str16, "");
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test220");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("null\n\t\n", watcher3, watcherMode4);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.containsWatcher("null\n\t\n", watcher8);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test221");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport10 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.containsWatcher("null\n\t\n", watcher12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("", watcher15, watcherMode16);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesPathReport9);
        org.junit.Assert.assertNotNull(watchesPathReport10);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test222");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("hi!", watcher11);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertNotNull(watchesPathReport9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test223");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("null\n\t\n", watcher10);
        org.apache.zookeeper.Watcher watcher12 = null;
        watchManager0.removeWatcher(watcher12);
        int int14 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport15 = watchManager0.getWatches();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
        org.junit.Assert.assertNotNull(watchesReport15);
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test224");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter13 = null;
        watchManager0.dumpWatches(printWriter13, true);
        java.lang.String str16 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.removeWatcher("null\n\t\n", watcher18);
        org.apache.zookeeper.Watcher watcher21 = null;
        boolean boolean22 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher21);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "" + "'", str16, "");
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test225");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("null\n\t\n", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("null\n\t\n", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        boolean boolean16 = watchManager0.containsWatcher("null\n\thi!\n", watcher14, watcherMode15);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test226");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("null\n\thi!\n", watcher11);
        org.apache.zookeeper.Watcher watcher13 = null;
        watchManager0.removeWatcher(watcher13);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesPathReport9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test227");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport10 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager14 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager14.addWatch("", watcher16);
        org.apache.zookeeper.Watcher watcher18 = null;
        watchManager14.removeWatcher(watcher18);
        java.lang.String str20 = watchManager14.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary21 = watchManager14.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType23 = null;
        org.apache.zookeeper.data.ACL[] aCLArray25 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList26 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean27 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList26, aCLArray25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager14.triggerWatch("", eventType23, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26, watcherOrBitSet28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager0.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26, watcherOrBitSet30);
        org.apache.zookeeper.Watcher watcher33 = null;
        boolean boolean34 = watchManager0.addWatch("hi!", watcher33);
        org.apache.zookeeper.Watcher watcher36 = null;
        boolean boolean37 = watchManager0.containsWatcher("", watcher36);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "" + "'", str9, "");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "" + "'", str20, "");
        org.junit.Assert.assertNotNull(watchesSummary21);
        org.junit.Assert.assertNotNull(aCLArray25);
        org.junit.Assert.assertArrayEquals(aCLArray25, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNull(watcherOrBitSet29);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + true + "'", boolean34 == true);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test228");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher18 = null;
        watchManager0.removeWatcher(watcher18);
        java.lang.String str20 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher21 = null;
        watchManager0.removeWatcher(watcher21);
        org.apache.zookeeper.Watcher watcher24 = null;
        boolean boolean25 = watchManager0.removeWatcher("null\n\tnull\n\t\n\tnull\n\t\n\n\n", watcher24);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "" + "'", str20, "");
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test229");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        int int18 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        boolean boolean22 = watchManager0.containsWatcher("hi!", watcher20, watcherMode21);
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport24 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 0 + "'", int18 == 0);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(watchesPathReport24);
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test230");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager0.removeWatcher("hi!", watcher15);
        org.apache.zookeeper.Watcher.Event.EventType eventType18 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager20 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.data.ACL[] aCLArray24 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList25 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean26 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList25, aCLArray24);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = watchManager20.triggerWatch("", eventType22, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList25, watcherOrBitSet27);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager0.triggerWatch("null\n\t\n\tnull\n\t\n\n", eventType18, (long) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList25);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 16");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(aCLArray24);
        org.junit.Assert.assertArrayEquals(aCLArray24, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertNull(watcherOrBitSet28);
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test231");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        int int18 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        boolean boolean22 = watchManager0.containsWatcher("hi!", watcher20, watcherMode21);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport23 = watchManager0.getWatches();
        java.lang.String str24 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 0 + "'", int18 == 0);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(watchesReport23);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "" + "'", str24, "");
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test232");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.addWatch("null\n\t\n", watcher5);
        java.lang.String str7 = watchManager0.toString();
        watchManager0.shutdown();
        int int9 = watchManager0.size();
        int int10 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.addWatch("", watcher12);
        java.lang.String str14 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "null\n\t\n\tnull\n\t\n\n" + "'", str7, "null\n\t\n\tnull\n\t\n\n");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 2 + "'", int9 == 2);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 2 + "'", int10 == 2);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "null\n\t\n\tnull\n\t\n\n" + "'", str14, "null\n\t\n\tnull\n\t\n\n");
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test233");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("hi!", watcher3, watcherMode4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = watchManager0.addWatch("null\n\tnull\n\t\n\tnull\n\t\n\n\n", watcher7, watcherMode8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test234");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.addWatch("null\n\t\n", watcher6);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test235");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("null\n\t\n", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("null\n\t\n", watcher11);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager17 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher19 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode20 = null;
        boolean boolean21 = watchManager17.containsWatcher("hi!", watcher19, watcherMode20);
        java.lang.String str22 = watchManager17.toString();
        org.apache.zookeeper.Watcher watcher24 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode25 = null;
        boolean boolean26 = watchManager17.containsWatcher("", watcher24, watcherMode25);
        org.apache.zookeeper.Watcher.Event.EventType eventType28 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager30 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport31 = watchManager30.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher33 = null;
        boolean boolean34 = watchManager30.addWatch("hi!", watcher33);
        org.apache.zookeeper.Watcher watcher36 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode37 = null;
        boolean boolean38 = watchManager30.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher36, watcherMode37);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary39 = watchManager30.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType41 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager43 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType45 = null;
        org.apache.zookeeper.data.ACL[] aCLArray47 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList48 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean49 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList48, aCLArray47);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet50 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet51 = watchManager43.triggerWatch("", eventType45, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList48, watcherOrBitSet50);
        java.lang.String str52 = watchManager43.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport53 = watchManager43.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType55 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager57 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher59 = null;
        boolean boolean60 = watchManager57.addWatch("", watcher59);
        org.apache.zookeeper.Watcher watcher61 = null;
        watchManager57.removeWatcher(watcher61);
        java.lang.String str63 = watchManager57.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary64 = watchManager57.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType66 = null;
        org.apache.zookeeper.data.ACL[] aCLArray68 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList69 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean70 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList69, aCLArray68);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet71 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet72 = watchManager57.triggerWatch("", eventType66, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList69, watcherOrBitSet71);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet73 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet74 = watchManager43.triggerWatch("", eventType55, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList69, watcherOrBitSet73);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet75 = watchManager30.triggerWatch("", eventType41, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList69);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet76 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet77 = watchManager17.triggerWatch("", eventType28, (long) (byte) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList69, watcherOrBitSet76);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet78 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet79 = watchManager0.triggerWatch("null\n\t\n\tnull\n\t\n\n", eventType15, (long) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList69, watcherOrBitSet78);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 16");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "" + "'", str22, "");
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertNotNull(watchesPathReport31);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + true + "'", boolean34 == true);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertNotNull(watchesSummary39);
        org.junit.Assert.assertNotNull(aCLArray47);
        org.junit.Assert.assertArrayEquals(aCLArray47, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + false + "'", boolean49 == false);
        org.junit.Assert.assertNull(watcherOrBitSet51);
        org.junit.Assert.assertEquals("'" + str52 + "' != '" + "" + "'", str52, "");
        org.junit.Assert.assertNotNull(watchesReport53);
        org.junit.Assert.assertTrue("'" + boolean60 + "' != '" + true + "'", boolean60 == true);
        org.junit.Assert.assertEquals("'" + str63 + "' != '" + "" + "'", str63, "");
        org.junit.Assert.assertNotNull(watchesSummary64);
        org.junit.Assert.assertNotNull(aCLArray68);
        org.junit.Assert.assertArrayEquals(aCLArray68, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean70 + "' != '" + false + "'", boolean70 == false);
        org.junit.Assert.assertNull(watcherOrBitSet72);
        org.junit.Assert.assertNull(watcherOrBitSet74);
        org.junit.Assert.assertNull(watcherOrBitSet75);
        org.junit.Assert.assertNull(watcherOrBitSet77);
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test236");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher6, watcherMode7);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.removeWatcher("null\n\t\n", watcher11);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test237");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("", watcher13);
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.data.ACL[] aCLArray22 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList23 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean24 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList23, aCLArray22);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager18.triggerWatch("", eventType20, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23, watcherOrBitSet25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = watchManager0.triggerWatch("", eventType16, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23);
        java.io.PrintWriter printWriter28 = null;
        watchManager0.dumpWatches(printWriter28, false);
        java.lang.Class<?> wildcardClass31 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(aCLArray22);
        org.junit.Assert.assertArrayEquals(aCLArray22, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNull(watcherOrBitSet26);
        org.junit.Assert.assertNull(watcherOrBitSet27);
        org.junit.Assert.assertNotNull(wildcardClass31);
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test238");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.containsWatcher("", watcher19);
        java.io.PrintWriter printWriter21 = null;
        watchManager0.dumpWatches(printWriter21, false);
        java.lang.String str24 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "" + "'", str24, "");
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test239");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("", watcher7, watcherMode8);
        int int10 = watchManager0.size();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.addWatch("", watcher13);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test240");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher7, watcherMode8);
        java.lang.String str10 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.containsWatcher("null\n\thi!\n", watcher12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean17 = watchManager0.addWatch("hi!", watcher15, watcherMode16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "" + "'", str10, "");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test241");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.containsWatcher("", watcher19);
        java.io.PrintWriter printWriter21 = null;
        watchManager0.dumpWatches(printWriter21, false);
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager27 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher29 = null;
        boolean boolean30 = watchManager27.addWatch("", watcher29);
        org.apache.zookeeper.Watcher watcher31 = null;
        watchManager27.removeWatcher(watcher31);
        java.lang.String str33 = watchManager27.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary34 = watchManager27.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType36 = null;
        org.apache.zookeeper.data.ACL[] aCLArray38 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList39 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean40 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList39, aCLArray38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager27.triggerWatch("", eventType36, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39, watcherOrBitSet41);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager0.triggerWatch("null\n\tnull\n\t\n\n", eventType25, (long) (byte) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 14");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + true + "'", boolean30 == true);
        org.junit.Assert.assertEquals("'" + str33 + "' != '" + "" + "'", str33, "");
        org.junit.Assert.assertNotNull(watchesSummary34);
        org.junit.Assert.assertNotNull(aCLArray38);
        org.junit.Assert.assertArrayEquals(aCLArray38, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertNull(watcherOrBitSet42);
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test242");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.addWatch("null\n\t\n", watcher12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.containsWatcher("null\n\tnull\n\t\n\tnull\n\t\n\n\n", watcher15, watcherMode16);
        int int18 = watchManager0.size();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher21 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode22 = null;
        boolean boolean23 = watchManager0.removeWatcher("null\n\thi!\n", watcher21, watcherMode22);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 2 + "'", int18 == 2);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test243");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.addWatch("", watcher10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("hi!", watcher13);
        java.io.PrintWriter printWriter15 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter15, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.println(String)\" because \"writer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test244");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.removeWatcher("hi!", watcher13);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.Watcher watcher17 = null;
        watchManager0.removeWatcher(watcher17);
        java.lang.String str19 = watchManager0.toString();
        org.apache.zookeeper.Watcher.Event.EventType eventType21 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager23 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher25 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode26 = null;
        boolean boolean27 = watchManager23.containsWatcher("hi!", watcher25, watcherMode26);
        java.lang.String str28 = watchManager23.toString();
        org.apache.zookeeper.Watcher watcher30 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode31 = null;
        boolean boolean32 = watchManager23.containsWatcher("", watcher30, watcherMode31);
        org.apache.zookeeper.Watcher.Event.EventType eventType34 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager36 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport37 = watchManager36.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher39 = null;
        boolean boolean40 = watchManager36.addWatch("hi!", watcher39);
        org.apache.zookeeper.Watcher watcher42 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode43 = null;
        boolean boolean44 = watchManager36.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher42, watcherMode43);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary45 = watchManager36.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType47 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager49 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType51 = null;
        org.apache.zookeeper.data.ACL[] aCLArray53 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList54 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean55 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList54, aCLArray53);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet56 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet57 = watchManager49.triggerWatch("", eventType51, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList54, watcherOrBitSet56);
        java.lang.String str58 = watchManager49.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport59 = watchManager49.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType61 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager63 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher65 = null;
        boolean boolean66 = watchManager63.addWatch("", watcher65);
        org.apache.zookeeper.Watcher watcher67 = null;
        watchManager63.removeWatcher(watcher67);
        java.lang.String str69 = watchManager63.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary70 = watchManager63.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType72 = null;
        org.apache.zookeeper.data.ACL[] aCLArray74 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList75 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean76 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList75, aCLArray74);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet77 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet78 = watchManager63.triggerWatch("", eventType72, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList75, watcherOrBitSet77);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet79 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet80 = watchManager49.triggerWatch("", eventType61, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList75, watcherOrBitSet79);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet81 = watchManager36.triggerWatch("", eventType47, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList75);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet82 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet83 = watchManager23.triggerWatch("", eventType34, (long) (byte) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList75, watcherOrBitSet82);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet84 = watchManager0.triggerWatch("null\n\thi!\n", eventType21, (long) 'a', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList75);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 10");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "" + "'", str19, "");
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertEquals("'" + str28 + "' != '" + "" + "'", str28, "");
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNotNull(watchesPathReport37);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + true + "'", boolean40 == true);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertNotNull(watchesSummary45);
        org.junit.Assert.assertNotNull(aCLArray53);
        org.junit.Assert.assertArrayEquals(aCLArray53, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean55 + "' != '" + false + "'", boolean55 == false);
        org.junit.Assert.assertNull(watcherOrBitSet57);
        org.junit.Assert.assertEquals("'" + str58 + "' != '" + "" + "'", str58, "");
        org.junit.Assert.assertNotNull(watchesReport59);
        org.junit.Assert.assertTrue("'" + boolean66 + "' != '" + true + "'", boolean66 == true);
        org.junit.Assert.assertEquals("'" + str69 + "' != '" + "" + "'", str69, "");
        org.junit.Assert.assertNotNull(watchesSummary70);
        org.junit.Assert.assertNotNull(aCLArray74);
        org.junit.Assert.assertArrayEquals(aCLArray74, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean76 + "' != '" + false + "'", boolean76 == false);
        org.junit.Assert.assertNull(watcherOrBitSet78);
        org.junit.Assert.assertNull(watcherOrBitSet80);
        org.junit.Assert.assertNull(watcherOrBitSet81);
        org.junit.Assert.assertNull(watcherOrBitSet83);
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test245");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.removeWatcher("", watcher11);
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager16 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        boolean boolean20 = watchManager16.containsWatcher("hi!", watcher18, watcherMode19);
        java.io.PrintWriter printWriter21 = null;
        watchManager16.dumpWatches(printWriter21, false);
        org.apache.zookeeper.Watcher watcher25 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode26 = null;
        boolean boolean27 = watchManager16.containsWatcher("hi!", watcher25, watcherMode26);
        org.apache.zookeeper.Watcher watcher29 = null;
        boolean boolean30 = watchManager16.containsWatcher("", watcher29);
        org.apache.zookeeper.Watcher.Event.EventType eventType32 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager34 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType36 = null;
        org.apache.zookeeper.data.ACL[] aCLArray38 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList39 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean40 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList39, aCLArray38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager34.triggerWatch("", eventType36, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39, watcherOrBitSet41);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager16.triggerWatch("", eventType32, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = watchManager0.triggerWatch("null\n\t\n\tnull\n\t\n\n", eventType14, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39, watcherOrBitSet44);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 16");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertNotNull(aCLArray38);
        org.junit.Assert.assertArrayEquals(aCLArray38, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertNull(watcherOrBitSet42);
        org.junit.Assert.assertNull(watcherOrBitSet43);
    }

    @Test
    public void test246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test246");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("", watcher7, watcherMode8);
        int int10 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher12);
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager17 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager17.addWatch("", watcher19);
        org.apache.zookeeper.Watcher watcher21 = null;
        watchManager17.removeWatcher(watcher21);
        org.apache.zookeeper.Watcher watcher24 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode25 = null;
        boolean boolean26 = watchManager17.containsWatcher("null\n\t\n", watcher24, watcherMode25);
        org.apache.zookeeper.Watcher.Event.EventType eventType28 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager30 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport31 = watchManager30.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher33 = null;
        boolean boolean34 = watchManager30.addWatch("hi!", watcher33);
        org.apache.zookeeper.Watcher watcher36 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode37 = null;
        boolean boolean38 = watchManager30.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher36, watcherMode37);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary39 = watchManager30.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType41 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager43 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType45 = null;
        org.apache.zookeeper.data.ACL[] aCLArray47 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList48 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean49 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList48, aCLArray47);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet50 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet51 = watchManager43.triggerWatch("", eventType45, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList48, watcherOrBitSet50);
        java.lang.String str52 = watchManager43.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport53 = watchManager43.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType55 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager57 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher59 = null;
        boolean boolean60 = watchManager57.addWatch("", watcher59);
        org.apache.zookeeper.Watcher watcher61 = null;
        watchManager57.removeWatcher(watcher61);
        java.lang.String str63 = watchManager57.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary64 = watchManager57.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType66 = null;
        org.apache.zookeeper.data.ACL[] aCLArray68 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList69 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean70 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList69, aCLArray68);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet71 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet72 = watchManager57.triggerWatch("", eventType66, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList69, watcherOrBitSet71);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet73 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet74 = watchManager43.triggerWatch("", eventType55, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList69, watcherOrBitSet73);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet75 = watchManager30.triggerWatch("", eventType41, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList69);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet76 = watchManager17.triggerWatch("", eventType28, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList69);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet77 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet78 = watchManager0.triggerWatch("null\n\tnull\n\t\n\n", eventType15, (long) (short) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList69, watcherOrBitSet77);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 14");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertNotNull(watchesPathReport31);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + true + "'", boolean34 == true);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertNotNull(watchesSummary39);
        org.junit.Assert.assertNotNull(aCLArray47);
        org.junit.Assert.assertArrayEquals(aCLArray47, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + false + "'", boolean49 == false);
        org.junit.Assert.assertNull(watcherOrBitSet51);
        org.junit.Assert.assertEquals("'" + str52 + "' != '" + "" + "'", str52, "");
        org.junit.Assert.assertNotNull(watchesReport53);
        org.junit.Assert.assertTrue("'" + boolean60 + "' != '" + true + "'", boolean60 == true);
        org.junit.Assert.assertEquals("'" + str63 + "' != '" + "" + "'", str63, "");
        org.junit.Assert.assertNotNull(watchesSummary64);
        org.junit.Assert.assertNotNull(aCLArray68);
        org.junit.Assert.assertArrayEquals(aCLArray68, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean70 + "' != '" + false + "'", boolean70 == false);
        org.junit.Assert.assertNull(watcherOrBitSet72);
        org.junit.Assert.assertNull(watcherOrBitSet74);
        org.junit.Assert.assertNull(watcherOrBitSet75);
        org.junit.Assert.assertNull(watcherOrBitSet76);
    }

    @Test
    public void test247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test247");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("null\n\t\n", watcher10);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test248");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("", watcher3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport8 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "null\n\t\n" + "'", str5, "null\n\t\n");
        org.junit.Assert.assertNotNull(watchesPathReport8);
        org.junit.Assert.assertNotNull(watchesPathReport9);
    }

    @Test
    public void test249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test249");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher4);
        int int6 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("null\n\thi!\n", watcher8);
        org.apache.zookeeper.Watcher watcher10 = null;
        watchManager0.removeWatcher(watcher10);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test250");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("null\n\t\n", watcher3, watcherMode4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("null\n\t\n", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher11);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary14 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
        org.junit.Assert.assertNotNull(watchesSummary14);
    }

    @Test
    public void test251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test251");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.addWatch("null\n\t\n\tnull\n\t\n\n", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        boolean boolean16 = watchManager0.containsWatcher("null\n\tnull\n\t\n\tnull\n\t\n\n\n", watcher14, watcherMode15);
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        boolean boolean20 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher18, watcherMode19);
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.data.ACL[] aCLArray24 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList25 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean26 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList25, aCLArray24);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = watchManager0.triggerWatch("null\n\thi!\n", eventType22, (long) (short) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList25, watcherOrBitSet27);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 10");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
        org.junit.Assert.assertNotNull(aCLArray24);
        org.junit.Assert.assertArrayEquals(aCLArray24, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
    }

    @Test
    public void test252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test252");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.addWatch("null\n\t\n", watcher10);
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary13 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.containsWatcher("hi!", watcher15, watcherMode16);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNotNull(watchesSummary13);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test253");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("hi!", watcher3, watcherMode4);
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("null\n\t\n", watcher7);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesPathReport9);
    }

    @Test
    public void test254() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test254");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager12.triggerWatch("", eventType14, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet19);
        java.lang.String str21 = watchManager12.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport22 = watchManager12.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager26 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher28 = null;
        boolean boolean29 = watchManager26.addWatch("", watcher28);
        org.apache.zookeeper.Watcher watcher30 = null;
        watchManager26.removeWatcher(watcher30);
        java.lang.String str32 = watchManager26.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary33 = watchManager26.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.data.ACL[] aCLArray37 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList38 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean39 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList38, aCLArray37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager26.triggerWatch("", eventType35, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager12.triggerWatch("", eventType24, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager0.triggerWatch("", eventType10, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher47 = null;
        boolean boolean48 = watchManager0.removeWatcher("hi!", watcher47);
        org.apache.zookeeper.Watcher watcher50 = null;
        boolean boolean51 = watchManager0.addWatch("null\n\t\n\tnull\n\t\n\n", watcher50);
        java.lang.String str52 = watchManager0.toString();
        java.lang.Class<?> wildcardClass53 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "" + "'", str21, "");
        org.junit.Assert.assertNotNull(watchesReport22);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + true + "'", boolean29 == true);
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "" + "'", str32, "");
        org.junit.Assert.assertNotNull(watchesSummary33);
        org.junit.Assert.assertNotNull(aCLArray37);
        org.junit.Assert.assertArrayEquals(aCLArray37, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNull(watcherOrBitSet41);
        org.junit.Assert.assertNull(watcherOrBitSet43);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + true + "'", boolean48 == true);
        org.junit.Assert.assertTrue("'" + boolean51 + "' != '" + true + "'", boolean51 == true);
        org.junit.Assert.assertEquals("'" + str52 + "' != '" + "null\n\tnull\n\t\n\tnull\n\t\n\n\n" + "'", str52, "null\n\tnull\n\t\n\tnull\n\t\n\n\n");
        org.junit.Assert.assertNotNull(wildcardClass53);
    }

    @Test
    public void test255() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test255");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.removeWatcher("", watcher14);
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.containsWatcher("null\n\t\n", watcher17);
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        boolean boolean22 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher20, watcherMode21);
        java.io.PrintWriter printWriter23 = null;
        watchManager0.dumpWatches(printWriter23, true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test256() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test256");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.addWatch("null\n\t\n", watcher5);
        java.lang.String str7 = watchManager0.toString();
        watchManager0.shutdown();
        int int9 = watchManager0.size();
        int int10 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.addWatch("", watcher12);
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "null\n\t\n\tnull\n\t\n\n" + "'", str7, "null\n\t\n\tnull\n\t\n\n");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 2 + "'", int9 == 2);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 2 + "'", int10 == 2);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test257() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test257");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("", watcher7, watcherMode8);
        int int10 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher12 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode13 = null;
        boolean boolean14 = watchManager0.containsWatcher("hi!", watcher12, watcherMode13);
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.addWatch("null\n\tnull\n\t\n\tnull\n\t\n\n\n", watcher16);
        org.apache.zookeeper.Watcher watcher19 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode20 = null;
        boolean boolean21 = watchManager0.containsWatcher("", watcher19, watcherMode20);
        java.io.PrintWriter printWriter22 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter22, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.print(String)\" because \"writer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
    }

    @Test
    public void test258() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test258");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.removeWatcher("", watcher14);
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.containsWatcher("null\n\t\n", watcher17);
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        boolean boolean22 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher20, watcherMode21);
        int int23 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher25 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode26 = null;
        boolean boolean27 = watchManager0.removeWatcher("null\n\thi!\n", watcher25, watcherMode26);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + 0 + "'", int23 == 0);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
    }

    @Test
    public void test259() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test259");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("", watcher13);
        java.io.PrintWriter printWriter15 = null;
        watchManager0.dumpWatches(printWriter15, true);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary18 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher20 = null;
        boolean boolean21 = watchManager0.addWatch("", watcher20);
        java.lang.Class<?> wildcardClass22 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(watchesSummary18);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + true + "'", boolean21 == true);
        org.junit.Assert.assertNotNull(wildcardClass22);
    }

    @Test
    public void test260() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test260");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher4);
        int int6 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean10 = watchManager0.addWatch("null\n\tnull\n\t\n\n", watcher8, watcherMode9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test261() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test261");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("null\n\t\n", watcher13);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        boolean boolean19 = watchManager0.removeWatcher("null\n\t\n", watcher17, watcherMode18);
        int int20 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 1 + "'", int20 == 1);
    }

    @Test
    public void test262() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test262");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        int int18 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        boolean boolean22 = watchManager0.containsWatcher("hi!", watcher20, watcherMode21);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport23 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher25 = null;
        boolean boolean26 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher25);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 0 + "'", int18 == 0);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(watchesReport23);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
    }

    @Test
    public void test263() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test263");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("", watcher13);
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.data.ACL[] aCLArray22 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList23 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean24 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList23, aCLArray22);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager18.triggerWatch("", eventType20, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23, watcherOrBitSet25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = watchManager0.triggerWatch("", eventType16, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23);
        java.io.PrintWriter printWriter28 = null;
        watchManager0.dumpWatches(printWriter28, false);
        org.apache.zookeeper.Watcher watcher32 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode33 = null;
        boolean boolean34 = watchManager0.removeWatcher("hi!", watcher32, watcherMode33);
        org.apache.zookeeper.Watcher watcher36 = null;
        boolean boolean37 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher36);
        int int38 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher40 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode41 = null;
        boolean boolean42 = watchManager0.containsWatcher("", watcher40, watcherMode41);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(aCLArray22);
        org.junit.Assert.assertArrayEquals(aCLArray22, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNull(watcherOrBitSet26);
        org.junit.Assert.assertNull(watcherOrBitSet27);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertTrue("'" + int38 + "' != '" + 0 + "'", int38 == 0);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
    }

    @Test
    public void test264() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test264");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher18 = null;
        watchManager0.removeWatcher(watcher18);
        org.apache.zookeeper.Watcher watcher21 = null;
        boolean boolean22 = watchManager0.addWatch("hi!", watcher21);
        watchManager0.shutdown();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport24 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
    }

    @Test
    public void test265() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test265");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.removeWatcher("null\n\tnull\n\t\n\tnull\n\t\n\n\n", watcher7);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test266() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test266");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("null\n\t\n", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager13 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport14 = watchManager13.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager13.addWatch("hi!", watcher16);
        org.apache.zookeeper.Watcher watcher19 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode20 = null;
        boolean boolean21 = watchManager13.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher19, watcherMode20);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary22 = watchManager13.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager26 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType28 = null;
        org.apache.zookeeper.data.ACL[] aCLArray30 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList31 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean32 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList31, aCLArray30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager26.triggerWatch("", eventType28, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList31, watcherOrBitSet33);
        java.lang.String str35 = watchManager26.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport36 = watchManager26.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType38 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager40 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher42 = null;
        boolean boolean43 = watchManager40.addWatch("", watcher42);
        org.apache.zookeeper.Watcher watcher44 = null;
        watchManager40.removeWatcher(watcher44);
        java.lang.String str46 = watchManager40.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary47 = watchManager40.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType49 = null;
        org.apache.zookeeper.data.ACL[] aCLArray51 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList52 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean53 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList52, aCLArray51);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet54 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet55 = watchManager40.triggerWatch("", eventType49, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList52, watcherOrBitSet54);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet56 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet57 = watchManager26.triggerWatch("", eventType38, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList52, watcherOrBitSet56);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet58 = watchManager13.triggerWatch("", eventType24, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList52);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet59 = watchManager0.triggerWatch("", eventType11, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList52);
        org.apache.zookeeper.Watcher watcher61 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode62 = null;
        boolean boolean63 = watchManager0.containsWatcher("null\n\tnull\n\t\n\tnull\n\t\n\n\n", watcher61, watcherMode62);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesPathReport14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(watchesSummary22);
        org.junit.Assert.assertNotNull(aCLArray30);
        org.junit.Assert.assertArrayEquals(aCLArray30, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNull(watcherOrBitSet34);
        org.junit.Assert.assertEquals("'" + str35 + "' != '" + "" + "'", str35, "");
        org.junit.Assert.assertNotNull(watchesReport36);
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + true + "'", boolean43 == true);
        org.junit.Assert.assertEquals("'" + str46 + "' != '" + "" + "'", str46, "");
        org.junit.Assert.assertNotNull(watchesSummary47);
        org.junit.Assert.assertNotNull(aCLArray51);
        org.junit.Assert.assertArrayEquals(aCLArray51, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean53 + "' != '" + false + "'", boolean53 == false);
        org.junit.Assert.assertNull(watcherOrBitSet55);
        org.junit.Assert.assertNull(watcherOrBitSet57);
        org.junit.Assert.assertNull(watcherOrBitSet58);
        org.junit.Assert.assertNull(watcherOrBitSet59);
        org.junit.Assert.assertTrue("'" + boolean63 + "' != '" + false + "'", boolean63 == false);
    }

    @Test
    public void test267() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test267");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        java.lang.String str10 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport11 = watchManager0.getWatches();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertNotNull(watchesSummary9);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "" + "'", str10, "");
        org.junit.Assert.assertNotNull(watchesReport11);
    }

    @Test
    public void test268() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test268");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.addWatch("null\n\t\n\tnull\n\t\n\n", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        boolean boolean16 = watchManager0.containsWatcher("null\n\tnull\n\t\n\tnull\n\t\n\n\n", watcher14, watcherMode15);
        int int17 = watchManager0.size();
        java.lang.String str18 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 1 + "'", int17 == 1);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "null\n\tnull\n\t\n\tnull\n\t\n\n\n" + "'", str18, "null\n\tnull\n\t\n\tnull\n\t\n\n\n");
    }

    @Test
    public void test269() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test269");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.removeWatcher("hi!", watcher14);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport16 = watchManager0.getWatches();
        java.lang.String str17 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(watchesReport16);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "" + "'", str17, "");
    }

    @Test
    public void test270() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test270");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("null\n\t\n", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager0.removeWatcher("", watcher15);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesPathReport9);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test271() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test271");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.removeWatcher("hi!", watcher13);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.Watcher watcher17 = null;
        watchManager0.removeWatcher(watcher17);
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        boolean boolean22 = watchManager0.containsWatcher("hi!", watcher20, watcherMode21);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test272() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test272");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("", watcher3);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager0.getWatchesSummary();
        watchManager0.shutdown();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(watchesSummary5);
    }

    @Test
    public void test273() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test273");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("null\n\t\n", watcher3, watcherMode4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("null\n\t\n", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher11);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        int int14 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        boolean boolean18 = watchManager0.removeWatcher("null\n\thi!\n", watcher16, watcherMode17);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test274() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test274");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.removeWatcher("hi!", watcher14);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport16 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.addWatch("null\n\t\n\tnull\n\t\n\n", watcher18);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(watchesReport16);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
    }

    @Test
    public void test275() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test275");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        boolean boolean10 = watchManager0.removeWatcher("null\n\tnull\n\t\n\tnull\n\t\n\n\n", watcher8, watcherMode9);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport11 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(watchesPathReport11);
    }

    @Test
    public void test276() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test276");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher6, watcherMode7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager13 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.data.ACL[] aCLArray17 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList18 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean19 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList18, aCLArray17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet21 = watchManager13.triggerWatch("", eventType15, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList18, watcherOrBitSet20);
        java.lang.String str22 = watchManager13.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport23 = watchManager13.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager27 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher29 = null;
        boolean boolean30 = watchManager27.addWatch("", watcher29);
        org.apache.zookeeper.Watcher watcher31 = null;
        watchManager27.removeWatcher(watcher31);
        java.lang.String str33 = watchManager27.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary34 = watchManager27.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType36 = null;
        org.apache.zookeeper.data.ACL[] aCLArray38 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList39 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean40 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList39, aCLArray38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager27.triggerWatch("", eventType36, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39, watcherOrBitSet41);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager13.triggerWatch("", eventType25, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39, watcherOrBitSet43);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = watchManager0.triggerWatch("", eventType11, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39);
        org.apache.zookeeper.Watcher watcher47 = null;
        boolean boolean48 = watchManager0.containsWatcher("null\n\t\n", watcher47);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport49 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesSummary9);
        org.junit.Assert.assertNotNull(aCLArray17);
        org.junit.Assert.assertArrayEquals(aCLArray17, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNull(watcherOrBitSet21);
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "" + "'", str22, "");
        org.junit.Assert.assertNotNull(watchesReport23);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + true + "'", boolean30 == true);
        org.junit.Assert.assertEquals("'" + str33 + "' != '" + "" + "'", str33, "");
        org.junit.Assert.assertNotNull(watchesSummary34);
        org.junit.Assert.assertNotNull(aCLArray38);
        org.junit.Assert.assertArrayEquals(aCLArray38, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertNull(watcherOrBitSet42);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertNull(watcherOrBitSet45);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + false + "'", boolean48 == false);
    }

    @Test
    public void test277() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test277");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager12.triggerWatch("", eventType14, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet19);
        java.lang.String str21 = watchManager12.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport22 = watchManager12.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager26 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher28 = null;
        boolean boolean29 = watchManager26.addWatch("", watcher28);
        org.apache.zookeeper.Watcher watcher30 = null;
        watchManager26.removeWatcher(watcher30);
        java.lang.String str32 = watchManager26.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary33 = watchManager26.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.data.ACL[] aCLArray37 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList38 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean39 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList38, aCLArray37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager26.triggerWatch("", eventType35, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager12.triggerWatch("", eventType24, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager0.triggerWatch("", eventType10, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher47 = null;
        boolean boolean48 = watchManager0.removeWatcher("hi!", watcher47);
        org.apache.zookeeper.Watcher watcher50 = null;
        boolean boolean51 = watchManager0.addWatch("null\n\t\n\tnull\n\t\n\n", watcher50);
        java.lang.String str52 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher54 = null;
        boolean boolean55 = watchManager0.containsWatcher("null\n\t\n", watcher54);
        org.apache.zookeeper.Watcher watcher57 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode58 = null;
        boolean boolean59 = watchManager0.removeWatcher("null\n\tnull\n\t\n\tnull\n\t\n\n\n", watcher57, watcherMode58);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "" + "'", str21, "");
        org.junit.Assert.assertNotNull(watchesReport22);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + true + "'", boolean29 == true);
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "" + "'", str32, "");
        org.junit.Assert.assertNotNull(watchesSummary33);
        org.junit.Assert.assertNotNull(aCLArray37);
        org.junit.Assert.assertArrayEquals(aCLArray37, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNull(watcherOrBitSet41);
        org.junit.Assert.assertNull(watcherOrBitSet43);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + true + "'", boolean48 == true);
        org.junit.Assert.assertTrue("'" + boolean51 + "' != '" + true + "'", boolean51 == true);
        org.junit.Assert.assertEquals("'" + str52 + "' != '" + "null\n\tnull\n\t\n\tnull\n\t\n\n\n" + "'", str52, "null\n\tnull\n\t\n\tnull\n\t\n\n\n");
        org.junit.Assert.assertTrue("'" + boolean55 + "' != '" + false + "'", boolean55 == false);
        org.junit.Assert.assertTrue("'" + boolean59 + "' != '" + false + "'", boolean59 == false);
    }

    @Test
    public void test278() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test278");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.removeWatcher("hi!", watcher14);
        java.lang.String str16 = watchManager0.toString();
        java.io.PrintWriter printWriter17 = null;
        watchManager0.dumpWatches(printWriter17, false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "" + "'", str16, "");
    }

    @Test
    public void test279() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test279");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport2 = watchManager0.getWatchesByPath();
        java.lang.String str3 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.addWatch("null\n\t\n", watcher5);
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        boolean boolean10 = watchManager0.removeWatcher("null\n\thi!\n", watcher8, watcherMode9);
        org.junit.Assert.assertNotNull(watchesPathReport2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test280() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test280");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        watchManager0.shutdown();
        java.lang.String str8 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "" + "'", str8, "");
    }

    @Test
    public void test281() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test281");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager12.triggerWatch("", eventType14, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet19);
        java.lang.String str21 = watchManager12.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport22 = watchManager12.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager26 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher28 = null;
        boolean boolean29 = watchManager26.addWatch("", watcher28);
        org.apache.zookeeper.Watcher watcher30 = null;
        watchManager26.removeWatcher(watcher30);
        java.lang.String str32 = watchManager26.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary33 = watchManager26.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.data.ACL[] aCLArray37 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList38 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean39 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList38, aCLArray37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager26.triggerWatch("", eventType35, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager12.triggerWatch("", eventType24, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager0.triggerWatch("", eventType10, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher47 = null;
        boolean boolean48 = watchManager0.removeWatcher("hi!", watcher47);
        org.apache.zookeeper.Watcher watcher50 = null;
        boolean boolean51 = watchManager0.addWatch("null\n\t\n\tnull\n\t\n\n", watcher50);
        java.lang.String str52 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher54 = null;
        boolean boolean55 = watchManager0.containsWatcher("null\n\t\n", watcher54);
        org.apache.zookeeper.Watcher watcher57 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode58 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean59 = watchManager0.addWatch("null\n\t\n\tnull\n\t\n\n", watcher57, watcherMode58);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "" + "'", str21, "");
        org.junit.Assert.assertNotNull(watchesReport22);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + true + "'", boolean29 == true);
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "" + "'", str32, "");
        org.junit.Assert.assertNotNull(watchesSummary33);
        org.junit.Assert.assertNotNull(aCLArray37);
        org.junit.Assert.assertArrayEquals(aCLArray37, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNull(watcherOrBitSet41);
        org.junit.Assert.assertNull(watcherOrBitSet43);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + true + "'", boolean48 == true);
        org.junit.Assert.assertTrue("'" + boolean51 + "' != '" + true + "'", boolean51 == true);
        org.junit.Assert.assertEquals("'" + str52 + "' != '" + "null\n\tnull\n\t\n\tnull\n\t\n\n\n" + "'", str52, "null\n\tnull\n\t\n\tnull\n\t\n\n\n");
        org.junit.Assert.assertTrue("'" + boolean55 + "' != '" + false + "'", boolean55 == false);
    }

    @Test
    public void test282() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test282");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("", watcher3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("", watcher10);
        java.lang.Class<?> wildcardClass12 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "null\n\t\n" + "'", str5, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(wildcardClass12);
    }

    @Test
    public void test283() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test283");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher18 = null;
        watchManager0.removeWatcher(watcher18);
        java.lang.String str20 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher21 = null;
        watchManager0.removeWatcher(watcher21);
        org.apache.zookeeper.Watcher watcher24 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode25 = null;
        boolean boolean26 = watchManager0.removeWatcher("", watcher24, watcherMode25);
        java.io.PrintWriter printWriter27 = null;
        watchManager0.dumpWatches(printWriter27, false);
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "" + "'", str20, "");
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
    }

    @Test
    public void test284() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test284");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.addWatch("null\n\t\n", watcher5);
        java.lang.String str7 = watchManager0.toString();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        java.io.PrintWriter printWriter11 = null;
        watchManager0.dumpWatches(printWriter11, true);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.containsWatcher("", watcher15, watcherMode16);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "null\n\t\n\tnull\n\t\n\n" + "'", str7, "null\n\t\n\tnull\n\t\n\n");
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test285() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test285");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.removeWatcher("", watcher14);
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.addWatch("hi!", watcher17);
        java.lang.String str19 = watchManager0.toString();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary21 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "null\n\thi!\n" + "'", str19, "null\n\thi!\n");
        org.junit.Assert.assertNotNull(watchesSummary21);
    }

    @Test
    public void test286() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test286");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter13 = null;
        watchManager0.dumpWatches(printWriter13, true);
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean19 = watchManager0.addWatch("", watcher17, watcherMode18);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
    }

    @Test
    public void test287() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test287");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.containsWatcher("null\n\t\n", watcher8);
        java.io.PrintWriter printWriter10 = null;
        watchManager0.dumpWatches(printWriter10, true);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.containsWatcher("hi!", watcher14);
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        boolean boolean19 = watchManager0.removeWatcher("", watcher17, watcherMode18);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test288() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test288");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("", watcher13);
        java.io.PrintWriter printWriter15 = null;
        watchManager0.dumpWatches(printWriter15, true);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary18 = watchManager0.getWatchesSummary();
        java.lang.Class<?> wildcardClass19 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(watchesSummary18);
        org.junit.Assert.assertNotNull(wildcardClass19);
    }

    @Test
    public void test289() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test289");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.addWatch("null\n\t\n", watcher5);
        java.lang.String str7 = watchManager0.toString();
        watchManager0.shutdown();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport9 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "null\n\t\n\tnull\n\t\n\n" + "'", str7, "null\n\t\n\tnull\n\t\n\n");
    }

    @Test
    public void test290() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test290");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport10 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.containsWatcher("null\n\t\n", watcher12);
        java.io.PrintWriter printWriter14 = null;
        watchManager0.dumpWatches(printWriter14, false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesPathReport9);
        org.junit.Assert.assertNotNull(watchesPathReport10);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test291() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test291");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("", watcher7, watcherMode8);
        int int10 = watchManager0.size();
        watchManager0.shutdown();
        java.lang.String str12 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.addWatch("hi!", watcher14);
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.removeWatcher("null\n\t\n", watcher17);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "" + "'", str12, "");
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test292() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test292");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("", watcher13);
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.data.ACL[] aCLArray22 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList23 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean24 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList23, aCLArray22);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager18.triggerWatch("", eventType20, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23, watcherOrBitSet25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = watchManager0.triggerWatch("", eventType16, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23);
        java.io.PrintWriter printWriter28 = null;
        watchManager0.dumpWatches(printWriter28, false);
        org.apache.zookeeper.Watcher watcher32 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode33 = null;
        boolean boolean34 = watchManager0.removeWatcher("hi!", watcher32, watcherMode33);
        org.apache.zookeeper.Watcher watcher36 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode37 = null;
        boolean boolean38 = watchManager0.removeWatcher("null\n\thi!\n", watcher36, watcherMode37);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(aCLArray22);
        org.junit.Assert.assertArrayEquals(aCLArray22, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNull(watcherOrBitSet26);
        org.junit.Assert.assertNull(watcherOrBitSet27);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
    }

    @Test
    public void test293() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test293");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("null\n\t\n", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("hi!", watcher11);
        java.lang.String str13 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary14 = watchManager0.getWatchesSummary();
        java.io.PrintWriter printWriter15 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter15, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.print(String)\" because \"writer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "null\n\thi!\n" + "'", str13, "null\n\thi!\n");
        org.junit.Assert.assertNotNull(watchesSummary14);
    }

    @Test
    public void test294() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test294");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher10 = null;
        watchManager0.removeWatcher(watcher10);
        org.apache.zookeeper.Watcher watcher12 = null;
        watchManager0.removeWatcher(watcher12);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test295() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test295");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        int int10 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 1 + "'", int10 == 1);
    }

    @Test
    public void test296() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test296");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport5 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test297() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test297");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.removeWatcher("", watcher14);
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.containsWatcher("null\n\t\n", watcher17);
        org.apache.zookeeper.Watcher watcher20 = null;
        boolean boolean21 = watchManager0.containsWatcher("hi!", watcher20);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
    }

    @Test
    public void test298() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test298");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("null\n\t\n", watcher10);
        org.apache.zookeeper.Watcher watcher12 = null;
        watchManager0.removeWatcher(watcher12);
        java.lang.Class<?> wildcardClass14 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(wildcardClass14);
    }

    @Test
    public void test299() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test299");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.addWatch("null\n\t\n", watcher5);
        java.lang.String str7 = watchManager0.toString();
        watchManager0.shutdown();
        int int9 = watchManager0.size();
        int int10 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.addWatch("", watcher12);
        java.lang.Class<?> wildcardClass14 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "null\n\t\n\tnull\n\t\n\n" + "'", str7, "null\n\t\n\tnull\n\t\n\n");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 2 + "'", int9 == 2);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 2 + "'", int10 == 2);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(wildcardClass14);
    }

    @Test
    public void test300() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test300");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.addWatch("null\n\t\n\tnull\n\t\n\n", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.containsWatcher("null\n\t\n", watcher14);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport16 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test301() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test301");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.removeWatcher("hi!", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.containsWatcher("hi!", watcher16);
        org.apache.zookeeper.Watcher.Event.EventType eventType19 = null;
        java.util.List<org.apache.zookeeper.data.ACL> aCLList21 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = watchManager0.triggerWatch("", eventType19, (long) '#', aCLList21);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNull(watcherOrBitSet22);
    }

    @Test
    public void test302() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test302");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("", watcher13);
        java.io.PrintWriter printWriter15 = null;
        watchManager0.dumpWatches(printWriter15, true);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary18 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher20 = null;
        boolean boolean21 = watchManager0.addWatch("", watcher20);
        org.apache.zookeeper.Watcher watcher23 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode24 = null;
        boolean boolean25 = watchManager0.containsWatcher("", watcher23, watcherMode24);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(watchesSummary18);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + true + "'", boolean21 == true);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + true + "'", boolean25 == true);
    }

    @Test
    public void test303() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test303");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("", watcher13);
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.data.ACL[] aCLArray22 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList23 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean24 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList23, aCLArray22);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager18.triggerWatch("", eventType20, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23, watcherOrBitSet25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = watchManager0.triggerWatch("", eventType16, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType30 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager32 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher34 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode35 = null;
        boolean boolean36 = watchManager32.containsWatcher("hi!", watcher34, watcherMode35);
        java.lang.String str37 = watchManager32.toString();
        org.apache.zookeeper.Watcher watcher39 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode40 = null;
        boolean boolean41 = watchManager32.containsWatcher("", watcher39, watcherMode40);
        org.apache.zookeeper.Watcher.Event.EventType eventType43 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager45 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport46 = watchManager45.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher48 = null;
        boolean boolean49 = watchManager45.addWatch("hi!", watcher48);
        org.apache.zookeeper.Watcher watcher51 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode52 = null;
        boolean boolean53 = watchManager45.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher51, watcherMode52);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary54 = watchManager45.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType56 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager58 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType60 = null;
        org.apache.zookeeper.data.ACL[] aCLArray62 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList63 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean64 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList63, aCLArray62);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet65 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet66 = watchManager58.triggerWatch("", eventType60, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList63, watcherOrBitSet65);
        java.lang.String str67 = watchManager58.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport68 = watchManager58.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType70 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager72 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher74 = null;
        boolean boolean75 = watchManager72.addWatch("", watcher74);
        org.apache.zookeeper.Watcher watcher76 = null;
        watchManager72.removeWatcher(watcher76);
        java.lang.String str78 = watchManager72.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary79 = watchManager72.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType81 = null;
        org.apache.zookeeper.data.ACL[] aCLArray83 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList84 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean85 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList84, aCLArray83);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet86 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet87 = watchManager72.triggerWatch("", eventType81, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList84, watcherOrBitSet86);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet88 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet89 = watchManager58.triggerWatch("", eventType70, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList84, watcherOrBitSet88);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet90 = watchManager45.triggerWatch("", eventType56, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList84);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet91 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet92 = watchManager32.triggerWatch("", eventType43, (long) (byte) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList84, watcherOrBitSet91);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet93 = watchManager0.triggerWatch("hi!", eventType30, (long) 'a', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList84);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(aCLArray22);
        org.junit.Assert.assertArrayEquals(aCLArray22, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNull(watcherOrBitSet26);
        org.junit.Assert.assertNull(watcherOrBitSet27);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertEquals("'" + str37 + "' != '" + "" + "'", str37, "");
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertNotNull(watchesPathReport46);
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + true + "'", boolean49 == true);
        org.junit.Assert.assertTrue("'" + boolean53 + "' != '" + false + "'", boolean53 == false);
        org.junit.Assert.assertNotNull(watchesSummary54);
        org.junit.Assert.assertNotNull(aCLArray62);
        org.junit.Assert.assertArrayEquals(aCLArray62, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean64 + "' != '" + false + "'", boolean64 == false);
        org.junit.Assert.assertNull(watcherOrBitSet66);
        org.junit.Assert.assertEquals("'" + str67 + "' != '" + "" + "'", str67, "");
        org.junit.Assert.assertNotNull(watchesReport68);
        org.junit.Assert.assertTrue("'" + boolean75 + "' != '" + true + "'", boolean75 == true);
        org.junit.Assert.assertEquals("'" + str78 + "' != '" + "" + "'", str78, "");
        org.junit.Assert.assertNotNull(watchesSummary79);
        org.junit.Assert.assertNotNull(aCLArray83);
        org.junit.Assert.assertArrayEquals(aCLArray83, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean85 + "' != '" + false + "'", boolean85 == false);
        org.junit.Assert.assertNull(watcherOrBitSet87);
        org.junit.Assert.assertNull(watcherOrBitSet89);
        org.junit.Assert.assertNull(watcherOrBitSet90);
        org.junit.Assert.assertNull(watcherOrBitSet92);
    }

    @Test
    public void test304() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test304");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.containsWatcher("", watcher9);
        int int11 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.addWatch("hi!", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.addWatch("null\n\thi!\n", watcher16);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
    }

    @Test
    public void test305() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test305");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        boolean boolean18 = watchManager0.removeWatcher("", watcher16, watcherMode17);
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean22 = watchManager0.addWatch("hi!", watcher20, watcherMode21);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test306() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test306");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary7 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesSummary7);
    }

    @Test
    public void test307() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test307");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        org.apache.zookeeper.data.ACL[] aCLArray13 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList14 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean15 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList14, aCLArray13);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet16 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = watchManager0.triggerWatch("null\n\thi!\n", eventType11, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList14, watcherOrBitSet16);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 10");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(aCLArray13);
        org.junit.Assert.assertArrayEquals(aCLArray13, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test308() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test308");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary7 = watchManager0.getWatchesSummary();
        int int8 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("null\n\tnull\n\t\n\n", watcher10, watcherMode11);
        java.io.PrintWriter printWriter13 = null;
        watchManager0.dumpWatches(printWriter13, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertNotNull(watchesSummary7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test309() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test309");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.addWatch("null\n\t\n", watcher12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.containsWatcher("null\n\tnull\n\t\n\tnull\n\t\n\n\n", watcher15, watcherMode16);
        int int18 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        boolean boolean22 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher20, watcherMode21);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 2 + "'", int18 == 2);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test310() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test310");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher18 = null;
        watchManager0.removeWatcher(watcher18);
        java.lang.String str20 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher21 = null;
        watchManager0.removeWatcher(watcher21);
        org.apache.zookeeper.Watcher watcher24 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode25 = null;
        boolean boolean26 = watchManager0.removeWatcher("", watcher24, watcherMode25);
        java.lang.Class<?> wildcardClass27 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "" + "'", str20, "");
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertNotNull(wildcardClass27);
    }

    @Test
    public void test311() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test311");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        boolean boolean10 = watchManager0.removeWatcher("null\n\tnull\n\t\n\tnull\n\t\n\n\n", watcher8, watcherMode9);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary11 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(watchesSummary11);
    }

    @Test
    public void test312() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test312");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary4 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType6 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager8 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.data.ACL[] aCLArray12 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList13 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean14 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList13, aCLArray12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet15 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet16 = watchManager8.triggerWatch("", eventType10, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList13, watcherOrBitSet15);
        java.lang.String str17 = watchManager8.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport18 = watchManager8.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager22 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher24 = null;
        boolean boolean25 = watchManager22.addWatch("", watcher24);
        org.apache.zookeeper.Watcher watcher26 = null;
        watchManager22.removeWatcher(watcher26);
        java.lang.String str28 = watchManager22.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary29 = watchManager22.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType31 = null;
        org.apache.zookeeper.data.ACL[] aCLArray33 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList34 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean35 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList34, aCLArray33);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet37 = watchManager22.triggerWatch("", eventType31, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList34, watcherOrBitSet36);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet38 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = watchManager8.triggerWatch("", eventType20, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList34, watcherOrBitSet38);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = watchManager0.triggerWatch("null\n\t\n", eventType6, (long) 2, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList34);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 7");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesSummary4);
        org.junit.Assert.assertNotNull(aCLArray12);
        org.junit.Assert.assertArrayEquals(aCLArray12, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNull(watcherOrBitSet16);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "" + "'", str17, "");
        org.junit.Assert.assertNotNull(watchesReport18);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + true + "'", boolean25 == true);
        org.junit.Assert.assertEquals("'" + str28 + "' != '" + "" + "'", str28, "");
        org.junit.Assert.assertNotNull(watchesSummary29);
        org.junit.Assert.assertNotNull(aCLArray33);
        org.junit.Assert.assertArrayEquals(aCLArray33, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertNull(watcherOrBitSet37);
        org.junit.Assert.assertNull(watcherOrBitSet39);
    }

    @Test
    public void test313() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test313");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.containsWatcher("", watcher9);
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager14 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport15 = watchManager14.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager14.addWatch("", watcher17);
        java.lang.String str19 = watchManager14.toString();
        org.apache.zookeeper.Watcher watcher20 = null;
        watchManager14.removeWatcher(watcher20);
        watchManager14.shutdown();
        org.apache.zookeeper.Watcher watcher24 = null;
        boolean boolean25 = watchManager14.containsWatcher("", watcher24);
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager29 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType31 = null;
        org.apache.zookeeper.data.ACL[] aCLArray33 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList34 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean35 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList34, aCLArray33);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet37 = watchManager29.triggerWatch("", eventType31, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList34, watcherOrBitSet36);
        java.lang.String str38 = watchManager29.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport39 = watchManager29.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType41 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager43 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher45 = null;
        boolean boolean46 = watchManager43.addWatch("", watcher45);
        org.apache.zookeeper.Watcher watcher47 = null;
        watchManager43.removeWatcher(watcher47);
        java.lang.String str49 = watchManager43.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary50 = watchManager43.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType52 = null;
        org.apache.zookeeper.data.ACL[] aCLArray54 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList55 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean56 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList55, aCLArray54);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet57 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet58 = watchManager43.triggerWatch("", eventType52, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList55, watcherOrBitSet57);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet59 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet60 = watchManager29.triggerWatch("", eventType41, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList55, watcherOrBitSet59);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet61 = watchManager14.triggerWatch("", eventType27, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList55);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet62 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet63 = watchManager0.triggerWatch("null\n\tnull\n\t\n\tnull\n\t\n\n\n", eventType12, 100L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList55, watcherOrBitSet62);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 23");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(watchesPathReport15);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "null\n\t\n" + "'", str19, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(aCLArray33);
        org.junit.Assert.assertArrayEquals(aCLArray33, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertNull(watcherOrBitSet37);
        org.junit.Assert.assertEquals("'" + str38 + "' != '" + "" + "'", str38, "");
        org.junit.Assert.assertNotNull(watchesReport39);
        org.junit.Assert.assertTrue("'" + boolean46 + "' != '" + true + "'", boolean46 == true);
        org.junit.Assert.assertEquals("'" + str49 + "' != '" + "" + "'", str49, "");
        org.junit.Assert.assertNotNull(watchesSummary50);
        org.junit.Assert.assertNotNull(aCLArray54);
        org.junit.Assert.assertArrayEquals(aCLArray54, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean56 + "' != '" + false + "'", boolean56 == false);
        org.junit.Assert.assertNull(watcherOrBitSet58);
        org.junit.Assert.assertNull(watcherOrBitSet60);
        org.junit.Assert.assertNull(watcherOrBitSet61);
    }

    @Test
    public void test314() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test314");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("", watcher13);
        java.lang.String str15 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean19 = watchManager0.addWatch("", watcher17, watcherMode18);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "" + "'", str15, "");
    }

    @Test
    public void test315() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test315");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher11 = null;
        watchManager0.removeWatcher(watcher11);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport13 = watchManager0.getWatches();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(watchesReport13);
    }

    @Test
    public void test316() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test316");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("", watcher3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("", watcher10);
        org.apache.zookeeper.Watcher.Event.EventType eventType13 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager15 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType17 = null;
        org.apache.zookeeper.data.ACL[] aCLArray19 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList20 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean21 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList20, aCLArray19);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet23 = watchManager15.triggerWatch("", eventType17, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20, watcherOrBitSet22);
        java.lang.String str24 = watchManager15.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport25 = watchManager15.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager29 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher31 = null;
        boolean boolean32 = watchManager29.addWatch("", watcher31);
        org.apache.zookeeper.Watcher watcher33 = null;
        watchManager29.removeWatcher(watcher33);
        java.lang.String str35 = watchManager29.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary36 = watchManager29.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType38 = null;
        org.apache.zookeeper.data.ACL[] aCLArray40 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList41 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean42 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList41, aCLArray40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager29.triggerWatch("", eventType38, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList41, watcherOrBitSet43);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = watchManager15.triggerWatch("", eventType27, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList41, watcherOrBitSet45);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet47 = watchManager0.triggerWatch("", eventType13, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList41);
        int int48 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "null\n\t\n" + "'", str5, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(aCLArray19);
        org.junit.Assert.assertArrayEquals(aCLArray19, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNull(watcherOrBitSet23);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "" + "'", str24, "");
        org.junit.Assert.assertNotNull(watchesReport25);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + true + "'", boolean32 == true);
        org.junit.Assert.assertEquals("'" + str35 + "' != '" + "" + "'", str35, "");
        org.junit.Assert.assertNotNull(watchesSummary36);
        org.junit.Assert.assertNotNull(aCLArray40);
        org.junit.Assert.assertArrayEquals(aCLArray40, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertNull(watcherOrBitSet46);
        org.junit.Assert.assertNull(watcherOrBitSet47);
        org.junit.Assert.assertTrue("'" + int48 + "' != '" + 0 + "'", int48 == 0);
    }

    @Test
    public void test317() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test317");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("null\n\t\n", watcher3, watcherMode4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("null\n\t\n", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.removeWatcher("", watcher14);
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.addWatch("", watcher17);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
    }

    @Test
    public void test318() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test318");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.containsWatcher("hi!", watcher16);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher20 = null;
        boolean boolean21 = watchManager0.addWatch("", watcher20);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + true + "'", boolean21 == true);
    }

    @Test
    public void test319() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test319");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager12.triggerWatch("", eventType14, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet19);
        java.lang.String str21 = watchManager12.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport22 = watchManager12.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager26 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher28 = null;
        boolean boolean29 = watchManager26.addWatch("", watcher28);
        org.apache.zookeeper.Watcher watcher30 = null;
        watchManager26.removeWatcher(watcher30);
        java.lang.String str32 = watchManager26.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary33 = watchManager26.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.data.ACL[] aCLArray37 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList38 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean39 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList38, aCLArray37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager26.triggerWatch("", eventType35, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager12.triggerWatch("", eventType24, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager0.triggerWatch("", eventType10, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38);
        org.apache.zookeeper.Watcher watcher46 = null;
        boolean boolean47 = watchManager0.removeWatcher("null\n\thi!\n", watcher46);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "" + "'", str21, "");
        org.junit.Assert.assertNotNull(watchesReport22);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + true + "'", boolean29 == true);
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "" + "'", str32, "");
        org.junit.Assert.assertNotNull(watchesSummary33);
        org.junit.Assert.assertNotNull(aCLArray37);
        org.junit.Assert.assertArrayEquals(aCLArray37, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNull(watcherOrBitSet41);
        org.junit.Assert.assertNull(watcherOrBitSet43);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + false + "'", boolean47 == false);
    }

    @Test
    public void test320() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test320");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter13 = null;
        watchManager0.dumpWatches(printWriter13, true);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport16 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.addWatch("null\n\thi!\n", watcher19);
        org.apache.zookeeper.Watcher watcher22 = null;
        boolean boolean23 = watchManager0.containsWatcher("null\n\t\n", watcher22);
        org.apache.zookeeper.Watcher watcher25 = null;
        boolean boolean26 = watchManager0.containsWatcher("hi!", watcher25);
        org.apache.zookeeper.Watcher watcher27 = null;
        watchManager0.removeWatcher(watcher27);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertNotNull(watchesPathReport16);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
    }

    @Test
    public void test321() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test321");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("", watcher7, watcherMode8);
        int int10 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary11 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport12 = watchManager0.getWatches();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertNotNull(watchesSummary11);
        org.junit.Assert.assertNotNull(watchesReport12);
    }

    @Test
    public void test322() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test322");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher11 = null;
        watchManager0.removeWatcher(watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean16 = watchManager0.addWatch("null\n\thi!\n", watcher14, watcherMode15);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
        org.junit.Assert.assertNotNull(watchesSummary10);
    }

    @Test
    public void test323() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test323");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("null\n\t\n", watcher3, watcherMode4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("null\n\t\n", watcher7, watcherMode8);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport10 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport11 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("null\n\thi!\n", watcher13);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesPathReport10);
        org.junit.Assert.assertNotNull(watchesPathReport11);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test324() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test324");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        boolean boolean18 = watchManager0.removeWatcher("", watcher16, watcherMode17);
        org.apache.zookeeper.Watcher watcher20 = null;
        boolean boolean21 = watchManager0.containsWatcher("null\n\t\n", watcher20);
        org.apache.zookeeper.Watcher watcher23 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode24 = null;
        boolean boolean25 = watchManager0.removeWatcher("null\n\tnull\n\t\n\n", watcher23, watcherMode24);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
    }

    @Test
    public void test325() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test325");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport7 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.removeWatcher("hi!", watcher9);
        java.lang.Class<?> wildcardClass11 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesPathReport7);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test326() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test326");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType8 = null;
        org.apache.zookeeper.data.ACL[] aCLArray10 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList11 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean12 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList11, aCLArray10);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager0.triggerWatch("null\n\thi!\n", eventType8, (long) (short) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList11);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 10");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(aCLArray10);
        org.junit.Assert.assertArrayEquals(aCLArray10, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test327() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test327");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        int int6 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test328() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test328");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("null\n\tnull\n\t\n\n", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean16 = watchManager0.addWatch("null\n\t\n\tnull\n\t\n\n", watcher14, watcherMode15);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test329() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test329");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.addWatch("null\n\t\n", watcher5);
        java.lang.String str7 = watchManager0.toString();
        watchManager0.shutdown();
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "null\n\t\n\tnull\n\t\n\n" + "'", str7, "null\n\t\n\tnull\n\t\n\n");
    }

    @Test
    public void test330() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test330");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
        java.lang.String str10 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesPathReport9);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "" + "'", str10, "");
    }

    @Test
    public void test331() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test331");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.removeWatcher("", watcher14);
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.containsWatcher("null\n\t\n", watcher17);
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        boolean boolean22 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher20, watcherMode21);
        int int23 = watchManager0.size();
        java.lang.String str24 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher26 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode27 = null;
        boolean boolean28 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher26, watcherMode27);
        org.apache.zookeeper.Watcher watcher30 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode31 = null;
        boolean boolean32 = watchManager0.containsWatcher("null\n\tnull\n\t\n\tnull\n\t\n\n\n", watcher30, watcherMode31);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + 0 + "'", int23 == 0);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "" + "'", str24, "");
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
    }

    @Test
    public void test332() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test332");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        int int9 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("null\n\t\n\tnull\n\t\n\n", watcher11);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
    }

    @Test
    public void test333() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test333");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
        java.lang.String str10 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher11 = null;
        watchManager0.removeWatcher(watcher11);
        int int13 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesPathReport9);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "" + "'", str10, "");
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
    }

    @Test
    public void test334() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test334");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.removeWatcher("hi!", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.containsWatcher("null\n\thi!\n", watcher16);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test335() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test335");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("null\n\t\n", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("null\n\t\n", watcher11);
        int int13 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
    }

    @Test
    public void test336() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test336");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport4 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test337() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test337");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("null\n\t\n", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.removeWatcher("hi!", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager0.addWatch("null\n\tnull\n\t\n\n", watcher15);
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.removeWatcher("null\n\thi!\n", watcher18);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport20 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test338() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test338");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("", watcher3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("", watcher10);
        org.apache.zookeeper.Watcher watcher12 = null;
        watchManager0.removeWatcher(watcher12);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "null\n\t\n" + "'", str5, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
    }

    @Test
    public void test339() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test339");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.removeWatcher("hi!", watcher13);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.Watcher watcher17 = null;
        watchManager0.removeWatcher(watcher17);
        int int19 = watchManager0.size();
        org.apache.zookeeper.Watcher.Event.EventType eventType21 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager23 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher25 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode26 = null;
        boolean boolean27 = watchManager23.containsWatcher("hi!", watcher25, watcherMode26);
        java.lang.String str28 = watchManager23.toString();
        org.apache.zookeeper.Watcher watcher30 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode31 = null;
        boolean boolean32 = watchManager23.removeWatcher("", watcher30, watcherMode31);
        org.apache.zookeeper.Watcher watcher34 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode35 = null;
        boolean boolean36 = watchManager23.containsWatcher("", watcher34, watcherMode35);
        org.apache.zookeeper.Watcher watcher38 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode39 = null;
        boolean boolean40 = watchManager23.removeWatcher("null\n\t\n", watcher38, watcherMode39);
        org.apache.zookeeper.Watcher watcher41 = null;
        watchManager23.removeWatcher(watcher41);
        java.lang.String str43 = watchManager23.toString();
        org.apache.zookeeper.Watcher watcher44 = null;
        watchManager23.removeWatcher(watcher44);
        org.apache.zookeeper.Watcher watcher47 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode48 = null;
        boolean boolean49 = watchManager23.removeWatcher("", watcher47, watcherMode48);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport50 = watchManager23.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType52 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager54 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager54.shutdown();
        int int56 = watchManager54.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary57 = watchManager54.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport58 = watchManager54.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType60 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager62 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType64 = null;
        org.apache.zookeeper.data.ACL[] aCLArray66 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList67 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean68 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList67, aCLArray66);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet69 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet70 = watchManager62.triggerWatch("", eventType64, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList67, watcherOrBitSet69);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet71 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet72 = watchManager54.triggerWatch("", eventType60, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList67, watcherOrBitSet71);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet73 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet74 = watchManager23.triggerWatch("", eventType52, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList67, watcherOrBitSet73);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet75 = watchManager0.triggerWatch("", eventType21, (-1L), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList67);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 0 + "'", int19 == 0);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertEquals("'" + str28 + "' != '" + "" + "'", str28, "");
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertEquals("'" + str43 + "' != '" + "" + "'", str43, "");
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + false + "'", boolean49 == false);
        org.junit.Assert.assertNotNull(watchesReport50);
        org.junit.Assert.assertTrue("'" + int56 + "' != '" + 0 + "'", int56 == 0);
        org.junit.Assert.assertNotNull(watchesSummary57);
        org.junit.Assert.assertNotNull(watchesReport58);
        org.junit.Assert.assertNotNull(aCLArray66);
        org.junit.Assert.assertArrayEquals(aCLArray66, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean68 + "' != '" + false + "'", boolean68 == false);
        org.junit.Assert.assertNull(watcherOrBitSet70);
        org.junit.Assert.assertNull(watcherOrBitSet72);
        org.junit.Assert.assertNull(watcherOrBitSet74);
        org.junit.Assert.assertNull(watcherOrBitSet75);
    }

    @Test
    public void test340() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test340");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager13 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager13.containsWatcher("hi!", watcher15, watcherMode16);
        java.lang.String str18 = watchManager13.toString();
        org.apache.zookeeper.Watcher watcher20 = null;
        boolean boolean21 = watchManager13.addWatch("", watcher20);
        java.lang.String str22 = watchManager13.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary23 = watchManager13.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager27 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher29 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode30 = null;
        boolean boolean31 = watchManager27.containsWatcher("hi!", watcher29, watcherMode30);
        java.lang.String str32 = watchManager27.toString();
        org.apache.zookeeper.Watcher watcher34 = null;
        boolean boolean35 = watchManager27.addWatch("", watcher34);
        java.lang.String str36 = watchManager27.toString();
        org.apache.zookeeper.Watcher watcher38 = null;
        boolean boolean39 = watchManager27.containsWatcher("", watcher38);
        org.apache.zookeeper.Watcher watcher41 = null;
        boolean boolean42 = watchManager27.removeWatcher("", watcher41);
        org.apache.zookeeper.Watcher.Event.EventType eventType44 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager46 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType48 = null;
        org.apache.zookeeper.data.ACL[] aCLArray50 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList51 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean52 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList51, aCLArray50);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet53 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet54 = watchManager46.triggerWatch("", eventType48, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList51, watcherOrBitSet53);
        org.apache.zookeeper.Watcher watcher56 = null;
        boolean boolean57 = watchManager46.addWatch("null\n\t\n", watcher56);
        org.apache.zookeeper.Watcher.Event.EventType eventType59 = null;
        org.apache.zookeeper.data.ACL[] aCLArray61 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList62 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean63 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList62, aCLArray61);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet64 = watchManager46.triggerWatch("", eventType59, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList62);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet65 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet66 = watchManager27.triggerWatch("", eventType44, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList62, watcherOrBitSet65);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet67 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet68 = watchManager13.triggerWatch("", eventType25, (long) (short) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList62, watcherOrBitSet67);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet69 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet70 = watchManager0.triggerWatch("", eventType11, (long) '#', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList62, watcherOrBitSet69);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "" + "'", str18, "");
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + true + "'", boolean21 == true);
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "null\n\t\n" + "'", str22, "null\n\t\n");
        org.junit.Assert.assertNotNull(watchesSummary23);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "" + "'", str32, "");
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + true + "'", boolean35 == true);
        org.junit.Assert.assertEquals("'" + str36 + "' != '" + "null\n\t\n" + "'", str36, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + true + "'", boolean39 == true);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + true + "'", boolean42 == true);
        org.junit.Assert.assertNotNull(aCLArray50);
        org.junit.Assert.assertArrayEquals(aCLArray50, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + false + "'", boolean52 == false);
        org.junit.Assert.assertNull(watcherOrBitSet54);
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + true + "'", boolean57 == true);
        org.junit.Assert.assertNotNull(aCLArray61);
        org.junit.Assert.assertArrayEquals(aCLArray61, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean63 + "' != '" + false + "'", boolean63 == false);
        org.junit.Assert.assertNull(watcherOrBitSet64);
        org.junit.Assert.assertNull(watcherOrBitSet66);
        org.junit.Assert.assertNull(watcherOrBitSet68);
        org.junit.Assert.assertNull(watcherOrBitSet70);
    }

    @Test
    public void test341() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test341");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("", watcher13);
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.data.ACL[] aCLArray22 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList23 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean24 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList23, aCLArray22);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager18.triggerWatch("", eventType20, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23, watcherOrBitSet25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = watchManager0.triggerWatch("", eventType16, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23);
        java.io.PrintWriter printWriter28 = null;
        watchManager0.dumpWatches(printWriter28, false);
        org.apache.zookeeper.Watcher watcher32 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode33 = null;
        boolean boolean34 = watchManager0.removeWatcher("hi!", watcher32, watcherMode33);
        org.apache.zookeeper.Watcher watcher36 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode37 = null;
        boolean boolean38 = watchManager0.removeWatcher("hi!", watcher36, watcherMode37);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(aCLArray22);
        org.junit.Assert.assertArrayEquals(aCLArray22, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNull(watcherOrBitSet26);
        org.junit.Assert.assertNull(watcherOrBitSet27);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
    }

    @Test
    public void test342() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test342");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        int int9 = watchManager0.size();
        java.lang.String str10 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher12 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode13 = null;
        boolean boolean14 = watchManager0.removeWatcher("hi!", watcher12, watcherMode13);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "" + "'", str10, "");
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test343() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test343");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher7);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport9 = watchManager0.getWatches();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesReport9);
    }

    @Test
    public void test344() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test344");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher6, watcherMode7);
        java.lang.String str9 = watchManager0.toString();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\thi!\n" + "'", str9, "null\n\thi!\n");
    }

    @Test
    public void test345() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test345");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher18 = null;
        watchManager0.removeWatcher(watcher18);
        int int20 = watchManager0.size();
        java.lang.String str21 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "" + "'", str21, "");
    }

    @Test
    public void test346() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test346");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.removeWatcher("", watcher14);
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.containsWatcher("null\n\t\n", watcher17);
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        boolean boolean22 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher20, watcherMode21);
        int int23 = watchManager0.size();
        java.lang.String str24 = watchManager0.toString();
        org.apache.zookeeper.Watcher.Event.EventType eventType26 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager28 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher30 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode31 = null;
        boolean boolean32 = watchManager28.containsWatcher("hi!", watcher30, watcherMode31);
        java.lang.String str33 = watchManager28.toString();
        org.apache.zookeeper.Watcher watcher35 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode36 = null;
        boolean boolean37 = watchManager28.removeWatcher("", watcher35, watcherMode36);
        org.apache.zookeeper.Watcher watcher39 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode40 = null;
        boolean boolean41 = watchManager28.containsWatcher("", watcher39, watcherMode40);
        org.apache.zookeeper.Watcher watcher43 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode44 = null;
        boolean boolean45 = watchManager28.removeWatcher("null\n\t\n", watcher43, watcherMode44);
        org.apache.zookeeper.Watcher watcher46 = null;
        watchManager28.removeWatcher(watcher46);
        java.lang.String str48 = watchManager28.toString();
        org.apache.zookeeper.Watcher watcher49 = null;
        watchManager28.removeWatcher(watcher49);
        org.apache.zookeeper.Watcher watcher52 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode53 = null;
        boolean boolean54 = watchManager28.removeWatcher("", watcher52, watcherMode53);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport55 = watchManager28.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType57 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager59 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager59.shutdown();
        int int61 = watchManager59.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary62 = watchManager59.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport63 = watchManager59.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType65 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager67 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType69 = null;
        org.apache.zookeeper.data.ACL[] aCLArray71 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList72 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean73 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList72, aCLArray71);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet74 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet75 = watchManager67.triggerWatch("", eventType69, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList72, watcherOrBitSet74);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet76 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet77 = watchManager59.triggerWatch("", eventType65, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList72, watcherOrBitSet76);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet78 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet79 = watchManager28.triggerWatch("", eventType57, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList72, watcherOrBitSet78);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet80 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet81 = watchManager0.triggerWatch("null\n\tnull\n\t\n\tnull\n\t\n\n\n", eventType26, 100L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList72, watcherOrBitSet80);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 23");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "null\n\t\n" + "'", str9, "null\n\t\n");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + 0 + "'", int23 == 0);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "" + "'", str24, "");
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertEquals("'" + str33 + "' != '" + "" + "'", str33, "");
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
        org.junit.Assert.assertEquals("'" + str48 + "' != '" + "" + "'", str48, "");
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + false + "'", boolean54 == false);
        org.junit.Assert.assertNotNull(watchesReport55);
        org.junit.Assert.assertTrue("'" + int61 + "' != '" + 0 + "'", int61 == 0);
        org.junit.Assert.assertNotNull(watchesSummary62);
        org.junit.Assert.assertNotNull(watchesReport63);
        org.junit.Assert.assertNotNull(aCLArray71);
        org.junit.Assert.assertArrayEquals(aCLArray71, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean73 + "' != '" + false + "'", boolean73 == false);
        org.junit.Assert.assertNull(watcherOrBitSet75);
        org.junit.Assert.assertNull(watcherOrBitSet77);
        org.junit.Assert.assertNull(watcherOrBitSet79);
    }

    @Test
    public void test347() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test347");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport10 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.containsWatcher("null\n\t\n", watcher12);
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager0.removeWatcher("", watcher15);
        org.apache.zookeeper.Watcher watcher17 = null;
        watchManager0.removeWatcher(watcher17);
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean22 = watchManager0.addWatch("", watcher20, watcherMode21);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesPathReport9);
        org.junit.Assert.assertNotNull(watchesPathReport10);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test348() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test348");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.removeWatcher("", watcher11);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary13 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesSummary13);
    }

    @Test
    public void test349() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test349");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.containsWatcher("", watcher19);
        java.lang.String str21 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport22 = watchManager0.getWatches();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "" + "'", str21, "");
        org.junit.Assert.assertNotNull(watchesReport22);
    }

    @Test
    public void test350() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test350");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean17 = watchManager0.addWatch("null\n\tnull\n\t\n\n", watcher15, watcherMode16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertNotNull(watchesPathReport13);
    }

    @Test
    public void test351() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test351");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.removeWatcher("null\n\t\n\tnull\n\t\n\n", watcher4);
        int int6 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        watchManager0.shutdown();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertNotNull(watchesReport7);
    }

    @Test
    public void test352() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test352");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher10);
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test353() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test353");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("null\n\t\n", watcher10);
        org.apache.zookeeper.Watcher watcher12 = null;
        watchManager0.removeWatcher(watcher12);
        org.apache.zookeeper.Watcher watcher14 = null;
        watchManager0.removeWatcher(watcher14);
        java.lang.String str16 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "" + "'", str16, "");
    }

    @Test
    public void test354() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test354");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("", watcher13);
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.data.ACL[] aCLArray22 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList23 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean24 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList23, aCLArray22);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager18.triggerWatch("", eventType20, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23, watcherOrBitSet25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = watchManager0.triggerWatch("", eventType16, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23);
        java.io.PrintWriter printWriter28 = null;
        watchManager0.dumpWatches(printWriter28, false);
        org.apache.zookeeper.Watcher watcher32 = null;
        boolean boolean33 = watchManager0.removeWatcher("hi!", watcher32);
        org.apache.zookeeper.Watcher watcher35 = null;
        boolean boolean36 = watchManager0.removeWatcher("null\n\tnull\n\t\n\n", watcher35);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(aCLArray22);
        org.junit.Assert.assertArrayEquals(aCLArray22, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNull(watcherOrBitSet26);
        org.junit.Assert.assertNull(watcherOrBitSet27);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
    }

    @Test
    public void test355() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test355");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.removeWatcher("", watcher14);
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.addWatch("hi!", watcher17);
        java.lang.String str19 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary20 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "null\n\thi!\n" + "'", str19, "null\n\thi!\n");
        org.junit.Assert.assertNotNull(watchesSummary20);
    }

    @Test
    public void test356() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test356");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher6, watcherMode7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager13 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.data.ACL[] aCLArray17 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList18 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean19 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList18, aCLArray17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet21 = watchManager13.triggerWatch("", eventType15, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList18, watcherOrBitSet20);
        java.lang.String str22 = watchManager13.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport23 = watchManager13.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager27 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher29 = null;
        boolean boolean30 = watchManager27.addWatch("", watcher29);
        org.apache.zookeeper.Watcher watcher31 = null;
        watchManager27.removeWatcher(watcher31);
        java.lang.String str33 = watchManager27.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary34 = watchManager27.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType36 = null;
        org.apache.zookeeper.data.ACL[] aCLArray38 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList39 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean40 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList39, aCLArray38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager27.triggerWatch("", eventType36, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39, watcherOrBitSet41);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager13.triggerWatch("", eventType25, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39, watcherOrBitSet43);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = watchManager0.triggerWatch("", eventType11, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39);
        java.lang.Class<?> wildcardClass46 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesSummary9);
        org.junit.Assert.assertNotNull(aCLArray17);
        org.junit.Assert.assertArrayEquals(aCLArray17, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNull(watcherOrBitSet21);
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "" + "'", str22, "");
        org.junit.Assert.assertNotNull(watchesReport23);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + true + "'", boolean30 == true);
        org.junit.Assert.assertEquals("'" + str33 + "' != '" + "" + "'", str33, "");
        org.junit.Assert.assertNotNull(watchesSummary34);
        org.junit.Assert.assertNotNull(aCLArray38);
        org.junit.Assert.assertArrayEquals(aCLArray38, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertNull(watcherOrBitSet42);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertNull(watcherOrBitSet45);
        org.junit.Assert.assertNotNull(wildcardClass46);
    }

    @Test
    public void test357() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test357");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test358() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test358");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("null\n\t\n\tnull\n\t\n\n", watcher6, watcherMode7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager13 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.data.ACL[] aCLArray17 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList18 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean19 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList18, aCLArray17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet21 = watchManager13.triggerWatch("", eventType15, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList18, watcherOrBitSet20);
        java.lang.String str22 = watchManager13.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport23 = watchManager13.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager27 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher29 = null;
        boolean boolean30 = watchManager27.addWatch("", watcher29);
        org.apache.zookeeper.Watcher watcher31 = null;
        watchManager27.removeWatcher(watcher31);
        java.lang.String str33 = watchManager27.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary34 = watchManager27.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType36 = null;
        org.apache.zookeeper.data.ACL[] aCLArray38 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList39 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean40 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList39, aCLArray38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager27.triggerWatch("", eventType36, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39, watcherOrBitSet41);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager13.triggerWatch("", eventType25, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39, watcherOrBitSet43);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = watchManager0.triggerWatch("", eventType11, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary46 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesSummary9);
        org.junit.Assert.assertNotNull(aCLArray17);
        org.junit.Assert.assertArrayEquals(aCLArray17, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNull(watcherOrBitSet21);
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "" + "'", str22, "");
        org.junit.Assert.assertNotNull(watchesReport23);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + true + "'", boolean30 == true);
        org.junit.Assert.assertEquals("'" + str33 + "' != '" + "" + "'", str33, "");
        org.junit.Assert.assertNotNull(watchesSummary34);
        org.junit.Assert.assertNotNull(aCLArray38);
        org.junit.Assert.assertArrayEquals(aCLArray38, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertNull(watcherOrBitSet42);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertNull(watcherOrBitSet45);
        org.junit.Assert.assertNotNull(watchesSummary46);
    }

    @Test
    public void test359() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test359");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("", watcher9, watcherMode10);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test360() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test360");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher18 = null;
        watchManager0.removeWatcher(watcher18);
        org.apache.zookeeper.Watcher watcher21 = null;
        boolean boolean22 = watchManager0.addWatch("hi!", watcher21);
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary24 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
        org.junit.Assert.assertNotNull(watchesSummary24);
    }

    @Test
    public void test361() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test361");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary7 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType9 = null;
        org.apache.zookeeper.data.ACL[] aCLArray11 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList12 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean13 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList12, aCLArray11);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet15 = watchManager0.triggerWatch("", eventType9, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList12, watcherOrBitSet14);
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.removeWatcher("null\n\tnull\n\t\n\tnull\n\t\n\n\n", watcher17);
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean22 = watchManager0.addWatch("null\n\tnull\n\t\n\n", watcher20, watcherMode21);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertNotNull(watchesSummary7);
        org.junit.Assert.assertNotNull(aCLArray11);
        org.junit.Assert.assertArrayEquals(aCLArray11, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNull(watcherOrBitSet15);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test362() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test362");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.removeWatcher("hi!", watcher13);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary15 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(watchesSummary15);
    }

    @Test
    public void test363() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test363");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("null\n\t\n", watcher10);
        org.apache.zookeeper.Watcher watcher12 = null;
        watchManager0.removeWatcher(watcher12);
        int int14 = watchManager0.size();
        java.io.PrintWriter printWriter15 = null;
        watchManager0.dumpWatches(printWriter15, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
    }

    @Test
    public void test364() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc1RandoopTest0.test364");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("null\n\t\n", watcher15, watcherMode16);
        int int18 = watchManager0.size();
        java.lang.String str19 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 0 + "'", int18 == 0);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "" + "'", str19, "");
    }
}

