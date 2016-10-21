import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public class class164 {
   @ObfuscatedName("e")
   static char[] field2674;
   @ObfuscatedName("k")
   static class157 field2676;
   @ObfuscatedName("n")
   static int[] field2677;
   @ObfuscatedName("f")
   static char[] field2679 = new char[64];

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field2679[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2679[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2679[var0] = (char)(48 + var0 - 52);
      }

      field2679[62] = 43;
      field2679[63] = 47;
      field2674 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field2674[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2674[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2674[var0] = (char)(var0 + 48 - 52);
      }

      field2674[62] = 42;
      field2674[63] = 45;
      field2677 = new int[128];

      for(var0 = 0; var0 < field2677.length; ++var0) {
         field2677[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field2677[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field2677[var0] = 26 + (var0 - 97);
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field2677[var0] = var0 - 48 + 52;
      }

      int[] var2 = field2677;
      field2677[43] = 62;
      var2[42] = 62;
      int[] var1 = field2677;
      field2677[47] = 63;
      var1[45] = 63;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "0"
   )
   static final int method3217(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class50.method1028(var3, var5);
      int var8 = class50.method1028(var3 + 1, var5);
      int var9 = class50.method1028(var3, 1 + var5);
      int var10 = class50.method1028(1 + var3, 1 + var5);
      int var12 = 65536 - class94.field1646[1024 * var4 / var2] >> 1;
      int var11 = ((65536 - var12) * var7 >> 16) + (var12 * var8 >> 16);
      int var14 = 65536 - class94.field1646[1024 * var4 / var2] >> 1;
      int var13 = (var10 * var14 >> 16) + (var9 * (65536 - var14) >> 16);
      int var16 = 65536 - class94.field1646[1024 * var6 / var2] >> 1;
      int var15 = (var16 * var13 >> 16) + (var11 * (65536 - var16) >> 16);
      return var15;
   }
}
