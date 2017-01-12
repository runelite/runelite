import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public class class187 extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1119021275
   )
   public int field2749 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1624767839
   )
   public static int field2750;
   @ObfuscatedName("u")
   static class182 field2751;
   @ObfuscatedName("i")
   public static NodeCache field2752 = new NodeCache(64);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;S)V",
      garbageValue = "29854"
   )
   void method3415(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3416(var1, var2);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "782491121"
   )
   void method3416(Buffer var1, int var2) {
      if(var2 == 5) {
         this.field2749 = var1.readUnsignedShort();
      }

   }
}
