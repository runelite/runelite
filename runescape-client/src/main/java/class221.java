import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
final class class221 implements Comparator {
   @ObfuscatedName("l")
   public static String field3209;

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4071((class217)var1, (class217)var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;B)I",
      garbageValue = "-84"
   )
   int method4071(class217 var1, class217 var2) {
      return var1.field3192 < var2.field3192?-1:(var1.field3192 == var2.field3192?0:1);
   }
}
