import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class21 {
   @ObfuscatedName("n")
   @Export("tileOverlayIds")
   static byte[][][] tileOverlayIds;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   static IndexedSprite field339;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 182114183
   )
   static int field338;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "30047471"
   )
   public static int method168() {
      return ++MouseInput.mouseIdleTicks - 1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILcr;ZB)I",
      garbageValue = "-49"
   )
   static int method167(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = UnitPriceComparator.getWidget(class81.intStack[--class171.intStackSize]);
      } else {
         var3 = var2?class49.field604:class81.field1270;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class81.intStack[--class171.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.setAction(var4, class81.scriptStringStack[--class81.scriptStringStackSize]);
            return 1;
         } else {
            --class81.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class171.intStackSize -= 2;
         var4 = class81.intStack[class171.intStackSize];
         int var5 = class81.intStack[class171.intStackSize + 1];
         var3.dragParent = class44.getWidgetChild(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.dragRenderBehavior = class81.intStack[--class171.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.dragDeadZone = class81.intStack[--class171.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.dragDeadTime = class81.intStack[--class171.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.opBase = class81.scriptStringStack[--class81.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.targetVerb = class81.scriptStringStack[--class81.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILcr;ZB)I",
      garbageValue = "-91"
   )
   static int method165(int var0, Script var1, boolean var2) {
      if(var0 == 5000) {
         class81.intStack[++class171.intStackSize - 1] = Client.publicChatMode;
         return 1;
      } else if(var0 == 5001) {
         class171.intStackSize -= 3;
         Client.publicChatMode = class81.intStack[class171.intStackSize];
         BoundingBox2D.field246 = WorldMapType2.method581(class81.intStack[class171.intStackSize + 1]);
         if(BoundingBox2D.field246 == null) {
            BoundingBox2D.field246 = class320.field3934;
         }

         Client.field1067 = class81.intStack[class171.intStackSize + 2];
         PacketNode var21 = AbstractSoundSystem.method2350(ClientPacket.field2449, Client.field911.field1460);
         var21.packetBuffer.putByte(Client.publicChatMode);
         var21.packetBuffer.putByte(BoundingBox2D.field246.field3935);
         var21.packetBuffer.putByte(Client.field1067);
         Client.field911.method2135(var21);
         return 1;
      } else {
         String var3;
         int var4;
         int var5;
         if(var0 == 5002) {
            var3 = class81.scriptStringStack[--class81.scriptStringStackSize];
            class171.intStackSize -= 2;
            var4 = class81.intStack[class171.intStackSize];
            var5 = class81.intStack[class171.intStackSize + 1];
            PacketNode var6 = AbstractSoundSystem.method2350(ClientPacket.field2402, Client.field911.field1460);
            var6.packetBuffer.putByte(class95.getLength(var3) + 2);
            var6.packetBuffer.putString(var3);
            var6.packetBuffer.putByte(var4 - 1);
            var6.packetBuffer.putByte(var5);
            Client.field911.method2135(var6);
            return 1;
         } else {
            int var10;
            if(var0 == 5003) {
               class171.intStackSize -= 2;
               var10 = class81.intStack[class171.intStackSize];
               var4 = class81.intStack[class171.intStackSize + 1];
               MessageNode var16 = KeyFocusListener.method822(var10, var4);
               if(var16 != null) {
                  class81.intStack[++class171.intStackSize - 1] = var16.id;
                  class81.intStack[++class171.intStackSize - 1] = var16.tick;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var16.name != null?var16.name:"";
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var16.sender != null?var16.sender:"";
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var16.value != null?var16.value:"";
                  class81.intStack[++class171.intStackSize - 1] = var16.method1189()?1:(var16.method1185()?2:0);
               } else {
                  class81.intStack[++class171.intStackSize - 1] = -1;
                  class81.intStack[++class171.intStackSize - 1] = 0;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                  class81.intStack[++class171.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 5004) {
               var10 = class81.intStack[--class171.intStackSize];
               MessageNode var19 = (MessageNode)class95.messages.get((long)var10);
               if(var19 != null) {
                  class81.intStack[++class171.intStackSize - 1] = var19.type;
                  class81.intStack[++class171.intStackSize - 1] = var19.tick;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var19.name != null?var19.name:"";
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var19.sender != null?var19.sender:"";
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var19.value != null?var19.value:"";
                  class81.intStack[++class171.intStackSize - 1] = var19.method1189()?1:(var19.method1185()?2:0);
               } else {
                  class81.intStack[++class171.intStackSize - 1] = -1;
                  class81.intStack[++class171.intStackSize - 1] = 0;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                  class81.intStack[++class171.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 5005) {
               if(BoundingBox2D.field246 == null) {
                  class81.intStack[++class171.intStackSize - 1] = -1;
               } else {
                  class81.intStack[++class171.intStackSize - 1] = BoundingBox2D.field246.field3935;
               }

               return 1;
            } else if(var0 == 5008) {
               var3 = class81.scriptStringStack[--class81.scriptStringStackSize];
               var4 = class81.intStack[--class171.intStackSize];
               String var15 = var3.toLowerCase();
               byte var20 = 0;
               if(var15.startsWith("yellow:")) {
                  var20 = 0;
                  var3 = var3.substring("yellow:".length());
               } else if(var15.startsWith("red:")) {
                  var20 = 1;
                  var3 = var3.substring("red:".length());
               } else if(var15.startsWith("green:")) {
                  var20 = 2;
                  var3 = var3.substring("green:".length());
               } else if(var15.startsWith("cyan:")) {
                  var20 = 3;
                  var3 = var3.substring("cyan:".length());
               } else if(var15.startsWith("purple:")) {
                  var20 = 4;
                  var3 = var3.substring("purple:".length());
               } else if(var15.startsWith("white:")) {
                  var20 = 5;
                  var3 = var3.substring("white:".length());
               } else if(var15.startsWith("flash1:")) {
                  var20 = 6;
                  var3 = var3.substring("flash1:".length());
               } else if(var15.startsWith("flash2:")) {
                  var20 = 7;
                  var3 = var3.substring("flash2:".length());
               } else if(var15.startsWith("flash3:")) {
                  var20 = 8;
                  var3 = var3.substring("flash3:".length());
               } else if(var15.startsWith("glow1:")) {
                  var20 = 9;
                  var3 = var3.substring("glow1:".length());
               } else if(var15.startsWith("glow2:")) {
                  var20 = 10;
                  var3 = var3.substring("glow2:".length());
               } else if(var15.startsWith("glow3:")) {
                  var20 = 11;
                  var3 = var3.substring("glow3:".length());
               } else if(Client.languageId != 0) {
                  if(var15.startsWith("yellow:")) {
                     var20 = 0;
                     var3 = var3.substring("yellow:".length());
                  } else if(var15.startsWith("red:")) {
                     var20 = 1;
                     var3 = var3.substring("red:".length());
                  } else if(var15.startsWith("green:")) {
                     var20 = 2;
                     var3 = var3.substring("green:".length());
                  } else if(var15.startsWith("cyan:")) {
                     var20 = 3;
                     var3 = var3.substring("cyan:".length());
                  } else if(var15.startsWith("purple:")) {
                     var20 = 4;
                     var3 = var3.substring("purple:".length());
                  } else if(var15.startsWith("white:")) {
                     var20 = 5;
                     var3 = var3.substring("white:".length());
                  } else if(var15.startsWith("flash1:")) {
                     var20 = 6;
                     var3 = var3.substring("flash1:".length());
                  } else if(var15.startsWith("flash2:")) {
                     var20 = 7;
                     var3 = var3.substring("flash2:".length());
                  } else if(var15.startsWith("flash3:")) {
                     var20 = 8;
                     var3 = var3.substring("flash3:".length());
                  } else if(var15.startsWith("glow1:")) {
                     var20 = 9;
                     var3 = var3.substring("glow1:".length());
                  } else if(var15.startsWith("glow2:")) {
                     var20 = 10;
                     var3 = var3.substring("glow2:".length());
                  } else if(var15.startsWith("glow3:")) {
                     var20 = 11;
                     var3 = var3.substring("glow3:".length());
                  }
               }

               var15 = var3.toLowerCase();
               byte var7 = 0;
               if(var15.startsWith("wave:")) {
                  var7 = 1;
                  var3 = var3.substring("wave:".length());
               } else if(var15.startsWith("wave2:")) {
                  var7 = 2;
                  var3 = var3.substring("wave2:".length());
               } else if(var15.startsWith("shake:")) {
                  var7 = 3;
                  var3 = var3.substring("shake:".length());
               } else if(var15.startsWith("scroll:")) {
                  var7 = 4;
                  var3 = var3.substring("scroll:".length());
               } else if(var15.startsWith("slide:")) {
                  var7 = 5;
                  var3 = var3.substring("slide:".length());
               } else if(Client.languageId != 0) {
                  if(var15.startsWith("wave:")) {
                     var7 = 1;
                     var3 = var3.substring("wave:".length());
                  } else if(var15.startsWith("wave2:")) {
                     var7 = 2;
                     var3 = var3.substring("wave2:".length());
                  } else if(var15.startsWith("shake:")) {
                     var7 = 3;
                     var3 = var3.substring("shake:".length());
                  } else if(var15.startsWith("scroll:")) {
                     var7 = 4;
                     var3 = var3.substring("scroll:".length());
                  } else if(var15.startsWith("slide:")) {
                     var7 = 5;
                     var3 = var3.substring("slide:".length());
                  }
               }

               PacketNode var8 = AbstractSoundSystem.method2350(ClientPacket.field2399, Client.field911.field1460);
               var8.packetBuffer.putByte(0);
               int var9 = var8.packetBuffer.offset;
               var8.packetBuffer.putByte(var4);
               var8.packetBuffer.putByte(var20);
               var8.packetBuffer.putByte(var7);
               class229.method4233(var8.packetBuffer, var3);
               var8.packetBuffer.method3749(var8.packetBuffer.offset - var9);
               Client.field911.method2135(var8);
               return 1;
            } else {
               int var13;
               if(var0 == 5009) {
                  class81.scriptStringStackSize -= 2;
                  var3 = class81.scriptStringStack[class81.scriptStringStackSize];
                  String var18 = class81.scriptStringStack[class81.scriptStringStackSize + 1];
                  PacketNode var11 = AbstractSoundSystem.method2350(ClientPacket.field2433, Client.field911.field1460);
                  var11.packetBuffer.putShort(0);
                  var13 = var11.packetBuffer.offset;
                  var11.packetBuffer.putString(var3);
                  class229.method4233(var11.packetBuffer, var18);
                  var11.packetBuffer.method3594(var11.packetBuffer.offset - var13);
                  Client.field911.method2135(var11);
                  return 1;
               } else if(var0 != 5015) {
                  if(var0 == 5016) {
                     class81.intStack[++class171.intStackSize - 1] = Client.field1067;
                     return 1;
                  } else if(var0 == 5017) {
                     var10 = class81.intStack[--class171.intStackSize];
                     class81.intStack[++class171.intStackSize - 1] = ScriptVarType.method20(var10);
                     return 1;
                  } else if(var0 == 5018) {
                     var10 = class81.intStack[--class171.intStackSize];
                     int[] var17 = class81.intStack;
                     var5 = ++class171.intStackSize - 1;
                     MessageNode var14 = (MessageNode)class95.messages.get((long)var10);
                     if(var14 == null) {
                        var13 = -1;
                     } else if(var14.previous == class95.field1429.sentinel) {
                        var13 = -1;
                     } else {
                        var13 = ((MessageNode)var14.previous).id;
                     }

                     var17[var5] = var13;
                     return 1;
                  } else if(var0 == 5019) {
                     var10 = class81.intStack[--class171.intStackSize];
                     class81.intStack[++class171.intStackSize - 1] = MouseRecorder.method1160(var10);
                     return 1;
                  } else if(var0 == 5020) {
                     var3 = class81.scriptStringStack[--class81.scriptStringStackSize];
                     if(var3.equalsIgnoreCase("toggleroof")) {
                        Client.preferences.hideRoofs = !Client.preferences.hideRoofs;
                        Widget.method4541();
                        if(Client.preferences.hideRoofs) {
                           ChatPlayer.sendGameMessage(99, "", "Roofs are now all hidden");
                        } else {
                           ChatPlayer.sendGameMessage(99, "", "Roofs will only be removed selectively");
                        }
                     }

                     if(var3.equalsIgnoreCase("displayfps")) {
                        Client.displayFps = !Client.displayFps;
                     }

                     if(var3.equalsIgnoreCase("renderself")) {
                        Client.field928 = !Client.field928;
                     }

                     if(var3.equalsIgnoreCase("mouseovertext")) {
                        Client.field1112 = !Client.field1112;
                     }

                     if(Client.rights >= 2) {
                        if(var3.equalsIgnoreCase("aabb")) {
                           if(!class7.drawBoundingBoxes3D) {
                              class7.drawBoundingBoxes3D = true;
                              class7.boundingBox3DDrawMode = BoundingBox3DDrawMode.ALWAYS;
                           } else if(BoundingBox3DDrawMode.ALWAYS == class7.boundingBox3DDrawMode) {
                              class7.drawBoundingBoxes3D = true;
                              class7.boundingBox3DDrawMode = BoundingBox3DDrawMode.ON_MOUSEOVER;
                           } else {
                              class7.drawBoundingBoxes3D = false;
                           }
                        }

                        if(var3.equalsIgnoreCase("showcoord")) {
                           class196.renderOverview.field4011 = !class196.renderOverview.field4011;
                        }

                        if(var3.equalsIgnoreCase("fpson")) {
                           Client.displayFps = true;
                        }

                        if(var3.equalsIgnoreCase("fpsoff")) {
                           Client.displayFps = false;
                        }

                        if(var3.equalsIgnoreCase("gc")) {
                           System.gc();
                        }

                        if(var3.equalsIgnoreCase("clientdrop")) {
                           class28.method240();
                        }

                        if(var3.equalsIgnoreCase("cs")) {
                           ChatPlayer.sendGameMessage(99, "", "" + Client.field1060);
                        }

                        if(var3.equalsIgnoreCase("errortest") && Client.socketType == 2) {
                           throw new RuntimeException();
                        }
                     }

                     PacketNode var12 = AbstractSoundSystem.method2350(ClientPacket.field2405, Client.field911.field1460);
                     var12.packetBuffer.putByte(var3.length() + 1);
                     var12.packetBuffer.putString(var3);
                     Client.field911.method2135(var12);
                     return 1;
                  } else if(var0 == 5021) {
                     Client.field1068 = class81.scriptStringStack[--class81.scriptStringStackSize].toLowerCase().trim();
                     return 1;
                  } else if(var0 == 5022) {
                     class81.scriptStringStack[++class81.scriptStringStackSize - 1] = Client.field1068;
                     return 1;
                  } else {
                     return 2;
                  }
               } else {
                  if(class265.localPlayer != null && class265.localPlayer.name != null) {
                     var3 = class265.localPlayer.name.getName();
                  } else {
                     var3 = "";
                  }

                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var3;
                  return 1;
               }
            }
         }
      }
   }
}
