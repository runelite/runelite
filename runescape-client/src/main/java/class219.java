import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
final class class219 implements Comparator {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "-101614405"
   )
   int method3918(class214 var1, class214 var2) {
      return var1.field3160 < var2.field3160?-1:(var1.field3160 == var2.field3160?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3918((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
