import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
public class class189 extends CacheableNode {
   @ObfuscatedName("b")
   public boolean field2788 = false;
   @ObfuscatedName("m")
   static NodeCache field2789 = new NodeCache(64);
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = -739598751
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("o")
   static class182 field2791;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "309104864"
   )
   void method3364(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3372(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "0"
   )
   static final int method3365(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = var2 / 2 + (var0 / 4 << 10) + (var1 / 32 << 7);
      return var3;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1555676766"
   )
   void method3372(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2788 = true;
      }

   }
}
