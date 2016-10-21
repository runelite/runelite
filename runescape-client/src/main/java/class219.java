import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
final class class219 implements Comparator {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "-832736608"
   )
   int method4032(class217 var1, class217 var2) {
      return var1.field3194.totalQuantity < var2.field3194.totalQuantity?-1:(var1.field3194.totalQuantity == var2.field3194.totalQuantity?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4032((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
