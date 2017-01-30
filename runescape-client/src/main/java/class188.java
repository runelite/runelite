import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class188 extends CacheableNode {
   @ObfuscatedName("g")
   public static NodeCache field2777 = new NodeCache(64);
   @ObfuscatedName("p")
   public static class182 field2778;
   @ObfuscatedName("x")
   public boolean field2779 = false;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-773239110"
   )
   void method3431(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2779 = true;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-165091184"
   )
   public void method3432(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3431(var1, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass228;I)I",
      garbageValue = "-2115796495"
   )
   static final int method3439(class228 var0) {
      if(var0 == null) {
         return 12;
      } else {
         switch(var0.field3240) {
         case 1:
            return 20;
         default:
            return 12;
         }
      }
   }
}
