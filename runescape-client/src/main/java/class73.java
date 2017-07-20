import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class73 extends class163 {
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = -607288251
   )
   @Export("cameraX")
   static int cameraX;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIILfu;I)Z",
      garbageValue = "2144325259"
   )
   protected boolean vmethod2998(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2274 && var3 == super.field2272;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lfv;ILbt;II)V",
      garbageValue = "-1871834075"
   )
   static final void method1068(PacketBuffer var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 4) != 0) {
         var5 = var0.readUnsignedByte();
         byte[] var6 = new byte[var5];
         Buffer var7 = new Buffer(var6);
         var0.readBytes(var6, 0, var5);
         class96.field1475[var1] = var7;
         var2.decodeApperance(var7);
      }

      int var18;
      if((var3 & 16) != 0) {
         var5 = var0.readUnsignedShort();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var18 = var0.readUnsignedByte();
         class14.method81(var2, var5, var18);
      }

      if((var3 & 128) != 0) {
         var2.interacting = var0.readUnsignedShort();
         if(var2.interacting == '\uffff') {
            var2.interacting = -1;
         }
      }

      if((var3 & 64) != 0) {
         var2.overhead = var0.readString();
         if(var2.overhead.charAt(0) == 126) {
            var2.overhead = var2.overhead.substring(1);
            Item.sendGameMessage(2, var2.name, var2.overhead);
         } else if(var2 == class226.localPlayer) {
            Item.sendGameMessage(2, var2.name, var2.overhead);
         }

         var2.field1223 = false;
         var2.field1226 = 0;
         var2.field1227 = 0;
         var2.field1225 = 150;
      }

      int var8;
      int var9;
      if((var3 & 2) != 0) {
         var5 = var0.readUnsignedByte();
         int var10;
         int var11;
         int var19;
         if(var5 > 0) {
            for(var18 = 0; var18 < var5; ++var18) {
               var8 = -1;
               var9 = -1;
               var10 = -1;
               var19 = var0.getUSmart();
               if(var19 == 32767) {
                  var19 = var0.getUSmart();
                  var9 = var0.getUSmart();
                  var8 = var0.getUSmart();
                  var10 = var0.getUSmart();
               } else if(var19 != 32766) {
                  var9 = var0.getUSmart();
               } else {
                  var19 = -1;
               }

               var11 = var0.getUSmart();
               var2.method1487(var19, var9, var8, var10, Client.gameCycle, var11);
            }
         }

         var18 = var0.readUnsignedByte();
         if(var18 > 0) {
            for(var19 = 0; var19 < var18; ++var19) {
               var8 = var0.getUSmart();
               var9 = var0.getUSmart();
               if(var9 != 32767) {
                  var10 = var0.getUSmart();
                  var11 = var0.readUnsignedByte();
                  int var12 = var9 > 0?var0.readUnsignedByte():var11;
                  var2.method1477(var8, Client.gameCycle, var9, var10, var11, var12);
               } else {
                  var2.method1478(var8);
               }
            }
         }
      }

      if((var3 & 32) != 0) {
         var2.field1237 = var0.readUnsignedShort();
         if(var2.queueSize == 0) {
            var2.orientation = var2.field1237;
            var2.field1237 = -1;
         }
      }

      if((var3 & 8) != 0) {
         var5 = var0.readUnsignedShort();
         Permission var22 = (Permission)class36.forOrdinal(class252.method4350(), var0.readUnsignedByte());
         boolean var25 = var0.readUnsignedByte() == 1;
         var8 = var0.readUnsignedByte();
         var9 = var0.offset;
         if(var2.name != null && var2.composition != null) {
            boolean var24 = false;
            if(var22.field3139 && KeyFocusListener.isIgnored(var2.name)) {
               var24 = true;
            }

            if(!var24 && Client.field1023 == 0 && !var2.hidden) {
               class96.field1464.offset = 0;
               var0.readBytes(class96.field1464.payload, 0, var8);
               class96.field1464.offset = 0;
               Buffer var20 = class96.field1464;
               String var21 = class28.method239(var20, 32767);
               String var13 = FontTypeFace.appendTags(class210.method3856(var21));
               var2.overhead = var13.trim();
               var2.field1226 = var5 >> 8;
               var2.field1227 = var5 & 255;
               var2.field1225 = 150;
               var2.field1223 = var25;
               var2.inSequence = var2 != class226.localPlayer && var22.field3139 && "" != Client.field1122 && var13.toLowerCase().indexOf(Client.field1122) == -1;
               int var14;
               if(var22.field3147) {
                  var14 = var25?91:1;
               } else {
                  var14 = var25?90:2;
               }

               if(var22.field3146 != -1) {
                  int var17 = var22.field3146;
                  String var16 = "<img=" + var17 + ">";
                  Item.sendGameMessage(var14, var16 + var2.name, var13);
               } else {
                  Item.sendGameMessage(var14, var2.name, var13);
               }
            }
         }

         var0.offset = var8 + var9;
      }

      if((var3 & 512) != 0) {
         var2.graphic = var0.readUnsignedShort();
         var5 = var0.readInt();
         var2.field1250 = var5 >> 16;
         var2.graphicsDelay = (var5 & '\uffff') + Client.gameCycle;
         var2.field1247 = 0;
         var2.field1248 = 0;
         if(var2.graphicsDelay > Client.gameCycle) {
            var2.field1247 = -1;
         }

         if(var2.graphic == '\uffff') {
            var2.graphic = -1;
         }
      }

      if((var3 & 2048) != 0) {
         var2.field1236 = var0.readByte();
         var2.field1253 = var0.readByte();
         var2.field1265 = var0.readByte();
         var2.field1254 = var0.readByte();
         var2.field1255 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field1268 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field1257 = var0.readUnsignedShort();
         if(var2.field898) {
            var2.field1236 += var2.field899;
            var2.field1253 += var2.field900;
            var2.field1265 += var2.field899;
            var2.field1254 += var2.field900;
            var2.queueSize = 0;
         } else {
            var2.field1236 += var2.pathX[0];
            var2.field1253 += var2.pathY[0];
            var2.field1265 += var2.pathX[0];
            var2.field1254 += var2.pathY[0];
            var2.queueSize = 1;
         }

         var2.field1219 = 0;
      }

      if((var3 & 1024) != 0) {
         class96.field1467[var1] = var0.readByte();
      }

      if((var3 & 256) != 0) {
         var4 = var0.readByte();
      }

      if((var3 & 4096) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.readString();
         }
      }

      if(var2.field898) {
         if(var4 == 127) {
            var2.method1076(var2.field899, var2.field900);
         } else {
            byte var23;
            if(var4 != -1) {
               var23 = var4;
            } else {
               var23 = class96.field1467[var1];
            }

            var2.method1075(var2.field899, var2.field900, var23);
         }
      }

   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(Lho;III)V",
      garbageValue = "-1534310743"
   )
   static final void method1069(Widget var0, int var1, int var2) {
      if(var0.field2620 == 1) {
         class261.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var3;
      int var4;
      int var5;
      if(var0.field2620 == 2 && !Client.spellSelected) {
         var5 = class60.getWidgetConfig(var0);
         var4 = var5 >> 11 & 63;
         if(var4 == 0) {
            var3 = null;
         } else if(var0.selectedAction != null && var0.selectedAction.trim().length() != 0) {
            var3 = var0.selectedAction;
         } else {
            var3 = null;
         }

         if(var3 != null) {
            class261.addMenuEntry(var3, class8.getColTags('\uff00') + var0.field2733, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2620 == 3) {
         class261.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2620 == 4) {
         class261.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2620 == 5) {
         class261.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2620 == 6 && Client.field1068 == null) {
         class261.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var6;
      int var20;
      if(var0.type == 2) {
         var20 = 0;

         for(var4 = 0; var4 < var0.height; ++var4) {
            for(var5 = 0; var5 < var0.width; ++var5) {
               var6 = (var0.paddingX + 32) * var5;
               int var7 = (var0.paddingY + 32) * var4;
               if(var20 < 20) {
                  var6 += var0.xSprites[var20];
                  var7 += var0.field2677[var20];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
                  Client.field1020 = var20;
                  class175.field2370 = var0;
                  if(var0.itemIds[var20] > 0) {
                     label377: {
                        ItemComposition var8 = class10.getItemDefinition(var0.itemIds[var20] - 1);
                        boolean var9;
                        int var10;
                        if(Client.itemSelectionState == 1) {
                           var10 = class60.getWidgetConfig(var0);
                           var9 = (var10 >> 30 & 1) != 0;
                           if(var9) {
                              if(var0.id != class8.field232 || var20 != class25.selectedItemIndex) {
                                 class261.addMenuEntry("Use", Client.field1058 + " " + "->" + " " + class8.getColTags(16748608) + var8.name, 31, var8.id, var20, var0.id);
                              }
                              break label377;
                           }
                        }

                        if(Client.spellSelected) {
                           var10 = class60.getWidgetConfig(var0);
                           var9 = (var10 >> 30 & 1) != 0;
                           if(var9) {
                              if((class39.field534 & 16) == 16) {
                                 class261.addMenuEntry(Client.field1062, Client.field1063 + " " + "->" + " " + class8.getColTags(16748608) + var8.name, 32, var8.id, var20, var0.id);
                              }
                              break label377;
                           }
                        }

                        String[] var21 = var8.inventoryActions;
                        if(Client.field1174) {
                           var21 = IndexDataBase.method4103(var21);
                        }

                        var10 = -1;
                        if(Client.field1052 && KeyFocusListener.field636[81]) {
                           var10 = var8.method4449();
                        }

                        int var12 = class60.getWidgetConfig(var0);
                        boolean var11 = (var12 >> 30 & 1) != 0;
                        if(var11) {
                           for(int var13 = 4; var13 >= 3; --var13) {
                              if(var13 != var10) {
                                 class34.method460(var0, var8, var20, var13, false);
                              }
                           }
                        }

                        int var14 = class60.getWidgetConfig(var0);
                        boolean var24 = (var14 >> 31 & 1) != 0;
                        if(var24) {
                           class261.addMenuEntry("Use", class8.getColTags(16748608) + var8.name, 38, var8.id, var20, var0.id);
                        }

                        int var16 = class60.getWidgetConfig(var0);
                        boolean var15 = (var16 >> 30 & 1) != 0;
                        int var17;
                        if(var15) {
                           if(var21 != null) {
                              for(var17 = 2; var17 >= 0; --var17) {
                                 if(var10 != var17) {
                                    class34.method460(var0, var8, var20, var17, false);
                                 }
                              }
                           }

                           if(var10 >= 0) {
                              class34.method460(var0, var8, var20, var10, true);
                           }
                        }

                        var21 = var0.configActions;
                        if(Client.field1174) {
                           var21 = IndexDataBase.method4103(var21);
                        }

                        if(var21 != null) {
                           for(var17 = 4; var17 >= 0; --var17) {
                              if(var21[var17] != null) {
                                 byte var18 = 0;
                                 if(var17 == 0) {
                                    var18 = 39;
                                 }

                                 if(var17 == 1) {
                                    var18 = 40;
                                 }

                                 if(var17 == 2) {
                                    var18 = 41;
                                 }

                                 if(var17 == 3) {
                                    var18 = 42;
                                 }

                                 if(var17 == 4) {
                                    var18 = 43;
                                 }

                                 class261.addMenuEntry(var21[var17], class8.getColTags(16748608) + var8.name, var18, var8.id, var20, var0.id);
                              }
                           }
                        }

                        class261.addMenuEntry("Examine", class8.getColTags(16748608) + var8.name, 1005, var8.id, var20, var0.id);
                     }
                  }
               }

               ++var20;
            }
         }
      }

      if(var0.hasScript) {
         if(Client.spellSelected) {
            if(RSSocket.method2936(class60.getWidgetConfig(var0)) && (class39.field534 & 32) == 32) {
               class261.addMenuEntry(Client.field1062, Client.field1063 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var20 = 9; var20 >= 5; --var20) {
               String var19 = class51.method747(var0, var20);
               if(var19 != null) {
                  class261.addMenuEntry(var19, var0.name, 1007, var20 + 1, var0.index, var0.id);
               }
            }

            var5 = class60.getWidgetConfig(var0);
            var4 = var5 >> 11 & 63;
            if(var4 == 0) {
               var3 = null;
            } else if(var0.selectedAction != null && var0.selectedAction.trim().length() != 0) {
               var3 = var0.selectedAction;
            } else {
               var3 = null;
            }

            if(var3 != null) {
               class261.addMenuEntry(var3, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var5 = 4; var5 >= 0; --var5) {
               String var22 = class51.method747(var0, var5);
               if(var22 != null) {
                  class261.addMenuEntry(var22, var0.name, 57, var5 + 1, var0.index, var0.id);
               }
            }

            var6 = class60.getWidgetConfig(var0);
            boolean var23 = (var6 & 1) != 0;
            if(var23) {
               class261.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }

   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "(I)Lkw;",
      garbageValue = "-1965271673"
   )
   static RenderOverview method1070() {
      return Client.renderOverview;
   }
}
