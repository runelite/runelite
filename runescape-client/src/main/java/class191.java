import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class191 extends CacheableNode {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2011412437
   )
   public int field2808;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 920861593
   )
   public int field2809;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1443332341
   )
   public int field2810;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1700460571
   )
   public int field2812;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1626037131
   )
   int field2816 = 0;
   @ObfuscatedName("m")
   public static NodeCache field2817 = new NodeCache(64);

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "77"
   )
   public void method3390() {
      this.method3399(this.field2816);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-409330758"
   )
   public void method3391(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3392(var1, var3, var2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIS)V",
      garbageValue = "19114"
   )
   void method3392(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field2816 = var1.read24BitInt();
      }

   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "4"
   )
   static final void method3393(int var0) {
      int[] var1 = class154.field2118.image;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = 24628 + 2048 * (103 - var3);

         for(var5 = 1; var5 < 103; ++var5) {
            if((class10.tileSettings[var0][var5][var3] & 24) == 0) {
               class159.region.method1700(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class10.tileSettings[1 + var0][var5][var3] & 8) != 0) {
               class159.region.method1700(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      class154.field2118.method4040();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class10.tileSettings[var0][var6][var5] & 24) == 0) {
               class10.method122(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class10.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               class10.method122(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field377 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class159.region.method1803(class63.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = class143.getObjectDefinition(var7).field2935;
               if(var8 >= 0) {
                  int var9 = var5;
                  int var10 = var6;
                  if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                     int[][] var13 = Client.collisionMaps[class63.plane].flags;

                     for(int var14 = 0; var14 < 10; ++var14) {
                        int var15 = (int)(Math.random() * 4.0D);
                        if(var15 == 0 && var9 > 0 && var9 > var5 - 3 && (var13[var9 - 1][var10] & 19136776) == 0) {
                           --var9;
                        }

                        if(var15 == 1 && var9 < 103 && var9 < var5 + 3 && (var13[var9 + 1][var10] & 19136896) == 0) {
                           ++var9;
                        }

                        if(var15 == 2 && var10 > 0 && var10 > var6 - 3 && (var13[var9][var10 - 1] & 19136770) == 0) {
                           --var10;
                        }

                        if(var15 == 3 && var10 < 103 && var10 < 3 + var6 && (var13[var9][1 + var10] & 19136800) == 0) {
                           ++var10;
                        }
                     }
                  }

                  Client.field517[Client.field377] = class15.field164[var8];
                  Client.field423[Client.field377] = var9;
                  Client.field474[Client.field377] = var10;
                  ++Client.field377;
               }
            }
         }
      }

      TextureProvider.bufferProvider.method3985();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1929663601"
   )
   void method3399(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var10 + var8) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field2812 = (int)(var14 * 256.0D);
      this.field2809 = (int)(256.0D * var16);
      if(this.field2812 < 0) {
         this.field2812 = 0;
      } else if(this.field2812 > 255) {
         this.field2812 = 255;
      }

      if(this.field2809 < 0) {
         this.field2809 = 0;
      } else if(this.field2809 > 255) {
         this.field2809 = 255;
      }

      if(var16 > 0.5D) {
         this.field2808 = (int)(512.0D * var14 * (1.0D - var16));
      } else {
         this.field2808 = (int)(512.0D * var14 * var16);
      }

      if(this.field2808 < 1) {
         this.field2808 = 1;
      }

      this.field2810 = (int)((double)this.field2808 * var12);
   }
}
