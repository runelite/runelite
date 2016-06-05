import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
final class class218 implements Comparator {
   @ObfuscatedName("t")
   static class167 field3169;
   @ObfuscatedName("i")
   public static class167 field3170;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "1694540809"
   )
   int method3910(class214 var1, class214 var2) {
      return var1.field3156 < var2.field3156?-1:(var2.field3156 == var1.field3156?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3910((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
