import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class161 {
   @ObfuscatedName("j")
   static int[] field2630;
   @ObfuscatedName("ay")
   static boolean field2631;
   @ObfuscatedName("eb")
   static class78[] field2632;
   @ObfuscatedName("b")
   static char[] field2634 = new char[64];
   @ObfuscatedName("g")
   static char[] field2635;

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field2634[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2634[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2634[var0] = (char)(48 + var0 - 52);
      }

      field2634[62] = 43;
      field2634[63] = 47;
      field2635 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field2635[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2635[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2635[var0] = (char)(var0 + 48 - 52);
      }

      field2635[62] = 42;
      field2635[63] = 45;
      field2630 = new int[128];

      for(var0 = 0; var0 < field2630.length; ++var0) {
         field2630[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field2630[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field2630[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field2630[var0] = 52 + (var0 - 48);
      }

      int[] var2 = field2630;
      field2630[43] = 62;
      var2[42] = 62;
      int[] var1 = field2630;
      field2630[47] = 63;
      var1[45] = 63;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lclass173;",
      garbageValue = "1802476828"
   )
   public static class173 method3205(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(class173.field2750[var1] == null || null == class173.field2750[var1][var2]) {
         boolean var3 = class84.method1909(var1);
         if(!var3) {
            return null;
         }
      }

      return class173.field2750[var1][var2];
   }
}
