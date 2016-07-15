import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public final class class5 {
   @ObfuscatedName("y")
   static final int[] field77 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("e")
   @Export("tileHeights")
   static int[][][] field78 = new int[4][105][105];
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2029410325
   )
   static int field79 = 99;
   @ObfuscatedName("h")
   static byte[][][] field80;
   @ObfuscatedName("b")
   static byte[][][] field81;
   @ObfuscatedName("k")
   static final int[] field82 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("u")
   static byte[][][] field83;
   @ObfuscatedName("p")
   static int[] field84;
   @ObfuscatedName("i")
   static int[] field85;
   @ObfuscatedName("z")
   static final int[] field87 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("m")
   static final int[] field88 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("l")
   @Export("tileSettings")
   static byte[][][] field89 = new byte[4][104][104];
   @ObfuscatedName("v")
   static final int[] field90 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("r")
   static byte[][][] field91;
   @ObfuscatedName("n")
   static final int[] field92 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -565670287
   )
   static int field93 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -337327173
   )
   static int field94 = (int)(Math.random() * 33.0D) - 16;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Lclass53;",
      garbageValue = "-544211474"
   )
   public static class53 method52(int var0) {
      class53 var1 = (class53)class53.field1160.method3834((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class53.field1159.method3340(15, var0);
         var1 = new class53();
         if(null != var2) {
            var1.method1135(new class122(var2));
         }

         class53.field1160.method3836(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(Lclass16;I)V",
      garbageValue = "-33066936"
   )
   static final void method53(class16 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field231 == 0) {
         var1 = class79.field1453.method2029(var0.field238, var0.field232, var0.field242);
      }

      if(var0.field231 == 1) {
         var1 = class79.field1453.method2050(var0.field238, var0.field232, var0.field242);
      }

      if(var0.field231 == 2) {
         var1 = class79.field1453.method2152(var0.field238, var0.field232, var0.field242);
      }

      if(var0.field231 == 3) {
         var1 = class79.field1453.method2165(var0.field238, var0.field232, var0.field242);
      }

      if(var1 != 0) {
         int var5 = class79.field1453.method2039(var0.field238, var0.field232, var0.field242, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field234 = var2;
      var0.field233 = var3;
      var0.field235 = var4;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-438273165"
   )
   static final void method71() {
      for(class31 var0 = (class31)client.field429.method3899(); var0 != null; var0 = (class31)client.field429.method3918()) {
         if(var0.field735 == class50.field1119 && !var0.field736) {
            if(client.field567 >= var0.field728) {
               var0.method671(client.field485);
               if(var0.field736) {
                  var0.method4000();
               } else {
                  class79.field1453.method2020(var0.field735, var0.field730, var0.field731, var0.field732, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.method4000();
         }
      }

   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "71"
   )
   static void method73(int var0) {
      class11.field189 = new class32();
      class11.field189.field749 = client.field436[var0];
      class11.field189.field746 = client.field437[var0];
      class11.field189.field748 = client.field438[var0];
      class11.field189.field747 = client.field303[var0];
      class11.field189.field750 = client.field440[var0];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;I)V",
      garbageValue = "-686679608"
   )
   public static void method74(File var0, File var1) {
      try {
         class230 var2 = new class230(class152.field2280, "rw", 10000L);
         class122 var3 = new class122(500);
         var3.method2795(3);
         var3.method2795(null != var1?1:0);
         var3.method2683(var0.getPath());
         if(null != var1) {
            var3.method2683(var1.getPath());
         }

         var2.method4212(var3.field2054, 0, var3.field2061);
         var2.method4213();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Lclass48;",
      garbageValue = "-38"
   )
   public static class48 method75(int var0) {
      class48 var1 = (class48)class48.field1093.method3834((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class212.field3164.method3340(4, var0);
         var1 = new class48();
         if(null != var2) {
            var1.method1038(new class122(var2), var0);
         }

         var1.method1029();
         class48.field1093.method3836(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1319014546"
   )
   static final void method76(boolean var0) {
      while(true) {
         if(client.field338.method2861(client.field532) >= 27) {
            int var1 = client.field338.method2859(15);
            if(var1 != 32767) {
               boolean var2 = false;
               if(client.field331[var1] == null) {
                  client.field331[var1] = new class36();
                  var2 = true;
               }

               class36 var3 = client.field331[var1];
               client.field333[++client.field332 - 1] = var1;
               var3.field899 = client.field567;
               int var4 = client.field548[client.field338.method2859(3)];
               if(var2) {
                  var3.field889 = var3.field905 = var4;
               }

               var3.field825 = class59.method1282(client.field338.method2859(14));
               int var5;
               if(var0) {
                  var5 = client.field338.method2859(8);
                  if(var5 > 127) {
                     var5 -= 256;
                  }
               } else {
                  var5 = client.field338.method2859(5);
                  if(var5 > 15) {
                     var5 -= 32;
                  }
               }

               int var6;
               if(var0) {
                  var6 = client.field338.method2859(8);
                  if(var6 > 127) {
                     var6 -= 256;
                  }
               } else {
                  var6 = client.field338.method2859(5);
                  if(var6 > 15) {
                     var6 -= 32;
                  }
               }

               int var7 = client.field338.method2859(1);
               if(var7 == 1) {
                  client.field335[++client.field334 - 1] = var1;
               }

               int var8 = client.field338.method2859(1);
               var3.field851 = var3.field825.field924;
               var3.field903 = var3.field825.field954;
               if(var3.field903 == 0) {
                  var3.field905 = 0;
               }

               var3.field858 = var3.field825.field953;
               var3.field850 = var3.field825.field931;
               var3.field860 = var3.field825.field932;
               var3.field861 = var3.field825.field933;
               var3.field854 = var3.field825.field950;
               var3.field856 = var3.field825.field928;
               var3.field857 = var3.field825.field929;
               var3.method752(class118.field2035.field885[0] + var5, class118.field2035.field906[0] + var6, var8 == 1);
               continue;
            }
         }

         client.field338.method2860();
         return;
      }
   }
}
