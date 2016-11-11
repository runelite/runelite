import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
final class class216 implements Comparator {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "1798128841"
   )
   int method3968(class217 var1, class217 var2) {
      return var1.method3978().compareTo(var2.method3978());
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3968((class217)var1, (class217)var2);
   }
}
