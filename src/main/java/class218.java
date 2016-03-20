import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ha")
final class class218 implements Comparator {
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = -2118798097
   )
   protected static int field3161;

   @ObfuscatedName("a")
   int method4017(class213 var1, class213 var2) {
      return var1.field3142 < var2.field3142?-1:(var1.field3142 == var2.field3142?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4017((class213)var1, (class213)var2);
   }
}
