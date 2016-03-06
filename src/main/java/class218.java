import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hd")
final class class218 implements Comparator {
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = -671417265
   )
   static int field3163;

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3922((class213)var1, (class213)var2);
   }

   @ObfuscatedName("cd")
   static final String method3920(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }

   @ObfuscatedName("j")
   int method3922(class213 var1, class213 var2) {
      return var1.field3147 < var2.field3147?-1:(var1.field3147 == var2.field3147?0:1);
   }
}
