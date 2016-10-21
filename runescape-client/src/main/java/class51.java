import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class51 extends CacheableNode {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1371281141
   )
   public int field1098 = 0;
   @ObfuscatedName("e")
   static class170 field1099;
   @ObfuscatedName("t")
   public static NodeCache field1100 = new NodeCache(64);
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1514500927
   )
   int field1101 = -1;
   @ObfuscatedName("f")
   static class170 field1102;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1111614359
   )
   public int field1104 = 1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1217353079
   )
   public int field1105 = 70;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 247860727
   )
   int field1106 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1353687669
   )
   int field1107 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2106281159
   )
   int field1108 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1126700469
   )
   int field1109 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 72477583
   )
   public int field1111 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 361152119
   )
   public int field1112 = -1;
   @ObfuscatedName("z")
   String field1113 = "";
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1712961617
   )
   public int field1114 = -1;
   @ObfuscatedName("b")
   public static NodeCache field1115 = new NodeCache(20);
   @ObfuscatedName("s")
   public int[] field1116;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1995436249
   )
   int field1117 = -1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -693395037
   )
   int field1118 = -1;
   @ObfuscatedName("v")
   @Export("spriteCache")
   public static NodeCache spriteCache = new NodeCache(64);
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 153375361
   )
   public int field1121 = 0;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "8"
   )
   void method1032(Buffer var1) {
      while(true) {
         int var2 = var1.method2656();
         if(var2 == 0) {
            return;
         }

         this.method1033(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "743509371"
   )
   void method1033(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1118 = var1.method2636();
      } else if(var2 == 2) {
         this.field1104 = var1.method2537() * -16777217;
      } else if(var2 == 3) {
         this.field1106 = var1.method2636();
      } else if(var2 == 4) {
         this.field1108 = var1.method2636();
      } else if(var2 == 5) {
         this.field1107 = var1.method2636();
      } else if(var2 == 6) {
         this.field1109 = var1.method2636();
      } else if(var2 == 7) {
         this.field1121 = var1.method2633();
      } else if(var2 == 8) {
         this.field1113 = var1.method2517();
      } else if(var2 == 9) {
         this.field1105 = var1.method2535();
      } else if(var2 == 10) {
         this.field1111 = var1.method2633();
      } else if(var2 == 11) {
         this.field1112 = 0;
      } else if(var2 == 12) {
         this.field1114 = var1.method2656();
      } else if(var2 == 13) {
         this.field1098 = var1.method2633();
      } else if(var2 == 14) {
         this.field1112 = var1.method2535();
      } else if(var2 == 17 || var2 == 18) {
         this.field1117 = var1.method2535();
         if(this.field1117 == '\uffff') {
            this.field1117 = -1;
         }

         this.field1101 = var1.method2535();
         if(this.field1101 == '\uffff') {
            this.field1101 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.method2535();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.method2656();
         this.field1116 = new int[2 + var4];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field1116[var5] = var1.method2535();
            if(this.field1116[var5] == '\uffff') {
               this.field1116[var5] = -1;
            }
         }

         this.field1116[1 + var4] = var3;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Lclass51;",
      garbageValue = "-113"
   )
   public final class51 method1034() {
      int var1 = -1;
      if(this.field1117 != -1) {
         var1 = class112.method2454(this.field1117);
      } else if(this.field1101 != -1) {
         var1 = class179.widgetSettings[this.field1101];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field1116.length - 1) {
         var2 = this.field1116[var1];
      } else {
         var2 = this.field1116[this.field1116.length - 1];
      }

      return var2 != -1?Ignore.method95(var2):null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1731784922"
   )
   public String method1035(int var1) {
      String var2 = this.field1113;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + class160.method3193(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "2020863692"
   )
   public SpritePixels method1037() {
      if(this.field1107 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1107);
         if(null != var1) {
            return var1;
         } else {
            var1 = class1.method14(field1099, this.field1107, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field1107);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "-122"
   )
   public SpritePixels method1039() {
      if(this.field1109 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1109);
         if(null != var1) {
            return var1;
         } else {
            var1 = class1.method14(field1099, this.field1109, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field1109);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Lclass227;",
      garbageValue = "64"
   )
   public class227 method1040() {
      if(this.field1118 == -1) {
         return null;
      } else {
         class227 var1 = (class227)field1115.get((long)this.field1118);
         if(null != var1) {
            return var1;
         } else {
            var1 = class53.method1083(field1099, Ignore.field131, this.field1118, 0);
            if(var1 != null) {
               field1115.put(var1, (long)this.field1118);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "382740370"
   )
   public SpritePixels method1058() {
      if(this.field1108 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1108);
         if(null != var1) {
            return var1;
         } else {
            var1 = class1.method14(field1099, this.field1108, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field1108);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "531345804"
   )
   public SpritePixels method1060() {
      if(this.field1106 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1106);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class1.method14(field1099, this.field1106, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field1106);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)[LModIcon;",
      garbageValue = "-1208238129"
   )
   public static ModIcon[] method1062(class170 var0, String var1, String var2) {
      int var3 = var0.method3299(var1);
      int var4 = var0.method3361(var3, var2);
      byte[] var7 = var0.method3304(var3, var4);
      boolean var6;
      if(null == var7) {
         var6 = false;
      } else {
         class13.method154(var7);
         var6 = true;
      }

      ModIcon[] var5;
      if(!var6) {
         var5 = null;
      } else {
         ModIcon[] var8 = new ModIcon[class79.field1429];

         for(int var9 = 0; var9 < class79.field1429; ++var9) {
            ModIcon var10 = var8[var9] = new ModIcon();
            var10.width = class79.field1430;
            var10.originalHeight = class79.field1437;
            var10.offsetX = class189.field3050[var9];
            var10.offsetY = class79.field1431[var9];
            var10.originalWidth = class79.field1432[var9];
            var10.height = XItemContainer.field221[var9];
            var10.palette = class137.field2130;
            var10.pixels = BufferProvider.field1450[var9];
         }

         class14.method161();
         var5 = var8;
      }

      return var5;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "1563184436"
   )
   public static boolean method1063(char var0) {
      return var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(LActor;IIIIII)V",
      garbageValue = "307268785"
   )
   static final void method1068(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(null != var0 && var0.vmethod787()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(null != var6.field913) {
               var6 = var6.method798();
            }

            if(var6 == null) {
               return;
            }
         }

         int var82 = class34.field763;
         int[] var7 = class34.field758;
         int var8 = 3;
         int var9;
         int var16;
         int var22;
         int var23;
         if(!var0.field822.method3935()) {
            var9 = var0.field839 + 15;
            class178.method3497(var0.x, var0.y, var9);

            for(class26 var10 = (class26)var0.field822.method3932(); null != var10; var10 = (class26)var0.field822.method3928()) {
               class20 var11 = var10.method606(Client.gameCycle);
               if(null == var11) {
                  if(var10.method607()) {
                     var10.unlink();
                  }
               } else {
                  class49 var12 = var10.field642;
                  SpritePixels var13 = var12.method996();
                  SpritePixels var14 = var12.method986();
                  var16 = 0;
                  int var76;
                  if(var13 != null && var14 != null) {
                     if(var12.field1072 * 2 < var14.width) {
                        var16 = var12.field1072;
                     }

                     var76 = var14.width - 2 * var16;
                  } else {
                     var76 = var12.field1083;
                  }

                  int var17 = 255;
                  boolean var18 = true;
                  int var19 = Client.gameCycle - var11.field570;
                  int var77 = var11.field566 * var76 / var12.field1083;
                  int var21;
                  int var88;
                  if(var11.field568 > var19) {
                     var21 = var12.field1089 == 0?0:var19 / var12.field1089 * var12.field1089;
                     var22 = var11.field569 * var76 / var12.field1083;
                     var88 = var22 + var21 * (var77 - var22) / var11.field568;
                  } else {
                     var88 = var77;
                     var21 = var12.field1084 + var11.field568 - var19;
                     if(var12.field1078 >= 0) {
                        var17 = (var21 << 8) / (var12.field1084 - var12.field1078);
                     }
                  }

                  if(var11.field566 > 0 && var88 < 1) {
                     var88 = 1;
                  }

                  var21 = var2 + Client.field387 - (var76 >> 1);
                  var22 = Client.field388 + var3 - var8;
                  if(null != var13 && null != var14) {
                     var21 -= var16;
                     if(var76 == var88) {
                        var88 += 2 * var16;
                     } else {
                        var88 += var16;
                     }

                     var23 = var13.height;
                     var8 += var23;
                     if(var17 >= 0 && var17 < 255) {
                        var13.method1768(var21, var22, var17);
                        class82.method1887(var21, var22, var88 + var21, var23 + var22);
                        var14.method1768(var21, var22, var17);
                     } else {
                        var13.method1763(var21, var22);
                        class82.method1887(var21, var22, var88 + var21, var23 + var22);
                        var14.method1763(var21, var22);
                     }

                     class82.method1895(var2, var3, var4 + var2, var3 + var5);
                     var8 += 2;
                  } else {
                     if(Client.field387 > -1) {
                        class82.method1861(var21, var22, var88, 5, '\uff00');
                        class82.method1861(var21 + var88, var22, var76 - var88, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         int var81;
         if(var1 < var82) {
            Player var80 = (Player)var0;
            if(var80.field52) {
               return;
            }

            if(var80.field56 != -1 || var80.field33 != -1) {
               var81 = var0.field839 + 15;
               class178.method3497(var0.x, var0.y, var81);
               if(Client.field387 > -1) {
                  if(var80.field56 != -1) {
                     class79.field1428[var80.field56].method1763(Client.field387 + var2 - 12, var3 + Client.field388 - var8);
                     var8 += 25;
                  }

                  if(var80.field33 != -1) {
                     class124.field2067[var80.field33].method1763(var2 + Client.field387 - 12, Client.field388 + var3 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field298 == 10 && Client.field533 == var7[var1]) {
               var81 = var0.field839 + 15;
               class178.method3497(var0.x, var0.y, var81);
               if(Client.field387 > -1) {
                  class40.field882[1].method1763(Client.field387 + var2 - 12, Client.field388 + var3 - var8);
               }
            }
         } else {
            NPCComposition var90 = ((NPC)var0).composition;
            if(var90.field913 != null) {
               var90 = var90.method798();
            }

            if(var90.field911 >= 0 && var90.field911 < class124.field2067.length) {
               var81 = 15 + var0.field839;
               class178.method3497(var0.x, var0.y, var81);
               if(Client.field387 > -1) {
                  class124.field2067[var90.field911].method1763(var2 + Client.field387 - 12, var3 + Client.field388 - 30);
               }
            }

            if(Client.field298 == 1 && Client.field278 == Client.field405[var1 - var82] && Client.gameCycle % 20 < 10) {
               var81 = var0.field839 + 15;
               class178.method3497(var0.x, var0.y, var81);
               if(Client.field387 > -1) {
                  class40.field882[0].method1763(Client.field387 + var2 - 12, Client.field388 + var3 - 28);
               }
            }
         }

         if(null != var0.overhead && (var1 >= var82 || !var0.inSequence && (Client.field497 == 4 || !var0.field830 && (Client.field497 == 0 || Client.field497 == 3 || Client.field497 == 1 && class5.method79(((Player)var0).name, false))))) {
            var9 = var0.field839;
            class178.method3497(var0.x, var0.y, var9);
            if(Client.field387 > -1 && Client.field382 < Client.field376) {
               Client.field380[Client.field382] = class79.field1434.method4091(var0.overhead) / 2;
               Client.field553[Client.field382] = class79.field1434.field3245;
               Client.field377[Client.field382] = Client.field387;
               Client.field378[Client.field382] = Client.field388;
               Client.field518[Client.field382] = var0.field816;
               Client.field284[Client.field382] = var0.field834;
               Client.field383[Client.field382] = var0.field832;
               Client.field384[Client.field382] = var0.overhead;
               ++Client.field382;
            }
         }

         for(var9 = 0; var9 < 4; ++var9) {
            var81 = var0.field838[var9];
            int var85 = var0.field870[var9];
            class51 var87 = null;
            int var84 = 0;
            if(var85 >= 0) {
               if(var81 <= Client.gameCycle) {
                  continue;
               }

               var87 = Ignore.method95(var0.field870[var9]);
               var84 = var87.field1105;
               if(var87 != null && var87.field1116 != null) {
                  var87 = var87.method1034();
                  if(null == var87) {
                     var0.field838[var9] = -1;
                     continue;
                  }
               }
            } else if(var81 < 0) {
               continue;
            }

            int var83 = var0.field874[var9];
            class51 var15 = null;
            if(var83 >= 0) {
               var15 = Ignore.method95(var83);
               if(null != var15 && null != var15.field1116) {
                  var15 = var15.method1034();
               }
            }

            if(var81 - var84 <= Client.gameCycle) {
               if(null == var87) {
                  var0.field838[var9] = -1;
               } else {
                  var16 = var0.field839 / 2;
                  class178.method3497(var0.x, var0.y, var16);
                  if(Client.field387 > -1) {
                     if(var9 == 1) {
                        Client.field388 -= 20;
                     }

                     if(var9 == 2) {
                        Client.field387 -= 15;
                        Client.field388 -= 10;
                     }

                     if(var9 == 3) {
                        Client.field387 += 15;
                        Client.field388 -= 10;
                     }

                     SpritePixels var79 = null;
                     SpritePixels var78 = null;
                     SpritePixels var20 = null;
                     SpritePixels var86 = null;
                     var22 = 0;
                     var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     int var28 = 0;
                     int var29 = 0;
                     SpritePixels var30 = null;
                     SpritePixels var31 = null;
                     SpritePixels var32 = null;
                     SpritePixels var33 = null;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     int var41 = 0;
                     int var42 = 0;
                     var79 = var87.method1060();
                     int var43;
                     if(var79 != null) {
                        var22 = var79.width;
                        var43 = var79.height;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var26 = var79.field1460;
                     }

                     var78 = var87.method1037();
                     if(null != var78) {
                        var23 = var78.width;
                        var43 = var78.height;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var27 = var78.field1460;
                     }

                     var20 = var87.method1058();
                     if(var20 != null) {
                        var24 = var20.width;
                        var43 = var20.height;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var28 = var20.field1460;
                     }

                     var86 = var87.method1039();
                     if(var86 != null) {
                        var25 = var86.width;
                        var43 = var86.height;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var29 = var86.field1460;
                     }

                     if(null != var15) {
                        var30 = var15.method1060();
                        if(var30 != null) {
                           var34 = var30.width;
                           var43 = var30.height;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var38 = var30.field1460;
                        }

                        var31 = var15.method1037();
                        if(null != var31) {
                           var35 = var31.width;
                           var43 = var31.height;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var39 = var31.field1460;
                        }

                        var32 = var15.method1058();
                        if(var32 != null) {
                           var36 = var32.width;
                           var43 = var32.height;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var40 = var32.field1460;
                        }

                        var33 = var15.method1039();
                        if(var33 != null) {
                           var37 = var33.width;
                           var43 = var33.height;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var41 = var33.field1460;
                        }
                     }

                     class227 var75 = var87.method1040();
                     if(null == var75) {
                        var75 = XItemContainer.field225;
                     }

                     class227 var44;
                     if(var15 != null) {
                        var44 = var15.method1040();
                        if(null == var44) {
                           var44 = XItemContainer.field225;
                        }
                     } else {
                        var44 = XItemContainer.field225;
                     }

                     String var45 = null;
                     String var46 = null;
                     boolean var47 = false;
                     int var48 = 0;
                     var45 = var87.method1035(var0.field837[var9]);
                     int var89 = var75.method4091(var45);
                     if(var15 != null) {
                        var46 = var15.method1035(var0.field820[var9]);
                        var48 = var44.method4091(var46);
                     }

                     int var49 = 0;
                     int var50 = 0;
                     if(var23 > 0) {
                        if(var20 == null && var86 == null) {
                           var49 = 1;
                        } else {
                           var49 = var89 / var23 + 1;
                        }
                     }

                     if(null != var15 && var35 > 0) {
                        if(var32 == null && null == var33) {
                           var50 = 1;
                        } else {
                           var50 = var48 / var35 + 1;
                        }
                     }

                     int var51 = 0;
                     int var52 = var51;
                     if(var22 > 0) {
                        var51 += var22;
                     }

                     var51 += 2;
                     int var53 = var51;
                     if(var24 > 0) {
                        var51 += var24;
                     }

                     int var54 = var51;
                     int var55 = var51;
                     int var56;
                     if(var23 > 0) {
                        var56 = var23 * var49;
                        var51 += var56;
                        var55 += (var56 - var89) / 2;
                     } else {
                        var51 += var89;
                     }

                     var56 = var51;
                     if(var25 > 0) {
                        var51 += var25;
                     }

                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61 = 0;
                     int var62;
                     if(null != var15) {
                        var51 += 2;
                        var57 = var51;
                        if(var34 > 0) {
                           var51 += var34;
                        }

                        var51 += 2;
                        var58 = var51;
                        if(var36 > 0) {
                           var51 += var36;
                        }

                        var59 = var51;
                        var61 = var51;
                        if(var35 > 0) {
                           var62 = var35 * var50;
                           var51 += var62;
                           var61 += (var62 - var48) / 2;
                        } else {
                           var51 += var48;
                        }

                        var60 = var51;
                        if(var37 > 0) {
                           var51 += var37;
                        }
                     }

                     var62 = var0.field838[var9] - Client.gameCycle;
                     int var63 = var87.field1121 - var87.field1121 * var62 / var87.field1105;
                     int var64 = -var87.field1111 + var87.field1111 * var62 / var87.field1105;
                     int var65 = var2 + Client.field387 - (var51 >> 1) + var63;
                     int var66 = var64 + (Client.field388 + var3 - 12);
                     int var67 = var66;
                     int var68 = var42 + var66;
                     int var69 = var87.field1098 + var66 + 15;
                     int var70 = var69 - var75.field3234;
                     int var71 = var75.field3240 + var69;
                     if(var70 < var66) {
                        var67 = var70;
                     }

                     if(var71 > var68) {
                        var68 = var71;
                     }

                     int var72 = 0;
                     int var73;
                     int var74;
                     if(var15 != null) {
                        var72 = var15.field1098 + 15 + var66;
                        var73 = var72 - var44.field3234;
                        var74 = var72 + var44.field3240;
                        if(var73 < var67) {
                           ;
                        }

                        if(var74 > var68) {
                           ;
                        }
                     }

                     var73 = 255;
                     if(var87.field1112 >= 0) {
                        var73 = (var62 << 8) / (var87.field1105 - var87.field1112);
                     }

                     if(var73 >= 0 && var73 < 255) {
                        if(var79 != null) {
                           var79.method1768(var65 + var52 - var26, var66, var73);
                        }

                        if(var20 != null) {
                           var20.method1768(var53 + var65 - var28, var66, var73);
                        }

                        if(var78 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var78.method1768(var65 + var54 - var27 + var23 * var74, var66, var73);
                           }
                        }

                        if(var86 != null) {
                           var86.method1768(var65 + var56 - var29, var66, var73);
                        }

                        var75.method4097(var45, var65 + var55, var69, var87.field1104 * 16777215, 0, var73);
                        if(var15 != null) {
                           if(var30 != null) {
                              var30.method1768(var65 + var57 - var38, var66, var73);
                           }

                           if(var32 != null) {
                              var32.method1768(var65 + var58 - var40, var66, var73);
                           }

                           if(null != var31) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var31.method1768(var59 + var65 - var39 + var35 * var74, var66, var73);
                              }
                           }

                           if(null != var33) {
                              var33.method1768(var65 + var60 - var41, var66, var73);
                           }

                           var44.method4097(var46, var65 + var61, var72, var15.field1104 * 16777215, 0, var73);
                        }
                     } else {
                        if(var79 != null) {
                           var79.method1763(var65 + var52 - var26, var66);
                        }

                        if(null != var20) {
                           var20.method1763(var53 + var65 - var28, var66);
                        }

                        if(null != var78) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var78.method1763(var54 + var65 - var27 + var74 * var23, var66);
                           }
                        }

                        if(var86 != null) {
                           var86.method1763(var56 + var65 - var29, var66);
                        }

                        var75.method4096(var45, var65 + var55, var69, var87.field1104 * 16777215 | -16777216, 0);
                        if(var15 != null) {
                           if(null != var30) {
                              var30.method1763(var57 + var65 - var38, var66);
                           }

                           if(var32 != null) {
                              var32.method1763(var65 + var58 - var40, var66);
                           }

                           if(null != var31) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var31.method1763(var35 * var74 + (var59 + var65 - var39), var66);
                              }
                           }

                           if(var33 != null) {
                              var33.method1763(var60 + var65 - var41, var66);
                           }

                           var44.method4096(var46, var65 + var61, var72, var15.field1104 * 16777215 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(LWidget;II)I",
      garbageValue = "457178180"
   )
   static final int method1069(Widget var0, int var1) {
      if(var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = Client.boostedSkillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.realSkillLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.skillExperiences[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class153.method3170(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class45.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var10.itemIds[var12] == var11 + 1) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class179.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class158.field2340[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class179.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class34.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class158.field2336[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class153.method3170(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class45.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.energy;
               }

               if(var6 == 12) {
                  var7 = Client.weight;
               }

               if(var6 == 13) {
                  var9 = class179.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class112.method2454(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (class34.localPlayer.x >> 7) + class32.baseX;
               }

               if(var6 == 19) {
                  var7 = (class34.localPlayer.y >> 7) + class8.baseY;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }
}
