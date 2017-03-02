import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
public class class189 extends CacheableNode {
   @ObfuscatedName("l")
   static NodeCache field2785 = new NodeCache(64);
   @ObfuscatedName("i")
   public boolean field2786 = false;
   @ObfuscatedName("b")
   public static class182 field2787;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "358578878"
   )
   void method3524(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2786 = true;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-826284515"
   )
   void method3535(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3524(var1, var2);
      }
   }
}
