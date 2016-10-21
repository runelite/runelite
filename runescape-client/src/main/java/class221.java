import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
final class class221 implements Comparator {
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 1068888575
   )
   static int field3210;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;B)I",
      garbageValue = "63"
   )
   int method4045(class217 var1, class217 var2) {
      return var1.field3192 < var2.field3192?-1:(var1.field3192 == var2.field3192?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4045((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
