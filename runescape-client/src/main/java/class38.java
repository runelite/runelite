import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class38 {
   @ObfuscatedName("ps")
   @ObfuscatedGetter(
      intValue = -148260563
   )
   static int field520;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1966986251
   )
   static int field519;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgb;ILbd;IS)V",
      garbageValue = "-12289"
   )
   static final void method517(PacketBuffer var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 2048) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.readString();
         }
      }

      if((var3 & 1) != 0) {
         var5 = var0.method3583();
         byte[] var6 = new byte[var5];
         Buffer var7 = new Buffer(var6);
         var0.readBytes(var6, 0, var5);
         class93.field1412[var1] = var7;
         var2.decodeApperance(var7);
      }

      if((var3 & 256) != 0) {
         var4 = var0.method3780();
      }

      if((var3 & 512) != 0) {
         class93.field1404[var1] = var0.method3612();
      }

      int var8;
      int var9;
      if((var3 & 8) != 0) {
         var5 = var0.readUnsignedShortOb1();
         Permission var19 = (Permission)MapIcon.forOrdinal(class241.method4552(), var0.method3610());
         boolean var15 = var0.method3610() == 1;
         var8 = var0.readUnsignedByte();
         var9 = var0.offset;
         if(var2.name != null && var2.composition != null) {
            boolean var10 = false;
            if(var19.field3333 && ContextMenuRow.friendManager.method1707(var2.name)) {
               var10 = true;
            }

            if(!var10 && Client.myPlayerIndex == 0 && !var2.hidden) {
               class93.field1415.offset = 0;
               var0.method3603(class93.field1415.payload, 0, var8);
               class93.field1415.offset = 0;
               Buffer var12 = class93.field1415;
               String var11 = PacketNode.method3492(var12, 32767);
               String var13 = FontTypeFace.appendTags(class71.method1133(var11));
               var2.overhead = var13.trim();
               var2.field1156 = var5 >> 8;
               var2.field1196 = var5 & 255;
               var2.overheadTextCyclesRemaining = 150;
               var2.field1153 = var15;
               var2.field1154 = var2 != TotalQuantityComparator.localPlayer && var19.field3333 && "" != Client.field1066 && var13.toLowerCase().indexOf(Client.field1066) == -1;
               int var14;
               if(var19.field3339) {
                  var14 = var15?91:1;
               } else {
                  var14 = var15?90:2;
               }

               if(var19.field3338 != -1) {
                  class19.sendGameMessage(var14, GameCanvas.method796(var19.field3338) + var2.name.getName(), var13);
               } else {
                  class19.sendGameMessage(var14, var2.name.getName(), var13);
               }
            }
         }

         var0.offset = var9 + var8;
      }

      if((var3 & 4) != 0) {
         var2.overhead = var0.readString();
         if(var2.overhead.charAt(0) == '~') {
            var2.overhead = var2.overhead.substring(1);
            class19.sendGameMessage(2, var2.name.getName(), var2.overhead);
         } else if(var2 == TotalQuantityComparator.localPlayer) {
            class19.sendGameMessage(2, var2.name.getName(), var2.overhead);
         }

         var2.field1153 = false;
         var2.field1156 = 0;
         var2.field1196 = 0;
         var2.overheadTextCyclesRemaining = 150;
      }

      if((var3 & 4096) != 0) {
         var2.field1167 = var0.method3612();
         var2.field1146 = var0.method3613();
         var2.field1181 = var0.method3612();
         var2.field1184 = var0.method3780();
         var2.field1188 = var0.readUnsignedShortOb1() + Client.gameCycle;
         var2.field1186 = var0.readUnsignedShortOb1() + Client.gameCycle;
         var2.field1187 = var0.readUnsignedShortOb1();
         if(var2.field840) {
            var2.field1167 += var2.field826;
            var2.field1146 += var2.field850;
            var2.field1181 += var2.field826;
            var2.field1184 += var2.field850;
            var2.queueSize = 0;
         } else {
            var2.field1167 += var2.pathX[0];
            var2.field1146 += var2.pathY[0];
            var2.field1181 += var2.pathX[0];
            var2.field1184 += var2.pathY[0];
            var2.queueSize = 1;
         }

         var2.field1198 = 0;
      }

      if((var3 & 64) != 0) {
         var2.interacting = var0.method3620();
         if(var2.interacting == 65535) {
            var2.interacting = -1;
         }
      }

      int var16;
      if((var3 & 128) != 0) {
         var5 = var0.method3618();
         if(var5 == 65535) {
            var5 = -1;
         }

         var16 = var0.method3609();
         class317.method5715(var2, var5, var16);
      }

      if((var3 & 2) != 0) {
         var5 = var0.method3583();
         int var17;
         int var21;
         int var22;
         if(var5 > 0) {
            for(var16 = 0; var16 < var5; ++var16) {
               var8 = -1;
               var9 = -1;
               var21 = -1;
               var22 = var0.getUSmart();
               if(var22 == 32767) {
                  var22 = var0.getUSmart();
                  var9 = var0.getUSmart();
                  var8 = var0.getUSmart();
                  var21 = var0.getUSmart();
               } else if(var22 != 32766) {
                  var9 = var0.getUSmart();
               } else {
                  var22 = -1;
               }

               var17 = var0.getUSmart();
               var2.method1630(var22, var9, var8, var21, Client.gameCycle, var17);
            }
         }

         var16 = var0.method3583();
         if(var16 > 0) {
            for(var22 = 0; var22 < var16; ++var22) {
               var8 = var0.getUSmart();
               var9 = var0.getUSmart();
               if(var9 != 32767) {
                  var21 = var0.getUSmart();
                  var17 = var0.method3609();
                  int var18 = var9 > 0?var0.readUnsignedByte():var17;
                  var2.method1631(var8, Client.gameCycle, var9, var21, var17, var18);
               } else {
                  var2.method1632(var8);
               }
            }
         }
      }

      if((var3 & 1024) != 0) {
         var2.graphic = var0.method3620();
         var5 = var0.method3628();
         var2.field1157 = var5 >> 16;
         var2.graphicsDelay = (var5 & 65535) + Client.gameCycle;
         var2.field1177 = 0;
         var2.field1178 = 0;
         if(var2.graphicsDelay > Client.gameCycle) {
            var2.field1177 = -1;
         }

         if(var2.graphic == 65535) {
            var2.graphic = -1;
         }
      }

      if((var3 & 16) != 0) {
         var2.field1142 = var0.method3620();
         if(var2.queueSize == 0) {
            var2.orientation = var2.field1142;
            var2.field1142 = -1;
         }
      }

      if(var2.field840) {
         if(var4 == 127) {
            var2.method1149(var2.field826, var2.field850);
         } else {
            byte var20;
            if(var4 != -1) {
               var20 = var4;
            } else {
               var20 = class93.field1404[var1];
            }

            var2.method1148(var2.field826, var2.field850, var20);
         }
      }

   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static void method508() {
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(Lcc;III)V",
      garbageValue = "8111092"
   )
   static final void method516(ContextMenuRow var0, int var1, int var2) {
      class62.menuAction(var0.param0, var0.param1, var0.type, var0.identifier, var0.option, var0.option, var1, var2);
   }
}
