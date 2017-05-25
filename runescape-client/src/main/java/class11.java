import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public class class11 {
   @ObfuscatedName("h")
   public static final class11 field263;
   @ObfuscatedName("b")
   static int[] field264;
   @ObfuscatedName("i")
   public static final class11 field267;

   static {
      field267 = new class11();
      field263 = new class11();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[LCollisionData;I)V",
      garbageValue = "-1929599291"
   )
   static final void method46(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionData[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var2 + var9 > 0 && var2 + var9 < 103 && var3 + var10 > 0 && var10 + var3 < 103) {
               var8[var1].flags[var2 + var9][var10 + var3] &= -16777217;
            }
         }
      }

      Buffer var28 = new Buffer(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var10 == var4 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < var6 + 8) {
                  int var17 = var11 & 7;
                  int var18 = var12 & 7;
                  int var19 = var7 & 3;
                  int var16;
                  if(var19 == 0) {
                     var16 = var17;
                  } else if(var19 == 1) {
                     var16 = var18;
                  } else if(var19 == 2) {
                     var16 = 7 - var17;
                  } else {
                     var16 = 7 - var18;
                  }

                  int var22 = var16 + var2;
                  int var25 = var11 & 7;
                  int var26 = var12 & 7;
                  int var27 = var7 & 3;
                  int var24;
                  if(var27 == 0) {
                     var24 = var26;
                  } else if(var27 == 1) {
                     var24 = 7 - var25;
                  } else if(var27 == 2) {
                     var24 = 7 - var26;
                  } else {
                     var24 = var25;
                  }

                  class146.method2936(var28, var1, var22, var3 + var24, 0, 0, var7);
               } else {
                  class146.method2936(var28, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "-489809811"
   )
   public static void method47(String var0, boolean var1, boolean var2) {
      class15.method84(var0, var1, "openjs", var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "709487881"
   )
   static final int method48(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = RSCanvas.method782(var3, var5);
      int var8 = RSCanvas.method782(var3 + 1, var5);
      int var9 = RSCanvas.method782(var3, var5 + 1);
      int var10 = RSCanvas.method782(var3 + 1, var5 + 1);
      int var11 = class34.method493(var7, var8, var4, var2);
      int var12 = class34.method493(var9, var10, var4, var2);
      return class34.method493(var11, var12, var6, var2);
   }
}
