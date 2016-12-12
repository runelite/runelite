import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
public class class186 extends CacheableNode {
   @ObfuscatedName("k")
   static class63 field2770;
   @ObfuscatedName("e")
   public static NodeCache field2771 = new NodeCache(64);
   @ObfuscatedName("jt")
   static Widget[] field2772;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1691543051
   )
   public int field2773 = 0;
   @ObfuscatedName("i")
   public static class182 field2774;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-2104522015"
   )
   public void method3363(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3367(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-240034611"
   )
   void method3367(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2773 = var1.readUnsignedShort();
      }

   }
}
