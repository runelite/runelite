import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
@Implements("GameCanvas")
public final class GameCanvas extends Canvas {
   @ObfuscatedName("a")
   @Export("component")
   Component component;

   GameCanvas(Component var1) {
      this.component = var1;
   }

   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }

   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgy;ILbj;II)V",
      garbageValue = "956010731"
   )
   static final void method764(PacketBuffer var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      if((var3 & 16) != 0) {
         var2.overhead = var0.readString();
         if(var2.overhead.charAt(0) == '~') {
            var2.overhead = var2.overhead.substring(1);
            class25.sendGameMessage(2, var2.name, var2.overhead);
         } else if(var2 == UrlRequest.localPlayer) {
            class25.sendGameMessage(2, var2.name, var2.overhead);
         }

         var2.field1122 = false;
         var2.field1179 = 0;
         var2.field1140 = 0;
         var2.overheadTextCyclesRemaining = 150;
      }

      int var5;
      int var6;
      int var8;
      int var9;
      int var12;
      if((var3 & 32) != 0) {
         var5 = var0.method3335();
         int var7;
         int var10;
         int var11;
         if(var5 > 0) {
            for(var6 = 0; var6 < var5; ++var6) {
               var8 = -1;
               var9 = -1;
               var10 = -1;
               var7 = var0.getUSmart();
               if(var7 == 32767) {
                  var7 = var0.getUSmart();
                  var9 = var0.getUSmart();
                  var8 = var0.getUSmart();
                  var10 = var0.getUSmart();
               } else if(var7 != 32766) {
                  var9 = var0.getUSmart();
               } else {
                  var7 = -1;
               }

               var11 = var0.getUSmart();
               var2.method1463(var7, var9, var8, var10, Client.gameCycle, var11);
            }
         }

         var6 = var0.readUnsignedByte();
         if(var6 > 0) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var0.getUSmart();
               var9 = var0.getUSmart();
               if(var9 != 32767) {
                  var10 = var0.getUSmart();
                  var11 = var0.readUnsignedByte();
                  var12 = var9 > 0?var0.readUnsignedByteNegate():var11;
                  var2.method1467(var8, Client.gameCycle, var9, var10, var11, var12);
               } else {
                  var2.method1468(var8);
               }
            }
         }
      }

      if((var3 & 1) != 0) {
         var5 = var0.method3274();
         byte[] var16 = new byte[var5];
         Buffer var17 = new Buffer(var16);
         var0.method3310(var16, 0, var5);
         class94.field1392[var1] = var17;
         var2.decodeApperance(var17);
      }

      if((var3 & 8) != 0) {
         var5 = var0.method3299();
         Permission var22 = (Permission)class91.forOrdinal(GroundObject.method2493(), var0.readUnsignedByte());
         boolean var20 = var0.readUnsignedByteNegate() == 1;
         var8 = var0.method3274();
         var9 = var0.offset;
         if(var2.name != null && var2.composition != null) {
            boolean var21 = false;
            if(var22.field3272 && class27.isIgnored(var2.name)) {
               var21 = true;
            }

            if(!var21 && Client.field947 == 0 && !var2.hidden) {
               class94.field1401.offset = 0;
               var0.readBytes(class94.field1401.payload, 0, var8);
               class94.field1401.offset = 0;
               String var18 = FontTypeFace.appendTags(SceneTilePaint.method2682(TotalQuantityComparator.method94(class94.field1401)));
               var2.overhead = var18.trim();
               var2.field1179 = var5 >> 8;
               var2.field1140 = var5 & 255;
               var2.overheadTextCyclesRemaining = 150;
               var2.field1122 = var20;
               var2.inSequence = var2 != UrlRequest.localPlayer && var22.field3272 && "" != Client.field1046 && var18.toLowerCase().indexOf(Client.field1046) == -1;
               if(var22.field3278) {
                  var12 = var20?91:1;
               } else {
                  var12 = var20?90:2;
               }

               if(var22.field3279 != -1) {
                  int var15 = var22.field3279;
                  String var14 = "<img=" + var15 + ">";
                  class25.sendGameMessage(var12, var14 + var2.name, var18);
               } else {
                  class25.sendGameMessage(var12, var2.name, var18);
               }
            }
         }

         var0.offset = var8 + var9;
      }

      if((var3 & 4096) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.readString();
         }
      }

      if((var3 & 1024) != 0) {
         var4 = var0.readByte();
      }

      if((var3 & 2) != 0) {
         var2.interacting = var0.readUnsignedShortOb1();
         if(var2.interacting == 65535) {
            var2.interacting = -1;
         }
      }

      if((var3 & 2048) != 0) {
         var2.field1164 = var0.readByte();
         var2.field1166 = var0.readByte();
         var2.field1165 = var0.method3437();
         var2.field1125 = var0.readByte();
         var2.field1138 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field1169 = var0.method3297() + Client.gameCycle;
         var2.field1133 = var0.readUnsignedShort();
         if(var2.field814) {
            var2.field1164 += var2.field833;
            var2.field1166 += var2.field834;
            var2.field1165 += var2.field833;
            var2.field1125 += var2.field834;
            var2.queueSize = 0;
         } else {
            var2.field1164 += var2.pathX[0];
            var2.field1166 += var2.pathY[0];
            var2.field1165 += var2.pathX[0];
            var2.field1125 += var2.pathY[0];
            var2.queueSize = 1;
         }

         var2.field1155 = 0;
      }

      if((var3 & 4) != 0) {
         var2.field1150 = var0.method3297();
         if(var2.queueSize == 0) {
            var2.orientation = var2.field1150;
            var2.field1150 = -1;
         }
      }

      if((var3 & 64) != 0) {
         var5 = var0.method3299();
         if(var5 == 65535) {
            var5 = -1;
         }

         var6 = var0.readUnsignedByteNegate();
         class37.method509(var2, var5, var6);
      }

      if((var3 & 256) != 0) {
         var2.graphic = var0.method3299();
         var5 = var0.method3308();
         var2.field1163 = var5 >> 16;
         var2.graphicsDelay = (var5 & 65535) + Client.gameCycle;
         var2.field1160 = 0;
         var2.field1143 = 0;
         if(var2.graphicsDelay > Client.gameCycle) {
            var2.field1160 = -1;
         }

         if(var2.graphic == 65535) {
            var2.graphic = -1;
         }
      }

      if((var3 & 512) != 0) {
         class94.field1388[var1] = var0.method3437();
      }

      if(var2.field814) {
         if(var4 == 127) {
            var2.method1082(var2.field833, var2.field834);
         } else {
            byte var19;
            if(var4 != -1) {
               var19 = var4;
            } else {
               var19 = class94.field1388[var1];
            }

            var2.method1085(var2.field833, var2.field834, var19);
         }
      }

   }
}
