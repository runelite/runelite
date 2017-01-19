import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gw")
public class class206 {
   @ObfuscatedName("c")
   static char[] field3092;
   @ObfuscatedName("s")
   static char[] field3093 = new char[64];
   @ObfuscatedName("f")
   static int[] field3095;

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3093[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3093[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3093[var0] = (char)(48 + var0 - 52);
      }

      field3093[62] = 43;
      field3093[63] = 47;
      field3092 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3092[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3092[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3092[var0] = (char)(48 + var0 - 52);
      }

      field3092[62] = 42;
      field3092[63] = 45;
      field3095 = new int[128];

      for(var0 = 0; var0 < field3095.length; ++var0) {
         field3095[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3095[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3095[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3095[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3095;
      field3095[43] = 62;
      var2[42] = 62;
      int[] var1 = field3095;
      field3095[47] = 63;
      var1[45] = 63;
   }
}
