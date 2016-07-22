import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public class class164 {
   @ObfuscatedName("m")
   public static char[] field2702 = new char[64];
   @ObfuscatedName("w")
   static char[] field2703;
   @ObfuscatedName("e")
   static int[] field2704;

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field2702[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2702[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2702[var0] = (char)(var0 + 48 - 52);
      }

      field2702[62] = 43;
      field2702[63] = 47;
      field2703 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field2703[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2703[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2703[var0] = (char)(48 + var0 - 52);
      }

      field2703[62] = 42;
      field2703[63] = 45;
      field2704 = new int[128];

      for(var0 = 0; var0 < field2704.length; ++var0) {
         field2704[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field2704[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field2704[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field2704[var0] = var0 - 48 + 52;
      }

      int[] var2 = field2704;
      field2704[43] = 62;
      var2[42] = 62;
      int[] var1 = field2704;
      field2704[47] = 63;
      var1[45] = 63;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass170;IIS)Lclass81;",
      garbageValue = "4558"
   )
   public static class81 method3232(class170 var0, int var1, int var2) {
      if(!class33.method708(var0, var1, var2)) {
         return null;
      } else {
         class81 var4 = new class81();
         var4.field1475 = class79.field1457;
         var4.field1481 = class79.field1458;
         var4.field1478 = class79.field1459[0];
         var4.field1479 = class79.field1460[0];
         var4.field1476 = class79.field1463[0];
         var4.field1480 = class117.field2021[0];
         int var5 = var4.field1476 * var4.field1480;
         byte[] var6 = class10.field151[0];
         var4.field1486 = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.field1486[var7] = class79.field1462[var6[var7] & 255];
         }

         class18.method191();
         return var4;
      }
   }
}
