import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("g")
   boolean[] field287;
   @ObfuscatedName("e")
   boolean[] field289;
   @ObfuscatedName("d")
   boolean field290 = false;
   @ObfuscatedName("n")
   int[] field291;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 7153234624595372431L
   )
   long field293;
   @ObfuscatedName("u")
   @Export("messages")
   String[] messages;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-626077031"
   )
   String method204(int var1) {
      return this.messages[var1];
   }

   ChatMessages() {
      this.field291 = new int[XItemContainer.field233.method3299(19)];
      this.messages = new String[XItemContainer.field233.method3299(15)];
      this.field289 = new boolean[this.field291.length];

      int var1;
      byte[] var4;
      for(var1 = 0; var1 < this.field291.length; ++var1) {
         class47 var3 = (class47)class47.field1063.get((long)var1);
         class47 var2;
         if(null != var3) {
            var2 = var3;
         } else {
            var4 = class47.field1064.method3292(19, var1);
            var3 = new class47();
            if(var4 != null) {
               var3.method981(new Buffer(var4));
            }

            class47.field1063.put(var3, (long)var1);
            var2 = var3;
         }

         this.field289[var1] = var2.field1065;
      }

      this.field287 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class53 var6 = (class53)class53.field1146.get((long)var1);
         class53 var5;
         if(null != var6) {
            var5 = var6;
         } else {
            var4 = class53.field1147.method3292(15, var1);
            var6 = new class53();
            if(var4 != null) {
               var6.method1090(new Buffer(var4));
            }

            class53.field1146.put(var6, (long)var1);
            var5 = var6;
         }

         this.field287[var1] = var5.field1151;
      }

      for(var1 = 0; var1 < this.field291.length; ++var1) {
         this.field291[var1] = -1;
      }

      this.method211();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "1558756673"
   )
   void method206(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field287[var1]) {
         this.field290 = true;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "452622110"
   )
   void method208() {
      int var1;
      for(var1 = 0; var1 < this.field291.length; ++var1) {
         if(!this.field289[var1]) {
            this.field291[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field287[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1627617619"
   )
   void method210() {
      FileOnDisk var1 = this.method230(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field291.length; ++var4) {
            if(this.field289[var4] && this.field291[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field287[var5] && null != this.messages[var5]) {
               var2 += 2 + class21.method547(this.messages[var5]);
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.method2529(1);
         var9.method2701(var3);

         int var6;
         for(var6 = 0; var6 < this.field291.length; ++var6) {
            if(this.field289[var6] && this.field291[var6] != -1) {
               var9.method2701(var6);
               var9.method2709(this.field291[var6]);
            }
         }

         var9.method2701(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field287[var6] && this.messages[var6] != null) {
               var9.method2701(var6);
               var9.method2535(this.messages[var6]);
            }
         }

         var1.method4153(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method4156();
         } catch (Exception var16) {
            ;
         }

      }

      this.field290 = false;
      this.field293 = class34.method738();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2113369988"
   )
   void method211() {
      FileOnDisk var1 = this.method230(false);

      label190: {
         try {
            byte[] var2 = new byte[(int)var1.method4160()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method4157(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            Buffer var13 = new Buffer(var2);
            if(var13.payload.length - var13.offset < 1) {
               return;
            }

            int var14 = var13.method2544();
            if(var14 >= 0 && var14 <= 1) {
               int var15 = var13.method2546();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var15; ++var7) {
                  var8 = var13.method2546();
                  var9 = var13.method2549();
                  if(this.field289[var8]) {
                     this.field291[var8] = var9;
                  }
               }

               var7 = var13.method2546();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label190;
                  }

                  var9 = var13.method2546();
                  String var10 = var13.method2552();
                  if(this.field287[var9]) {
                     this.messages[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label190;
         } finally {
            try {
               var1.method4156();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.field290 = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "1935665158"
   )
   public static String method212(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;
      int var5 = var1;

      int var8;
      for(int var6 = var1 + var2; var5 < var6; var3[var4++] = (char)var8) {
         int var7 = var0[var5++] & 255;
         if(var7 < 128) {
            if(var7 == 0) {
               var8 = '�';
            } else {
               var8 = var7;
            }
         } else if(var7 < 192) {
            var8 = '�';
         } else if(var7 < 224) {
            if(var5 < var6 && (var0[var5] & 192) == 128) {
               var8 = (var7 & 31) << 6 | var0[var5++] & 63;
               if(var8 < 128) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 240) {
            if(1 + var5 < var6 && (var0[var5] & 192) == 128 && (var0[1 + var5] & 192) == 128) {
               var8 = (var7 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 < 2048) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 248) {
            if(2 + var5 < var6 && (var0[var5] & 192) == 128 && (var0[1 + var5] & 192) == 128 && (var0[2 + var5] & 192) == 128) {
               var8 = (var7 & 7) << 18 | (var0[var5++] & 63) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 >= 65536 && var8 <= 1114111) {
                  var8 = '�';
               } else {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else {
            var8 = '�';
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1913061741"
   )
   void method219(int var1, int var2) {
      this.field291[var1] = var2;
      if(this.field289[var1]) {
         this.field290 = true;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1228296548"
   )
   int method225(int var1) {
      return this.field291[var1];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1447397224"
   )
   void method226() {
      if(this.field290 && this.field293 < class34.method738() - 60000L) {
         this.method210();
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ZB)LFileOnDisk;",
      garbageValue = "63"
   )
   FileOnDisk method230(boolean var1) {
      return GameEngine.method3132("2", class114.field2004.field2341, var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass125;II)Z",
      garbageValue = "1707941390"
   )
   static boolean method233(class125 var0, int var1) {
      int var2 = var0.method2787(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method2787(1) != 0) {
            method233(var0, var1);
         }

         var3 = var0.method2787(6);
         var4 = var0.method2787(6);
         boolean var12 = var0.method2787(1) == 1;
         if(var12) {
            class34.field787[++class34.field775 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field54 = var1;
            if(class34.field784[var1] != null) {
               var6.method15(class34.field784[var1]);
            }

            var6.field886 = class34.field780[var1];
            var6.interacting = class34.field788[var1];
            var7 = class34.field783[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field850[0] = class34.field777[var1];
            var6.field53 = (byte)var8;
            var6.method19(var3 + (var9 << 6) - class193.baseX, var4 + (var10 << 6) - DecorativeObject.baseY);
            var6.field55 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method2787(2);
         var4 = class34.field783[var1];
         class34.field783[var1] = (((var4 >> 28) + var3 & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.method2787(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class34.field783[var1];
            var7 = var4 + (var11 >> 28) & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class34.field783[var1] = (var7 << 28) + (var8 << 14) + var9;
            return false;
         } else {
            var3 = var0.method2787(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class34.field783[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = (var7 >> 14) + var5 & 255;
            var10 = var7 + var11 & 255;
            class34.field783[var1] = (var8 << 28) + (var9 << 14) + var10;
            return false;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LRegion;[LCollisionData;I)V",
      garbageValue = "1688618303"
   )
   static final void method234(Region var0, CollisionData[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if((class5.tileSettings[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if((class5.tileSettings[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method2422(var3, var4);
                  }
               }
            }
         }
      }

      class5.field106 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field106 < -8) {
         class5.field106 = -8;
      }

      if(class5.field106 > 8) {
         class5.field106 = 8;
      }

      class5.field87 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field87 < -16) {
         class5.field87 = -16;
      }

      if(class5.field87 > 16) {
         class5.field87 = 16;
      }

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      int var42;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var47 = class35.field801[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = 768 * var9 >> 8;

         int var20;
         int var43;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class5.tileHeights[var2][var12 + 1][var11] - class5.tileHeights[var2][var12 - 1][var11];
               var14 = class5.tileHeights[var2][var12][1 + var11] - class5.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(65536 + var13 * var13 + var14 * var14));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var42 = (var14 << 8) / var15;
               var43 = (-50 * var42 + var16 * -50 + var17 * -10) / var10 + 96;
               var20 = (var47[var12][var11] >> 1) + (var47[var12][var11 - 1] >> 2) + (var47[var12 + 1][var11] >> 3) + (var47[var12 - 1][var11] >> 2) + (var47[var12][1 + var11] >> 3);
               class5.field91[var12][var11] = var43 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class5.field92[var11] = 0;
            class172.field2751[var11] = 0;
            class5.field93[var11] = 0;
            class5.field94[var11] = 0;
            class0.field1[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class5.field102[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     var16 = var14 - 1;
                     class43 var44 = (class43)class43.field996.get((long)var16);
                     class43 var45;
                     if(var44 != null) {
                        var45 = var44;
                     } else {
                        byte[] var18 = class43.field1000.method3292(1, var16);
                        var44 = new class43();
                        if(var18 != null) {
                           var44.method894(new Buffer(var18), var16);
                        }

                        var44.method883();
                        class43.field996.put(var44, (long)var16);
                        var45 = var44;
                     }

                     class5.field92[var12] += var45.field1005;
                     class172.field2751[var12] += var45.field999;
                     class5.field93[var12] += var45.field998;
                     class5.field94[var12] += var45.field1001;
                     ++class0.field1[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class5.field102[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     var17 = var15 - 1;
                     class43 var50 = (class43)class43.field996.get((long)var17);
                     class43 var46;
                     if(var50 != null) {
                        var46 = var50;
                     } else {
                        byte[] var19 = class43.field1000.method3292(1, var17);
                        var50 = new class43();
                        if(null != var19) {
                           var50.method894(new Buffer(var19), var17);
                        }

                        var50.method883();
                        class43.field996.put(var50, (long)var17);
                        var46 = var50;
                     }

                     class5.field92[var12] -= var46.field1005;
                     class172.field2751[var12] -= var46.field999;
                     class5.field93[var12] -= var46.field998;
                     class5.field94[var12] -= var46.field1001;
                     --class0.field1[var12];
                  }
               }
            }

            if(var11 >= 1 && var11 < 103) {
               var12 = 0;
               var13 = 0;
               var14 = 0;
               var15 = 0;
               var16 = 0;

               for(var17 = -5; var17 < 109; ++var17) {
                  var42 = var17 + 5;
                  if(var42 >= 0 && var42 < 104) {
                     var12 += class5.field92[var42];
                     var13 += class172.field2751[var42];
                     var14 += class5.field93[var42];
                     var15 += class5.field94[var42];
                     var16 += class0.field1[var42];
                  }

                  var43 = var17 - 5;
                  if(var43 >= 0 && var43 < 104) {
                     var12 -= class5.field92[var43];
                     var13 -= class172.field2751[var43];
                     var14 -= class5.field93[var43];
                     var15 -= class5.field94[var43];
                     var16 -= class0.field1[var43];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.field304 || (class5.tileSettings[0][var11][var17] & 2) != 0 || (class5.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class5.field86) {
                        class5.field86 = var2;
                     }

                     var20 = class5.field102[var2][var11][var17] & 255;
                     int var21 = class5.field88[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class5.tileHeights[var2][var11][var17];
                        int var23 = class5.tileHeights[var2][var11 + 1][var17];
                        int var24 = class5.tileHeights[var2][1 + var11][var17 + 1];
                        int var25 = class5.tileHeights[var2][var11][var17 + 1];
                        int var26 = class5.field91[var11][var17];
                        int var27 = class5.field91[var11 + 1][var17];
                        int var28 = class5.field91[var11 + 1][var17 + 1];
                        int var29 = class5.field91[var11][1 + var17];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = 256 * var12 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = class32.method675(var32, var33, var34);
                           var32 = class5.field106 + var32 & 255;
                           var34 += class5.field87;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class32.method675(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var51 = true;
                           if(var20 == 0 && class5.field89[var2][var11][var17] != 0) {
                              var51 = false;
                           }

                           if(var21 > 0 && !class18.method203(var21 - 1).field1068) {
                              var51 = false;
                           }

                           if(var51 && var23 == var22 && var22 == var24 && var22 == var25) {
                              class5.field107[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class94.colorPalette[class51.method1065(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.method1957(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class51.method1065(var30, var26), class51.method1065(var30, var27), class51.method1065(var30, var28), class51.method1065(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = class5.field89[var2][var11][var17] + 1;
                           byte var52 = class5.field90[var2][var11][var17];
                           class48 var35 = class18.method203(var21 - 1);
                           int var36 = var35.field1069;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var36 >= 0) {
                              var38 = class94.field1638.vmethod2214(var36);
                              var37 = -1;
                           } else if(var35.field1072 == 16711935) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = class32.method675(var35.field1074, var35.field1073, var35.field1075);
                              var39 = class5.field106 + var35.field1074 & 255;
                              var40 = var35.field1075 + class5.field87;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = class32.method675(var39, var35.field1073, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = class94.colorPalette[class38.method780(var38, 96)];
                           }

                           if(var35.field1070 != -1) {
                              var40 = class5.field106 + var35.field1066 & 255;
                              int var41 = class5.field87 + var35.field1077;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = class32.method675(var40, var35.field1076, var41);
                              var39 = class94.colorPalette[class38.method780(var38, 96)];
                           }

                           var0.method1957(var2, var11, var17, var33, var52, var36, var22, var23, var24, var25, class51.method1065(var30, var26), class51.method1065(var30, var27), class51.method1065(var30, var28), class51.method1065(var30, var29), class38.method780(var37, var26), class38.method780(var37, var27), class38.method780(var37, var28), class38.method780(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               if((class5.tileSettings[var2][var12][var11] & 8) != 0) {
                  var17 = 0;
               } else if(var2 > 0 && (class5.tileSettings[1][var12][var11] & 2) != 0) {
                  var17 = var2 - 1;
               } else {
                  var17 = var2;
               }

               var0.method2009(var2, var12, var11, var17);
            }
         }

         class5.field102[var2] = null;
         class5.field88[var2] = null;
         class5.field89[var2] = null;
         class5.field90[var2] = null;
         class35.field801[var2] = null;
      }

      var0.method1983(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class5.tileSettings[1][var2][var3] & 2) == 2) {
               var0.method1954(var2, var3);
            }
         }
      }

      var2 = 1;
      var3 = 2;
      var4 = 4;

      for(var5 = 0; var5 < 4; ++var5) {
         if(var5 > 0) {
            var2 <<= 3;
            var3 <<= 3;
            var4 <<= 3;
         }

         for(int var6 = 0; var6 <= var5; ++var6) {
            for(int var7 = 0; var7 <= 104; ++var7) {
               for(int var8 = 0; var8 <= 104; ++var8) {
                  short var49;
                  if((class5.field107[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class5.field107[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class5.field107[var6][var8][1 + var10] & var2) != 0) {
                        ++var10;
                     }

                     label553:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class5.field107[var11 - 1][var8][var13] & var2) == 0) {
                              break label553;
                           }
                        }

                        --var11;
                     }

                     label542:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class5.field107[1 + var12][var8][var13] & var2) == 0) {
                              break label542;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var12 + 1 - var11) * (1 + (var10 - var9));
                     if(var13 >= 8) {
                        var49 = 240;
                        var15 = class5.tileHeights[var12][var8][var9] - var49;
                        var16 = class5.tileHeights[var11][var8][var9];
                        Region.method1955(var5, 1, 128 * var8, var8 * 128, var9 * 128, 128 * var10 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var42 = var9; var42 <= var10; ++var42) {
                              class5.field107[var17][var8][var42] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class5.field107[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class5.field107[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class5.field107[var6][var10 + 1][var7] & var3) != 0) {
                        ++var10;
                     }

                     label606:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class5.field107[var11 - 1][var13][var7] & var3) == 0) {
                              break label606;
                           }
                        }

                        --var11;
                     }

                     label595:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class5.field107[var12 + 1][var13][var7] & var3) == 0) {
                              break label595;
                           }
                        }

                        ++var12;
                     }

                     var13 = (1 + var12 - var11) * (1 + (var10 - var9));
                     if(var13 >= 8) {
                        var49 = 240;
                        var15 = class5.tileHeights[var12][var9][var7] - var49;
                        var16 = class5.tileHeights[var11][var9][var7];
                        Region.method1955(var5, 2, var9 * 128, 128 + 128 * var10, var7 * 128, 128 * var7, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var42 = var9; var42 <= var10; ++var42) {
                              class5.field107[var17][var42][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class5.field107[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class5.field107[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class5.field107[var6][var8][1 + var12] & var4) != 0) {
                        ++var12;
                     }

                     label659:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class5.field107[var6][var9 - 1][var13] & var4) == 0) {
                              break label659;
                           }
                        }

                        --var9;
                     }

                     label648:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class5.field107[var6][var10 + 1][var13] & var4) == 0) {
                              break label648;
                           }
                        }

                        ++var10;
                     }

                     if((var10 - var9 + 1) * (var12 - var11 + 1) >= 4) {
                        var13 = class5.tileHeights[var6][var9][var11];
                        Region.method1955(var5, 4, 128 * var9, 128 + var10 * 128, 128 * var11, 128 + var12 * 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class5.field107[var6][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-677411683"
   )
   static final void method235(int var0, int var1) {
      int var2 = MessageNode.field811.method4062("Choose Option");

      int var3;
      for(var3 = 0; var3 < Client.menuOptionCount; ++var3) {
         class227 var4 = MessageNode.field811;
         String var5;
         if(Client.menuTargets[var3].length() > 0) {
            var5 = Client.menuOptions[var3] + " " + Client.menuTargets[var3];
         } else {
            var5 = Client.menuOptions[var3];
         }

         int var6 = var4.method4062(var5);
         if(var6 > var2) {
            var2 = var6;
         }
      }

      var2 += 8;
      var3 = 22 + Client.menuOptionCount * 15;
      int var7 = var0 - var2 / 2;
      if(var7 + var2 > class62.field1267) {
         var7 = class62.field1267 - var2;
      }

      if(var7 < 0) {
         var7 = 0;
      }

      int var8 = var1;
      if(var3 + var1 > class77.field1428) {
         var8 = class77.field1428 - var3;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      Client.isMenuOpen = true;
      class146.menuX = var7;
      class130.menuY = var8;
      ChatLineBuffer.menuWidth = var2;
      class194.menuHeight = Client.menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1850547502"
   )
   boolean method236() {
      return this.field290;
   }
}
