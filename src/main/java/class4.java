import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("f")
public class class4 {
   @ObfuscatedName("j")
   static final BigInteger field73 = new BigInteger("10001", 16);
   @ObfuscatedName("ep")
   static class78[] field74;
   @ObfuscatedName("p")
   static int[] field75;
   @ObfuscatedName("l")
   static final BigInteger field76 = new BigInteger("9af81c9f218cdd7bf3a2e04a6df00f9a842c536cb48e40371679a0d13a03f5089f7bcdcaf230ec707d9e43013e8b4a9d1f5dec33c0613c9098b64e56e65683e4170e112ce0f60eb150508049fd8ec01caec46491c4ba1aed208f66ed39e73328dd3a3a2ca8d86bcf34d5c410f560eb1d5f89eb9352944ab391bde362cf3a4091", 16);
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      longValue = 3011619382367253243L
   )
   static long field79;

   @ObfuscatedName("m")
   static final void method36() {
      class85.field1509 = false;
      client.field457 = false;
   }

   @ObfuscatedName("k")
   public static void method37() {
      class39.field879.method3720();
      class39.field882.method3720();
   }

   @ObfuscatedName("j")
   public static int method38(byte[] var0, int var1) {
      int var3 = -1;

      for(int var4 = 0; var4 < var1; ++var4) {
         var3 = var3 >>> 8 ^ class118.field1993[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("dr")
   static final void method39(class3 var0, boolean var1) {
      int var2 = var0.field66;
      int var3 = (int)var0.field3112;
      var0.method3853();
      if(var1) {
         method40(var2);
      }

      class107.method2353(var2);
      class172 var4 = class31.method698(var3);
      if(null != var4) {
         class114.method2400(var4);
      }

      class107.method2371();
      if(-1 != client.field448) {
         class18.method192(client.field448, 1);
      }

   }

   @ObfuscatedName("f")
   public static void method40(int var0) {
      if(var0 != -1) {
         if(class172.field2750[var0]) {
            class51.field1162.method3269(var0);
            if(class172.field2757[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < class172.field2757[var0].length; ++var2) {
                  if(class172.field2757[var0][var2] != null) {
                     if(class172.field2757[var0][var2].field2849 != 2) {
                        class172.field2757[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  class172.field2757[var0] = null;
               }

               class172.field2750[var0] = false;
            }
         }
      }
   }

   @ObfuscatedName("f")
   public static void method41(int var0, class166 var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.method3248(var2);
      int var7 = var1.method3238(var6, var3);
      class182.field2957 = 1;
      class182.field2955 = var1;
      class125.field2043 = var6;
      class7.field138 = var7;
      class75.field1388 = var4;
      class11.field182 = var5;
      class3.field62 = var0;
   }

   @ObfuscatedName("ad")
   static final void method42(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class105.method2335(var0, var1, class75.field1386) - var2;
         var0 -= class142.field2197;
         var3 -= class36.field797;
         var1 -= class147.field2228;
         int var4 = class90.field1587[client.field556];
         int var5 = class90.field1590[client.field556];
         int var6 = class90.field1587[class74.field1371];
         int var7 = class90.field1590[class74.field1371];
         int var8 = var7 * var0 + var6 * var1 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var4 * var1 >> 16;
         var1 = var4 * var3 + var5 * var1 >> 16;
         if(var1 >= 50) {
            client.field358 = (client.field552 / 2 + var0 * client.field487 / var1) * -1;
            client.field396 = (client.field553 / 2 + client.field487 * var8 / var1) * -1;
         } else {
            client.field358 = 1;
            client.field396 = 1;
         }

      } else {
         client.field358 = 1;
         client.field396 = 1;
      }
   }
}
