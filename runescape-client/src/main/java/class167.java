import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class167 {
   @ObfuscatedName("d")
   @Export("jagexClDat")
   static File jagexClDat;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   @Export("randomDat")
   static CacheFile randomDat;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   @Export("dat2File")
   public static CacheFile dat2File;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   @Export("idx255File")
   public static CacheFile idx255File;
   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "Lll;"
   )
   static IndexedSprite field2223;

   static {
      randomDat = null;
      dat2File = null;
      idx255File = null;
   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "-37"
   )
   static final void method3256(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.lowMemory && var0 != BoundingBox3DDrawMode.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class255.region.getWallObjectHash(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class255.region.method2879(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class255.region.method2888(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class255.region.getGroundObjectHash(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class255.region.getObjectFlags(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class255.region.removeBoundaryObject(var0, var2, var3);
               var12 = GameCanvas.getObjectDefinition(var13);
               if(var12.clipType != 0) {
                  Client.collisionMaps[var0].removeWall(var2, var3, var14, var15, var12.blocksProjectile);
               }
            }

            if(var1 == 1) {
               class255.region.removeWallDecoration(var0, var2, var3);
            }

            if(var1 == 2) {
               class255.region.method3035(var0, var2, var3);
               var12 = GameCanvas.getObjectDefinition(var13);
               if(var2 + var12.width > 103 || var3 + var12.width > 103 || var2 + var12.length > 103 || var3 + var12.length > 103) {
                  return;
               }

               if(var12.clipType != 0) {
                  Client.collisionMaps[var0].removeObject(var2, var3, var12.width, var12.length, var15, var12.blocksProjectile);
               }
            }

            if(var1 == 3) {
               class255.region.removeFloorDecoration(var0, var2, var3);
               var12 = GameCanvas.getObjectDefinition(var13);
               if(var12.clipType == 1) {
                  Client.collisionMaps[var0].method3401(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class62.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            class254.method4508(var0, var11, var2, var3, var4, var5, var6, class255.region, Client.collisionMaps[var0]);
         }
      }

   }
}
