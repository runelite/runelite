import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gi")
public class class206 {
   @ObfuscatedName("x")
   static char[] field3072;
   @ObfuscatedName("i")
   static int[] field3073;
   @ObfuscatedName("u")
   static char[] field3074 = new char[64];
   @ObfuscatedName("t")
   static class208 field3075;

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3074[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3074[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3074[var0] = (char)(48 + var0 - 52);
      }

      field3074[62] = 43;
      field3074[63] = 47;
      field3072 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3072[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3072[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3072[var0] = (char)(48 + var0 - 52);
      }

      field3072[62] = 42;
      field3072[63] = 45;
      field3073 = new int[128];

      for(var0 = 0; var0 < field3073.length; ++var0) {
         field3073[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3073[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3073[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3073[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3073;
      field3073[43] = 62;
      var2[42] = 62;
      int[] var1 = field3073;
      field3073[47] = 63;
      var1[45] = 63;
   }
}
