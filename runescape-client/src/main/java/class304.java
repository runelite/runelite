import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("kq")
public class class304 {
   @ObfuscatedName("w")
   static char[] field3736;
   @ObfuscatedName("m")
   static char[] field3734;
   @ObfuscatedName("q")
   static int[] field3735;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1932373969
   )
   static int field3737;

   static {
      field3736 = new char[64];

      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3736[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3736[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3736[var0] = (char)(var0 + 48 - 52);
      }

      field3736[62] = '+';
      field3736[63] = '/';
      field3734 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3734[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3734[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3734[var0] = (char)(var0 + 48 - 52);
      }

      field3734[62] = '*';
      field3734[63] = '-';
      field3735 = new int[128];

      for(var0 = 0; var0 < field3735.length; ++var0) {
         field3735[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3735[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3735[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3735[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3735;
      field3735[43] = 62;
      var2[42] = 62;
      int[] var1 = field3735;
      field3735[47] = 63;
      var1[45] = 63;
   }
}
