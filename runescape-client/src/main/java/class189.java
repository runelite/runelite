import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
public class class189 extends CacheableNode {
   @ObfuscatedName("i")
   static NodeCache field2799 = new NodeCache(64);
   @ObfuscatedName("u")
   public boolean field2800 = false;
   @ObfuscatedName("f")
   static IndexDataBase field2801;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1619247527"
   )
   void method3503(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3510(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1449961102"
   )
   void method3510(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2800 = true;
      }

   }
}
