import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
final class class216 implements Comparator {
   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;B)I",
      garbageValue = "-95"
   )
   int method4094(class217 var1, class217 var2) {
      return var1.method4102().compareTo(var2.method4102());
   }

   public int compare(Object var1, Object var2) {
      return this.method4094((class217)var1, (class217)var2);
   }
}
