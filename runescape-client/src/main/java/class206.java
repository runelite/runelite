import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gu")
public class class206 {
   @ObfuscatedName("h")
   static int[] field3089;
   @ObfuscatedName("q")
   public static char[] field3090 = new char[64];
   @ObfuscatedName("d")
   static char[] field3092;

   class206() throws Throwable {
      throw new Error();
   }

   static {
      int var2;
      for(var2 = 0; var2 < 26; ++var2) {
         field3090[var2] = (char)(65 + var2);
      }

      for(var2 = 26; var2 < 52; ++var2) {
         field3090[var2] = (char)(97 + var2 - 26);
      }

      for(var2 = 52; var2 < 62; ++var2) {
         field3090[var2] = (char)(48 + var2 - 52);
      }

      field3090[62] = 43;
      field3090[63] = 47;
      field3092 = new char[64];

      for(var2 = 0; var2 < 26; ++var2) {
         field3092[var2] = (char)(65 + var2);
      }

      for(var2 = 26; var2 < 52; ++var2) {
         field3092[var2] = (char)(var2 + 97 - 26);
      }

      for(var2 = 52; var2 < 62; ++var2) {
         field3092[var2] = (char)(var2 + 48 - 52);
      }

      field3092[62] = 42;
      field3092[63] = 45;
      field3089 = new int[128];

      for(var2 = 0; var2 < field3089.length; ++var2) {
         field3089[var2] = -1;
      }

      for(var2 = 65; var2 <= 90; ++var2) {
         field3089[var2] = var2 - 65;
      }

      for(var2 = 97; var2 <= 122; ++var2) {
         field3089[var2] = var2 - 97 + 26;
      }

      for(var2 = 48; var2 <= 57; ++var2) {
         field3089[var2] = 52 + (var2 - 48);
      }

      int[] var0 = field3089;
      field3089[43] = 62;
      var0[42] = 62;
      int[] var1 = field3089;
      field3089[47] = 63;
      var1[45] = 63;
   }
}
