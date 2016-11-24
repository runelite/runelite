import java.applet.Applet;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
public class class114 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -662480843
   )
   public static int field1792;
   @ObfuscatedName("n")
   public static Applet field1793 = null;
   @ObfuscatedName("d")
   public static String field1794 = null;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "-30482"
   )
   public static int method2247(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-66"
   )
   static void method2249(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class225.field3212 = var1.method3097();
      class225.field3213 = new int[class225.field3212];
      class225.field3214 = new int[class225.field3212];
      class225.field3215 = new int[class225.field3212];
      class225.field3219 = new int[class225.field3212];
      class225.field3218 = new byte[class225.field3212][];
      var1.offset = var0.length - 7 - class225.field3212 * 8;
      class225.field3211 = var1.method3097();
      class225.field3216 = var1.method3097();
      int var2 = (var1.method3033() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class225.field3212; ++var3) {
         class225.field3213[var3] = var1.method3097();
      }

      for(var3 = 0; var3 < class225.field3212; ++var3) {
         class225.field3214[var3] = var1.method3097();
      }

      for(var3 = 0; var3 < class225.field3212; ++var3) {
         class225.field3215[var3] = var1.method3097();
      }

      for(var3 = 0; var3 < class225.field3212; ++var3) {
         class225.field3219[var3] = var1.method3097();
      }

      var1.offset = var0.length - 7 - class225.field3212 * 8 - 3 * (var2 - 1);
      class225.field3210 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class225.field3210[var3] = var1.method2994();
         if(class225.field3210[var3] == 0) {
            class225.field3210[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class225.field3212; ++var3) {
         int var4 = class225.field3215[var3];
         int var5 = class225.field3219[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         class225.field3218[var3] = var7;
         int var8 = var1.method3033();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.method3047();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var10 * var4] = var1.method3047();
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIILRegion;[LCollisionData;I)V",
      garbageValue = "-1091887015"
   )
   static final void method2252(byte[] var0, int var1, int var2, Region var3, CollisionData[] var4) {
      Buffer var5 = new Buffer(var0);
      int var6 = -1;

      while(true) {
         int var7 = var5.method3003();
         if(var7 == 0) {
            return;
         }

         var6 += var7;
         int var8 = 0;

         while(true) {
            int var9 = var5.method3003();
            if(var9 == 0) {
               break;
            }

            var8 += var9 - 1;
            int var10 = var8 & 63;
            int var11 = var8 >> 6 & 63;
            int var12 = var8 >> 12;
            int var13 = var5.method3033();
            int var14 = var13 >> 2;
            int var15 = var13 & 3;
            int var16 = var11 + var1;
            int var17 = var10 + var2;
            if(var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
               int var18 = var12;
               if((class11.tileSettings[1][var16][var17] & 2) == 2) {
                  var18 = var12 - 1;
               }

               CollisionData var19 = null;
               if(var18 >= 0) {
                  var19 = var4[var18];
               }

               class163.method3198(var12, var16, var17, var6, var15, var14, var3, var19);
            }
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[LCollisionData;I)V",
      garbageValue = "-213740650"
   )
   static final void method2253(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionData[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var2 + var9 > 0 && var2 + var9 < 103 && var3 + var10 > 0 && var10 + var3 < 103) {
               var8[var1].flags[var2 + var9][var3 + var10] &= -16777217;
            }
         }
      }

      Buffer var21 = new Buffer(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var10 == var4 && var11 >= var5 && var11 < 8 + var5 && var12 >= var6 && var12 < var6 + 8) {
                  int var15 = var2 + class109.method2095(var11 & 7, var12 & 7, var7);
                  int var18 = var11 & 7;
                  int var19 = var12 & 7;
                  int var20 = var7 & 3;
                  int var17;
                  if(var20 == 0) {
                     var17 = var19;
                  } else if(var20 == 1) {
                     var17 = 7 - var18;
                  } else if(var20 == 2) {
                     var17 = 7 - var19;
                  } else {
                     var17 = var18;
                  }

                  Player.method255(var21, var1, var15, var17 + var3, 0, 0, var7);
               } else {
                  Player.method255(var21, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }
}
