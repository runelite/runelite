import java.io.File;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
final class class219 implements Comparator {
   @ObfuscatedName("gh")
   static class173 field3170;
   @ObfuscatedName("d")
   static File field3171;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "-969002880"
   )
   int method3987(class214 var1, class214 var2) {
      return var1.field3147 < var2.field3147?-1:(var1.field3147 == var2.field3147?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3987((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
