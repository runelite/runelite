import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class184 extends Node {
   @ObfuscatedName("l")
   int[] field2985 = new int[128];
   @ObfuscatedName("h")
   class65[] field2986 = new class65[128];
   @ObfuscatedName("e")
   short[] field2987 = new short[128];
   @ObfuscatedName("g")
   byte[] field2988 = new byte[128];
   @ObfuscatedName("n")
   byte[] field2989 = new byte[128];
   @ObfuscatedName("d")
   byte[] field2990 = new byte[128];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1548256397
   )
   int field2991;
   @ObfuscatedName("u")
   class188[] field2993 = new class188[128];

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass62;[B[II)Z",
      garbageValue = "1813827082"
   )
   boolean method3555(class62 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class65 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(null == var2 || var2[var7] != 0) {
            int var8 = this.field2985[var7];
            if(var8 != 0) {
               if(var8 != var5) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1297(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1294(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(null != var6) {
                  this.field2986[var7] = var6;
                  this.field2985[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   class184(byte[] var1) {
      Buffer var2 = new Buffer(var1);

      int var3;
      for(var3 = 0; var2.payload[var2.offset + var3] != 0; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.method2545();
      }

      ++var2.offset;
      ++var3;
      var5 = var2.offset;
      var2.offset += var3;

      int var6;
      for(var6 = 0; var2.payload[var6 + var2.offset] != 0; ++var6) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.method2545();
      }

      ++var2.offset;
      ++var6;
      var8 = var2.offset;
      var2.offset += var6;

      int var9;
      for(var9 = 0; var2.payload[var9 + var2.offset] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var41 = 0; var41 < var9; ++var41) {
         var10[var41] = var2.method2545();
      }

      ++var2.offset;
      ++var9;
      byte[] var11 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var11[1] = 1;
         int var13 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var15 = var2.method2544();
            if(var15 == 0) {
               var13 = var12++;
            } else {
               if(var15 <= var13) {
                  --var15;
               }

               var13 = var15;
            }

            var11[var14] = (byte)var13;
         }
      } else {
         var12 = var9;
      }

      class188[] var36 = new class188[var12];

      class188 var39;
      for(var14 = 0; var14 < var36.length; ++var14) {
         var39 = var36[var14] = new class188();
         int var16 = var2.method2544();
         if(var16 > 0) {
            var39.field3047 = new byte[var16 * 2];
         }

         var16 = var2.method2544();
         if(var16 > 0) {
            var39.field3057 = new byte[2 + 2 * var16];
            var39.field3057[1] = 64;
         }
      }

      var14 = var2.method2544();
      byte[] var47 = var14 > 0?new byte[2 * var14]:null;
      var14 = var2.method2544();
      byte[] var38 = var14 > 0?new byte[2 * var14]:null;

      int var17;
      for(var17 = 0; var2.payload[var2.offset + var17] != 0; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.method2545();
      }

      ++var2.offset;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2544();
         this.field2987[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2544();
         this.field2987[var20] = (short)(this.field2987[var20] + (var19 << 8));
      }

      var20 = 0;
      int var21 = 0;
      int var22 = 0;

      int var23;
      for(var23 = 0; var23 < 128; ++var23) {
         if(var20 == 0) {
            if(var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            var22 = var2.method2616();
         }

         this.field2987[var23] = (short)(this.field2987[var23] + ((var22 - 1 & 2) << 14));
         this.field2985[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2985[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2990[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var40 = 0; var40 < 128; ++var40) {
         if(this.field2985[var40] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field2989[var40] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class188 var25 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2985[var26] != 0) {
            if(var20 == 0) {
               var25 = var36[var11[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2993[var26] = var25;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var26 = 0;

      int var27;
      for(var27 = 0; var27 < 128; ++var27) {
         if(var20 == 0) {
            if(var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            if(this.field2985[var27] > 0) {
               var26 = var2.method2544() + 1;
            }
         }

         this.field2988[var27] = (byte)var26;
         --var20;
      }

      this.field2991 = var2.method2544() + 1;

      class188 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var36[var27];
         if(null != var28.field3047) {
            for(var29 = 1; var29 < var28.field3047.length; var29 += 2) {
               var28.field3047[var29] = var2.method2545();
            }
         }

         if(var28.field3057 != null) {
            for(var29 = 3; var29 < var28.field3057.length - 2; var29 += 2) {
               var28.field3057[var29] = var2.method2545();
            }
         }
      }

      if(var47 != null) {
         for(var27 = 1; var27 < var47.length; var27 += 2) {
            var47[var27] = var2.method2545();
         }
      }

      if(null != var38) {
         for(var27 = 1; var27 < var38.length; var27 += 2) {
            var38[var27] = var2.method2545();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var36[var27];
         if(null != var28.field3057) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field3057.length; var29 += 2) {
               var19 = 1 + var19 + var2.method2544();
               var28.field3057[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var36[var27];
         if(var28.field3047 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field3047.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2544();
               var28.field3047[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var42;
      byte var44;
      if(null != var47) {
         var19 = var2.method2544();
         var47[0] = (byte)var19;

         for(var27 = 2; var27 < var47.length; var27 += 2) {
            var19 = var19 + 1 + var2.method2544();
            var47[var27] = (byte)var19;
         }

         var44 = var47[0];
         byte var37 = var47[1];

         for(var29 = 0; var29 < var44; ++var29) {
            this.field2988[var29] = (byte)(32 + var37 * this.field2988[var29] >> 6);
         }

         for(var29 = 2; var29 < var47.length; var29 += 2) {
            var30 = var47[var29];
            byte var31 = var47[1 + var29];
            var32 = var37 * (var30 - var44) + (var30 - var44) / 2;

            for(var33 = var44; var33 < var30; ++var33) {
               var34 = class51.method1057(var32, var30 - var44);
               this.field2988[var33] = (byte)(32 + this.field2988[var33] * var34 >> 6);
               var32 += var31 - var37;
            }

            var44 = var30;
            var37 = var31;
         }

         for(var42 = var44; var42 < 128; ++var42) {
            this.field2988[var42] = (byte)(32 + var37 * this.field2988[var42] >> 6);
         }

         var39 = null;
      }

      if(var38 != null) {
         var19 = var2.method2544();
         var38[0] = (byte)var19;

         for(var27 = 2; var27 < var38.length; var27 += 2) {
            var19 = 1 + var19 + var2.method2544();
            var38[var27] = (byte)var19;
         }

         var44 = var38[0];
         int var45 = var38[1] << 1;

         for(var29 = 0; var29 < var44; ++var29) {
            var42 = var45 + (this.field2989[var29] & 255);
            if(var42 < 0) {
               var42 = 0;
            }

            if(var42 > 128) {
               var42 = 128;
            }

            this.field2989[var29] = (byte)var42;
         }

         int var43;
         for(var29 = 2; var29 < var38.length; var29 += 2) {
            var30 = var38[var29];
            var43 = var38[1 + var29] << 1;
            var32 = (var30 - var44) / 2 + (var30 - var44) * var45;

            for(var33 = var44; var33 < var30; ++var33) {
               var34 = class51.method1057(var32, var30 - var44);
               int var35 = (this.field2989[var33] & 255) + var34;
               if(var35 < 0) {
                  var35 = 0;
               }

               if(var35 > 128) {
                  var35 = 128;
               }

               this.field2989[var33] = (byte)var35;
               var32 += var43 - var45;
            }

            var44 = var30;
            var45 = var43;
         }

         for(var42 = var44; var42 < 128; ++var42) {
            var43 = (this.field2989[var42] & 255) + var45;
            if(var43 < 0) {
               var43 = 0;
            }

            if(var43 > 128) {
               var43 = 128;
            }

            this.field2989[var42] = (byte)var43;
         }

         Object var46 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var36[var27].field3048 = var2.method2544();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var36[var27];
         if(var28.field3047 != null) {
            var28.field3049 = var2.method2544();
         }

         if(null != var28.field3057) {
            var28.field3050 = var2.method2544();
         }

         if(var28.field3048 > 0) {
            var28.field3051 = var2.method2544();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var36[var27].field3053 = var2.method2544();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var36[var27];
         if(var28.field3053 > 0) {
            var28.field3055 = var2.method2544();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var36[var27];
         if(var28.field3055 > 0) {
            var28.field3054 = var2.method2544();
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-256387459"
   )
   void method3558() {
      this.field2985 = null;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIIIZB)LSpritePixels;",
      garbageValue = "21"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var2 << 38) + ((long)var1 << 16) + (long)var0 + ((long)var4 << 40) + ((long)var3 << 42);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = class92.getItemDefinition(var0);
      if(var1 > 1 && null != var9.field1200) {
         int var10 = -1;

         for(int var21 = 0; var21 < 10; ++var21) {
            if(var1 >= var9.field1201[var21] && var9.field1201[var21] != 0) {
               var10 = var9.field1200[var21];
            }
         }

         if(var10 != -1) {
            var9 = class92.getItemDefinition(var10);
         }
      }

      Model var22 = var9.getModel(1);
      if(null == var22) {
         return null;
      } else {
         SpritePixels var11 = null;
         if(var9.field1203 != -1) {
            var11 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var11 == null) {
               return null;
            }
         } else if(var9.field1185 != -1) {
            var11 = createSprite(var9.field1211, var1, var2, var3, 0, false);
            if(var11 == null) {
               return null;
            }
         } else if(var9.field1212 != -1) {
            var11 = createSprite(var9.field1213, var1, 0, 0, 0, false);
            if(null == var11) {
               return null;
            }
         }

         int[] var12 = class82.graphicsPixels;
         int var13 = class82.graphicsPixelsWidth;
         int var14 = class82.graphicsPixelsHeight;
         int[] var15 = new int[4];
         class82.method1833(var15);
         var8 = new SpritePixels(36, 32);
         class82.setRasterBuffer(var8.image, 36, 32);
         class82.method1835();
         class94.method2153();
         class94.method2146(16, 16);
         class94.rasterGouraudLowRes = false;
         if(var9.field1212 != -1) {
            var11.method1810(0, 0);
         }

         int var16 = var9.field1177;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = var16 * class94.field1623[var9.field1178] >> 16;
         int var18 = class94.field1642[var9.field1178] * var16 >> 16;
         var22.method2335();
         var22.method2347(0, var9.field1179, var9.field1180, var9.field1178, var9.field1181, var9.field1182 + var17 + var22.modelHeight / 2, var18 + var9.field1182);
         if(var9.field1185 != -1) {
            var11.method1810(0, 0);
         }

         if(var2 >= 1) {
            var8.method1746(1);
         }

         if(var2 >= 2) {
            var8.method1746(16777215);
         }

         if(var3 != 0) {
            var8.method1750(var3);
         }

         class82.setRasterBuffer(var8.image, 36, 32);
         if(var9.field1203 != -1) {
            var11.method1810(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            class227 var19 = FaceNormal.field1507;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method4124(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         class82.setRasterBuffer(var12, var13, var14);
         class82.method1834(var15);
         class94.method2153();
         class94.rasterGouraudLowRes = true;
         return var8;
      }
   }
}
