import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hr")
final class class217 implements Comparator {
   @ObfuscatedName("a")
   int method4008(class213 var1, class213 var2) {
      return var1.field3140 < var2.field3140?-1:(var2.field3140 == var1.field3140?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4008((class213)var1, (class213)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
