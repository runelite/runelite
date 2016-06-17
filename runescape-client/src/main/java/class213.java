import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
final class class213 implements Comparator {
   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "1619677965"
   )
   int method3937(class214 var1, class214 var2) {
      return var1.method3946().compareTo(var2.method3946());
   }

   public int compare(Object var1, Object var2) {
      return this.method3937((class214)var1, (class214)var2);
   }
}
