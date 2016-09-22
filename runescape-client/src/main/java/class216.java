import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
final class class216 implements Comparator {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "-536270607"
   )
   int method3993(class217 var1, class217 var2) {
      return var1.method4000().compareTo(var2.method4000());
   }

   public int compare(Object var1, Object var2) {
      return this.method3993((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
