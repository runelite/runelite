import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class189 extends CacheableNode {
   @ObfuscatedName("c")
   public static NodeCache field2788 = new NodeCache(64);
   @ObfuscatedName("f")
   public boolean field2789 = false;
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = 1989325529
   )
   static int field2793;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-979475692"
   )
   public void method3348(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3349(var1, var2);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "36"
   )
   void method3349(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2789 = true;
      }

   }
}
