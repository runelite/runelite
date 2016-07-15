import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
final class class216 implements Comparator {
   @ObfuscatedName("l")
   static String field3190;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;B)I",
      garbageValue = "-9"
   )
   int method4024(class217 var1, class217 var2) {
      return var1.method4035().compareTo(var2.method4035());
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4024((class217)var1, (class217)var2);
   }
}
