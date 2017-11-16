import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public class class148 implements Runnable {
   @ObfuscatedName("b")
   final Thread field2092;
   @ObfuscatedName("s")
   volatile boolean field2096;
   @ObfuscatedName("r")
   Queue field2093;

   public class148() {
      this.field2093 = new LinkedList();
      this.field2092 = new Thread(this);
      this.field2092.setPriority(1);
      this.field2092.start();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Led;",
      garbageValue = "-252445271"
   )
   public class149 method2899(URL var1) {
      class149 var2 = new class149(var1);
      synchronized(this) {
         this.field2093.add(var2);
         this.notify();
         return var2;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-655338388"
   )
   public void method2900() {
      this.field2096 = true;

      try {
         synchronized(this) {
            this.notify();
         }

         this.field2092.join();
      } catch (InterruptedException var4) {
         ;
      }

   }

   public void run() {
      while(!this.field2096) {
         try {
            class149 var1;
            synchronized(this) {
               var1 = (class149)this.field2093.poll();
               if(var1 == null) {
                  try {
                     this.wait();
                  } catch (InterruptedException var13) {
                     ;
                  }
                  continue;
               }
            }

            DataInputStream var2 = null;
            URLConnection var3 = null;

            try {
               var3 = var1.field2101.openConnection();
               var3.setConnectTimeout(5000);
               var3.setReadTimeout(5000);
               var3.setUseCaches(false);
               var3.setRequestProperty("Connection", "close");
               int var4 = var3.getContentLength();
               if(var4 >= 0) {
                  byte[] var5 = new byte[var4];
                  var2 = new DataInputStream(var3.getInputStream());
                  var2.readFully(var5);
                  var1.field2100 = var5;
               }

               var1.field2098 = true;
            } catch (IOException var14) {
               var1.field2098 = true;
            } finally {
               if(var2 != null) {
                  var2.close();
               }

               if(var3 != null && var3 instanceof HttpURLConnection) {
                  ((HttpURLConnection)var3).disconnect();
               }

            }
         } catch (Exception var17) {
            class48.method690((String)null, var17);
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lij;Lij;Lij;Lhj;I)Z",
      garbageValue = "561994359"
   )
   public static boolean method2912(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, class211 var3) {
      class210.field2590 = var0;
      class210.field2589 = var1;
      class74.field845 = var2;
      class210.field2587 = var3;
      return true;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfs;II)V",
      garbageValue = "1995078034"
   )
   public static void method2911(Buffer var0, int var1) {
      if(class156.field2151 != null) {
         try {
            class156.field2151.seek(0L);
            class156.field2151.write(var0.payload, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(Lbw;II)V",
      garbageValue = "320350861"
   )
   static final void method2910(Actor var0, int var1) {
      int var2;
      int var3;
      int var4;
      if(var0.field1178 > Client.gameCycle) {
         var2 = var0.field1178 - Client.gameCycle;
         var3 = var0.field1186 * 128 + var0.field1148 * 64;
         var4 = var0.field1162 * 128 + var0.field1148 * 64;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field1202 = 0;
         var0.orientation = var0.field1195;
      } else if(var0.field1191 >= Client.gameCycle) {
         TextureProvider.method2414(var0);
      } else {
         var0.poseAnimation = var0.idlePoseAnimation;
         if(var0.queueSize == 0) {
            var0.field1202 = 0;
         } else {
            label274: {
               if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
                  Sequence var11 = class90.getAnimation(var0.animation);
                  if(var0.field1203 > 0 && var11.precedenceAnimating == 0) {
                     ++var0.field1202;
                     break label274;
                  }

                  if(var0.field1203 <= 0 && var11.priority == 0) {
                     ++var0.field1202;
                     break label274;
                  }
               }

               var2 = var0.x;
               var3 = var0.y;
               var4 = var0.pathX[var0.queueSize - 1] * 128 + var0.field1148 * 64;
               int var5 = var0.pathY[var0.queueSize - 1] * 128 + var0.field1148 * 64;
               if(var2 < var4) {
                  if(var3 < var5) {
                     var0.orientation = 1280;
                  } else if(var3 > var5) {
                     var0.orientation = 1792;
                  } else {
                     var0.orientation = 1536;
                  }
               } else if(var2 > var4) {
                  if(var3 < var5) {
                     var0.orientation = 768;
                  } else if(var3 > var5) {
                     var0.orientation = 256;
                  } else {
                     var0.orientation = 512;
                  }
               } else if(var3 < var5) {
                  var0.orientation = 1024;
               } else if(var3 > var5) {
                  var0.orientation = 0;
               }

               byte var6 = var0.field1189[var0.queueSize - 1];
               if(var4 - var2 <= 256 && var4 - var2 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                  int var7 = var0.orientation - var0.angle & 2047;
                  if(var7 > 1024) {
                     var7 -= 2048;
                  }

                  int var8 = var0.field1153;
                  if(var7 >= -256 && var7 <= 256) {
                     var8 = var0.field1152;
                  } else if(var7 >= 256 && var7 < 768) {
                     var8 = var0.field1155;
                  } else if(var7 >= -768 && var7 <= -256) {
                     var8 = var0.field1154;
                  }

                  if(var8 == -1) {
                     var8 = var0.field1152;
                  }

                  var0.poseAnimation = var8;
                  int var9 = 4;
                  boolean var10 = true;
                  if(var0 instanceof NPC) {
                     var10 = ((NPC)var0).composition.isClickable;
                  }

                  if(var10) {
                     if(var0.angle != var0.orientation && var0.interacting == -1 && var0.field1197 != 0) {
                        var9 = 2;
                     }

                     if(var0.queueSize > 2) {
                        var9 = 6;
                     }

                     if(var0.queueSize > 3) {
                        var9 = 8;
                     }

                     if(var0.field1202 > 0 && var0.queueSize > 1) {
                        var9 = 8;
                        --var0.field1202;
                     }
                  } else {
                     if(var0.queueSize > 1) {
                        var9 = 6;
                     }

                     if(var0.queueSize > 2) {
                        var9 = 8;
                     }

                     if(var0.field1202 > 0 && var0.queueSize > 1) {
                        var9 = 8;
                        --var0.field1202;
                     }
                  }

                  if(var6 == 2) {
                     var9 <<= 1;
                  }

                  if(var9 >= 8 && var0.poseAnimation == var0.field1152 && var0.field1166 != -1) {
                     var0.poseAnimation = var0.field1166;
                  }

                  if(var2 != var4 || var3 != var5) {
                     if(var2 < var4) {
                        var0.x += var9;
                        if(var0.x > var4) {
                           var0.x = var4;
                        }
                     } else if(var2 > var4) {
                        var0.x -= var9;
                        if(var0.x < var4) {
                           var0.x = var4;
                        }
                     }

                     if(var3 < var5) {
                        var0.y += var9;
                        if(var0.y > var5) {
                           var0.y = var5;
                        }
                     } else if(var3 > var5) {
                        var0.y -= var9;
                        if(var0.y < var5) {
                           var0.y = var5;
                        }
                     }
                  }

                  if(var4 == var0.x && var5 == var0.y) {
                     --var0.queueSize;
                     if(var0.field1203 > 0) {
                        --var0.field1203;
                     }
                  }
               } else {
                  var0.x = var4;
                  var0.y = var5;
                  --var0.queueSize;
                  if(var0.field1203 > 0) {
                     --var0.field1203;
                  }
               }
            }
         }
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1178 = 0;
         var0.field1191 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1148 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1148 * 64;
         var0.method1496();
      }

      if(class275.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1178 = 0;
         var0.field1191 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1148 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1148 * 64;
         var0.method1496();
      }

      ScriptVarType.method18(var0);
      class61.method997(var0);
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "([Lhx;IIIIIIIB)V",
      garbageValue = "80"
   )
   static final void method2914(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2793 || class12.getWidgetConfig(var9) != 0 || var9 == Client.field1021 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !class2.method2(var9))) {
            int var10 = var9.relativeX + var6;
            int var11 = var7 + var9.relativeY;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var19;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               int var18 = var10 + var9.width;
               var19 = var11 + var9.height;
               if(var18 < var10) {
                  var16 = var18;
                  var18 = var10;
               }

               if(var19 < var11) {
                  var17 = var19;
                  var19 = var11;
               }

               ++var18;
               ++var19;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var18 < var4?var18:var4;
               var15 = var19 < var5?var19:var5;
            } else {
               var16 = var10 + var9.width;
               var17 = var11 + var9.height;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == Client.field1020) {
               Client.field1028 = true;
               Client.field1029 = var10;
               Client.field1030 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = MouseInput.field681;
               var17 = MouseInput.field676;
               if(MouseInput.field687 != 0) {
                  var16 = MouseInput.field674;
                  var17 = MouseInput.field688;
               }

               boolean var44 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               int var20;
               int var21;
               int var22;
               int var23;
               int var24;
               int var25;
               int var28;
               int var40;
               if(var9.contentType == 1337) {
                  if(!Client.field1005 && !Client.isMenuOpen && var44) {
                     if(Client.itemSelectionState == 0 && !Client.spellSelected) {
                        WorldMapData.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var19 = -1;
                     var20 = -1;

                     for(var21 = 0; var21 < class133.field1907; ++var21) {
                        var22 = class133.field1902[var21];
                        var23 = var22 & 127;
                        var24 = var22 >> 7 & 127;
                        var25 = var22 >> 29 & 3;
                        int var26 = var22 >> 14 & 32767;
                        if(var22 != var20) {
                           var20 = var22;
                           if(var25 == 2 && Client.region.method2718(class28.plane, var23, var24, var22) >= 0) {
                              ObjectComposition var48 = ClientPacket.getObjectDefinition(var26);
                              if(var48.impostorIds != null) {
                                 var48 = var48.getImpostor();
                              }

                              if(var48 == null) {
                                 continue;
                              }

                              if(Client.itemSelectionState == 1) {
                                 WorldMapData.addMenuEntry("Use", Client.field1001 + " " + "->" + " " + class222.getColTags(65535) + var48.name, 1, var22, var23, var24);
                              } else if(Client.spellSelected) {
                                 if((class28.field387 & 4) == 4) {
                                    WorldMapData.addMenuEntry(Client.field1045, Client.field948 + " " + "->" + " " + class222.getColTags(65535) + var48.name, 2, var22, var23, var24);
                                 }
                              } else {
                                 String[] var34 = var48.actions;
                                 if(Client.field1018) {
                                    var34 = Area.method4292(var34);
                                 }

                                 if(var34 != null) {
                                    for(var40 = 4; var40 >= 0; --var40) {
                                       if(var34[var40] != null) {
                                          short var54 = 0;
                                          if(var40 == 0) {
                                             var54 = 3;
                                          }

                                          if(var40 == 1) {
                                             var54 = 4;
                                          }

                                          if(var40 == 2) {
                                             var54 = 5;
                                          }

                                          if(var40 == 3) {
                                             var54 = 6;
                                          }

                                          if(var40 == 4) {
                                             var54 = 1001;
                                          }

                                          WorldMapData.addMenuEntry(var34[var40], class222.getColTags(65535) + var48.name, var54, var22, var23, var24);
                                       }
                                    }
                                 }

                                 WorldMapData.addMenuEntry("Examine", class222.getColTags(65535) + var48.name, 1002, var48.id << 14, var23, var24);
                              }
                           }

                           NPC var29;
                           Player var31;
                           int[] var49;
                           int var55;
                           if(var25 == 1) {
                              NPC var50 = Client.cachedNPCs[var26];
                              if(var50 == null) {
                                 continue;
                              }

                              if(var50.composition.field3606 == 1 && (var50.x & 127) == 64 && (var50.y & 127) == 64) {
                                 for(var28 = 0; var28 < Client.npcIndexesCount; ++var28) {
                                    var29 = Client.cachedNPCs[Client.npcIndices[var28]];
                                    if(var29 != null && var29 != var50 && var29.composition.field3606 == 1 && var29.x == var50.x && var29.y == var50.y) {
                                       MilliTimer.method2936(var29.composition, Client.npcIndices[var28], var23, var24);
                                    }
                                 }

                                 var28 = class94.playerIndexesCount;
                                 var49 = class94.playerIndices;

                                 for(var55 = 0; var55 < var28; ++var55) {
                                    var31 = Client.cachedPlayers[var49[var55]];
                                    if(var31 != null && var50.x == var31.x && var31.y == var50.y) {
                                       VertexNormal.method2597(var31, var49[var55], var23, var24);
                                    }
                                 }
                              }

                              MilliTimer.method2936(var50.composition, var26, var23, var24);
                           }

                           if(var25 == 0) {
                              Player var51 = Client.cachedPlayers[var26];
                              if(var51 == null) {
                                 continue;
                              }

                              if((var51.x & 127) == 64 && (var51.y & 127) == 64) {
                                 for(var28 = 0; var28 < Client.npcIndexesCount; ++var28) {
                                    var29 = Client.cachedNPCs[Client.npcIndices[var28]];
                                    if(var29 != null && var29.composition.field3606 == 1 && var29.x == var51.x && var29.y == var51.y) {
                                       MilliTimer.method2936(var29.composition, Client.npcIndices[var28], var23, var24);
                                    }
                                 }

                                 var28 = class94.playerIndexesCount;
                                 var49 = class94.playerIndices;

                                 for(var55 = 0; var55 < var28; ++var55) {
                                    var31 = Client.cachedPlayers[var49[var55]];
                                    if(var31 != null && var31 != var51 && var31.x == var51.x && var51.y == var31.y) {
                                       VertexNormal.method2597(var31, var49[var55], var23, var24);
                                    }
                                 }
                              }

                              if(var26 != Client.field1070) {
                                 VertexNormal.method2597(var51, var26, var23, var24);
                              } else {
                                 var19 = var22;
                              }
                           }

                           if(var25 == 3) {
                              Deque var52 = Client.groundItemDeque[class28.plane][var23][var24];
                              if(var52 != null) {
                                 for(Item var56 = (Item)var52.getTail(); var56 != null; var56 = (Item)var52.getPrevious()) {
                                    ItemComposition var53 = class139.getItemDefinition(var56.id);
                                    if(Client.itemSelectionState == 1) {
                                       WorldMapData.addMenuEntry("Use", Client.field1001 + " " + "->" + " " + class222.getColTags(16748608) + var53.name, 16, var56.id, var23, var24);
                                    } else if(Client.spellSelected) {
                                       if((class28.field387 & 1) == 1) {
                                          WorldMapData.addMenuEntry(Client.field1045, Client.field948 + " " + "->" + " " + class222.getColTags(16748608) + var53.name, 17, var56.id, var23, var24);
                                       }
                                    } else {
                                       String[] var35 = var53.groundActions;
                                       if(Client.field1018) {
                                          var35 = Area.method4292(var35);
                                       }

                                       for(int var36 = 4; var36 >= 0; --var36) {
                                          if(var35 != null && var35[var36] != null) {
                                             byte var32 = 0;
                                             if(var36 == 0) {
                                                var32 = 18;
                                             }

                                             if(var36 == 1) {
                                                var32 = 19;
                                             }

                                             if(var36 == 2) {
                                                var32 = 20;
                                             }

                                             if(var36 == 3) {
                                                var32 = 21;
                                             }

                                             if(var36 == 4) {
                                                var32 = 22;
                                             }

                                             WorldMapData.addMenuEntry(var35[var36], class222.getColTags(16748608) + var53.name, var32, var56.id, var23, var24);
                                          } else if(var36 == 2) {
                                             WorldMapData.addMenuEntry("Take", class222.getColTags(16748608) + var53.name, 20, var56.id, var23, var24);
                                          }
                                       }

                                       WorldMapData.addMenuEntry("Examine", class222.getColTags(16748608) + var53.name, 1004, var56.id, var23, var24);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var19 != -1) {
                        var21 = var19 & 127;
                        var22 = var19 >> 7 & 127;
                        Player var33 = Client.cachedPlayers[Client.field1070];
                        VertexNormal.method2597(var33, Client.field1070, var21, var22);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  Varcs.method1803(var9, var10, var11);
               } else {
                  if(var9.contentType == 1400) {
                     ScriptState.renderOverview.method5240(MouseInput.field681, MouseInput.field676, var44, var10, var11, var9.width, var9.height);
                  }

                  boolean var47;
                  if(!Client.isMenuOpen && var44) {
                     if(var9.contentType == 1400) {
                        ScriptState.renderOverview.method5287(var10, var11, var9.width, var9.height, var16, var17);
                     } else {
                        var19 = var16 - var10;
                        var20 = var17 - var11;
                        if(var9.field2724 == 1) {
                           WorldMapData.addMenuEntry(var9.tooltip, "", 24, 0, 0, var9.id);
                        }

                        String var38;
                        if(var9.field2724 == 2 && !Client.spellSelected) {
                           var23 = class12.getWidgetConfig(var9);
                           var22 = var23 >> 11 & 63;
                           if(var22 == 0) {
                              var38 = null;
                           } else if(var9.selectedAction != null && var9.selectedAction.trim().length() != 0) {
                              var38 = var9.selectedAction;
                           } else {
                              var38 = null;
                           }

                           if(var38 != null) {
                              WorldMapData.addMenuEntry(var38, class222.getColTags(65280) + var9.field2797, 25, 0, -1, var9.id);
                           }
                        }

                        if(var9.field2724 == 3) {
                           WorldMapData.addMenuEntry("Close", "", 26, 0, 0, var9.id);
                        }

                        if(var9.field2724 == 4) {
                           WorldMapData.addMenuEntry(var9.tooltip, "", 28, 0, 0, var9.id);
                        }

                        if(var9.field2724 == 5) {
                           WorldMapData.addMenuEntry(var9.tooltip, "", 29, 0, 0, var9.id);
                        }

                        if(var9.field2724 == 6 && Client.field878 == null) {
                           WorldMapData.addMenuEntry(var9.tooltip, "", 30, 0, -1, var9.id);
                        }

                        if(var9.type == 2) {
                           var21 = 0;

                           for(var22 = 0; var22 < var9.height; ++var22) {
                              for(var23 = 0; var23 < var9.width; ++var23) {
                                 var24 = var23 * (var9.paddingX + 32);
                                 var25 = var22 * (var9.paddingY + 32);
                                 if(var21 < 20) {
                                    var24 += var9.xSprites[var21];
                                    var25 += var9.field2782[var21];
                                 }

                                 if(var19 >= var24 && var20 >= var25 && var19 < var24 + 32 && var20 < var25 + 32) {
                                    Client.field1111 = var21;
                                    Widget.field2709 = var9;
                                    if(var9.itemIds[var21] > 0) {
                                       ItemComposition var43 = class139.getItemDefinition(var9.itemIds[var21] - 1);
                                       if(Client.itemSelectionState == 1 && class184.method3432(class12.getWidgetConfig(var9))) {
                                          if(var9.id != class268.field3677 || var21 != WorldMapType3.selectedItemIndex) {
                                             WorldMapData.addMenuEntry("Use", Client.field1001 + " " + "->" + " " + class222.getColTags(16748608) + var43.name, 31, var43.id, var21, var9.id);
                                          }
                                       } else if(Client.spellSelected && class184.method3432(class12.getWidgetConfig(var9))) {
                                          if((class28.field387 & 16) == 16) {
                                             WorldMapData.addMenuEntry(Client.field1045, Client.field948 + " " + "->" + " " + class222.getColTags(16748608) + var43.name, 32, var43.id, var21, var9.id);
                                          }
                                       } else {
                                          String[] var27 = var43.inventoryActions;
                                          if(Client.field1018) {
                                             var27 = Area.method4292(var27);
                                          }

                                          var28 = -1;
                                          if(Client.field995 && KeyFocusListener.field578[81]) {
                                             var28 = var43.method4584();
                                          }

                                          if(class184.method3432(class12.getWidgetConfig(var9))) {
                                             for(var40 = 4; var40 >= 3; --var40) {
                                                if(var40 != var28) {
                                                   class74.method1099(var9, var43, var21, var40, false);
                                                }
                                             }
                                          }

                                          if(class25.method178(class12.getWidgetConfig(var9))) {
                                             WorldMapData.addMenuEntry("Use", class222.getColTags(16748608) + var43.name, 38, var43.id, var21, var9.id);
                                          }

                                          if(class184.method3432(class12.getWidgetConfig(var9))) {
                                             for(var40 = 2; var40 >= 0; --var40) {
                                                if(var28 != var40) {
                                                   class74.method1099(var9, var43, var21, var40, false);
                                                }
                                             }

                                             if(var28 >= 0) {
                                                class74.method1099(var9, var43, var21, var28, true);
                                             }
                                          }

                                          var27 = var9.configActions;
                                          if(Client.field1018) {
                                             var27 = Area.method4292(var27);
                                          }

                                          if(var27 != null) {
                                             for(var40 = 4; var40 >= 0; --var40) {
                                                if(var27[var40] != null) {
                                                   byte var30 = 0;
                                                   if(var40 == 0) {
                                                      var30 = 39;
                                                   }

                                                   if(var40 == 1) {
                                                      var30 = 40;
                                                   }

                                                   if(var40 == 2) {
                                                      var30 = 41;
                                                   }

                                                   if(var40 == 3) {
                                                      var30 = 42;
                                                   }

                                                   if(var40 == 4) {
                                                      var30 = 43;
                                                   }

                                                   WorldMapData.addMenuEntry(var27[var40], class222.getColTags(16748608) + var43.name, var30, var43.id, var21, var9.id);
                                                }
                                             }
                                          }

                                          WorldMapData.addMenuEntry("Examine", class222.getColTags(16748608) + var43.name, 1005, var43.id, var21, var9.id);
                                       }
                                    }
                                 }

                                 ++var21;
                              }
                           }
                        }

                        if(var9.hasScript) {
                           if(Client.spellSelected) {
                              var22 = class12.getWidgetConfig(var9);
                              var47 = (var22 >> 21 & 1) != 0;
                              if(var47 && (class28.field387 & 32) == 32) {
                                 WorldMapData.addMenuEntry(Client.field1045, Client.field948 + " " + "->" + " " + var9.name, 58, 0, var9.index, var9.id);
                              }
                           } else {
                              for(var21 = 9; var21 >= 5; --var21) {
                                 String var42 = class43.method588(var9, var21);
                                 if(var42 != null) {
                                    WorldMapData.addMenuEntry(var42, var9.name, 1007, var21 + 1, var9.index, var9.id);
                                 }
                              }

                              var23 = class12.getWidgetConfig(var9);
                              var22 = var23 >> 11 & 63;
                              if(var22 == 0) {
                                 var38 = null;
                              } else if(var9.selectedAction != null && var9.selectedAction.trim().length() != 0) {
                                 var38 = var9.selectedAction;
                              } else {
                                 var38 = null;
                              }

                              if(var38 != null) {
                                 WorldMapData.addMenuEntry(var38, var9.name, 25, 0, var9.index, var9.id);
                              }

                              for(var23 = 4; var23 >= 0; --var23) {
                                 String var39 = class43.method588(var9, var23);
                                 if(var39 != null) {
                                    WorldMapData.addMenuEntry(var39, var9.name, 57, var23 + 1, var9.index, var9.id);
                                 }
                              }

                              if(class81.method1588(class12.getWidgetConfig(var9))) {
                                 WorldMapData.addMenuEntry("Continue", "", 30, 0, var9.index, var9.id);
                              }
                           }
                        }
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && class2.method2(var9) && var9 != class13.field264) {
                        continue;
                     }

                     method2914(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method2914(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var37 = (WidgetNode)Client.componentTable.get((long)var9.id);
                     if(var37 != null) {
                        if(var37.owner == 0 && MouseInput.field681 >= var12 && MouseInput.field676 >= var13 && MouseInput.field681 < var14 && MouseInput.field676 < var15 && !Client.isMenuOpen && !Client.field1017) {
                           for(ScriptEvent var41 = (ScriptEvent)Client.field862.getFront(); var41 != null; var41 = (ScriptEvent)Client.field862.getNext()) {
                              if(var41.field776) {
                                 var41.unlink();
                                 var41.widget.field2846 = false;
                              }
                           }

                           if(class61.field711 == 0) {
                              Client.field1020 = null;
                              Client.field1021 = null;
                           }

                           if(!Client.isMenuOpen) {
                              WidgetNode.method1027();
                           }
                        }

                        class264.method4631(var37.id, var12, var13, var14, var15, var10, var11);
                     }
                  }

                  if(var9.hasScript) {
                     ScriptEvent var57;
                     if(!var9.noClickThrough) {
                        if(var9.field2847 && MouseInput.field681 >= var12 && MouseInput.field676 >= var13 && MouseInput.field681 < var14 && MouseInput.field676 < var15) {
                           for(var57 = (ScriptEvent)Client.field862.getFront(); var57 != null; var57 = (ScriptEvent)Client.field862.getNext()) {
                              if(var57.field776 && var57.widget.scrollListener == var57.field785) {
                                 var57.unlink();
                              }
                           }
                        }
                     } else if(MouseInput.field681 >= var12 && MouseInput.field676 >= var13 && MouseInput.field681 < var14 && MouseInput.field676 < var15) {
                        for(var57 = (ScriptEvent)Client.field862.getFront(); var57 != null; var57 = (ScriptEvent)Client.field862.getNext()) {
                           if(var57.field776) {
                              var57.unlink();
                              var57.widget.field2846 = false;
                           }
                        }

                        if(class61.field711 == 0) {
                           Client.field1020 = null;
                           Client.field1021 = null;
                        }

                        if(!Client.isMenuOpen) {
                           WidgetNode.method1027();
                        }
                     }

                     if(MouseInput.field681 >= var12 && MouseInput.field676 >= var13 && MouseInput.field681 < var14 && MouseInput.field676 < var15) {
                        var44 = true;
                     } else {
                        var44 = false;
                     }

                     boolean var46 = false;
                     if((MouseInput.field689 == 1 || !Signlink.field2142 && MouseInput.field689 == 4) && var44) {
                        var46 = true;
                     }

                     boolean var45 = false;
                     if((MouseInput.field687 == 1 || !Signlink.field2142 && MouseInput.field687 == 4) && MouseInput.field674 >= var12 && MouseInput.field688 >= var13 && MouseInput.field674 < var14 && MouseInput.field688 < var15) {
                        var45 = true;
                     }

                     if(var45) {
                        class44.method595(var9, MouseInput.field674 - var10, MouseInput.field688 - var11);
                     }

                     if(var9.contentType == 1400) {
                        ScriptState.renderOverview.method5241(MouseInput.field681, MouseInput.field676, var44 & var46, var44 & var45);
                     }

                     if(Client.field1020 != null && var9 != Client.field1020 && var44) {
                        var22 = class12.getWidgetConfig(var9);
                        var47 = (var22 >> 20 & 1) != 0;
                        if(var47) {
                           Client.field1024 = var9;
                        }
                     }

                     if(var9 == Client.field1021) {
                        Client.field1025 = true;
                        Client.field1026 = var10;
                        Client.field1059 = var11;
                     }

                     if(var9.field2793) {
                        ScriptEvent var59;
                        if(var44 && Client.field985 != 0 && var9.scrollListener != null) {
                           var59 = new ScriptEvent();
                           var59.field776 = true;
                           var59.widget = var9;
                           var59.field775 = Client.field985;
                           var59.field785 = var9.scrollListener;
                           Client.field862.addFront(var59);
                        }

                        if(Client.field1020 != null || class72.field812 != null || Client.isMenuOpen) {
                           var45 = false;
                           var46 = false;
                           var44 = false;
                        }

                        if(!var9.field2839 && var45) {
                           var9.field2839 = true;
                           if(var9.field2795 != null) {
                              var59 = new ScriptEvent();
                              var59.field776 = true;
                              var59.widget = var9;
                              var59.field778 = MouseInput.field674 - var10;
                              var59.field775 = MouseInput.field688 - var11;
                              var59.field785 = var9.field2795;
                              Client.field862.addFront(var59);
                           }
                        }

                        if(var9.field2839 && var46 && var9.field2796 != null) {
                           var59 = new ScriptEvent();
                           var59.field776 = true;
                           var59.widget = var9;
                           var59.field778 = MouseInput.field681 - var10;
                           var59.field775 = MouseInput.field676 - var11;
                           var59.field785 = var9.field2796;
                           Client.field862.addFront(var59);
                        }

                        if(var9.field2839 && !var46) {
                           var9.field2839 = false;
                           if(var9.field2766 != null) {
                              var59 = new ScriptEvent();
                              var59.field776 = true;
                              var59.widget = var9;
                              var59.field778 = MouseInput.field681 - var10;
                              var59.field775 = MouseInput.field676 - var11;
                              var59.field785 = var9.field2766;
                              Client.field1048.addFront(var59);
                           }
                        }

                        if(var46 && var9.field2798 != null) {
                           var59 = new ScriptEvent();
                           var59.field776 = true;
                           var59.widget = var9;
                           var59.field778 = MouseInput.field681 - var10;
                           var59.field775 = MouseInput.field676 - var11;
                           var59.field785 = var9.field2798;
                           Client.field862.addFront(var59);
                        }

                        if(!var9.field2846 && var44) {
                           var9.field2846 = true;
                           if(var9.mouseEnterListener != null) {
                              var59 = new ScriptEvent();
                              var59.field776 = true;
                              var59.widget = var9;
                              var59.field778 = MouseInput.field681 - var10;
                              var59.field775 = MouseInput.field676 - var11;
                              var59.field785 = var9.mouseEnterListener;
                              Client.field862.addFront(var59);
                           }
                        }

                        if(var9.field2846 && var44 && var9.mouseHoverListener != null) {
                           var59 = new ScriptEvent();
                           var59.field776 = true;
                           var59.widget = var9;
                           var59.field778 = MouseInput.field681 - var10;
                           var59.field775 = MouseInput.field676 - var11;
                           var59.field785 = var9.mouseHoverListener;
                           Client.field862.addFront(var59);
                        }

                        if(var9.field2846 && !var44) {
                           var9.field2846 = false;
                           if(var9.mouseExitListener != null) {
                              var59 = new ScriptEvent();
                              var59.field776 = true;
                              var59.widget = var9;
                              var59.field778 = MouseInput.field681 - var10;
                              var59.field775 = MouseInput.field676 - var11;
                              var59.field785 = var9.mouseExitListener;
                              Client.field1048.addFront(var59);
                           }
                        }

                        if(var9.renderListener != null) {
                           var59 = new ScriptEvent();
                           var59.widget = var9;
                           var59.field785 = var9.renderListener;
                           Client.field1047.addFront(var59);
                        }

                        ScriptEvent var58;
                        if(var9.configListenerArgs != null && Client.field1034 > var9.field2752) {
                           if(var9.configTriggers != null && Client.field1034 - var9.field2752 <= 32) {
                              label1319:
                              for(var21 = var9.field2752; var21 < Client.field1034; ++var21) {
                                 var22 = Client.field1033[var21 & 31];

                                 for(var23 = 0; var23 < var9.configTriggers.length; ++var23) {
                                    if(var22 == var9.configTriggers[var23]) {
                                       var58 = new ScriptEvent();
                                       var58.widget = var9;
                                       var58.field785 = var9.configListenerArgs;
                                       Client.field862.addFront(var58);
                                       break label1319;
                                    }
                                 }
                              }
                           } else {
                              var59 = new ScriptEvent();
                              var59.widget = var9;
                              var59.field785 = var9.configListenerArgs;
                              Client.field862.addFront(var59);
                           }

                           var9.field2752 = Client.field1034;
                        }

                        if(var9.tableListenerArgs != null && Client.field973 > var9.field2730) {
                           if(var9.tableModTriggers != null && Client.field973 - var9.field2730 <= 32) {
                              label1295:
                              for(var21 = var9.field2730; var21 < Client.field973; ++var21) {
                                 var22 = Client.interfaceItemTriggers[var21 & 31];

                                 for(var23 = 0; var23 < var9.tableModTriggers.length; ++var23) {
                                    if(var22 == var9.tableModTriggers[var23]) {
                                       var58 = new ScriptEvent();
                                       var58.widget = var9;
                                       var58.field785 = var9.tableListenerArgs;
                                       Client.field862.addFront(var58);
                                       break label1295;
                                    }
                                 }
                              }
                           } else {
                              var59 = new ScriptEvent();
                              var59.widget = var9;
                              var59.field785 = var9.tableListenerArgs;
                              Client.field862.addFront(var59);
                           }

                           var9.field2730 = Client.field973;
                        }

                        if(var9.skillListenerArgs != null && Client.field1038 > var9.field2843) {
                           if(var9.skillTriggers != null && Client.field1038 - var9.field2843 <= 32) {
                              label1271:
                              for(var21 = var9.field2843; var21 < Client.field1038; ++var21) {
                                 var22 = Client.field1037[var21 & 31];

                                 for(var23 = 0; var23 < var9.skillTriggers.length; ++var23) {
                                    if(var22 == var9.skillTriggers[var23]) {
                                       var58 = new ScriptEvent();
                                       var58.widget = var9;
                                       var58.field785 = var9.skillListenerArgs;
                                       Client.field862.addFront(var58);
                                       break label1271;
                                    }
                                 }
                              }
                           } else {
                              var59 = new ScriptEvent();
                              var59.widget = var9;
                              var59.field785 = var9.skillListenerArgs;
                              Client.field862.addFront(var59);
                           }

                           var9.field2843 = Client.field1038;
                        }

                        if(Client.chatCycle > var9.field2840 && var9.field2815 != null) {
                           var59 = new ScriptEvent();
                           var59.widget = var9;
                           var59.field785 = var9.field2815;
                           Client.field862.addFront(var59);
                        }

                        if(Client.field1040 > var9.field2840 && var9.field2817 != null) {
                           var59 = new ScriptEvent();
                           var59.widget = var9;
                           var59.field785 = var9.field2817;
                           Client.field862.addFront(var59);
                        }

                        if(Client.field1046 > var9.field2840 && var9.field2804 != null) {
                           var59 = new ScriptEvent();
                           var59.widget = var9;
                           var59.field785 = var9.field2804;
                           Client.field862.addFront(var59);
                        }

                        if(Client.field1042 > var9.field2840 && var9.field2823 != null) {
                           var59 = new ScriptEvent();
                           var59.widget = var9;
                           var59.field785 = var9.field2823;
                           Client.field862.addFront(var59);
                        }

                        if(Client.field967 > var9.field2840 && var9.field2824 != null) {
                           var59 = new ScriptEvent();
                           var59.widget = var9;
                           var59.field785 = var9.field2824;
                           Client.field862.addFront(var59);
                        }

                        if(Client.field864 > var9.field2840 && var9.field2702 != null) {
                           var59 = new ScriptEvent();
                           var59.widget = var9;
                           var59.field785 = var9.field2702;
                           Client.field862.addFront(var59);
                        }

                        var9.field2840 = Client.cycleCntr;
                        if(var9.field2731 != null) {
                           for(var21 = 0; var21 < Client.field1068; ++var21) {
                              ScriptEvent var60 = new ScriptEvent();
                              var60.widget = var9;
                              var60.field782 = Client.field970[var21];
                              var60.field780 = Client.field1069[var21];
                              var60.field785 = var9.field2731;
                              Client.field862.addFront(var60);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.field1020 == null && class72.field812 == null && !Client.isMenuOpen) {
                     if((var9.field2828 >= 0 || var9.field2838 != 0) && MouseInput.field681 >= var12 && MouseInput.field676 >= var13 && MouseInput.field681 < var14 && MouseInput.field676 < var15) {
                        if(var9.field2828 >= 0) {
                           class13.field264 = var0[var9.field2828];
                        } else {
                           class13.field264 = var9;
                        }
                     }

                     if(var9.type == 8 && MouseInput.field681 >= var12 && MouseInput.field676 >= var13 && MouseInput.field681 < var14 && MouseInput.field676 < var15) {
                        class29.field394 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        Frames.method2879(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, MouseInput.field681, MouseInput.field676);
                     }
                  }
               }
            }
         }
      }

   }
}
