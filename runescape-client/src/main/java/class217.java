import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
final class class217 implements Comparator {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1415760111
   )
   public static int field3162;
   @ObfuscatedName("f")
   static class167 field3163;

   public int compare(Object var1, Object var2) {
      return this.method3997((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "1742076303"
   )
   int method3997(class214 var1, class214 var2) {
      return var1.field3147.field3169 < var2.field3147.field3169?-1:(var2.field3147.field3169 == var1.field3147.field3169?0:1);
   }
}
