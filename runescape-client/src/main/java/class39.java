import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class39 {
   @ObfuscatedName("c")
   @Export("rsaKeyModulus")
   static final BigInteger rsaKeyModulus;
   @ObfuscatedName("v")
   static ModIcon field797;
   @ObfuscatedName("d")
   @Export("rsaKeyExponent")
   static final BigInteger rsaKeyExponent;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = 1722949959
   )
   static int field802;

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass166;I)V",
      garbageValue = "65535"
   )
   static final void method772(int var0, int var1, int var2, int var3, SpritePixels var4, class166 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle + Client.mapScale & 2047;
         int var7 = var2 * var2 + var3 * var3;
         if(var7 <= 6400) {
            int var8 = class84.field1433[var6];
            int var9 = class84.field1441[var6];
            var8 = var8 * 256 / (Client.mapScaleDelta + 256);
            var9 = var9 * 256 / (Client.mapScaleDelta + 256);
            int var10 = var8 * var3 + var2 * var9 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method4287(var5.field2167 / 2 + var10 - var4.maxWidth / 2, var5.field2165 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2167, var5.field2165, var5.field2166, var5.field2164);
            } else {
               var4.method4230(var0 + var5.field2167 / 2 + var10 - var4.maxWidth / 2, var1 + var5.field2165 / 2 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }

   static {
      rsaKeyExponent = new BigInteger("10001", 16);
      rsaKeyModulus = new BigInteger("9cb954af0865fabe3fcee77d0a91524f62b18e71b550fa614215edb36424cc57718697e30a7f074ed8bf30c15bb2fca615790d6b322606e48445c2b3393680f56874e5ae8a9f89cd7bbab8c2dd8d2b233b3731f5bb00e9ddb3eddc7a46db157ba848e3ba5fe1e71edde7e36d0976b7ba8dd2ad6c9712ccc9c788212347c3a517", 16);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "6"
   )
   static final int method773(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1791918581"
   )
   public static void method774() {
      ObjectComposition.field2926.reset();
      ObjectComposition.field2927.reset();
      ObjectComposition.field2928.reset();
      ObjectComposition.field2948.reset();
   }

   class39() throws Throwable {
      throw new Error();
   }
}
