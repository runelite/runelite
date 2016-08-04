import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
final class class220 implements Comparator {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;B)I",
      garbageValue = "12"
   )
   int method4117(class217 var1, class217 var2) {
      return var1.field3206.field3216 < var2.field3206.field3216?-1:(var2.field3206.field3216 == var1.field3206.field3216?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4117((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
