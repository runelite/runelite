import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
final class class221 implements Comparator {
   @ObfuscatedName("d")
   static class170 field3216;

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4026((class217)var1, (class217)var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "397590516"
   )
   int method4026(class217 var1, class217 var2) {
      return var1.field3203 < var2.field3203?-1:(var1.field3203 == var2.field3203?0:1);
   }
}
