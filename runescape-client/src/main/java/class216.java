import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
final class class216 implements Comparator {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "2060477931"
   )
   int method3932(class214 var1, class214 var2) {
      return var1.field3159.field3177 < var2.field3159.field3177?-1:(var2.field3159.field3177 == var1.field3159.field3177?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3932((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
