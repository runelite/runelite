import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
final class class19 implements Comparator {
   @ObfuscatedName("pe")
   static class102 field328;
   @ObfuscatedName("gp")
   static SpritePixels field329;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "1035466838"
   )
   int method136(class14 var1, class14 var2) {
      return var1.field286 < var2.field286?-1:(var2.field286 == var1.field286?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method136((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Z",
      garbageValue = "-1508336125"
   )
   static boolean method139(String var0, int var1) {
      return class215.method3969(var0, var1, "openjs");
   }
}
