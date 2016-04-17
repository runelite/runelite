import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fx")
public class class161 {
   @ObfuscatedName("d")
   static int[] field2633;
   @ObfuscatedName("w")
   static char[] field2634;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = 359588321
   )
   static int field2636;
   @ObfuscatedName("a")
   static char[] field2637 = new char[64];

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field2637[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2637[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2637[var0] = (char)(48 + var0 - 52);
      }

      field2637[62] = 43;
      field2637[63] = 47;
      field2634 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field2634[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2634[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2634[var0] = (char)(var0 + 48 - 52);
      }

      field2634[62] = 42;
      field2634[63] = 45;
      field2633 = new int[128];

      for(var0 = 0; var0 < field2633.length; ++var0) {
         field2633[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field2633[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field2633[var0] = 26 + (var0 - 97);
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field2633[var0] = 52 + (var0 - 48);
      }

      int[] var2 = field2633;
      field2633[43] = 62;
      var2[42] = 62;
      int[] var1 = field2633;
      field2633[47] = 63;
      var1[45] = 63;
   }
}
