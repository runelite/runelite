import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
final class class213 implements Comparator {
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -1382023425
   )
   static int field3158;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "-2087695978"
   )
   int method3916(class214 var1, class214 var2) {
      return var1.method3924().compareTo(var2.method3924());
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3916((class214)var1, (class214)var2);
   }
}
