import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class148 {
   @ObfuscatedName("w")
   final URL field2188;
   @ObfuscatedName("s")
   volatile boolean field2192;
   @ObfuscatedName("q")
   volatile byte[] field2190;

   class148(URL var1) {
      this.field2188 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   public boolean method2933() {
      return this.field2192;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "-108"
   )
   public byte[] method2935() {
      return this.field2190;
   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1978123503"
   )
   static void method2942(int var0) {
      if(var0 == -1 && !Client.field1151) {
         class152.method2974();
      } else if(var0 != -1 && var0 != Client.field1150 && Client.field1149 != 0 && !Client.field1151) {
         IndexFile.method3070(2, class37.indexTrack1, var0, 0, Client.field1149, false);
      }

      Client.field1150 = var0;
   }

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1299228607"
   )
   static final void method2941(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class41.getTileHeight(var0, var1, class46.plane) - var2;
         var0 -= AbstractByteBuffer.cameraX;
         var3 -= class229.cameraZ;
         var1 -= World.cameraY;
         int var4 = Graphics3D.SINE[class18.cameraPitch];
         int var5 = Graphics3D.COSINE[class18.cameraPitch];
         int var6 = Graphics3D.SINE[CombatInfo1.cameraYaw];
         int var7 = Graphics3D.COSINE[CombatInfo1.cameraYaw];
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

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-98"
   )
   static void method2940() {
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
   }
}
