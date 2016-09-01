import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
final class class216 implements Comparator {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "1639174319"
   )
   int method3959(class217 var1, class217 var2) {
      return var1.method3969().compareTo(var2.method3969());
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3959((class217)var1, (class217)var2);
   }
}
