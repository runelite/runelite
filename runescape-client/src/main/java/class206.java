import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gl")
public class class206 {
   @ObfuscatedName("n")
   static char[] field3077 = new char[64];
   @ObfuscatedName("m")
   static int[] field3078;
   @ObfuscatedName("d")
   static char[] field3079;
   @ObfuscatedName("z")
   @Export("worldServersDownload")
   static class26 worldServersDownload;

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3077[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3077[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3077[var0] = (char)(48 + var0 - 52);
      }

      field3077[62] = 43;
      field3077[63] = 47;
      field3079 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3079[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3079[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3079[var0] = (char)(48 + var0 - 52);
      }

      field3079[62] = 42;
      field3079[63] = 45;
      field3078 = new int[128];

      for(var0 = 0; var0 < field3078.length; ++var0) {
         field3078[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3078[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3078[var0] = 26 + (var0 - 97);
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3078[var0] = 52 + (var0 - 48);
      }

      int[] var2 = field3078;
      field3078[43] = 62;
      var2[42] = 62;
      int[] var1 = field3078;
      field3078[47] = 63;
      var1[45] = 63;
   }
}
