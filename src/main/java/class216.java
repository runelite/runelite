import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hy")
final class class216 implements Comparator {
   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4006((class213)var1, (class213)var2);
   }

   @ObfuscatedName("a")
   int method4006(class213 var1, class213 var2) {
      return var1.field3139.field3164 < var2.field3139.field3164?-1:(var2.field3139.field3164 == var1.field3139.field3164?0:1);
   }
}
