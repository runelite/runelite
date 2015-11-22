package net.runelite.rs.client;

import java.util.Calendar;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ap")
public class class36 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1608449863
   )
   static int field780 = 0;
   @ObfuscatedName("f")
   static int[] field782;
   @ObfuscatedName("l")
   static String[] field783;
   @ObfuscatedName("z")
   static final String[] field784 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("h")
   static int[] field786 = new int[1000];
   @ObfuscatedName("i")
   static String[] field787 = new String[1000];
   @ObfuscatedName("u")
   static int[] field788 = new int[5];
   @ObfuscatedName("k")
   static class14[] field789 = new class14[50];
   @ObfuscatedName("e")
   static Calendar field790 = Calendar.getInstance();
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -949942251
   )
   static int field791 = 0;
   @ObfuscatedName("a")
   static int[][] field792 = new int[5][5000];
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = -2028770867
   )
   static int field793;

   @ObfuscatedName("u")
   public static class78[] method780(class166 var0, String var1, String var2) {
      int var3 = var0.method3327(var1);
      int var4 = var0.method3323(var3, var2);
      class78[] var5;
      if(!class46.method1007(var0, var3, var4)) {
         var5 = null;
      } else {
         class78[] var7 = new class78[class76.field1379];

         for(int var8 = 0; var8 < class76.field1379; ++var8) {
            class78 var9 = var7[var8] = new class78();
            var9.field1388 = class76.field1367;
            var9.field1399 = class76.field1368;
            var9.field1391 = class76.field1366[var8];
            var9.field1392 = class76.field1370[var8];
            var9.field1389 = class76.field1371[var8];
            var9.field1390 = class76.field1373[var8];
            int var10 = var9.field1390 * var9.field1389;
            byte[] var11 = class17.field236[var8];
            var9.field1394 = new int[var10];

            for(int var12 = 0; var12 < var10; ++var12) {
               var9.field1394[var12] = class76.field1369[var11[var12] & 255];
            }
         }

         class135.method2935();
         var5 = var7;
      }

      return var5;
   }

   @ObfuscatedName("c")
   public static final class56 method788(class135 var0, int var1, int var2) {
      if(0 == class56.field1183) {
         throw new IllegalStateException();
      } else {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            class69 var6 = new class69();
            var6.field1165 = new int[(class228.field3215?2:1) * 256];
            var6.field1170 = var2;
            var6.vmethod1529();
            var6.field1169 = (var2 & -1024) + 1024;
            if(var6.field1169 > 16384) {
               var6.field1169 = 16384;
            }

            var6.vmethod1530(var6.field1169);
            if(class56.field1162 > 0 && null == class28.field659) {
               class28.field659 = new class72();
               class28.field659.field1342 = var0;
               var0.method2919(class28.field659, class56.field1162);
            }

            if(class28.field659 != null) {
               if(class28.field659.field1340[var1] != null) {
                  throw new IllegalArgumentException();
               }

               class28.field659.field1340[var1] = var6;
            }

            return var6;
         } catch (Throwable var5) {
            try {
               class54 var3 = new class54(var0, var1);
               var3.field1165 = new int[(class228.field3215?2:1) * 256];
               var3.field1170 = var2;
               var3.vmethod1529();
               var3.field1169 = 16384;
               var3.vmethod1530(var3.field1169);
               if(class56.field1162 > 0 && null == class28.field659) {
                  class28.field659 = new class72();
                  class28.field659.field1342 = var0;
                  var0.method2919(class28.field659, class56.field1162);
               }

               if(class28.field659 != null) {
                  if(class28.field659.field1340[var1] != null) {
                     throw new IllegalArgumentException();
                  }

                  class28.field659.field1340[var1] = var3;
               }

               return var3;
            } catch (Throwable var4) {
               return new class56();
            }
         }
      }
   }
}
