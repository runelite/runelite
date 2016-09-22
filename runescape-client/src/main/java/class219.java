import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
final class class219 implements Comparator {
   public int compare(Object var1, Object var2) {
      return this.method4014((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;S)I",
      garbageValue = "2551"
   )
   int method4014(class217 var1, class217 var2) {
      return var1.field3202.totalQuantity < var2.field3202.totalQuantity?-1:(var2.field3202.totalQuantity == var1.field3202.totalQuantity?0:1);
   }
}
