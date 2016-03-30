import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class38 extends class207 {
   @ObfuscatedName("x")
   String field877;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1245610771
   )
   int field881 = (int)(class14.method165() / 1000L);
   @ObfuscatedName("t")
   short field884;

   @ObfuscatedName("y")
   static int method782(class25 var0, class25 var1, int var2, boolean var3) {
      if(1 == var2) {
         int var4 = var0.field638;
         int var5 = var1.field638;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(-1 == var5) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.field648 - var1.field648:(3 == var2?(var0.field639.equals("-")?(var1.field639.equals("-")?0:(var3?-1:1)):(var1.field639.equals("-")?(var3?1:-1):var0.field639.compareTo(var1.field639))):(4 == var2?(var0.method642()?(var1.method642()?0:1):(var1.method642()?-1:0)):(var2 == 5?(var0.method613()?(var1.method613()?0:1):(var1.method613()?-1:0)):(6 == var2?(var0.method622()?(var1.method622()?0:1):(var1.method622()?-1:0)):(7 == var2?(var0.method635()?(var1.method635()?0:1):(var1.method635()?-1:0)):var0.field650 - var1.field650)))));
      }
   }

   @ObfuscatedName("t")
   public static String method783(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class165.field2681[var6 - 128];
               if(0 == var7) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "1927"
   )
   static final void method784(int var0) {
      short var1 = 256;
      class31.field723 += var0 * 128;
      int var2;
      if(class31.field723 > class4.field87.length) {
         class31.field723 -= class4.field87.length;
         var2 = (int)(Math.random() * 12.0D);
         class40.method871(class139.field2162[var2]);
      }

      var2 = 0;
      int var3 = var0 * 128;
      int var4 = 128 * (var1 - var0);

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = class48.field1097[var3 + var2] - class4.field87[class31.field723 + var2 & class4.field87.length - 1] * var0 / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         class48.field1097[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = 128 * var5;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               class48.field1097[var7 + var6] = 255;
            } else {
               class48.field1097[var6 + var7] = 0;
            }
         }
      }

      if(class31.field716 > 0) {
         class31.field716 -= var0 * 4;
      }

      if(class31.field721 > 0) {
         class31.field721 -= 4 * var0;
      }

      if(0 == class31.field716 && class31.field721 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class31.field716 = 1024;
         }

         if(var5 == 1) {
            class31.field721 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class31.field719[var5] = class31.field719[var0 + var5];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class31.field719[var5] = (int)(Math.sin((double)class31.field726 / 14.0D) * 16.0D + Math.sin((double)class31.field726 / 15.0D) * 14.0D + Math.sin((double)class31.field726 / 16.0D) * 12.0D);
         ++class31.field726;
      }

      class31.field733 += var0;
      var5 = ((client.field305 & 1) + var0) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class31.field733 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            class48.field1097[(var8 << 7) + var7] = 192;
         }

         class31.field733 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var9 + var5 < 128) {
                  var7 += class48.field1097[var9 + var8 + var5];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= class48.field1097[var8 + var9 - (1 + var5)];
               }

               if(var9 >= 0) {
                  class28.field684[var8 + var9] = var7 / (2 * var5 + 1);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = var8 * 128;
               if(var5 + var8 < var1) {
                  var7 += class28.field684[var9 + var6 + var5 * 128];
               }

               if(var8 - (var5 + 1) >= 0) {
                  var7 -= class28.field684[var9 + var6 - 128 * (1 + var5)];
               }

               if(var8 >= 0) {
                  class48.field1097[var9 + var6] = var7 / (1 + 2 * var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-96"
   )
   static final void method785() {
      if(null != class9.field173) {
         class9.field173.method3005();
         class9.field173 = null;
      }

      class0.method1();
      class3.field75.method2045();

      for(int var0 = 0; var0 < 4; ++var0) {
         client.field372[var0].method2394();
      }

      System.gc();
      class52.method1116(2);
      client.field532 = -1;
      client.field496 = false;
      class10.method126();
      class138.method2937(10);
   }

   class38(String var1, int var2) {
      this.field877 = var1;
      this.field884 = (short)var2;
   }

   @ObfuscatedName("p")
   public static void method786(int var0, class167 var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.method3303(var2);
      int var7 = var1.method3289(var6, var3);
      class183.field2968 = 1;
      class151.field2279 = var1;
      class72.field1358 = var6;
      class183.field2964 = var7;
      class183.field2970 = var4;
      class14.field225 = var5;
      class75.field1384 = var0;
   }
}
