import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
public class class276 {
   @ObfuscatedName("m")
   public static char[] field3731;
   @ObfuscatedName("p")
   static char[] field3730;
   @ObfuscatedName("i")
   static int[] field3732;

   static {
      field3731 = new char[64];

      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3731[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3731[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3731[var0] = (char)(var0 + 48 - 52);
      }

      field3731[62] = '+';
      field3731[63] = '/';
      field3730 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3730[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3730[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3730[var0] = (char)(var0 + 48 - 52);
      }

      field3730[62] = '*';
      field3730[63] = '-';
      field3732 = new int[128];

      for(var0 = 0; var0 < field3732.length; ++var0) {
         field3732[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3732[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3732[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3732[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3732;
      field3732[43] = 62;
      var2[42] = 62;
      int[] var1 = field3732;
      field3732[47] = 63;
      var1[45] = 63;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II)I",
      garbageValue = "1949135448"
   )
   public static int method5043(CharSequence var0, int var1) {
      return class246.parseInt(var0, var1, true);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-12"
   )
   static void method5044() {
      class295.field3853 = null;
      class37.offsetsY = null;
      ItemContainer.field745 = null;
      class31.field428 = null;
      class295.field3852 = null;
      class295.spritePixels = null;
   }
}
