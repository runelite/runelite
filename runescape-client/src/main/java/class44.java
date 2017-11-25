import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class44 extends WorldMapData {
   @ObfuscatedName("lf")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   static class157 field555;
   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   static IndexData field550;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = 1459680025
   )
   static int field554;
   @ObfuscatedName("n")
   HashSet field551;
   @ObfuscatedName("c")
   HashSet field556;
   @ObfuscatedName("y")
   List field552;

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(Lfr;Lfr;Lfr;IZI)V",
      garbageValue = "-2025572197"
   )
   void method635(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field551 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method171(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field551.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field556 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class45 var9 = new class45();

         try {
            var9.method657(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field556.add(var9);
      }

      this.method632(var2, var5);
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(Lfr;ZI)V",
      garbageValue = "1873810226"
   )
   void method632(Buffer var1, boolean var2) {
      this.field552 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3444();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field552.add(new class25(var5, var6));
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgv;IB)V",
      garbageValue = "14"
   )
   @Export("playerUpdatePacketHandler")
   @Hook("onPlayerUpdatePacketHandler")
   static final void playerUpdatePacketHandler(PacketBuffer var0, int var1) {
      int var2 = var0.offset;
      class94.field1419 = 0;
      int var3 = 0;
      var0.bitAccess();

      int var4;
      int var5;
      int var6;
      for(var4 = 0; var4 < class94.playerIndexesCount; ++var4) {
         var5 = class94.playerIndices[var4];
         if((class94.field1412[var5] & 1) == 0) {
            if(var3 > 0) {
               --var3;
               class94.field1412[var5] = (byte)(class94.field1412[var5] | 2);
            } else {
               var6 = var0.getBits(1);
               if(var6 == 0) {
                  var3 = class17.method144(var0);
                  class94.field1412[var5] = (byte)(class94.field1412[var5] | 2);
               } else {
                  Coordinates.decodeMovement(var0, var5);
               }
            }
         }
      }

      var0.byteAccess();
      if(var3 != 0) {
         throw new RuntimeException();
      } else {
         var0.bitAccess();

         for(var4 = 0; var4 < class94.playerIndexesCount; ++var4) {
            var5 = class94.playerIndices[var4];
            if((class94.field1412[var5] & 1) != 0) {
               if(var3 > 0) {
                  --var3;
                  class94.field1412[var5] = (byte)(class94.field1412[var5] | 2);
               } else {
                  var6 = var0.getBits(1);
                  if(var6 == 0) {
                     var3 = class17.method144(var0);
                     class94.field1412[var5] = (byte)(class94.field1412[var5] | 2);
                  } else {
                     Coordinates.decodeMovement(var0, var5);
                  }
               }
            }
         }

         var0.byteAccess();
         if(var3 != 0) {
            throw new RuntimeException();
         } else {
            var0.bitAccess();

            for(var4 = 0; var4 < class94.field1414; ++var4) {
               var5 = class94.field1415[var4];
               if((class94.field1412[var5] & 1) != 0) {
                  if(var3 > 0) {
                     --var3;
                     class94.field1412[var5] = (byte)(class94.field1412[var5] | 2);
                  } else {
                     var6 = var0.getBits(1);
                     if(var6 == 0) {
                        var3 = class17.method144(var0);
                        class94.field1412[var5] = (byte)(class94.field1412[var5] | 2);
                     } else if(class34.decodeRegionHash(var0, var5)) {
                        class94.field1412[var5] = (byte)(class94.field1412[var5] | 2);
                     }
                  }
               }
            }

            var0.byteAccess();
            if(var3 != 0) {
               throw new RuntimeException();
            } else {
               var0.bitAccess();

               for(var4 = 0; var4 < class94.field1414; ++var4) {
                  var5 = class94.field1415[var4];
                  if((class94.field1412[var5] & 1) == 0) {
                     if(var3 > 0) {
                        --var3;
                        class94.field1412[var5] = (byte)(class94.field1412[var5] | 2);
                     } else {
                        var6 = var0.getBits(1);
                        if(var6 == 0) {
                           var3 = class17.method144(var0);
                           class94.field1412[var5] = (byte)(class94.field1412[var5] | 2);
                        } else if(class34.decodeRegionHash(var0, var5)) {
                           class94.field1412[var5] = (byte)(class94.field1412[var5] | 2);
                        }
                     }
                  }
               }

               var0.byteAccess();
               if(var3 != 0) {
                  throw new RuntimeException();
               } else {
                  class94.playerIndexesCount = 0;
                  class94.field1414 = 0;

                  Player var7;
                  for(var4 = 1; var4 < 2048; ++var4) {
                     class94.field1412[var4] = (byte)(class94.field1412[var4] >> 1);
                     var7 = Client.cachedPlayers[var4];
                     if(var7 != null) {
                        class94.playerIndices[++class94.playerIndexesCount - 1] = var4;
                     } else {
                        class94.field1415[++class94.field1414 - 1] = var4;
                     }
                  }

                  for(var3 = 0; var3 < class94.field1419; ++var3) {
                     var4 = class94.field1420[var3];
                     var7 = Client.cachedPlayers[var4];
                     var6 = var0.readUnsignedByte();
                     if((var6 & 32) != 0) {
                        var6 += var0.readUnsignedByte() << 8;
                     }

                     method637(var0, var4, var7, var6);
                  }

                  if(var0.offset - var2 != var1) {
                     throw new RuntimeException(var0.offset - var2 + " " + var1);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgv;ILbw;II)V",
      garbageValue = "2126464241"
   )
   static final void method637(PacketBuffer var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      if((var3 & 4096) != 0) {
         class94.field1410[var1] = var0.method3329();
      }

      if((var3 & 2) != 0) {
         var2.interacting = var0.method3333();
         if(var2.interacting == 65535) {
            var2.interacting = -1;
         }
      }

      int var5;
      if((var3 & 2048) != 0) {
         var2.graphic = var0.readUnsignedShortOb1();
         var5 = var0.method3279();
         var2.field1187 = var5 >> 16;
         var2.graphicsDelay = (var5 & 65535) + Client.gameCycle;
         var2.field1184 = 0;
         var2.field1185 = 0;
         if(var2.graphicsDelay > Client.gameCycle) {
            var2.field1184 = -1;
         }

         if(var2.graphic == 65535) {
            var2.graphic = -1;
         }
      }

      int var8;
      int var9;
      int var12;
      if((var3 & 1) != 0) {
         var5 = var0.readUnsignedShort();
         Permission var6 = (Permission)class94.forOrdinal(class61.method1087(), var0.method3422());
         boolean var7 = var0.method3457() == 1;
         var8 = var0.method3422();
         var9 = var0.offset;
         if(var2.name != null && var2.composition != null) {
            boolean var10 = false;
            if(var6.field3259 && class29.isIgnored(var2.name)) {
               var10 = true;
            }

            if(!var10 && Client.field908 == 0 && !var2.hidden) {
               class94.field1421.offset = 0;
               var0.readBytes(class94.field1421.payload, 0, var8);
               class94.field1421.offset = 0;
               String var11 = FontTypeFace.appendTags(class28.method240(class64.method1107(class94.field1421)));
               var2.overhead = var11.trim();
               var2.field1163 = var5 >> 8;
               var2.field1164 = var5 & 255;
               var2.field1177 = 150;
               var2.field1160 = var7;
               var2.inSequence = var2 != class181.localPlayer && var6.field3259 && "" != Client.field1072 && var11.toLowerCase().indexOf(Client.field1072) == -1;
               if(var6.field3257) {
                  var12 = var7?91:1;
               } else {
                  var12 = var7?90:2;
               }

               if(var6.field3251 != -1) {
                  class54.sendGameMessage(var12, Client.method1570(var6.field3251) + var2.name, var11);
               } else {
                  class54.sendGameMessage(var12, var2.name, var11);
               }
            }
         }

         var0.offset = var9 + var8;
      }

      if((var3 & 128) != 0) {
         var5 = var0.method3457();
         byte[] var16 = new byte[var5];
         Buffer var13 = new Buffer(var16);
         var0.method3345(var16, 0, var5);
         class94.field1407[var1] = var13;
         var2.decodeApperance(var13);
      }

      int var14;
      if((var3 & 4) != 0) {
         var5 = var0.method3422();
         int var15;
         int var17;
         int var19;
         if(var5 > 0) {
            for(var14 = 0; var14 < var5; ++var14) {
               var8 = -1;
               var9 = -1;
               var19 = -1;
               var17 = var0.getUSmart();
               if(var17 == 32767) {
                  var17 = var0.getUSmart();
                  var9 = var0.getUSmart();
                  var8 = var0.getUSmart();
                  var19 = var0.getUSmart();
               } else if(var17 != 32766) {
                  var9 = var0.getUSmart();
               } else {
                  var17 = -1;
               }

               var15 = var0.getUSmart();
               var2.method1580(var17, var9, var8, var19, Client.gameCycle, var15);
            }
         }

         var14 = var0.method3380();
         if(var14 > 0) {
            for(var17 = 0; var17 < var14; ++var17) {
               var8 = var0.getUSmart();
               var9 = var0.getUSmart();
               if(var9 != 32767) {
                  var19 = var0.getUSmart();
                  var15 = var0.method3457();
                  var12 = var9 > 0?var0.method3380():var15;
                  var2.method1578(var8, Client.gameCycle, var9, var19, var15, var12);
               } else {
                  var2.method1579(var8);
               }
            }
         }
      }

      if((var3 & 512) != 0) {
         var2.field1188 = var0.readByte();
         var2.field1190 = var0.readByte();
         var2.field1178 = var0.method3328();
         var2.field1166 = var0.method3327();
         var2.field1176 = var0.method3333() + Client.gameCycle;
         var2.field1193 = var0.method3333() + Client.gameCycle;
         var2.field1194 = var0.readUnsignedShort();
         if(var2.field836) {
            var2.field1188 += var2.field859;
            var2.field1190 += var2.field860;
            var2.field1178 += var2.field859;
            var2.field1166 += var2.field860;
            var2.queueSize = 0;
         } else {
            var2.field1188 += var2.pathX[0];
            var2.field1190 += var2.pathY[0];
            var2.field1178 += var2.pathX[0];
            var2.field1166 += var2.pathY[0];
            var2.queueSize = 1;
         }

         var2.field1159 = 0;
      }

      if((var3 & 16) != 0) {
         var2.overhead = var0.readString();
         if(var2.overhead.charAt(0) == '~') {
            var2.overhead = var2.overhead.substring(1);
            class54.sendGameMessage(2, var2.name, var2.overhead);
         } else if(var2 == class181.localPlayer) {
            class54.sendGameMessage(2, var2.name, var2.overhead);
         }

         var2.field1160 = false;
         var2.field1163 = 0;
         var2.field1164 = 0;
         var2.field1177 = 150;
      }

      if((var3 & 1024) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.readString();
         }
      }

      if((var3 & 256) != 0) {
         var4 = var0.method3327();
      }

      if((var3 & 64) != 0) {
         var2.field1174 = var0.method3334();
         if(var2.queueSize == 0) {
            var2.orientation = var2.field1174;
            var2.field1174 = -1;
         }
      }

      if((var3 & 8) != 0) {
         var5 = var0.method3333();
         if(var5 == 65535) {
            var5 = -1;
         }

         var14 = var0.readUnsignedByte();
         class70.method1130(var2, var5, var14);
      }

      if(var2.field836) {
         if(var4 == 127) {
            var2.method1156(var2.field859, var2.field860);
         } else {
            byte var18;
            if(var4 != -1) {
               var18 = var4;
            } else {
               var18 = class94.field1410[var1];
            }

            var2.method1165(var2.field859, var2.field860, var18);
         }
      }

   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "120438768"
   )
   static final void method636(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field1035; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1059[var4] = true;
         }
      }

   }
}
