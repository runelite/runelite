import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
final class class222 implements Comparator {
   public int compare(Object var1, Object var2) {
      return this.method4005((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "-301977321"
   )
   int method4005(class217 var1, class217 var2) {
      return var1.field3204 < var2.field3204?-1:(var1.field3204 == var2.field3204?0:1);
   }
}
