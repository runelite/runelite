import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fy")
public class class164 {
   @ObfuscatedName("cx")
   static class227 field2683;
   @ObfuscatedName("e")
   static char[] field2684 = new char[64];
   @ObfuscatedName("c")
   static int[] field2685;
   @ObfuscatedName("l")
   static char[] field2686;

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field2684[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2684[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2684[var0] = (char)(var0 + 48 - 52);
      }

      field2684[62] = 43;
      field2684[63] = 47;
      field2686 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field2686[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2686[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2686[var0] = (char)(48 + var0 - 52);
      }

      field2686[62] = 42;
      field2686[63] = 45;
      field2685 = new int[128];

      for(var0 = 0; var0 < field2685.length; ++var0) {
         field2685[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field2685[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field2685[var0] = 26 + (var0 - 97);
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field2685[var0] = var0 - 48 + 52;
      }

      int[] var2 = field2685;
      field2685[43] = 62;
      var2[42] = 62;
      int[] var1 = field2685;
      field2685[47] = 63;
      var1[45] = 63;
   }
}
