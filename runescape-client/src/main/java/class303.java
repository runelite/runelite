import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ka")
public class class303 {
   @ObfuscatedName("b")
   static char[] field3799;
   @ObfuscatedName("q")
   static char[] field3797;
   @ObfuscatedName("o")
   static int[] field3801;

   static {
      field3799 = new char[64];

      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3799[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3799[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3799[var0] = (char)(var0 + 48 - 52);
      }

      field3799[62] = '+';
      field3799[63] = '/';
      field3797 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3797[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3797[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3797[var0] = (char)(var0 + 48 - 52);
      }

      field3797[62] = '*';
      field3797[63] = '-';
      field3801 = new int[128];

      for(var0 = 0; var0 < field3801.length; ++var0) {
         field3801[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3801[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3801[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3801[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3801;
      field3801[43] = 62;
      var2[42] = 62;
      int[] var1 = field3801;
      field3801[47] = 63;
      var1[45] = 63;
   }
}
