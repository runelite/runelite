import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
@Implements("Item")
public final class class28 extends class85 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 725772137
   )
   @Export("quantity")
   int field683;
   @ObfuscatedName("am")
   static int[] field684;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1916313575
   )
   @Export("id")
   int field686;
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = 436160727
   )
   static int field687;

   @ObfuscatedName("w")
   public static File method659(String var0, String var1, int var2) {
      String var3 = 0 == var2?"":"" + var2;
      class149.field2259 = new File(class48.field1098, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      class119 var8;
      File var20;
      if(class149.field2259.exists()) {
         try {
            class227 var7 = new class227(class149.field2259, "rw", 10000L);

            int var9;
            for(var8 = new class119((int)var7.method4132()); var8.field2011 < var8.field2012.length; var8.field2011 += var9) {
               var9 = var7.method4131(var8.field2012, var8.field2011, var8.field2012.length - var8.field2011);
               if(-1 == var9) {
                  throw new IOException();
               }
            }

            var8.field2011 = 0;
            var9 = var8.method2506();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.method2506();
            }

            if(var9 <= 2) {
               var4 = var8.method2515();
               if(1 == var10) {
                  var5 = var8.method2515();
               }
            } else {
               var4 = var8.method2516();
               if(var10 == 1) {
                  var5 = var8.method2516();
               }
            }

            var7.method4130();
         } catch (IOException var17) {
            var17.printStackTrace();
         }

         if(null != var4) {
            var20 = new File(var4);
            if(!var20.exists()) {
               var4 = null;
            }
         }

         if(var4 != null) {
            var20 = new File(var4, "test.dat");
            if(!class25.method638(var20, true)) {
               var4 = null;
            }
         }
      }

      if(var4 == null && 0 == var2) {
         label139:
         for(int var18 = 0; var18 < class111.field1967.length; ++var18) {
            for(int var21 = 0; var21 < class72.field1361.length; ++var21) {
               File var22 = new File(class72.field1361[var21] + class111.field1967[var18] + File.separatorChar + var0 + File.separatorChar);
               if(var22.exists() && class25.method638(new File(var22, "test.dat"), true)) {
                  var4 = var22.toString();
                  var6 = true;
                  break label139;
               }
            }
         }
      }

      if(var4 == null) {
         var4 = class48.field1098 + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      File var19;
      if(null != var5) {
         var19 = new File(var5);
         var20 = new File(var4);

         try {
            File[] var23 = var19.listFiles();
            File[] var25 = var23;

            for(int var11 = 0; var11 < var25.length; ++var11) {
               File var12 = var25[var11];
               File var13 = new File(var20, var12.getName());
               boolean var14 = var12.renameTo(var13);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var16) {
            var16.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         var19 = new File(var4);
         var8 = null;

         try {
            class227 var24 = new class227(class149.field2259, "rw", 10000L);
            class119 var26 = new class119(500);
            var26.method2573(3);
            var26.method2573(null != var8?1:0);
            var26.method2572(var19.getPath());
            if(null != var8) {
//               var26.method2572(var8.getPath());
            }

            var24.method4143(var26.field2012, 0, var26.field2011);
            var24.method4130();
         } catch (IOException var15) {
            var15.printStackTrace();
         }
      }

      return new File(var4);
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(IIIILclass78;Lclass175;I)V",
      garbageValue = "-1698269229"
   )
   static final void method660(int var0, int var1, int var2, int var3, class78 var4, class175 var5) {
      if(var4 != null) {
         int var6 = client.field365 + client.field388 & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class91.field1573[var6];
            int var9 = class91.field1595[var6];
            var8 = 256 * var8 / (256 + client.field367);
            var9 = var9 * 256 / (256 + client.field367);
            int var10 = var2 * var9 + var3 * var8 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method1709(var5.field2911 / 2 + var10 - var4.field1401 / 2, var5.field2912 / 2 - var11 - var4.field1409 / 2, var0, var1, var5.field2911, var5.field2912, var5.field2909, var5.field2914);
            } else {
               var4.method1699(var10 + var0 + var5.field2911 / 2 - var4.field1401 / 2, var5.field2912 / 2 + var1 - var11 - var4.field1409 / 2);
            }

         }
      }
   }

   @ObfuscatedName("t")
   protected final class105 vmethod1901() {
      return class50.method1055(this.field686).method1084(this.field683);
   }

   @ObfuscatedName("d")
   public static void method662() {
      class173.field2843.method3776();
      class173.field2854.method3776();
      class173.field2758.method3776();
      class173.field2764.method3776();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[Lclass108;I)V",
      garbageValue = "641400415"
   )
   static final void method663(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, class108[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var9 + var2 > 0 && var9 + var2 < 103 && var3 + var10 > 0 && var10 + var3 < 103) {
               var8[var1].field1894[var2 + var9][var10 + var3] &= -16777217;
            }
         }
      }

      class119 var28 = new class119(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var4 == var10 && var11 >= var5 && var11 < 8 + var5 && var12 >= var6 && var12 < var6 + 8) {
                  int var17 = var11 & 7;
                  int var18 = var12 & 7;
                  int var19 = var7 & 3;
                  int var16;
                  if(0 == var19) {
                     var16 = var17;
                  } else if(1 == var19) {
                     var16 = var18;
                  } else if(2 == var19) {
                     var16 = 7 - var17;
                  } else {
                     var16 = 7 - var18;
                  }

                  int var22 = var2 + var16;
                  int var25 = var11 & 7;
                  int var26 = var12 & 7;
                  int var27 = var7 & 3;
                  int var24;
                  if(var27 == 0) {
                     var24 = var26;
                  } else if(1 == var27) {
                     var24 = 7 - var25;
                  } else if(var27 == 2) {
                     var24 = 7 - var26;
                  } else {
                     var24 = var25;
                  }

                  class152.method3178(var28, var1, var22, var24 + var3, 0, 0, var7);
               } else {
                  class152.method3178(var28, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }
}
