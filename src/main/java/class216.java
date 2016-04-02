import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hs")
final class class216 implements Comparator {
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = 52010125
   )
   @Export("cameraPitch")
   static int field3156;
   @ObfuscatedName("ak")
   static class168 field3157;
   @ObfuscatedName("gv")
   static class173 field3158;
   @ObfuscatedName("e")
   public static class167 field3159;

   public int compare(Object var1, Object var2) {
      return this.method3946((class214)var1, (class214)var2);
   }

   @ObfuscatedName("e")
   int method3946(class214 var1, class214 var2) {
      return var1.field3146.field3170 < var2.field3146.field3170?-1:(var2.field3146.field3170 == var1.field3146.field3170?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
