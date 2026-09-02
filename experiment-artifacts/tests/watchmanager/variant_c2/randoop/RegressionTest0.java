package org.apache.zookeeper.server.watch.watchmanager.variant_c2.randoop;

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
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test001");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher3);
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
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test002");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.Class<?> wildcardClass4 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test003");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher7);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport9 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because the return value of \"java.util.Map$Entry.getKey()\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test004");
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
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because the return value of \"java.util.Map$Entry.getKey()\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test005");
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
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test006");
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
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test007");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher7);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test008");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        java.lang.Class<?> wildcardClass5 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str4, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test009");
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
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test010");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher7, watcherMode8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test011");
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = watchManager0.triggerWatch("0 connections watching 0 paths\n", eventType10, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet21);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 31");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test012");
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
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test013");
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
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test014");
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = watchManager0.triggerWatch("1 connections watching 1 paths\n -> [null]\n", eventType8, (long) 1, aCLList10, watcherOrBitSet11);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 42");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\n" + "'", str6, "0 connections watching 0 paths\n");
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test015");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher10, watcherMode11);
        java.lang.Class<?> wildcardClass13 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(wildcardClass13);
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test016");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher6);
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
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test017");
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
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test018");
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
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test019");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher10, watcherMode11);
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
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test020");
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
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\n" + "'", str6, "0 connections watching 0 paths\n");
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test021");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher3);
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
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test022");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.containsWatcher("hi!", watcher12);
        java.lang.Class<?> wildcardClass14 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(wildcardClass14);
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test023");
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
            boolean boolean13 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher11, watcherMode12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test024");
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
            boolean boolean19 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher17, watcherMode18);
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
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test025");
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
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because the return value of \"java.util.Map$Entry.getKey()\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test026");
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
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\n" + "'", str6, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test027");
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = watchManager0.triggerWatch("0 connections watching 0 paths\n", eventType10, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 31");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
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
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test028");
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
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test029");
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
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test030");
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("1 connections watching 1 paths\n -> [null]\n", eventType16, (long) (-1), aCLList18, watcherOrBitSet19);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 42");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test031");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher6, watcherMode7);
        java.lang.Class<?> wildcardClass9 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str4, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test032");
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
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "0 connections watching 0 paths\n" + "'", str15, "0 connections watching 0 paths\n");
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test033");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        boolean boolean10 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher8, watcherMode9);
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher12);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test034");
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
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test035");
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = watchManager0.triggerWatch("1 connections watching 1 paths\n -> [null]\n", eventType10, 100L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30, watcherOrBitSet35);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 42");
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
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test036");
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
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test037");
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager0.triggerWatch("0 connections watching 0 paths\n", eventType10, 100L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23, watcherOrBitSet28);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 31");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(aCLArray22);
        org.junit.Assert.assertArrayEquals(aCLArray22, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNull(watcherOrBitSet26);
        org.junit.Assert.assertNull(watcherOrBitSet27);
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test038");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        int int2 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher4);
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager0.triggerWatch("0 connections watching 0 paths\n", eventType7, (-1L), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList14);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 31");
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
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test039");
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
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test040");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        boolean boolean10 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher8, watcherMode9);
        java.lang.Class<?> wildcardClass11 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\n" + "'", str6, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test041");
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
        boolean boolean16 = watchManager12.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher15);
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = watchManager0.triggerWatch("1 connections watching 1 paths\n -> [null]\n", eventType10, (long) (short) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList25);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 42");
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
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test042");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher6, watcherMode7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        java.lang.Class<?> wildcardClass10 = watchesSummary9.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str4, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesSummary9);
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test043");
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
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test044");
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
        boolean boolean13 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher11, watcherMode12);
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = watchManager0.triggerWatch("0 connections watching 0 paths\n", eventType15, (long) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22, watcherOrBitSet26);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 31");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 1 + "'", int9 == 1);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(aCLArray21);
        org.junit.Assert.assertArrayEquals(aCLArray21, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNull(watcherOrBitSet25);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test045");
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
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test046");
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
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test047");
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = watchManager0.triggerWatch("0 connections watching 0 paths\n", eventType14, (long) (byte) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22, watcherOrBitSet26);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 31");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(aCLArray21);
        org.junit.Assert.assertArrayEquals(aCLArray21, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNull(watcherOrBitSet25);
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test048");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("hi!", watcher4);
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher9);
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
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test049");
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
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test050");
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
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\n" + "'", str6, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(aCLArray13);
        org.junit.Assert.assertArrayEquals(aCLArray13, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test051");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher6);
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
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test052");
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
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test053");
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
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "0 connections watching 0 paths\n" + "'", str11, "0 connections watching 0 paths\n");
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test054");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher3);
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
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because the return value of \"java.util.Map$Entry.getKey()\" is null");
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
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test055");
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
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesSummary8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(watchesPathReport17);
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test056");
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager0.triggerWatch("1 connections watching 1 paths\n -> [null]\n", eventType14, (long) (short) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 42");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(aCLArray21);
        org.junit.Assert.assertArrayEquals(aCLArray21, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNull(watcherOrBitSet25);
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test057");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport3 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertNotNull(watchesPathReport3);
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test058");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager0.getWatchesSummary();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.containsWatcher("hi!", watcher14);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str6, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test059");
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
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test060");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.addWatch("", watcher9);
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher12);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test061");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode6 = null;
        boolean boolean7 = watchManager0.containsWatcher("", watcher5, watcherMode6);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport8 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because the return value of \"java.util.Map$Entry.getKey()\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test062");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager0.getWatchesSummary();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher8);
        org.apache.zookeeper.Watcher watcher10 = null;
        watchManager0.removeWatcher(watcher10);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str6, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test063");
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
            boolean boolean15 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher13, watcherMode14);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test064");
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager0.triggerWatch("1 connections watching 1 paths\n -> [null]\n", eventType15, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 42");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\n" + "'", str6, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(aCLArray21);
        org.junit.Assert.assertArrayEquals(aCLArray21, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNull(watcherOrBitSet25);
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test065");
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
        boolean boolean19 = watchManager15.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher18);
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager0.triggerWatch("1 connections watching 1 paths\n -> [null]\n", eventType13, (long) (byte) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28, watcherOrBitSet33);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 42");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertNotNull(aCLArray27);
        org.junit.Assert.assertArrayEquals(aCLArray27, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNull(watcherOrBitSet32);
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test066");
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
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test067");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher10, watcherMode11);
        org.apache.zookeeper.Watcher watcher13 = null;
        watchManager0.removeWatcher(watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        boolean boolean18 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher16, watcherMode17);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test068");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher10);
        int int12 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str4, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 2 + "'", int12 == 2);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test069");
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
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test070");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher6, watcherMode7);
        java.lang.String str9 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str4, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str9, "1 connections watching 1 paths\n -> [null]\n");
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test071");
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
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test072");
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
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(watchesReport12);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test073");
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
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(watchesReport11);
        org.junit.Assert.assertNotNull(wildcardClass12);
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test074");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher6);
        int int8 = watchManager0.size();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport9 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because the return value of \"java.util.Map$Entry.getKey()\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 1 + "'", int8 == 1);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test075");
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
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\n" + "'", str6, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test076");
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet15 = watchManager0.triggerWatch("1 connections watching 1 paths\n -> [null]\n", eventType4, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList11);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 42");
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
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test077");
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = watchManager0.triggerWatch("1 connections watching 1 paths\n -> [null]\n", eventType12, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20, watcherOrBitSet24);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 42");
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
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test078");
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
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str6, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 1 + "'", int7 == 1);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test079");
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
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\n" + "'", str6, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test080");
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
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test081");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher6, watcherMode7);
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager0.triggerWatch("1 connections watching 1 paths\n -> [null]\n", eventType10, (long) (byte) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23, watcherOrBitSet28);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 42");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str4, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(aCLArray22);
        org.junit.Assert.assertArrayEquals(aCLArray22, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNull(watcherOrBitSet26);
        org.junit.Assert.assertNull(watcherOrBitSet27);
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test082");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher6);
        java.lang.Class<?> wildcardClass8 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test083");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("hi!", watcher10);
        org.apache.zookeeper.Watcher.Event.EventType eventType13 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager15 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager15.shutdown();
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager15.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher18);
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
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str4, "1 connections watching 1 paths\n -> [null]\n");
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
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test084");
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
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test085");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean6 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher4, watcherMode5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test086");
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
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test087");
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
        boolean boolean13 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher12);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test088");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager0.getWatchesSummary();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher8);
        java.lang.String str10 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str6, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n" + "'", str10, "1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n");
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test089");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher7, watcherMode8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test090");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        boolean boolean10 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher8, watcherMode9);
        java.lang.Class<?> wildcardClass11 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test091");
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = watchManager0.triggerWatch("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", eventType18, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 84");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(aCLArray25);
        org.junit.Assert.assertArrayEquals(aCLArray25, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNull(watcherOrBitSet29);
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test092");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        int int5 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str4, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(watchesSummary6);
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test093");
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
            boolean boolean17 = watchManager0.addWatch("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher15, watcherMode16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesReport8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test094");
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
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test095");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        int int2 = watchManager0.size();
        java.lang.Class<?> wildcardClass3 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test096");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher6, watcherMode7);
        java.lang.Class<?> wildcardClass9 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str4, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test097");
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
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test098");
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
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesPathReport14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(watchesReport21);
        org.junit.Assert.assertNotNull(watchesSummary22);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test099");
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager0.triggerWatch("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", eventType7, (long) (byte) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 95");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str4, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test100");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher13);
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
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test101");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher10);
        org.apache.zookeeper.Watcher.Event.EventType eventType13 = null;
        java.util.List<org.apache.zookeeper.data.ACL> aCLList15 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet16 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = watchManager0.triggerWatch("1 connections watching 1 paths\n -> [null]\n", eventType13, (long) (byte) 100, aCLList15, watcherOrBitSet16);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 42");
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
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test102");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher10);
        int int12 = watchManager0.size();
        java.lang.String str13 = watchManager0.toString();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "0 connections watching 0 paths\n" + "'", str13, "0 connections watching 0 paths\n");
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test103");
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = watchManager0.triggerWatch("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", eventType12, (long) (short) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20, watcherOrBitSet24);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 84");
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
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test104");
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
        boolean boolean13 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher12);
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
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "0 connections watching 0 paths\n" + "'", str10, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test105");
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
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test106");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher6, watcherMode7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager0.getWatchesSummary();
        java.lang.Class<?> wildcardClass11 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str4, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesSummary9);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test107");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher6, watcherMode7);
        java.io.PrintWriter printWriter9 = null;
        watchManager0.dumpWatches(printWriter9, true);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test108");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        java.util.List<org.apache.zookeeper.data.ACL> aCLList12 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager0.triggerWatch("hi!", eventType10, 1L, aCLList12);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str4, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test109");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher3);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test110");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher10);
        org.apache.zookeeper.Watcher watcher13 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode14 = null;
        boolean boolean15 = watchManager0.removeWatcher("", watcher13, watcherMode14);
        java.lang.String str16 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher17 = null;
        watchManager0.removeWatcher(watcher17);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "0 connections watching 0 paths\n" + "'", str16, "0 connections watching 0 paths\n");
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test111");
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
        boolean boolean14 = watchManager10.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher13);
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = watchManager0.triggerWatch("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", eventType8, (long) (byte) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 84");
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
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test112");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("hi!", watcher4);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because the return value of \"java.util.Map$Entry.getKey()\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test113");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager0.getWatchesSummary();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher11);
        int int13 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("", watcher15, watcherMode16);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str6, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 2 + "'", int13 == 2);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test114");
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
        boolean boolean22 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher20, watcherMode21);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "0 connections watching 0 paths\n" + "'", str17, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesReport18);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test115");
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager0.triggerWatch("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", eventType13, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26, watcherOrBitSet31);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 95");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesSummary8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(aCLArray25);
        org.junit.Assert.assertArrayEquals(aCLArray25, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNull(watcherOrBitSet29);
        org.junit.Assert.assertNull(watcherOrBitSet30);
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test116");
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
        boolean boolean15 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher14);
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet57 = watchManager0.triggerWatch("0 connections watching 0 paths\n", eventType17, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList51);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 31");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "0 connections watching 0 paths\n" + "'", str24, "0 connections watching 0 paths\n");
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
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test117");
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
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test118");
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
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(watchesSummary11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(wildcardClass13);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test119");
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
        boolean boolean22 = watchManager0.containsWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher20, watcherMode21);
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
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "0 connections watching 0 paths\n" + "'", str18, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(aCLArray36);
        org.junit.Assert.assertArrayEquals(aCLArray36, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertNull(watcherOrBitSet40);
        org.junit.Assert.assertNull(watcherOrBitSet41);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test120");
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
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test121");
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
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "0 connections watching 0 paths\n" + "'", str8, "0 connections watching 0 paths\n");
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test122");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("hi!", watcher4);
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher9);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport11 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because the return value of \"java.util.Map$Entry.getKey()\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test123");
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
        boolean boolean12 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher11);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test124");
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
        boolean boolean13 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher12);
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager17 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher19 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode20 = null;
        boolean boolean21 = watchManager17.containsWatcher("hi!", watcher19, watcherMode20);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport22 = watchManager17.getWatches();
        watchManager17.shutdown();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport24 = watchManager17.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType26 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager28 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager28.shutdown();
        org.apache.zookeeper.Watcher watcher31 = null;
        boolean boolean32 = watchManager28.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher31);
        org.apache.zookeeper.Watcher.Event.EventType eventType34 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager36 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType38 = null;
        org.apache.zookeeper.data.ACL[] aCLArray40 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList41 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean42 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList41, aCLArray40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager36.triggerWatch("", eventType38, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList41, watcherOrBitSet43);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = watchManager28.triggerWatch("", eventType34, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList41);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = watchManager17.triggerWatch("", eventType26, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList41);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet47 = watchManager0.triggerWatch("1 connections watching 1 paths\n -> [null]\n", eventType15, (long) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList41);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 42");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(watchesReport22);
        org.junit.Assert.assertNotNull(watchesReport24);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + true + "'", boolean32 == true);
        org.junit.Assert.assertNotNull(aCLArray40);
        org.junit.Assert.assertArrayEquals(aCLArray40, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertNull(watcherOrBitSet45);
        org.junit.Assert.assertNull(watcherOrBitSet46);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test125");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher.Event.EventType eventType9 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager11 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager11.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager11.triggerWatch("", eventType14, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet19);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet21 = watchManager0.triggerWatch("", eventType9, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17);
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
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNull(watcherOrBitSet21);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test126");
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
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        java.lang.Class<?> wildcardClass13 = watchesPathReport12.getClass();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertNotNull(wildcardClass13);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test127");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher10);
        int int12 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.addWatch("hi!", watcher14);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary16 = watchManager0.getWatchesSummary();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport17 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
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
        org.junit.Assert.assertNotNull(watchesSummary16);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test128");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        watchManager0.shutdown();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because the return value of \"java.util.Map$Entry.getKey()\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test129");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher10, watcherMode11);
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean16 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher14, watcherMode15);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test130");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher10, watcherMode11);
        org.apache.zookeeper.Watcher watcher13 = null;
        watchManager0.removeWatcher(watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.containsWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher16);
        org.apache.zookeeper.Watcher watcher19 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode20 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean21 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher19, watcherMode20);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test131");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport5 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher7, watcherMode8);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesPathReport5);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test132");
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
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport21 = watchManager20.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher23 = null;
        boolean boolean24 = watchManager20.containsWatcher("hi!", watcher23);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport25 = watchManager20.getWatches();
        org.apache.zookeeper.Watcher watcher27 = null;
        boolean boolean28 = watchManager20.containsWatcher("", watcher27);
        org.apache.zookeeper.Watcher.Event.EventType eventType30 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager32 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager32.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.data.ACL[] aCLArray37 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList38 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean39 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList38, aCLArray37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager32.triggerWatch("", eventType35, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager20.triggerWatch("", eventType30, (long) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager0.triggerWatch("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", eventType18, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet43);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 95");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(watchesPathReport21);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNotNull(watchesReport25);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertNotNull(aCLArray37);
        org.junit.Assert.assertArrayEquals(aCLArray37, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNull(watcherOrBitSet41);
        org.junit.Assert.assertNull(watcherOrBitSet42);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test133");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        int int5 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher8);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher12 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode13 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean14 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher12, watcherMode13);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertNotNull(watchesSummary10);
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test134");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        int int5 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = watchManager0.addWatch("hi!", watcher7, watcherMode8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str4, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test135");
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
        boolean boolean12 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher14);
        org.apache.zookeeper.Watcher watcher16 = null;
        watchManager0.removeWatcher(watcher16);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test136");
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
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager0.removeWatcher("hi!", watcher15);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(watchesSummary11);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "0 connections watching 0 paths\n" + "'", str13, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test137");
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
        boolean boolean12 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher14);
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher17);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test138");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher8 = null;
        watchManager0.removeWatcher(watcher8);
        java.io.PrintWriter printWriter10 = null;
        watchManager0.dumpWatches(printWriter10, false);
        java.lang.Class<?> wildcardClass13 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(wildcardClass13);
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test139");
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
        java.lang.String str13 = watchManager0.toString();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "0 connections watching 0 paths\n" + "'", str13, "0 connections watching 0 paths\n");
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test140");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        java.lang.String str7 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary8 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher10);
        org.apache.zookeeper.Watcher.Event.EventType eventType13 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager15 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType17 = null;
        org.apache.zookeeper.data.ACL[] aCLArray19 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList20 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean21 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList20, aCLArray19);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet23 = watchManager15.triggerWatch("", eventType17, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20, watcherOrBitSet22);
        org.apache.zookeeper.Watcher watcher24 = null;
        watchManager15.removeWatcher(watcher24);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport26 = watchManager15.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType28 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager30 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager30.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType33 = null;
        org.apache.zookeeper.data.ACL[] aCLArray35 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList36 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean37 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList36, aCLArray35);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet38 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = watchManager30.triggerWatch("", eventType33, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList36, watcherOrBitSet38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager15.triggerWatch("", eventType28, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList36, watcherOrBitSet40);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager0.triggerWatch("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", eventType13, (long) (byte) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList36);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 84");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesSummary8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNotNull(aCLArray19);
        org.junit.Assert.assertArrayEquals(aCLArray19, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNull(watcherOrBitSet23);
        org.junit.Assert.assertNotNull(watchesReport26);
        org.junit.Assert.assertNotNull(aCLArray35);
        org.junit.Assert.assertArrayEquals(aCLArray35, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertNull(watcherOrBitSet39);
        org.junit.Assert.assertNull(watcherOrBitSet41);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test141");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.containsWatcher("hi!", watcher12);
        java.io.PrintWriter printWriter14 = null;
        watchManager0.dumpWatches(printWriter14, false);
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.addWatch("", watcher18);
        org.apache.zookeeper.Watcher.Event.EventType eventType21 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager23 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.data.ACL[] aCLArray27 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList28 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean29 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList28, aCLArray27);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager23.triggerWatch("", eventType25, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28, watcherOrBitSet30);
        org.apache.zookeeper.Watcher watcher32 = null;
        watchManager23.removeWatcher(watcher32);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport34 = watchManager23.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType36 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager38 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager38.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType41 = null;
        org.apache.zookeeper.data.ACL[] aCLArray43 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList44 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean45 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList44, aCLArray43);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet47 = watchManager38.triggerWatch("", eventType41, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList44, watcherOrBitSet46);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet48 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet49 = watchManager23.triggerWatch("", eventType36, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList44, watcherOrBitSet48);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet50 = watchManager0.triggerWatch("hi!", eventType21, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList44);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertNotNull(aCLArray27);
        org.junit.Assert.assertArrayEquals(aCLArray27, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNotNull(watchesReport34);
        org.junit.Assert.assertNotNull(aCLArray43);
        org.junit.Assert.assertArrayEquals(aCLArray43, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
        org.junit.Assert.assertNull(watcherOrBitSet47);
        org.junit.Assert.assertNull(watcherOrBitSet49);
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test142");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport6 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher8);
        java.lang.String str10 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesPathReport6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "0 connections watching 0 paths\n" + "'", str10, "0 connections watching 0 paths\n");
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test143");
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
        org.apache.zookeeper.Watcher watcher18 = null;
        watchManager0.removeWatcher(watcher18);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesPathReport14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test144");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.removeWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher16);
        java.lang.String str18 = watchManager0.toString();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "0 connections watching 0 paths\n" + "'", str18, "0 connections watching 0 paths\n");
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test145");
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
        boolean boolean13 = watchManager0.removeWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher12);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "0 connections watching 0 paths\n" + "'", str10, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test146");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        java.lang.String str8 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher10, watcherMode11);
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager0.triggerWatch("hi!", eventType14, (long) 'a', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "0 connections watching 0 paths\n" + "'", str8, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test147");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher6);
        int int8 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("", watcher10);
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager0.triggerWatch("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", eventType13, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26, watcherOrBitSet31);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 84");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 1 + "'", int8 == 1);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNotNull(aCLArray25);
        org.junit.Assert.assertArrayEquals(aCLArray25, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNull(watcherOrBitSet29);
        org.junit.Assert.assertNull(watcherOrBitSet30);
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test148");
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
        java.util.List<org.apache.zookeeper.data.ACL> aCLList22 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet23 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = watchManager0.triggerWatch("hi!", eventType20, (long) 10, aCLList22, watcherOrBitSet23);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "0 connections watching 0 paths\n" + "'", str18, "0 connections watching 0 paths\n");
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test149");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport6 = watchManager0.getWatchesByPath();
        java.lang.String str7 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport8 = watchManager0.getWatches();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesPathReport6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesReport8);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test150");
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
        int int24 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesPathReport14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
        org.junit.Assert.assertTrue("'" + int24 + "' != '" + 0 + "'", int24 == 0);
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test151");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.addWatch("hi!", watcher6);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.containsWatcher("", watcher9);
        java.lang.Class<?> wildcardClass11 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test152");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        org.apache.zookeeper.Watcher.Event.EventType eventType9 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager11 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager11.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager11.containsWatcher("hi!", watcher14);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport16 = watchManager11.getWatches();
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager11.containsWatcher("", watcher18);
        org.apache.zookeeper.Watcher.Event.EventType eventType21 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager23 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager23.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType26 = null;
        org.apache.zookeeper.data.ACL[] aCLArray28 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList29 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean30 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList29, aCLArray28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager23.triggerWatch("", eventType26, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList29, watcherOrBitSet31);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager11.triggerWatch("", eventType21, (long) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList29);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = watchManager0.triggerWatch("1 connections watching 1 paths\n -> [null]\n", eventType9, (long) 2, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList29, watcherOrBitSet34);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 42");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(watchesReport16);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(aCLArray28);
        org.junit.Assert.assertArrayEquals(aCLArray28, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertNull(watcherOrBitSet32);
        org.junit.Assert.assertNull(watcherOrBitSet33);
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test153");
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
        boolean boolean22 = watchManager0.containsWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher20, watcherMode21);
        org.apache.zookeeper.Watcher watcher23 = null;
        watchManager0.removeWatcher(watcher23);
        org.apache.zookeeper.Watcher watcher25 = null;
        watchManager0.removeWatcher(watcher25);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "0 connections watching 0 paths\n" + "'", str18, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test154");
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
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.containsWatcher("hi!", watcher19);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test155");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        java.lang.String str7 = watchManager0.toString();
        org.apache.zookeeper.Watcher.Event.EventType eventType9 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager11 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher13 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode14 = null;
        boolean boolean15 = watchManager11.containsWatcher("hi!", watcher13, watcherMode14);
        java.lang.String str16 = watchManager11.toString();
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        boolean boolean20 = watchManager11.removeWatcher("", watcher18, watcherMode19);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport21 = watchManager11.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType23 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager25 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport26 = watchManager25.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher28 = null;
        boolean boolean29 = watchManager25.containsWatcher("hi!", watcher28);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport30 = watchManager25.getWatches();
        org.apache.zookeeper.Watcher watcher32 = null;
        boolean boolean33 = watchManager25.containsWatcher("", watcher32);
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager37 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager37.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType40 = null;
        org.apache.zookeeper.data.ACL[] aCLArray42 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList43 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean44 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList43, aCLArray42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = watchManager37.triggerWatch("", eventType40, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43, watcherOrBitSet45);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet47 = watchManager25.triggerWatch("", eventType35, (long) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet48 = watchManager11.triggerWatch("", eventType23, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet49 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet50 = watchManager0.triggerWatch("hi!", eventType9, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43, watcherOrBitSet49);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "0 connections watching 0 paths\n" + "'", str16, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(watchesReport21);
        org.junit.Assert.assertNotNull(watchesPathReport26);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNotNull(watchesReport30);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertNotNull(aCLArray42);
        org.junit.Assert.assertArrayEquals(aCLArray42, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertNull(watcherOrBitSet46);
        org.junit.Assert.assertNull(watcherOrBitSet47);
        org.junit.Assert.assertNull(watcherOrBitSet48);
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test156");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher6);
        int int8 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("", watcher10);
        java.io.PrintWriter printWriter12 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter12, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.println(String)\" because \"writer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 1 + "'", int8 == 1);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test157");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher11, watcherMode12);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test158");
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
        org.apache.zookeeper.Watcher watcher12 = null;
        watchManager0.removeWatcher(watcher12);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertNotNull(watchesReport11);
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test159");
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
        boolean boolean15 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher13, watcherMode14);
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        boolean boolean19 = watchManager0.removeWatcher("hi!", watcher17, watcherMode18);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary20 = watchManager0.getWatchesSummary();
        java.lang.Class<?> wildcardClass21 = watchesSummary20.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(watchesSummary20);
        org.junit.Assert.assertNotNull(wildcardClass21);
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test160");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.containsWatcher("", watcher6);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test161");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        int int9 = watchManager0.size();
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 1 + "'", int9 == 1);
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test162");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.addWatch("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher13);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test163");
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
        java.io.PrintWriter printWriter18 = null;
        watchManager0.dumpWatches(printWriter18, false);
        java.lang.Class<?> wildcardClass21 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
        org.junit.Assert.assertNotNull(wildcardClass21);
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test164");
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
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary13 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 1 + "'", int8 == 1);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesSummary13);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test165");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        boolean boolean10 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher8, watcherMode9);
        org.apache.zookeeper.Watcher watcher12 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode13 = null;
        boolean boolean14 = watchManager0.removeWatcher("", watcher12, watcherMode13);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test166");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher7);
        java.io.PrintWriter printWriter9 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter9, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.println(String)\" because \"writer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test167");
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
        boolean boolean13 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher15, watcherMode16);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport18 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "0 connections watching 0 paths\n" + "'", str10, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test168");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("hi!", watcher4);
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher10);
        int int12 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 1 + "'", int12 == 1);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test169");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager9.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager14 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager14.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType17 = null;
        org.apache.zookeeper.data.ACL[] aCLArray19 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList20 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean21 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList20, aCLArray19);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet23 = watchManager14.triggerWatch("", eventType17, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20, watcherOrBitSet22);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = watchManager9.triggerWatch("", eventType12, (long) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager0.triggerWatch("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", eventType7, (long) (short) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20, watcherOrBitSet25);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 84");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(aCLArray19);
        org.junit.Assert.assertArrayEquals(aCLArray19, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNull(watcherOrBitSet23);
        org.junit.Assert.assertNull(watcherOrBitSet24);
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test170");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        watchManager0.shutdown();
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test171");
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
        boolean boolean14 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher13);
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        boolean boolean22 = watchManager18.containsWatcher("hi!", watcher20, watcherMode21);
        java.io.PrintWriter printWriter23 = null;
        watchManager18.dumpWatches(printWriter23, false);
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager29 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager29.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType32 = null;
        org.apache.zookeeper.data.ACL[] aCLArray34 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList35 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean36 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList35, aCLArray34);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet37 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet38 = watchManager29.triggerWatch("", eventType32, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList35, watcherOrBitSet37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = watchManager18.triggerWatch("", eventType27, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList35);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager0.triggerWatch("1 connections watching 1 paths\n -> [null]\n", eventType16, (long) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList35, watcherOrBitSet40);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 42");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(aCLArray34);
        org.junit.Assert.assertArrayEquals(aCLArray34, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertNull(watcherOrBitSet38);
        org.junit.Assert.assertNull(watcherOrBitSet39);
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test172");
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
        boolean boolean22 = watchManager0.containsWatcher("hi!", watcher20, watcherMode21);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "0 connections watching 0 paths\n" + "'", str18, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test173");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher3);
        org.apache.zookeeper.Watcher watcher5 = null;
        watchManager0.removeWatcher(watcher5);
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean10 = watchManager0.addWatch("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher8, watcherMode9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test174");
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
        java.io.PrintWriter printWriter20 = null;
        watchManager15.dumpWatches(printWriter20, false);
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager26 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager26.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType29 = null;
        org.apache.zookeeper.data.ACL[] aCLArray31 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList32 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean33 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList32, aCLArray31);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = watchManager26.triggerWatch("", eventType29, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList32, watcherOrBitSet34);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = watchManager15.triggerWatch("", eventType24, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList32);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet37 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet38 = watchManager0.triggerWatch("hi!", eventType13, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList32, watcherOrBitSet37);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(aCLArray31);
        org.junit.Assert.assertArrayEquals(aCLArray31, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertNull(watcherOrBitSet35);
        org.junit.Assert.assertNull(watcherOrBitSet36);
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test175");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher6);
        java.lang.Class<?> wildcardClass8 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test176");
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
        boolean boolean15 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher13, watcherMode14);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary16 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher18);
        org.apache.zookeeper.Watcher watcher21 = null;
        boolean boolean22 = watchManager0.removeWatcher("", watcher21);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(watchesSummary16);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test177");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher7, watcherMode8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNotNull(watchesSummary5);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test178");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher12);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test179");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport2 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        org.apache.zookeeper.Watcher.Event.EventType eventType6 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager8 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager8.containsWatcher("hi!", watcher10, watcherMode11);
        java.lang.String str13 = watchManager8.toString();
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager8.removeWatcher("", watcher15, watcherMode16);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport18 = watchManager8.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager22 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport23 = watchManager22.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher25 = null;
        boolean boolean26 = watchManager22.containsWatcher("hi!", watcher25);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport27 = watchManager22.getWatches();
        org.apache.zookeeper.Watcher watcher29 = null;
        boolean boolean30 = watchManager22.containsWatcher("", watcher29);
        org.apache.zookeeper.Watcher.Event.EventType eventType32 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager34 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager34.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType37 = null;
        org.apache.zookeeper.data.ACL[] aCLArray39 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList40 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean41 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList40, aCLArray39);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager34.triggerWatch("", eventType37, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList40, watcherOrBitSet42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager22.triggerWatch("", eventType32, (long) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = watchManager8.triggerWatch("", eventType20, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList40);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = watchManager0.triggerWatch("0 connections watching 0 paths\n", eventType6, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList40);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 31");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport2);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "0 connections watching 0 paths\n" + "'", str13, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNotNull(watchesReport18);
        org.junit.Assert.assertNotNull(watchesPathReport23);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertNotNull(watchesReport27);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertNotNull(aCLArray39);
        org.junit.Assert.assertArrayEquals(aCLArray39, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertNull(watcherOrBitSet43);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertNull(watcherOrBitSet45);
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test180");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        int int5 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.containsWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager16 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        boolean boolean20 = watchManager16.containsWatcher("hi!", watcher18, watcherMode19);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport21 = watchManager16.getWatches();
        watchManager16.shutdown();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport23 = watchManager16.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager27 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager27.shutdown();
        org.apache.zookeeper.Watcher watcher30 = null;
        boolean boolean31 = watchManager27.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher30);
        org.apache.zookeeper.Watcher.Event.EventType eventType33 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager35 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType37 = null;
        org.apache.zookeeper.data.ACL[] aCLArray39 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList40 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean41 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList40, aCLArray39);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager35.triggerWatch("", eventType37, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList40, watcherOrBitSet42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager27.triggerWatch("", eventType33, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = watchManager16.triggerWatch("", eventType25, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet47 = watchManager0.triggerWatch("0 connections watching 0 paths\n", eventType14, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList40, watcherOrBitSet46);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 31");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(watchesReport21);
        org.junit.Assert.assertNotNull(watchesReport23);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + true + "'", boolean31 == true);
        org.junit.Assert.assertNotNull(aCLArray39);
        org.junit.Assert.assertArrayEquals(aCLArray39, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertNull(watcherOrBitSet43);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertNull(watcherOrBitSet45);
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test181");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        boolean boolean6 = watchManager0.containsWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher4, watcherMode5);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test182");
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager0.triggerWatch("1 connections watching 1 paths\n -> [null]\n", eventType15, (long) (byte) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 42");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesSummary8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(aCLArray21);
        org.junit.Assert.assertArrayEquals(aCLArray21, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNull(watcherOrBitSet25);
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test183");
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
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager16 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager16.shutdown();
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager16.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher19);
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType26 = null;
        org.apache.zookeeper.data.ACL[] aCLArray28 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList29 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean30 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList29, aCLArray28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager24.triggerWatch("", eventType26, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList29, watcherOrBitSet31);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager16.triggerWatch("", eventType22, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList29);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager0.triggerWatch("1 connections watching 1 paths\n -> [null]\n", eventType14, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList29);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 42");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(watchesReport11);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "0 connections watching 0 paths\n" + "'", str12, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
        org.junit.Assert.assertNotNull(aCLArray28);
        org.junit.Assert.assertArrayEquals(aCLArray28, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertNull(watcherOrBitSet32);
        org.junit.Assert.assertNull(watcherOrBitSet33);
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test184");
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
        boolean boolean12 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher11);
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager16 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager16.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType19 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager21 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager21.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.data.ACL[] aCLArray26 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList27 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean28 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList27, aCLArray26);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = watchManager21.triggerWatch("", eventType24, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList27, watcherOrBitSet29);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager16.triggerWatch("", eventType19, (long) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList27);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager0.triggerWatch("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", eventType14, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList27);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 84");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(aCLArray26);
        org.junit.Assert.assertArrayEquals(aCLArray26, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertNull(watcherOrBitSet30);
        org.junit.Assert.assertNull(watcherOrBitSet31);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test185");
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
        boolean boolean14 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher13);
        java.lang.String str15 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "0 connections watching 0 paths\n" + "'", str15, "0 connections watching 0 paths\n");
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test186");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport10 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher12 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode13 = null;
        boolean boolean14 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher12, watcherMode13);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test187");
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
        java.io.PrintWriter printWriter14 = null;
        watchManager0.dumpWatches(printWriter14, false);
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.containsWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher18);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(watchesReport13);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test188");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test189");
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
        boolean boolean13 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher11, watcherMode12);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary14 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher16);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test190");
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
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test191");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport6 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher8);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesPathReport6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test192");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        int int5 = watchManager0.size();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager9.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager14 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager14.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType17 = null;
        org.apache.zookeeper.data.ACL[] aCLArray19 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList20 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean21 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList20, aCLArray19);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet23 = watchManager14.triggerWatch("", eventType17, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20, watcherOrBitSet22);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = watchManager9.triggerWatch("", eventType12, (long) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager0.triggerWatch("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", eventType7, (long) 'a', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20, watcherOrBitSet25);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 84");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str4, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(aCLArray19);
        org.junit.Assert.assertArrayEquals(aCLArray19, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNull(watcherOrBitSet23);
        org.junit.Assert.assertNull(watcherOrBitSet24);
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test193");
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
        boolean boolean15 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher13, watcherMode14);
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher17);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test194");
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
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary14 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test195");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport6 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean10 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher8, watcherMode9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesPathReport6);
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test196");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("", watcher7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager12.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.data.ACL[] aCLArray17 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList18 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean19 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList18, aCLArray17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet21 = watchManager12.triggerWatch("", eventType15, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList18, watcherOrBitSet20);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = watchManager0.triggerWatch("", eventType10, (long) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList18);
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager26 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType28 = null;
        org.apache.zookeeper.data.ACL[] aCLArray30 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList31 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean32 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList31, aCLArray30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager26.triggerWatch("", eventType28, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList31, watcherOrBitSet33);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = watchManager0.triggerWatch("hi!", eventType24, (long) (byte) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList31, watcherOrBitSet35);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(aCLArray17);
        org.junit.Assert.assertArrayEquals(aCLArray17, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNull(watcherOrBitSet21);
        org.junit.Assert.assertNull(watcherOrBitSet22);
        org.junit.Assert.assertNotNull(aCLArray30);
        org.junit.Assert.assertArrayEquals(aCLArray30, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNull(watcherOrBitSet34);
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test197");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport9 = watchManager0.getWatches();
        watchManager0.shutdown();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertNotNull(watchesReport9);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test198");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher10);
        int int12 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.addWatch("hi!", watcher14);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary16 = watchManager0.getWatchesSummary();
        java.io.PrintWriter printWriter17 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter17, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.println(String)\" because \"writer\" is null");
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
        org.junit.Assert.assertNotNull(watchesSummary16);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test199");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher11);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test200");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        java.lang.String str11 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "0 connections watching 0 paths\n" + "'", str11, "0 connections watching 0 paths\n");
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test201");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        boolean boolean10 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher8, watcherMode9);
        org.apache.zookeeper.Watcher watcher12 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode13 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean14 = watchManager0.addWatch("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher12, watcherMode13);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\n" + "'", str6, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test202");
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
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary14 = watchManager0.getWatchesSummary();
        java.lang.Class<?> wildcardClass15 = watchesSummary14.getClass();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(watchesSummary11);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "0 connections watching 0 paths\n" + "'", str13, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesSummary14);
        org.junit.Assert.assertNotNull(wildcardClass15);
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test203");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher7);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test204");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher6);
        org.apache.zookeeper.Watcher.Event.EventType eventType9 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager11 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher13 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode14 = null;
        boolean boolean15 = watchManager11.containsWatcher("hi!", watcher13, watcherMode14);
        java.lang.String str16 = watchManager11.toString();
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        boolean boolean20 = watchManager11.removeWatcher("", watcher18, watcherMode19);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport21 = watchManager11.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType23 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager25 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport26 = watchManager25.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher28 = null;
        boolean boolean29 = watchManager25.containsWatcher("hi!", watcher28);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport30 = watchManager25.getWatches();
        org.apache.zookeeper.Watcher watcher32 = null;
        boolean boolean33 = watchManager25.containsWatcher("", watcher32);
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager37 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager37.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType40 = null;
        org.apache.zookeeper.data.ACL[] aCLArray42 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList43 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean44 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList43, aCLArray42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = watchManager37.triggerWatch("", eventType40, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43, watcherOrBitSet45);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet47 = watchManager25.triggerWatch("", eventType35, (long) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet48 = watchManager11.triggerWatch("", eventType23, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet49 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet50 = watchManager0.triggerWatch("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", eventType9, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43, watcherOrBitSet49);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 95");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "0 connections watching 0 paths\n" + "'", str16, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(watchesReport21);
        org.junit.Assert.assertNotNull(watchesPathReport26);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNotNull(watchesReport30);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertNotNull(aCLArray42);
        org.junit.Assert.assertArrayEquals(aCLArray42, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertNull(watcherOrBitSet46);
        org.junit.Assert.assertNull(watcherOrBitSet47);
        org.junit.Assert.assertNull(watcherOrBitSet48);
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test205");
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
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport14 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        boolean boolean22 = watchManager18.containsWatcher("hi!", watcher20, watcherMode21);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport23 = watchManager18.getWatches();
        watchManager18.shutdown();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport25 = watchManager18.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager29 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager29.shutdown();
        org.apache.zookeeper.Watcher watcher32 = null;
        boolean boolean33 = watchManager29.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher32);
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager37 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType39 = null;
        org.apache.zookeeper.data.ACL[] aCLArray41 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList42 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean43 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList42, aCLArray41);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = watchManager37.triggerWatch("", eventType39, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList42, watcherOrBitSet44);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = watchManager29.triggerWatch("", eventType35, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet47 = watchManager18.triggerWatch("", eventType27, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet48 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet49 = watchManager0.triggerWatch("", eventType16, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList42, watcherOrBitSet48);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(watchesSummary11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "0 connections watching 0 paths\n" + "'", str13, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesPathReport14);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(watchesReport23);
        org.junit.Assert.assertNotNull(watchesReport25);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + true + "'", boolean33 == true);
        org.junit.Assert.assertNotNull(aCLArray41);
        org.junit.Assert.assertArrayEquals(aCLArray41, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
        org.junit.Assert.assertNull(watcherOrBitSet45);
        org.junit.Assert.assertNull(watcherOrBitSet46);
        org.junit.Assert.assertNull(watcherOrBitSet47);
        org.junit.Assert.assertNull(watcherOrBitSet49);
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test206");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager0.getWatchesSummary();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        boolean boolean16 = watchManager0.removeWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher14, watcherMode15);
        java.lang.Class<?> wildcardClass17 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str6, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(wildcardClass17);
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test207");
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
        boolean boolean22 = watchManager0.containsWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher20, watcherMode21);
        org.apache.zookeeper.Watcher watcher23 = null;
        watchManager0.removeWatcher(watcher23);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport25 = watchManager0.getWatchesByPath();
        int int26 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "0 connections watching 0 paths\n" + "'", str18, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(watchesPathReport25);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 0 + "'", int26 == 0);
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test208");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("hi!", watcher10);
        org.apache.zookeeper.Watcher.Event.EventType eventType13 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager15 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        boolean boolean19 = watchManager15.containsWatcher("hi!", watcher17, watcherMode18);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport20 = watchManager15.getWatches();
        watchManager15.shutdown();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport22 = watchManager15.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager26 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager26.shutdown();
        org.apache.zookeeper.Watcher watcher29 = null;
        boolean boolean30 = watchManager26.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher29);
        org.apache.zookeeper.Watcher.Event.EventType eventType32 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager34 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType36 = null;
        org.apache.zookeeper.data.ACL[] aCLArray38 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList39 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean40 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList39, aCLArray38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager34.triggerWatch("", eventType36, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39, watcherOrBitSet41);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager26.triggerWatch("", eventType32, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager15.triggerWatch("", eventType24, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = watchManager0.triggerWatch("1 connections watching 1 paths\n -> [null]\n", eventType13, (long) (byte) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 42");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str4, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(watchesReport20);
        org.junit.Assert.assertNotNull(watchesReport22);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + true + "'", boolean30 == true);
        org.junit.Assert.assertNotNull(aCLArray38);
        org.junit.Assert.assertArrayEquals(aCLArray38, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertNull(watcherOrBitSet42);
        org.junit.Assert.assertNull(watcherOrBitSet43);
        org.junit.Assert.assertNull(watcherOrBitSet44);
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test209");
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
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport22 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher23 = null;
        watchManager0.removeWatcher(watcher23);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesPathReport14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
        org.junit.Assert.assertNotNull(watchesPathReport22);
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test210");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("", watcher10);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test211");
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
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary15 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        boolean boolean19 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher17, watcherMode18);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(watchesReport11);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertNotNull(watchesSummary15);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test212");
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
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        boolean boolean20 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher18, watcherMode19);
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        java.util.List<org.apache.zookeeper.data.ACL> aCLList24 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = watchManager0.triggerWatch("hi!", eventType22, (long) (short) 0, aCLList24);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesSummary8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test213");
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
        boolean boolean15 = watchManager11.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher14);
        org.apache.zookeeper.Watcher.Event.EventType eventType17 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager19 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType21 = null;
        org.apache.zookeeper.data.ACL[] aCLArray23 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList24 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean25 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList24, aCLArray23);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = watchManager19.triggerWatch("", eventType21, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList24, watcherOrBitSet26);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = watchManager11.triggerWatch("", eventType17, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList24);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager0.triggerWatch("", eventType9, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList24);
        org.apache.zookeeper.Watcher watcher30 = null;
        watchManager0.removeWatcher(watcher30);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertNotNull(aCLArray23);
        org.junit.Assert.assertArrayEquals(aCLArray23, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNull(watcherOrBitSet27);
        org.junit.Assert.assertNull(watcherOrBitSet28);
        org.junit.Assert.assertNull(watcherOrBitSet29);
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test214");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("hi!", watcher7);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport9 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because the return value of \"java.util.Map$Entry.getKey()\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test215");
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
        int int14 = watchManager0.size();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(watchesSummary11);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "0 connections watching 0 paths\n" + "'", str13, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test216");
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
        boolean boolean15 = watchManager0.containsWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher14);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test217");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher11);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test218");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        java.lang.String str8 = watchManager0.toString();
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport10 = watchManager0.getWatches();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "0 connections watching 0 paths\n" + "'", str8, "0 connections watching 0 paths\n");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesReport10);
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test219");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher6);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test220");
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
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "0 connections watching 0 paths\n" + "'", str8, "0 connections watching 0 paths\n");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test221");
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
        boolean boolean13 = watchManager0.containsWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher14 = null;
        watchManager0.removeWatcher(watcher14);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "0 connections watching 0 paths\n" + "'", str8, "0 connections watching 0 paths\n");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test222");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher6);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.removeWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher9);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test223");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("hi!", watcher4);
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher9);
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = watchManager0.triggerWatch("", eventType12, (long) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet17);
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test224");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary8 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("", watcher10, watcherMode11);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(watchesSummary8);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test225");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode6 = null;
        boolean boolean7 = watchManager0.containsWatcher("", watcher5, watcherMode6);
        watchManager0.shutdown();
        java.lang.String str9 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str9, "1 connections watching 1 paths\n -> [null]\n");
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test226");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport8 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport9 = watchManager0.getWatches();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesPathReport8);
        org.junit.Assert.assertNotNull(watchesReport9);
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test227");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher10, watcherMode11);
        watchManager0.shutdown();
        java.io.PrintWriter printWriter14 = null;
        watchManager0.dumpWatches(printWriter14, false);
        java.lang.String str17 = watchManager0.toString();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "0 connections watching 0 paths\n" + "'", str17, "0 connections watching 0 paths\n");
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test228");
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
        boolean boolean15 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher13, watcherMode14);
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        boolean boolean19 = watchManager0.removeWatcher("hi!", watcher17, watcherMode18);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary20 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher22 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode23 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean24 = watchManager0.addWatch("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher22, watcherMode23);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(watchesSummary20);
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test229");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher7);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test230");
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
        watchManager0.shutdown();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.removeWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher16);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(watchesSummary11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test231");
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
        java.lang.String str12 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "0 connections watching 0 paths\n" + "'", str12, "0 connections watching 0 paths\n");
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test232");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.containsWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher6);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test233");
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
        boolean boolean15 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher13, watcherMode14);
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        boolean boolean19 = watchManager0.removeWatcher("hi!", watcher17, watcherMode18);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary20 = watchManager0.getWatchesSummary();
        java.io.PrintWriter printWriter21 = null;
        watchManager0.dumpWatches(printWriter21, false);
        org.apache.zookeeper.Watcher watcher25 = null;
        boolean boolean26 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher25);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(watchesSummary20);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + true + "'", boolean26 == true);
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test234");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        int int5 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean13 = watchManager0.addWatch("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher11, watcherMode12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test235");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("hi!", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager12.triggerWatch("", eventType14, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet19);
        org.apache.zookeeper.Watcher watcher21 = null;
        watchManager12.removeWatcher(watcher21);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport23 = watchManager12.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager27 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager27.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType30 = null;
        org.apache.zookeeper.data.ACL[] aCLArray32 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList33 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean34 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList33, aCLArray32);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = watchManager27.triggerWatch("", eventType30, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList33, watcherOrBitSet35);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet37 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet38 = watchManager12.triggerWatch("", eventType25, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList33, watcherOrBitSet37);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = watchManager0.triggerWatch("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", eventType10, (long) (byte) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList33);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 95");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNotNull(watchesReport23);
        org.junit.Assert.assertNotNull(aCLArray32);
        org.junit.Assert.assertArrayEquals(aCLArray32, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertNull(watcherOrBitSet36);
        org.junit.Assert.assertNull(watcherOrBitSet38);
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test236");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher13);
        java.io.PrintWriter printWriter15 = null;
        watchManager0.dumpWatches(printWriter15, true);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test237");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher8 = null;
        watchManager0.removeWatcher(watcher8);
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager13 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager13.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.data.ACL[] aCLArray18 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList19 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean20 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList19, aCLArray18);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet21 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = watchManager13.triggerWatch("", eventType16, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList19, watcherOrBitSet21);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet23 = watchManager0.triggerWatch("1 connections watching 1 paths\n -> [null]\n", eventType11, (long) 'a', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList19);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 42");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(aCLArray18);
        org.junit.Assert.assertArrayEquals(aCLArray18, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNull(watcherOrBitSet22);
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test238");
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
        boolean boolean15 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher13, watcherMode14);
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        boolean boolean19 = watchManager0.removeWatcher("hi!", watcher17, watcherMode18);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary20 = watchManager0.getWatchesSummary();
        java.io.PrintWriter printWriter21 = null;
        watchManager0.dumpWatches(printWriter21, false);
        org.apache.zookeeper.Watcher watcher24 = null;
        watchManager0.removeWatcher(watcher24);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport26 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher.Event.EventType eventType28 = null;
        org.apache.zookeeper.data.ACL[] aCLArray30 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList31 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean32 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList31, aCLArray30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager0.triggerWatch("hi!", eventType28, (long) (short) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList31, watcherOrBitSet33);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(watchesSummary20);
        org.junit.Assert.assertNotNull(watchesPathReport26);
        org.junit.Assert.assertNotNull(aCLArray30);
        org.junit.Assert.assertArrayEquals(aCLArray30, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test239");
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
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary13 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(watchesSummary11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(watchesSummary13);
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test240");
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
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        boolean boolean16 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher14, watcherMode15);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test241");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher8);
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager13 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager13.containsWatcher("hi!", watcher15, watcherMode16);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport18 = watchManager13.getWatches();
        watchManager13.shutdown();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport20 = watchManager13.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager24.shutdown();
        org.apache.zookeeper.Watcher watcher27 = null;
        boolean boolean28 = watchManager24.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher27);
        org.apache.zookeeper.Watcher.Event.EventType eventType30 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager32 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType34 = null;
        org.apache.zookeeper.data.ACL[] aCLArray36 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList37 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean38 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList37, aCLArray36);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = watchManager32.triggerWatch("", eventType34, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37, watcherOrBitSet39);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager24.triggerWatch("", eventType30, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager13.triggerWatch("", eventType22, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager0.triggerWatch("1 connections watching 1 paths\n -> [null]\n", eventType11, (long) (short) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37, watcherOrBitSet43);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 42");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNotNull(watchesReport18);
        org.junit.Assert.assertNotNull(watchesReport20);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + true + "'", boolean28 == true);
        org.junit.Assert.assertNotNull(aCLArray36);
        org.junit.Assert.assertArrayEquals(aCLArray36, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertNull(watcherOrBitSet40);
        org.junit.Assert.assertNull(watcherOrBitSet41);
        org.junit.Assert.assertNull(watcherOrBitSet42);
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test242");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.containsWatcher("hi!", watcher4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test243");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.removeWatcher("", watcher9);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport11 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(watchesPathReport11);
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test244");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher10);
        int int12 = watchManager0.size();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager16 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType18 = null;
        org.apache.zookeeper.data.ACL[] aCLArray20 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList21 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean22 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList21, aCLArray20);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet23 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = watchManager16.triggerWatch("", eventType18, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList21, watcherOrBitSet23);
        org.apache.zookeeper.Watcher watcher25 = null;
        watchManager16.removeWatcher(watcher25);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport27 = watchManager16.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType29 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager31 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager31.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType34 = null;
        org.apache.zookeeper.data.ACL[] aCLArray36 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList37 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean38 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList37, aCLArray36);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = watchManager31.triggerWatch("", eventType34, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37, watcherOrBitSet39);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager16.triggerWatch("", eventType29, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37, watcherOrBitSet41);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager0.triggerWatch("", eventType14, (long) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37, watcherOrBitSet43);
        java.lang.Class<?> wildcardClass45 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(aCLArray20);
        org.junit.Assert.assertArrayEquals(aCLArray20, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNull(watcherOrBitSet24);
        org.junit.Assert.assertNotNull(watchesReport27);
        org.junit.Assert.assertNotNull(aCLArray36);
        org.junit.Assert.assertArrayEquals(aCLArray36, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertNull(watcherOrBitSet40);
        org.junit.Assert.assertNull(watcherOrBitSet42);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertNotNull(wildcardClass45);
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test245");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary8 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("", watcher10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher13);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(watchesSummary8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test246");
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
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean16 = watchManager0.addWatch("hi!", watcher14, watcherMode15);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test247");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        boolean boolean18 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher16, watcherMode17);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test248");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        boolean boolean16 = watchManager12.containsWatcher("hi!", watcher14, watcherMode15);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport17 = watchManager12.getWatches();
        watchManager12.shutdown();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport19 = watchManager12.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType21 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager23 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager23.shutdown();
        org.apache.zookeeper.Watcher watcher26 = null;
        boolean boolean27 = watchManager23.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher26);
        org.apache.zookeeper.Watcher.Event.EventType eventType29 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager31 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType33 = null;
        org.apache.zookeeper.data.ACL[] aCLArray35 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList36 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean37 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList36, aCLArray35);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet38 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = watchManager31.triggerWatch("", eventType33, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList36, watcherOrBitSet38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = watchManager23.triggerWatch("", eventType29, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList36);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager12.triggerWatch("", eventType21, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList36);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager0.triggerWatch("1 connections watching 1 paths\n -> [null]\n", eventType10, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList36, watcherOrBitSet42);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 42");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(watchesReport17);
        org.junit.Assert.assertNotNull(watchesReport19);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + true + "'", boolean27 == true);
        org.junit.Assert.assertNotNull(aCLArray35);
        org.junit.Assert.assertArrayEquals(aCLArray35, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertNull(watcherOrBitSet39);
        org.junit.Assert.assertNull(watcherOrBitSet40);
        org.junit.Assert.assertNull(watcherOrBitSet41);
    }

    @Test
    public void test249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test249");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        java.lang.String str7 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport8 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        java.io.PrintWriter printWriter10 = null;
        watchManager0.dumpWatches(printWriter10, true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesReport8);
        org.junit.Assert.assertNotNull(watchesSummary9);
    }

    @Test
    public void test250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test250");
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
        watchManager0.shutdown();
        java.io.PrintWriter printWriter16 = null;
        watchManager0.dumpWatches(printWriter16, false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
    }

    @Test
    public void test251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test251");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher6);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test252");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher3);
        org.apache.zookeeper.Watcher watcher5 = null;
        watchManager0.removeWatcher(watcher5);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary7 = watchManager0.getWatchesSummary();
        java.lang.Class<?> wildcardClass8 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(watchesSummary7);
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test253");
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
        java.io.PrintWriter printWriter18 = null;
        watchManager0.dumpWatches(printWriter18, false);
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
    }

    @Test
    public void test254() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test254");
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
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary14 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.removeWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher16);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(watchesSummary11);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "0 connections watching 0 paths\n" + "'", str13, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesSummary14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test255() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test255");
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
        boolean boolean13 = watchManager0.containsWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher11, watcherMode12);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport14 = watchManager0.getWatches();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "0 connections watching 0 paths\n" + "'", str8, "0 connections watching 0 paths\n");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesReport14);
    }

    @Test
    public void test256() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test256");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher10, watcherMode11);
        org.apache.zookeeper.Watcher watcher13 = null;
        watchManager0.removeWatcher(watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.containsWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher16);
        org.apache.zookeeper.Watcher watcher18 = null;
        watchManager0.removeWatcher(watcher18);
        org.apache.zookeeper.Watcher watcher21 = null;
        boolean boolean22 = watchManager0.containsWatcher("", watcher21);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test257() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test257");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.removeWatcher("", watcher6);
        java.lang.String str8 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "0 connections watching 0 paths\n" + "'", str8, "0 connections watching 0 paths\n");
    }

    @Test
    public void test258() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test258");
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
        boolean boolean16 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher15);
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.removeWatcher("hi!", watcher18);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesSummary8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test259() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test259");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher7);
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test260() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test260");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        org.apache.zookeeper.Watcher watcher11 = null;
        watchManager0.removeWatcher(watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        boolean boolean16 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher14, watcherMode15);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test261() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test261");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        java.io.PrintWriter printWriter8 = null;
        watchManager0.dumpWatches(printWriter8, false);
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
    }

    @Test
    public void test262() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test262");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary8 = watchManager0.getWatchesSummary();
        java.io.PrintWriter printWriter9 = null;
        watchManager0.dumpWatches(printWriter9, false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(watchesSummary8);
    }

    @Test
    public void test263() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test263");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport6 = watchManager0.getWatchesByPath();
        int int7 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.removeWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher9);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesPathReport6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test264() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test264");
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
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.containsWatcher("hi!", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher19 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode20 = null;
        boolean boolean21 = watchManager0.removeWatcher("", watcher19, watcherMode20);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
    }

    @Test
    public void test265() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test265");
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
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean13 = watchManager0.addWatch("", watcher11, watcherMode12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
    }

    @Test
    public void test266() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test266");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.removeWatcher("", watcher6);
        java.lang.String str8 = watchManager0.toString();
        java.lang.String str9 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "0 connections watching 0 paths\n" + "'", str8, "0 connections watching 0 paths\n");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
    }

    @Test
    public void test267() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test267");
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
        boolean boolean15 = watchManager0.containsWatcher("", watcher13, watcherMode14);
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean19 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher17, watcherMode18);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test268() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test268");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher6, watcherMode7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.addWatch("", watcher12);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str4, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesSummary9);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test269() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test269");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport6 = watchManager0.getWatchesByPath();
        java.lang.Class<?> wildcardClass7 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesPathReport6);
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test270() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test270");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher.Event.EventType eventType9 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager11 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager11.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager11.triggerWatch("", eventType14, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet19);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet21 = watchManager0.triggerWatch("", eventType9, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17);
        java.io.PrintWriter printWriter22 = null;
        watchManager0.dumpWatches(printWriter22, false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNull(watcherOrBitSet21);
    }

    @Test
    public void test271() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test271");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode6 = null;
        boolean boolean7 = watchManager0.containsWatcher("", watcher5, watcherMode6);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.removeWatcher("hi!", watcher9);
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher12);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
    }

    @Test
    public void test272() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test272");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher3);
        org.apache.zookeeper.Watcher.Event.EventType eventType6 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager8 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.data.ACL[] aCLArray12 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList13 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean14 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList13, aCLArray12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet15 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet16 = watchManager8.triggerWatch("", eventType10, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList13, watcherOrBitSet15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = watchManager0.triggerWatch("", eventType6, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList13);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary18 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(aCLArray12);
        org.junit.Assert.assertArrayEquals(aCLArray12, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNull(watcherOrBitSet16);
        org.junit.Assert.assertNull(watcherOrBitSet17);
        org.junit.Assert.assertNotNull(watchesSummary18);
    }

    @Test
    public void test273() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test273");
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
        boolean boolean16 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher15);
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean20 = watchManager0.addWatch("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher18, watcherMode19);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesSummary8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
    }

    @Test
    public void test274() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test274");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher6, watcherMode7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher12 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode13 = null;
        boolean boolean14 = watchManager0.removeWatcher("", watcher12, watcherMode13);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str4, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesSummary9);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
    }

    @Test
    public void test275() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test275");
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
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary19 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType21 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager23 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher25 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode26 = null;
        boolean boolean27 = watchManager23.containsWatcher("hi!", watcher25, watcherMode26);
        java.lang.String str28 = watchManager23.toString();
        org.apache.zookeeper.Watcher watcher30 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode31 = null;
        boolean boolean32 = watchManager23.containsWatcher("0 connections watching 0 paths\n", watcher30, watcherMode31);
        org.apache.zookeeper.Watcher.Event.EventType eventType34 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager36 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType38 = null;
        org.apache.zookeeper.data.ACL[] aCLArray40 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList41 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean42 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList41, aCLArray40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager36.triggerWatch("", eventType38, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList41, watcherOrBitSet43);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = watchManager23.triggerWatch("", eventType34, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList41, watcherOrBitSet45);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet47 = watchManager0.triggerWatch("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", eventType21, (long) (byte) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList41);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 84");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "0 connections watching 0 paths\n" + "'", str17, "0 connections watching 0 paths\n");
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "0 connections watching 0 paths\n" + "'", str18, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesSummary19);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertEquals("'" + str28 + "' != '" + "0 connections watching 0 paths\n" + "'", str28, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNotNull(aCLArray40);
        org.junit.Assert.assertArrayEquals(aCLArray40, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertNull(watcherOrBitSet46);
    }

    @Test
    public void test276() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test276");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.addWatch("hi!", watcher6);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.containsWatcher("", watcher9);
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher12);
        watchManager0.shutdown();
        java.lang.Class<?> wildcardClass15 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(wildcardClass15);
    }

    @Test
    public void test277() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test277");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher6, watcherMode7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager13 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager13.containsWatcher("hi!", watcher15, watcherMode16);
        java.io.PrintWriter printWriter18 = null;
        watchManager13.dumpWatches(printWriter18, false);
        org.apache.zookeeper.Watcher watcher22 = null;
        boolean boolean23 = watchManager13.addWatch("", watcher22);
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager27 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher29 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode30 = null;
        boolean boolean31 = watchManager27.containsWatcher("hi!", watcher29, watcherMode30);
        java.lang.String str32 = watchManager27.toString();
        org.apache.zookeeper.Watcher watcher34 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode35 = null;
        boolean boolean36 = watchManager27.removeWatcher("", watcher34, watcherMode35);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport37 = watchManager27.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType39 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager41 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport42 = watchManager41.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher44 = null;
        boolean boolean45 = watchManager41.containsWatcher("hi!", watcher44);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport46 = watchManager41.getWatches();
        org.apache.zookeeper.Watcher watcher48 = null;
        boolean boolean49 = watchManager41.containsWatcher("", watcher48);
        org.apache.zookeeper.Watcher.Event.EventType eventType51 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager53 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager53.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType56 = null;
        org.apache.zookeeper.data.ACL[] aCLArray58 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList59 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean60 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList59, aCLArray58);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet61 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet62 = watchManager53.triggerWatch("", eventType56, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList59, watcherOrBitSet61);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet63 = watchManager41.triggerWatch("", eventType51, (long) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList59);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet64 = watchManager27.triggerWatch("", eventType39, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList59);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet65 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet66 = watchManager13.triggerWatch("", eventType25, (long) (byte) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList59, watcherOrBitSet65);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet67 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet68 = watchManager0.triggerWatch("0 connections watching 0 paths\n", eventType11, (long) (short) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList59, watcherOrBitSet67);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 31");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "0 connections watching 0 paths\n" + "'", str32, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertNotNull(watchesReport37);
        org.junit.Assert.assertNotNull(watchesPathReport42);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
        org.junit.Assert.assertNotNull(watchesReport46);
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + false + "'", boolean49 == false);
        org.junit.Assert.assertNotNull(aCLArray58);
        org.junit.Assert.assertArrayEquals(aCLArray58, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean60 + "' != '" + false + "'", boolean60 == false);
        org.junit.Assert.assertNull(watcherOrBitSet62);
        org.junit.Assert.assertNull(watcherOrBitSet63);
        org.junit.Assert.assertNull(watcherOrBitSet64);
        org.junit.Assert.assertNull(watcherOrBitSet66);
    }

    @Test
    public void test278() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test278");
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
        boolean boolean15 = watchManager11.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher14);
        org.apache.zookeeper.Watcher.Event.EventType eventType17 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager19 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType21 = null;
        org.apache.zookeeper.data.ACL[] aCLArray23 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList24 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean25 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList24, aCLArray23);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = watchManager19.triggerWatch("", eventType21, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList24, watcherOrBitSet26);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = watchManager11.triggerWatch("", eventType17, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList24);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager0.triggerWatch("", eventType9, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList24);
        org.apache.zookeeper.Watcher watcher31 = null;
        boolean boolean32 = watchManager0.removeWatcher("", watcher31);
        org.apache.zookeeper.Watcher watcher34 = null;
        boolean boolean35 = watchManager0.removeWatcher("", watcher34);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertNotNull(aCLArray23);
        org.junit.Assert.assertArrayEquals(aCLArray23, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNull(watcherOrBitSet27);
        org.junit.Assert.assertNull(watcherOrBitSet28);
        org.junit.Assert.assertNull(watcherOrBitSet29);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
    }

    @Test
    public void test279() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test279");
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
        boolean boolean13 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher19 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode20 = null;
        boolean boolean21 = watchManager0.containsWatcher("hi!", watcher19, watcherMode20);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "0 connections watching 0 paths\n" + "'", str10, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
    }

    @Test
    public void test280() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test280");
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
        java.io.PrintWriter printWriter13 = null;
        watchManager0.dumpWatches(printWriter13, false);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(watchesSummary11);
        org.junit.Assert.assertNotNull(watchesSummary12);
    }

    @Test
    public void test281() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test281");
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
        int int14 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\n" + "'", str6, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
    }

    @Test
    public void test282() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test282");
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
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport17 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(watchesPathReport17);
    }

    @Test
    public void test283() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test283");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.removeWatcher("", watcher9);
        java.lang.Class<?> wildcardClass11 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test284() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test284");
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
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary14 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.containsWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher16);
        org.apache.zookeeper.Watcher watcher19 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode20 = null;
        boolean boolean21 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher19, watcherMode20);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(watchesSummary11);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "0 connections watching 0 paths\n" + "'", str13, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesSummary14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
    }

    @Test
    public void test285() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test285");
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
        java.lang.String str16 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(watchesReport11);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 1 + "'", int15 == 1);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "1 connections watching 1 paths\nhi! -> [null]\n" + "'", str16, "1 connections watching 1 paths\nhi! -> [null]\n");
    }

    @Test
    public void test286() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test286");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        int int5 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.containsWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.addWatch("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher14);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
    }

    @Test
    public void test287() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test287");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher3);
        org.apache.zookeeper.Watcher watcher5 = null;
        watchManager0.removeWatcher(watcher5);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary7 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean11 = watchManager0.addWatch("hi!", watcher9, watcherMode10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(watchesSummary7);
    }

    @Test
    public void test288() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test288");
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
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.containsWatcher("hi!", watcher15, watcherMode16);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary18 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNotNull(watchesSummary18);
    }

    @Test
    public void test289() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test289");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher10);
        int int12 = watchManager0.size();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager16 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType18 = null;
        org.apache.zookeeper.data.ACL[] aCLArray20 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList21 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean22 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList21, aCLArray20);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet23 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = watchManager16.triggerWatch("", eventType18, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList21, watcherOrBitSet23);
        org.apache.zookeeper.Watcher watcher25 = null;
        watchManager16.removeWatcher(watcher25);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport27 = watchManager16.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType29 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager31 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager31.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType34 = null;
        org.apache.zookeeper.data.ACL[] aCLArray36 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList37 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean38 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList37, aCLArray36);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = watchManager31.triggerWatch("", eventType34, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37, watcherOrBitSet39);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager16.triggerWatch("", eventType29, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37, watcherOrBitSet41);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager0.triggerWatch("", eventType14, (long) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37, watcherOrBitSet43);
        org.apache.zookeeper.Watcher.Event.EventType eventType46 = null;
        org.apache.zookeeper.data.ACL[] aCLArray48 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList49 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean50 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList49, aCLArray48);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet51 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet52 = watchManager0.triggerWatch("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", eventType46, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList49, watcherOrBitSet51);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 95");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(aCLArray20);
        org.junit.Assert.assertArrayEquals(aCLArray20, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNull(watcherOrBitSet24);
        org.junit.Assert.assertNotNull(watchesReport27);
        org.junit.Assert.assertNotNull(aCLArray36);
        org.junit.Assert.assertArrayEquals(aCLArray36, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertNull(watcherOrBitSet40);
        org.junit.Assert.assertNull(watcherOrBitSet42);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertNotNull(aCLArray48);
        org.junit.Assert.assertArrayEquals(aCLArray48, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean50 + "' != '" + false + "'", boolean50 == false);
    }

    @Test
    public void test290() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test290");
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
        int int13 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport14 = watchManager0.getWatchesByPath();
        java.lang.String str15 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.removeWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher17);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertNotNull(watchesPathReport14);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "0 connections watching 0 paths\n" + "'", str15, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test291() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test291");
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
        java.lang.Class<?> wildcardClass14 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(wildcardClass14);
    }

    @Test
    public void test292() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test292");
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
        org.apache.zookeeper.Watcher.Event.EventType eventType23 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager25 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport26 = watchManager25.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher28 = null;
        boolean boolean29 = watchManager25.containsWatcher("hi!", watcher28);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport30 = watchManager25.getWatches();
        org.apache.zookeeper.Watcher watcher32 = null;
        boolean boolean33 = watchManager25.containsWatcher("", watcher32);
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager37 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager37.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType40 = null;
        org.apache.zookeeper.data.ACL[] aCLArray42 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList43 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean44 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList43, aCLArray42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = watchManager37.triggerWatch("", eventType40, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43, watcherOrBitSet45);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet47 = watchManager25.triggerWatch("", eventType35, (long) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet48 = watchManager0.triggerWatch("0 connections watching 0 paths\n", eventType23, (long) 2, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 31");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesPathReport14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(watchesReport21);
        org.junit.Assert.assertNotNull(watchesPathReport26);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNotNull(watchesReport30);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertNotNull(aCLArray42);
        org.junit.Assert.assertArrayEquals(aCLArray42, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertNull(watcherOrBitSet46);
        org.junit.Assert.assertNull(watcherOrBitSet47);
    }

    @Test
    public void test293() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test293");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher10);
        org.apache.zookeeper.Watcher watcher13 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode14 = null;
        boolean boolean15 = watchManager0.removeWatcher("", watcher13, watcherMode14);
        java.lang.String str16 = watchManager0.toString();
        org.apache.zookeeper.Watcher.Event.EventType eventType18 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager20 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport21 = watchManager20.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher23 = null;
        boolean boolean24 = watchManager20.containsWatcher("hi!", watcher23);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport25 = watchManager20.getWatches();
        org.apache.zookeeper.Watcher watcher27 = null;
        boolean boolean28 = watchManager20.containsWatcher("", watcher27);
        org.apache.zookeeper.Watcher watcher30 = null;
        boolean boolean31 = watchManager20.containsWatcher("hi!", watcher30);
        int int32 = watchManager20.size();
        org.apache.zookeeper.Watcher.Event.EventType eventType34 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager36 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType38 = null;
        org.apache.zookeeper.data.ACL[] aCLArray40 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList41 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean42 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList41, aCLArray40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager36.triggerWatch("", eventType38, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList41, watcherOrBitSet43);
        org.apache.zookeeper.Watcher watcher45 = null;
        watchManager36.removeWatcher(watcher45);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport47 = watchManager36.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType49 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager51 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager51.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType54 = null;
        org.apache.zookeeper.data.ACL[] aCLArray56 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList57 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean58 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList57, aCLArray56);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet59 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet60 = watchManager51.triggerWatch("", eventType54, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList57, watcherOrBitSet59);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet61 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet62 = watchManager36.triggerWatch("", eventType49, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList57, watcherOrBitSet61);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet63 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet64 = watchManager20.triggerWatch("", eventType34, (long) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList57, watcherOrBitSet63);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet65 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet66 = watchManager0.triggerWatch("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", eventType18, 100L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList57, watcherOrBitSet65);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 84");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "0 connections watching 0 paths\n" + "'", str16, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesPathReport21);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNotNull(watchesReport25);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + int32 + "' != '" + 0 + "'", int32 == 0);
        org.junit.Assert.assertNotNull(aCLArray40);
        org.junit.Assert.assertArrayEquals(aCLArray40, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertNotNull(watchesReport47);
        org.junit.Assert.assertNotNull(aCLArray56);
        org.junit.Assert.assertArrayEquals(aCLArray56, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean58 + "' != '" + false + "'", boolean58 == false);
        org.junit.Assert.assertNull(watcherOrBitSet60);
        org.junit.Assert.assertNull(watcherOrBitSet62);
        org.junit.Assert.assertNull(watcherOrBitSet64);
    }

    @Test
    public void test294() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test294");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager0.getWatchesSummary();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        boolean boolean16 = watchManager0.removeWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher14, watcherMode15);
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean20 = watchManager0.addWatch("", watcher18, watcherMode19);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str6, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test295() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test295");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        boolean boolean10 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher8, watcherMode9);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport11 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport12 = watchManager0.getWatches();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\n" + "'", str6, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(watchesPathReport11);
        org.junit.Assert.assertNotNull(watchesReport12);
    }

    @Test
    public void test296() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test296");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        int int8 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\n" + "'", str6, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
    }

    @Test
    public void test297() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test297");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher10);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.addWatch("", watcher14);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
    }

    @Test
    public void test298() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test298");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher10, watcherMode11);
        org.apache.zookeeper.Watcher watcher13 = null;
        watchManager0.removeWatcher(watcher13);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport15 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher17);
        org.apache.zookeeper.Watcher watcher20 = null;
        boolean boolean21 = watchManager0.addWatch("", watcher20);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesReport15);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + true + "'", boolean21 == true);
    }

    @Test
    public void test299() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test299");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher3);
        org.apache.zookeeper.Watcher watcher5 = null;
        watchManager0.removeWatcher(watcher5);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary7 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary8 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher10);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(watchesSummary7);
        org.junit.Assert.assertNotNull(watchesSummary8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test300() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test300");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.addWatch("", watcher9);
        org.apache.zookeeper.Watcher watcher11 = null;
        watchManager0.removeWatcher(watcher11);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
    }

    @Test
    public void test301() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test301");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.String str6 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher8);
        int int10 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\n" + "'", str6, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
    }

    @Test
    public void test302() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test302");
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
        org.apache.zookeeper.server.watch.WatchesReport watchesReport12 = watchManager0.getWatches();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesReport8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesReport12);
    }

    @Test
    public void test303() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test303");
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
        boolean boolean12 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher11);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean17 = watchManager0.addWatch("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher15, watcherMode16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test304() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test304");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        java.lang.String str8 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher10);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "0 connections watching 0 paths\n" + "'", str8, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test305() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test305");
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
        boolean boolean15 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher13, watcherMode14);
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        boolean boolean19 = watchManager0.removeWatcher("hi!", watcher17, watcherMode18);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport20 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher22 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode23 = null;
        boolean boolean24 = watchManager0.removeWatcher("1 connections watching 1 paths\nhi! -> [null]\n", watcher22, watcherMode23);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(watchesPathReport20);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
    }

    @Test
    public void test306() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test306");
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
        int int13 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport14 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary15 = watchManager0.getWatchesSummary();
        java.lang.Class<?> wildcardClass16 = watchesSummary15.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertNotNull(watchesPathReport14);
        org.junit.Assert.assertNotNull(watchesSummary15);
        org.junit.Assert.assertNotNull(wildcardClass16);
    }

    @Test
    public void test307() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test307");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        java.lang.String str9 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport10 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher12 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode13 = null;
        boolean boolean14 = watchManager0.removeWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher12, watcherMode13);
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.removeWatcher("1 connections watching 1 paths\nhi! -> [null]\n", watcher16);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test308() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test308");
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
        boolean boolean22 = watchManager0.containsWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher20, watcherMode21);
        org.apache.zookeeper.Watcher watcher23 = null;
        watchManager0.removeWatcher(watcher23);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport25 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher27 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode28 = null;
        boolean boolean29 = watchManager0.removeWatcher("", watcher27, watcherMode28);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary30 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "0 connections watching 0 paths\n" + "'", str18, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(watchesPathReport25);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNotNull(watchesSummary30);
    }

    @Test
    public void test309() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test309");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher7, watcherMode8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test310() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test310");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        int int5 = watchManager0.size();
        java.lang.String str6 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str4, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str6, "1 connections watching 1 paths\n -> [null]\n");
    }

    @Test
    public void test311() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test311");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher10);
        int int12 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.addWatch("hi!", watcher14);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        boolean boolean20 = watchManager0.containsWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher18, watcherMode19);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test312() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test312");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher10);
        int int12 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        int int14 = watchManager0.size();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(watchesPathReport13);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
    }

    @Test
    public void test313() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test313");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary8 = watchManager0.getWatchesSummary();
        java.io.PrintWriter printWriter9 = null;
        watchManager0.dumpWatches(printWriter9, true);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.removeWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.addWatch("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher16);
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.containsWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher19);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(watchesSummary8);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
    }

    @Test
    public void test314() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test314");
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
        java.io.PrintWriter printWriter19 = null;
        watchManager0.dumpWatches(printWriter19, true);
        org.apache.zookeeper.Watcher.Event.EventType eventType23 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager25 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher27 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode28 = null;
        boolean boolean29 = watchManager25.containsWatcher("hi!", watcher27, watcherMode28);
        java.lang.String str30 = watchManager25.toString();
        org.apache.zookeeper.Watcher watcher32 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode33 = null;
        boolean boolean34 = watchManager25.containsWatcher("0 connections watching 0 paths\n", watcher32, watcherMode33);
        org.apache.zookeeper.Watcher.Event.EventType eventType36 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager38 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType40 = null;
        org.apache.zookeeper.data.ACL[] aCLArray42 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList43 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean44 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList43, aCLArray42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = watchManager38.triggerWatch("", eventType40, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43, watcherOrBitSet45);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet47 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet48 = watchManager25.triggerWatch("", eventType36, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43, watcherOrBitSet47);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet49 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet50 = watchManager0.triggerWatch("", eventType23, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43, watcherOrBitSet49);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "0 connections watching 0 paths\n" + "'", str17, "0 connections watching 0 paths\n");
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "0 connections watching 0 paths\n" + "'", str18, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertEquals("'" + str30 + "' != '" + "0 connections watching 0 paths\n" + "'", str30, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertNotNull(aCLArray42);
        org.junit.Assert.assertArrayEquals(aCLArray42, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertNull(watcherOrBitSet46);
        org.junit.Assert.assertNull(watcherOrBitSet48);
        org.junit.Assert.assertNull(watcherOrBitSet50);
    }

    @Test
    public void test315() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test315");
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
        boolean boolean35 = watchManager21.removeWatcher("hi!", watcher34);
        org.apache.zookeeper.Watcher.Event.EventType eventType37 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager39 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher41 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode42 = null;
        boolean boolean43 = watchManager39.containsWatcher("hi!", watcher41, watcherMode42);
        java.io.PrintWriter printWriter44 = null;
        watchManager39.dumpWatches(printWriter44, false);
        org.apache.zookeeper.Watcher watcher48 = null;
        boolean boolean49 = watchManager39.addWatch("", watcher48);
        org.apache.zookeeper.Watcher.Event.EventType eventType51 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager53 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher55 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode56 = null;
        boolean boolean57 = watchManager53.containsWatcher("hi!", watcher55, watcherMode56);
        java.lang.String str58 = watchManager53.toString();
        org.apache.zookeeper.Watcher watcher60 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode61 = null;
        boolean boolean62 = watchManager53.removeWatcher("", watcher60, watcherMode61);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport63 = watchManager53.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType65 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager67 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport68 = watchManager67.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher70 = null;
        boolean boolean71 = watchManager67.containsWatcher("hi!", watcher70);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport72 = watchManager67.getWatches();
        org.apache.zookeeper.Watcher watcher74 = null;
        boolean boolean75 = watchManager67.containsWatcher("", watcher74);
        org.apache.zookeeper.Watcher.Event.EventType eventType77 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager79 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager79.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType82 = null;
        org.apache.zookeeper.data.ACL[] aCLArray84 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList85 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean86 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList85, aCLArray84);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet87 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet88 = watchManager79.triggerWatch("", eventType82, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList85, watcherOrBitSet87);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet89 = watchManager67.triggerWatch("", eventType77, (long) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList85);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet90 = watchManager53.triggerWatch("", eventType65, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList85);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet91 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet92 = watchManager39.triggerWatch("", eventType51, (long) (byte) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList85, watcherOrBitSet91);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet93 = watchManager21.triggerWatch("", eventType37, (long) 'a', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList85);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet94 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet95 = watchManager0.triggerWatch("", eventType19, (long) (short) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList85, watcherOrBitSet94);
        org.junit.Assert.assertNotNull(aCLArray10);
        org.junit.Assert.assertArrayEquals(aCLArray10, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNull(watcherOrBitSet15);
        org.junit.Assert.assertNotNull(watchesPathReport17);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + true + "'", boolean49 == true);
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + false + "'", boolean57 == false);
        org.junit.Assert.assertEquals("'" + str58 + "' != '" + "0 connections watching 0 paths\n" + "'", str58, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean62 + "' != '" + false + "'", boolean62 == false);
        org.junit.Assert.assertNotNull(watchesReport63);
        org.junit.Assert.assertNotNull(watchesPathReport68);
        org.junit.Assert.assertTrue("'" + boolean71 + "' != '" + false + "'", boolean71 == false);
        org.junit.Assert.assertNotNull(watchesReport72);
        org.junit.Assert.assertTrue("'" + boolean75 + "' != '" + false + "'", boolean75 == false);
        org.junit.Assert.assertNotNull(aCLArray84);
        org.junit.Assert.assertArrayEquals(aCLArray84, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean86 + "' != '" + false + "'", boolean86 == false);
        org.junit.Assert.assertNull(watcherOrBitSet88);
        org.junit.Assert.assertNull(watcherOrBitSet89);
        org.junit.Assert.assertNull(watcherOrBitSet90);
        org.junit.Assert.assertNull(watcherOrBitSet92);
        org.junit.Assert.assertNull(watcherOrBitSet93);
        org.junit.Assert.assertNull(watcherOrBitSet95);
    }

    @Test
    public void test316() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test316");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher8);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport10 = watchManager0.getWatches();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesReport10);
    }

    @Test
    public void test317() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test317");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher10, watcherMode11);
        org.apache.zookeeper.Watcher watcher13 = null;
        watchManager0.removeWatcher(watcher13);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport15 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher17);
        org.apache.zookeeper.Watcher watcher19 = null;
        watchManager0.removeWatcher(watcher19);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesReport15);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test318() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test318");
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
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.data.ACL[] aCLArray17 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList18 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean19 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList18, aCLArray17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet21 = watchManager0.triggerWatch("", eventType15, (long) '#', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList18, watcherOrBitSet20);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(watchesSummary11);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "0 connections watching 0 paths\n" + "'", str13, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(aCLArray17);
        org.junit.Assert.assertArrayEquals(aCLArray17, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNull(watcherOrBitSet21);
    }

    @Test
    public void test319() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test319");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary8 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("", watcher10, watcherMode11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.addWatch("", watcher14);
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        boolean boolean19 = watchManager0.removeWatcher("hi!", watcher17, watcherMode18);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(watchesSummary8);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test320() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test320");
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
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        boolean boolean18 = watchManager0.removeWatcher("hi!", watcher16, watcherMode17);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(watchesReport11);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
    }

    @Test
    public void test321() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test321");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode6 = null;
        boolean boolean7 = watchManager0.containsWatcher("", watcher5, watcherMode6);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.removeWatcher("hi!", watcher9);
        org.apache.zookeeper.Watcher watcher11 = null;
        watchManager0.removeWatcher(watcher11);
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport14 = watchManager0.getWatches();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(watchesReport14);
    }

    @Test
    public void test322() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test322");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher8);
        java.lang.String str10 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "0 connections watching 0 paths\n" + "'", str10, "0 connections watching 0 paths\n");
    }

    @Test
    public void test323() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test323");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport6 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary7 = watchManager0.getWatchesSummary();
        int int8 = watchManager0.size();
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        java.util.List<org.apache.zookeeper.data.ACL> aCLList12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager0.triggerWatch("", eventType10, (long) '#', aCLList12);
        java.lang.String str14 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesPathReport6);
        org.junit.Assert.assertNotNull(watchesSummary7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0 connections watching 0 paths\n" + "'", str14, "0 connections watching 0 paths\n");
    }

    @Test
    public void test324() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test324");
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
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        boolean boolean20 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher18, watcherMode19);
        org.apache.zookeeper.Watcher watcher22 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode23 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean24 = watchManager0.addWatch("", watcher22, watcherMode23);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test325() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test325");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher10, watcherMode11);
        org.apache.zookeeper.Watcher watcher13 = null;
        watchManager0.removeWatcher(watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.containsWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher16);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary18 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNotNull(watchesSummary18);
    }

    @Test
    public void test326() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test326");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode6 = null;
        boolean boolean7 = watchManager0.containsWatcher("", watcher5, watcherMode6);
        watchManager0.shutdown();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport9 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because the return value of \"java.util.Map$Entry.getKey()\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test327() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test327");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher6, watcherMode7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean17 = watchManager0.addWatch("1 connections watching 1 paths\nhi! -> [null]\n", watcher15, watcherMode16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1 connections watching 1 paths\n -> [null]\n" + "'", str4, "1 connections watching 1 paths\n -> [null]\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesSummary9);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test328() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test328");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        java.lang.String str8 = watchManager0.toString();
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "0 connections watching 0 paths\n" + "'", str8, "0 connections watching 0 paths\n");
    }

    @Test
    public void test329() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test329");
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
        boolean boolean14 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        boolean boolean18 = watchManager0.removeWatcher("", watcher16, watcherMode17);
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test330() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test330");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher6, watcherMode7);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport9 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher11);
        int int13 = watchManager0.size();
        java.lang.String str14 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesReport9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0 connections watching 0 paths\n" + "'", str14, "0 connections watching 0 paths\n");
    }

    @Test
    public void test331() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test331");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher.Event.EventType eventType9 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager11 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager11.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager11.triggerWatch("", eventType14, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet19);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet21 = watchManager0.triggerWatch("", eventType9, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17);
        org.apache.zookeeper.Watcher watcher23 = null;
        boolean boolean24 = watchManager0.containsWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher23);
        org.apache.zookeeper.Watcher watcher26 = null;
        boolean boolean27 = watchManager0.removeWatcher("1 connections watching 1 paths\nhi! -> [null]\n", watcher26);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNull(watcherOrBitSet21);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
    }

    @Test
    public void test332() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test332");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        boolean boolean10 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher8, watcherMode9);
        java.lang.String str11 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "0 connections watching 0 paths\n" + "'", str11, "0 connections watching 0 paths\n");
    }

    @Test
    public void test333() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test333");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport6 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher15);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary17 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesPathReport6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertNotNull(watchesSummary17);
    }

    @Test
    public void test334() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test334");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        java.lang.Class<?> wildcardClass5 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test335() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test335");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode6 = null;
        boolean boolean7 = watchManager0.containsWatcher("", watcher5, watcherMode6);
        org.apache.zookeeper.Watcher watcher8 = null;
        watchManager0.removeWatcher(watcher8);
        java.io.PrintWriter printWriter10 = null;
        watchManager0.dumpWatches(printWriter10, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test336() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test336");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.addWatch("", watcher9);
        org.apache.zookeeper.Watcher watcher12 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode13 = null;
        boolean boolean14 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher12, watcherMode13);
        java.io.PrintWriter printWriter15 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter15, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.print(String)\" because \"writer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test337() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test337");
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
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test338() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test338");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.addWatch("hi!", watcher6);
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.containsWatcher("", watcher9);
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher12);
        int int14 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 1 + "'", int14 == 1);
    }

    @Test
    public void test339() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test339");
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
        boolean boolean15 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher13, watcherMode14);
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        boolean boolean19 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher17, watcherMode18);
        org.apache.zookeeper.Watcher.Event.EventType eventType21 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager23 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport24 = watchManager23.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher26 = null;
        boolean boolean27 = watchManager23.containsWatcher("hi!", watcher26);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport28 = watchManager23.getWatches();
        org.apache.zookeeper.Watcher watcher30 = null;
        boolean boolean31 = watchManager23.containsWatcher("", watcher30);
        org.apache.zookeeper.Watcher.Event.EventType eventType33 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager35 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager35.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType38 = null;
        org.apache.zookeeper.data.ACL[] aCLArray40 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList41 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean42 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList41, aCLArray40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager35.triggerWatch("", eventType38, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList41, watcherOrBitSet43);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = watchManager23.triggerWatch("", eventType33, (long) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList41);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = watchManager0.triggerWatch("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", eventType21, (long) (byte) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList41);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 95");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(watchesPathReport24);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNotNull(watchesReport28);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNotNull(aCLArray40);
        org.junit.Assert.assertArrayEquals(aCLArray40, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertNull(watcherOrBitSet45);
    }

    @Test
    public void test340() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test340");
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
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.removeWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher16);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(watchesReport11);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test341() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test341");
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
        boolean boolean22 = watchManager0.containsWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher20, watcherMode21);
        org.apache.zookeeper.Watcher watcher23 = null;
        watchManager0.removeWatcher(watcher23);
        org.apache.zookeeper.Watcher watcher26 = null;
        boolean boolean27 = watchManager0.containsWatcher("hi!", watcher26);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "0 connections watching 0 paths\n" + "'", str18, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
    }

    @Test
    public void test342() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test342");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode6 = null;
        boolean boolean7 = watchManager0.containsWatcher("", watcher5, watcherMode6);
        int int8 = watchManager0.size();
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        boolean boolean16 = watchManager12.containsWatcher("hi!", watcher14, watcherMode15);
        java.io.PrintWriter printWriter17 = null;
        watchManager12.dumpWatches(printWriter17, false);
        org.apache.zookeeper.Watcher.Event.EventType eventType21 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager23 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager23.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType26 = null;
        org.apache.zookeeper.data.ACL[] aCLArray28 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList29 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean30 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList29, aCLArray28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager23.triggerWatch("", eventType26, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList29, watcherOrBitSet31);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager12.triggerWatch("", eventType21, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList29);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager0.triggerWatch("hi!", eventType10, (long) 2, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList29);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 1 + "'", int8 == 1);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(aCLArray28);
        org.junit.Assert.assertArrayEquals(aCLArray28, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertNull(watcherOrBitSet32);
        org.junit.Assert.assertNull(watcherOrBitSet33);
    }

    @Test
    public void test343() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test343");
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
        org.apache.zookeeper.server.watch.WatchesReport watchesReport17 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.addWatch("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher19);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(watchesReport17);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
    }

    @Test
    public void test344() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test344");
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
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet57 = watchManager0.triggerWatch("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", eventType17, (long) (short) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList51);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 95");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "0 connections watching 0 paths\n" + "'", str24, "0 connections watching 0 paths\n");
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
    public void test345() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test345");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher6);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher9, watcherMode10);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test346() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test346");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher6, watcherMode7);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesPathReport9);
    }

    @Test
    public void test347() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test347");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport7 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter8 = null;
        watchManager0.dumpWatches(printWriter8, false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesPathReport7);
    }

    @Test
    public void test348() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test348");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test349() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test349");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher10);
        int int12 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher14);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test350() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test350");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager13 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.data.ACL[] aCLArray17 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList18 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean19 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList18, aCLArray17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet21 = watchManager13.triggerWatch("", eventType15, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList18, watcherOrBitSet20);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet23 = watchManager0.triggerWatch("", eventType11, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList18, watcherOrBitSet22);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport24 = watchManager0.getWatches();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(aCLArray17);
        org.junit.Assert.assertArrayEquals(aCLArray17, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNull(watcherOrBitSet21);
        org.junit.Assert.assertNull(watcherOrBitSet23);
        org.junit.Assert.assertNotNull(watchesReport24);
    }

    @Test
    public void test351() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test351");
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
        boolean boolean13 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher11, watcherMode12);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport14 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        boolean boolean18 = watchManager0.removeWatcher("", watcher16, watcherMode17);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesReport14);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test352() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test352");
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
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        boolean boolean16 = watchManager0.containsWatcher("1 connections watching 1 paths\nhi! -> [null]\n", watcher14, watcherMode15);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(watchesSummary11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test353() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test353");
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
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        boolean boolean22 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher20, watcherMode21);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "0 connections watching 0 paths\n" + "'", str17, "0 connections watching 0 paths\n");
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "0 connections watching 0 paths\n" + "'", str18, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test354() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test354");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        int int2 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        boolean boolean6 = watchManager0.containsWatcher("1 connections watching 1 paths\nhi! -> [null]\n", watcher4, watcherMode5);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test355() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test355");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher8);
        org.apache.zookeeper.Watcher watcher10 = null;
        watchManager0.removeWatcher(watcher10);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test356() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test356");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        int int2 = watchManager0.size();
        java.lang.String str3 = watchManager0.toString();
        java.io.PrintWriter printWriter4 = null;
        watchManager0.dumpWatches(printWriter4, false);
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher8);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "0 connections watching 0 paths\n" + "'", str3, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test357() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test357");
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
        org.apache.zookeeper.Watcher watcher23 = null;
        boolean boolean24 = watchManager0.removeWatcher("1 connections watching 1 paths\nhi! -> [null]\n", watcher23);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesPathReport14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
    }

    @Test
    public void test358() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test358");
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
        boolean boolean14 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher13);
        java.io.PrintWriter printWriter15 = null;
        watchManager0.dumpWatches(printWriter15, false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test359() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test359");
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
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesPathReport12);
    }

    @Test
    public void test360() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test360");
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
        boolean boolean12 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher14);
        java.lang.String str16 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n" + "'", str16, "1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n");
    }

    @Test
    public void test361() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test361");
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
        org.apache.zookeeper.server.watch.WatcherMode watcherMode20 = null;
        boolean boolean21 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher19, watcherMode20);
        org.apache.zookeeper.Watcher watcher23 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode24 = null;
        boolean boolean25 = watchManager0.removeWatcher("1 connections watching 1 paths\nhi! -> [null]\n", watcher23, watcherMode24);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesPathReport14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
    }

    @Test
    public void test362() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test362");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher10);
        org.apache.zookeeper.Watcher watcher13 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode14 = null;
        boolean boolean15 = watchManager0.removeWatcher("", watcher13, watcherMode14);
        java.lang.String str16 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport17 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher.Event.EventType eventType19 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager21 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport22 = watchManager21.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher24 = null;
        boolean boolean25 = watchManager21.containsWatcher("hi!", watcher24);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport26 = watchManager21.getWatches();
        org.apache.zookeeper.Watcher watcher28 = null;
        boolean boolean29 = watchManager21.containsWatcher("", watcher28);
        org.apache.zookeeper.Watcher.Event.EventType eventType31 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager33 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager33.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType36 = null;
        org.apache.zookeeper.data.ACL[] aCLArray38 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList39 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean40 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList39, aCLArray38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager33.triggerWatch("", eventType36, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39, watcherOrBitSet41);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager21.triggerWatch("", eventType31, (long) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager0.triggerWatch("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", eventType19, (long) 'a', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 95");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "0 connections watching 0 paths\n" + "'", str16, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesPathReport17);
        org.junit.Assert.assertNotNull(watchesPathReport22);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(watchesReport26);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNotNull(aCLArray38);
        org.junit.Assert.assertArrayEquals(aCLArray38, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertNull(watcherOrBitSet42);
        org.junit.Assert.assertNull(watcherOrBitSet43);
    }

    @Test
    public void test363() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test363");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher4);
        int int6 = watchManager0.size();
        java.lang.Class<?> wildcardClass7 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 1 + "'", int6 == 1);
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test364() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test364");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher10);
        int int12 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.addWatch("hi!", watcher14);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport16 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because the return value of \"java.util.Map$Entry.getKey()\" is null");
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
    public void test365() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test365");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        java.lang.String str14 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0 connections watching 0 paths\n" + "'", str14, "0 connections watching 0 paths\n");
    }

    @Test
    public void test366() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test366");
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
        boolean boolean13 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher15);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
    }

    @Test
    public void test367() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test367");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        int int2 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher4);
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport10 = watchManager9.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager9.containsWatcher("hi!", watcher12);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport14 = watchManager9.getWatches();
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager9.containsWatcher("", watcher16);
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager9.containsWatcher("hi!", watcher19);
        int int21 = watchManager9.size();
        org.apache.zookeeper.Watcher.Event.EventType eventType23 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager25 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.data.ACL[] aCLArray29 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList30 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList30, aCLArray29);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager25.triggerWatch("", eventType27, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30, watcherOrBitSet32);
        org.apache.zookeeper.Watcher watcher34 = null;
        watchManager25.removeWatcher(watcher34);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport36 = watchManager25.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType38 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager40 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager40.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType43 = null;
        org.apache.zookeeper.data.ACL[] aCLArray45 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList46 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean47 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList46, aCLArray45);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet48 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet49 = watchManager40.triggerWatch("", eventType43, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList46, watcherOrBitSet48);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet50 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet51 = watchManager25.triggerWatch("", eventType38, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList46, watcherOrBitSet50);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet52 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet53 = watchManager9.triggerWatch("", eventType23, (long) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList46, watcherOrBitSet52);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet54 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet55 = watchManager0.triggerWatch("1 connections watching 1 paths\n -> [null]\n", eventType7, (long) 'a', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList46, watcherOrBitSet54);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 42");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(watchesPathReport10);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesReport14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
        org.junit.Assert.assertNotNull(aCLArray29);
        org.junit.Assert.assertArrayEquals(aCLArray29, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertNotNull(watchesReport36);
        org.junit.Assert.assertNotNull(aCLArray45);
        org.junit.Assert.assertArrayEquals(aCLArray45, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + false + "'", boolean47 == false);
        org.junit.Assert.assertNull(watcherOrBitSet49);
        org.junit.Assert.assertNull(watcherOrBitSet51);
        org.junit.Assert.assertNull(watcherOrBitSet53);
    }

    @Test
    public void test368() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test368");
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
        java.lang.Class<?> wildcardClass14 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(watchesSummary11);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "0 connections watching 0 paths\n" + "'", str13, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(wildcardClass14);
    }

    @Test
    public void test369() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test369");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.removeWatcher("", watcher6);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport8 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter9 = null;
        watchManager0.dumpWatches(printWriter9, true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNotNull(watchesPathReport8);
    }

    @Test
    public void test370() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test370");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher14 = null;
        watchManager0.removeWatcher(watcher14);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary16 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary16);
    }

    @Test
    public void test371() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test371");
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
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean20 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher18, watcherMode19);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test372() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test372");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        watchManager0.shutdown();
        java.io.PrintWriter printWriter9 = null;
        watchManager0.dumpWatches(printWriter9, true);
        org.apache.zookeeper.Watcher watcher13 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode14 = null;
        boolean boolean15 = watchManager0.containsWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher13, watcherMode14);
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.removeWatcher("hi!", watcher17);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test373() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test373");
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
        boolean boolean13 = watchManager0.addWatch("", watcher12);
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager0.addWatch("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher15);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
    }

    @Test
    public void test374() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test374");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher6, watcherMode7);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher10 = null;
        watchManager0.removeWatcher(watcher10);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher13);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport15 = watchManager0.getWatches();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesSummary9);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(watchesReport15);
    }

    @Test
    public void test375() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test375");
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
        org.apache.zookeeper.server.watch.WatchesReport watchesReport17 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType19 = null;
        java.util.List<org.apache.zookeeper.data.ACL> aCLList21 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = watchManager0.triggerWatch("1 connections watching 1 paths\nhi! -> [null]\n", eventType19, (long) (byte) 100, aCLList21);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 45");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(watchesReport17);
    }

    @Test
    public void test376() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test376");
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
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        java.lang.Class<?> wildcardClass13 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertNotNull(watchesPathReport12);
        org.junit.Assert.assertNotNull(wildcardClass13);
    }

    @Test
    public void test377() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test377");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher3);
        int int5 = watchManager0.size();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport10 = watchManager9.getWatchesByPath();
        watchManager9.shutdown();
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager9.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher13);
        java.lang.String str15 = watchManager9.toString();
        org.apache.zookeeper.Watcher.Event.EventType eventType17 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager19 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager19.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.data.ACL[] aCLArray24 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList25 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean26 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList25, aCLArray24);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = watchManager19.triggerWatch("", eventType22, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList25, watcherOrBitSet27);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = watchManager9.triggerWatch("", eventType17, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList25, watcherOrBitSet29);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager0.triggerWatch("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", eventType7, (long) 2, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList25);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 84");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(watchesPathReport10);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n" + "'", str15, "1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n");
        org.junit.Assert.assertNotNull(aCLArray24);
        org.junit.Assert.assertArrayEquals(aCLArray24, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertNull(watcherOrBitSet28);
        org.junit.Assert.assertNull(watcherOrBitSet30);
    }

    @Test
    public void test378() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test378");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher5 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode6 = null;
        boolean boolean7 = watchManager0.containsWatcher("", watcher5, watcherMode6);
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNotNull(watchesSummary9);
    }

    @Test
    public void test379() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test379");
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
        boolean boolean13 = watchManager0.addWatch("1 connections watching 1 paths\nhi! -> [null]\n", watcher12);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
    }

    @Test
    public void test380() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test380");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport6 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary7 = watchManager0.getWatchesSummary();
        int int8 = watchManager0.size();
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        java.util.List<org.apache.zookeeper.data.ACL> aCLList12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager0.triggerWatch("", eventType10, (long) '#', aCLList12);
        int int14 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesPathReport6);
        org.junit.Assert.assertNotNull(watchesSummary7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
    }

    @Test
    public void test381() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test381");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary8 = watchManager0.getWatchesSummary();
        java.io.PrintWriter printWriter9 = null;
        watchManager0.dumpWatches(printWriter9, true);
        java.io.PrintWriter printWriter12 = null;
        watchManager0.dumpWatches(printWriter12, true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(watchesSummary8);
    }

    @Test
    public void test382() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test382");
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
        boolean boolean12 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher11);
        watchManager0.shutdown();
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
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test383() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test383");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        java.io.PrintWriter printWriter8 = null;
        watchManager0.dumpWatches(printWriter8, false);
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.addWatch("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher12);
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.removeWatcher("0 connections watching 0 paths\n", watcher15, watcherMode16);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test384() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test384");
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
        boolean boolean15 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher13, watcherMode14);
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        boolean boolean19 = watchManager0.removeWatcher("hi!", watcher17, watcherMode18);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary20 = watchManager0.getWatchesSummary();
        java.io.PrintWriter printWriter21 = null;
        watchManager0.dumpWatches(printWriter21, false);
        org.apache.zookeeper.Watcher watcher24 = null;
        watchManager0.removeWatcher(watcher24);
        org.apache.zookeeper.Watcher watcher27 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode28 = null;
        boolean boolean29 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher27, watcherMode28);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(watchesSummary20);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
    }

    @Test
    public void test385() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test385");
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
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.containsWatcher("hi!", watcher13);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertNotNull(watchesReport11);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test386() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test386");
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
        boolean boolean22 = watchManager0.containsWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher20, watcherMode21);
        org.apache.zookeeper.Watcher watcher23 = null;
        watchManager0.removeWatcher(watcher23);
        org.apache.zookeeper.Watcher watcher26 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode27 = null;
        boolean boolean28 = watchManager0.removeWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher26, watcherMode27);
        org.apache.zookeeper.Watcher watcher30 = null;
        boolean boolean31 = watchManager0.addWatch("1 connections watching 1 paths\nhi! -> [null]\n", watcher30);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "0 connections watching 0 paths\n" + "'", str18, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + true + "'", boolean31 == true);
    }

    @Test
    public void test387() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test387");
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
        org.apache.zookeeper.Watcher.Event.EventType eventType21 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager23 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher25 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode26 = null;
        boolean boolean27 = watchManager23.containsWatcher("hi!", watcher25, watcherMode26);
        java.lang.String str28 = watchManager23.toString();
        org.apache.zookeeper.Watcher watcher30 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode31 = null;
        boolean boolean32 = watchManager23.containsWatcher("0 connections watching 0 paths\n", watcher30, watcherMode31);
        org.apache.zookeeper.Watcher.Event.EventType eventType34 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager36 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType38 = null;
        org.apache.zookeeper.data.ACL[] aCLArray40 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList41 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean42 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList41, aCLArray40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager36.triggerWatch("", eventType38, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList41, watcherOrBitSet43);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = watchManager23.triggerWatch("", eventType34, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList41, watcherOrBitSet45);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet47 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet48 = watchManager0.triggerWatch("hi!", eventType21, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList41, watcherOrBitSet47);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertEquals("'" + str28 + "' != '" + "0 connections watching 0 paths\n" + "'", str28, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNotNull(aCLArray40);
        org.junit.Assert.assertArrayEquals(aCLArray40, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertNull(watcherOrBitSet46);
    }

    @Test
    public void test388() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test388");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.addWatch("", watcher6);
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        boolean boolean11 = watchManager0.containsWatcher("hi!", watcher9, watcherMode10);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test389() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test389");
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
        boolean boolean15 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher13, watcherMode14);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary16 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher18);
        java.lang.String str20 = watchManager0.toString();
        java.io.PrintWriter printWriter21 = null;
        watchManager0.dumpWatches(printWriter21, true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(watchesSummary16);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "0 connections watching 0 paths\n" + "'", str20, "0 connections watching 0 paths\n");
    }

    @Test
    public void test390() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test390");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher10);
        int int12 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.addWatch("hi!", watcher14);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary16 = watchManager0.getWatchesSummary();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher19 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode20 = null;
        boolean boolean21 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher19, watcherMode20);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertNotNull(watchesSummary16);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
    }

    @Test
    public void test391() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test391");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        java.lang.Class<?> wildcardClass6 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test392() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test392");
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
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager17 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager17.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager22 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager22.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.data.ACL[] aCLArray27 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList28 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean29 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList28, aCLArray27);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager22.triggerWatch("", eventType25, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28, watcherOrBitSet30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager17.triggerWatch("", eventType20, (long) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager0.triggerWatch("0 connections watching 0 paths\n", eventType15, (long) (short) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 31");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(watchesSummary11);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "0 connections watching 0 paths\n" + "'", str13, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(aCLArray27);
        org.junit.Assert.assertArrayEquals(aCLArray27, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNull(watcherOrBitSet32);
    }

    @Test
    public void test393() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test393");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher6, watcherMode7);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport9 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher11);
        int int13 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager0.removeWatcher("1 connections watching 1 paths\nhi! -> [null]\n", watcher15);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesReport9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test394() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test394");
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
        watchManager0.dumpWatches(printWriter12, true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(watchesReport11);
    }

    @Test
    public void test395() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test395");
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
        boolean boolean13 = watchManager0.addWatch("", watcher12);
        watchManager0.shutdown();
        watchManager0.shutdown();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
    }

    @Test
    public void test396() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test396");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher4);
        int int6 = watchManager0.size();
        int int7 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 1 + "'", int6 == 1);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 1 + "'", int7 == 1);
    }

    @Test
    public void test397() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test397");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport8 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher10, watcherMode11);
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean16 = watchManager0.addWatch("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher14, watcherMode15);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesPathReport8);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test398() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test398");
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
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean16 = watchManager0.addWatch("", watcher14, watcherMode15);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test399() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test399");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        watchManager0.removeWatcher(watcher6);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary8 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesSummary8);
    }

    @Test
    public void test400() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test400");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary8 = watchManager0.getWatchesSummary();
        java.io.PrintWriter printWriter9 = null;
        watchManager0.dumpWatches(printWriter9, true);
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.removeWatcher("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.addWatch("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher16);
        watchManager0.shutdown();
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(watchesSummary8);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
    }

    @Test
    public void test401() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test401");
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
        boolean boolean15 = watchManager0.containsWatcher("", watcher13, watcherMode14);
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.addWatch("0 connections watching 0 paths\n", watcher17);
        java.io.PrintWriter printWriter19 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter19, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.print(String)\" because \"writer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
    }

    @Test
    public void test402() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test402");
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
        boolean boolean12 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher11);
        watchManager0.shutdown();
        java.lang.String str14 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0 connections watching 0 paths\n" + "'", str14, "0 connections watching 0 paths\n");
    }

    @Test
    public void test403() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test403");
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
        boolean boolean13 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher12);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher16);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
    }

    @Test
    public void test404() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test404");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport6 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary7 = watchManager0.getWatchesSummary();
        int int8 = watchManager0.size();
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        java.util.List<org.apache.zookeeper.data.ACL> aCLList12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager0.triggerWatch("", eventType10, (long) '#', aCLList12);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport14 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        boolean boolean18 = watchManager0.containsWatcher("hi!", watcher16, watcherMode17);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesPathReport6);
        org.junit.Assert.assertNotNull(watchesSummary7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNotNull(watchesPathReport14);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test405() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test405");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher3);
        org.apache.zookeeper.Watcher watcher5 = null;
        watchManager0.removeWatcher(watcher5);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary7 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher9 = null;
        boolean boolean10 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher9);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(watchesSummary7);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test406() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test406");
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
        java.lang.Class<?> wildcardClass12 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertNotNull(wildcardClass12);
    }

    @Test
    public void test407() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test407");
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
        boolean boolean15 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher13, watcherMode14);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary16 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.containsWatcher("0 connections watching 0 paths\n", watcher18);
        org.apache.zookeeper.Watcher.Event.EventType eventType21 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager23 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher25 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode26 = null;
        boolean boolean27 = watchManager23.containsWatcher("hi!", watcher25, watcherMode26);
        java.io.PrintWriter printWriter28 = null;
        watchManager23.dumpWatches(printWriter28, false);
        org.apache.zookeeper.Watcher watcher32 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode33 = null;
        boolean boolean34 = watchManager23.containsWatcher("hi!", watcher32, watcherMode33);
        org.apache.zookeeper.Watcher watcher36 = null;
        boolean boolean37 = watchManager23.removeWatcher("hi!", watcher36);
        org.apache.zookeeper.Watcher.Event.EventType eventType39 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager41 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher43 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode44 = null;
        boolean boolean45 = watchManager41.containsWatcher("hi!", watcher43, watcherMode44);
        java.io.PrintWriter printWriter46 = null;
        watchManager41.dumpWatches(printWriter46, false);
        org.apache.zookeeper.Watcher watcher50 = null;
        boolean boolean51 = watchManager41.addWatch("", watcher50);
        org.apache.zookeeper.Watcher.Event.EventType eventType53 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager55 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher57 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode58 = null;
        boolean boolean59 = watchManager55.containsWatcher("hi!", watcher57, watcherMode58);
        java.lang.String str60 = watchManager55.toString();
        org.apache.zookeeper.Watcher watcher62 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode63 = null;
        boolean boolean64 = watchManager55.removeWatcher("", watcher62, watcherMode63);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport65 = watchManager55.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType67 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager69 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport70 = watchManager69.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher72 = null;
        boolean boolean73 = watchManager69.containsWatcher("hi!", watcher72);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport74 = watchManager69.getWatches();
        org.apache.zookeeper.Watcher watcher76 = null;
        boolean boolean77 = watchManager69.containsWatcher("", watcher76);
        org.apache.zookeeper.Watcher.Event.EventType eventType79 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager81 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager81.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType84 = null;
        org.apache.zookeeper.data.ACL[] aCLArray86 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList87 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean88 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList87, aCLArray86);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet89 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet90 = watchManager81.triggerWatch("", eventType84, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList87, watcherOrBitSet89);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet91 = watchManager69.triggerWatch("", eventType79, (long) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList87);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet92 = watchManager55.triggerWatch("", eventType67, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList87);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet93 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet94 = watchManager41.triggerWatch("", eventType53, (long) (byte) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList87, watcherOrBitSet93);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet95 = watchManager23.triggerWatch("", eventType39, (long) 'a', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList87);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet96 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet97 = watchManager0.triggerWatch("1 connections watching 1 paths\nhi! -> [null]\n", eventType21, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList87, watcherOrBitSet96);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 45");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(watchesSummary16);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
        org.junit.Assert.assertTrue("'" + boolean51 + "' != '" + true + "'", boolean51 == true);
        org.junit.Assert.assertTrue("'" + boolean59 + "' != '" + false + "'", boolean59 == false);
        org.junit.Assert.assertEquals("'" + str60 + "' != '" + "0 connections watching 0 paths\n" + "'", str60, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean64 + "' != '" + false + "'", boolean64 == false);
        org.junit.Assert.assertNotNull(watchesReport65);
        org.junit.Assert.assertNotNull(watchesPathReport70);
        org.junit.Assert.assertTrue("'" + boolean73 + "' != '" + false + "'", boolean73 == false);
        org.junit.Assert.assertNotNull(watchesReport74);
        org.junit.Assert.assertTrue("'" + boolean77 + "' != '" + false + "'", boolean77 == false);
        org.junit.Assert.assertNotNull(aCLArray86);
        org.junit.Assert.assertArrayEquals(aCLArray86, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean88 + "' != '" + false + "'", boolean88 == false);
        org.junit.Assert.assertNull(watcherOrBitSet90);
        org.junit.Assert.assertNull(watcherOrBitSet91);
        org.junit.Assert.assertNull(watcherOrBitSet92);
        org.junit.Assert.assertNull(watcherOrBitSet94);
        org.junit.Assert.assertNull(watcherOrBitSet95);
    }

    @Test
    public void test408() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test408");
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
        org.apache.zookeeper.Watcher.Event.EventType eventType13 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager15 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager15.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType18 = null;
        org.apache.zookeeper.data.ACL[] aCLArray20 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList21 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean22 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList21, aCLArray20);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet23 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = watchManager15.triggerWatch("", eventType18, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList21, watcherOrBitSet23);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = watchManager0.triggerWatch("hi!", eventType13, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList21);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(watchesReport11);
        org.junit.Assert.assertNotNull(aCLArray20);
        org.junit.Assert.assertArrayEquals(aCLArray20, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNull(watcherOrBitSet24);
    }

    @Test
    public void test409() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test409");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport2 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        org.apache.zookeeper.Watcher watcher5 = null;
        watchManager0.removeWatcher(watcher5);
        org.junit.Assert.assertNotNull(watchesPathReport2);
    }

    @Test
    public void test410() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test410");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("", watcher2);
        int int4 = watchManager0.size();
        watchManager0.shutdown();
        java.lang.Class<?> wildcardClass6 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test411() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test411");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport1 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("hi!", watcher4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("1 connections watching 2 paths\n -> [null]\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", watcher7, watcherMode8);
        org.junit.Assert.assertNotNull(watchesPathReport1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test412() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test412");
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
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.containsWatcher("", watcher15, watcherMode16);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\n" + "'", str7, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test413() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test413");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("1 connections watching 1 paths\n -> [null]\n", watcher10);
        int int12 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.addWatch("hi!", watcher14);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary16 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.containsWatcher("1 connections watching 1 paths\n -> [null]\n", watcher18);
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertNotNull(watchesSummary16);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test414() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test414");
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
        int int13 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport14 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        boolean boolean18 = watchManager0.containsWatcher("hi!", watcher16, watcherMode17);
        org.apache.zookeeper.Watcher watcher19 = null;
        watchManager0.removeWatcher(watcher19);
        org.apache.zookeeper.Watcher watcher21 = null;
        watchManager0.removeWatcher(watcher21);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertNotNull(watchesPathReport14);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test415() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test415");
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
        org.apache.zookeeper.server.watch.WatchesReport watchesReport20 = watchManager0.getWatches();
        int int21 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(watchesReport20);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
    }

    @Test
    public void test416() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test416");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        int int2 = watchManager0.size();
        java.lang.String str3 = watchManager0.toString();
        java.io.PrintWriter printWriter4 = null;
        watchManager0.dumpWatches(printWriter4, false);
        org.apache.zookeeper.Watcher watcher7 = null;
        watchManager0.removeWatcher(watcher7);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "0 connections watching 0 paths\n" + "'", str3, "0 connections watching 0 paths\n");
    }

    @Test
    public void test417() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test417");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode3 = null;
        boolean boolean4 = watchManager0.containsWatcher("hi!", watcher2, watcherMode3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("", watcher7);
        org.apache.zookeeper.Watcher watcher9 = null;
        watchManager0.removeWatcher(watcher9);
        org.apache.zookeeper.Watcher watcher11 = null;
        watchManager0.removeWatcher(watcher11);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport13 = watchManager0.getWatches();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\n" + "'", str5, "0 connections watching 0 paths\n");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(watchesReport13);
    }

    @Test
    public void test418() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "WatchManagerc2RandoopTest0.test418");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.data.ACL[] aCLArray4 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList5 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList5, aCLArray4);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet7 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = watchManager0.triggerWatch("", eventType2, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList5, watcherOrBitSet7);
        java.lang.String str9 = watchManager0.toString();
        java.lang.String str10 = watchManager0.toString();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager14 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport15 = watchManager14.getWatchesByPath();
        watchManager14.shutdown();
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager14.addWatch("1 connections watching 1 paths\n -> [null]\n", watcher18);
        java.lang.String str20 = watchManager14.toString();
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager24.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.data.ACL[] aCLArray29 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList30 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList30, aCLArray29);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager24.triggerWatch("", eventType27, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30, watcherOrBitSet32);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = watchManager14.triggerWatch("", eventType22, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30, watcherOrBitSet34);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = watchManager0.triggerWatch("1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n", eventType12, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 84");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(aCLArray4);
        org.junit.Assert.assertArrayEquals(aCLArray4, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(watcherOrBitSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "0 connections watching 0 paths\n" + "'", str9, "0 connections watching 0 paths\n");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "0 connections watching 0 paths\n" + "'", str10, "0 connections watching 0 paths\n");
        org.junit.Assert.assertNotNull(watchesPathReport15);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n" + "'", str20, "1 connections watching 1 paths\n1 connections watching 1 paths\n -> [null]\n -> [null]\n");
        org.junit.Assert.assertNotNull(aCLArray29);
        org.junit.Assert.assertArrayEquals(aCLArray29, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertNull(watcherOrBitSet35);
    }
}

