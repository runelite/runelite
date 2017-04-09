import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gs")
public class class206 {
   @ObfuscatedName("u")
   static int[] field3097;
   @ObfuscatedName("i")
   static char[] field3098;
   @ObfuscatedName("f")
   static char[] field3100 = new char[64];

   class206() throws Throwable {
      throw new Error();
   }

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3100[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3100[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3100[var0] = (char)(var0 + 48 - 52);
      }

      field3100[62] = 43;
      field3100[63] = 47;
      field3098 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3098[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3098[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3098[var0] = (char)(var0 + 48 - 52);
      }

      field3098[62] = 42;
      field3098[63] = 45;
      field3097 = new int[128];

      for(var0 = 0; var0 < field3097.length; ++var0) {
         field3097[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3097[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3097[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3097[var0] = var0 - 48 + 52;
      }

      int[] var1 = field3097;
      field3097[43] = 62;
      var1[42] = 62;
      int[] var2 = field3097;
      field3097[47] = 63;
      var2[45] = 63;
   }
}
