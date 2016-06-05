import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
final class class213 implements Comparator {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;S)I",
      garbageValue = "25027"
   )
   int method3883(class214 var1, class214 var2) {
      return var1.method3889().compareTo(var2.method3889());
   }

   public int compare(Object var1, Object var2) {
      return this.method3883((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
