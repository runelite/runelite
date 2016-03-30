import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fi")
public class class161 {
   @ObfuscatedName("x")
   static char[] field2663;
   @ObfuscatedName("t")
   static int[] field2665;
   @ObfuscatedName("w")
   static char[] field2666 = new char[64];
   @ObfuscatedName("z")
   static int[] field2667;
   @ObfuscatedName("y")
   static class78 field2668;

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field2666[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2666[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2666[var0] = (char)(var0 + 48 - 52);
      }

      field2666[62] = 43;
      field2666[63] = 47;
      field2663 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field2663[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2663[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2663[var0] = (char)(var0 + 48 - 52);
      }

      field2663[62] = 42;
      field2663[63] = 45;
      field2665 = new int[128];

      for(var0 = 0; var0 < field2665.length; ++var0) {
         field2665[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field2665[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field2665[var0] = 26 + (var0 - 97);
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field2665[var0] = var0 - 48 + 52;
      }

      int[] var2 = field2665;
      field2665[43] = 62;
      var2[42] = 62;
      int[] var1 = field2665;
      field2665[47] = 63;
      var1[45] = 63;
   }
}
