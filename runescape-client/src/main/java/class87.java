import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
public final class class87 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 416888625
   )
   int field1506;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1234739397
   )
   int field1507;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1134641983
   )
   int field1508;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 257567907
   )
   int field1509;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -101464999
   )
   public int field1510 = 0;
   @ObfuscatedName("e")
   public class85 field1511;
   @ObfuscatedName("i")
   public class85 field1512;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1738058283
   )
   int field1513;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1714536535
   )
   int field1515 = 0;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "5603321"
   )
   public static String method2079(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;
      int var5 = var1;

      int var8;
      for(int var6 = var2 + var1; var5 < var6; var3[var4++] = (char)var8) {
         int var7 = var0[var5++] & 255;
         if(var7 < 128) {
            if(0 == var7) {
               var8 = '�';
            } else {
               var8 = var7;
            }
         } else if(var7 < 192) {
            var8 = '�';
         } else if(var7 < 224) {
            if(var5 < var6 && 128 == (var0[var5] & 192)) {
               var8 = (var7 & 31) << 6 | var0[var5++] & 63;
               if(var8 < 128) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 240) {
            if(var5 + 1 < var6 && 128 == (var0[var5] & 192) && (var0[var5 + 1] & 192) == 128) {
               var8 = (var7 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 < 2048) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 248) {
            if(var5 + 2 < var6 && 128 == (var0[var5] & 192) && (var0[1 + var5] & 192) == 128 && (var0[var5 + 2] & 192) == 128) {
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass42;IIII)V",
      garbageValue = "878748790"
   )
   static void method2080(class42 var0, int var1, int var2, int var3) {
      if(client.field515 < 50 && 0 != client.field514) {
         if(null != var0.field975 && var1 < var0.field975.length) {
            int var4 = var0.field975[var1];
            if(0 != var4) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               client.field439[client.field515] = var5;
               client.field460[client.field515] = var6;
               client.field518[client.field515] = 0;
               client.field543[client.field515] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               client.field519[client.field515] = (var9 << 8) + (var8 << 16) + var7;
               ++client.field515;
            }
         }
      }
   }
}
