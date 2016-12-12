import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gk")
public class class206 {
   @ObfuscatedName("i")
   public static char[] field3084 = new char[64];
   @ObfuscatedName("e")
   static char[] field3085;
   @ObfuscatedName("f")
   static int[] field3086;

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3084[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3084[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3084[var0] = (char)(var0 + 48 - 52);
      }

      field3084[62] = 43;
      field3084[63] = 47;
      field3085 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3085[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3085[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3085[var0] = (char)(48 + var0 - 52);
      }

      field3085[62] = 42;
      field3085[63] = 45;
      field3086 = new int[128];

      for(var0 = 0; var0 < field3086.length; ++var0) {
         field3086[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3086[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3086[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3086[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3086;
      field3086[43] = 62;
      var2[42] = 62;
      int[] var1 = field3086;
      field3086[47] = 63;
      var1[45] = 63;
   }
}
