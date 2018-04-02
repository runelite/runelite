import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import java.text.DecimalFormat;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
public class class90 {
   @ObfuscatedName("c")
   static boolean field1345;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1993943545
   )
   static int field1338;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Llq;"
   )
   static IndexedSprite field1339;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[Llq;"
   )
   @Export("runeSprites")
   static IndexedSprite[] runeSprites;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Llq;"
   )
   @Export("logoSprite")
   static IndexedSprite logoSprite;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Llq;"
   )
   static IndexedSprite field1342;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1865946043
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("n")
   static int[] field1360;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 72685675
   )
   static int field1346;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1095309933
   )
   static int field1357;
   @ObfuscatedName("ai")
   static int[] field1362;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1579300407
   )
   static int field1349;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 777253307
   )
   static int field1365;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1533924105
   )
   static int field1351;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1583933707
   )
   static int field1352;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -911828325
   )
   @Export("loadingBarPercentage")
   static int loadingBarPercentage;
   @ObfuscatedName("am")
   @Export("loadingText")
   static String loadingText;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1740099917
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("ae")
   @Export("Login_response0")
   static String Login_response0;
   @ObfuscatedName("af")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("aw")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("ax")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ag")
   @Export("username")
   static String username;
   @ObfuscatedName("ay")
   @Export("password")
   static String password;
   @ObfuscatedName("ad")
   @Export("Login_isUsernameRemembered")
   static boolean Login_isUsernameRemembered;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 428528677
   )
   static int field1363;
   @ObfuscatedName("an")
   static boolean field1364;
   @ObfuscatedName("bv")
   static boolean field1340;
   @ObfuscatedName("ba")
   static boolean field1344;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 684898293
   )
   static int field1367;
   @ObfuscatedName("bu")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "[Llq;"
   )
   @Export("slFlagSprites")
   static IndexedSprite[] slFlagSprites;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -412102279
   )
   static int field1372;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      longValue = -1575346312715460511L
   )
   static long field1373;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      longValue = -8326997725450967731L
   )
   static long field1359;

   static {
      field1338 = 0;
      loginWindowX = field1338 + 202;
      field1360 = new int[256];
      field1346 = 0;
      field1357 = 0;
      field1349 = 0;
      field1365 = 0;
      field1351 = 0;
      field1352 = 0;
      loadingBarPercentage = 10;
      loadingText = "";
      loginIndex = 0;
      Login_response0 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      password = "";
      Login_isUsernameRemembered = false;
      field1364 = false;
      field1340 = false;
      field1344 = true;
      field1367 = 0;
      worldSelectShown = false;
      field1372 = -1;
      new DecimalFormat("##0.00");
      new class160();
      field1373 = -1L;
      field1359 = -1L;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "1203141885"
   )
   static int method1911(int var0, Script var1, boolean var2) {
      if(var0 < 1000) {
         return BoundingBox.method53(var0, var1, var2);
      } else if(var0 < 1100) {
         return Script.method2018(var0, var1, var2);
      } else if(var0 < 1200) {
         return FrameMap.method2874(var0, var1, var2);
      } else if(var0 < 1300) {
         return class7.method42(var0, var1, var2);
      } else if(var0 < 1400) {
         return MouseRecorder.method1105(var0, var1, var2);
      } else if(var0 < 1500) {
         return VertexNormal.method2788(var0, var1, var2);
      } else {
         byte var3;
         Widget var49;
         if(var0 < 1600) {
            var49 = var2?class336.field4073:class61.field713;
            if(var0 == 1500) {
               class81.intStack[++SceneTilePaint.intStackSize - 1] = var49.relativeX;
               var3 = 1;
            } else if(var0 == 1501) {
               class81.intStack[++SceneTilePaint.intStackSize - 1] = var49.relativeY;
               var3 = 1;
            } else if(var0 == 1502) {
               class81.intStack[++SceneTilePaint.intStackSize - 1] = var49.width;
               var3 = 1;
            } else if(var0 == 1503) {
               class81.intStack[++SceneTilePaint.intStackSize - 1] = var49.height;
               var3 = 1;
            } else if(var0 == 1504) {
               class81.intStack[++SceneTilePaint.intStackSize - 1] = var49.isHidden?1:0;
               var3 = 1;
            } else if(var0 == 1505) {
               class81.intStack[++SceneTilePaint.intStackSize - 1] = var49.parentId;
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else {
            Widget var76;
            if(var0 < 1700) {
               var76 = var2?class336.field4073:class61.field713;
               if(var0 == 1600) {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var76.scrollX;
                  var3 = 1;
               } else if(var0 == 1601) {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var76.scrollY;
                  var3 = 1;
               } else if(var0 == 1602) {
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = var76.text;
                  var3 = 1;
               } else if(var0 == 1603) {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var76.scrollWidth;
                  var3 = 1;
               } else if(var0 == 1604) {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var76.scrollHeight;
                  var3 = 1;
               } else if(var0 == 1605) {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var76.modelZoom;
                  var3 = 1;
               } else if(var0 == 1606) {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var76.rotationX;
                  var3 = 1;
               } else if(var0 == 1607) {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var76.rotationY;
                  var3 = 1;
               } else if(var0 == 1608) {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var76.rotationZ;
                  var3 = 1;
               } else if(var0 == 1609) {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var76.opacity;
                  var3 = 1;
               } else if(var0 == 1610) {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var76.field2846;
                  var3 = 1;
               } else if(var0 == 1611) {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var76.textColor;
                  var3 = 1;
               } else if(var0 == 1612) {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var76.field2920;
                  var3 = 1;
               } else if(var0 == 1613) {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var76.field2896.rsOrdinal();
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 1800) {
               return class22.method185(var0, var1, var2);
            } else {
               int var6;
               int var8;
               int var22;
               int var23;
               int[] var42;
               if(var0 < 1900) {
                  var76 = var2?class336.field4073:class61.field713;
                  if(var0 == 1800) {
                     var42 = class81.intStack;
                     var6 = ++SceneTilePaint.intStackSize - 1;
                     var8 = class45.getWidgetClickMask(var76);
                     var22 = var8 >> 11 & 63;
                     var42[var6] = var22;
                     var3 = 1;
                  } else if(var0 == 1801) {
                     var23 = class81.intStack[--SceneTilePaint.intStackSize];
                     --var23;
                     if(var76.actions != null && var23 < var76.actions.length && var76.actions[var23] != null) {
                        class81.scriptStringStack[++World.scriptStringStackSize - 1] = var76.actions[var23];
                     } else {
                        class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                     }

                     var3 = 1;
                  } else if(var0 == 1802) {
                     if(var76.opBase == null) {
                        class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                     } else {
                        class81.scriptStringStack[++World.scriptStringStackSize - 1] = var76.opBase;
                     }

                     var3 = 1;
                  } else {
                     var3 = 2;
                  }

                  return var3;
               } else if(var0 < 2000) {
                  return GraphicsObject.method1797(var0, var1, var2);
               } else if(var0 < 2100) {
                  return Script.method2018(var0, var1, var2);
               } else if(var0 < 2200) {
                  return FrameMap.method2874(var0, var1, var2);
               } else if(var0 < 2300) {
                  return class7.method42(var0, var1, var2);
               } else if(var0 < 2400) {
                  return MouseRecorder.method1105(var0, var1, var2);
               } else if(var0 < 2500) {
                  return VertexNormal.method2788(var0, var1, var2);
               } else if(var0 < 2600) {
                  return class19.method158(var0, var1, var2);
               } else if(var0 < 2700) {
                  return WorldMapManager.method624(var0, var1, var2);
               } else if(var0 < 2800) {
                  return PlayerComposition.method4435(var0, var1, var2);
               } else if(var0 < 2900) {
                  return PendingSpawn.method1582(var0, var1, var2);
               } else if(var0 < 3000) {
                  return GraphicsObject.method1797(var0, var1, var2);
               } else {
                  int var4;
                  int var10;
                  int[] var21;
                  String var40;
                  PacketNode var48;
                  boolean var55;
                  boolean var62;
                  String var66;
                  if(var0 < 3200) {
                     if(var0 == 3100) {
                        var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                        class189.sendGameMessage(0, "", var66);
                        var3 = 1;
                     } else if(var0 == 3101) {
                        SceneTilePaint.intStackSize -= 2;
                        FontName.method5496(WorldComparator.localPlayer, class81.intStack[SceneTilePaint.intStackSize], class81.intStack[SceneTilePaint.intStackSize + 1]);
                        var3 = 1;
                     } else if(var0 == 3103) {
                        PacketNode var75 = FaceNormal.method3078(ClientPacket.field2403, Client.field902.field1475);
                        Client.field902.method2036(var75);

                        for(WidgetNode var53 = (WidgetNode)Client.componentTable.first(); var53 != null; var53 = (WidgetNode)Client.componentTable.next()) {
                           if(var53.owner == 0 || var53.owner == 3) {
                              class44.closeWidget(var53, true);
                           }
                        }

                        if(Client.field1102 != null) {
                           WorldMapType1.method274(Client.field1102);
                           Client.field1102 = null;
                        }

                        var3 = 1;
                     } else if(var0 == 3104) {
                        var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                        var23 = 0;
                        if(Nameable.method5280(var66)) {
                           var6 = FrameMap.parseInt(var66, 10, true);
                           var23 = var6;
                        }

                        PacketNode var70 = FaceNormal.method3078(ClientPacket.field2416, Client.field902.field1475);
                        var70.packetBuffer.putInt(var23);
                        Client.field902.method2036(var70);
                        var3 = 1;
                     } else if(var0 == 3105) {
                        var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                        var48 = FaceNormal.method3078(ClientPacket.field2384, Client.field902.field1475);
                        var48.packetBuffer.putByte(var66.length() + 1);
                        var48.packetBuffer.putString(var66);
                        Client.field902.method2036(var48);
                        var3 = 1;
                     } else if(var0 == 3106) {
                        var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                        var48 = FaceNormal.method3078(ClientPacket.field2450, Client.field902.field1475);
                        var48.packetBuffer.putByte(var66.length() + 1);
                        var48.packetBuffer.putString(var66);
                        Client.field902.method2036(var48);
                        var3 = 1;
                     } else if(var0 == 3107) {
                        var4 = class81.intStack[--SceneTilePaint.intStackSize];
                        var40 = class81.scriptStringStack[--World.scriptStringStackSize];
                        var6 = class93.playerIndexesCount;
                        int[] var47 = class93.playerIndices;
                        boolean var57 = false;
                        Name var56 = new Name(var40, Client.loginType);

                        for(var10 = 0; var10 < var6; ++var10) {
                           Player var11 = Client.cachedPlayers[var47[var10]];
                           if(var11 != null && var11 != WorldComparator.localPlayer && var11.name != null && var11.name.equals(var56)) {
                              PacketNode var12;
                              if(var4 == 1) {
                                 var12 = FaceNormal.method3078(ClientPacket.field2431, Client.field902.field1475);
                                 var12.packetBuffer.method3648(var47[var10]);
                                 var12.packetBuffer.method3544(0);
                                 Client.field902.method2036(var12);
                              } else if(var4 == 4) {
                                 var12 = FaceNormal.method3078(ClientPacket.field2468, Client.field902.field1475);
                                 var12.packetBuffer.method3554(var47[var10]);
                                 var12.packetBuffer.method3690(0);
                                 Client.field902.method2036(var12);
                              } else if(var4 == 6) {
                                 var12 = FaceNormal.method3078(ClientPacket.field2377, Client.field902.field1475);
                                 var12.packetBuffer.method3544(0);
                                 var12.packetBuffer.putShort(var47[var10]);
                                 Client.field902.method2036(var12);
                              } else if(var4 == 7) {
                                 var12 = FaceNormal.method3078(ClientPacket.field2435, Client.field902.field1475);
                                 var12.packetBuffer.method3544(0);
                                 var12.packetBuffer.method3619(var47[var10]);
                                 Client.field902.method2036(var12);
                              }

                              var57 = true;
                              break;
                           }
                        }

                        if(!var57) {
                           class189.sendGameMessage(4, "", "Unable to find " + var40);
                        }

                        var3 = 1;
                     } else if(var0 == 3108) {
                        SceneTilePaint.intStackSize -= 3;
                        var4 = class81.intStack[SceneTilePaint.intStackSize];
                        var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                        var6 = class81.intStack[SceneTilePaint.intStackSize + 2];
                        var49 = class3.getWidget(var6);
                        class231.method4258(var49, var4, var23);
                        var3 = 1;
                     } else if(var0 == 3109) {
                        SceneTilePaint.intStackSize -= 2;
                        var4 = class81.intStack[SceneTilePaint.intStackSize];
                        var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                        Widget var72 = var2?class336.field4073:class61.field713;
                        class231.method4258(var72, var4, var23);
                        var3 = 1;
                     } else if(var0 == 3110) {
                        WorldMapData.middleMouseMovesCamera = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                        var3 = 1;
                     } else if(var0 == 3111) {
                        class81.intStack[++SceneTilePaint.intStackSize - 1] = class46.preferences.hideRoofs?1:0;
                        var3 = 1;
                     } else if(var0 == 3112) {
                        class46.preferences.hideRoofs = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                        class46.method694();
                        var3 = 1;
                     } else if(var0 == 3113) {
                        var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                        boolean var77 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                        if(!var77) {
                           ItemLayer.method2580(var66, 3);
                        } else {
                           label2309: {
                              if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                 try {
                                    Desktop.getDesktop().browse(new URI(var66));
                                    break label2309;
                                 } catch (Exception var39) {
                                    ;
                                 }
                              }

                              if(class57.field646.startsWith("win")) {
                                 ItemLayer.method2580(var66, 0);
                              } else if(class57.field646.startsWith("mac")) {
                                 WorldMapType2.method553(var66, 1, "openjs");
                              } else {
                                 ItemLayer.method2580(var66, 2);
                              }
                           }
                        }

                        var3 = 1;
                     } else if(var0 == 3115) {
                        var4 = class81.intStack[--SceneTilePaint.intStackSize];
                        var48 = FaceNormal.method3078(ClientPacket.field2394, Client.field902.field1475);
                        var48.packetBuffer.putShort(var4);
                        Client.field902.method2036(var48);
                        var3 = 1;
                     } else if(var0 == 3116) {
                        var4 = class81.intStack[--SceneTilePaint.intStackSize];
                        World.scriptStringStackSize -= 2;
                        var40 = class81.scriptStringStack[World.scriptStringStackSize];
                        String var74 = class81.scriptStringStack[World.scriptStringStackSize + 1];
                        if(var40.length() > 500) {
                           var3 = 1;
                        } else if(var74.length() > 500) {
                           var3 = 1;
                        } else {
                           PacketNode var50 = FaceNormal.method3078(ClientPacket.field2464, Client.field902.field1475);
                           var50.packetBuffer.putShort(1 + Projectile.getLength(var40) + Projectile.getLength(var74));
                           var50.packetBuffer.putString(var74);
                           var50.packetBuffer.method3690(var4);
                           var50.packetBuffer.putString(var40);
                           Client.field902.method2036(var50);
                           var3 = 1;
                        }
                     } else if(var0 == 3117) {
                        Client.field1001 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                        var3 = 1;
                     } else if(var0 == 3118) {
                        Client.field912 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                        var3 = 1;
                     } else if(var0 == 3119) {
                        Client.field974 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                        var3 = 1;
                     } else if(var0 == 3120) {
                        if(class81.intStack[--SceneTilePaint.intStackSize] == 1) {
                           Client.playerNameMask |= 1;
                        } else {
                           Client.playerNameMask &= -2;
                        }

                        var3 = 1;
                     } else if(var0 == 3121) {
                        if(class81.intStack[--SceneTilePaint.intStackSize] == 1) {
                           Client.playerNameMask |= 2;
                        } else {
                           Client.playerNameMask &= -3;
                        }

                        var3 = 1;
                     } else if(var0 == 3122) {
                        if(class81.intStack[--SceneTilePaint.intStackSize] == 1) {
                           Client.playerNameMask |= 4;
                        } else {
                           Client.playerNameMask &= -5;
                        }

                        var3 = 1;
                     } else if(var0 == 3123) {
                        if(class81.intStack[--SceneTilePaint.intStackSize] == 1) {
                           Client.playerNameMask |= 8;
                        } else {
                           Client.playerNameMask &= -9;
                        }

                        var3 = 1;
                     } else if(var0 == 3124) {
                        Client.playerNameMask = 0;
                        var3 = 1;
                     } else if(var0 == 3125) {
                        Client.field937 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                        var3 = 1;
                     } else if(var0 == 3126) {
                        Client.field960 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                        var3 = 1;
                     } else if(var0 == 3127) {
                        var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                        Client.field1002 = var62;
                        var3 = 1;
                     } else if(var0 == 3128) {
                        var21 = class81.intStack;
                        var23 = ++SceneTilePaint.intStackSize - 1;
                        var55 = Client.field1002;
                        var21[var23] = var55?1:0;
                        var3 = 1;
                     } else if(var0 == 3129) {
                        SceneTilePaint.intStackSize -= 2;
                        Client.field935 = class81.intStack[SceneTilePaint.intStackSize];
                        Client.field936 = class81.intStack[SceneTilePaint.intStackSize + 1];
                        var3 = 1;
                     } else {
                        var3 = 2;
                     }

                     return var3;
                  } else if(var0 < 3300) {
                     return class150.method3133(var0, var1, var2);
                  } else {
                     int var25;
                     if(var0 < 3400) {
                        if(var0 == 3300) {
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.gameCycle;
                           var3 = 1;
                        } else {
                           ItemContainer var52;
                           int[] var69;
                           if(var0 == 3301) {
                              SceneTilePaint.intStackSize -= 2;
                              var4 = class81.intStack[SceneTilePaint.intStackSize];
                              var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                              var69 = class81.intStack;
                              var22 = ++SceneTilePaint.intStackSize - 1;
                              var52 = (ItemContainer)ItemContainer.itemContainers.get((long)var4);
                              if(var52 == null) {
                                 var8 = -1;
                              } else if(var23 >= 0 && var23 < var52.itemIds.length) {
                                 var8 = var52.itemIds[var23];
                              } else {
                                 var8 = -1;
                              }

                              var69[var22] = var8;
                              var3 = 1;
                           } else if(var0 == 3302) {
                              SceneTilePaint.intStackSize -= 2;
                              var4 = class81.intStack[SceneTilePaint.intStackSize];
                              var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = Preferences.method1645(var4, var23);
                              var3 = 1;
                           } else if(var0 == 3303) {
                              SceneTilePaint.intStackSize -= 2;
                              var4 = class81.intStack[SceneTilePaint.intStackSize];
                              var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                              var69 = class81.intStack;
                              var22 = ++SceneTilePaint.intStackSize - 1;
                              var52 = (ItemContainer)ItemContainer.itemContainers.get((long)var4);
                              if(var52 == null) {
                                 var8 = 0;
                              } else if(var23 == -1) {
                                 var8 = 0;
                              } else {
                                 var10 = 0;

                                 for(var25 = 0; var25 < var52.stackSizes.length; ++var25) {
                                    if(var23 == var52.itemIds[var25]) {
                                       var10 += var52.stackSizes[var25];
                                    }
                                 }

                                 var8 = var10;
                              }

                              var69[var22] = var8;
                              var3 = 1;
                           } else if(var0 == 3304) {
                              var4 = class81.intStack[--SceneTilePaint.intStackSize];
                              var42 = class81.intStack;
                              var6 = ++SceneTilePaint.intStackSize - 1;
                              InvType var73 = (InvType)InvType.inventoryCache.get((long)var4);
                              InvType var43;
                              if(var73 != null) {
                                 var43 = var73;
                              } else {
                                 byte[] var54 = InvType.field3438.getConfigData(5, var4);
                                 var73 = new InvType();
                                 if(var54 != null) {
                                    var73.decode(new Buffer(var54));
                                 }

                                 InvType.inventoryCache.put(var73, (long)var4);
                                 var43 = var73;
                              }

                              var42[var6] = var43.size;
                              var3 = 1;
                           } else if(var0 == 3305) {
                              var4 = class81.intStack[--SceneTilePaint.intStackSize];
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.boostedSkillLevels[var4];
                              var3 = 1;
                           } else if(var0 == 3306) {
                              var4 = class81.intStack[--SceneTilePaint.intStackSize];
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.realSkillLevels[var4];
                              var3 = 1;
                           } else if(var0 == 3307) {
                              var4 = class81.intStack[--SceneTilePaint.intStackSize];
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.skillExperiences[var4];
                              var3 = 1;
                           } else if(var0 == 3308) {
                              var4 = class237.plane;
                              var23 = (WorldComparator.localPlayer.x >> 7) + PacketNode.baseX;
                              var6 = (WorldComparator.localPlayer.y >> 7) + BaseVarType.baseY;
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = (var23 << 14) + var6 + (var4 << 28);
                              var3 = 1;
                           } else if(var0 == 3309) {
                              var4 = class81.intStack[--SceneTilePaint.intStackSize];
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = var4 >> 14 & 16383;
                              var3 = 1;
                           } else if(var0 == 3310) {
                              var4 = class81.intStack[--SceneTilePaint.intStackSize];
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = var4 >> 28;
                              var3 = 1;
                           } else if(var0 == 3311) {
                              var4 = class81.intStack[--SceneTilePaint.intStackSize];
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = var4 & 16383;
                              var3 = 1;
                           } else if(var0 == 3312) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.isMembers?1:0;
                              var3 = 1;
                           } else if(var0 == 3313) {
                              SceneTilePaint.intStackSize -= 2;
                              var4 = class81.intStack[SceneTilePaint.intStackSize] + 32768;
                              var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                              var69 = class81.intStack;
                              var22 = ++SceneTilePaint.intStackSize - 1;
                              var52 = (ItemContainer)ItemContainer.itemContainers.get((long)var4);
                              if(var52 == null) {
                                 var8 = -1;
                              } else if(var23 >= 0 && var23 < var52.itemIds.length) {
                                 var8 = var52.itemIds[var23];
                              } else {
                                 var8 = -1;
                              }

                              var69[var22] = var8;
                              var3 = 1;
                           } else if(var0 == 3314) {
                              SceneTilePaint.intStackSize -= 2;
                              var4 = class81.intStack[SceneTilePaint.intStackSize] + 32768;
                              var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = Preferences.method1645(var4, var23);
                              var3 = 1;
                           } else if(var0 == 3315) {
                              SceneTilePaint.intStackSize -= 2;
                              var4 = class81.intStack[SceneTilePaint.intStackSize] + 32768;
                              var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                              var69 = class81.intStack;
                              var22 = ++SceneTilePaint.intStackSize - 1;
                              var52 = (ItemContainer)ItemContainer.itemContainers.get((long)var4);
                              if(var52 == null) {
                                 var8 = 0;
                              } else if(var23 == -1) {
                                 var8 = 0;
                              } else {
                                 var10 = 0;

                                 for(var25 = 0; var25 < var52.stackSizes.length; ++var25) {
                                    if(var23 == var52.itemIds[var25]) {
                                       var10 += var52.stackSizes[var25];
                                    }
                                 }

                                 var8 = var10;
                              }

                              var69[var22] = var8;
                              var3 = 1;
                           } else if(var0 == 3316) {
                              if(Client.rights >= 2) {
                                 class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.rights;
                              } else {
                                 class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                              }

                              var3 = 1;
                           } else if(var0 == 3317) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.field873;
                              var3 = 1;
                           } else if(var0 == 3318) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.world;
                              var3 = 1;
                           } else if(var0 == 3321) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.energy;
                              var3 = 1;
                           } else if(var0 == 3322) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.weight;
                              var3 = 1;
                           } else if(var0 == 3323) {
                              if(Client.field1025) {
                                 class81.intStack[++SceneTilePaint.intStackSize - 1] = 1;
                              } else {
                                 class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                              }

                              var3 = 1;
                           } else if(var0 == 3324) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.flags;
                              var3 = 1;
                           } else if(var0 == 3325) {
                              SceneTilePaint.intStackSize -= 4;
                              var4 = class81.intStack[SceneTilePaint.intStackSize];
                              var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                              var6 = class81.intStack[SceneTilePaint.intStackSize + 2];
                              var22 = class81.intStack[SceneTilePaint.intStackSize + 3];
                              var4 += var23 << 14;
                              var4 += var6 << 28;
                              var4 += var22;
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = var4;
                              var3 = 1;
                           } else {
                              var3 = 2;
                           }
                        }

                        return var3;
                     } else if(var0 < 3500) {
                        return WorldMapData.method347(var0, var1, var2);
                     } else if(var0 < 3700) {
                        if(var0 == 3600) {
                           if(RunException.friendManager.field1246 == 0) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = -2;
                           } else if(RunException.friendManager.field1246 == 1) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                           } else {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = RunException.friendManager.field1250.getCount();
                           }

                           var3 = 1;
                        } else if(var0 == 3601) {
                           var4 = class81.intStack[--SceneTilePaint.intStackSize];
                           if(RunException.friendManager.method1657() && var4 >= 0 && var4 < RunException.friendManager.field1250.getCount()) {
                              Friend var45 = (Friend)RunException.friendManager.field1250.get(var4);
                              class81.scriptStringStack[++World.scriptStringStackSize - 1] = var45.method5278();
                              class81.scriptStringStack[++World.scriptStringStackSize - 1] = var45.method5262();
                           } else {
                              class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                              class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                           }

                           var3 = 1;
                        } else if(var0 == 3602) {
                           var4 = class81.intStack[--SceneTilePaint.intStackSize];
                           if(RunException.friendManager.method1657() && var4 >= 0 && var4 < RunException.friendManager.field1250.getCount()) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = ((ChatPlayer)RunException.friendManager.field1250.get(var4)).world;
                           } else {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 3603) {
                           var4 = class81.intStack[--SceneTilePaint.intStackSize];
                           if(RunException.friendManager.method1657() && var4 >= 0 && var4 < RunException.friendManager.field1250.getCount()) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = ((ChatPlayer)RunException.friendManager.field1250.get(var4)).rank;
                           } else {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 3604) {
                           var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                           var23 = class81.intStack[--SceneTilePaint.intStackSize];
                           MapIcon.method577(var66, var23);
                           var3 = 1;
                        } else if(var0 == 3605) {
                           var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                           RunException.friendManager.method1664(var66);
                           var3 = 1;
                        } else if(var0 == 3606) {
                           var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                           RunException.friendManager.method1668(var66);
                           var3 = 1;
                        } else if(var0 == 3607) {
                           var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                           RunException.friendManager.method1666(var66);
                           var3 = 1;
                        } else if(var0 == 3608) {
                           var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                           RunException.friendManager.method1690(var66);
                           var3 = 1;
                        } else if(var0 == 3609) {
                           var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                           var66 = MapIconReference.method747(var66);
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = RunException.friendManager.isFriended(new Name(var66, Client.loginType), false)?1:0;
                           var3 = 1;
                        } else if(var0 == 3611) {
                           if(class33.clanMemberManager != null) {
                              class81.scriptStringStack[++World.scriptStringStackSize - 1] = class33.clanMemberManager.field3857;
                           } else {
                              class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                           }

                           var3 = 1;
                        } else if(var0 == 3612) {
                           if(class33.clanMemberManager != null) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = class33.clanMemberManager.getCount();
                           } else {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 3613) {
                           var4 = class81.intStack[--SceneTilePaint.intStackSize];
                           if(class33.clanMemberManager != null && var4 < class33.clanMemberManager.getCount()) {
                              class81.scriptStringStack[++World.scriptStringStackSize - 1] = class33.clanMemberManager.get(var4).method5260().getName();
                           } else {
                              class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                           }

                           var3 = 1;
                        } else if(var0 == 3614) {
                           var4 = class81.intStack[--SceneTilePaint.intStackSize];
                           if(class33.clanMemberManager != null && var4 < class33.clanMemberManager.getCount()) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = ((ChatPlayer)class33.clanMemberManager.get(var4)).method5400();
                           } else {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 3615) {
                           var4 = class81.intStack[--SceneTilePaint.intStackSize];
                           if(class33.clanMemberManager != null && var4 < class33.clanMemberManager.getCount()) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = ((ChatPlayer)class33.clanMemberManager.get(var4)).rank;
                           } else {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 3616) {
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = class33.clanMemberManager != null?class33.clanMemberManager.field3860:0;
                           var3 = 1;
                        } else if(var0 == 3617) {
                           var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                           if(class33.clanMemberManager != null) {
                              var48 = FaceNormal.method3078(ClientPacket.field2414, Client.field902.field1475);
                              var48.packetBuffer.putByte(Projectile.getLength(var66));
                              var48.packetBuffer.putString(var66);
                              Client.field902.method2036(var48);
                           }

                           var3 = 1;
                        } else if(var0 == 3618) {
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = class33.clanMemberManager != null?class33.clanMemberManager.field3862:0;
                           var3 = 1;
                        } else if(var0 == 3619) {
                           var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                           if(!var66.equals("")) {
                              var48 = FaceNormal.method3078(ClientPacket.field2417, Client.field902.field1475);
                              var48.packetBuffer.putByte(Projectile.getLength(var66));
                              var48.packetBuffer.putString(var66);
                              Client.field902.method2036(var48);
                           }

                           var3 = 1;
                        } else if(var0 == 3620) {
                           class203.method3843();
                           var3 = 1;
                        } else if(var0 == 3621) {
                           if(!RunException.friendManager.method1657()) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                           } else {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = RunException.friendManager.field1249.getCount();
                           }

                           var3 = 1;
                        } else if(var0 == 3622) {
                           var4 = class81.intStack[--SceneTilePaint.intStackSize];
                           if(RunException.friendManager.method1657() && var4 >= 0 && var4 < RunException.friendManager.field1249.getCount()) {
                              Ignore var51 = (Ignore)RunException.friendManager.field1249.get(var4);
                              class81.scriptStringStack[++World.scriptStringStackSize - 1] = var51.method5278();
                              class81.scriptStringStack[++World.scriptStringStackSize - 1] = var51.method5262();
                           } else {
                              class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                              class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                           }

                           var3 = 1;
                        } else if(var0 == 3623) {
                           var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                           var66 = MapIconReference.method747(var66);
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = RunException.friendManager.method1695(new Name(var66, Client.loginType))?1:0;
                           var3 = 1;
                        } else if(var0 == 3624) {
                           var4 = class81.intStack[--SceneTilePaint.intStackSize];
                           if(class33.clanMemberManager != null && var4 < class33.clanMemberManager.getCount() && class33.clanMemberManager.get(var4).method5260().equals(WorldComparator.localPlayer.name)) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = 1;
                           } else {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 3625) {
                           if(class33.clanMemberManager != null && class33.clanMemberManager.field3856 != null) {
                              class81.scriptStringStack[++World.scriptStringStackSize - 1] = class33.clanMemberManager.field3856;
                           } else {
                              class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                           }

                           var3 = 1;
                        } else if(var0 == 3626) {
                           var4 = class81.intStack[--SceneTilePaint.intStackSize];
                           if(class33.clanMemberManager != null && var4 < class33.clanMemberManager.getCount() && ((ClanMember)class33.clanMemberManager.get(var4)).method5237()) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = 1;
                           } else {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 3627) {
                           var4 = class81.intStack[--SceneTilePaint.intStackSize];
                           if(class33.clanMemberManager != null && var4 < class33.clanMemberManager.getCount() && ((ClanMember)class33.clanMemberManager.get(var4)).method5240()) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = 1;
                           } else {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 3628) {
                           RunException.friendManager.field1250.method5334();
                           var3 = 1;
                        } else if(var0 == 3629) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           RunException.friendManager.field1250.method5377(new class321(var62));
                           var3 = 1;
                        } else if(var0 == 3630) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           RunException.friendManager.field1250.method5377(new class322(var62));
                           var3 = 1;
                        } else if(var0 == 3631) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           RunException.friendManager.field1250.method5377(new class155(var62));
                           var3 = 1;
                        } else if(var0 == 3632) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           RunException.friendManager.field1250.method5377(new class149(var62));
                           var3 = 1;
                        } else if(var0 == 3633) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           RunException.friendManager.field1250.method5377(new class154(var62));
                           var3 = 1;
                        } else if(var0 == 3634) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           RunException.friendManager.field1250.method5377(new class157(var62));
                           var3 = 1;
                        } else if(var0 == 3635) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           RunException.friendManager.field1250.method5377(new class153(var62));
                           var3 = 1;
                        } else if(var0 == 3636) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           RunException.friendManager.field1250.method5377(new class151(var62));
                           var3 = 1;
                        } else if(var0 == 3637) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           RunException.friendManager.field1250.method5377(new class150(var62));
                           var3 = 1;
                        } else if(var0 == 3638) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           RunException.friendManager.field1250.method5377(new class152(var62));
                           var3 = 1;
                        } else if(var0 == 3639) {
                           RunException.friendManager.field1250.method5333();
                           var3 = 1;
                        } else if(var0 == 3640) {
                           RunException.friendManager.field1249.method5334();
                           var3 = 1;
                        } else if(var0 == 3641) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           RunException.friendManager.field1249.method5377(new class321(var62));
                           var3 = 1;
                        } else if(var0 == 3642) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           RunException.friendManager.field1249.method5377(new class322(var62));
                           var3 = 1;
                        } else if(var0 == 3643) {
                           RunException.friendManager.field1249.method5333();
                           var3 = 1;
                        } else if(var0 == 3644) {
                           if(class33.clanMemberManager != null) {
                              class33.clanMemberManager.method5334();
                           }

                           var3 = 1;
                        } else if(var0 == 3645) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           if(class33.clanMemberManager != null) {
                              class33.clanMemberManager.method5377(new class321(var62));
                           }

                           var3 = 1;
                        } else if(var0 == 3646) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           if(class33.clanMemberManager != null) {
                              class33.clanMemberManager.method5377(new class322(var62));
                           }

                           var3 = 1;
                        } else if(var0 == 3647) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           if(class33.clanMemberManager != null) {
                              class33.clanMemberManager.method5377(new class155(var62));
                           }

                           var3 = 1;
                        } else if(var0 == 3648) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           if(class33.clanMemberManager != null) {
                              class33.clanMemberManager.method5377(new class149(var62));
                           }

                           var3 = 1;
                        } else if(var0 == 3649) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           if(class33.clanMemberManager != null) {
                              class33.clanMemberManager.method5377(new class154(var62));
                           }

                           var3 = 1;
                        } else if(var0 == 3650) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           if(class33.clanMemberManager != null) {
                              class33.clanMemberManager.method5377(new class157(var62));
                           }

                           var3 = 1;
                        } else if(var0 == 3651) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           if(class33.clanMemberManager != null) {
                              class33.clanMemberManager.method5377(new class153(var62));
                           }

                           var3 = 1;
                        } else if(var0 == 3652) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           if(class33.clanMemberManager != null) {
                              class33.clanMemberManager.method5377(new class151(var62));
                           }

                           var3 = 1;
                        } else if(var0 == 3653) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           if(class33.clanMemberManager != null) {
                              class33.clanMemberManager.method5377(new class150(var62));
                           }

                           var3 = 1;
                        } else if(var0 == 3654) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           if(class33.clanMemberManager != null) {
                              class33.clanMemberManager.method5377(new class152(var62));
                           }

                           var3 = 1;
                        } else if(var0 == 3655) {
                           if(class33.clanMemberManager != null) {
                              class33.clanMemberManager.method5333();
                           }

                           var3 = 1;
                        } else if(var0 == 3656) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           RunException.friendManager.field1250.method5377(new class156(var62));
                           var3 = 1;
                        } else if(var0 == 3657) {
                           var62 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           if(class33.clanMemberManager != null) {
                              class33.clanMemberManager.method5377(new class156(var62));
                           }

                           var3 = 1;
                        } else {
                           var3 = 2;
                        }

                        return var3;
                     } else if(var0 < 4000) {
                        return FaceNormal.method3077(var0, var1, var2);
                     } else if(var0 < 4100) {
                        if(var0 == 4000) {
                           SceneTilePaint.intStackSize -= 2;
                           var4 = class81.intStack[SceneTilePaint.intStackSize];
                           var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = var23 + var4;
                           var3 = 1;
                        } else if(var0 == 4001) {
                           SceneTilePaint.intStackSize -= 2;
                           var4 = class81.intStack[SceneTilePaint.intStackSize];
                           var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = var4 - var23;
                           var3 = 1;
                        } else if(var0 == 4002) {
                           SceneTilePaint.intStackSize -= 2;
                           var4 = class81.intStack[SceneTilePaint.intStackSize];
                           var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = var4 * var23;
                           var3 = 1;
                        } else if(var0 == 4003) {
                           SceneTilePaint.intStackSize -= 2;
                           var4 = class81.intStack[SceneTilePaint.intStackSize];
                           var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = var4 / var23;
                           var3 = 1;
                        } else if(var0 == 4004) {
                           var4 = class81.intStack[--SceneTilePaint.intStackSize];
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = (int)(Math.random() * (double)var4);
                           var3 = 1;
                        } else if(var0 == 4005) {
                           var4 = class81.intStack[--SceneTilePaint.intStackSize];
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = (int)(Math.random() * (double)(var4 + 1));
                           var3 = 1;
                        } else if(var0 == 4006) {
                           SceneTilePaint.intStackSize -= 5;
                           var4 = class81.intStack[SceneTilePaint.intStackSize];
                           var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                           var6 = class81.intStack[SceneTilePaint.intStackSize + 2];
                           var22 = class81.intStack[SceneTilePaint.intStackSize + 3];
                           var8 = class81.intStack[SceneTilePaint.intStackSize + 4];
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = var4 + (var23 - var4) * (var8 - var6) / (var22 - var6);
                           var3 = 1;
                        } else if(var0 == 4007) {
                           SceneTilePaint.intStackSize -= 2;
                           var4 = class81.intStack[SceneTilePaint.intStackSize];
                           var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = var4 + var4 * var23 / 100;
                           var3 = 1;
                        } else if(var0 == 4008) {
                           SceneTilePaint.intStackSize -= 2;
                           var4 = class81.intStack[SceneTilePaint.intStackSize];
                           var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = var4 | 1 << var23;
                           var3 = 1;
                        } else if(var0 == 4009) {
                           SceneTilePaint.intStackSize -= 2;
                           var4 = class81.intStack[SceneTilePaint.intStackSize];
                           var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = var4 & -1 - (1 << var23);
                           var3 = 1;
                        } else if(var0 == 4010) {
                           SceneTilePaint.intStackSize -= 2;
                           var4 = class81.intStack[SceneTilePaint.intStackSize];
                           var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = (var4 & 1 << var23) != 0?1:0;
                           var3 = 1;
                        } else if(var0 == 4011) {
                           SceneTilePaint.intStackSize -= 2;
                           var4 = class81.intStack[SceneTilePaint.intStackSize];
                           var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = var4 % var23;
                           var3 = 1;
                        } else if(var0 == 4012) {
                           SceneTilePaint.intStackSize -= 2;
                           var4 = class81.intStack[SceneTilePaint.intStackSize];
                           var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                           if(var4 == 0) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                           } else {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = (int)Math.pow((double)var4, (double)var23);
                           }

                           var3 = 1;
                        } else if(var0 == 4013) {
                           SceneTilePaint.intStackSize -= 2;
                           var4 = class81.intStack[SceneTilePaint.intStackSize];
                           var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                           if(var4 == 0) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                              var3 = 1;
                           } else {
                              switch(var23) {
                              case 0:
                                 class81.intStack[++SceneTilePaint.intStackSize - 1] = Integer.MAX_VALUE;
                                 break;
                              case 1:
                                 class81.intStack[++SceneTilePaint.intStackSize - 1] = var4;
                                 break;
                              case 2:
                                 class81.intStack[++SceneTilePaint.intStackSize - 1] = (int)Math.sqrt((double)var4);
                                 break;
                              case 3:
                                 class81.intStack[++SceneTilePaint.intStackSize - 1] = (int)Math.cbrt((double)var4);
                                 break;
                              case 4:
                                 class81.intStack[++SceneTilePaint.intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var4));
                                 break;
                              default:
                                 class81.intStack[++SceneTilePaint.intStackSize - 1] = (int)Math.pow((double)var4, 1.0D / (double)var23);
                              }

                              var3 = 1;
                           }
                        } else if(var0 == 4014) {
                           SceneTilePaint.intStackSize -= 2;
                           var4 = class81.intStack[SceneTilePaint.intStackSize];
                           var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = var4 & var23;
                           var3 = 1;
                        } else if(var0 == 4015) {
                           SceneTilePaint.intStackSize -= 2;
                           var4 = class81.intStack[SceneTilePaint.intStackSize];
                           var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = var4 | var23;
                           var3 = 1;
                        } else if(var0 == 4018) {
                           SceneTilePaint.intStackSize -= 3;
                           long var27 = (long)class81.intStack[SceneTilePaint.intStackSize];
                           long var29 = (long)class81.intStack[SceneTilePaint.intStackSize + 1];
                           long var31 = (long)class81.intStack[SceneTilePaint.intStackSize + 2];
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = (int)(var31 * var27 / var29);
                           var3 = 1;
                        } else {
                           var3 = 2;
                        }

                        return var3;
                     } else if(var0 < 4200) {
                        if(var0 == 4100) {
                           var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                           var23 = class81.intStack[--SceneTilePaint.intStackSize];
                           class81.scriptStringStack[++World.scriptStringStackSize - 1] = var66 + var23;
                           var3 = 1;
                        } else if(var0 == 4101) {
                           World.scriptStringStackSize -= 2;
                           var66 = class81.scriptStringStack[World.scriptStringStackSize];
                           var40 = class81.scriptStringStack[World.scriptStringStackSize + 1];
                           class81.scriptStringStack[++World.scriptStringStackSize - 1] = var66 + var40;
                           var3 = 1;
                        } else {
                           int var13;
                           int var16;
                           int var17;
                           int var34;
                           if(var0 == 4102) {
                              var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                              var23 = class81.intStack[--SceneTilePaint.intStackSize];
                              String[] var68 = class81.scriptStringStack;
                              var22 = ++World.scriptStringStackSize - 1;
                              String var9;
                              if(var23 < 0) {
                                 var9 = Integer.toString(var23);
                              } else {
                                 var25 = var23;
                                 String var33;
                                 if(var23 < 0) {
                                    var33 = Integer.toString(var23, 10);
                                 } else {
                                    var34 = 2;

                                    for(var13 = var23 / 10; var13 != 0; ++var34) {
                                       var13 /= 10;
                                    }

                                    char[] var14 = new char[var34];
                                    var14[0] = '+';

                                    for(int var15 = var34 - 1; var15 > 0; --var15) {
                                       var16 = var25;
                                       var25 /= 10;
                                       var17 = var16 - var25 * 10;
                                       if(var17 >= 10) {
                                          var14[var15] = (char)(var17 + 87);
                                       } else {
                                          var14[var15] = (char)(var17 + 48);
                                       }
                                    }

                                    var33 = new String(var14);
                                 }

                                 var9 = var33;
                              }

                              var68[var22] = var66 + var9;
                              var3 = 1;
                           } else if(var0 == 4103) {
                              var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                              class81.scriptStringStack[++World.scriptStringStackSize - 1] = var66.toLowerCase();
                              var3 = 1;
                           } else {
                              int var37;
                              if(var0 == 4104) {
                                 var4 = class81.intStack[--SceneTilePaint.intStackSize];
                                 long var35 = ((long)var4 + 11745L) * 86400000L;
                                 class81.field1268.setTime(new Date(var35));
                                 var22 = class81.field1268.get(5);
                                 var8 = class81.field1268.get(2);
                                 var37 = class81.field1268.get(1);
                                 class81.scriptStringStack[++World.scriptStringStackSize - 1] = var22 + "-" + class81.field1277[var8] + "-" + var37;
                                 var3 = 1;
                              } else if(var0 == 4105) {
                                 World.scriptStringStackSize -= 2;
                                 var66 = class81.scriptStringStack[World.scriptStringStackSize];
                                 var40 = class81.scriptStringStack[World.scriptStringStackSize + 1];
                                 if(WorldComparator.localPlayer.composition != null && WorldComparator.localPlayer.composition.isFemale) {
                                    class81.scriptStringStack[++World.scriptStringStackSize - 1] = var40;
                                 } else {
                                    class81.scriptStringStack[++World.scriptStringStackSize - 1] = var66;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4106) {
                                 var4 = class81.intStack[--SceneTilePaint.intStackSize];
                                 class81.scriptStringStack[++World.scriptStringStackSize - 1] = Integer.toString(var4);
                                 var3 = 1;
                              } else if(var0 == 4107) {
                                 World.scriptStringStackSize -= 2;
                                 var21 = class81.intStack;
                                 var23 = ++SceneTilePaint.intStackSize - 1;
                                 String var7 = class81.scriptStringStack[World.scriptStringStackSize];
                                 String var26 = class81.scriptStringStack[World.scriptStringStackSize + 1];
                                 var37 = Client.languageId;
                                 var10 = var7.length();
                                 var25 = var26.length();
                                 var34 = 0;
                                 var13 = 0;
                                 byte var38 = 0;
                                 byte var58 = 0;

                                 label2078:
                                 while(true) {
                                    if(var34 - var38 >= var10 && var13 - var58 >= var25) {
                                       var16 = Math.min(var10, var25);

                                       char var65;
                                       for(var17 = 0; var17 < var16; ++var17) {
                                          char var63 = var7.charAt(var17);
                                          var65 = var26.charAt(var17);
                                          if(var63 != var65 && Character.toUpperCase(var63) != Character.toUpperCase(var65)) {
                                             var63 = Character.toLowerCase(var63);
                                             var65 = Character.toLowerCase(var65);
                                             if(var65 != var63) {
                                                var6 = class173.method3340(var63, var37) - class173.method3340(var65, var37);
                                                break label2078;
                                             }
                                          }
                                       }

                                       var17 = var10 - var25;
                                       if(var17 != 0) {
                                          var6 = var17;
                                          break;
                                       }

                                       for(int var64 = 0; var64 < var16; ++var64) {
                                          var65 = var7.charAt(var64);
                                          char var20 = var26.charAt(var64);
                                          if(var65 != var20) {
                                             var6 = class173.method3340(var65, var37) - class173.method3340(var20, var37);
                                             break label2078;
                                          }
                                       }

                                       var6 = 0;
                                       break;
                                    }

                                    if(var34 - var38 >= var10) {
                                       var6 = -1;
                                       break;
                                    }

                                    if(var13 - var58 >= var25) {
                                       var6 = 1;
                                       break;
                                    }

                                    char var60;
                                    if(var38 != 0) {
                                       var60 = (char)var38;
                                       boolean var78 = false;
                                    } else {
                                       var60 = var7.charAt(var34++);
                                    }

                                    char var61;
                                    if(var58 != 0) {
                                       var61 = (char)var58;
                                       boolean var59 = false;
                                    } else {
                                       var61 = var26.charAt(var13++);
                                    }

                                    byte var18;
                                    if(var60 == 198) {
                                       var18 = 69;
                                    } else if(var60 == 230) {
                                       var18 = 101;
                                    } else if(var60 == 223) {
                                       var18 = 115;
                                    } else if(var60 == 338) {
                                       var18 = 69;
                                    } else if(var60 == 339) {
                                       var18 = 101;
                                    } else {
                                       var18 = 0;
                                    }

                                    var38 = var18;
                                    byte var19;
                                    if(var61 == 198) {
                                       var19 = 69;
                                    } else if(var61 == 230) {
                                       var19 = 101;
                                    } else if(var61 == 223) {
                                       var19 = 115;
                                    } else if(var61 == 338) {
                                       var19 = 69;
                                    } else if(var61 == 339) {
                                       var19 = 101;
                                    } else {
                                       var19 = 0;
                                    }

                                    var58 = var19;
                                    var60 = Nameable.method5284(var60, var37);
                                    var61 = Nameable.method5284(var61, var37);
                                    if(var61 != var60 && Character.toUpperCase(var60) != Character.toUpperCase(var61)) {
                                       var60 = Character.toLowerCase(var60);
                                       var61 = Character.toLowerCase(var61);
                                       if(var60 != var61) {
                                          var6 = class173.method3340(var60, var37) - class173.method3340(var61, var37);
                                          break;
                                       }
                                    }
                                 }

                                 var21[var23] = FriendManager.method1686(var6);
                                 var3 = 1;
                              } else {
                                 byte[] var41;
                                 Font var71;
                                 if(var0 == 4108) {
                                    var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                                    SceneTilePaint.intStackSize -= 2;
                                    var23 = class81.intStack[SceneTilePaint.intStackSize];
                                    var6 = class81.intStack[SceneTilePaint.intStackSize + 1];
                                    var41 = class18.indexCache13.getConfigData(var6, 0);
                                    var71 = new Font(var41);
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = var71.method5519(var66, var23);
                                    var3 = 1;
                                 } else if(var0 == 4109) {
                                    var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                                    SceneTilePaint.intStackSize -= 2;
                                    var23 = class81.intStack[SceneTilePaint.intStackSize];
                                    var6 = class81.intStack[SceneTilePaint.intStackSize + 1];
                                    var41 = class18.indexCache13.getConfigData(var6, 0);
                                    var71 = new Font(var41);
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = var71.method5518(var66, var23);
                                    var3 = 1;
                                 } else if(var0 == 4110) {
                                    World.scriptStringStackSize -= 2;
                                    var66 = class81.scriptStringStack[World.scriptStringStackSize];
                                    var40 = class81.scriptStringStack[World.scriptStringStackSize + 1];
                                    if(class81.intStack[--SceneTilePaint.intStackSize] == 1) {
                                       class81.scriptStringStack[++World.scriptStringStackSize - 1] = var66;
                                    } else {
                                       class81.scriptStringStack[++World.scriptStringStackSize - 1] = var40;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4111) {
                                    var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                                    class81.scriptStringStack[++World.scriptStringStackSize - 1] = FontTypeFace.appendTags(var66);
                                    var3 = 1;
                                 } else if(var0 == 4112) {
                                    var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                                    var23 = class81.intStack[--SceneTilePaint.intStackSize];
                                    class81.scriptStringStack[++World.scriptStringStackSize - 1] = var66 + (char)var23;
                                    var3 = 1;
                                 } else {
                                    char var46;
                                    boolean var67;
                                    if(var0 == 4113) {
                                       var4 = class81.intStack[--SceneTilePaint.intStackSize];
                                       var42 = class81.intStack;
                                       var6 = ++SceneTilePaint.intStackSize - 1;
                                       var46 = (char)var4;
                                       if(var46 >= ' ' && var46 <= '~') {
                                          var67 = true;
                                       } else if(var46 >= 160 && var46 <= 255) {
                                          var67 = true;
                                       } else if(var46 != 8364 && var46 != 338 && var46 != 8212 && var46 != 339 && var46 != 376) {
                                          var67 = false;
                                       } else {
                                          var67 = true;
                                       }

                                       var42[var6] = var67?1:0;
                                       var3 = 1;
                                    } else if(var0 == 4114) {
                                       var4 = class81.intStack[--SceneTilePaint.intStackSize];
                                       var42 = class81.intStack;
                                       var6 = ++SceneTilePaint.intStackSize - 1;
                                       var46 = (char)var4;
                                       var67 = var46 >= '0' && var46 <= '9' || var46 >= 'A' && var46 <= 'Z' || var46 >= 'a' && var46 <= 'z';
                                       var42[var6] = var67?1:0;
                                       var3 = 1;
                                    } else if(var0 == 4115) {
                                       var4 = class81.intStack[--SceneTilePaint.intStackSize];
                                       class81.intStack[++SceneTilePaint.intStackSize - 1] = PacketNode.method3430((char)var4)?1:0;
                                       var3 = 1;
                                    } else if(var0 == 4116) {
                                       var4 = class81.intStack[--SceneTilePaint.intStackSize];
                                       class81.intStack[++SceneTilePaint.intStackSize - 1] = class1.method0((char)var4)?1:0;
                                       var3 = 1;
                                    } else if(var0 == 4117) {
                                       var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                                       if(var66 != null) {
                                          class81.intStack[++SceneTilePaint.intStackSize - 1] = var66.length();
                                       } else {
                                          class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                                       }

                                       var3 = 1;
                                    } else if(var0 == 4118) {
                                       var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                                       SceneTilePaint.intStackSize -= 2;
                                       var23 = class81.intStack[SceneTilePaint.intStackSize];
                                       var6 = class81.intStack[SceneTilePaint.intStackSize + 1];
                                       class81.scriptStringStack[++World.scriptStringStackSize - 1] = var66.substring(var23, var6);
                                       var3 = 1;
                                    } else if(var0 == 4119) {
                                       var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                                       StringBuilder var44 = new StringBuilder(var66.length());
                                       var55 = false;

                                       for(var22 = 0; var22 < var66.length(); ++var22) {
                                          var46 = var66.charAt(var22);
                                          if(var46 == '<') {
                                             var55 = true;
                                          } else if(var46 == '>') {
                                             var55 = false;
                                          } else if(!var55) {
                                             var44.append(var46);
                                          }
                                       }

                                       class81.scriptStringStack[++World.scriptStringStackSize - 1] = var44.toString();
                                       var3 = 1;
                                    } else if(var0 == 4120) {
                                       var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                                       var23 = class81.intStack[--SceneTilePaint.intStackSize];
                                       class81.intStack[++SceneTilePaint.intStackSize - 1] = var66.indexOf(var23);
                                       var3 = 1;
                                    } else if(var0 == 4121) {
                                       World.scriptStringStackSize -= 2;
                                       var66 = class81.scriptStringStack[World.scriptStringStackSize];
                                       var40 = class81.scriptStringStack[World.scriptStringStackSize + 1];
                                       var6 = class81.intStack[--SceneTilePaint.intStackSize];
                                       class81.intStack[++SceneTilePaint.intStackSize - 1] = var66.indexOf(var40, var6);
                                       var3 = 1;
                                    } else {
                                       var3 = 2;
                                    }
                                 }
                              }
                           }
                        }

                        return var3;
                     } else if(var0 < 4300) {
                        if(var0 == 4200) {
                           var4 = class81.intStack[--SceneTilePaint.intStackSize];
                           class81.scriptStringStack[++World.scriptStringStackSize - 1] = GameObject.getItemDefinition(var4).name;
                           var3 = 1;
                        } else {
                           ItemComposition var24;
                           if(var0 == 4201) {
                              SceneTilePaint.intStackSize -= 2;
                              var4 = class81.intStack[SceneTilePaint.intStackSize];
                              var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                              var24 = GameObject.getItemDefinition(var4);
                              if(var23 >= 1 && var23 <= 5 && var24.groundActions[var23 - 1] != null) {
                                 class81.scriptStringStack[++World.scriptStringStackSize - 1] = var24.groundActions[var23 - 1];
                              } else {
                                 class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 4202) {
                              SceneTilePaint.intStackSize -= 2;
                              var4 = class81.intStack[SceneTilePaint.intStackSize];
                              var23 = class81.intStack[SceneTilePaint.intStackSize + 1];
                              var24 = GameObject.getItemDefinition(var4);
                              if(var23 >= 1 && var23 <= 5 && var24.inventoryActions[var23 - 1] != null) {
                                 class81.scriptStringStack[++World.scriptStringStackSize - 1] = var24.inventoryActions[var23 - 1];
                              } else {
                                 class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 4203) {
                              var4 = class81.intStack[--SceneTilePaint.intStackSize];
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = GameObject.getItemDefinition(var4).price;
                              var3 = 1;
                           } else if(var0 == 4204) {
                              var4 = class81.intStack[--SceneTilePaint.intStackSize];
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = GameObject.getItemDefinition(var4).isStackable == 1?1:0;
                              var3 = 1;
                           } else {
                              ItemComposition var5;
                              if(var0 == 4205) {
                                 var4 = class81.intStack[--SceneTilePaint.intStackSize];
                                 var5 = GameObject.getItemDefinition(var4);
                                 if(var5.notedTemplate == -1 && var5.note >= 0) {
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = var5.note;
                                 } else {
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = var4;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4206) {
                                 var4 = class81.intStack[--SceneTilePaint.intStackSize];
                                 var5 = GameObject.getItemDefinition(var4);
                                 if(var5.notedTemplate >= 0 && var5.note >= 0) {
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = var5.note;
                                 } else {
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = var4;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4207) {
                                 var4 = class81.intStack[--SceneTilePaint.intStackSize];
                                 class81.intStack[++SceneTilePaint.intStackSize - 1] = GameObject.getItemDefinition(var4).isMembers?1:0;
                                 var3 = 1;
                              } else if(var0 == 4208) {
                                 var4 = class81.intStack[--SceneTilePaint.intStackSize];
                                 var5 = GameObject.getItemDefinition(var4);
                                 if(var5.int3 == -1 && var5.int2 >= 0) {
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = var5.int2;
                                 } else {
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = var4;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4209) {
                                 var4 = class81.intStack[--SceneTilePaint.intStackSize];
                                 var5 = GameObject.getItemDefinition(var4);
                                 if(var5.int3 >= 0 && var5.int2 >= 0) {
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = var5.int2;
                                 } else {
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = var4;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4210) {
                                 var66 = class81.scriptStringStack[--World.scriptStringStackSize];
                                 var23 = class81.intStack[--SceneTilePaint.intStackSize];
                                 WorldComparator.method75(var66, var23 == 1);
                                 class81.intStack[++SceneTilePaint.intStackSize - 1] = GroundObject.field1789;
                                 var3 = 1;
                              } else if(var0 == 4211) {
                                 if(class23.field340 != null && Preferences.field1243 < GroundObject.field1789) {
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = class23.field340[++Preferences.field1243 - 1] & '\uffff';
                                 } else {
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4212) {
                                 Preferences.field1243 = 0;
                                 var3 = 1;
                              } else {
                                 var3 = 2;
                              }
                           }
                        }

                        return var3;
                     } else if(var0 < 5100) {
                        return Buffer.method3737(var0, var1, var2);
                     } else if(var0 >= 5400) {
                        if(var0 < 5600) {
                           if(var0 == 5504) {
                              SceneTilePaint.intStackSize -= 2;
                              var22 = class81.intStack[SceneTilePaint.intStackSize];
                              var8 = class81.intStack[SceneTilePaint.intStackSize + 1];
                              if(!Client.field1099) {
                                 Client.cameraPitchTarget = var22;
                                 Client.mapAngle = var8;
                              }

                              var3 = 1;
                           } else if(var0 == 5505) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.cameraPitchTarget;
                              var3 = 1;
                           } else if(var0 == 5506) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.mapAngle;
                              var3 = 1;
                           } else if(var0 == 5530) {
                              var22 = class81.intStack[--SceneTilePaint.intStackSize];
                              if(var22 < 0) {
                                 var22 = 0;
                              }

                              Client.field931 = var22;
                              var3 = 1;
                           } else if(var0 == 5531) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.field931;
                              var3 = 1;
                           } else {
                              var3 = 2;
                           }

                           return var3;
                        } else if(var0 < 5700) {
                           return AbstractSoundSystem.method2188(var0, var1, var2);
                        } else if(var0 < 6300) {
                           if(var0 == 6200) {
                              SceneTilePaint.intStackSize -= 2;
                              Client.field1105 = (short)class81.intStack[SceneTilePaint.intStackSize];
                              if(Client.field1105 <= 0) {
                                 Client.field1105 = 256;
                              }

                              Client.field1106 = (short)class81.intStack[SceneTilePaint.intStackSize + 1];
                              if(Client.field1106 <= 0) {
                                 Client.field1106 = 205;
                              }

                              var3 = 1;
                           } else if(var0 == 6201) {
                              SceneTilePaint.intStackSize -= 2;
                              Client.field876 = (short)class81.intStack[SceneTilePaint.intStackSize];
                              if(Client.field876 <= 0) {
                                 Client.field876 = 256;
                              }

                              Client.field1108 = (short)class81.intStack[SceneTilePaint.intStackSize + 1];
                              if(Client.field1108 <= 0) {
                                 Client.field1108 = 320;
                              }

                              var3 = 1;
                           } else if(var0 == 6202) {
                              SceneTilePaint.intStackSize -= 4;
                              Client.field926 = (short)class81.intStack[SceneTilePaint.intStackSize];
                              if(Client.field926 <= 0) {
                                 Client.field926 = 1;
                              }

                              Client.field881 = (short)class81.intStack[SceneTilePaint.intStackSize + 1];
                              if(Client.field881 <= 0) {
                                 Client.field881 = 32767;
                              } else if(Client.field881 < Client.field926) {
                                 Client.field881 = Client.field926;
                              }

                              Client.field1111 = (short)class81.intStack[SceneTilePaint.intStackSize + 2];
                              if(Client.field1111 <= 0) {
                                 Client.field1111 = 1;
                              }

                              Client.field1112 = (short)class81.intStack[SceneTilePaint.intStackSize + 3];
                              if(Client.field1112 <= 0) {
                                 Client.field1112 = 32767;
                              } else if(Client.field1112 < Client.field1111) {
                                 Client.field1112 = Client.field1111;
                              }

                              var3 = 1;
                           } else if(var0 == 6203) {
                              if(Client.field1026 != null) {
                                 Projectile.method1921(0, 0, Client.field1026.width, Client.field1026.height, false);
                                 class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.viewportWidth;
                                 class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.viewportHeight;
                              } else {
                                 class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                                 class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                              }

                              var3 = 1;
                           } else if(var0 == 6204) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.field876;
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.field1108;
                              var3 = 1;
                           } else if(var0 == 6205) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.field1105;
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.field1106;
                              var3 = 1;
                           } else {
                              var3 = 2;
                           }

                           return var3;
                        } else {
                           return var0 < 6600?Actor.method1601(var0, var1, var2):(var0 < 6700?class37.method521(var0, var1, var2):2);
                        }
                     } else {
                        if(var0 == 5306) {
                           var21 = class81.intStack;
                           var23 = ++SceneTilePaint.intStackSize - 1;
                           var6 = Client.isResized?2:1;
                           var21[var23] = var6;
                           var3 = 1;
                        } else if(var0 == 5307) {
                           var4 = class81.intStack[--SceneTilePaint.intStackSize];
                           if(var4 == 1 || var4 == 2) {
                              AttackOption.method1859(var4);
                           }

                           var3 = 1;
                        } else if(var0 == 5308) {
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = class46.preferences.screenType;
                           var3 = 1;
                        } else if(var0 == 5309) {
                           var4 = class81.intStack[--SceneTilePaint.intStackSize];
                           if(var4 == 1 || var4 == 2) {
                              class46.preferences.screenType = var4;
                              class46.method694();
                           }

                           var3 = 1;
                        } else {
                           var3 = 2;
                        }

                        return var3;
                     }
                  }
               }
            }
         }
      }
   }
}
