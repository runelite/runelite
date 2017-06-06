import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("jf")
public class class269 {
   @ObfuscatedName("i")
   static char[] field3672;
   @ObfuscatedName("c")
   static char[] field3673;
   @ObfuscatedName("e")
   static int[] field3674;
   @ObfuscatedName("h")
   public static short[] field3676;

   static {
      field3672 = new char[64];

      int var2;
      for(var2 = 0; var2 < 26; ++var2) {
         field3672[var2] = (char)(var2 + 65);
      }

      for(var2 = 26; var2 < 52; ++var2) {
         field3672[var2] = (char)(var2 + 97 - 26);
      }

      for(var2 = 52; var2 < 62; ++var2) {
         field3672[var2] = (char)(var2 + 48 - 52);
      }

      field3672[62] = 43;
      field3672[63] = 47;
      field3673 = new char[64];

      for(var2 = 0; var2 < 26; ++var2) {
         field3673[var2] = (char)(var2 + 65);
      }

      for(var2 = 26; var2 < 52; ++var2) {
         field3673[var2] = (char)(var2 + 97 - 26);
      }

      for(var2 = 52; var2 < 62; ++var2) {
         field3673[var2] = (char)(var2 + 48 - 52);
      }

      field3673[62] = 42;
      field3673[63] = 45;
      field3674 = new int[128];

      for(var2 = 0; var2 < field3674.length; ++var2) {
         field3674[var2] = -1;
      }

      for(var2 = 65; var2 <= 90; ++var2) {
         field3674[var2] = var2 - 65;
      }

      for(var2 = 97; var2 <= 122; ++var2) {
         field3674[var2] = var2 - 97 + 26;
      }

      for(var2 = 48; var2 <= 57; ++var2) {
         field3674[var2] = var2 - 48 + 52;
      }

      int[] var0 = field3674;
      field3674[43] = 62;
      var0[42] = 62;
      int[] var1 = field3674;
      field3674[47] = 63;
      var1[45] = 63;
   }
}
