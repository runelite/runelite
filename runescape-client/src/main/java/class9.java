import java.io.IOException;
import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class9 {
   @ObfuscatedName("t")
   static final BigInteger field145 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("bc")
   static class171 field147;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = 2131460659
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("ac")
   static int[] field149;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = -1522136415
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = -1781552871
   )
   protected static int field151;
   @ObfuscatedName("z")
   static final BigInteger field154 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Lclass8;",
      garbageValue = "-735629287"
   )
   static class8 method126() {
      FileOnDisk var0 = null;
      class8 var1 = new class8();

      try {
         var0 = GameObject.method2224("", Client.field548.field2347, false);
         byte[] var2 = new byte[(int)var0.method4180()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.method4178(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new class8(new Buffer(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method4197();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-20"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[Item.plane][var0][var1];
      if(var2 == null) {
         class16.region.method2107(Item.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method3854(); null != var6; var6 = (Item)var2.method3869()) {
            ItemComposition var7 = MessageNode.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class16.region.method2107(Item.plane, var0, var1);
         } else {
            var2.method3877(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.method3854(); null != var6; var6 = (Item)var2.method3869()) {
               if(var6.id != var5.id) {
                  if(null == var11) {
                     var11 = var6;
                  }

                  if(var6.id != var11.id && null == var10) {
                     var10 = var6;
                  }
               }
            }

            int var9 = 1610612736 + var0 + (var1 << 7);
            class16.region.method1955(Item.plane, var0, var1, class116.method2462(var0 * 128 + 64, var1 * 128 + 64, Item.plane), var5, var9, var11, var10);
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "29"
   )
   public static int method130(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1945733608"
   )
   static final void method131(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class16.region.method2022(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var21;
      if(var5 != 0) {
         var6 = class16.region.method2033(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = TextureProvider.field1712.image;
         var11 = 24624 + 4 * var1 + 2048 * (103 - var2);
         var21 = var5 >> 14 & 32767;
         ObjectComposition var13 = class165.getObjectDefinition(var21);
         if(var13.field977 != -1) {
            ModIcon var14 = class18.field257[var13.field977];
            if(null != var14) {
               int var15 = (var13.field963 * 4 - var14.originalWidth) / 2;
               int var16 = (var13.field964 * 4 - var14.height) / 2;
               var14.method1900(var1 * 4 + 48 + var15, var16 + 48 + (104 - var2 - var13.field964) * 4);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[1024 + var11] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[3 + var11] = var9;
                  var10[512 + var11 + 3] = var9;
                  var10[1024 + var11 + 3] = var9;
                  var10[1536 + var11 + 3] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
                  var10[1 + 1536 + var11] = var9;
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
                  var10[1536 + var11 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[512 + var11] = var9;
                  var10[1024 + var11] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[2 + var11] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[3 + var11 + 512] = var9;
                  var10[var11 + 3 + 1024] = var9;
                  var10[1536 + var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[1536 + var11] = var9;
                  var10[1 + var11 + 1536] = var9;
                  var10[1536 + var11 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class16.region.method1976(var0, var1, var2);
      if(var5 != 0) {
         var6 = class16.region.method2033(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = class165.getObjectDefinition(var9);
         int var19;
         if(var23.field977 != -1) {
            ModIcon var20 = class18.field257[var23.field977];
            if(var20 != null) {
               var21 = (var23.field963 * 4 - var20.originalWidth) / 2;
               var19 = (var23.field964 * 4 - var20.height) / 2;
               var20.method1900(48 + var1 * 4 + var21, 48 + (104 - var2 - var23.field964) * 4 + var19);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var12 = TextureProvider.field1712.image;
            var19 = 2048 * (103 - var2) + 24624 + 4 * var1;
            if(var7 != 0 && var7 != 2) {
               var12[var19] = var11;
               var12[1 + 512 + var19] = var11;
               var12[1024 + var19 + 2] = var11;
               var12[3 + 1536 + var19] = var11;
            } else {
               var12[1536 + var19] = var11;
               var12[1 + var19 + 1024] = var11;
               var12[2 + var19 + 512] = var11;
               var12[3 + var19] = var11;
            }
         }
      }

      var5 = class16.region.method1977(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var18 = class165.getObjectDefinition(var6);
         if(var18.field977 != -1) {
            ModIcon var17 = class18.field257[var18.field977];
            if(var17 != null) {
               var9 = (var18.field963 * 4 - var17.originalWidth) / 2;
               int var22 = (var18.field964 * 4 - var17.height) / 2;
               var17.method1900(var9 + var1 * 4 + 48, (104 - var2 - var18.field964) * 4 + 48 + var22);
            }
         }
      }

   }
}
