import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
final class class216 implements Comparator {
   @ObfuscatedName("g")
   static int[] field3167;
   @ObfuscatedName("t")
   @Export("widgets")
   public static class173[][] field3168;

   public int compare(Object var1, Object var2) {
      return this.method3900((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;B)I",
      garbageValue = "-53"
   )
   int method3900(class214 var1, class214 var2) {
      return var1.field3157.field3174 < var2.field3157.field3174?-1:(var1.field3157.field3174 == var2.field3157.field3174?0:1);
   }

   @ObfuscatedName("rx")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   protected static final void method3903() {
      class190.field3081.vmethod3081();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         class144.field2231[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         class144.field2232[var0] = 0L;
      }

      class44.field1038 = 0;
   }
}
