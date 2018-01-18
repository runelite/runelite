import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("UrlRequest")
public class UrlRequest {
   @ObfuscatedName("n")
   @Export("url")
   final URL url;
   @ObfuscatedName("v")
   @Export("isDone0")
   volatile boolean isDone0;
   @ObfuscatedName("y")
   @Export("response0")
   volatile byte[] response0;

   UrlRequest(URL var1) {
      this.url = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-264675776"
   )
   @Export("isDone")
   public boolean isDone() {
      return this.isDone0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "35"
   )
   @Export("getResponse")
   public byte[] getResponse() {
      return this.response0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IILfo;Lfi;I)Z",
      garbageValue = "-1580087558"
   )
   public static final boolean method2985(int var0, int var1, class168 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class167.field2236[var6][var7] = 99;
      class167.field2238[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class167.field2241[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class167.field2240[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class167.field2241[var11];
         var5 = class167.field2240[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod3237(2, var4, var5, var3)) {
            class3.field16 = var4;
            class3.field19 = var5;
            return true;
         }

         int var15 = class167.field2238[var16][var17] + 1;
         if(var16 > 0 && class167.field2236[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
            class167.field2241[var18] = var4 - 1;
            class167.field2240[var18] = var5;
            var18 = var18 + 1 & 4095;
            class167.field2236[var16 - 1][var17] = 2;
            class167.field2238[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class167.field2236[var16 + 1][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[var13 + 2][var14 + 1] & 19136992) == 0) {
            class167.field2241[var18] = var4 + 1;
            class167.field2240[var18] = var5;
            var18 = var18 + 1 & 4095;
            class167.field2236[var16 + 1][var17] = 8;
            class167.field2238[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class167.field2236[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
            class167.field2241[var18] = var4;
            class167.field2240[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class167.field2236[var16][var17 - 1] = 1;
            class167.field2238[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && class167.field2236[var16][var17 + 1] == 0 && (var12[var13][var14 + 2] & 19136824) == 0 && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
            class167.field2241[var18] = var4;
            class167.field2240[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class167.field2236[var16][var17 + 1] = 4;
            class167.field2238[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class167.field2236[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class167.field2241[var18] = var4 - 1;
            class167.field2240[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class167.field2236[var16 - 1][var17 - 1] = 3;
            class167.field2238[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class167.field2236[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
            class167.field2241[var18] = var4 + 1;
            class167.field2240[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class167.field2236[var16 + 1][var17 - 1] = 9;
            class167.field2238[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class167.field2236[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
            class167.field2241[var18] = var4 - 1;
            class167.field2240[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class167.field2236[var16 - 1][var17 + 1] = 6;
            class167.field2238[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 126 && var17 < 126 && class167.field2236[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 2] & 19137016) == 0 && (var12[var13 + 2][var14 + 2] & 19136992) == 0 && (var12[var13 + 2][var14 + 1] & 19136995) == 0) {
            class167.field2241[var18] = var4 + 1;
            class167.field2240[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class167.field2236[var16 + 1][var17 + 1] = 12;
            class167.field2238[var16 + 1][var17 + 1] = var15;
         }
      }

      class3.field16 = var4;
      class3.field19 = var5;
      return false;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public static void method2986() {
      Overlay.overlays.reset();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1599607778"
   )
   static final int method2984(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }
}
