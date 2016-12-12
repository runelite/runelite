import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
public class class194 extends CacheableNode {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 633090953
   )
   public int field2848;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -269674813
   )
   public int field2849;
   @ObfuscatedName("e")
   public static NodeCache field2850 = new NodeCache(64);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1831739839
   )
   public int field2852;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "263810413"
   )
   void method3483(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2848 = var1.readUnsignedShort();
         this.field2849 = var1.readUnsignedByte();
         this.field2852 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-68"
   )
   void method3484(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3483(var1, var2);
      }
   }
}
