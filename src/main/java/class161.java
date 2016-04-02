import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fy")
public class class161 {
   @ObfuscatedName("w")
   static char[] field2639;
   @ObfuscatedName("f")
   static int[] field2640;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = 1854078925
   )
   static int field2642;
   @ObfuscatedName("e")
   static char[] field2643 = new char[64];

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field2643[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2643[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2643[var0] = (char)(48 + var0 - 52);
      }

      field2643[62] = 43;
      field2643[63] = 47;
      field2639 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field2639[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2639[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2639[var0] = (char)(48 + var0 - 52);
      }

      field2639[62] = 42;
      field2639[63] = 45;
      field2640 = new int[128];

      for(var0 = 0; var0 < field2640.length; ++var0) {
         field2640[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field2640[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field2640[var0] = 26 + (var0 - 97);
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field2640[var0] = var0 - 48 + 52;
      }

      int[] var2 = field2640;
      field2640[43] = 62;
      var2[42] = 62;
      int[] var1 = field2640;
      field2640[47] = 63;
      var1[45] = 63;
   }
}
