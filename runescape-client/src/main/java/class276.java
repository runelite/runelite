import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("jw")
public class class276 {
   @ObfuscatedName("d")
   static char[] field3734;
   @ObfuscatedName("x")
   static char[] field3735;
   @ObfuscatedName("k")
   static int[] field3736;

   static {
      field3734 = new char[64];

      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3734[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3734[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3734[var0] = (char)(var0 + 48 - 52);
      }

      field3734[62] = '+';
      field3734[63] = '/';
      field3735 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3735[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3735[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3735[var0] = (char)(var0 + 48 - 52);
      }

      field3735[62] = '*';
      field3735[63] = '-';
      field3736 = new int[128];

      for(var0 = 0; var0 < field3736.length; ++var0) {
         field3736[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3736[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3736[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3736[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3736;
      field3736[43] = 62;
      var2[42] = 62;
      int[] var1 = field3736;
      field3736[47] = 63;
      var1[45] = 63;
   }
}
