import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("jq")
public class class270 {
   @ObfuscatedName("j")
   static char[] field3665;
   @ObfuscatedName("h")
   static char[] field3663;
   @ObfuscatedName("f")
   static int[] field3664;

   static {
      field3665 = new char[64];

      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3665[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3665[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3665[var0] = (char)(var0 + 48 - 52);
      }

      field3665[62] = 43;
      field3665[63] = 47;
      field3663 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3663[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3663[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3663[var0] = (char)(var0 + 48 - 52);
      }

      field3663[62] = 42;
      field3663[63] = 45;
      field3664 = new int[128];

      for(var0 = 0; var0 < field3664.length; ++var0) {
         field3664[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3664[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3664[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3664[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3664;
      field3664[43] = 62;
      var2[42] = 62;
      int[] var1 = field3664;
      field3664[47] = 63;
      var1[45] = 63;
   }
}
