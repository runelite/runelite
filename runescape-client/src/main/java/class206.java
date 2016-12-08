import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public class class206 {
   @ObfuscatedName("b")
   static int[] field3084;
   @ObfuscatedName("m")
   static char[] field3085;
   @ObfuscatedName("bu")
   static class184 field3086;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 657938913
   )
   static int field3087;
   @ObfuscatedName("o")
   public static char[] field3089 = new char[64];
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1391229527
   )
   static int field3091;

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "-615257012"
   )
   static final void method3733(Actor var0, int var1) {
      Sequence.method3699(var0.x, var0.y, var1);
   }

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3089[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3089[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3089[var0] = (char)(var0 + 48 - 52);
      }

      field3089[62] = 43;
      field3089[63] = 47;
      field3085 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3085[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3085[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3085[var0] = (char)(var0 + 48 - 52);
      }

      field3085[62] = 42;
      field3085[63] = 45;
      field3084 = new int[128];

      for(var0 = 0; var0 < field3084.length; ++var0) {
         field3084[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3084[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3084[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3084[var0] = 52 + (var0 - 48);
      }

      int[] var2 = field3084;
      field3084[43] = 62;
      var2[42] = 62;
      int[] var1 = field3084;
      field3084[47] = 63;
      var1[45] = 63;
   }
}
