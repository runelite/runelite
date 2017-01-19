import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
public class class187 extends CacheableNode {
   @ObfuscatedName("s")
   public static class182 field2777;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1672041699
   )
   public int field2778 = 0;
   @ObfuscatedName("a")
   static class182 field2779;
   @ObfuscatedName("f")
   public static NodeCache field2780 = new NodeCache(64);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-185722871"
   )
   public void method3334(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3335(var1, var2);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1150383325"
   )
   void method3335(Buffer var1, int var2) {
      if(var2 == 5) {
         this.field2778 = var1.readUnsignedShort();
      }

   }
}
