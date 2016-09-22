import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
final class class220 implements Comparator {
   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4018((class217)var1, (class217)var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "-63301222"
   )
   int method4018(class217 var1, class217 var2) {
      return var1.field3202.price < var2.field3202.price?-1:(var1.field3202.price == var2.field3202.price?0:1);
   }
}
