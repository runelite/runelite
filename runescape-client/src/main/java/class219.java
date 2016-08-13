import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
final class class219 implements Comparator {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "443078177"
   )
   int method4106(class217 var1, class217 var2) {
      return var1.field3206.totalQuantity < var2.field3206.totalQuantity?-1:(var1.field3206.totalQuantity == var2.field3206.totalQuantity?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4106((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
