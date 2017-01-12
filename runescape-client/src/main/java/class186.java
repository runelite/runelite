import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class186 extends CacheableNode {
   @ObfuscatedName("x")
   public static NodeCache field2745 = new NodeCache(64);
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2114084443
   )
   public int field2746 = 0;
   @ObfuscatedName("u")
   public static class182 field2748;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1456570002"
   )
   public void method3407(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3410(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-306624838"
   )
   void method3410(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2746 = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "1664312172"
   )
   public static boolean method3412(char var0) {
      return var0 >= 48 && var0 <= 57;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1551462196"
   )
   public static int method3413(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }
}
