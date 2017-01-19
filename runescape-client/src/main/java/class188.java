import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public class class188 extends CacheableNode {
   @ObfuscatedName("c")
   static NodeCache field2784 = new NodeCache(64);
   @ObfuscatedName("f")
   public boolean field2785 = false;
   @ObfuscatedName("s")
   public static class182 field2786;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-2107692466"
   )
   void method3342(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2785 = true;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-408793340"
   )
   void method3344(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3342(var1, var2);
      }
   }
}
