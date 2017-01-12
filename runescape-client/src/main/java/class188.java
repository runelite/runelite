import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
public class class188 extends CacheableNode {
   @ObfuscatedName("u")
   public static class182 field2753;
   @ObfuscatedName("x")
   public static NodeCache field2754 = new NodeCache(64);
   @ObfuscatedName("i")
   public boolean field2755 = false;
   @ObfuscatedName("is")
   static Widget field2758;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "16776960"
   )
   public void method3430(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3431(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-44"
   )
   void method3431(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2755 = true;
      }

   }
}
