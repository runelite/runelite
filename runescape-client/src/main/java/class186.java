import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
public class class186 extends CacheableNode {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 265444307
   )
   public int field2762 = 0;
   @ObfuscatedName("l")
   static NodeCache field2763 = new NodeCache(64);
   @ObfuscatedName("b")
   static class182 field2764;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1169540865"
   )
   void method3490(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3491(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-117"
   )
   void method3491(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2762 = var1.readUnsignedShort();
      }

   }
}
