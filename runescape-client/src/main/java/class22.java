import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.RandomAccessFile;
import java.io.StreamCorruptedException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("l")
public class class22 extends class119 {
   @ObfuscatedName("k")
   static int[] field231;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "9"
   )
   static final boolean method207(int var0, int var1) {
      ObjectComposition var2 = class217.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method3598(var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "1167824572"
   )
   public boolean vmethod2300(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field1858 && super.field1856 == var3;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "-1912357711"
   )
   static final void method211(Actor var0, int var1) {
      int var2;
      int var3;
      int var4;
      if(var0.field652 > Client.gameCycle) {
         class162.method3080(var0);
      } else if(var0.field639 >= Client.gameCycle) {
         if(Client.gameCycle == var0.field639 || var0.animation == -1 || var0.actionAnimationDisable != 0 || 1 + var0.field626 > class146.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
            var2 = var0.field639 - var0.field652;
            var3 = Client.gameCycle - var0.field652;
            var4 = var0.field596 * 64 + var0.field634 * 128;
            int var5 = var0.field636 * 128 + var0.field596 * 64;
            int var6 = var0.field596 * 64 + var0.field610 * 128;
            int var7 = var0.field596 * 64 + var0.field647 * 128;
            var0.x = (var3 * var6 + (var2 - var3) * var4) / var2;
            var0.y = ((var2 - var3) * var5 + var3 * var7) / var2;
         }

         var0.field627 = 0;
         var0.field643 = var0.field592;
         var0.angle = var0.field643;
      } else {
         class47.method869(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field652 = 0;
         var0.field639 = 0;
         var0.x = var0.field596 * 64 + var0.pathX[0] * 128;
         var0.y = var0.field596 * 64 + 128 * var0.pathY[0];
         var0.method580();
      }

      if(class16.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field652 = 0;
         var0.field639 = 0;
         var0.x = 128 * var0.pathX[0] + var0.field596 * 64;
         var0.y = var0.field596 * 64 + var0.pathY[0] * 128;
         var0.method580();
      }

      if(var0.field645 != 0) {
         if(var0.interacting != -1) {
            Object var8 = null;
            if(var0.interacting < '耀') {
               var8 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var8 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(null != var8) {
               var3 = var0.x - ((Actor)var8).x;
               var4 = var0.y - ((Actor)var8).y;
               if(var3 != 0 || var4 != 0) {
                  var0.field643 = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field619) {
               var0.interacting = -1;
               var0.field619 = false;
            }
         }

         if(var0.field620 != -1 && (var0.field646 == 0 || var0.field627 > 0)) {
            var0.field643 = var0.field620;
            var0.field620 = -1;
         }

         var2 = var0.field643 - var0.angle & 2047;
         if(var2 == 0 && var0.field619) {
            var0.interacting = -1;
            var0.field619 = false;
         }

         if(var2 != 0) {
            ++var0.field644;
            boolean var10;
            if(var2 > 1024) {
               var0.angle -= var0.field645;
               var10 = true;
               if(var2 < var0.field645 || var2 > 2048 - var0.field645) {
                  var0.angle = var0.field643;
                  var10 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field644 > 25 || var10)) {
                  if(var0.field598 != -1) {
                     var0.poseAnimation = var0.field598;
                  } else {
                     var0.poseAnimation = var0.field600;
                  }
               }
            } else {
               var0.angle += var0.field645;
               var10 = true;
               if(var2 < var0.field645 || var2 > 2048 - var0.field645) {
                  var0.angle = var0.field643;
                  var10 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field644 > 25 || var10)) {
                  if(var0.field599 != -1) {
                     var0.poseAnimation = var0.field599;
                  } else {
                     var0.poseAnimation = var0.field600;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field644 = 0;
         }
      }

      WidgetNode.method187(var0);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass184;II)V",
      garbageValue = "1324839754"
   )
   static void method212(class184 var0, int var1) {
      if(null != Buffer.field2090) {
         Buffer.field2090.offset = 5 + var1 * 8;
         int var2 = Buffer.field2090.method2819();
         int var3 = Buffer.field2090.method2819();
         var0.method3364(var2, var3);
      } else {
         class176.method3244((class184)null, 255, 255, 0, (byte)0, true);
         class185.field2758[var1] = var0;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1049983379"
   )
   static final int method213(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class7.method113(var3, var5);
      int var8 = class7.method113(var3 + 1, var5);
      int var9 = class7.method113(var3, 1 + var5);
      int var10 = class7.method113(var3 + 1, var5 + 1);
      int var11 = class40.method741(var7, var8, var4, var2);
      int var12 = class40.method741(var9, var10, var4, var2);
      return class40.method741(var11, var12, var6, var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2114302648"
   )
   static final void method214() {
      if(Client.field295 > 1) {
         --Client.field295;
      }

      if(Client.field331 > 0) {
         --Client.field331;
      }

      if(Client.field332) {
         Client.field332 = false;
         if(Client.field331 > 0) {
            GameObject.method1915();
         } else {
            class212.setGameState(40);
            Client.field496 = Friend.field152;
            Friend.field152 = null;
         }

      } else {
         if(!Client.isMenuOpen) {
            Client.menuOptions[0] = "Cancel";
            Client.menuTargets[0] = "";
            Client.menuTypes[0] = 1006;
            Client.menuOptionCount = 1;
         }

         int var0;
         int var2;
         int var4;
         String var5;
         int var11;
         int var24;
         long var25;
         int var31;
         int var32;
         int var33;
         int var34;
         boolean var35;
         String var42;
         Widget var87;
         boolean var118;
         int var123;
         boolean var125;
         int var129;
         Widget var131;
         for(var0 = 0; var0 < 100; ++var0) {
            boolean var1;
            if(Friend.field152 == null) {
               var1 = false;
            } else {
               label3450: {
                  String var3;
                  try {
                     var2 = Friend.field152.method2054();
                     if(var2 == 0) {
                        var1 = false;
                        break label3450;
                     }

                     if(Client.packetOpcode == -1) {
                        Friend.field152.method2055(Client.field323.payload, 0, 1);
                        Client.field323.offset = 0;
                        Client.packetOpcode = Client.field323.method3040();
                        Client.field541 = class212.field3143[Client.packetOpcode];
                        --var2;
                     }

                     if(Client.field541 == -1) {
                        if(var2 <= 0) {
                           var1 = false;
                           break label3450;
                        }

                        Friend.field152.method2055(Client.field323.payload, 0, 1);
                        Client.field541 = Client.field323.payload[0] & 255;
                        --var2;
                     }

                     if(Client.field541 == -2) {
                        if(var2 <= 1) {
                           var1 = false;
                           break label3450;
                        }

                        Friend.field152.method2055(Client.field323.payload, 0, 2);
                        Client.field323.offset = 0;
                        Client.field541 = Client.field323.readUnsignedShort();
                        var2 -= 2;
                     }

                     if(var2 < Client.field541) {
                        var1 = false;
                        break label3450;
                     }

                     Client.field323.offset = 0;
                     Friend.field152.method2055(Client.field323.payload, 0, Client.field541);
                     Client.field326 = 0;
                     Client.field330 = Client.field400;
                     Client.field400 = Client.field328;
                     Client.field328 = Client.packetOpcode;
                     if(Client.packetOpcode == 144) {
                        Client.field295 = Client.field323.readUnsignedShort() * 30;
                        Client.field474 = Client.field462;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 4) {
                        World var83 = new World();
                        var83.address = Client.field323.method2846();
                        var83.id = Client.field323.readUnsignedShort();
                        var4 = Client.field323.method2819();
                        var83.mask = var4;
                        class212.setGameState(45);
                        Friend.field152.method2059();
                        Friend.field152 = null;
                        class137.method2487(var83);
                        Client.packetOpcode = -1;
                        var1 = false;
                        break label3450;
                     }

                     if(Client.packetOpcode == 89) {
                        for(var24 = 0; var24 < Client.cachedPlayers.length; ++var24) {
                           if(Client.cachedPlayers[var24] != null) {
                              Client.cachedPlayers[var24].animation = -1;
                           }
                        }

                        for(var24 = 0; var24 < Client.cachedNPCs.length; ++var24) {
                           if(null != Client.cachedNPCs[var24]) {
                              Client.cachedNPCs[var24].animation = -1;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     Widget var93;
                     WidgetNode var102;
                     if(Client.packetOpcode == 38) {
                        var24 = Client.field323.method2819();
                        var4 = Client.field323.method2831();
                        WidgetNode var111 = (WidgetNode)Client.componentTable.method2374((long)var24);
                        var102 = (WidgetNode)Client.componentTable.method2374((long)var4);
                        if(var102 != null) {
                           class9.method117(var102, null == var111 || var102.id != var111.id);
                        }

                        if(null != var111) {
                           var111.unlink();
                           Client.componentTable.method2364(var111, (long)var4);
                        }

                        var93 = class37.method736(var24);
                        if(null != var93) {
                           class33.method682(var93);
                        }

                        var93 = class37.method736(var4);
                        if(null != var93) {
                           class33.method682(var93);
                           Renderable.method1892(Widget.widgets[var93.id >>> 16], var93, true);
                        }

                        if(Client.widgetRoot != -1) {
                           class148.method2783(Client.widgetRoot, 1);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     int var12;
                     int var15;
                     long var27;
                     if(Client.packetOpcode == 22) {
                        var3 = Client.field323.method2846();
                        var25 = (long)Client.field323.readUnsignedShort();
                        var27 = (long)Client.field323.read24BitInt();
                        class177 var104 = (class177)TextureProvider.method1454(CombatInfoListHolder.method696(), Client.field323.readUnsignedByte());
                        long var9 = var27 + (var25 << 32);
                        boolean var107 = false;

                        for(var12 = 0; var12 < 100; ++var12) {
                           if(var9 == Client.field361[var12]) {
                              var107 = true;
                              break;
                           }
                        }

                        if(class170.method3237(var3)) {
                           var107 = true;
                        }

                        if(!var107 && Client.field397 == 0) {
                           Client.field361[Client.field312] = var9;
                           Client.field312 = (1 + Client.field312) % 100;
                           class159 var109 = Client.field323;

                           String var112;
                           try {
                              var15 = var109.method2979();
                              if(var15 > 32767) {
                                 var15 = 32767;
                              }

                              byte[] var116 = new byte[var15];
                              var109.offset += class210.field3117.method2745(var109.payload, var109.offset, var116, 0, var15);
                              String var115 = World.method610(var116, 0, var15);
                              var112 = var115;
                           } catch (Exception var66) {
                              var112 = "Cabbage";
                           }

                           var112 = FontTypeFace.method3919(class2.method22(var112));
                           byte var114;
                           if(var104.field2664) {
                              var114 = 7;
                           } else {
                              var114 = 3;
                           }

                           if(var104.field2663 != -1) {
                              class103.sendGameMessage(var114, class167.method3163(var104.field2663) + var3, var112);
                           } else {
                              class103.sendGameMessage(var114, var3, var112);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 1) {
                        if(Client.widgetRoot != -1) {
                           class148.method2783(Client.widgetRoot, 0);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 211) {
                        Client.field545 = 1;
                        Client.field416 = Client.field462;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     boolean var108;
                     boolean var122;
                     if(Client.packetOpcode == 165) {
                        var24 = Client.field323.method2979();
                        var108 = Client.field323.readUnsignedByte() == 1;
                        var5 = "";
                        var122 = false;
                        if(var108) {
                           var5 = Client.field323.method2846();
                           if(class170.method3237(var5)) {
                              var122 = true;
                           }
                        }

                        String var98 = Client.field323.method2846();
                        if(!var122) {
                           class103.sendGameMessage(var24, var5, var98);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     Widget var81;
                     if(Client.packetOpcode == 222) {
                        var24 = Client.field323.method2858();
                        var4 = Client.field323.method2933();
                        var81 = class37.method736(var24);
                        if(var81 != null && var81.type == 0) {
                           if(var4 > var81.scrollHeight - var81.height) {
                              var4 = var81.scrollHeight - var81.height;
                           }

                           if(var4 < 0) {
                              var4 = 0;
                           }

                           if(var4 != var81.scrollY) {
                              var81.scrollY = var4;
                              class33.method682(var81);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 148) {
                        var24 = Client.field323.readUnsignedByte();
                        var4 = Client.field323.readUnsignedByte();
                        var32 = Client.field323.readUnsignedByte();
                        var31 = Client.field323.readUnsignedByte();
                        Client.field443[var24] = true;
                        Client.field527[var24] = var4;
                        Client.field528[var24] = var32;
                        Client.field529[var24] = var31;
                        Client.field530[var24] = 0;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 54) {
                        var3 = Client.field323.method2846();
                        var4 = Client.field323.method2858();
                        var81 = class37.method736(var4);
                        if(!var3.equals(var81.text)) {
                           var81.text = var3;
                           class33.method682(var81);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 68) {
                        var3 = Client.field323.method2846();
                        var4 = Client.field323.readUnsignedShort();
                        byte var127 = Client.field323.readByte();
                        var122 = false;
                        if(var127 == -128) {
                           var122 = true;
                        }

                        if(var122) {
                           if(class10.clanChatCount == 0) {
                              Client.packetOpcode = -1;
                              var1 = true;
                              break label3450;
                           }

                           var125 = false;

                           for(var33 = 0; var33 < class10.clanChatCount && (!Renderable.clanMembers[var33].username.equals(var3) || var4 != Renderable.clanMembers[var33].world); ++var33) {
                              ;
                           }

                           if(var33 < class10.clanChatCount) {
                              while(var33 < class10.clanChatCount - 1) {
                                 Renderable.clanMembers[var33] = Renderable.clanMembers[var33 + 1];
                                 ++var33;
                              }

                              --class10.clanChatCount;
                              Renderable.clanMembers[class10.clanChatCount] = null;
                           }
                        } else {
                           Client.field323.method2846();
                           XClanMember var95 = new XClanMember();
                           var95.username = var3;
                           var95.field277 = FrameMap.method1697(var95.username, FaceNormal.field1561);
                           var95.world = var4;
                           var95.rank = var127;

                           for(var34 = class10.clanChatCount - 1; var34 >= 0; --var34) {
                              var123 = Renderable.clanMembers[var34].field277.compareTo(var95.field277);
                              if(var123 == 0) {
                                 Renderable.clanMembers[var34].world = var4;
                                 Renderable.clanMembers[var34].rank = var127;
                                 if(var3.equals(class16.localPlayer.name)) {
                                    class109.field1742 = var127;
                                 }

                                 Client.field471 = Client.field462;
                                 Client.packetOpcode = -1;
                                 var1 = true;
                                 break label3450;
                              }

                              if(var123 < 0) {
                                 break;
                              }
                           }

                           if(class10.clanChatCount >= Renderable.clanMembers.length) {
                              Client.packetOpcode = -1;
                              var1 = true;
                              break label3450;
                           }

                           for(var123 = class10.clanChatCount - 1; var123 > var34; --var123) {
                              Renderable.clanMembers[var123 + 1] = Renderable.clanMembers[var123];
                           }

                           if(class10.clanChatCount == 0) {
                              Renderable.clanMembers = new XClanMember[100];
                           }

                           Renderable.clanMembers[1 + var34] = var95;
                           ++class10.clanChatCount;
                           if(var3.equals(class16.localPlayer.name)) {
                              class109.field1742 = var127;
                           }
                        }

                        Client.field471 = Client.field462;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 92 || Client.packetOpcode == 7 || Client.packetOpcode == 156 || Client.packetOpcode == 136 || Client.packetOpcode == 236 || Client.packetOpcode == 241 || Client.packetOpcode == 37 || Client.packetOpcode == 51 || Client.packetOpcode == 231 || Client.packetOpcode == 219) {
                        class44.method804();
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 75) {
                        class107.field1729 = Client.field323.method2848();
                        class183.field2721 = Client.field323.readUnsignedByte();

                        while(Client.field323.offset < Client.field541) {
                           Client.packetOpcode = Client.field323.readUnsignedByte();
                           class44.method804();
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     long var36;
                     if(Client.packetOpcode == 113) {
                        var24 = Client.field323.method2850();
                        if(var24 == '\uffff') {
                           var24 = -1;
                        }

                        var4 = Client.field323.method2819();
                        var32 = Client.field323.method2850();
                        if(var32 == '\uffff') {
                           var32 = -1;
                        }

                        var31 = Client.field323.method2831();

                        for(var33 = var24; var33 <= var32; ++var33) {
                           var36 = (long)var33 + ((long)var4 << 32);
                           Node var105 = Client.widgetFlags.method2374(var36);
                           if(var105 != null) {
                              var105.unlink();
                           }

                           Client.widgetFlags.method2364(new class133(var31), var36);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 120) {
                        var24 = Client.field323.method2827();
                        if(var24 == '\uffff') {
                           var24 = -1;
                        }

                        if(var24 == -1 && !Client.field516) {
                           class138.field1920.method2513();
                           class138.field1921 = 1;
                           Item.field887 = null;
                        } else if(var24 != -1 && Client.field515 != var24 && Client.field536 != 0 && !Client.field516) {
                           NPCComposition.method3725(2, class227.field3228, var24, 0, Client.field536, false);
                        }

                        Client.field515 = var24;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 65) {
                        var24 = Client.field323.method2933();
                        if(var24 == '\uffff') {
                           var24 = -1;
                        }

                        var4 = Client.field323.method2853();
                        class31.method668(var24, var4);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 0) {
                        var24 = Client.field323.method2842();
                        var4 = Client.field323.method2848();
                        var5 = Client.field323.method2846();
                        if(var24 >= 1 && var24 <= 8) {
                           if(var5.equalsIgnoreCase("null")) {
                              var5 = null;
                           }

                           Client.playerOptions[var24 - 1] = var5;
                           Client.playerOptionsPriority[var24 - 1] = var4 == 0;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 227) {
                        var24 = Client.field323.method2850();
                        var4 = Client.field323.method2848();
                        var32 = Client.field323.method2857();
                        var102 = (WidgetNode)Client.componentTable.method2374((long)var32);
                        if(var102 != null) {
                           class9.method117(var102, var24 != var102.id);
                        }

                        Client.method357(var32, var24, var4);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 200) {
                        CombatInfo1.field662 = class202.method3785(Client.field323.readUnsignedByte());
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 111) {
                        var24 = Client.field323.readUnsignedShort();
                        var4 = Client.field323.readUnsignedShort();
                        var32 = Client.field323.method2819();
                        var31 = Client.field323.method2850();
                        var93 = class37.method736(var32);
                        if(var93.rotationX != var31 || var93.rotationZ != var4 || var93.field2250 != var24) {
                           var93.rotationX = var31;
                           var93.rotationZ = var4;
                           var93.field2250 = var24;
                           class33.method682(var93);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     long var40;
                     if(Client.packetOpcode == 64) {
                        var24 = Client.field541 + Client.field323.offset;
                        var4 = Client.field323.readUnsignedShort();
                        var32 = Client.field323.readUnsignedShort();
                        if(var4 != Client.widgetRoot) {
                           Client.widgetRoot = var4;
                           class41.method756(false);
                           class9.method120(Client.widgetRoot);
                           class5.method78(Client.widgetRoot);

                           for(var31 = 0; var31 < 100; ++var31) {
                              Client.field482[var31] = true;
                           }
                        }

                        WidgetNode var130;
                        for(; var32-- > 0; var130.field176 = true) {
                           var31 = Client.field323.method2819();
                           var33 = Client.field323.readUnsignedShort();
                           var34 = Client.field323.readUnsignedByte();
                           var130 = (WidgetNode)Client.componentTable.method2374((long)var31);
                           if(var130 != null && var33 != var130.id) {
                              class9.method117(var130, true);
                              var130 = null;
                           }

                           if(var130 == null) {
                              var130 = Client.method357(var31, var33, var34);
                           }
                        }

                        for(var102 = (WidgetNode)Client.componentTable.method2361(); null != var102; var102 = (WidgetNode)Client.componentTable.method2369()) {
                           if(var102.field176) {
                              var102.field176 = false;
                           } else {
                              class9.method117(var102, true);
                           }
                        }

                        Client.widgetFlags = new XHashTable(512);

                        while(Client.field323.offset < var24) {
                           var31 = Client.field323.method2819();
                           var33 = Client.field323.readUnsignedShort();
                           var34 = Client.field323.readUnsignedShort();
                           var123 = Client.field323.method2819();

                           for(var129 = var33; var129 <= var34; ++var129) {
                              var40 = ((long)var31 << 32) + (long)var129;
                              Client.widgetFlags.method2364(new class133(var123), var40);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 66) {
                        var24 = Client.field323.readUnsignedByte();
                        if(Client.field323.readUnsignedByte() == 0) {
                           Client.grandExchangeOffers[var24] = new XGrandExchangeOffer();
                           Client.field323.offset += 18;
                        } else {
                           --Client.field323.offset;
                           Client.grandExchangeOffers[var24] = new XGrandExchangeOffer(Client.field323, false);
                        }

                        Client.field470 = Client.field462;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 6) {
                        GameObject.method1915();
                        Client.packetOpcode = -1;
                        var1 = false;
                        break label3450;
                     }

                     if(Client.packetOpcode == 143) {
                        var118 = Client.field323.method2954() == 1;
                        var4 = Client.field323.method2858();
                        var81 = class37.method736(var4);
                        if(var118 != var81.isHidden) {
                           var81.isHidden = var118;
                           class33.method682(var81);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     class159 var78;
                     if(Client.packetOpcode == 100) {
                        Client.field323.offset += 28;
                        if(Client.field323.method2836()) {
                           var78 = Client.field323;
                           var4 = Client.field323.offset - 28;
                           if(class104.field1683 != null) {
                              try {
                                 class104.field1683.method1369(0L);
                                 class104.field1683.method1373(var78.payload, var4, 24);
                              } catch (Exception var65) {
                                 ;
                              }
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 47) {
                        var24 = Client.field323.method2819();
                        class30.field690 = class45.field899.method1954(var24);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 139) {
                        Widget.method3223(Client.field323, Client.field541);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 166) {
                        class13.method176();
                        Client.energy = Client.field323.readUnsignedByte();
                        Client.field474 = Client.field462;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 201) {
                        class13.method176();
                        Client.weight = Client.field323.readShort();
                        Client.field474 = Client.field462;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 159) {
                        var24 = Client.field323.method2831();
                        var4 = Client.field323.method2850();
                        var32 = var4 >> 10 & 31;
                        var31 = var4 >> 5 & 31;
                        var33 = var4 & 31;
                        var34 = (var31 << 11) + (var32 << 19) + (var33 << 3);
                        Widget var128 = class37.method736(var24);
                        if(var34 != var128.textColor) {
                           var128.textColor = var34;
                           class33.method682(var128);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 9) {
                        class30.xteaChanged(true);
                        Client.field323.method3040();
                        var24 = Client.field323.readUnsignedShort();
                        Widget.method3223(Client.field323, var24);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 225) {
                        var24 = Client.field323.method2819();
                        WidgetNode var135 = (WidgetNode)Client.componentTable.method2374((long)var24);
                        if(var135 != null) {
                           class9.method117(var135, true);
                        }

                        if(null != Client.field441) {
                           class33.method682(Client.field441);
                           Client.field441 = null;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 198) {
                        class13.method176();
                        var24 = Client.field323.method2858();
                        var4 = Client.field323.method2848();
                        var32 = Client.field323.method2842();
                        Client.skillExperiences[var32] = var24;
                        Client.boostedSkillLevels[var32] = var4;
                        Client.realSkillLevels[var32] = 1;

                        for(var31 = 0; var31 < 98; ++var31) {
                           if(var24 >= class172.field2345[var31]) {
                              Client.realSkillLevels[var32] = var31 + 2;
                           }
                        }

                        Client.field467[++Client.field468 - 1 & 31] = var32;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 254) {
                        var24 = Client.field323.method2827();
                        var4 = Client.field323.method2857();
                        var81 = class37.method736(var4);
                        if(var81.modelType != 2 || var81.modelId != var24) {
                           var81.modelType = 2;
                           var81.modelId = var24;
                           class33.method682(var81);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 132) {
                        Client.field471 = Client.field462;
                        if(Client.field541 == 0) {
                           Client.field504 = null;
                           Client.clanChatOwner = null;
                           class10.clanChatCount = 0;
                           Renderable.clanMembers = null;
                           Client.packetOpcode = -1;
                           var1 = true;
                        } else {
                           Client.clanChatOwner = Client.field323.method2846();
                           long var43 = Client.field323.method2820();
                           Client.field504 = class152.method2797(var43);
                           Friend.field149 = Client.field323.readByte();
                           var32 = Client.field323.readUnsignedByte();
                           if(var32 == 255) {
                              Client.packetOpcode = -1;
                              var1 = true;
                           } else {
                              class10.clanChatCount = var32;
                              XClanMember[] var100 = new XClanMember[100];

                              for(var33 = 0; var33 < class10.clanChatCount; ++var33) {
                                 var100[var33] = new XClanMember();
                                 var100[var33].username = Client.field323.method2846();
                                 var100[var33].field277 = FrameMap.method1697(var100[var33].username, FaceNormal.field1561);
                                 var100[var33].world = Client.field323.readUnsignedShort();
                                 var100[var33].rank = Client.field323.readByte();
                                 Client.field323.method2846();
                                 if(var100[var33].username.equals(class16.localPlayer.name)) {
                                    class109.field1742 = var100[var33].rank;
                                 }
                              }

                              var125 = false;
                              var123 = class10.clanChatCount;

                              while(var123 > 0) {
                                 var125 = true;
                                 --var123;

                                 for(var129 = 0; var129 < var123; ++var129) {
                                    if(var100[var129].field277.compareTo(var100[1 + var129].field277) > 0) {
                                       XClanMember var103 = var100[var129];
                                       var100[var129] = var100[1 + var129];
                                       var100[var129 + 1] = var103;
                                       var125 = false;
                                    }
                                 }

                                 if(var125) {
                                    break;
                                 }
                              }

                              Renderable.clanMembers = var100;
                              Client.packetOpcode = -1;
                              var1 = true;
                           }
                        }
                        break label3450;
                     }

                     if(Client.packetOpcode == 181) {
                        class30.xteaChanged(false);
                        Client.field323.method3040();
                        var24 = Client.field323.readUnsignedShort();
                        Widget.method3223(Client.field323, var24);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 244) {
                        byte var124 = Client.field323.method2844();
                        var4 = Client.field323.readUnsignedShort();
                        class165.settings[var4] = var124;
                        if(var124 != class165.widgetSettings[var4]) {
                           class165.widgetSettings[var4] = var124;
                        }

                        class37.method732(var4);
                        Client.field428[++Client.field458 - 1 & 31] = var4;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 18) {
                        var24 = Client.field323.method2827();
                        var4 = Client.field323.method2831();
                        class165.settings[var24] = var4;
                        if(var4 != class165.widgetSettings[var24]) {
                           class165.widgetSettings[var24] = var4;
                        }

                        class37.method732(var24);
                        Client.field428[++Client.field458 - 1 & 31] = var24;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 157) {
                        class7.method100(false);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 96) {
                        Client.field407 = Client.field323.readUnsignedByte();
                        if(Client.field407 == 1) {
                           Client.field499 = Client.field323.readUnsignedShort();
                        }

                        if(Client.field407 >= 2 && Client.field407 <= 6) {
                           if(Client.field407 == 2) {
                              Client.field356 = 64;
                              Client.field296 = 64;
                           }

                           if(Client.field407 == 3) {
                              Client.field356 = 0;
                              Client.field296 = 64;
                           }

                           if(Client.field407 == 4) {
                              Client.field356 = 128;
                              Client.field296 = 64;
                           }

                           if(Client.field407 == 5) {
                              Client.field356 = 64;
                              Client.field296 = 0;
                           }

                           if(Client.field407 == 6) {
                              Client.field356 = 64;
                              Client.field296 = 128;
                           }

                           Client.field407 = 2;
                           Client.field439 = Client.field323.readUnsignedShort();
                           Client.field549 = Client.field323.readUnsignedShort();
                           Client.field301 = Client.field323.readUnsignedByte();
                        }

                        if(Client.field407 == 10) {
                           Client.field321 = Client.field323.readUnsignedShort();
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 238) {
                        var3 = Client.field323.method2846();
                        Object[] var134 = new Object[var3.length() + 1];

                        for(var32 = var3.length() - 1; var32 >= 0; --var32) {
                           if(var3.charAt(var32) == 115) {
                              var134[var32 + 1] = Client.field323.method2846();
                           } else {
                              var134[var32 + 1] = new Integer(Client.field323.method2819());
                           }
                        }

                        var134[0] = new Integer(Client.field323.method2819());
                        class18 var106 = new class18();
                        var106.field188 = var134;
                        XItemContainer.method160(var106, 200000);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     String var6;
                     if(Client.packetOpcode == 133) {
                        while(Client.field323.offset < Client.field541) {
                           var24 = Client.field323.readUnsignedByte();
                           var108 = (var24 & 1) == 1;
                           var5 = Client.field323.method2846();
                           var6 = Client.field323.method2846();
                           Client.field323.method2846();

                           for(var33 = 0; var33 < Client.ignoreCount; ++var33) {
                              Ignore var101 = Client.ignores[var33];
                              if(var108) {
                                 if(var6.equals(var101.name)) {
                                    var101.name = var5;
                                    var101.previousName = var6;
                                    var5 = null;
                                    break;
                                 }
                              } else if(var5.equals(var101.name)) {
                                 var101.name = var5;
                                 var101.previousName = var6;
                                 var5 = null;
                                 break;
                              }
                           }

                           if(var5 != null && Client.ignoreCount < 400) {
                              Ignore var92 = new Ignore();
                              Client.ignores[Client.ignoreCount] = var92;
                              var92.name = var5;
                              var92.previousName = var6;
                              ++Client.ignoreCount;
                           }
                        }

                        Client.field416 = Client.field462;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 142) {
                        var24 = Client.field323.method2850();
                        var4 = Client.field323.method2819();
                        var81 = class37.method736(var4);
                        if(var81.modelType != 1 || var81.modelId != var24) {
                           var81.modelType = 1;
                           var81.modelId = var24;
                           class33.method682(var81);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 63) {
                        var24 = Client.field323.readUnsignedShort();
                        var4 = Client.field323.readUnsignedByte();
                        var32 = Client.field323.readUnsignedShort();
                        if(Client.field517 != 0 && var4 != 0 && Client.field370 < 50) {
                           Client.field520[Client.field370] = var24;
                           Client.field521[Client.field370] = var4;
                           Client.field522[Client.field370] = var32;
                           Client.field302[Client.field370] = null;
                           Client.field523[Client.field370] = 0;
                           ++Client.field370;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 62) {
                        class183.field2721 = Client.field323.readUnsignedByte();
                        class107.field1729 = Client.field323.method2842();

                        for(var24 = class107.field1729; var24 < 8 + class107.field1729; ++var24) {
                           for(var4 = class183.field2721; var4 < 8 + class183.field2721; ++var4) {
                              if(Client.groundItemDeque[WallObject.plane][var24][var4] != null) {
                                 Client.groundItemDeque[WallObject.plane][var24][var4] = null;
                                 class15.groundItemSpawned(var24, var4);
                              }
                           }
                        }

                        for(class25 var79 = (class25)Client.field410.method2412(); var79 != null; var79 = (class25)Client.field410.method2426()) {
                           if(var79.field560 >= class107.field1729 && var79.field560 < class107.field1729 + 8 && var79.field562 >= class183.field2721 && var79.field562 < class183.field2721 + 8 && WallObject.plane == var79.field565) {
                              var79.field570 = 0;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 184) {
                        class159.method3062(Client.field323.method2846());
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 20) {
                        class7.method100(true);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 23) {
                        Client.flagX = Client.field323.readUnsignedByte();
                        if(Client.flagX == 255) {
                           Client.flagX = 0;
                        }

                        Client.flagY = Client.field323.readUnsignedByte();
                        if(Client.flagY == 255) {
                           Client.flagY = 0;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 52) {
                        for(var24 = 0; var24 < class187.field2770; ++var24) {
                           class187 var99 = (class187)class187.field2772.get((long)var24);
                           class187 var133;
                           if(var99 != null) {
                              var133 = var99;
                           } else {
                              byte[] var96 = class187.field2775.getConfigData(16, var24);
                              var99 = new class187();
                              if(var96 != null) {
                                 var99.method3421(new Buffer(var96));
                              }

                              class187.field2772.put(var99, (long)var24);
                              var133 = var99;
                           }

                           if(var133 != null) {
                              class165.settings[var24] = 0;
                              class165.widgetSettings[var24] = 0;
                           }
                        }

                        class13.method176();
                        Client.field458 += 32;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     boolean var45;
                     int var46;
                     if(Client.packetOpcode == 21) {
                        var3 = Client.field323.method2846();
                        var25 = Client.field323.method2820();
                        var27 = (long)Client.field323.readUnsignedShort();
                        var36 = (long)Client.field323.read24BitInt();
                        class177 var10 = (class177)TextureProvider.method1454(CombatInfoListHolder.method696(), Client.field323.readUnsignedByte());
                        var40 = (var27 << 32) + var36;
                        var45 = false;

                        for(var46 = 0; var46 < 100; ++var46) {
                           if(var40 == Client.field361[var46]) {
                              var45 = true;
                              break;
                           }
                        }

                        if(var10.field2665 && class170.method3237(var3)) {
                           var45 = true;
                        }

                        if(!var45 && Client.field397 == 0) {
                           Client.field361[Client.field312] = var40;
                           Client.field312 = (1 + Client.field312) % 100;
                           class159 var119 = Client.field323;

                           String var113;
                           try {
                              int var47 = var119.method2979();
                              if(var47 > 32767) {
                                 var47 = 32767;
                              }

                              byte[] var18 = new byte[var47];
                              var119.offset += class210.field3117.method2745(var119.payload, var119.offset, var18, 0, var47);
                              String var117 = World.method610(var18, 0, var47);
                              var113 = var117;
                           } catch (Exception var64) {
                              var113 = "Cabbage";
                           }

                           var113 = FontTypeFace.method3919(class2.method22(var113));
                           if(var10.field2663 != -1) {
                              Projectile.addChatMessage(9, class167.method3163(var10.field2663) + var3, var113, class149.method2784(var25));
                           } else {
                              Projectile.addChatMessage(9, var3, var113, class149.method2784(var25));
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 84) {
                        class45.field898 = 0;

                        for(var24 = 0; var24 < 2048; ++var24) {
                           class45.field897[var24] = null;
                           class45.field910[var24] = 1;
                        }

                        for(var24 = 0; var24 < 2048; ++var24) {
                           Client.cachedPlayers[var24] = null;
                        }

                        World.method628(Client.field323);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 206) {
                        var24 = Client.field323.method2831();
                        var4 = Client.field323.method2827();
                        var32 = Client.field323.method2827();
                        var87 = class37.method736(var24);
                        var87.field2192 = (var32 << 16) + var4;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 224) {
                        var24 = Client.field323.method2819();
                        var4 = Client.field323.readUnsignedShort();
                        if(var24 < -70000) {
                           var4 += '耀';
                        }

                        if(var24 >= 0) {
                           var81 = class37.method736(var24);
                        } else {
                           var81 = null;
                        }

                        for(; Client.field323.offset < Client.field541; class167.method3162(var4, var31, var33 - 1, var34)) {
                           var31 = Client.field323.method2979();
                           var33 = Client.field323.readUnsignedShort();
                           var34 = 0;
                           if(var33 != 0) {
                              var34 = Client.field323.readUnsignedByte();
                              if(var34 == 255) {
                                 var34 = Client.field323.method2819();
                              }
                           }

                           if(null != var81 && var31 >= 0 && var31 < var81.itemIds.length) {
                              var81.itemIds[var31] = var33;
                              var81.itemQuantities[var31] = var34;
                           }
                        }

                        if(null != var81) {
                           class33.method682(var81);
                        }

                        class13.method176();
                        Client.interfaceItemTriggers[++Client.field466 - 1 & 31] = var4 & 32767;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 105) {
                        var24 = Client.field323.readUnsignedShort();
                        XItemContainer var132 = (XItemContainer)XItemContainer.itemContainers.method2374((long)var24);
                        if(null != var132) {
                           var132.unlink();
                        }

                        Client.interfaceItemTriggers[++Client.field466 - 1 & 31] = var24 & 32767;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     String var126;
                     if(Client.packetOpcode == 255) {
                        var78 = Client.field323;
                        var4 = Client.field541;
                        ClassInfo var85 = new ClassInfo();
                        var85.field3227 = var78.readUnsignedByte();
                        var85.field3221 = var78.method2819();
                        var85.field3224 = new int[var85.field3227];
                        var85.field3222 = new int[var85.field3227];
                        var85.fields = new Field[var85.field3227];
                        var85.field3220 = new int[var85.field3227];
                        var85.methods = new Method[var85.field3227];
                        var85.args = new byte[var85.field3227][][];

                        for(var31 = 0; var31 < var85.field3227; ++var31) {
                           try {
                              var33 = var78.readUnsignedByte();
                              String var97;
                              if(var33 != 0 && var33 != 1 && var33 != 2) {
                                 if(var33 == 3 || var33 == 4) {
                                    var97 = var78.method2846();
                                    var126 = var78.method2846();
                                    var129 = var78.readUnsignedByte();
                                    String[] var138 = new String[var129];

                                    for(var12 = 0; var12 < var129; ++var12) {
                                       var138[var12] = var78.method2846();
                                    }

                                    String var121 = var78.method2846();
                                    byte[][] var13 = new byte[var129][];
                                    if(var33 == 3) {
                                       for(var46 = 0; var46 < var129; ++var46) {
                                          var15 = var78.method2819();
                                          var13[var46] = new byte[var15];
                                          var78.method2824(var13[var46], 0, var15);
                                       }
                                    }

                                    var85.field3224[var31] = var33;
                                    Class[] var110 = new Class[var129];

                                    for(var15 = 0; var15 < var129; ++var15) {
                                       var110[var15] = class37.method733(var138[var15]);
                                    }

                                    Class var29 = class37.method733(var121);
                                    if(class37.method733(var97).getClassLoader() == null) {
                                       throw new SecurityException();
                                    }

                                    Method[] var16 = class37.method733(var97).getDeclaredMethods();
                                    Method[] var17 = var16;

                                    for(int var49 = 0; var49 < var17.length; ++var49) {
                                       Method var19 = var17[var49];
                                       if(Reflection.getMethodName(var19).equals(var126)) {
                                          Class[] var20 = Reflection.getParameterTypes(var19);
                                          if(var20.length == var110.length) {
                                             boolean var21 = true;

                                             for(int var22 = 0; var22 < var110.length; ++var22) {
                                                if(var110[var22] != var20[var22]) {
                                                   var21 = false;
                                                   break;
                                                }
                                             }

                                             if(var21 && var29 == var19.getReturnType()) {
                                                var85.methods[var31] = var19;
                                             }
                                          }
                                       }
                                    }

                                    var85.args[var31] = var13;
                                 }
                              } else {
                                 var97 = var78.method2846();
                                 var126 = var78.method2846();
                                 var129 = 0;
                                 if(var33 == 1) {
                                    var129 = var78.method2819();
                                 }

                                 var85.field3224[var31] = var33;
                                 var85.field3220[var31] = var129;
                                 if(class37.method733(var97).getClassLoader() == null) {
                                    throw new SecurityException();
                                 }

                                 var85.fields[var31] = Reflection.findField(class37.method733(var97), var126);
                              }
                           } catch (ClassNotFoundException var70) {
                              var85.field3222[var31] = -1;
                           } catch (SecurityException var71) {
                              var85.field3222[var31] = -2;
                           } catch (NullPointerException var72) {
                              var85.field3222[var31] = -3;
                           } catch (Exception var73) {
                              var85.field3222[var31] = -4;
                           } catch (Throwable var74) {
                              var85.field3222[var31] = -5;
                           }
                        }

                        class227.field3230.method2398(var85);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 168) {
                        var24 = Client.field323.method2850();
                        if(var24 == '\uffff') {
                           var24 = -1;
                        }

                        var4 = Client.field323.method2857();
                        var32 = Client.field323.method2831();
                        var87 = class37.method736(var32);
                        ItemComposition var86;
                        if(!var87.hasScript) {
                           if(var24 == -1) {
                              var87.modelType = 0;
                              Client.packetOpcode = -1;
                              var1 = true;
                              break label3450;
                           }

                           var86 = class36.getItemDefinition(var24);
                           var87.modelType = 4;
                           var87.modelId = var24;
                           var87.rotationX = var86.xan2d;
                           var87.rotationZ = var86.yan2d;
                           var87.field2250 = var86.zoom2d * 100 / var4;
                           class33.method682(var87);
                        } else {
                           var87.item = var24;
                           var87.stackSize = var4;
                           var86 = class36.getItemDefinition(var24);
                           var87.rotationX = var86.xan2d;
                           var87.rotationZ = var86.yan2d;
                           var87.rotationY = var86.zan2d;
                           var87.field2245 = var86.offsetX2d;
                           var87.field2247 = var86.offsetY2d;
                           var87.field2250 = var86.zoom2d;
                           if(var86.isStackable == 1) {
                              var87.field2187 = 1;
                           } else {
                              var87.field2187 = 2;
                           }

                           if(var87.field2199 > 0) {
                              var87.field2250 = var87.field2250 * 32 / var87.field2199;
                           } else if(var87.originalWidth > 0) {
                              var87.field2250 = var87.field2250 * 32 / var87.originalWidth;
                           }

                           class33.method682(var87);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 101) {
                        var24 = Client.field323.readUnsignedShort();
                        Client.widgetRoot = var24;
                        class41.method756(false);
                        class9.method120(var24);
                        class5.method78(Client.widgetRoot);

                        for(var4 = 0; var4 < 100; ++var4) {
                           Client.field482[var4] = true;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 248) {
                        Client.field513 = Client.field323.readUnsignedByte();
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 57) {
                        var24 = Client.field323.method2857();
                        var4 = Client.field323.readShort();
                        var81 = class37.method736(var24);
                        if(var81.field2243 != var4 || var4 == -1) {
                           var81.field2243 = var4;
                           var81.field2221 = 0;
                           var81.field2319 = 0;
                           class33.method682(var81);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 58) {
                        var24 = Client.field323.method2819();
                        var4 = Client.field323.method2819();
                        if(null == Item.field884 || !Item.field884.isValid()) {
                           try {
                              Iterator var82 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                              while(var82.hasNext()) {
                                 GarbageCollectorMXBean var89 = (GarbageCollectorMXBean)var82.next();
                                 if(var89.isValid()) {
                                    Item.field884 = var89;
                                    Client.field555 = -1L;
                                    Client.field374 = -1L;
                                 }
                              }
                           } catch (Throwable var69) {
                              ;
                           }
                        }

                        long var50 = FrameMap.method1695();
                        var33 = -1;
                        if(Item.field884 != null) {
                           var36 = Item.field884.getCollectionTime();
                           if(Client.field374 != -1L) {
                              long var52 = var36 - Client.field374;
                              long var54 = var50 - Client.field555;
                              if(var54 != 0L) {
                                 var33 = (int)(100L * var52 / var54);
                              }
                           }

                           Client.field374 = var36;
                           Client.field555 = var50;
                        }

                        Client.field394.method3037(205);
                        Client.field394.method2838(GameEngine.FPS);
                        Client.field394.method2855(var24);
                        Client.field394.method2847(var4);
                        Client.field394.method2799(var33);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 250) {
                        Client.field525 = true;
                        ChatLineBuffer.field973 = Client.field323.readUnsignedByte();
                        class5.field58 = Client.field323.readUnsignedByte();
                        class0.field1 = Client.field323.readUnsignedShort();
                        class65.field1112 = Client.field323.readUnsignedByte();
                        class15.field159 = Client.field323.readUnsignedByte();
                        if(class15.field159 >= 100) {
                           GameEngine.cameraX = 64 + ChatLineBuffer.field973 * 128;
                           class149.cameraY = class5.field58 * 128 + 64;
                           class40.cameraZ = class65.method1153(GameEngine.cameraX, class149.cameraY, WallObject.plane) - class0.field1;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 235) {
                        var24 = Client.field323.method2819();
                        var4 = Client.field323.readUnsignedShort();
                        if(var24 < -70000) {
                           var4 += '耀';
                        }

                        if(var24 >= 0) {
                           var81 = class37.method736(var24);
                        } else {
                           var81 = null;
                        }

                        if(var81 != null) {
                           for(var31 = 0; var31 < var81.itemIds.length; ++var31) {
                              var81.itemIds[var31] = 0;
                              var81.itemQuantities[var31] = 0;
                           }
                        }

                        class189.method3453(var4);
                        var31 = Client.field323.readUnsignedShort();

                        for(var33 = 0; var33 < var31; ++var33) {
                           var34 = Client.field323.method2933();
                           var123 = Client.field323.readUnsignedByte();
                           if(var123 == 255) {
                              var123 = Client.field323.method2858();
                           }

                           if(var81 != null && var33 < var81.itemIds.length) {
                              var81.itemIds[var33] = var34;
                              var81.itemQuantities[var33] = var123;
                           }

                           class167.method3162(var4, var33, var34 - 1, var123);
                        }

                        if(var81 != null) {
                           class33.method682(var81);
                        }

                        class13.method176();
                        Client.interfaceItemTriggers[++Client.field466 - 1 & 31] = var4 & 32767;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 45) {
                        for(var24 = 0; var24 < class165.widgetSettings.length; ++var24) {
                           if(class165.widgetSettings[var24] != class165.settings[var24]) {
                              class165.widgetSettings[var24] = class165.settings[var24];
                              class37.method732(var24);
                              Client.field428[++Client.field458 - 1 & 31] = var24;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 24) {
                        var24 = Client.field323.method2857();
                        var4 = Client.field323.method2851();
                        var32 = Client.field323.readShort();
                        var87 = class37.method736(var24);
                        if(var87.originalX != var32 || var4 != var87.originalY || var87.field2201 != 0 || var87.field2195 != 0) {
                           var87.originalX = var32;
                           var87.originalY = var4;
                           var87.field2201 = 0;
                           var87.field2195 = 0;
                           class33.method682(var87);
                           class172.method3239(var87);
                           if(var87.type == 0) {
                              Renderable.method1892(Widget.widgets[var24 >> 16], var87, false);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 69) {
                        var3 = Client.field323.method2846();
                        class159 var80 = Client.field323;

                        try {
                           var33 = var80.method2979();
                           if(var33 > 32767) {
                              var33 = 32767;
                           }

                           byte[] var94 = new byte[var33];
                           var80.offset += class210.field3117.method2745(var80.payload, var80.offset, var94, 0, var33);
                           var126 = World.method610(var94, 0, var33);
                           var6 = var126;
                        } catch (Exception var63) {
                           var6 = "Cabbage";
                        }

                        var6 = FontTypeFace.method3919(class2.method22(var6));
                        class103.sendGameMessage(6, var3, var6);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 215) {
                        var118 = Client.field323.readUnsignedByte() == 1;
                        if(var118) {
                           class15.field158 = FrameMap.method1695() - Client.field323.method2820();
                           class168.field2184 = new class1(Client.field323, true);
                        } else {
                           class168.field2184 = null;
                        }

                        Client.field473 = Client.field462;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 27) {
                        Client.field525 = true;
                        class152.field2086 = Client.field323.readUnsignedByte();
                        Player.field249 = Client.field323.readUnsignedByte();
                        class99.field1647 = Client.field323.readUnsignedShort();
                        class72.field1187 = Client.field323.readUnsignedByte();
                        MessageNode.field218 = Client.field323.readUnsignedByte();
                        if(MessageNode.field218 >= 100) {
                           var24 = 64 + class152.field2086 * 128;
                           var4 = 64 + Player.field249 * 128;
                           var32 = class65.method1153(var24, var4, WallObject.plane) - class99.field1647;
                           var31 = var24 - GameEngine.cameraX;
                           var33 = var32 - class40.cameraZ;
                           var34 = var4 - class149.cameraY;
                           var123 = (int)Math.sqrt((double)(var34 * var34 + var31 * var31));
                           class13.cameraPitch = (int)(Math.atan2((double)var33, (double)var123) * 325.949D) & 2047;
                           World.cameraYaw = (int)(Math.atan2((double)var31, (double)var34) * -325.949D) & 2047;
                           if(class13.cameraPitch < 128) {
                              class13.cameraPitch = 128;
                           }

                           if(class13.cameraPitch > 383) {
                              class13.cameraPitch = 383;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 234) {
                        Client.field495 = Client.field323.readUnsignedByte();
                        Client.field514 = Client.field323.readUnsignedByte();
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 106) {
                        var24 = Client.field323.method2857();
                        var131 = class37.method736(var24);

                        for(var32 = 0; var32 < var131.itemIds.length; ++var32) {
                           var131.itemIds[var32] = -1;
                           var131.itemIds[var32] = 0;
                        }

                        class33.method682(var131);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 43) {
                        var24 = Client.field323.method2858();
                        var131 = class37.method736(var24);
                        var131.modelType = 3;
                        var131.modelId = class16.localPlayer.composition.method3128();
                        class33.method682(var131);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 70) {
                        while(Client.field323.offset < Client.field541) {
                           var118 = Client.field323.readUnsignedByte() == 1;
                           var42 = Client.field323.method2846();
                           var5 = Client.field323.method2846();
                           var31 = Client.field323.readUnsignedShort();
                           var33 = Client.field323.readUnsignedByte();
                           var34 = Client.field323.readUnsignedByte();
                           var35 = (var34 & 2) != 0;
                           boolean var39 = (var34 & 1) != 0;
                           if(var31 > 0) {
                              Client.field323.method2846();
                              Client.field323.readUnsignedByte();
                              Client.field323.method2819();
                           }

                           Client.field323.method2846();

                           for(var11 = 0; var11 < Client.friendCount; ++var11) {
                              Friend var30 = Client.friends[var11];
                              if(!var118) {
                                 if(var42.equals(var30.name)) {
                                    if(var31 != var30.world) {
                                       var45 = true;

                                       for(class16 var14 = (class16)Client.field547.method2446(); var14 != null; var14 = (class16)Client.field547.method2448()) {
                                          if(var14.field169.equals(var42)) {
                                             if(var31 != 0 && var14.field170 == 0) {
                                                var14.method2451();
                                                var45 = false;
                                             } else if(var31 == 0 && var14.field170 != 0) {
                                                var14.method2451();
                                                var45 = false;
                                             }
                                          }
                                       }

                                       if(var45) {
                                          Client.field547.method2444(new class16(var42, var31));
                                       }

                                       var30.world = var31;
                                    }

                                    var30.previousName = var5;
                                    var30.rank = var33;
                                    var30.field146 = var35;
                                    var30.field148 = var39;
                                    var42 = null;
                                    break;
                                 }
                              } else if(var5.equals(var30.name)) {
                                 var30.name = var42;
                                 var30.previousName = var5;
                                 var42 = null;
                                 break;
                              }
                           }

                           if(var42 != null && Client.friendCount < 400) {
                              Friend var48 = new Friend();
                              Client.friends[Client.friendCount] = var48;
                              var48.name = var42;
                              var48.previousName = var5;
                              var48.world = var31;
                              var48.rank = var33;
                              var48.field146 = var35;
                              var48.field148 = var39;
                              ++Client.friendCount;
                           }
                        }

                        Client.field545 = 2;
                        Client.field416 = Client.field462;
                        var118 = false;
                        var4 = Client.friendCount;

                        while(var4 > 0) {
                           var118 = true;
                           --var4;

                           for(var32 = 0; var32 < var4; ++var32) {
                              var122 = false;
                              Friend var7 = Client.friends[var32];
                              Friend var8 = Client.friends[var32 + 1];
                              if(var7.world != Client.world && Client.world == var8.world) {
                                 var122 = true;
                              }

                              if(!var122 && var7.world == 0 && var8.world != 0) {
                                 var122 = true;
                              }

                              if(!var122 && !var7.field146 && var8.field146) {
                                 var122 = true;
                              }

                              if(!var122 && !var7.field148 && var8.field148) {
                                 var122 = true;
                              }

                              if(var122) {
                                 Friend var38 = Client.friends[var32];
                                 Client.friends[var32] = Client.friends[1 + var32];
                                 Client.friends[var32 + 1] = var38;
                                 var118 = false;
                              }
                           }

                           if(var118) {
                              break;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 134) {
                        Client.field525 = false;

                        for(var24 = 0; var24 < 5; ++var24) {
                           Client.field443[var24] = false;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     if(Client.packetOpcode == 153) {
                        class183.field2721 = Client.field323.method2842();
                        class107.field1729 = Client.field323.method2848();
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3450;
                     }

                     class65.method1151("" + Client.packetOpcode + "," + Client.field400 + "," + Client.field330 + "," + Client.field541, (Throwable)null);
                     GameObject.method1915();
                  } catch (IOException var75) {
                     if(Client.field331 > 0) {
                        GameObject.method1915();
                     } else {
                        class212.setGameState(40);
                        Client.field496 = Friend.field152;
                        Friend.field152 = null;
                     }
                  } catch (Exception var76) {
                     var3 = "" + Client.packetOpcode + "," + Client.field400 + "," + Client.field330 + "," + Client.field541 + "," + (Projectile.baseX + class16.localPlayer.pathX[0]) + "," + (class16.localPlayer.pathY[0] + class3.baseY) + ",";

                     for(var4 = 0; var4 < Client.field541 && var4 < 50; ++var4) {
                        var3 = var3 + Client.field323.payload[var4] + ",";
                     }

                     class65.method1151(var3, var76);
                     GameObject.method1915();
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
               ClassInfo var57 = (ClassInfo)class227.field3230.method2381();
               boolean var77;
               if(null == var57) {
                  var77 = false;
               } else {
                  var77 = true;
               }

               int var120;
               if(!var77) {
                  Object var58 = class45.field901.field214;
                  synchronized(class45.field901.field214) {
                     if(!Client.field375) {
                        class45.field901.field210 = 0;
                     } else if(class115.field1813 != 0 || class45.field901.field210 >= 40) {
                        Client.field394.method3037(88);
                        Client.field394.method2799(0);
                        var120 = Client.field394.offset;
                        var2 = 0;

                        for(var24 = 0; var24 < class45.field901.field210 && Client.field394.offset - var120 < 240; ++var24) {
                           ++var2;
                           var4 = class45.field901.field212[var24];
                           if(var4 < 0) {
                              var4 = 0;
                           } else if(var4 > 502) {
                              var4 = 502;
                           }

                           var32 = class45.field901.field211[var24];
                           if(var32 < 0) {
                              var32 = 0;
                           } else if(var32 > 764) {
                              var32 = 764;
                           }

                           var31 = var4 * 765 + var32;
                           if(class45.field901.field212[var24] == -1 && class45.field901.field211[var24] == -1) {
                              var32 = -1;
                              var4 = -1;
                              var31 = 524287;
                           }

                           if(var32 == Client.field290 && Client.field291 == var4) {
                              if(Client.field292 < 2047) {
                                 ++Client.field292;
                              }
                           } else {
                              var33 = var32 - Client.field290;
                              Client.field290 = var32;
                              var34 = var4 - Client.field291;
                              Client.field291 = var4;
                              if(Client.field292 < 8 && var33 >= -32 && var33 <= 31 && var34 >= -32 && var34 <= 31) {
                                 var33 += 32;
                                 var34 += 32;
                                 Client.field394.method2837((var33 << 6) + (Client.field292 << 12) + var34);
                                 Client.field292 = 0;
                              } else if(Client.field292 < 8) {
                                 Client.field394.method2801(var31 + (Client.field292 << 19) + 8388608);
                                 Client.field292 = 0;
                              } else {
                                 Client.field394.method2802((Client.field292 << 19) + -1073741824 + var31);
                                 Client.field292 = 0;
                              }
                           }
                        }

                        Client.field394.method2811(Client.field394.offset - var120);
                        if(var2 >= class45.field901.field210) {
                           class45.field901.field210 = 0;
                        } else {
                           class45.field901.field210 -= var2;

                           for(var24 = 0; var24 < class45.field901.field210; ++var24) {
                              class45.field901.field211[var24] = class45.field901.field211[var2 + var24];
                              class45.field901.field212[var24] = class45.field901.field212[var2 + var24];
                           }
                        }
                     }
                  }

                  if(class115.field1813 == 1 || !class48.field937 && class115.field1813 == 4 || class115.field1813 == 2) {
                     long var59 = (class115.field1799 - Client.field289) / 50L;
                     if(var59 > 4095L) {
                        var59 = 4095L;
                     }

                     Client.field289 = class115.field1799;
                     var2 = class115.field1812;
                     if(var2 < 0) {
                        var2 = 0;
                     } else if(var2 > class187.field2776) {
                        var2 = class187.field2776;
                     }

                     var24 = class115.field1811;
                     if(var24 < 0) {
                        var24 = 0;
                     } else if(var24 > class26.field577) {
                        var24 = class26.field577;
                     }

                     var4 = (int)var59;
                     Client.field394.method3037(110);
                     Client.field394.method2837((class115.field1813 == 2?1:0) + (var4 << 1));
                     Client.field394.method2837(var24);
                     Client.field394.method2837(var2);
                  }

                  if(class105.field1715 > 0) {
                     Client.field394.method3037(72);
                     Client.field394.method2837(0);
                     var0 = Client.field394.offset;
                     long var61 = FrameMap.method1695();

                     for(var24 = 0; var24 < class105.field1715; ++var24) {
                        var25 = var61 - Client.field503;
                        if(var25 > 16777215L) {
                           var25 = 16777215L;
                        }

                        Client.field503 = var61;
                        Client.field394.method2882((int)var25);
                        Client.field394.method2799(class105.field1714[var24]);
                     }

                     Client.field394.method2810(Client.field394.offset - var0);
                  }

                  if(Client.field369 > 0) {
                     --Client.field369;
                  }

                  if(class105.field1708[96] || class105.field1708[97] || class105.field1708[98] || class105.field1708[99]) {
                     Client.field435 = true;
                  }

                  if(Client.field435 && Client.field369 <= 0) {
                     Client.field369 = 20;
                     Client.field435 = false;
                     Client.field394.method3037(175);
                     Client.field394.method2870(Client.mapAngle);
                     Client.field394.method2837(Client.field383);
                  }

                  if(class177.field2668 && !Client.field293) {
                     Client.field293 = true;
                     Client.field394.method3037(41);
                     Client.field394.method2799(1);
                  }

                  if(!class177.field2668 && Client.field293) {
                     Client.field293 = false;
                     Client.field394.method3037(41);
                     Client.field394.method2799(0);
                  }

                  if(WallObject.plane != Client.field506) {
                     Client.field506 = WallObject.plane;
                     class159.method3057(WallObject.plane);
                  }

                  if(Client.gameState != 30) {
                     return;
                  }

                  for(class25 var144 = (class25)Client.field410.method2412(); null != var144; var144 = (class25)Client.field410.method2426()) {
                     if(var144.field570 > 0) {
                        --var144.field570;
                     }

                     if(var144.field570 == 0) {
                        if(var144.field563 < 0 || method207(var144.field563, var144.field571)) {
                           class105.method2014(var144.field565, var144.field559, var144.field560, var144.field562, var144.field563, var144.field564, var144.field571);
                           var144.unlink();
                        }
                     } else {
                        if(var144.field569 > 0) {
                           --var144.field569;
                        }

                        if(var144.field569 == 0 && var144.field560 >= 1 && var144.field562 >= 1 && var144.field560 <= 102 && var144.field562 <= 102 && (var144.field572 < 0 || method207(var144.field572, var144.field568))) {
                           class105.method2014(var144.field565, var144.field559, var144.field560, var144.field562, var144.field572, var144.field567, var144.field568);
                           var144.field569 = -1;
                           if(var144.field572 == var144.field563 && var144.field563 == -1) {
                              var144.unlink();
                           } else if(var144.field572 == var144.field563 && var144.field567 == var144.field564 && var144.field568 == var144.field571) {
                              var144.unlink();
                           }
                        }
                     }
                  }

                  Object var148;
                  for(var0 = 0; var0 < Client.field370; ++var0) {
                     --Client.field522[var0];
                     if(Client.field522[var0] >= -10) {
                        class53 var142 = Client.field302[var0];
                        if(null == var142) {
                           var148 = null;
                           var142 = class53.method957(class150.field2044, Client.field520[var0], 0);
                           if(null == var142) {
                              continue;
                           }

                           Client.field522[var0] += var142.method953();
                           Client.field302[var0] = var142;
                        }

                        if(Client.field522[var0] < 0) {
                           if(Client.field523[var0] != 0) {
                              var24 = 128 * (Client.field523[var0] & 255);
                              var4 = Client.field523[var0] >> 16 & 255;
                              var32 = 64 + 128 * var4 - class16.localPlayer.x;
                              if(var32 < 0) {
                                 var32 = -var32;
                              }

                              var31 = Client.field523[var0] >> 8 & 255;
                              var33 = 64 + var31 * 128 - class16.localPlayer.y;
                              if(var33 < 0) {
                                 var33 = -var33;
                              }

                              var34 = var33 + var32 - 128;
                              if(var34 > var24) {
                                 Client.field522[var0] = -100;
                                 continue;
                              }

                              if(var34 < 0) {
                                 var34 = 0;
                              }

                              var2 = (var24 - var34) * Client.field518 / var24;
                           } else {
                              var2 = Client.field517;
                           }

                           if(var2 > 0) {
                              class55 var84 = var142.method955().method995(class187.field2769);
                              class66 var136 = class66.method1214(var84, 100, var2);
                              var136.method1162(Client.field521[var0] - 1);
                              CombatInfoListHolder.field753.method898(var136);
                           }

                           Client.field522[var0] = -100;
                        }
                     } else {
                        --Client.field370;

                        for(var120 = var0; var120 < Client.field370; ++var120) {
                           Client.field520[var120] = Client.field520[var120 + 1];
                           Client.field302[var120] = Client.field302[1 + var120];
                           Client.field521[var120] = Client.field521[1 + var120];
                           Client.field522[var120] = Client.field522[1 + var120];
                           Client.field523[var120] = Client.field523[var120 + 1];
                        }

                        --var0;
                     }
                  }

                  if(Client.field516) {
                     if(class138.field1921 != 0) {
                        var77 = true;
                     } else {
                        var77 = class138.field1920.method2589();
                     }

                     if(!var77) {
                        if(Client.field536 != 0 && Client.field515 != -1) {
                           class48.method875(class227.field3228, Client.field515, 0, Client.field536, false);
                        }

                        Client.field516 = false;
                     }
                  }

                  ++Client.field326;
                  if(Client.field326 > 750) {
                     if(Client.field331 > 0) {
                        GameObject.method1915();
                     } else {
                        class212.setGameState(40);
                        Client.field496 = Friend.field152;
                        Friend.field152 = null;
                     }

                     return;
                  }

                  class18.method190();
                  TextureProvider.method1442();
                  int[] var146 = class45.field895;

                  for(var120 = 0; var120 < class45.field898; ++var120) {
                     Player var56 = Client.cachedPlayers[var146[var120]];
                     if(null != var56 && var56.field608 > 0) {
                        --var56.field608;
                        if(var56.field608 == 0) {
                           var56.overhead = null;
                        }
                     }
                  }

                  for(var120 = 0; var120 < Client.field316; ++var120) {
                     var2 = Client.field419[var120];
                     NPC var88 = Client.cachedNPCs[var2];
                     if(var88 != null && var88.field608 > 0) {
                        --var88.field608;
                        if(var88.field608 == 0) {
                           var88.overhead = null;
                        }
                     }
                  }

                  ++Client.field354;
                  if(Client.field371 != 0) {
                     Client.field388 += 20;
                     if(Client.field388 >= 400) {
                        Client.field371 = 0;
                     }
                  }

                  if(class57.field1063 != null) {
                     ++Client.field390;
                     if(Client.field390 >= 15) {
                        class33.method682(class57.field1063);
                        class57.field1063 = null;
                     }
                  }

                  Widget var147 = class15.field167;
                  Widget var145 = Ignore.field201;
                  class15.field167 = null;
                  Ignore.field201 = null;
                  Client.field454 = null;
                  Client.field448 = false;
                  Client.field337 = false;
                  Client.field500 = 0;

                  while(class65.method1142() && Client.field500 < 128) {
                     if(Client.field327 >= 2 && class105.field1708[82] && class109.field1744 == 66) {
                        String var140 = FaceNormal.method1893();
                        class15.field165.setContents(new StringSelection(var140), (ClipboardOwner)null);
                     } else {
                        Client.field447[Client.field500] = class109.field1744;
                        Client.field501[Client.field500] = VertexNormal.field1424;
                        ++Client.field500;
                     }
                  }

                  if(Client.widgetRoot != -1) {
                     var2 = Client.widgetRoot;
                     var24 = class26.field577;
                     var4 = class187.field2776;
                     if(class103.method1973(var2)) {
                        Actor.method596(Widget.widgets[var2], -1, 0, 0, var24, var4, 0, 0);
                     }
                  }

                  ++Client.field462;

                  while(true) {
                     Widget var90;
                     class18 var141;
                     do {
                        var141 = (class18)Client.field378.method2422();
                        if(var141 == null) {
                           while(true) {
                              do {
                                 var141 = (class18)Client.field478.method2422();
                                 if(var141 == null) {
                                    while(true) {
                                       do {
                                          var141 = (class18)Client.field476.method2422();
                                          if(null == var141) {
                                             boolean var91 = false;

                                             while(!var91) {
                                                var91 = true;

                                                for(var24 = 0; var24 < Client.menuOptionCount - 1; ++var24) {
                                                   if(Client.menuTypes[var24] < 1000 && Client.menuTypes[1 + var24] > 1000) {
                                                      var42 = Client.menuTargets[var24];
                                                      Client.menuTargets[var24] = Client.menuTargets[1 + var24];
                                                      Client.menuTargets[1 + var24] = var42;
                                                      var5 = Client.menuOptions[var24];
                                                      Client.menuOptions[var24] = Client.menuOptions[var24 + 1];
                                                      Client.menuOptions[var24 + 1] = var5;
                                                      var31 = Client.menuTypes[var24];
                                                      Client.menuTypes[var24] = Client.menuTypes[1 + var24];
                                                      Client.menuTypes[1 + var24] = var31;
                                                      var31 = Client.menuActionParams0[var24];
                                                      Client.menuActionParams0[var24] = Client.menuActionParams0[1 + var24];
                                                      Client.menuActionParams0[var24 + 1] = var31;
                                                      var31 = Client.menuActionParams1[var24];
                                                      Client.menuActionParams1[var24] = Client.menuActionParams1[var24 + 1];
                                                      Client.menuActionParams1[var24 + 1] = var31;
                                                      var31 = Client.menuIdentifiers[var24];
                                                      Client.menuIdentifiers[var24] = Client.menuIdentifiers[var24 + 1];
                                                      Client.menuIdentifiers[var24 + 1] = var31;
                                                      var91 = false;
                                                   }
                                                }
                                             }

                                             if(null == CombatInfoListHolder.field751 && null == Client.field368) {
                                                var2 = class115.field1813;
                                                if(Client.isMenuOpen) {
                                                   if(var2 != 1 && (class48.field937 || var2 != 4)) {
                                                      var24 = class115.field1805;
                                                      var4 = class115.field1814;
                                                      if(var24 < class185.menuX - 10 || var24 > class185.menuX + XClanMember.menuWidth + 10 || var4 < class103.menuY - 10 || var4 > class175.menuHeight + class103.menuY + 10) {
                                                         Client.isMenuOpen = false;
                                                         NPC.method717(class185.menuX, class103.menuY, XClanMember.menuWidth, class175.menuHeight);
                                                      }
                                                   }

                                                   if(var2 == 1 || !class48.field937 && var2 == 4) {
                                                      var24 = class185.menuX;
                                                      var4 = class103.menuY;
                                                      var32 = XClanMember.menuWidth;
                                                      var31 = class115.field1811;
                                                      var33 = class115.field1812;
                                                      var34 = -1;

                                                      for(var123 = 0; var123 < Client.menuOptionCount; ++var123) {
                                                         var129 = 31 + var4 + 15 * (Client.menuOptionCount - 1 - var123);
                                                         if(var31 > var24 && var31 < var24 + var32 && var33 > var129 - 13 && var33 < 3 + var129) {
                                                            var34 = var123;
                                                         }
                                                      }

                                                      if(var34 != -1) {
                                                         class13.method177(var34);
                                                      }

                                                      Client.isMenuOpen = false;
                                                      NPC.method717(class185.menuX, class103.menuY, XClanMember.menuWidth, class175.menuHeight);
                                                   }
                                                } else {
                                                   label3565: {
                                                      label3677: {
                                                         if((var2 == 1 || !class48.field937 && var2 == 4) && Client.menuOptionCount > 0) {
                                                            var24 = Client.menuTypes[Client.menuOptionCount - 1];
                                                            if(var24 == 39 || var24 == 40 || var24 == 41 || var24 == 42 || var24 == 43 || var24 == 33 || var24 == 34 || var24 == 35 || var24 == 36 || var24 == 37 || var24 == 38 || var24 == 1005) {
                                                               var4 = Client.menuActionParams0[Client.menuOptionCount - 1];
                                                               var32 = Client.menuActionParams1[Client.menuOptionCount - 1];
                                                               var87 = class37.method736(var32);
                                                               var34 = class36.method724(var87);
                                                               var125 = (var34 >> 28 & 1) != 0;
                                                               if(var125) {
                                                                  break label3677;
                                                               }

                                                               var148 = null;
                                                               if(PlayerComposition.method3153(class36.method724(var87))) {
                                                                  break label3677;
                                                               }
                                                            }
                                                         }

                                                         if(var2 == 1 || !class48.field937 && var2 == 4) {
                                                            label3670: {
                                                               if(Client.field384 != 1 || Client.menuOptionCount <= 2) {
                                                                  var4 = Client.menuOptionCount - 1;
                                                                  if(var4 < 0) {
                                                                     var118 = false;
                                                                  } else {
                                                                     var32 = Client.menuTypes[var4];
                                                                     if(var32 >= 2000) {
                                                                        var32 -= 2000;
                                                                     }

                                                                     if(var32 == 1007) {
                                                                        var118 = true;
                                                                     } else {
                                                                        var118 = false;
                                                                     }
                                                                  }

                                                                  if(!var118) {
                                                                     break label3670;
                                                                  }
                                                               }

                                                               var2 = 2;
                                                            }
                                                         }

                                                         if((var2 == 1 || !class48.field937 && var2 == 4) && Client.menuOptionCount > 0) {
                                                            class13.method177(Client.menuOptionCount - 1);
                                                         }

                                                         if(var2 == 2 && Client.menuOptionCount > 0) {
                                                            Spotanim.method3463(class115.field1811, class115.field1812);
                                                         }
                                                         break label3565;
                                                      }

                                                      if(null != CombatInfoListHolder.field751 && !Client.field396 && Client.field384 != 1) {
                                                         var129 = Client.menuOptionCount - 1;
                                                         if(var129 < 0) {
                                                            var35 = false;
                                                         } else {
                                                            var11 = Client.menuTypes[var129];
                                                            if(var11 >= 2000) {
                                                               var11 -= 2000;
                                                            }

                                                            if(var11 == 1007) {
                                                               var35 = true;
                                                            } else {
                                                               var35 = false;
                                                            }
                                                         }

                                                         if(!var35 && Client.menuOptionCount > 0) {
                                                            Client.method423(Client.field393, Client.field526);
                                                         }
                                                      }

                                                      Client.field396 = false;
                                                      Client.field320 = 0;
                                                      if(null != CombatInfoListHolder.field751) {
                                                         class33.method682(CombatInfoListHolder.field751);
                                                      }

                                                      CombatInfoListHolder.field751 = class37.method736(var32);
                                                      Client.field392 = var4;
                                                      Client.field393 = class115.field1811;
                                                      Client.field526 = class115.field1812;
                                                      if(Client.menuOptionCount > 0) {
                                                         var123 = Client.menuOptionCount - 1;
                                                         class15.field164 = new class38();
                                                         class15.field164.field794 = Client.menuActionParams0[var123];
                                                         class15.field164.field791 = Client.menuActionParams1[var123];
                                                         class15.field164.field790 = Client.menuTypes[var123];
                                                         class15.field164.field793 = Client.menuIdentifiers[var123];
                                                         class15.field164.field796 = Client.menuOptions[var123];
                                                      }

                                                      class33.method682(CombatInfoListHolder.field751);
                                                   }
                                                }
                                             }

                                             if(null != Client.field368) {
                                                class26.method575();
                                             }

                                             if(CombatInfoListHolder.field751 != null) {
                                                class33.method682(CombatInfoListHolder.field751);
                                                ++Client.field320;
                                                if(class115.field1804 == 0) {
                                                   if(Client.field396) {
                                                      if(class39.field802 == CombatInfoListHolder.field751 && Client.field395 != Client.field392) {
                                                         Widget var143 = CombatInfoListHolder.field751;
                                                         byte var139 = 0;
                                                         if(Client.field440 == 1 && var143.contentType == 206) {
                                                            var139 = 1;
                                                         }

                                                         if(var143.itemIds[Client.field395] <= 0) {
                                                            var139 = 0;
                                                         }

                                                         if(PlayerComposition.method3153(class36.method724(var143))) {
                                                            var4 = Client.field392;
                                                            var32 = Client.field395;
                                                            var143.itemIds[var32] = var143.itemIds[var4];
                                                            var143.itemQuantities[var32] = var143.itemQuantities[var4];
                                                            var143.itemIds[var4] = -1;
                                                            var143.itemQuantities[var4] = 0;
                                                         } else if(var139 == 1) {
                                                            var4 = Client.field392;
                                                            var32 = Client.field395;

                                                            while(var4 != var32) {
                                                               if(var4 > var32) {
                                                                  var143.method3206(var4 - 1, var4);
                                                                  --var4;
                                                               } else if(var4 < var32) {
                                                                  var143.method3206(var4 + 1, var4);
                                                                  ++var4;
                                                               }
                                                            }
                                                         } else {
                                                            var143.method3206(Client.field395, Client.field392);
                                                         }

                                                         Client.field394.method3037(54);
                                                         Client.field394.method2802(CombatInfoListHolder.field751.id);
                                                         Client.field394.method2799(var139);
                                                         Client.field394.method2904(Client.field392);
                                                         Client.field394.method2870(Client.field395);
                                                      }
                                                   } else {
                                                      label3618: {
                                                         label2581: {
                                                            if(Client.field384 != 1) {
                                                               var24 = Client.menuOptionCount - 1;
                                                               if(var24 < 0) {
                                                                  var91 = false;
                                                               } else {
                                                                  var4 = Client.menuTypes[var24];
                                                                  if(var4 >= 2000) {
                                                                     var4 -= 2000;
                                                                  }

                                                                  if(var4 == 1007) {
                                                                     var91 = true;
                                                                  } else {
                                                                     var91 = false;
                                                                  }
                                                               }

                                                               if(!var91) {
                                                                  break label2581;
                                                               }
                                                            }

                                                            if(Client.menuOptionCount > 2) {
                                                               Spotanim.method3463(Client.field393, Client.field526);
                                                               break label3618;
                                                            }
                                                         }

                                                         if(Client.menuOptionCount > 0) {
                                                            Client.method423(Client.field393, Client.field526);
                                                         }
                                                      }
                                                   }

                                                   Client.field390 = 10;
                                                   class115.field1813 = 0;
                                                   CombatInfoListHolder.field751 = null;
                                                } else if(Client.field320 >= 5 && (class115.field1805 > Client.field393 + 5 || class115.field1805 < Client.field393 - 5 || class115.field1814 > 5 + Client.field526 || class115.field1814 < Client.field526 - 5)) {
                                                   Client.field396 = true;
                                                }
                                             }

                                             if(Region.method1718()) {
                                                var2 = Region.field1505;
                                                var24 = Region.field1491;
                                                Client.field394.method3037(237);
                                                Client.field394.method2799(5);
                                                Client.field394.method2839(class105.field1708[82]?(class105.field1708[81]?2:1):0);
                                                Client.field394.method2904(class3.baseY + var24);
                                                Client.field394.method2904(Projectile.baseX + var2);
                                                Region.method1739();
                                                Client.field420 = class115.field1811;
                                                Client.field464 = class115.field1812;
                                                Client.field371 = 1;
                                                Client.field388 = 0;
                                                Client.flagX = var2;
                                                Client.flagY = var24;
                                             }

                                             if(var147 != class15.field167) {
                                                if(var147 != null) {
                                                   class33.method682(var147);
                                                }

                                                if(class15.field167 != null) {
                                                   class33.method682(class15.field167);
                                                }
                                             }

                                             if(Ignore.field201 != var145 && Client.field427 == Client.field507) {
                                                if(null != var145) {
                                                   class33.method682(var145);
                                                }

                                                if(Ignore.field201 != null) {
                                                   class33.method682(Ignore.field201);
                                                }
                                             }

                                             if(Ignore.field201 != null) {
                                                if(Client.field427 < Client.field507) {
                                                   ++Client.field427;
                                                   if(Client.field427 == Client.field507) {
                                                      class33.method682(Ignore.field201);
                                                   }
                                                }
                                             } else if(Client.field427 > 0) {
                                                --Client.field427;
                                             }

                                             var2 = class16.localPlayer.x + Client.field362;
                                             var24 = Client.field344 + class16.localPlayer.y;
                                             if(class44.field891 - var2 < -500 || class44.field891 - var2 > 500 || class13.field122 - var24 < -500 || class13.field122 - var24 > 500) {
                                                class44.field891 = var2;
                                                class13.field122 = var24;
                                             }

                                             if(class44.field891 != var2) {
                                                class44.field891 += (var2 - class44.field891) / 16;
                                             }

                                             if(class13.field122 != var24) {
                                                class13.field122 += (var24 - class13.field122) / 16;
                                             }

                                             if(class115.field1804 == 4 && class48.field937) {
                                                var4 = class115.field1814 - Client.field367;
                                                Client.field365 = var4 * 2;
                                                Client.field367 = var4 != -1 && var4 != 1?(class115.field1814 + Client.field367) / 2:class115.field1814;
                                                var32 = Client.field366 - class115.field1805;
                                                Client.field364 = var32 * 2;
                                                Client.field366 = var32 != -1 && var32 != 1?(Client.field366 + class115.field1805) / 2:class115.field1805;
                                             } else {
                                                if(class105.field1708[96]) {
                                                   Client.field364 += (-24 - Client.field364) / 2;
                                                } else if(class105.field1708[97]) {
                                                   Client.field364 += (24 - Client.field364) / 2;
                                                } else {
                                                   Client.field364 /= 2;
                                                }

                                                if(class105.field1708[98]) {
                                                   Client.field365 += (12 - Client.field365) / 2;
                                                } else if(class105.field1708[99]) {
                                                   Client.field365 += (-12 - Client.field365) / 2;
                                                } else {
                                                   Client.field365 /= 2;
                                                }

                                                Client.field367 = class115.field1814;
                                                Client.field366 = class115.field1805;
                                             }

                                             Client.mapAngle = Client.mapAngle + Client.field364 / 2 & 2047;
                                             Client.field383 += Client.field365 / 2;
                                             if(Client.field383 < 128) {
                                                Client.field383 = 128;
                                             }

                                             if(Client.field383 > 383) {
                                                Client.field383 = 383;
                                             }

                                             var4 = class44.field891 >> 7;
                                             var32 = class13.field122 >> 7;
                                             var31 = class65.method1153(class44.field891, class13.field122, WallObject.plane);
                                             var33 = 0;
                                             if(var4 > 3 && var32 > 3 && var4 < 100 && var32 < 100) {
                                                for(var34 = var4 - 4; var34 <= var4 + 4; ++var34) {
                                                   for(var123 = var32 - 4; var123 <= 4 + var32; ++var123) {
                                                      var129 = WallObject.plane;
                                                      if(var129 < 3 && (class10.tileSettings[1][var34][var123] & 2) == 2) {
                                                         ++var129;
                                                      }

                                                      var11 = var31 - class10.tileHeights[var129][var34][var123];
                                                      if(var11 > var33) {
                                                         var33 = var11;
                                                      }
                                                   }
                                                }
                                             }

                                             var34 = 192 * var33;
                                             if(var34 > 98048) {
                                                var34 = 98048;
                                             }

                                             if(var34 < '耀') {
                                                var34 = '耀';
                                             }

                                             if(var34 > Client.field519) {
                                                Client.field519 += (var34 - Client.field519) / 24;
                                             } else if(var34 < Client.field519) {
                                                Client.field519 += (var34 - Client.field519) / 80;
                                             }

                                             if(Client.field525) {
                                                XGrandExchangeOffer.method59();
                                             }

                                             for(var2 = 0; var2 < 5; ++var2) {
                                                ++Client.field530[var2];
                                             }

                                             Tile.chatMessages.method831();
                                             var2 = class57.method1022();
                                             var24 = class25.method572();
                                             if(var2 > 15000 && var24 > 15000) {
                                                Client.field331 = 250;
                                                class115.mouseIdleTicks = 14500;
                                                Client.field394.method3037(55);
                                             }

                                             ++Client.field463;
                                             if(Client.field463 > 500) {
                                                Client.field463 = 0;
                                                var4 = (int)(Math.random() * 8.0D);
                                                if((var4 & 1) == 1) {
                                                   Client.field362 += Client.field299;
                                                }

                                                if((var4 & 2) == 2) {
                                                   Client.field344 += Client.field417;
                                                }

                                                if((var4 & 4) == 4) {
                                                   Client.field346 += Client.field347;
                                                }
                                             }

                                             if(Client.field362 < -50) {
                                                Client.field299 = 2;
                                             }

                                             if(Client.field362 > 50) {
                                                Client.field299 = -2;
                                             }

                                             if(Client.field344 < -55) {
                                                Client.field417 = 2;
                                             }

                                             if(Client.field344 > 55) {
                                                Client.field417 = -2;
                                             }

                                             if(Client.field346 < -40) {
                                                Client.field347 = 1;
                                             }

                                             if(Client.field346 > 40) {
                                                Client.field347 = -1;
                                             }

                                             ++Client.field281;
                                             if(Client.field281 > 500) {
                                                Client.field281 = 0;
                                                var4 = (int)(Math.random() * 8.0D);
                                                if((var4 & 1) == 1) {
                                                   Client.mapScale += Client.field350;
                                                }

                                                if((var4 & 2) == 2) {
                                                   Client.mapScaleDelta += Client.field352;
                                                }
                                             }

                                             if(Client.mapScale < -60) {
                                                Client.field350 = 2;
                                             }

                                             if(Client.mapScale > 60) {
                                                Client.field350 = -2;
                                             }

                                             if(Client.mapScaleDelta < -20) {
                                                Client.field352 = 1;
                                             }

                                             if(Client.mapScaleDelta > 10) {
                                                Client.field352 = -1;
                                             }

                                             for(class16 var137 = (class16)Client.field547.method2446(); var137 != null; var137 = (class16)Client.field547.method2448()) {
                                                if((long)var137.field173 < FrameMap.method1695() / 1000L - 5L) {
                                                   if(var137.field170 > 0) {
                                                      class103.sendGameMessage(5, "", var137.field169 + " has logged in.");
                                                   }

                                                   if(var137.field170 == 0) {
                                                      class103.sendGameMessage(5, "", var137.field169 + " has logged out.");
                                                   }

                                                   var137.method2451();
                                                }
                                             }

                                             ++Client.field348;
                                             if(Client.field348 > 50) {
                                                Client.field394.method3037(249);
                                             }

                                             try {
                                                if(null != Friend.field152 && Client.field394.offset > 0) {
                                                   Friend.field152.method2073(Client.field394.payload, 0, Client.field394.offset);
                                                   Client.field394.offset = 0;
                                                   Client.field348 = 0;
                                                }
                                             } catch (IOException var67) {
                                                if(Client.field331 > 0) {
                                                   GameObject.method1915();
                                                } else {
                                                   class212.setGameState(40);
                                                   Client.field496 = Friend.field152;
                                                   Friend.field152 = null;
                                                }
                                             }

                                             return;
                                          }

                                          var90 = var141.field180;
                                          if(var90.index < 0) {
                                             break;
                                          }

                                          var131 = class37.method736(var90.parentId);
                                       } while(null == var131 || null == var131.children || var90.index >= var131.children.length || var131.children[var90.index] != var90);

                                       XItemContainer.method160(var141, 200000);
                                    }
                                 }

                                 var90 = var141.field180;
                                 if(var90.index < 0) {
                                    break;
                                 }

                                 var131 = class37.method736(var90.parentId);
                              } while(null == var131 || var131.children == null || var90.index >= var131.children.length || var90 != var131.children[var90.index]);

                              XItemContainer.method160(var141, 200000);
                           }
                        }

                        var90 = var141.field180;
                        if(var90.index < 0) {
                           break;
                        }

                        var131 = class37.method736(var90.parentId);
                     } while(null == var131 || null == var131.children || var90.index >= var131.children.length || var90 != var131.children[var90.index]);

                     XItemContainer.method160(var141, 200000);
                  }
               }

               Client.field394.method3037(177);
               Client.field394.method2799(0);
               var120 = Client.field394.offset;
               method218(Client.field394);
               Client.field394.method2811(Client.field394.offset - var120);
            }
         }
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1563795966"
   )
   static final int method215() {
      if(class107.field1733.field685) {
         return WallObject.plane;
      } else {
         int var0 = class65.method1153(GameEngine.cameraX, class149.cameraY, WallObject.plane);
         return var0 - class40.cameraZ < 800 && (class10.tileSettings[WallObject.plane][GameEngine.cameraX >> 7][class149.cameraY >> 7] & 4) != 0?WallObject.plane:3;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "781114362"
   )
   static boolean method216(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "1690186147"
   )
   public static int method217(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if(var7 == 8364) {
               var3[var4 + var6] = -128;
            } else if(var7 == 8218) {
               var3[var6 + var4] = -126;
            } else if(var7 == 402) {
               var3[var4 + var6] = -125;
            } else if(var7 == 8222) {
               var3[var6 + var4] = -124;
            } else if(var7 == 8230) {
               var3[var6 + var4] = -123;
            } else if(var7 == 8224) {
               var3[var6 + var4] = -122;
            } else if(var7 == 8225) {
               var3[var4 + var6] = -121;
            } else if(var7 == 710) {
               var3[var6 + var4] = -120;
            } else if(var7 == 8240) {
               var3[var4 + var6] = -119;
            } else if(var7 == 352) {
               var3[var4 + var6] = -118;
            } else if(var7 == 8249) {
               var3[var6 + var4] = -117;
            } else if(var7 == 338) {
               var3[var6 + var4] = -116;
            } else if(var7 == 381) {
               var3[var4 + var6] = -114;
            } else if(var7 == 8216) {
               var3[var4 + var6] = -111;
            } else if(var7 == 8217) {
               var3[var6 + var4] = -110;
            } else if(var7 == 8220) {
               var3[var6 + var4] = -109;
            } else if(var7 == 8221) {
               var3[var4 + var6] = -108;
            } else if(var7 == 8226) {
               var3[var6 + var4] = -107;
            } else if(var7 == 8211) {
               var3[var4 + var6] = -106;
            } else if(var7 == 8212) {
               var3[var6 + var4] = -105;
            } else if(var7 == 732) {
               var3[var6 + var4] = -104;
            } else if(var7 == 8482) {
               var3[var6 + var4] = -103;
            } else if(var7 == 353) {
               var3[var6 + var4] = -102;
            } else if(var7 == 8250) {
               var3[var6 + var4] = -101;
            } else if(var7 == 339) {
               var3[var4 + var6] = -100;
            } else if(var7 == 382) {
               var3[var4 + var6] = -98;
            } else if(var7 == 376) {
               var3[var6 + var4] = -97;
            } else {
               var3[var4 + var6] = 63;
            }
         } else {
            var3[var4 + var6] = (byte)var7;
         }
      }

      return var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)V",
      garbageValue = "1711853017"
   )
   public static void method218(class159 var0) {
      ClassInfo var1 = (ClassInfo)class227.field3230.method2381();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.method2802(var1.field3221);

         for(int var3 = 0; var3 < var1.field3227; ++var3) {
            if(var1.field3222[var3] != 0) {
               var0.method2799(var1.field3222[var3]);
            } else {
               try {
                  int var4 = var1.field3224[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = Reflection.getInt(var5, (Object)null);
                     var0.method2799(0);
                     var0.method2802(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     Reflection.setInt(var5, (Object)null, var1.field3220[var3]);
                     var0.method2799(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.method2799(0);
                     var0.method2802(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.method2799(0);
                        var0.method2802(var6);
                     }
                  } else {
                     var25 = var1.methods[var3];
                     byte[][] var10 = var1.args[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = Reflection.invoke(var25, (Object)null, var7);
                     if(var11 == null) {
                        var0.method2799(0);
                     } else if(var11 instanceof Number) {
                        var0.method2799(1);
                        var0.method2804(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.method2799(2);
                        var0.method2805((String)var11);
                     } else {
                        var0.method2799(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.method2799(-10);
               } catch (InvalidClassException var14) {
                  var0.method2799(-11);
               } catch (StreamCorruptedException var15) {
                  var0.method2799(-12);
               } catch (OptionalDataException var16) {
                  var0.method2799(-13);
               } catch (IllegalAccessException var17) {
                  var0.method2799(-14);
               } catch (IllegalArgumentException var18) {
                  var0.method2799(-15);
               } catch (InvocationTargetException var19) {
                  var0.method2799(-16);
               } catch (SecurityException var20) {
                  var0.method2799(-17);
               } catch (IOException var21) {
                  var0.method2799(-18);
               } catch (NullPointerException var22) {
                  var0.method2799(-19);
               } catch (Exception var23) {
                  var0.method2799(-20);
               } catch (Throwable var24) {
                  var0.method2799(-21);
               }
            }
         }

         var0.method2856(var2);
         var1.unlink();
      }
   }
}
