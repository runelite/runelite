import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public final class class10 extends class9 {
   @ObfuscatedName("dq")
   static Task field262;
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = -975809923
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = -1360471207
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = 202631745
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("bi")
   static ModIcon[] field263;
   @ObfuscatedName("fv")
   static int[] field259;
   @ObfuscatedName("cz")
   @Export("indexTrack2")
   static IndexData indexTrack2;
   @ObfuscatedName("u")
   static int[] field256;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 173871339
   )
   final int field258;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1316245573
   )
   final int field254;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -587350623
   )
   final int field252;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -627217073
   )
   final int field257;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1878558871
   )
   final int field253;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -924574065
   )
   final int field251;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1441461557
   )
   final int field268;

   class10(Model var1, int var2, int var3, int var4, int var5) {
      this.field258 = var2 + var1.field1949 - var1.field1947;
      this.field252 = var3 + var1.field1950 - var1.field1974;
      this.field253 = var4 + var1.field1951 - var1.field1954;
      this.field254 = var2 + var1.field1949 + var1.field1947;
      this.field257 = var3 + var1.field1950 + var1.field1974;
      this.field251 = var4 + var1.field1951 + var1.field1954;
      this.field268 = var5;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   final void vmethod54() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.field258:this.field254;
         int var2 = (var4 & 2) == 0?this.field252:this.field257;
         int var3 = (var4 & 4) == 0?this.field253:this.field251;
         if((var4 & 1) == 0) {
            class227.method4063(var1, var2, var3, this.field254, var2, var3, this.field268);
         }

         if((var4 & 2) == 0) {
            class227.method4063(var1, var2, var3, var1, this.field257, var3, this.field268);
         }

         if((var4 & 4) == 0) {
            class227.method4063(var1, var2, var3, var1, var2, this.field251, this.field268);
         }
      }

   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1344594123"
   )
   static final void method57(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class29.region.method2688(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class29.region.method2743(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class221.field2833.image;
         var11 = (103 - var2) * 2048 + 4 * var1 + 24624;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = PlayerComposition.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            ModIcon var14 = GZipDecompressor.field2330[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var13.sizeY * 4 - var14.height) / 2;
               var14.method4952(var15 + 48 + 4 * var1, var16 + (104 - var2 - var13.sizeY) * 4 + 48);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 3 + 512] = var9;
                  var10[var11 + 3 + 1024] = var9;
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[1536 + var11 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[1536 + var11 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[3 + var11 + 512] = var9;
                  var10[var11 + 3 + 1024] = var9;
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class29.region.method2675(var0, var1, var2);
      if(var5 != 0) {
         var6 = class29.region.method2743(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = PlayerComposition.getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            ModIcon var17 = GZipDecompressor.field2330[var23.mapSceneId];
            if(var17 != null) {
               var12 = (var23.sizeX * 4 - var17.originalWidth) / 2;
               var18 = (var23.sizeY * 4 - var17.height) / 2;
               var17.method4952(4 * var1 + 48 + var12, var18 + (104 - var2 - var23.sizeY) * 4 + 48);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = class221.field2833.image;
            var18 = var1 * 4 + 24624 + (103 - var2) * 2048;
            if(var7 != 0 && var7 != 2) {
               var22[var18] = var11;
               var22[var18 + 512 + 1] = var11;
               var22[var18 + 1024 + 2] = var11;
               var22[var18 + 1536 + 3] = var11;
            } else {
               var22[var18 + 1536] = var11;
               var22[var18 + 1024 + 1] = var11;
               var22[var18 + 512 + 2] = var11;
               var22[var18 + 3] = var11;
            }
         }
      }

      var5 = class29.region.method2747(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var19 = PlayerComposition.getObjectDefinition(var6);
         if(var19.mapSceneId != -1) {
            ModIcon var20 = GZipDecompressor.field2330[var19.mapSceneId];
            if(var20 != null) {
               var9 = (var19.sizeX * 4 - var20.originalWidth) / 2;
               int var21 = (var19.sizeY * 4 - var20.height) / 2;
               var20.method4952(var9 + 48 + var1 * 4, var21 + 4 * (104 - var2 - var19.sizeY) + 48);
            }
         }
      }

   }
}
