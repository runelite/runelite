import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("jq")
public class class269 {
   @ObfuscatedName("d")
   static char[] field3681;
   @ObfuscatedName("k")
   static char[] field3680;
   @ObfuscatedName("e")
   static int[] field3679;

   static {
      field3681 = new char[64];

      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3681[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3681[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3681[var0] = (char)(var0 + 48 - 52);
      }

      field3681[62] = '+';
      field3681[63] = '/';
      field3680 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3680[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3680[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3680[var0] = (char)(var0 + 48 - 52);
      }

      field3680[62] = '*';
      field3680[63] = '-';
      field3679 = new int[128];

      for(var0 = 0; var0 < field3679.length; ++var0) {
         field3679[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3679[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3679[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3679[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3679;
      field3679[43] = 62;
      var2[42] = 62;
      int[] var1 = field3679;
      field3679[47] = 63;
      var1[45] = 63;
   }
}
