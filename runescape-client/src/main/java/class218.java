import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
final class class218 implements Comparator {
   public int compare(Object var1, Object var2) {
      return this.method3953((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;B)I",
      garbageValue = "0"
   )
   int method3953(class214 var1, class214 var2) {
      return var1.field3156 < var2.field3156?-1:(var2.field3156 == var1.field3156?0:1);
   }
}
