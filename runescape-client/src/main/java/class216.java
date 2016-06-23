import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
final class class216 implements Comparator {
   @ObfuscatedName("m")
   static byte[][][] field3159;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = -726855291
   )
   @Export("cameraX")
   static int field3160;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "484195984"
   )
   int method3983(class214 var1, class214 var2) {
      return var1.field3147.field3172 < var2.field3147.field3172?-1:(var2.field3147.field3172 == var1.field3147.field3172?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3983((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
