import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("lk")
public class class317 {
   @ObfuscatedName("o")
   static char[] field3926;
   @ObfuscatedName("k")
   static char[] field3927;
   @ObfuscatedName("t")
   static int[] field3928;

   static {
      field3926 = new char[64];

      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3926[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3926[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3926[var0] = (char)(var0 + 48 - 52);
      }

      field3926[62] = '+';
      field3926[63] = '/';
      field3927 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3927[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3927[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3927[var0] = (char)(var0 + 48 - 52);
      }

      field3927[62] = '*';
      field3927[63] = '-';
      field3928 = new int[128];

      for(var0 = 0; var0 < field3928.length; ++var0) {
         field3928[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3928[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3928[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3928[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3928;
      field3928[43] = 62;
      var2[42] = 62;
      int[] var1 = field3928;
      field3928[47] = 63;
      var1[45] = 63;
   }
}
