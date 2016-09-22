import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
final class class222 implements Comparator {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "-1702408418"
   )
   int method4032(class217 var1, class217 var2) {
      return var1.field3204 < var2.field3204?-1:(var1.field3204 == var2.field3204?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4032((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "71"
   )
   static int method4033() {
      return ++class11.field168 - 1;
   }
}
