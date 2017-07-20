import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public class class22 extends class28 {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lcx;"
   )
   static class103 field332;
   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   static class289 field331;
   @ObfuscatedName("ps")
   @ObfuscatedGetter(
      intValue = -173967367
   )
   static int field333;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lfp;Lfp;B)V",
      garbageValue = "1"
   )
   void method166(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field491.field500) {
         throw new IllegalStateException("");
      } else {
         super.field396 = var2.readUnsignedByte();
         super.field405 = var2.readUnsignedByte();
         super.field403 = var2.readUnsignedShort();
         super.field393 = var2.readUnsignedShort();
         super.field394 = var2.readUnsignedShort();
         super.field392 = var2.readUnsignedShort();
         super.field405 = Math.min(super.field405, 4);
         super.field398 = new short[1][64][64];
         super.field399 = new short[super.field405][64][64];
         super.field400 = new byte[super.field405][64][64];
         super.field401 = new byte[super.field405][64][64];
         super.field397 = new class31[super.field405][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field484.field481) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field394 && var5 == super.field392) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method224(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return super.field394 == var2.field394 && var2.field392 == super.field392;
      }
   }

   public int hashCode() {
      return super.field394 | super.field392 << 8;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1712840413"
   )
   static void method165(String var0, String var1, String var2) {
      class92.loginMessage1 = var0;
      class92.loginMessage2 = var1;
      class92.loginMessage3 = var2;
   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "322944633"
   )
   static final void method157(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class23.getTileHeight(var0, var1, class10.plane) - var2;
         var0 -= class73.cameraX;
         var3 -= WidgetNode.cameraZ;
         var1 -= Client.cameraY;
         int var4 = Graphics3D.SINE[class10.cameraPitch];
         int var5 = Graphics3D.COSINE[class10.cameraPitch];
         int var6 = Graphics3D.SINE[class236.cameraYaw];
         int var7 = Graphics3D.COSINE[class236.cameraYaw];
         int var8 = var0 * var7 + var6 * var1 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var4 * var1 >> 16;
         var1 = var3 * var4 + var5 * var1 >> 16;
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
