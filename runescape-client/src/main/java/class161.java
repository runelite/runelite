import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class161 {
   @ObfuscatedName("i")
   static char[] field2667;
   @ObfuscatedName("t")
   public static char[] field2668 = new char[64];
   @ObfuscatedName("g")
   static int[] field2669;
   @ObfuscatedName("be")
   @Export("host")
   static String field2670;
   @ObfuscatedName("h")
   static byte[][][] field2672;

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1987357368"
   )
   static final void method3156() {
      client.field325.method2733(39);

      for(class3 var0 = (class3)client.field443.method3751(); null != var0; var0 = (class3)client.field443.method3752()) {
         if(var0.field64 == 0 || var0.field64 == 3) {
            class44.method912(var0, true);
         }
      }

      if(null != client.field399) {
         class20.method547(client.field399);
         client.field399 = null;
      }

   }

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field2668[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2668[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2668[var0] = (char)(48 + var0 - 52);
      }

      field2668[62] = 43;
      field2668[63] = 47;
      field2667 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field2667[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2667[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2667[var0] = (char)(var0 + 48 - 52);
      }

      field2667[62] = 42;
      field2667[63] = 45;
      field2669 = new int[128];

      for(var0 = 0; var0 < field2669.length; ++var0) {
         field2669[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field2669[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field2669[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field2669[var0] = var0 - 48 + 52;
      }

      int[] var2 = field2669;
      field2669[43] = 62;
      var2[42] = 62;
      int[] var1 = field2669;
      field2669[47] = 63;
      var1[45] = 63;
   }
}
