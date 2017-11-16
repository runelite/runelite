import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("k")
   public static short[] field1910;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 104162231
   )
   @Export("x")
   int x;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 672404471
   )
   @Export("y")
   int y;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1335564101
   )
   @Export("z")
   int z;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -589867877
   )
   @Export("magnitude")
   int magnitude;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      signature = "(Leh;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(ZLgd;I)V",
      garbageValue = "1321889907"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0, PacketBuffer var1) {
      Client.isDynamicRegion = var0;
      int var2;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      if(!Client.isDynamicRegion) {
         var2 = var1.method3290();
         int var3 = var1.method3290();
         var4 = var1.readUnsignedShort();
         class51.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               class51.xteaKeys[var5][var6] = var1.readInt();
            }
         }

         class87.mapRegions = new int[var4];
         class91.landMapFileIds = new int[var4];
         class41.landRegionFileIds = new int[var4];
         class111.field1578 = new byte[var4][];
         class89.field1320 = new byte[var4][];
         boolean var16 = false;
         if((var2 / 8 == 48 || var2 / 8 == 49) && var3 / 8 == 48) {
            var16 = true;
         }

         if(var2 / 8 == 48 && var3 / 8 == 148) {
            var16 = true;
         }

         var4 = 0;

         for(var6 = (var2 - 6) / 8; var6 <= (var2 + 6) / 8; ++var6) {
            for(var7 = (var3 - 6) / 8; var7 <= (var3 + 6) / 8; ++var7) {
               var8 = var7 + (var6 << 8);
               if(!var16 || var7 != 49 && var7 != 149 && var7 != 147 && var6 != 50 && (var6 != 49 || var7 != 47)) {
                  class87.mapRegions[var4] = var8;
                  class91.landMapFileIds[var4] = RSCanvas.indexMaps.getFile("m" + var6 + "_" + var7);
                  class41.landRegionFileIds[var4] = RSCanvas.indexMaps.getFile("l" + var6 + "_" + var7);
                  ++var4;
               }
            }
         }

         class8.method44(var2, var3, true);
      } else {
         var2 = var1.readUnsignedShort();
         boolean var15 = var1.method3215() == 1;
         var4 = var1.method3222();
         var5 = var1.readUnsignedShort();
         var1.bitAccess();

         int var9;
         for(var6 = 0; var6 < 4; ++var6) {
            for(var7 = 0; var7 < 13; ++var7) {
               for(var8 = 0; var8 < 13; ++var8) {
                  var9 = var1.getBits(1);
                  if(var9 == 1) {
                     Client.field1011[var6][var7][var8] = var1.getBits(26);
                  } else {
                     Client.field1011[var6][var7][var8] = -1;
                  }
               }
            }
         }

         var1.byteAccess();
         class51.xteaKeys = new int[var5][4];

         for(var6 = 0; var6 < var5; ++var6) {
            for(var7 = 0; var7 < 4; ++var7) {
               class51.xteaKeys[var6][var7] = var1.readInt();
            }
         }

         class87.mapRegions = new int[var5];
         class91.landMapFileIds = new int[var5];
         class41.landRegionFileIds = new int[var5];
         class111.field1578 = new byte[var5][];
         class89.field1320 = new byte[var5][];
         var5 = 0;

         for(var6 = 0; var6 < 4; ++var6) {
            for(var7 = 0; var7 < 13; ++var7) {
               for(var8 = 0; var8 < 13; ++var8) {
                  var9 = Client.field1011[var6][var7][var8];
                  if(var9 != -1) {
                     int var10 = var9 >> 14 & 1023;
                     int var11 = var9 >> 3 & 2047;
                     int var12 = (var10 / 8 << 8) + var11 / 8;

                     int var13;
                     for(var13 = 0; var13 < var5; ++var13) {
                        if(class87.mapRegions[var13] == var12) {
                           var12 = -1;
                           break;
                        }
                     }

                     if(var12 != -1) {
                        class87.mapRegions[var5] = var12;
                        var13 = var12 >> 8 & 255;
                        int var14 = var12 & 255;
                        class91.landMapFileIds[var5] = RSCanvas.indexMaps.getFile("m" + var13 + "_" + var14);
                        class41.landRegionFileIds[var5] = RSCanvas.indexMaps.getFile("l" + var13 + "_" + var14);
                        ++var5;
                     }
                  }
               }
            }
         }

         class8.method44(var2, var4, !var15);
      }

   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;I)V",
      garbageValue = "-151177864"
   )
   static void method2598(int var0, int var1, int var2, int var3, String var4) {
      Widget var5 = DecorativeObject.method2896(var1, var2);
      if(var5 != null) {
         if(var5.field2813 != null) {
            ScriptEvent var6 = new ScriptEvent();
            var6.widget = var5;
            var6.field783 = var0;
            var6.field784 = var4;
            var6.field785 = var5.field2813;
            BaseVarType.method11(var6);
         }

         boolean var11 = true;
         if(var5.contentType > 0) {
            var11 = BaseVarType.method13(var5);
         }

         if(var11) {
            int var8 = class12.getWidgetConfig(var5);
            int var9 = var0 - 1;
            boolean var7 = (var8 >> var9 + 1 & 1) != 0;
            if(var7) {
               PacketNode var10;
               if(var0 == 1) {
                  var10 = class18.method133(ClientPacket.field2355, Client.field905.field1460);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field905.method1855(var10);
               }

               if(var0 == 2) {
                  var10 = class18.method133(ClientPacket.field2313, Client.field905.field1460);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field905.method1855(var10);
               }

               if(var0 == 3) {
                  var10 = class18.method133(ClientPacket.field2305, Client.field905.field1460);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field905.method1855(var10);
               }

               if(var0 == 4) {
                  var10 = class18.method133(ClientPacket.field2341, Client.field905.field1460);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field905.method1855(var10);
               }

               if(var0 == 5) {
                  var10 = class18.method133(ClientPacket.field2364, Client.field905.field1460);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field905.method1855(var10);
               }

               if(var0 == 6) {
                  var10 = class18.method133(ClientPacket.field2332, Client.field905.field1460);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field905.method1855(var10);
               }

               if(var0 == 7) {
                  var10 = class18.method133(ClientPacket.field2390, Client.field905.field1460);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field905.method1855(var10);
               }

               if(var0 == 8) {
                  var10 = class18.method133(ClientPacket.field2335, Client.field905.field1460);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field905.method1855(var10);
               }

               if(var0 == 9) {
                  var10 = class18.method133(ClientPacket.field2388, Client.field905.field1460);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field905.method1855(var10);
               }

               if(var0 == 10) {
                  var10 = class18.method133(ClientPacket.field2392, Client.field905.field1460);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field905.method1855(var10);
               }

            }
         }
      }
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(Lbd;IIIB)V",
      garbageValue = "-35"
   )
   static final void method2597(Player var0, int var1, int var2, int var3) {
      if(class275.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            int var7;
            if(var0.totalLevel == 0) {
               String var5 = var0.actions[0] + var0.name + var0.actions[1];
               var7 = var0.combatLevel;
               int var8 = class275.localPlayer.combatLevel;
               int var9 = var8 - var7;
               String var6;
               if(var9 < -9) {
                  var6 = class222.getColTags(16711680);
               } else if(var9 < -6) {
                  var6 = class222.getColTags(16723968);
               } else if(var9 < -3) {
                  var6 = class222.getColTags(16740352);
               } else if(var9 < 0) {
                  var6 = class222.getColTags(16756736);
               } else if(var9 > 9) {
                  var6 = class222.getColTags(65280);
               } else if(var9 > 6) {
                  var6 = class222.getColTags(4259584);
               } else if(var9 > 3) {
                  var6 = class222.getColTags(8453888);
               } else if(var9 > 0) {
                  var6 = class222.getColTags(12648192);
               } else {
                  var6 = class222.getColTags(16776960);
               }

               var4 = var5 + var6 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var10;
            if(Client.itemSelectionState == 1) {
               WorldMapData.addMenuEntry("Use", Client.field1001 + " " + "->" + " " + class222.getColTags(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.spellSelected) {
               if((class28.field387 & 8) == 8) {
                  WorldMapData.addMenuEntry(Client.field1045, Client.field948 + " " + "->" + " " + class222.getColTags(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var10 = 7; var10 >= 0; --var10) {
                  if(Client.playerOptions[var10] != null) {
                     short var11 = 0;
                     if(Client.playerOptions[var10].equalsIgnoreCase("Attack")) {
                        if(Client.field1096 == class90.field1328) {
                           continue;
                        }

                        if(Client.field1096 == class90.field1322 || Client.field1096 == class90.field1325 && var0.combatLevel > class275.localPlayer.combatLevel) {
                           var11 = 2000;
                        }

                        if(class275.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == class275.localPlayer.team) {
                              var11 = 2000;
                           } else {
                              var11 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriorities[var10]) {
                        var11 = 2000;
                     }

                     boolean var12 = false;
                     var7 = Client.playerMenuTypes[var10] + var11;
                     WorldMapData.addMenuEntry(Client.playerOptions[var10], class222.getColTags(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var10 = 0; var10 < Client.menuOptionCount; ++var10) {
               if(Client.menuTypes[var10] == 23) {
                  Client.menuTargets[var10] = class222.getColTags(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
