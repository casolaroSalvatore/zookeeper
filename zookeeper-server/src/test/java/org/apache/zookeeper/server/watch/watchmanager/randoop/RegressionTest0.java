package org.apache.zookeeper.server.watch;

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
            System.out.format("%n%s%n", "RegressionTest0.test001");
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
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        java.util.List<org.apache.zookeeper.data.ACL> aCLList13 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet15 = watchManager0.triggerWatch("hi!", eventType11, 100L, aCLList13, watcherOrBitSet14);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Class<?> wildcardClass10 = watcherOrBitSet9.getClass();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test004");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        org.apache.zookeeper.Watcher.Event.EventType eventType6 = null;
        org.apache.zookeeper.data.ACL[] aCLArray8 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList9 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean10 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList9, aCLArray8);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet11 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = watchManager0.triggerWatch("hi!", eventType6, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList9, watcherOrBitSet11);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(aCLArray8);
        org.junit.Assert.assertArrayEquals(aCLArray8, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test005");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("hi!", watcher11);
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager16 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary17 = watchManager16.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType19 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager21 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType23 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager25 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary26 = watchManager25.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType28 = null;
        org.apache.zookeeper.data.ACL[] aCLArray30 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList31 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean32 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList31, aCLArray30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager25.triggerWatch("", eventType28, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList31, watcherOrBitSet33);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = watchManager21.triggerWatch("", eventType23, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList31);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = watchManager16.triggerWatch("", eventType19, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList31);
        org.apache.zookeeper.Watcher.Event.EventType eventType38 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager40 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary41 = watchManager40.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType43 = null;
        org.apache.zookeeper.data.ACL[] aCLArray45 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList46 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean47 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList46, aCLArray45);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet48 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet49 = watchManager40.triggerWatch("", eventType43, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList46, watcherOrBitSet48);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet50 = watchManager16.triggerWatch("", eventType38, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList46);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet51 = watchManager0.triggerWatch("hi!", eventType14, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList46);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertNotNull(watchesSummary17);
        org.junit.Assert.assertNotNull(watchesSummary26);
        org.junit.Assert.assertNotNull(aCLArray30);
        org.junit.Assert.assertArrayEquals(aCLArray30, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNull(watcherOrBitSet34);
        org.junit.Assert.assertNull(watcherOrBitSet35);
        org.junit.Assert.assertNull(watcherOrBitSet36);
        org.junit.Assert.assertNotNull(watchesSummary41);
        org.junit.Assert.assertNotNull(aCLArray45);
        org.junit.Assert.assertArrayEquals(aCLArray45, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + false + "'", boolean47 == false);
        org.junit.Assert.assertNull(watcherOrBitSet49);
        org.junit.Assert.assertNull(watcherOrBitSet50);
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary15 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean19 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher17, watcherMode18);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesSummary15);
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager22 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary23 = watchManager22.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.data.ACL[] aCLArray27 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList28 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean29 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList28, aCLArray27);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager22.triggerWatch("", eventType25, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28, watcherOrBitSet30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager18.triggerWatch("", eventType20, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager0.triggerWatch("", eventType16, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        org.apache.zookeeper.Watcher watcher35 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode36 = null;
        boolean boolean37 = watchManager0.removeWatcher("", watcher35, watcherMode36);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesSummary23);
        org.junit.Assert.assertNotNull(aCLArray27);
        org.junit.Assert.assertArrayEquals(aCLArray27, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNull(watcherOrBitSet32);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.size();
        watchManager0.shutdown();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap3 = watchManager0.getWatch2Paths();
        org.apache.zookeeper.Watcher.Event.EventType eventType5 = null;
        org.apache.zookeeper.data.ACL[] aCLArray7 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList8 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean9 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList8, aCLArray7);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet10 = watchManager0.triggerWatch("0 connections watching 0 paths\nTotal watches:0", eventType5, (long) 'a', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList8);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(watcherMap3);
        org.junit.Assert.assertNotNull(aCLArray7);
        org.junit.Assert.assertArrayEquals(aCLArray7, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.containsWatcher("", watcher18);
        java.lang.Class<?> wildcardClass20 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(wildcardClass20);
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.Watcher.Event.EventType eventType21 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager23 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager27 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary28 = watchManager27.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType30 = null;
        org.apache.zookeeper.data.ACL[] aCLArray32 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList33 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean34 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList33, aCLArray32);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = watchManager27.triggerWatch("", eventType30, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList33, watcherOrBitSet35);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet37 = watchManager23.triggerWatch("", eventType25, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList33);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet38 = watchManager5.triggerWatch("", eventType21, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList33);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = watchManager0.triggerWatch("0 connections watching 0 paths\nTotal watches:0", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList33);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNotNull(watchesSummary28);
        org.junit.Assert.assertNotNull(aCLArray32);
        org.junit.Assert.assertArrayEquals(aCLArray32, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertNull(watcherOrBitSet36);
        org.junit.Assert.assertNull(watcherOrBitSet37);
        org.junit.Assert.assertNull(watcherOrBitSet38);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("hi!", watcher11);
        watchManager0.shutdown();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport14 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because the return value of \"java.util.Map$Entry.getKey()\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport5 = watchManager0.getWatchesByPath();
        java.lang.String str6 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesPathReport5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str6, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary15 = watchManager0.getWatchesSummary();
        int int16 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesSummary15);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 0 + "'", int16 == 0);
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("hi!", watcher11);
        watchManager0.shutdown();
        java.lang.Class<?> wildcardClass14 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertNotNull(wildcardClass14);
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher3, watcherMode4);
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager0.triggerWatch("0 connections watching 0 paths\nTotal watches:0", eventType7, 1L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean6 = watchManager0.addWatch("", watcher4, watcherMode5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("", watcher3);
        java.lang.Class<?> wildcardClass5 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary15 = watchManager0.getWatchesSummary();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType18 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager20 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary21 = watchManager20.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType23 = null;
        org.apache.zookeeper.data.ACL[] aCLArray25 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList26 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean27 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList26, aCLArray25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager20.triggerWatch("", eventType23, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26, watcherOrBitSet28);
        org.apache.zookeeper.Watcher watcher31 = null;
        boolean boolean32 = watchManager20.containsWatcher("hi!", watcher31);
        org.apache.zookeeper.Watcher.Event.EventType eventType34 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager36 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType38 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager40 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary41 = watchManager40.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType43 = null;
        org.apache.zookeeper.data.ACL[] aCLArray45 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList46 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean47 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList46, aCLArray45);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet48 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet49 = watchManager40.triggerWatch("", eventType43, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList46, watcherOrBitSet48);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet50 = watchManager36.triggerWatch("", eventType38, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList46);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet51 = watchManager20.triggerWatch("", eventType34, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList46);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet52 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet53 = watchManager0.triggerWatch("hi!", eventType18, (long) (short) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList46, watcherOrBitSet52);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesSummary15);
        org.junit.Assert.assertNotNull(watchesSummary21);
        org.junit.Assert.assertNotNull(aCLArray25);
        org.junit.Assert.assertArrayEquals(aCLArray25, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNull(watcherOrBitSet29);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNotNull(watchesSummary41);
        org.junit.Assert.assertNotNull(aCLArray45);
        org.junit.Assert.assertArrayEquals(aCLArray45, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + false + "'", boolean47 == false);
        org.junit.Assert.assertNull(watcherOrBitSet49);
        org.junit.Assert.assertNull(watcherOrBitSet50);
        org.junit.Assert.assertNull(watcherOrBitSet51);
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean6 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher4, watcherMode5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher14 = null;
        watchManager0.removeWatcher(watcher14);
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean19 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher17, watcherMode18);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("", watcher3);
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap5 = watchManager0.getWatch2Paths();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(watcherMap5);
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager22 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary23 = watchManager22.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.data.ACL[] aCLArray27 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList28 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean29 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList28, aCLArray27);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager22.triggerWatch("", eventType25, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28, watcherOrBitSet30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager18.triggerWatch("", eventType20, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager0.triggerWatch("", eventType16, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        java.lang.Class<?> wildcardClass34 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesSummary23);
        org.junit.Assert.assertNotNull(aCLArray27);
        org.junit.Assert.assertArrayEquals(aCLArray27, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNull(watcherOrBitSet32);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertNotNull(wildcardClass34);
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        int int15 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport16 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        boolean boolean20 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher18, watcherMode19);
        org.apache.zookeeper.Watcher watcher22 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode23 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean24 = watchManager0.addWatch("", watcher22, watcherMode23);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNotNull(watchesReport16);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("hi!", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean13 = watchManager0.addWatch("hi!", watcher11, watcherMode12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap3 = watchManager0.getWatch2Paths();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport4 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean8 = watchManager0.addWatch("hi!", watcher6, watcherMode7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(watcherMap3);
        org.junit.Assert.assertNotNull(watchesReport4);
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("hi!", watcher11);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport13 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because the return value of \"java.util.Map$Entry.getKey()\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary13 = watchManager0.getWatchesSummary();
        java.lang.Class<?> wildcardClass14 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesSummary13);
        org.junit.Assert.assertNotNull(wildcardClass14);
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Class<?> wildcardClass15 = watcherOrBitSet14.getClass();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport3 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport4 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(watchesPathReport3);
        org.junit.Assert.assertNotNull(watchesPathReport4);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager16 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType18 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager20 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary21 = watchManager20.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType23 = null;
        org.apache.zookeeper.data.ACL[] aCLArray25 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList26 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean27 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList26, aCLArray25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager20.triggerWatch("", eventType23, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26, watcherOrBitSet28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = watchManager16.triggerWatch("", eventType18, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager0.triggerWatch("", eventType14, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26);
        java.io.PrintWriter printWriter32 = null;
        watchManager0.dumpWatches(printWriter32, false);
        org.apache.zookeeper.Watcher.Event.EventType eventType36 = null;
        org.apache.zookeeper.data.ACL[] aCLArray38 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList39 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean40 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList39, aCLArray38);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager0.triggerWatch("1 connections watching 1 paths\nTotal watches:1", eventType36, (long) (byte) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesSummary21);
        org.junit.Assert.assertNotNull(aCLArray25);
        org.junit.Assert.assertArrayEquals(aCLArray25, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNull(watcherOrBitSet29);
        org.junit.Assert.assertNull(watcherOrBitSet30);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNotNull(aCLArray38);
        org.junit.Assert.assertArrayEquals(aCLArray38, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean13 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher11, watcherMode12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.containsWatcher("", watcher18);
        org.apache.zookeeper.Watcher watcher21 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode22 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean23 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher21, watcherMode22);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        int int15 = watchManager0.getRecursiveWatchQty();
        java.lang.String str16 = watchManager0.toString();
        watchManager0.shutdown();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str16, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test035");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        java.lang.Class<?> wildcardClass5 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap3 = watchManager0.getWatch2Paths();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport4 = watchManager0.getWatches();
        watchManager0.shutdown();
        int int6 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher.Event.EventType eventType8 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager10 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary11 = watchManager10.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType13 = null;
        org.apache.zookeeper.data.ACL[] aCLArray15 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList16 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean17 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList16, aCLArray15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager10.triggerWatch("", eventType13, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList16, watcherOrBitSet18);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("1 connections watching 1 paths\nTotal watches:1", eventType8, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList16);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(watcherMap3);
        org.junit.Assert.assertNotNull(watchesReport4);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertNotNull(watchesSummary11);
        org.junit.Assert.assertNotNull(aCLArray15);
        org.junit.Assert.assertArrayEquals(aCLArray15, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNull(watcherOrBitSet19);
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        boolean boolean6 = watchManager0.containsWatcher("hi!", watcher4, watcherMode5);
        org.apache.zookeeper.Watcher.Event.EventType eventType8 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager10 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager10.shutdown();
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager10.containsWatcher("", watcher13);
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary19 = watchManager18.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType21 = null;
        org.apache.zookeeper.data.ACL[] aCLArray23 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList24 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean25 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList24, aCLArray23);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = watchManager18.triggerWatch("", eventType21, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList24, watcherOrBitSet26);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager10.triggerWatch("", eventType16, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList24, watcherOrBitSet28);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = watchManager0.triggerWatch("hi!", eventType8, (-1L), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList24);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(watchesSummary19);
        org.junit.Assert.assertNotNull(aCLArray23);
        org.junit.Assert.assertArrayEquals(aCLArray23, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNull(watcherOrBitSet27);
        org.junit.Assert.assertNull(watcherOrBitSet29);
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("hi!", watcher11);
        java.io.PrintWriter printWriter13 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter13, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.println(String)\" because \"pwriter\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode15 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean16 = watchManager0.addWatch("hi!", watcher14, watcherMode15);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("hi!", watcher10);
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
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("hi!", watcher11);
        watchManager0.shutdown();
        java.lang.String str14 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.containsWatcher("", watcher16);
        java.lang.Class<?> wildcardClass18 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str14, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNotNull(wildcardClass18);
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("", watcher6, watcherMode7);
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap9 = watchManager0.getWatch2Paths();
        int int10 = watchManager0.size();
        int int11 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher13 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode14 = null;
        boolean boolean15 = watchManager0.removeWatcher("", watcher13, watcherMode14);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watcherMap9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.Watcher watcher22 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode23 = null;
        boolean boolean24 = watchManager0.containsWatcher("", watcher22, watcherMode23);
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary26 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNotNull(watchesSummary26);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        boolean boolean6 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher4, watcherMode5);
        org.apache.zookeeper.Watcher.Event.EventType eventType8 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager10 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager14 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary15 = watchManager14.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType17 = null;
        org.apache.zookeeper.data.ACL[] aCLArray19 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList20 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean21 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList20, aCLArray19);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet23 = watchManager14.triggerWatch("", eventType17, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20, watcherOrBitSet22);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = watchManager10.triggerWatch("", eventType12, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager0.triggerWatch("hi!", eventType8, (long) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20, watcherOrBitSet25);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(watchesSummary15);
        org.junit.Assert.assertNotNull(aCLArray19);
        org.junit.Assert.assertArrayEquals(aCLArray19, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNull(watcherOrBitSet23);
        org.junit.Assert.assertNull(watcherOrBitSet24);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("hi!", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.addWatch("", watcher14);
        int int16 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean20 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher18, watcherMode19);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 2 + "'", int16 == 2);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        int int15 = watchManager0.getRecursiveWatchQty();
        java.lang.String str16 = watchManager0.toString();
        java.io.PrintWriter printWriter17 = null;
        watchManager0.dumpWatches(printWriter17, false);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str16, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.Watcher.Event.EventType eventType18 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager20 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary25 = watchManager24.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.data.ACL[] aCLArray29 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList30 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList30, aCLArray29);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager24.triggerWatch("", eventType27, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30, watcherOrBitSet32);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager20.triggerWatch("", eventType22, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = watchManager0.triggerWatch("", eventType18, (long) (byte) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30, watcherOrBitSet35);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Class<?> wildcardClass37 = watcherOrBitSet36.getClass();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesSummary25);
        org.junit.Assert.assertNotNull(aCLArray29);
        org.junit.Assert.assertArrayEquals(aCLArray29, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertNull(watcherOrBitSet34);
        org.junit.Assert.assertNull(watcherOrBitSet36);
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.size();
        java.lang.Class<?> wildcardClass3 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        java.lang.Class<?> wildcardClass5 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher3, watcherMode4);
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap6 = watchManager0.getWatch2Paths();
        org.apache.zookeeper.Watcher.Event.EventType eventType8 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager10 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager14 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary15 = watchManager14.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType17 = null;
        org.apache.zookeeper.data.ACL[] aCLArray19 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList20 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean21 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList20, aCLArray19);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet23 = watchManager14.triggerWatch("", eventType17, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20, watcherOrBitSet22);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = watchManager10.triggerWatch("", eventType12, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20);
        org.apache.zookeeper.Watcher watcher25 = null;
        watchManager10.removeWatcher(watcher25);
        org.apache.zookeeper.Watcher.Event.EventType eventType28 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager30 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType32 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager34 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary35 = watchManager34.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType37 = null;
        org.apache.zookeeper.data.ACL[] aCLArray39 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList40 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean41 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList40, aCLArray39);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager34.triggerWatch("", eventType37, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList40, watcherOrBitSet42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager30.triggerWatch("", eventType32, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = watchManager10.triggerWatch("", eventType28, (long) (byte) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList40, watcherOrBitSet45);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet47 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet48 = watchManager0.triggerWatch("0 connections watching 0 paths\nTotal watches:0", eventType8, (long) (byte) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList40, watcherOrBitSet47);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(watcherMap6);
        org.junit.Assert.assertNotNull(watchesSummary15);
        org.junit.Assert.assertNotNull(aCLArray19);
        org.junit.Assert.assertArrayEquals(aCLArray19, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNull(watcherOrBitSet23);
        org.junit.Assert.assertNull(watcherOrBitSet24);
        org.junit.Assert.assertNotNull(watchesSummary35);
        org.junit.Assert.assertNotNull(aCLArray39);
        org.junit.Assert.assertArrayEquals(aCLArray39, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertNull(watcherOrBitSet43);
        org.junit.Assert.assertNull(watcherOrBitSet44);
        org.junit.Assert.assertNull(watcherOrBitSet46);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        int int2 = watchManager0.getRecursiveWatchQty();
        java.lang.String str3 = watchManager0.toString();
        org.apache.zookeeper.Watcher.Event.EventType eventType5 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager7 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager7.shutdown();
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager7.containsWatcher("", watcher10);
        org.apache.zookeeper.Watcher.Event.EventType eventType13 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager15 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary16 = watchManager15.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType18 = null;
        org.apache.zookeeper.data.ACL[] aCLArray20 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList21 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean22 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList21, aCLArray20);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet23 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = watchManager15.triggerWatch("", eventType18, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList21, watcherOrBitSet23);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager7.triggerWatch("", eventType13, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList21, watcherOrBitSet25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet27 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = watchManager0.triggerWatch("0 connections watching 0 paths\nTotal watches:0", eventType5, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList21, watcherOrBitSet27);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str3, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesSummary16);
        org.junit.Assert.assertNotNull(aCLArray20);
        org.junit.Assert.assertArrayEquals(aCLArray20, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNull(watcherOrBitSet24);
        org.junit.Assert.assertNull(watcherOrBitSet26);
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary15 = watchManager0.getWatchesSummary();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport17 = watchManager0.getWatches();
        java.lang.Class<?> wildcardClass18 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesSummary15);
        org.junit.Assert.assertNotNull(watchesReport17);
        org.junit.Assert.assertNotNull(wildcardClass18);
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport17 = watchManager0.getWatchesByPath();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap18 = watchManager0.getWatch2Paths();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesPathReport17);
        org.junit.Assert.assertNotNull(watcherMap18);
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap15 = watchManager0.getWatch2Paths();
        java.lang.Class<?> wildcardClass16 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watcherMap15);
        org.junit.Assert.assertNotNull(wildcardClass16);
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport17 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.removeWatcher("", watcher19);
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType26 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager28 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary29 = watchManager28.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType31 = null;
        org.apache.zookeeper.data.ACL[] aCLArray33 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList34 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean35 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList34, aCLArray33);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet37 = watchManager28.triggerWatch("", eventType31, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList34, watcherOrBitSet36);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet38 = watchManager24.triggerWatch("", eventType26, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList34);
        org.apache.zookeeper.Watcher watcher39 = null;
        watchManager24.removeWatcher(watcher39);
        org.apache.zookeeper.Watcher.Event.EventType eventType42 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager44 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType46 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager48 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary49 = watchManager48.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType51 = null;
        org.apache.zookeeper.data.ACL[] aCLArray53 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList54 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean55 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList54, aCLArray53);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet56 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet57 = watchManager48.triggerWatch("", eventType51, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList54, watcherOrBitSet56);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet58 = watchManager44.triggerWatch("", eventType46, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList54);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet59 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet60 = watchManager24.triggerWatch("", eventType42, (long) (byte) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList54, watcherOrBitSet59);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet61 = watchManager0.triggerWatch("hi!", eventType22, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList54);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesPathReport17);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(watchesSummary29);
        org.junit.Assert.assertNotNull(aCLArray33);
        org.junit.Assert.assertArrayEquals(aCLArray33, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertNull(watcherOrBitSet37);
        org.junit.Assert.assertNull(watcherOrBitSet38);
        org.junit.Assert.assertNotNull(watchesSummary49);
        org.junit.Assert.assertNotNull(aCLArray53);
        org.junit.Assert.assertArrayEquals(aCLArray53, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean55 + "' != '" + false + "'", boolean55 == false);
        org.junit.Assert.assertNull(watcherOrBitSet57);
        org.junit.Assert.assertNull(watcherOrBitSet58);
        org.junit.Assert.assertNull(watcherOrBitSet60);
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport6 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher.Event.EventType eventType8 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager10 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager14 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary15 = watchManager14.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType17 = null;
        org.apache.zookeeper.data.ACL[] aCLArray19 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList20 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean21 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList20, aCLArray19);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet23 = watchManager14.triggerWatch("", eventType17, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20, watcherOrBitSet22);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = watchManager10.triggerWatch("", eventType12, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20);
        org.apache.zookeeper.Watcher.Event.EventType eventType26 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager28 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType30 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager32 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary33 = watchManager32.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.data.ACL[] aCLArray37 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList38 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean39 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList38, aCLArray37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager32.triggerWatch("", eventType35, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager28.triggerWatch("", eventType30, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager10.triggerWatch("", eventType26, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = watchManager0.triggerWatch("1 connections watching 1 paths\nTotal watches:1", eventType8, (long) (byte) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet44);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(watchesPathReport6);
        org.junit.Assert.assertNotNull(watchesSummary15);
        org.junit.Assert.assertNotNull(aCLArray19);
        org.junit.Assert.assertArrayEquals(aCLArray19, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNull(watcherOrBitSet23);
        org.junit.Assert.assertNull(watcherOrBitSet24);
        org.junit.Assert.assertNotNull(watchesSummary33);
        org.junit.Assert.assertNotNull(aCLArray37);
        org.junit.Assert.assertArrayEquals(aCLArray37, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNull(watcherOrBitSet41);
        org.junit.Assert.assertNull(watcherOrBitSet42);
        org.junit.Assert.assertNull(watcherOrBitSet43);
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        watchManager0.shutdown();
        java.lang.Class<?> wildcardClass6 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher3, watcherMode4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("hi!", watcher7, watcherMode8);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport10 = watchManager0.getWatches();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesReport10);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        watchManager0.shutdown();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap14 = watchManager0.getWatch2Paths();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watcherMap14);
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher6, watcherMode7);
        java.io.PrintWriter printWriter9 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter9, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.print(String)\" because \"pwriter\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher3, watcherMode4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("hi!", watcher7, watcherMode8);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport10 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher12 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode13 = null;
        boolean boolean14 = watchManager0.containsWatcher("1 connections watching 1 paths\nTotal watches:1", watcher12, watcherMode13);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesPathReport10);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.Watcher watcher22 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode23 = null;
        boolean boolean24 = watchManager0.containsWatcher("", watcher22, watcherMode23);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher27 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode28 = null;
        boolean boolean29 = watchManager0.removeWatcher("hi!", watcher27, watcherMode28);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        int int15 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.containsWatcher("", watcher17);
        java.lang.String str19 = watchManager0.toString();
        int int20 = watchManager0.getRecursiveWatchQty();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str19, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager22 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary23 = watchManager22.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.data.ACL[] aCLArray27 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList28 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean29 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList28, aCLArray27);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager22.triggerWatch("", eventType25, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28, watcherOrBitSet30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager18.triggerWatch("", eventType20, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager0.triggerWatch("", eventType16, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport34 = watchManager0.getWatches();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesSummary23);
        org.junit.Assert.assertNotNull(aCLArray27);
        org.junit.Assert.assertArrayEquals(aCLArray27, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNull(watcherOrBitSet32);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertNotNull(watchesReport34);
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.Watcher.Event.EventType eventType18 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager20 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary25 = watchManager24.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.data.ACL[] aCLArray29 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList30 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList30, aCLArray29);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager24.triggerWatch("", eventType27, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30, watcherOrBitSet32);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager20.triggerWatch("", eventType22, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = watchManager0.triggerWatch("", eventType18, (long) (byte) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30, watcherOrBitSet35);
        org.apache.zookeeper.Watcher watcher38 = null;
        boolean boolean39 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher38);
        org.apache.zookeeper.Watcher.Event.EventType eventType41 = null;
        org.apache.zookeeper.data.ACL[] aCLArray43 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList44 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean45 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList44, aCLArray43);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet47 = watchManager0.triggerWatch("hi!", eventType41, (long) 2, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList44, watcherOrBitSet46);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesSummary25);
        org.junit.Assert.assertNotNull(aCLArray29);
        org.junit.Assert.assertArrayEquals(aCLArray29, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertNull(watcherOrBitSet34);
        org.junit.Assert.assertNull(watcherOrBitSet36);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + true + "'", boolean39 == true);
        org.junit.Assert.assertNotNull(aCLArray43);
        org.junit.Assert.assertArrayEquals(aCLArray43, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("", watcher10);
        org.apache.zookeeper.Watcher watcher13 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode14 = null;
        boolean boolean15 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher13, watcherMode14);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher14);
        org.apache.zookeeper.Watcher.Event.EventType eventType17 = null;
        org.apache.zookeeper.data.ACL[] aCLArray19 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList20 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean21 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList20, aCLArray19);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet23 = watchManager0.triggerWatch("hi!", eventType17, (long) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList20, watcherOrBitSet22);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(aCLArray19);
        org.junit.Assert.assertArrayEquals(aCLArray19, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap15 = watchManager0.getWatch2Paths();
        java.lang.Class<?> wildcardClass16 = watcherMap15.getClass();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watcherMap15);
        org.junit.Assert.assertNotNull(wildcardClass16);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport3 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher.Event.EventType eventType5 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager7 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType9 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager11 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary12 = watchManager11.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager11.triggerWatch("", eventType14, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet19);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet21 = watchManager7.triggerWatch("", eventType9, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17);
        org.apache.zookeeper.Watcher watcher22 = null;
        watchManager7.removeWatcher(watcher22);
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager27 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType29 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager31 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary32 = watchManager31.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType34 = null;
        org.apache.zookeeper.data.ACL[] aCLArray36 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList37 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean38 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList37, aCLArray36);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = watchManager31.triggerWatch("", eventType34, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37, watcherOrBitSet39);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager27.triggerWatch("", eventType29, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager7.triggerWatch("", eventType25, (long) (byte) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37, watcherOrBitSet42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = watchManager0.triggerWatch("1 connections watching 1 paths\nTotal watches:1", eventType5, (long) '#', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37, watcherOrBitSet44);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(watchesPathReport3);
        org.junit.Assert.assertNotNull(watchesSummary12);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNull(watcherOrBitSet21);
        org.junit.Assert.assertNotNull(watchesSummary32);
        org.junit.Assert.assertNotNull(aCLArray36);
        org.junit.Assert.assertArrayEquals(aCLArray36, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertNull(watcherOrBitSet40);
        org.junit.Assert.assertNull(watcherOrBitSet41);
        org.junit.Assert.assertNull(watcherOrBitSet43);
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        java.lang.String str14 = watchManager0.toString();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.removeWatcher("hi!", watcher17);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str14, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("hi!", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.addWatch("", watcher14);
        int int16 = watchManager0.size();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport17 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 2 + "'", int16 == 2);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager22 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary23 = watchManager22.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.data.ACL[] aCLArray27 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList28 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean29 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList28, aCLArray27);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager22.triggerWatch("", eventType25, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28, watcherOrBitSet30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager18.triggerWatch("", eventType20, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager0.triggerWatch("", eventType16, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        int int34 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport35 = watchManager0.getWatches();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher.Event.EventType eventType38 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager40 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager40.shutdown();
        org.apache.zookeeper.Watcher watcher43 = null;
        boolean boolean44 = watchManager40.containsWatcher("", watcher43);
        org.apache.zookeeper.Watcher.Event.EventType eventType46 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager48 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary49 = watchManager48.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType51 = null;
        org.apache.zookeeper.data.ACL[] aCLArray53 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList54 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean55 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList54, aCLArray53);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet56 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet57 = watchManager48.triggerWatch("", eventType51, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList54, watcherOrBitSet56);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet58 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet59 = watchManager40.triggerWatch("", eventType46, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList54, watcherOrBitSet58);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet60 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet61 = watchManager0.triggerWatch("0 connections watching 0 paths\nTotal watches:0", eventType38, 10L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList54, watcherOrBitSet60);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesSummary23);
        org.junit.Assert.assertNotNull(aCLArray27);
        org.junit.Assert.assertArrayEquals(aCLArray27, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNull(watcherOrBitSet32);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertTrue("'" + int34 + "' != '" + 0 + "'", int34 == 0);
        org.junit.Assert.assertNotNull(watchesReport35);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertNotNull(watchesSummary49);
        org.junit.Assert.assertNotNull(aCLArray53);
        org.junit.Assert.assertArrayEquals(aCLArray53, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean55 + "' != '" + false + "'", boolean55 == false);
        org.junit.Assert.assertNull(watcherOrBitSet57);
        org.junit.Assert.assertNull(watcherOrBitSet59);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.containsWatcher("", watcher18);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport20 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager24.shutdown();
        org.apache.zookeeper.Watcher watcher27 = null;
        boolean boolean28 = watchManager24.containsWatcher("", watcher27);
        org.apache.zookeeper.Watcher.Event.EventType eventType30 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager32 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary33 = watchManager32.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.data.ACL[] aCLArray37 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList38 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean39 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList38, aCLArray37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager32.triggerWatch("", eventType35, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager24.triggerWatch("", eventType30, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet42);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager0.triggerWatch("1 connections watching 1 paths\nTotal watches:1", eventType22, (long) (short) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(watchesPathReport20);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertNotNull(watchesSummary33);
        org.junit.Assert.assertNotNull(aCLArray37);
        org.junit.Assert.assertArrayEquals(aCLArray37, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNull(watcherOrBitSet41);
        org.junit.Assert.assertNull(watcherOrBitSet43);
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("hi!", watcher11);
        watchManager0.shutdown();
        java.io.PrintWriter printWriter14 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter14, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.println(String)\" because \"pwriter\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("", watcher6, watcherMode7);
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap9 = watchManager0.getWatch2Paths();
        int int10 = watchManager0.size();
        int int11 = watchManager0.size();
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watcherMap9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter14 = null;
        watchManager0.dumpWatches(printWriter14, true);
        org.apache.zookeeper.Watcher watcher17 = null;
        watchManager0.removeWatcher(watcher17);
        watchManager0.shutdown();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        int int15 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.containsWatcher("", watcher17);
        org.apache.zookeeper.Watcher watcher19 = null;
        watchManager0.removeWatcher(watcher19);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        boolean boolean6 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher4, watcherMode5);
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("hi!", watcher11, watcherMode12);
        java.lang.Class<?> wildcardClass14 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(wildcardClass14);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport2 = watchManager0.getWatches();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesReport2);
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.containsWatcher("", watcher18);
        org.apache.zookeeper.Watcher watcher21 = null;
        boolean boolean22 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher21);
        int int23 = watchManager0.getRecursiveWatchQty();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + 0 + "'", int23 == 0);
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        int int21 = watchManager0.getRecursiveWatchQty();
        int int22 = watchManager0.getRecursiveWatchQty();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 0 + "'", int22 == 0);
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("", watcher6, watcherMode7);
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap9 = watchManager0.getWatch2Paths();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap10 = watchManager0.getWatch2Paths();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watcherMap9);
        org.junit.Assert.assertNotNull(watcherMap10);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport3 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher5 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode6 = null;
        boolean boolean7 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher5, watcherMode6);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(watchesPathReport3);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        boolean boolean6 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher4, watcherMode5);
        java.io.PrintWriter printWriter7 = null;
        watchManager0.dumpWatches(printWriter7, false);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.Watcher watcher22 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode23 = null;
        boolean boolean24 = watchManager0.containsWatcher("", watcher22, watcherMode23);
        org.apache.zookeeper.Watcher.Event.EventType eventType26 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager28 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary29 = watchManager28.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType31 = null;
        org.apache.zookeeper.data.ACL[] aCLArray33 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList34 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean35 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList34, aCLArray33);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet37 = watchManager28.triggerWatch("", eventType31, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList34, watcherOrBitSet36);
        org.apache.zookeeper.Watcher watcher39 = null;
        boolean boolean40 = watchManager28.containsWatcher("hi!", watcher39);
        org.apache.zookeeper.Watcher.Event.EventType eventType42 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager44 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType46 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager48 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary49 = watchManager48.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType51 = null;
        org.apache.zookeeper.data.ACL[] aCLArray53 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList54 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean55 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList54, aCLArray53);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet56 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet57 = watchManager48.triggerWatch("", eventType51, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList54, watcherOrBitSet56);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet58 = watchManager44.triggerWatch("", eventType46, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList54);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet59 = watchManager28.triggerWatch("", eventType42, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList54);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet60 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet61 = watchManager0.triggerWatch("", eventType26, (long) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList54, watcherOrBitSet60);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport62 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNotNull(watchesSummary29);
        org.junit.Assert.assertNotNull(aCLArray33);
        org.junit.Assert.assertArrayEquals(aCLArray33, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertNull(watcherOrBitSet37);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertNotNull(watchesSummary49);
        org.junit.Assert.assertNotNull(aCLArray53);
        org.junit.Assert.assertArrayEquals(aCLArray53, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean55 + "' != '" + false + "'", boolean55 == false);
        org.junit.Assert.assertNull(watcherOrBitSet57);
        org.junit.Assert.assertNull(watcherOrBitSet58);
        org.junit.Assert.assertNull(watcherOrBitSet59);
        org.junit.Assert.assertNull(watcherOrBitSet61);
        org.junit.Assert.assertNotNull(watchesPathReport62);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary21 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher23 = null;
        boolean boolean24 = watchManager0.containsWatcher("hi!", watcher23);
        org.apache.zookeeper.Watcher watcher26 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode27 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean28 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher26, watcherMode27);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNotNull(watchesSummary21);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap10 = watchManager0.getWatch2Paths();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport11 = watchManager0.getWatches();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertNotNull(watcherMap10);
        org.junit.Assert.assertNotNull(watchesReport11);
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter14 = null;
        watchManager0.dumpWatches(printWriter14, true);
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.removeWatcher("hi!", watcher18);
        org.apache.zookeeper.Watcher watcher20 = null;
        watchManager0.removeWatcher(watcher20);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport17 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.removeWatcher("", watcher19);
        java.lang.String str21 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher23 = null;
        boolean boolean24 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher23);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesPathReport17);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str21, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport17 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.removeWatcher("", watcher19);
        org.apache.zookeeper.Watcher watcher22 = null;
        boolean boolean23 = watchManager0.containsWatcher("hi!", watcher22);
        org.apache.zookeeper.Watcher watcher25 = null;
        boolean boolean26 = watchManager0.containsWatcher("1 connections watching 1 paths\nTotal watches:1", watcher25);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesPathReport17);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("hi!", watcher2);
        int int4 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean8 = watchManager0.addWatch("", watcher6, watcherMode7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("hi!", watcher2);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary4 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(watchesSummary4);
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("hi!", watcher11);
        watchManager0.shutdown();
        java.lang.String str14 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        boolean boolean18 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher16, watcherMode17);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str14, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean12 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher10, watcherMode11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager22 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary23 = watchManager22.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.data.ACL[] aCLArray27 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList28 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean29 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList28, aCLArray27);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager22.triggerWatch("", eventType25, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28, watcherOrBitSet30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager18.triggerWatch("", eventType20, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager0.triggerWatch("", eventType16, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        int int34 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport35 = watchManager0.getWatches();
        watchManager0.shutdown();
        java.lang.Class<?> wildcardClass37 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesSummary23);
        org.junit.Assert.assertNotNull(aCLArray27);
        org.junit.Assert.assertArrayEquals(aCLArray27, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNull(watcherOrBitSet32);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertTrue("'" + int34 + "' != '" + 0 + "'", int34 == 0);
        org.junit.Assert.assertNotNull(watchesReport35);
        org.junit.Assert.assertNotNull(wildcardClass37);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport3 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport4 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport5 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary13 = watchManager12.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager17 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType19 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager21 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary22 = watchManager21.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.data.ACL[] aCLArray26 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList27 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean28 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList27, aCLArray26);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = watchManager21.triggerWatch("", eventType24, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList27, watcherOrBitSet29);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager17.triggerWatch("", eventType19, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList27);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager12.triggerWatch("", eventType15, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList27);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager0.triggerWatch("hi!", eventType10, (long) '4', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList27, watcherOrBitSet33);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(watchesPathReport3);
        org.junit.Assert.assertNotNull(watchesReport4);
        org.junit.Assert.assertNotNull(watchesReport5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesSummary13);
        org.junit.Assert.assertNotNull(watchesSummary22);
        org.junit.Assert.assertNotNull(aCLArray26);
        org.junit.Assert.assertArrayEquals(aCLArray26, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertNull(watcherOrBitSet30);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNull(watcherOrBitSet32);
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport3 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.removeWatcher("hi!", watcher5);
        java.io.PrintWriter printWriter7 = null;
        watchManager0.dumpWatches(printWriter7, false);
        org.apache.zookeeper.Watcher watcher10 = null;
        watchManager0.removeWatcher(watcher10);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(watchesPathReport3);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager16 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType18 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager20 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary21 = watchManager20.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType23 = null;
        org.apache.zookeeper.data.ACL[] aCLArray25 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList26 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean27 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList26, aCLArray25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager20.triggerWatch("", eventType23, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26, watcherOrBitSet28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = watchManager16.triggerWatch("", eventType18, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager0.triggerWatch("", eventType14, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26);
        java.lang.String str32 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher34 = null;
        boolean boolean35 = watchManager0.containsWatcher("", watcher34);
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap36 = watchManager0.getWatch2Paths();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesSummary21);
        org.junit.Assert.assertNotNull(aCLArray25);
        org.junit.Assert.assertArrayEquals(aCLArray25, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNull(watcherOrBitSet29);
        org.junit.Assert.assertNull(watcherOrBitSet30);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str32, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertNotNull(watcherMap36);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("hi!", watcher11);
        org.apache.zookeeper.Watcher watcher14 = null;
        boolean boolean15 = watchManager0.addWatch("", watcher14);
        int int16 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary17 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 2 + "'", int16 == 2);
        org.junit.Assert.assertNotNull(watchesSummary17);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("", watcher6, watcherMode7);
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap9 = watchManager0.getWatch2Paths();
        int int10 = watchManager0.size();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap11 = watchManager0.getWatch2Paths();
        int int12 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watcherMap9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertNotNull(watcherMap11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("hi!", watcher7, watcherMode8);
        java.lang.String str10 = watchManager0.toString();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str10, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.Watcher watcher22 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode23 = null;
        boolean boolean24 = watchManager0.containsWatcher("", watcher22, watcherMode23);
        int int25 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher27 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode28 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean29 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher27, watcherMode28);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + int25 + "' != '" + 0 + "'", int25 == 0);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher3, watcherMode4);
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap6 = watchManager0.getWatch2Paths();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.containsWatcher("hi!", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.removeWatcher("hi!", watcher11, watcherMode12);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(watcherMap6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher3, watcherMode4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("hi!", watcher7, watcherMode8);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport10 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher12 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode13 = null;
        boolean boolean14 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher12, watcherMode13);
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap15 = watchManager0.getWatch2Paths();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesPathReport10);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(watcherMap15);
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.containsWatcher("", watcher18);
        org.apache.zookeeper.Watcher watcher20 = null;
        watchManager0.removeWatcher(watcher20);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport17 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.removeWatcher("", watcher19);
        org.apache.zookeeper.Watcher watcher22 = null;
        boolean boolean23 = watchManager0.containsWatcher("hi!", watcher22);
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager27 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType29 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager31 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary32 = watchManager31.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType34 = null;
        org.apache.zookeeper.data.ACL[] aCLArray36 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList37 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean38 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList37, aCLArray36);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = watchManager31.triggerWatch("", eventType34, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37, watcherOrBitSet39);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager27.triggerWatch("", eventType29, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager0.triggerWatch("0 connections watching 0 paths\nTotal watches:0", eventType25, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37, watcherOrBitSet42);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesPathReport17);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNotNull(watchesSummary32);
        org.junit.Assert.assertNotNull(aCLArray36);
        org.junit.Assert.assertArrayEquals(aCLArray36, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertNull(watcherOrBitSet40);
        org.junit.Assert.assertNull(watcherOrBitSet41);
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap3 = watchManager0.getWatch2Paths();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport4 = watchManager0.getWatches();
        watchManager0.shutdown();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher8);
        int int10 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(watcherMap3);
        org.junit.Assert.assertNotNull(watchesReport4);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport17 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.removeWatcher("", watcher19);
        java.lang.String str21 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher23 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode24 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean25 = watchManager0.addWatch("hi!", watcher23, watcherMode24);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesPathReport17);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str21, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.Watcher watcher22 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode23 = null;
        boolean boolean24 = watchManager0.containsWatcher("", watcher22, watcherMode23);
        org.apache.zookeeper.Watcher watcher26 = null;
        boolean boolean27 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher26);
        org.apache.zookeeper.Watcher.Event.EventType eventType29 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager31 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary32 = watchManager31.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType34 = null;
        org.apache.zookeeper.data.ACL[] aCLArray36 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList37 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean38 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList37, aCLArray36);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = watchManager31.triggerWatch("", eventType34, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37, watcherOrBitSet39);
        org.apache.zookeeper.Watcher watcher42 = null;
        boolean boolean43 = watchManager31.containsWatcher("hi!", watcher42);
        org.apache.zookeeper.Watcher.Event.EventType eventType45 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager47 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType49 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager51 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary52 = watchManager51.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType54 = null;
        org.apache.zookeeper.data.ACL[] aCLArray56 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList57 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean58 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList57, aCLArray56);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet59 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet60 = watchManager51.triggerWatch("", eventType54, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList57, watcherOrBitSet59);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet61 = watchManager47.triggerWatch("", eventType49, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList57);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet62 = watchManager31.triggerWatch("", eventType45, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList57);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet63 = watchManager0.triggerWatch("", eventType29, (long) (byte) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList57);
        watchManager0.shutdown();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNotNull(watchesSummary32);
        org.junit.Assert.assertNotNull(aCLArray36);
        org.junit.Assert.assertArrayEquals(aCLArray36, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertNull(watcherOrBitSet40);
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
        org.junit.Assert.assertNotNull(watchesSummary52);
        org.junit.Assert.assertNotNull(aCLArray56);
        org.junit.Assert.assertArrayEquals(aCLArray56, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean58 + "' != '" + false + "'", boolean58 == false);
        org.junit.Assert.assertNull(watcherOrBitSet60);
        org.junit.Assert.assertNull(watcherOrBitSet61);
        org.junit.Assert.assertNull(watcherOrBitSet62);
        org.junit.Assert.assertNull(watcherOrBitSet63);
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, true);
        int int8 = watchManager0.getRecursiveWatchQty();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        watchManager0.shutdown();
        int int6 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher3, watcherMode4);
        int int6 = watchManager0.getRecursiveWatchQty();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary21 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher23 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode24 = null;
        boolean boolean25 = watchManager0.removeWatcher("hi!", watcher23, watcherMode24);
        java.io.PrintWriter printWriter26 = null;
        watchManager0.dumpWatches(printWriter26, true);
        org.apache.zookeeper.Watcher watcher29 = null;
        watchManager0.removeWatcher(watcher29);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNotNull(watchesSummary21);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport3 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.removeWatcher("hi!", watcher5);
        java.io.PrintWriter printWriter7 = null;
        watchManager0.dumpWatches(printWriter7, false);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("", watcher11);
        int int13 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean17 = watchManager0.addWatch("hi!", watcher15, watcherMode16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(watchesPathReport3);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("hi!", watcher11);
        watchManager0.shutdown();
        java.lang.String str14 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean18 = watchManager0.addWatch("", watcher16, watcherMode17);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str14, "1 connections watching 1 paths\nTotal watches:1");
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter14 = null;
        watchManager0.dumpWatches(printWriter14, true);
        int int17 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher19 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode20 = null;
        boolean boolean21 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher19, watcherMode20);
        int int22 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher24 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode25 = null;
        boolean boolean26 = watchManager0.containsWatcher("hi!", watcher24, watcherMode25);
        int int27 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 0 + "'", int22 == 0);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + int27 + "' != '" + 0 + "'", int27 == 0);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary25 = watchManager24.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.data.ACL[] aCLArray29 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList30 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList30, aCLArray29);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager24.triggerWatch("", eventType27, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30, watcherOrBitSet32);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager0.triggerWatch("", eventType22, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30);
        java.lang.String str35 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher37 = null;
        boolean boolean38 = watchManager0.addWatch("", watcher37);
        org.apache.zookeeper.Watcher watcher40 = null;
        boolean boolean41 = watchManager0.addWatch("", watcher40);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNotNull(watchesSummary25);
        org.junit.Assert.assertNotNull(aCLArray29);
        org.junit.Assert.assertArrayEquals(aCLArray29, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertNull(watcherOrBitSet34);
        org.junit.Assert.assertEquals("'" + str35 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str35, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + true + "'", boolean38 == true);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.containsWatcher("", watcher18);
        org.apache.zookeeper.Watcher watcher21 = null;
        boolean boolean22 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher21);
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport24 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher26 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode27 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean28 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher26, watcherMode27);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(watchesPathReport24);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        int int15 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport16 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        boolean boolean20 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher18, watcherMode19);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher23 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode24 = null;
        boolean boolean25 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher23, watcherMode24);
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager29 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary30 = watchManager29.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType32 = null;
        org.apache.zookeeper.data.ACL[] aCLArray34 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList35 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean36 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList35, aCLArray34);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet37 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet38 = watchManager29.triggerWatch("", eventType32, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList35, watcherOrBitSet37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = watchManager0.triggerWatch("", eventType27, (long) ' ', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList35, watcherOrBitSet39);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNotNull(watchesReport16);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(watchesSummary30);
        org.junit.Assert.assertNotNull(aCLArray34);
        org.junit.Assert.assertArrayEquals(aCLArray34, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertNull(watcherOrBitSet38);
        org.junit.Assert.assertNull(watcherOrBitSet40);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher12 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode13 = null;
        boolean boolean14 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher12, watcherMode13);
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.addWatch("hi!", watcher16);
        org.apache.zookeeper.Watcher.Event.EventType eventType19 = null;
        java.util.List<org.apache.zookeeper.data.ACL> aCLList21 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = watchManager0.triggerWatch("", eventType19, (long) '#', aCLList21);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertNull(watcherOrBitSet22);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        java.lang.String str14 = watchManager0.toString();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport16 = watchManager0.getWatches();
        java.lang.Class<?> wildcardClass17 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str14, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesReport16);
        org.junit.Assert.assertNotNull(wildcardClass17);
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary15 = watchManager0.getWatchesSummary();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport17 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.containsWatcher("1 connections watching 1 paths\nTotal watches:1", watcher19);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesSummary15);
        org.junit.Assert.assertNotNull(watchesReport17);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary25 = watchManager24.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.data.ACL[] aCLArray29 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList30 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList30, aCLArray29);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager24.triggerWatch("", eventType27, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30, watcherOrBitSet32);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager0.triggerWatch("", eventType22, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30);
        int int35 = watchManager0.getRecursiveWatchQty();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap36 = watchManager0.getWatch2Paths();
        int int37 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNotNull(watchesSummary25);
        org.junit.Assert.assertNotNull(aCLArray29);
        org.junit.Assert.assertArrayEquals(aCLArray29, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertNull(watcherOrBitSet34);
        org.junit.Assert.assertTrue("'" + int35 + "' != '" + 0 + "'", int35 == 0);
        org.junit.Assert.assertNotNull(watcherMap36);
        org.junit.Assert.assertTrue("'" + int37 + "' != '" + 0 + "'", int37 == 0);
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport3 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.removeWatcher("hi!", watcher5);
        java.io.PrintWriter printWriter7 = null;
        watchManager0.dumpWatches(printWriter7, false);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean13 = watchManager0.addWatch("hi!", watcher11, watcherMode12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(watchesPathReport3);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test125");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport17 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.removeWatcher("", watcher19);
        java.lang.String str21 = watchManager0.toString();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher23 = null;
        watchManager0.removeWatcher(watcher23);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesPathReport17);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str21, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test126");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("hi!", watcher11);
        java.lang.String str13 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher15 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode16 = null;
        boolean boolean17 = watchManager0.containsWatcher("", watcher15, watcherMode16);
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.containsWatcher("1 connections watching 1 paths\nTotal watches:1", watcher19);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str13, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test127");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary21 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher23 = null;
        boolean boolean24 = watchManager0.containsWatcher("hi!", watcher23);
        org.apache.zookeeper.Watcher watcher26 = null;
        boolean boolean27 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher26);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNotNull(watchesSummary21);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test128");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        int int15 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher.Event.EventType eventType17 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager19 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary20 = watchManager19.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType26 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager28 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary29 = watchManager28.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType31 = null;
        org.apache.zookeeper.data.ACL[] aCLArray33 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList34 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean35 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList34, aCLArray33);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet37 = watchManager28.triggerWatch("", eventType31, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList34, watcherOrBitSet36);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet38 = watchManager24.triggerWatch("", eventType26, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList34);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = watchManager19.triggerWatch("", eventType22, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList34);
        org.apache.zookeeper.Watcher watcher41 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode42 = null;
        boolean boolean43 = watchManager19.containsWatcher("", watcher41, watcherMode42);
        org.apache.zookeeper.Watcher watcher45 = null;
        boolean boolean46 = watchManager19.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher45);
        org.apache.zookeeper.Watcher.Event.EventType eventType48 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager50 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary51 = watchManager50.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType53 = null;
        org.apache.zookeeper.data.ACL[] aCLArray55 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList56 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean57 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList56, aCLArray55);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet58 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet59 = watchManager50.triggerWatch("", eventType53, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList56, watcherOrBitSet58);
        org.apache.zookeeper.Watcher watcher61 = null;
        boolean boolean62 = watchManager50.containsWatcher("hi!", watcher61);
        org.apache.zookeeper.Watcher.Event.EventType eventType64 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager66 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType68 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager70 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary71 = watchManager70.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType73 = null;
        org.apache.zookeeper.data.ACL[] aCLArray75 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList76 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean77 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList76, aCLArray75);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet78 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet79 = watchManager70.triggerWatch("", eventType73, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList76, watcherOrBitSet78);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet80 = watchManager66.triggerWatch("", eventType68, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList76);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet81 = watchManager50.triggerWatch("", eventType64, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList76);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet82 = watchManager19.triggerWatch("", eventType48, (long) (byte) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList76);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet83 = watchManager0.triggerWatch("hi!", eventType17, (long) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList76);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNotNull(watchesSummary20);
        org.junit.Assert.assertNotNull(watchesSummary29);
        org.junit.Assert.assertNotNull(aCLArray33);
        org.junit.Assert.assertArrayEquals(aCLArray33, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertNull(watcherOrBitSet37);
        org.junit.Assert.assertNull(watcherOrBitSet38);
        org.junit.Assert.assertNull(watcherOrBitSet39);
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
        org.junit.Assert.assertTrue("'" + boolean46 + "' != '" + false + "'", boolean46 == false);
        org.junit.Assert.assertNotNull(watchesSummary51);
        org.junit.Assert.assertNotNull(aCLArray55);
        org.junit.Assert.assertArrayEquals(aCLArray55, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + false + "'", boolean57 == false);
        org.junit.Assert.assertNull(watcherOrBitSet59);
        org.junit.Assert.assertTrue("'" + boolean62 + "' != '" + false + "'", boolean62 == false);
        org.junit.Assert.assertNotNull(watchesSummary71);
        org.junit.Assert.assertNotNull(aCLArray75);
        org.junit.Assert.assertArrayEquals(aCLArray75, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean77 + "' != '" + false + "'", boolean77 == false);
        org.junit.Assert.assertNull(watcherOrBitSet79);
        org.junit.Assert.assertNull(watcherOrBitSet80);
        org.junit.Assert.assertNull(watcherOrBitSet81);
        org.junit.Assert.assertNull(watcherOrBitSet82);
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test129");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.Watcher watcher22 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode23 = null;
        boolean boolean24 = watchManager0.containsWatcher("", watcher22, watcherMode23);
        int int25 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher27 = null;
        boolean boolean28 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher27);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + int25 + "' != '" + 0 + "'", int25 == 0);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test130");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        int int15 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport16 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        boolean boolean20 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher18, watcherMode19);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher22 = null;
        watchManager0.removeWatcher(watcher22);
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.data.ACL[] aCLArray27 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList28 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean29 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList28, aCLArray27);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = watchManager0.triggerWatch("0 connections watching 0 paths\nTotal watches:0", eventType25, (long) (short) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNotNull(watchesReport16);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(aCLArray27);
        org.junit.Assert.assertArrayEquals(aCLArray27, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test131");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        int int21 = watchManager0.getRecursiveWatchQty();
        java.lang.Class<?> wildcardClass22 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
        org.junit.Assert.assertNotNull(wildcardClass22);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test132");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap10 = watchManager0.getWatch2Paths();
        org.apache.zookeeper.Watcher watcher12 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode13 = null;
        boolean boolean14 = watchManager0.removeWatcher("", watcher12, watcherMode13);
        java.io.PrintWriter printWriter15 = null;
        watchManager0.dumpWatches(printWriter15, true);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watcherMap10);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test133");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        int int2 = watchManager0.size();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test134");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("hi!", watcher10);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary12 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(watchesSummary12);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test135");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        boolean boolean6 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher4, watcherMode5);
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher8);
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap10 = watchManager0.getWatch2Paths();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watcherMap10);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test136");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        java.lang.String str14 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean18 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher16, watcherMode17);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str14, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test137");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher3, watcherMode4);
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("", watcher7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary13 = watchManager12.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.data.ACL[] aCLArray17 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList18 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean19 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList18, aCLArray17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet21 = watchManager12.triggerWatch("", eventType15, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList18, watcherOrBitSet20);
        org.apache.zookeeper.Watcher watcher23 = null;
        boolean boolean24 = watchManager12.containsWatcher("hi!", watcher23);
        org.apache.zookeeper.Watcher.Event.EventType eventType26 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager28 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType30 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager32 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary33 = watchManager32.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.data.ACL[] aCLArray37 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList38 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean39 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList38, aCLArray37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager32.triggerWatch("", eventType35, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager28.triggerWatch("", eventType30, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = watchManager12.triggerWatch("", eventType26, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = watchManager0.triggerWatch("0 connections watching 0 paths\nTotal watches:0", eventType10, (long) '4', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet44);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesSummary13);
        org.junit.Assert.assertNotNull(aCLArray17);
        org.junit.Assert.assertArrayEquals(aCLArray17, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNull(watcherOrBitSet21);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNotNull(watchesSummary33);
        org.junit.Assert.assertNotNull(aCLArray37);
        org.junit.Assert.assertArrayEquals(aCLArray37, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNull(watcherOrBitSet41);
        org.junit.Assert.assertNull(watcherOrBitSet42);
        org.junit.Assert.assertNull(watcherOrBitSet43);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test138");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher3, watcherMode4);
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("", watcher7);
        int int9 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.removeWatcher("", watcher11, watcherMode12);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test139");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean10 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher8, watcherMode9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesReport6);
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test140");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport5 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher7);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport9 = watchManager0.getWatches();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesPathReport5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesReport9);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test141");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        int int15 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport16 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        boolean boolean20 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher18, watcherMode19);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher22 = null;
        watchManager0.removeWatcher(watcher22);
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager27 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType29 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager31 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary32 = watchManager31.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType34 = null;
        org.apache.zookeeper.data.ACL[] aCLArray36 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList37 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean38 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList37, aCLArray36);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = watchManager31.triggerWatch("", eventType34, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37, watcherOrBitSet39);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager27.triggerWatch("", eventType29, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37);
        org.apache.zookeeper.Watcher watcher42 = null;
        watchManager27.removeWatcher(watcher42);
        org.apache.zookeeper.Watcher.Event.EventType eventType45 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager47 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType49 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager51 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary52 = watchManager51.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType54 = null;
        org.apache.zookeeper.data.ACL[] aCLArray56 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList57 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean58 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList57, aCLArray56);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet59 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet60 = watchManager51.triggerWatch("", eventType54, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList57, watcherOrBitSet59);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet61 = watchManager47.triggerWatch("", eventType49, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList57);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet62 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet63 = watchManager27.triggerWatch("", eventType45, (long) (byte) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList57, watcherOrBitSet62);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet64 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet65 = watchManager0.triggerWatch("hi!", eventType25, (long) (short) 10, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList57, watcherOrBitSet64);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNotNull(watchesReport16);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(watchesSummary32);
        org.junit.Assert.assertNotNull(aCLArray36);
        org.junit.Assert.assertArrayEquals(aCLArray36, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertNull(watcherOrBitSet40);
        org.junit.Assert.assertNull(watcherOrBitSet41);
        org.junit.Assert.assertNotNull(watchesSummary52);
        org.junit.Assert.assertNotNull(aCLArray56);
        org.junit.Assert.assertArrayEquals(aCLArray56, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean58 + "' != '" + false + "'", boolean58 == false);
        org.junit.Assert.assertNull(watcherOrBitSet60);
        org.junit.Assert.assertNull(watcherOrBitSet61);
        org.junit.Assert.assertNull(watcherOrBitSet63);
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test142");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.containsWatcher("", watcher18);
        org.apache.zookeeper.Watcher watcher21 = null;
        boolean boolean22 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher21);
        org.apache.zookeeper.Watcher watcher24 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode25 = null;
        boolean boolean26 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher24, watcherMode25);
        java.lang.String str27 = watchManager0.toString();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertEquals("'" + str27 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str27, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test143");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.containsWatcher("", watcher18);
        org.apache.zookeeper.Watcher watcher21 = null;
        boolean boolean22 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher21);
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport24 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher26 = null;
        boolean boolean27 = watchManager0.addWatch("hi!", watcher26);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(watchesPathReport24);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + true + "'", boolean27 == true);
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test144");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        boolean boolean6 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher4, watcherMode5);
        java.lang.Class<?> wildcardClass7 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test145");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.removeWatcher("", watcher2);
        org.apache.zookeeper.Watcher watcher4 = null;
        watchManager0.removeWatcher(watcher4);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test146");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.Watcher watcher22 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode23 = null;
        boolean boolean24 = watchManager0.containsWatcher("", watcher22, watcherMode23);
        org.apache.zookeeper.Watcher watcher26 = null;
        boolean boolean27 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher26);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary28 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNotNull(watchesSummary28);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test147");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        watchManager0.shutdown();
        java.lang.String str11 = watchManager0.toString();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str11, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test148");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport17 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher19 = null;
        boolean boolean20 = watchManager0.removeWatcher("", watcher19);
        org.apache.zookeeper.Watcher watcher22 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode23 = null;
        boolean boolean24 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher22, watcherMode23);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesPathReport17);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test149");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        java.lang.String str14 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        boolean boolean18 = watchManager0.containsWatcher("hi!", watcher16, watcherMode17);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str14, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test150");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary21 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher23 = null;
        boolean boolean24 = watchManager0.containsWatcher("hi!", watcher23);
        watchManager0.shutdown();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNotNull(watchesSummary21);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test151");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("", watcher6, watcherMode7);
        int int9 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("", watcher11);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test152");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        boolean boolean7 = watchManager0.removeWatcher("hi!", watcher6);
        java.lang.String str8 = watchManager0.toString();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str8, "1 connections watching 1 paths\nTotal watches:1");
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test153");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport5 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher7);
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager16 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary17 = watchManager16.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType19 = null;
        org.apache.zookeeper.data.ACL[] aCLArray21 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList22 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean23 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList22, aCLArray21);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet24 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = watchManager16.triggerWatch("", eventType19, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22, watcherOrBitSet24);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager12.triggerWatch("", eventType14, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList22);
        org.apache.zookeeper.Watcher watcher27 = null;
        watchManager12.removeWatcher(watcher27);
        org.apache.zookeeper.Watcher.Event.EventType eventType30 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager32 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType34 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager36 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary37 = watchManager36.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType39 = null;
        org.apache.zookeeper.data.ACL[] aCLArray41 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList42 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean43 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList42, aCLArray41);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = watchManager36.triggerWatch("", eventType39, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList42, watcherOrBitSet44);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = watchManager32.triggerWatch("", eventType34, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet47 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet48 = watchManager12.triggerWatch("", eventType30, (long) (byte) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList42, watcherOrBitSet47);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet49 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet50 = watchManager0.triggerWatch("1 connections watching 1 paths\nTotal watches:1", eventType10, (long) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList42, watcherOrBitSet49);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesPathReport5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesSummary17);
        org.junit.Assert.assertNotNull(aCLArray21);
        org.junit.Assert.assertArrayEquals(aCLArray21, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNull(watcherOrBitSet25);
        org.junit.Assert.assertNull(watcherOrBitSet26);
        org.junit.Assert.assertNotNull(watchesSummary37);
        org.junit.Assert.assertNotNull(aCLArray41);
        org.junit.Assert.assertArrayEquals(aCLArray41, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
        org.junit.Assert.assertNull(watcherOrBitSet45);
        org.junit.Assert.assertNull(watcherOrBitSet46);
        org.junit.Assert.assertNull(watcherOrBitSet48);
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test154");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap3 = watchManager0.getWatch2Paths();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary4 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport5 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(watcherMap3);
        org.junit.Assert.assertNotNull(watchesSummary4);
        org.junit.Assert.assertNotNull(watchesPathReport5);
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test155");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager22 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary23 = watchManager22.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.data.ACL[] aCLArray27 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList28 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean29 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList28, aCLArray27);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager22.triggerWatch("", eventType25, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28, watcherOrBitSet30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager18.triggerWatch("", eventType20, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager0.triggerWatch("", eventType16, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        int int34 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport35 = watchManager0.getWatches();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap36 = watchManager0.getWatch2Paths();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesSummary23);
        org.junit.Assert.assertNotNull(aCLArray27);
        org.junit.Assert.assertArrayEquals(aCLArray27, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNull(watcherOrBitSet32);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertTrue("'" + int34 + "' != '" + 0 + "'", int34 == 0);
        org.junit.Assert.assertNotNull(watchesReport35);
        org.junit.Assert.assertNotNull(watcherMap36);
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test156");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager22 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary23 = watchManager22.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.data.ACL[] aCLArray27 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList28 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean29 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList28, aCLArray27);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager22.triggerWatch("", eventType25, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28, watcherOrBitSet30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager18.triggerWatch("", eventType20, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager0.triggerWatch("", eventType16, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        int int34 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport35 = watchManager0.getWatches();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher38 = null;
        boolean boolean39 = watchManager0.removeWatcher("", watcher38);
        java.lang.Class<?> wildcardClass40 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesSummary23);
        org.junit.Assert.assertNotNull(aCLArray27);
        org.junit.Assert.assertArrayEquals(aCLArray27, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNull(watcherOrBitSet32);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertTrue("'" + int34 + "' != '" + 0 + "'", int34 == 0);
        org.junit.Assert.assertNotNull(watchesReport35);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNotNull(wildcardClass40);
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test157");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        watchManager0.shutdown();
        watchManager0.shutdown();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test158");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.removeWatcher("hi!", watcher10);
        java.lang.String str12 = watchManager0.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str12, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test159");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager16 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType18 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager20 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary21 = watchManager20.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType23 = null;
        org.apache.zookeeper.data.ACL[] aCLArray25 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList26 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean27 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList26, aCLArray25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager20.triggerWatch("", eventType23, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26, watcherOrBitSet28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = watchManager16.triggerWatch("", eventType18, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager0.triggerWatch("", eventType14, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26);
        java.lang.String str32 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher34 = null;
        boolean boolean35 = watchManager0.containsWatcher("", watcher34);
        java.lang.Class<?> wildcardClass36 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesSummary21);
        org.junit.Assert.assertNotNull(aCLArray25);
        org.junit.Assert.assertArrayEquals(aCLArray25, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNull(watcherOrBitSet29);
        org.junit.Assert.assertNull(watcherOrBitSet30);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str32, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertNotNull(wildcardClass36);
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test160");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("", watcher10);
        org.apache.zookeeper.Watcher watcher12 = null;
        watchManager0.removeWatcher(watcher12);
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager0.containsWatcher("", watcher15);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test161");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter14 = null;
        watchManager0.dumpWatches(printWriter14, true);
        int int17 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher19 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode20 = null;
        boolean boolean21 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher19, watcherMode20);
        org.apache.zookeeper.Watcher watcher23 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode24 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean25 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher23, watcherMode24);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test162");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("hi!", watcher11);
        watchManager0.shutdown();
        java.lang.String str14 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.containsWatcher("", watcher16);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport18 = watchManager0.getWatchesByPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because \"watcher\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str14, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test163");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        org.apache.zookeeper.Watcher.Event.EventType eventType6 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager8 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager8.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        org.apache.zookeeper.data.ACL[] aCLArray13 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList14 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean15 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList14, aCLArray13);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet16 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = watchManager8.triggerWatch("", eventType11, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList14, watcherOrBitSet16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager0.triggerWatch("", eventType6, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList14, watcherOrBitSet18);
        org.apache.zookeeper.Watcher watcher21 = null;
        boolean boolean22 = watchManager0.addWatch("", watcher21);
        org.apache.zookeeper.Watcher watcher23 = null;
        watchManager0.removeWatcher(watcher23);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesSummary9);
        org.junit.Assert.assertNotNull(aCLArray13);
        org.junit.Assert.assertArrayEquals(aCLArray13, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNull(watcherOrBitSet17);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test164");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("", watcher6, watcherMode7);
        int int9 = watchManager0.getRecursiveWatchQty();
        java.lang.Class<?> wildcardClass10 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test165");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.Watcher.Event.EventType eventType18 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager20 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary25 = watchManager24.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.data.ACL[] aCLArray29 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList30 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList30, aCLArray29);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager24.triggerWatch("", eventType27, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30, watcherOrBitSet32);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager20.triggerWatch("", eventType22, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = watchManager0.triggerWatch("", eventType18, (long) (byte) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30, watcherOrBitSet35);
        org.apache.zookeeper.Watcher watcher38 = null;
        boolean boolean39 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher38);
        org.apache.zookeeper.Watcher.Event.EventType eventType41 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager43 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType45 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager47 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary48 = watchManager47.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType50 = null;
        org.apache.zookeeper.data.ACL[] aCLArray52 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList53 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean54 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList53, aCLArray52);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet55 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet56 = watchManager47.triggerWatch("", eventType50, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList53, watcherOrBitSet55);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet57 = watchManager43.triggerWatch("", eventType45, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList53);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet58 = watchManager0.triggerWatch("hi!", eventType41, (long) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList53);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesSummary25);
        org.junit.Assert.assertNotNull(aCLArray29);
        org.junit.Assert.assertArrayEquals(aCLArray29, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertNull(watcherOrBitSet34);
        org.junit.Assert.assertNull(watcherOrBitSet36);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + true + "'", boolean39 == true);
        org.junit.Assert.assertNotNull(watchesSummary48);
        org.junit.Assert.assertNotNull(aCLArray52);
        org.junit.Assert.assertArrayEquals(aCLArray52, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + false + "'", boolean54 == false);
        org.junit.Assert.assertNull(watcherOrBitSet56);
        org.junit.Assert.assertNull(watcherOrBitSet57);
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test166");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        int int15 = watchManager0.getRecursiveWatchQty();
        java.lang.Class<?> wildcardClass16 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNotNull(wildcardClass16);
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test167");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        java.lang.String str3 = watchManager0.toString();
        java.lang.String str4 = watchManager0.toString();
        int int5 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = watchManager0.addWatch("", watcher7, watcherMode8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str3, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str4, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test168");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        int int15 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport16 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        boolean boolean20 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher18, watcherMode19);
        watchManager0.shutdown();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap22 = watchManager0.getWatch2Paths();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNotNull(watchesReport16);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(watcherMap22);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test169");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher6, watcherMode7);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test170");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        int int15 = watchManager0.getRecursiveWatchQty();
        java.lang.String str16 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        boolean boolean20 = watchManager0.removeWatcher("hi!", watcher18, watcherMode19);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str16, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test171");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap3 = watchManager0.getWatch2Paths();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport4 = watchManager0.getWatches();
        watchManager0.shutdown();
        int int6 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher8 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode9 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean10 = watchManager0.addWatch("", watcher8, watcherMode9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(watcherMap3);
        org.junit.Assert.assertNotNull(watchesReport4);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test172");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        boolean boolean6 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher4, watcherMode5);
        java.lang.String str7 = watchManager0.toString();
        java.lang.String str8 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport9 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher11, watcherMode12);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str7, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str8, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesReport9);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test173");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.addWatch("", watcher3);
        watchManager0.shutdown();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test174");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.addWatch("hi!", watcher7);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test175");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        int int21 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport22 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
        org.junit.Assert.assertNotNull(watchesPathReport22);
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test176");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher11);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test177");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        org.apache.zookeeper.Watcher.Event.EventType eventType6 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager8 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager8.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        org.apache.zookeeper.data.ACL[] aCLArray13 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList14 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean15 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList14, aCLArray13);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet16 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = watchManager8.triggerWatch("", eventType11, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList14, watcherOrBitSet16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager0.triggerWatch("", eventType6, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList14, watcherOrBitSet18);
        org.apache.zookeeper.Watcher watcher21 = null;
        boolean boolean22 = watchManager0.addWatch("", watcher21);
        org.apache.zookeeper.Watcher.Event.EventType eventType24 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager26 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary27 = watchManager26.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType29 = null;
        org.apache.zookeeper.data.ACL[] aCLArray31 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList32 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean33 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList32, aCLArray31);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = watchManager26.triggerWatch("", eventType29, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList32, watcherOrBitSet34);
        org.apache.zookeeper.Watcher watcher37 = null;
        boolean boolean38 = watchManager26.containsWatcher("hi!", watcher37);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport39 = watchManager26.getWatchesByPath();
        java.io.PrintWriter printWriter40 = null;
        watchManager26.dumpWatches(printWriter40, true);
        int int43 = watchManager26.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher45 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode46 = null;
        boolean boolean47 = watchManager26.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher45, watcherMode46);
        org.apache.zookeeper.Watcher.Event.EventType eventType49 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager51 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager51.shutdown();
        org.apache.zookeeper.Watcher watcher54 = null;
        boolean boolean55 = watchManager51.containsWatcher("", watcher54);
        org.apache.zookeeper.Watcher.Event.EventType eventType57 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager59 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary60 = watchManager59.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType62 = null;
        org.apache.zookeeper.data.ACL[] aCLArray64 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList65 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean66 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList65, aCLArray64);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet67 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet68 = watchManager59.triggerWatch("", eventType62, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList65, watcherOrBitSet67);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet69 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet70 = watchManager51.triggerWatch("", eventType57, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList65, watcherOrBitSet69);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet71 = watchManager26.triggerWatch("", eventType49, (long) (short) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList65);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet72 = watchManager0.triggerWatch("0 connections watching 0 paths\nTotal watches:0", eventType24, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList65);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesSummary9);
        org.junit.Assert.assertNotNull(aCLArray13);
        org.junit.Assert.assertArrayEquals(aCLArray13, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNull(watcherOrBitSet17);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
        org.junit.Assert.assertNotNull(watchesSummary27);
        org.junit.Assert.assertNotNull(aCLArray31);
        org.junit.Assert.assertArrayEquals(aCLArray31, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertNull(watcherOrBitSet35);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertNotNull(watchesPathReport39);
        org.junit.Assert.assertTrue("'" + int43 + "' != '" + 0 + "'", int43 == 0);
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + false + "'", boolean47 == false);
        org.junit.Assert.assertTrue("'" + boolean55 + "' != '" + false + "'", boolean55 == false);
        org.junit.Assert.assertNotNull(watchesSummary60);
        org.junit.Assert.assertNotNull(aCLArray64);
        org.junit.Assert.assertArrayEquals(aCLArray64, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean66 + "' != '" + false + "'", boolean66 == false);
        org.junit.Assert.assertNull(watcherOrBitSet68);
        org.junit.Assert.assertNull(watcherOrBitSet70);
        org.junit.Assert.assertNull(watcherOrBitSet71);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test178");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.Watcher watcher22 = null;
        boolean boolean23 = watchManager0.removeWatcher("hi!", watcher22);
        java.lang.String str24 = watchManager0.toString();
        int int25 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher27 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode28 = null;
        boolean boolean29 = watchManager0.containsWatcher("", watcher27, watcherMode28);
        org.apache.zookeeper.Watcher watcher31 = null;
        boolean boolean32 = watchManager0.removeWatcher("hi!", watcher31);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str24, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + int25 + "' != '" + 0 + "'", int25 == 0);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test179");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("hi!", watcher11);
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap13 = watchManager0.getWatch2Paths();
        java.lang.String str14 = watchManager0.toString();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertNotNull(watcherMap13);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str14, "1 connections watching 1 paths\nTotal watches:1");
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test180");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        java.lang.String str3 = watchManager0.toString();
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("hi!", watcher6, watcherMode7);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str3, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str4, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test181");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        watchManager0.shutdown();
        java.io.PrintWriter printWriter11 = null;
        watchManager0.dumpWatches(printWriter11, true);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test182");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary25 = watchManager24.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.data.ACL[] aCLArray29 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList30 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList30, aCLArray29);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager24.triggerWatch("", eventType27, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30, watcherOrBitSet32);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager0.triggerWatch("", eventType22, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Class<?> wildcardClass35 = watcherOrBitSet34.getClass();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNotNull(watchesSummary25);
        org.junit.Assert.assertNotNull(aCLArray29);
        org.junit.Assert.assertArrayEquals(aCLArray29, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertNull(watcherOrBitSet34);
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test183");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary25 = watchManager24.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.data.ACL[] aCLArray29 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList30 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList30, aCLArray29);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager24.triggerWatch("", eventType27, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30, watcherOrBitSet32);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager0.triggerWatch("", eventType22, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30);
        int int35 = watchManager0.getRecursiveWatchQty();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap36 = watchManager0.getWatch2Paths();
        java.lang.String str37 = watchManager0.toString();
        org.apache.zookeeper.Watcher.Event.EventType eventType39 = null;
        java.util.List<org.apache.zookeeper.data.ACL> aCLList41 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager0.triggerWatch("1 connections watching 1 paths\nTotal watches:1", eventType39, (long) (short) -1, aCLList41);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNotNull(watchesSummary25);
        org.junit.Assert.assertNotNull(aCLArray29);
        org.junit.Assert.assertArrayEquals(aCLArray29, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertNull(watcherOrBitSet34);
        org.junit.Assert.assertTrue("'" + int35 + "' != '" + 0 + "'", int35 == 0);
        org.junit.Assert.assertNotNull(watcherMap36);
        org.junit.Assert.assertEquals("'" + str37 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str37, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test184");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport6 = watchManager0.getWatchesByPath();
        java.lang.Class<?> wildcardClass7 = watchesPathReport6.getClass();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(watchesPathReport6);
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test185");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        boolean boolean6 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher4, watcherMode5);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary7 = watchManager0.getWatchesSummary();
        java.io.PrintWriter printWriter8 = null;
        watchManager0.dumpWatches(printWriter8, true);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport11 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.addWatch("", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        boolean boolean18 = watchManager0.removeWatcher("", watcher16, watcherMode17);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport19 = watchManager0.getWatches();
        int int20 = watchManager0.getRecursiveWatchQty();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(watchesSummary7);
        org.junit.Assert.assertNotNull(watchesPathReport11);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertNotNull(watchesReport19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test186");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport17 = watchManager0.getWatchesByPath();
        java.lang.String str18 = watchManager0.toString();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesPathReport17);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str18, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test187");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter14 = null;
        watchManager0.dumpWatches(printWriter14, true);
        int int17 = watchManager0.getRecursiveWatchQty();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap18 = watchManager0.getWatch2Paths();
        org.apache.zookeeper.Watcher watcher20 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode21 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean22 = watchManager0.addWatch("hi!", watcher20, watcherMode21);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
        org.junit.Assert.assertNotNull(watcherMap18);
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test188");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        int int15 = watchManager0.getRecursiveWatchQty();
        java.lang.String str16 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher17 = null;
        watchManager0.removeWatcher(watcher17);
        int int19 = watchManager0.size();
        java.lang.String str20 = watchManager0.toString();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str16, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 0 + "'", int19 == 0);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str20, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test189");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        int int15 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport16 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        boolean boolean20 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher18, watcherMode19);
        java.io.PrintWriter printWriter21 = null;
        watchManager0.dumpWatches(printWriter21, true);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNotNull(watchesReport16);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test190");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("hi!", watcher11);
        java.lang.String str13 = watchManager0.toString();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatchesReport watchesReport14 = watchManager0.getWatches();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.ServerCnxn.getSessionId()\" because the return value of \"java.util.Map$Entry.getKey()\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str13, "1 connections watching 1 paths\nTotal watches:1");
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test191");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        watchManager0.shutdown();
        int int11 = watchManager0.getRecursiveWatchQty();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test192");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport6 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher8);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport10 = watchManager0.getWatches();
        java.io.PrintWriter printWriter11 = null;
        watchManager0.dumpWatches(printWriter11, false);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(watchesPathReport6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesReport10);
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test193");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher15 = null;
        boolean boolean16 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher15);
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        boolean boolean20 = watchManager0.containsWatcher("1 connections watching 1 paths\nTotal watches:1", watcher18, watcherMode19);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test194");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager22 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary23 = watchManager22.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.data.ACL[] aCLArray27 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList28 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean29 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList28, aCLArray27);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager22.triggerWatch("", eventType25, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28, watcherOrBitSet30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager18.triggerWatch("", eventType20, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager0.triggerWatch("", eventType16, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        int int34 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport35 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary36 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher38 = null;
        boolean boolean39 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher38);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesSummary23);
        org.junit.Assert.assertNotNull(aCLArray27);
        org.junit.Assert.assertArrayEquals(aCLArray27, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNull(watcherOrBitSet32);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertTrue("'" + int34 + "' != '" + 0 + "'", int34 == 0);
        org.junit.Assert.assertNotNull(watchesReport35);
        org.junit.Assert.assertNotNull(watchesSummary36);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test195");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        java.lang.String str14 = watchManager0.toString();
        watchManager0.shutdown();
        int int16 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str14, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 0 + "'", int16 == 0);
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test196");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        java.lang.String str14 = watchManager0.toString();
        java.lang.Class<?> wildcardClass15 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str14, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(wildcardClass15);
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test197");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter14 = null;
        watchManager0.dumpWatches(printWriter14, true);
        org.apache.zookeeper.Watcher watcher17 = null;
        watchManager0.removeWatcher(watcher17);
        int int19 = watchManager0.getRecursiveWatchQty();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 0 + "'", int19 == 0);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test198");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap3 = watchManager0.getWatch2Paths();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport4 = watchManager0.getWatches();
        watchManager0.shutdown();
        int int6 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher8);
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager13 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary14 = watchManager13.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager22 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary23 = watchManager22.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.data.ACL[] aCLArray27 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList28 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean29 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList28, aCLArray27);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager22.triggerWatch("", eventType25, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28, watcherOrBitSet30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager18.triggerWatch("", eventType20, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager13.triggerWatch("", eventType16, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager37 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary38 = watchManager37.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType40 = null;
        org.apache.zookeeper.data.ACL[] aCLArray42 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList43 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean44 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList43, aCLArray42);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = watchManager37.triggerWatch("", eventType40, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43, watcherOrBitSet45);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet47 = watchManager13.triggerWatch("", eventType35, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet48 = watchManager0.triggerWatch("0 connections watching 0 paths\nTotal watches:0", eventType11, (long) (byte) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList43);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(watcherMap3);
        org.junit.Assert.assertNotNull(watchesReport4);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesSummary14);
        org.junit.Assert.assertNotNull(watchesSummary23);
        org.junit.Assert.assertNotNull(aCLArray27);
        org.junit.Assert.assertArrayEquals(aCLArray27, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNull(watcherOrBitSet32);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertNotNull(watchesSummary38);
        org.junit.Assert.assertNotNull(aCLArray42);
        org.junit.Assert.assertArrayEquals(aCLArray42, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertNull(watcherOrBitSet46);
        org.junit.Assert.assertNull(watcherOrBitSet47);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test199");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        int int15 = watchManager0.getRecursiveWatchQty();
        int int16 = watchManager0.getRecursiveWatchQty();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 0 + "'", int16 == 0);
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test200");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap10 = watchManager0.getWatch2Paths();
        java.lang.Class<?> wildcardClass11 = watcherMap10.getClass();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watcherMap10);
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test201");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary21 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher23 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode24 = null;
        boolean boolean25 = watchManager0.removeWatcher("hi!", watcher23, watcherMode24);
        java.io.PrintWriter printWriter26 = null;
        watchManager0.dumpWatches(printWriter26, true);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport29 = watchManager0.getWatchesByPath();
        java.lang.Class<?> wildcardClass30 = watchesPathReport29.getClass();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNotNull(watchesSummary21);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(watchesPathReport29);
        org.junit.Assert.assertNotNull(wildcardClass30);
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test202");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.Watcher watcher22 = null;
        boolean boolean23 = watchManager0.removeWatcher("hi!", watcher22);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport24 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNotNull(watchesPathReport24);
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test203");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        boolean boolean6 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher4, watcherMode5);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary7 = watchManager0.getWatchesSummary();
        java.io.PrintWriter printWriter8 = null;
        watchManager0.dumpWatches(printWriter8, true);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport11 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher13 = null;
        boolean boolean14 = watchManager0.addWatch("", watcher13);
        org.apache.zookeeper.Watcher watcher16 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode17 = null;
        boolean boolean18 = watchManager0.removeWatcher("", watcher16, watcherMode17);
        org.apache.zookeeper.Watcher watcher20 = null;
        boolean boolean21 = watchManager0.removeWatcher("", watcher20);
        java.lang.String str22 = watchManager0.toString();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(watchesSummary7);
        org.junit.Assert.assertNotNull(watchesPathReport11);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str22, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test204");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        int int2 = watchManager0.getRecursiveWatchQty();
        java.lang.String str3 = watchManager0.toString();
        org.apache.zookeeper.Watcher.Event.EventType eventType5 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager7 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary8 = watchManager7.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.data.ACL[] aCLArray12 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList13 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean14 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList13, aCLArray12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet15 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet16 = watchManager7.triggerWatch("", eventType10, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList13, watcherOrBitSet15);
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager7.containsWatcher("hi!", watcher18);
        org.apache.zookeeper.Watcher.Event.EventType eventType21 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager23 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager27 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary28 = watchManager27.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType30 = null;
        org.apache.zookeeper.data.ACL[] aCLArray32 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList33 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean34 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList33, aCLArray32);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet36 = watchManager27.triggerWatch("", eventType30, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList33, watcherOrBitSet35);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet37 = watchManager23.triggerWatch("", eventType25, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList33);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet38 = watchManager7.triggerWatch("", eventType21, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList33);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = watchManager0.triggerWatch("", eventType5, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList33, watcherOrBitSet39);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str3, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesSummary8);
        org.junit.Assert.assertNotNull(aCLArray12);
        org.junit.Assert.assertArrayEquals(aCLArray12, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNull(watcherOrBitSet16);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(watchesSummary28);
        org.junit.Assert.assertNotNull(aCLArray32);
        org.junit.Assert.assertArrayEquals(aCLArray32, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertNull(watcherOrBitSet36);
        org.junit.Assert.assertNull(watcherOrBitSet37);
        org.junit.Assert.assertNull(watcherOrBitSet38);
        org.junit.Assert.assertNull(watcherOrBitSet40);
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test205");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter14 = null;
        watchManager0.dumpWatches(printWriter14, true);
        int int17 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher19 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode20 = null;
        boolean boolean21 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher19, watcherMode20);
        int int22 = watchManager0.size();
        java.lang.String str23 = watchManager0.toString();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap24 = watchManager0.getWatch2Paths();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 0 + "'", int22 == 0);
        org.junit.Assert.assertEquals("'" + str23 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str23, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watcherMap24);
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test206");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("", watcher6, watcherMode7);
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap9 = watchManager0.getWatch2Paths();
        int int10 = watchManager0.size();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap11 = watchManager0.getWatch2Paths();
        org.apache.zookeeper.Watcher watcher12 = null;
        watchManager0.removeWatcher(watcher12);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watcherMap9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertNotNull(watcherMap11);
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test207");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter14 = null;
        watchManager0.dumpWatches(printWriter14, true);
        int int17 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher19 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode20 = null;
        boolean boolean21 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher19, watcherMode20);
        org.apache.zookeeper.Watcher.Event.EventType eventType23 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager25 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager25.shutdown();
        org.apache.zookeeper.Watcher watcher28 = null;
        boolean boolean29 = watchManager25.containsWatcher("", watcher28);
        org.apache.zookeeper.Watcher.Event.EventType eventType31 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager33 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary34 = watchManager33.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType36 = null;
        org.apache.zookeeper.data.ACL[] aCLArray38 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList39 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean40 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList39, aCLArray38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager33.triggerWatch("", eventType36, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39, watcherOrBitSet41);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager25.triggerWatch("", eventType31, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39, watcherOrBitSet43);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = watchManager0.triggerWatch("", eventType23, (long) (short) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList39);
        org.apache.zookeeper.Watcher watcher47 = null;
        boolean boolean48 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher47);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
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
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test208");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary21 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher23 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode24 = null;
        boolean boolean25 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher23, watcherMode24);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport26 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNotNull(watchesSummary21);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(watchesPathReport26);
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test209");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        int int15 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport16 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        boolean boolean20 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher18, watcherMode19);
        java.lang.String str21 = watchManager0.toString();
        org.apache.zookeeper.Watcher.Event.EventType eventType23 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager25 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary26 = watchManager25.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType28 = null;
        org.apache.zookeeper.data.ACL[] aCLArray30 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList31 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean32 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList31, aCLArray30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager25.triggerWatch("", eventType28, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList31, watcherOrBitSet33);
        org.apache.zookeeper.Watcher watcher36 = null;
        boolean boolean37 = watchManager25.containsWatcher("hi!", watcher36);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport38 = watchManager25.getWatchesByPath();
        java.io.PrintWriter printWriter39 = null;
        watchManager25.dumpWatches(printWriter39, true);
        int int42 = watchManager25.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher44 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode45 = null;
        boolean boolean46 = watchManager25.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher44, watcherMode45);
        org.apache.zookeeper.Watcher.Event.EventType eventType48 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager50 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager50.shutdown();
        org.apache.zookeeper.Watcher watcher53 = null;
        boolean boolean54 = watchManager50.containsWatcher("", watcher53);
        org.apache.zookeeper.Watcher.Event.EventType eventType56 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager58 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary59 = watchManager58.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType61 = null;
        org.apache.zookeeper.data.ACL[] aCLArray63 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList64 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean65 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList64, aCLArray63);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet66 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet67 = watchManager58.triggerWatch("", eventType61, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList64, watcherOrBitSet66);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet68 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet69 = watchManager50.triggerWatch("", eventType56, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList64, watcherOrBitSet68);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet70 = watchManager25.triggerWatch("", eventType48, (long) (short) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList64);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet71 = watchManager0.triggerWatch("1 connections watching 1 paths\nTotal watches:1", eventType23, (long) 'a', (java.util.List<org.apache.zookeeper.data.ACL>) aCLList64);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNotNull(watchesReport16);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str21, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesSummary26);
        org.junit.Assert.assertNotNull(aCLArray30);
        org.junit.Assert.assertArrayEquals(aCLArray30, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNull(watcherOrBitSet34);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertNotNull(watchesPathReport38);
        org.junit.Assert.assertTrue("'" + int42 + "' != '" + 0 + "'", int42 == 0);
        org.junit.Assert.assertTrue("'" + boolean46 + "' != '" + false + "'", boolean46 == false);
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + false + "'", boolean54 == false);
        org.junit.Assert.assertNotNull(watchesSummary59);
        org.junit.Assert.assertNotNull(aCLArray63);
        org.junit.Assert.assertArrayEquals(aCLArray63, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean65 + "' != '" + false + "'", boolean65 == false);
        org.junit.Assert.assertNull(watcherOrBitSet67);
        org.junit.Assert.assertNull(watcherOrBitSet69);
        org.junit.Assert.assertNull(watcherOrBitSet70);
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test210");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher3 = null;
        watchManager0.removeWatcher(watcher3);
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport6 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher8);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport10 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary11 = watchManager0.getWatchesSummary();
        int int12 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(watchesPathReport6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesReport10);
        org.junit.Assert.assertNotNull(watchesSummary11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test211");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary25 = watchManager24.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.data.ACL[] aCLArray29 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList30 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList30, aCLArray29);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager24.triggerWatch("", eventType27, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30, watcherOrBitSet32);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager0.triggerWatch("", eventType22, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30);
        java.lang.String str35 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher37 = null;
        boolean boolean38 = watchManager0.addWatch("", watcher37);
        java.lang.Class<?> wildcardClass39 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNotNull(watchesSummary25);
        org.junit.Assert.assertNotNull(aCLArray29);
        org.junit.Assert.assertArrayEquals(aCLArray29, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertNull(watcherOrBitSet34);
        org.junit.Assert.assertEquals("'" + str35 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str35, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + true + "'", boolean38 == true);
        org.junit.Assert.assertNotNull(wildcardClass39);
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test212");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport17 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary19 = watchManager0.getWatchesSummary();
        java.lang.String str20 = watchManager0.toString();
        int int21 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesPathReport17);
        org.junit.Assert.assertNotNull(watchesSummary19);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str20, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test213");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher7, watcherMode8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean13 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher11, watcherMode12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test214");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        java.lang.String str3 = watchManager0.toString();
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher6, watcherMode7);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str3, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str4, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test215");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.containsWatcher("", watcher4);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test216");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher3);
        java.io.PrintWriter printWriter5 = null;
        watchManager0.dumpWatches(printWriter5, false);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test217");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.addWatch("hi!", watcher11);
        java.lang.String str13 = watchManager0.toString();
        java.io.PrintWriter printWriter14 = null;
        // The following exception was thrown during execution in test generation
        try {
            watchManager0.dumpWatches(printWriter14, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.PrintWriter.println(String)\" because \"pwriter\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str13, "1 connections watching 1 paths\nTotal watches:1");
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test218");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport5 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.addWatch("hi!", watcher10);
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesPathReport5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test219");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport11 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport12 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertNotNull(watchesPathReport11);
        org.junit.Assert.assertNotNull(watchesPathReport12);
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test220");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher10, watcherMode11);
        java.lang.Class<?> wildcardClass13 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(wildcardClass13);
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test221");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher watcher2 = null;
        boolean boolean3 = watchManager0.addWatch("hi!", watcher2);
        int int4 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher5 = null;
        watchManager0.removeWatcher(watcher5);
        java.lang.Class<?> wildcardClass7 = watchManager0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test222");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("", watcher6, watcherMode7);
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap9 = watchManager0.getWatch2Paths();
        int int10 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher12 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode13 = null;
        boolean boolean14 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher12, watcherMode13);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watcherMap9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test223");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        int int15 = watchManager0.getRecursiveWatchQty();
        java.lang.String str16 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher17 = null;
        watchManager0.removeWatcher(watcher17);
        int int19 = watchManager0.size();
        java.lang.Class<?> wildcardClass20 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str16, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 0 + "'", int19 == 0);
        org.junit.Assert.assertNotNull(wildcardClass20);
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test224");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        int int2 = watchManager0.getRecursiveWatchQty();
        java.lang.String str3 = watchManager0.toString();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("1 connections watching 1 paths\nTotal watches:1", watcher6, watcherMode7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.removeWatcher("", watcher10, watcherMode11);
        watchManager0.shutdown();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str3, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test225");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.Watcher watcher22 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode23 = null;
        boolean boolean24 = watchManager0.containsWatcher("", watcher22, watcherMode23);
        org.apache.zookeeper.Watcher watcher26 = null;
        boolean boolean27 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher26);
        java.io.PrintWriter printWriter28 = null;
        watchManager0.dumpWatches(printWriter28, false);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary31 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNotNull(watchesSummary31);
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test226");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap8 = watchManager0.getWatch2Paths();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(watcherMap8);
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test227");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        boolean boolean6 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher4, watcherMode5);
        java.lang.String str7 = watchManager0.toString();
        java.lang.String str8 = watchManager0.toString();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap9 = watchManager0.getWatch2Paths();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str7, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str8, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watcherMap9);
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test228");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.Watcher watcher22 = null;
        boolean boolean23 = watchManager0.removeWatcher("hi!", watcher22);
        java.lang.String str24 = watchManager0.toString();
        int int25 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher27 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode28 = null;
        boolean boolean29 = watchManager0.containsWatcher("", watcher27, watcherMode28);
        org.apache.zookeeper.server.watch.WatchesReport watchesReport30 = watchManager0.getWatches();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str24, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + int25 + "' != '" + 0 + "'", int25 == 0);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNotNull(watchesReport30);
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test229");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary21 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher23 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode24 = null;
        boolean boolean25 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher23, watcherMode24);
        java.lang.String str26 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport27 = watchManager0.getWatches();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNotNull(watchesSummary21);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertEquals("'" + str26 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str26, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesReport27);
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test230");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        int int15 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport16 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        boolean boolean20 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher18, watcherMode19);
        watchManager0.shutdown();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher24 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode25 = null;
        boolean boolean26 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher24, watcherMode25);
        org.apache.zookeeper.Watcher watcher28 = null;
        boolean boolean29 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher28);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNotNull(watchesReport16);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test231");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        int int15 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport16 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport17 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport18 = watchManager0.getWatches();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNotNull(watchesReport16);
        org.junit.Assert.assertNotNull(watchesPathReport17);
        org.junit.Assert.assertNotNull(watchesReport18);
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test232");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport17 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport20 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesPathReport17);
        org.junit.Assert.assertNotNull(watchesPathReport20);
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test233");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary25 = watchManager24.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.data.ACL[] aCLArray29 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList30 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList30, aCLArray29);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager24.triggerWatch("", eventType27, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30, watcherOrBitSet32);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager0.triggerWatch("", eventType22, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30);
        int int35 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher37 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode38 = null;
        boolean boolean39 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher37, watcherMode38);
        java.lang.String str40 = watchManager0.toString();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNotNull(watchesSummary25);
        org.junit.Assert.assertNotNull(aCLArray29);
        org.junit.Assert.assertArrayEquals(aCLArray29, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertNull(watcherOrBitSet34);
        org.junit.Assert.assertTrue("'" + int35 + "' != '" + 0 + "'", int35 == 0);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertEquals("'" + str40 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str40, "0 connections watching 0 paths\nTotal watches:0");
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test234");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        int int15 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport16 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher18);
        int int20 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher22 = null;
        boolean boolean23 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher22);
        org.apache.zookeeper.Watcher watcher25 = null;
        boolean boolean26 = watchManager0.removeWatcher("hi!", watcher25);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNotNull(watchesReport16);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test235");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        boolean boolean6 = watchManager0.containsWatcher("hi!", watcher4, watcherMode5);
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean13 = watchManager0.addWatch("", watcher11, watcherMode12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test236");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport5 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        boolean boolean11 = watchManager0.containsWatcher("", watcher10);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesPathReport5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test237");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager22 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary23 = watchManager22.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.data.ACL[] aCLArray27 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList28 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean29 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList28, aCLArray27);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager22.triggerWatch("", eventType25, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28, watcherOrBitSet30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager18.triggerWatch("", eventType20, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager0.triggerWatch("", eventType16, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        int int34 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport35 = watchManager0.getWatches();
        watchManager0.shutdown();
        java.io.PrintWriter printWriter37 = null;
        watchManager0.dumpWatches(printWriter37, true);
        org.apache.zookeeper.Watcher.Event.EventType eventType41 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager43 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary44 = watchManager43.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType46 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager48 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType50 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager52 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary53 = watchManager52.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType55 = null;
        org.apache.zookeeper.data.ACL[] aCLArray57 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList58 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean59 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList58, aCLArray57);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet60 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet61 = watchManager52.triggerWatch("", eventType55, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList58, watcherOrBitSet60);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet62 = watchManager48.triggerWatch("", eventType50, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList58);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet63 = watchManager43.triggerWatch("", eventType46, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList58);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet64 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet65 = watchManager0.triggerWatch("", eventType41, (long) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList58, watcherOrBitSet64);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesSummary23);
        org.junit.Assert.assertNotNull(aCLArray27);
        org.junit.Assert.assertArrayEquals(aCLArray27, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNull(watcherOrBitSet32);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertTrue("'" + int34 + "' != '" + 0 + "'", int34 == 0);
        org.junit.Assert.assertNotNull(watchesReport35);
        org.junit.Assert.assertNotNull(watchesSummary44);
        org.junit.Assert.assertNotNull(watchesSummary53);
        org.junit.Assert.assertNotNull(aCLArray57);
        org.junit.Assert.assertArrayEquals(aCLArray57, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean59 + "' != '" + false + "'", boolean59 == false);
        org.junit.Assert.assertNull(watcherOrBitSet61);
        org.junit.Assert.assertNull(watcherOrBitSet62);
        org.junit.Assert.assertNull(watcherOrBitSet63);
        org.junit.Assert.assertNull(watcherOrBitSet65);
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test238");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        java.lang.String str3 = watchManager0.toString();
        java.lang.String str4 = watchManager0.toString();
        int int5 = watchManager0.getRecursiveWatchQty();
        watchManager0.shutdown();
        int int7 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str3, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str4, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test239");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport3 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.removeWatcher("hi!", watcher5);
        java.io.PrintWriter printWriter7 = null;
        watchManager0.dumpWatches(printWriter7, false);
        int int10 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.addWatch("", watcher12);
        org.apache.zookeeper.Watcher watcher14 = null;
        watchManager0.removeWatcher(watcher14);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(watchesPathReport3);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test240");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        boolean boolean6 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher4, watcherMode5);
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher8);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport10 = watchManager0.getWatchesByPath();
        java.lang.Class<?> wildcardClass11 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesPathReport10);
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test241");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        boolean boolean6 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher4, watcherMode5);
        java.lang.String str7 = watchManager0.toString();
        java.lang.String str8 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport9 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager13 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary14 = watchManager13.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType16 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager18 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager22 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary23 = watchManager22.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.data.ACL[] aCLArray27 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList28 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean29 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList28, aCLArray27);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager22.triggerWatch("", eventType25, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28, watcherOrBitSet30);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = watchManager18.triggerWatch("", eventType20, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager13.triggerWatch("", eventType16, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet35 = watchManager0.triggerWatch("0 connections watching 0 paths\nTotal watches:0", eventType11, (long) (short) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList28, watcherOrBitSet34);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str7, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str8, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesReport9);
        org.junit.Assert.assertNotNull(watchesSummary14);
        org.junit.Assert.assertNotNull(watchesSummary23);
        org.junit.Assert.assertNotNull(aCLArray27);
        org.junit.Assert.assertArrayEquals(aCLArray27, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNull(watcherOrBitSet32);
        org.junit.Assert.assertNull(watcherOrBitSet33);
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test242");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        watchManager0.shutdown();
        java.io.PrintWriter printWriter14 = null;
        watchManager0.dumpWatches(printWriter14, true);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test243");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher9 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode10 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean11 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher9, watcherMode10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.zookeeper.server.watch.WatcherMode.ordinal()\" because \"mode\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesReport7);
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test244");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher4 = null;
        boolean boolean5 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher4);
        java.lang.Class<?> wildcardClass6 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test245");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        java.lang.String str14 = watchManager0.toString();
        int int15 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.removeWatcher("hi!", watcher17);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str14, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test246");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport3 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher5 = null;
        boolean boolean6 = watchManager0.removeWatcher("hi!", watcher5);
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap7 = watchManager0.getWatch2Paths();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap8 = watchManager0.getWatch2Paths();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(watchesPathReport3);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(watcherMap7);
        org.junit.Assert.assertNotNull(watcherMap8);
    }

    @Test
    public void test247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test247");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager16 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType18 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager20 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary21 = watchManager20.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType23 = null;
        org.apache.zookeeper.data.ACL[] aCLArray25 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList26 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean27 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList26, aCLArray25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager20.triggerWatch("", eventType23, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26, watcherOrBitSet28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = watchManager16.triggerWatch("", eventType18, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager0.triggerWatch("", eventType14, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26);
        java.lang.String str32 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher34 = null;
        boolean boolean35 = watchManager0.containsWatcher("1 connections watching 1 paths\nTotal watches:1", watcher34);
        org.apache.zookeeper.Watcher watcher37 = null;
        boolean boolean38 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher37);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesSummary21);
        org.junit.Assert.assertNotNull(aCLArray25);
        org.junit.Assert.assertArrayEquals(aCLArray25, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNull(watcherOrBitSet29);
        org.junit.Assert.assertNull(watcherOrBitSet30);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str32, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + true + "'", boolean38 == true);
    }

    @Test
    public void test248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test248");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager17 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary18 = watchManager17.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType20 = null;
        org.apache.zookeeper.data.ACL[] aCLArray22 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList23 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean24 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList23, aCLArray22);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet25 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet26 = watchManager17.triggerWatch("", eventType20, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList23, watcherOrBitSet25);
        org.apache.zookeeper.Watcher watcher28 = null;
        boolean boolean29 = watchManager17.addWatch("hi!", watcher28);
        watchManager17.shutdown();
        java.lang.String str31 = watchManager17.toString();
        org.apache.zookeeper.Watcher.Event.EventType eventType33 = null;
        org.apache.zookeeper.data.ACL[] aCLArray35 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList36 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean37 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList36, aCLArray35);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet38 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = watchManager17.triggerWatch("", eventType33, 100L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList36, watcherOrBitSet38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager0.triggerWatch("0 connections watching 0 paths\nTotal watches:0", eventType15, (long) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList36, watcherOrBitSet40);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
        org.junit.Assert.assertNotNull(watchesSummary18);
        org.junit.Assert.assertNotNull(aCLArray22);
        org.junit.Assert.assertArrayEquals(aCLArray22, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNull(watcherOrBitSet26);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + true + "'", boolean29 == true);
        org.junit.Assert.assertEquals("'" + str31 + "' != '" + "1 connections watching 1 paths\nTotal watches:1" + "'", str31, "1 connections watching 1 paths\nTotal watches:1");
        org.junit.Assert.assertNotNull(aCLArray35);
        org.junit.Assert.assertArrayEquals(aCLArray35, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertNull(watcherOrBitSet39);
    }

    @Test
    public void test249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test249");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport5 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary6 = watchManager0.getWatchesSummary();
        int int7 = watchManager0.size();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap8 = watchManager0.getWatch2Paths();
        int int9 = watchManager0.getRecursiveWatchQty();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesPathReport5);
        org.junit.Assert.assertNotNull(watchesSummary6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertNotNull(watcherMap8);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
    }

    @Test
    public void test250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test250");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary25 = watchManager24.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.data.ACL[] aCLArray29 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList30 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList30, aCLArray29);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager24.triggerWatch("", eventType27, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30, watcherOrBitSet32);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager0.triggerWatch("", eventType22, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30);
        int int35 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNotNull(watchesSummary25);
        org.junit.Assert.assertNotNull(aCLArray29);
        org.junit.Assert.assertArrayEquals(aCLArray29, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertNull(watcherOrBitSet34);
        org.junit.Assert.assertTrue("'" + int35 + "' != '" + 0 + "'", int35 == 0);
    }

    @Test
    public void test251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test251");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("", watcher7);
        org.apache.zookeeper.Watcher watcher10 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher10, watcherMode11);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary13 = watchManager0.getWatchesSummary();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher16 = null;
        boolean boolean17 = watchManager0.addWatch("hi!", watcher16);
        org.apache.zookeeper.Watcher watcher19 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode20 = null;
        boolean boolean21 = watchManager0.containsWatcher("1 connections watching 1 paths\nTotal watches:1", watcher19, watcherMode20);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesSummary13);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
    }

    @Test
    public void test252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test252");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.Watcher watcher22 = null;
        boolean boolean23 = watchManager0.removeWatcher("hi!", watcher22);
        java.lang.String str24 = watchManager0.toString();
        int int25 = watchManager0.size();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary26 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str24, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + int25 + "' != '" + 0 + "'", int25 == 0);
        org.junit.Assert.assertNotNull(watchesSummary26);
    }

    @Test
    public void test253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test253");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap15 = watchManager0.getWatch2Paths();
        org.apache.zookeeper.Watcher watcher17 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode18 = null;
        boolean boolean19 = watchManager0.containsWatcher("", watcher17, watcherMode18);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watcherMap15);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test254() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test254");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        watchManager0.shutdown();
        java.io.PrintWriter printWriter6 = null;
        watchManager0.dumpWatches(printWriter6, false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test255() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test255");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.Watcher.Event.EventType eventType22 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager24 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary25 = watchManager24.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType27 = null;
        org.apache.zookeeper.data.ACL[] aCLArray29 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList30 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList30, aCLArray29);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet32 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet33 = watchManager24.triggerWatch("", eventType27, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30, watcherOrBitSet32);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet34 = watchManager0.triggerWatch("", eventType22, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList30);
        int int35 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher37 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode38 = null;
        boolean boolean39 = watchManager0.containsWatcher("hi!", watcher37, watcherMode38);
        org.apache.zookeeper.Watcher watcher41 = null;
        boolean boolean42 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher41);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNotNull(watchesSummary25);
        org.junit.Assert.assertNotNull(aCLArray29);
        org.junit.Assert.assertArrayEquals(aCLArray29, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNull(watcherOrBitSet33);
        org.junit.Assert.assertNull(watcherOrBitSet34);
        org.junit.Assert.assertTrue("'" + int35 + "' != '" + 0 + "'", int35 == 0);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
    }

    @Test
    public void test256() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test256");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary21 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher23 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode24 = null;
        boolean boolean25 = watchManager0.removeWatcher("hi!", watcher23, watcherMode24);
        java.io.PrintWriter printWriter26 = null;
        watchManager0.dumpWatches(printWriter26, true);
        int int29 = watchManager0.size();
        org.apache.zookeeper.Watcher.Event.EventType eventType31 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager33 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary34 = watchManager33.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType36 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager38 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType40 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager42 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary43 = watchManager42.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType45 = null;
        org.apache.zookeeper.data.ACL[] aCLArray47 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList48 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean49 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList48, aCLArray47);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet50 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet51 = watchManager42.triggerWatch("", eventType45, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList48, watcherOrBitSet50);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet52 = watchManager38.triggerWatch("", eventType40, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList48);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet53 = watchManager33.triggerWatch("", eventType36, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList48);
        org.apache.zookeeper.Watcher watcher55 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode56 = null;
        boolean boolean57 = watchManager33.containsWatcher("", watcher55, watcherMode56);
        org.apache.zookeeper.Watcher.Event.EventType eventType59 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager61 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary62 = watchManager61.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType64 = null;
        org.apache.zookeeper.data.ACL[] aCLArray66 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList67 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean68 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList67, aCLArray66);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet69 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet70 = watchManager61.triggerWatch("", eventType64, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList67, watcherOrBitSet69);
        org.apache.zookeeper.Watcher watcher72 = null;
        boolean boolean73 = watchManager61.containsWatcher("hi!", watcher72);
        org.apache.zookeeper.Watcher.Event.EventType eventType75 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager77 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType79 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager81 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary82 = watchManager81.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType84 = null;
        org.apache.zookeeper.data.ACL[] aCLArray86 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList87 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean88 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList87, aCLArray86);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet89 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet90 = watchManager81.triggerWatch("", eventType84, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList87, watcherOrBitSet89);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet91 = watchManager77.triggerWatch("", eventType79, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList87);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet92 = watchManager61.triggerWatch("", eventType75, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList87);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet93 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet94 = watchManager33.triggerWatch("", eventType59, (long) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList87, watcherOrBitSet93);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet95 = watchManager0.triggerWatch("0 connections watching 0 paths\nTotal watches:0", eventType31, (long) (short) 100, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList87);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNotNull(watchesSummary21);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + int29 + "' != '" + 0 + "'", int29 == 0);
        org.junit.Assert.assertNotNull(watchesSummary34);
        org.junit.Assert.assertNotNull(watchesSummary43);
        org.junit.Assert.assertNotNull(aCLArray47);
        org.junit.Assert.assertArrayEquals(aCLArray47, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + false + "'", boolean49 == false);
        org.junit.Assert.assertNull(watcherOrBitSet51);
        org.junit.Assert.assertNull(watcherOrBitSet52);
        org.junit.Assert.assertNull(watcherOrBitSet53);
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + false + "'", boolean57 == false);
        org.junit.Assert.assertNotNull(watchesSummary62);
        org.junit.Assert.assertNotNull(aCLArray66);
        org.junit.Assert.assertArrayEquals(aCLArray66, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean68 + "' != '" + false + "'", boolean68 == false);
        org.junit.Assert.assertNull(watcherOrBitSet70);
        org.junit.Assert.assertTrue("'" + boolean73 + "' != '" + false + "'", boolean73 == false);
        org.junit.Assert.assertNotNull(watchesSummary82);
        org.junit.Assert.assertNotNull(aCLArray86);
        org.junit.Assert.assertArrayEquals(aCLArray86, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean88 + "' != '" + false + "'", boolean88 == false);
        org.junit.Assert.assertNull(watcherOrBitSet90);
        org.junit.Assert.assertNull(watcherOrBitSet91);
        org.junit.Assert.assertNull(watcherOrBitSet92);
        org.junit.Assert.assertNull(watcherOrBitSet94);
    }

    @Test
    public void test257() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test257");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        java.lang.String str3 = watchManager0.toString();
        java.lang.String str4 = watchManager0.toString();
        org.apache.zookeeper.Watcher.Event.EventType eventType6 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager8 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType10 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager12 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary13 = watchManager12.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType15 = null;
        org.apache.zookeeper.data.ACL[] aCLArray17 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList18 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean19 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList18, aCLArray17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet21 = watchManager12.triggerWatch("", eventType15, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList18, watcherOrBitSet20);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet22 = watchManager8.triggerWatch("", eventType10, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList18);
        org.apache.zookeeper.Watcher watcher23 = null;
        watchManager8.removeWatcher(watcher23);
        org.apache.zookeeper.Watcher.Event.EventType eventType26 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager28 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType30 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager32 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary33 = watchManager32.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType35 = null;
        org.apache.zookeeper.data.ACL[] aCLArray37 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList38 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean39 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList38, aCLArray37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager32.triggerWatch("", eventType35, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet40);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager28.triggerWatch("", eventType30, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager8.triggerWatch("", eventType26, (long) (byte) 1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet43);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet45 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet46 = watchManager0.triggerWatch("1 connections watching 1 paths\nTotal watches:1", eventType6, (long) (byte) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList38, watcherOrBitSet45);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: Range [0, -1) out of bounds for length 46");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str3, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str4, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesSummary13);
        org.junit.Assert.assertNotNull(aCLArray17);
        org.junit.Assert.assertArrayEquals(aCLArray17, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNull(watcherOrBitSet21);
        org.junit.Assert.assertNull(watcherOrBitSet22);
        org.junit.Assert.assertNotNull(watchesSummary33);
        org.junit.Assert.assertNotNull(aCLArray37);
        org.junit.Assert.assertArrayEquals(aCLArray37, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNull(watcherOrBitSet41);
        org.junit.Assert.assertNull(watcherOrBitSet42);
        org.junit.Assert.assertNull(watcherOrBitSet44);
    }

    @Test
    public void test258() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test258");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.containsWatcher("", watcher18);
        java.io.PrintWriter printWriter20 = null;
        watchManager0.dumpWatches(printWriter20, false);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test259() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test259");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager16 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType18 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager20 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary21 = watchManager20.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType23 = null;
        org.apache.zookeeper.data.ACL[] aCLArray25 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList26 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean27 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList26, aCLArray25);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet28 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet29 = watchManager20.triggerWatch("", eventType23, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26, watcherOrBitSet28);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet30 = watchManager16.triggerWatch("", eventType18, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet31 = watchManager0.triggerWatch("", eventType14, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList26);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport32 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher34 = null;
        boolean boolean35 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher34);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesSummary21);
        org.junit.Assert.assertNotNull(aCLArray25);
        org.junit.Assert.assertArrayEquals(aCLArray25, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNull(watcherOrBitSet29);
        org.junit.Assert.assertNull(watcherOrBitSet30);
        org.junit.Assert.assertNull(watcherOrBitSet31);
        org.junit.Assert.assertNotNull(watchesPathReport32);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
    }

    @Test
    public void test260() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test260");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary21 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher23 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode24 = null;
        boolean boolean25 = watchManager0.removeWatcher("hi!", watcher23, watcherMode24);
        org.apache.zookeeper.Watcher watcher27 = null;
        boolean boolean28 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher27);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertNotNull(watchesSummary21);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
    }

    @Test
    public void test261() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test261");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        boolean boolean6 = watchManager0.containsWatcher("hi!", watcher4, watcherMode5);
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.containsWatcher("", watcher8);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test262() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test262");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher3, watcherMode4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("hi!", watcher7, watcherMode8);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport10 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher12 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode13 = null;
        boolean boolean14 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher12, watcherMode13);
        java.lang.String str15 = watchManager0.toString();
        java.lang.Class<?> wildcardClass16 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesPathReport10);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str15, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(wildcardClass16);
    }

    @Test
    public void test263() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test263");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter14 = null;
        watchManager0.dumpWatches(printWriter14, true);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport17 = watchManager0.getWatchesByPath();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
        org.junit.Assert.assertNotNull(watchesPathReport17);
    }

    @Test
    public void test264() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test264");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary15 = watchManager0.getWatchesSummary();
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport17 = watchManager0.getWatches();
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap18 = watchManager0.getWatch2Paths();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport19 = watchManager0.getWatches();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesSummary15);
        org.junit.Assert.assertNotNull(watchesReport17);
        org.junit.Assert.assertNotNull(watcherMap18);
        org.junit.Assert.assertNotNull(watchesReport19);
    }

    @Test
    public void test265() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test265");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        boolean boolean6 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher4, watcherMode5);
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher8);
        org.apache.zookeeper.Watcher watcher11 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode12 = null;
        boolean boolean13 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher11, watcherMode12);
        org.apache.zookeeper.Watcher watcher14 = null;
        watchManager0.removeWatcher(watcher14);
        int int16 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 0 + "'", int16 == 0);
    }

    @Test
    public void test266() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test266");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.containsWatcher("hi!", watcher6, watcherMode7);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport9 = watchManager0.getWatchesByPath();
        int int10 = watchManager0.getRecursiveWatchQty();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watchesPathReport9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
    }

    @Test
    public void test267() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test267");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        int int15 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport16 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        boolean boolean20 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher18, watcherMode19);
        watchManager0.shutdown();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher24 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode25 = null;
        boolean boolean26 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher24, watcherMode25);
        java.lang.String str27 = watchManager0.toString();
        int int28 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNotNull(watchesReport16);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertEquals("'" + str27 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str27, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + int28 + "' != '" + 0 + "'", int28 == 0);
    }

    @Test
    public void test268() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test268");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager5 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager9 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary10 = watchManager9.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType12 = null;
        org.apache.zookeeper.data.ACL[] aCLArray14 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList15 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList15, aCLArray14);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = watchManager9.triggerWatch("", eventType12, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15, watcherOrBitSet17);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager5.triggerWatch("", eventType7, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager0.triggerWatch("", eventType3, (long) (short) 0, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList15);
        org.apache.zookeeper.Watcher watcher22 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode23 = null;
        boolean boolean24 = watchManager0.containsWatcher("", watcher22, watcherMode23);
        watchManager0.shutdown();
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport26 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher28 = null;
        boolean boolean29 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher28);
        org.apache.zookeeper.Watcher watcher31 = null;
        boolean boolean32 = watchManager0.removeWatcher("", watcher31);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(watchesSummary10);
        org.junit.Assert.assertNotNull(aCLArray14);
        org.junit.Assert.assertArrayEquals(aCLArray14, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNull(watcherOrBitSet18);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNotNull(watchesPathReport26);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
    }

    @Test
    public void test269() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test269");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        org.apache.zookeeper.Watcher.Event.EventType eventType6 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager8 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary9 = watchManager8.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType11 = null;
        org.apache.zookeeper.data.ACL[] aCLArray13 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList14 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean15 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList14, aCLArray13);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet16 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet17 = watchManager8.triggerWatch("", eventType11, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList14, watcherOrBitSet16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet18 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = watchManager0.triggerWatch("", eventType6, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList14, watcherOrBitSet18);
        org.apache.zookeeper.Watcher watcher21 = null;
        boolean boolean22 = watchManager0.addWatch("", watcher21);
        org.apache.zookeeper.Watcher watcher24 = null;
        boolean boolean25 = watchManager0.addWatch("", watcher24);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(watchesSummary9);
        org.junit.Assert.assertNotNull(aCLArray13);
        org.junit.Assert.assertArrayEquals(aCLArray13, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNull(watcherOrBitSet17);
        org.junit.Assert.assertNull(watcherOrBitSet19);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
    }

    @Test
    public void test270() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test270");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher3, watcherMode4);
        org.apache.zookeeper.Watcher watcher7 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode8 = null;
        boolean boolean9 = watchManager0.containsWatcher("hi!", watcher7, watcherMode8);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport10 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher12);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesPathReport10);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
    }

    @Test
    public void test271() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test271");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        int int15 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport16 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher watcher18 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode19 = null;
        boolean boolean20 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher18, watcherMode19);
        watchManager0.shutdown();
        java.lang.Class<?> wildcardClass22 = watchManager0.getClass();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNotNull(watchesReport16);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(wildcardClass22);
    }

    @Test
    public void test272() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test272");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport17 = watchManager0.getWatchesByPath();
        watchManager0.shutdown();
        java.io.PrintWriter printWriter19 = null;
        watchManager0.dumpWatches(printWriter19, true);
        org.apache.zookeeper.Watcher watcher22 = null;
        watchManager0.removeWatcher(watcher22);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary24 = watchManager0.getWatchesSummary();
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesPathReport17);
        org.junit.Assert.assertNotNull(watchesSummary24);
    }

    @Test
    public void test273() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test273");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        boolean boolean6 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher4, watcherMode5);
        java.lang.String str7 = watchManager0.toString();
        java.io.PrintWriter printWriter8 = null;
        watchManager0.dumpWatches(printWriter8, true);
        int int11 = watchManager0.size();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str7, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
    }

    @Test
    public void test274() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test274");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        org.apache.zookeeper.Watcher watcher6 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode7 = null;
        boolean boolean8 = watchManager0.removeWatcher("", watcher6, watcherMode7);
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap9 = watchManager0.getWatch2Paths();
        int int10 = watchManager0.size();
        java.io.PrintWriter printWriter11 = null;
        watchManager0.dumpWatches(printWriter11, true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watcherMap9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
    }

    @Test
    public void test275() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test275");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary15 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher17 = null;
        boolean boolean18 = watchManager0.removeWatcher("", watcher17);
        java.lang.String str19 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher21 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode22 = null;
        boolean boolean23 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher21, watcherMode22);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertNotNull(watchesSummary15);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str19, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
    }

    @Test
    public void test276() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test276");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        int int2 = watchManager0.size();
        org.apache.zookeeper.Watcher watcher4 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode5 = null;
        boolean boolean6 = watchManager0.containsWatcher("0 connections watching 0 paths\nTotal watches:0", watcher4, watcherMode5);
        org.apache.zookeeper.Watcher watcher8 = null;
        boolean boolean9 = watchManager0.removeWatcher("", watcher8);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport10 = watchManager0.getWatchesByPath();
        org.apache.zookeeper.Watcher watcher12 = null;
        boolean boolean13 = watchManager0.addWatch("1 connections watching 1 paths\nTotal watches:1", watcher12);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(watchesPathReport10);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
    }

    @Test
    public void test277() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test277");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        watchManager0.shutdown();
        org.apache.zookeeper.Watcher watcher3 = null;
        boolean boolean4 = watchManager0.containsWatcher("", watcher3);
        java.lang.String str5 = watchManager0.toString();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport6 = watchManager0.getWatches();
        org.apache.zookeeper.server.watch.WatchesReport watchesReport7 = watchManager0.getWatches();
        org.apache.zookeeper.Watcher.Event.EventType eventType9 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager11 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary12 = watchManager11.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType14 = null;
        org.apache.zookeeper.data.ACL[] aCLArray16 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList17 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList17, aCLArray16);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet19 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet20 = watchManager11.triggerWatch("", eventType14, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList17, watcherOrBitSet19);
        org.apache.zookeeper.Watcher watcher22 = null;
        boolean boolean23 = watchManager11.containsWatcher("hi!", watcher22);
        org.apache.zookeeper.Watcher.Event.EventType eventType25 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager27 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType29 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager31 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary32 = watchManager31.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType34 = null;
        org.apache.zookeeper.data.ACL[] aCLArray36 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList37 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean38 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList37, aCLArray36);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet39 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet40 = watchManager31.triggerWatch("", eventType34, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37, watcherOrBitSet39);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet41 = watchManager27.triggerWatch("", eventType29, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet42 = watchManager11.triggerWatch("", eventType25, (long) (byte) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet43 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet44 = watchManager0.triggerWatch("", eventType9, (long) (short) -1, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList37, watcherOrBitSet43);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str5, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertNotNull(watchesReport6);
        org.junit.Assert.assertNotNull(watchesReport7);
        org.junit.Assert.assertNotNull(watchesSummary12);
        org.junit.Assert.assertNotNull(aCLArray16);
        org.junit.Assert.assertArrayEquals(aCLArray16, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(watcherOrBitSet20);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNotNull(watchesSummary32);
        org.junit.Assert.assertNotNull(aCLArray36);
        org.junit.Assert.assertArrayEquals(aCLArray36, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertNull(watcherOrBitSet40);
        org.junit.Assert.assertNull(watcherOrBitSet41);
        org.junit.Assert.assertNull(watcherOrBitSet42);
        org.junit.Assert.assertNull(watcherOrBitSet44);
    }

    @Test
    public void test278() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test278");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher watcher3 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode4 = null;
        boolean boolean5 = watchManager0.removeWatcher("0 connections watching 0 paths\nTotal watches:0", watcher3, watcherMode4);
        org.apache.zookeeper.Watcher watcher7 = null;
        boolean boolean8 = watchManager0.containsWatcher("", watcher7);
        java.util.Map<org.apache.zookeeper.Watcher, java.util.Map<java.lang.String, org.apache.zookeeper.server.watch.WatchStats>> watcherMap9 = watchManager0.getWatch2Paths();
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(watcherMap9);
    }

    @Test
    public void test279() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test279");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.Watcher.Event.EventType eventType2 = null;
        org.apache.zookeeper.server.watch.WatchManager watchManager4 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary5 = watchManager4.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType7 = null;
        org.apache.zookeeper.data.ACL[] aCLArray9 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList10 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList10, aCLArray9);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet12 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet13 = watchManager4.triggerWatch("", eventType7, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10, watcherOrBitSet12);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet14 = watchManager0.triggerWatch("", eventType2, (long) (-1), (java.util.List<org.apache.zookeeper.data.ACL>) aCLList10);
        org.apache.zookeeper.Watcher watcher15 = null;
        watchManager0.removeWatcher(watcher15);
        org.apache.zookeeper.Watcher watcher18 = null;
        boolean boolean19 = watchManager0.addWatch("0 connections watching 0 paths\nTotal watches:0", watcher18);
        org.junit.Assert.assertNotNull(watchesSummary5);
        org.junit.Assert.assertNotNull(aCLArray9);
        org.junit.Assert.assertArrayEquals(aCLArray9, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(watcherOrBitSet13);
        org.junit.Assert.assertNull(watcherOrBitSet14);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
    }

    @Test
    public void test280() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test280");
        org.apache.zookeeper.server.watch.WatchManager watchManager0 = new org.apache.zookeeper.server.watch.WatchManager();
        org.apache.zookeeper.server.watch.WatchesSummary watchesSummary1 = watchManager0.getWatchesSummary();
        org.apache.zookeeper.Watcher.Event.EventType eventType3 = null;
        org.apache.zookeeper.data.ACL[] aCLArray5 = new org.apache.zookeeper.data.ACL[] {};
        java.util.ArrayList<org.apache.zookeeper.data.ACL> aCLList6 = new java.util.ArrayList<org.apache.zookeeper.data.ACL>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.zookeeper.data.ACL>) aCLList6, aCLArray5);
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet8 = null;
        org.apache.zookeeper.server.watch.WatcherOrBitSet watcherOrBitSet9 = watchManager0.triggerWatch("", eventType3, 0L, (java.util.List<org.apache.zookeeper.data.ACL>) aCLList6, watcherOrBitSet8);
        org.apache.zookeeper.Watcher watcher11 = null;
        boolean boolean12 = watchManager0.containsWatcher("hi!", watcher11);
        org.apache.zookeeper.server.watch.WatchesPathReport watchesPathReport13 = watchManager0.getWatchesByPath();
        java.io.PrintWriter printWriter14 = null;
        watchManager0.dumpWatches(printWriter14, true);
        int int17 = watchManager0.getRecursiveWatchQty();
        org.apache.zookeeper.Watcher watcher19 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode20 = null;
        boolean boolean21 = watchManager0.removeWatcher("1 connections watching 1 paths\nTotal watches:1", watcher19, watcherMode20);
        int int22 = watchManager0.size();
        java.lang.String str23 = watchManager0.toString();
        org.apache.zookeeper.Watcher watcher25 = null;
        org.apache.zookeeper.server.watch.WatcherMode watcherMode26 = null;
        boolean boolean27 = watchManager0.removeWatcher("", watcher25, watcherMode26);
        org.junit.Assert.assertNotNull(watchesSummary1);
        org.junit.Assert.assertNotNull(aCLArray5);
        org.junit.Assert.assertArrayEquals(aCLArray5, new org.apache.zookeeper.data.ACL[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(watcherOrBitSet9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(watchesPathReport13);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 0 + "'", int22 == 0);
        org.junit.Assert.assertEquals("'" + str23 + "' != '" + "0 connections watching 0 paths\nTotal watches:0" + "'", str23, "0 connections watching 0 paths\nTotal watches:0");
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
    }
}

