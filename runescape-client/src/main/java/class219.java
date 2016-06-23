import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
final class class219 implements Comparator {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "-64206281"
   )
   int method4007(class214 var1, class214 var2) {
      return var1.field3149 < var2.field3149?-1:(var1.field3149 == var2.field3149?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4007((class214)var1, (class214)var2);
   }
}
