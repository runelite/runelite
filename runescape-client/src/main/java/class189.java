import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public class class189 extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -343280687
   )
   public static int field2783;
   @ObfuscatedName("n")
   static NodeCache field2784;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1898999377
   )
   public int field2785;
   @ObfuscatedName("d")
   static IndexDataBase field2786;
   @ObfuscatedName("u")
   public static IndexDataBase field2787;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-2029379553"
   )
   void method3434(Buffer var1, int var2) {
      if(var2 == 5) {
         this.field2785 = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "977486337"
   )
   void method3437(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3434(var1, var2);
      }
   }

   class189() {
      this.field2785 = 0;
   }

   static {
      field2784 = new NodeCache(64);
   }
}
