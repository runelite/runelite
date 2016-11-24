import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class188 extends CacheableNode {
   @ObfuscatedName("u")
   static int[] field2780;
   @ObfuscatedName("m")
   public boolean field2781 = false;
   @ObfuscatedName("n")
   public static class182 field2782;
   @ObfuscatedName("d")
   static NodeCache field2783 = new NodeCache(64);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1522347516"
   )
   void method3487(Buffer var1) {
      while(true) {
         int var2 = var1.method3033();
         if(var2 == 0) {
            return;
         }

         this.method3488(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1668883068"
   )
   void method3488(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2781 = true;
      }

   }
}
