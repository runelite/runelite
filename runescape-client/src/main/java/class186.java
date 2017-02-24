import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
public class class186 extends CacheableNode {
   @ObfuscatedName("d")
   static NodeCache field2770 = new NodeCache(64);
   @ObfuscatedName("q")
   static class182 field2772;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -160715121
   )
   public int field2774 = 0;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "4"
   )
   void method3432(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3433(var1, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "417746123"
   )
   void method3433(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2774 = var1.readUnsignedShort();
      }

   }
}
