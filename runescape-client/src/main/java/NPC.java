import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("i")
   @Export("composition")
   NPCComposition composition;
   @ObfuscatedName("eu")
   static SpritePixels[] field804;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "-542811593"
   )
   public static void method740(class170 var0) {
      class43.field1000 = var0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "19"
   )
   final void method742(int var1, int var2, boolean var3) {
      if(super.animation != -1 && class192.getAnimation(super.animation).field1023 == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field889 < 9) {
               ++super.field889;
            }

            for(int var6 = super.field889; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field850[var6] = super.field850[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field850[0] = 1;
            return;
         }
      }

      super.field889 = 0;
      super.field894 = 0;
      super.field893 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.pathX[0] * 128 + super.field839 * 64;
      super.y = super.pathY[0] * 128 + super.field839 * 64;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-270112451"
   )
   final boolean vmethod783() {
      return this.composition != null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass125;II)V",
      garbageValue = "-282922216"
   )
   static void method747(class125 var0, int var1) {
      boolean var2 = var0.method2787(1) == 1;
      if(var2) {
         class34.field787[++class34.field775 - 1] = var1;
      }

      int var3 = var0.method2787(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field55 = false;
         } else if(var1 == Client.localInteractingIndex) {
            throw new RuntimeException();
         } else {
            class34.field783[var1] = (DecorativeObject.baseY + var4.pathY[0] >> 6) + (var4.field53 << 28) + (class193.baseX + var4.pathX[0] >> 6 << 14);
            if(var4.field863 != -1) {
               class34.field780[var1] = var4.field863;
            } else {
               class34.field780[var1] = var4.field886;
            }

            class34.field788[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method2787(1) != 0) {
               ChatMessages.method233(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method2787(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field55 = true;
                  var4.field56 = var6;
                  var4.field33 = var7;
               } else {
                  var4.field55 = false;
                  var4.method18(var6, var7, class34.field777[var1]);
               }
            } else {
               var4.method19(var6, var7);
               var4.field55 = false;
            }

         } else if(var3 == 2) {
            var5 = var0.method2787(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(var1 == Client.localInteractingIndex && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method19(var6, var7);
               var4.field55 = false;
            } else if(var2) {
               var4.field55 = true;
               var4.field56 = var6;
               var4.field33 = var7;
            } else {
               var4.field55 = false;
               var4.method18(var6, var7, class34.field777[var1]);
            }

         } else {
            var5 = var0.method2787(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method2787(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var4.pathX[0] + var8;
               var11 = var4.pathY[0] + var9;
               if(var1 == Client.localInteractingIndex && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method19(var10, var11);
                  var4.field55 = false;
               } else if(var2) {
                  var4.field55 = true;
                  var4.field56 = var10;
                  var4.field33 = var11;
               } else {
                  var4.field55 = false;
                  var4.method18(var10, var11, class34.field777[var1]);
               }

               var4.field53 = (byte)(var7 + var4.field53 & 3);
               if(var1 == Client.localInteractingIndex) {
                  class173.plane = var4.field53;
               }

            } else {
               var6 = var0.method2787(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + class193.baseX + var4.pathX[0] & 16383) - class193.baseX;
               var11 = (var4.pathY[0] + DecorativeObject.baseY + var9 & 16383) - DecorativeObject.baseY;
               if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field55 = true;
                     var4.field56 = var10;
                     var4.field33 = var11;
                  } else {
                     var4.field55 = false;
                     var4.method18(var10, var11, class34.field777[var1]);
                  }
               } else {
                  var4.method19(var10, var11);
                  var4.field55 = false;
               }

               var4.field53 = (byte)(var7 + var4.field53 & 3);
               if(Client.localInteractingIndex == var1) {
                  class173.plane = var4.field53;
               }

            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "-2129991659"
   )
   final void method755(int var1, byte var2) {
      int var3 = super.pathX[0];
      int var4 = super.pathY[0];
      if(var1 == 0) {
         --var3;
         ++var4;
      }

      if(var1 == 1) {
         ++var4;
      }

      if(var1 == 2) {
         ++var3;
         ++var4;
      }

      if(var1 == 3) {
         --var3;
      }

      if(var1 == 4) {
         ++var3;
      }

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(var1 == 6) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(super.animation != -1 && class192.getAnimation(super.animation).field1023 == 1) {
         super.animation = -1;
      }

      if(super.field889 < 9) {
         ++super.field889;
      }

      for(int var5 = super.field889; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field850[var5] = super.field850[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field850[0] = var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)[LSpritePixels;",
      garbageValue = "542889354"
   )
   public static SpritePixels[] method756(class170 var0, String var1, String var2) {
      int var3 = var0.method3304(var1);
      int var4 = var0.method3305(var3, var2);
      SpritePixels[] var5;
      if(!class22.method559(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = FrameMap.method2319();
      }

      return var5;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "72"
   )
   public static void method757() {
      KitDefinition.field1047.reset();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "3937"
   )
   public static final boolean method758() {
      class140 var0 = class140.keyboard;
      synchronized(class140.keyboard) {
         if(class140.field2175 == class140.field2159) {
            return false;
         } else {
            class20.field597 = class140.field2170[class140.field2159];
            class129.field2093 = class140.field2169[class140.field2159];
            class140.field2159 = class140.field2159 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1523468294"
   )
   static final void method759(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class35.field801[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5 - 1][var4];
               }

               if(var2 + var0 == var5 && var5 < 103) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][1 + var5][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "117"
   )
   static void method760(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class79.field1436 = var1.method2546();
      class79.field1439 = new int[class79.field1436];
      class79.field1438 = new int[class79.field1436];
      class79.field1443 = new int[class79.field1436];
      class79.field1440 = new int[class79.field1436];
      class79.field1441 = new byte[class79.field1436][];
      var1.offset = var0.length - 7 - class79.field1436 * 8;
      class169.field2713 = var1.method2546();
      class79.field1435 = var1.method2546();
      int var2 = (var1.method2544() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class79.field1436; ++var3) {
         class79.field1439[var3] = var1.method2546();
      }

      for(var3 = 0; var3 < class79.field1436; ++var3) {
         class79.field1438[var3] = var1.method2546();
      }

      for(var3 = 0; var3 < class79.field1436; ++var3) {
         class79.field1443[var3] = var1.method2546();
      }

      for(var3 = 0; var3 < class79.field1436; ++var3) {
         class79.field1440[var3] = var1.method2546();
      }

      var1.offset = var0.length - 7 - class79.field1436 * 8 - 3 * (var2 - 1);
      class129.field2092 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class129.field2092[var3] = var1.method2548();
         if(class129.field2092[var3] == 0) {
            class129.field2092[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class79.field1436; ++var3) {
         int var4 = class79.field1443[var3];
         int var5 = class79.field1440[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class79.field1441[var3] = var7;
         int var8 = var1.method2544();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.method2545();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var10 * var4 + var9] = var1.method2545();
               }
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1050401255"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class192.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || super.idlePoseAnimation == super.poseAnimation && null != var1?null:class192.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method814(var1, super.actionFrame, var2, super.poseFrame);
         if(null == var3) {
            return null;
         } else {
            var3.method2335();
            super.field870 = var3.modelHeight;
            if(super.graphic != -1 && super.field873 != -1) {
               Model var4 = Sequence.method929(super.graphic).method935(super.field873);
               if(null != var4) {
                  var4.method2345(0, -super.field876, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field910 == 1) {
               var3.field1881 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass49;",
      garbageValue = "1578084055"
   )
   public static class49 method762(int var0) {
      class49 var1 = (class49)class49.field1091.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class49.field1082.method3292(33, var0);
         var1 = new class49();
         if(null != var2) {
            var1.method1001(new Buffer(var2));
         }

         class49.field1091.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1249546281"
   )
   static final void method763(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class128.region.method1978(var0, var1, var2);
      int var6;
      int var9;
      int var11;
      int var17;
      int var18;
      int var19;
      if(var5 != 0) {
         var6 = class128.region.method1995(var0, var1, var2, var5);
         var17 = var6 >> 6 & 3;
         var18 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var21 = class178.field2953.image;
         var11 = 24624 + 4 * var1 + 2048 * (103 - var2);
         var19 = var5 >> 14 & 32767;
         ObjectComposition var20 = class9.getObjectDefinition(var19);
         if(var20.field956 != -1) {
            ModIcon var14 = class152.field2279[var20.field956];
            if(null != var14) {
               int var15 = (var20.field959 * 4 - var14.originalWidth) / 2;
               int var16 = (var20.field960 * 4 - var14.height) / 2;
               var14.method1905(var15 + 4 * var1 + 48, var16 + 48 + (104 - var2 - var20.field960) * 4);
            }
         } else {
            if(var18 == 0 || var18 == 2) {
               if(var17 == 0) {
                  var21[var11] = var9;
                  var21[512 + var11] = var9;
                  var21[var11 + 1024] = var9;
                  var21[1536 + var11] = var9;
               } else if(var17 == 1) {
                  var21[var11] = var9;
                  var21[var11 + 1] = var9;
                  var21[var11 + 2] = var9;
                  var21[3 + var11] = var9;
               } else if(var17 == 2) {
                  var21[3 + var11] = var9;
                  var21[512 + 3 + var11] = var9;
                  var21[1024 + var11 + 3] = var9;
                  var21[1536 + var11 + 3] = var9;
               } else if(var17 == 3) {
                  var21[var11 + 1536] = var9;
                  var21[1 + 1536 + var11] = var9;
                  var21[2 + 1536 + var11] = var9;
                  var21[3 + 1536 + var11] = var9;
               }
            }

            if(var18 == 3) {
               if(var17 == 0) {
                  var21[var11] = var9;
               } else if(var17 == 1) {
                  var21[3 + var11] = var9;
               } else if(var17 == 2) {
                  var21[1536 + var11 + 3] = var9;
               } else if(var17 == 3) {
                  var21[1536 + var11] = var9;
               }
            }

            if(var18 == 2) {
               if(var17 == 3) {
                  var21[var11] = var9;
                  var21[var11 + 512] = var9;
                  var21[var11 + 1024] = var9;
                  var21[1536 + var11] = var9;
               } else if(var17 == 0) {
                  var21[var11] = var9;
                  var21[1 + var11] = var9;
                  var21[2 + var11] = var9;
                  var21[var11 + 3] = var9;
               } else if(var17 == 1) {
                  var21[3 + var11] = var9;
                  var21[512 + var11 + 3] = var9;
                  var21[1024 + var11 + 3] = var9;
                  var21[3 + var11 + 1536] = var9;
               } else if(var17 == 2) {
                  var21[var11 + 1536] = var9;
                  var21[1536 + var11 + 1] = var9;
                  var21[1536 + var11 + 2] = var9;
                  var21[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class128.region.method1980(var0, var1, var2);
      if(var5 != 0) {
         var6 = class128.region.method1995(var0, var1, var2, var5);
         var17 = var6 >> 6 & 3;
         var18 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = class9.getObjectDefinition(var9);
         int var13;
         if(var23.field956 != -1) {
            ModIcon var22 = class152.field2279[var23.field956];
            if(null != var22) {
               var19 = (var23.field959 * 4 - var22.originalWidth) / 2;
               var13 = (var23.field960 * 4 - var22.height) / 2;
               var22.method1905(var19 + 4 * var1 + 48, var13 + 4 * (104 - var2 - var23.field960) + 48);
            }
         } else if(var18 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var12 = class178.field2953.image;
            var13 = 4 * var1 + 24624 + 2048 * (103 - var2);
            if(var17 != 0 && var17 != 2) {
               var12[var13] = var11;
               var12[512 + var13 + 1] = var11;
               var12[2 + var13 + 1024] = var11;
               var12[1536 + var13 + 3] = var11;
            } else {
               var12[var13 + 1536] = var11;
               var12[var13 + 1024 + 1] = var11;
               var12[512 + var13 + 2] = var11;
               var12[var13 + 3] = var11;
            }
         }
      }

      var5 = class128.region.method2052(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var7 = class9.getObjectDefinition(var6);
         if(var7.field956 != -1) {
            ModIcon var8 = class152.field2279[var7.field956];
            if(null != var8) {
               var9 = (var7.field959 * 4 - var8.originalWidth) / 2;
               int var10 = (var7.field960 * 4 - var8.height) / 2;
               var8.method1905(var9 + 48 + 4 * var1, (104 - var2 - var7.field960) * 4 + 48 + var10);
            }
         }
      }

   }
}
