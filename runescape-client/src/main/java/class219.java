import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
final class class219 implements Comparator {
   public int compare(Object var1, Object var2) {
      return this.method3990((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;B)I",
      garbageValue = "-98"
   )
   int method3990(class217 var1, class217 var2) {
      return var1.field3205.totalQuantity < var2.field3205.totalQuantity?-1:(var1.field3205.totalQuantity == var2.field3205.totalQuantity?0:1);
   }
}
