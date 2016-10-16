import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
final class class222 implements Comparator {
   @ObfuscatedName("s")
   public static class170 field3215;

   public int compare(Object var1, Object var2) {
      return this.method3974((class217)var1, (class217)var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;B)I",
      garbageValue = "-42"
   )
   int method3974(class217 var1, class217 var2) {
      return var1.field3199 < var2.field3199?-1:(var2.field3199 == var1.field3199?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
