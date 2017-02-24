import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class145 {
   @ObfuscatedName("d")
   byte[] field2009;
   @ObfuscatedName("h")
   int[] field2011;
   @ObfuscatedName("bm")
   static class184 field2013;
   @ObfuscatedName("q")
   int[] field2015;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BII[BIB)I",
      garbageValue = "33"
   )
   public int method2751(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field2015[var8];
         byte var10 = this.field2009[var8];
         if(var10 == 0) {
            throw new RuntimeException("");
         }

         int var11 = var7 >> 3;
         int var12 = var7 & 7;
         var6 &= -var12 >> 31;
         int var13 = (var10 + var12 - 1 >> 3) + var11;
         var12 += 24;
         var4[var11] = (byte)(var6 |= var9 >>> var12);
         if(var11 < var13) {
            ++var11;
            var12 -= 8;
            var4[var11] = (byte)(var6 = var9 >>> var12);
            if(var11 < var13) {
               ++var11;
               var12 -= 8;
               var4[var11] = (byte)(var6 = var9 >>> var12);
               if(var11 < var13) {
                  ++var11;
                  var12 -= 8;
                  var4[var11] = (byte)(var6 = var9 >>> var12);
                  if(var11 < var13) {
                     ++var11;
                     var12 -= 8;
                     var4[var11] = (byte)(var6 = var9 << -var12);
                  }
               }
            }
         }

         var7 += var10;
      }

      return (7 + var7 >> 3) - var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI[BIII)I",
      garbageValue = "1436061890"
   )
   public int method2752(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field2011[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field2011[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.field2011[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2011[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field2011[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2011[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.field2011[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2011[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.field2011[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2011[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field2011[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2011[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.field2011[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2011[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.field2011[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2011[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            ++var7;
         }

         return var7 + 1 - var2;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass182;II)LModIcon;",
      garbageValue = "582598760"
   )
   public static ModIcon method2754(class182 var0, int var1) {
      byte[] var3 = var0.method3308(var1);
      boolean var2;
      if(null == var3) {
         var2 = false;
      } else {
         class210.method3984(var3);
         var2 = true;
      }

      return !var2?null:class165.method3168();
   }

   public class145(byte[] var1) {
      int var2 = var1.length;
      this.field2015 = new int[var2];
      this.field2009 = var1;
      int[] var3 = new int[33];
      this.field2011 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field2015[var5] = var8;
            int var9;
            int var10;
            int var11;
            int var12;
            if((var8 & var7) != 0) {
               var9 = var3[var6 - 1];
            } else {
               var9 = var8 | var7;

               for(var10 = var6 - 1; var10 >= 1; --var10) {
                  var11 = var3[var10];
                  if(var11 != var8) {
                     break;
                  }

                  var12 = 1 << 32 - var10;
                  if((var11 & var12) != 0) {
                     var3[var10] = var3[var10 - 1];
                     break;
                  }

                  var3[var10] = var11 | var12;
               }
            }

            var3[var6] = var9;

            for(var10 = 1 + var6; var10 <= 32; ++var10) {
               if(var8 == var3[var10]) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if((var8 & var12) != 0) {
                  if(this.field2011[var10] == 0) {
                     this.field2011[var10] = var4;
                  }

                  var10 = this.field2011[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field2011.length) {
                  int[] var13 = new int[2 * this.field2011.length];

                  for(int var14 = 0; var14 < this.field2011.length; ++var14) {
                     var13[var14] = this.field2011[var14];
                  }

                  this.field2011 = var13;
               }

               var12 >>>= 1;
            }

            this.field2011[var10] = ~var5;
            if(var10 >= var4) {
               var4 = var10 + 1;
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "5"
   )
   public static int method2759(CharSequence var0) {
      return class13.method169(var0, 10, true);
   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "49"
   )
   static final void method2760(int var0) {
      Client.method601();
      class140.method2665();
      int var1 = class182.method3356(var0).field2780;
      if(var1 != 0) {
         int var2 = class165.widgetSettings[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               class84.method1691(0.9D);
               ((TextureProvider)class84.field1465).method1487(0.9D);
            }

            if(var2 == 2) {
               class84.method1691(0.8D);
               ((TextureProvider)class84.field1465).method1487(0.8D);
            }

            if(var2 == 3) {
               class84.method1691(0.7D);
               ((TextureProvider)class84.field1465).method1487(0.7D);
            }

            if(var2 == 4) {
               class84.method1691(0.6D);
               ((TextureProvider)class84.field1465).method1487(0.6D);
            }

            class48.method971();
         }

         if(var1 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(Client.field542 != var3) {
               if(Client.field542 == 0 && Client.field421 != -1) {
                  class72.method1464(class11.field127, Client.field421, 0, var3, false);
                  Client.field545 = false;
               } else if(var3 == 0) {
                  class138.field1916.method2620();
                  class138.field1919 = 1;
                  class167.field2182 = null;
                  Client.field545 = false;
               } else if(class138.field1919 != 0) {
                  class1.field16 = var3;
               } else {
                  class138.field1916.method2547(var3);
               }

               Client.field542 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               Client.field479 = 127;
            }

            if(var2 == 1) {
               Client.field479 = 96;
            }

            if(var2 == 2) {
               Client.field479 = 64;
            }

            if(var2 == 3) {
               Client.field479 = 32;
            }

            if(var2 == 4) {
               Client.field479 = 0;
            }
         }

         if(var1 == 5) {
            Client.field442 = var2;
         }

         if(var1 == 6) {
            Client.field338 = var2;
         }

         if(var1 == 9) {
            Client.field468 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               Client.field546 = 127;
            }

            if(var2 == 1) {
               Client.field546 = 96;
            }

            if(var2 == 2) {
               Client.field546 = 64;
            }

            if(var2 == 3) {
               Client.field546 = 32;
            }

            if(var2 == 4) {
               Client.field546 = 0;
            }
         }

         if(var1 == 17) {
            Client.field514 = var2 & '\uffff';
         }

         class40[] var4;
         if(var1 == 18) {
            var4 = new class40[]{class40.field836, class40.field830, class40.field831, class40.field829};
            Client.field331 = (class40)class119.method2341(var4, var2);
            if(null == Client.field331) {
               Client.field331 = class40.field831;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               Client.field434 = -1;
            } else {
               Client.field434 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            var4 = new class40[]{class40.field836, class40.field830, class40.field831, class40.field829};
            Client.field332 = (class40)class119.method2341(var4, var2);
            if(null == Client.field332) {
               Client.field332 = class40.field831;
            }
         }

      }
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "622829072"
   )
   static final void method2761(int var0, int var1) {
      if(var0 != class149.field2035 || var1 != MessageNode.field239) {
         class149.field2035 = var0;
         MessageNode.field239 = var1;
         class8.setGameState(25);
         Ignore.method203("Loading - please wait.", true);
         int var2 = class5.baseX;
         int var3 = class24.baseY;
         class5.baseX = (var0 - 6) * 8;
         class24.baseY = (var1 - 6) * 8;
         int var4 = class5.baseX - var2;
         int var5 = class24.baseY - var3;
         var2 = class5.baseX;
         var3 = class24.baseY;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            NPC var7 = Client.cachedNPCs[var6];
            if(var7 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.pathX[var8] -= var4;
                  var7.pathY[var8] -= var5;
               }

               var7.x -= 128 * var4;
               var7.y -= 128 * var5;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            Player var20 = Client.cachedPlayers[var6];
            if(null != var20) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var20.pathX[var8] -= var4;
                  var20.pathY[var8] -= var5;
               }

               var20.x -= var4 * 128;
               var20.y -= 128 * var5;
            }
         }

         byte var19 = 0;
         byte var18 = 104;
         byte var21 = 1;
         if(var4 < 0) {
            var19 = 103;
            var18 = -1;
            var21 = -1;
         }

         byte var9 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var9 = 103;
            var10 = -1;
            var11 = -1;
         }

         int var13;
         for(int var12 = var19; var12 != var18; var12 += var21) {
            for(var13 = var9; var10 != var13; var13 += var11) {
               int var14 = var4 + var12;
               int var15 = var13 + var5;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     Client.groundItemDeque[var16][var12][var13] = Client.groundItemDeque[var16][var14][var15];
                  } else {
                     Client.groundItemDeque[var16][var12][var13] = null;
                  }
               }
            }
         }

         for(class25 var17 = (class25)Client.field436.method2458(); var17 != null; var17 = (class25)Client.field436.method2472()) {
            var17.field598 -= var4;
            var17.field595 -= var5;
            if(var17.field598 < 0 || var17.field595 < 0 || var17.field598 >= 104 || var17.field595 >= 104) {
               var17.unlink();
            }
         }

         if(Client.flagX != 0) {
            Client.flagX -= var4;
            Client.flagY -= var5;
         }

         Client.field547 = 0;
         Client.field553 = false;
         Client.field534 = -1;
         Client.field418.method2452();
         Client.projectiles.method2452();

         for(var13 = 0; var13 < 4; ++var13) {
            Client.collisionMaps[var13].method2306();
         }

      }
   }
}
