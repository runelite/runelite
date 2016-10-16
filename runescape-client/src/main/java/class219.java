import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
final class class219 implements Comparator {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = -7392899886198978763L
   )
   public static long field3208;
   @ObfuscatedName("y")
   static class75 field3209;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;B)I",
      garbageValue = "1"
   )
   int method3950(class217 var1, class217 var2) {
      return var1.field3202.totalQuantity < var2.field3202.totalQuantity?-1:(var1.field3202.totalQuantity == var2.field3202.totalQuantity?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3950((class217)var1, (class217)var2);
   }
}
