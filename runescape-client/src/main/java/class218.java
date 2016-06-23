import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
final class class218 implements Comparator {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;S)I",
      garbageValue = "-10497"
   )
   int method4000(class214 var1, class214 var2) {
      return var1.field3148 < var2.field3148?-1:(var1.field3148 == var2.field3148?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4000((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
