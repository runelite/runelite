import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class20 implements class112 {
   @ObfuscatedName("j")
   static final class20 field565 = new class20(1);
   @ObfuscatedName("dt")
   static byte[][] field566;
   @ObfuscatedName("x")
   static final class20 field567 = new class20(3);
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -733557131
   )
   final int field568;
   @ObfuscatedName("u")
   static class78 field569;
   @ObfuscatedName("r")
   public static class228[] field570;
   @ObfuscatedName("s")
   static final class20 field571 = new class20(0);
   @ObfuscatedName("p")
   static final class20 field572 = new class20(2);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "693017402"
   )
   public int vmethod3150() {
      return this.field568;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class20(int var1) {
      this.field568 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;Lclass167;I)V",
      garbageValue = "173375997"
   )
   public static void method549(class167 var0, class167 var1, class167 var2) {
      class42.field985 = var0;
      class90.field1568 = var1;
      class42.field983 = var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1926922837"
   )
   public static final boolean method551() {
      class137 var0 = class137.field2119;
      class137 var1 = class137.field2119;
      synchronized(class137.field2119) {
         if(class137.field2143 == class137.field2141) {
            return false;
         } else {
            class137.field2133 = class137.field2138[class137.field2141];
            class109.field1917 = class137.field2127[class137.field2141];
            class137.field2141 = 1 + class137.field2141 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1488469792"
   )
   static int method554(int var0, int var1) {
      class15 var2 = (class15)class15.field204.method3777((long)var0);
      return null == var2?0:(var1 >= 0 && var1 < var2.field206.length?var2.field206[var1]:0);
   }
}
