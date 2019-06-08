import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kc")
public class class307 {
   @ObfuscatedName("m")
   @Export("__kc_m")
   public static char[] __kc_m;
   @ObfuscatedName("f")
   @Export("__kc_f")
   static char[] __kc_f;
   @ObfuscatedName("q")
   @Export("__kc_q")
   static char[] __kc_q;
   @ObfuscatedName("w")
   @Export("__kc_w")
   static int[] __kc_w;
   @ObfuscatedName("g")
   @Export("__kc_g")
   static byte[][][] __kc_g;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ldt;"
   )
   @Export("soundCache")
   public static SoundCache soundCache;

   static {
      __kc_m = new char[64];

      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         __kc_m[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         __kc_m[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         __kc_m[var0] = (char)(var0 + 48 - 52);
      }

      __kc_m[62] = '+';
      __kc_m[63] = '/';
      __kc_f = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         __kc_f[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         __kc_f[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         __kc_f[var0] = (char)(var0 + 48 - 52);
      }

      __kc_f[62] = '*';
      __kc_f[63] = '-';
      __kc_q = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         __kc_q[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         __kc_q[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         __kc_q[var0] = (char)(var0 + 48 - 52);
      }

      __kc_q[62] = '-';
      __kc_q[63] = '_';
      __kc_w = new int[128];

      for(var0 = 0; var0 < __kc_w.length; ++var0) {
         __kc_w[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         __kc_w[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         __kc_w[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         __kc_w[var0] = var0 - 48 + 52;
      }

      int[] var2 = __kc_w;
      __kc_w[43] = 62;
      var2[42] = 62;
      int[] var1 = __kc_w;
      __kc_w[47] = 63;
      var1[45] = 63;
   }
}
