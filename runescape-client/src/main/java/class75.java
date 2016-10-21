import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
public class class75 implements Runnable {
   @ObfuscatedName("e")
   volatile class59[] field1394 = new class59[2];
   @ObfuscatedName("n")
   volatile boolean field1396 = false;
   @ObfuscatedName("t")
   volatile boolean field1397 = false;
   @ObfuscatedName("d")
   static String[] field1398;
   @ObfuscatedName("f")
   class139 field1399;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -785498129
   )
   static int field1401;

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "697660776"
   )
   static void method1623(int var0, int var1) {
      Client.field397.method2768(105);
      Client.field397.method2574(var0);
      Client.field397.method2567(var1);
   }

   public void run() {
      this.field1397 = true;

      try {
         while(!this.field1396) {
            class59 var2;
            for(int var1 = 0; var1 < 2; ++var1) {
               var2 = this.field1394[var1];
               if(var2 != null) {
                  var2.method1222();
               }
            }

            class110.method2407(10L);
            class139 var5 = this.field1399;
            var2 = null;
            if(null != var5.field2141) {
               for(int var3 = 0; var3 < 50 && var5.field2141.peekEvent() != null; ++var3) {
                  class110.method2407(1L);
               }

               if(null != var2) {
                  var5.field2141.postEvent(new ActionEvent(var2, 1001, "dummy"));
               }
            }
         }
      } catch (Exception var8) {
         Frames.method2316((String)null, var8);
      } finally {
         this.field1397 = false;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "45"
   )
   public static int method1624(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2052369546"
   )
   static final void method1627() {
      if(Client.field457 > 1) {
         --Client.field457;
      }

      if(Client.field335 > 0) {
         --Client.field335;
      }

      if(Client.field336) {
         Client.field336 = false;
         class56.method1159();
      } else {
         if(!Client.isMenuOpen) {
            Client.menuOptions[0] = "Cancel";
            Client.menuTargets[0] = "";
            Client.menuTypes[0] = 1006;
            Client.menuOptionCount = 1;
         }

         int var0;
         for(var0 = 0; var0 < 100 && class1.method11(); ++var0) {
            ;
         }

         if(Client.gameState == 30) {
            while(true) {
               ClassInfo var1 = (ClassInfo)class214.field3177.method3932();
               boolean var24;
               if(null == var1) {
                  var24 = false;
               } else {
                  var24 = true;
               }

               int var13;
               if(!var24) {
                  Object var14 = class222.field3213.field199;
                  int var2;
                  int var3;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  synchronized(class222.field3213.field199) {
                     if(!Client.field280) {
                        class222.field3213.field191 = 0;
                     } else if(class143.field2198 != 0 || class222.field3213.field191 >= 40) {
                        Client.field397.method2768(149);
                        Client.field397.method2518(0);
                        var13 = Client.field397.offset;
                        var2 = 0;

                        for(var3 = 0; var3 < class222.field3213.field191 && Client.field397.offset - var13 < 240; ++var3) {
                           ++var2;
                           var4 = class222.field3213.field189[var3];
                           if(var4 < 0) {
                              var4 = 0;
                           } else if(var4 > 502) {
                              var4 = 502;
                           }

                           var5 = class222.field3213.field194[var3];
                           if(var5 < 0) {
                              var5 = 0;
                           } else if(var5 > 764) {
                              var5 = 764;
                           }

                           var6 = var5 + var4 * 765;
                           if(class222.field3213.field189[var3] == -1 && class222.field3213.field194[var3] == -1) {
                              var5 = -1;
                              var4 = -1;
                              var6 = 524287;
                           }

                           if(var5 == Client.field292 && var4 == Client.field293) {
                              if(Client.field283 < 2047) {
                                 ++Client.field283;
                              }
                           } else {
                              var7 = var5 - Client.field292;
                              Client.field292 = var5;
                              var8 = var4 - Client.field293;
                              Client.field293 = var4;
                              if(Client.field283 < 8 && var7 >= -32 && var7 <= 31 && var8 >= -32 && var8 <= 31) {
                                 var7 += 32;
                                 var8 += 32;
                                 Client.field397.method2519((var7 << 6) + (Client.field283 << 12) + var8);
                                 Client.field283 = 0;
                              } else if(Client.field283 < 8) {
                                 Client.field397.method2520(8388608 + (Client.field283 << 19) + var6);
                                 Client.field283 = 0;
                              } else {
                                 Client.field397.method2521(var6 + (Client.field283 << 19) + -1073741824);
                                 Client.field283 = 0;
                              }
                           }
                        }

                        Client.field397.method2530(Client.field397.offset - var13);
                        if(var2 >= class222.field3213.field191) {
                           class222.field3213.field191 = 0;
                        } else {
                           class222.field3213.field191 -= var2;

                           for(var3 = 0; var3 < class222.field3213.field191; ++var3) {
                              class222.field3213.field194[var3] = class222.field3213.field194[var2 + var3];
                              class222.field3213.field189[var3] = class222.field3213.field189[var3 + var2];
                           }
                        }
                     }
                  }

                  if(class143.field2198 == 1 || !ChatMessages.field276 && class143.field2198 == 4 || class143.field2198 == 2) {
                     long var26 = (class143.field2195 - Client.field291) / 50L;
                     if(var26 > 4095L) {
                        var26 = 4095L;
                     }

                     Client.field291 = class143.field2195;
                     var2 = class143.field2207;
                     if(var2 < 0) {
                        var2 = 0;
                     } else if(var2 > class93.field1616) {
                        var2 = class93.field1616;
                     }

                     var3 = class143.field2197;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > class153.field2296) {
                        var3 = class153.field2296;
                     }

                     var4 = (int)var26;
                     Client.field397.method2768(123);
                     Client.field397.method2519((var4 << 1) + (class143.field2198 == 2?1:0));
                     Client.field397.method2519(var3);
                     Client.field397.method2519(var2);
                  }

                  if(class140.field2172 > 0) {
                     Client.field397.method2768(90);
                     Client.field397.method2519(0);
                     var0 = Client.field397.offset;
                     long var30 = class11.method139();

                     for(var3 = 0; var3 < class140.field2172; ++var3) {
                        long var27 = var30 - Client.field505;
                        if(var27 > 16777215L) {
                           var27 = 16777215L;
                        }

                        Client.field505 = var30;
                        Client.field397.method2558(class140.field2171[var3]);
                        Client.field397.method2572((int)var27);
                     }

                     Client.field397.method2529(Client.field397.offset - var0);
                  }

                  if(Client.field372 > 0) {
                     --Client.field372;
                  }

                  if(class140.field2153[96] || class140.field2153[97] || class140.field2153[98] || class140.field2153[99]) {
                     Client.field373 = true;
                  }

                  if(Client.field373 && Client.field372 <= 0) {
                     Client.field372 = 20;
                     Client.field373 = false;
                     Client.field397.method2768(113);
                     Client.field397.method2519(Client.mapAngle);
                     Client.field397.method2519(Client.field365);
                  }

                  if(World.field665 && !Client.field409) {
                     Client.field409 = true;
                     Client.field397.method2768(69);
                     Client.field397.method2518(1);
                  }

                  if(!World.field665 && Client.field409) {
                     Client.field409 = false;
                     Client.field397.method2768(69);
                     Client.field397.method2518(0);
                  }

                  class4.method51();
                  if(Client.gameState != 30) {
                     return;
                  }

                  for(class16 var31 = (class16)Client.field413.method3890(); null != var31; var31 = (class16)Client.field413.method3892()) {
                     if(var31.field238 > 0) {
                        --var31.field238;
                     }

                     if(var31.field238 == 0) {
                        if(var31.field235 < 0 || SecondaryBufferProvider.method1680(var31.field235, var31.field233)) {
                           GroundObject.method2201(var31.field234, var31.field231, var31.field229, var31.field230, var31.field235, var31.field227, var31.field233);
                           var31.unlink();
                        }
                     } else {
                        if(var31.field237 > 0) {
                           --var31.field237;
                        }

                        if(var31.field237 == 0 && var31.field229 >= 1 && var31.field230 >= 1 && var31.field229 <= 102 && var31.field230 <= 102 && (var31.field228 < 0 || SecondaryBufferProvider.method1680(var31.field228, var31.field236))) {
                           GroundObject.method2201(var31.field234, var31.field231, var31.field229, var31.field230, var31.field228, var31.field239, var31.field236);
                           var31.field237 = -1;
                           if(var31.field235 == var31.field228 && var31.field235 == -1) {
                              var31.unlink();
                           } else if(var31.field235 == var31.field228 && var31.field227 == var31.field239 && var31.field233 == var31.field236) {
                              var31.unlink();
                           }
                        }
                     }
                  }

                  class85.method1935();
                  ++Client.field330;
                  if(Client.field330 > 750) {
                     class56.method1159();
                     return;
                  }

                  WidgetNode.method46();

                  for(var0 = 0; var0 < Client.field321; ++var0) {
                     var13 = Client.field405[var0];
                     NPC var15 = Client.cachedNPCs[var13];
                     if(null != var15) {
                        class129.method2835(var15, var15.composition.field894);
                     }
                  }

                  BufferProvider.method1744();
                  ++Client.field358;
                  if(Client.field392 != 0) {
                     Client.field391 += 20;
                     if(Client.field391 >= 400) {
                        Client.field392 = 0;
                     }
                  }

                  if(class79.field1439 != null) {
                     ++Client.field551;
                     if(Client.field551 >= 15) {
                        MessageNode.method750(class79.field1439);
                        class79.field1439 = null;
                     }
                  }

                  Widget var32 = class113.field1973;
                  Widget var25 = DecorativeObject.field1672;
                  class113.field1973 = null;
                  DecorativeObject.field1672 = null;
                  Client.field370 = null;
                  Client.field508 = false;
                  Client.field396 = false;
                  Client.field502 = 0;

                  while(class217.method4030() && Client.field502 < 128) {
                     if(Client.field446 >= 2 && class140.field2153[82] && class140.field2161 == 66) {
                        String var16 = "";

                        MessageNode var18;
                        for(Iterator var17 = class11.field167.iterator(); var17.hasNext(); var16 = var16 + var18.name + ':' + var18.value + '\n') {
                           var18 = (MessageNode)var17.next();
                        }

                        class8.field144.setContents(new StringSelection(var16), (ClipboardOwner)null);
                     } else {
                        Client.field504[Client.field502] = class140.field2161;
                        Client.field503[Client.field502] = class140.field2163;
                        ++Client.field502;
                     }
                  }

                  if(Client.widgetRoot != -1) {
                     var2 = Client.widgetRoot;
                     var3 = class153.field2296;
                     var4 = class93.field1616;
                     if(class171.method3404(var2)) {
                        World.method651(Widget.widgets[var2], -1, 0, 0, var3, var4, 0, 0);
                     }
                  }

                  ++Client.field295;

                  while(true) {
                     class0 var33;
                     Widget var35;
                     Widget var36;
                     do {
                        var33 = (class0)Client.field479.method3904();
                        if(null == var33) {
                           while(true) {
                              do {
                                 var33 = (class0)Client.field334.method3904();
                                 if(var33 == null) {
                                    while(true) {
                                       do {
                                          var33 = (class0)Client.field379.method3904();
                                          if(var33 == null) {
                                             class45.method934();
                                             int var11;
                                             int var19;
                                             int var20;
                                             if(Client.field452 != null) {
                                                MessageNode.method750(Client.field452);
                                                ++GameEngine.field2256;
                                                if(Client.field508 && Client.field396) {
                                                   var2 = class143.field2192;
                                                   var3 = class143.field2199;
                                                   var2 -= Client.field521;
                                                   var3 -= Client.field455;
                                                   if(var2 < Client.field400) {
                                                      var2 = Client.field400;
                                                   }

                                                   if(var2 + Client.field452.width > Client.field400 + Client.field453.width) {
                                                      var2 = Client.field453.width + Client.field400 - Client.field452.width;
                                                   }

                                                   if(var3 < Client.field459) {
                                                      var3 = Client.field459;
                                                   }

                                                   if(Client.field452.height + var3 > Client.field453.height + Client.field459) {
                                                      var3 = Client.field453.height + Client.field459 - Client.field452.height;
                                                   }

                                                   var4 = var2 - Client.field461;
                                                   var5 = var3 - Client.field462;
                                                   var6 = Client.field452.field2864;
                                                   if(GameEngine.field2256 > Client.field452.field2916 && (var4 > var6 || var4 < -var6 || var5 > var6 || var5 < -var6)) {
                                                      Client.field463 = true;
                                                   }

                                                   var7 = var2 - Client.field400 + Client.field453.itemId;
                                                   var8 = var3 - Client.field459 + Client.field453.scrollY;
                                                   class0 var9;
                                                   if(Client.field452.field2781 != null && Client.field463) {
                                                      var9 = new class0();
                                                      var9.field2 = Client.field452;
                                                      var9.field3 = var7;
                                                      var9.field5 = var8;
                                                      var9.field1 = Client.field452.field2781;
                                                      class112.method2452(var9);
                                                   }

                                                   if(class143.field2205 == 0) {
                                                      if(Client.field463) {
                                                         if(Client.field452.field2878 != null) {
                                                            var9 = new class0();
                                                            var9.field2 = Client.field452;
                                                            var9.field3 = var7;
                                                            var9.field5 = var8;
                                                            var9.field6 = Client.field370;
                                                            var9.field1 = Client.field452.field2878;
                                                            class112.method2452(var9);
                                                         }

                                                         if(Client.field370 != null) {
                                                            Widget var10 = Client.field452;
                                                            var11 = class49.method992(class93.method2130(var10));
                                                            Widget var29;
                                                            if(var11 == 0) {
                                                               var29 = null;
                                                            } else {
                                                               int var12 = 0;

                                                               while(true) {
                                                                  if(var12 >= var11) {
                                                                     var29 = var10;
                                                                     break;
                                                                  }

                                                                  var10 = class153.method3170(var10.parentId);
                                                                  if(var10 == null) {
                                                                     var29 = null;
                                                                     break;
                                                                  }

                                                                  ++var12;
                                                               }
                                                            }

                                                            if(var29 != null) {
                                                               Client.field397.method2768(161);
                                                               Client.field397.method2575(Client.field370.id);
                                                               Client.field397.method2519(Client.field452.index);
                                                               Client.field397.method2576(Client.field452.id);
                                                               Client.field397.method2516(Client.field370.index);
                                                               Client.field397.method2519(Client.field452.item);
                                                               Client.field397.method2567(Client.field370.item);
                                                            }
                                                         }
                                                      } else if((Client.field419 == 1 || class1.method12(Client.menuOptionCount - 1)) && Client.menuOptionCount > 2) {
                                                         Projectile.method89(Client.field521 + Client.field461, Client.field462 + Client.field455);
                                                      } else if(Client.menuOptionCount > 0) {
                                                         var19 = Client.field461 + Client.field521;
                                                         var20 = Client.field455 + Client.field462;
                                                         class127.method2803(class23.field603, var19, var20);
                                                         class23.field603 = null;
                                                      }

                                                      Client.field452 = null;
                                                   }
                                                } else if(GameEngine.field2256 > 1) {
                                                   Client.field452 = null;
                                                }
                                             }

                                             if(null != Projectile.field124) {
                                                MessageNode.method750(Projectile.field124);
                                                ++Client.field402;
                                                if(class143.field2205 == 0) {
                                                   if(Client.field399) {
                                                      if(Projectile.field124 == NPC.field787 && Client.field398 != Client.field395) {
                                                         Widget var34 = Projectile.field124;
                                                         byte var28 = 0;
                                                         if(Client.field549 == 1 && var34.contentType == 206) {
                                                            var28 = 1;
                                                         }

                                                         if(var34.itemIds[Client.field398] <= 0) {
                                                            var28 = 0;
                                                         }

                                                         if(ChatMessages.method231(class93.method2130(var34))) {
                                                            var4 = Client.field395;
                                                            var5 = Client.field398;
                                                            var34.itemIds[var5] = var34.itemIds[var4];
                                                            var34.itemQuantities[var5] = var34.itemQuantities[var4];
                                                            var34.itemIds[var4] = -1;
                                                            var34.itemQuantities[var4] = 0;
                                                         } else if(var28 == 1) {
                                                            var4 = Client.field395;
                                                            var5 = Client.field398;

                                                            while(var4 != var5) {
                                                               if(var4 > var5) {
                                                                  var34.method3444(var4 - 1, var4);
                                                                  --var4;
                                                               } else if(var4 < var5) {
                                                                  var34.method3444(var4 + 1, var4);
                                                                  ++var4;
                                                               }
                                                            }
                                                         } else {
                                                            var34.method3444(Client.field398, Client.field395);
                                                         }

                                                         Client.field397.method2768(143);
                                                         Client.field397.method2521(Projectile.field124.id);
                                                         Client.field397.method2516(Client.field395);
                                                         Client.field397.method2519(Client.field398);
                                                         Client.field397.method2518(var28);
                                                      }
                                                   } else if((Client.field419 == 1 || class1.method12(Client.menuOptionCount - 1)) && Client.menuOptionCount > 2) {
                                                      Projectile.method89(Client.field393, Client.field417);
                                                   } else if(Client.menuOptionCount > 0) {
                                                      var2 = Client.field393;
                                                      var3 = Client.field417;
                                                      class127.method2803(class23.field603, var2, var3);
                                                      class23.field603 = null;
                                                   }

                                                   Client.field551 = 10;
                                                   class143.field2198 = 0;
                                                   Projectile.field124 = null;
                                                } else if(Client.field402 >= 5 && (class143.field2192 > 5 + Client.field393 || class143.field2192 < Client.field393 - 5 || class143.field2199 > 5 + Client.field417 || class143.field2199 < Client.field417 - 5)) {
                                                   Client.field399 = true;
                                                }
                                             }

                                             if(Region.field1554 != -1) {
                                                var2 = Region.field1554;
                                                var3 = Region.field1555;
                                                Client.field397.method2768(102);
                                                Client.field397.method2518(5);
                                                Client.field397.method2559(class140.field2153[82]?(class140.field2153[81]?2:1):0);
                                                Client.field397.method2567(var2 + class32.baseX);
                                                Client.field397.method2516(class8.baseY + var3);
                                                Region.field1554 = -1;
                                                Client.field389 = class143.field2197;
                                                Client.field390 = class143.field2207;
                                                Client.field392 = 1;
                                                Client.field391 = 0;
                                                Client.flagX = var2;
                                                Client.flagY = var3;
                                             }

                                             if(var32 != class113.field1973) {
                                                if(var32 != null) {
                                                   MessageNode.method750(var32);
                                                }

                                                if(class113.field1973 != null) {
                                                   MessageNode.method750(class113.field1973);
                                                }
                                             }

                                             if(DecorativeObject.field1672 != var25 && Client.field403 == Client.field458) {
                                                if(null != var25) {
                                                   MessageNode.method750(var25);
                                                }

                                                if(null != DecorativeObject.field1672) {
                                                   MessageNode.method750(DecorativeObject.field1672);
                                                }
                                             }

                                             if(DecorativeObject.field1672 != null) {
                                                if(Client.field458 < Client.field403) {
                                                   ++Client.field458;
                                                   if(Client.field403 == Client.field458) {
                                                      MessageNode.method750(DecorativeObject.field1672);
                                                   }
                                                }
                                             } else if(Client.field458 > 0) {
                                                --Client.field458;
                                             }

                                             var2 = class34.localPlayer.x + Client.field346;
                                             var3 = Client.field348 + class34.localPlayer.y;
                                             if(TextureProvider.field1683 - var2 < -500 || TextureProvider.field1683 - var2 > 500 || class18.field264 - var3 < -500 || class18.field264 - var3 > 500) {
                                                TextureProvider.field1683 = var2;
                                                class18.field264 = var3;
                                             }

                                             if(var2 != TextureProvider.field1683) {
                                                TextureProvider.field1683 += (var2 - TextureProvider.field1683) / 16;
                                             }

                                             if(class18.field264 != var3) {
                                                class18.field264 += (var3 - class18.field264) / 16;
                                             }

                                             if(class143.field2205 == 4 && ChatMessages.field276) {
                                                var4 = class143.field2199 - Client.field306;
                                                Client.field476 = var4 * 2;
                                                Client.field306 = var4 != -1 && var4 != 1?(Client.field306 + class143.field2199) / 2:class143.field2199;
                                                var5 = Client.field322 - class143.field2192;
                                                Client.field367 = var5 * 2;
                                                Client.field322 = var5 != -1 && var5 != 1?(class143.field2192 + Client.field322) / 2:class143.field2192;
                                             } else {
                                                if(class140.field2153[96]) {
                                                   Client.field367 += (-24 - Client.field367) / 2;
                                                } else if(class140.field2153[97]) {
                                                   Client.field367 += (24 - Client.field367) / 2;
                                                } else {
                                                   Client.field367 /= 2;
                                                }

                                                if(class140.field2153[98]) {
                                                   Client.field476 += (12 - Client.field476) / 2;
                                                } else if(class140.field2153[99]) {
                                                   Client.field476 += (-12 - Client.field476) / 2;
                                                } else {
                                                   Client.field476 /= 2;
                                                }

                                                Client.field306 = class143.field2199;
                                                Client.field322 = class143.field2192;
                                             }

                                             Client.mapAngle = Client.field367 / 2 + Client.mapAngle & 2047;
                                             Client.field365 += Client.field476 / 2;
                                             if(Client.field365 < 128) {
                                                Client.field365 = 128;
                                             }

                                             if(Client.field365 > 383) {
                                                Client.field365 = 383;
                                             }

                                             var4 = TextureProvider.field1683 >> 7;
                                             var5 = class18.field264 >> 7;
                                             var6 = Renderable.method1960(TextureProvider.field1683, class18.field264, XItemContainer.plane);
                                             var7 = 0;
                                             if(var4 > 3 && var5 > 3 && var4 < 100 && var5 < 100) {
                                                for(var8 = var4 - 4; var8 <= 4 + var4; ++var8) {
                                                   for(var19 = var5 - 4; var19 <= 4 + var5; ++var19) {
                                                      var20 = XItemContainer.plane;
                                                      if(var20 < 3 && (class5.tileSettings[1][var8][var19] & 2) == 2) {
                                                         ++var20;
                                                      }

                                                      var11 = var6 - class5.tileHeights[var20][var8][var19];
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

                                             if(var8 > Client.field374) {
                                                Client.field374 += (var8 - Client.field374) / 24;
                                             } else if(var8 < Client.field374) {
                                                Client.field374 += (var8 - Client.field374) / 80;
                                             }

                                             if(Client.field562) {
                                                Actor.method774();
                                             }

                                             for(var2 = 0; var2 < 5; ++var2) {
                                                ++Client.field532[var2];
                                             }

                                             class126.chatMessages.method203();
                                             var2 = ++class143.mouseIdleTicks - 1;
                                             var4 = class140.keyboardIdleTicks;
                                             if(var2 > 15000 && var4 > 15000) {
                                                Client.field335 = 250;
                                                class143.mouseIdleTicks = 14500;
                                                Client.field397.method2768(212);
                                             }

                                             ++Client.field489;
                                             if(Client.field489 > 500) {
                                                Client.field489 = 0;
                                                var6 = (int)(Math.random() * 8.0D);
                                                if((var6 & 1) == 1) {
                                                   Client.field346 += Client.field347;
                                                }

                                                if((var6 & 2) == 2) {
                                                   Client.field348 += Client.field349;
                                                }

                                                if((var6 & 4) == 4) {
                                                   Client.field350 += Client.field351;
                                                }
                                             }

                                             if(Client.field346 < -50) {
                                                Client.field347 = 2;
                                             }

                                             if(Client.field346 > 50) {
                                                Client.field347 = -2;
                                             }

                                             if(Client.field348 < -55) {
                                                Client.field349 = 2;
                                             }

                                             if(Client.field348 > 55) {
                                                Client.field349 = -2;
                                             }

                                             if(Client.field350 < -40) {
                                                Client.field351 = 1;
                                             }

                                             if(Client.field350 > 40) {
                                                Client.field351 = -1;
                                             }

                                             ++Client.field481;
                                             if(Client.field481 > 500) {
                                                Client.field481 = 0;
                                                var6 = (int)(Math.random() * 8.0D);
                                                if((var6 & 1) == 1) {
                                                   Client.mapScale += Client.field354;
                                                }

                                                if((var6 & 2) == 2) {
                                                   Client.mapScaleDelta += Client.field356;
                                                }
                                             }

                                             if(Client.mapScale < -60) {
                                                Client.field354 = 2;
                                             }

                                             if(Client.mapScale > 60) {
                                                Client.field354 = -2;
                                             }

                                             if(Client.mapScaleDelta < -20) {
                                                Client.field356 = 1;
                                             }

                                             if(Client.mapScaleDelta > 10) {
                                                Client.field356 = -1;
                                             }

                                             for(class40 var21 = (class40)Client.field316.method3846(); null != var21; var21 = (class40)Client.field316.method3839()) {
                                                if((long)var21.field881 < class11.method139() / 1000L - 5L) {
                                                   if(var21.field878 > 0) {
                                                      class190.sendGameMessage(5, "", var21.field880 + " has logged in.");
                                                   }

                                                   if(var21.field878 == 0) {
                                                      class190.sendGameMessage(5, "", var21.field880 + " has logged out.");
                                                   }

                                                   var21.method3984();
                                                }
                                             }

                                             ++Client.field552;
                                             if(Client.field552 > 50) {
                                                Client.field397.method2768(204);
                                             }

                                             try {
                                                if(class23.field604 != null && Client.field397.offset > 0) {
                                                   class23.field604.method3009(Client.field397.payload, 0, Client.field397.offset);
                                                   Client.field397.offset = 0;
                                                   Client.field552 = 0;
                                                }
                                             } catch (IOException var22) {
                                                class56.method1159();
                                             }

                                             return;
                                          }

                                          var35 = var33.field2;
                                          if(var35.index < 0) {
                                             break;
                                          }

                                          var36 = class153.method3170(var35.parentId);
                                       } while(null == var36 || null == var36.children || var35.index >= var36.children.length || var35 != var36.children[var35.index]);

                                       class112.method2452(var33);
                                    }
                                 }

                                 var35 = var33.field2;
                                 if(var35.index < 0) {
                                    break;
                                 }

                                 var36 = class153.method3170(var35.parentId);
                              } while(var36 == null || null == var36.children || var35.index >= var36.children.length || var35 != var36.children[var35.index]);

                              class112.method2452(var33);
                           }
                        }

                        var35 = var33.field2;
                        if(var35.index < 0) {
                           break;
                        }

                        var36 = class153.method3170(var35.parentId);
                     } while(var36 == null || var36.children == null || var35.index >= var36.children.length || var35 != var36.children[var35.index]);

                     class112.method2452(var33);
                  }
               }

               Client.field397.method2768(4);
               Client.field397.method2518(0);
               var13 = Client.field397.offset;
               class13.method148(Client.field397);
               Client.field397.method2530(Client.field397.offset - var13);
            }
         }
      }
   }
}
