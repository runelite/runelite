import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fg")
public class class164 {
   @ObfuscatedName("d")
   static char[] field2704;
   @ObfuscatedName("v")
   static int[] field2705;
   @ObfuscatedName("a")
   static char[] field2706 = new char[64];
   @ObfuscatedName("j")
   static String field2707;
   @ObfuscatedName("ek")
   static SpritePixels[] field2709;

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field2706[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2706[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2706[var0] = (char)(48 + var0 - 52);
      }

      field2706[62] = 43;
      field2706[63] = 47;
      field2704 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field2704[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2704[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2704[var0] = (char)(48 + var0 - 52);
      }

      field2704[62] = 42;
      field2704[63] = 45;
      field2705 = new int[128];

      for(var0 = 0; var0 < field2705.length; ++var0) {
         field2705[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field2705[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field2705[var0] = 26 + (var0 - 97);
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field2705[var0] = 52 + (var0 - 48);
      }

      int[] var2 = field2705;
      field2705[43] = 62;
      var2[42] = 62;
      int[] var1 = field2705;
      field2705[47] = 63;
      var1[45] = 63;
   }
}
