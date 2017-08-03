import java.util.LinkedList;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public abstract class class28 {
   @ObfuscatedName("qz")
   static short[] field392;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1985779991
   )
   int field381;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -557912465
   )
   int field390;
   @ObfuscatedName("v")
   short[][][] field385;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1293938335
   )
   int field382;
   @ObfuscatedName("t")
   short[][][] field386;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[[[[Lar;"
   )
   class31[][][][] field389;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1783504547
   )
   int field383;
   @ObfuscatedName("i")
   byte[][][] field388;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -277219159
   )
   int field384;
   @ObfuscatedName("r")
   byte[][][] field387;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1030363443
   )
   int field380;

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1293762697"
   )
   int method215(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field385[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IILfw;II)V",
      garbageValue = "-317075880"
   )
   void method213(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field386[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field385[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IILfw;II)V",
      garbageValue = "769806990"
   )
   void method233(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field385[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedByte();
            if(var10 != 0) {
               this.field386[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field388[var9][var1][var2] = (byte)(var11 >> 2);
               this.field387[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               class31[] var14 = this.field389[var8][var1][var2] = new class31[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3216();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new class31(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "331532999"
   )
   int method216() {
      return this.field381;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "201437167"
   )
   int method226() {
      return this.field390;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IILfw;I)V",
      garbageValue = "1505859055"
   )
   void method212(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method213(var1, var2, var3, var4);
         } else {
            this.method233(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(Lbg;IIBI)V",
      garbageValue = "-1592842186"
   )
   static final void method224(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.getSize();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var8 = var0.getSize();
            class163 var9 = class261.method4715(var1, var2);
            CollisionData var10 = Client.collisionMaps[var0.field881];
            int[] var11 = Client.field919;
            int[] var12 = Client.field1161;

            int var13;
            int var14;
            for(var13 = 0; var13 < 128; ++var13) {
               for(var14 = 0; var14 < 128; ++var14) {
                  class162.field2272[var13][var14] = 0;
                  class162.field2273[var13][var14] = 99999999;
               }
            }

            int var15;
            int var16;
            byte var18;
            int var19;
            int var20;
            int var22;
            int var24;
            int var25;
            int var26;
            boolean var33;
            int var35;
            int var36;
            int var38;
            if(var8 == 1) {
               var15 = var4;
               var16 = var5;
               byte var17 = 64;
               var18 = 64;
               var19 = var4 - var17;
               var20 = var5 - var18;
               class162.field2272[var17][var18] = 99;
               class162.field2273[var17][var18] = 0;
               byte var21 = 0;
               var22 = 0;
               class162.field2271[var21] = var4;
               var38 = var21 + 1;
               class162.field2282[var21] = var5;
               int[][] var23 = var10.flags;

               boolean var34;
               while(true) {
                  if(var22 == var38) {
                     class162.field2277 = var15;
                     class98.field1497 = var16;
                     var34 = false;
                     break;
                  }

                  var15 = class162.field2271[var22];
                  var16 = class162.field2282[var22];
                  var22 = var22 + 1 & 4095;
                  var35 = var15 - var19;
                  var36 = var16 - var20;
                  var24 = var15 - var10.x;
                  var25 = var16 - var10.y;
                  if(var9.vmethod3102(1, var15, var16, var10)) {
                     class162.field2277 = var15;
                     class98.field1497 = var16;
                     var34 = true;
                     break;
                  }

                  var26 = class162.field2273[var35][var36] + 1;
                  if(var35 > 0 && class162.field2272[var35 - 1][var36] == 0 && (var23[var24 - 1][var25] & 19136776) == 0) {
                     class162.field2271[var38] = var15 - 1;
                     class162.field2282[var38] = var16;
                     var38 = var38 + 1 & 4095;
                     class162.field2272[var35 - 1][var36] = 2;
                     class162.field2273[var35 - 1][var36] = var26;
                  }

                  if(var35 < 127 && class162.field2272[var35 + 1][var36] == 0 && (var23[var24 + 1][var25] & 19136896) == 0) {
                     class162.field2271[var38] = var15 + 1;
                     class162.field2282[var38] = var16;
                     var38 = var38 + 1 & 4095;
                     class162.field2272[var35 + 1][var36] = 8;
                     class162.field2273[var35 + 1][var36] = var26;
                  }

                  if(var36 > 0 && class162.field2272[var35][var36 - 1] == 0 && (var23[var24][var25 - 1] & 19136770) == 0) {
                     class162.field2271[var38] = var15;
                     class162.field2282[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class162.field2272[var35][var36 - 1] = 1;
                     class162.field2273[var35][var36 - 1] = var26;
                  }

                  if(var36 < 127 && class162.field2272[var35][var36 + 1] == 0 && (var23[var24][var25 + 1] & 19136800) == 0) {
                     class162.field2271[var38] = var15;
                     class162.field2282[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class162.field2272[var35][var36 + 1] = 4;
                     class162.field2273[var35][var36 + 1] = var26;
                  }

                  if(var35 > 0 && var36 > 0 && class162.field2272[var35 - 1][var36 - 1] == 0 && (var23[var24 - 1][var25 - 1] & 19136782) == 0 && (var23[var24 - 1][var25] & 19136776) == 0 && (var23[var24][var25 - 1] & 19136770) == 0) {
                     class162.field2271[var38] = var15 - 1;
                     class162.field2282[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class162.field2272[var35 - 1][var36 - 1] = 3;
                     class162.field2273[var35 - 1][var36 - 1] = var26;
                  }

                  if(var35 < 127 && var36 > 0 && class162.field2272[var35 + 1][var36 - 1] == 0 && 0 == (var23[var24 + 1][var25 - 1] & 19136899) && 0 == (var23[var24 + 1][var25] & 19136896) && (var23[var24][var25 - 1] & 19136770) == 0) {
                     class162.field2271[var38] = var15 + 1;
                     class162.field2282[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class162.field2272[var35 + 1][var36 - 1] = 9;
                     class162.field2273[var35 + 1][var36 - 1] = var26;
                  }

                  if(var35 > 0 && var36 < 127 && class162.field2272[var35 - 1][var36 + 1] == 0 && (var23[var24 - 1][var25 + 1] & 19136824) == 0 && (var23[var24 - 1][var25] & 19136776) == 0 && (var23[var24][var25 + 1] & 19136800) == 0) {
                     class162.field2271[var38] = var15 - 1;
                     class162.field2282[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class162.field2272[var35 - 1][var36 + 1] = 6;
                     class162.field2273[var35 - 1][var36 + 1] = var26;
                  }

                  if(var35 < 127 && var36 < 127 && class162.field2272[var35 + 1][var36 + 1] == 0 && (var23[var24 + 1][var25 + 1] & 19136992) == 0 && (var23[var24 + 1][var25] & 19136896) == 0 && (var23[var24][var25 + 1] & 19136800) == 0) {
                     class162.field2271[var38] = var15 + 1;
                     class162.field2282[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class162.field2272[var35 + 1][var36 + 1] = 12;
                     class162.field2273[var35 + 1][var36 + 1] = var26;
                  }
               }

               var33 = var34;
            } else if(var8 == 2) {
               var33 = class164.method3118(var4, var5, var9, var10);
            } else {
               var33 = GameObject.method2922(var4, var5, var8, var9, var10);
            }

            int var7;
            label344: {
               var14 = var4 - 64;
               var15 = var5 - 64;
               var16 = class162.field2277;
               var35 = class98.field1497;
               if(!var33) {
                  var36 = Integer.MAX_VALUE;
                  var19 = Integer.MAX_VALUE;
                  byte var37 = 10;
                  var38 = var9.field2288;
                  var22 = var9.field2284;
                  int var32 = var9.field2287;
                  var24 = var9.field2286;

                  for(var25 = var38 - var37; var25 <= var38 + var37; ++var25) {
                     for(var26 = var22 - var37; var26 <= var37 + var22; ++var26) {
                        int var27 = var25 - var14;
                        int var28 = var26 - var15;
                        if(var27 >= 0 && var28 >= 0 && var27 < 128 && var28 < 128 && class162.field2273[var27][var28] < 100) {
                           int var29 = 0;
                           if(var25 < var38) {
                              var29 = var38 - var25;
                           } else if(var25 > var38 + var32 - 1) {
                              var29 = var25 - (var38 + var32 - 1);
                           }

                           int var30 = 0;
                           if(var26 < var22) {
                              var30 = var22 - var26;
                           } else if(var26 > var22 + var24 - 1) {
                              var30 = var26 - (var22 + var24 - 1);
                           }

                           int var31 = var30 * var30 + var29 * var29;
                           if(var31 < var36 || var36 == var31 && class162.field2273[var27][var28] < var19) {
                              var36 = var31;
                              var19 = class162.field2273[var27][var28];
                              var16 = var25;
                              var35 = var26;
                           }
                        }
                     }
                  }

                  if(var36 == Integer.MAX_VALUE) {
                     var7 = -1;
                     break label344;
                  }
               }

               if(var16 == var4 && var35 == var5) {
                  var7 = 0;
               } else {
                  var18 = 0;
                  class162.field2271[var18] = var16;
                  var36 = var18 + 1;
                  class162.field2282[var18] = var35;

                  for(var19 = var20 = class162.field2272[var16 - var14][var35 - var15]; var4 != var16 || var5 != var35; var19 = class162.field2272[var16 - var14][var35 - var15]) {
                     if(var19 != var20) {
                        var20 = var19;
                        class162.field2271[var36] = var16;
                        class162.field2282[var36++] = var35;
                     }

                     if((var19 & 2) != 0) {
                        ++var16;
                     } else if((var19 & 8) != 0) {
                        --var16;
                     }

                     if((var19 & 1) != 0) {
                        ++var35;
                     } else if((var19 & 4) != 0) {
                        --var35;
                     }
                  }

                  var38 = 0;

                  while(var36-- > 0) {
                     var11[var38] = class162.field2271[var36];
                     var12[var38++] = class162.field2282[var36];
                     if(var38 >= var11.length) {
                        break;
                     }
                  }

                  var7 = var38;
               }
            }

            var13 = var7;
            if(var7 >= 1) {
               for(var14 = 0; var14 < var13 - 1; ++var14) {
                  var0.method1151(Client.field919[var14], Client.field1161[var14], var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljw;I)V",
      garbageValue = "-2142318234"
   )
   static final void method234(IndexedSprite var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class174.field2373.length; ++var2) {
         class174.field2373[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class174.field2373[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class268.field3657[var5] = (class174.field2373[var5 + 128] + class174.field2373[var5 - 128] + class174.field2373[var5 + 1] + class174.field2373[var5 - 1]) / 4;
            }
         }

         int[] var8 = class174.field2373;
         class174.field2373 = class268.field3657;
         class268.field3657 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + var0.offsetX + 16;
                  int var6 = var3 + var0.offsetY + 16;
                  int var7 = var5 + (var6 << 7);
                  class174.field2373[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILcd;ZB)I",
      garbageValue = "107"
   )
   static int method236(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = WallObject.method2901(class83.intStack[--class83.intStackSize]);
      } else {
         var3 = var2?class214.field2615:class73.field851;
      }

      if(var0 == 1927) {
         if(class83.field1306 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2741 == null) {
            return 0;
         } else {
            ScriptEvent var4 = new ScriptEvent();
            var4.widget = var3;
            var4.field818 = var3.field2741;
            var4.field820 = class83.field1306 + 1;
            Client.field1082.addFront(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lcc;Lcc;IZI)I",
      garbageValue = "-2142408544"
   )
   static int method235(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1561()?(var1.method1561()?0:1):(var1.method1561()?-1:0)):(var2 == 5?(var0.method1573()?(var1.method1573()?0:1):(var1.method1573()?-1:0)):(var2 == 6?(var0.method1584()?(var1.method1584()?0:1):(var1.method1584()?-1:0)):(var2 == 7?(var0.method1596()?(var1.method1596()?0:1):(var1.method1596()?-1:0)):var0.id - var1.id)))));
      }
   }
}
