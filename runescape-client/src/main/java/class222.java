import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
final class class222 implements Comparator {
   @ObfuscatedName("h")
   public static boolean field3221;
   @ObfuscatedName("et")
   static ModIcon[] field3222;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "-1446272336"
   )
   int method4013(class217 var1, class217 var2) {
      return var1.field3204 < var2.field3204?-1:(var1.field3204 == var2.field3204?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4013((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
