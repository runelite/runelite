import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class64 {
   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "-32"
   )
   static final void method1137(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.lowMemory && var0 != class35.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class36.region.method2728(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class36.region.method2782(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class36.region.method2730(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class36.region.method2731(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class36.region.method2825(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class36.region.method2788(var0, var2, var3);
               var12 = class37.getObjectDefinition(var13);
               if(var12.interactType != 0) {
                  Client.collisionMaps[var0].removeWall(var2, var3, var14, var15, var12.field3444);
               }
            }

            if(var1 == 1) {
               class36.region.method2797(var0, var2, var3);
            }

            if(var1 == 2) {
               class36.region.method2721(var0, var2, var3);
               var12 = class37.getObjectDefinition(var13);
               if(var2 + var12.sizeX > 103 || var3 + var12.sizeX > 103 || var2 + var12.sizeY > 103 || var3 + var12.sizeY > 103) {
                  return;
               }

               if(var12.interactType != 0) {
                  Client.collisionMaps[var0].removeObject(var2, var3, var12.sizeX, var12.sizeY, var15, var12.field3444);
               }
            }

            if(var1 == 3) {
               class36.region.method2722(var0, var2, var3);
               var12 = class37.getObjectDefinition(var13);
               if(var12.interactType == 1) {
                  Client.collisionMaps[var0].unblock(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class61.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            class17.method132(var0, var11, var2, var3, var4, var5, var6, class36.region, Client.collisionMaps[var0]);
         }
      }

   }
}
