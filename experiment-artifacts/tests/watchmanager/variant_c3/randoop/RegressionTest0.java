package org.apache.zookeeper.server.watch.watchmanager.variant_c3.randoop;

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
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test001");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher7, watcherMode8);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test002");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean8 = watchManager0.addWatch("", watcher6, watcherMode7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test003");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.Class<?> wildcardClass4 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test004");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher7);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport9 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test005");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.addWatch("", watcher9);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport11 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test006");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.apache.zookeeper.Watcher.Event.EventType eventType13 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager15 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType17 = null;
        org.apache.zookeeper.data.ACL[] aCLArray19 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList20 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean21 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList20, aCLArray19);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet23 = watchManager15.triggerWatch("", eventType17, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20, watcherOrBitSet22);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = watchManager0.triggerWatch("hi!", eventType13, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20, watcherOrBitSet24);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(aCLArray19);
        org.junit.Assert.assertArrayEquals(aCLArray19, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNull(watcherOrBitSet23);
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test007");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode6 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean7 = watchManager0.addWatch("hi!", watcher5, watcherMode6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test008");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher7);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test009");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        java.lang.Class<?> wildcardClass5 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str4, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test010");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher7);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test011");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.addWatch("", watcher9);
        java.io.PrintWriter printWriter11 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter11, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.println(String)\" because \"writer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test012");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("", watcher10, watcherMode11);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test013");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport5 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesPathReport5);
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test014");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher7, watcherMode8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test015");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = watchManager0.triggerWatch("0 connections watching 0 paths\nTotal watches:0", eventType10, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet21);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test016");
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = watchManager0.triggerWatch("hi!", eventType10, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet21);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
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
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test017");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport6 = watchManager0.getWatchesByPath();
        java.lang.Class<?> wildcardClass7 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesPathReport6);
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test018");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher.Event.EventType eventType8 = null;
        java.util.List<org.apache.zookeeper.data.ACL> aCLList10 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet11 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = watchManager0.triggerWatch("1 connections watching 1 paths\nTotal watches:1", eventType8, (long) 1, aCLList10, watcherOrBitSet11);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str6, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test019");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher10, watcherMode11);
        java.lang.Class<?> wildcardClass13 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(wildcardClass13);
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test020");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher6);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport8 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test021");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport6 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean10 = watchManager0.addWatch("", watcher8, watcherMode9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesPathReport6);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test022");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        java.lang.Class<?> wildcardClass8 = watchesReport7.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test023");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher10, watcherMode11);
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean16 = watchManager0.addWatch("", watcher14, watcherMode15);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test024");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("hi!", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary14 = watchManager0.getWatchesSummary();
        java.io.PrintWriter printWriter15 = null;
        watchManager0.dumpWatches(printWriter15, false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test025");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
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
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str6, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test026");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher3);
        org.apache.zookeeper.Watcher.Event.EventType eventType6 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager8 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.data.ACL[] aCLArray12 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList13 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean14 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList13, aCLArray12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet15 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet16 = watchManager8.triggerWatch("", eventType10, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList13, watcherOrBitSet15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = watchManager0.triggerWatch("", eventType6, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList13);
        java.lang.Class<?> wildcardClass18 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(aCLArray12);
        org.junit.Assert.assertArrayEquals(aCLArray12, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNull(watcherOrBitSet16);
        org.junit.Assert.assertNull(watcherOrBitSet17);
        org.junit.Assert.assertNotNull(wildcardClass18);
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test027");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.containsWatcher("hi!", watcher12);
        java.lang.Class<?> wildcardClass14 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(wildcardClass14);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test028");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("hi!", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean13 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher11, watcherMode12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test029");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager5.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType8 = null;
        org.apache.zookeeper.data.ACL[] aCLArray10 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList11 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean12 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList11, aCLArray10);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager5.triggerWatch("", eventType8, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList11, watcherOrBitSet13);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet15 = watchManager0.triggerWatch("", eventType3, (long) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList11);
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean19 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher17, watcherMode18);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray10);
        org.junit.Assert.assertArrayEquals(aCLArray10, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNull(watcherOrBitSet15);
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test030");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("hi!", watcher6, watcherMode7);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport9 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test031");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean17 = watchManager0.addWatch("hi!", watcher15, watcherMode16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str6, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test032");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        java.lang.String str7 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport8 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager12.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager12.containsWatcher("hi!", watcher15);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport17 = watchManager12.getWatches();
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager12.containsWatcher("", watcher19);
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager24.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.data.ACL[] aCLArray29 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList30 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList30, aCLArray29);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager24.triggerWatch("", eventType27, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30, watcherOrBitSet32);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager12.triggerWatch("", eventType22, (long) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = watchManager0.triggerWatch("0 connections watching 0 paths\nTotal watches:0", eventType10, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str7, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesReport8);
        org.junit.Assert.assertNotNull(watchesPathReport13);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(watchesReport17);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(aCLArray29);
        org.junit.Assert.assertArrayEquals(aCLArray29, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertNull(watcherOrBitSet34);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test033");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        int int6 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test034");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher6);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test035");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("hi!", watcher4);
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean11 = watchManager0.addWatch("", watcher9, watcherMode10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test036");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("hi!", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary14 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        java.util.List<org.apache.zookeeper.data.ACL> aCLList18 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("1 connections watching 1 paths\nTotal watches:1", eventType16, (long) (-1), aCLList18, watcherOrBitSet19);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test037");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher6, watcherMode7);
        java.lang.Class<?> wildcardClass9 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str4, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test038");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("hi!", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary14 = watchManager0.getWatchesSummary();
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
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str15, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test039");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode6 = null;
        boolean boolean7 = watchManager0.containsWatcher("", watcher5, watcherMode6);
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test040");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        boolean boolean10 = watchManager0.containsWatcher("1 connections watching 1 paths\nTotal watches:1", watcher8, watcherMode9);
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher12);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test041");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test042");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("", watcher7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager12.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager12.containsWatcher("hi!", watcher15);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport17 = watchManager12.getWatches();
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager12.containsWatcher("", watcher19);
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager24.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.data.ACL[] aCLArray29 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList30 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList30, aCLArray29);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager24.triggerWatch("", eventType27, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30, watcherOrBitSet32);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager12.triggerWatch("", eventType22, (long) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = watchManager0.triggerWatch("1 connections watching 1 paths\nTotal watches:1", eventType10, 100L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30, watcherOrBitSet35);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(watchesReport17);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(aCLArray29);
        org.junit.Assert.assertArrayEquals(aCLArray29, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertNull(watcherOrBitSet34);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test043");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport6 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.addWatch("hi!", watcher8);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesPathReport6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test044");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager12.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager17 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager17.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.data.ACL[] aCLArray22 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList23 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean24 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList23, aCLArray22);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager17.triggerWatch("", eventType20, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23, watcherOrBitSet25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = watchManager12.triggerWatch("", eventType15, (long) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager0.triggerWatch("0 connections watching 0 paths\nTotal watches:0", eventType10, 100L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23, watcherOrBitSet28);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(aCLArray22);
        org.junit.Assert.assertArrayEquals(aCLArray22, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNull(watcherOrBitSet26);
        org.junit.Assert.assertNull(watcherOrBitSet27);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test045");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        int int2 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher4);
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        org.apache.zookeeper.data.ACL[] aCLArray13 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList14 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean15 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList14, aCLArray13);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet16 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = watchManager9.triggerWatch("", eventType11, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList14, watcherOrBitSet16);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager0.triggerWatch("0 connections watching 0 paths\nTotal watches:0", eventType7, (-1L), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList14);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(aCLArray13);
        org.junit.Assert.assertArrayEquals(aCLArray13, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNull(watcherOrBitSet17);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test046");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.addWatch("", watcher13);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test047");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        boolean boolean10 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher8, watcherMode9);
        java.lang.Class<?> wildcardClass11 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str6, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test048");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager12.shutdown();
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager12.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher15);
        org.apache.zookeeper.Watcher.Event.EventType eventType18 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager20 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.data.ACL[] aCLArray24 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList25 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean26 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList25, aCLArray24);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = watchManager20.triggerWatch("", eventType22, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList25, watcherOrBitSet27);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager12.triggerWatch("", eventType18, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList25);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = watchManager0.triggerWatch("1 connections watching 1 paths\nTotal watches:1", eventType10, (long) (short) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList25);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertNotNull(aCLArray24);
        org.junit.Assert.assertArrayEquals(aCLArray24, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertNull(watcherOrBitSet28);
        org.junit.Assert.assertNull(watcherOrBitSet29);
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test049");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher6, watcherMode7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        java.lang.Class<?> wildcardClass10 = watchesSummary9.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str4, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesSummary9);
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test050");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher10 = null;
        watchManager0.removeWatcher(watcher10);
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test051");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        int int9 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher11, watcherMode12);
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = watchManager0.triggerWatch("0 connections watching 0 paths\nTotal watches:0", eventType15, (long) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22, watcherOrBitSet26);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 1 + "'", int9 == 1);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(aCLArray21);
        org.junit.Assert.assertArrayEquals(aCLArray21, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNull(watcherOrBitSet25);
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test052");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        java.io.PrintWriter printWriter8 = null;
        watchManager0.dumpWatches(printWriter8, false);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport11 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.addWatch("hi!", watcher13);
        int int15 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(watchesReport11);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 1 + "'", int15 == 1);
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test053");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode6 = null;
        boolean boolean7 = watchManager0.containsWatcher("", watcher5, watcherMode6);
        int int8 = watchManager0.size();
        java.lang.Class<?> wildcardClass9 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 1 + "'", int8 == 1);
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test054");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport10 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher11 = null;
        watchManager0.removeWatcher(watcher11);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport13 = watchManager0.getWatches();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str9, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(watchesReport13);
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test055");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode6 = null;
        boolean boolean7 = watchManager0.containsWatcher("", watcher5, watcherMode6);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.removeWatcher("hi!", watcher9);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport11 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test056");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport10 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary11 = watchManager0.getWatchesSummary();
        watchManager0.shutdown();
        java.lang.String str13 = watchManager0.toString();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str9, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(watchesSummary11);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str13, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test057");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("hi!", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("", watcher11);
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager16 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager16.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType19 = null;
        org.apache.zookeeper.data.ACL[] aCLArray21 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList22 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean23 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList22, aCLArray21);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = watchManager16.triggerWatch("", eventType19, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22, watcherOrBitSet24);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = watchManager0.triggerWatch("0 connections watching 0 paths\nTotal watches:0", eventType14, (long) (byte) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22, watcherOrBitSet26);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(aCLArray21);
        org.junit.Assert.assertArrayEquals(aCLArray21, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNull(watcherOrBitSet25);
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test058");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("hi!", watcher4);
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher9);
        java.io.PrintWriter printWriter11 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter11, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.println(String)\" because \"writer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test059");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager12.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager17 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager17.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.data.ACL[] aCLArray22 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList23 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean24 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList23, aCLArray22);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager17.triggerWatch("", eventType20, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23, watcherOrBitSet25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = watchManager12.triggerWatch("", eventType15, (long) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager0.triggerWatch("hi!", eventType10, (long) '4', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23, watcherOrBitSet28);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertNotNull(aCLArray22);
        org.junit.Assert.assertArrayEquals(aCLArray22, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNull(watcherOrBitSet26);
        org.junit.Assert.assertNull(watcherOrBitSet27);
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test060");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher8);
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        org.apache.zookeeper.data.ACL[] aCLArray13 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList14 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean15 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList14, aCLArray13);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet16 = watchManager0.triggerWatch("hi!", eventType11, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList14);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str6, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(aCLArray13);
        org.junit.Assert.assertArrayEquals(aCLArray13, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test061");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher6);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport8 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test062");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport2 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean8 = watchManager0.addWatch("", watcher6, watcherMode7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport2);
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test063");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.removeWatcher("", watcher9);
        java.lang.String str11 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str11, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test064");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher3);
        org.apache.zookeeper.Watcher.Event.EventType eventType6 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager8 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.data.ACL[] aCLArray12 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList13 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean14 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList13, aCLArray12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet15 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet16 = watchManager8.triggerWatch("", eventType10, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList13, watcherOrBitSet15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = watchManager0.triggerWatch("", eventType6, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList13);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport18 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(aCLArray12);
        org.junit.Assert.assertArrayEquals(aCLArray12, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNull(watcherOrBitSet16);
        org.junit.Assert.assertNull(watcherOrBitSet17);
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test065");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        java.lang.String str7 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary8 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher10);
        org.apache.zookeeper.Watcher watcher12 = null;
        watchManager0.removeWatcher(watcher12);
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager0.containsWatcher("", watcher15);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport17 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str7, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesSummary8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(watchesPathReport17);
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test066");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport10 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher11 = null;
        watchManager0.removeWatcher(watcher11);
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager16 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager16.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType19 = null;
        org.apache.zookeeper.data.ACL[] aCLArray21 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList22 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean23 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList22, aCLArray21);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = watchManager16.triggerWatch("", eventType19, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22, watcherOrBitSet24);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager0.triggerWatch("1 connections watching 1 paths\nTotal watches:1", eventType14, (long) (short) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str9, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(aCLArray21);
        org.junit.Assert.assertArrayEquals(aCLArray21, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNull(watcherOrBitSet25);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test067");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport3 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertNotNull(watchesPathReport3);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test068");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        java.lang.String str7 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary8 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher10);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str7, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesSummary8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test069");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager0.getWatchesSummary();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.containsWatcher("hi!", watcher14);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str6, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test070");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager5.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType8 = null;
        org.apache.zookeeper.data.ACL[] aCLArray10 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList11 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean12 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList11, aCLArray10);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager5.triggerWatch("", eventType8, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList11, watcherOrBitSet13);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet15 = watchManager0.triggerWatch("", eventType3, (long) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList11);
        java.lang.Class<?> wildcardClass16 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(aCLArray10);
        org.junit.Assert.assertArrayEquals(aCLArray10, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNull(watcherOrBitSet15);
        org.junit.Assert.assertNotNull(wildcardClass16);
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test071");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode6 = null;
        boolean boolean7 = watchManager0.containsWatcher("", watcher5, watcherMode6);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport8 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test072");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str6, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesReport7);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test073");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher13 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode14 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean15 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher13, watcherMode14);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test074");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager17 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType19 = null;
        org.apache.zookeeper.data.ACL[] aCLArray21 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList22 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean23 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList22, aCLArray21);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = watchManager17.triggerWatch("", eventType19, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22, watcherOrBitSet24);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager0.triggerWatch("1 connections watching 1 paths\nTotal watches:1", eventType15, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str6, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(aCLArray21);
        org.junit.Assert.assertArrayEquals(aCLArray21, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNull(watcherOrBitSet25);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test075");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport6 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.containsWatcher("1 connections watching 1 paths\nTotal watches:1", watcher8);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesPathReport6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test076");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("hi!", watcher4);
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher10);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test077");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType13 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager15 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager15.shutdown();
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager15.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher18);
        org.apache.zookeeper.Watcher.Event.EventType eventType21 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager23 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.data.ACL[] aCLArray27 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList28 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean29 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList28, aCLArray27);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager23.triggerWatch("", eventType25, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28, watcherOrBitSet30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager15.triggerWatch("", eventType21, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager0.triggerWatch("1 connections watching 1 paths\nTotal watches:1", eventType13, (long) (byte) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28, watcherOrBitSet33);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertNotNull(aCLArray27);
        org.junit.Assert.assertArrayEquals(aCLArray27, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNull(watcherOrBitSet32);
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test078");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("hi!", watcher7);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test079");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher10);
        int int12 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str4, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 2 + "'", int12 == 2);
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test080");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean4 = watchManager0.addWatch("", watcher2, watcherMode3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test081");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher6, watcherMode7);
        java.lang.String str9 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str4, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str9, "1 connections watching 1 paths\nTotal watches:1");
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test082");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        java.lang.String str7 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport8 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str7, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesReport8);
        org.junit.Assert.assertNotNull(watchesSummary9);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test083");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("hi!", watcher4);
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("", watcher7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test084");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport12 = watchManager0.getWatches();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(watchesReport12);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test085");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher10);
        watchManager0.shutdown();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test086");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport11 = watchManager0.getWatches();
        java.lang.Class<?> wildcardClass12 = watchesReport11.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(watchesReport11);
        org.junit.Assert.assertNotNull(wildcardClass12);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test087");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher6);
        int int8 = watchManager0.size();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport9 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 1 + "'", int8 == 1);
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test088");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher10, watcherMode11);
        org.apache.zookeeper.Watcher watcher13 = null;
        watchManager0.removeWatcher(watcher13);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport15 = watchManager0.getWatches();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesReport15);
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test089");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher8);
        java.lang.Class<?> wildcardClass10 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str6, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test090");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport2 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher.Event.EventType eventType4 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager6 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType8 = null;
        org.apache.zookeeper.data.ACL[] aCLArray10 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList11 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean12 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList11, aCLArray10);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager6.triggerWatch("", eventType8, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList11, watcherOrBitSet13);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet15 = watchManager0.triggerWatch("1 connections watching 1 paths\nTotal watches:1", eventType4, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList11);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport2);
        org.junit.Assert.assertNotNull(aCLArray10);
        org.junit.Assert.assertArrayEquals(aCLArray10, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNull(watcherOrBitSet14);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test091");
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
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test092");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager14 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager14.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType17 = null;
        org.apache.zookeeper.data.ACL[] aCLArray19 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList20 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean21 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList20, aCLArray19);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet23 = watchManager14.triggerWatch("", eventType17, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20, watcherOrBitSet22);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = watchManager0.triggerWatch("1 connections watching 1 paths\nTotal watches:1", eventType12, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20, watcherOrBitSet24);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertNotNull(aCLArray19);
        org.junit.Assert.assertArrayEquals(aCLArray19, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNull(watcherOrBitSet23);
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test093");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("hi!", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager0.removeWatcher("hi!", watcher15);
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.containsWatcher("", watcher18);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test094");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager0.getWatchesSummary();
        java.lang.String str6 = watchManager0.toString();
        int int7 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str6, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 1 + "'", int7 == 1);
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test095");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.String str6 = watchManager0.toString();
        java.lang.Class<?> wildcardClass7 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str6, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test096");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("hi!", watcher4);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(watchesSummary6);
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test097");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager12.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager17 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager17.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.data.ACL[] aCLArray22 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList23 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean24 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList23, aCLArray22);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager17.triggerWatch("", eventType20, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23, watcherOrBitSet25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = watchManager12.triggerWatch("", eventType15, (long) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager0.triggerWatch("1 connections watching 1 paths\nTotal watches:1", eventType10, (long) (byte) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23, watcherOrBitSet28);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str4, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(aCLArray22);
        org.junit.Assert.assertArrayEquals(aCLArray22, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNull(watcherOrBitSet26);
        org.junit.Assert.assertNull(watcherOrBitSet27);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test098");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher13 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode14 = null;
        boolean boolean15 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher13, watcherMode14);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test099");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher6);
        java.lang.Class<?> wildcardClass8 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test100");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("hi!", watcher10);
        org.apache.zookeeper.Watcher.Event.EventType eventType13 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager15 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager15.shutdown();
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager15.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher18);
        org.apache.zookeeper.Watcher.Event.EventType eventType21 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager23 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.data.ACL[] aCLArray27 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList28 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean29 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList28, aCLArray27);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager23.triggerWatch("", eventType25, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28, watcherOrBitSet30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager15.triggerWatch("", eventType21, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager0.triggerWatch("hi!", eventType13, (long) 'a', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28, watcherOrBitSet33);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str4, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertNotNull(aCLArray27);
        org.junit.Assert.assertArrayEquals(aCLArray27, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNull(watcherOrBitSet32);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test101");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("hi!", watcher7);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test102");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("hi!", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean12 = watchManager0.addWatch("", watcher10, watcherMode11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test103");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode6 = null;
        boolean boolean7 = watchManager0.containsWatcher("", watcher5, watcherMode6);
        int int8 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher10, watcherMode11);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 1 + "'", int8 == 1);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test104");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean6 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher4, watcherMode5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test105");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager5.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType8 = null;
        org.apache.zookeeper.data.ACL[] aCLArray10 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList11 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean12 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList11, aCLArray10);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager5.triggerWatch("", eventType8, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList11, watcherOrBitSet13);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet15 = watchManager0.triggerWatch("", eventType3, (long) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList11);
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport17 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertNotNull(aCLArray10);
        org.junit.Assert.assertArrayEquals(aCLArray10, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNull(watcherOrBitSet15);
        org.junit.Assert.assertNotNull(watchesPathReport17);
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test106");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        watchManager0.shutdown();
        java.lang.Class<?> wildcardClass7 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test107");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager0.getWatchesSummary();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher8);
        java.lang.String str10 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str6, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "1 connections watching 2 paths\nTotal watches:2" + "'", str10, "1 connections watching 2 paths\nTotal watches:2");
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test108");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher4);
        java.lang.String str6 = watchManager0.toString();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str6, "1 connections watching 1 paths\nTotal watches:1");
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test109");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = watchManager0.addWatch("hi!", watcher7, watcherMode8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test110");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.removeWatcher("hi!", watcher16);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test111");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        boolean boolean10 = watchManager0.containsWatcher("1 connections watching 1 paths\nTotal watches:1", watcher8, watcherMode9);
        java.lang.Class<?> wildcardClass11 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test112");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        java.lang.String str7 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        watchManager0.removeWatcher(watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.removeWatcher("hi!", watcher11, watcherMode12);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str7, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test113");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("hi!", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager0.removeWatcher("hi!", watcher15);
        org.apache.zookeeper.Watcher.Event.EventType eventType18 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager20 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager20.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType23 = null;
        org.apache.zookeeper.data.ACL[] aCLArray25 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList26 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean27 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList26, aCLArray25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager20.triggerWatch("", eventType23, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26, watcherOrBitSet28);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = watchManager0.triggerWatch("0 connections watching 0 paths\nTotal watches:0", eventType18, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(aCLArray25);
        org.junit.Assert.assertArrayEquals(aCLArray25, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNull(watcherOrBitSet29);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test114");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher8);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test115");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        int int5 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str4, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(watchesSummary6);
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test116");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        java.lang.String str7 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport8 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("hi!", watcher10);
        org.apache.zookeeper.Watcher watcher12 = null;
        watchManager0.removeWatcher(watcher12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean17 = watchManager0.addWatch("1 connections watching 2 paths\nTotal watches:2", watcher15, watcherMode16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str7, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesReport8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test117");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport10 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary11 = watchManager0.getWatchesSummary();
        int int12 = watchManager0.size();
        java.lang.String str13 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(watchesSummary11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str13, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test118");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        watchManager0.shutdown();
        java.lang.Class<?> wildcardClass9 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test119");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher12 = null;
        watchManager0.removeWatcher(watcher12);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test120");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher10, watcherMode11);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test121");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("hi!", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary14 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.containsWatcher("hi!", watcher16);
        java.lang.String str18 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        boolean boolean22 = watchManager0.containsWatcher("", watcher20, watcherMode21);
        org.apache.zookeeper.Watcher watcher23 = null;
        watchManager0.removeWatcher(watcher23);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str18, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test122");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher6);
        int int8 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("", watcher10);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 1 + "'", int8 == 1);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test123");
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
        org.apache.zookeeper.server.watch.WatcherMode watcherMode14 = null;
        boolean boolean15 = watchManager0.containsWatcher("1 connections watching 1 paths\nTotal watches:1", watcher13, watcherMode14);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary16 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher18);
        java.lang.String str20 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(watchesSummary16);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str20, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test124");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        int int2 = watchManager0.size();
        java.lang.Class<?> wildcardClass3 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test125");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.addWatch("", watcher9);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test126");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher6);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.containsWatcher("", watcher9);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test127");
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
        int int15 = watchManager0.size();
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test128");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport10 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher12);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test129");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher6, watcherMode7);
        java.lang.Class<?> wildcardClass9 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str4, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test130");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
        java.lang.Class<?> wildcardClass10 = watchesPathReport9.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesPathReport9);
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test131");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary8 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(watchesSummary8);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test132");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        java.lang.String str7 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        watchManager0.removeWatcher(watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher11);
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str7, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test133");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        java.lang.String str8 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str8, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test134");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher6, watcherMode7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesSummary9);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test135");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        int int5 = watchManager0.size();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager9.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager0.triggerWatch("1 connections watching 1 paths\nTotal watches:1", eventType7, (long) (byte) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str4, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test136");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher13);
        java.lang.Class<?> wildcardClass15 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(wildcardClass15);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test137");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher13 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode14 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean15 = watchManager0.addWatch("hi!", watcher13, watcherMode14);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test138");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        int int5 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.containsWatcher("hi!", watcher8);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test139");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher10);
        org.apache.zookeeper.Watcher.Event.EventType eventType13 = null;
        java.util.List<org.apache.zookeeper.data.ACL> aCLList15 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet16 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = watchManager0.triggerWatch("1 connections watching 2 paths\nTotal watches:2", eventType13, (long) (byte) 100, aCLList15, watcherOrBitSet16);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test140");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        int int5 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher8);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager14 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager14.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType17 = null;
        org.apache.zookeeper.data.ACL[] aCLArray19 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList20 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean21 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList20, aCLArray19);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet23 = watchManager14.triggerWatch("", eventType17, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20, watcherOrBitSet22);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = watchManager0.triggerWatch("1 connections watching 1 paths\nTotal watches:1", eventType12, (long) (short) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20, watcherOrBitSet24);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray19);
        org.junit.Assert.assertArrayEquals(aCLArray19, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNull(watcherOrBitSet23);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test141");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        java.lang.String str9 = watchManager0.toString();
        java.lang.String str10 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher12);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport14 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str9, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str10, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test142");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test143");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher6, watcherMode7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager0.getWatchesSummary();
        java.lang.Class<?> wildcardClass11 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str4, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesSummary9);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test144");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher6, watcherMode7);
        java.io.PrintWriter printWriter9 = null;
        watchManager0.dumpWatches(printWriter9, true);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test145");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        java.io.PrintWriter printWriter8 = null;
        watchManager0.dumpWatches(printWriter8, false);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport11 = watchManager0.getWatches();
        java.lang.String str12 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(watchesReport11);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str12, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test146");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher3);
        int int5 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test147");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        java.util.List<org.apache.zookeeper.data.ACL> aCLList12 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager0.triggerWatch("1 connections watching 2 paths\nTotal watches:2", eventType10, 1L, aCLList12);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str4, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test148");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("hi!", watcher3);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test149");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher3);
        org.apache.zookeeper.Watcher watcher5 = null;
        watchManager0.removeWatcher(watcher5);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test150");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport6 = watchManager0.getWatchesByPath();
        java.lang.String str7 = watchManager0.toString();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesPathReport6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str7, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test151");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.containsWatcher("hi!", watcher12);
        java.io.PrintWriter printWriter14 = null;
        watchManager0.dumpWatches(printWriter14, false);
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.addWatch("", watcher18);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test152");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        java.lang.String str9 = watchManager0.toString();
        java.lang.String str10 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.containsWatcher("", watcher15, watcherMode16);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str9, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str10, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test153");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType8 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager10 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager10.shutdown();
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager10.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher13);
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.data.ACL[] aCLArray22 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList23 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean24 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList23, aCLArray22);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager18.triggerWatch("", eventType20, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23, watcherOrBitSet25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = watchManager10.triggerWatch("", eventType16, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = watchManager0.triggerWatch("1 connections watching 2 paths\nTotal watches:2", eventType8, (long) (byte) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertNotNull(aCLArray22);
        org.junit.Assert.assertArrayEquals(aCLArray22, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNull(watcherOrBitSet26);
        org.junit.Assert.assertNull(watcherOrBitSet27);
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test154");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("hi!", watcher4);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test155");
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
        org.apache.zookeeper.server.watch.WatcherMode watcherMode14 = null;
        boolean boolean15 = watchManager0.containsWatcher("1 connections watching 1 paths\nTotal watches:1", watcher13, watcherMode14);
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        boolean boolean19 = watchManager0.removeWatcher("1 connections watching 2 paths\nTotal watches:2", watcher17, watcherMode18);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test156");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("hi!", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        boolean boolean16 = watchManager0.containsWatcher("hi!", watcher14, watcherMode15);
        java.lang.String str17 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport18 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        boolean boolean22 = watchManager0.removeWatcher("1 connections watching 2 paths\nTotal watches:2", watcher20, watcherMode21);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str17, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesReport18);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test157");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        boolean boolean10 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher8, watcherMode9);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport11 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str6, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(watchesPathReport11);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test158");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        java.lang.String str7 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary8 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher10);
        org.apache.zookeeper.Watcher.Event.EventType eventType13 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager15 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager15.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType18 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager20 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager20.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType23 = null;
        org.apache.zookeeper.data.ACL[] aCLArray25 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList26 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean27 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList26, aCLArray25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager20.triggerWatch("", eventType23, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26, watcherOrBitSet28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = watchManager15.triggerWatch("", eventType18, (long) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager0.triggerWatch("hi!", eventType13, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26, watcherOrBitSet31);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str7, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesSummary8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(aCLArray25);
        org.junit.Assert.assertArrayEquals(aCLArray25, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNull(watcherOrBitSet29);
        org.junit.Assert.assertNull(watcherOrBitSet30);
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test159");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport10 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher11 = null;
        watchManager0.removeWatcher(watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher14);
        org.apache.zookeeper.Watcher.Event.EventType eventType17 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager19 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher21 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode22 = null;
        boolean boolean23 = watchManager19.containsWatcher("hi!", watcher21, watcherMode22);
        java.lang.String str24 = watchManager19.toString();
        org.apache.zookeeper.Watcher watcher26 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode27 = null;
        boolean boolean28 = watchManager19.removeWatcher("", watcher26, watcherMode27);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport29 = watchManager19.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType31 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager33 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport34 = watchManager33.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher36 = null;
        boolean boolean37 = watchManager33.containsWatcher("hi!", watcher36);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport38 = watchManager33.getWatches();
        org.apache.zookeeper.Watcher watcher40 = null;
        boolean boolean41 = watchManager33.containsWatcher("", watcher40);
        org.apache.zookeeper.Watcher.Event.EventType eventType43 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager45 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager45.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType48 = null;
        org.apache.zookeeper.data.ACL[] aCLArray50 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList51 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean52 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList51, aCLArray50);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet53 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet54 = watchManager45.triggerWatch("", eventType48, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList51, watcherOrBitSet53);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet55 = watchManager33.triggerWatch("", eventType43, (long) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList51);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet56 = watchManager19.triggerWatch("", eventType31, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList51);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet57 = watchManager0.triggerWatch("hi!", eventType17, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList51);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str9, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str24, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertNotNull(watchesReport29);
        org.junit.Assert.assertNotNull(watchesPathReport34);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertNotNull(watchesReport38);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertNotNull(aCLArray50);
        org.junit.Assert.assertArrayEquals(aCLArray50, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + false + "'", boolean52 == false);
        org.junit.Assert.assertNull(watcherOrBitSet54);
        org.junit.Assert.assertNull(watcherOrBitSet55);
        org.junit.Assert.assertNull(watcherOrBitSet56);
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test160");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("hi!", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        boolean boolean16 = watchManager0.containsWatcher("hi!", watcher14, watcherMode15);
        int int17 = watchManager0.size();
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test161");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        java.lang.String str8 = watchManager0.toString();
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("hi!", watcher11, watcherMode12);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str8, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str9, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test162");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport10 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary11 = watchManager0.getWatchesSummary();
        int int12 = watchManager0.size();
        java.lang.Class<?> wildcardClass13 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(watchesSummary11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(wildcardClass13);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test163");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("hi!", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary14 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.containsWatcher("hi!", watcher16);
        java.lang.String str18 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        boolean boolean22 = watchManager0.containsWatcher("", watcher20, watcherMode21);
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager26 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager26.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType29 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager31 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager31.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType34 = null;
        org.apache.zookeeper.data.ACL[] aCLArray36 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList37 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean38 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList37, aCLArray36);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = watchManager31.triggerWatch("", eventType34, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37, watcherOrBitSet39);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager26.triggerWatch("", eventType29, (long) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager0.triggerWatch("hi!", eventType24, (long) (byte) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str18, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(aCLArray36);
        org.junit.Assert.assertArrayEquals(aCLArray36, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertNull(watcherOrBitSet40);
        org.junit.Assert.assertNull(watcherOrBitSet41);
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test164");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("hi!", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport14 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.removeWatcher("hi!", watcher16);
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.containsWatcher("", watcher19);
        int int21 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher22 = null;
        watchManager0.removeWatcher(watcher22);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesPathReport14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test165");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher10);
        int int12 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test166");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("hi!", watcher4);
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.addWatch("hi!", watcher9);
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher12);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test167");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("hi!", watcher4);
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.addWatch("hi!", watcher9);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport11 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test168");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher10);
        int int12 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.addWatch("hi!", watcher14);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary16 = watchManager0.getWatchesSummary();
        watchManager0.shutdown();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertNotNull(watchesSummary16);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test169");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        java.lang.String str8 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str8, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test170");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("hi!", watcher4);
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher9);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport11 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test171");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 2 paths\nTotal watches:2", watcher6, watcherMode7);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test172");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType9 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager11 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager11.shutdown();
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager11.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher14);
        org.apache.zookeeper.Watcher.Event.EventType eventType17 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager19 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType21 = null;
        org.apache.zookeeper.data.ACL[] aCLArray23 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList24 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean25 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList24, aCLArray23);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = watchManager19.triggerWatch("", eventType21, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList24, watcherOrBitSet26);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = watchManager11.triggerWatch("", eventType17, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList24);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager0.triggerWatch("hi!", eventType9, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList24);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertNotNull(aCLArray23);
        org.junit.Assert.assertArrayEquals(aCLArray23, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNull(watcherOrBitSet27);
        org.junit.Assert.assertNull(watcherOrBitSet28);
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test173");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test174");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher2 = null;
        watchManager0.removeWatcher(watcher2);
        org.junit.Assert.assertNotNull(watchesPathReport1);
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test175");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode6 = null;
        boolean boolean7 = watchManager0.containsWatcher("", watcher5, watcherMode6);
        int int8 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher10);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 1 + "'", int8 == 1);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test176");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        int int2 = watchManager0.size();
        java.lang.String str3 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str3, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test177");
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
        boolean boolean18 = watchManager0.removeWatcher("hi!", watcher16, watcherMode17);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test178");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("hi!", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary14 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.containsWatcher("hi!", watcher16);
        java.lang.String str18 = watchManager0.toString();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager22 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher24 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode25 = null;
        boolean boolean26 = watchManager22.containsWatcher("hi!", watcher24, watcherMode25);
        java.io.PrintWriter printWriter27 = null;
        watchManager22.dumpWatches(printWriter27, false);
        org.apache.zookeeper.Watcher.Event.EventType eventType31 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager33 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager33.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType36 = null;
        org.apache.zookeeper.data.ACL[] aCLArray38 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList39 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean40 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList39, aCLArray38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager33.triggerWatch("", eventType36, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39, watcherOrBitSet41);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager22.triggerWatch("", eventType31, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager0.triggerWatch("0 connections watching 0 paths\nTotal watches:0", eventType20, (long) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str18, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertNotNull(aCLArray38);
        org.junit.Assert.assertArrayEquals(aCLArray38, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertNull(watcherOrBitSet42);
        org.junit.Assert.assertNull(watcherOrBitSet43);
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test179");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher7, watcherMode8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test180");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher9);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test181");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        java.lang.String str7 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        watchManager0.removeWatcher(watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher14);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport16 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str7, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test182");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("hi!", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        boolean boolean16 = watchManager0.containsWatcher("hi!", watcher14, watcherMode15);
        java.lang.String str17 = watchManager0.toString();
        java.lang.String str18 = watchManager0.toString();
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str17, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str18, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test183");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher12);
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher15);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test184");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager0.getWatchesSummary();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.addWatch("", watcher14);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str6, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test185");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("hi!", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport14 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.removeWatcher("hi!", watcher16);
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.containsWatcher("", watcher19);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport21 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary22 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport23 = watchManager0.getWatches();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesPathReport14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(watchesReport21);
        org.junit.Assert.assertNotNull(watchesSummary22);
        org.junit.Assert.assertNotNull(watchesReport23);
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test186");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher10);
        int int12 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.addWatch("hi!", watcher14);
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean19 = watchManager0.addWatch("1 connections watching 2 paths\nTotal watches:2", watcher17, watcherMode18);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test187");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.addWatch("", watcher9);
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.containsWatcher("1 connections watching 1 paths\nTotal watches:1", watcher12);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary14 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test188");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher10, watcherMode11);
        org.apache.zookeeper.Watcher watcher13 = null;
        watchManager0.removeWatcher(watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.containsWatcher("", watcher16);
        org.apache.zookeeper.Watcher watcher18 = null;
        watchManager0.removeWatcher(watcher18);
        java.io.PrintWriter printWriter20 = null;
        watchManager0.dumpWatches(printWriter20, false);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test189");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher10);
        int int12 = watchManager0.size();
        java.lang.String str13 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean17 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher15, watcherMode16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str13, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test190");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.containsWatcher("1 connections watching 1 paths\nTotal watches:1", watcher10, watcherMode11);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str4, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test191");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        watchManager0.shutdown();
        org.junit.Assert.assertNotNull(watchesPathReport1);
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test192");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport9 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean13 = watchManager0.addWatch("1 connections watching 2 paths\nTotal watches:2", watcher11, watcherMode12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertNotNull(watchesReport9);
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test193");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        int int5 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = watchManager0.addWatch("1 connections watching 2 paths\nTotal watches:2", watcher7, watcherMode8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str4, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test194");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        boolean boolean10 = watchManager0.containsWatcher("1 connections watching 1 paths\nTotal watches:1", watcher8, watcherMode9);
        org.apache.zookeeper.Watcher watcher11 = null;
        watchManager0.removeWatcher(watcher11);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test195");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport11 = watchManager0.getWatches();
        java.io.PrintWriter printWriter12 = null;
        watchManager0.dumpWatches(printWriter12, false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(watchesReport11);
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test196");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher11);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test197");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport2 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher4);
        org.junit.Assert.assertNotNull(watchesPathReport2);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test198");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        java.io.PrintWriter printWriter8 = null;
        watchManager0.dumpWatches(printWriter8, false);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport11 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.addWatch("hi!", watcher13);
        java.lang.Class<?> wildcardClass15 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(watchesReport11);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertNotNull(wildcardClass15);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test199");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        watchManager0.shutdown();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str6, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test200");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport10 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary11 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary12 = watchManager0.getWatchesSummary();
        java.lang.String str13 = watchManager0.toString();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str9, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(watchesSummary11);
        org.junit.Assert.assertNotNull(watchesSummary12);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str13, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test201");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher.Event.EventType eventType6 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager8 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager8.containsWatcher("hi!", watcher10, watcherMode11);
        java.lang.String str13 = watchManager8.toString();
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager8.removeWatcher("", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher.Event.EventType eventType19 = null;
        org.apache.zookeeper.data.ACL[] aCLArray21 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList22 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean23 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList22, aCLArray21);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = watchManager8.triggerWatch("", eventType19, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22, watcherOrBitSet24);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager0.triggerWatch("hi!", eventType6, (long) (byte) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str4, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str13, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNotNull(aCLArray21);
        org.junit.Assert.assertArrayEquals(aCLArray21, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNull(watcherOrBitSet25);
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test202");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType13 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager15 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        boolean boolean19 = watchManager15.containsWatcher("hi!", watcher17, watcherMode18);
        java.lang.String str20 = watchManager15.toString();
        org.apache.zookeeper.Watcher watcher22 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode23 = null;
        boolean boolean24 = watchManager15.removeWatcher("", watcher22, watcherMode23);
        org.apache.zookeeper.Watcher.Event.EventType eventType26 = null;
        org.apache.zookeeper.data.ACL[] aCLArray28 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList29 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean30 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList29, aCLArray28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager15.triggerWatch("", eventType26, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList29, watcherOrBitSet31);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager0.triggerWatch("1 connections watching 2 paths\nTotal watches:2", eventType13, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList29);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str20, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNotNull(aCLArray28);
        org.junit.Assert.assertArrayEquals(aCLArray28, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertNull(watcherOrBitSet32);
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test203");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode6 = null;
        boolean boolean7 = watchManager0.containsWatcher("", watcher5, watcherMode6);
        org.apache.zookeeper.Watcher watcher8 = null;
        watchManager0.removeWatcher(watcher8);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test204");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesSummary9);
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test205");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        int int5 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        boolean boolean10 = watchManager0.removeWatcher("1 connections watching 2 paths\nTotal watches:2", watcher8, watcherMode9);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test206");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher7);
        java.lang.String str9 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str9, "1 connections watching 1 paths\nTotal watches:1");
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test207");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher11);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str6, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test208");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher6, watcherMode7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager0.getWatchesSummary();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport11 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str4, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesSummary9);
        org.junit.Assert.assertNotNull(watchesSummary10);
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test209");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager0.getWatchesSummary();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher8);
        org.apache.zookeeper.Watcher watcher10 = null;
        watchManager0.removeWatcher(watcher10);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport12 = watchManager0.getWatches();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str6, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertNotNull(watchesReport12);
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test210");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport6 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        boolean boolean10 = watchManager0.removeWatcher("1 connections watching 2 paths\nTotal watches:2", watcher8, watcherMode9);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesPathReport6);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test211");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        int int9 = watchManager0.size();
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        org.apache.zookeeper.data.ACL[] aCLArray13 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList14 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean15 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList14, aCLArray13);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet16 = watchManager0.triggerWatch("1 connections watching 1 paths\nTotal watches:1", eventType11, (long) 'a', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList14);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 1 + "'", int9 == 1);
        org.junit.Assert.assertNotNull(aCLArray13);
        org.junit.Assert.assertArrayEquals(aCLArray13, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test212");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.removeWatcher("", watcher6);
        org.apache.zookeeper.Watcher.Event.EventType eventType9 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager11 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager11.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager16 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager16.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType19 = null;
        org.apache.zookeeper.data.ACL[] aCLArray21 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList22 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean23 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList22, aCLArray21);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = watchManager16.triggerWatch("", eventType19, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22, watcherOrBitSet24);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager11.triggerWatch("", eventType14, (long) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = watchManager0.triggerWatch("", eventType9, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22, watcherOrBitSet27);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(aCLArray21);
        org.junit.Assert.assertArrayEquals(aCLArray21, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNull(watcherOrBitSet25);
        org.junit.Assert.assertNull(watcherOrBitSet26);
        org.junit.Assert.assertNull(watcherOrBitSet28);
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test213");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport2 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        boolean boolean6 = watchManager0.removeWatcher("", watcher4, watcherMode5);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary7 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertNotNull(watchesPathReport2);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(watchesSummary7);
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test214");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.removeWatcher("", watcher6);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.containsWatcher("hi!", watcher9);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test215");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport5 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test216");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        java.lang.String str7 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        watchManager0.removeWatcher(watcher8);
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        java.util.List<org.apache.zookeeper.data.ACL> aCLList13 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet15 = watchManager0.triggerWatch("hi!", eventType11, (long) 10, aCLList13, watcherOrBitSet14);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str7, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test217");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher10);
        org.apache.zookeeper.Watcher watcher13 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode14 = null;
        boolean boolean15 = watchManager0.removeWatcher("", watcher13, watcherMode14);
        java.lang.String str16 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher17 = null;
        watchManager0.removeWatcher(watcher17);
        java.lang.String str19 = watchManager0.toString();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str16, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str19, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test218");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher6, watcherMode7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher10 = null;
        watchManager0.removeWatcher(watcher10);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str4, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesSummary9);
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test219");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher7, watcherMode8);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test220");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        java.lang.String str7 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary8 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher10);
        org.apache.zookeeper.Watcher.Event.EventType eventType13 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager15 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager15.shutdown();
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager15.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher18);
        org.apache.zookeeper.Watcher.Event.EventType eventType21 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager23 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.data.ACL[] aCLArray27 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList28 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean29 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList28, aCLArray27);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager23.triggerWatch("", eventType25, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28, watcherOrBitSet30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager15.triggerWatch("", eventType21, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager0.triggerWatch("", eventType13, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28, watcherOrBitSet33);
        int int35 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str7, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesSummary8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertNotNull(aCLArray27);
        org.junit.Assert.assertArrayEquals(aCLArray27, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNull(watcherOrBitSet32);
        org.junit.Assert.assertNull(watcherOrBitSet34);
        org.junit.Assert.assertTrue("'" + int35 + "' != '" + 0 + "'", int35 == 0);
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test221");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport11 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertNotNull(watchesReport11);
        org.junit.Assert.assertNotNull(watchesPathReport12);
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test222");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        java.lang.String str7 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary8 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher10);
        org.apache.zookeeper.Watcher watcher12 = null;
        watchManager0.removeWatcher(watcher12);
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager0.addWatch("hi!", watcher15);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str7, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesSummary8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test223");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        int int5 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher8);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager0.getWatchesSummary();
        java.lang.Class<?> wildcardClass11 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test224");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher10, watcherMode11);
        org.apache.zookeeper.Watcher watcher13 = null;
        watchManager0.removeWatcher(watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        boolean boolean18 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher16, watcherMode17);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport19 = watchManager0.getWatches();
        java.io.PrintWriter printWriter20 = null;
        watchManager0.dumpWatches(printWriter20, false);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNotNull(watchesReport19);
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test225");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        int int5 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary7 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesSummary7);
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test226");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("hi!", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary14 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.containsWatcher("hi!", watcher16);
        java.lang.String str18 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        boolean boolean22 = watchManager0.containsWatcher("", watcher20, watcherMode21);
        int int23 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str18, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + 0 + "'", int23 == 0);
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test227");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport10 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary11 = watchManager0.getWatchesSummary();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        boolean boolean16 = watchManager0.containsWatcher("", watcher14, watcherMode15);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str9, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(watchesSummary11);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test228");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher6, watcherMode7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        watchManager0.shutdown();
        java.io.PrintWriter printWriter11 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter11, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.print(String)\" because \"writer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str4, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesSummary9);
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test229");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("", watcher10);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test230");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(watchesPathReport12);
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test231");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        int int5 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("1 connections watching 2 paths\nTotal watches:2", watcher7);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test232");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher10, watcherMode11);
        org.apache.zookeeper.Watcher watcher13 = null;
        watchManager0.removeWatcher(watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        boolean boolean18 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher16, watcherMode17);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport19 = watchManager0.getWatches();
        int int20 = watchManager0.size();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNotNull(watchesReport19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test233");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager0.getWatchesSummary();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher11);
        int int13 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("", watcher15, watcherMode16);
        java.lang.String str18 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str6, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 2 + "'", int13 == 2);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str18, "1 connections watching 1 paths\nTotal watches:1");
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc3RandoopTest0.test234");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher10);
        int int12 = watchManager0.size();
        java.lang.String str13 = watchManager0.toString();
        int int14 = watchManager0.size();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str13, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
    }
}

