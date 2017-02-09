import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
public class class188 extends CacheableNode {
   @ObfuscatedName("y")
   static NodeCache field2761 = new NodeCache(64);
   @ObfuscatedName("o")
   public boolean field2762 = false;
   @ObfuscatedName("k")
   static class182 field2765;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1662499907"
   )
   void method3428(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2762 = true;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1075698305"
   )
   void method3439(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3428(var1, var2);
      }
   }
}
