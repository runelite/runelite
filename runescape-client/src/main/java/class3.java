import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
final class class3 implements class0 {
   @ObfuscatedName("ow")
   @ObfuscatedSignature(
      signature = "Ldi;"
   )
   @Export("soundSystem0")
   static AbstractSoundSystem soundSystem0;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("seq_ref")
   public static IndexDataBase seq_ref;
   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   @Export("compass")
   static SpritePixels compass;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-302199367"
   )
   static final void method7(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = Math.min(var3, Math.min(var4, var5)) - var6;
      int var8 = Math.max(var3, Math.max(var4, var5)) + var6;
      int var9 = Math.min(var0, Math.min(var1, var2)) - var6;
      int var10 = Math.max(var0, Math.max(var1, var2)) + var6;
      GroundObject.method2599(var7, var9, var8, var10, -49088);
   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-27"
   )
   static final void method6(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class70.getTileHeight(var0, var1, Ignore.plane) - var2;
         var0 -= class29.cameraX;
         var3 -= class70.cameraZ;
         var1 -= Player.cameraY;
         int var4 = Graphics3D.SINE[class28.cameraPitch];
         int var5 = Graphics3D.COSINE[class28.cameraPitch];
         int var6 = Graphics3D.SINE[class228.cameraYaw];
         int var7 = Graphics3D.COSINE[class228.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var5 * var1 + var4 * var3 >> 16;
         if(var1 >= 50) {
            Client.screenY = var0 * Client.scale / var1 + Client.viewportHeight / 2;
            Client.screenX = Client.viewportWidth / 2 + var8 * Client.scale / var1;
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
