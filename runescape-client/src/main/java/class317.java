import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("lq")
public class class317 {
   @ObfuscatedName("t")
   static char[] field3928;
   @ObfuscatedName("q")
   static char[] field3930;
   @ObfuscatedName("i")
   static int[] field3925;

   static {
      field3928 = new char[64];

      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3928[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3928[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3928[var0] = (char)(var0 + 48 - 52);
      }

      field3928[62] = '+';
      field3928[63] = '/';
      field3930 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3930[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3930[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3930[var0] = (char)(var0 + 48 - 52);
      }

      field3930[62] = '*';
      field3930[63] = '-';
      field3925 = new int[128];

      for(var0 = 0; var0 < field3925.length; ++var0) {
         field3925[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3925[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3925[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3925[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3925;
      field3925[43] = 62;
      var2[42] = 62;
      int[] var1 = field3925;
      field3925[47] = 63;
      var1[45] = 63;
   }
}
