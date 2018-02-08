import java.util.LinkedHashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = -1588215843
   )
   @Export("port2")
   static int port2;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -831791623
   )
   @Export("x")
   int x;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -797446091
   )
   @Export("y")
   int y;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1314566197
   )
   @Export("z")
   int z;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIILfj;Lfb;Z[I[II)I",
      garbageValue = "-2060344855"
   )
   public static int method3116(int var0, int var1, int var2, class168 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class167.field2224[var8][var9] = 0;
            class167.field2222[var8][var9] = 99999999;
         }
      }

      int var10;
      int var11;
      byte var13;
      int var14;
      int var15;
      int var17;
      int var19;
      int var20;
      int var21;
      boolean var28;
      int var30;
      int var31;
      int var33;
      if(var2 == 1) {
         var10 = var0;
         var11 = var1;
         byte var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class167.field2224[var12][var13] = 99;
         class167.field2222[var12][var13] = 0;
         byte var16 = 0;
         var17 = 0;
         class167.field2219[var16] = var0;
         var33 = var16 + 1;
         class167.field2225[var16] = var1;
         int[][] var18 = var4.flags;

         boolean var29;
         while(true) {
            if(var17 == var33) {
               VarPlayerType.field3371 = var10;
               class175.field2446 = var11;
               var29 = false;
               break;
            }

            var10 = class167.field2219[var17];
            var11 = class167.field2225[var17];
            var17 = var17 + 1 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod3396(1, var10, var11, var4)) {
               VarPlayerType.field3371 = var10;
               class175.field2446 = var11;
               var29 = true;
               break;
            }

            var21 = class167.field2222[var30][var31] + 1;
            if(var30 > 0 && class167.field2224[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136776) == 0) {
               class167.field2219[var33] = var10 - 1;
               class167.field2225[var33] = var11;
               var33 = var33 + 1 & 4095;
               class167.field2224[var30 - 1][var31] = 2;
               class167.field2222[var30 - 1][var31] = var21;
            }

            if(var30 < 127 && class167.field2224[var30 + 1][var31] == 0 && (var18[var19 + 1][var20] & 19136896) == 0) {
               class167.field2219[var33] = var10 + 1;
               class167.field2225[var33] = var11;
               var33 = var33 + 1 & 4095;
               class167.field2224[var30 + 1][var31] = 8;
               class167.field2222[var30 + 1][var31] = var21;
            }

            if(var31 > 0 && class167.field2224[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class167.field2219[var33] = var10;
               class167.field2225[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class167.field2224[var30][var31 - 1] = 1;
               class167.field2222[var30][var31 - 1] = var21;
            }

            if(var31 < 127 && class167.field2224[var30][var31 + 1] == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class167.field2219[var33] = var10;
               class167.field2225[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class167.field2224[var30][var31 + 1] = 4;
               class167.field2222[var30][var31 + 1] = var21;
            }

            if(var30 > 0 && var31 > 0 && class167.field2224[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class167.field2219[var33] = var10 - 1;
               class167.field2225[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class167.field2224[var30 - 1][var31 - 1] = 3;
               class167.field2222[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 127 && var31 > 0 && class167.field2224[var30 + 1][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class167.field2219[var33] = var10 + 1;
               class167.field2225[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class167.field2224[var30 + 1][var31 - 1] = 9;
               class167.field2222[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 127 && class167.field2224[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + 1] & 19136824) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class167.field2219[var33] = var10 - 1;
               class167.field2225[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class167.field2224[var30 - 1][var31 + 1] = 6;
               class167.field2222[var30 - 1][var31 + 1] = var21;
            }

            if(var30 < 127 && var31 < 127 && class167.field2224[var30 + 1][var31 + 1] == 0 && (var18[var19 + 1][var20 + 1] & 19136992) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class167.field2219[var33] = var10 + 1;
               class167.field2225[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class167.field2224[var30 + 1][var31 + 1] = 12;
               class167.field2222[var30 + 1][var31 + 1] = var21;
            }
         }

         var28 = var29;
      } else if(var2 == 2) {
         var28 = class160.method3260(var0, var1, var3, var4);
      } else {
         var28 = class5.method15(var0, var1, var2, var3, var4);
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = VarPlayerType.field3371;
      var30 = class175.field2446;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field2229;
         var17 = var3.field2228;
         int var27 = var3.field2233;
         var19 = var3.field2231;

         for(var20 = var33 - var32; var20 <= var32 + var33; ++var20) {
            for(var21 = var17 - var32; var21 <= var17 + var32; ++var21) {
               int var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class167.field2222[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var33) {
                     var24 = var33 - var20;
                  } else if(var20 > var33 + var27 - 1) {
                     var24 = var20 - (var33 + var27 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var17 + var19 - 1) {
                     var25 = var21 - (var19 + var17 - 1);
                  }

                  int var26 = var24 * var24 + var25 * var25;
                  if(var26 < var31 || var26 == var31 && class167.field2222[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class167.field2222[var22][var23];
                     var11 = var20;
                     var30 = var21;
                  }
               }
            }
         }

         if(var31 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var11 && var30 == var1) {
         return 0;
      } else {
         var13 = 0;
         class167.field2219[var13] = var11;
         var31 = var13 + 1;
         class167.field2225[var13] = var30;

         for(var14 = var15 = class167.field2224[var11 - var9][var30 - var10]; var0 != var11 || var30 != var1; var14 = class167.field2224[var11 - var9][var30 - var10]) {
            if(var14 != var15) {
               var15 = var14;
               class167.field2219[var31] = var11;
               class167.field2225[var31++] = var30;
            }

            if((var14 & 2) != 0) {
               ++var11;
            } else if((var14 & 8) != 0) {
               --var11;
            }

            if((var14 & 1) != 0) {
               ++var30;
            } else if((var14 & 4) != 0) {
               --var30;
            }
         }

         var33 = 0;

         while(var31-- > 0) {
            var6[var33] = class167.field2219[var31];
            var7[var33++] = class167.field2225[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lfh;",
      garbageValue = "-285993907"
   )
   public static Timer method3115() {
      try {
         return new NanoTimer();
      } catch (Throwable var1) {
         return new MilliTimer();
      }
   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "6000"
   )
   static final void method3113(boolean var0) {
      if(var0) {
         Client.field877 = class89.field1346?class148.field2083:class148.field2084;
      } else {
         LinkedHashMap var1 = WorldComparator.preferences.preferences;
         String var3 = class89.username;
         int var4 = var3.length();
         int var5 = 0;

         for(int var6 = 0; var6 < var4; ++var6) {
            var5 = (var5 << 5) - var5 + var3.charAt(var6);
         }

         Client.field877 = var1.containsKey(Integer.valueOf(var5))?class148.field2085:class148.field2086;
      }

   }

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-30"
   )
   static final void method3114() {
      if(class60.plane != Client.field1049) {
         Client.field1049 = class60.plane;
         Size.method175(class60.plane);
      }

   }
}
