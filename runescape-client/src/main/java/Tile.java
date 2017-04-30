import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("w")
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("l")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1767849801
   )
   @Export("x")
   int x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2076119841
   )
   int field1319;
   @ObfuscatedName("u")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1256221767
   )
   int field1323;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 900353481
   )
   int field1324;
   @ObfuscatedName("v")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1976229665
   )
   int field1326;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -716776815
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("r")
   int[] field1328;
   @ObfuscatedName("z")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2103996431
   )
   int field1330;
   @ObfuscatedName("e")
   boolean field1331;
   @ObfuscatedName("j")
   boolean field1332;
   @ObfuscatedName("i")
   boolean field1333;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1995841741
   )
   int field1334;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -923850207
   )
   int field1335;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -786115039
   )
   int field1336;
   @ObfuscatedName("p")
   class77 field1337;
   @ObfuscatedName("f")
   Tile field1338;
   @ObfuscatedName("t")
   class85 field1339;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1871042591
   )
   @Export("y")
   int y;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1783083684"
   )
   public static int method1565(String var0) {
      return var0.length() + 2;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1830923379"
   )
   static final void method1566() {
      if(Client.field495 > 1) {
         --Client.field495;
      }

      if(Client.field489 > 0) {
         --Client.field489;
      }

      if(Client.field336) {
         Client.field336 = false;
         if(Client.field489 > 0) {
            class0.method12();
         } else {
            class9.setGameState(40);
            class132.field1979 = Friend.rssocket;
            Friend.rssocket = null;
         }

      } else {
         if(!Client.isMenuOpen) {
            class119.method2293();
         }

         int var0;
         int var2;
         String var3;
         int var4;
         int var7;
         int var8;
         int var9;
         int var10;
         int var15;
         int var21;
         int var24;
         long var40;
         int var46;
         int var49;
         boolean var71;
         int var74;
         boolean var79;
         int var80;
         Widget var95;
         boolean var121;
         for(var0 = 0; var0 < 100; ++var0) {
            boolean var1;
            if(Friend.rssocket == null) {
               var1 = false;
            } else {
               label3199: {
                  try {
                     var2 = Friend.rssocket.available();
                     if(var2 == 0) {
                        var1 = false;
                        break label3199;
                     }

                     if(Client.packetOpcode == -1) {
                        Friend.rssocket.read(Client.secretPacketBuffer2.payload, 0, 1);
                        Client.secretPacketBuffer2.offset = 0;
                        Client.packetOpcode = Client.secretPacketBuffer2.readOpcode();
                        Client.packetLength = class216.packetLenghts[Client.packetOpcode];
                        --var2;
                     }

                     if(Client.packetLength == -1) {
                        if(var2 <= 0) {
                           var1 = false;
                           break label3199;
                        }

                        Friend.rssocket.read(Client.secretPacketBuffer2.payload, 0, 1);
                        Client.packetLength = Client.secretPacketBuffer2.payload[0] & 255;
                        --var2;
                     }

                     if(Client.packetLength == -2) {
                        if(var2 <= 1) {
                           var1 = false;
                           break label3199;
                        }

                        Friend.rssocket.read(Client.secretPacketBuffer2.payload, 0, 2);
                        Client.secretPacketBuffer2.offset = 0;
                        Client.packetLength = Client.secretPacketBuffer2.readUnsignedShort();
                        var2 -= 2;
                     }

                     if(var2 < Client.packetLength) {
                        var1 = false;
                        break label3199;
                     }

                     Client.secretPacketBuffer2.offset = 0;
                     Friend.rssocket.read(Client.secretPacketBuffer2.payload, 0, Client.packetLength);
                     Client.field330 = 0;
                     Client.field466 = Client.field417;
                     Client.field417 = Client.field538;
                     Client.field538 = Client.packetOpcode;
                     if(Client.packetOpcode == 172) {
                        Client.field323 = Client.secretPacketBuffer2.readUnsignedByte();
                        Client.field468 = Client.secretPacketBuffer2.readUnsignedByte();
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 2) {
                        World var72 = new World();
                        var72.address = Client.secretPacketBuffer2.readString();
                        var72.id = Client.secretPacketBuffer2.readUnsignedShort();
                        var4 = Client.secretPacketBuffer2.readInt();
                        var72.mask = var4;
                        class9.setGameState(45);
                        Friend.rssocket.method2093();
                        Friend.rssocket = null;
                        class7.method100(var72);
                        Client.packetOpcode = -1;
                        var1 = false;
                        break label3199;
                     }

                     if(Client.packetOpcode == 77) {
                        var21 = Client.secretPacketBuffer2.method2577();
                        var95 = class128.method2364(var21);
                        var95.modelType = 3;
                        var95.modelId = class22.localPlayer.composition.method3170();
                        class124.method2350(var95);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     String var5;
                     boolean var6;
                     boolean var13;
                     String var91;
                     if(Client.packetOpcode == 76) {
                        while(Client.secretPacketBuffer2.offset < Client.packetLength) {
                           var121 = Client.secretPacketBuffer2.readUnsignedByte() == 1;
                           var91 = Client.secretPacketBuffer2.readString();
                           var5 = Client.secretPacketBuffer2.readString();
                           var74 = Client.secretPacketBuffer2.readUnsignedShort();
                           var7 = Client.secretPacketBuffer2.readUnsignedByte();
                           var8 = Client.secretPacketBuffer2.readUnsignedByte();
                           boolean var83 = (var8 & 2) != 0;
                           var79 = (var8 & 1) != 0;
                           if(var74 > 0) {
                              Client.secretPacketBuffer2.readString();
                              Client.secretPacketBuffer2.readUnsignedByte();
                              Client.secretPacketBuffer2.readInt();
                           }

                           Client.secretPacketBuffer2.readString();

                           for(var80 = 0; var80 < Client.friendCount; ++var80) {
                              Friend var81 = Client.friends[var80];
                              if(!var121) {
                                 if(var91.equals(var81.name)) {
                                    if(var74 != var81.world) {
                                       var13 = true;

                                       for(class16 var88 = (class16)Client.field556.method2857(); var88 != null; var88 = (class16)Client.field556.method2858()) {
                                          if(var88.field170.equals(var91)) {
                                             if(var74 != 0 && var88.field171 == 0) {
                                                var88.method2865();
                                                var13 = false;
                                             } else if(var74 == 0 && var88.field171 != 0) {
                                                var88.method2865();
                                                var13 = false;
                                             }
                                          }
                                       }

                                       if(var13) {
                                          Client.field556.method2856(new class16(var91, var74));
                                       }

                                       var81.world = var74;
                                    }

                                    var81.previousName = var5;
                                    var81.rank = var7;
                                    var81.field152 = var83;
                                    var81.field159 = var79;
                                    var91 = null;
                                    break;
                                 }
                              } else if(var5.equals(var81.name)) {
                                 var81.name = var91;
                                 var81.previousName = var5;
                                 var91 = null;
                                 break;
                              }
                           }

                           if(var91 != null && Client.friendCount < 400) {
                              Friend var94 = new Friend();
                              Client.friends[Client.friendCount] = var94;
                              var94.name = var91;
                              var94.previousName = var5;
                              var94.world = var74;
                              var94.rank = var7;
                              var94.field152 = var83;
                              var94.field159 = var79;
                              ++Client.friendCount;
                           }
                        }

                        Client.field554 = 2;
                        Client.field478 = Client.field311;
                        var121 = false;
                        var4 = Client.friendCount;

                        while(var4 > 0) {
                           var121 = true;
                           --var4;

                           for(var24 = 0; var24 < var4; ++var24) {
                              var6 = false;
                              Friend var112 = Client.friends[var24];
                              Friend var110 = Client.friends[var24 + 1];
                              if(var112.world != Client.world && Client.world == var110.world) {
                                 var6 = true;
                              }

                              if(!var6 && var112.world == 0 && var110.world != 0) {
                                 var6 = true;
                              }

                              if(!var6 && !var112.field152 && var110.field152) {
                                 var6 = true;
                              }

                              if(!var6 && !var112.field159 && var110.field159) {
                                 var6 = true;
                              }

                              if(var6) {
                                 Friend var115 = Client.friends[var24];
                                 Client.friends[var24] = Client.friends[var24 + 1];
                                 Client.friends[var24 + 1] = var115;
                                 var121 = false;
                              }
                           }

                           if(var121) {
                              break;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 53) {
                        var21 = Client.secretPacketBuffer2.readUnsignedShort();
                        Client.widgetRoot = var21;
                        class15.method188(false);
                        class99.method1946(var21);
                        TextureProvider.method1473(Client.widgetRoot);

                        for(var4 = 0; var4 < 100; ++var4) {
                           Client.field368[var4] = true;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 189) {
                        Client.field534 = true;
                        class3.field36 = Client.secretPacketBuffer2.readUnsignedByte();
                        GameObject.field1597 = Client.secretPacketBuffer2.readUnsignedByte();
                        Frames.field1554 = Client.secretPacketBuffer2.readUnsignedShort();
                        class7.field60 = Client.secretPacketBuffer2.readUnsignedByte();
                        class130.field1969 = Client.secretPacketBuffer2.readUnsignedByte();
                        if(class130.field1969 >= 100) {
                           class22.cameraX = class3.field36 * 128 + 64;
                           class13.cameraY = GameObject.field1597 * 128 + 64;
                           class1.cameraZ = CombatInfo1.method600(class22.cameraX, class13.cameraY, Client.plane) - Frames.field1554;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 69) {
                        var21 = Client.secretPacketBuffer2.readUnsignedByte();
                        var4 = Client.secretPacketBuffer2.readUnsignedByte();
                        var24 = Client.secretPacketBuffer2.readUnsignedByte();
                        var74 = Client.secretPacketBuffer2.readUnsignedByte();
                        Client.field535[var21] = true;
                        Client.field536[var21] = var4;
                        Client.field401[var21] = var24;
                        Client.field545[var21] = var74;
                        Client.field539[var21] = 0;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     Widget var105;
                     WidgetNode var118;
                     if(Client.packetOpcode == 190) {
                        var21 = Client.secretPacketBuffer2.method2487();
                        var4 = Client.secretPacketBuffer2.method2577();
                        WidgetNode var85 = (WidgetNode)Client.componentTable.method2773((long)var4);
                        var118 = (WidgetNode)Client.componentTable.method2773((long)var21);
                        if(var118 != null) {
                           FrameMap.method1718(var118, var85 == null || var118.id != var85.id);
                        }

                        if(var85 != null) {
                           var85.unlink();
                           Client.componentTable.method2774(var85, (long)var21);
                        }

                        var105 = class128.method2364(var4);
                        if(var105 != null) {
                           class124.method2350(var105);
                        }

                        var105 = class128.method2364(var21);
                        if(var105 != null) {
                           class124.method2350(var105);
                           class164.method3116(class133.widgets[var105.id >>> 16], var105, true);
                        }

                        if(Client.widgetRoot != -1) {
                           Client.method572(Client.widgetRoot, 1);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 249) {
                        Client.field534 = true;
                        class7.field63 = Client.secretPacketBuffer2.readUnsignedByte();
                        class131.field1974 = Client.secretPacketBuffer2.readUnsignedByte();
                        class10.field95 = Client.secretPacketBuffer2.readUnsignedShort();
                        class44.field884 = Client.secretPacketBuffer2.readUnsignedByte();
                        Buffer.field1961 = Client.secretPacketBuffer2.readUnsignedByte();
                        if(Buffer.field1961 >= 100) {
                           var21 = class7.field63 * 128 + 64;
                           var4 = class131.field1974 * 128 + 64;
                           var24 = CombatInfo1.method600(var21, var4, Client.plane) - class10.field95;
                           var74 = var21 - class22.cameraX;
                           var7 = var24 - class1.cameraZ;
                           var8 = var4 - class13.cameraY;
                           var9 = (int)Math.sqrt((double)(var8 * var8 + var74 * var74));
                           class108.cameraPitch = (int)(Math.atan2((double)var7, (double)var9) * 325.949D) & 2047;
                           class13.cameraYaw = (int)(Math.atan2((double)var74, (double)var8) * -325.949D) & 2047;
                           if(class108.cameraPitch < 128) {
                              class108.cameraPitch = 128;
                           }

                           if(class108.cameraPitch > 383) {
                              class108.cameraPitch = 383;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 203) {
                        if(Client.widgetRoot != -1) {
                           var21 = Client.widgetRoot;
                           if(class112.method2112(var21)) {
                              FileOnDisk.method1445(class133.widgets[var21], 0);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 52) {
                        Friend.field157 = class211.method4013(Client.secretPacketBuffer2.readUnsignedByte());
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     long var31;
                     if(Client.packetOpcode == 200) {
                        var21 = Client.secretPacketBuffer2.readInt();
                        var4 = Client.secretPacketBuffer2.readInt();
                        if(Player.field266 == null || !Player.field266.isValid()) {
                           try {
                              Iterator var84 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                              while(var84.hasNext()) {
                                 GarbageCollectorMXBean var119 = (GarbageCollectorMXBean)var84.next();
                                 if(var119.isValid()) {
                                    Player.field266 = var119;
                                    Client.field564 = -1L;
                                    Client.field563 = -1L;
                                 }
                              }
                           } catch (Throwable var65) {
                              ;
                           }
                        }

                        long var29 = class72.method1421();
                        var7 = -1;
                        if(Player.field266 != null) {
                           var31 = Player.field266.getCollectionTime();
                           if(Client.field563 != -1L) {
                              long var33 = var31 - Client.field563;
                              long var35 = var29 - Client.field564;
                              if(var35 != 0L) {
                                 var7 = (int)(var33 * 100L / var35);
                              }
                           }

                           Client.field563 = var31;
                           Client.field564 = var29;
                        }

                        Client.secretPacketBuffer1.putOpcode(193);
                        Client.secretPacketBuffer1.method2411(var21);
                        Client.secretPacketBuffer1.method2426(var4);
                        Client.secretPacketBuffer1.method2429(GameEngine.FPS);
                        Client.secretPacketBuffer1.putByte(var7);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     Widget var75;
                     if(Client.packetOpcode == 78) {
                        var21 = Client.secretPacketBuffer2.method2419();
                        var4 = Client.secretPacketBuffer2.method2485();
                        var75 = class128.method2364(var4);
                        if(var75.modelType != 1 || var75.modelId != var21) {
                           var75.modelType = 1;
                           var75.modelId = var21;
                           class124.method2350(var75);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 163) {
                        var3 = Client.secretPacketBuffer2.readString();
                        Object[] var96 = new Object[var3.length() + 1];

                        for(var24 = var3.length() - 1; var24 >= 0; --var24) {
                           if(var3.charAt(var24) == 115) {
                              var96[var24 + 1] = Client.secretPacketBuffer2.readString();
                           } else {
                              var96[var24 + 1] = new Integer(Client.secretPacketBuffer2.readInt());
                           }
                        }

                        var96[0] = new Integer(Client.secretPacketBuffer2.readInt());
                        class18 var82 = new class18();
                        var82.field196 = var96;
                        Script.method910(var82, 200000);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 219) {
                        class38.method766(Client.secretPacketBuffer2, Client.packetLength);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     long var38;
                     if(Client.packetOpcode == 80) {
                        var21 = Client.packetLength + Client.secretPacketBuffer2.offset;
                        var4 = Client.secretPacketBuffer2.readUnsignedShort();
                        var24 = Client.secretPacketBuffer2.readUnsignedShort();
                        if(var4 != Client.widgetRoot) {
                           Client.widgetRoot = var4;
                           class15.method188(false);
                           class99.method1946(Client.widgetRoot);
                           TextureProvider.method1473(Client.widgetRoot);

                           for(var74 = 0; var74 < 100; ++var74) {
                              Client.field368[var74] = true;
                           }
                        }

                        WidgetNode var111;
                        for(; var24-- > 0; var111.field180 = true) {
                           var74 = Client.secretPacketBuffer2.readInt();
                           var7 = Client.secretPacketBuffer2.readUnsignedShort();
                           var8 = Client.secretPacketBuffer2.readUnsignedByte();
                           var111 = (WidgetNode)Client.componentTable.method2773((long)var74);
                           if(var111 != null && var7 != var111.id) {
                              FrameMap.method1718(var111, true);
                              var111 = null;
                           }

                           if(var111 == null) {
                              WidgetNode var23 = new WidgetNode();
                              var23.id = var7;
                              var23.field179 = var8;
                              Client.componentTable.method2774(var23, (long)var74);
                              class99.method1946(var7);
                              Widget var12 = class128.method2364(var74);
                              class124.method2350(var12);
                              if(Client.field449 != null) {
                                 class124.method2350(Client.field449);
                                 Client.field449 = null;
                              }

                              class16.method190();
                              class164.method3116(class133.widgets[var74 >> 16], var12, false);
                              TextureProvider.method1473(var7);
                              if(Client.widgetRoot != -1) {
                                 int var87 = Client.widgetRoot;
                                 if(class112.method2112(var87)) {
                                    FileOnDisk.method1445(class133.widgets[var87], 1);
                                 }
                              }

                              var111 = var23;
                           }
                        }

                        for(var118 = (WidgetNode)Client.componentTable.method2776(); var118 != null; var118 = (WidgetNode)Client.componentTable.method2777()) {
                           if(var118.field180) {
                              var118.field180 = false;
                           } else {
                              FrameMap.method1718(var118, true);
                           }
                        }

                        Client.widgetFlags = new XHashTable(512);

                        while(Client.secretPacketBuffer2.offset < var21) {
                           var74 = Client.secretPacketBuffer2.readInt();
                           var7 = Client.secretPacketBuffer2.readUnsignedShort();
                           var8 = Client.secretPacketBuffer2.readUnsignedShort();
                           var9 = Client.secretPacketBuffer2.readInt();

                           for(var10 = var7; var10 <= var8; ++var10) {
                              var38 = ((long)var74 << 32) + (long)var10;
                              Client.widgetFlags.method2774(new class154(var9), var38);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 16) {
                        var21 = Client.secretPacketBuffer2.method2577();
                        class0.field1 = class45.field896.method1969(var21);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 231) {
                        var21 = Client.secretPacketBuffer2.method2419();
                        var4 = Client.secretPacketBuffer2.readInt();
                        var24 = Client.secretPacketBuffer2.method2419();
                        var74 = Client.secretPacketBuffer2.method2418();
                        var105 = class128.method2364(var4);
                        if(var105.rotationX != var74 || var105.rotationZ != var21 || var105.field2244 != var24) {
                           var105.rotationX = var74;
                           var105.rotationZ = var21;
                           var105.field2244 = var24;
                           class124.method2350(var105);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 51) {
                        class215.field3157 = Client.secretPacketBuffer2.method2409();
                        class39.field802 = Client.secretPacketBuffer2.method2410();
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 59) {
                        var21 = Client.secretPacketBuffer2.method2577();
                        var4 = Client.secretPacketBuffer2.readUnsignedShort();
                        var75 = class128.method2364(var21);
                        if(var75 != null && var75.type == 0) {
                           if(var4 > var75.scrollHeight - var75.height) {
                              var4 = var75.scrollHeight - var75.height;
                           }

                           if(var4 < 0) {
                              var4 = 0;
                           }

                           if(var4 != var75.scrollY) {
                              var75.scrollY = var4;
                              class124.method2350(var75);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 127) {
                        class45.field891 = 0;

                        for(var21 = 0; var21 < 2048; ++var21) {
                           class45.field890[var21] = null;
                           class45.field889[var21] = 1;
                        }

                        for(var21 = 0; var21 < 2048; ++var21) {
                           Client.cachedPlayers[var21] = null;
                        }

                        class5.method76(Client.secretPacketBuffer2);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 140) {
                        var21 = Client.secretPacketBuffer2.readInt();
                        var4 = Client.secretPacketBuffer2.readUnsignedShort();
                        if(var21 < -70000) {
                           var4 += '耀';
                        }

                        if(var21 >= 0) {
                           var75 = class128.method2364(var21);
                        } else {
                           var75 = null;
                        }

                        if(var75 != null) {
                           for(var74 = 0; var74 < var75.itemIds.length; ++var74) {
                              var75.itemIds[var74] = 0;
                              var75.itemQuantities[var74] = 0;
                           }
                        }

                        class13.method178(var4);
                        var74 = Client.secretPacketBuffer2.readUnsignedShort();

                        for(var7 = 0; var7 < var74; ++var7) {
                           var8 = Client.secretPacketBuffer2.readUnsignedShort();
                           var9 = Client.secretPacketBuffer2.method2410();
                           if(var9 == 255) {
                              var9 = Client.secretPacketBuffer2.readInt();
                           }

                           if(var75 != null && var7 < var75.itemIds.length) {
                              var75.itemIds[var7] = var8;
                              var75.itemQuantities[var7] = var9;
                           }

                           FrameMap.method1717(var4, var7, var8 - 1, var9);
                        }

                        if(var75 != null) {
                           class124.method2350(var75);
                        }

                        class130.method2606();
                        Client.interfaceItemTriggers[++Client.field474 - 1 & 31] = var4 & 32767;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 4) {
                        var21 = Client.secretPacketBuffer2.method2418();
                        var4 = Client.secretPacketBuffer2.method2485();
                        var75 = class128.method2364(var4);
                        if(var75.modelType != 2 || var75.modelId != var21) {
                           var75.modelType = 2;
                           var75.modelId = var21;
                           class124.method2350(var75);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 47) {
                        var21 = Client.secretPacketBuffer2.method2577();
                        var95 = class128.method2364(var21);

                        for(var24 = 0; var24 < var95.itemIds.length; ++var24) {
                           var95.itemIds[var24] = -1;
                           var95.itemIds[var24] = 0;
                        }

                        class124.method2350(var95);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 108) {
                        Client.flagX = Client.secretPacketBuffer2.readUnsignedByte();
                        if(Client.flagX == 255) {
                           Client.flagX = 0;
                        }

                        Client.flagY = Client.secretPacketBuffer2.readUnsignedByte();
                        if(Client.flagY == 255) {
                           Client.flagY = 0;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 167) {
                        Client.field495 = Client.secretPacketBuffer2.method2418() * 30;
                        Client.field482 = Client.field311;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 22) {
                        var21 = Client.secretPacketBuffer2.method2577();
                        var4 = Client.secretPacketBuffer2.method2420();
                        var24 = Client.secretPacketBuffer2.method2409();
                        var118 = (WidgetNode)Client.componentTable.method2773((long)var21);
                        if(var118 != null) {
                           FrameMap.method1718(var118, var118.id != var4);
                        }

                        WidgetNode var103 = new WidgetNode();
                        var103.id = var4;
                        var103.field179 = var24;
                        Client.componentTable.method2774(var103, (long)var21);
                        class99.method1946(var4);
                        Widget var108 = class128.method2364(var21);
                        class124.method2350(var108);
                        if(Client.field449 != null) {
                           class124.method2350(Client.field449);
                           Client.field449 = null;
                        }

                        class16.method190();
                        class164.method3116(class133.widgets[var21 >> 16], var108, false);
                        TextureProvider.method1473(var4);
                        if(Client.widgetRoot != -1) {
                           var9 = Client.widgetRoot;
                           if(class112.method2112(var9)) {
                              FileOnDisk.method1445(class133.widgets[var9], 1);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 226) {
                        var121 = Client.secretPacketBuffer2.readUnsignedByte() == 1;
                        if(var121) {
                           Projectile.field872 = class72.method1421() - Client.secretPacketBuffer2.readLong();
                           IndexData.field2745 = new class1(Client.secretPacketBuffer2, true);
                        } else {
                           IndexData.field2745 = null;
                        }

                        Client.field481 = Client.field311;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 157) {
                        Client.field298 = Client.secretPacketBuffer2.readUnsignedByte();
                        if(Client.field298 == 1) {
                           Client.field299 = Client.secretPacketBuffer2.readUnsignedShort();
                        }

                        if(Client.field298 >= 2 && Client.field298 <= 6) {
                           if(Client.field298 == 2) {
                              Client.field304 = 64;
                              Client.field305 = 64;
                           }

                           if(Client.field298 == 3) {
                              Client.field304 = 0;
                              Client.field305 = 64;
                           }

                           if(Client.field298 == 4) {
                              Client.field304 = 128;
                              Client.field305 = 64;
                           }

                           if(Client.field298 == 5) {
                              Client.field304 = 64;
                              Client.field305 = 0;
                           }

                           if(Client.field298 == 6) {
                              Client.field304 = 64;
                              Client.field305 = 128;
                           }

                           Client.field298 = 2;
                           Client.field301 = Client.secretPacketBuffer2.readUnsignedShort();
                           Client.field302 = Client.secretPacketBuffer2.readUnsignedShort();
                           Client.field303 = Client.secretPacketBuffer2.readUnsignedByte();
                        }

                        if(Client.field298 == 10) {
                           Client.field300 = Client.secretPacketBuffer2.readUnsignedShort();
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 245) {
                        var21 = Client.secretPacketBuffer2.readInt();
                        var4 = Client.secretPacketBuffer2.readUnsignedShort();
                        if(var21 < -70000) {
                           var4 += '耀';
                        }

                        if(var21 >= 0) {
                           var75 = class128.method2364(var21);
                        } else {
                           var75 = null;
                        }

                        for(; Client.secretPacketBuffer2.offset < Client.packetLength; FrameMap.method1717(var4, var74, var7 - 1, var8)) {
                           var74 = Client.secretPacketBuffer2.method2395();
                           var7 = Client.secretPacketBuffer2.readUnsignedShort();
                           var8 = 0;
                           if(var7 != 0) {
                              var8 = Client.secretPacketBuffer2.readUnsignedByte();
                              if(var8 == 255) {
                                 var8 = Client.secretPacketBuffer2.readInt();
                              }
                           }

                           if(var75 != null && var74 >= 0 && var74 < var75.itemIds.length) {
                              var75.itemIds[var74] = var7;
                              var75.itemQuantities[var74] = var8;
                           }
                        }

                        if(var75 != null) {
                           class124.method2350(var75);
                        }

                        class130.method2606();
                        Client.interfaceItemTriggers[++Client.field474 - 1 & 31] = var4 & 32767;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     String var114;
                     if(Client.packetOpcode == 184) {
                        var3 = Client.secretPacketBuffer2.readString();
                        PacketBuffer var78 = Client.secretPacketBuffer2;

                        try {
                           var7 = var78.method2395();
                           if(var7 > 32767) {
                              var7 = 32767;
                           }

                           byte[] var106 = new byte[var7];
                           var78.offset += class209.field3127.method2310(var78.payload, var78.offset, var106, 0, var7);
                           String var109 = class109.method2067(var106, 0, var7);
                           var114 = var109;
                        } catch (Exception var62) {
                           var114 = "Cabbage";
                        }

                        var114 = FontTypeFace.method3913(class37.method764(var114));
                        WidgetNode.sendGameMessage(6, var3, var114);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     Widget var28;
                     if(Client.packetOpcode == 175) {
                        var21 = Client.secretPacketBuffer2.method2419();
                        var4 = Client.secretPacketBuffer2.method2420();
                        var24 = Client.secretPacketBuffer2.method2577();
                        var28 = class128.method2364(var24);
                        var28.field2260 = var21 + (var4 << 16);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 183) {
                        for(var21 = 0; var21 < Client.cachedPlayers.length; ++var21) {
                           if(Client.cachedPlayers[var21] != null) {
                              Client.cachedPlayers[var21].animation = -1;
                           }
                        }

                        for(var21 = 0; var21 < Client.cachedNPCs.length; ++var21) {
                           if(Client.cachedNPCs[var21] != null) {
                              Client.cachedNPCs[var21].animation = -1;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 11) {
                        class130.method2606();
                        var21 = Client.secretPacketBuffer2.method2487();
                        var4 = Client.secretPacketBuffer2.method2558();
                        var24 = Client.secretPacketBuffer2.readUnsignedByte();
                        Client.skillExperiences[var24] = var21;
                        Client.boostedSkillLevels[var24] = var4;
                        Client.realSkillLevels[var24] = 1;

                        for(var74 = 0; var74 < 98; ++var74) {
                           if(var21 >= class174.field2355[var74]) {
                              Client.realSkillLevels[var24] = var74 + 2;
                           }
                        }

                        Client.field475[++Client.field364 - 1 & 31] = var24;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 121) {
                        byte var120 = Client.secretPacketBuffer2.method2501();
                        var4 = Client.secretPacketBuffer2.method2420();
                        class167.settings[var4] = var120;
                        if(var120 != class167.widgetSettings[var4]) {
                           class167.widgetSettings[var4] = var120;
                        }

                        class167.method3139(var4);
                        Client.field471[++Client.field443 - 1 & 31] = var4;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 15) {
                        var21 = Client.secretPacketBuffer2.method2485();
                        var4 = Client.secretPacketBuffer2.method2374();
                        var75 = class128.method2364(var21);
                        if(var4 != var75.field2254 || var4 == -1) {
                           var75.field2254 = var4;
                           var75.field2329 = 0;
                           var75.field2214 = 0;
                           class124.method2350(var75);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 177) {
                        Client.field554 = 1;
                        Client.field478 = Client.field311;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 191) {
                        class215.field3157 = Client.secretPacketBuffer2.method2409();
                        class39.field802 = Client.secretPacketBuffer2.method2409();

                        while(Client.secretPacketBuffer2.offset < Client.packetLength) {
                           Client.packetOpcode = Client.secretPacketBuffer2.readUnsignedByte();
                           class174.method3260();
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 199) {
                        var21 = Client.secretPacketBuffer2.method2420();
                        if(var21 == '\uffff') {
                           var21 = -1;
                        }

                        var4 = Client.secretPacketBuffer2.method2577();
                        var24 = Client.secretPacketBuffer2.readInt();
                        var28 = class128.method2364(var24);
                        ItemComposition var101;
                        if(!var28.hasScript) {
                           if(var21 == -1) {
                              var28.modelType = 0;
                              Client.packetOpcode = -1;
                              var1 = true;
                              break label3199;
                           }

                           var101 = class47.getItemDefinition(var21);
                           var28.modelType = 4;
                           var28.modelId = var21;
                           var28.rotationX = var101.xan2d;
                           var28.rotationZ = var101.yan2d;
                           var28.field2244 = var101.zoom2d * 100 / var4;
                           class124.method2350(var28);
                        } else {
                           var28.item = var21;
                           var28.stackSize = var4;
                           var101 = class47.getItemDefinition(var21);
                           var28.rotationX = var101.xan2d;
                           var28.rotationZ = var101.yan2d;
                           var28.rotationY = var101.zan2d;
                           var28.field2256 = var101.offsetX2d;
                           var28.field2257 = var101.offsetY2d;
                           var28.field2244 = var101.zoom2d;
                           if(var101.isStackable == 1) {
                              var28.field2265 = 1;
                           } else {
                              var28.field2265 = 2;
                           }

                           if(var28.field2298 > 0) {
                              var28.field2244 = var28.field2244 * 32 / var28.field2298;
                           } else if(var28.originalWidth > 0) {
                              var28.field2244 = var28.field2244 * 32 / var28.originalWidth;
                           }

                           class124.method2350(var28);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 21) {
                        WidgetNode.method200(false);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 116) {
                        class9.xteaChanged(true);
                        Client.secretPacketBuffer2.readOpcode();
                        var21 = Client.secretPacketBuffer2.readUnsignedShort();
                        class38.method766(Client.secretPacketBuffer2, var21);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 112) {
                        Client.field534 = false;

                        for(var21 = 0; var21 < 5; ++var21) {
                           Client.field535[var21] = false;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     long var42;
                     if(Client.packetOpcode == 75) {
                        var3 = Client.secretPacketBuffer2.readString();
                        var40 = (long)Client.secretPacketBuffer2.readUnsignedShort();
                        var42 = (long)Client.secretPacketBuffer2.read24BitInt();
                        class179 var104 = (class179)class32.method708(ItemLayer.method1475(), Client.secretPacketBuffer2.readUnsignedByte());
                        long var44 = var42 + (var40 << 32);
                        boolean var11 = false;

                        for(var46 = 0; var46 < 100; ++var46) {
                           if(Client.field506[var46] == var44) {
                              var11 = true;
                              break;
                           }
                        }

                        if(class2.method27(var3)) {
                           var11 = true;
                        }

                        if(!var11 && Client.field402 == 0) {
                           Client.field506[Client.field348] = var44;
                           Client.field348 = (Client.field348 + 1) % 100;
                           PacketBuffer var47 = Client.secretPacketBuffer2;

                           String var14;
                           try {
                              var15 = var47.method2395();
                              if(var15 > 32767) {
                                 var15 = 32767;
                              }

                              byte[] var90 = new byte[var15];
                              var47.offset += class209.field3127.method2310(var47.payload, var47.offset, var90, 0, var15);
                              String var17 = class109.method2067(var90, 0, var15);
                              var14 = var17;
                           } catch (Exception var61) {
                              var14 = "Cabbage";
                           }

                           var14 = FontTypeFace.method3913(class37.method764(var14));
                           byte var89;
                           if(var104.field2669) {
                              var89 = 7;
                           } else {
                              var89 = 3;
                           }

                           if(var104.field2661 != -1) {
                              WidgetNode.sendGameMessage(var89, TextureProvider.method1472(var104.field2661) + var3, var14);
                           } else {
                              WidgetNode.sendGameMessage(var89, var3, var14);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 138) {
                        var21 = Client.secretPacketBuffer2.method2420();
                        if(var21 == '\uffff') {
                           var21 = -1;
                        }

                        if(var21 == -1 && !Client.field525) {
                           MessageNode.method218();
                        } else if(var21 != -1 && var21 != Client.field524 && Client.field501 != 0 && !Client.field525) {
                           IndexData var93 = class18.indexTrack1;
                           var24 = Client.field501;
                           class159.field2063 = 1;
                           class159.field2067 = var93;
                           PacketBuffer.field1989 = var21;
                           class190.field2791 = 0;
                           class159.field2069 = var24;
                           class15.field164 = false;
                           WallObject.field1543 = 2;
                        }

                        Client.field524 = var21;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 54) {
                        var21 = Client.secretPacketBuffer2.method2418();
                        if(var21 == '\uffff') {
                           var21 = -1;
                        }

                        var4 = Client.secretPacketBuffer2.method2597();
                        class183.method3291(var21, var4);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     boolean var77;
                     if(Client.packetOpcode == 239) {
                        var3 = Client.secretPacketBuffer2.readString();
                        var4 = Client.secretPacketBuffer2.readUnsignedShort();
                        byte var99 = Client.secretPacketBuffer2.readByte();
                        var6 = false;
                        if(var99 == -128) {
                           var6 = true;
                        }

                        if(var6) {
                           if(class85.clanChatCount == 0) {
                              Client.packetOpcode = -1;
                              var1 = true;
                              break label3199;
                           }

                           var77 = false;

                           for(var7 = 0; var7 < class85.clanChatCount && (!Client.clanMembers[var7].username.equals(var3) || var4 != Client.clanMembers[var7].world); ++var7) {
                              ;
                           }

                           if(var7 < class85.clanChatCount) {
                              while(var7 < class85.clanChatCount - 1) {
                                 Client.clanMembers[var7] = Client.clanMembers[var7 + 1];
                                 ++var7;
                              }

                              --class85.clanChatCount;
                              Client.clanMembers[class85.clanChatCount] = null;
                           }
                        } else {
                           Client.secretPacketBuffer2.readString();
                           XClanMember var100 = new XClanMember();
                           var100.username = var3;
                           var100.field276 = class108.method2059(var100.username, NPC.field757);
                           var100.world = var4;
                           var100.rank = var99;

                           for(var8 = class85.clanChatCount - 1; var8 >= 0; --var8) {
                              var9 = Client.clanMembers[var8].field276.compareTo(var100.field276);
                              if(var9 == 0) {
                                 Client.clanMembers[var8].world = var4;
                                 Client.clanMembers[var8].rank = var99;
                                 if(var3.equals(class22.localPlayer.name)) {
                                    Player.field242 = var99;
                                 }

                                 Client.field479 = Client.field311;
                                 Client.packetOpcode = -1;
                                 var1 = true;
                                 break label3199;
                              }

                              if(var9 < 0) {
                                 break;
                              }
                           }

                           if(class85.clanChatCount >= Client.clanMembers.length) {
                              Client.packetOpcode = -1;
                              var1 = true;
                              break label3199;
                           }

                           for(var9 = class85.clanChatCount - 1; var9 > var8; --var9) {
                              Client.clanMembers[var9 + 1] = Client.clanMembers[var9];
                           }

                           if(class85.clanChatCount == 0) {
                              Client.clanMembers = new XClanMember[100];
                           }

                           Client.clanMembers[var8 + 1] = var100;
                           ++class85.clanChatCount;
                           if(var3.equals(class22.localPlayer.name)) {
                              Player.field242 = var99;
                           }
                        }

                        Client.field479 = Client.field311;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 244) {
                        var21 = Client.secretPacketBuffer2.method2419();
                        var4 = Client.secretPacketBuffer2.method2577();
                        var24 = var21 >> 10 & 31;
                        var74 = var21 >> 5 & 31;
                        var7 = var21 & 31;
                        var8 = (var7 << 3) + (var74 << 11) + (var24 << 19);
                        Widget var27 = class128.method2364(var4);
                        if(var8 != var27.textColor) {
                           var27.textColor = var8;
                           class124.method2350(var27);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 139) {
                        class0.method12();
                        Client.packetOpcode = -1;
                        var1 = false;
                        break label3199;
                     }

                     if(Client.packetOpcode == 60) {
                        class173.method3256(Client.secretPacketBuffer2.readString());
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 0) {
                        var21 = Client.secretPacketBuffer2.readInt();
                        WidgetNode var92 = (WidgetNode)Client.componentTable.method2773((long)var21);
                        if(var92 != null) {
                           FrameMap.method1718(var92, true);
                        }

                        if(Client.field449 != null) {
                           class124.method2350(Client.field449);
                           Client.field449 = null;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 160) {
                        Client.field522 = Client.secretPacketBuffer2.readUnsignedByte();
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 73) {
                        var21 = Client.secretPacketBuffer2.readInt();
                        var91 = Client.secretPacketBuffer2.readString();
                        var75 = class128.method2364(var21);
                        if(!var91.equals(var75.text)) {
                           var75.text = var91;
                           class124.method2350(var75);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 196) {
                        class200.method3641(Client.secretPacketBuffer2, Client.packetLength);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 128) {
                        for(var21 = 0; var21 < class189.field2783; ++var21) {
                           class189 var22 = RSSocket.method2096(var21);
                           if(var22 != null) {
                              class167.settings[var21] = 0;
                              class167.widgetSettings[var21] = 0;
                           }
                        }

                        class130.method2606();
                        Client.field443 += 32;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 44) {
                        var21 = Client.secretPacketBuffer2.readUnsignedShort();
                        var4 = Client.secretPacketBuffer2.readUnsignedByte();
                        var24 = Client.secretPacketBuffer2.readUnsignedShort();
                        if(Client.field551 != 0 && var4 != 0 && Client.field528 < 50) {
                           Client.field529[Client.field528] = var21;
                           Client.field530[Client.field528] = var4;
                           Client.field442[Client.field528] = var24;
                           Client.field504[Client.field528] = null;
                           Client.field493[Client.field528] = 0;
                           ++Client.field528;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 187) {
                        var21 = Client.secretPacketBuffer2.method2418();
                        if(var21 == '\uffff') {
                           var21 = -1;
                        }

                        var4 = Client.secretPacketBuffer2.method2485();
                        var24 = Client.secretPacketBuffer2.method2487();
                        var74 = Client.secretPacketBuffer2.method2419();
                        if(var74 == '\uffff') {
                           var74 = -1;
                        }

                        for(var7 = var74; var7 <= var21; ++var7) {
                           var31 = (long)var7 + ((long)var4 << 32);
                           Node var122 = Client.widgetFlags.method2773(var31);
                           if(var122 != null) {
                              var122.unlink();
                           }

                           Client.widgetFlags.method2774(new class154(var24), var31);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 211) {
                        class130.method2606();
                        Client.weight = Client.secretPacketBuffer2.readShort();
                        Client.field482 = Client.field311;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 95) {
                        class130.method2606();
                        Client.energy = Client.secretPacketBuffer2.readUnsignedByte();
                        Client.field482 = Client.field311;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 198) {
                        var21 = Client.secretPacketBuffer2.method2419();
                        var4 = Client.secretPacketBuffer2.method2485();
                        class167.settings[var21] = var4;
                        if(var4 != class167.widgetSettings[var21]) {
                           class167.widgetSettings[var21] = var4;
                        }

                        class167.method3139(var21);
                        Client.field471[++Client.field443 - 1 & 31] = var21;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 110) {
                        var21 = Client.secretPacketBuffer2.readUnsignedShort();
                        ChatMessages.method890(var21);
                        Client.interfaceItemTriggers[++Client.field474 - 1 & 31] = var21 & 32767;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 65) {
                        class9.xteaChanged(false);
                        Client.secretPacketBuffer2.readOpcode();
                        var21 = Client.secretPacketBuffer2.readUnsignedShort();
                        class38.method766(Client.secretPacketBuffer2, var21);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 120) {
                        for(var21 = 0; var21 < class167.widgetSettings.length; ++var21) {
                           if(class167.widgetSettings[var21] != class167.settings[var21]) {
                              class167.widgetSettings[var21] = class167.settings[var21];
                              class167.method3139(var21);
                              Client.field471[++Client.field443 - 1 & 31] = var21;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 144) {
                        var21 = Client.secretPacketBuffer2.readUnsignedByte();
                        if(Client.secretPacketBuffer2.readUnsignedByte() == 0) {
                           Client.grandExchangeOffers[var21] = new XGrandExchangeOffer();
                           Client.secretPacketBuffer2.offset += 18;
                        } else {
                           --Client.secretPacketBuffer2.offset;
                           Client.grandExchangeOffers[var21] = new XGrandExchangeOffer(Client.secretPacketBuffer2, false);
                        }

                        Client.field480 = Client.field311;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 86 || Client.packetOpcode == 87 || Client.packetOpcode == 232 || Client.packetOpcode == 158 || Client.packetOpcode == 102 || Client.packetOpcode == 97 || Client.packetOpcode == 193 || Client.packetOpcode == 85 || Client.packetOpcode == 151 || Client.packetOpcode == 119) {
                        class174.method3260();
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 31) {
                        var3 = Client.secretPacketBuffer2.readString();
                        var40 = Client.secretPacketBuffer2.readLong();
                        var42 = (long)Client.secretPacketBuffer2.readUnsignedShort();
                        var31 = (long)Client.secretPacketBuffer2.read24BitInt();
                        class179 var37 = (class179)class32.method708(ItemLayer.method1475(), Client.secretPacketBuffer2.readUnsignedByte());
                        var38 = var31 + (var42 << 32);
                        var13 = false;

                        for(var49 = 0; var49 < 100; ++var49) {
                           if(Client.field506[var49] == var38) {
                              var13 = true;
                              break;
                           }
                        }

                        if(var37.field2670 && class2.method27(var3)) {
                           var13 = true;
                        }

                        if(!var13 && Client.field402 == 0) {
                           Client.field506[Client.field348] = var38;
                           Client.field348 = (Client.field348 + 1) % 100;
                           PacketBuffer var48 = Client.secretPacketBuffer2;

                           String var16;
                           try {
                              int var50 = var48.method2395();
                              if(var50 > 32767) {
                                 var50 = 32767;
                              }

                              byte[] var18 = new byte[var50];
                              var48.offset += class209.field3127.method2310(var48.payload, var48.offset, var18, 0, var50);
                              String var19 = class109.method2067(var18, 0, var50);
                              var16 = var19;
                           } catch (Exception var60) {
                              var16 = "Cabbage";
                           }

                           var16 = FontTypeFace.method3913(class37.method764(var16));
                           if(var37.field2661 != -1) {
                              XItemContainer.addChatMessage(9, TextureProvider.method1472(var37.field2661) + var3, var16, XItemContainer.method175(var40));
                           } else {
                              XItemContainer.addChatMessage(9, var3, var16, XItemContainer.method175(var40));
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 159) {
                        var21 = Client.secretPacketBuffer2.method2395();
                        var71 = Client.secretPacketBuffer2.readUnsignedByte() == 1;
                        var5 = "";
                        var6 = false;
                        if(var71) {
                           var5 = Client.secretPacketBuffer2.readString();
                           if(class2.method27(var5)) {
                              var6 = true;
                           }
                        }

                        String var97 = Client.secretPacketBuffer2.readString();
                        if(!var6) {
                           WidgetNode.sendGameMessage(var21, var5, var97);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 124) {
                        class215.field3157 = Client.secretPacketBuffer2.method2410();
                        class39.field802 = Client.secretPacketBuffer2.method2410();

                        for(var21 = class215.field3157; var21 < class215.field3157 + 8; ++var21) {
                           for(var4 = class39.field802; var4 < class39.field802 + 8; ++var4) {
                              if(Client.groundItemDeque[Client.plane][var21][var4] != null) {
                                 Client.groundItemDeque[Client.plane][var21][var4] = null;
                                 class40.groundItemSpawned(var21, var4);
                              }
                           }
                        }

                        for(class25 var70 = (class25)Client.field415.method2828(); var70 != null; var70 = (class25)Client.field415.method2830()) {
                           if(var70.field573 >= class215.field3157 && var70.field573 < class215.field3157 + 8 && var70.field574 >= class39.field802 && var70.field574 < class39.field802 + 8 && Client.plane == var70.field579) {
                              var70.field582 = 0;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 99) {
                        var21 = Client.secretPacketBuffer2.readInt();
                        var71 = Client.secretPacketBuffer2.method2558() == 1;
                        var75 = class128.method2364(var21);
                        if(var75.isHidden != var71) {
                           var75.isHidden = var71;
                           class124.method2350(var75);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 34) {
                        var21 = Client.secretPacketBuffer2.method2410();
                        var4 = Client.secretPacketBuffer2.readUnsignedByte();
                        var5 = Client.secretPacketBuffer2.readString();
                        if(var4 >= 1 && var4 <= 8) {
                           if(var5.equalsIgnoreCase("null")) {
                              var5 = null;
                           }

                           Client.playerOptions[var4 - 1] = var5;
                           Client.playerOptionsPriorities[var4 - 1] = var21 == 0;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 71) {
                        while(Client.secretPacketBuffer2.offset < Client.packetLength) {
                           var21 = Client.secretPacketBuffer2.readUnsignedByte();
                           var71 = (var21 & 1) == 1;
                           var5 = Client.secretPacketBuffer2.readString();
                           var114 = Client.secretPacketBuffer2.readString();
                           Client.secretPacketBuffer2.readString();

                           for(var7 = 0; var7 < Client.ignoreCount; ++var7) {
                              Ignore var102 = Client.ignores[var7];
                              if(var71) {
                                 if(var114.equals(var102.name)) {
                                    var102.name = var5;
                                    var102.previousName = var114;
                                    var5 = null;
                                    break;
                                 }
                              } else if(var5.equals(var102.name)) {
                                 var102.name = var5;
                                 var102.previousName = var114;
                                 var5 = null;
                                 break;
                              }
                           }

                           if(var5 != null && Client.ignoreCount < 400) {
                              Ignore var25 = new Ignore();
                              Client.ignores[Client.ignoreCount] = var25;
                              var25.name = var5;
                              var25.previousName = var114;
                              ++Client.ignoreCount;
                           }
                        }

                        Client.field478 = Client.field311;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 48) {
                        Client.field479 = Client.field311;
                        if(Client.packetLength == 0) {
                           Client.field485 = null;
                           Client.clanChatOwner = null;
                           class85.clanChatCount = 0;
                           Client.clanMembers = null;
                           Client.packetOpcode = -1;
                           var1 = true;
                        } else {
                           Client.clanChatOwner = Client.secretPacketBuffer2.readString();
                           long var51 = Client.secretPacketBuffer2.readLong();
                           Client.field485 = XItemContainer.method174(var51);
                           Client.field332 = Client.secretPacketBuffer2.readByte();
                           var24 = Client.secretPacketBuffer2.readUnsignedByte();
                           if(var24 == 255) {
                              Client.packetOpcode = -1;
                              var1 = true;
                           } else {
                              class85.clanChatCount = var24;
                              XClanMember[] var113 = new XClanMember[100];

                              for(var7 = 0; var7 < class85.clanChatCount; ++var7) {
                                 var113[var7] = new XClanMember();
                                 var113[var7].username = Client.secretPacketBuffer2.readString();
                                 var113[var7].field276 = class108.method2059(var113[var7].username, NPC.field757);
                                 var113[var7].world = Client.secretPacketBuffer2.readUnsignedShort();
                                 var113[var7].rank = Client.secretPacketBuffer2.readByte();
                                 Client.secretPacketBuffer2.readString();
                                 if(var113[var7].username.equals(class22.localPlayer.name)) {
                                    Player.field242 = var113[var7].rank;
                                 }
                              }

                              var77 = false;
                              var9 = class85.clanChatCount;

                              while(var9 > 0) {
                                 var77 = true;
                                 --var9;

                                 for(var10 = 0; var10 < var9; ++var10) {
                                    if(var113[var10].field276.compareTo(var113[var10 + 1].field276) > 0) {
                                       XClanMember var26 = var113[var10];
                                       var113[var10] = var113[var10 + 1];
                                       var113[var10 + 1] = var26;
                                       var77 = false;
                                    }
                                 }

                                 if(var77) {
                                    break;
                                 }
                              }

                              Client.clanMembers = var113;
                              Client.packetOpcode = -1;
                              var1 = true;
                           }
                        }
                        break label3199;
                     }

                     if(Client.packetOpcode == 17) {
                        Client.secretPacketBuffer2.offset += 28;
                        if(Client.secretPacketBuffer2.method2527()) {
                           PacketBuffer var69 = Client.secretPacketBuffer2;
                           var4 = Client.secretPacketBuffer2.offset - 28;
                           class7.method98(var69.payload, var4);
                           class107.method2056(var69, var4);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 98) {
                        var21 = Client.secretPacketBuffer2.method2577();
                        var4 = Client.secretPacketBuffer2.method2374();
                        var24 = Client.secretPacketBuffer2.method2421();
                        var28 = class128.method2364(var21);
                        if(var24 != var28.originalX || var28.originalY != var4 || var28.field2212 != 0 || var28.field2206 != 0) {
                           var28.originalX = var24;
                           var28.originalY = var4;
                           var28.field2212 = 0;
                           var28.field2206 = 0;
                           class124.method2350(var28);
                           FileOnDisk.method1441(var28);
                           if(var28.type == 0) {
                              class164.method3116(class133.widgets[var21 >> 16], var28, false);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     if(Client.packetOpcode == 66) {
                        WidgetNode.method200(true);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3199;
                     }

                     class173.method3259("" + Client.packetOpcode + "," + Client.field417 + "," + Client.field466 + "," + Client.packetLength, (Throwable)null);
                     class0.method12();
                  } catch (IOException var66) {
                     class0.method11();
                  } catch (Exception var67) {
                     var3 = "" + Client.packetOpcode + "," + Client.field417 + "," + Client.field466 + "," + Client.packetLength + "," + (class22.localPlayer.pathX[0] + class108.baseX) + "," + (GameEngine.baseY + class22.localPlayer.pathY[0]) + ",";

                     for(var4 = 0; var4 < Client.packetLength && var4 < 50; ++var4) {
                        var3 = var3 + Client.secretPacketBuffer2.payload[var4] + ",";
                     }

                     class173.method3259(var3, var67);
                     class0.method12();
                  }

                  var1 = true;
               }
            }

            if(!var1) {
               break;
            }
         }

         if(Client.gameState == 30) {
            while(true) {
               ClassInfo var54 = (ClassInfo)class231.field3265.method2790();
               boolean var68;
               if(var54 == null) {
                  var68 = false;
               } else {
                  var68 = true;
               }

               int var117;
               if(!var68) {
                  Object var55 = class180.field2678.field215;
                  synchronized(class180.field2678.field215) {
                     if(!Client.field280) {
                        class180.field2678.field217 = 0;
                     } else if(class115.field1811 != 0 || class180.field2678.field217 >= 40) {
                        Client.secretPacketBuffer1.putOpcode(249);
                        Client.secretPacketBuffer1.putByte(0);
                        var117 = Client.secretPacketBuffer1.offset;
                        var2 = 0;

                        for(var21 = 0; var21 < class180.field2678.field217 && Client.secretPacketBuffer1.offset - var117 < 240; ++var21) {
                           ++var2;
                           var4 = class180.field2678.field218[var21];
                           if(var4 < 0) {
                              var4 = 0;
                           } else if(var4 > 502) {
                              var4 = 502;
                           }

                           var24 = class180.field2678.field214[var21];
                           if(var24 < 0) {
                              var24 = 0;
                           } else if(var24 > 764) {
                              var24 = 764;
                           }

                           var74 = var24 + var4 * 765;
                           if(class180.field2678.field218[var21] == -1 && class180.field2678.field214[var21] == -1) {
                              var24 = -1;
                              var4 = -1;
                              var74 = 524287;
                           }

                           if(Client.field498 == var24 && var4 == Client.field519) {
                              if(Client.field555 < 2047) {
                                 ++Client.field555;
                              }
                           } else {
                              var7 = var24 - Client.field498;
                              Client.field498 = var24;
                              var8 = var4 - Client.field519;
                              Client.field519 = var4;
                              if(Client.field555 < 8 && var7 >= -32 && var7 <= 31 && var8 >= -32 && var8 <= 31) {
                                 var7 += 32;
                                 var8 += 32;
                                 Client.secretPacketBuffer1.putShort(var8 + (var7 << 6) + (Client.field555 << 12));
                                 Client.field555 = 0;
                              } else if(Client.field555 < 8) {
                                 Client.secretPacketBuffer1.put24bitInt(var74 + (Client.field555 << 19) + 8388608);
                                 Client.field555 = 0;
                              } else {
                                 Client.secretPacketBuffer1.putInt(var74 + (Client.field555 << 19) + -1073741824);
                                 Client.field555 = 0;
                              }
                           }
                        }

                        Client.secretPacketBuffer1.method2380(Client.secretPacketBuffer1.offset - var117);
                        if(var2 >= class180.field2678.field217) {
                           class180.field2678.field217 = 0;
                        } else {
                           class180.field2678.field217 -= var2;

                           for(var21 = 0; var21 < class180.field2678.field217; ++var21) {
                              class180.field2678.field214[var21] = class180.field2678.field214[var2 + var21];
                              class180.field2678.field218[var21] = class180.field2678.field218[var21 + var2];
                           }
                        }
                     }
                  }

                  if(class115.field1811 == 1 || !CombatInfo1.field662 && class115.field1811 == 4 || class115.field1811 == 2) {
                     long var56 = (class115.field1814 - Client.field405) / 50L;
                     if(var56 > 4095L) {
                        var56 = 4095L;
                     }

                     Client.field405 = class115.field1814;
                     var2 = class115.field1813;
                     if(var2 < 0) {
                        var2 = 0;
                     } else if(var2 > IndexDataBase.field2726) {
                        var2 = IndexDataBase.field2726;
                     }

                     var21 = class115.field1802;
                     if(var21 < 0) {
                        var21 = 0;
                     } else if(var21 > class187.field2760) {
                        var21 = class187.field2760;
                     }

                     var4 = (int)var56;
                     Client.secretPacketBuffer1.putOpcode(170);
                     Client.secretPacketBuffer1.putShort((var4 << 1) + (class115.field1811 == 2?1:0));
                     Client.secretPacketBuffer1.putShort(var21);
                     Client.secretPacketBuffer1.putShort(var2);
                  }

                  if(class105.field1707 > 0) {
                     Client.secretPacketBuffer1.putOpcode(55);
                     Client.secretPacketBuffer1.putShort(0);
                     var0 = Client.secretPacketBuffer1.offset;
                     long var58 = class72.method1421();

                     for(var21 = 0; var21 < class105.field1707; ++var21) {
                        var40 = var58 - Client.field511;
                        if(var40 > 16777215L) {
                           var40 = 16777215L;
                        }

                        Client.field511 = var58;
                        Client.secretPacketBuffer1.method2499(class105.field1700[var21]);
                        Client.secretPacketBuffer1.method2451((int)var40);
                     }

                     Client.secretPacketBuffer1.method2379(Client.secretPacketBuffer1.offset - var0);
                  }

                  if(Client.field383 > 0) {
                     --Client.field383;
                  }

                  if(class105.field1695[96] || class105.field1695[97] || class105.field1695[98] || class105.field1695[99]) {
                     Client.field374 = true;
                  }

                  if(Client.field374 && Client.field383 <= 0) {
                     Client.field383 = 20;
                     Client.field374 = false;
                     Client.secretPacketBuffer1.putOpcode(237);
                     Client.secretPacketBuffer1.putShort(Client.mapAngle);
                     Client.secretPacketBuffer1.method2375(Client.field366);
                  }

                  if(KitDefinition.field2831 && !Client.field295) {
                     Client.field295 = true;
                     Client.secretPacketBuffer1.putOpcode(189);
                     Client.secretPacketBuffer1.putByte(1);
                  }

                  if(!KitDefinition.field2831 && Client.field295) {
                     Client.field295 = false;
                     Client.secretPacketBuffer1.putOpcode(189);
                     Client.secretPacketBuffer1.putByte(0);
                  }

                  int[] var126;
                  if(Client.plane != Client.field515) {
                     Client.field515 = Client.plane;
                     var0 = Client.plane;
                     var126 = ISAACCipher.field2000.image;
                     var2 = var126.length;

                     for(var21 = 0; var21 < var2; ++var21) {
                        var126[var21] = 0;
                     }

                     for(var21 = 1; var21 < 103; ++var21) {
                        var4 = (103 - var21) * 2048 + 24628;

                        for(var24 = 1; var24 < 103; ++var24) {
                           if((class10.tileSettings[var0][var24][var21] & 24) == 0) {
                              class172.region.method1731(var126, var4, 512, var0, var24, var21);
                           }

                           if(var0 < 3 && (class10.tileSettings[var0 + 1][var24][var21] & 8) != 0) {
                              class172.region.method1731(var126, var4, 512, var0 + 1, var24, var21);
                           }

                           var4 += 4;
                        }
                     }

                     var21 = ((int)(Math.random() * 20.0D) + 238 - 10 << 16) + ((int)(Math.random() * 20.0D) + 238 - 10 << 8) + ((int)(Math.random() * 20.0D) + 238 - 10);
                     var4 = (int)(Math.random() * 20.0D) + 238 - 10 << 16;
                     ISAACCipher.field2000.method4220();

                     for(var24 = 1; var24 < 103; ++var24) {
                        for(var74 = 1; var74 < 103; ++var74) {
                           if((class10.tileSettings[var0][var74][var24] & 24) == 0) {
                              class175.method3263(var0, var74, var24, var21, var4);
                           }

                           if(var0 < 3 && (class10.tileSettings[var0 + 1][var74][var24] & 8) != 0) {
                              class175.method3263(var0 + 1, var74, var24, var21, var4);
                           }
                        }
                     }

                     Client.field516 = 0;

                     for(var24 = 0; var24 < 104; ++var24) {
                        for(var74 = 0; var74 < 104; ++var74) {
                           var7 = class172.region.method1750(Client.plane, var24, var74);
                           if(var7 != 0) {
                              var7 = var7 >> 14 & 32767;
                              var8 = class26.getObjectDefinition(var7).mapIconId;
                              if(var8 >= 0) {
                                 var9 = var24;
                                 var10 = var74;
                                 if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                                    int[][] var123 = Client.collisionMaps[Client.plane].flags;

                                    for(var49 = 0; var49 < 10; ++var49) {
                                       var15 = (int)(Math.random() * 4.0D);
                                       if(var15 == 0 && var9 > 0 && var9 > var24 - 3 && (var123[var9 - 1][var10] & 19136776) == 0) {
                                          --var9;
                                       }

                                       if(var15 == 1 && var9 < 103 && var9 < var24 + 3 && (var123[var9 + 1][var10] & 19136896) == 0) {
                                          ++var9;
                                       }

                                       if(var15 == 2 && var10 > 0 && var10 > var74 - 3 && (var123[var9][var10 - 1] & 19136770) == 0) {
                                          --var10;
                                       }

                                       if(var15 == 3 && var10 < 103 && var10 < var74 + 3 && (var123[var9][var10 + 1] & 19136800) == 0) {
                                          ++var10;
                                       }
                                    }
                                 }

                                 Client.field570[Client.field516] = class107.field1719[var8];
                                 Client.field505[Client.field516] = var9;
                                 Client.field518[Client.field516] = var10;
                                 ++Client.field516;
                              }
                           }
                        }
                     }

                     class88.bufferProvider.method4147();
                  }

                  if(Client.gameState != 30) {
                     return;
                  }

                  class6.method78();
                  class174.method3262();
                  ++Client.field330;
                  if(Client.field330 > 750) {
                     if(Client.field489 > 0) {
                        class0.method12();
                     } else {
                        class9.setGameState(40);
                        class132.field1979 = Friend.rssocket;
                        Friend.rssocket = null;
                     }

                     return;
                  }

                  var0 = class45.field891;
                  var126 = class45.field894;

                  for(var2 = 0; var2 < var0; ++var2) {
                     Player var73 = Client.cachedPlayers[var126[var2]];
                     if(var73 != null) {
                        WidgetNode.method198(var73, 1);
                     }
                  }

                  class47.method901();
                  class115.method2231();
                  ++Client.field358;
                  if(Client.field393 != 0) {
                     Client.field333 += 20;
                     if(Client.field333 >= 400) {
                        Client.field393 = 0;
                     }
                  }

                  if(class32.field732 != null) {
                     ++Client.field394;
                     if(Client.field394 >= 15) {
                        class124.method2350(class32.field732);
                        class32.field732 = null;
                     }
                  }

                  Widget var128 = ChatMessages.field920;
                  Widget var127 = class13.field142;
                  ChatMessages.field920 = null;
                  class13.field142 = null;
                  Client.field462 = null;
                  Client.field376 = false;
                  Client.field463 = false;
                  Client.field508 = 0;

                  while(ChatLineBuffer.method925() && Client.field508 < 128) {
                     if(Client.field517 >= 2 && class105.field1695[82] && class177.field2652 == 66) {
                        var3 = "";

                        MessageNode var86;
                        for(Iterator var98 = class47.field924.iterator(); var98.hasNext(); var3 = var3 + var86.name + ':' + var86.value + '\n') {
                           var86 = (MessageNode)var98.next();
                        }

                        class3.field28.setContents(new StringSelection(var3), (ClipboardOwner)null);
                     } else {
                        Client.field510[Client.field508] = class177.field2652;
                        Client.field444[Client.field508] = class25.field571;
                        ++Client.field508;
                     }
                  }

                  if(Client.widgetRoot != -1) {
                     class7.method101(Client.widgetRoot, 0, 0, class187.field2760, IndexDataBase.field2726, 0, 0);
                  }

                  ++Client.field311;

                  while(true) {
                     class18 var53;
                     Widget var76;
                     do {
                        var53 = (class18)Client.field476.method2826();
                        if(var53 == null) {
                           while(true) {
                              do {
                                 var53 = (class18)Client.field486.method2826();
                                 if(var53 == null) {
                                    while(true) {
                                       do {
                                          var53 = (class18)Client.field484.method2826();
                                          if(var53 == null) {
                                             MessageNode.method219();
                                             if(Client.field458 != null) {
                                                class124.method2350(Client.field458);
                                                ++class99.field1638;
                                                if(Client.field376 && Client.field463) {
                                                   var2 = class115.field1805;
                                                   var21 = class115.field1806;
                                                   var2 -= Client.field492;
                                                   var21 -= Client.field461;
                                                   if(var2 < Client.field380) {
                                                      var2 = Client.field380;
                                                   }

                                                   if(Client.field458.width + var2 > Client.field380 + Client.field496.width) {
                                                      var2 = Client.field496.width + Client.field380 - Client.field458.width;
                                                   }

                                                   if(var21 < Client.field465) {
                                                      var21 = Client.field465;
                                                   }

                                                   if(var21 + Client.field458.height > Client.field496.height + Client.field465) {
                                                      var21 = Client.field496.height + Client.field465 - Client.field458.height;
                                                   }

                                                   var4 = var2 - Client.field467;
                                                   var24 = var21 - Client.field397;
                                                   var74 = Client.field458.field2283;
                                                   if(class99.field1638 > Client.field458.field2284 && (var4 > var74 || var4 < -var74 || var24 > var74 || var24 < -var74)) {
                                                      Client.field469 = true;
                                                   }

                                                   var7 = var2 - Client.field380 + Client.field496.scrollX;
                                                   var8 = var21 - Client.field465 + Client.field496.scrollY;
                                                   class18 var116;
                                                   if(Client.field458.field2296 != null && Client.field469) {
                                                      var116 = new class18();
                                                      var116.field189 = Client.field458;
                                                      var116.field193 = var7;
                                                      var116.field187 = var8;
                                                      var116.field196 = Client.field458.field2296;
                                                      Script.method910(var116, 200000);
                                                   }

                                                   if(class115.field1799 == 0) {
                                                      if(Client.field469) {
                                                         if(Client.field458.field2297 != null) {
                                                            var116 = new class18();
                                                            var116.field189 = Client.field458;
                                                            var116.field193 = var7;
                                                            var116.field187 = var8;
                                                            var116.field195 = Client.field462;
                                                            var116.field196 = Client.field458.field2297;
                                                            Script.method910(var116, 200000);
                                                         }

                                                         if(Client.field462 != null && class105.method2027(Client.field458) != null) {
                                                            Client.secretPacketBuffer1.putOpcode(43);
                                                            Client.secretPacketBuffer1.method2375(Client.field462.index);
                                                            Client.secretPacketBuffer1.putShort(Client.field458.item);
                                                            Client.secretPacketBuffer1.method2416(Client.field462.item);
                                                            Client.secretPacketBuffer1.method2411(Client.field458.id);
                                                            Client.secretPacketBuffer1.method2411(Client.field462.id);
                                                            Client.secretPacketBuffer1.putShort(Client.field458.index);
                                                         }
                                                      } else {
                                                         label3383: {
                                                            var9 = class114.method2212();
                                                            if(Client.menuOptionCount > 2) {
                                                               label3358: {
                                                                  label3314: {
                                                                     if(Client.field421 == 1) {
                                                                        if(Client.menuOptionCount <= 0) {
                                                                           var79 = false;
                                                                        } else if(Client.field432 && class105.field1695[81] && Client.field431 != -1) {
                                                                           var79 = true;
                                                                        } else {
                                                                           var79 = false;
                                                                        }

                                                                        if(!var79) {
                                                                           break label3314;
                                                                        }
                                                                     }

                                                                     if(var9 < 0) {
                                                                        var79 = false;
                                                                     } else {
                                                                        var80 = Client.menuTypes[var9];
                                                                        if(var80 >= 2000) {
                                                                           var80 -= 2000;
                                                                        }

                                                                        if(var80 == 1007) {
                                                                           var79 = true;
                                                                        } else {
                                                                           var79 = false;
                                                                        }
                                                                     }

                                                                     if(!var79) {
                                                                        break label3358;
                                                                     }
                                                                  }

                                                                  Item.method824(Client.field467 + Client.field492, Client.field461 + Client.field397);
                                                                  break label3383;
                                                               }
                                                            }

                                                            if(Client.menuOptionCount > 0) {
                                                               class85.method1716(Client.field467 + Client.field492, Client.field397 + Client.field461);
                                                            }
                                                         }
                                                      }

                                                      Client.field458 = null;
                                                   }
                                                } else if(class99.field1638 > 1) {
                                                   Client.field458 = null;
                                                }
                                             }

                                             if(class97.field1627 != null) {
                                                class124.method2350(class97.field1627);
                                                ++Client.field404;
                                                if(class115.field1799 == 0) {
                                                   if(Client.field400) {
                                                      if(class97.field1627 == class9.field83 && Client.field488 != Client.field399) {
                                                         Widget var125 = class97.field1627;
                                                         byte var124 = 0;
                                                         if(Client.field448 == 1 && var125.contentType == 206) {
                                                            var124 = 1;
                                                         }

                                                         if(var125.itemIds[Client.field399] <= 0) {
                                                            var124 = 0;
                                                         }

                                                         var24 = class103.method1988(var125);
                                                         var71 = (var24 >> 29 & 1) != 0;
                                                         if(var71) {
                                                            var74 = Client.field488;
                                                            var7 = Client.field399;
                                                            var125.itemIds[var7] = var125.itemIds[var74];
                                                            var125.itemQuantities[var7] = var125.itemQuantities[var74];
                                                            var125.itemIds[var74] = -1;
                                                            var125.itemQuantities[var74] = 0;
                                                         } else if(var124 == 1) {
                                                            var74 = Client.field488;
                                                            var7 = Client.field399;

                                                            while(var74 != var7) {
                                                               if(var74 > var7) {
                                                                  var125.method3192(var74 - 1, var74);
                                                                  --var74;
                                                               } else if(var74 < var7) {
                                                                  var125.method3192(var74 + 1, var74);
                                                                  ++var74;
                                                               }
                                                            }
                                                         } else {
                                                            var125.method3192(Client.field399, Client.field488);
                                                         }

                                                         Client.secretPacketBuffer1.putOpcode(245);
                                                         Client.secretPacketBuffer1.method2499(var124);
                                                         Client.secretPacketBuffer1.method2375(Client.field488);
                                                         Client.secretPacketBuffer1.method2411(class97.field1627.id);
                                                         Client.secretPacketBuffer1.method2375(Client.field399);
                                                      }
                                                   } else {
                                                      label3362: {
                                                         label3386: {
                                                            var2 = class114.method2212();
                                                            if(Client.menuOptionCount > 2) {
                                                               if(Client.field421 == 1) {
                                                                  if(Client.menuOptionCount <= 0) {
                                                                     var121 = false;
                                                                  } else if(Client.field432 && class105.field1695[81] && Client.field431 != -1) {
                                                                     var121 = true;
                                                                  } else {
                                                                     var121 = false;
                                                                  }

                                                                  if(!var121) {
                                                                     break label3386;
                                                                  }
                                                               }

                                                               if(var2 < 0) {
                                                                  var121 = false;
                                                               } else {
                                                                  var4 = Client.menuTypes[var2];
                                                                  if(var4 >= 2000) {
                                                                     var4 -= 2000;
                                                                  }

                                                                  if(var4 == 1007) {
                                                                     var121 = true;
                                                                  } else {
                                                                     var121 = false;
                                                                  }
                                                               }

                                                               if(var121) {
                                                                  break label3386;
                                                               }
                                                            }

                                                            if(Client.menuOptionCount > 0) {
                                                               class85.method1716(Client.field540, Client.field398);
                                                            }
                                                            break label3362;
                                                         }

                                                         Item.method824(Client.field540, Client.field398);
                                                      }
                                                   }

                                                   Client.field394 = 10;
                                                   class115.field1811 = 0;
                                                   class97.field1627 = null;
                                                } else if(Client.field404 >= 5 && (class115.field1805 > Client.field540 + 5 || class115.field1805 < Client.field540 - 5 || class115.field1806 > Client.field398 + 5 || class115.field1806 < Client.field398 - 5)) {
                                                   Client.field400 = true;
                                                }
                                             }

                                             if(Region.method1788()) {
                                                var2 = Region.field1482;
                                                var21 = Region.field1498;
                                                Client.secretPacketBuffer1.putOpcode(149);
                                                Client.secretPacketBuffer1.putByte(5);
                                                Client.secretPacketBuffer1.method2499(class105.field1695[82]?(class105.field1695[81]?2:1):0);
                                                Client.secretPacketBuffer1.method2526(var2 + class108.baseX);
                                                Client.secretPacketBuffer1.method2416(GameEngine.baseY + var21);
                                                Region.method1761();
                                                Client.field550 = class115.field1802;
                                                Client.field391 = class115.field1813;
                                                Client.field393 = 1;
                                                Client.field333 = 0;
                                                Client.flagX = var2;
                                                Client.flagY = var21;
                                             }

                                             if(var128 != ChatMessages.field920) {
                                                if(var128 != null) {
                                                   class124.method2350(var128);
                                                }

                                                if(ChatMessages.field920 != null) {
                                                   class124.method2350(ChatMessages.field920);
                                                }
                                             }

                                             if(class13.field142 != var127 && Client.field437 == Client.field436) {
                                                if(var127 != null) {
                                                   class124.method2350(var127);
                                                }

                                                if(class13.field142 != null) {
                                                   class124.method2350(class13.field142);
                                                }
                                             }

                                             if(class13.field142 != null) {
                                                if(Client.field436 < Client.field437) {
                                                   ++Client.field436;
                                                   if(Client.field437 == Client.field436) {
                                                      class124.method2350(class13.field142);
                                                   }
                                                }
                                             } else if(Client.field436 > 0) {
                                                --Client.field436;
                                             }

                                             XItemContainer.method167();
                                             if(Client.field534) {
                                                var2 = class3.field36 * 128 + 64;
                                                var21 = GameObject.field1597 * 128 + 64;
                                                var4 = CombatInfo1.method600(var2, var21, Client.plane) - Frames.field1554;
                                                if(class22.cameraX < var2) {
                                                   class22.cameraX += class7.field60 + class130.field1969 * (var2 - class22.cameraX) / 1000;
                                                   if(class22.cameraX > var2) {
                                                      class22.cameraX = var2;
                                                   }
                                                }

                                                if(class22.cameraX > var2) {
                                                   class22.cameraX -= class7.field60 + class130.field1969 * (class22.cameraX - var2) / 1000;
                                                   if(class22.cameraX < var2) {
                                                      class22.cameraX = var2;
                                                   }
                                                }

                                                if(class1.cameraZ < var4) {
                                                   class1.cameraZ += class130.field1969 * (var4 - class1.cameraZ) / 1000 + class7.field60;
                                                   if(class1.cameraZ > var4) {
                                                      class1.cameraZ = var4;
                                                   }
                                                }

                                                if(class1.cameraZ > var4) {
                                                   class1.cameraZ -= class7.field60 + class130.field1969 * (class1.cameraZ - var4) / 1000;
                                                   if(class1.cameraZ < var4) {
                                                      class1.cameraZ = var4;
                                                   }
                                                }

                                                if(class13.cameraY < var21) {
                                                   class13.cameraY += (var21 - class13.cameraY) * class130.field1969 / 1000 + class7.field60;
                                                   if(class13.cameraY > var21) {
                                                      class13.cameraY = var21;
                                                   }
                                                }

                                                if(class13.cameraY > var21) {
                                                   class13.cameraY -= (class13.cameraY - var21) * class130.field1969 / 1000 + class7.field60;
                                                   if(class13.cameraY < var21) {
                                                      class13.cameraY = var21;
                                                   }
                                                }

                                                var2 = class7.field63 * 128 + 64;
                                                var21 = class131.field1974 * 128 + 64;
                                                var4 = CombatInfo1.method600(var2, var21, Client.plane) - class10.field95;
                                                var24 = var2 - class22.cameraX;
                                                var74 = var4 - class1.cameraZ;
                                                var7 = var21 - class13.cameraY;
                                                var8 = (int)Math.sqrt((double)(var7 * var7 + var24 * var24));
                                                var9 = (int)(Math.atan2((double)var74, (double)var8) * 325.949D) & 2047;
                                                var10 = (int)(Math.atan2((double)var24, (double)var7) * -325.949D) & 2047;
                                                if(var9 < 128) {
                                                   var9 = 128;
                                                }

                                                if(var9 > 383) {
                                                   var9 = 383;
                                                }

                                                if(class108.cameraPitch < var9) {
                                                   class108.cameraPitch += (var9 - class108.cameraPitch) * Buffer.field1961 / 1000 + class44.field884;
                                                   if(class108.cameraPitch > var9) {
                                                      class108.cameraPitch = var9;
                                                   }
                                                }

                                                if(class108.cameraPitch > var9) {
                                                   class108.cameraPitch -= (class108.cameraPitch - var9) * Buffer.field1961 / 1000 + class44.field884;
                                                   if(class108.cameraPitch < var9) {
                                                      class108.cameraPitch = var9;
                                                   }
                                                }

                                                var80 = var10 - class13.cameraYaw;
                                                if(var80 > 1024) {
                                                   var80 -= 2048;
                                                }

                                                if(var80 < -1024) {
                                                   var80 += 2048;
                                                }

                                                if(var80 > 0) {
                                                   class13.cameraYaw += Buffer.field1961 * var80 / 1000 + class44.field884;
                                                   class13.cameraYaw &= 2047;
                                                }

                                                if(var80 < 0) {
                                                   class13.cameraYaw -= class44.field884 + -var80 * Buffer.field1961 / 1000;
                                                   class13.cameraYaw &= 2047;
                                                }

                                                var46 = var10 - class13.cameraYaw;
                                                if(var46 > 1024) {
                                                   var46 -= 2048;
                                                }

                                                if(var46 < -1024) {
                                                   var46 += 2048;
                                                }

                                                if(var46 < 0 && var80 > 0 || var46 > 0 && var80 < 0) {
                                                   class13.cameraYaw = var10;
                                                }
                                             }

                                             for(var2 = 0; var2 < 5; ++var2) {
                                                ++Client.field539[var2];
                                             }

                                             XClanMember.chatMessages.method865();
                                             var2 = WidgetNode.method193();
                                             var21 = class180.method3284();
                                             if(var2 > 15000 && var21 > 15000) {
                                                Client.field489 = 250;
                                                class49.method915(14500);
                                                Client.secretPacketBuffer1.putOpcode(147);
                                             }

                                             ++Client.field352;
                                             if(Client.field352 > 500) {
                                                Client.field352 = 0;
                                                var4 = (int)(Math.random() * 8.0D);
                                                if((var4 & 1) == 1) {
                                                   Client.field346 += Client.field347;
                                                }

                                                if((var4 & 2) == 2) {
                                                   Client.field526 += Client.field349;
                                                }

                                                if((var4 & 4) == 4) {
                                                   Client.field425 += Client.field512;
                                                }
                                             }

                                             if(Client.field346 < -50) {
                                                Client.field347 = 2;
                                             }

                                             if(Client.field346 > 50) {
                                                Client.field347 = -2;
                                             }

                                             if(Client.field526 < -55) {
                                                Client.field349 = 2;
                                             }

                                             if(Client.field526 > 55) {
                                                Client.field349 = -2;
                                             }

                                             if(Client.field425 < -40) {
                                                Client.field512 = 1;
                                             }

                                             if(Client.field425 > 40) {
                                                Client.field512 = -1;
                                             }

                                             ++Client.field357;
                                             if(Client.field357 > 500) {
                                                Client.field357 = 0;
                                                var4 = (int)(Math.random() * 8.0D);
                                                if((var4 & 1) == 1) {
                                                   Client.mapScale += Client.mapOffset;
                                                }

                                                if((var4 & 2) == 2) {
                                                   Client.mapScaleDelta += Client.field356;
                                                }
                                             }

                                             if(Client.mapScale < -60) {
                                                Client.mapOffset = 2;
                                             }

                                             if(Client.mapScale > 60) {
                                                Client.mapOffset = -2;
                                             }

                                             if(Client.mapScaleDelta < -20) {
                                                Client.field356 = 1;
                                             }

                                             if(Client.mapScaleDelta > 10) {
                                                Client.field356 = -1;
                                             }

                                             for(class16 var107 = (class16)Client.field556.method2857(); var107 != null; var107 = (class16)Client.field556.method2858()) {
                                                if((long)var107.field172 < class72.method1421() / 1000L - 5L) {
                                                   if(var107.field171 > 0) {
                                                      WidgetNode.sendGameMessage(5, "", var107.field170 + " has logged in.");
                                                   }

                                                   if(var107.field171 == 0) {
                                                      WidgetNode.sendGameMessage(5, "", var107.field170 + " has logged out.");
                                                   }

                                                   var107.method2865();
                                                }
                                             }

                                             ++Client.field331;
                                             if(Client.field331 > 50) {
                                                Client.secretPacketBuffer1.putOpcode(102);
                                             }

                                             try {
                                                if(Friend.rssocket != null && Client.secretPacketBuffer1.offset > 0) {
                                                   Friend.rssocket.queueForWrite(Client.secretPacketBuffer1.payload, 0, Client.secretPacketBuffer1.offset);
                                                   Client.secretPacketBuffer1.offset = 0;
                                                   Client.field331 = 0;
                                                }
                                             } catch (IOException var63) {
                                                if(Client.field489 > 0) {
                                                   class0.method12();
                                                } else {
                                                   class9.setGameState(40);
                                                   class132.field1979 = Friend.rssocket;
                                                   Friend.rssocket = null;
                                                }
                                             }

                                             return;
                                          }

                                          var76 = var53.field189;
                                          if(var76.index < 0) {
                                             break;
                                          }

                                          var95 = class128.method2364(var76.parentId);
                                       } while(var95 == null || var95.children == null || var76.index >= var95.children.length || var76 != var95.children[var76.index]);

                                       Script.method910(var53, 200000);
                                    }
                                 }

                                 var76 = var53.field189;
                                 if(var76.index < 0) {
                                    break;
                                 }

                                 var95 = class128.method2364(var76.parentId);
                              } while(var95 == null || var95.children == null || var76.index >= var95.children.length || var95.children[var76.index] != var76);

                              Script.method910(var53, 200000);
                           }
                        }

                        var76 = var53.field189;
                        if(var76.index < 0) {
                           break;
                        }

                        var95 = class128.method2364(var76.parentId);
                     } while(var95 == null || var95.children == null || var76.index >= var95.children.length || var76 != var95.children[var76.index]);

                     Script.method910(var53, 200000);
                  }
               }

               Client.secretPacketBuffer1.putOpcode(33);
               Client.secretPacketBuffer1.putByte(0);
               var117 = Client.secretPacketBuffer1.offset;
               Ignore.method204(Client.secretPacketBuffer1);
               Client.secretPacketBuffer1.method2380(Client.secretPacketBuffer1.offset - var117);
            }
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "814062205"
   )
   static int method1567(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 4200) {
         var3 = class32.field720[--class32.field715];
         class32.scriptStringStack[++class32.scriptStringStackSize - 1] = class47.getItemDefinition(var3).name;
         return 1;
      } else {
         int var4;
         ItemComposition var17;
         if(var0 == 4201) {
            class32.field715 -= 2;
            var3 = class32.field720[class32.field715];
            var4 = class32.field720[class32.field715 + 1];
            var17 = class47.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var17.groundActions[var4 - 1] != null) {
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var17.groundActions[var4 - 1];
            } else {
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4202) {
            class32.field715 -= 2;
            var3 = class32.field720[class32.field715];
            var4 = class32.field720[class32.field715 + 1];
            var17 = class47.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var17.inventoryActions[var4 - 1] != null) {
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var17.inventoryActions[var4 - 1];
            } else {
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4203) {
            var3 = class32.field720[--class32.field715];
            class32.field720[++class32.field715 - 1] = class47.getItemDefinition(var3).price;
            return 1;
         } else if(var0 == 4204) {
            var3 = class32.field720[--class32.field715];
            class32.field720[++class32.field715 - 1] = class47.getItemDefinition(var3).isStackable == 1?1:0;
            return 1;
         } else {
            ItemComposition var13;
            if(var0 == 4205) {
               var3 = class32.field720[--class32.field715];
               var13 = class47.getItemDefinition(var3);
               if(var13.notedTemplate == -1 && var13.note >= 0) {
                  class32.field720[++class32.field715 - 1] = var13.note;
               } else {
                  class32.field720[++class32.field715 - 1] = var3;
               }

               return 1;
            } else if(var0 == 4206) {
               var3 = class32.field720[--class32.field715];
               var13 = class47.getItemDefinition(var3);
               if(var13.notedTemplate >= 0 && var13.note >= 0) {
                  class32.field720[++class32.field715 - 1] = var13.note;
               } else {
                  class32.field720[++class32.field715 - 1] = var3;
               }

               return 1;
            } else if(var0 == 4207) {
               var3 = class32.field720[--class32.field715];
               class32.field720[++class32.field715 - 1] = class47.getItemDefinition(var3).isMembers?1:0;
               return 1;
            } else if(var0 == 4208) {
               var3 = class32.field720[--class32.field715];
               var13 = class47.getItemDefinition(var3);
               if(var13.field3000 == -1 && var13.field3016 >= 0) {
                  class32.field720[++class32.field715 - 1] = var13.field3016;
               } else {
                  class32.field720[++class32.field715 - 1] = var3;
               }

               return 1;
            } else if(var0 == 4209) {
               var3 = class32.field720[--class32.field715];
               var13 = class47.getItemDefinition(var3);
               if(var13.field3000 >= 0 && var13.field3016 >= 0) {
                  class32.field720[++class32.field715 - 1] = var13.field3016;
               } else {
                  class32.field720[++class32.field715 - 1] = var3;
               }

               return 1;
            } else if(var0 == 4210) {
               String var15 = class32.scriptStringStack[--class32.scriptStringStackSize];
               var4 = class32.field720[--class32.field715];
               boolean var6 = var4 == 1;
               String var5 = var15.toLowerCase();
               short[] var7 = new short[16];
               int var8 = 0;
               int var14 = 0;

               while(true) {
                  if(var14 >= ItemComposition.field2981) {
                     class26.field589 = var7;
                     class118.field1853 = 0;
                     class105.field1691 = var8;
                     String[] var9 = new String[class105.field1691];

                     for(int var16 = 0; var16 < class105.field1691; ++var16) {
                        var9[var16] = class47.getItemDefinition(var7[var16]).name;
                     }

                     short[] var18 = class26.field589;
                     class118.method2292(var9, var18, 0, var9.length - 1);
                     break;
                  }

                  ItemComposition var10 = class47.getItemDefinition(var14);
                  if((!var6 || var10.field3017) && var10.notedTemplate == -1 && var10.name.toLowerCase().indexOf(var5) != -1) {
                     if(var8 >= 250) {
                        class105.field1691 = -1;
                        class26.field589 = null;
                        break;
                     }

                     if(var8 >= var7.length) {
                        short[] var11 = new short[var7.length * 2];

                        for(int var12 = 0; var12 < var8; ++var12) {
                           var11[var12] = var7[var12];
                        }

                        var7 = var11;
                     }

                     var7[var8++] = (short)var14;
                  }

                  ++var14;
               }

               class32.field720[++class32.field715 - 1] = class105.field1691;
               return 1;
            } else if(var0 != 4211) {
               if(var0 == 4212) {
                  class118.field1853 = 0;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               if(class26.field589 != null && class118.field1853 < class105.field1691) {
                  class32.field720[++class32.field715 - 1] = class26.field589[++class118.field1853 - 1] & '\uffff';
               } else {
                  class32.field720[++class32.field715 - 1] = -1;
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;IIS)LFont;",
      garbageValue = "257"
   )
   public static Font method1568(IndexDataBase var0, IndexDataBase var1, int var2, int var3) {
      if(!class199.method3620(var0, var2, var3)) {
         return null;
      } else {
         byte[] var5 = var1.getConfigData(var2, var3);
         Font var4;
         if(var5 == null) {
            var4 = null;
         } else {
            Font var6 = new Font(var5, class199.field2877, class229.field3252, class229.field3254, class36.field772, class229.field3249, class229.field3253);
            class199.field2877 = null;
            class229.field3252 = null;
            class229.field3254 = null;
            class36.field772 = null;
            class229.field3249 = null;
            class229.field3253 = null;
            var4 = var6;
         }

         return var4;
      }
   }

   Tile(int var1, int var2, int var3) {
      this.objects = new GameObject[5];
      this.field1328 = new int[5];
      this.field1326 = 0;
      this.field1319 = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }
}
