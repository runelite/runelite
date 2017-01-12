import java.awt.Component;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
public class class145 {
   @ObfuscatedName("x")
   byte[] field1996;
   @ObfuscatedName("u")
   int[] field1997;
   @ObfuscatedName("i")
   int[] field1999;
   @ObfuscatedName("ny")
   @ObfuscatedGetter(
      intValue = 2015025197
   )
   static int field2000;
   @ObfuscatedName("eq")
   static SpritePixels[] field2001;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BI[BIII)I",
      garbageValue = "-952945634"
   )
   public int method2706(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field1999[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field1999[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.field1999[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1999[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field1999[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1999[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.field1999[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1999[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.field1999[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1999[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field1999[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1999[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.field1999[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1999[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.field1999[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1999[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            ++var7;
         }

         return 1 + var7 - var2;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "-34"
   )
   public static void method2707(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(class105.keyboard);
      var0.addFocusListener(class105.keyboard);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BII[BIB)I",
      garbageValue = "0"
   )
   public int method2709(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field1997[var8];
         byte var10 = this.field1996[var8];
         if(var10 == 0) {
            throw new RuntimeException("");
         }

         int var11 = var7 >> 3;
         int var12 = var7 & 7;
         var6 &= -var12 >> 31;
         int var13 = (var12 + var10 - 1 >> 3) + var11;
         var12 += 24;
         var4[var11] = (byte)(var6 |= var9 >>> var12);
         if(var11 < var13) {
            ++var11;
            var12 -= 8;
            var4[var11] = (byte)(var6 = var9 >>> var12);
            if(var11 < var13) {
               ++var11;
               var12 -= 8;
               var4[var11] = (byte)(var6 = var9 >>> var12);
               if(var11 < var13) {
                  ++var11;
                  var12 -= 8;
                  var4[var11] = (byte)(var6 = var9 >>> var12);
                  if(var11 < var13) {
                     ++var11;
                     var12 -= 8;
                     var4[var11] = (byte)(var6 = var9 << -var12);
                  }
               }
            }
         }

         var7 += var10;
      }

      return (7 + var7 >> 3) - var5;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static final void method2711() {
      if(Client.field297 > 1) {
         --Client.field297;
      }

      if(Client.field336 > 0) {
         --Client.field336;
      }

      if(Client.field337) {
         Client.field337 = false;
         Frames.method1851();
      } else {
         if(!Client.isMenuOpen) {
            Client.menuOptions[0] = "Cancel";
            Client.menuTargets[0] = "";
            Client.menuTypes[0] = 1006;
            Client.menuOptionCount = 1;
         }

         int var0;
         int var2;
         int var3;
         int var4;
         int var6;
         int var7;
         int var8;
         int var10;
         int var25;
         int var60;
         long var61;
         boolean var66;
         Widget var87;
         int var125;
         for(var0 = 0; var0 < 100; ++var0) {
            boolean var1;
            if(null == class37.field774) {
               var1 = false;
            } else {
               label3099: {
                  String var24;
                  try {
                     var2 = class37.field774.method2017();
                     if(var2 == 0) {
                        var1 = false;
                        break label3099;
                     }

                     if(Client.packetOpcode == -1) {
                        class37.field774.method2014(Client.field409.payload, 0, 1);
                        Client.field409.offset = 0;
                        Client.packetOpcode = Client.field409.method3030();
                        Client.field328 = class212.field3130[Client.packetOpcode];
                        --var2;
                     }

                     if(Client.field328 == -1) {
                        if(var2 <= 0) {
                           var1 = false;
                           break label3099;
                        }

                        class37.field774.method2014(Client.field409.payload, 0, 1);
                        Client.field328 = Client.field409.payload[0] & 255;
                        --var2;
                     }

                     if(Client.field328 == -2) {
                        if(var2 <= 1) {
                           var1 = false;
                           break label3099;
                        }

                        class37.field774.method2014(Client.field409.payload, 0, 2);
                        Client.field409.offset = 0;
                        Client.field328 = Client.field409.readUnsignedShort();
                        var2 -= 2;
                     }

                     if(var2 < Client.field328) {
                        var1 = false;
                        break label3099;
                     }

                     Client.field409.offset = 0;
                     class37.field774.method2014(Client.field409.payload, 0, Client.field328);
                     Client.field308 = 0;
                     Client.field335 = Client.field334;
                     Client.field334 = Client.field333 * -1;
                     Client.field333 = Client.packetOpcode * -1;
                     Widget var5;
                     boolean var72;
                     if(Client.packetOpcode == 250) {
                        var72 = Client.field409.method2804() == 1;
                        var4 = Client.field409.method2780();
                        var5 = class44.method799(var4);
                        if(var72 != var5.isHidden) {
                           var5.isHidden = var72;
                           class6.method87(var5);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 172) {
                        var24 = Client.field409.method2965();
                        var4 = Client.field409.method2802();
                        var25 = Client.field409.readUnsignedByte();
                        if(var4 >= 1 && var4 <= 8) {
                           if(var24.equalsIgnoreCase("null")) {
                              var24 = null;
                           }

                           Client.field466[var4 - 1] = var24;
                           Client.field410[var4 - 1] = var25 == 0;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 3) {
                        var3 = Client.field409.method2936();
                        var4 = Client.field409.readUnsignedShort();
                        class165.settings[var4] = var3;
                        if(var3 != class165.widgetSettings[var4]) {
                           class165.widgetSettings[var4] = var3;
                        }

                        CombatInfo2.method3532(var4);
                        Client.field287[++Client.field467 - 1 & 31] = var4;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 158) {
                        class190.method3457();

                        for(var3 = 0; var3 < 2048; ++var3) {
                           Client.cachedPlayers[var3] = null;
                        }

                        CombatInfoListHolder.method712(Client.field409);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 63) {
                        var3 = Client.field409.method2820();
                        var87 = class44.method799(var3);

                        for(var25 = 0; var25 < var87.itemIds.length; ++var25) {
                           var87.itemIds[var25] = -1;
                           var87.itemIds[var25] = 0;
                        }

                        class6.method87(var87);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 189) {
                        var3 = Client.field409.method2922();
                        Client.widgetRoot = var3;
                        XGrandExchangeOffer.method64(Client.widgetRoot, class0.field1, class65.field1099, false);
                        class157.method3024(var3);
                        class18.method186(Client.widgetRoot);

                        for(var4 = 0; var4 < 100; ++var4) {
                           Client.field485[var4] = true;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 223) {
                        Client.flagX = Client.field409.readUnsignedByte();
                        if(Client.flagX == 255) {
                           Client.flagX = 0;
                        }

                        Client.flagY = Client.field409.readUnsignedByte();
                        if(Client.flagY == 255) {
                           Client.flagY = 0;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 55) {
                        Client.field529 = true;
                        ChatLineBuffer.field960 = Client.field409.readUnsignedByte();
                        class2.field20 = Client.field409.readUnsignedByte();
                        class152.field2061 = Client.field409.readUnsignedShort();
                        class60.field1079 = Client.field409.readUnsignedByte();
                        class47.field925 = Client.field409.readUnsignedByte();
                        if(class47.field925 >= 100) {
                           var3 = ChatLineBuffer.field960 * 128 + 64;
                           var4 = 64 + class2.field20 * 128;
                           var25 = class176.method3243(var3, var4, class60.plane) - class152.field2061;
                           var6 = var3 - class36.cameraX;
                           var7 = var25 - class36.cameraZ;
                           var8 = var4 - GroundObject.cameraY;
                           var60 = (int)Math.sqrt((double)(var8 * var8 + var6 * var6));
                           class165.cameraPitch = (int)(Math.atan2((double)var7, (double)var60) * 325.949D) & 2047;
                           XClanMember.cameraYaw = (int)(Math.atan2((double)var6, (double)var8) * -325.949D) & 2047;
                           if(class165.cameraPitch < 128) {
                              class165.cameraPitch = 128;
                           }

                           if(class165.cameraPitch > 383) {
                              class165.cameraPitch = 383;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     Widget var27;
                     if(Client.packetOpcode == 167) {
                        var3 = Client.field409.method2953();
                        var4 = Client.field409.method2968();
                        var25 = Client.field409.method2819();
                        var27 = class44.method799(var25);
                        if(var27.field2194 != var4 || var27.field2195 != var3 || var27.field2230 != 0 || var27.field2191 != 0) {
                           var27.field2194 = var4;
                           var27.field2195 = var3;
                           var27.field2230 = 0;
                           var27.field2191 = 0;
                           class6.method87(var27);
                           XItemContainer.method166(var27);
                           if(var27.type == 0) {
                              class6.method97(Widget.widgets[var25 >> 16], var27, false);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 30) {
                        var4 = Client.field409.readUnsignedByte();
                        class216[] var74 = new class216[]{class216.field3162, class216.field3165, class216.field3163};
                        class216[] var104 = var74;
                        var7 = 0;

                        class216 var92;
                        while(true) {
                           if(var7 >= var104.length) {
                              var92 = null;
                              break;
                           }

                           class216 var105 = var104[var7];
                           if(var105.field3161 == var4) {
                              var92 = var105;
                              break;
                           }

                           ++var7;
                        }

                        FrameMap.field1467 = var92;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     boolean var62;
                     boolean var67;
                     if(Client.packetOpcode == 13) {
                        var24 = Client.field409.method2965();
                        var4 = Client.field409.readUnsignedShort();
                        byte var111 = Client.field409.readByte();
                        var67 = false;
                        if(var111 == -128) {
                           var67 = true;
                        }

                        if(var67) {
                           if(class142.field1984 == 0) {
                              Client.packetOpcode = -1;
                              var1 = true;
                              break label3099;
                           }

                           var62 = false;

                           for(var7 = 0; var7 < class142.field1984 && (!class30.clanMembers[var7].username.equals(var24) || class30.clanMembers[var7].world != var4); ++var7) {
                              ;
                           }

                           if(var7 < class142.field1984) {
                              while(var7 < class142.field1984 - 1) {
                                 class30.clanMembers[var7] = class30.clanMembers[1 + var7];
                                 ++var7;
                              }

                              --class142.field1984;
                              class30.clanMembers[class142.field1984] = null;
                           }
                        } else {
                           Client.field409.method2965();
                           XClanMember var117 = new XClanMember();
                           var117.username = var24;
                           var117.field271 = class139.method2601(var117.username, Ignore.field209);
                           var117.world = var4;
                           var117.rank = var111;

                           for(var8 = class142.field1984 - 1; var8 >= 0; --var8) {
                              var60 = class30.clanMembers[var8].field271.compareTo(var117.field271);
                              if(var60 == 0) {
                                 class30.clanMembers[var8].world = var4;
                                 class30.clanMembers[var8].rank = var111;
                                 if(var24.equals(class148.localPlayer.name)) {
                                    class118.field1831 = var111;
                                 }

                                 Client.field474 = Client.field446;
                                 Client.packetOpcode = -1;
                                 var1 = true;
                                 break label3099;
                              }

                              if(var60 < 0) {
                                 break;
                              }
                           }

                           if(class142.field1984 >= class30.clanMembers.length) {
                              Client.packetOpcode = -1;
                              var1 = true;
                              break label3099;
                           }

                           for(var60 = class142.field1984 - 1; var60 > var8; --var60) {
                              class30.clanMembers[var60 + 1] = class30.clanMembers[var60];
                           }

                           if(class142.field1984 == 0) {
                              class30.clanMembers = new XClanMember[100];
                           }

                           class30.clanMembers[var8 + 1] = var117;
                           ++class142.field1984;
                           if(var24.equals(class148.localPlayer.name)) {
                              class118.field1831 = var111;
                           }
                        }

                        Client.field474 = Client.field446;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     String var58;
                     if(Client.packetOpcode == 143) {
                        var3 = Client.field409.method2963();
                        var66 = Client.field409.readUnsignedByte() == 1;
                        var58 = "";
                        var67 = false;
                        if(var66) {
                           var58 = Client.field409.method2965();
                           if(class164.method3115(var58)) {
                              var67 = true;
                           }
                        }

                        String var115 = Client.field409.method2965();
                        if(!var67) {
                           class7.method99(var3, var58, var115);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 219) {
                        Client.field298 = Client.field409.readUnsignedByte();
                        if(Client.field298 == 1) {
                           Client.field299 = Client.field409.readUnsignedShort();
                        }

                        if(Client.field298 >= 2 && Client.field298 <= 6) {
                           if(Client.field298 == 2) {
                              Client.field304 = 64;
                              Client.field323 = 64;
                           }

                           if(Client.field298 == 3) {
                              Client.field304 = 0;
                              Client.field323 = 64;
                           }

                           if(Client.field298 == 4) {
                              Client.field304 = 128;
                              Client.field323 = 64;
                           }

                           if(Client.field298 == 5) {
                              Client.field304 = 64;
                              Client.field323 = 0;
                           }

                           if(Client.field298 == 6) {
                              Client.field304 = 64;
                              Client.field323 = 128;
                           }

                           Client.field298 = 2;
                           Client.field530 = Client.field409.readUnsignedShort();
                           Client.field426 = Client.field409.readUnsignedShort();
                           Client.field534 = Client.field409.readUnsignedByte();
                        }

                        if(Client.field298 == 10) {
                           Client.field544 = Client.field409.readUnsignedShort();
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 25) {
                        Client.field529 = true;
                        class22.field237 = Client.field409.readUnsignedByte();
                        class10.field107 = Client.field409.readUnsignedByte();
                        class114.field1776 = Client.field409.readUnsignedShort();
                        class146.field2004 = Client.field409.readUnsignedByte();
                        field2000 = Client.field409.readUnsignedByte();
                        if(field2000 >= 100) {
                           class36.cameraX = 64 + class22.field237 * 128;
                           GroundObject.cameraY = class10.field107 * 128 + 64;
                           class36.cameraZ = class176.method3243(class36.cameraX, GroundObject.cameraY, class60.plane) - class114.field1776;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 180) {
                        class103.method1935(Client.field409.method2965());
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 36) {
                        var24 = Client.field409.method2965();
                        Object[] var95 = new Object[var24.length() + 1];

                        for(var25 = var24.length() - 1; var25 >= 0; --var25) {
                           if(var24.charAt(var25) == 115) {
                              var95[var25 + 1] = Client.field409.method2965();
                           } else {
                              var95[var25 + 1] = new Integer(Client.field409.method2780());
                           }
                        }

                        var95[0] = new Integer(Client.field409.method2780());
                        class18 var71 = new class18();
                        var71.field203 = var95;
                        class49.method871(var71, 200000);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 249) {
                        if(Client.widgetRoot != -1) {
                           var3 = Client.widgetRoot;
                           if(class94.method1870(var3)) {
                              class140.method2607(Widget.widgets[var3], 0);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     long var64;
                     if(Client.packetOpcode == 61) {
                        var3 = Client.field409.method2780();
                        var4 = Client.field409.method2780();
                        if(class8.field77 == null || !class8.field77.isValid()) {
                           try {
                              Iterator var68 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                              while(var68.hasNext()) {
                                 GarbageCollectorMXBean var102 = (GarbageCollectorMXBean)var68.next();
                                 if(var102.isValid()) {
                                    class8.field77 = var102;
                                    Client.field559 = -1L;
                                    Client.field366 = -1L;
                                 }
                              }
                           } catch (Throwable var47) {
                              ;
                           }
                        }

                        long var101 = class9.method117();
                        var7 = -1;
                        if(class8.field77 != null) {
                           var64 = class8.field77.getCollectionTime();
                           if(Client.field366 != -1L) {
                              long var75 = var64 - Client.field366;
                              long var76 = var101 - Client.field559;
                              if(var76 != 0L) {
                                 var7 = (int)(var75 * 100L / var76);
                              }
                           }

                           Client.field366 = var64;
                           Client.field559 = var101;
                        }

                        Client.field326.method3029(47);
                        Client.field326.method2800(GameEngine.field1763);
                        Client.field326.method2817(var3);
                        Client.field326.method2818(var4);
                        Client.field326.method2801(var7);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 184) {
                        class33.method695();
                        Client.weight = Client.field409.method2968();
                        Client.field477 = Client.field446;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 78) {
                        class32.xteaChanged(false);
                        Client.field409.method3030();
                        var3 = Client.field409.readUnsignedShort();
                        class39.method735(Client.field409, var3);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 62) {
                        var3 = Client.field409.method2922();
                        class171.method3233(var3);
                        Client.field471[++Client.field469 - 1 & 31] = var3 & 32767;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     class159 var88;
                     if(Client.packetOpcode == 32) {
                        Client.field409.offset += 28;
                        if(Client.field409.method2855()) {
                           var88 = Client.field409;
                           var4 = Client.field409.offset - 28;
                           if(class104.field1682 != null) {
                              try {
                                 class104.field1682.method1335(0L);
                                 class104.field1682.method1360(var88.payload, var4, 24);
                              } catch (Exception var44) {
                                 ;
                              }
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 216) {
                        var3 = Client.field409.method2780();
                        WidgetNode var93 = (WidgetNode)Client.componentTable.method2339((long)var3);
                        if(var93 != null) {
                           class3.method31(var93, true);
                        }

                        if(null != Client.field537) {
                           class6.method87(Client.field537);
                           Client.field537 = null;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 157) {
                        class11.method150();
                        Client.packetOpcode = -1;
                        var1 = false;
                        break label3099;
                     }

                     if(Client.packetOpcode == 182) {
                        Client.field297 = Client.field409.method2762() * 30;
                        Client.field477 = Client.field446;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 102) {
                        var3 = Client.field409.method2922();
                        byte var80 = Client.field409.readByte();
                        class165.settings[var3] = var80;
                        if(class165.widgetSettings[var3] != var80) {
                           class165.widgetSettings[var3] = var80;
                        }

                        CombatInfo2.method3532(var3);
                        Client.field287[++Client.field467 - 1 & 31] = var3;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 133) {
                        var3 = Client.field409.method2780();
                        var4 = Client.field409.readUnsignedShort();
                        if(var3 < -70000) {
                           var4 += '耀';
                        }

                        if(var3 >= 0) {
                           var5 = class44.method799(var3);
                        } else {
                           var5 = null;
                        }

                        if(null != var5) {
                           for(var6 = 0; var6 < var5.itemIds.length; ++var6) {
                              var5.itemIds[var6] = 0;
                              var5.itemQuantities[var6] = 0;
                           }
                        }

                        class63.method1109(var4);
                        var6 = Client.field409.readUnsignedShort();

                        for(var7 = 0; var7 < var6; ++var7) {
                           var8 = Client.field409.readUnsignedByte();
                           if(var8 == 255) {
                              var8 = Client.field409.method2819();
                           }

                           var60 = Client.field409.method2922();
                           if(null != var5 && var7 < var5.itemIds.length) {
                              var5.itemIds[var7] = var60;
                              var5.itemQuantities[var7] = var8;
                           }

                           class0.method1(var4, var7, var60 - 1, var8);
                        }

                        if(null != var5) {
                           class6.method87(var5);
                        }

                        class33.method695();
                        Client.field471[++Client.field469 - 1 & 31] = var4 & 32767;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 231) {
                        class33.method695();
                        var3 = Client.field409.method2803();
                        var4 = Client.field409.readUnsignedByte();
                        var25 = Client.field409.method2936();
                        Client.skillExperiences[var3] = var25;
                        Client.boostedSkillLevels[var3] = var4;
                        Client.realSkillLevels[var3] = 1;

                        for(var6 = 0; var6 < 98; ++var6) {
                           if(var25 >= class172.field2333[var6]) {
                              Client.realSkillLevels[var3] = var6 + 2;
                           }
                        }

                        Client.field470[++Client.field344 - 1 & 31] = var3;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 210) {
                        var3 = Client.field409.method2922();
                        if(var3 == '\uffff') {
                           var3 = -1;
                        }

                        if(var3 == -1 && !Client.field519) {
                           class9.method118();
                        } else if(var3 != -1 && Client.field444 != var3 && Client.field517 != 0 && !Client.field519) {
                           class85.method1663(2, class37.field781, var3, 0, Client.field517, false);
                        }

                        Client.field444 = var3;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 176) {
                        var3 = Client.field409.method2815();
                        var4 = Client.field409.method2922();
                        if(var4 == '\uffff') {
                           var4 = -1;
                        }

                        if(Client.field517 != 0 && var4 != -1) {
                           class107.method2001(class162.field2136, var4, 0, Client.field517, false);
                           Client.field519 = true;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     String var89;
                     if(Client.packetOpcode == 124) {
                        var24 = Client.field409.method2965();
                        var89 = class209.method3866(Client.method589(class40.method738(Client.field409)));
                        class7.method99(6, var24, var89);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     int var12;
                     int var14;
                     int var15;
                     if(Client.packetOpcode == 155) {
                        var88 = Client.field409;
                        var4 = Client.field328;
                        ClassInfo var63 = new ClassInfo();
                        var63.field3220 = var88.readUnsignedByte();
                        var63.field3221 = var88.method2780();
                        var63.field3219 = new int[var63.field3220];
                        var63.field3222 = new int[var63.field3220];
                        var63.fields = new Field[var63.field3220];
                        var63.field3224 = new int[var63.field3220];
                        var63.methods = new Method[var63.field3220];
                        var63.args = new byte[var63.field3220][][];

                        for(var6 = 0; var6 < var63.field3220; ++var6) {
                           try {
                              var7 = var88.readUnsignedByte();
                              String var99;
                              String var119;
                              if(var7 != 0 && var7 != 1 && var7 != 2) {
                                 if(var7 == 3 || var7 == 4) {
                                    var99 = var88.method2965();
                                    var119 = var88.method2965();
                                    var10 = var88.readUnsignedByte();
                                    String[] var69 = new String[var10];

                                    for(var12 = 0; var12 < var10; ++var12) {
                                       var69[var12] = var88.method2965();
                                    }

                                    String var116 = var88.method2965();
                                    byte[][] var77 = new byte[var10][];
                                    if(var7 == 3) {
                                       for(var14 = 0; var14 < var10; ++var14) {
                                          var15 = var88.method2780();
                                          var77[var14] = new byte[var15];
                                          var88.method2974(var77[var14], 0, var15);
                                       }
                                    }

                                    var63.field3219[var6] = var7;
                                    Class[] var123 = new Class[var10];

                                    for(var15 = 0; var15 < var10; ++var15) {
                                       var123[var15] = Client.method590(var69[var15]);
                                    }

                                    Class var121 = Client.method590(var116);
                                    if(Client.method590(var99).getClassLoader() == null) {
                                       throw new SecurityException();
                                    }

                                    Method[] var83 = Client.method590(var99).getDeclaredMethods();
                                    Method[] var81 = var83;

                                    for(int var18 = 0; var18 < var81.length; ++var18) {
                                       Method var84 = var81[var18];
                                       if(var84.getName().equals(var119)) {
                                          Class[] var20 = var84.getParameterTypes();
                                          if(var20.length == var123.length) {
                                             boolean var21 = true;

                                             for(int var22 = 0; var22 < var123.length; ++var22) {
                                                if(var123[var22] != var20[var22]) {
                                                   var21 = false;
                                                   break;
                                                }
                                             }

                                             if(var21 && var121 == var84.getReturnType()) {
                                                var63.methods[var6] = var84;
                                             }
                                          }
                                       }
                                    }

                                    var63.args[var6] = var77;
                                 }
                              } else {
                                 var99 = var88.method2965();
                                 var119 = var88.method2965();
                                 var10 = 0;
                                 if(var7 == 1) {
                                    var10 = var88.method2780();
                                 }

                                 var63.field3219[var6] = var7;
                                 var63.field3224[var6] = var10;
                                 if(Client.method590(var99).getClassLoader() == null) {
                                    throw new SecurityException();
                                 }

                                 var63.fields[var6] = Client.method590(var99).getDeclaredField(var119);
                              }
                           } catch (ClassNotFoundException var48) {
                              var63.field3222[var6] = -1;
                           } catch (SecurityException var49) {
                              var63.field3222[var6] = -2;
                           } catch (NullPointerException var50) {
                              var63.field3222[var6] = -3;
                           } catch (Exception var51) {
                              var63.field3222[var6] = -4;
                           } catch (Throwable var52) {
                              var63.field3222[var6] = -5;
                           }
                        }

                        class227.field3228.method2371(var63);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 190) {
                        for(var3 = 0; var3 < class165.widgetSettings.length; ++var3) {
                           if(class165.settings[var3] != class165.widgetSettings[var3]) {
                              class165.widgetSettings[var3] = class165.settings[var3];
                              CombatInfo2.method3532(var3);
                              Client.field287[++Client.field467 - 1 & 31] = var3;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 86 || Client.packetOpcode == 225 || Client.packetOpcode == 132 || Client.packetOpcode == 95 || Client.packetOpcode == 27 || Client.packetOpcode == 236 || Client.packetOpcode == 51 || Client.packetOpcode == 181 || Client.packetOpcode == 46 || Client.packetOpcode == 137) {
                        class101.method1910();
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 211) {
                        class25.field580 = Client.field409.readUnsignedByte();
                        class22.field234 = Client.field409.method2803();

                        for(var3 = class22.field234; var3 < class22.field234 + 8; ++var3) {
                           for(var4 = class25.field580; var4 < 8 + class25.field580; ++var4) {
                              if(Client.groundItemDeque[class60.plane][var3][var4] != null) {
                                 Client.groundItemDeque[class60.plane][var3][var4] = null;
                                 class44.groundItemSpawned(var3, var4);
                              }
                           }
                        }

                        for(class25 var86 = (class25)Client.field545.method2391(); var86 != null; var86 = (class25)Client.field545.method2393()) {
                           if(var86.field568 >= class22.field234 && var86.field568 < class22.field234 + 8 && var86.field569 >= class25.field580 && var86.field569 < 8 + class25.field580 && var86.field584 == class60.plane) {
                              var86.field577 = 0;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     boolean var35;
                     if(Client.packetOpcode == 17) {
                        while(Client.field409.offset < Client.field328) {
                           var72 = Client.field409.readUnsignedByte() == 1;
                           var89 = Client.field409.method2965();
                           var58 = Client.field409.method2965();
                           var6 = Client.field409.readUnsignedShort();
                           var7 = Client.field409.readUnsignedByte();
                           var8 = Client.field409.readUnsignedByte();
                           boolean var65 = (var8 & 2) != 0;
                           boolean var70 = (var8 & 1) != 0;
                           if(var6 > 0) {
                              Client.field409.method2965();
                              Client.field409.readUnsignedByte();
                              Client.field409.method2780();
                           }

                           Client.field409.method2965();

                           for(var125 = 0; var125 < Client.friendCount; ++var125) {
                              Friend var31 = Client.friends[var125];
                              if(!var72) {
                                 if(var89.equals(var31.name)) {
                                    if(var31.world != var6) {
                                       var35 = true;

                                       for(class16 var122 = (class16)Client.field383.method2416(); var122 != null; var122 = (class16)Client.field383.method2419()) {
                                          if(var122.field175.equals(var89)) {
                                             if(var6 != 0 && var122.field176 == 0) {
                                                var122.method2431();
                                                var35 = false;
                                             } else if(var6 == 0 && var122.field176 != 0) {
                                                var122.method2431();
                                                var35 = false;
                                             }
                                          }
                                       }

                                       if(var35) {
                                          Client.field383.method2417(new class16(var89, var6));
                                       }

                                       var31.world = var6;
                                    }

                                    var31.previousName = var58;
                                    var31.rank = var7;
                                    var31.field158 = var65;
                                    var31.field154 = var70;
                                    var89 = null;
                                    break;
                                 }
                              } else if(var58.equals(var31.name)) {
                                 var31.name = var89;
                                 var31.previousName = var58;
                                 var89 = null;
                                 break;
                              }
                           }

                           if(null != var89 && Client.friendCount < 400) {
                              Friend var11 = new Friend();
                              Client.friends[Client.friendCount] = var11;
                              var11.name = var89;
                              var11.previousName = var58;
                              var11.world = var6;
                              var11.rank = var7;
                              var11.field158 = var65;
                              var11.field154 = var70;
                              ++Client.friendCount;
                           }
                        }

                        Client.field465 = 2;
                        Client.field460 = Client.field446;
                        var72 = false;
                        var4 = Client.friendCount;

                        while(var4 > 0) {
                           var72 = true;
                           --var4;

                           for(var25 = 0; var25 < var4; ++var25) {
                              var67 = false;
                              Friend var114 = Client.friends[var25];
                              Friend var98 = Client.friends[1 + var25];
                              if(var114.world != Client.world && var98.world == Client.world) {
                                 var67 = true;
                              }

                              if(!var67 && var114.world == 0 && var98.world != 0) {
                                 var67 = true;
                              }

                              if(!var67 && !var114.field158 && var98.field158) {
                                 var67 = true;
                              }

                              if(!var67 && !var114.field154 && var98.field154) {
                                 var67 = true;
                              }

                              if(var67) {
                                 Friend var118 = Client.friends[var25];
                                 Client.friends[var25] = Client.friends[1 + var25];
                                 Client.friends[1 + var25] = var118;
                                 var72 = false;
                              }
                           }

                           if(var72) {
                              break;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 117) {
                        var3 = Client.field409.readUnsignedShort();
                        var4 = Client.field409.method2780();
                        var5 = class44.method799(var4);
                        if(null != var5 && var5.type == 0) {
                           if(var3 > var5.scrollHeight - var5.height) {
                              var3 = var5.scrollHeight - var5.height;
                           }

                           if(var3 < 0) {
                              var3 = 0;
                           }

                           if(var5.scrollY != var3) {
                              var5.scrollY = var3;
                              class6.method87(var5);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     long var34;
                     WidgetNode var91;
                     if(Client.packetOpcode == 141) {
                        var3 = Client.field328 + Client.field409.offset;
                        var4 = Client.field409.readUnsignedShort();
                        var25 = Client.field409.readUnsignedShort();
                        if(var4 != Client.widgetRoot) {
                           Client.widgetRoot = var4;
                           XGrandExchangeOffer.method64(Client.widgetRoot, class0.field1, class65.field1099, false);
                           class157.method3024(Client.widgetRoot);
                           class18.method186(Client.widgetRoot);

                           for(var6 = 0; var6 < 100; ++var6) {
                              Client.field485[var6] = true;
                           }
                        }

                        WidgetNode var109;
                        for(; var25-- > 0; var109.field183 = true) {
                           var6 = Client.field409.method2780();
                           var7 = Client.field409.readUnsignedShort();
                           var8 = Client.field409.readUnsignedByte();
                           var109 = (WidgetNode)Client.componentTable.method2339((long)var6);
                           if(var109 != null && var109.id != var7) {
                              class3.method31(var109, true);
                              var109 = null;
                           }

                           if(var109 == null) {
                              var109 = class20.method194(var6, var7, var8);
                           }
                        }

                        for(var91 = (WidgetNode)Client.componentTable.method2344(); var91 != null; var91 = (WidgetNode)Client.componentTable.method2343()) {
                           if(var91.field183) {
                              var91.field183 = false;
                           } else {
                              class3.method31(var91, true);
                           }
                        }

                        Client.widgetFlags = new XHashTable(512);

                        while(Client.field409.offset < var3) {
                           var6 = Client.field409.method2780();
                           var7 = Client.field409.readUnsignedShort();
                           var8 = Client.field409.readUnsignedShort();
                           var60 = Client.field409.method2780();

                           for(var10 = var7; var10 <= var8; ++var10) {
                              var34 = ((long)var6 << 32) + (long)var10;
                              Client.widgetFlags.method2340(new class133(var60), var34);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 41) {
                        Client.field474 = Client.field446;
                        if(Client.field328 == 0) {
                           Client.field507 = null;
                           Client.clanChatOwner = null;
                           class142.field1984 = 0;
                           class30.clanMembers = null;
                           Client.packetOpcode = -1;
                           var1 = true;
                        } else {
                           Client.clanChatOwner = Client.field409.method2965();
                           long var73 = Client.field409.method2908();
                           Client.field507 = class107.method2000(var73);
                           class165.field2147 = Client.field409.readByte();
                           var25 = Client.field409.readUnsignedByte();
                           if(var25 == 255) {
                              Client.packetOpcode = -1;
                              var1 = true;
                           } else {
                              class142.field1984 = var25;
                              XClanMember[] var96 = new XClanMember[100];

                              for(var7 = 0; var7 < class142.field1984; ++var7) {
                                 var96[var7] = new XClanMember();
                                 var96[var7].username = Client.field409.method2965();
                                 var96[var7].field271 = class139.method2601(var96[var7].username, Ignore.field209);
                                 var96[var7].world = Client.field409.readUnsignedShort();
                                 var96[var7].rank = Client.field409.readByte();
                                 Client.field409.method2965();
                                 if(var96[var7].username.equals(class148.localPlayer.name)) {
                                    class118.field1831 = var96[var7].rank;
                                 }
                              }

                              var62 = false;
                              var60 = class142.field1984;

                              while(var60 > 0) {
                                 var62 = true;
                                 --var60;

                                 for(var10 = 0; var10 < var60; ++var10) {
                                    if(var96[var10].field271.compareTo(var96[var10 + 1].field271) > 0) {
                                       XClanMember var97 = var96[var10];
                                       var96[var10] = var96[var10 + 1];
                                       var96[1 + var10] = var97;
                                       var62 = false;
                                    }
                                 }

                                 if(var62) {
                                    break;
                                 }
                              }

                              class30.clanMembers = var96;
                              Client.packetOpcode = -1;
                              var1 = true;
                           }
                        }
                        break label3099;
                     }

                     Widget var29;
                     if(Client.packetOpcode == 162) {
                        var3 = Client.field409.method2819();
                        var4 = Client.field409.method2936();
                        WidgetNode var59 = (WidgetNode)Client.componentTable.method2339((long)var3);
                        var91 = (WidgetNode)Client.componentTable.method2339((long)var4);
                        if(var91 != null) {
                           class3.method31(var91, var59 == null || var91.id != var59.id);
                        }

                        if(null != var59) {
                           var59.unlink();
                           Client.componentTable.method2340(var59, (long)var4);
                        }

                        var29 = class44.method799(var3);
                        if(null != var29) {
                           class6.method87(var29);
                        }

                        var29 = class44.method799(var4);
                        if(null != var29) {
                           class6.method87(var29);
                           class6.method97(Widget.widgets[var29.id >>> 16], var29, true);
                        }

                        if(Client.widgetRoot != -1) {
                           var8 = Client.widgetRoot;
                           if(class94.method1870(var8)) {
                              class140.method2607(Widget.widgets[var8], 1);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 208) {
                        Client.field543 = Client.field409.readUnsignedByte();
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 224) {
                        var3 = Client.field409.method2780();
                        var4 = Client.field409.method2762();
                        var5 = class44.method799(var3);
                        if(var5.modelType != 1 || var4 != var5.modelId) {
                           var5.modelType = 1;
                           var5.modelId = var4;
                           class6.method87(var5);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 233) {
                        var72 = Client.field409.readUnsignedByte() == 1;
                        if(var72) {
                           class5.field45 = class9.method117() - Client.field409.method2908();
                           class11.field123 = new class1(Client.field409, true);
                        } else {
                           class11.field123 = null;
                        }

                        Client.field476 = Client.field446;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 206) {
                        class116.method2218(false);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 164) {
                        var3 = Client.field409.method2780();
                        var4 = Client.field409.readUnsignedByte();
                        var25 = Client.field409.readUnsignedShort();
                        var91 = (WidgetNode)Client.componentTable.method2339((long)var3);
                        if(var91 != null) {
                           class3.method31(var91, var25 != var91.id);
                        }

                        class20.method194(var3, var25, var4);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 58) {
                        for(var3 = 0; var3 < Client.cachedPlayers.length; ++var3) {
                           if(Client.cachedPlayers[var3] != null) {
                              Client.cachedPlayers[var3].animation = -1;
                           }
                        }

                        for(var3 = 0; var3 < Client.cachedNPCs.length; ++var3) {
                           if(null != Client.cachedNPCs[var3]) {
                              Client.cachedNPCs[var3].animation = -1;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 45) {
                        var3 = Client.field409.readUnsignedShort();
                        if(var3 == '\uffff') {
                           var3 = -1;
                        }

                        var4 = Client.field409.method2819();
                        var25 = Client.field409.method2936();
                        var6 = Client.field409.method2922();
                        if(var6 == '\uffff') {
                           var6 = -1;
                        }

                        for(var7 = var3; var7 <= var6; ++var7) {
                           var64 = ((long)var4 << 32) + (long)var7;
                           Node var126 = Client.widgetFlags.method2339(var64);
                           if(null != var126) {
                              var126.unlink();
                           }

                           Client.widgetFlags.method2340(new class133(var25), var64);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     long var57;
                     if(Client.packetOpcode == 92) {
                        var24 = Client.field409.method2965();
                        var61 = (long)Client.field409.readUnsignedShort();
                        var57 = (long)Client.field409.read24BitInt();
                        class177 var94 = (class177)class181.method3258(class22.method211(), Client.field409.readUnsignedByte());
                        long var9 = (var61 << 32) + var57;
                        boolean var124 = false;

                        for(var12 = 0; var12 < 100; ++var12) {
                           if(Client.field501[var12] == var9) {
                              var124 = true;
                              break;
                           }
                        }

                        if(class164.method3115(var24)) {
                           var124 = true;
                        }

                        if(!var124 && Client.field402 == 0) {
                           Client.field501[Client.field432] = var9;
                           Client.field432 = (1 + Client.field432) % 100;
                           class159 var13 = Client.field409;

                           String var32;
                           try {
                              var15 = var13.method2963();
                              if(var15 > 32767) {
                                 var15 = 32767;
                              }

                              byte[] var82 = new byte[var15];
                              var13.offset += class210.field3106.method2706(var13.payload, var13.offset, var82, 0, var15);
                              String var17 = class183.method3346(var82, 0, var15);
                              var32 = var17;
                           } catch (Exception var43) {
                              var32 = "Cabbage";
                           }

                           var32 = class209.method3866(Client.method589(var32));
                           byte var79;
                           if(var94.field2649) {
                              var79 = 7;
                           } else {
                              var79 = 3;
                           }

                           if(var94.field2641 != -1) {
                              class7.method99(var79, class109.method2012(var94.field2641) + var24, var32);
                           } else {
                              class7.method99(var79, var24, var32);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 103) {
                        class32.xteaChanged(true);
                        Client.field409.method3030();
                        var3 = Client.field409.readUnsignedShort();
                        class39.method735(Client.field409, var3);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 188) {
                        while(Client.field409.offset < Client.field328) {
                           var3 = Client.field409.readUnsignedByte();
                           var66 = (var3 & 1) == 1;
                           var58 = Client.field409.method2965();
                           String var90 = Client.field409.method2965();
                           Client.field409.method2965();

                           for(var7 = 0; var7 < Client.ignoreCount; ++var7) {
                              Ignore var28 = Client.ignores[var7];
                              if(var66) {
                                 if(var90.equals(var28.name)) {
                                    var28.name = var58;
                                    var28.previousName = var90;
                                    var58 = null;
                                    break;
                                 }
                              } else if(var58.equals(var28.name)) {
                                 var28.name = var58;
                                 var28.previousName = var90;
                                 var58 = null;
                                 break;
                              }
                           }

                           if(var58 != null && Client.ignoreCount < 400) {
                              Ignore var107 = new Ignore();
                              Client.ignores[Client.ignoreCount] = var107;
                              var107.name = var58;
                              var107.previousName = var90;
                              ++Client.ignoreCount;
                           }
                        }

                        Client.field460 = Client.field446;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 116) {
                        var3 = Client.field409.method2820();
                        var4 = Client.field409.method2762();
                        var5 = class44.method799(var3);
                        if(var5.modelType != 2 || var4 != var5.modelId) {
                           var5.modelType = 2;
                           var5.modelId = var4;
                           class6.method87(var5);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 229) {
                        var3 = Client.field409.readUnsignedByte();
                        var4 = Client.field409.readUnsignedByte();
                        var25 = Client.field409.readUnsignedByte();
                        var6 = Client.field409.readUnsignedByte();
                        Client.field493[var3] = true;
                        Client.field368[var3] = var4;
                        Client.field532[var3] = var25;
                        Client.field315[var3] = var6;
                        Client.field510[var3] = 0;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 135) {
                        var3 = Client.field409.method2936();
                        var4 = Client.field409.method2953();
                        var5 = class44.method799(var3);
                        if(var5.field2250 != var4 || var4 == -1) {
                           var5.field2250 = var4;
                           var5.field2215 = 0;
                           var5.field2308 = 0;
                           class6.method87(var5);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 107) {
                        var3 = Client.field409.method2819();
                        class72.field1175 = class44.field881.method1926(var3);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 242) {
                        class22.field234 = Client.field409.method2803();
                        class25.field580 = Client.field409.method2803();
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 209) {
                        var24 = Client.field409.method2965();
                        var61 = Client.field409.method2908();
                        var57 = (long)Client.field409.readUnsignedShort();
                        var64 = (long)Client.field409.read24BitInt();
                        class177 var36 = (class177)class181.method3258(class22.method211(), Client.field409.readUnsignedByte());
                        var34 = var64 + (var57 << 32);
                        var35 = false;

                        for(var14 = 0; var14 < 100; ++var14) {
                           if(var34 == Client.field501[var14]) {
                              var35 = true;
                              break;
                           }
                        }

                        if(var36.field2648 && class164.method3115(var24)) {
                           var35 = true;
                        }

                        if(!var35 && Client.field402 == 0) {
                           Client.field501[Client.field432] = var34;
                           Client.field432 = (1 + Client.field432) % 100;
                           class159 var33 = Client.field409;

                           String var16;
                           try {
                              int var37 = var33.method2963();
                              if(var37 > 32767) {
                                 var37 = 32767;
                              }

                              byte[] var38 = new byte[var37];
                              var33.offset += class210.field3106.method2706(var33.payload, var33.offset, var38, 0, var37);
                              String var19 = class183.method3346(var38, 0, var37);
                              var16 = var19;
                           } catch (Exception var42) {
                              var16 = "Cabbage";
                           }

                           var16 = class209.method3866(Client.method589(var16));
                           if(var36.field2641 != -1) {
                              class207.addChatMessage(9, class109.method2012(var36.field2641) + var24, var16, class174.method3238(var61));
                           } else {
                              class207.addChatMessage(9, var24, var16, class174.method3238(var61));
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 88) {
                        class116.method2218(true);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 34) {
                        var3 = Client.field409.method2819();
                        var4 = Client.field409.method2779();
                        var25 = var4 >> 10 & 31;
                        var6 = var4 >> 5 & 31;
                        var7 = var4 & 31;
                        var8 = (var7 << 3) + (var6 << 11) + (var25 << 19);
                        Widget var30 = class44.method799(var3);
                        if(var30.textColor != var8) {
                           var30.textColor = var8;
                           class6.method87(var30);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 147) {
                        var3 = Client.field409.readUnsignedShort();
                        var4 = Client.field409.readUnsignedByte();
                        var25 = Client.field409.readUnsignedShort();
                        class119.method2275(var3, var4, var25);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 232) {
                        var3 = Client.field409.readUnsignedByte();
                        if(Client.field409.readUnsignedByte() == 0) {
                           Client.grandExchangeOffers[var3] = new XGrandExchangeOffer();
                           Client.field409.offset += 18;
                        } else {
                           --Client.field409.offset;
                           Client.grandExchangeOffers[var3] = new XGrandExchangeOffer(Client.field409, false);
                        }

                        Client.field549 = Client.field446;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 235) {
                        var3 = Client.field409.method2779();
                        var4 = Client.field409.method2922();
                        var25 = Client.field409.method2819();
                        var27 = class44.method799(var25);
                        var27.field2241 = var3 + (var4 << 16);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 150) {
                        Client.field465 = 1;
                        Client.field460 = Client.field446;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 239) {
                        Client.field529 = false;

                        for(var3 = 0; var3 < 5; ++var3) {
                           Client.field493[var3] = false;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 222) {
                        World var85 = new World();
                        var85.address = Client.field409.method2965();
                        var85.id = Client.field409.readUnsignedShort();
                        var4 = Client.field409.method2780();
                        var85.mask = var4;
                        Friend.setGameState(45);
                        class37.field774.method2026();
                        class37.field774 = null;
                        class139.selectWorld(var85);
                        Client.packetOpcode = -1;
                        var1 = false;
                        break label3099;
                     }

                     if(Client.packetOpcode == 205) {
                        var3 = Client.field409.method2780();
                        var4 = Client.field409.readUnsignedShort();
                        if(var3 < -70000) {
                           var4 += '耀';
                        }

                        if(var3 >= 0) {
                           var5 = class44.method799(var3);
                        } else {
                           var5 = null;
                        }

                        for(; Client.field409.offset < Client.field328; class0.method1(var4, var6, var7 - 1, var8)) {
                           var6 = Client.field409.method2963();
                           var7 = Client.field409.readUnsignedShort();
                           var8 = 0;
                           if(var7 != 0) {
                              var8 = Client.field409.readUnsignedByte();
                              if(var8 == 255) {
                                 var8 = Client.field409.method2780();
                              }
                           }

                           if(var5 != null && var6 >= 0 && var6 < var5.itemIds.length) {
                              var5.itemIds[var6] = var7;
                              var5.itemQuantities[var6] = var8;
                           }
                        }

                        if(null != var5) {
                           class6.method87(var5);
                        }

                        class33.method695();
                        Client.field471[++Client.field469 - 1 & 31] = var4 & 32767;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 65) {
                        class39.method735(Client.field409, Client.field328);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 165) {
                        var24 = Client.field409.method2965();
                        var4 = Client.field409.method2820();
                        var5 = class44.method799(var4);
                        if(!var24.equals(var5.text)) {
                           var5.text = var24;
                           class6.method87(var5);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 142) {
                        var3 = Client.field409.method2936();
                        var87 = class44.method799(var3);
                        var87.modelType = 3;
                        var87.modelId = class148.localPlayer.composition.method3125();
                        class6.method87(var87);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 151) {
                        Client.field498 = Client.field409.readUnsignedByte();
                        Client.field499 = Client.field409.readUnsignedByte();
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 221) {
                        for(var3 = 0; var3 < class187.field2750; ++var3) {
                           class187 var26 = class30.method674(var3);
                           if(var26 != null) {
                              class165.settings[var3] = 0;
                              class165.widgetSettings[var3] = 0;
                           }
                        }

                        class33.method695();
                        Client.field467 += 32;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 37) {
                        class33.method695();
                        Client.energy = Client.field409.readUnsignedByte();
                        Client.field477 = Client.field446;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 67) {
                        var3 = Client.field409.method2780();
                        var4 = Client.field409.readUnsignedShort();
                        if(var4 == '\uffff') {
                           var4 = -1;
                        }

                        var25 = Client.field409.method2780();
                        var27 = class44.method799(var3);
                        ItemComposition var100;
                        if(!var27.field2184) {
                           if(var4 == -1) {
                              var27.modelType = 0;
                              Client.packetOpcode = -1;
                              var1 = true;
                              break label3099;
                           }

                           var100 = class88.getItemDefinition(var4);
                           var27.modelType = 4;
                           var27.modelId = var4;
                           var27.rotationX = var100.field2949;
                           var27.rotationZ = var100.field2937;
                           var27.field2239 = var100.field2948 * 100 / var25;
                           class6.method87(var27);
                        } else {
                           var27.item = var4;
                           var27.stackSize = var25;
                           var100 = class88.getItemDefinition(var4);
                           var27.rotationX = var100.field2949;
                           var27.rotationZ = var100.field2937;
                           var27.rotationY = var100.field2951;
                           var27.field2234 = var100.field2952;
                           var27.field2178 = var100.field2953;
                           var27.field2239 = var100.field2948;
                           if(var100.isStackable == 1) {
                              var27.field2244 = 1;
                           } else {
                              var27.field2244 = 2;
                           }

                           if(var27.field2231 > 0) {
                              var27.field2239 = var27.field2239 * 32 / var27.field2231;
                           } else if(var27.field2237 > 0) {
                              var27.field2239 = var27.field2239 * 32 / var27.field2237;
                           }

                           class6.method87(var27);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 53) {
                        class22.field234 = Client.field409.method2802();
                        class25.field580 = Client.field409.method2803();

                        while(Client.field409.offset < Client.field328) {
                           Client.packetOpcode = Client.field409.readUnsignedByte();
                           class101.method1910();
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     if(Client.packetOpcode == 101) {
                        var3 = Client.field409.method2820();
                        var4 = Client.field409.method2779();
                        var25 = Client.field409.method2922();
                        var6 = Client.field409.method2779();
                        var29 = class44.method799(var3);
                        if(var29.rotationX != var6 || var29.rotationZ != var4 || var29.field2239 != var25) {
                           var29.rotationX = var6;
                           var29.rotationZ = var4;
                           var29.field2239 = var25;
                           class6.method87(var29);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3099;
                     }

                     class174.method3240("" + Client.packetOpcode + "," + Client.field334 + "," + Client.field335 + "," + Client.field328, (Throwable)null);
                     class11.method150();
                  } catch (IOException var53) {
                     Frames.method1851();
                  } catch (Exception var54) {
                     var24 = "" + Client.packetOpcode + "," + Client.field334 + "," + Client.field335 + "," + Client.field328 + "," + (class148.localPlayer.pathX[0] + FrameMap.baseX) + "," + (class148.localPlayer.pathY[0] + XItemContainer.baseY) + ",";

                     for(var4 = 0; var4 < Client.field328 && var4 < 50; ++var4) {
                        var24 = var24 + Client.field409.payload[var4] + ",";
                     }

                     class174.method3240(var24, var54);
                     class11.method150();
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
               ClassInfo var40 = (ClassInfo)class227.field3228.method2358();
               boolean var55;
               if(var40 == null) {
                  var55 = false;
               } else {
                  var55 = true;
               }

               int var103;
               if(!var55) {
                  Object var41 = class191.field2796.field213;
                  synchronized(class191.field2796.field213) {
                     if(!Client.field280) {
                        class191.field2796.field214 = 0;
                     } else if(class115.field1794 != 0 || class191.field2796.field214 >= 40) {
                        Client.field326.method3029(218);
                        Client.field326.method2760(0);
                        var103 = Client.field326.offset;
                        var2 = 0;

                        for(var3 = 0; var3 < class191.field2796.field214 && Client.field326.offset - var103 < 240; ++var3) {
                           ++var2;
                           var4 = class191.field2796.field216[var3];
                           if(var4 < 0) {
                              var4 = 0;
                           } else if(var4 > 502) {
                              var4 = 502;
                           }

                           var25 = class191.field2796.field215[var3];
                           if(var25 < 0) {
                              var25 = 0;
                           } else if(var25 > 764) {
                              var25 = 764;
                           }

                           var6 = var25 + var4 * 765;
                           if(class191.field2796.field216[var3] == -1 && class191.field2796.field215[var3] == -1) {
                              var25 = -1;
                              var4 = -1;
                              var6 = 524287;
                           }

                           if(var25 == Client.field339 && Client.field293 == var4) {
                              if(Client.field294 < 2047) {
                                 ++Client.field294;
                              }
                           } else {
                              var7 = var25 - Client.field339;
                              Client.field339 = var25;
                              var8 = var4 - Client.field293;
                              Client.field293 = var4;
                              if(Client.field294 < 8 && var7 >= -32 && var7 <= 31 && var8 >= -32 && var8 <= 31) {
                                 var7 += 32;
                                 var8 += 32;
                                 Client.field326.method2918(var8 + (Client.field294 << 12) + (var7 << 6));
                                 Client.field294 = 0;
                              } else if(Client.field294 < 8) {
                                 Client.field326.method2914(8388608 + (Client.field294 << 19) + var6);
                                 Client.field294 = 0;
                              } else {
                                 Client.field326.method2763(-1073741824 + (Client.field294 << 19) + var6);
                                 Client.field294 = 0;
                              }
                           }
                        }

                        Client.field326.method2772(Client.field326.offset - var103);
                        if(var2 >= class191.field2796.field214) {
                           class191.field2796.field214 = 0;
                        } else {
                           class191.field2796.field214 -= var2;

                           for(var3 = 0; var3 < class191.field2796.field214; ++var3) {
                              class191.field2796.field215[var3] = class191.field2796.field215[var3 + var2];
                              class191.field2796.field216[var3] = class191.field2796.field216[var3 + var2];
                           }
                        }
                     }
                  }

                  if(class115.field1794 == 1 || !GroundObject.field1297 && class115.field1794 == 4 || class115.field1794 == 2) {
                     long var56 = (class115.field1797 - Client.field291) / 50L;
                     if(var56 > 4095L) {
                        var56 = 4095L;
                     }

                     Client.field291 = class115.field1797;
                     var2 = class115.field1796;
                     if(var2 < 0) {
                        var2 = 0;
                     } else if(var2 > class65.field1099) {
                        var2 = class65.field1099;
                     }

                     var3 = class115.field1791;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > class0.field1) {
                        var3 = class0.field1;
                     }

                     var4 = (int)var56;
                     Client.field326.method3029(19);
                     Client.field326.method2918((class115.field1794 == 2?1:0) + (var4 << 1));
                     Client.field326.method2918(var3);
                     Client.field326.method2918(var2);
                  }

                  if(class105.field1710 > 0) {
                     Client.field326.method3029(88);
                     Client.field326.method2918(0);
                     var0 = Client.field326.offset;
                     long var110 = class9.method117();

                     for(var3 = 0; var3 < class105.field1710; ++var3) {
                        var61 = var110 - Client.field506;
                        if(var61 > 16777215L) {
                           var61 = 16777215L;
                        }

                        Client.field506 = var110;
                        Client.field326.method2816((int)var61);
                        Client.field326.method2800(class105.field1706[var3]);
                     }

                     Client.field326.method2771(Client.field326.offset - var0);
                  }

                  if(Client.field373 > 0) {
                     --Client.field373;
                  }

                  if(class105.field1700[96] || class105.field1700[97] || class105.field1700[98] || class105.field1700[99]) {
                     Client.field515 = true;
                  }

                  if(Client.field515 && Client.field373 <= 0) {
                     Client.field373 = 20;
                     Client.field515 = false;
                     Client.field326.method3029(242);
                     Client.field326.method2809(Client.mapAngle);
                     Client.field326.method2918(Client.field520);
                  }

                  if(class20.field219 && !Client.field295) {
                     Client.field295 = true;
                     Client.field326.method3029(42);
                     Client.field326.method2760(1);
                  }

                  if(!class20.field219 && Client.field295) {
                     Client.field295 = false;
                     Client.field326.method3029(42);
                     Client.field326.method2760(0);
                  }

                  if(Client.field359 != class60.plane) {
                     Client.field359 = class60.plane;
                     class99.method1897(class60.plane);
                  }

                  if(Client.gameState != 30) {
                     return;
                  }

                  class190.method3448();
                  class119.method2278();
                  ++Client.field308;
                  if(Client.field308 > 750) {
                     if(Client.field336 > 0) {
                        class11.method150();
                     } else {
                        Friend.setGameState(40);
                        class101.field1643 = class37.field774;
                        class37.field774 = null;
                     }

                     return;
                  }

                  var0 = class45.field888;
                  int[] var129 = class45.field892;

                  for(var2 = 0; var2 < var0; ++var2) {
                     Player var108 = Client.cachedPlayers[var129[var2]];
                     if(var108 != null) {
                        class31.method680(var108, 1);
                     }
                  }

                  class103.method1936();
                  int[] var132 = class45.field892;

                  for(var103 = 0; var103 < class45.field888; ++var103) {
                     Player var39 = Client.cachedPlayers[var132[var103]];
                     if(null != var39 && var39.field615 > 0) {
                        --var39.field615;
                        if(var39.field615 == 0) {
                           var39.overhead = null;
                        }
                     }
                  }

                  for(var103 = 0; var103 < Client.field322; ++var103) {
                     var2 = Client.field483[var103];
                     NPC var112 = Client.cachedNPCs[var2];
                     if(null != var112 && var112.field615 > 0) {
                        --var112.field615;
                        if(var112.field615 == 0) {
                           var112.overhead = null;
                        }
                     }
                  }

                  ++Client.field462;
                  if(Client.field393 != 0) {
                     Client.field392 += 20;
                     if(Client.field392 >= 400) {
                        Client.field393 = 0;
                     }
                  }

                  if(null != PlayerComposition.field2164) {
                     ++Client.field531;
                     if(Client.field531 >= 15) {
                        class6.method87(PlayerComposition.field2164);
                        PlayerComposition.field2164 = null;
                     }
                  }

                  Widget var133 = class188.field2758;
                  Widget var130 = Player.field241;
                  class188.field2758 = null;
                  Player.field241 = null;
                  Client.field457 = null;
                  Client.field525 = false;
                  Client.field458 = false;
                  Client.field503 = 0;

                  while(class196.method3554() && Client.field503 < 128) {
                     if(Client.field352 >= 2 && class105.field1700[82] && class162.field2134 == 66) {
                        String var127 = class25.method594();
                        class160.field2118.setContents(new StringSelection(var127), (ClipboardOwner)null);
                     } else {
                        Client.field505[Client.field503] = class162.field2134;
                        Client.field504[Client.field503] = class175.field2631;
                        ++Client.field503;
                     }
                  }

                  if(Client.widgetRoot != -1) {
                     class183.method3352(Client.widgetRoot, 0, 0, class0.field1, class65.field1099, 0, 0);
                  }

                  ++Client.field446;

                  while(true) {
                     Widget var113;
                     class18 var128;
                     do {
                        var128 = (class18)Client.field480.method2389();
                        if(var128 == null) {
                           while(true) {
                              do {
                                 var128 = (class18)Client.field325.method2389();
                                 if(null == var128) {
                                    while(true) {
                                       do {
                                          var128 = (class18)Client.field479.method2389();
                                          if(var128 == null) {
                                             class94.method1869();
                                             if(Client.field453 != null) {
                                                class6.method87(Client.field453);
                                                ++class94.field1581;
                                                if(Client.field525 && Client.field458) {
                                                   var2 = class115.field1788;
                                                   var3 = class115.field1789;
                                                   var2 -= Client.field455;
                                                   var3 -= Client.field550;
                                                   if(var2 < Client.field490) {
                                                      var2 = Client.field490;
                                                   }

                                                   if(Client.field453.width + var2 > Client.field454.width + Client.field490) {
                                                      var2 = Client.field490 + Client.field454.width - Client.field453.width;
                                                   }

                                                   if(var3 < Client.field284) {
                                                      var3 = Client.field284;
                                                   }

                                                   if(Client.field453.height + var3 > Client.field284 + Client.field454.height) {
                                                      var3 = Client.field454.height + Client.field284 - Client.field453.height;
                                                   }

                                                   var4 = var2 - Client.field509;
                                                   var25 = var3 - Client.field463;
                                                   var6 = Client.field453.field2261;
                                                   if(class94.field1581 > Client.field453.field2262 && (var4 > var6 || var4 < -var6 || var25 > var6 || var25 < -var6)) {
                                                      Client.field464 = true;
                                                   }

                                                   var7 = var2 - Client.field490 + Client.field454.scrollX;
                                                   var8 = Client.field454.scrollY + (var3 - Client.field284);
                                                   class18 var120;
                                                   if(null != Client.field453.field2274 && Client.field464) {
                                                      var120 = new class18();
                                                      var120.field195 = Client.field453;
                                                      var120.field191 = var7;
                                                      var120.field190 = var8;
                                                      var120.field203 = Client.field453.field2274;
                                                      class49.method871(var120, 200000);
                                                   }

                                                   if(class115.field1787 == 0) {
                                                      if(Client.field464) {
                                                         if(Client.field453.field2275 != null) {
                                                            var120 = new class18();
                                                            var120.field195 = Client.field453;
                                                            var120.field191 = var7;
                                                            var120.field190 = var8;
                                                            var120.field194 = Client.field457;
                                                            var120.field203 = Client.field453.field2275;
                                                            class49.method871(var120, 200000);
                                                         }

                                                         if(Client.field457 != null && class140.method2605(Client.field453) != null) {
                                                            Client.field326.method3029(224);
                                                            Client.field326.method2809(Client.field453.index);
                                                            Client.field326.method2818(Client.field453.id);
                                                            Client.field326.method2818(Client.field457.id);
                                                            Client.field326.method2918(Client.field453.item);
                                                            Client.field326.method2809(Client.field457.index);
                                                            Client.field326.method2918(Client.field457.item);
                                                         }
                                                      } else if((Client.field303 == 1 || class5.method78(Client.menuOptionCount - 1)) && Client.menuOptionCount > 2) {
                                                         ChatLineBuffer.method874(Client.field455 + Client.field509, Client.field550 + Client.field463);
                                                      } else if(Client.menuOptionCount > 0) {
                                                         class114.method2162(Client.field455 + Client.field509, Client.field550 + Client.field463);
                                                      }

                                                      Client.field453 = null;
                                                   }
                                                } else if(class94.field1581 > 1) {
                                                   Client.field453 = null;
                                                }
                                             }

                                             if(null != class31.field715) {
                                                class6.method87(class31.field715);
                                                ++Client.field401;
                                                if(class115.field1787 == 0) {
                                                   if(Client.field400) {
                                                      if(class13.field144 == class31.field715 && Client.field399 != Client.field396) {
                                                         Widget var131 = class31.field715;
                                                         byte var106 = 0;
                                                         if(Client.field558 == 1 && var131.contentType == 206) {
                                                            var106 = 1;
                                                         }

                                                         if(var131.itemIds[Client.field399] <= 0) {
                                                            var106 = 0;
                                                         }

                                                         var25 = GameObject.method1872(var131);
                                                         var66 = (var25 >> 29 & 1) != 0;
                                                         if(var66) {
                                                            var6 = Client.field396;
                                                            var7 = Client.field399;
                                                            var131.itemIds[var7] = var131.itemIds[var6];
                                                            var131.itemQuantities[var7] = var131.itemQuantities[var6];
                                                            var131.itemIds[var6] = -1;
                                                            var131.itemQuantities[var6] = 0;
                                                         } else if(var106 == 1) {
                                                            var6 = Client.field396;
                                                            var7 = Client.field399;

                                                            while(var6 != var7) {
                                                               if(var6 > var7) {
                                                                  var131.method3163(var6 - 1, var6);
                                                                  --var6;
                                                               } else if(var6 < var7) {
                                                                  var131.method3163(var6 + 1, var6);
                                                                  ++var6;
                                                               }
                                                            }
                                                         } else {
                                                            var131.method3163(Client.field399, Client.field396);
                                                         }

                                                         Client.field326.method3029(32);
                                                         Client.field326.method2807(Client.field396);
                                                         Client.field326.method2800(var106);
                                                         Client.field326.method2942(Client.field399);
                                                         Client.field326.method2763(class31.field715.id);
                                                      }
                                                   } else if((Client.field303 == 1 || class5.method78(Client.menuOptionCount - 1)) && Client.menuOptionCount > 2) {
                                                      ChatLineBuffer.method874(Client.field397, Client.field398);
                                                   } else if(Client.menuOptionCount > 0) {
                                                      class114.method2162(Client.field397, Client.field398);
                                                   }

                                                   Client.field531 = 10;
                                                   class115.field1794 = 0;
                                                   class31.field715 = null;
                                                } else if(Client.field401 >= 5 && (class115.field1788 > 5 + Client.field397 || class115.field1788 < Client.field397 - 5 || class115.field1789 > Client.field398 + 5 || class115.field1789 < Client.field398 - 5)) {
                                                   Client.field400 = true;
                                                }
                                             }

                                             if(Region.field1470 != -1) {
                                                var2 = Region.field1470;
                                                var3 = Region.field1504;
                                                Client.field326.method3029(164);
                                                Client.field326.method2760(5);
                                                Client.field326.method2800(class105.field1700[82]?(class105.field1700[81]?2:1):0);
                                                Client.field326.method2942(FrameMap.baseX + var2);
                                                Client.field326.method2809(var3 + XItemContainer.baseY);
                                                Region.field1470 = -1;
                                                Client.field390 = class115.field1791;
                                                Client.field391 = class115.field1796;
                                                Client.field393 = 1;
                                                Client.field392 = 0;
                                                Client.flagX = var2;
                                                Client.flagY = var3;
                                             }

                                             if(class188.field2758 != var133) {
                                                if(var133 != null) {
                                                   class6.method87(var133);
                                                }

                                                if(class188.field2758 != null) {
                                                   class6.method87(class188.field2758);
                                                }
                                             }

                                             if(var130 != Player.field241 && Client.field361 == Client.field431) {
                                                if(null != var130) {
                                                   class6.method87(var130);
                                                }

                                                if(Player.field241 != null) {
                                                   class6.method87(Player.field241);
                                                }
                                             }

                                             if(null != Player.field241) {
                                                if(Client.field431 < Client.field361) {
                                                   ++Client.field431;
                                                   if(Client.field361 == Client.field431) {
                                                      class6.method87(Player.field241);
                                                   }
                                                }
                                             } else if(Client.field431 > 0) {
                                                --Client.field431;
                                             }

                                             var2 = Client.field347 + class148.localPlayer.x;
                                             var3 = Client.field394 + class148.localPlayer.y;
                                             if(class22.field236 - var2 < -500 || class22.field236 - var2 > 500 || class152.field2068 - var3 < -500 || class152.field2068 - var3 > 500) {
                                                class22.field236 = var2;
                                                class152.field2068 = var3;
                                             }

                                             if(class22.field236 != var2) {
                                                class22.field236 += (var2 - class22.field236) / 16;
                                             }

                                             if(class152.field2068 != var3) {
                                                class152.field2068 += (var3 - class152.field2068) / 16;
                                             }

                                             if(class115.field1787 == 4 && GroundObject.field1297) {
                                                var4 = class115.field1789 - Client.field371;
                                                Client.field369 = var4 * 2;
                                                Client.field371 = var4 != -1 && var4 != 1?(class115.field1789 + Client.field371) / 2:class115.field1789;
                                                var25 = Client.field521 - class115.field1788;
                                                Client.field385 = var25 * 2;
                                                Client.field521 = var25 != -1 && var25 != 1?(Client.field521 + class115.field1788) / 2:class115.field1788;
                                             } else {
                                                if(class105.field1700[96]) {
                                                   Client.field385 += (-24 - Client.field385) / 2;
                                                } else if(class105.field1700[97]) {
                                                   Client.field385 += (24 - Client.field385) / 2;
                                                } else {
                                                   Client.field385 /= 2;
                                                }

                                                if(class105.field1700[98]) {
                                                   Client.field369 += (12 - Client.field369) / 2;
                                                } else if(class105.field1700[99]) {
                                                   Client.field369 += (-12 - Client.field369) / 2;
                                                } else {
                                                   Client.field369 /= 2;
                                                }

                                                Client.field371 = class115.field1789;
                                                Client.field521 = class115.field1788;
                                             }

                                             Client.mapAngle = Client.mapAngle + Client.field385 / 2 & 2047;
                                             Client.field520 += Client.field369 / 2;
                                             if(Client.field520 < 128) {
                                                Client.field520 = 128;
                                             }

                                             if(Client.field520 > 383) {
                                                Client.field520 = 383;
                                             }

                                             var4 = class22.field236 >> 7;
                                             var25 = class152.field2068 >> 7;
                                             var6 = class176.method3243(class22.field236, class152.field2068, class60.plane);
                                             var7 = 0;
                                             if(var4 > 3 && var25 > 3 && var4 < 100 && var25 < 100) {
                                                for(var8 = var4 - 4; var8 <= var4 + 4; ++var8) {
                                                   for(var60 = var25 - 4; var60 <= 4 + var25; ++var60) {
                                                      var10 = class60.plane;
                                                      if(var10 < 3 && (class10.tileSettings[1][var8][var60] & 2) == 2) {
                                                         ++var10;
                                                      }

                                                      var125 = var6 - class10.tileHeights[var10][var8][var60];
                                                      if(var125 > var7) {
                                                         var7 = var125;
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

                                             if(var8 > Client.field406) {
                                                Client.field406 += (var8 - Client.field406) / 24;
                                             } else if(var8 < Client.field406) {
                                                Client.field406 += (var8 - Client.field406) / 80;
                                             }

                                             if(Client.field529) {
                                                class6.method95();
                                             }

                                             for(var2 = 0; var2 < 5; ++var2) {
                                                ++Client.field510[var2];
                                             }

                                             Renderable.chatMessages.method829();
                                             var2 = class99.method1893();
                                             var3 = class105.keyboardIdleTicks;
                                             if(var2 > 15000 && var3 > 15000) {
                                                Client.field336 = 250;
                                                class115.mouseIdleTicks = 14500;
                                                Client.field326.method3029(76);
                                             }

                                             ++Client.field302;
                                             if(Client.field302 > 500) {
                                                Client.field302 = 0;
                                                var25 = (int)(Math.random() * 8.0D);
                                                if((var25 & 1) == 1) {
                                                   Client.field347 += Client.field348;
                                                }

                                                if((var25 & 2) == 2) {
                                                   Client.field394 += Client.field331;
                                                }

                                                if((var25 & 4) == 4) {
                                                   Client.field351 += Client.field353;
                                                }
                                             }

                                             if(Client.field347 < -50) {
                                                Client.field348 = 2;
                                             }

                                             if(Client.field347 > 50) {
                                                Client.field348 = -2;
                                             }

                                             if(Client.field394 < -55) {
                                                Client.field331 = 2;
                                             }

                                             if(Client.field394 > 55) {
                                                Client.field331 = -2;
                                             }

                                             if(Client.field351 < -40) {
                                                Client.field353 = 1;
                                             }

                                             if(Client.field351 > 40) {
                                                Client.field353 = -1;
                                             }

                                             ++Client.field473;
                                             if(Client.field473 > 500) {
                                                Client.field473 = 0;
                                                var25 = (int)(Math.random() * 8.0D);
                                                if((var25 & 1) == 1) {
                                                   Client.mapScale += Client.field355;
                                                }

                                                if((var25 & 2) == 2) {
                                                   Client.mapScaleDelta += Client.field357;
                                                }
                                             }

                                             if(Client.mapScale < -60) {
                                                Client.field355 = 2;
                                             }

                                             if(Client.mapScale > 60) {
                                                Client.field355 = -2;
                                             }

                                             if(Client.mapScaleDelta < -20) {
                                                Client.field357 = 1;
                                             }

                                             if(Client.mapScaleDelta > 10) {
                                                Client.field357 = -1;
                                             }

                                             for(class16 var78 = (class16)Client.field383.method2416(); var78 != null; var78 = (class16)Client.field383.method2419()) {
                                                if((long)var78.field180 < class9.method117() / 1000L - 5L) {
                                                   if(var78.field176 > 0) {
                                                      class7.method99(5, "", var78.field175 + " has logged in.");
                                                   }

                                                   if(var78.field176 == 0) {
                                                      class7.method99(5, "", var78.field175 + " has logged out.");
                                                   }

                                                   var78.method2431();
                                                }
                                             }

                                             ++Client.field332;
                                             if(Client.field332 > 50) {
                                                Client.field326.method3029(217);
                                             }

                                             try {
                                                if(null != class37.field774 && Client.field326.offset > 0) {
                                                   class37.field774.method2018(Client.field326.payload, 0, Client.field326.offset);
                                                   Client.field326.offset = 0;
                                                   Client.field332 = 0;
                                                }
                                             } catch (IOException var45) {
                                                if(Client.field336 > 0) {
                                                   class11.method150();
                                                } else {
                                                   Friend.setGameState(40);
                                                   class101.field1643 = class37.field774;
                                                   class37.field774 = null;
                                                }
                                             }

                                             return;
                                          }

                                          var113 = var128.field195;
                                          if(var113.index < 0) {
                                             break;
                                          }

                                          var87 = class44.method799(var113.parentId);
                                       } while(var87 == null || var87.children == null || var113.index >= var87.children.length || var113 != var87.children[var113.index]);

                                       class49.method871(var128, 200000);
                                    }
                                 }

                                 var113 = var128.field195;
                                 if(var113.index < 0) {
                                    break;
                                 }

                                 var87 = class44.method799(var113.parentId);
                              } while(null == var87 || null == var87.children || var113.index >= var87.children.length || var87.children[var113.index] != var113);

                              class49.method871(var128, 200000);
                           }
                        }

                        var113 = var128.field195;
                        if(var113.index < 0) {
                           break;
                        }

                        var87 = class44.method799(var113.parentId);
                     } while(null == var87 || var87.children == null || var113.index >= var87.children.length || var113 != var87.children[var113.index]);

                     class0.method8(var128);
                  }
               }

               Client.field326.method3029(227);
               Client.field326.method2760(0);
               var103 = Client.field326.offset;
               class22.method212(Client.field326);
               Client.field326.method2772(Client.field326.offset - var103);
            }
         }
      }
   }

   public class145(byte[] var1) {
      int var2 = var1.length;
      this.field1997 = new int[var2];
      this.field1996 = var1;
      int[] var3 = new int[33];
      this.field1999 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field1997[var5] = var8;
            int var9;
            int var10;
            int var11;
            int var12;
            if((var8 & var7) != 0) {
               var9 = var3[var6 - 1];
            } else {
               var9 = var8 | var7;

               for(var10 = var6 - 1; var10 >= 1; --var10) {
                  var11 = var3[var10];
                  if(var11 != var8) {
                     break;
                  }

                  var12 = 1 << 32 - var10;
                  if((var11 & var12) != 0) {
                     var3[var10] = var3[var10 - 1];
                     break;
                  }

                  var3[var10] = var11 | var12;
               }
            }

            var3[var6] = var9;

            for(var10 = 1 + var6; var10 <= 32; ++var10) {
               if(var8 == var3[var10]) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if((var8 & var12) != 0) {
                  if(this.field1999[var10] == 0) {
                     this.field1999[var10] = var4;
                  }

                  var10 = this.field1999[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field1999.length) {
                  int[] var13 = new int[this.field1999.length * 2];

                  for(int var14 = 0; var14 < this.field1999.length; ++var14) {
                     var13[var14] = this.field1999[var14];
                  }

                  this.field1999 = var13;
               }

               var12 >>>= 1;
            }

            this.field1999[var10] = ~var5;
            if(var10 >= var4) {
               var4 = 1 + var10;
            }
         }
      }

   }
}
