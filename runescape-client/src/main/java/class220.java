import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
final class class220 implements Comparator {
   @ObfuscatedName("k")
   static byte[][] field3211;
   @ObfuscatedName("y")
   static byte[][][] field3213;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "-1887083323"
   )
   int method3958(class217 var1, class217 var2) {
      return var1.field3202.price < var2.field3202.price?-1:(var1.field3202.price == var2.field3202.price?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3958((class217)var1, (class217)var2);
   }
}
