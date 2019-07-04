import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kc")
public class class307 {
   @ObfuscatedName("m")
   public static char[] field1151;
   @ObfuscatedName("f")
   static char[] field1152;
   @ObfuscatedName("q")
   static char[] field1153;
   @ObfuscatedName("w")
   static int[] field1154;
   @ObfuscatedName("g")
   static byte[][][] field1155;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ldt;"
   )
   @Export("soundCache")
   public static SoundCache soundCache;

   static {
      field1151 = new char[64];

      int var0;
      for (var0 = 0; var0 < 26; ++var0) {
         field1151[var0] = (char)(var0 + 65);
      }

      for (var0 = 26; var0 < 52; ++var0) {
         field1151[var0] = (char)(var0 + 97 - 26);
      }

      for (var0 = 52; var0 < 62; ++var0) {
         field1151[var0] = (char)(var0 + 48 - 52);
      }

      field1151[62] = '+';
      field1151[63] = '/';
      field1152 = new char[64];

      for (var0 = 0; var0 < 26; ++var0) {
         field1152[var0] = (char)(var0 + 65);
      }

      for (var0 = 26; var0 < 52; ++var0) {
         field1152[var0] = (char)(var0 + 97 - 26);
      }

      for (var0 = 52; var0 < 62; ++var0) {
         field1152[var0] = (char)(var0 + 48 - 52);
      }

      field1152[62] = '*';
      field1152[63] = '-';
      field1153 = new char[64];

      for (var0 = 0; var0 < 26; ++var0) {
         field1153[var0] = (char)(var0 + 65);
      }

      for (var0 = 26; var0 < 52; ++var0) {
         field1153[var0] = (char)(var0 + 97 - 26);
      }

      for (var0 = 52; var0 < 62; ++var0) {
         field1153[var0] = (char)(var0 + 48 - 52);
      }

      field1153[62] = '-';
      field1153[63] = '_';
      field1154 = new int[128];

      for (var0 = 0; var0 < field1154.length; ++var0) {
         field1154[var0] = -1;
      }

      for (var0 = 65; var0 <= 90; ++var0) {
         field1154[var0] = var0 - 65;
      }

      for (var0 = 97; var0 <= 122; ++var0) {
         field1154[var0] = var0 - 97 + 26;
      }

      for (var0 = 48; var0 <= 57; ++var0) {
         field1154[var0] = var0 - 48 + 52;
      }

      int[] var1 = field1154;
      field1154[43] = 62;
      var1[42] = 62;
      int[] var2 = field1154;
      field1154[47] = 63;
      var2[45] = 63;
   }
}
