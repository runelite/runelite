import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class164 extends CacheableNode {
   @ObfuscatedName("f")
   public final int[] field2158;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 54216125
   )
   public final int field2159;
   @ObfuscatedName("k")
   public final int[] field2161;
   @ObfuscatedName("qr")
   protected static java.awt.Frame field2162;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2106885625
   )
   public final int field2167;

   class164(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2159 = var1;
      this.field2167 = var2;
      this.field2158 = var3;
      this.field2161 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-95"
   )
   public boolean method3053(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2161.length) {
         int var3 = this.field2161[var2];
         if(var1 >= var3 && var1 <= this.field2158[var2] + var3) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;I)V",
      garbageValue = "-2128649277"
   )
   public static void method3055(class182 var0, class182 var1) {
      class190.field2806 = var0;
      class190.field2792 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public static void method3056() {
      class196.field2868.reset();
      class196.spriteCache.reset();
      class196.field2870.reset();
   }
}
