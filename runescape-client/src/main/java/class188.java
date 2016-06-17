import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
public class class188 {
   @ObfuscatedName("gt")
   public static final int[] field3045 = new int[]{-2, 0, 2, 2, 0, 0, 0, 0, 0, 0, -2, 10, -1, 0, 8, 0, 4, 0, 0, 0, -1, 0, 0, 0, 6, 0, -1, 0, 0, 0, 0, 0, 0, 0, 6, 6, 0, -2, 2, 0, 6, -2, 0, -2, -2, 5, 0, 0, 0, 0, 0, 0, -2, 0, 8, 0, 0, 0, 0, 3, 0, 0, 7, 2, 4, 0, 0, 0, 0, 2, 0, 15, -1, 0, 0, 0, 0, 3, 0, 0, 0, -2, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 4, 0, -2, 0, 0, 0, 6, 0, 0, 0, 14, 0, 0, 0, -2, 0, 0, 5, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, -2, 0, 0, 0, 8, 0, 28, 4, 0, 2, -2, 0, 0, 0, -1, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 6, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 12, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5, -2, 0, 10, -2, 0, 0, -2, 0, 0, 0, 0, 0, 7, 0, 0, 4, 0, 6, 0, 1, 0, 0, 2, 0, 6, -2, 0, -1, 0, 2, 0, 8, 0, 0, 0, 0, -2, 6, 0, 0, 0, 0, 1, 4, 0, 0};

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "57"
   )
   public static String method3752(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;
      int var5 = var1;

      int var8;
      for(int var6 = var2 + var1; var5 < var6; var3[var4++] = (char)var8) {
         int var7 = var0[var5++] & 255;
         if(var7 < 128) {
            if(var7 == 0) {
               var8 = '�';
            } else {
               var8 = var7;
            }
         } else if(var7 < 192) {
            var8 = '�';
         } else if(var7 < 224) {
            if(var5 < var6 && (var0[var5] & 192) == 128) {
               var8 = (var7 & 31) << 6 | var0[var5++] & 63;
               if(var8 < 128) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 240) {
            if(var5 + 1 < var6 && (var0[var5] & 192) == 128 && (var0[1 + var5] & 192) == 128) {
               var8 = (var7 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 < 2048) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 248) {
            if(var5 + 2 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128 && (var0[var5 + 2] & 192) == 128) {
               var8 = (var7 & 7) << 18 | (var0[var5++] & 63) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 >= 65536 && var8 <= 1114111) {
                  var8 = '�';
               } else {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else {
            var8 = '�';
         }
      }

      return new String(var3, 0, var4);
   }
}
