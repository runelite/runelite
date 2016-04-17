import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
final class class217 implements Comparator {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "-630437799"
   )
   int method4046(class214 var1, class214 var2) {
      return var1.field3153.field3171 < var2.field3153.field3171?-1:(var1.field3153.field3171 == var2.field3153.field3171?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4046((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
