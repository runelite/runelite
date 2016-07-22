import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
final class class221 implements Comparator {
   @ObfuscatedName("w")
   static class170 field3212;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -466478046100807105L
   )
   public static long field3213;
   @ObfuscatedName("in")
   static class32 field3214;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "325042004"
   )
   int method4048(class217 var1, class217 var2) {
      return var1.field3197 < var2.field3197?-1:(var2.field3197 == var1.field3197?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4048((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
