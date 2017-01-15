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
         int var1;
         int var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int var8;
         int var9;
         long var10;
         boolean var12;
         Widget var13;
         int var14;
         class18 var24;
         String var69;
         for(var0 = 0; var0 < 100; ++var0) {
            boolean var15;
            if(null == class37.field774) {
               var15 = false;
            } else {
               label2744: {
                  String var16;
                  try {
                     var1 = class37.field774.method2017();
                     if(var1 == 0) {
                        var15 = false;
                        break label2744;
                     }

                     if(Client.packetOpcode == -1) {
                        class37.field774.method2014(Client.field409.payload, 0, 1);
                        Client.field409.offset = 0;
                        Client.packetOpcode = Client.field409.method3030();
                        Client.field328 = class212.field3130[Client.packetOpcode];
                        --var1;
                     }

                     if(Client.field328 == -1) {
                        if(var1 <= 0) {
                           var15 = false;
                           break label2744;
                        }

                        class37.field774.method2014(Client.field409.payload, 0, 1);
                        Client.field328 = Client.field409.payload[0] & 255;
                        --var1;
                     }

                     if(Client.field328 == -2) {
                        if(var1 <= 1) {
                           var15 = false;
                           break label2744;
                        }

                        class37.field774.method2014(Client.field409.payload, 0, 2);
                        Client.field409.offset = 0;
                        Client.field328 = Client.field409.readUnsignedShort();
                        var1 -= 2;
                     }

                     if(var1 < Client.field328) {
                        var15 = false;
                        break label2744;
                     }

                     Client.field409.offset = 0;
                     class37.field774.method2014(Client.field409.payload, 0, Client.field328);
                     Client.field308 = 0;
                     Client.field335 = Client.field334;
                     Client.field334 = Client.field333 * -1;
                     Client.field333 = Client.packetOpcode * -1;
                     Widget var17;
                     boolean var18;
                     if(Client.packetOpcode == 250) {
                        var18 = Client.field409.method2804() == 1;
                        var3 = Client.field409.method2780();
                        var17 = class44.method799(var3);
                        if(var18 != var17.isHidden) {
                           var17.isHidden = var18;
                           class6.method87(var17);
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 172) {
                        var16 = Client.field409.method2965();
                        var3 = Client.field409.method2802();
                        var8 = Client.field409.readUnsignedByte();
                        if(var3 >= 1 && var3 <= 8) {
                           if(var16.equalsIgnoreCase("null")) {
                              var16 = null;
                           }

                           Client.field466[var3 - 1] = var16;
                           Client.field410[var3 - 1] = var8 == 0;
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 3) {
                        var2 = Client.field409.method2936();
                        var3 = Client.field409.readUnsignedShort();
                        class165.settings[var3] = var2;
                        if(var2 != class165.widgetSettings[var3]) {
                           class165.widgetSettings[var3] = var2;
                        }

                        CombatInfo2.method3532(var3);
                        Client.field287[++Client.field467 - 1 & 31] = var3;
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 158) {
                        class190.method3457();

                        for(var2 = 0; var2 < 2048; ++var2) {
                           Client.cachedPlayers[var2] = null;
                        }

                        CombatInfoListHolder.method712(Client.field409);
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 63) {
                        var2 = Client.field409.method2820();
                        var13 = class44.method799(var2);

                        for(var8 = 0; var8 < var13.itemIds.length; ++var8) {
                           var13.itemIds[var8] = -1;
                           var13.itemIds[var8] = 0;
                        }

                        class6.method87(var13);
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 189) {
                        var2 = Client.field409.method2922();
                        Client.widgetRoot = var2;
                        XGrandExchangeOffer.method64(Client.widgetRoot, class0.field1, class65.field1099, false);
                        class157.method3024(var2);
                        class18.method186(Client.widgetRoot);

                        for(var3 = 0; var3 < 100; ++var3) {
                           Client.field485[var3] = true;
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
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
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 55) {
                        Client.field529 = true;
                        ChatLineBuffer.field960 = Client.field409.readUnsignedByte();
                        class2.field20 = Client.field409.readUnsignedByte();
                        class152.field2061 = Client.field409.readUnsignedShort();
                        class60.field1079 = Client.field409.readUnsignedByte();
                        class47.field925 = Client.field409.readUnsignedByte();
                        if(class47.field925 >= 100) {
                           var2 = ChatLineBuffer.field960 * 128 + 64;
                           var3 = 64 + class2.field20 * 128;
                           var8 = class176.method3243(var2, var3, class60.plane) - class152.field2061;
                           var4 = var2 - class36.cameraX;
                           var5 = var8 - class36.cameraZ;
                           var6 = var3 - GroundObject.cameraY;
                           var9 = (int)Math.sqrt((double)(var6 * var6 + var4 * var4));
                           class165.cameraPitch = (int)(Math.atan2((double)var5, (double)var9) * 325.949D) & 2047;
                           XClanMember.cameraYaw = (int)(Math.atan2((double)var4, (double)var6) * -325.949D) & 2047;
                           if(class165.cameraPitch < 128) {
                              class165.cameraPitch = 128;
                           }

                           if(class165.cameraPitch > 383) {
                              class165.cameraPitch = 383;
                           }
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     Widget var19;
                     if(Client.packetOpcode == 167) {
                        var2 = Client.field409.method2953();
                        var3 = Client.field409.method2968();
                        var8 = Client.field409.method2819();
                        var19 = class44.method799(var8);
                        if(var19.field2194 != var3 || var19.field2195 != var2 || var19.field2230 != 0 || var19.field2191 != 0) {
                           var19.field2194 = var3;
                           var19.field2195 = var2;
                           var19.field2230 = 0;
                           var19.field2191 = 0;
                           class6.method87(var19);
                           XItemContainer.method166(var19);
                           if(var19.type == 0) {
                              class6.method97(Widget.widgets[var8 >> 16], var19, false);
                           }
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 30) {
                        var3 = Client.field409.readUnsignedByte();
                        class216[] var64 = new class216[]{class216.field3162, class216.field3165, class216.field3163};
                        class216[] var76 = var64;
                        var5 = 0;

                        class216 var72;
                        while(true) {
                           if(var5 >= var76.length) {
                              var72 = null;
                              break;
                           }

                           class216 var73 = var76[var5];
                           if(var73.field3161 == var3) {
                              var72 = var73;
                              break;
                           }

                           ++var5;
                        }

                        FrameMap.field1467 = var72;
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     boolean var20;
                     boolean var21;
                     if(Client.packetOpcode == 13) {
                        var16 = Client.field409.method2965();
                        var3 = Client.field409.readUnsignedShort();
                        byte var70 = Client.field409.readByte();
                        var21 = false;
                        if(var70 == -128) {
                           var21 = true;
                        }

                        if(var21) {
                           if(class142.field1984 == 0) {
                              Client.packetOpcode = -1;
                              var15 = true;
                              break label2744;
                           }

                           var20 = false;

                           for(var5 = 0; var5 < class142.field1984 && (!class30.clanMembers[var5].username.equals(var16) || class30.clanMembers[var5].world != var3); ++var5) {
                              ;
                           }

                           if(var5 < class142.field1984) {
                              while(var5 < class142.field1984 - 1) {
                                 class30.clanMembers[var5] = class30.clanMembers[1 + var5];
                                 ++var5;
                              }

                              --class142.field1984;
                              class30.clanMembers[class142.field1984] = null;
                           }
                        } else {
                           Client.field409.method2965();
                           XClanMember var71 = new XClanMember();
                           var71.username = var16;
                           var71.field271 = class139.method2601(var71.username, Ignore.field209);
                           var71.world = var3;
                           var71.rank = var70;

                           for(var6 = class142.field1984 - 1; var6 >= 0; --var6) {
                              var9 = class30.clanMembers[var6].field271.compareTo(var71.field271);
                              if(var9 == 0) {
                                 class30.clanMembers[var6].world = var3;
                                 class30.clanMembers[var6].rank = var70;
                                 if(var16.equals(class148.localPlayer.name)) {
                                    class118.field1831 = var70;
                                 }

                                 Client.field474 = Client.field446;
                                 Client.packetOpcode = -1;
                                 var15 = true;
                                 break label2744;
                              }

                              if(var9 < 0) {
                                 break;
                              }
                           }

                           if(class142.field1984 >= class30.clanMembers.length) {
                              Client.packetOpcode = -1;
                              var15 = true;
                              break label2744;
                           }

                           for(var9 = class142.field1984 - 1; var9 > var6; --var9) {
                              class30.clanMembers[var9 + 1] = class30.clanMembers[var9];
                           }

                           if(class142.field1984 == 0) {
                              class30.clanMembers = new XClanMember[100];
                           }

                           class30.clanMembers[var6 + 1] = var71;
                           ++class142.field1984;
                           if(var16.equals(class148.localPlayer.name)) {
                              class118.field1831 = var70;
                           }
                        }

                        Client.field474 = Client.field446;
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     String var22;
                     if(Client.packetOpcode == 143) {
                        var2 = Client.field409.method2963();
                        var12 = Client.field409.readUnsignedByte() == 1;
                        var22 = "";
                        var21 = false;
                        if(var12) {
                           var22 = Client.field409.method2965();
                           if(class164.method3115(var22)) {
                              var21 = true;
                           }
                        }

                        var69 = Client.field409.method2965();
                        if(!var21) {
                           class7.method99(var2, var22, var69);
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
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
                        var15 = true;
                        break label2744;
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
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 180) {
                        class103.method1935(Client.field409.method2965());
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 36) {
                        var16 = Client.field409.method2965();
                        Object[] var68 = new Object[var16.length() + 1];

                        for(var8 = var16.length() - 1; var8 >= 0; --var8) {
                           if(var16.charAt(var8) == 115) {
                              var68[var8 + 1] = Client.field409.method2965();
                           } else {
                              var68[var8 + 1] = new Integer(Client.field409.method2780());
                           }
                        }

                        var68[0] = new Integer(Client.field409.method2780());
                        var24 = new class18();
                        var24.field203 = var68;
                        class49.method871(var24, 200000);
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 249) {
                        if(Client.widgetRoot != -1) {
                           var2 = Client.widgetRoot;
                           if(class94.method1870(var2)) {
                              class140.method2607(Widget.widgets[var2], 0);
                           }
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     long var23;
                     if(Client.packetOpcode == 61) {
                        var2 = Client.field409.method2780();
                        var3 = Client.field409.method2780();
                        if(class8.field77 == null || !class8.field77.isValid()) {
                           try {
                              Iterator var74 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                              while(var74.hasNext()) {
                                 GarbageCollectorMXBean var87 = (GarbageCollectorMXBean)var74.next();
                                 if(var87.isValid()) {
                                    class8.field77 = var87;
                                    Client.field559 = -1L;
                                    Client.field366 = -1L;
                                 }
                              }
                           } catch (Throwable var56) {
                              ;
                           }
                        }

                        long var78 = class9.method117();
                        var5 = -1;
                        if(class8.field77 != null) {
                           var23 = class8.field77.getCollectionTime();
                           if(Client.field366 != -1L) {
                              long var88 = var23 - Client.field366;
                              long var90 = var78 - Client.field559;
                              if(var90 != 0L) {
                                 var5 = (int)(var88 * 100L / var90);
                              }
                           }

                           Client.field366 = var23;
                           Client.field559 = var78;
                        }

                        Client.field326.method3029(47);
                        Client.field326.method2800(GameEngine.field1763);
                        Client.field326.method2817(var2);
                        Client.field326.method2818(var3);
                        Client.field326.method2801(var5);
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 184) {
                        class33.method695();
                        Client.weight = Client.field409.method2968();
                        Client.field477 = Client.field446;
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 78) {
                        class32.xteaChanged(false);
                        Client.field409.method3030();
                        var2 = Client.field409.readUnsignedShort();
                        class39.method735(Client.field409, var2);
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 62) {
                        var2 = Client.field409.method2922();
                        class171.method3233(var2);
                        Client.field471[++Client.field469 - 1 & 31] = var2 & 32767;
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     class159 var25;
                     if(Client.packetOpcode == 32) {
                        Client.field409.offset += 28;
                        if(Client.field409.method2855()) {
                           var25 = Client.field409;
                           var3 = Client.field409.offset - 28;
                           if(class104.field1682 != null) {
                              try {
                                 class104.field1682.method1335(0L);
                                 class104.field1682.method1360(var25.payload, var3, 24);
                              } catch (Exception var48) {
                                 ;
                              }
                           }
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 216) {
                        var2 = Client.field409.method2780();
                        WidgetNode var86 = (WidgetNode)Client.componentTable.method2339((long)var2);
                        if(var86 != null) {
                           class3.method31(var86, true);
                        }

                        if(null != Client.field537) {
                           class6.method87(Client.field537);
                           Client.field537 = null;
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 157) {
                        class11.method150();
                        Client.packetOpcode = -1;
                        var15 = false;
                        break label2744;
                     }

                     if(Client.packetOpcode == 182) {
                        Client.field297 = Client.field409.method2762() * 30;
                        Client.field477 = Client.field446;
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 102) {
                        var2 = Client.field409.method2922();
                        byte var85 = Client.field409.readByte();
                        class165.settings[var2] = var85;
                        if(class165.widgetSettings[var2] != var85) {
                           class165.widgetSettings[var2] = var85;
                        }

                        CombatInfo2.method3532(var2);
                        Client.field287[++Client.field467 - 1 & 31] = var2;
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 133) {
                        var2 = Client.field409.method2780();
                        var3 = Client.field409.readUnsignedShort();
                        if(var2 < -70000) {
                           var3 += '耀';
                        }

                        if(var2 >= 0) {
                           var17 = class44.method799(var2);
                        } else {
                           var17 = null;
                        }

                        if(null != var17) {
                           for(var4 = 0; var4 < var17.itemIds.length; ++var4) {
                              var17.itemIds[var4] = 0;
                              var17.itemQuantities[var4] = 0;
                           }
                        }

                        class63.method1109(var3);
                        var4 = Client.field409.readUnsignedShort();

                        for(var5 = 0; var5 < var4; ++var5) {
                           var6 = Client.field409.readUnsignedByte();
                           if(var6 == 255) {
                              var6 = Client.field409.method2819();
                           }

                           var9 = Client.field409.method2922();
                           if(null != var17 && var5 < var17.itemIds.length) {
                              var17.itemIds[var5] = var9;
                              var17.itemQuantities[var5] = var6;
                           }

                           class0.method1(var3, var5, var9 - 1, var6);
                        }

                        if(null != var17) {
                           class6.method87(var17);
                        }

                        class33.method695();
                        Client.field471[++Client.field469 - 1 & 31] = var3 & 32767;
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 231) {
                        class33.method695();
                        var2 = Client.field409.method2803();
                        var3 = Client.field409.readUnsignedByte();
                        var8 = Client.field409.method2936();
                        Client.skillExperiences[var2] = var8;
                        Client.boostedSkillLevels[var2] = var3;
                        Client.realSkillLevels[var2] = 1;

                        for(var4 = 0; var4 < 98; ++var4) {
                           if(var8 >= class172.field2333[var4]) {
                              Client.realSkillLevels[var2] = var4 + 2;
                           }
                        }

                        Client.field470[++Client.field344 - 1 & 31] = var2;
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 210) {
                        var2 = Client.field409.method2922();
                        if(var2 == '\uffff') {
                           var2 = -1;
                        }

                        if(var2 == -1 && !Client.field519) {
                           class9.method118();
                        } else if(var2 != -1 && Client.field444 != var2 && Client.field517 != 0 && !Client.field519) {
                           class85.method1663(2, class37.field781, var2, 0, Client.field517, false);
                        }

                        Client.field444 = var2;
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 176) {
                        var2 = Client.field409.method2815();
                        var3 = Client.field409.method2922();
                        if(var3 == '\uffff') {
                           var3 = -1;
                        }

                        if(Client.field517 != 0 && var3 != -1) {
                           class107.method2001(class162.field2136, var3, 0, Client.field517, false);
                           Client.field519 = true;
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     String var26;
                     if(Client.packetOpcode == 124) {
                        var16 = Client.field409.method2965();
                        var26 = class209.method3866(Client.method589(class40.method738(Client.field409)));
                        class7.method99(6, var16, var26);
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     int var27;
                     int var28;
                     int var29;
                     int var40;
                     if(Client.packetOpcode == 155) {
                        var25 = Client.field409;
                        var3 = Client.field328;
                        ClassInfo var97 = new ClassInfo();
                        var97.field3220 = var25.readUnsignedByte();
                        var97.field3221 = var25.method2780();
                        var97.field3219 = new int[var97.field3220];
                        var97.field3222 = new int[var97.field3220];
                        var97.fields = new Field[var97.field3220];
                        var97.field3224 = new int[var97.field3220];
                        var97.methods = new Method[var97.field3220];
                        var97.args = new byte[var97.field3220][][];

                        for(var4 = 0; var4 < var97.field3220; ++var4) {
                           try {
                              var5 = var25.readUnsignedByte();
                              String var93;
                              String var96;
                              if(var5 != 0 && var5 != 1 && var5 != 2) {
                                 if(var5 == 3 || var5 == 4) {
                                    var93 = var25.method2965();
                                    var96 = var25.method2965();
                                    var7 = var25.readUnsignedByte();
                                    String[] var100 = new String[var7];

                                    for(var27 = 0; var27 < var7; ++var27) {
                                       var100[var27] = var25.method2965();
                                    }

                                    String var107 = var25.method2965();
                                    byte[][] var104 = new byte[var7][];
                                    if(var5 == 3) {
                                       for(var28 = 0; var28 < var7; ++var28) {
                                          var29 = var25.method2780();
                                          var104[var28] = new byte[var29];
                                          var25.method2974(var104[var28], 0, var29);
                                       }
                                    }

                                    var97.field3219[var4] = var5;
                                    Class[] var105 = new Class[var7];

                                    for(var29 = 0; var29 < var7; ++var29) {
                                       var105[var29] = Client.method590(var100[var29]);
                                    }

                                    Class var117 = Client.method590(var107);
                                    if(Client.method590(var93).getClassLoader() == null) {
                                       throw new SecurityException();
                                    }

                                    Method[] var115 = Client.method590(var93).getDeclaredMethods();
                                    Method[] var118 = var115;

                                    for(var40 = 0; var40 < var118.length; ++var40) {
                                       Method var121 = var118[var40];
                                       if(var121.getName().equals(var96)) {
                                          Class[] var123 = var121.getParameterTypes();
                                          if(var123.length == var105.length) {
                                             boolean var126 = true;

                                             for(int var125 = 0; var125 < var105.length; ++var125) {
                                                if(var105[var125] != var123[var125]) {
                                                   var126 = false;
                                                   break;
                                                }
                                             }

                                             if(var126 && var117 == var121.getReturnType()) {
                                                var97.methods[var4] = var121;
                                             }
                                          }
                                       }
                                    }

                                    var97.args[var4] = var104;
                                 }
                              } else {
                                 var93 = var25.method2965();
                                 var96 = var25.method2965();
                                 var7 = 0;
                                 if(var5 == 1) {
                                    var7 = var25.method2780();
                                 }

                                 var97.field3219[var4] = var5;
                                 var97.field3224[var4] = var7;
                                 if(Client.method590(var93).getClassLoader() == null) {
                                    throw new SecurityException();
                                 }

                                 var97.fields[var4] = Client.method590(var93).getDeclaredField(var96);
                              }
                           } catch (ClassNotFoundException var51) {
                              var97.field3222[var4] = -1;
                           } catch (SecurityException var52) {
                              var97.field3222[var4] = -2;
                           } catch (NullPointerException var53) {
                              var97.field3222[var4] = -3;
                           } catch (Exception var54) {
                              var97.field3222[var4] = -4;
                           } catch (Throwable var55) {
                              var97.field3222[var4] = -5;
                           }
                        }

                        class227.field3228.method2371(var97);
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 190) {
                        for(var2 = 0; var2 < class165.widgetSettings.length; ++var2) {
                           if(class165.settings[var2] != class165.widgetSettings[var2]) {
                              class165.widgetSettings[var2] = class165.settings[var2];
                              CombatInfo2.method3532(var2);
                              Client.field287[++Client.field467 - 1 & 31] = var2;
                           }
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 86 || Client.packetOpcode == 225 || Client.packetOpcode == 132 || Client.packetOpcode == 95 || Client.packetOpcode == 27 || Client.packetOpcode == 236 || Client.packetOpcode == 51 || Client.packetOpcode == 181 || Client.packetOpcode == 46 || Client.packetOpcode == 137) {
                        class101.method1910();
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 211) {
                        class25.field580 = Client.field409.readUnsignedByte();
                        class22.field234 = Client.field409.method2803();

                        for(var2 = class22.field234; var2 < class22.field234 + 8; ++var2) {
                           for(var3 = class25.field580; var3 < 8 + class25.field580; ++var3) {
                              if(Client.groundItemDeque[class60.plane][var2][var3] != null) {
                                 Client.groundItemDeque[class60.plane][var2][var3] = null;
                                 class44.groundItemSpawned(var2, var3);
                              }
                           }
                        }

                        for(class25 var94 = (class25)Client.field545.method2391(); var94 != null; var94 = (class25)Client.field545.method2393()) {
                           if(var94.field568 >= class22.field234 && var94.field568 < class22.field234 + 8 && var94.field569 >= class25.field580 && var94.field569 < 8 + class25.field580 && var94.field584 == class60.plane) {
                              var94.field577 = 0;
                           }
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     boolean var30;
                     if(Client.packetOpcode == 17) {
                        Friend var98;
                        while(Client.field409.offset < Client.field328) {
                           var18 = Client.field409.readUnsignedByte() == 1;
                           var26 = Client.field409.method2965();
                           var22 = Client.field409.method2965();
                           var4 = Client.field409.readUnsignedShort();
                           var5 = Client.field409.readUnsignedByte();
                           var6 = Client.field409.readUnsignedByte();
                           boolean var91 = (var6 & 2) != 0;
                           boolean var32 = (var6 & 1) != 0;
                           if(var4 > 0) {
                              Client.field409.method2965();
                              Client.field409.readUnsignedByte();
                              Client.field409.method2780();
                           }

                           Client.field409.method2965();

                           for(var14 = 0; var14 < Client.friendCount; ++var14) {
                              var98 = Client.friends[var14];
                              if(!var18) {
                                 if(var26.equals(var98.name)) {
                                    if(var98.world != var4) {
                                       var30 = true;

                                       for(class16 var106 = (class16)Client.field383.method2416(); var106 != null; var106 = (class16)Client.field383.method2419()) {
                                          if(var106.field175.equals(var26)) {
                                             if(var4 != 0 && var106.field176 == 0) {
                                                var106.method2431();
                                                var30 = false;
                                             } else if(var4 == 0 && var106.field176 != 0) {
                                                var106.method2431();
                                                var30 = false;
                                             }
                                          }
                                       }

                                       if(var30) {
                                          Client.field383.method2417(new class16(var26, var4));
                                       }

                                       var98.world = var4;
                                    }

                                    var98.previousName = var22;
                                    var98.rank = var5;
                                    var98.field158 = var91;
                                    var98.field154 = var32;
                                    var26 = null;
                                    break;
                                 }
                              } else if(var22.equals(var98.name)) {
                                 var98.name = var26;
                                 var98.previousName = var22;
                                 var26 = null;
                                 break;
                              }
                           }

                           if(null != var26 && Client.friendCount < 400) {
                              var98 = new Friend();
                              Client.friends[Client.friendCount] = var98;
                              var98.name = var26;
                              var98.previousName = var22;
                              var98.world = var4;
                              var98.rank = var5;
                              var98.field158 = var91;
                              var98.field154 = var32;
                              ++Client.friendCount;
                           }
                        }

                        Client.field465 = 2;
                        Client.field460 = Client.field446;
                        var18 = false;
                        var3 = Client.friendCount;

                        while(var3 > 0) {
                           var18 = true;
                           --var3;

                           for(var8 = 0; var8 < var3; ++var8) {
                              var21 = false;
                              Friend var92 = Client.friends[var8];
                              Friend var95 = Client.friends[1 + var8];
                              if(var92.world != Client.world && var95.world == Client.world) {
                                 var21 = true;
                              }

                              if(!var21 && var92.world == 0 && var95.world != 0) {
                                 var21 = true;
                              }

                              if(!var21 && !var92.field158 && var95.field158) {
                                 var21 = true;
                              }

                              if(!var21 && !var92.field154 && var95.field154) {
                                 var21 = true;
                              }

                              if(var21) {
                                 var98 = Client.friends[var8];
                                 Client.friends[var8] = Client.friends[1 + var8];
                                 Client.friends[1 + var8] = var98;
                                 var18 = false;
                              }
                           }

                           if(var18) {
                              break;
                           }
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 117) {
                        var2 = Client.field409.readUnsignedShort();
                        var3 = Client.field409.method2780();
                        var17 = class44.method799(var3);
                        if(null != var17 && var17.type == 0) {
                           if(var2 > var17.scrollHeight - var17.height) {
                              var2 = var17.scrollHeight - var17.height;
                           }

                           if(var2 < 0) {
                              var2 = 0;
                           }

                           if(var17.scrollY != var2) {
                              var17.scrollY = var2;
                              class6.method87(var17);
                           }
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     long var31;
                     WidgetNode var33;
                     if(Client.packetOpcode == 141) {
                        var2 = Client.field328 + Client.field409.offset;
                        var3 = Client.field409.readUnsignedShort();
                        var8 = Client.field409.readUnsignedShort();
                        if(var3 != Client.widgetRoot) {
                           Client.widgetRoot = var3;
                           XGrandExchangeOffer.method64(Client.widgetRoot, class0.field1, class65.field1099, false);
                           class157.method3024(Client.widgetRoot);
                           class18.method186(Client.widgetRoot);

                           for(var4 = 0; var4 < 100; ++var4) {
                              Client.field485[var4] = true;
                           }
                        }

                        WidgetNode var101;
                        for(; var8-- > 0; var101.field183 = true) {
                           var4 = Client.field409.method2780();
                           var5 = Client.field409.readUnsignedShort();
                           var6 = Client.field409.readUnsignedByte();
                           var101 = (WidgetNode)Client.componentTable.method2339((long)var4);
                           if(var101 != null && var101.id != var5) {
                              class3.method31(var101, true);
                              var101 = null;
                           }

                           if(var101 == null) {
                              var101 = class20.method194(var4, var5, var6);
                           }
                        }

                        for(var33 = (WidgetNode)Client.componentTable.method2344(); var33 != null; var33 = (WidgetNode)Client.componentTable.method2343()) {
                           if(var33.field183) {
                              var33.field183 = false;
                           } else {
                              class3.method31(var33, true);
                           }
                        }

                        Client.widgetFlags = new XHashTable(512);

                        while(Client.field409.offset < var2) {
                           var4 = Client.field409.method2780();
                           var5 = Client.field409.readUnsignedShort();
                           var6 = Client.field409.readUnsignedShort();
                           var9 = Client.field409.method2780();

                           for(var7 = var5; var7 <= var6; ++var7) {
                              var31 = ((long)var4 << 32) + (long)var7;
                              Client.widgetFlags.method2340(new class133(var9), var31);
                           }
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 41) {
                        Client.field474 = Client.field446;
                        if(Client.field328 == 0) {
                           Client.field507 = null;
                           Client.clanChatOwner = null;
                           class142.field1984 = 0;
                           class30.clanMembers = null;
                           Client.packetOpcode = -1;
                           var15 = true;
                           break label2744;
                        }

                        Client.clanChatOwner = Client.field409.method2965();
                        long var99 = Client.field409.method2908();
                        Client.field507 = class107.method2000(var99);
                        class165.field2147 = Client.field409.readByte();
                        var8 = Client.field409.readUnsignedByte();
                        if(var8 == 255) {
                           Client.packetOpcode = -1;
                           var15 = true;
                           break label2744;
                        }

                        class142.field1984 = var8;
                        XClanMember[] var36 = new XClanMember[100];

                        for(var5 = 0; var5 < class142.field1984; ++var5) {
                           var36[var5] = new XClanMember();
                           var36[var5].username = Client.field409.method2965();
                           var36[var5].field271 = class139.method2601(var36[var5].username, Ignore.field209);
                           var36[var5].world = Client.field409.readUnsignedShort();
                           var36[var5].rank = Client.field409.readByte();
                           Client.field409.method2965();
                           if(var36[var5].username.equals(class148.localPlayer.name)) {
                              class118.field1831 = var36[var5].rank;
                           }
                        }

                        var20 = false;
                        var9 = class142.field1984;

                        while(var9 > 0) {
                           var20 = true;
                           --var9;

                           for(var7 = 0; var7 < var9; ++var7) {
                              if(var36[var7].field271.compareTo(var36[var7 + 1].field271) > 0) {
                                 XClanMember var116 = var36[var7];
                                 var36[var7] = var36[var7 + 1];
                                 var36[1 + var7] = var116;
                                 var20 = false;
                              }
                           }

                           if(var20) {
                              break;
                           }
                        }

                        class30.clanMembers = var36;
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     Widget var34;
                     if(Client.packetOpcode == 162) {
                        var2 = Client.field409.method2819();
                        var3 = Client.field409.method2936();
                        WidgetNode var103 = (WidgetNode)Client.componentTable.method2339((long)var2);
                        var33 = (WidgetNode)Client.componentTable.method2339((long)var3);
                        if(var33 != null) {
                           class3.method31(var33, var103 == null || var33.id != var103.id);
                        }

                        if(null != var103) {
                           var103.unlink();
                           Client.componentTable.method2340(var103, (long)var3);
                        }

                        var34 = class44.method799(var2);
                        if(null != var34) {
                           class6.method87(var34);
                        }

                        var34 = class44.method799(var3);
                        if(null != var34) {
                           class6.method87(var34);
                           class6.method97(Widget.widgets[var34.id >>> 16], var34, true);
                        }

                        if(Client.widgetRoot != -1) {
                           var6 = Client.widgetRoot;
                           if(class94.method1870(var6)) {
                              class140.method2607(Widget.widgets[var6], 1);
                           }
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 208) {
                        Client.field543 = Client.field409.readUnsignedByte();
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 224) {
                        var2 = Client.field409.method2780();
                        var3 = Client.field409.method2762();
                        var17 = class44.method799(var2);
                        if(var17.modelType != 1 || var3 != var17.modelId) {
                           var17.modelType = 1;
                           var17.modelId = var3;
                           class6.method87(var17);
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 233) {
                        var18 = Client.field409.readUnsignedByte() == 1;
                        if(var18) {
                           class5.field45 = class9.method117() - Client.field409.method2908();
                           class11.field123 = new class1(Client.field409, true);
                        } else {
                           class11.field123 = null;
                        }

                        Client.field476 = Client.field446;
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 206) {
                        class116.method2218(false);
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 164) {
                        var2 = Client.field409.method2780();
                        var3 = Client.field409.readUnsignedByte();
                        var8 = Client.field409.readUnsignedShort();
                        var33 = (WidgetNode)Client.componentTable.method2339((long)var2);
                        if(var33 != null) {
                           class3.method31(var33, var8 != var33.id);
                        }

                        class20.method194(var2, var8, var3);
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 58) {
                        for(var2 = 0; var2 < Client.cachedPlayers.length; ++var2) {
                           if(Client.cachedPlayers[var2] != null) {
                              Client.cachedPlayers[var2].animation = -1;
                           }
                        }

                        for(var2 = 0; var2 < Client.cachedNPCs.length; ++var2) {
                           if(null != Client.cachedNPCs[var2]) {
                              Client.cachedNPCs[var2].animation = -1;
                           }
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 45) {
                        var2 = Client.field409.readUnsignedShort();
                        if(var2 == '\uffff') {
                           var2 = -1;
                        }

                        var3 = Client.field409.method2819();
                        var8 = Client.field409.method2936();
                        var4 = Client.field409.method2922();
                        if(var4 == '\uffff') {
                           var4 = -1;
                        }

                        for(var5 = var2; var5 <= var4; ++var5) {
                           var23 = ((long)var3 << 32) + (long)var5;
                           Node var102 = Client.widgetFlags.method2339(var23);
                           if(null != var102) {
                              var102.unlink();
                           }

                           Client.widgetFlags.method2340(new class133(var8), var23);
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     long var35;
                     String var42;
                     class177 var112;
                     if(Client.packetOpcode == 92) {
                        var16 = Client.field409.method2965();
                        var10 = (long)Client.field409.readUnsignedShort();
                        var35 = (long)Client.field409.read24BitInt();
                        var112 = (class177)class181.method3258(class22.method211(), Client.field409.readUnsignedByte());
                        long var113 = (var10 << 32) + var35;
                        boolean var119 = false;

                        for(var27 = 0; var27 < 100; ++var27) {
                           if(Client.field501[var27] == var113) {
                              var119 = true;
                              break;
                           }
                        }

                        if(class164.method3115(var16)) {
                           var119 = true;
                        }

                        if(!var119 && Client.field402 == 0) {
                           Client.field501[Client.field432] = var113;
                           Client.field432 = (1 + Client.field432) % 100;
                           class159 var120 = Client.field409;

                           try {
                              var29 = var120.method2963();
                              if(var29 > 32767) {
                                 var29 = 32767;
                              }

                              byte[] var43 = new byte[var29];
                              var120.offset += class210.field3106.method2706(var120.payload, var120.offset, var43, 0, var29);
                              String var44 = class183.method3346(var43, 0, var29);
                              var42 = var44;
                           } catch (Exception var47) {
                              var42 = "Cabbage";
                           }

                           var42 = class209.method3866(Client.method589(var42));
                           byte var122;
                           if(var112.field2649) {
                              var122 = 7;
                           } else {
                              var122 = 3;
                           }

                           if(var112.field2641 != -1) {
                              class7.method99(var122, class109.method2012(var112.field2641) + var16, var42);
                           } else {
                              class7.method99(var122, var16, var42);
                           }
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 103) {
                        class32.xteaChanged(true);
                        Client.field409.method3030();
                        var2 = Client.field409.readUnsignedShort();
                        class39.method735(Client.field409, var2);
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 188) {
                        while(Client.field409.offset < Client.field328) {
                           var2 = Client.field409.readUnsignedByte();
                           var12 = (var2 & 1) == 1;
                           var22 = Client.field409.method2965();
                           String var114 = Client.field409.method2965();
                           Client.field409.method2965();

                           Ignore var110;
                           for(var5 = 0; var5 < Client.ignoreCount; ++var5) {
                              var110 = Client.ignores[var5];
                              if(var12) {
                                 if(var114.equals(var110.name)) {
                                    var110.name = var22;
                                    var110.previousName = var114;
                                    var22 = null;
                                    break;
                                 }
                              } else if(var22.equals(var110.name)) {
                                 var110.name = var22;
                                 var110.previousName = var114;
                                 var22 = null;
                                 break;
                              }
                           }

                           if(var22 != null && Client.ignoreCount < 400) {
                              var110 = new Ignore();
                              Client.ignores[Client.ignoreCount] = var110;
                              var110.name = var22;
                              var110.previousName = var114;
                              ++Client.ignoreCount;
                           }
                        }

                        Client.field460 = Client.field446;
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 116) {
                        var2 = Client.field409.method2820();
                        var3 = Client.field409.method2762();
                        var17 = class44.method799(var2);
                        if(var17.modelType != 2 || var3 != var17.modelId) {
                           var17.modelType = 2;
                           var17.modelId = var3;
                           class6.method87(var17);
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 229) {
                        var2 = Client.field409.readUnsignedByte();
                        var3 = Client.field409.readUnsignedByte();
                        var8 = Client.field409.readUnsignedByte();
                        var4 = Client.field409.readUnsignedByte();
                        Client.field493[var2] = true;
                        Client.field368[var2] = var3;
                        Client.field532[var2] = var8;
                        Client.field315[var2] = var4;
                        Client.field510[var2] = 0;
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 135) {
                        var2 = Client.field409.method2936();
                        var3 = Client.field409.method2953();
                        var17 = class44.method799(var2);
                        if(var17.field2250 != var3 || var3 == -1) {
                           var17.field2250 = var3;
                           var17.field2215 = 0;
                           var17.field2308 = 0;
                           class6.method87(var17);
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 107) {
                        var2 = Client.field409.method2819();
                        class72.field1175 = class44.field881.method1926(var2);
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 242) {
                        class22.field234 = Client.field409.method2803();
                        class25.field580 = Client.field409.method2803();
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 209) {
                        var16 = Client.field409.method2965();
                        var10 = Client.field409.method2908();
                        var35 = (long)Client.field409.readUnsignedShort();
                        var23 = (long)Client.field409.read24BitInt();
                        var112 = (class177)class181.method3258(class22.method211(), Client.field409.readUnsignedByte());
                        var31 = var23 + (var35 << 32);
                        var30 = false;

                        for(var28 = 0; var28 < 100; ++var28) {
                           if(var31 == Client.field501[var28]) {
                              var30 = true;
                              break;
                           }
                        }

                        if(var112.field2648 && class164.method3115(var16)) {
                           var30 = true;
                        }

                        if(!var30 && Client.field402 == 0) {
                           Client.field501[Client.field432] = var31;
                           Client.field432 = (1 + Client.field432) % 100;
                           class159 var38 = Client.field409;

                           String var39;
                           try {
                              var40 = var38.method2963();
                              if(var40 > 32767) {
                                 var40 = 32767;
                              }

                              byte[] var41 = new byte[var40];
                              var38.offset += class210.field3106.method2706(var38.payload, var38.offset, var41, 0, var40);
                              var42 = class183.method3346(var41, 0, var40);
                              var39 = var42;
                           } catch (Exception var46) {
                              var39 = "Cabbage";
                           }

                           var39 = class209.method3866(Client.method589(var39));
                           if(var112.field2641 != -1) {
                              class207.addChatMessage(9, class109.method2012(var112.field2641) + var16, var39, class174.method3238(var10));
                           } else {
                              class207.addChatMessage(9, var16, var39, class174.method3238(var10));
                           }
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 88) {
                        class116.method2218(true);
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 34) {
                        var2 = Client.field409.method2819();
                        var3 = Client.field409.method2779();
                        var8 = var3 >> 10 & 31;
                        var4 = var3 >> 5 & 31;
                        var5 = var3 & 31;
                        var6 = (var5 << 3) + (var4 << 11) + (var8 << 19);
                        Widget var111 = class44.method799(var2);
                        if(var111.textColor != var6) {
                           var111.textColor = var6;
                           class6.method87(var111);
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 147) {
                        var2 = Client.field409.readUnsignedShort();
                        var3 = Client.field409.readUnsignedByte();
                        var8 = Client.field409.readUnsignedShort();
                        class119.method2275(var2, var3, var8);
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 232) {
                        var2 = Client.field409.readUnsignedByte();
                        if(Client.field409.readUnsignedByte() == 0) {
                           Client.grandExchangeOffers[var2] = new XGrandExchangeOffer();
                           Client.field409.offset += 18;
                        } else {
                           --Client.field409.offset;
                           Client.grandExchangeOffers[var2] = new XGrandExchangeOffer(Client.field409, false);
                        }

                        Client.field549 = Client.field446;
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 235) {
                        var2 = Client.field409.method2779();
                        var3 = Client.field409.method2922();
                        var8 = Client.field409.method2819();
                        var19 = class44.method799(var8);
                        var19.field2241 = var2 + (var3 << 16);
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 150) {
                        Client.field465 = 1;
                        Client.field460 = Client.field446;
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 239) {
                        Client.field529 = false;

                        for(var2 = 0; var2 < 5; ++var2) {
                           Client.field493[var2] = false;
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 222) {
                        World var109 = new World();
                        var109.address = Client.field409.method2965();
                        var109.id = Client.field409.readUnsignedShort();
                        var3 = Client.field409.method2780();
                        var109.mask = var3;
                        Friend.setGameState(45);
                        class37.field774.method2026();
                        class37.field774 = null;
                        class139.selectWorld(var109);
                        Client.packetOpcode = -1;
                        var15 = false;
                        break label2744;
                     }

                     if(Client.packetOpcode == 205) {
                        var2 = Client.field409.method2780();
                        var3 = Client.field409.readUnsignedShort();
                        if(var2 < -70000) {
                           var3 += '耀';
                        }

                        if(var2 >= 0) {
                           var17 = class44.method799(var2);
                        } else {
                           var17 = null;
                        }

                        for(; Client.field409.offset < Client.field328; class0.method1(var3, var4, var5 - 1, var6)) {
                           var4 = Client.field409.method2963();
                           var5 = Client.field409.readUnsignedShort();
                           var6 = 0;
                           if(var5 != 0) {
                              var6 = Client.field409.readUnsignedByte();
                              if(var6 == 255) {
                                 var6 = Client.field409.method2780();
                              }
                           }

                           if(var17 != null && var4 >= 0 && var4 < var17.itemIds.length) {
                              var17.itemIds[var4] = var5;
                              var17.itemQuantities[var4] = var6;
                           }
                        }

                        if(null != var17) {
                           class6.method87(var17);
                        }

                        class33.method695();
                        Client.field471[++Client.field469 - 1 & 31] = var3 & 32767;
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 65) {
                        class39.method735(Client.field409, Client.field328);
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 165) {
                        var16 = Client.field409.method2965();
                        var3 = Client.field409.method2820();
                        var17 = class44.method799(var3);
                        if(!var16.equals(var17.text)) {
                           var17.text = var16;
                           class6.method87(var17);
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 142) {
                        var2 = Client.field409.method2936();
                        var13 = class44.method799(var2);
                        var13.modelType = 3;
                        var13.modelId = class148.localPlayer.composition.method3125();
                        class6.method87(var13);
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 151) {
                        Client.field498 = Client.field409.readUnsignedByte();
                        Client.field499 = Client.field409.readUnsignedByte();
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 221) {
                        for(var2 = 0; var2 < class187.field2750; ++var2) {
                           class187 var108 = class30.method674(var2);
                           if(var108 != null) {
                              class165.settings[var2] = 0;
                              class165.widgetSettings[var2] = 0;
                           }
                        }

                        class33.method695();
                        Client.field467 += 32;
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 37) {
                        class33.method695();
                        Client.energy = Client.field409.readUnsignedByte();
                        Client.field477 = Client.field446;
                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 67) {
                        var2 = Client.field409.method2780();
                        var3 = Client.field409.readUnsignedShort();
                        if(var3 == '\uffff') {
                           var3 = -1;
                        }

                        var8 = Client.field409.method2780();
                        var19 = class44.method799(var2);
                        ItemComposition var37;
                        if(!var19.field2184) {
                           if(var3 == -1) {
                              var19.modelType = 0;
                              Client.packetOpcode = -1;
                              var15 = true;
                              break label2744;
                           }

                           var37 = class88.getItemDefinition(var3);
                           var19.modelType = 4;
                           var19.modelId = var3;
                           var19.rotationX = var37.field2949;
                           var19.rotationZ = var37.field2937;
                           var19.field2239 = var37.field2948 * 100 / var8;
                           class6.method87(var19);
                        } else {
                           var19.item = var3;
                           var19.stackSize = var8;
                           var37 = class88.getItemDefinition(var3);
                           var19.rotationX = var37.field2949;
                           var19.rotationZ = var37.field2937;
                           var19.rotationY = var37.field2951;
                           var19.field2234 = var37.field2952;
                           var19.field2178 = var37.field2953;
                           var19.field2239 = var37.field2948;
                           if(var37.isStackable == 1) {
                              var19.field2244 = 1;
                           } else {
                              var19.field2244 = 2;
                           }

                           if(var19.field2231 > 0) {
                              var19.field2239 = var19.field2239 * 32 / var19.field2231;
                           } else if(var19.field2237 > 0) {
                              var19.field2239 = var19.field2239 * 32 / var19.field2237;
                           }

                           class6.method87(var19);
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 53) {
                        class22.field234 = Client.field409.method2802();
                        class25.field580 = Client.field409.method2803();

                        while(Client.field409.offset < Client.field328) {
                           Client.packetOpcode = Client.field409.readUnsignedByte();
                           class101.method1910();
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     if(Client.packetOpcode == 101) {
                        var2 = Client.field409.method2820();
                        var3 = Client.field409.method2779();
                        var8 = Client.field409.method2922();
                        var4 = Client.field409.method2779();
                        var34 = class44.method799(var2);
                        if(var34.rotationX != var4 || var34.rotationZ != var3 || var34.field2239 != var8) {
                           var34.rotationX = var4;
                           var34.rotationZ = var3;
                           var34.field2239 = var8;
                           class6.method87(var34);
                        }

                        Client.packetOpcode = -1;
                        var15 = true;
                        break label2744;
                     }

                     class174.method3240("" + Client.packetOpcode + "," + Client.field334 + "," + Client.field335 + "," + Client.field328, (Throwable)null);
                     class11.method150();
                  } catch (IOException var57) {
                     Frames.method1851();
                  } catch (Exception var58) {
                     var16 = "" + Client.packetOpcode + "," + Client.field334 + "," + Client.field335 + "," + Client.field328 + "," + (class148.localPlayer.pathX[0] + FrameMap.baseX) + "," + (class148.localPlayer.pathY[0] + XItemContainer.baseY) + ",";

                     for(var3 = 0; var3 < Client.field328 && var3 < 50; ++var3) {
                        var16 = var16 + Client.field409.payload[var3] + ",";
                     }

                     class174.method3240(var16, var58);
                     class11.method150();
                  }

                  var15 = true;
               }
            }

            if(!var15) {
               break;
            }
         }

         if(Client.gameState == 30) {
            while(true) {
               ClassInfo var124 = (ClassInfo)class227.field3228.method2358();
               boolean var59;
               if(var124 == null) {
                  var59 = false;
               } else {
                  var59 = true;
               }

               int var63;
               if(!var59) {
                  Object var60 = class191.field2796.field213;
                  Object var61 = class191.field2796.field213;
                  synchronized(class191.field2796.field213) {
                     if(!Client.field280) {
                        class191.field2796.field214 = 0;
                     } else if(class115.field1794 != 0 || class191.field2796.field214 >= 40) {
                        Client.field326.method3029(218);
                        Client.field326.method2760(0);
                        var63 = Client.field326.offset;
                        var1 = 0;

                        for(var2 = 0; var2 < class191.field2796.field214 && Client.field326.offset - var63 < 240; ++var2) {
                           ++var1;
                           var3 = class191.field2796.field216[var2];
                           if(var3 < 0) {
                              var3 = 0;
                           } else if(var3 > 502) {
                              var3 = 502;
                           }

                           var8 = class191.field2796.field215[var2];
                           if(var8 < 0) {
                              var8 = 0;
                           } else if(var8 > 764) {
                              var8 = 764;
                           }

                           var4 = var8 + var3 * 765;
                           if(class191.field2796.field216[var2] == -1 && class191.field2796.field215[var2] == -1) {
                              var8 = -1;
                              var3 = -1;
                              var4 = 524287;
                           }

                           if(var8 == Client.field339 && Client.field293 == var3) {
                              if(Client.field294 < 2047) {
                                 ++Client.field294;
                              }
                           } else {
                              var5 = var8 - Client.field339;
                              Client.field339 = var8;
                              var6 = var3 - Client.field293;
                              Client.field293 = var3;
                              if(Client.field294 < 8 && var5 >= -32 && var5 <= 31 && var6 >= -32 && var6 <= 31) {
                                 var5 += 32;
                                 var6 += 32;
                                 Client.field326.method2918(var6 + (Client.field294 << 12) + (var5 << 6));
                                 Client.field294 = 0;
                              } else if(Client.field294 < 8) {
                                 Client.field326.method2914(8388608 + (Client.field294 << 19) + var4);
                                 Client.field294 = 0;
                              } else {
                                 Client.field326.method2763(-1073741824 + (Client.field294 << 19) + var4);
                                 Client.field294 = 0;
                              }
                           }
                        }

                        Client.field326.method2772(Client.field326.offset - var63);
                        if(var1 >= class191.field2796.field214) {
                           class191.field2796.field214 = 0;
                        } else {
                           class191.field2796.field214 -= var1;

                           for(var2 = 0; var2 < class191.field2796.field214; ++var2) {
                              class191.field2796.field215[var2] = class191.field2796.field215[var2 + var1];
                              class191.field2796.field216[var2] = class191.field2796.field216[var2 + var1];
                           }
                        }
                     }
                  }

                  long var62;
                  if(class115.field1794 == 1 || !GroundObject.field1297 && class115.field1794 == 4 || class115.field1794 == 2) {
                     var62 = (class115.field1797 - Client.field291) / 50L;
                     if(var62 > 4095L) {
                        var62 = 4095L;
                     }

                     Client.field291 = class115.field1797;
                     var1 = class115.field1796;
                     if(var1 < 0) {
                        var1 = 0;
                     } else if(var1 > class65.field1099) {
                        var1 = class65.field1099;
                     }

                     var2 = class115.field1791;
                     if(var2 < 0) {
                        var2 = 0;
                     } else if(var2 > class0.field1) {
                        var2 = class0.field1;
                     }

                     var3 = (int)var62;
                     Client.field326.method3029(19);
                     Client.field326.method2918((class115.field1794 == 2?1:0) + (var3 << 1));
                     Client.field326.method2918(var2);
                     Client.field326.method2918(var1);
                  }

                  if(class105.field1710 > 0) {
                     Client.field326.method3029(88);
                     Client.field326.method2918(0);
                     var0 = Client.field326.offset;
                     var62 = class9.method117();

                     for(var2 = 0; var2 < class105.field1710; ++var2) {
                        var10 = var62 - Client.field506;
                        if(var10 > 16777215L) {
                           var10 = 16777215L;
                        }

                        Client.field506 = var62;
                        Client.field326.method2816((int)var10);
                        Client.field326.method2800(class105.field1706[var2]);
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
                  int[] var65 = class45.field892;

                  for(var1 = 0; var1 < var0; ++var1) {
                     Player var66 = Client.cachedPlayers[var65[var1]];
                     if(var66 != null) {
                        class31.method680(var66, 1);
                     }
                  }

                  class103.method1936();
                  int[] var67 = class45.field892;

                  for(var63 = 0; var63 < class45.field888; ++var63) {
                     Player var79 = Client.cachedPlayers[var67[var63]];
                     if(null != var79 && var79.field615 > 0) {
                        --var79.field615;
                        if(var79.field615 == 0) {
                           var79.overhead = null;
                        }
                     }
                  }

                  for(var63 = 0; var63 < Client.field322; ++var63) {
                     var1 = Client.field483[var63];
                     NPC var81 = Client.cachedNPCs[var1];
                     if(null != var81 && var81.field615 > 0) {
                        --var81.field615;
                        if(var81.field615 == 0) {
                           var81.overhead = null;
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

                  Widget var82 = class188.field2758;
                  Widget var77 = Player.field241;
                  class188.field2758 = null;
                  Player.field241 = null;
                  Client.field457 = null;
                  Client.field525 = false;
                  Client.field458 = false;
                  Client.field503 = 0;

                  while(class196.method3554() && Client.field503 < 128) {
                     if(Client.field352 >= 2 && class105.field1700[82] && class162.field2134 == 66) {
                        var69 = class25.method594();
                        class160.field2118.setContents(new StringSelection(var69), (ClipboardOwner)null);
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
                     Widget var75;
                     do {
                        var24 = (class18)Client.field480.method2389();
                        if(var24 == null) {
                           while(true) {
                              do {
                                 var24 = (class18)Client.field325.method2389();
                                 if(null == var24) {
                                    while(true) {
                                       do {
                                          var24 = (class18)Client.field479.method2389();
                                          if(var24 == null) {
                                             class94.method1869();
                                             if(Client.field453 != null) {
                                                class6.method87(Client.field453);
                                                ++class94.field1581;
                                                if(Client.field525 && Client.field458) {
                                                   var1 = class115.field1788;
                                                   var2 = class115.field1789;
                                                   var1 -= Client.field455;
                                                   var2 -= Client.field550;
                                                   if(var1 < Client.field490) {
                                                      var1 = Client.field490;
                                                   }

                                                   if(Client.field453.width + var1 > Client.field454.width + Client.field490) {
                                                      var1 = Client.field490 + Client.field454.width - Client.field453.width;
                                                   }

                                                   if(var2 < Client.field284) {
                                                      var2 = Client.field284;
                                                   }

                                                   if(Client.field453.height + var2 > Client.field284 + Client.field454.height) {
                                                      var2 = Client.field454.height + Client.field284 - Client.field453.height;
                                                   }

                                                   var3 = var1 - Client.field509;
                                                   var8 = var2 - Client.field463;
                                                   var4 = Client.field453.field2261;
                                                   if(class94.field1581 > Client.field453.field2262 && (var3 > var4 || var3 < -var4 || var8 > var4 || var8 < -var4)) {
                                                      Client.field464 = true;
                                                   }

                                                   var5 = var1 - Client.field490 + Client.field454.scrollX;
                                                   var6 = Client.field454.scrollY + (var2 - Client.field284);
                                                   class18 var80;
                                                   if(null != Client.field453.field2274 && Client.field464) {
                                                      var80 = new class18();
                                                      var80.field195 = Client.field453;
                                                      var80.field191 = var5;
                                                      var80.field190 = var6;
                                                      var80.field203 = Client.field453.field2274;
                                                      class49.method871(var80, 200000);
                                                   }

                                                   if(class115.field1787 == 0) {
                                                      if(Client.field464) {
                                                         if(Client.field453.field2275 != null) {
                                                            var80 = new class18();
                                                            var80.field195 = Client.field453;
                                                            var80.field191 = var5;
                                                            var80.field190 = var6;
                                                            var80.field194 = Client.field457;
                                                            var80.field203 = Client.field453.field2275;
                                                            class49.method871(var80, 200000);
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
                                                         Widget var83 = class31.field715;
                                                         byte var89 = 0;
                                                         if(Client.field558 == 1 && var83.contentType == 206) {
                                                            var89 = 1;
                                                         }

                                                         if(var83.itemIds[Client.field399] <= 0) {
                                                            var89 = 0;
                                                         }

                                                         var8 = GameObject.method1872(var83);
                                                         var12 = (var8 >> 29 & 1) != 0;
                                                         if(var12) {
                                                            var4 = Client.field396;
                                                            var5 = Client.field399;
                                                            var83.itemIds[var5] = var83.itemIds[var4];
                                                            var83.itemQuantities[var5] = var83.itemQuantities[var4];
                                                            var83.itemIds[var4] = -1;
                                                            var83.itemQuantities[var4] = 0;
                                                         } else if(var89 == 1) {
                                                            var4 = Client.field396;
                                                            var5 = Client.field399;

                                                            while(var4 != var5) {
                                                               if(var4 > var5) {
                                                                  var83.method3163(var4 - 1, var4);
                                                                  --var4;
                                                               } else if(var4 < var5) {
                                                                  var83.method3163(var4 + 1, var4);
                                                                  ++var4;
                                                               }
                                                            }
                                                         } else {
                                                            var83.method3163(Client.field399, Client.field396);
                                                         }

                                                         Client.field326.method3029(32);
                                                         Client.field326.method2807(Client.field396);
                                                         Client.field326.method2800(var89);
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
                                                var1 = Region.field1470;
                                                var2 = Region.field1504;
                                                Client.field326.method3029(164);
                                                Client.field326.method2760(5);
                                                Client.field326.method2800(class105.field1700[82]?(class105.field1700[81]?2:1):0);
                                                Client.field326.method2942(FrameMap.baseX + var1);
                                                Client.field326.method2809(var2 + XItemContainer.baseY);
                                                Region.field1470 = -1;
                                                Client.field390 = class115.field1791;
                                                Client.field391 = class115.field1796;
                                                Client.field393 = 1;
                                                Client.field392 = 0;
                                                Client.flagX = var1;
                                                Client.flagY = var2;
                                             }

                                             if(class188.field2758 != var82) {
                                                if(var82 != null) {
                                                   class6.method87(var82);
                                                }

                                                if(class188.field2758 != null) {
                                                   class6.method87(class188.field2758);
                                                }
                                             }

                                             if(var77 != Player.field241 && Client.field361 == Client.field431) {
                                                if(null != var77) {
                                                   class6.method87(var77);
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

                                             var1 = Client.field347 + class148.localPlayer.x;
                                             var2 = Client.field394 + class148.localPlayer.y;
                                             if(class22.field236 - var1 < -500 || class22.field236 - var1 > 500 || class152.field2068 - var2 < -500 || class152.field2068 - var2 > 500) {
                                                class22.field236 = var1;
                                                class152.field2068 = var2;
                                             }

                                             if(class22.field236 != var1) {
                                                class22.field236 += (var1 - class22.field236) / 16;
                                             }

                                             if(class152.field2068 != var2) {
                                                class152.field2068 += (var2 - class152.field2068) / 16;
                                             }

                                             if(class115.field1787 == 4 && GroundObject.field1297) {
                                                var3 = class115.field1789 - Client.field371;
                                                Client.field369 = var3 * 2;
                                                Client.field371 = var3 != -1 && var3 != 1?(class115.field1789 + Client.field371) / 2:class115.field1789;
                                                var8 = Client.field521 - class115.field1788;
                                                Client.field385 = var8 * 2;
                                                Client.field521 = var8 != -1 && var8 != 1?(Client.field521 + class115.field1788) / 2:class115.field1788;
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

                                             var3 = class22.field236 >> 7;
                                             var8 = class152.field2068 >> 7;
                                             var4 = class176.method3243(class22.field236, class152.field2068, class60.plane);
                                             var5 = 0;
                                             if(var3 > 3 && var8 > 3 && var3 < 100 && var8 < 100) {
                                                for(var6 = var3 - 4; var6 <= var3 + 4; ++var6) {
                                                   for(var9 = var8 - 4; var9 <= 4 + var8; ++var9) {
                                                      var7 = class60.plane;
                                                      if(var7 < 3 && (class10.tileSettings[1][var6][var9] & 2) == 2) {
                                                         ++var7;
                                                      }

                                                      var14 = var4 - class10.tileHeights[var7][var6][var9];
                                                      if(var14 > var5) {
                                                         var5 = var14;
                                                      }
                                                   }
                                                }
                                             }

                                             var6 = 192 * var5;
                                             if(var6 > 98048) {
                                                var6 = 98048;
                                             }

                                             if(var6 < '耀') {
                                                var6 = '耀';
                                             }

                                             if(var6 > Client.field406) {
                                                Client.field406 += (var6 - Client.field406) / 24;
                                             } else if(var6 < Client.field406) {
                                                Client.field406 += (var6 - Client.field406) / 80;
                                             }

                                             if(Client.field529) {
                                                class6.method95();
                                             }

                                             for(var1 = 0; var1 < 5; ++var1) {
                                                ++Client.field510[var1];
                                             }

                                             Renderable.chatMessages.method829();
                                             var1 = class99.method1893();
                                             var2 = class105.keyboardIdleTicks;
                                             if(var1 > 15000 && var2 > 15000) {
                                                Client.field336 = 250;
                                                class115.mouseIdleTicks = 14500;
                                                Client.field326.method3029(76);
                                             }

                                             ++Client.field302;
                                             if(Client.field302 > 500) {
                                                Client.field302 = 0;
                                                var8 = (int)(Math.random() * 8.0D);
                                                if((var8 & 1) == 1) {
                                                   Client.field347 += Client.field348;
                                                }

                                                if((var8 & 2) == 2) {
                                                   Client.field394 += Client.field331;
                                                }

                                                if((var8 & 4) == 4) {
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
                                                var8 = (int)(Math.random() * 8.0D);
                                                if((var8 & 1) == 1) {
                                                   Client.mapScale += Client.field355;
                                                }

                                                if((var8 & 2) == 2) {
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

                                             for(class16 var84 = (class16)Client.field383.method2416(); var84 != null; var84 = (class16)Client.field383.method2419()) {
                                                if((long)var84.field180 < class9.method117() / 1000L - 5L) {
                                                   if(var84.field176 > 0) {
                                                      class7.method99(5, "", var84.field175 + " has logged in.");
                                                   }

                                                   if(var84.field176 == 0) {
                                                      class7.method99(5, "", var84.field175 + " has logged out.");
                                                   }

                                                   var84.method2431();
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
                                             } catch (IOException var49) {
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

                                          var75 = var24.field195;
                                          if(var75.index < 0) {
                                             break;
                                          }

                                          var13 = class44.method799(var75.parentId);
                                       } while(var13 == null || var13.children == null || var75.index >= var13.children.length || var75 != var13.children[var75.index]);

                                       class49.method871(var24, 200000);
                                    }
                                 }

                                 var75 = var24.field195;
                                 if(var75.index < 0) {
                                    break;
                                 }

                                 var13 = class44.method799(var75.parentId);
                              } while(null == var13 || null == var13.children || var75.index >= var13.children.length || var13.children[var75.index] != var75);

                              class49.method871(var24, 200000);
                           }
                        }

                        var75 = var24.field195;
                        if(var75.index < 0) {
                           break;
                        }

                        var13 = class44.method799(var75.parentId);
                     } while(null == var13 || var13.children == null || var75.index >= var13.children.length || var75 != var13.children[var75.index]);

                     class0.method8(var24);
                  }
               }

               Client.field326.method3029(227);
               Client.field326.method2760(0);
               var63 = Client.field326.offset;
               class22.method212(Client.field326);
               Client.field326.method2772(Client.field326.offset - var63);
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
