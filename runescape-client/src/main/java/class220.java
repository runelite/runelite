import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
final class class220 implements Comparator {
   @ObfuscatedName("g")
   static int[][][] field3214;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "126229957"
   )
   int method3986(class217 var1, class217 var2) {
      return var1.field3203.price < var2.field3203.price?-1:(var2.field3203.price == var1.field3203.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3986((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
