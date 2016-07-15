import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
final class class220 implements Comparator {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;B)I",
      garbageValue = "1"
   )
   int method4054(class217 var1, class217 var2) {
      return var1.field3194.field3215 < var2.field3194.field3215?-1:(var2.field3194.field3215 == var1.field3194.field3215?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4054((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
