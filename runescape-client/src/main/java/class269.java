import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("js")
public class class269 {
   @ObfuscatedName("d")
   static char[] field3661;
   @ObfuscatedName("q")
   static char[] field3660;
   @ObfuscatedName("x")
   static int[] field3664;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      longValue = 6869412325350852255L
   )
   static long field3665;

   static {
      field3661 = new char[64];

      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3661[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3661[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3661[var0] = (char)(var0 + 48 - 52);
      }

      field3661[62] = 43;
      field3661[63] = 47;
      field3660 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3660[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3660[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3660[var0] = (char)(var0 + 48 - 52);
      }

      field3660[62] = 42;
      field3660[63] = 45;
      field3664 = new int[128];

      for(var0 = 0; var0 < field3664.length; ++var0) {
         field3664[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3664[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3664[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3664[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3664;
      field3664[43] = 62;
      var2[42] = 62;
      int[] var1 = field3664;
      field3664[47] = 63;
      var1[45] = 63;
   }
}
