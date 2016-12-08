import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
public class class188 extends CacheableNode {
   @ObfuscatedName("b")
   public boolean field2785 = false;
   @ObfuscatedName("m")
   public static NodeCache field2786 = new NodeCache(64);
   @ObfuscatedName("o")
   public static class182 field2787;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-50684126"
   )
   public void method3358(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3360(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "705437841"
   )
   void method3360(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2785 = true;
      }

   }
}
