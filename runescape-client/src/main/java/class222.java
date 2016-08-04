import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
final class class222 implements Comparator {
   public int compare(Object var1, Object var2) {
      return this.method4139((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "1296892085"
   )
   int method4139(class217 var1, class217 var2) {
      return var1.field3208 < var2.field3208?-1:(var2.field3208 == var1.field3208?0:1);
   }
}
