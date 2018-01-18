import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("jp")
public class class280 {
   @ObfuscatedName("n")
   static char[] field3755;
   @ObfuscatedName("v")
   static char[] field3754;
   @ObfuscatedName("y")
   static int[] field3756;

   static {
      field3755 = new char[64];

      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3755[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3755[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3755[var0] = (char)(var0 + 48 - 52);
      }

      field3755[62] = '+';
      field3755[63] = '/';
      field3754 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3754[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3754[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3754[var0] = (char)(var0 + 48 - 52);
      }

      field3754[62] = '*';
      field3754[63] = '-';
      field3756 = new int[128];

      for(var0 = 0; var0 < field3756.length; ++var0) {
         field3756[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3756[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3756[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3756[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3756;
      field3756[43] = 62;
      var2[42] = 62;
      int[] var1 = field3756;
      field3756[47] = 63;
      var1[45] = 63;
   }
}
