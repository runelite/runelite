import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
final class class218 implements Comparator {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "-170972031"
   )
   int method4056(class214 var1, class214 var2) {
      return var1.field3151 < var2.field3151?-1:(var2.field3151 == var1.field3151?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4056((class214)var1, (class214)var2);
   }
}
