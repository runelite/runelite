import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
public class class117 {
   @ObfuscatedName("v")
   static class170 field2027;
   @ObfuscatedName("gd")
   static Widget field2030;
   @ObfuscatedName("g")
   public static class62 field2031;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILRegion;[LCollisionData;I)V",
      garbageValue = "-2062695287"
   )
   static final void method2509(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Region var8, CollisionData[] var9) {
      Buffer var10 = new Buffer(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.method2554();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.method2554();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.method2571();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var17 == var4 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < 8 + var6) {
               ObjectComposition var21 = Projectile.getObjectDefinition(var11);
               int var22 = var2 + class118.method2513(var16 & 7, var15 & 7, var7, var21.field950, var21.field948, var20);
               int var23 = var3 + class23.method591(var16 & 7, var15 & 7, var7, var21.field950, var21.field948, var20);
               if(var22 > 0 && var23 > 0 && var22 < 103 && var23 < 103) {
                  int var24 = var1;
                  if((class5.tileSettings[1][var22][var23] & 2) == 2) {
                     var24 = var1 - 1;
                  }

                  CollisionData var25 = null;
                  if(var24 >= 0) {
                     var25 = var9[var24];
                  }

                  class35.method738(var1, var22, var23, var11, var20 + var7 & 3, var19, var8, var25);
               }
            }
         }
      }
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "18"
   )
   static void method2510() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         int var2 = Client.menuTypes[var0];
         boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
         if(var1) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var3 = var0; var3 < Client.menuOptionCount - 1; ++var3) {
                  Client.menuOptions[var3] = Client.menuOptions[1 + var3];
                  Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
                  Client.menuTypes[var3] = Client.menuTypes[1 + var3];
                  Client.menuIdentifiers[var3] = Client.menuIdentifiers[var3 + 1];
                  Client.menuActionParams0[var3] = Client.menuActionParams0[1 + var3];
                  Client.menuActionParams1[var3] = Client.menuActionParams1[var3 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }
}
