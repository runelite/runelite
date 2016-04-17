import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
final class class216 implements Comparator {
   public int compare(Object var1, Object var2) {
      return this.method4041((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "451685423"
   )
   int method4041(class214 var1, class214 var2) {
      return var1.field3153.field3172 < var2.field3153.field3172?-1:(var1.field3153.field3172 == var2.field3153.field3172?0:1);
   }
}
