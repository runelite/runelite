package net.runelite.rs.client;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("j")
public class class0 extends class207 {
   @ObfuscatedName("s")
   int field0;
   @ObfuscatedName("m")
   boolean field1;
   @ObfuscatedName("f")
   class172 field2;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -54094355
   )
   int field3;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 181855361
   )
   int field4;
   @ObfuscatedName("k")
   String field6;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2008217447
   )
   int field7;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1173073117
   )
   int field8;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = 769342757
   )
   static int field9;
   @ObfuscatedName("j")
   Object[] field10;
   @ObfuscatedName("hl")
   @Export("localPlayer")
   static class2 field12;
   @ObfuscatedName("x")
   public static String field14;
   @ObfuscatedName("h")
   class172 field15;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1297405053
   )
   int field16;

   @ObfuscatedName("f")
   static boolean method0(String var0) {
      if(var0 == null) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }

   @ObfuscatedName("w")
   public static void method1() {
      class42.field986.method3806();
      class42.field972.method3806();
   }

   @ObfuscatedName("am")
   static void method2() {
      int var0 = class129.field2048;
      int var1 = class136.field2101;
      if(class18.field252 < var0) {
         var0 = class18.field252;
      }

      if(class22.field585 < var1) {
         var1 = class22.field585;
      }

      if(null != class153.field2277) {
         try {
            class131.method2877(client.field274, "resize", new Object[]{Integer.valueOf(class27.method688())});
         } catch (Throwable var3) {
            ;
         }
      }

   }

   @ObfuscatedName("m")
   public static boolean method3(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("l")
   public static class80 method4(class166 var0, String var1, String var2) {
      int var3 = var0.method3327(var1);
      int var4 = var0.method3323(var3, var2);
      class80 var5;
      if(!class46.method1007(var0, var3, var4)) {
         var5 = null;
      } else {
         class80 var7 = new class80();
         var7.field1413 = class76.field1367;
         var7.field1414 = class76.field1368;
         var7.field1411 = class76.field1366[0];
         var7.field1409 = class76.field1370[0];
         var7.field1407 = class76.field1371[0];
         var7.field1410 = class76.field1373[0];
         var7.field1412 = class76.field1369;
         var7.field1408 = class17.field236[0];
         class135.method2935();
         var5 = var7;
      }

      return var5;
   }
}
