import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
final class class219 implements Comparator {
   public int compare(Object var1, Object var2) {
      return this.method3963((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;B)I",
      garbageValue = "-85"
   )
   int method3963(class214 var1, class214 var2) {
      return var1.field3161 < var2.field3161?-1:(var2.field3161 == var1.field3161?0:1);
   }
}
