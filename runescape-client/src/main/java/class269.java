import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("jg")
public class class269 {
   @ObfuscatedName("w")
   static char[] field3677;
   @ObfuscatedName("s")
   static char[] field3676;
   @ObfuscatedName("q")
   static int[] field3678;

   static {
      field3677 = new char[64];

      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3677[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3677[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3677[var0] = (char)(var0 + 48 - 52);
      }

      field3677[62] = '+';
      field3677[63] = '/';
      field3676 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3676[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3676[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3676[var0] = (char)(var0 + 48 - 52);
      }

      field3676[62] = '*';
      field3676[63] = '-';
      field3678 = new int[128];

      for(var0 = 0; var0 < field3678.length; ++var0) {
         field3678[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3678[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3678[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3678[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3678;
      field3678[43] = 62;
      var2[42] = 62;
      int[] var1 = field3678;
      field3678[47] = 63;
      var1[45] = 63;
   }
}
