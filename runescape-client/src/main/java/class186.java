import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class186 extends CacheableNode {
   @ObfuscatedName("m")
   public static NodeCache field2777 = new NodeCache(64);
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1322456743
   )
   public int field2778 = 0;
   @ObfuscatedName("o")
   public static class182 field2779;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;S)V",
      garbageValue = "-17601"
   )
   public void method3334(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3336(var1, var2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1985767926"
   )
   void method3336(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2778 = var1.readUnsignedShort();
      }

   }
}
