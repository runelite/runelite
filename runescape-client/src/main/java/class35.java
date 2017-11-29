import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class35 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Las;"
   )
   static final class35 field477;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Las;"
   )
   static final class35 field475;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 1338226649
   )
   public static int field473;
   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("indexTrack2")
   static IndexData indexTrack2;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 388349689
   )
   final int field474;

   static {
      field477 = new class35(0);
      field475 = new class35(1);
   }

   class35(int var1) {
      this.field474 = var1;
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "658311760"
   )
   @Export("worldToScreen")
   static final void worldToScreen(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class41.getTileHeight(var0, var1, class233.plane) - var2;
         var0 -= class214.cameraX;
         var3 -= GameEngine.cameraZ;
         var1 -= class289.cameraY;
         int var4 = Graphics3D.SINE[class18.cameraPitch];
         int var5 = Graphics3D.COSINE[class18.cameraPitch];
         int var6 = Graphics3D.SINE[SoundTaskDataProvider.cameraYaw];
         int var7 = Graphics3D.COSINE[SoundTaskDataProvider.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var5 * var1 + var3 * var4 >> 16;
         if(var1 >= 50) {
            Client.screenY = var0 * Client.scale / var1 + Client.viewportHeight / 2;
            Client.screenX = var8 * Client.scale / var1 + Client.viewportWidth / 2;
         } else {
            Client.screenY = -1;
            Client.screenX = -1;
         }

      } else {
         Client.screenY = -1;
         Client.screenX = -1;
      }
   }
}
