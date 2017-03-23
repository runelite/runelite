import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("x")
   @Export("itemContainers")
   static XHashTable itemContainers = new XHashTable(32);
   @ObfuscatedName("j")
   @Export("itemIds")
   int[] itemIds = new int[]{-1};
   @ObfuscatedName("c")
   @Export("stackSizes")
   int[] stackSizes = new int[]{0};
   @ObfuscatedName("d")
   static int[] field147;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = 1950189729
   )
   @Export("menuY")
   static int menuY;

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "-4"
   )
   static void method174(int var0, String var1) {
      int var2 = class45.field934;
      int[] var3 = class45.field925;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         Player var6 = Client.cachedPlayers[var3[var5]];
         if(null != var6 && var6 != class22.localPlayer && null != var6.name && var6.name.equalsIgnoreCase(var1)) {
            if(var0 == 1) {
               Client.secretCipherBuffer1.putOpcode(197);
               Client.secretCipherBuffer1.method2864(var3[var5]);
               Client.secretCipherBuffer1.method2855(0);
            } else if(var0 == 4) {
               Client.secretCipherBuffer1.putOpcode(98);
               Client.secretCipherBuffer1.method2855(0);
               Client.secretCipherBuffer1.method2909(var3[var5]);
            } else if(var0 == 6) {
               Client.secretCipherBuffer1.putOpcode(240);
               Client.secretCipherBuffer1.method2855(0);
               Client.secretCipherBuffer1.method2864(var3[var5]);
            } else if(var0 == 7) {
               Client.secretCipherBuffer1.putOpcode(101);
               Client.secretCipherBuffer1.method2864(var3[var5]);
               Client.secretCipherBuffer1.putByte(0);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class30.sendGameMessage(4, "", "Unable to find " + var1);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)LFrames;",
      garbageValue = "-1630323184"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field3057.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         var1 = class178.method3290(Sequence.field3054, Sequence.field3053, var0, false);
         if(null != var1) {
            Sequence.field3057.put(var1, (long)var0);
         }

         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "37"
   )
   public static void method188(Component var0) {
      var0.removeKeyListener(class105.keyboard);
      var0.removeFocusListener(class105.keyboard);
      class105.field1721 = -1;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1897459839"
   )
   static final void method189() {
      int var0;
      int var1;
      int var2;
      int var4;
      int var9;
      int var10;
      int var11;
      int var12;
      int var32;
      if(Client.packetOpcode == 97) {
         var0 = Client.secretCipherBuffer2.method2869();
         var1 = Client.secretCipherBuffer2.readLittleEndianShort();
         var2 = Client.secretCipherBuffer2.readUnsignedShort();
         byte var3 = Client.secretCipherBuffer2.method2863();
         var4 = Client.secretCipherBuffer2.readLittleEndianShort();
         byte var5 = Client.secretCipherBuffer2.method2897();
         byte var29 = Client.secretCipherBuffer2.method2897();
         byte var30 = Client.secretCipherBuffer2.method2861();
         var32 = Client.secretCipherBuffer2.method2858();
         var9 = class172.field2337 + (var32 >> 4 & 7);
         var10 = (var32 & 7) + MessageNode.field261;
         var11 = Client.secretCipherBuffer2.method2997();
         var12 = var11 >> 2;
         int var13 = var11 & 3;
         int var14 = Client.field361[var12];
         Player var15;
         if(Client.localInteractingIndex == var1) {
            var15 = class22.localPlayer;
         } else {
            var15 = Client.cachedPlayers[var1];
         }

         if(null != var15) {
            ObjectComposition var16 = class195.getObjectDefinition(var2);
            int var17;
            int var18;
            if(var13 != 1 && var13 != 3) {
               var17 = var16.sizeX;
               var18 = var16.sizeY;
            } else {
               var17 = var16.sizeY;
               var18 = var16.sizeX;
            }

            int var19 = (var17 >> 1) + var9;
            int var20 = (var17 + 1 >> 1) + var9;
            int var21 = (var18 >> 1) + var10;
            int var22 = var10 + (var18 + 1 >> 1);
            int[][] var23 = class10.tileHeights[class31.plane];
            int var24 = var23[var20][var21] + var23[var19][var21] + var23[var19][var22] + var23[var20][var22] >> 2;
            int var25 = (var9 << 7) + (var17 << 6);
            int var26 = (var18 << 6) + (var10 << 7);
            Model var27 = var16.method3654(var12, var13, var23, var25, var24, var26);
            if(var27 != null) {
               GroundObject.method1597(class31.plane, var9, var10, var14, -1, 0, 0, 1 + var4, 1 + var0);
               var15.totalLevel = var4 + Client.gameCycle;
               var15.field292 = Client.gameCycle + var0;
               var15.model = var27;
               var15.field280 = 128 * var9 + var17 * 64;
               var15.field288 = 64 * var18 + var10 * 128;
               var15.field279 = var24;
               byte var28;
               if(var29 > var30) {
                  var28 = var29;
                  var29 = var30;
                  var30 = var28;
               }

               if(var5 > var3) {
                  var28 = var5;
                  var5 = var3;
                  var3 = var28;
               }

               var15.field270 = var9 + var29;
               var15.field286 = var9 + var30;
               var15.field285 = var10 + var5;
               var15.field287 = var3 + var10;
            }
         }
      }

      int var35;
      int var36;
      int var41;
      int var42;
      if(Client.packetOpcode == 29) {
         var0 = Client.secretCipherBuffer2.readLittleEndianShort();
         var1 = Client.secretCipherBuffer2.readUnsignedByte();
         var2 = var1 >> 2;
         var35 = var1 & 3;
         var4 = Client.field361[var2];
         var36 = Client.secretCipherBuffer2.readUnsignedByte();
         var41 = (var36 >> 4 & 7) + class172.field2337;
         var42 = MessageNode.field261 + (var36 & 7);
         if(var41 >= 0 && var42 >= 0 && var41 < 103 && var42 < 103) {
            if(var4 == 0) {
               WallObject var8 = Friend.region.method1761(class31.plane, var41, var42);
               if(null != var8) {
                  var9 = var8.hash >> 14 & 32767;
                  if(var2 == 2) {
                     var8.renderable1 = new class49(var9, 2, 4 + var35, class31.plane, var41, var42, var0, false, var8.renderable1);
                     var8.renderable2 = new class49(var9, 2, 1 + var35 & 3, class31.plane, var41, var42, var0, false, var8.renderable2);
                  } else {
                     var8.renderable1 = new class49(var9, var2, var35, class31.plane, var41, var42, var0, false, var8.renderable1);
                  }
               }
            }

            if(var4 == 1) {
               DecorativeObject var38 = Friend.region.method1776(class31.plane, var41, var42);
               if(null != var38) {
                  var9 = var38.hash >> 14 & 32767;
                  if(var2 != 4 && var2 != 5) {
                     if(var2 == 6) {
                        var38.renderable1 = new class49(var9, 4, 4 + var35, class31.plane, var41, var42, var0, false, var38.renderable1);
                     } else if(var2 == 7) {
                        var38.renderable1 = new class49(var9, 4, 4 + (var35 + 2 & 3), class31.plane, var41, var42, var0, false, var38.renderable1);
                     } else if(var2 == 8) {
                        var38.renderable1 = new class49(var9, 4, 4 + var35, class31.plane, var41, var42, var0, false, var38.renderable1);
                        var38.renderable2 = new class49(var9, 4, (2 + var35 & 3) + 4, class31.plane, var41, var42, var0, false, var38.renderable2);
                     }
                  } else {
                     var38.renderable1 = new class49(var9, 4, var35, class31.plane, var41, var42, var0, false, var38.renderable1);
                  }
               }
            }

            if(var4 == 2) {
               GameObject var39 = Friend.region.method1777(class31.plane, var41, var42);
               if(var2 == 11) {
                  var2 = 10;
               }

               if(null != var39) {
                  var39.renderable = new class49(var39.hash >> 14 & 32767, var2, var35, class31.plane, var41, var42, var0, false, var39.renderable);
               }
            }

            if(var4 == 3) {
               GroundObject var40 = Friend.region.method1778(class31.plane, var41, var42);
               if(null != var40) {
                  var40.renderable = new class49(var40.hash >> 14 & 32767, 22, var35, class31.plane, var41, var42, var0, false, var40.renderable);
               }
            }
         }

      } else if(Client.packetOpcode == 23) {
         var0 = Client.secretCipherBuffer2.readUnsignedByte();
         var1 = class172.field2337 + (var0 >> 4 & 7);
         var2 = MessageNode.field261 + (var0 & 7);
         var35 = Client.secretCipherBuffer2.readUnsignedShort();
         var4 = Client.secretCipherBuffer2.readUnsignedShort();
         var36 = Client.secretCipherBuffer2.readUnsignedShort();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            Deque var37 = Client.groundItemDeque[class31.plane][var1][var2];
            if(var37 != null) {
               for(Item var7 = (Item)var37.method2448(); var7 != null; var7 = (Item)var37.method2445()) {
                  if((var35 & 32767) == var7.id && var4 == var7.quantity) {
                     var7.quantity = var36;
                     break;
                  }
               }

               XGrandExchangeOffer.groundItemSpawned(var1, var2);
            }
         }

      } else if(Client.packetOpcode == 73) {
         var0 = Client.secretCipherBuffer2.readUnsignedByte();
         var1 = (var0 >> 4 & 7) + class172.field2337;
         var2 = (var0 & 7) + MessageNode.field261;
         var35 = var1 + Client.secretCipherBuffer2.readByte();
         var4 = var2 + Client.secretCipherBuffer2.readByte();
         var36 = Client.secretCipherBuffer2.readShort();
         var41 = Client.secretCipherBuffer2.readUnsignedShort();
         var42 = Client.secretCipherBuffer2.readUnsignedByte() * 4;
         var32 = Client.secretCipherBuffer2.readUnsignedByte() * 4;
         var9 = Client.secretCipherBuffer2.readUnsignedShort();
         var10 = Client.secretCipherBuffer2.readUnsignedShort();
         var11 = Client.secretCipherBuffer2.readUnsignedByte();
         var12 = Client.secretCipherBuffer2.readUnsignedByte();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var35 >= 0 && var4 >= 0 && var35 < 104 && var4 < 104 && var41 != '\uffff') {
            var1 = 128 * var1 + 64;
            var2 = 128 * var2 + 64;
            var35 = var35 * 128 + 64;
            var4 = 64 + var4 * 128;
            Projectile var33 = new Projectile(var41, class31.plane, var1, var2, class1.method21(var1, var2, class31.plane) - var42, Client.gameCycle + var9, var10 + Client.gameCycle, var11, var12, var36, var32);
            var33.method862(var35, var4, class1.method21(var35, var4, class31.plane) - var32, var9 + Client.gameCycle);
            Client.projectiles.method2458(var33);
         }

      } else {
         Item var31;
         if(Client.packetOpcode == 143) {
            var0 = Client.secretCipherBuffer2.readLittleEndianShort();
            var1 = Client.secretCipherBuffer2.method2869();
            var2 = Client.secretCipherBuffer2.method2997();
            var35 = (var2 >> 4 & 7) + class172.field2337;
            var4 = (var2 & 7) + MessageNode.field261;
            if(var35 >= 0 && var4 >= 0 && var35 < 104 && var4 < 104) {
               var31 = new Item();
               var31.id = var0;
               var31.quantity = var1;
               if(Client.groundItemDeque[class31.plane][var35][var4] == null) {
                  Client.groundItemDeque[class31.plane][var35][var4] = new Deque();
               }

               Client.groundItemDeque[class31.plane][var35][var4].method2458(var31);
               XGrandExchangeOffer.groundItemSpawned(var35, var4);
            }

         } else if(Client.packetOpcode == 117) {
            var0 = Client.secretCipherBuffer2.method2997();
            var1 = var0 >> 2;
            var2 = var0 & 3;
            var35 = Client.field361[var1];
            var4 = Client.secretCipherBuffer2.method2869();
            var36 = Client.secretCipherBuffer2.method2997();
            var41 = (var36 >> 4 & 7) + class172.field2337;
            var42 = MessageNode.field261 + (var36 & 7);
            if(var41 >= 0 && var42 >= 0 && var41 < 104 && var42 < 104) {
               GroundObject.method1597(class31.plane, var41, var42, var35, var4, var1, var2, 0, -1);
            }

         } else {
            if(Client.packetOpcode == 168) {
               var0 = Client.secretCipherBuffer2.readUnsignedByte();
               var1 = class172.field2337 + (var0 >> 4 & 7);
               var2 = MessageNode.field261 + (var0 & 7);
               var35 = Client.secretCipherBuffer2.readUnsignedShort();
               var4 = Client.secretCipherBuffer2.readUnsignedByte();
               var36 = var4 >> 4 & 15;
               var41 = var4 & 7;
               var42 = Client.secretCipherBuffer2.readUnsignedByte();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  var32 = 1 + var36;
                  if(class22.localPlayer.pathX[0] >= var1 - var32 && class22.localPlayer.pathX[0] <= var32 + var1 && class22.localPlayer.pathY[0] >= var2 - var32 && class22.localPlayer.pathY[0] <= var32 + var2 && Client.field554 != 0 && var41 > 0 && Client.field419 < 50) {
                     Client.field556[Client.field419] = var35;
                     Client.field557[Client.field419] = var41;
                     Client.field558[Client.field419] = var42;
                     Client.field560[Client.field419] = null;
                     Client.field559[Client.field419] = (var1 << 16) + (var2 << 8) + var36;
                     ++Client.field419;
                  }
               }
            }

            if(Client.packetOpcode != 251) {
               if(Client.packetOpcode == 232) {
                  var0 = Client.secretCipherBuffer2.readUnsignedByte();
                  var1 = class172.field2337 + (var0 >> 4 & 7);
                  var2 = MessageNode.field261 + (var0 & 7);
                  var35 = Client.secretCipherBuffer2.readUnsignedShort();
                  var4 = Client.secretCipherBuffer2.readUnsignedByte();
                  var36 = Client.secretCipherBuffer2.readUnsignedShort();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var1 = 64 + var1 * 128;
                     var2 = 128 * var2 + 64;
                     class33 var6 = new class33(var35, class31.plane, var1, var2, class1.method21(var1, var2, class31.plane) - var4, var36, Client.gameCycle);
                     Client.field443.method2458(var6);
                  }

               } else if(Client.packetOpcode == 186) {
                  var0 = Client.secretCipherBuffer2.method2997();
                  var1 = class172.field2337 + (var0 >> 4 & 7);
                  var2 = (var0 & 7) + MessageNode.field261;
                  var35 = Client.secretCipherBuffer2.method2997();
                  var4 = var35 >> 2;
                  var36 = var35 & 3;
                  var41 = Client.field361[var4];
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     GroundObject.method1597(class31.plane, var1, var2, var41, -1, var4, var36, 0, -1);
                  }

               }
            } else {
               var0 = Client.secretCipherBuffer2.method2860();
               var1 = class172.field2337 + (var0 >> 4 & 7);
               var2 = (var0 & 7) + MessageNode.field261;
               var35 = Client.secretCipherBuffer2.readLittleEndianShort();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  Deque var34 = Client.groundItemDeque[class31.plane][var1][var2];
                  if(var34 != null) {
                     for(var31 = (Item)var34.method2448(); null != var31; var31 = (Item)var34.method2445()) {
                        if((var35 & 32767) == var31.id) {
                           var31.unlink();
                           break;
                        }
                     }

                     if(var34.method2448() == null) {
                        Client.groundItemDeque[class31.plane][var1][var2] = null;
                     }

                     XGrandExchangeOffer.groundItemSpawned(var1, var2);
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;B)V",
      garbageValue = "3"
   )
   static void method191(int var0, int var1, int var2, int var3, String var4) {
      Widget var5 = class40.method826(var1, var2);
      if(var5 != null) {
         if(null != var5.field2286) {
            class18 var7 = new class18();
            var7.field223 = var5;
            var7.field226 = var0;
            var7.field224 = var4;
            var7.field232 = var5.field2286;
            Frames.method1963(var7);
         }

         boolean var6 = true;
         if(var5.contentType > 0) {
            var6 = CombatInfoListHolder.method776(var5);
         }

         if(var6) {
            if(class97.method1989(class174.method3271(var5), var0 - 1)) {
               if(var0 == 1) {
                  Client.secretCipherBuffer1.putOpcode(168);
                  Client.secretCipherBuffer1.putInt(var1);
                  Client.secretCipherBuffer1.putShort(var2);
                  Client.secretCipherBuffer1.putShort(var3);
               }

               if(var0 == 2) {
                  Client.secretCipherBuffer1.putOpcode(34);
                  Client.secretCipherBuffer1.putInt(var1);
                  Client.secretCipherBuffer1.putShort(var2);
                  Client.secretCipherBuffer1.putShort(var3);
               }

               if(var0 == 3) {
                  Client.secretCipherBuffer1.putOpcode(86);
                  Client.secretCipherBuffer1.putInt(var1);
                  Client.secretCipherBuffer1.putShort(var2);
                  Client.secretCipherBuffer1.putShort(var3);
               }

               if(var0 == 4) {
                  Client.secretCipherBuffer1.putOpcode(186);
                  Client.secretCipherBuffer1.putInt(var1);
                  Client.secretCipherBuffer1.putShort(var2);
                  Client.secretCipherBuffer1.putShort(var3);
               }

               if(var0 == 5) {
                  Client.secretCipherBuffer1.putOpcode(103);
                  Client.secretCipherBuffer1.putInt(var1);
                  Client.secretCipherBuffer1.putShort(var2);
                  Client.secretCipherBuffer1.putShort(var3);
               }

               if(var0 == 6) {
                  Client.secretCipherBuffer1.putOpcode(76);
                  Client.secretCipherBuffer1.putInt(var1);
                  Client.secretCipherBuffer1.putShort(var2);
                  Client.secretCipherBuffer1.putShort(var3);
               }

               if(var0 == 7) {
                  Client.secretCipherBuffer1.putOpcode(185);
                  Client.secretCipherBuffer1.putInt(var1);
                  Client.secretCipherBuffer1.putShort(var2);
                  Client.secretCipherBuffer1.putShort(var3);
               }

               if(var0 == 8) {
                  Client.secretCipherBuffer1.putOpcode(63);
                  Client.secretCipherBuffer1.putInt(var1);
                  Client.secretCipherBuffer1.putShort(var2);
                  Client.secretCipherBuffer1.putShort(var3);
               }

               if(var0 == 9) {
                  Client.secretCipherBuffer1.putOpcode(148);
                  Client.secretCipherBuffer1.putInt(var1);
                  Client.secretCipherBuffer1.putShort(var2);
                  Client.secretCipherBuffer1.putShort(var3);
               }

               if(var0 == 10) {
                  Client.secretCipherBuffer1.putOpcode(204);
                  Client.secretCipherBuffer1.putInt(var1);
                  Client.secretCipherBuffer1.putShort(var2);
                  Client.secretCipherBuffer1.putShort(var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)LModIcon;",
      garbageValue = "-2032855418"
   )
   static ModIcon method192(class182 var0, int var1, int var2) {
      if(!class65.method1246(var0, var1, var2)) {
         return null;
      } else {
         ModIcon var4 = new ModIcon();
         var4.width = class203.field3083;
         var4.originalHeight = class225.field3232;
         var4.offsetX = field147[0];
         var4.offsetY = class203.field3085[0];
         var4.originalWidth = class225.field3233[0];
         var4.height = class225.field3231[0];
         var4.palette = class225.field3237;
         var4.pixels = RSCanvas.field1766[0];
         field147 = null;
         class203.field3085 = null;
         class225.field3233 = null;
         class225.field3231 = null;
         class225.field3237 = null;
         RSCanvas.field1766 = null;
         return var4;
      }
   }
}
