import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fm")
public class class164 {
   @ObfuscatedName("t")
   static int[] field2691;
   @ObfuscatedName("s")
   public static char[] field2692 = new char[64];
   @ObfuscatedName("z")
   static char[] field2694;

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field2692[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2692[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2692[var0] = (char)(48 + var0 - 52);
      }

      field2692[62] = 43;
      field2692[63] = 47;
      field2694 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field2694[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2694[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2694[var0] = (char)(var0 + 48 - 52);
      }

      field2694[62] = 42;
      field2694[63] = 45;
      field2691 = new int[128];

      for(var0 = 0; var0 < field2691.length; ++var0) {
         field2691[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field2691[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field2691[var0] = 26 + (var0 - 97);
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field2691[var0] = 52 + (var0 - 48);
      }

      int[] var2 = field2691;
      field2691[43] = 62;
      var2[42] = 62;
      int[] var1 = field2691;
      field2691[47] = 63;
      var1[45] = 63;
   }
}
