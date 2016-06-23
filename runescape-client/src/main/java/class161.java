import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fr")
public class class161 {
   @ObfuscatedName("f")
   static char[] field2639 = new char[64];
   @ObfuscatedName("x")
   static int[] field2641;
   @ObfuscatedName("u")
   static char[] field2642;

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field2639[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2639[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2639[var0] = (char)(48 + var0 - 52);
      }

      field2639[62] = 43;
      field2639[63] = 47;
      field2642 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field2642[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2642[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2642[var0] = (char)(48 + var0 - 52);
      }

      field2642[62] = 42;
      field2642[63] = 45;
      field2641 = new int[128];

      for(var0 = 0; var0 < field2641.length; ++var0) {
         field2641[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field2641[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field2641[var0] = 26 + (var0 - 97);
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field2641[var0] = 52 + (var0 - 48);
      }

      int[] var2 = field2641;
      field2641[43] = 62;
      var2[42] = 62;
      int[] var1 = field2641;
      field2641[47] = 63;
      var1[45] = 63;
   }
}
