import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public class class186 extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -715836419
   )
   public int field2761 = 0;
   @ObfuscatedName("x")
   static class182 field2762;
   @ObfuscatedName("k")
   static ModIcon field2763;
   @ObfuscatedName("j")
   static NodeCache field2764 = new NodeCache(64);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "10"
   )
   void method3442(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3444(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "963248956"
   )
   void method3444(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2761 = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "-1683250188"
   )
   public static int method3449(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
