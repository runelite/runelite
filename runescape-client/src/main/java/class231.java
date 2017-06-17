import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
public class class231 {
   @ObfuscatedName("t")
   static final class231 field3190;
   @ObfuscatedName("m")
   static final class231 field3191;
   @ObfuscatedName("p")
   static final class231 field3192;
   @ObfuscatedName("w")
   public final String field3194;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -405656807
   )
   public final int field3195;
   @ObfuscatedName("e")
   static final class231 field3198;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "688824008"
   )
   public static int method3979(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class231(String var1, int var2) {
      this.field3194 = var1;
      this.field3195 = var2;
   }

   static {
      field3192 = new class231("LIVE", 0);
      field3191 = new class231("BUILDLIVE", 3);
      field3198 = new class231("RC", 1);
      field3190 = new class231("WIP", 2);
   }
}
