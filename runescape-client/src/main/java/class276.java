import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ja")
public class class276 {
   @ObfuscatedName("b")
   public static char[] field3724;
   @ObfuscatedName("s")
   static char[] field3725;
   @ObfuscatedName("r")
   static int[] field3723;

   static {
      field3724 = new char[64];

      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3724[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3724[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3724[var0] = (char)(var0 + 48 - 52);
      }

      field3724[62] = '+';
      field3724[63] = '/';
      field3725 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3725[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3725[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3725[var0] = (char)(var0 + 48 - 52);
      }

      field3725[62] = '*';
      field3725[63] = '-';
      field3723 = new int[128];

      for(var0 = 0; var0 < field3723.length; ++var0) {
         field3723[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3723[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3723[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3723[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3723;
      field3723[43] = 62;
      var2[42] = 62;
      int[] var1 = field3723;
      field3723[47] = 63;
      var1[45] = 63;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "-67"
   )
   public static int method4885(CharSequence var0) {
      return class61.parseInt(var0, 10, true);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "79354493"
   )
   public static boolean method4884(char var0) {
      return var0 >= '0' && var0 <= '9';
   }
}
