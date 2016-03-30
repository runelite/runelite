import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hv")
final class class219 implements Comparator {
   public int compare(Object var1, Object var2) {
      return this.method3995((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("w")
   int method3995(class214 var1, class214 var2) {
      return var1.field3160 < var2.field3160?-1:(var2.field3160 == var1.field3160?0:1);
   }
}
