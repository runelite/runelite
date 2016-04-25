import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
final class class216 implements Comparator {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "357069042"
   )
   int method3923(class214 var1, class214 var2) {
      return var1.field3158.field3176 < var2.field3158.field3176?-1:(var2.field3158.field3176 == var1.field3158.field3176?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3923((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
