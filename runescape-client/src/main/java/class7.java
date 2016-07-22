import java.awt.Color;
import java.awt.Container;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
@Implements("Ignore")
public class class7 {
   @ObfuscatedName("m")
   @Export("name")
   String field120;
   @ObfuscatedName("w")
   @Export("previousName")
   String field122;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = -212287353
   )
   static int field123;
   @ObfuscatedName("bf")
   protected static FontMetrics field124;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)Lclass230;",
      garbageValue = "-1119338891"
   )
   public static class230 method96(String var0, String var1, boolean var2) {
      File var3 = new File(class152.field2291, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            class230 var10 = new class230(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class21.field574 == 33) {
         var4 = "_rc";
      } else if(class21.field574 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class52.field1155, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      class230 var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new class230(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new class230(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "364845739"
   )
   static final void method97(String var0) {
      if(null != var0) {
         if((client.field537 < 200 || client.field549 == 1) && client.field537 < 400) {
            String var1 = class23.method579(var0, class134.field2117);
            if(var1 != null) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < client.field537; ++var2) {
                  class17 var3 = client.field273[var2];
                  var4 = class23.method579(var3.field229, class134.field2117);
                  if(null != var4 && var4.equals(var1)) {
                     class59.method1304(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(var3.field224 != null) {
                     var5 = class23.method579(var3.field224, class134.field2117);
                     if(null != var5 && var5.equals(var1)) {
                        class59.method1304(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < client.field543; ++var2) {
                  class7 var6 = client.field384[var2];
                  var4 = class23.method579(var6.field120, class134.field2117);
                  if(var4 != null && var4.equals(var1)) {
                     class59.method1304(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(null != var6.field122) {
                     var5 = class23.method579(var6.field122, class134.field2117);
                     if(var5 != null && var5.equals(var1)) {
                        class59.method1304(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class23.method579(class114.field2010.field43, class134.field2117).equals(var1)) {
                  class59.method1304(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  client.field313.method2797(73);
                  client.field313.method2557(class77.method1679(var0));
                  client.field313.method2563(var0);
               }
            }
         } else {
            class59.method1304(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "193386309"
   )
   static final void method98() {
      client.field313.method2797(164);

      for(class3 var0 = (class3)client.field535.method3847(); var0 != null; var0 = (class3)client.field535.method3852()) {
         if(var0.field64 == 0 || var0.field64 == 3) {
            class142.method3002(var0, true);
         }
      }

      if(client.field402 != null) {
         class92.method2164(client.field402);
         client.field402 = null;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-182030894"
   )
   static final void method99() {
      if(client.field289 > 1) {
         --client.field289;
      }

      if(client.field323 > 0) {
         --client.field323;
      }

      if(client.field324) {
         client.field324 = false;
         if(client.field323 > 0) {
            class15.method178();
         } else {
            class171.method3414(40);
            class177.field2937 = class38.field829;
            class38.field829 = null;
         }

      } else {
         if(!client.field517) {
            client.field417[0] = "Cancel";
            client.field328[0] = "";
            client.field415[0] = 1006;
            client.field412 = 1;
         }

         int var0;
         for(var0 = 0; var0 < 100 && class18.method194(); ++var0) {
            ;
         }

         if(client.field280 == 30) {
            while(class44.method914()) {
               client.field313.method2797(209);
               client.field313.method2557(0);
               var0 = client.field313.field2045;
               class111.method2482(client.field313);
               client.field313.method2701(client.field313.field2045 - var0);
            }

            Object var12 = class62.field1289.field180;
            int var1;
            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            synchronized(class62.field1289.field180) {
               if(!client.field271) {
                  class62.field1289.field185 = 0;
               } else if(class143.field2224 != 0 || class62.field1289.field185 >= 40) {
                  client.field313.method2797(90);
                  client.field313.method2557(0);
                  var1 = client.field313.field2045;
                  var2 = 0;

                  for(var3 = 0; var3 < class62.field1289.field185 && client.field313.field2045 - var1 < 240; ++var3) {
                     ++var2;
                     var4 = class62.field1289.field178[var3];
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > 502) {
                        var4 = 502;
                     }

                     var5 = class62.field1289.field179[var3];
                     if(var5 < 0) {
                        var5 = 0;
                     } else if(var5 > 764) {
                        var5 = 764;
                     }

                     var6 = var4 * 765 + var5;
                     if(class62.field1289.field178[var3] == -1 && class62.field1289.field179[var3] == -1) {
                        var5 = -1;
                        var4 = -1;
                        var6 = 524287;
                     }

                     if(var5 == client.field371 && client.field529 == var4) {
                        if(client.field286 < 2047) {
                           ++client.field286;
                        }
                     } else {
                        var7 = var5 - client.field371;
                        client.field371 = var5;
                        var8 = var4 - client.field529;
                        client.field529 = var4;
                        if(client.field286 < 8 && var7 >= -32 && var7 <= 31 && var8 >= -32 && var8 <= 31) {
                           var7 += 32;
                           var8 += 32;
                           client.field313.method2558((client.field286 << 12) + (var7 << 6) + var8);
                           client.field286 = 0;
                        } else if(client.field286 < 8) {
                           client.field313.method2559(8388608 + (client.field286 << 19) + var6);
                           client.field286 = 0;
                        } else {
                           client.field313.method2560(var6 + -1073741824 + (client.field286 << 19));
                           client.field286 = 0;
                        }
                     }
                  }

                  client.field313.method2701(client.field313.field2045 - var1);
                  if(var2 >= class62.field1289.field185) {
                     class62.field1289.field185 = 0;
                  } else {
                     class62.field1289.field185 -= var2;

                     for(var3 = 0; var3 < class62.field1289.field185; ++var3) {
                        class62.field1289.field179[var3] = class62.field1289.field179[var3 + var2];
                        class62.field1289.field178[var3] = class62.field1289.field178[var2 + var3];
                     }
                  }
               }
            }

            if(class143.field2224 == 1 || !class17.field235 && class143.field2224 == 4 || class143.field2224 == 2) {
               long var23 = (class143.field2208 - client.field539) / 50L;
               if(var23 > 4095L) {
                  var23 = 4095L;
               }

               client.field539 = class143.field2208;
               var2 = class143.field2222;
               if(var2 < 0) {
                  var2 = 0;
               } else if(var2 > class19.field264) {
                  var2 = class19.field264;
               }

               var3 = class143.field2220;
               if(var3 < 0) {
                  var3 = 0;
               } else if(var3 > class12.field174) {
                  var3 = class12.field174;
               }

               var4 = (int)var23;
               client.field313.method2797(21);
               client.field313.method2558((var4 << 1) + (class143.field2224 == 2?1:0));
               client.field313.method2558(var3);
               client.field313.method2558(var2);
            }

            if(class140.field2181 > 0) {
               client.field313.method2797(141);
               client.field313.method2558(0);
               var0 = client.field313.field2045;
               long var24 = class193.method3805();

               for(var3 = 0; var3 < class140.field2181; ++var3) {
                  long var26 = var24 - client.field496;
                  if(var26 > 16777215L) {
                     var26 = 16777215L;
                  }

                  client.field496 = var24;
                  client.field313.method2557(class140.field2178[var3]);
                  client.field313.method2587((int)var26);
               }

               client.field313.method2568(client.field313.field2045 - var0);
            }

            if(client.field363 > 0) {
               --client.field363;
            }

            if(class140.field2186[96] || class140.field2186[97] || class140.field2186[98] || class140.field2186[99]) {
               client.field432 = true;
            }

            if(client.field432 && client.field363 <= 0) {
               client.field363 = 20;
               client.field432 = false;
               client.field313.method2797(233);
               client.field313.method2605(client.field357);
               client.field313.method2567(client.field356);
            }

            if(class125.field2070 && !client.field287) {
               client.field287 = true;
               client.field313.method2797(2);
               client.field313.method2557(1);
            }

            if(!class125.field2070 && client.field287) {
               client.field287 = false;
               client.field313.method2797(2);
               client.field313.method2557(0);
            }

            class27.method644();
            if(client.field280 == 30) {
               class12.method149();

               for(var0 = 0; var0 < client.field274; ++var0) {
                  --client.field434[var0];
                  if(client.field434[var0] >= -10) {
                     class61 var13 = client.field450[var0];
                     if(null == var13) {
                        Object var10000 = null;
                        var13 = class61.method1324(class127.field2083, client.field513[var0], 0);
                        if(null == var13) {
                           continue;
                        }

                        client.field434[var0] += var13.method1320();
                        client.field450[var0] = var13;
                     }

                     if(client.field434[var0] < 0) {
                        if(client.field288[var0] != 0) {
                           var3 = 128 * (client.field288[var0] & 255);
                           var4 = client.field288[var0] >> 16 & 255;
                           var5 = 128 * var4 + 64 - class114.field2010.field864;
                           if(var5 < 0) {
                              var5 = -var5;
                           }

                           var6 = client.field288[var0] >> 8 & 255;
                           var7 = 64 + 128 * var6 - class114.field2010.field831;
                           if(var7 < 0) {
                              var7 = -var7;
                           }

                           var8 = var5 + var7 - 128;
                           if(var8 > var3) {
                              client.field434[var0] = -100;
                              continue;
                           }

                           if(var8 < 0) {
                              var8 = 0;
                           }

                           var2 = client.field511 * (var3 - var8) / var3;
                        } else {
                           var2 = client.field510;
                        }

                        if(var2 > 0) {
                           class65 var14 = var13.method1319().method1365(class31.field718);
                           class67 var15 = class67.method1416(var14, 100, var2);
                           var15.method1392(client.field346[var0] - 1);
                           class18.field254.method1204(var15);
                        }

                        client.field434[var0] = -100;
                     }
                  } else {
                     --client.field274;

                     for(var1 = var0; var1 < client.field274; ++var1) {
                        client.field513[var1] = client.field513[var1 + 1];
                        client.field450[var1] = client.field450[1 + var1];
                        client.field346[var1] = client.field346[var1 + 1];
                        client.field434[var1] = client.field434[var1 + 1];
                        client.field288[var1] = client.field288[1 + var1];
                     }

                     --var0;
                  }
               }

               if(client.field532 && !class152.method3188()) {
                  if(client.field507 != 0 && client.field443 != -1) {
                     class153.method3190(class38.field814, client.field443, 0, client.field507, false);
                  }

                  client.field532 = false;
               }

               ++client.field318;
               if(client.field318 > 750) {
                  if(client.field323 > 0) {
                     class15.method178();
                  } else {
                     class171.method3414(40);
                     class177.field2937 = class38.field829;
                     class38.field829 = null;
                  }

               } else {
                  var0 = class34.field777;
                  int[] var33 = class34.field780;

                  for(var2 = 0; var2 < var0; ++var2) {
                     class2 var34 = client.field393[var33[var2]];
                     if(var34 != null) {
                        class134.method2900(var34, 1);
                     }
                  }

                  for(var0 = 0; var0 < client.field394; ++var0) {
                     var1 = client.field310[var0];
                     class36 var16 = client.field308[var1];
                     if(var16 != null) {
                        class134.method2900(var16, var16.field802.field906);
                     }
                  }

                  int[] var31 = class34.field780;

                  for(var1 = 0; var1 < class34.field777; ++var1) {
                     class2 var39 = client.field393[var31[var1]];
                     if(null != var39 && var39.field890 > 0) {
                        --var39.field890;
                        if(var39.field890 == 0) {
                           var39.field843 = null;
                        }
                     }
                  }

                  for(var1 = 0; var1 < client.field394; ++var1) {
                     var2 = client.field310[var1];
                     class36 var36 = client.field308[var2];
                     if(null != var36 && var36.field890 > 0) {
                        --var36.field890;
                        if(var36.field890 == 0) {
                           var36.field843 = null;
                        }
                     }
                  }

                  ++client.field329;
                  if(client.field383 != 0) {
                     client.field423 += 20;
                     if(client.field423 >= 400) {
                        client.field383 = 0;
                     }
                  }

                  if(null != class97.field1673) {
                     ++client.field488;
                     if(client.field488 >= 15) {
                        class92.method2164(class97.field1673);
                        class97.field1673 = null;
                     }
                  }

                  class176 var32 = class15.field197;
                  class176 var35 = class27.field642;
                  class15.field197 = null;
                  class27.field642 = null;
                  client.field447 = null;
                  client.field451 = false;
                  client.field448 = false;
                  client.field493 = 0;

                  while(class0.method0() && client.field493 < 128) {
                     if(client.field409 >= 2 && class140.field2186[82] && class139.field2152 == 66) {
                        String var41 = class51.method1097();
                        class4.field73.setContents(new StringSelection(var41), (ClipboardOwner)null);
                     } else {
                        client.field278[client.field493] = class139.field2152;
                        client.field319[client.field493] = class48.field1079;
                        ++client.field493;
                     }
                  }

                  if(client.field430 != -1) {
                     class143.method3030(client.field430, 0, 0, class12.field174, class19.field264, 0, 0);
                  }

                  ++client.field455;

                  while(true) {
                     class176 var37;
                     class176 var38;
                     class0 var43;
                     do {
                        var43 = (class0)client.field470.method3880();
                        if(null == var43) {
                           while(true) {
                              do {
                                 var43 = (class0)client.field382.method3880();
                                 if(var43 == null) {
                                    while(true) {
                                       do {
                                          var43 = (class0)client.field327.method3880();
                                          if(var43 == null) {
                                             boolean var25 = false;

                                             while(!var25) {
                                                var25 = true;

                                                for(var3 = 0; var3 < client.field412 - 1; ++var3) {
                                                   if(client.field415[var3] < 1000 && client.field415[var3 + 1] > 1000) {
                                                      String var40 = client.field328[var3];
                                                      client.field328[var3] = client.field328[var3 + 1];
                                                      client.field328[1 + var3] = var40;
                                                      String var17 = client.field417[var3];
                                                      client.field417[var3] = client.field417[1 + var3];
                                                      client.field417[1 + var3] = var17;
                                                      var6 = client.field415[var3];
                                                      client.field415[var3] = client.field415[var3 + 1];
                                                      client.field415[var3 + 1] = var6;
                                                      var6 = client.field294[var3];
                                                      client.field294[var3] = client.field294[1 + var3];
                                                      client.field294[var3 + 1] = var6;
                                                      var6 = client.field414[var3];
                                                      client.field414[var3] = client.field414[var3 + 1];
                                                      client.field414[1 + var3] = var6;
                                                      var6 = client.field322[var3];
                                                      client.field322[var3] = client.field322[var3 + 1];
                                                      client.field322[var3 + 1] = var6;
                                                      var25 = false;
                                                   }
                                                }
                                             }

                                             int var10;
                                             int var18;
                                             if(null == class30.field701 && null == client.field540) {
                                                var2 = class143.field2224;
                                                if(client.field517) {
                                                   if(var2 != 1 && (class17.field235 || var2 != 4)) {
                                                      var3 = class143.field2213;
                                                      var4 = class143.field2214;
                                                      if(var3 < class163.field2699 - 10 || var3 > class163.field2699 + class23.field600 + 10 || var4 < class130.field2099 - 10 || var4 > class130.field2099 + class34.field788 + 10) {
                                                         client.field517 = false;
                                                         method101(class163.field2699, class130.field2099, class23.field600, class34.field788);
                                                      }
                                                   }

                                                   if(var2 == 1 || !class17.field235 && var2 == 4) {
                                                      var3 = class163.field2699;
                                                      var4 = class130.field2099;
                                                      var5 = class23.field600;
                                                      var6 = class143.field2220;
                                                      var7 = class143.field2222;
                                                      var8 = -1;

                                                      for(var18 = 0; var18 < client.field412; ++var18) {
                                                         var10 = 31 + var4 + (client.field412 - 1 - var18) * 15;
                                                         if(var6 > var3 && var6 < var5 + var3 && var7 > var10 - 13 && var7 < var10 + 3) {
                                                            var8 = var18;
                                                         }
                                                      }

                                                      if(var8 != -1) {
                                                         class92.method2161(var8);
                                                      }

                                                      client.field517 = false;
                                                      method101(class163.field2699, class130.field2099, class23.field600, class34.field788);
                                                   }
                                                } else {
                                                   label1470: {
                                                      if((var2 == 1 || !class17.field235 && var2 == 4) && client.field412 > 0) {
                                                         var3 = client.field415[client.field412 - 1];
                                                         if(var3 == 39 || var3 == 40 || var3 == 41 || var3 == 42 || var3 == 43 || var3 == 33 || var3 == 34 || var3 == 35 || var3 == 36 || var3 == 37 || var3 == 38 || var3 == 1005) {
                                                            label1450: {
                                                               var4 = client.field294[client.field412 - 1];
                                                               var5 = client.field414[client.field412 - 1];
                                                               class176 var19 = class34.method720(var5);
                                                               var8 = class12.method151(var19);
                                                               boolean var27 = (var8 >> 28 & 1) != 0;
                                                               if(!var27) {
                                                                  var10 = class12.method151(var19);
                                                                  boolean var45 = (var10 >> 29 & 1) != 0;
                                                                  if(!var45) {
                                                                     break label1450;
                                                                  }
                                                               }

                                                               if(class30.field701 != null && !client.field340 && client.field528 != 1 && !class42.method882(client.field412 - 1) && client.field412 > 0) {
                                                                  class99.method2278(client.field387, client.field388);
                                                               }

                                                               client.field340 = false;
                                                               client.field391 = 0;
                                                               if(class30.field701 != null) {
                                                                  class92.method2164(class30.field701);
                                                               }

                                                               class30.field701 = class34.method720(var5);
                                                               client.field386 = var4;
                                                               client.field387 = class143.field2220;
                                                               client.field388 = class143.field2222;
                                                               if(client.field412 > 0) {
                                                                  var18 = client.field412 - 1;
                                                                  class221.field3214 = new class32();
                                                                  class221.field3214.field725 = client.field294[var18];
                                                                  class221.field3214.field720 = client.field414[var18];
                                                                  class221.field3214.field722 = client.field415[var18];
                                                                  class221.field3214.field724 = client.field322[var18];
                                                                  class221.field3214.field723 = client.field417[var18];
                                                               }

                                                               class92.method2164(class30.field701);
                                                               break label1470;
                                                            }
                                                         }
                                                      }

                                                      if((var2 == 1 || !class17.field235 && var2 == 4) && (client.field528 == 1 && client.field412 > 2 || class42.method882(client.field412 - 1))) {
                                                         var2 = 2;
                                                      }

                                                      if((var2 == 1 || !class17.field235 && var2 == 4) && client.field412 > 0) {
                                                         var3 = client.field412 - 1;
                                                         if(var3 >= 0) {
                                                            var4 = client.field294[var3];
                                                            var5 = client.field414[var3];
                                                            var6 = client.field415[var3];
                                                            var7 = client.field322[var3];
                                                            String var20 = client.field417[var3];
                                                            String var9 = client.field328[var3];
                                                            class35.method729(var4, var5, var6, var7, var20, var9, class143.field2220, class143.field2222);
                                                         }
                                                      }

                                                      if(var2 == 2 && client.field412 > 0) {
                                                         class24.method592(class143.field2220, class143.field2222);
                                                      }
                                                   }
                                                }
                                             }

                                             if(client.field540 != null) {
                                                class92.method2164(client.field540);
                                                ++class77.field1444;
                                                if(client.field451 && client.field448) {
                                                   var2 = class143.field2213;
                                                   var3 = class143.field2214;
                                                   var2 -= client.field445;
                                                   var3 -= client.field446;
                                                   if(var2 < client.field449) {
                                                      var2 = client.field449;
                                                   }

                                                   if(var2 + client.field540.field2926 > client.field352.field2926 + client.field449) {
                                                      var2 = client.field449 + client.field352.field2926 - client.field540.field2926;
                                                   }

                                                   if(var3 < client.field515) {
                                                      var3 = client.field515;
                                                   }

                                                   if(var3 + client.field540.field2877 > client.field515 + client.field352.field2877) {
                                                      var3 = client.field515 + client.field352.field2877 - client.field540.field2877;
                                                   }

                                                   var4 = var2 - client.field452;
                                                   var5 = var3 - client.field453;
                                                   var6 = client.field540.field2825;
                                                   if(class77.field1444 > client.field540.field2797 && (var4 > var6 || var4 < -var6 || var5 > var6 || var5 < -var6)) {
                                                      client.field454 = true;
                                                   }

                                                   var7 = client.field352.field2894 + (var2 - client.field449);
                                                   var8 = client.field352.field2817 + (var3 - client.field515);
                                                   class0 var28;
                                                   if(null != client.field540.field2842 && client.field454) {
                                                      var28 = new class0();
                                                      var28.field3 = client.field540;
                                                      var28.field0 = var7;
                                                      var28.field4 = var8;
                                                      var28.field1 = client.field540.field2842;
                                                      class43.method884(var28, 200000);
                                                   }

                                                   if(class143.field2216 == 0) {
                                                      if(client.field454) {
                                                         if(null != client.field540.field2885) {
                                                            var28 = new class0();
                                                            var28.field3 = client.field540;
                                                            var28.field0 = var7;
                                                            var28.field4 = var8;
                                                            var28.field2 = client.field447;
                                                            var28.field1 = client.field540.field2885;
                                                            class43.method884(var28, 200000);
                                                         }

                                                         if(client.field447 != null && class158.method3213(client.field540) != null) {
                                                            client.field313.method2797(72);
                                                            client.field313.method2603(client.field540.field2834);
                                                            client.field313.method2558(client.field540.field2796);
                                                            client.field313.method2605(client.field447.field2796);
                                                            client.field313.method2560(client.field447.field2795);
                                                            client.field313.method2560(client.field540.field2795);
                                                            client.field313.method2558(client.field447.field2834);
                                                         }
                                                      } else if((client.field528 == 1 || class42.method882(client.field412 - 1)) && client.field412 > 2) {
                                                         class24.method592(client.field452 + client.field445, client.field453 + client.field446);
                                                      } else if(client.field412 > 0) {
                                                         class99.method2278(client.field452 + client.field445, client.field453 + client.field446);
                                                      }

                                                      client.field540 = null;
                                                   }
                                                } else if(class77.field1444 > 1) {
                                                   client.field540 = null;
                                                }
                                             }

                                             if(class30.field701 != null) {
                                                class92.method2164(class30.field701);
                                                ++client.field391;
                                                if(class143.field2216 == 0) {
                                                   if(client.field340) {
                                                      if(class36.field801 == class30.field701 && client.field386 != client.field389) {
                                                         class176 var44 = class30.field701;
                                                         byte var30 = 0;
                                                         if(client.field433 == 1 && var44.field2799 == 206) {
                                                            var30 = 1;
                                                         }

                                                         if(var44.field2869[client.field389] <= 0) {
                                                            var30 = 0;
                                                         }

                                                         var5 = class12.method151(var44);
                                                         boolean var29 = (var5 >> 29 & 1) != 0;
                                                         if(var29) {
                                                            var6 = client.field386;
                                                            var7 = client.field389;
                                                            var44.field2869[var7] = var44.field2869[var6];
                                                            var44.field2830[var7] = var44.field2830[var6];
                                                            var44.field2869[var6] = -1;
                                                            var44.field2830[var6] = 0;
                                                         } else if(var30 == 1) {
                                                            var6 = client.field386;
                                                            var7 = client.field389;

                                                            while(var6 != var7) {
                                                               if(var6 > var7) {
                                                                  var44.method3448(var6 - 1, var6);
                                                                  --var6;
                                                               } else if(var6 < var7) {
                                                                  var44.method3448(1 + var6, var6);
                                                                  ++var6;
                                                               }
                                                            }
                                                         } else {
                                                            var44.method3448(client.field389, client.field386);
                                                         }

                                                         client.field313.method2797(54);
                                                         client.field313.method2567(client.field389);
                                                         client.field313.method2595(var30);
                                                         client.field313.method2605(client.field386);
                                                         client.field313.method2560(class30.field701.field2795);
                                                      }
                                                   } else if((client.field528 == 1 || class42.method882(client.field412 - 1)) && client.field412 > 2) {
                                                      class24.method592(client.field387, client.field388);
                                                   } else if(client.field412 > 0) {
                                                      class99.method2278(client.field387, client.field388);
                                                   }

                                                   client.field488 = 10;
                                                   class143.field2224 = 0;
                                                   class30.field701 = null;
                                                } else if(client.field391 >= 5 && (class143.field2213 > 5 + client.field387 || class143.field2213 < client.field387 - 5 || class143.field2214 > 5 + client.field388 || class143.field2214 < client.field388 - 5)) {
                                                   client.field340 = true;
                                                }
                                             }

                                             if(class89.field1572 != -1) {
                                                var2 = class89.field1572;
                                                var3 = class89.field1573;
                                                client.field313.method2797(139);
                                                client.field313.method2557(5);
                                                client.field313.method2605(class13.field184 + var3);
                                                client.field313.method2596(class140.field2186[82]?(class140.field2186[81]?2:1):0);
                                                client.field313.method2605(var2 + class39.field838);
                                                class89.field1572 = -1;
                                                client.field380 = class143.field2220;
                                                client.field351 = class143.field2222;
                                                client.field383 = 1;
                                                client.field423 = 0;
                                                client.field504 = var2;
                                                client.field464 = var3;
                                             }

                                             if(class15.field197 != var32) {
                                                if(var32 != null) {
                                                   class92.method2164(var32);
                                                }

                                                if(class15.field197 != null) {
                                                   class92.method2164(class15.field197);
                                                }
                                             }

                                             if(class27.field642 != var35 && client.field422 == client.field390) {
                                                if(null != var35) {
                                                   class92.method2164(var35);
                                                }

                                                if(class27.field642 != null) {
                                                   class92.method2164(class27.field642);
                                                }
                                             }

                                             if(null != class27.field642) {
                                                if(client.field390 < client.field422) {
                                                   ++client.field390;
                                                   if(client.field390 == client.field422) {
                                                      class92.method2164(class27.field642);
                                                   }
                                                }
                                             } else if(client.field390 > 0) {
                                                --client.field390;
                                             }

                                             var2 = client.field341 + class114.field2010.field864;
                                             var3 = class114.field2010.field831 + client.field337;
                                             if(class85.field1505 - var2 < -500 || class85.field1505 - var2 > 500 || class166.field2710 - var3 < -500 || class166.field2710 - var3 > 500) {
                                                class85.field1505 = var2;
                                                class166.field2710 = var3;
                                             }

                                             if(var2 != class85.field1505) {
                                                class85.field1505 += (var2 - class85.field1505) / 16;
                                             }

                                             if(var3 != class166.field2710) {
                                                class166.field2710 += (var3 - class166.field2710) / 16;
                                             }

                                             if(class143.field2216 == 4 && class17.field235) {
                                                var4 = class143.field2214 - client.field361;
                                                client.field475 = var4 * 2;
                                                client.field361 = var4 != -1 && var4 != 1?(class143.field2214 + client.field361) / 2:class143.field2214;
                                                var5 = client.field471 - class143.field2213;
                                                client.field358 = var5 * 2;
                                                client.field471 = var5 != -1 && var5 != 1?(client.field471 + class143.field2213) / 2:class143.field2213;
                                             } else {
                                                if(class140.field2186[96]) {
                                                   client.field358 += (-24 - client.field358) / 2;
                                                } else if(class140.field2186[97]) {
                                                   client.field358 += (24 - client.field358) / 2;
                                                } else {
                                                   client.field358 /= 2;
                                                }

                                                if(class140.field2186[98]) {
                                                   client.field475 += (12 - client.field475) / 2;
                                                } else if(class140.field2186[99]) {
                                                   client.field475 += (-12 - client.field475) / 2;
                                                } else {
                                                   client.field475 /= 2;
                                                }

                                                client.field361 = class143.field2214;
                                                client.field471 = class143.field2213;
                                             }

                                             client.field357 = client.field358 / 2 + client.field357 & 2047;
                                             client.field356 += client.field475 / 2;
                                             if(client.field356 < 128) {
                                                client.field356 = 128;
                                             }

                                             if(client.field356 > 383) {
                                                client.field356 = 383;
                                             }

                                             var4 = class85.field1505 >> 7;
                                             var5 = class166.field2710 >> 7;
                                             var6 = class15.method163(class85.field1505, class166.field2710, class51.field1119);
                                             var7 = 0;
                                             if(var4 > 3 && var5 > 3 && var4 < 100 && var5 < 100) {
                                                for(var8 = var4 - 4; var8 <= 4 + var4; ++var8) {
                                                   for(var18 = var5 - 4; var18 <= var5 + 4; ++var18) {
                                                      var10 = class51.field1119;
                                                      if(var10 < 3 && (class5.field78[1][var8][var18] & 2) == 2) {
                                                         ++var10;
                                                      }

                                                      int var11 = var6 - class5.field77[var10][var8][var18];
                                                      if(var11 > var7) {
                                                         var7 = var11;
                                                      }
                                                   }
                                                }
                                             }

                                             var8 = 192 * var7;
                                             if(var8 > 98048) {
                                                var8 = 98048;
                                             }

                                             if(var8 < '耀') {
                                                var8 = '耀';
                                             }

                                             if(var8 > client.field365) {
                                                client.field365 += (var8 - client.field365) / 24;
                                             } else if(var8 < client.field365) {
                                                client.field365 += (var8 - client.field365) / 80;
                                             }

                                             if(client.field518) {
                                                class138.method2928();
                                             }

                                             for(var2 = 0; var2 < 5; ++var2) {
                                                ++client.field523[var2];
                                             }

                                             class33.field764.method204();
                                             var2 = class98.method2275();
                                             var3 = class50.method1046();
                                             if(var2 > 15000 && var3 > 15000) {
                                                client.field323 = 250;
                                                class143.field2221 = 14500;
                                                client.field313.method2797(227);
                                             }

                                             ++client.field381;
                                             if(client.field381 > 500) {
                                                client.field381 = 0;
                                                var4 = (int)(Math.random() * 8.0D);
                                                if((var4 & 1) == 1) {
                                                   client.field341 += client.field545;
                                                }

                                                if((var4 & 2) == 2) {
                                                   client.field337 += client.field285;
                                                }

                                                if((var4 & 4) == 4) {
                                                   client.field339 += client.field368;
                                                }
                                             }

                                             if(client.field341 < -50) {
                                                client.field545 = 2;
                                             }

                                             if(client.field341 > 50) {
                                                client.field545 = -2;
                                             }

                                             if(client.field337 < -55) {
                                                client.field285 = 2;
                                             }

                                             if(client.field337 > 55) {
                                                client.field285 = -2;
                                             }

                                             if(client.field339 < -40) {
                                                client.field368 = 1;
                                             }

                                             if(client.field339 > 40) {
                                                client.field368 = -1;
                                             }

                                             ++client.field499;
                                             if(client.field499 > 500) {
                                                client.field499 = 0;
                                                var4 = (int)(Math.random() * 8.0D);
                                                if((var4 & 1) == 1) {
                                                   client.field342 += client.field421;
                                                }

                                                if((var4 & 2) == 2) {
                                                   client.field484 += client.field345;
                                                }
                                             }

                                             if(client.field342 < -60) {
                                                client.field421 = 2;
                                             }

                                             if(client.field342 > 60) {
                                                client.field421 = -2;
                                             }

                                             if(client.field484 < -20) {
                                                client.field345 = 1;
                                             }

                                             if(client.field484 > 10) {
                                                client.field345 = -1;
                                             }

                                             for(class40 var42 = (class40)client.field401.method3841(); var42 != null; var42 = (class40)client.field401.method3842()) {
                                                if((long)var42.field893 < class193.method3805() / 1000L - 5L) {
                                                   if(var42.field898 > 0) {
                                                      class59.method1304(5, "", var42.field894 + " has logged in.");
                                                   }

                                                   if(var42.field898 == 0) {
                                                      class59.method1304(5, "", var42.field894 + " has logged out.");
                                                   }

                                                   var42.method3984();
                                                }
                                             }

                                             ++client.field362;
                                             if(client.field362 > 50) {
                                                client.field313.method2797(132);
                                             }

                                             try {
                                                if(class38.field829 != null && client.field313.field2045 > 0) {
                                                   class38.field829.method3045(client.field313.field2047, 0, client.field313.field2045);
                                                   client.field313.field2045 = 0;
                                                   client.field362 = 0;
                                                }
                                             } catch (IOException var21) {
                                                if(client.field323 > 0) {
                                                   class15.method178();
                                                } else {
                                                   class171.method3414(40);
                                                   class177.field2937 = class38.field829;
                                                   class38.field829 = null;
                                                }
                                             }

                                             return;
                                          }

                                          var37 = var43.field3;
                                          if(var37.field2796 < 0) {
                                             break;
                                          }

                                          var38 = class34.method720(var37.field2836);
                                       } while(var38 == null || null == var38.field2919 || var37.field2796 >= var38.field2919.length || var38.field2919[var37.field2796] != var37);

                                       class43.method884(var43, 200000);
                                    }
                                 }

                                 var37 = var43.field3;
                                 if(var37.field2796 < 0) {
                                    break;
                                 }

                                 var38 = class34.method720(var37.field2836);
                              } while(null == var38 || var38.field2919 == null || var37.field2796 >= var38.field2919.length || var37 != var38.field2919[var37.field2796]);

                              class43.method884(var43, 200000);
                           }
                        }

                        var37 = var43.field3;
                        if(var37.field2796 < 0) {
                           break;
                        }

                        var38 = class34.method720(var37.field2836);
                     } while(var38 == null || var38.field2919 == null || var37.field2796 >= var38.field2919.length || var37 != var38.field2919[var37.field2796]);

                     class43.method884(var43, 200000);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lclass42;",
      garbageValue = "471713872"
   )
   @Export("getObjectDefinition")
   public static class42 method100(int var0) {
      class42 var1 = (class42)class42.field944.method3817((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class221.field3212.method3304(6, var0);
         var1 = new class42();
         var1.field949 = var0;
         if(null != var2) {
            var1.method831(new class122(var2));
         }

         var1.method837();
         if(var1.field957) {
            var1.field959 = 0;
            var1.field960 = false;
         }

         class42.field944.method3823(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-33"
   )
   static final void method101(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < client.field413; ++var4) {
         if(client.field478[var4] + client.field359[var4] > var0 && client.field478[var4] < var2 + var0 && client.field479[var4] + client.field495[var4] > var1 && client.field479[var4] < var1 + var3) {
            client.field460[var4] = true;
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1873217033"
   )
   static void method102() {
      int var0 = class147.field2262;
      int var1 = class147.field2263;
      int var2 = class128.field2092 - class12.field174 - var0;
      int var3 = class112.field1962 - class19.field264 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = client.field270.method3103();
            int var5 = 0;
            int var6 = 0;
            if(var4 == class39.field835) {
               Insets var7 = class39.field835.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class112.field1962);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class128.field2092, var1);
            }

            if(var2 > 0) {
               var9.fillRect(class128.field2092 + var5 - var2, var6, var2, class112.field1962);
            }

            if(var3 > 0) {
               var9.fillRect(var5, var6 + class112.field1962 - var3, class128.field2092, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lclass50;",
      garbageValue = "-2064045586"
   )
   public static class50 method103(int var0) {
      class50 var1 = (class50)class50.field1105.method3817((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class50.field1108.method3304(14, var0);
         var1 = new class50();
         if(var2 != null) {
            var1.method1049(new class122(var2));
         }

         class50.field1105.method3823(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIS)I",
      garbageValue = "256"
   )
   static final int method104(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = var2 / 2 + (var0 / 4 << 10) + (var1 / 32 << 7);
      return var3;
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "89"
   )
   static final void method105(int var0, int var1, int var2, int var3) {
      if(client.field531 == 0 && !client.field444) {
         class98.method2276("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < class108.field1919; ++var6) {
         var7 = class108.field1910[var6];
         int var18 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var5 != var7) {
            var5 = var7;
            if(var10 == 2 && class5.field91.method2028(class51.field1119, var18, var9, var7) >= 0) {
               class42 var12 = method100(var11);
               if(null != var12.field983) {
                  var12 = var12.method851();
               }

               if(null == var12) {
                  continue;
               }

               if(client.field531 == 1) {
                  class98.method2276("Use", client.field424 + " " + "->" + " " + class51.method1096('\uffff') + var12.field952, 1, var7, var18, var9);
               } else if(client.field444) {
                  if((class116.field2016 & 4) == 4) {
                     class98.method2276(client.field428, client.field438 + " " + "->" + " " + class51.method1096('\uffff') + var12.field952, 2, var7, var18, var9);
                  }
               } else {
                  String[] var13 = var12.field973;
                  if(client.field441) {
                     var13 = class87.method1983(var13);
                  }

                  if(null != var13) {
                     for(int var22 = 4; var22 >= 0; --var22) {
                        if(var13[var22] != null) {
                           short var15 = 0;
                           if(var22 == 0) {
                              var15 = 3;
                           }

                           if(var22 == 1) {
                              var15 = 4;
                           }

                           if(var22 == 2) {
                              var15 = 5;
                           }

                           if(var22 == 3) {
                              var15 = 6;
                           }

                           if(var22 == 4) {
                              var15 = 1001;
                           }

                           class98.method2276(var13[var22], class51.method1096('\uffff') + var12.field952, var15, var7, var18, var9);
                        }
                     }
                  }

                  class98.method2276("Examine", class51.method1096('\uffff') + var12.field952, 1002, var12.field949 << 14, var18, var9);
               }
            }

            class36 var14;
            class2 var16;
            int var19;
            int[] var27;
            int var29;
            if(var10 == 1) {
               class36 var23 = client.field308[var11];
               if(var23 == null) {
                  continue;
               }

               if(var23.field802.field906 == 1 && (var23.field864 & 127) == 64 && (var23.field831 & 127) == 64) {
                  for(var19 = 0; var19 < client.field394; ++var19) {
                     var14 = client.field308[client.field310[var19]];
                     if(null != var14 && var14 != var23 && var14.field802.field906 == 1 && var14.field864 == var23.field864 && var14.field831 == var23.field831) {
                        class213.method4003(var14.field802, client.field310[var19], var18, var9);
                     }
                  }

                  var19 = class34.field777;
                  var27 = class34.field780;

                  for(var29 = 0; var29 < var19; ++var29) {
                     var16 = client.field393[var27[var29]];
                     if(var16 != null && var23.field864 == var16.field864 && var23.field831 == var16.field831) {
                        class18.method188(var16, var27[var29], var18, var9);
                     }
                  }
               }

               class213.method4003(var23.field802, var11, var18, var9);
            }

            if(var10 == 0) {
               class2 var24 = client.field393[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.field864 & 127) == 64 && (var24.field831 & 127) == 64) {
                  for(var19 = 0; var19 < client.field394; ++var19) {
                     var14 = client.field308[client.field310[var19]];
                     if(var14 != null && var14.field802.field906 == 1 && var14.field864 == var24.field864 && var24.field831 == var14.field831) {
                        class213.method4003(var14.field802, client.field310[var19], var18, var9);
                     }
                  }

                  var19 = class34.field777;
                  var27 = class34.field780;

                  for(var29 = 0; var29 < var19; ++var29) {
                     var16 = client.field393[var27[var29]];
                     if(null != var16 && var16 != var24 && var24.field864 == var16.field864 && var16.field831 == var24.field831) {
                        class18.method188(var16, var27[var29], var18, var9);
                     }
                  }
               }

               if(client.field344 != var11) {
                  class18.method188(var24, var11, var18, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               class202 var25 = client.field403[class51.field1119][var18][var9];
               if(var25 != null) {
                  for(class30 var26 = (class30)var25.method3883(); var26 != null; var26 = (class30)var25.method3898()) {
                     class55 var28 = class4.method42(var26.field699);
                     if(client.field531 == 1) {
                        class98.method2276("Use", client.field424 + " " + "->" + " " + class51.method1096(16748608) + var28.field1183, 16, var26.field699, var18, var9);
                     } else if(client.field444) {
                        if((class116.field2016 & 1) == 1) {
                           class98.method2276(client.field428, client.field438 + " " + "->" + " " + class51.method1096(16748608) + var28.field1183, 17, var26.field699, var18, var9);
                        }
                     } else {
                        String[] var20 = var28.field1197;
                        if(client.field441) {
                           var20 = class87.method1983(var20);
                        }

                        for(int var21 = 4; var21 >= 0; --var21) {
                           if(null != var20 && null != var20[var21]) {
                              byte var17 = 0;
                              if(var21 == 0) {
                                 var17 = 18;
                              }

                              if(var21 == 1) {
                                 var17 = 19;
                              }

                              if(var21 == 2) {
                                 var17 = 20;
                              }

                              if(var21 == 3) {
                                 var17 = 21;
                              }

                              if(var21 == 4) {
                                 var17 = 22;
                              }

                              class98.method2276(var20[var21], class51.method1096(16748608) + var28.field1183, var17, var26.field699, var18, var9);
                           } else if(var21 == 2) {
                              class98.method2276("Take", class51.method1096(16748608) + var28.field1183, 20, var26.field699, var18, var9);
                           }
                        }

                        class98.method2276("Examine", class51.method1096(16748608) + var28.field1183, 1004, var26.field699, var18, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         class2 var8 = client.field393[client.field344];
         class18.method188(var8, client.field344, var6, var7);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-183899741"
   )
   public static String method106(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class168.field2720[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }
}
