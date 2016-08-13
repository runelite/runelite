import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class164 {
   @ObfuscatedName("bc")
   static class171 field2699;
   @ObfuscatedName("r")
   static int[] field2701;
   @ObfuscatedName("l")
   static char[] field2702 = new char[64];
   @ObfuscatedName("g")
   static char[] field2703;

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(III)Lclass110;",
      garbageValue = "-653197386"
   )
   static class110 method3333(int var0, int var1) {
      Client.field573.field1951 = var0;
      Client.field573.field1948 = var1;
      Client.field573.field1949 = 1;
      Client.field573.field1950 = 1;
      return Client.field573;
   }

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field2702[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2702[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2702[var0] = (char)(48 + var0 - 52);
      }

      field2702[62] = 43;
      field2702[63] = 47;
      field2703 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field2703[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2703[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2703[var0] = (char)(var0 + 48 - 52);
      }

      field2703[62] = 42;
      field2703[63] = 45;
      field2701 = new int[128];

      for(var0 = 0; var0 < field2701.length; ++var0) {
         field2701[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field2701[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field2701[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field2701[var0] = 52 + (var0 - 48);
      }

      int[] var1 = field2701;
      field2701[43] = 62;
      var1[42] = 62;
      int[] var2 = field2701;
      field2701[47] = 63;
      var2[45] = 63;
   }
}
