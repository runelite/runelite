import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
final class class220 implements Comparator {
   @ObfuscatedName("s")
   static int[] field3207;
   @ObfuscatedName("ay")
   static int[] field3209;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "-1384144241"
   )
   int method4040(class217 var1, class217 var2) {
      return var1.field3194.price < var2.field3194.price?-1:(var1.field3194.price == var2.field3194.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4040((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
