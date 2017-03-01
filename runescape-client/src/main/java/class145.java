import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class145 {
   @ObfuscatedName("dw")
   static byte[][] field2009;
   @ObfuscatedName("x")
   int[] field2010;
   @ObfuscatedName("g")
   int[] field2011;
   @ObfuscatedName("n")
   byte[] field2012;
   @ObfuscatedName("y")
   public static int[] field2013;

   public class145(byte[] var1) {
      int var2 = var1.length;
      this.field2010 = new int[var2];
      this.field2012 = var1;
      int[] var3 = new int[33];
      this.field2011 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field2010[var5] = var8;
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

            for(var10 = var6 + 1; var10 <= 32; ++var10) {
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
                  int[] var13 = new int[this.field2011.length * 2];

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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BII[BII)I",
      garbageValue = "-1446730140"
   )
   public int method2799(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field2010[var8];
         byte var10 = this.field2012[var8];
         if(var10 == 0) {
            throw new RuntimeException("");
         }

         int var11 = var7 >> 3;
         int var12 = var7 & 7;
         var6 &= -var12 >> 31;
         int var13 = (var12 + var10 - 1 >> 3) + var11;
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

      return (var7 + 7 >> 3) - var5;
   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "1304027141"
   )
   static final String[] method2800(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2048509900"
   )
   static final void method2807() {
      for(int var0 = 0; var0 < Client.field532; ++var0) {
         --Client.field535[var0];
         if(Client.field535[var0] >= -10) {
            class53 var9 = Client.field537[var0];
            if(var9 == null) {
               Object var10000 = null;
               var9 = class53.method1064(class150.field2041, Client.field533[var0], 0);
               if(null == var9) {
                  continue;
               }

               Client.field535[var0] += var9.method1059();
               Client.field537[var0] = var9;
            }

            if(Client.field535[var0] < 0) {
               int var2;
               if(Client.field536[var0] != 0) {
                  int var3 = (Client.field536[var0] & 255) * 128;
                  int var4 = Client.field536[var0] >> 16 & 255;
                  int var5 = var4 * 128 + 64 - WidgetNode.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.field536[var0] >> 8 & 255;
                  int var7 = 128 * var6 + 64 - WidgetNode.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var7 + var5 - 128;
                  if(var8 > var3) {
                     Client.field535[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * Client.field397 / var3;
               } else {
                  var2 = Client.field530;
               }

               if(var2 > 0) {
                  class55 var10 = var9.method1058().method1097(DecorativeObject.field1602);
                  class66 var11 = class66.method1256(var10, 100, var2);
                  var11.method1259(Client.field534[var0] - 1);
                  Client.field572.method1024(var11);
               }

               Client.field535[var0] = -100;
            }
         } else {
            --Client.field532;

            for(int var1 = var0; var1 < Client.field532; ++var1) {
               Client.field533[var1] = Client.field533[1 + var1];
               Client.field537[var1] = Client.field537[var1 + 1];
               Client.field534[var1] = Client.field534[var1 + 1];
               Client.field535[var1] = Client.field535[1 + var1];
               Client.field536[var1] = Client.field536[1 + var1];
            }

            --var0;
         }
      }

      if(Client.field439) {
         boolean var12;
         if(class138.field1921 != 0) {
            var12 = true;
         } else {
            var12 = class138.field1919.method2582();
         }

         if(!var12) {
            if(Client.field544 != 0 && Client.field528 != -1) {
               class44.method892(Client.field306, Client.field528, 0, Client.field544, false);
            }

            Client.field439 = false;
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BI[BIII)I",
      garbageValue = "-687747071"
   )
   public int method2808(byte[] var1, int var2, byte[] var3, int var4, int var5) {
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

         return 1 + var7 - var2;
      }
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static final void method2809() {
      for(class25 var0 = (class25)Client.field392.method2503(); var0 != null; var0 = (class25)Client.field392.method2492()) {
         if(var0.field575 == -1) {
            var0.field586 = 0;
            XClanMember.method260(var0);
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-41"
   )
   static final void method2810(int var0, int var1, int var2, int var3) {
      Client.field484 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class45.field916;
      int[] var7 = class45.field913;

      int var8;
      for(var8 = 0; var8 < var6 + Client.field328; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = Client.cachedPlayers[var7[var8]];
            if(Client.field418 == var7[var8]) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = Client.cachedNPCs[Client.field285[var8 - var6]];
         }

         class171.method3330((Actor)var9, var8, var0, var1, var2, var3);
      }

      if(var4) {
         class171.method3330(Client.cachedPlayers[Client.field418], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < Client.field484; ++var8) {
         int var19 = Client.field384[var8];
         int var10 = Client.field385[var8];
         int var11 = Client.field434[var8];
         int var12 = Client.field386[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var14 = 0; var14 < var8; ++var14) {
               if(2 + var10 > Client.field385[var14] - Client.field386[var14] && var10 - var12 < 2 + Client.field385[var14] && var19 - var11 < Client.field434[var14] + Client.field384[var14] && var11 + var19 > Client.field384[var14] - Client.field434[var14] && Client.field385[var14] - Client.field386[var14] < var10) {
                  var10 = Client.field385[var14] - Client.field386[var14];
                  var13 = true;
               }
            }
         }

         Client.field447 = Client.field384[var8];
         Client.field469 = Client.field385[var8] = var10;
         String var18 = Client.field391[var8];
         if(Client.field451 == 0) {
            int var15 = 16776960;
            if(Client.field388[var8] < 6) {
               var15 = Client.field506[Client.field388[var8]];
            }

            if(Client.field388[var8] == 6) {
               var15 = Client.field502 % 20 < 10?16711680:16776960;
            }

            if(Client.field388[var8] == 7) {
               var15 = Client.field502 % 20 < 10?255:'\uffff';
            }

            if(Client.field388[var8] == 8) {
               var15 = Client.field502 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(Client.field388[var8] == 9) {
               var16 = 150 - Client.field390[var8];
               if(var16 < 50) {
                  var15 = 16711680 + 1280 * var16;
               } else if(var16 < 100) {
                  var15 = 16776960 - 327680 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = '\uff00' + (var16 - 100) * 5;
               }
            }

            if(Client.field388[var8] == 10) {
               var16 = 150 - Client.field390[var8];
               if(var16 < 50) {
                  var15 = 16711680 + var16 * 5;
               } else if(var16 < 100) {
                  var15 = 16711935 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = 327680 * (var16 - 100) + 255 - (var16 - 100) * 5;
               }
            }

            if(Client.field388[var8] == 11) {
               var16 = 150 - Client.field390[var8];
               if(var16 < 50) {
                  var15 = 16777215 - var16 * 327685;
               } else if(var16 < 100) {
                  var15 = '\uff00' + (var16 - 50) * 327685;
               } else if(var16 < 150) {
                  var15 = 16777215 - 327680 * (var16 - 100);
               }
            }

            if(Client.field500[var8] == 0) {
               class217.field3188.method3912(var18, var0 + Client.field447, var1 + Client.field469, var15, 0);
            }

            if(Client.field500[var8] == 1) {
               class217.field3188.method3951(var18, Client.field447 + var0, Client.field469 + var1, var15, 0, Client.field502);
            }

            if(Client.field500[var8] == 2) {
               class217.field3188.method3915(var18, var0 + Client.field447, var1 + Client.field469, var15, 0, Client.field502);
            }

            if(Client.field500[var8] == 3) {
               class217.field3188.method3916(var18, Client.field447 + var0, Client.field469 + var1, var15, 0, Client.field502, 150 - Client.field390[var8]);
            }

            if(Client.field500[var8] == 4) {
               var16 = (150 - Client.field390[var8]) * (class217.field3188.method3904(var18) + 100) / 150;
               Rasterizer2D.method4014(Client.field447 + var0 - 50, var1, 50 + var0 + Client.field447, var3 + var1);
               class217.field3188.method3973(var18, 50 + Client.field447 + var0 - var16, var1 + Client.field469, var15, 0);
               Rasterizer2D.method4091(var0, var1, var0 + var2, var1 + var3);
            }

            if(Client.field500[var8] == 5) {
               var16 = 150 - Client.field390[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               Rasterizer2D.method4014(var0, Client.field469 + var1 - class217.field3188.field3112 - 1, var2 + var0, 5 + Client.field469 + var1);
               class217.field3188.method3912(var18, var0 + Client.field447, var17 + Client.field469 + var1, var15, 0);
               Rasterizer2D.method4091(var0, var1, var0 + var2, var1 + var3);
            }
         } else {
            class217.field3188.method3912(var18, Client.field447 + var0, var1 + Client.field469, 16776960, 0);
         }
      }

   }
}
