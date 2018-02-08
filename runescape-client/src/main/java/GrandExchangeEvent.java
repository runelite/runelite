import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
@Implements("GrandExchangeEvent")
public class GrandExchangeEvent {
   @ObfuscatedName("np")
   static boolean field282;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2040760217
   )
   @Export("world")
   public final int world;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 8135798737829601461L
   )
   public final long field277;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   @Export("grandExchangeOffer")
   public final GrandExchangeOffer grandExchangeOffer;
   @ObfuscatedName("h")
   @Export("string1")
   String string1;
   @ObfuscatedName("i")
   @Export("string2")
   String string2;

   @ObfuscatedSignature(
      signature = "(Lgy;BI)V"
   )
   GrandExchangeEvent(Buffer var1, byte var2, int var3) {
      this.string1 = var1.readString();
      this.string2 = var1.readString();
      this.world = var1.readUnsignedShort();
      this.field277 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.grandExchangeOffer = new GrandExchangeOffer();
      this.grandExchangeOffer.method106(2);
      this.grandExchangeOffer.method102(var2);
      this.grandExchangeOffer.price = var4;
      this.grandExchangeOffer.totalQuantity = var5;
      this.grandExchangeOffer.quantitySold = 0;
      this.grandExchangeOffer.spent = 0;
      this.grandExchangeOffer.itemId = var3;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "139522083"
   )
   public String method79() {
      return this.string1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1009956530"
   )
   public String method86() {
      return this.string2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "-1699745972"
   )
   public static void method78(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgt;I)V",
      garbageValue = "627559294"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = GroundObject.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field822 = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - ClanMemberManager.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - WorldMapData.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      class60.plane = var2.field827 = var4;
      if(class92.field1398[var1] != null) {
         var2.decodeApperance(class92.field1398[var1]);
      }

      class92.playerIndexesCount = 0;
      class92.playerIndices[++class92.playerIndexesCount - 1] = var1;
      class92.field1389[var1] = 0;
      class92.field1394 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class92.Players_regions[var7] = (var10 << 14) + var11 + (var9 << 28);
            class92.Players_orientations[var7] = 0;
            class92.Players_targetIndices[var7] = -1;
            class92.field1402[++class92.field1394 - 1] = var7;
            class92.field1389[var7] = 0;
         }
      }

      var0.byteAccess();
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "616900433"
   )
   static final int method88() {
      if(WorldComparator.preferences.hideRoofs) {
         return class60.plane;
      } else {
         int var0 = 3;
         if(ScriptEvent.cameraPitch < 310) {
            int var1 = class89.cameraX >> 7;
            int var2 = class3.cameraY >> 7;
            int var3 = GroundObject.localPlayer.x >> 7;
            int var4 = GroundObject.localPlayer.y >> 7;
            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return class60.plane;
            }

            if((class62.tileSettings[class60.plane][var1][var2] & 4) != 0) {
               var0 = class60.plane;
            }

            int var5;
            if(var3 > var1) {
               var5 = var3 - var1;
            } else {
               var5 = var1 - var3;
            }

            int var6;
            if(var4 > var2) {
               var6 = var4 - var2;
            } else {
               var6 = var2 - var4;
            }

            int var7;
            int var8;
            if(var5 > var6) {
               var7 = var6 * 65536 / var5;
               var8 = 32768;

               while(var1 != var3) {
                  if(var1 < var3) {
                     ++var1;
                  } else if(var1 > var3) {
                     --var1;
                  }

                  if((class62.tileSettings[class60.plane][var1][var2] & 4) != 0) {
                     var0 = class60.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var2 < var4) {
                        ++var2;
                     } else if(var2 > var4) {
                        --var2;
                     }

                     if((class62.tileSettings[class60.plane][var1][var2] & 4) != 0) {
                        var0 = class60.plane;
                     }
                  }
               }
            } else {
               var7 = var5 * 65536 / var6;
               var8 = 32768;

               while(var4 != var2) {
                  if(var2 < var4) {
                     ++var2;
                  } else if(var2 > var4) {
                     --var2;
                  }

                  if((class62.tileSettings[class60.plane][var1][var2] & 4) != 0) {
                     var0 = class60.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var1 < var3) {
                        ++var1;
                     } else if(var1 > var3) {
                        --var1;
                     }

                     if((class62.tileSettings[class60.plane][var1][var2] & 4) != 0) {
                        var0 = class60.plane;
                     }
                  }
               }
            }
         }

         if(GroundObject.localPlayer.x >= 0 && GroundObject.localPlayer.y >= 0 && GroundObject.localPlayer.x < 13312 && GroundObject.localPlayer.y < 13312) {
            if((class62.tileSettings[class60.plane][GroundObject.localPlayer.x >> 7][GroundObject.localPlayer.y >> 7] & 4) != 0) {
               var0 = class60.plane;
            }

            return var0;
         } else {
            return class60.plane;
         }
      }
   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "([Lhs;II)V",
      garbageValue = "-1842034019"
   )
   static final void method80(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !ContextMenuRow.method1877(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.hasScript && ContextMenuRow.method1877(var3) && var3 != KeyFocusListener.field624) {
                  continue;
               }

               method80(var0, var3.id);
               if(var3.children != null) {
                  method80(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  var5 = var4.id;
                  if(ServerPacket.loadWidget(var5)) {
                     method80(ScriptState.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2801 != -1 || var3.field2831 != -1) {
                  boolean var7 = class43.method600(var3);
                  if(var7) {
                     var5 = var3.field2831;
                  } else {
                     var5 = var3.field2801;
                  }

                  if(var5 != -1) {
                     Sequence var6 = FileRequest.getAnimation(var5);

                     for(var3.field2889 += Client.field1091; var3.field2889 > var6.frameLenghts[var3.field2876]; class33.method341(var3)) {
                        var3.field2889 -= var6.frameLenghts[var3.field2876];
                        ++var3.field2876;
                        if(var3.field2876 >= var6.frameIDs.length) {
                           var3.field2876 -= var6.frameStep;
                           if(var3.field2876 < 0 || var3.field2876 >= var6.frameIDs.length) {
                              var3.field2876 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2810 != 0 && !var3.hasScript) {
                  int var8 = var3.field2810 >> 16;
                  var5 = var3.field2810 << 16 >> 16;
                  var8 *= Client.field1091;
                  var5 *= Client.field1091;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class33.method341(var3);
               }
            }
         }
      }

   }
}
