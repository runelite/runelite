import java.awt.event.ActionEvent;
import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("c")
   boolean[] field264;
   @ObfuscatedName("v")
   int[] field265;
   @ObfuscatedName("m")
   boolean field267 = false;
   @ObfuscatedName("j")
   @Export("messages")
   String[] messages;
   @ObfuscatedName("f")
   boolean[] field270;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = -8023090260787351435L
   )
   long field271;
   @ObfuscatedName("jk")
   static Widget[] field272;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1419501212"
   )
   public static void method189() {
      Object var0 = class173.field2757;
      synchronized(class173.field2757) {
         if(class173.field2756 != 0) {
            class173.field2756 = 1;

            try {
               class173.field2757.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1992943750"
   )
   void method190(int var1, int var2) {
      this.field265[var1] = var2;
      if(this.field270[var1]) {
         this.field267 = true;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZS)LFileOnDisk;",
      garbageValue = "1945"
   )
   FileOnDisk method191(boolean var1) {
      return class116.method2507("2", Client.field280.field2328, var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "2"
   )
   void method192(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field264[var1]) {
         this.field267 = true;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-2125035657"
   )
   String method193(int var1) {
      return this.messages[var1];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "23"
   )
   void method195() {
      FileOnDisk var1 = this.method191(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field265.length; ++var4) {
            if(this.field270[var4] && this.field265[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field264[var5] && this.messages[var5] != null) {
               var2 += 2 + class31.method685(this.messages[var5]);
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.method2556(1);
         var9.method2638(var3);

         int var6;
         for(var6 = 0; var6 < this.field265.length; ++var6) {
            if(this.field270[var6] && this.field265[var6] != -1) {
               var9.method2638(var6);
               var9.method2559(this.field265[var6]);
            }
         }

         var9.method2638(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field264[var6] && this.messages[var6] != null) {
               var9.method2638(var6);
               var9.method2562(this.messages[var6]);
            }
         }

         var1.method4145(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method4146();
         } catch (Exception var16) {
            ;
         }

      }

      this.field267 = false;
      this.field271 = class169.method3276();
   }

   ChatMessages() {
      this.field265 = new int[class13.field200.method3290(19)];
      this.messages = new String[class13.field200.method3290(15)];
      this.field270 = new boolean[this.field265.length];

      int var1;
      for(var1 = 0; var1 < this.field265.length; ++var1) {
         class47 var3 = (class47)class47.field1066.get((long)var1);
         class47 var2;
         if(null != var3) {
            var2 = var3;
         } else {
            byte[] var4 = class47.field1071.method3305(19, var1);
            var3 = new class47();
            if(var4 != null) {
               var3.method978(new Buffer(var4));
            }

            class47.field1066.put(var3, (long)var1);
            var2 = var3;
         }

         this.field270[var1] = var2.field1065;
      }

      this.field264 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class53 var5 = class35.method739(var1);
         this.field264[var1] = var5.field1154;
      }

      for(var1 = 0; var1 < this.field265.length; ++var1) {
         this.field265[var1] = -1;
      }

      this.method196();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1277364705"
   )
   void method196() {
      FileOnDisk var1 = this.method191(false);

      label191: {
         try {
            byte[] var2 = new byte[(int)var1.method4147()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method4143(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            Buffer var13 = new Buffer(var2);
            if(var13.payload.length - var13.offset < 1) {
               return;
            }

            int var14 = var13.method2571();
            if(var14 >= 0 && var14 <= 1) {
               int var15 = var13.method2691();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var15; ++var7) {
                  var8 = var13.method2691();
                  var9 = var13.method2576();
                  if(this.field270[var8]) {
                     this.field265[var8] = var9;
                  }
               }

               var7 = var13.method2691();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label191;
                  }

                  var9 = var13.method2691();
                  String var10 = var13.method2579();
                  if(this.field264[var9]) {
                     this.messages[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label191;
         } finally {
            try {
               var1.method4146();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.field267 = false;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "115"
   )
   boolean method198() {
      return this.field267;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1595727672"
   )
   int method199(int var1) {
      return this.field265[var1];
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "15095"
   )
   void method205() {
      int var1;
      for(var1 = 0; var1 < this.field265.length; ++var1) {
         if(!this.field270[var1]) {
            this.field265[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field264[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1607789473"
   )
   void method211() {
      if(this.field267 && this.field271 < class169.method3276() - 60000L) {
         this.method195();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass139;Ljava/lang/Object;I)V",
      garbageValue = "1633997665"
   )
   public static void method214(class139 var0, Object var1) {
      if(var0.field2143 != null) {
         for(int var2 = 0; var2 < 50 && var0.field2143.peekEvent() != null; ++var2) {
            class127.method2846(1L);
         }

         if(null != var1) {
            var0.field2143.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(LActor;IIIIIB)V",
      garbageValue = "40"
   )
   static final void method224(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(null != var0 && var0.vmethod774()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(null != var6.field923) {
               var6 = var6.method801();
            }

            if(var6 == null) {
               return;
            }
         }

         int var74 = class34.field777;
         int[] var7 = class34.field773;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.field848.method3897()) {
            TextureProvider.method2253(var0, var0.field857 + 15);

            for(class26 var75 = (class26)var0.field848.method3893(); var75 != null; var75 = (class26)var0.field848.method3913()) {
               class20 var10 = var75.method619(Client.gameCycle);
               if(var10 == null) {
                  if(var75.method609()) {
                     var75.unlink();
                  }
               } else {
                  class49 var11 = var75.field629;
                  SpritePixels var12 = var11.method1010();
                  SpritePixels var13 = var11.method1028();
                  int var15 = 0;
                  if(var12 != null && null != var13) {
                     if(var11.field1096 * 2 < var13.width) {
                        var15 = var11.field1096;
                     }

                     var14 = var13.width - 2 * var15;
                  } else {
                     var14 = var11.field1098;
                  }

                  int var16 = 255;
                  boolean var76 = true;
                  int var18 = Client.gameCycle - var10.field566;
                  int var19 = var10.field564 * var14 / var11.field1098;
                  int var20;
                  int var89;
                  if(var10.field567 > var18) {
                     var20 = var11.field1093 == 0?0:var18 / var11.field1093 * var11.field1093;
                     var21 = var10.field565 * var14 / var11.field1098;
                     var89 = var21 + var20 * (var19 - var21) / var10.field567;
                  } else {
                     var89 = var19;
                     var20 = var11.field1094 + var10.field567 - var18;
                     if(var11.field1092 >= 0) {
                        var16 = (var20 << 8) / (var11.field1094 - var11.field1092);
                     }
                  }

                  if(var10.field564 > 0 && var89 < 1) {
                     var89 = 1;
                  }

                  var20 = Client.field387 + var2 - (var14 >> 1);
                  var21 = Client.field333 + var3 - var8;
                  if(null != var12 && null != var13) {
                     var20 -= var15;
                     if(var89 == var14) {
                        var89 += 2 * var15;
                     } else {
                        var89 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method1755(var20, var21, var16);
                        class82.method1835(var20, var21, var20 + var89, var21 + var22);
                        var13.method1755(var20, var21, var16);
                     } else {
                        var12.method1760(var20, var21);
                        class82.method1835(var20, var21, var89 + var20, var22 + var21);
                        var13.method1760(var20, var21);
                     }

                     class82.method1834(var2, var3, var4 + var2, var3 + var5);
                     var8 += 2;
                  } else {
                     if(Client.field387 > -1) {
                        class82.method1885(var20, var21, var89, 5, '\uff00');
                        class82.method1885(var89 + var20, var21, var14 - var89, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         if(var1 < var74) {
            Player var87 = (Player)var0;
            if(var87.field49) {
               return;
            }

            if(var87.field30 != -1 || var87.field46 != -1) {
               TextureProvider.method2253(var0, 15 + var0.field857);
               if(Client.field387 > -1) {
                  if(var87.field30 != -1) {
                     class0.field12[var87.field30].method1760(Client.field387 + var2 - 12, var3 + Client.field333 - var8);
                     var8 += 25;
                  }

                  if(var87.field46 != -1) {
                     class151.field2276[var87.field46].method1760(Client.field387 + var2 - 12, var3 + Client.field333 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field278 == 10 && Client.field467 == var7[var1]) {
               TextureProvider.method2253(var0, 15 + var0.field857);
               if(Client.field387 > -1) {
                  XClanMember.field623[1].method1760(Client.field387 + var2 - 12, var3 + Client.field333 - var8);
               }
            }
         } else {
            NPCComposition var88 = ((NPC)var0).composition;
            if(var88.field923 != null) {
               var88 = var88.method801();
            }

            if(var88.field928 >= 0 && var88.field928 < class151.field2276.length) {
               TextureProvider.method2253(var0, 15 + var0.field857);
               if(Client.field387 > -1) {
                  class151.field2276[var88.field928].method1760(var2 + Client.field387 - 12, var3 + Client.field333 - 30);
               }
            }

            if(Client.field278 == 1 && Client.field501[var1 - var74] == Client.field427 && Client.gameCycle % 20 < 10) {
               TextureProvider.method2253(var0, 15 + var0.field857);
               if(Client.field387 > -1) {
                  XClanMember.field623[0].method1760(var2 + Client.field387 - 12, var3 + Client.field333 - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var74 || !var0.inSequence && (Client.field498 == 4 || !var0.field868 && (Client.field498 == 0 || Client.field498 == 3 || Client.field498 == 1 && class0.method1(((Player)var0).name, false))))) {
            TextureProvider.method2253(var0, var0.field857);
            if(Client.field387 > -1 && Client.field530 < Client.field376) {
               Client.field380[Client.field530] = PlayerComposition.field2977.method4047(var0.overhead) / 2;
               Client.field379[Client.field530] = PlayerComposition.field2977.field3240;
               Client.field377[Client.field530] = Client.field387;
               Client.field354[Client.field530] = Client.field333;
               Client.field381[Client.field530] = var0.field842;
               Client.field345[Client.field530] = var0.field843;
               Client.field383[Client.field530] = var0.field884;
               Client.field384[Client.field530] = var0.overhead;
               ++Client.field530;
            }
         }

         for(int var9 = 0; var9 < 4; ++var9) {
            int var79 = var0.field847[var9];
            int var80 = var0.field837[var9];
            class51 var85 = null;
            int var81 = 0;
            if(var80 >= 0) {
               if(var79 <= Client.gameCycle) {
                  continue;
               }

               var85 = class43.method892(var0.field837[var9]);
               var81 = var85.field1121;
               if(var85 != null && null != var85.field1132) {
                  var85 = var85.method1047();
                  if(var85 == null) {
                     var0.field847[var9] = -1;
                     continue;
                  }
               }
            } else if(var79 < 0) {
               continue;
            }

            var14 = var0.field886[var9];
            class51 var77 = null;
            if(var14 >= 0) {
               var77 = class43.method892(var14);
               if(var77 != null && var77.field1132 != null) {
                  var77 = var77.method1047();
               }
            }

            if(var79 - var81 <= Client.gameCycle) {
               if(null == var85) {
                  var0.field847[var9] = -1;
               } else {
                  TextureProvider.method2253(var0, var0.field857 / 2);
                  if(Client.field387 > -1) {
                     if(var9 == 1) {
                        Client.field333 -= 20;
                     }

                     if(var9 == 2) {
                        Client.field387 -= 15;
                        Client.field333 -= 10;
                     }

                     if(var9 == 3) {
                        Client.field387 += 15;
                        Client.field333 -= 10;
                     }

                     SpritePixels var17 = null;
                     SpritePixels var83 = null;
                     SpritePixels var84 = null;
                     SpritePixels var82 = null;
                     var21 = 0;
                     var22 = 0;
                     int var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     int var28 = 0;
                     SpritePixels var29 = null;
                     SpritePixels var30 = null;
                     SpritePixels var31 = null;
                     SpritePixels var32 = null;
                     int var33 = 0;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     int var41 = 0;
                     var17 = var85.method1049();
                     int var42;
                     if(null != var17) {
                        var21 = var17.width;
                        var42 = var17.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var17.field1455;
                     }

                     var83 = var85.method1057();
                     if(null != var83) {
                        var22 = var83.width;
                        var42 = var83.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var83.field1455;
                     }

                     var84 = var85.method1051();
                     if(var84 != null) {
                        var23 = var84.width;
                        var42 = var84.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var84.field1455;
                     }

                     var82 = var85.method1052();
                     if(null != var82) {
                        var24 = var82.width;
                        var42 = var82.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var82.field1455;
                     }

                     if(null != var77) {
                        var29 = var77.method1049();
                        if(var29 != null) {
                           var33 = var29.width;
                           var42 = var29.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.field1455;
                        }

                        var30 = var77.method1057();
                        if(var30 != null) {
                           var34 = var30.width;
                           var42 = var30.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.field1455;
                        }

                        var31 = var77.method1051();
                        if(var31 != null) {
                           var35 = var31.width;
                           var42 = var31.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.field1455;
                        }

                        var32 = var77.method1052();
                        if(null != var32) {
                           var36 = var32.width;
                           var42 = var32.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.field1455;
                        }
                     }

                     class227 var78 = var85.method1056();
                     if(null == var78) {
                        var78 = class52.field1149;
                     }

                     class227 var43;
                     if(null != var77) {
                        var43 = var77.method1056();
                        if(var43 == null) {
                           var43 = class52.field1149;
                        }
                     } else {
                        var43 = class52.field1149;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var85.method1065(var0.field846[var9]);
                     int var86 = var78.method4047(var44);
                     if(null != var77) {
                        var45 = var77.method1065(var0.field849[var9]);
                        var47 = var43.method4047(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(null == var84 && var82 == null) {
                           var48 = 1;
                        } else {
                           var48 = 1 + var86 / var22;
                        }
                     }

                     if(null != var77 && var34 > 0) {
                        if(null == var31 && null == var32) {
                           var49 = 1;
                        } else {
                           var49 = var47 / var34 + 1;
                        }
                     }

                     int var50 = 0;
                     int var51 = var50;
                     if(var21 > 0) {
                        var50 += var21;
                     }

                     var50 += 2;
                     int var52 = var50;
                     if(var23 > 0) {
                        var50 += var23;
                     }

                     int var53 = var50;
                     int var54 = var50;
                     int var55;
                     if(var22 > 0) {
                        var55 = var22 * var48;
                        var50 += var55;
                        var54 += (var55 - var86) / 2;
                     } else {
                        var50 += var86;
                     }

                     var55 = var50;
                     if(var24 > 0) {
                        var50 += var24;
                     }

                     int var56 = 0;
                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61;
                     if(var77 != null) {
                        var50 += 2;
                        var56 = var50;
                        if(var33 > 0) {
                           var50 += var33;
                        }

                        var50 += 2;
                        var57 = var50;
                        if(var35 > 0) {
                           var50 += var35;
                        }

                        var58 = var50;
                        var60 = var50;
                        if(var34 > 0) {
                           var61 = var49 * var34;
                           var50 += var61;
                           var60 += (var61 - var47) / 2;
                        } else {
                           var50 += var47;
                        }

                        var59 = var50;
                        if(var36 > 0) {
                           var50 += var36;
                        }
                     }

                     var61 = var0.field847[var9] - Client.gameCycle;
                     int var62 = var85.field1126 - var61 * var85.field1126 / var85.field1121;
                     int var63 = -var85.field1129 + var85.field1129 * var61 / var85.field1121;
                     int var64 = var62 + (Client.field387 + var2 - (var50 >> 1));
                     int var65 = var63 + (Client.field333 + var3 - 12);
                     int var66 = var65;
                     int var67 = var65 + var41;
                     int var68 = var85.field1131 + var65 + 15;
                     int var69 = var68 - var78.field3249;
                     int var70 = var68 + var78.field3250;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(var77 != null) {
                        var71 = var77.field1131 + 15 + var65;
                        var72 = var71 - var43.field3249;
                        var73 = var43.field3250 + var71;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var85.field1127 >= 0) {
                        var72 = (var61 << 8) / (var85.field1121 - var85.field1127);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(null != var17) {
                           var17.method1755(var64 + var51 - var25, var65, var72);
                        }

                        if(var84 != null) {
                           var84.method1755(var64 + var52 - var27, var65, var72);
                        }

                        if(null != var83) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var83.method1755(var53 + var64 - var26 + var73 * var22, var65, var72);
                           }
                        }

                        if(null != var82) {
                           var82.method1755(var55 + var64 - var28, var65, var72);
                        }

                        var78.method4052(var44, var64 + var54, var68, var85.field1128, 0, var72);
                        if(var77 != null) {
                           if(null != var29) {
                              var29.method1755(var56 + var64 - var37, var65, var72);
                           }

                           if(null != var31) {
                              var31.method1755(var57 + var64 - var39, var65, var72);
                           }

                           if(null != var30) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method1755(var58 + var64 - var38 + var34 * var73, var65, var72);
                              }
                           }

                           if(null != var32) {
                              var32.method1755(var64 + var59 - var40, var65, var72);
                           }

                           var43.method4052(var45, var64 + var60, var71, var77.field1128, 0, var72);
                        }
                     } else {
                        if(var17 != null) {
                           var17.method1760(var64 + var51 - var25, var65);
                        }

                        if(null != var84) {
                           var84.method1760(var64 + var52 - var27, var65);
                        }

                        if(var83 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var83.method1760(var64 + var53 - var26 + var73 * var22, var65);
                           }
                        }

                        if(null != var82) {
                           var82.method1760(var64 + var55 - var28, var65);
                        }

                        var78.method4118(var44, var54 + var64, var68, var85.field1128 | -16777216, 0);
                        if(var77 != null) {
                           if(null != var29) {
                              var29.method1760(var56 + var64 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.method1760(var64 + var57 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method1760(var34 * var73 + (var58 + var64 - var38), var65);
                              }
                           }

                           if(var32 != null) {
                              var32.method1760(var59 + var64 - var40, var65);
                           }

                           var43.method4118(var45, var60 + var64, var71, var77.field1128 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(III)Ljava/lang/String;",
      garbageValue = "1626997683"
   )
   static final String method226(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class144.method3013(16711680):(var2 < -6?class144.method3013(16723968):(var2 < -3?class144.method3013(16740352):(var2 < 0?class144.method3013(16756736):(var2 > 9?class144.method3013('\uff00'):(var2 > 6?class144.method3013(4259584):(var2 > 3?class144.method3013(8453888):(var2 > 0?class144.method3013(12648192):class144.method3013(16776960))))))));
   }
}
