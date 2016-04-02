import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hj")
final class class218 implements Comparator {
   @ObfuscatedName("e")
   public static class167 field3163;

   public int compare(Object var1, Object var2) {
      return this.method3962((class214)var1, (class214)var2);
   }

   @ObfuscatedName("e")
   int method3962(class214 var1, class214 var2) {
      return var1.field3147 < var2.field3147?-1:(var2.field3147 == var1.field3147?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
