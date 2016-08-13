import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
public class class56 extends CacheableNode {
   @ObfuscatedName("r")
   static NodeCache field1231 = new NodeCache(64);
   @ObfuscatedName("l")
   static class170 field1232;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -524708021
   )
   public static int field1233;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 130631835
   )
   public int field1234 = 0;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 1435849663
   )
   static int field1235;
   @ObfuscatedName("an")
   static class171 field1236;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "98"
   )
   void method1236(Buffer var1) {
      while(true) {
         int var2 = var1.method2633();
         if(var2 == 0) {
            return;
         }

         this.method1237(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1549925229"
   )
   void method1237(Buffer var1, int var2) {
      if(var2 == 5) {
         this.field1234 = var1.method2635();
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1205067486"
   )
   public static synchronized long method1249() {
      long var0 = System.currentTimeMillis();
      if(var0 < class118.field2031) {
         class118.field2029 += class118.field2031 - var0;
      }

      class118.field2031 = var0;
      return class118.field2029 + var0;
   }
}
