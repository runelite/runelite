import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("he")
final class class216 implements Comparator {
   @ObfuscatedName("j")
   static class142 field3155;
   @ObfuscatedName("k")
   static class18 field3156;

   @ObfuscatedName("j")
   int method3900(class213 var1, class213 var2) {
      return var1.field3142.field3169 < var2.field3142.field3169?-1:(var1.field3142.field3169 == var2.field3142.field3169?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3900((class213)var1, (class213)var2);
   }
}
