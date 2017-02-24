import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;
import netscape.javascript.JSObject;

@ObfuscatedName("cg")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -1989645953
   )
   @Export("modelHeight")
   public int modelHeight = 1000;

   @ObfuscatedName("cj")
   void vmethod1948(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(null != var10) {
         this.modelHeight = var10.modelHeight;
         var10.vmethod1948(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "286397846"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   static final boolean method1952() {
      if(class149.field2036 == null) {
         return false;
      } else {
         int var2;
         String var21;
         try {
            int var0 = class149.field2036.method2128();
            if(var0 == 0) {
               return false;
            }

            if(Client.packetOpcode == -1) {
               class149.field2036.method2117(Client.field350.payload, 0, 1);
               Client.field350.offset = 0;
               Client.packetOpcode = Client.field350.method3069();
               Client.field351 = class212.field3149[Client.packetOpcode];
               --var0;
            }

            if(Client.field351 == -1) {
               if(var0 <= 0) {
                  return false;
               }

               class149.field2036.method2117(Client.field350.payload, 0, 1);
               Client.field351 = Client.field350.payload[0] & 255;
               --var0;
            }

            if(Client.field351 == -2) {
               if(var0 <= 1) {
                  return false;
               }

               class149.field2036.method2117(Client.field350.payload, 0, 2);
               Client.field350.offset = 0;
               Client.field351 = Client.field350.readUnsignedShort();
               var0 -= 2;
            }

            if(var0 < Client.field351) {
               return false;
            }

            Client.field350.offset = 0;
            class149.field2036.method2117(Client.field350.payload, 0, Client.field351);
            Client.field559 = 0;
            Client.field574 = Client.field356;
            Client.field356 = Client.field355;
            Client.field355 = Client.packetOpcode;
            if(Client.packetOpcode == 38) {
               Client.field553 = true;
               class155.field2116 = Client.field350.readUnsignedByte();
               class152.field2086 = Client.field350.readUnsignedByte();
               Frames.field1580 = Client.field350.readUnsignedShort();
               XGrandExchangeOffer.field45 = Client.field350.readUnsignedByte();
               class41.field873 = Client.field350.readUnsignedByte();
               if(class41.field873 >= 100) {
                  VertexNormal.cameraX = 64 + class155.field2116 * 128;
                  class37.cameraY = class152.field2086 * 128 + 64;
                  class36.cameraZ = class2.method19(VertexNormal.cameraX, class37.cameraY, WallObject.plane) - Frames.field1580;
               }

               Client.packetOpcode = -1;
               return true;
            }

            int var1;
            int var3;
            int var4;
            Widget var64;
            if(Client.packetOpcode == 171) {
               var1 = Client.field350.method2873();
               var2 = Client.field350.method2878();
               var3 = Client.field350.readUnsignedShort();
               var4 = Client.field350.readUnsignedShort();
               var64 = class179.method3296(var2);
               if(var64.rotationX != var1 || var64.rotationZ != var4 || var3 != var64.field2259) {
                  var64.rotationX = var1;
                  var64.rotationZ = var4;
                  var64.field2259 = var3;
                  class174.method3276(var64);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 212) {
               var1 = Client.field350.method2867();
               class146.method2767(var1);
               Client.interfaceItemTriggers[++Client.field494 - 1 & 31] = var1 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 207) {
               GameEngine.method2252(true);
               Client.packetOpcode = -1;
               return true;
            }

            long var6;
            long var9;
            int var12;
            String var13;
            int var14;
            long var22;
            long var24;
            boolean var80;
            if(Client.packetOpcode == 170) {
               var21 = Client.field350.method2868();
               var22 = Client.field350.method2819();
               var24 = (long)Client.field350.readUnsignedShort();
               var6 = (long)Client.field350.read24BitInt();
               class177 var73 = (class177)class119.method2341(class15.method179(), Client.field350.readUnsignedByte());
               var9 = var6 + (var24 << 32);
               var80 = false;

               for(var12 = 0; var12 < 100; ++var12) {
                  if(var9 == Client.field429[var12]) {
                     var80 = true;
                     break;
                  }
               }

               if(var73.field2671 && Ignore.method206(var21)) {
                  var80 = true;
               }

               if(!var80 && Client.field424 == 0) {
                  Client.field429[Client.field557] = var9;
                  Client.field557 = (1 + Client.field557) % 100;
                  String var87 = FontTypeFace.method3958(class32.method775(ItemLayer.method1511(Client.field350)));
                  if(var73.field2669 != -1) {
                     var14 = var73.field2669;
                     var13 = "<img=" + var14 + ">";
                     class110.addChatMessage(9, var13 + var21, var87, class112.method2159(var22));
                  } else {
                     class110.addChatMessage(9, var21, var87, class112.method2159(var22));
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 125) {
               var1 = Client.field350.readUnsignedByte();
               var2 = Client.field350.readUnsignedByte();
               var3 = Client.field350.readUnsignedByte();
               var4 = Client.field350.readUnsignedByte();
               Client.field554[var1] = true;
               Client.field327[var1] = var2;
               Client.field527[var1] = var3;
               Client.field311[var1] = var4;
               Client.field558[var1] = 0;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 245) {
               var1 = Client.field350.readUnsignedByte();
               if(Client.field350.readUnsignedByte() == 0) {
                  Client.grandExchangeOffers[var1] = new XGrandExchangeOffer();
                  Client.field350.offset += 18;
               } else {
                  --Client.field350.offset;
                  Client.grandExchangeOffers[var1] = new XGrandExchangeOffer(Client.field350, false);
               }

               Client.field500 = Client.field490;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 76) {
               Client.method601();
               Client.energy = Client.field350.readUnsignedByte();
               Client.field502 = Client.field490;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 130) {
               Client.field551 = Client.field350.readUnsignedByte();
               if(Client.field551 == 1) {
                  Client.field324 = Client.field350.readUnsignedShort();
               }

               if(Client.field551 >= 2 && Client.field551 <= 6) {
                  if(Client.field551 == 2) {
                     Client.field329 = 64;
                     Client.field330 = 64;
                  }

                  if(Client.field551 == 3) {
                     Client.field329 = 0;
                     Client.field330 = 64;
                  }

                  if(Client.field551 == 4) {
                     Client.field329 = 128;
                     Client.field330 = 64;
                  }

                  if(Client.field551 == 5) {
                     Client.field329 = 64;
                     Client.field330 = 0;
                  }

                  if(Client.field551 == 6) {
                     Client.field329 = 64;
                     Client.field330 = 128;
                  }

                  Client.field551 = 2;
                  Client.field326 = Client.field350.readUnsignedShort();
                  Client.field520 = Client.field350.readUnsignedShort();
                  Client.field328 = Client.field350.readUnsignedByte();
               }

               if(Client.field551 == 10) {
                  Client.field325 = Client.field350.readUnsignedShort();
               }

               Client.packetOpcode = -1;
               return true;
            }

            boolean var67;
            if(Client.packetOpcode == 169) {
               var67 = Client.field350.readUnsignedByte() == 1;
               if(var67) {
                  class33.field766 = class0.method11() - Client.field350.method2819();
                  class105.field1703 = new class1(Client.field350, true);
               } else {
                  class105.field1703 = null;
               }

               Client.field440 = Client.field490;
               Client.packetOpcode = -1;
               return true;
            }

            String var27;
            int var29;
            boolean var63;
            String var91;
            if(Client.packetOpcode == 5) {
               while(Client.field350.offset < Client.field351) {
                  var1 = Client.field350.readUnsignedByte();
                  var63 = (var1 & 1) == 1;
                  var27 = Client.field350.method2868();
                  var91 = Client.field350.method2868();
                  Client.field350.method2868();

                  for(var29 = 0; var29 < Client.ignoreCount; ++var29) {
                     Ignore var104 = Client.ignores[var29];
                     if(var63) {
                        if(var91.equals(var104.name)) {
                           var104.name = var27;
                           var104.previousName = var91;
                           var27 = null;
                           break;
                        }
                     } else if(var27.equals(var104.name)) {
                        var104.name = var27;
                        var104.previousName = var91;
                        var27 = null;
                        break;
                     }
                  }

                  if(var27 != null && Client.ignoreCount < 400) {
                     Ignore var74 = new Ignore();
                     Client.ignores[Client.ignoreCount] = var74;
                     var74.name = var27;
                     var74.previousName = var91;
                     ++Client.ignoreCount;
                  }
               }

               Client.field451 = Client.field490;
               Client.packetOpcode = -1;
               return true;
            }

            Widget var89;
            if(Client.packetOpcode == 43) {
               var1 = Client.field350.method2879();
               var2 = Client.field350.method2867();
               var89 = class179.method3296(var1);
               if(var89 != null && var89.type == 0) {
                  if(var2 > var89.scrollHeight - var89.height) {
                     var2 = var89.scrollHeight - var89.height;
                  }

                  if(var2 < 0) {
                     var2 = 0;
                  }

                  if(var2 != var89.scrollY) {
                     var89.scrollY = var2;
                     class174.method3276(var89);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 53) {
               class177.field2674 = class114.method2264(Client.field350.readUnsignedByte());
               Client.packetOpcode = -1;
               return true;
            }

            int var31;
            if(Client.packetOpcode == 113) {
               var1 = Client.field350.method2965();
               var2 = Client.field350.readUnsignedShort();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var89 = class179.method3296(var1);
               } else {
                  var89 = null;
               }

               for(; Client.field350.offset < Client.field351; class31.method709(var2, var4, var29 - 1, var31)) {
                  var4 = Client.field350.method2846();
                  var29 = Client.field350.readUnsignedShort();
                  var31 = 0;
                  if(var29 != 0) {
                     var31 = Client.field350.readUnsignedByte();
                     if(var31 == 255) {
                        var31 = Client.field350.method2965();
                     }
                  }

                  if(var89 != null && var4 >= 0 && var4 < var89.itemIds.length) {
                     var89.itemIds[var4] = var29;
                     var89.itemQuantities[var4] = var31;
                  }
               }

               if(var89 != null) {
                  class174.method3276(var89);
               }

               Client.method601();
               Client.interfaceItemTriggers[++Client.field494 - 1 & 31] = var2 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 68) {
               class8.field81 = Client.field350.method2861();
               class181.field2704 = Client.field350.method2897();

               for(var1 = class181.field2704; var1 < class181.field2704 + 8; ++var1) {
                  for(var2 = class8.field81; var2 < class8.field81 + 8; ++var2) {
                     if(Client.groundItemDeque[WallObject.plane][var1][var2] != null) {
                        Client.groundItemDeque[WallObject.plane][var1][var2] = null;
                        class88.groundItemSpawned(var1, var2);
                     }
                  }
               }

               for(class25 var85 = (class25)Client.field436.method2458(); null != var85; var85 = (class25)Client.field436.method2472()) {
                  if(var85.field598 >= class181.field2704 && var85.field598 < class181.field2704 + 8 && var85.field595 >= class8.field81 && var85.field595 < class8.field81 + 8 && var85.field594 == WallObject.plane) {
                     var85.field603 = 0;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            int var10;
            int var32;
            int var36;
            class159 var83;
            String var96;
            String var108;
            if(Client.packetOpcode == 2) {
               var83 = Client.field350;
               var2 = Client.field351;
               ClassInfo var107 = new ClassInfo();
               var107.field3242 = var83.readUnsignedByte();
               var107.field3237 = var83.method2965();
               var107.field3235 = new int[var107.field3242];
               var107.field3238 = new int[var107.field3242];
               var107.fields = new Field[var107.field3242];
               var107.field3240 = new int[var107.field3242];
               var107.methods = new Method[var107.field3242];
               var107.args = new byte[var107.field3242][][];

               for(var4 = 0; var4 < var107.field3242; ++var4) {
                  try {
                     var29 = var83.readUnsignedByte();
                     String var76;
                     if(var29 != 0 && var29 != 1 && var29 != 2) {
                        if(var29 == 3 || var29 == 4) {
                           var96 = var83.method2868();
                           var76 = var83.method2868();
                           var32 = var83.readUnsignedByte();
                           String[] var105 = new String[var32];

                           for(var10 = 0; var10 < var32; ++var10) {
                              var105[var10] = var83.method2868();
                           }

                           var108 = var83.method2868();
                           byte[][] var35 = new byte[var32][];
                           if(var29 == 3) {
                              for(var12 = 0; var12 < var32; ++var12) {
                                 var36 = var83.method2965();
                                 var35[var12] = new byte[var36];
                                 var83.method3010(var35[var12], 0, var36);
                              }
                           }

                           var107.field3235[var4] = var29;
                           Class[] var86 = new Class[var32];

                           for(var36 = 0; var36 < var32; ++var36) {
                              var86[var36] = class140.method2667(var105[var36]);
                           }

                           Class var82 = class140.method2667(var108);
                           if(class140.method2667(var96).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var37 = class140.method2667(var96).getDeclaredMethods();
                           Method[] var15 = var37;

                           for(int var16 = 0; var16 < var15.length; ++var16) {
                              Method var17 = var15[var16];
                              if(Reflection.getMethodName(var17).equals(var76)) {
                                 Class[] var18 = Reflection.getParameterTypes(var17);
                                 if(var18.length == var86.length) {
                                    boolean var19 = true;

                                    for(int var20 = 0; var20 < var86.length; ++var20) {
                                       if(var18[var20] != var86[var20]) {
                                          var19 = false;
                                          break;
                                       }
                                    }

                                    if(var19 && var82 == var17.getReturnType()) {
                                       var107.methods[var4] = var17;
                                    }
                                 }
                              }
                           }

                           var107.args[var4] = var35;
                        }
                     } else {
                        var96 = var83.method2868();
                        var76 = var83.method2868();
                        var32 = 0;
                        if(var29 == 1) {
                           var32 = var83.method2965();
                        }

                        var107.field3235[var4] = var29;
                        var107.field3240[var4] = var32;
                        if(class140.method2667(var96).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var107.fields[var4] = Reflection.findField(class140.method2667(var96), var76);
                     }
                  } catch (ClassNotFoundException var56) {
                     var107.field3238[var4] = -1;
                  } catch (SecurityException var57) {
                     var107.field3238[var4] = -2;
                  } catch (NullPointerException var58) {
                     var107.field3238[var4] = -3;
                  } catch (Exception var59) {
                     var107.field3238[var4] = -4;
                  } catch (Throwable var60) {
                     var107.field3238[var4] = -5;
                  }
               }

               class227.field3245.method2435(var107);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 65) {
               GameEngine.method2252(false);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 126) {
               Client.flagX = Client.field350.readUnsignedByte();
               if(Client.flagX == 255) {
                  Client.flagX = 0;
               }

               Client.flagY = Client.field350.readUnsignedByte();
               if(Client.flagY == 255) {
                  Client.flagY = 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            long var38;
            if(Client.packetOpcode == 14) {
               var21 = Client.field350.method2868();
               var22 = (long)Client.field350.readUnsignedShort();
               var24 = (long)Client.field350.read24BitInt();
               class177 var98 = (class177)class119.method2341(class15.method179(), Client.field350.readUnsignedByte());
               var38 = var24 + (var22 << 32);
               boolean var110 = false;

               for(var10 = 0; var10 < 100; ++var10) {
                  if(var38 == Client.field429[var10]) {
                     var110 = true;
                     break;
                  }
               }

               if(Ignore.method206(var21)) {
                  var110 = true;
               }

               if(!var110 && Client.field424 == 0) {
                  Client.field429[Client.field557] = var38;
                  Client.field557 = (Client.field557 + 1) % 100;
                  var108 = FontTypeFace.method3958(class32.method775(ItemLayer.method1511(Client.field350)));
                  byte var81;
                  if(var98.field2670) {
                     var81 = 7;
                  } else {
                     var81 = 3;
                  }

                  if(var98.field2669 != -1) {
                     var14 = var98.field2669;
                     var13 = "<img=" + var14 + ">";
                     class16.sendGameMessage(var81, var13 + var21, var108);
                  } else {
                     class16.sendGameMessage(var81, var21, var108);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 112) {
               for(var1 = 0; var1 < Client.cachedPlayers.length; ++var1) {
                  if(Client.cachedPlayers[var1] != null) {
                     Client.cachedPlayers[var1].animation = -1;
                  }
               }

               for(var1 = 0; var1 < Client.cachedNPCs.length; ++var1) {
                  if(Client.cachedNPCs[var1] != null) {
                     Client.cachedNPCs[var1].animation = -1;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 105) {
               var1 = Client.field350.method2965();
               WidgetNode var116 = (WidgetNode)Client.componentTable.method2399((long)var1);
               if(var116 != null) {
                  World.method672(var116, true);
               }

               if(Client.field469 != null) {
                  class174.method3276(Client.field469);
                  Client.field469 = null;
               }

               Client.packetOpcode = -1;
               return true;
            }

            Player var30;
            int var42;
            if(Client.packetOpcode == 238) {
               var83 = Client.field350;
               var2 = Client.field351;
               var3 = var83.offset;
               class45.field928 = 0;
               var4 = 0;
               var83.method3072();

               for(var29 = 0; var29 < class45.field921; ++var29) {
                  var31 = class45.field931[var29];
                  if((class45.field918[var31] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                     } else {
                        var42 = var83.method3095(1);
                        if(var42 == 0) {
                           var4 = FaceNormal.method1955(var83);
                           class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                        } else {
                           XGrandExchangeOffer.method56(var83, var31);
                        }
                     }
                  }
               }

               var83.method3074();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var83.method3072();

               for(var29 = 0; var29 < class45.field921; ++var29) {
                  var31 = class45.field931[var29];
                  if((class45.field918[var31] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                     } else {
                        var42 = var83.method3095(1);
                        if(var42 == 0) {
                           var4 = FaceNormal.method1955(var83);
                           class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                        } else {
                           XGrandExchangeOffer.method56(var83, var31);
                        }
                     }
                  }
               }

               var83.method3074();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var83.method3072();

               for(var29 = 0; var29 < class45.field929; ++var29) {
                  var31 = class45.field924[var29];
                  if((class45.field918[var31] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                     } else {
                        var42 = var83.method3095(1);
                        if(var42 == 0) {
                           var4 = FaceNormal.method1955(var83);
                           class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                        } else if(Projectile.method866(var83, var31)) {
                           class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                        }
                     }
                  }
               }

               var83.method3074();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var83.method3072();

               for(var29 = 0; var29 < class45.field929; ++var29) {
                  var31 = class45.field924[var29];
                  if((class45.field918[var31] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                     } else {
                        var42 = var83.method3095(1);
                        if(var42 == 0) {
                           var4 = FaceNormal.method1955(var83);
                           class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                        } else if(Projectile.method866(var83, var31)) {
                           class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                        }
                     }
                  }
               }

               var83.method3074();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               class45.field921 = 0;
               class45.field929 = 0;

               for(var29 = 1; var29 < 2048; ++var29) {
                  class45.field918[var29] = (byte)(class45.field918[var29] >> 1);
                  var30 = Client.cachedPlayers[var29];
                  if(null != var30) {
                     class45.field931[++class45.field921 - 1] = var29;
                  } else {
                     class45.field924[++class45.field929 - 1] = var29;
                  }
               }

               for(var4 = 0; var4 < class45.field928; ++var4) {
                  var29 = class45.field916[var4];
                  var30 = Client.cachedPlayers[var29];
                  var42 = var83.readUnsignedByte();
                  if((var42 & 16) != 0) {
                     var42 += var83.readUnsignedByte() << 8;
                  }

                  class154.method3036(var83, var29, var30, var42);
               }

               if(var2 != var83.offset - var3) {
                  throw new RuntimeException(var83.offset - var3 + " " + var2);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 226) {
               Client.field553 = true;
               class31.field740 = Client.field350.readUnsignedByte();
               class161.field2149 = Client.field350.readUnsignedByte();
               class138.field1920 = Client.field350.readUnsignedShort();
               class183.field2727 = Client.field350.readUnsignedByte();
               class63.field1105 = Client.field350.readUnsignedByte();
               if(class63.field1105 >= 100) {
                  var1 = class31.field740 * 128 + 64;
                  var2 = class161.field2149 * 128 + 64;
                  var3 = class2.method19(var1, var2, WallObject.plane) - class138.field1920;
                  var4 = var1 - VertexNormal.cameraX;
                  var29 = var3 - class36.cameraZ;
                  var31 = var2 - class37.cameraY;
                  var42 = (int)Math.sqrt((double)(var31 * var31 + var4 * var4));
                  Actor.cameraPitch = (int)(Math.atan2((double)var29, (double)var42) * 325.949D) & 2047;
                  class26.cameraYaw = (int)(Math.atan2((double)var4, (double)var31) * -325.949D) & 2047;
                  if(Actor.cameraPitch < 128) {
                     Actor.cameraPitch = 128;
                  }

                  if(Actor.cameraPitch > 383) {
                     Actor.cameraPitch = 383;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 203) {
               Client.field588 = Client.field350.readUnsignedByte();
               Client.field524 = Client.field350.readUnsignedByte();
               Client.packetOpcode = -1;
               return true;
            }

            Widget var28;
            if(Client.packetOpcode == 128) {
               var1 = Client.field350.method2848();
               var2 = Client.field350.method2955();
               var3 = Client.field350.method2870();
               var28 = class179.method3296(var2);
               if(var28.originalX != var3 || var1 != var28.originalY || var28.field2291 != 0 || var28.field2217 != 0) {
                  var28.originalX = var3;
                  var28.originalY = var1;
                  var28.field2291 = 0;
                  var28.field2217 = 0;
                  class174.method3276(var28);
                  class108.method2105(var28);
                  if(var28.type == 0) {
                     class154.method3034(Widget.widgets[var2 >> 16], var28, false);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 154) {
               var1 = Client.field350.method2879();
               var2 = Client.field350.method2873();
               var89 = class179.method3296(var1);
               if(var89.modelType != 1 || var2 != var89.modelId) {
                  var89.modelType = 1;
                  var89.modelId = var2;
                  class174.method3276(var89);
               }

               Client.packetOpcode = -1;
               return true;
            }

            boolean var79;
            if(Client.packetOpcode == 167) {
               var21 = Client.field350.method2868();
               var2 = Client.field350.readUnsignedShort();
               byte var77 = Client.field350.readByte();
               var79 = false;
               if(var77 == -128) {
                  var79 = true;
               }

               if(var79) {
                  if(Player.clanChatCount == 0) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  boolean var109 = false;

                  for(var29 = 0; var29 < Player.clanChatCount && (!class72.clanMembers[var29].username.equals(var21) || class72.clanMembers[var29].world != var2); ++var29) {
                     ;
                  }

                  if(var29 < Player.clanChatCount) {
                     while(var29 < Player.clanChatCount - 1) {
                        class72.clanMembers[var29] = class72.clanMembers[1 + var29];
                        ++var29;
                     }

                     --Player.clanChatCount;
                     class72.clanMembers[Player.clanChatCount] = null;
                  }
               } else {
                  Client.field350.method2868();
                  XClanMember var72 = new XClanMember();
                  var72.username = var21;
                  var72.field288 = GroundObject.method1594(var72.username, MessageNode.field244);
                  var72.world = var2;
                  var72.rank = var77;

                  for(var31 = Player.clanChatCount - 1; var31 >= 0; --var31) {
                     var42 = class72.clanMembers[var31].field288.compareTo(var72.field288);
                     if(var42 == 0) {
                        class72.clanMembers[var31].world = var2;
                        class72.clanMembers[var31].rank = var77;
                        if(var21.equals(class36.localPlayer.name)) {
                           ObjectComposition.field2942 = var77;
                        }

                        Client.field499 = Client.field490;
                        Client.packetOpcode = -1;
                        return true;
                     }

                     if(var42 < 0) {
                        break;
                     }
                  }

                  if(Player.clanChatCount >= class72.clanMembers.length) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  for(var42 = Player.clanChatCount - 1; var42 > var31; --var42) {
                     class72.clanMembers[1 + var42] = class72.clanMembers[var42];
                  }

                  if(Player.clanChatCount == 0) {
                     class72.clanMembers = new XClanMember[100];
                  }

                  class72.clanMembers[var31 + 1] = var72;
                  ++Player.clanChatCount;
                  if(var21.equals(class36.localPlayer.name)) {
                     ObjectComposition.field2942 = var77;
                  }
               }

               Client.field499 = Client.field490;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 49) {
               for(var1 = 0; var1 < class165.widgetSettings.length; ++var1) {
                  if(class165.widgetSettings[var1] != class165.settings[var1]) {
                     class165.widgetSettings[var1] = class165.settings[var1];
                     class145.method2760(var1);
                     Client.field445[++Client.field535 - 1 & 31] = var1;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            long var47;
            if(Client.packetOpcode == 41) {
               var1 = Client.field350.method2965();
               var2 = Client.field350.method2965();
               if(null == Client.field582 || !Client.field582.isValid()) {
                  try {
                     Iterator var102 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var102.hasNext()) {
                        GarbageCollectorMXBean var94 = (GarbageCollectorMXBean)var102.next();
                        if(var94.isValid()) {
                           Client.field582 = var94;
                           Client.field456 = -1L;
                           Client.field583 = -1L;
                        }
                     }
                  } catch (Throwable var55) {
                     ;
                  }
               }

               long var43 = class0.method11();
               var29 = -1;
               if(Client.field582 != null) {
                  var6 = Client.field582.getCollectionTime();
                  if(Client.field583 != -1L) {
                     long var45 = var6 - Client.field583;
                     var47 = var43 - Client.field456;
                     if(var47 != 0L) {
                        var29 = (int)(100L * var45 / var47);
                     }
                  }

                  Client.field583 = var6;
                  Client.field456 = var43;
               }

               Client.field348.method3073(27);
               Client.field348.method2857(var29);
               Client.field348.method2918(GameEngine.FPS);
               Client.field348.method2972(var1);
               Client.field348.method2876(var2);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 101) {
               var21 = Client.field350.method2868();
               Object[] var115 = new Object[var21.length() + 1];

               for(var3 = var21.length() - 1; var3 >= 0; --var3) {
                  if(var21.charAt(var3) == 115) {
                     var115[var3 + 1] = Client.field350.method2868();
                  } else {
                     var115[1 + var3] = new Integer(Client.field350.method2965());
                  }
               }

               var115[0] = new Integer(Client.field350.method2965());
               class18 var100 = new class18();
               var100.field209 = var115;
               class174.method3275(var100, 200000);
               Client.packetOpcode = -1;
               return true;
            }

            Widget var41;
            if(Client.packetOpcode == 229) {
               var1 = Client.field350.method2879();
               var41 = class179.method3296(var1);

               for(var3 = 0; var3 < var41.itemIds.length; ++var3) {
                  var41.itemIds[var3] = -1;
                  var41.itemIds[var3] = 0;
               }

               class174.method3276(var41);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 211) {
               Client.method601();
               Client.weight = Client.field350.readShort();
               Client.field502 = Client.field490;
               Client.packetOpcode = -1;
               return true;
            }

            String var68;
            if(Client.packetOpcode == 253) {
               var1 = Client.field350.method2846();
               var63 = Client.field350.readUnsignedByte() == 1;
               var27 = "";
               var79 = false;
               if(var63) {
                  var27 = Client.field350.method2868();
                  if(Ignore.method206(var27)) {
                     var79 = true;
                  }
               }

               var68 = Client.field350.method2868();
               if(!var79) {
                  class16.sendGameMessage(var1, var27, var68);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 107) {
               class181.field2704 = Client.field350.method2861();
               class8.field81 = Client.field350.readUnsignedByte();

               while(Client.field350.offset < Client.field351) {
                  Client.packetOpcode = Client.field350.readUnsignedByte();
                  class5.method68();
               }

               Client.packetOpcode = -1;
               return true;
            }

            int var11;
            int var40;
            String var112;
            if(Client.packetOpcode == 165) {
               var21 = Client.field350.method2868();
               Client.field310 = var21;

               try {
                  var112 = Client.field508.getParameter(class214.field3170.field3173);
                  var27 = Client.field508.getParameter(class214.field3171.field3173);
                  var91 = var112 + "settings=" + var21 + "; version=1; path=/; domain=" + var27;
                  if(var21.length() == 0) {
                     var91 = var91 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var68 = var91 + "; Expires=";
                     var38 = class0.method11() + 94608000000L;
                     class162.field2150.setTime(new Date(var38));
                     var40 = class162.field2150.get(7);
                     var10 = class162.field2150.get(5);
                     var11 = class162.field2150.get(2);
                     var12 = class162.field2150.get(1);
                     var36 = class162.field2150.get(11);
                     var14 = class162.field2150.get(12);
                     int var49 = class162.field2150.get(13);
                     var96 = class162.field2151[var40 - 1] + ", " + var10 / 10 + var10 % 10 + "-" + class162.field2152[0][var11] + "-" + var12 + " " + var36 / 10 + var36 % 10 + ":" + var14 / 10 + var14 % 10 + ":" + var49 / 10 + var49 % 10 + " GMT";
                     var91 = var68 + var96 + "; Max-Age=" + 94608000L;
                  }

                  Client var69 = Client.field508;
                  var96 = "document.cookie=\"" + var91 + "\"";
                  JSObject.getWindow(var69).eval(var96);
               } catch (Throwable var54) {
                  ;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 111) {
               Client.field322 = Client.field350.method2873() * 30;
               Client.field502 = Client.field490;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 98) {
               var21 = Client.field350.method2868();
               var112 = FontTypeFace.method3958(class32.method775(ItemLayer.method1511(Client.field350)));
               class16.sendGameMessage(6, var21, var112);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 19) {
               for(var1 = 0; var1 < class187.field2782; ++var1) {
                  class187 var113 = class182.method3356(var1);
                  if(var113 != null) {
                     class165.settings[var1] = 0;
                     class165.widgetSettings[var1] = 0;
                  }
               }

               Client.method601();
               Client.field535 += 32;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 213) {
               var1 = Client.field350.method2878();
               var2 = Client.field350.method2867();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var3 = Client.field350.method2965();
               var4 = Client.field350.method2873();
               if(var4 == '\uffff') {
                  var4 = -1;
               }

               for(var29 = var2; var29 <= var4; ++var29) {
                  var6 = ((long)var3 << 32) + (long)var29;
                  Node var8 = Client.widgetFlags.method2399(var6);
                  if(null != var8) {
                     var8.unlink();
                  }

                  Client.widgetFlags.method2400(new class133(var1), var6);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 54) {
               var1 = Client.field350.method2879();
               var2 = Client.field350.method2965();
               var3 = Client.field350.method2869();
               if(var3 == '\uffff') {
                  var3 = -1;
               }

               var28 = class179.method3296(var1);
               ItemComposition var66;
               if(!var28.hasScript) {
                  if(var3 == -1) {
                     var28.modelType = 0;
                     Client.packetOpcode = -1;
                     return true;
                  }

                  var66 = class103.getItemDefinition(var3);
                  var28.modelType = 4;
                  var28.modelId = var3;
                  var28.rotationX = var66.xan2d;
                  var28.rotationZ = var66.yan2d;
                  var28.field2259 = var66.zoom2d * 100 / var2;
                  class174.method3276(var28);
               } else {
                  var28.item = var3;
                  var28.stackSize = var2;
                  var66 = class103.getItemDefinition(var3);
                  var28.rotationX = var66.xan2d;
                  var28.rotationZ = var66.yan2d;
                  var28.rotationY = var66.zan2d;
                  var28.field2254 = var66.offsetX2d;
                  var28.field2255 = var66.offsetY2d;
                  var28.field2259 = var66.zoom2d;
                  if(var66.isStackable == 1) {
                     var28.field2263 = 1;
                  } else {
                     var28.field2263 = 2;
                  }

                  if(var28.field2260 > 0) {
                     var28.field2259 = var28.field2259 * 32 / var28.field2260;
                  } else if(var28.originalWidth > 0) {
                     var28.field2259 = var28.field2259 * 32 / var28.originalWidth;
                  }

                  class174.method3276(var28);
               }

               Client.packetOpcode = -1;
               return true;
            }

            WidgetNode var88;
            if(Client.packetOpcode == 182) {
               var1 = Client.field350.method2878();
               var2 = Client.field350.readUnsignedByte();
               var3 = Client.field350.method2867();
               var88 = (WidgetNode)Client.componentTable.method2399((long)var1);
               if(var88 != null) {
                  World.method672(var88, var88.id != var3);
               }

               WidgetNode var65 = new WidgetNode();
               var65.id = var3;
               var65.field189 = var2;
               Client.componentTable.method2400(var65, (long)var1);
               class10.method134(var3);
               Widget var95 = class179.method3296(var1);
               class174.method3276(var95);
               if(null != Client.field469) {
                  class174.method3276(Client.field469);
                  Client.field469 = null;
               }

               class13.method173();
               class154.method3034(Widget.widgets[var1 >> 16], var95, false);
               class159.method3071(var3);
               if(Client.widgetRoot != -1) {
                  var42 = Client.widgetRoot;
                  if(class30.method696(var42)) {
                     class164.method3159(Widget.widgets[var42], 1);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 254) {
               if(Client.widgetRoot != -1) {
                  var1 = Client.widgetRoot;
                  if(class30.method696(var1)) {
                     class164.method3159(Widget.widgets[var1], 0);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 153 || Client.packetOpcode == 44 || Client.packetOpcode == 248 || Client.packetOpcode == 116 || Client.packetOpcode == 247 || Client.packetOpcode == 225 || Client.packetOpcode == 84 || Client.packetOpcode == 58 || Client.packetOpcode == 186 || Client.packetOpcode == 231) {
               class5.method68();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 251) {
               var1 = Client.field350.method2867();
               byte var78 = Client.field350.method3015();
               class165.settings[var1] = var78;
               if(var78 != class165.widgetSettings[var1]) {
                  class165.widgetSettings[var1] = var78;
               }

               class145.method2760(var1);
               Client.field445[++Client.field535 - 1 & 31] = var1;
               Client.packetOpcode = -1;
               return true;
            }

            class159 var111;
            if(Client.packetOpcode == 172) {
               Player.xteaChanged(true);
               Client.field350.method3069();
               var1 = Client.field350.readUnsignedShort();
               var111 = Client.field350;
               var3 = var111.offset;
               class45.field928 = 0;
               var4 = 0;
               var111.method3072();

               for(var29 = 0; var29 < class45.field921; ++var29) {
                  var31 = class45.field931[var29];
                  if((class45.field918[var31] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                     } else {
                        var42 = var111.method3095(1);
                        if(var42 == 0) {
                           var4 = FaceNormal.method1955(var111);
                           class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                        } else {
                           XGrandExchangeOffer.method56(var111, var31);
                        }
                     }
                  }
               }

               var111.method3074();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var111.method3072();

               for(var29 = 0; var29 < class45.field921; ++var29) {
                  var31 = class45.field931[var29];
                  if((class45.field918[var31] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                     } else {
                        var42 = var111.method3095(1);
                        if(var42 == 0) {
                           var4 = FaceNormal.method1955(var111);
                           class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                        } else {
                           XGrandExchangeOffer.method56(var111, var31);
                        }
                     }
                  }
               }

               var111.method3074();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var111.method3072();

               for(var29 = 0; var29 < class45.field929; ++var29) {
                  var31 = class45.field924[var29];
                  if((class45.field918[var31] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                     } else {
                        var42 = var111.method3095(1);
                        if(var42 == 0) {
                           var4 = FaceNormal.method1955(var111);
                           class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                        } else if(Projectile.method866(var111, var31)) {
                           class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                        }
                     }
                  }
               }

               var111.method3074();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var111.method3072();

               for(var29 = 0; var29 < class45.field929; ++var29) {
                  var31 = class45.field924[var29];
                  if((class45.field918[var31] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                     } else {
                        var42 = var111.method3095(1);
                        if(var42 == 0) {
                           var4 = FaceNormal.method1955(var111);
                           class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                        } else if(Projectile.method866(var111, var31)) {
                           class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                        }
                     }
                  }
               }

               var111.method3074();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               class45.field921 = 0;
               class45.field929 = 0;

               for(var29 = 1; var29 < 2048; ++var29) {
                  class45.field918[var29] = (byte)(class45.field918[var29] >> 1);
                  var30 = Client.cachedPlayers[var29];
                  if(null != var30) {
                     class45.field931[++class45.field921 - 1] = var29;
                  } else {
                     class45.field924[++class45.field929 - 1] = var29;
                  }
               }

               for(var4 = 0; var4 < class45.field928; ++var4) {
                  var29 = class45.field916[var4];
                  var30 = Client.cachedPlayers[var29];
                  var42 = var111.readUnsignedByte();
                  if((var42 & 16) != 0) {
                     var42 += var111.readUnsignedByte() << 8;
                  }

                  class154.method3036(var111, var29, var30, var42);
               }

               if(var1 != var111.offset - var3) {
                  throw new RuntimeException(var111.offset - var3 + " " + var1);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 29) {
               class8.field81 = Client.field350.method2859();
               class181.field2704 = Client.field350.method2897();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 6) {
               var1 = Client.field350.method2955();
               ChatMessages.field934 = class33.field775.method2029(var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 13) {
               class45.field921 = 0;

               for(var1 = 0; var1 < 2048; ++var1) {
                  class45.field920[var1] = null;
                  class45.field923[var1] = 1;
               }

               for(var1 = 0; var1 < 2048; ++var1) {
                  Client.cachedPlayers[var1] = null;
               }

               Item.method879(Client.field350);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 164) {
               var1 = Client.field350.method2955();
               var2 = Client.field350.readUnsignedShort();
               var89 = class179.method3296(var1);
               if(var89.modelType != 2 || var89.modelId != var2) {
                  var89.modelType = 2;
                  var89.modelId = var2;
                  class174.method3276(var89);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 223) {
               var1 = Client.field350.method2965();
               var2 = Client.field350.readUnsignedShort();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var89 = class179.method3296(var1);
               } else {
                  var89 = null;
               }

               if(var89 != null) {
                  for(var4 = 0; var4 < var89.itemIds.length; ++var4) {
                     var89.itemIds[var4] = 0;
                     var89.itemQuantities[var4] = 0;
                  }
               }

               XItemContainer var90 = (XItemContainer)XItemContainer.itemContainers.method2399((long)var2);
               if(null != var90) {
                  for(var29 = 0; var29 < var90.itemIds.length; ++var29) {
                     var90.itemIds[var29] = -1;
                     var90.stackSizes[var29] = 0;
                  }
               }

               var4 = Client.field350.readUnsignedShort();

               for(var29 = 0; var29 < var4; ++var29) {
                  var31 = Client.field350.method2861();
                  if(var31 == 255) {
                     var31 = Client.field350.method2955();
                  }

                  var42 = Client.field350.readUnsignedShort();
                  if(null != var89 && var29 < var89.itemIds.length) {
                     var89.itemIds[var29] = var42;
                     var89.itemQuantities[var29] = var31;
                  }

                  class31.method709(var2, var29, var42 - 1, var31);
               }

               if(null != var89) {
                  class174.method3276(var89);
               }

               Client.method601();
               Client.interfaceItemTriggers[++Client.field494 - 1 & 31] = var2 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 8) {
               var1 = Client.field350.method2878();
               var2 = Client.field350.readUnsignedShort();
               class165.settings[var2] = var1;
               if(var1 != class165.widgetSettings[var2]) {
                  class165.widgetSettings[var2] = var1;
               }

               class145.method2760(var2);
               Client.field445[++Client.field535 - 1 & 31] = var2;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 124) {
               var1 = Client.field350.method2955();
               var112 = Client.field350.method2868();
               var89 = class179.method3296(var1);
               if(!var112.equals(var89.text)) {
                  var89.text = var112;
                  class174.method3276(var89);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 240) {
               Client.field564 = Client.field350.readUnsignedByte();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 104) {
               var1 = Client.field350.method2878();
               var2 = Client.field350.method2878();
               WidgetNode var92 = (WidgetNode)Client.componentTable.method2399((long)var2);
               var88 = (WidgetNode)Client.componentTable.method2399((long)var1);
               if(var88 != null) {
                  World.method672(var88, var92 == null || var88.id != var92.id);
               }

               if(var92 != null) {
                  var92.unlink();
                  Client.componentTable.method2400(var92, (long)var1);
               }

               var64 = class179.method3296(var2);
               if(null != var64) {
                  class174.method3276(var64);
               }

               var64 = class179.method3296(var1);
               if(var64 != null) {
                  class174.method3276(var64);
                  class154.method3034(Widget.widgets[var64.id >>> 16], var64, true);
               }

               if(Client.widgetRoot != -1) {
                  var31 = Client.widgetRoot;
                  if(class30.method696(var31)) {
                     class164.method3159(Widget.widgets[var31], 1);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            boolean var97;
            if(Client.packetOpcode == 243) {
               while(Client.field350.offset < Client.field351) {
                  var67 = Client.field350.readUnsignedByte() == 1;
                  var112 = Client.field350.method2868();
                  var27 = Client.field350.method2868();
                  var4 = Client.field350.readUnsignedShort();
                  var29 = Client.field350.readUnsignedByte();
                  var31 = Client.field350.readUnsignedByte();
                  boolean var114 = (var31 & 2) != 0;
                  var97 = (var31 & 1) != 0;
                  if(var4 > 0) {
                     Client.field350.method2868();
                     Client.field350.readUnsignedByte();
                     Client.field350.method2965();
                  }

                  Client.field350.method2868();

                  for(var40 = 0; var40 < Client.friendCount; ++var40) {
                     Friend var106 = Client.friends[var40];
                     if(!var67) {
                        if(var112.equals(var106.name)) {
                           if(var106.world != var4) {
                              var80 = true;

                              for(class16 var26 = (class16)Client.field575.method2488(); var26 != null; var26 = (class16)Client.field575.method2489()) {
                                 if(var26.field180.equals(var112)) {
                                    if(var4 != 0 && var26.field182 == 0) {
                                       var26.method2496();
                                       var80 = false;
                                    } else if(var4 == 0 && var26.field182 != 0) {
                                       var26.method2496();
                                       var80 = false;
                                    }
                                 }
                              }

                              if(var80) {
                                 Client.field575.method2487(new class16(var112, var4));
                              }

                              var106.world = var4;
                           }

                           var106.previousName = var27;
                           var106.rank = var29;
                           var106.field161 = var114;
                           var106.field164 = var97;
                           var112 = null;
                           break;
                        }
                     } else if(var27.equals(var106.name)) {
                        var106.name = var112;
                        var106.previousName = var27;
                        var112 = null;
                        break;
                     }
                  }

                  if(var112 != null && Client.friendCount < 400) {
                     Friend var103 = new Friend();
                     Client.friends[Client.friendCount] = var103;
                     var103.name = var112;
                     var103.previousName = var27;
                     var103.world = var4;
                     var103.rank = var29;
                     var103.field161 = var114;
                     var103.field164 = var97;
                     ++Client.friendCount;
                  }
               }

               Client.field573 = 2;
               Client.field451 = Client.field490;
               var67 = false;
               var2 = Client.friendCount;

               while(var2 > 0) {
                  var67 = true;
                  --var2;

                  for(var3 = 0; var3 < var2; ++var3) {
                     var79 = false;
                     Friend var5 = Client.friends[var3];
                     Friend var93 = Client.friends[var3 + 1];
                     if(var5.world != Client.world && Client.world == var93.world) {
                        var79 = true;
                     }

                     if(!var79 && var5.world == 0 && var93.world != 0) {
                        var79 = true;
                     }

                     if(!var79 && !var5.field161 && var93.field161) {
                        var79 = true;
                     }

                     if(!var79 && !var5.field164 && var93.field164) {
                        var79 = true;
                     }

                     if(var79) {
                        Friend var75 = Client.friends[var3];
                        Client.friends[var3] = Client.friends[1 + var3];
                        Client.friends[var3 + 1] = var75;
                        var67 = false;
                     }
                  }

                  if(var67) {
                     break;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 37) {
               Client.field573 = 1;
               Client.field451 = Client.field490;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 0) {
               World var84 = new World();
               var84.address = Client.field350.method2868();
               var84.id = Client.field350.readUnsignedShort();
               var2 = Client.field350.method2965();
               var84.mask = var2;
               class8.setGameState(45);
               class149.field2036.method2118();
               class149.field2036 = null;
               Spotanim.method3482(var84);
               Client.packetOpcode = -1;
               return false;
            }

            if(Client.packetOpcode == 147) {
               var1 = Client.field351 + Client.field350.offset;
               var2 = Client.field350.readUnsignedShort();
               var3 = Client.field350.readUnsignedShort();
               if(var2 != Client.widgetRoot) {
                  Client.widgetRoot = var2;
                  CombatInfoListHolder.method797(false);
                  class10.method134(Client.widgetRoot);
                  class159.method3071(Client.widgetRoot);

                  for(var4 = 0; var4 < 100; ++var4) {
                     Client.field510[var4] = true;
                  }
               }

               WidgetNode var71;
               for(; var3-- > 0; var71.field190 = true) {
                  var4 = Client.field350.method2965();
                  var29 = Client.field350.readUnsignedShort();
                  var31 = Client.field350.readUnsignedByte();
                  var71 = (WidgetNode)Client.componentTable.method2399((long)var4);
                  if(null != var71 && var29 != var71.id) {
                     World.method672(var71, true);
                     var71 = null;
                  }

                  if(var71 == null) {
                     WidgetNode var101 = new WidgetNode();
                     var101.id = var29;
                     var101.field189 = var31;
                     Client.componentTable.method2400(var101, (long)var4);
                     class10.method134(var29);
                     Widget var34 = class179.method3296(var4);
                     class174.method3276(var34);
                     if(Client.field469 != null) {
                        class174.method3276(Client.field469);
                        Client.field469 = null;
                     }

                     class13.method173();
                     class154.method3034(Widget.widgets[var4 >> 16], var34, false);
                     class159.method3071(var29);
                     if(Client.widgetRoot != -1) {
                        var11 = Client.widgetRoot;
                        if(class30.method696(var11)) {
                           class164.method3159(Widget.widgets[var11], 1);
                        }
                     }

                     var71 = var101;
                  }
               }

               for(var88 = (WidgetNode)Client.componentTable.method2403(); null != var88; var88 = (WidgetNode)Client.componentTable.method2411()) {
                  if(var88.field190) {
                     var88.field190 = false;
                  } else {
                     World.method672(var88, true);
                  }
               }

               Client.widgetFlags = new XHashTable(512);

               while(Client.field350.offset < var1) {
                  var4 = Client.field350.method2965();
                  var29 = Client.field350.readUnsignedShort();
                  var31 = Client.field350.readUnsignedShort();
                  var42 = Client.field350.method2965();

                  for(var32 = var29; var32 <= var31; ++var32) {
                     var9 = ((long)var4 << 32) + (long)var32;
                     Client.widgetFlags.method2400(new class133(var42), var9);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 252) {
               var1 = Client.field350.method2873();
               var2 = Client.field350.method2873();
               var3 = Client.field350.method2879();
               var28 = class179.method3296(var3);
               var28.field2294 = var2 + (var1 << 16);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 85) {
               Client.field553 = false;

               for(var1 = 0; var1 < 5; ++var1) {
                  Client.field554[var1] = false;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 91) {
               var1 = Client.field350.method2897();
               var2 = Client.field350.method2859();
               var27 = Client.field350.method2868();
               if(var1 >= 1 && var1 <= 8) {
                  if(var27.equalsIgnoreCase("null")) {
                     var27 = null;
                  }

                  Client.playerOptions[var1 - 1] = var27;
                  Client.playerOptionsPriority[var1 - 1] = var2 == 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 42) {
               var1 = Client.field350.method2879();
               var2 = Client.field350.method2848();
               var89 = class179.method3296(var1);
               if(var89.field2230 != var2 || var2 == -1) {
                  var89.field2230 = var2;
                  var89.field2327 = 0;
                  var89.field2328 = 0;
                  class174.method3276(var89);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 32) {
               var1 = Client.field350.method2873();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               if(var1 == -1 && !Client.field545) {
                  class138.field1916.method2620();
                  class138.field1919 = 1;
                  class167.field2182 = null;
               } else if(var1 != -1 && var1 != Client.field421 && Client.field542 != 0 && !Client.field545) {
                  class152.method2815(2, class11.field127, var1, 0, Client.field542, false);
               }

               Client.field421 = var1;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 161) {
               var1 = Client.field350.method2823();
               var2 = Client.field350.method2869();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               if(Client.field542 != 0 && var2 != -1) {
                  class72.method1464(class150.field2044, var2, 0, Client.field542, false);
                  Client.field545 = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 61) {
               var1 = Client.field350.method2869();
               Client.widgetRoot = var1;
               CombatInfoListHolder.method797(false);
               class10.method134(var1);
               class159.method3071(Client.widgetRoot);

               for(var2 = 0; var2 < 100; ++var2) {
                  Client.field510[var2] = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 185) {
               Client.field350.offset += 28;
               if(Client.field350.method2855()) {
                  var83 = Client.field350;
                  var2 = Client.field350.offset - 28;
                  if(class104.field1692 != null) {
                     try {
                        class104.field1692.method1453(0L);
                        class104.field1692.method1436(var83.payload, var2, 24);
                     } catch (Exception var53) {
                        ;
                     }
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 187) {
               Player.xteaChanged(false);
               Client.field350.method3069();
               var1 = Client.field350.readUnsignedShort();
               var111 = Client.field350;
               var3 = var111.offset;
               class45.field928 = 0;
               var4 = 0;
               var111.method3072();

               for(var29 = 0; var29 < class45.field921; ++var29) {
                  var31 = class45.field931[var29];
                  if((class45.field918[var31] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                     } else {
                        var42 = var111.method3095(1);
                        if(var42 == 0) {
                           var4 = FaceNormal.method1955(var111);
                           class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                        } else {
                           XGrandExchangeOffer.method56(var111, var31);
                        }
                     }
                  }
               }

               var111.method3074();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var111.method3072();

               for(var29 = 0; var29 < class45.field921; ++var29) {
                  var31 = class45.field931[var29];
                  if((class45.field918[var31] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                     } else {
                        var42 = var111.method3095(1);
                        if(var42 == 0) {
                           var4 = FaceNormal.method1955(var111);
                           class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                        } else {
                           XGrandExchangeOffer.method56(var111, var31);
                        }
                     }
                  }
               }

               var111.method3074();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var111.method3072();

               for(var29 = 0; var29 < class45.field929; ++var29) {
                  var31 = class45.field924[var29];
                  if((class45.field918[var31] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                     } else {
                        var42 = var111.method3095(1);
                        if(var42 == 0) {
                           var4 = FaceNormal.method1955(var111);
                           class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                        } else if(Projectile.method866(var111, var31)) {
                           class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                        }
                     }
                  }
               }

               var111.method3074();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var111.method3072();

               for(var29 = 0; var29 < class45.field929; ++var29) {
                  var31 = class45.field924[var29];
                  if((class45.field918[var31] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                     } else {
                        var42 = var111.method3095(1);
                        if(var42 == 0) {
                           var4 = FaceNormal.method1955(var111);
                           class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                        } else if(Projectile.method866(var111, var31)) {
                           class45.field918[var31] = (byte)(class45.field918[var31] | 2);
                        }
                     }
                  }
               }

               var111.method3074();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               class45.field921 = 0;
               class45.field929 = 0;

               for(var29 = 1; var29 < 2048; ++var29) {
                  class45.field918[var29] = (byte)(class45.field918[var29] >> 1);
                  var30 = Client.cachedPlayers[var29];
                  if(null != var30) {
                     class45.field931[++class45.field921 - 1] = var29;
                  } else {
                     class45.field924[++class45.field929 - 1] = var29;
                  }
               }

               for(var4 = 0; var4 < class45.field928; ++var4) {
                  var29 = class45.field916[var4];
                  var30 = Client.cachedPlayers[var29];
                  var42 = var111.readUnsignedByte();
                  if((var42 & 16) != 0) {
                     var42 += var111.readUnsignedByte() << 8;
                  }

                  class154.method3036(var111, var29, var30, var42);
               }

               if(var111.offset - var3 != var1) {
                  throw new RuntimeException(var111.offset - var3 + " " + var1);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 143) {
               class6.method73();
               Client.packetOpcode = -1;
               return false;
            }

            if(Client.packetOpcode == 144) {
               var1 = Client.field350.method2878();
               var63 = Client.field350.method2859() == 1;
               var89 = class179.method3296(var1);
               if(var63 != var89.isHidden) {
                  var89.isHidden = var63;
                  class174.method3276(var89);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 73) {
               Client.field499 = Client.field490;
               if(Client.field351 == 0) {
                  Client.field532 = null;
                  Client.clanChatOwner = null;
                  Player.clanChatCount = 0;
                  class72.clanMembers = null;
                  Client.packetOpcode = -1;
                  return true;
               }

               Client.clanChatOwner = Client.field350.method2868();
               long var50 = Client.field350.method2819();
               var24 = var50;
               if(var50 > 0L && var50 < 6582952005840035281L) {
                  if(0L == var50 % 37L) {
                     var27 = null;
                  } else {
                     var31 = 0;

                     for(var38 = var50; var38 != 0L; var38 /= 37L) {
                        ++var31;
                     }

                     StringBuilder var33 = new StringBuilder(var31);

                     while(var24 != 0L) {
                        var47 = var24;
                        var24 /= 37L;
                        var33.append(class205.field3086[(int)(var47 - 37L * var24)]);
                     }

                     var27 = var33.reverse().toString();
                  }
               } else {
                  var27 = null;
               }

               Client.field532 = var27;
               class115.field1805 = Client.field350.readByte();
               var31 = Client.field350.readUnsignedByte();
               if(var31 == 255) {
                  Client.packetOpcode = -1;
                  return true;
               }

               Player.clanChatCount = var31;
               XClanMember[] var70 = new XClanMember[100];

               for(var32 = 0; var32 < Player.clanChatCount; ++var32) {
                  var70[var32] = new XClanMember();
                  var70[var32].username = Client.field350.method2868();
                  var70[var32].field288 = GroundObject.method1594(var70[var32].username, MessageNode.field244);
                  var70[var32].world = Client.field350.readUnsignedShort();
                  var70[var32].rank = Client.field350.readByte();
                  Client.field350.method2868();
                  if(var70[var32].username.equals(class36.localPlayer.name)) {
                     ObjectComposition.field2942 = var70[var32].rank;
                  }
               }

               var97 = false;
               var10 = Player.clanChatCount;

               while(var10 > 0) {
                  var97 = true;
                  --var10;

                  for(var11 = 0; var11 < var10; ++var11) {
                     if(var70[var11].field288.compareTo(var70[1 + var11].field288) > 0) {
                        XClanMember var99 = var70[var11];
                        var70[var11] = var70[1 + var11];
                        var70[var11 + 1] = var99;
                        var97 = false;
                     }
                  }

                  if(var97) {
                     break;
                  }
               }

               class72.clanMembers = var70;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 30) {
               Client.method601();
               var1 = Client.field350.method2878();
               var2 = Client.field350.method2859();
               var3 = Client.field350.readUnsignedByte();
               Client.skillExperiences[var2] = var1;
               Client.boostedSkillLevels[var2] = var3;
               Client.realSkillLevels[var2] = 1;

               for(var4 = 0; var4 < 98; ++var4) {
                  if(var1 >= class172.field2352[var4]) {
                     Client.realSkillLevels[var2] = var4 + 2;
                  }
               }

               Client.field495[++Client.field460 - 1 & 31] = var2;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 35) {
               var1 = Client.field350.readUnsignedShort();
               var2 = Client.field350.readUnsignedByte();
               var3 = Client.field350.readUnsignedShort();
               VertexNormal.method1684(var1, var2, var3);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 106) {
               var1 = Client.field350.method2955();
               var41 = class179.method3296(var1);
               var41.modelType = 3;
               var41.modelId = class36.localPlayer.composition.method3178();
               class174.method3276(var41);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 196) {
               var1 = Client.field350.method2873();
               var2 = Client.field350.method2879();
               var3 = var1 >> 10 & 31;
               var4 = var1 >> 5 & 31;
               var29 = var1 & 31;
               var31 = (var3 << 19) + (var4 << 11) + (var29 << 3);
               Widget var7 = class179.method3296(var2);
               if(var7.textColor != var31) {
                  var7.textColor = var31;
                  class174.method3276(var7);
               }

               Client.packetOpcode = -1;
               return true;
            }

            class37.method822("" + Client.packetOpcode + "," + Client.field356 + "," + Client.field574 + "," + Client.field351, (Throwable)null);
            class6.method73();
         } catch (IOException var61) {
            if(Client.field358 > 0) {
               class6.method73();
            } else {
               class8.setGameState(40);
               class159.field2130 = class149.field2036;
               class149.field2036 = null;
            }
         } catch (Exception var62) {
            var21 = "" + Client.packetOpcode + "," + Client.field356 + "," + Client.field574 + "," + Client.field351 + "," + (class5.baseX + class36.localPlayer.pathX[0]) + "," + (XClanMember.baseY + class36.localPlayer.pathY[0]) + ",";

            for(var2 = 0; var2 < Client.field351 && var2 < 50; ++var2) {
               var21 = var21 + Client.field350.payload[var2] + ",";
            }

            class37.method822(var21, var62);
            class6.method73();
         }

         return true;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)LSpotanim;",
      garbageValue = "-1301615308"
   )
   public static Spotanim method1953(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.field2803.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class148.field2028.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.field2799 = var0;
         if(var2 != null) {
            var1.method3477(new Buffer(var2));
         }

         Spotanim.field2803.put(var1, (long)var0);
         return var1;
      }
   }
}
