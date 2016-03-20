import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("he")
final class class215 implements Comparator {
   public int compare(Object var1, Object var2) {
      return this.method3991((class213)var1, (class213)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("a")
   int method3991(class213 var1, class213 var2) {
      return var1.field3139.field3162 < var2.field3139.field3162?-1:(var1.field3139.field3162 == var2.field3139.field3162?0:1);
   }
}
