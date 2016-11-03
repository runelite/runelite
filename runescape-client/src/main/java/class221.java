import java.io.File;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
final class class221 implements Comparator {
   @ObfuscatedName("c")
   static File field3214;
   @ObfuscatedName("e")
   static class175 field3215;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "-100092691"
   )
   int method4002(class217 var1, class217 var2) {
      return var1.field3199 < var2.field3199?-1:(var1.field3199 == var2.field3199?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4002((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
