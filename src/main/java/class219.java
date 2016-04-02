import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hi")
final class class219 implements Comparator {
   @ObfuscatedName("w")
   static class167 field3166;

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("e")
   int method3969(class214 var1, class214 var2) {
      return var1.field3149 < var2.field3149?-1:(var1.field3149 == var2.field3149?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3969((class214)var1, (class214)var2);
   }
}
