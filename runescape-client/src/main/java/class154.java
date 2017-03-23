import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
public class class154 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 748305335
   )
   static int field2092 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -325233029
   )
   static int field2093 = 0;
   @ObfuscatedName("d")
   static byte[][] field2094 = new byte[1000][];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 263816377
   )
   static int field2095 = 0;
   @ObfuscatedName("h")
   static byte[][] field2097 = new byte[50][];
   @ObfuscatedName("w")
   static byte[][] field2099 = new byte[250][];

   class154() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1929886034"
   )
   static void method3038() {
      Client.field320 = -1L;
      Client.field314 = -1;
      Client.field321.field254 = 0;
      class101.field1661 = true;
      Client.field581 = true;
      Client.field539 = -1L;
      class57.method1152();
      Client.secretCipherBuffer1.offset = 0;
      Client.secretCipherBuffer2.offset = 0;
      Client.packetOpcode = -1;
      Client.field483 = -1;
      Client.field363 = -1;
      Client.field364 = -1;
      Client.field360 = 0;
      Client.field327 = 0;
      Client.field365 = 0;
      Client.field458 = 0;
      Client.menuOptionCount = 0;
      Client.field391 = -1;
      Client.isMenuOpen = false;
      class115.mouseIdleTicks = 0;
      class47.chatLineMap.clear();
      class47.field951.method2357();
      class47.field952.method2513();
      class47.field953 = 0;
      Client.field466 = 0;
      Client.field468 = false;
      Client.field419 = 0;
      Client.field376 = (int)(Math.random() * 100.0D) - 50;
      Client.field415 = (int)(Math.random() * 110.0D) - 55;
      Client.field380 = (int)(Math.random() * 80.0D) - 40;
      Client.mapScale = (int)(Math.random() * 120.0D) - 60;
      Client.mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
      Client.mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
      Client.field549 = 0;
      Client.field543 = -1;
      Client.flagX = 0;
      Client.flagY = 0;
      Client.field336 = class40.field836;
      Client.field337 = class40.field836;
      Client.field351 = 0;
      Spotanim.method3484();

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      for(var0 = 0; var0 < '耀'; ++var0) {
         Client.cachedNPCs[var0] = null;
      }

      Client.field407 = -1;
      Client.projectiles.method2442();
      Client.field443.method2442();

      int var2;
      for(var0 = 0; var0 < 4; ++var0) {
         for(int var1 = 0; var1 < 104; ++var1) {
            for(var2 = 0; var2 < 104; ++var2) {
               Client.groundItemDeque[var0][var1][var2] = null;
            }
         }
      }

      Client.field444 = new Deque();
      Client.field375 = 0;
      Client.friendCount = 0;
      Client.ignoreCount = 0;

      for(var0 = 0; var0 < class187.field2768; ++var0) {
         class187 var3 = class108.method2103(var0);
         if(null != var3) {
            class165.settings[var0] = 0;
            class165.widgetSettings[var0] = 0;
         }
      }

      class7.chatMessages.method922();
      Client.field481 = -1;
      if(Client.widgetRoot != -1) {
         var0 = Client.widgetRoot;
         if(var0 != -1 && NPC.validInterfaces[var0]) {
            Widget.field2269.method3318(var0);
            if(null != Widget.widgets[var0]) {
               boolean var5 = true;

               for(var2 = 0; var2 < Widget.widgets[var0].length; ++var2) {
                  if(null != Widget.widgets[var0][var2]) {
                     if(Widget.widgets[var0][var2].type != 2) {
                        Widget.widgets[var0][var2] = null;
                     } else {
                        var5 = false;
                     }
                  }
               }

               if(var5) {
                  Widget.widgets[var0] = null;
               }

               NPC.validInterfaces[var0] = false;
            }
         }
      }

      for(WidgetNode var4 = (WidgetNode)Client.componentTable.method2391(); null != var4; var4 = (WidgetNode)Client.componentTable.method2392()) {
         XGrandExchangeOffer.method65(var4, true);
      }

      Client.widgetRoot = -1;
      Client.componentTable = new XHashTable(8);
      Client.field477 = null;
      Client.menuOptionCount = 0;
      Client.field391 = -1;
      Client.isMenuOpen = false;
      Client.field576.method3183((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.playerOptions[var0] = null;
         Client.playerOptionsPriority[var0] = false;
      }

      class10.method167();
      Client.field318 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field518[var0] = true;
      }

      class45.method910();
      Client.field540 = null;
      class9.clanChatCount = 0;
      class137.clanMembers = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
      }

      class104.field1702 = null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1607567455"
   )
   static synchronized byte[] method3039(int var0) {
      byte[] var1;
      if(var0 == 100 && field2095 > 0) {
         var1 = field2094[--field2095];
         field2094[field2095] = null;
         return var1;
      } else if(var0 == 5000 && field2093 > 0) {
         var1 = field2099[--field2093];
         field2099[field2093] = null;
         return var1;
      } else if(var0 == 30000 && field2092 > 0) {
         var1 = field2097[--field2092];
         field2097[field2092] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILRegion;[LCollisionData;I)V",
      garbageValue = "-234347302"
   )
   static final void method3040(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Region var8, CollisionData[] var9) {
      Buffer var10 = new Buffer(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.method3013();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.method3013();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.readUnsignedByte();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var17 == var4 && var16 >= var5 && var16 < 8 + var5 && var15 >= var6 && var15 < var6 + 8) {
               ObjectComposition var21 = class195.getObjectDefinition(var11);
               int var24 = var16 & 7;
               int var25 = var15 & 7;
               int var27 = var21.sizeX;
               int var28 = var21.sizeY;
               int var29;
               if((var20 & 1) == 1) {
                  var29 = var27;
                  var27 = var28;
                  var28 = var29;
               }

               int var26 = var7 & 3;
               int var23;
               if(var26 == 0) {
                  var23 = var24;
               } else if(var26 == 1) {
                  var23 = var25;
               } else if(var26 == 2) {
                  var23 = 7 - var24 - (var27 - 1);
               } else {
                  var23 = 7 - var25 - (var28 - 1);
               }

               var29 = var2 + var23;
               int var32 = var16 & 7;
               int var33 = var15 & 7;
               int var35 = var21.sizeX;
               int var36 = var21.sizeY;
               int var37;
               if((var20 & 1) == 1) {
                  var37 = var35;
                  var35 = var36;
                  var36 = var37;
               }

               int var34 = var7 & 3;
               int var31;
               if(var34 == 0) {
                  var31 = var33;
               } else if(var34 == 1) {
                  var31 = 7 - var32 - (var35 - 1);
               } else if(var34 == 2) {
                  var31 = 7 - var33 - (var36 - 1);
               } else {
                  var31 = var32;
               }

               var37 = var31 + var3;
               if(var29 > 0 && var37 > 0 && var29 < 103 && var37 < 103) {
                  int var38 = var1;
                  if((class10.tileSettings[1][var29][var37] & 2) == 2) {
                     var38 = var1 - 1;
                  }

                  CollisionData var39 = null;
                  if(var38 >= 0) {
                     var39 = var9[var38];
                  }

                  class32.method751(var1, var29, var37, var11, var20 + var7 & 3, var19, var8, var39);
               }
            }
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "1690456127"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field2952.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.field2975.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method3657();
         if(var1.notedTemplate != -1) {
            var1.method3660(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.field2998 != -1) {
            var1.method3661(getItemDefinition(var1.field2998), getItemDefinition(var1.field2997));
         }

         if(var1.field3000 != -1) {
            var1.method3688(getItemDefinition(var1.field3000), getItemDefinition(var1.field2973));
         }

         if(!class47.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field2996 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.field2995 = 0;
         }

         ItemComposition.field2952.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BIII)Z",
      garbageValue = "-416009292"
   )
   static final boolean method3042(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label84:
      while(true) {
         int var6 = var4.method3013();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.method3013();
               if(var9 == 0) {
                  continue label84;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.readUnsignedByte() >> 2;
               int var13 = var11 + var1;
               int var14 = var2 + var10;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  ObjectComposition var15 = class195.getObjectDefinition(var5);
                  if(var12 != 22 || !Client.field439 || var15.field2913 != 0 || var15.field2911 == 1 || var15.field2932) {
                     if(!var15.method3617()) {
                        ++Client.field369;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.method3013();
            if(var9 == 0) {
               break;
            }

            var4.readUnsignedByte();
         }
      }
   }
}
