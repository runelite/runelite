import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fp")
public class class160 {
   @ObfuscatedName("a")
   static int[] field2646;
   @ObfuscatedName("l")
   static char[] field2647;
   @ObfuscatedName("m")
   static class152 field2648;
   @ObfuscatedName("bc")
   static class167 field2649;
   @ObfuscatedName("j")
   static char[] field2650 = new char[64];

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field2650[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2650[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2650[var0] = (char)(var0 + 48 - 52);
      }

      field2650[62] = 43;
      field2650[63] = 47;
      field2647 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field2647[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2647[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2647[var0] = (char)(48 + var0 - 52);
      }

      field2647[62] = 42;
      field2647[63] = 45;
      field2646 = new int[128];

      for(var0 = 0; var0 < field2646.length; ++var0) {
         field2646[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field2646[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field2646[var0] = 26 + (var0 - 97);
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field2646[var0] = 52 + (var0 - 48);
      }

      int[] var2 = field2646;
      field2646[43] = 62;
      var2[42] = 62;
      int[] var1 = field2646;
      field2646[47] = 63;
      var1[45] = 63;
   }

   @ObfuscatedName("i")
   public static class80[] method3138(class166 var0, String var1, String var2) {
      int var3 = var0.method3248(var1);
      int var4 = var0.method3238(var3, var2);
      return class93.method2138(var0, var3, var4);
   }
}
