import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class22 extends class28 {
   @ObfuscatedName("og")
   static byte field359;
   @ObfuscatedName("gy")
   static SpritePixels[] field360;

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return super.field421 == var2.field421 && super.field422 == var2.field422;
      }
   }

   public int hashCode() {
      return super.field421 | super.field422 << 8;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;LBuffer;B)V",
      garbageValue = "1"
   )
   void method177(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field513.field518) {
         throw new IllegalStateException("");
      } else {
         super.field423 = var2.readUnsignedByte();
         super.field430 = var2.readUnsignedByte();
         super.field424 = var2.readUnsignedShort();
         super.field420 = var2.readUnsignedShort();
         super.field421 = var2.readUnsignedShort();
         super.field422 = var2.readUnsignedShort();
         super.field430 = Math.min(super.field430, 4);
         super.field425 = new short[1][64][64];
         super.field419 = new short[super.field430][64][64];
         super.field427 = new byte[super.field430][64][64];
         super.field428 = new byte[super.field430][64][64];
         super.field429 = new class31[super.field430][64][64][];
         var3 = var1.readUnsignedByte();
         if(class35.field512.field505 != var3) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(super.field421 == var4 && var5 == super.field422) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method230(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "267912501"
   )
   public static String method181(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class266.field3665[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1631333982"
   )
   static int method184(int var0, int var1, int var2) {
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

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "1"
   )
   static final void method185(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var2 - var0;
      int var7 = var3 - var1;
      int var8 = var6 >= 0?var6:-var6;
      int var9 = var7 >= 0?var7:-var7;
      int var10 = var8;
      if(var8 < var9) {
         var10 = var9;
      }

      if(var10 != 0) {
         int var11 = (var6 << 16) / var10;
         int var12 = (var7 << 16) / var10;
         if(var12 <= var11) {
            var11 = -var11;
         } else {
            var12 = -var12;
         }

         int var13 = var12 * var5 >> 17;
         int var14 = var12 * var5 + 1 >> 17;
         int var15 = var5 * var11 >> 17;
         int var16 = var5 * var11 + 1 >> 17;
         var0 -= Rasterizer2D.field3752;
         var1 -= Rasterizer2D.drawingAreaTop;
         int var17 = var0 + var13;
         int var18 = var0 - var14;
         int var19 = var0 + var6 - var14;
         int var20 = var0 + var6 + var13;
         int var21 = var1 + var15;
         int var22 = var1 - var16;
         int var23 = var7 + var1 - var16;
         int var24 = var7 + var1 + var15;
         class136.setRasterClippingEnabled(var17, var18, var19);
         class136.rasterFlat(var21, var22, var23, var17, var18, var19, var4);
         class136.setRasterClippingEnabled(var17, var19, var20);
         class136.rasterFlat(var21, var23, var24, var17, var19, var20, var4);
      }
   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(IIIIIS)V",
      garbageValue = "1536"
   )
   static final void method186(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class17.region.method2584(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class17.region.method2727(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = Actor.field1268.image;
         var11 = (103 - var2) * 2048 + var1 * 4 + 24624;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = class29.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            ModIcon var14 = Client.field925[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var13.sizeY * 4 - var14.height) / 2;
               var14.method4923(var1 * 4 + 48 + var15, var16 + (104 - var2 - var13.sizeY) * 4 + 48);
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
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
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
                  var10[var11 + 3 + 512] = var9;
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

      var5 = class17.region.method2606(var0, var1, var2);
      if(var5 != 0) {
         var6 = class17.region.method2727(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = class29.getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            ModIcon var17 = Client.field925[var23.mapSceneId];
            if(var17 != null) {
               var12 = (var23.sizeX * 4 - var17.originalWidth) / 2;
               var18 = (var23.sizeY * 4 - var17.height) / 2;
               var17.method4923(var12 + var1 * 4 + 48, var18 + (104 - var2 - var23.sizeY) * 4 + 48);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = Actor.field1268.image;
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

      var5 = class17.region.method2659(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var19 = class29.getObjectDefinition(var6);
         if(var19.mapSceneId != -1) {
            ModIcon var20 = Client.field925[var19.mapSceneId];
            if(var20 != null) {
               var9 = (var19.sizeX * 4 - var20.originalWidth) / 2;
               int var21 = (var19.sizeY * 4 - var20.height) / 2;
               var20.method4923(var1 * 4 + 48 + var9, var21 + (104 - var2 - var19.sizeY) * 4 + 48);
            }
         }
      }

   }
}
