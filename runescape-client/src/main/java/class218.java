import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
final class class218 implements Comparator {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;B)I",
      garbageValue = "-37"
   )
   int method3976(class214 var1, class214 var2) {
      return var1.field3151 < var2.field3151?-1:(var1.field3151 == var2.field3151?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3976((class214)var1, (class214)var2);
   }
}
