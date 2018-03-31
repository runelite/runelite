import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lk")
public class class317 {
   @ObfuscatedName("c")
   public static char[] field3924;
   @ObfuscatedName("i")
   static char[] field3923;
   @ObfuscatedName("o")
   static int[] field3925;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1050056085
   )
   @Export("sampleRate")
   public static int sampleRate;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   static SpritePixels field3926;

   static {
      field3924 = new char[64];

      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3924[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3924[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3924[var0] = (char)(var0 + 48 - 52);
      }

      field3924[62] = '+';
      field3924[63] = '/';
      field3923 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3923[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3923[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3923[var0] = (char)(var0 + 48 - 52);
      }

      field3923[62] = '*';
      field3923[63] = '-';
      field3925 = new int[128];

      for(var0 = 0; var0 < field3925.length; ++var0) {
         field3925[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3925[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3925[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3925[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3925;
      field3925[43] = 62;
      var2[42] = 62;
      int[] var1 = field3925;
      field3925[47] = 63;
      var1[45] = 63;
   }
}
