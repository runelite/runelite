import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class167 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -40724719
   )
   @Export("idxCount")
   public static int idxCount;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   @Export("randomDat")
   public static CacheFile randomDat;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   @Export("dat2File")
   public static CacheFile dat2File;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   @Export("idx255File")
   public static CacheFile idx255File;
   @ObfuscatedName("d")
   @Export("osNameLC")
   public static String osNameLC;
   @ObfuscatedName("r")
   @Export("userHome")
   public static String userHome;

   static {
      randomDat = null;
      dat2File = null;
      idx255File = null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-94"
   )
   public static void method3262() {
      Overlay.overlays.reset();
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(ZLgz;I)V",
      garbageValue = "-1120687622"
   )
   @Hook("onNpcUpdate")
   @Export("updateNpcs")
   static final void updateNpcs(boolean var0, PacketBuffer var1) {
      Client.field969 = 0;
      Client.pendingNpcFlagsCount = 0;
      Client.method1257();

      int var2;
      NPC var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      while(var1.bitsAvail(Client.field1072.packetLength) >= 27) {
         var2 = var1.getBits(15);
         if(var2 == 32767) {
            break;
         }

         boolean var3 = false;
         if(Client.cachedNPCs[var2] == null) {
            Client.cachedNPCs[var2] = new NPC();
            var3 = true;
         }

         var4 = Client.cachedNPCs[var2];
         Client.npcIndices[++Client.npcIndexesCount - 1] = var2;
         var4.npcCycle = Client.gameCycle;
         if(var0) {
            var5 = var1.getBits(8);
            if(var5 > 127) {
               var5 -= 256;
            }
         } else {
            var5 = var1.getBits(5);
            if(var5 > 15) {
               var5 -= 32;
            }
         }

         var6 = var1.getBits(1);
         var7 = Client.field881[var1.getBits(3)];
         if(var3) {
            var4.orientation = var4.angle = var7;
         }

         if(var0) {
            var8 = var1.getBits(8);
            if(var8 > 127) {
               var8 -= 256;
            }
         } else {
            var8 = var1.getBits(5);
            if(var8 > 15) {
               var8 -= 32;
            }
         }

         var4.composition = class233.getNpcDefinition(var1.getBits(14));
         var9 = var1.getBits(1);
         if(var9 == 1) {
            Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
         }

         var4.field1139 = var4.composition.field3710;
         var4.field1190 = var4.composition.field3720;
         if(var4.field1190 == 0) {
            var4.angle = 0;
         }

         var4.field1145 = var4.composition.field3717;
         var4.field1158 = var4.composition.field3718;
         var4.field1147 = var4.composition.field3719;
         var4.field1148 = var4.composition.field3740;
         var4.idlePoseAnimation = var4.composition.field3714;
         var4.field1143 = var4.composition.field3715;
         var4.field1164 = var4.composition.field3716;
         var4.method1895(WorldMapData.localPlayer.pathX[0] + var8, WorldMapData.localPlayer.pathY[0] + var5, var6 == 1);
      }

      var1.byteAccess();

      int var14;
      for(var2 = 0; var2 < Client.pendingNpcFlagsCount; ++var2) {
         var14 = Client.pendingNpcFlagsIndices[var2];
         var4 = Client.cachedNPCs[var14];
         var5 = var1.readUnsignedByte();
         if((var5 & 32) != 0) {
            var6 = var1.readUnsignedShort();
            var7 = var1.readUnsignedShortOb1();
            var8 = var4.x - (var6 - class38.baseX - class38.baseX) * 64;
            var9 = var4.y - (var7 - PlayerComposition.baseY - PlayerComposition.baseY) * 64;
            if(var8 != 0 || var9 != 0) {
               var4.field1142 = (int)(Math.atan2((double)var8, (double)var9) * 325.949D) & 2047;
            }
         }

         if((var5 & 16) != 0) {
            var4.graphic = var1.readUnsignedShortOb1();
            var6 = var1.readInt();
            var4.field1178 = var6 >> 16;
            var4.graphicsDelay = (var6 & 65535) + Client.gameCycle;
            var4.field1175 = 0;
            var4.field1176 = 0;
            if(var4.graphicsDelay > Client.gameCycle) {
               var4.field1175 = -1;
            }

            if(var4.graphic == 65535) {
               var4.graphic = -1;
            }
         }

         if((var5 & 8) != 0) {
            var4.overhead = var1.readString();
            var4.overheadTextCyclesRemaining = 100;
         }

         if((var5 & 2) != 0) {
            var4.interacting = var1.method3576();
            if(var4.interacting == 65535) {
               var4.interacting = -1;
            }
         }

         if((var5 & 64) != 0) {
            var4.composition = class233.getNpcDefinition(var1.method3576());
            var4.field1139 = var4.composition.field3710;
            var4.field1190 = var4.composition.field3720;
            var4.field1145 = var4.composition.field3717;
            var4.field1158 = var4.composition.field3718;
            var4.field1147 = var4.composition.field3719;
            var4.field1148 = var4.composition.field3740;
            var4.idlePoseAnimation = var4.composition.field3714;
            var4.field1143 = var4.composition.field3715;
            var4.field1164 = var4.composition.field3716;
         }

         if((var5 & 4) != 0) {
            var6 = var1.readUnsignedByte();
            int var10;
            int var11;
            int var12;
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var9 = -1;
                  var10 = -1;
                  var11 = -1;
                  var8 = var1.getUSmart();
                  if(var8 == 32767) {
                     var8 = var1.getUSmart();
                     var10 = var1.getUSmart();
                     var9 = var1.getUSmart();
                     var11 = var1.getUSmart();
                  } else if(var8 != 32766) {
                     var10 = var1.getUSmart();
                  } else {
                     var8 = -1;
                  }

                  var12 = var1.getUSmart();
                  var4.method1653(var8, var10, var9, var11, Client.gameCycle, var12);
               }
            }

            var7 = var1.method3566();
            if(var7 > 0) {
               for(var8 = 0; var8 < var7; ++var8) {
                  var9 = var1.getUSmart();
                  var10 = var1.getUSmart();
                  if(var10 != 32767) {
                     var11 = var1.getUSmart();
                     var12 = var1.readUnsignedByte();
                     int var13 = var10 > 0?var1.method3566():var12;
                     var4.method1654(var9, Client.gameCycle, var10, var11, var12, var13);
                  } else {
                     var4.method1655(var9);
                  }
               }
            }
         }

         if((var5 & 1) != 0) {
            var6 = var1.method3576();
            if(var6 == 65535) {
               var6 = -1;
            }

            var7 = var1.readUnsignedByte();
            if(var6 == var4.animation && var6 != -1) {
               var8 = class158.getAnimation(var6).replyMode;
               if(var8 == 1) {
                  var4.actionFrame = 0;
                  var4.field1140 = 0;
                  var4.actionAnimationDisable = var7;
                  var4.field1186 = 0;
               }

               if(var8 == 2) {
                  var4.field1186 = 0;
               }
            } else if(var6 == -1 || var4.animation == -1 || class158.getAnimation(var6).forcedPriority >= class158.getAnimation(var4.animation).forcedPriority) {
               var4.animation = var6;
               var4.actionFrame = 0;
               var4.field1140 = 0;
               var4.actionAnimationDisable = var7;
               var4.field1186 = 0;
               var4.field1196 = var4.queueSize;
            }
         }
      }

      for(var2 = 0; var2 < Client.field969; ++var2) {
         var14 = Client.field970[var2];
         if(Client.cachedNPCs[var14].npcCycle != Client.gameCycle) {
            Client.cachedNPCs[var14].composition = null;
            Client.cachedNPCs[var14] = null;
         }
      }

      if(var1.offset != Client.field1072.packetLength) {
         throw new RuntimeException(var1.offset + "," + Client.field1072.packetLength);
      } else {
         for(var2 = 0; var2 < Client.npcIndexesCount; ++var2) {
            if(Client.cachedNPCs[Client.npcIndices[var2]] == null) {
               throw new RuntimeException(var2 + "," + Client.npcIndexesCount);
            }
         }

      }
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "([Lig;II)V",
      garbageValue = "-1628485281"
   )
   static final void method3263(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method3263(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  BoundingBox.method50(var4.id, var1);
               }
            }

            ScriptEvent var5;
            if(var1 == 0 && var3.field2924 != null) {
               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.objs = var3.field2924;
               class25.runScript(var5, 500000);
            }

            if(var1 == 1 && var3.field2925 != null) {
               if(var3.index >= 0) {
                  Widget var6 = GZipDecompressor.getWidget(var3.id);
                  if(var6 == null || var6.children == null || var3.index >= var6.children.length || var3 != var6.children[var3.index]) {
                     continue;
                  }
               }

               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.objs = var3.field2925;
               class25.runScript(var5, 500000);
            }
         }
      }

   }
}
