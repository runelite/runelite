import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("kj")
public class class292 {
   @ObfuscatedName("p")
   static char[] field3771;
   @ObfuscatedName("i")
   static char[] field3772;
   @ObfuscatedName("w")
   static int[] field3773;

   static {
      field3771 = new char[64];

      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3771[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3771[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3771[var0] = (char)(var0 + 48 - 52);
      }

      field3771[62] = '+';
      field3771[63] = '/';
      field3772 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3772[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3772[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3772[var0] = (char)(var0 + 48 - 52);
      }

      field3772[62] = '*';
      field3772[63] = '-';
      field3773 = new int[128];

      for(var0 = 0; var0 < field3773.length; ++var0) {
         field3773[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3773[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3773[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3773[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3773;
      field3773[43] = 62;
      var2[42] = 62;
      int[] var1 = field3773;
      field3773[47] = 63;
      var1[45] = 63;
   }
}
