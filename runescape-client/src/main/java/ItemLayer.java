import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1807056787
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2127673185
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -722361885
   )
   @Export("x")
   int x;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("top")
   Renderable top;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1757315665
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 849779049
   )
   @Export("height")
   int height;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-2"
   )
   public static void method2508() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         ++KeyFocusListener.keyboardIdleTicks;
         KeyFocusListener.field600 = KeyFocusListener.field616;
         KeyFocusListener.field613 = 0;
         int var1;
         if(KeyFocusListener.field614 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               KeyFocusListener.field606[var1] = false;
            }

            KeyFocusListener.field614 = KeyFocusListener.field608;
         } else {
            while(KeyFocusListener.field614 != KeyFocusListener.field608) {
               var1 = KeyFocusListener.field619[KeyFocusListener.field608];
               KeyFocusListener.field608 = KeyFocusListener.field608 + 1 & 127;
               if(var1 < 0) {
                  KeyFocusListener.field606[~var1] = false;
               } else {
                  if(!KeyFocusListener.field606[var1] && KeyFocusListener.field613 < KeyFocusListener.field612.length - 1) {
                     KeyFocusListener.field612[++KeyFocusListener.field613 - 1] = var1;
                  }

                  KeyFocusListener.field606[var1] = true;
               }
            }
         }

         if(KeyFocusListener.field613 > 0) {
            KeyFocusListener.keyboardIdleTicks = 0;
         }

         KeyFocusListener.field616 = KeyFocusListener.field618;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "637077847"
   )
   static int method2507(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 6600) {
         var3 = class233.plane;
         int var9 = (class181.localPlayer.x >> 7) + IndexDataBase.baseX;
         int var5 = (class181.localPlayer.y >> 7) + Occluder.baseY;
         ScriptState.method1094().method5402(var3, var9, var5, true);
         return 1;
      } else {
         WorldMapData var11;
         if(var0 == 6601) {
            var3 = class82.intStack[--class13.intStackSize];
            String var16 = "";
            var11 = ScriptState.method1094().method5418(var3);
            if(var11 != null) {
               var16 = var11.method284();
            }

            class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var16;
            return 1;
         } else if(var0 == 6602) {
            var3 = class82.intStack[--class13.intStackSize];
            ScriptState.method1094().method5403(var3);
            return 1;
         } else if(var0 == 6603) {
            class82.intStack[++class13.intStackSize - 1] = ScriptState.method1094().method5415();
            return 1;
         } else if(var0 == 6604) {
            var3 = class82.intStack[--class13.intStackSize];
            ScriptState.method1094().method5519(var3);
            return 1;
         } else if(var0 == 6605) {
            class82.intStack[++class13.intStackSize - 1] = ScriptState.method1094().method5417()?1:0;
            return 1;
         } else {
            Coordinates var15;
            if(var0 == 6606) {
               var15 = new Coordinates(class82.intStack[--class13.intStackSize]);
               ScriptState.method1094().method5419(var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6607) {
               var15 = new Coordinates(class82.intStack[--class13.intStackSize]);
               ScriptState.method1094().method5420(var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6608) {
               var15 = new Coordinates(class82.intStack[--class13.intStackSize]);
               ScriptState.method1094().method5543(var15.plane, var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6609) {
               var15 = new Coordinates(class82.intStack[--class13.intStackSize]);
               ScriptState.method1094().method5422(var15.plane, var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6610) {
               class82.intStack[++class13.intStackSize - 1] = ScriptState.method1094().method5470();
               class82.intStack[++class13.intStackSize - 1] = ScriptState.method1094().method5424();
               return 1;
            } else {
               WorldMapData var13;
               if(var0 == 6611) {
                  var3 = class82.intStack[--class13.intStackSize];
                  var13 = ScriptState.method1094().method5418(var3);
                  if(var13 == null) {
                     class82.intStack[++class13.intStackSize - 1] = 0;
                  } else {
                     class82.intStack[++class13.intStackSize - 1] = var13.method356().method4109();
                  }

                  return 1;
               } else if(var0 == 6612) {
                  var3 = class82.intStack[--class13.intStackSize];
                  var13 = ScriptState.method1094().method5418(var3);
                  if(var13 == null) {
                     class82.intStack[++class13.intStackSize - 1] = 0;
                     class82.intStack[++class13.intStackSize - 1] = 0;
                  } else {
                     class82.intStack[++class13.intStackSize - 1] = (var13.method288() - var13.method287() + 1) * 64;
                     class82.intStack[++class13.intStackSize - 1] = (var13.method290() - var13.method289() + 1) * 64;
                  }

                  return 1;
               } else if(var0 == 6613) {
                  var3 = class82.intStack[--class13.intStackSize];
                  var13 = ScriptState.method1094().method5418(var3);
                  if(var13 == null) {
                     class82.intStack[++class13.intStackSize - 1] = 0;
                     class82.intStack[++class13.intStackSize - 1] = 0;
                     class82.intStack[++class13.intStackSize - 1] = 0;
                     class82.intStack[++class13.intStackSize - 1] = 0;
                  } else {
                     class82.intStack[++class13.intStackSize - 1] = var13.method287() * 64;
                     class82.intStack[++class13.intStackSize - 1] = var13.method289() * 64;
                     class82.intStack[++class13.intStackSize - 1] = var13.method288() * 64 + 64 - 1;
                     class82.intStack[++class13.intStackSize - 1] = var13.method290() * 64 + 64 - 1;
                  }

                  return 1;
               } else if(var0 == 6614) {
                  var3 = class82.intStack[--class13.intStackSize];
                  var13 = ScriptState.method1094().method5418(var3);
                  if(var13 == null) {
                     class82.intStack[++class13.intStackSize - 1] = -1;
                  } else {
                     class82.intStack[++class13.intStackSize - 1] = var13.method286();
                  }

                  return 1;
               } else if(var0 == 6615) {
                  var15 = ScriptState.method1094().method5425();
                  if(var15 == null) {
                     class82.intStack[++class13.intStackSize - 1] = -1;
                     class82.intStack[++class13.intStackSize - 1] = -1;
                  } else {
                     class82.intStack[++class13.intStackSize - 1] = var15.worldX;
                     class82.intStack[++class13.intStackSize - 1] = var15.worldY;
                  }

                  return 1;
               } else if(var0 == 6616) {
                  class82.intStack[++class13.intStackSize - 1] = ScriptState.method1094().method5555();
                  return 1;
               } else if(var0 == 6617) {
                  var15 = new Coordinates(class82.intStack[--class13.intStackSize]);
                  var13 = ScriptState.method1094().method5486();
                  if(var13 == null) {
                     class82.intStack[++class13.intStackSize - 1] = -1;
                     class82.intStack[++class13.intStackSize - 1] = -1;
                     return 1;
                  } else {
                     int[] var14 = var13.method278(var15.plane, var15.worldX, var15.worldY);
                     if(var14 == null) {
                        class82.intStack[++class13.intStackSize - 1] = -1;
                        class82.intStack[++class13.intStackSize - 1] = -1;
                     } else {
                        class82.intStack[++class13.intStackSize - 1] = var14[0];
                        class82.intStack[++class13.intStackSize - 1] = var14[1];
                     }

                     return 1;
                  }
               } else {
                  Coordinates var7;
                  if(var0 == 6618) {
                     var15 = new Coordinates(class82.intStack[--class13.intStackSize]);
                     var13 = ScriptState.method1094().method5486();
                     if(var13 == null) {
                        class82.intStack[++class13.intStackSize - 1] = -1;
                        class82.intStack[++class13.intStackSize - 1] = -1;
                        return 1;
                     } else {
                        var7 = var13.method291(var15.worldX, var15.worldY);
                        if(var7 == null) {
                           class82.intStack[++class13.intStackSize - 1] = -1;
                        } else {
                           class82.intStack[++class13.intStackSize - 1] = var7.method4109();
                        }

                        return 1;
                     }
                  } else {
                     Coordinates var12;
                     if(var0 == 6619) {
                        class13.intStackSize -= 2;
                        var3 = class82.intStack[class13.intStackSize];
                        var12 = new Coordinates(class82.intStack[class13.intStackSize + 1]);
                        FileOnDisk.method2468(var3, var12, false);
                        return 1;
                     } else if(var0 == 6620) {
                        class13.intStackSize -= 2;
                        var3 = class82.intStack[class13.intStackSize];
                        var12 = new Coordinates(class82.intStack[class13.intStackSize + 1]);
                        FileOnDisk.method2468(var3, var12, true);
                        return 1;
                     } else if(var0 == 6621) {
                        class13.intStackSize -= 2;
                        var3 = class82.intStack[class13.intStackSize];
                        var12 = new Coordinates(class82.intStack[class13.intStackSize + 1]);
                        var11 = ScriptState.method1094().method5418(var3);
                        if(var11 == null) {
                           class82.intStack[++class13.intStackSize - 1] = 0;
                           return 1;
                        } else {
                           class82.intStack[++class13.intStackSize - 1] = var11.method276(var12.plane, var12.worldX, var12.worldY)?1:0;
                           return 1;
                        }
                     } else if(var0 == 6622) {
                        class82.intStack[++class13.intStackSize - 1] = ScriptState.method1094().method5426();
                        class82.intStack[++class13.intStackSize - 1] = ScriptState.method1094().method5427();
                        return 1;
                     } else if(var0 == 6623) {
                        var15 = new Coordinates(class82.intStack[--class13.intStackSize]);
                        var13 = ScriptState.method1094().method5401(var15.plane, var15.worldX, var15.worldY);
                        if(var13 == null) {
                           class82.intStack[++class13.intStackSize - 1] = -1;
                        } else {
                           class82.intStack[++class13.intStackSize - 1] = var13.method281();
                        }

                        return 1;
                     } else if(var0 == 6624) {
                        ScriptState.method1094().method5428(class82.intStack[--class13.intStackSize]);
                        return 1;
                     } else if(var0 == 6625) {
                        ScriptState.method1094().method5429();
                        return 1;
                     } else if(var0 == 6626) {
                        ScriptState.method1094().method5435(class82.intStack[--class13.intStackSize]);
                        return 1;
                     } else if(var0 == 6627) {
                        ScriptState.method1094().method5431();
                        return 1;
                     } else {
                        boolean var10;
                        if(var0 == 6628) {
                           var10 = class82.intStack[--class13.intStackSize] == 1;
                           ScriptState.method1094().method5582(var10);
                           return 1;
                        } else if(var0 == 6629) {
                           var3 = class82.intStack[--class13.intStackSize];
                           ScriptState.method1094().method5562(var3);
                           return 1;
                        } else if(var0 == 6630) {
                           var3 = class82.intStack[--class13.intStackSize];
                           ScriptState.method1094().method5558(var3);
                           return 1;
                        } else if(var0 == 6631) {
                           ScriptState.method1094().method5550();
                           return 1;
                        } else if(var0 == 6632) {
                           var10 = class82.intStack[--class13.intStackSize] == 1;
                           ScriptState.method1094().method5465(var10);
                           return 1;
                        } else {
                           boolean var4;
                           if(var0 == 6633) {
                              class13.intStackSize -= 2;
                              var3 = class82.intStack[class13.intStackSize];
                              var4 = class82.intStack[class13.intStackSize + 1] == 1;
                              ScriptState.method1094().method5437(var3, var4);
                              return 1;
                           } else if(var0 == 6634) {
                              class13.intStackSize -= 2;
                              var3 = class82.intStack[class13.intStackSize];
                              var4 = class82.intStack[class13.intStackSize + 1] == 1;
                              ScriptState.method1094().method5438(var3, var4);
                              return 1;
                           } else if(var0 == 6635) {
                              class82.intStack[++class13.intStackSize - 1] = ScriptState.method1094().method5439()?1:0;
                              return 1;
                           } else if(var0 == 6636) {
                              var3 = class82.intStack[--class13.intStackSize];
                              class82.intStack[++class13.intStackSize - 1] = ScriptState.method1094().method5518(var3)?1:0;
                              return 1;
                           } else if(var0 == 6637) {
                              var3 = class82.intStack[--class13.intStackSize];
                              class82.intStack[++class13.intStackSize - 1] = ScriptState.method1094().method5474(var3)?1:0;
                              return 1;
                           } else if(var0 == 6638) {
                              class13.intStackSize -= 2;
                              var3 = class82.intStack[class13.intStackSize];
                              var12 = new Coordinates(class82.intStack[class13.intStackSize + 1]);
                              var7 = ScriptState.method1094().method5444(var3, var12);
                              if(var7 == null) {
                                 class82.intStack[++class13.intStackSize - 1] = -1;
                              } else {
                                 class82.intStack[++class13.intStackSize - 1] = var7.method4109();
                              }

                              return 1;
                           } else {
                              class39 var8;
                              if(var0 == 6639) {
                                 var8 = ScriptState.method1094().method5495();
                                 if(var8 == null) {
                                    class82.intStack[++class13.intStackSize - 1] = -1;
                                    class82.intStack[++class13.intStackSize - 1] = -1;
                                 } else {
                                    class82.intStack[++class13.intStackSize - 1] = var8.field513;
                                    class82.intStack[++class13.intStackSize - 1] = var8.field506.method4109();
                                 }

                                 return 1;
                              } else if(var0 == 6640) {
                                 var8 = ScriptState.method1094().method5447();
                                 if(var8 == null) {
                                    class82.intStack[++class13.intStackSize - 1] = -1;
                                    class82.intStack[++class13.intStackSize - 1] = -1;
                                 } else {
                                    class82.intStack[++class13.intStackSize - 1] = var8.field513;
                                    class82.intStack[++class13.intStackSize - 1] = var8.field506.method4109();
                                 }

                                 return 1;
                              } else {
                                 Area var6;
                                 if(var0 == 6693) {
                                    var3 = class82.intStack[--class13.intStackSize];
                                    var6 = Area.mapAreaType[var3];
                                    if(var6.name == null) {
                                       class82.scriptStringStack[++class82.scriptStringStackSize - 1] = "";
                                    } else {
                                       class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var6.name;
                                    }

                                    return 1;
                                 } else if(var0 == 6694) {
                                    var3 = class82.intStack[--class13.intStackSize];
                                    var6 = Area.mapAreaType[var3];
                                    class82.intStack[++class13.intStackSize - 1] = var6.field3371;
                                    return 1;
                                 } else if(var0 == 6695) {
                                    var3 = class82.intStack[--class13.intStackSize];
                                    var6 = Area.mapAreaType[var3];
                                    if(var6 == null) {
                                       class82.intStack[++class13.intStackSize - 1] = -1;
                                    } else {
                                       class82.intStack[++class13.intStackSize - 1] = var6.field3384;
                                    }

                                    return 1;
                                 } else if(var0 == 6696) {
                                    var3 = class82.intStack[--class13.intStackSize];
                                    var6 = Area.mapAreaType[var3];
                                    if(var6 == null) {
                                       class82.intStack[++class13.intStackSize - 1] = -1;
                                    } else {
                                       class82.intStack[++class13.intStackSize - 1] = var6.spriteId;
                                    }

                                    return 1;
                                 } else if(var0 == 6697) {
                                    class82.intStack[++class13.intStackSize - 1] = class28.field380.field572;
                                    return 1;
                                 } else if(var0 == 6698) {
                                    class82.intStack[++class13.intStackSize - 1] = class28.field380.field575.method4109();
                                    return 1;
                                 } else if(var0 == 6699) {
                                    class82.intStack[++class13.intStackSize - 1] = class28.field380.field574.method4109();
                                    return 1;
                                 } else {
                                    return 2;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-1419567956"
   )
   @Export("menuAction")
   @Hook("menuActionHook")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      PacketNode var8;
      if(var2 == 1) {
         Client.field1064 = var6;
         Client.field962 = var7;
         Client.cursorState = 2;
         Client.field963 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class218.method4105(ClientPacket.field2344, Client.field916.field1470);
         var8.packetBuffer.putByte(KeyFocusListener.field606[82]?1:0);
         var8.packetBuffer.putShort(class94.field1409);
         var8.packetBuffer.method3332(var0 + IndexDataBase.baseX);
         var8.packetBuffer.putShort(class34.selectedItemIndex);
         var8.packetBuffer.method3365(class214.field2675);
         var8.packetBuffer.method3330(Occluder.baseY + var1);
         var8.packetBuffer.method3332(var3 >> 14 & 32767);
         Client.field916.method1925(var8);
      } else if(var2 == 2) {
         Client.field1064 = var6;
         Client.field962 = var7;
         Client.cursorState = 2;
         Client.field963 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class218.method4105(ClientPacket.field2399, Client.field916.field1470);
         var8.packetBuffer.method3307(KeyFocusListener.field606[82]?1:0);
         var8.packetBuffer.method3400(class37.field489);
         var8.packetBuffer.putShortLE(Occluder.baseY + var1);
         var8.packetBuffer.method3332(var3 >> 14 & 32767);
         var8.packetBuffer.method3332(Client.field917);
         var8.packetBuffer.method3332(var0 + IndexDataBase.baseX);
         Client.field916.method1925(var8);
      } else if(var2 == 3) {
         Client.field1064 = var6;
         Client.field962 = var7;
         Client.cursorState = 2;
         Client.field963 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class218.method4105(ClientPacket.field2334, Client.field916.field1470);
         var8.packetBuffer.method3330(var0 + IndexDataBase.baseX);
         var8.packetBuffer.putShort(Occluder.baseY + var1);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         var8.packetBuffer.putByte(KeyFocusListener.field606[82]?1:0);
         Client.field916.method1925(var8);
      } else if(var2 == 4) {
         Client.field1064 = var6;
         Client.field962 = var7;
         Client.cursorState = 2;
         Client.field963 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class218.method4105(ClientPacket.field2395, Client.field916.field1470);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         var8.packetBuffer.putShortLE(Occluder.baseY + var1);
         var8.packetBuffer.method3307(KeyFocusListener.field606[82]?1:0);
         var8.packetBuffer.method3332(var0 + IndexDataBase.baseX);
         Client.field916.method1925(var8);
      } else if(var2 == 5) {
         Client.field1064 = var6;
         Client.field962 = var7;
         Client.cursorState = 2;
         Client.field963 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class218.method4105(ClientPacket.field2393, Client.field916.field1470);
         var8.packetBuffer.method3307(KeyFocusListener.field606[82]?1:0);
         var8.packetBuffer.method3332(Occluder.baseY + var1);
         var8.packetBuffer.putShortLE(var3 >> 14 & 32767);
         var8.packetBuffer.method3330(var0 + IndexDataBase.baseX);
         Client.field916.method1925(var8);
      } else if(var2 == 6) {
         Client.field1064 = var6;
         Client.field962 = var7;
         Client.cursorState = 2;
         Client.field963 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class218.method4105(ClientPacket.field2387, Client.field916.field1470);
         var8.packetBuffer.method3332(var3 >> 14 & 32767);
         var8.packetBuffer.method3343(KeyFocusListener.field606[82]?1:0);
         var8.packetBuffer.putShortLE(var0 + IndexDataBase.baseX);
         var8.packetBuffer.putShort(Occluder.baseY + var1);
         Client.field916.method1925(var8);
      } else {
         PacketNode var16;
         NPC var21;
         if(var2 == 7) {
            var21 = Client.cachedNPCs[var3];
            if(var21 != null) {
               Client.field1064 = var6;
               Client.field962 = var7;
               Client.cursorState = 2;
               Client.field963 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var16 = class218.method4105(ClientPacket.field2381, Client.field916.field1470);
               var16.packetBuffer.method3330(var3);
               var16.packetBuffer.method3330(class34.selectedItemIndex);
               var16.packetBuffer.method3307(KeyFocusListener.field606[82]?1:0);
               var16.packetBuffer.method3330(class94.field1409);
               var16.packetBuffer.method3400(class214.field2675);
               Client.field916.method1925(var16);
            }
         } else if(var2 == 8) {
            var21 = Client.cachedNPCs[var3];
            if(var21 != null) {
               Client.field1064 = var6;
               Client.field962 = var7;
               Client.cursorState = 2;
               Client.field963 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var16 = class218.method4105(ClientPacket.field2309, Client.field916.field1470);
               var16.packetBuffer.method3341(class37.field489);
               var16.packetBuffer.method3322(KeyFocusListener.field606[82]?1:0);
               var16.packetBuffer.method3330(var3);
               var16.packetBuffer.putShortLE(Client.field917);
               Client.field916.method1925(var16);
            }
         } else if(var2 == 9) {
            var21 = Client.cachedNPCs[var3];
            if(var21 != null) {
               Client.field1064 = var6;
               Client.field962 = var7;
               Client.cursorState = 2;
               Client.field963 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var16 = class218.method4105(ClientPacket.field2333, Client.field916.field1470);
               var16.packetBuffer.method3330(var3);
               var16.packetBuffer.method3307(KeyFocusListener.field606[82]?1:0);
               Client.field916.method1925(var16);
            }
         } else if(var2 == 10) {
            var21 = Client.cachedNPCs[var3];
            if(var21 != null) {
               Client.field1064 = var6;
               Client.field962 = var7;
               Client.cursorState = 2;
               Client.field963 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var16 = class218.method4105(ClientPacket.field2396, Client.field916.field1470);
               var16.packetBuffer.method3322(KeyFocusListener.field606[82]?1:0);
               var16.packetBuffer.putShortLE(var3);
               Client.field916.method1925(var16);
            }
         } else if(var2 == 11) {
            var21 = Client.cachedNPCs[var3];
            if(var21 != null) {
               Client.field1064 = var6;
               Client.field962 = var7;
               Client.cursorState = 2;
               Client.field963 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var16 = class218.method4105(ClientPacket.field2362, Client.field916.field1470);
               var16.packetBuffer.putByte(KeyFocusListener.field606[82]?1:0);
               var16.packetBuffer.method3332(var3);
               Client.field916.method1925(var16);
            }
         } else if(var2 == 12) {
            var21 = Client.cachedNPCs[var3];
            if(var21 != null) {
               Client.field1064 = var6;
               Client.field962 = var7;
               Client.cursorState = 2;
               Client.field963 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var16 = class218.method4105(ClientPacket.field2372, Client.field916.field1470);
               var16.packetBuffer.method3332(var3);
               var16.packetBuffer.putByte(KeyFocusListener.field606[82]?1:0);
               Client.field916.method1925(var16);
            }
         } else if(var2 == 13) {
            var21 = Client.cachedNPCs[var3];
            if(var21 != null) {
               Client.field1064 = var6;
               Client.field962 = var7;
               Client.cursorState = 2;
               Client.field963 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var16 = class218.method4105(ClientPacket.field2392, Client.field916.field1470);
               var16.packetBuffer.putShortLE(var3);
               var16.packetBuffer.method3343(KeyFocusListener.field606[82]?1:0);
               Client.field916.method1925(var16);
            }
         } else {
            Player var24;
            if(var2 == 14) {
               var24 = Client.cachedPlayers[var3];
               if(var24 != null) {
                  Client.field1064 = var6;
                  Client.field962 = var7;
                  Client.cursorState = 2;
                  Client.field963 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var16 = class218.method4105(ClientPacket.field2388, Client.field916.field1470);
                  var16.packetBuffer.method3332(var3);
                  var16.packetBuffer.method3343(KeyFocusListener.field606[82]?1:0);
                  var16.packetBuffer.method3330(class34.selectedItemIndex);
                  var16.packetBuffer.method3332(class94.field1409);
                  var16.packetBuffer.method3341(class214.field2675);
                  Client.field916.method1925(var16);
               }
            } else if(var2 == 15) {
               var24 = Client.cachedPlayers[var3];
               if(var24 != null) {
                  Client.field1064 = var6;
                  Client.field962 = var7;
                  Client.cursorState = 2;
                  Client.field963 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var16 = class218.method4105(ClientPacket.field2347, Client.field916.field1470);
                  var16.packetBuffer.putShort(Client.field917);
                  var16.packetBuffer.method3330(var3);
                  var16.packetBuffer.method3343(KeyFocusListener.field606[82]?1:0);
                  var16.packetBuffer.method3365(class37.field489);
                  Client.field916.method1925(var16);
               }
            } else if(var2 == 16) {
               Client.field1064 = var6;
               Client.field962 = var7;
               Client.cursorState = 2;
               Client.field963 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class218.method4105(ClientPacket.field2359, Client.field916.field1470);
               var8.packetBuffer.putShort(class94.field1409);
               var8.packetBuffer.method3365(class214.field2675);
               var8.packetBuffer.method3330(var3);
               var8.packetBuffer.method3332(var0 + IndexDataBase.baseX);
               var8.packetBuffer.putShort(Occluder.baseY + var1);
               var8.packetBuffer.method3322(KeyFocusListener.field606[82]?1:0);
               var8.packetBuffer.putShortLE(class34.selectedItemIndex);
               Client.field916.method1925(var8);
            } else if(var2 == 17) {
               Client.field1064 = var6;
               Client.field962 = var7;
               Client.cursorState = 2;
               Client.field963 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class218.method4105(ClientPacket.field2389, Client.field916.field1470);
               var8.packetBuffer.method3330(var3);
               var8.packetBuffer.method3343(KeyFocusListener.field606[82]?1:0);
               var8.packetBuffer.putInt(class37.field489);
               var8.packetBuffer.method3330(Client.field917);
               var8.packetBuffer.method3330(var0 + IndexDataBase.baseX);
               var8.packetBuffer.method3330(Occluder.baseY + var1);
               Client.field916.method1925(var8);
            } else if(var2 == 18) {
               Client.field1064 = var6;
               Client.field962 = var7;
               Client.cursorState = 2;
               Client.field963 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class218.method4105(ClientPacket.field2326, Client.field916.field1470);
               var8.packetBuffer.method3330(Occluder.baseY + var1);
               var8.packetBuffer.putByte(KeyFocusListener.field606[82]?1:0);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.putShort(var0 + IndexDataBase.baseX);
               Client.field916.method1925(var8);
            } else if(var2 == 19) {
               Client.field1064 = var6;
               Client.field962 = var7;
               Client.cursorState = 2;
               Client.field963 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class218.method4105(ClientPacket.field2398, Client.field916.field1470);
               var8.packetBuffer.method3343(KeyFocusListener.field606[82]?1:0);
               var8.packetBuffer.method3330(var0 + IndexDataBase.baseX);
               var8.packetBuffer.method3330(Occluder.baseY + var1);
               var8.packetBuffer.putShortLE(var3);
               Client.field916.method1925(var8);
            } else if(var2 == 20) {
               Client.field1064 = var6;
               Client.field962 = var7;
               Client.cursorState = 2;
               Client.field963 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class218.method4105(ClientPacket.field2366, Client.field916.field1470);
               var8.packetBuffer.method3332(var3);
               var8.packetBuffer.putShortLE(var0 + IndexDataBase.baseX);
               var8.packetBuffer.putShort(Occluder.baseY + var1);
               var8.packetBuffer.method3307(KeyFocusListener.field606[82]?1:0);
               Client.field916.method1925(var8);
            } else if(var2 == 21) {
               Client.field1064 = var6;
               Client.field962 = var7;
               Client.cursorState = 2;
               Client.field963 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class218.method4105(ClientPacket.field2377, Client.field916.field1470);
               var8.packetBuffer.method3322(KeyFocusListener.field606[82]?1:0);
               var8.packetBuffer.putShort(Occluder.baseY + var1);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.putShortLE(var0 + IndexDataBase.baseX);
               Client.field916.method1925(var8);
            } else if(var2 == 22) {
               Client.field1064 = var6;
               Client.field962 = var7;
               Client.cursorState = 2;
               Client.field963 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class218.method4105(ClientPacket.field2371, Client.field916.field1470);
               var8.packetBuffer.method3330(var0 + IndexDataBase.baseX);
               var8.packetBuffer.method3332(Occluder.baseY + var1);
               var8.packetBuffer.method3330(var3);
               var8.packetBuffer.method3322(KeyFocusListener.field606[82]?1:0);
               Client.field916.method1925(var8);
            } else if(var2 == 23) {
               if(Client.isMenuOpen) {
                  class14.region.method2834();
               } else {
                  class14.region.method2970(class233.plane, var0, var1, true);
               }
            } else {
               PacketNode var10;
               Widget var26;
               if(var2 == 24) {
                  var26 = class87.method1762(var1);
                  boolean var9 = true;
                  if(var26.contentType > 0) {
                     var9 = Renderable.method2994(var26);
                  }

                  if(var9) {
                     var10 = class218.method4105(ClientPacket.field2341, Client.field916.field1470);
                     var10.packetBuffer.putInt(var1);
                     Client.field916.method1925(var10);
                  }
               } else {
                  int var17;
                  int var22;
                  if(var2 == 25) {
                     var26 = MilliTimer.method3058(var1, var0);
                     if(var26 != null) {
                        Script.method1909();
                        var17 = ClanMember.getWidgetConfig(var26);
                        var22 = var17 >> 11 & 63;
                        int var25 = var26.itemId;
                        Widget var13 = MilliTimer.method3058(var1, var0);
                        if(var13 != null && var13.field2784 != null) {
                           ScriptEvent var14 = new ScriptEvent();
                           var14.widget = var13;
                           var14.field797 = var13.field2784;
                           class14.method95(var14);
                        }

                        Client.field1011 = var25;
                        Client.spellSelected = true;
                        class37.field489 = var1;
                        Client.field917 = var0;
                        class156.field2161 = var22;
                        class40.method556(var13);
                        Client.itemSelectionState = 0;
                        Client.field1042 = DecorativeObject.method3017(var26);
                        if(Client.field1042 == null) {
                           Client.field1042 = "Null";
                        }

                        if(var26.hasScript) {
                           Client.field1013 = var26.name + ISAACCipher.getColTags(16777215);
                        } else {
                           Client.field1013 = ISAACCipher.getColTags(65280) + var26.field2840 + ISAACCipher.getColTags(16777215);
                        }
                     }

                     return;
                  }

                  if(var2 == 26) {
                     WorldMapType1.method268();
                  } else {
                     Widget var27;
                     if(var2 == 28) {
                        var8 = class218.method4105(ClientPacket.field2341, Client.field916.field1470);
                        var8.packetBuffer.putInt(var1);
                        Client.field916.method1925(var8);
                        var27 = class87.method1762(var1);
                        if(var27.dynamicValues != null && var27.dynamicValues[0][0] == 5) {
                           var17 = var27.dynamicValues[0][1];
                           class218.widgetSettings[var17] = 1 - class218.widgetSettings[var17];
                           GraphicsObject.method1724(var17);
                        }
                     } else if(var2 == 29) {
                        var8 = class218.method4105(ClientPacket.field2341, Client.field916.field1470);
                        var8.packetBuffer.putInt(var1);
                        Client.field916.method1925(var8);
                        var27 = class87.method1762(var1);
                        if(var27.dynamicValues != null && var27.dynamicValues[0][0] == 5) {
                           var17 = var27.dynamicValues[0][1];
                           if(class218.widgetSettings[var17] != var27.field2822[0]) {
                              class218.widgetSettings[var17] = var27.field2822[0];
                              GraphicsObject.method1724(var17);
                           }
                        }
                     } else if(var2 == 30) {
                        if(Client.field1018 == null) {
                           class182.method3528(var1, var0);
                           Client.field1018 = MilliTimer.method3058(var1, var0);
                           class40.method556(Client.field1018);
                        }
                     } else if(var2 == 31) {
                        var8 = class218.method4105(ClientPacket.field2365, Client.field916.field1470);
                        var8.packetBuffer.method3330(var0);
                        var8.packetBuffer.method3332(var3);
                        var8.packetBuffer.putInt(class214.field2675);
                        var8.packetBuffer.putShort(class34.selectedItemIndex);
                        var8.packetBuffer.putShortLE(class94.field1409);
                        var8.packetBuffer.method3400(var1);
                        Client.field916.method1925(var8);
                        Client.field965 = 0;
                        class51.field622 = class87.method1762(var1);
                        Client.field966 = var0;
                     } else if(var2 == 32) {
                        var8 = class218.method4105(ClientPacket.field2317, Client.field916.field1470);
                        var8.packetBuffer.method3400(var1);
                        var8.packetBuffer.putShortLE(var0);
                        var8.packetBuffer.putShort(Client.field917);
                        var8.packetBuffer.method3365(class37.field489);
                        var8.packetBuffer.putShortLE(var3);
                        Client.field916.method1925(var8);
                        Client.field965 = 0;
                        class51.field622 = class87.method1762(var1);
                        Client.field966 = var0;
                     } else if(var2 == 33) {
                        var8 = class218.method4105(ClientPacket.field2379, Client.field916.field1470);
                        var8.packetBuffer.method3332(var3);
                        var8.packetBuffer.putInt(var1);
                        var8.packetBuffer.putShortLE(var0);
                        Client.field916.method1925(var8);
                        Client.field965 = 0;
                        class51.field622 = class87.method1762(var1);
                        Client.field966 = var0;
                     } else if(var2 == 34) {
                        var8 = class218.method4105(ClientPacket.field2391, Client.field916.field1470);
                        var8.packetBuffer.method3330(var0);
                        var8.packetBuffer.putShortLE(var3);
                        var8.packetBuffer.method3400(var1);
                        Client.field916.method1925(var8);
                        Client.field965 = 0;
                        class51.field622 = class87.method1762(var1);
                        Client.field966 = var0;
                     } else if(var2 == 35) {
                        var8 = class218.method4105(ClientPacket.field2369, Client.field916.field1470);
                        var8.packetBuffer.putInt(var1);
                        var8.packetBuffer.method3330(var3);
                        var8.packetBuffer.putShortLE(var0);
                        Client.field916.method1925(var8);
                        Client.field965 = 0;
                        class51.field622 = class87.method1762(var1);
                        Client.field966 = var0;
                     } else if(var2 == 36) {
                        var8 = class218.method4105(ClientPacket.field2331, Client.field916.field1470);
                        var8.packetBuffer.putShort(var3);
                        var8.packetBuffer.putShort(var0);
                        var8.packetBuffer.method3365(var1);
                        Client.field916.method1925(var8);
                        Client.field965 = 0;
                        class51.field622 = class87.method1762(var1);
                        Client.field966 = var0;
                     } else if(var2 == 37) {
                        var8 = class218.method4105(ClientPacket.field2306, Client.field916.field1470);
                        var8.packetBuffer.putInt(var1);
                        var8.packetBuffer.method3332(var3);
                        var8.packetBuffer.method3332(var0);
                        Client.field916.method1925(var8);
                        Client.field965 = 0;
                        class51.field622 = class87.method1762(var1);
                        Client.field966 = var0;
                     } else {
                        if(var2 == 38) {
                           Script.method1909();
                           var26 = class87.method1762(var1);
                           Client.itemSelectionState = 1;
                           class34.selectedItemIndex = var0;
                           class214.field2675 = var1;
                           class94.field1409 = var3;
                           class40.method556(var26);
                           Client.field974 = ISAACCipher.getColTags(16748608) + WorldMapType2.getItemDefinition(var3).name + ISAACCipher.getColTags(16777215);
                           if(Client.field974 == null) {
                              Client.field974 = "null";
                           }

                           return;
                        }

                        if(var2 == 39) {
                           var8 = class218.method4105(ClientPacket.field2336, Client.field916.field1470);
                           var8.packetBuffer.putInt(var1);
                           var8.packetBuffer.method3330(var3);
                           var8.packetBuffer.method3330(var0);
                           Client.field916.method1925(var8);
                           Client.field965 = 0;
                           class51.field622 = class87.method1762(var1);
                           Client.field966 = var0;
                        } else if(var2 == 40) {
                           var8 = class218.method4105(ClientPacket.field2319, Client.field916.field1470);
                           var8.packetBuffer.method3341(var1);
                           var8.packetBuffer.putShort(var0);
                           var8.packetBuffer.putShortLE(var3);
                           Client.field916.method1925(var8);
                           Client.field965 = 0;
                           class51.field622 = class87.method1762(var1);
                           Client.field966 = var0;
                        } else if(var2 == 41) {
                           var8 = class218.method4105(ClientPacket.field2328, Client.field916.field1470);
                           var8.packetBuffer.putInt(var1);
                           var8.packetBuffer.method3330(var0);
                           var8.packetBuffer.putShortLE(var3);
                           Client.field916.method1925(var8);
                           Client.field965 = 0;
                           class51.field622 = class87.method1762(var1);
                           Client.field966 = var0;
                        } else if(var2 == 42) {
                           var8 = class218.method4105(ClientPacket.field2353, Client.field916.field1470);
                           var8.packetBuffer.method3365(var1);
                           var8.packetBuffer.putShortLE(var0);
                           var8.packetBuffer.putShort(var3);
                           Client.field916.method1925(var8);
                           Client.field965 = 0;
                           class51.field622 = class87.method1762(var1);
                           Client.field966 = var0;
                        } else if(var2 == 43) {
                           var8 = class218.method4105(ClientPacket.field2349, Client.field916.field1470);
                           var8.packetBuffer.putShortLE(var3);
                           var8.packetBuffer.method3400(var1);
                           var8.packetBuffer.putShortLE(var0);
                           Client.field916.method1925(var8);
                           Client.field965 = 0;
                           class51.field622 = class87.method1762(var1);
                           Client.field966 = var0;
                        } else if(var2 == 44) {
                           var24 = Client.cachedPlayers[var3];
                           if(var24 != null) {
                              Client.field1064 = var6;
                              Client.field962 = var7;
                              Client.cursorState = 2;
                              Client.field963 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var16 = class218.method4105(ClientPacket.field2368, Client.field916.field1470);
                              var16.packetBuffer.method3322(KeyFocusListener.field606[82]?1:0);
                              var16.packetBuffer.putShort(var3);
                              Client.field916.method1925(var16);
                           }
                        } else if(var2 == 45) {
                           var24 = Client.cachedPlayers[var3];
                           if(var24 != null) {
                              Client.field1064 = var6;
                              Client.field962 = var7;
                              Client.cursorState = 2;
                              Client.field963 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var16 = class218.method4105(ClientPacket.field2303, Client.field916.field1470);
                              var16.packetBuffer.method3332(var3);
                              var16.packetBuffer.method3307(KeyFocusListener.field606[82]?1:0);
                              Client.field916.method1925(var16);
                           }
                        } else if(var2 == 46) {
                           var24 = Client.cachedPlayers[var3];
                           if(var24 != null) {
                              Client.field1064 = var6;
                              Client.field962 = var7;
                              Client.cursorState = 2;
                              Client.field963 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var16 = class218.method4105(ClientPacket.field2330, Client.field916.field1470);
                              var16.packetBuffer.putShortLE(var3);
                              var16.packetBuffer.method3322(KeyFocusListener.field606[82]?1:0);
                              Client.field916.method1925(var16);
                           }
                        } else if(var2 == 47) {
                           var24 = Client.cachedPlayers[var3];
                           if(var24 != null) {
                              Client.field1064 = var6;
                              Client.field962 = var7;
                              Client.cursorState = 2;
                              Client.field963 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var16 = class218.method4105(ClientPacket.field2380, Client.field916.field1470);
                              var16.packetBuffer.putShort(var3);
                              var16.packetBuffer.putByte(KeyFocusListener.field606[82]?1:0);
                              Client.field916.method1925(var16);
                           }
                        } else if(var2 == 48) {
                           var24 = Client.cachedPlayers[var3];
                           if(var24 != null) {
                              Client.field1064 = var6;
                              Client.field962 = var7;
                              Client.cursorState = 2;
                              Client.field963 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var16 = class218.method4105(ClientPacket.field2338, Client.field916.field1470);
                              var16.packetBuffer.putShort(var3);
                              var16.packetBuffer.method3343(KeyFocusListener.field606[82]?1:0);
                              Client.field916.method1925(var16);
                           }
                        } else if(var2 == 49) {
                           var24 = Client.cachedPlayers[var3];
                           if(var24 != null) {
                              Client.field1064 = var6;
                              Client.field962 = var7;
                              Client.cursorState = 2;
                              Client.field963 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var16 = class218.method4105(ClientPacket.field2323, Client.field916.field1470);
                              var16.packetBuffer.putShortLE(var3);
                              var16.packetBuffer.method3322(KeyFocusListener.field606[82]?1:0);
                              Client.field916.method1925(var16);
                           }
                        } else if(var2 == 50) {
                           var24 = Client.cachedPlayers[var3];
                           if(var24 != null) {
                              Client.field1064 = var6;
                              Client.field962 = var7;
                              Client.cursorState = 2;
                              Client.field963 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var16 = class218.method4105(ClientPacket.field2354, Client.field916.field1470);
                              var16.packetBuffer.method3307(KeyFocusListener.field606[82]?1:0);
                              var16.packetBuffer.putShortLE(var3);
                              Client.field916.method1925(var16);
                           }
                        } else if(var2 == 51) {
                           var24 = Client.cachedPlayers[var3];
                           if(var24 != null) {
                              Client.field1064 = var6;
                              Client.field962 = var7;
                              Client.cursorState = 2;
                              Client.field963 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var16 = class218.method4105(ClientPacket.field2329, Client.field916.field1470);
                              var16.packetBuffer.method3322(KeyFocusListener.field606[82]?1:0);
                              var16.packetBuffer.putShort(var3);
                              Client.field916.method1925(var16);
                           }
                        } else if(var2 != 1007 && var2 != 57) {
                           if(var2 == 58) {
                              var26 = MilliTimer.method3058(var1, var0);
                              if(var26 != null) {
                                 var16 = class218.method4105(ClientPacket.field2320, Client.field916.field1470);
                                 var16.packetBuffer.putShort(Client.field1011);
                                 var16.packetBuffer.method3400(var1);
                                 var16.packetBuffer.method3332(Client.field917);
                                 var16.packetBuffer.putShort(var26.itemId);
                                 var16.packetBuffer.method3330(var0);
                                 var16.packetBuffer.method3341(class37.field489);
                                 Client.field916.method1925(var16);
                              }
                           } else if(var2 == 1001) {
                              Client.field1064 = var6;
                              Client.field962 = var7;
                              Client.cursorState = 2;
                              Client.field963 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var8 = class218.method4105(ClientPacket.field2390, Client.field916.field1470);
                              var8.packetBuffer.method3330(var3 >> 14 & 32767);
                              var8.packetBuffer.method3330(Occluder.baseY + var1);
                              var8.packetBuffer.method3343(KeyFocusListener.field606[82]?1:0);
                              var8.packetBuffer.putShortLE(var0 + IndexDataBase.baseX);
                              Client.field916.method1925(var8);
                           } else if(var2 == 1002) {
                              Client.field1064 = var6;
                              Client.field962 = var7;
                              Client.cursorState = 2;
                              Client.field963 = 0;
                              var8 = class218.method4105(ClientPacket.field2363, Client.field916.field1470);
                              var8.packetBuffer.method3330(var3 >> 14 & 32767);
                              Client.field916.method1925(var8);
                           } else if(var2 == 1003) {
                              Client.field1064 = var6;
                              Client.field962 = var7;
                              Client.cursorState = 2;
                              Client.field963 = 0;
                              var21 = Client.cachedNPCs[var3];
                              if(var21 != null) {
                                 NPCComposition var28 = var21.composition;
                                 if(var28.configs != null) {
                                    var28 = var28.transform();
                                 }

                                 if(var28 != null) {
                                    var10 = class218.method4105(ClientPacket.field2356, Client.field916.field1470);
                                    var10.packetBuffer.putShortLE(var28.id);
                                    Client.field916.method1925(var10);
                                 }
                              }
                           } else if(var2 == 1004) {
                              Client.field1064 = var6;
                              Client.field962 = var7;
                              Client.cursorState = 2;
                              Client.field963 = 0;
                              var8 = class218.method4105(ClientPacket.field2357, Client.field916.field1470);
                              var8.packetBuffer.putShort(var3);
                              Client.field916.method1925(var8);
                           } else if(var2 == 1005) {
                              var26 = class87.method1762(var1);
                              if(var26 != null && var26.itemQuantities[var0] >= 100000) {
                                 class54.sendGameMessage(27, "", var26.itemQuantities[var0] + " x " + WorldMapType2.getItemDefinition(var3).name);
                              } else {
                                 var16 = class218.method4105(ClientPacket.field2357, Client.field916.field1470);
                                 var16.packetBuffer.putShort(var3);
                                 Client.field916.method1925(var16);
                              }

                              Client.field965 = 0;
                              class51.field622 = class87.method1762(var1);
                              Client.field966 = var0;
                           } else if(var2 == 1010 || var2 == 1009 || var2 == 1008 || var2 == 1011 || var2 == 1012) {
                              MouseInput.renderOverview.method5445(var2, var3, new Coordinates(var0), new Coordinates(var1));
                           }
                        } else {
                           var26 = MilliTimer.method3058(var1, var0);
                           if(var26 != null) {
                              var22 = var26.itemId;
                              Widget var23 = MilliTimer.method3058(var1, var0);
                              if(var23 != null) {
                                 if(var23.field2803 != null) {
                                    ScriptEvent var18 = new ScriptEvent();
                                    var18.widget = var23;
                                    var18.field806 = var3;
                                    var18.field805 = var5;
                                    var18.field797 = var23.field2803;
                                    class14.method95(var18);
                                 }

                                 boolean var11 = true;
                                 if(var23.contentType > 0) {
                                    var11 = Renderable.method2994(var23);
                                 }

                                 if(var11) {
                                    int var19 = ClanMember.getWidgetConfig(var23);
                                    int var20 = var3 - 1;
                                    boolean var12 = (var19 >> var20 + 1 & 1) != 0;
                                    if(var12) {
                                       PacketNode var15;
                                       if(var3 == 1) {
                                          var15 = class218.method4105(ClientPacket.field2316, Client.field916.field1470);
                                          var15.packetBuffer.putInt(var1);
                                          var15.packetBuffer.putShort(var0);
                                          var15.packetBuffer.putShort(var22);
                                          Client.field916.method1925(var15);
                                       }

                                       if(var3 == 2) {
                                          var15 = class218.method4105(ClientPacket.field2308, Client.field916.field1470);
                                          var15.packetBuffer.putInt(var1);
                                          var15.packetBuffer.putShort(var0);
                                          var15.packetBuffer.putShort(var22);
                                          Client.field916.method1925(var15);
                                       }

                                       if(var3 == 3) {
                                          var15 = class218.method4105(ClientPacket.field2332, Client.field916.field1470);
                                          var15.packetBuffer.putInt(var1);
                                          var15.packetBuffer.putShort(var0);
                                          var15.packetBuffer.putShort(var22);
                                          Client.field916.method1925(var15);
                                       }

                                       if(var3 == 4) {
                                          var15 = class218.method4105(ClientPacket.field2346, Client.field916.field1470);
                                          var15.packetBuffer.putInt(var1);
                                          var15.packetBuffer.putShort(var0);
                                          var15.packetBuffer.putShort(var22);
                                          Client.field916.method1925(var15);
                                       }

                                       if(var3 == 5) {
                                          var15 = class218.method4105(ClientPacket.field2373, Client.field916.field1470);
                                          var15.packetBuffer.putInt(var1);
                                          var15.packetBuffer.putShort(var0);
                                          var15.packetBuffer.putShort(var22);
                                          Client.field916.method1925(var15);
                                       }

                                       if(var3 == 6) {
                                          var15 = class218.method4105(ClientPacket.field2339, Client.field916.field1470);
                                          var15.packetBuffer.putInt(var1);
                                          var15.packetBuffer.putShort(var0);
                                          var15.packetBuffer.putShort(var22);
                                          Client.field916.method1925(var15);
                                       }

                                       if(var3 == 7) {
                                          var15 = class218.method4105(ClientPacket.field2358, Client.field916.field1470);
                                          var15.packetBuffer.putInt(var1);
                                          var15.packetBuffer.putShort(var0);
                                          var15.packetBuffer.putShort(var22);
                                          Client.field916.method1925(var15);
                                       }

                                       if(var3 == 8) {
                                          var15 = class218.method4105(ClientPacket.field2325, Client.field916.field1470);
                                          var15.packetBuffer.putInt(var1);
                                          var15.packetBuffer.putShort(var0);
                                          var15.packetBuffer.putShort(var22);
                                          Client.field916.method1925(var15);
                                       }

                                       if(var3 == 9) {
                                          var15 = class218.method4105(ClientPacket.field2312, Client.field916.field1470);
                                          var15.packetBuffer.putInt(var1);
                                          var15.packetBuffer.putShort(var0);
                                          var15.packetBuffer.putShort(var22);
                                          Client.field916.method1925(var15);
                                       }

                                       if(var3 == 10) {
                                          var15 = class218.method4105(ClientPacket.field2367, Client.field916.field1470);
                                          var15.packetBuffer.putInt(var1);
                                          var15.packetBuffer.putShort(var0);
                                          var15.packetBuffer.putShort(var22);
                                          Client.field916.method1925(var15);
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      if(Client.itemSelectionState != 0) {
         Client.itemSelectionState = 0;
         class40.method556(class87.method1762(class214.field2675));
      }

      if(Client.spellSelected) {
         Script.method1909();
      }

      if(class51.field622 != null && Client.field965 == 0) {
         class40.method556(class51.field622);
      }

   }
}
