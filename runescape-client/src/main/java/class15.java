import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
final class class15 implements Comparator {
   @ObfuscatedName("ez")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   static Font field293;
   @ObfuscatedName("s")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lt;Lt;I)I",
      garbageValue = "1311129542"
   )
   int method85(class14 var1, class14 var2) {
      return var1.field276.totalQuantity < var2.field276.totalQuantity?-1:(var2.field276.totalQuantity == var1.field276.totalQuantity?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method85((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "1257439205"
   )
   @Export("getLength")
   public static int getLength(String var0) {
      return var0.length() + 1;
   }
}
