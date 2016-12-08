import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
final class class7 implements Comparator {
   @ObfuscatedName("gx")
   static Widget field51;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = 512098899
   )
   static int field54;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZS)[B",
      garbageValue = "10671"
   )
   public static byte[] method73(Object var0, boolean var1) {
      if(null == var0) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var6 = (byte[])((byte[])var0);
         if(var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if(var0 instanceof class156) {
         class156 var2 = (class156)var0;
         return var2.vmethod2937();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "1019266364"
   )
   int method74(class2 var1, class2 var2) {
      return var1.field16 < var2.field16?-1:(var1.field16 == var2.field16?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/CharSequence;III)Ljava/lang/String;",
      garbageValue = "-1239869431"
   )
   public static String method83(CharSequence[] var0, int var1, int var2) {
      if(var2 == 0) {
         return "";
      } else if(var2 == 1) {
         CharSequence var9 = var0[var1];
         return null == var9?"null":var9.toString();
      } else {
         int var3 = var1 + var2;
         int var4 = 0;

         for(int var8 = var1; var8 < var3; ++var8) {
            CharSequence var10 = var0[var8];
            if(null == var10) {
               var4 += 4;
            } else {
               var4 += var10.length();
            }
         }

         StringBuilder var5 = new StringBuilder(var4);

         for(int var6 = var1; var6 < var3; ++var6) {
            CharSequence var7 = var0[var6];
            if(var7 == null) {
               var5.append("null");
            } else {
               var5.append(var7);
            }
         }

         return var5.toString();
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-70"
   )
   static final void method85(int var0, int var1, int var2, int var3) {
      Client.field292 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class45.field900;
      int[] var7 = class45.field902;

      int var8;
      for(var8 = 0; var8 < Client.field492 + var6; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = Client.cachedPlayers[var7[var8]];
            if(var7[var8] == Client.field416) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = Client.cachedNPCs[Client.field327[var8 - var6]];
         }

         Renderable.method1837((Actor)var9, var8, var0, var1, var2, var3);
      }

      if(var4) {
         Renderable.method1837(Client.cachedPlayers[Client.field416], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < Client.field292; ++var8) {
         int var19 = Client.field286[var8];
         int var10 = Client.field304[var8];
         int var11 = Client.field530[var8];
         int var12 = Client.field458[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var14 = 0; var14 < var8; ++var14) {
               if(2 + var10 > Client.field304[var14] - Client.field458[var14] && var10 - var12 < Client.field304[var14] + 2 && var19 - var11 < Client.field286[var14] + Client.field530[var14] && var11 + var19 > Client.field286[var14] - Client.field530[var14] && Client.field304[var14] - Client.field458[var14] < var10) {
                  var10 = Client.field304[var14] - Client.field458[var14];
                  var13 = true;
               }
            }
         }

         Client.field392 = Client.field286[var8];
         Client.field393 = Client.field304[var8] = var10;
         String var18 = Client.field389[var8];
         if(Client.field446 == 0) {
            int var15 = 16776960;
            if(Client.field386[var8] < 6) {
               var15 = Client.field380[Client.field386[var8]];
            }

            if(Client.field386[var8] == 6) {
               var15 = Client.field391 % 20 < 10?16711680:16776960;
            }

            if(Client.field386[var8] == 7) {
               var15 = Client.field391 % 20 < 10?255:'\uffff';
            }

            if(Client.field386[var8] == 8) {
               var15 = Client.field391 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(Client.field386[var8] == 9) {
               var16 = 150 - Client.field414[var8];
               if(var16 < 50) {
                  var15 = 16711680 + var16 * 1280;
               } else if(var16 < 100) {
                  var15 = 16776960 - 327680 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = '\uff00' + (var16 - 100) * 5;
               }
            }

            if(Client.field386[var8] == 10) {
               var16 = 150 - Client.field414[var8];
               if(var16 < 50) {
                  var15 = 16711680 + 5 * var16;
               } else if(var16 < 100) {
                  var15 = 16711935 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = 327680 * (var16 - 100) + 255 - 5 * (var16 - 100);
               }
            }

            if(Client.field386[var8] == 11) {
               var16 = 150 - Client.field414[var8];
               if(var16 < 50) {
                  var15 = 16777215 - 327685 * var16;
               } else if(var16 < 100) {
                  var15 = '\uff00' + 327685 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = 16777215 - 327680 * (var16 - 100);
               }
            }

            if(Client.field355[var8] == 0) {
               Ignore.field218.method3787(var18, var0 + Client.field392, var1 + Client.field393, var15, 0);
            }

            if(Client.field355[var8] == 1) {
               Ignore.field218.method3789(var18, var0 + Client.field392, var1 + Client.field393, var15, 0, Client.field391);
            }

            if(Client.field355[var8] == 2) {
               Ignore.field218.method3840(var18, var0 + Client.field392, var1 + Client.field393, var15, 0, Client.field391);
            }

            if(Client.field355[var8] == 3) {
               Ignore.field218.method3790(var18, Client.field392 + var0, var1 + Client.field393, var15, 0, Client.field391, 150 - Client.field414[var8]);
            }

            if(Client.field355[var8] == 4) {
               var16 = (150 - Client.field414[var8]) * (Ignore.field218.method3774(var18) + 100) / 150;
               class219.method3894(var0 + Client.field392 - 50, var1, Client.field392 + var0 + 50, var1 + var3);
               Ignore.field218.method3784(var18, var0 + Client.field392 + 50 - var16, Client.field393 + var1, var15, 0);
               class219.method3893(var0, var1, var0 + var2, var1 + var3);
            }

            if(Client.field355[var8] == 5) {
               var16 = 150 - Client.field414[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               class219.method3894(var0, var1 + Client.field393 - Ignore.field218.field3102 - 1, var2 + var0, Client.field393 + var1 + 5);
               Ignore.field218.method3787(var18, var0 + Client.field392, var1 + Client.field393 + var17, var15, 0);
               class219.method3893(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            Ignore.field218.method3787(var18, Client.field392 + var0, var1 + Client.field393, 16776960, 0);
         }
      }

   }

   public int compare(Object var1, Object var2) {
      return this.method74((class2)var1, (class2)var2);
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "57"
   )
   static final void method86(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field487; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var2 + var0 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field308[var4] = true;
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([LWorld;II[I[II)V",
      garbageValue = "-1577482002"
   )
   static void method87(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var1 + var2) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var11;
            int var12;
            int var13;
            do {
               --var6;

               for(var13 = 0; var13 < 4; ++var13) {
                  if(var3[var13] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var13] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var13] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var13] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var13] == 3) {
                     var11 = var0[var6].method596()?1:0;
                     var12 = var8.method596()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var13] != 1 || var11 <= var12) && (var4[var13] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var13 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var13 = 0; var13 < 4; ++var13) {
                  if(var3[var13] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var13] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var13] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var13] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var13] == 3) {
                     var11 = var0[var5].method596()?1:0;
                     var12 = var8.method596()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var13] != 1 || var11 >= var12) && (var4[var13] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var13 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var10 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var10;
            }
         }

         method87(var0, var1, var6, var3, var4);
         method87(var0, 1 + var6, var2, var3, var4);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "129661355"
   )
   static final byte[] method88(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.method2731();
      if(var3 >= 0 && (class182.field2720 == 0 || var3 <= class182.field2720)) {
         if(var2 == 0) {
            byte[] var4 = new byte[var3];
            var1.method2796(var4, 0, var3);
            return var4;
         } else {
            int var6 = var1.method2731();
            if(var6 >= 0 && (class182.field2720 == 0 || var6 <= class182.field2720)) {
               byte[] var5 = new byte[var6];
               if(var2 == 1) {
                  class147.method2673(var5, var6, var0, var3, 9);
               } else {
                  class182.field2730.method2668(var1, var5);
               }

               return var5;
            } else {
               throw new RuntimeException();
            }
         }
      } else {
         throw new RuntimeException();
      }
   }
}
