import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
final class class216 implements Comparator {
   @ObfuscatedName("ea")
   static class78[] field3158;
   @ObfuscatedName("n")
   static class173 field3159;

   public int compare(Object var1, Object var2) {
      return this.method3961((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;B)I",
      garbageValue = "103"
   )
   int method3961(class214 var1, class214 var2) {
      return var1.field3148.field3175 < var2.field3148.field3175?-1:(var1.field3148.field3175 == var2.field3148.field3175?0:1);
   }
}
