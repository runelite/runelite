import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
final class class3 implements class0 {
   @ObfuscatedName("v")
   static SpritePixels field19;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)I",
      garbageValue = "1"
   )
   public static int method9(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(LPendingSpawn;I)V",
      garbageValue = "1987773958"
   )
   static final void method10(PendingSpawn var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.type == 0) {
         var1 = class2.region.method2692(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = class2.region.method2794(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = class2.region.method2694(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = class2.region.method2695(var0.level, var0.x, var0.y);
      }

      if(var1 != 0) {
         int var5 = class2.region.method2696(var0.level, var0.x, var0.y, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1209 = var2;
      var0.field1222 = var3;
      var0.field1214 = var4;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILRegion;[LCollisionData;I)V",
      garbageValue = "2001651162"
   )
   static final void method11(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Region var8, CollisionData[] var9) {
      Buffer var10 = new Buffer(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.getUSmart();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.getUSmart();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.readUnsignedByte();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var17 == var4 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
               ObjectComposition var21 = class251.getObjectDefinition(var11);
               int var22 = var2 + method9(var16 & 7, var15 & 7, var7, var21.sizeX, var21.sizeY, var20);
               int var23 = var3 + class54.method816(var16 & 7, var15 & 7, var7, var21.sizeX, var21.sizeY, var20);
               if(var22 > 0 && var23 > 0 && var22 < 103 && var23 < 103) {
                  int var24 = var1;
                  if((class61.tileSettings[1][var22][var23] & 2) == 2) {
                     var24 = var1 - 1;
                  }

                  CollisionData var25 = null;
                  if(var24 >= 0) {
                     var25 = var9[var24];
                  }

                  class211.addObject(var1, var22, var23, var11, var20 + var7 & 3, var19, var8, var25);
               }
            }
         }
      }
   }
}
