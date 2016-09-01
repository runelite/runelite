import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
final class class219 implements Comparator {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;B)I",
      garbageValue = "-89"
   )
   int method3975(class217 var1, class217 var2) {
      return var1.field3203.totalQuantity < var2.field3203.totalQuantity?-1:(var1.field3203.totalQuantity == var2.field3203.totalQuantity?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3975((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
