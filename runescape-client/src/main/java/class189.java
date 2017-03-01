import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class189 extends CacheableNode {
   @ObfuscatedName("g")
   public boolean field2787 = false;
   @ObfuscatedName("n")
   public static NodeCache field2788 = new NodeCache(64);
   @ObfuscatedName("a")
   static ModIcon[] field2789;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = 721412841
   )
   static int field2791;
   @ObfuscatedName("x")
   public static class182 field2793;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-176863128"
   )
   public void method3523(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3525(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "31"
   )
   void method3525(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2787 = true;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "65536"
   )
   static final int method3526(int var0, int var1) {
      int var2 = class88.method1969(var0 - 1, var1 - 1) + class88.method1969(1 + var0, var1 - 1) + class88.method1969(var0 - 1, 1 + var1) + class88.method1969(var0 + 1, 1 + var1);
      int var3 = class88.method1969(var0 - 1, var1) + class88.method1969(1 + var0, var1) + class88.method1969(var0, var1 - 1) + class88.method1969(var0, var1 + 1);
      int var4 = class88.method1969(var0, var1);
      return var4 / 4 + var3 / 8 + var2 / 16;
   }
}
