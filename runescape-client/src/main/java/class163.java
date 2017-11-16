import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public class class163 {
   @ObfuscatedName("r")
   static int[][] field2206;
   @ObfuscatedName("g")
   static int[][] field2203;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1637571969
   )
   static int field2204;
   @ObfuscatedName("t")
   static int[] field2201;
   @ObfuscatedName("k")
   static int[] field2202;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1543808131
   )
   static int field2207;

   static {
      field2206 = new int[128][128];
      field2203 = new int[128][128];
      field2201 = new int[4096];
      field2202 = new int[4096];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)Z",
      garbageValue = "-1402417895"
   )
   static boolean method3077(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == '-') {
                  var3 = true;
                  continue;
               }

               if(var8 == '+') {
                  continue;
               }
            }

            int var10;
            if(var8 >= '0' && var8 <= '9') {
               var10 = var8 - '0';
            } else if(var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - '7';
            } else {
               if(var8 < 'a' || var8 > 'z') {
                  return false;
               }

               var10 = var8 - 'W';
            }

            if(var10 >= var1) {
               return false;
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var5 * var1;
            if(var9 / var1 != var5) {
               return false;
            }

            var5 = var9;
            var4 = true;
         }

         return var4;
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lij;IIB)Lkb;",
      garbageValue = "-13"
   )
   public static SpritePixels method3082(IndexDataBase var0, int var1, int var2) {
      return !Sequence.method4738(var0, var1, var2)?null:Occluder.method2895();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II)I",
      garbageValue = "-2071819261"
   )
   public static int method3081(CharSequence var0, int var1) {
      return class61.parseInt(var0, var1, true);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2040664082"
   )
   static final void method3079() {
      short var0 = 256;
      int var1;
      if(class91.field1337 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class91.field1337 > 768) {
               Friend.field758[var1] = GrandExchangeOffer.method113(class82.field1265[var1], class91.field1330[var1], 1024 - class91.field1337);
            } else if(class91.field1337 > 256) {
               Friend.field758[var1] = class91.field1330[var1];
            } else {
               Friend.field758[var1] = GrandExchangeOffer.method113(class91.field1330[var1], class82.field1265[var1], 256 - class91.field1337);
            }
         }
      } else if(class91.field1338 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class91.field1338 > 768) {
               Friend.field758[var1] = GrandExchangeOffer.method113(class82.field1265[var1], class44.field540[var1], 1024 - class91.field1338);
            } else if(class91.field1338 > 256) {
               Friend.field758[var1] = class44.field540[var1];
            } else {
               Friend.field758[var1] = GrandExchangeOffer.method113(class44.field540[var1], class82.field1265[var1], 256 - class91.field1338);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            Friend.field758[var1] = class82.field1265[var1];
         }
      }

      Rasterizer2D.setDrawRegion(class91.field1361, 9, class91.field1361 + 128, var0 + 7);
      class243.field3292.method5138(class91.field1361, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      int var2 = class236.field3227.width * 9 + class91.field1361;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class91.field1358[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class21.field312[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = Friend.field758[var7];
               var10 = class236.field3227.pixels[var2];
               class236.field3227.pixels[var2++] = (var9 * (var10 & 65280) + var8 * (var7 & 65280) & 16711680) + ((var7 & 16711935) * var8 + (var10 & 16711935) * var9 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + class236.field3227.width - 128;
      }

      Rasterizer2D.setDrawRegion(class91.field1361 + 765 - 128, 9, class91.field1361 + 765, var0 + 7);
      class230.field2910.method5138(class91.field1361 + 382, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      var2 = class236.field3227.width * 9 + class91.field1361 + 637 + 24;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class91.field1358[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class21.field312[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = Friend.field758[var7];
               var10 = class236.field3227.pixels[var2];
               class236.field3227.pixels[var2++] = (var8 * (var7 & 65280) + var9 * (var10 & 65280) & 16711680) + ((var7 & 16711935) * var8 + (var10 & 16711935) * var9 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class236.field3227.width - var5 - var4;
      }

   }
}
