import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public class class187 extends CacheableNode {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1949999073
   )
   public static int field2755;
   @ObfuscatedName("o")
   public static NodeCache field2756 = new NodeCache(64);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 332130115
   )
   public int field2757 = 0;
   @ObfuscatedName("k")
   public static class182 field2759;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1966535333"
   )
   void method3420(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3421(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-128"
   )
   void method3421(Buffer var1, int var2) {
      if(var2 == 5) {
         this.field2757 = var1.readUnsignedShort();
      }

   }
}
