import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hh")
final class class218 implements Comparator {
   @ObfuscatedName("w")
   int method3985(class214 var1, class214 var2) {
      return var1.field3154 < var2.field3154?-1:(var1.field3154 == var2.field3154?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3985((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
