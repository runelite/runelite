import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1569051013
   )
   @Export("screenType")
   int screenType;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1035559881
   )
   static int field1327;
   @ObfuscatedName("t")
   @Export("muted")
   boolean muted;
   @ObfuscatedName("r")
   @Export("preferences")
   LinkedHashMap preferences;
   @ObfuscatedName("a")
   @Export("hideRoofs")
   boolean hideRoofs;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)LBuffer;",
      garbageValue = "1038525976"
   )
   @Export("serialize")
   Buffer serialize() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1327);
      var1.putByte(this.hideRoofs?1:0);
      var1.putByte(this.muted?1:0);
      var1.putByte(this.screenType);
      var1.putByte(this.preferences.size());
      Iterator var2 = this.preferences.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.putInt(((Integer)var3.getKey()).intValue());
         var1.putInt(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   Preferences(Buffer var1) {
      this.screenType = 1;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1327) {
            if(var1.readUnsignedByte() == 1) {
               this.hideRoofs = true;
            }

            if(var2 > 1) {
               this.muted = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.screenType = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.preferences.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method1610(true);
         }
      } else {
         this.method1610(true);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "823829088"
   )
   void method1610(boolean var1) {
   }

   Preferences() {
      this.screenType = 1;
      this.preferences = new LinkedHashMap();
      this.method1610(true);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;B)V",
      garbageValue = "1"
   )
   @Export("updatePlayersFlag")
   static final void updatePlayersFlag(PacketBuffer var0) {
      for(int var1 = 0; var1 < class96.field1525; ++var1) {
         int var2 = class96.field1529[var1];
         Player var3 = Client.cachedPlayers[var2];
         int var4 = var0.readUnsignedByte();
         if((var4 & 4) != 0) {
            var4 += var0.readUnsignedByte() << 8;
         }

         byte var5 = -1;
         int var6;
         if((var4 & 16) != 0) {
            var6 = var0.readUnsignedByte();
            byte[] var7 = new byte[var6];
            Buffer var8 = new Buffer(var7);
            var0.readBytes(var7, 0, var6);
            class96.field1520[var2] = var8;
            var3.decodeApperance(var8);
         }

         int var19;
         if((var4 & 2) != 0) {
            var6 = var0.readUnsignedShort();
            if(var6 == '\uffff') {
               var6 = -1;
            }

            var19 = var0.readUnsignedByte();
            RSCanvas.method810(var3, var6, var19);
         }

         if((var4 & 32) != 0) {
            var3.interacting = var0.readUnsignedShort();
            if(var3.interacting == '\uffff') {
               var3.interacting = -1;
            }
         }

         if((var4 & 128) != 0) {
            var3.overhead = var0.readString();
            if(var3.overhead.charAt(0) == 126) {
               var3.overhead = var3.overhead.substring(1);
               class152.sendGameMessage(2, var3.name, var3.overhead);
            } else if(var3 == XItemContainer.localPlayer) {
               class152.sendGameMessage(2, var3.name, var3.overhead);
            }

            var3.field1284 = false;
            var3.field1255 = 0;
            var3.field1256 = 0;
            var3.field1264 = 150;
         }

         int var9;
         int var20;
         if((var4 & 64) != 0) {
            var6 = var0.readUnsignedByte();
            int var10;
            int var11;
            int var12;
            if(var6 > 0) {
               for(var19 = 0; var19 < var6; ++var19) {
                  var20 = -1;
                  var9 = -1;
                  var10 = -1;
                  var12 = var0.getUSmart();
                  if(var12 == 32767) {
                     var12 = var0.getUSmart();
                     var9 = var0.getUSmart();
                     var20 = var0.getUSmart();
                     var10 = var0.getUSmart();
                  } else if(var12 != 32766) {
                     var9 = var0.getUSmart();
                  } else {
                     var12 = -1;
                  }

                  var11 = var0.getUSmart();
                  var3.method1536(var12, var9, var20, var10, Client.gameCycle, var11);
               }
            }

            var19 = var0.readUnsignedByte();
            if(var19 > 0) {
               for(var12 = 0; var12 < var19; ++var12) {
                  var20 = var0.getUSmart();
                  var9 = var0.getUSmart();
                  if(var9 != 32767) {
                     var10 = var0.getUSmart();
                     var11 = var0.readUnsignedByte();
                     int var13 = var9 > 0?var0.readUnsignedByte():var11;
                     var3.method1537(var20, Client.gameCycle, var9, var10, var11, var13);
                  } else {
                     var3.method1550(var20);
                  }
               }
            }
         }

         if((var4 & 1) != 0) {
            var3.field1266 = var0.readUnsignedShort();
            if(var3.queueSize == 0) {
               var3.orientation = var3.field1266;
               var3.field1266 = -1;
            }
         }

         if((var4 & 8) != 0) {
            var6 = var0.readUnsignedShort();
            Permission var21 = (Permission)class134.forOrdinal(Widget.method4032(), var0.readUnsignedByte());
            boolean var22 = var0.readUnsignedByte() == 1;
            var20 = var0.readUnsignedByte();
            var9 = var0.offset;
            if(var3.name != null && var3.composition != null) {
               boolean var25 = false;
               if(var21.field3188 && class1.isIgnored(var3.name)) {
                  var25 = true;
               }

               if(!var25 && Client.field1045 == 0 && !var3.hidden) {
                  class96.field1533.offset = 0;
                  var0.readBytes(class96.field1533.payload, 0, var20);
                  class96.field1533.offset = 0;
                  Buffer var24 = class96.field1533;

                  String var14;
                  int var15;
                  try {
                     var15 = var24.getUSmart();
                     if(var15 > 32767) {
                        var15 = 32767;
                     }

                     byte[] var16 = new byte[var15];
                     var24.offset += class265.field3665.decompress(var24.payload, var24.offset, var16, 0, var15);
                     String var17 = class48.getString(var16, 0, var15);
                     var14 = var17;
                  } catch (Exception var18) {
                     var14 = "Cabbage";
                  }

                  var14 = FontTypeFace.appendTags(FaceNormal.method2870(var14));
                  var3.overhead = var14.trim();
                  var3.field1255 = var6 >> 8;
                  var3.field1256 = var6 & 255;
                  var3.field1264 = 150;
                  var3.field1284 = var22;
                  var3.inSequence = var3 != XItemContainer.localPlayer && var21.field3188 && "" != Client.field1145 && var14.toLowerCase().indexOf(Client.field1145) == -1;
                  if(var21.field3184) {
                     var15 = var22?91:1;
                  } else {
                     var15 = var22?90:2;
                  }

                  if(var21.field3186 != -1) {
                     class152.sendGameMessage(var15, class41.method609(var21.field3186) + var3.name, var14);
                  } else {
                     class152.sendGameMessage(var15, var3.name, var14);
                  }
               }
            }

            var0.offset = var9 + var20;
         }

         if((var4 & 4096) != 0) {
            var3.graphic = var0.readUnsignedShort();
            var6 = var0.readInt();
            var3.field1238 = var6 >> 16;
            var3.graphicsDelay = (var6 & '\uffff') + Client.gameCycle;
            var3.field1244 = 0;
            var3.field1277 = 0;
            if(var3.graphicsDelay > Client.gameCycle) {
               var3.field1244 = -1;
            }

            if(var3.graphic == '\uffff') {
               var3.graphic = -1;
            }
         }

         if((var4 & 256) != 0) {
            var3.field1280 = var0.readByte();
            var3.field1282 = var0.readByte();
            var3.field1296 = var0.readByte();
            var3.field1241 = var0.readByte();
            var3.field1274 = var0.readUnsignedShort() + Client.gameCycle;
            var3.field1285 = var0.readUnsignedShort() + Client.gameCycle;
            var3.field1286 = var0.readUnsignedShort();
            if(var3.field913) {
               var3.field1280 += var3.field917;
               var3.field1282 += var3.field915;
               var3.field1296 += var3.field917;
               var3.field1241 += var3.field915;
               var3.queueSize = 0;
            } else {
               var3.field1280 += var3.pathX[0];
               var3.field1282 += var3.pathY[0];
               var3.field1296 += var3.pathX[0];
               var3.field1241 += var3.pathY[0];
               var3.queueSize = 1;
            }

            var3.field1269 = 0;
         }

         if((var4 & 512) != 0) {
            class96.field1519[var2] = var0.readByte();
         }

         if((var4 & 1024) != 0) {
            var5 = var0.readByte();
         }

         if((var4 & 2048) != 0) {
            for(var6 = 0; var6 < 3; ++var6) {
               var3.actions[var6] = var0.readString();
            }
         }

         if(var3.field913) {
            if(var5 == 127) {
               var3.method1176(var3.field917, var3.field915);
            } else {
               byte var23;
               if(var5 != -1) {
                  var23 = var5;
               } else {
                  var23 = class96.field1519[var2];
               }

               var3.method1158(var3.field917, var3.field915, var23);
            }
         }
      }

   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1029215386"
   )
   static final void method1614(int var0) {
      ScriptEvent.method1135();

      for(class82 var1 = (class82)class82.field1349.getFront(); var1 != null; var1 = (class82)class82.field1349.getNext()) {
         if(var1.field1345 != null) {
            var1.method1617();
         }
      }

      VarPlayerType var6 = (VarPlayerType)VarPlayerType.varplayers.get((long)var0);
      VarPlayerType var2;
      if(var6 != null) {
         var2 = var6;
      } else {
         byte[] var3 = VarPlayerType.varplayer_ref.getConfigData(16, var0);
         var6 = new VarPlayerType();
         if(var3 != null) {
            var6.decode(new Buffer(var3));
         }

         VarPlayerType.varplayers.put(var6, (long)var0);
         var2 = var6;
      }

      int var7 = var2.configType;
      if(var7 != 0) {
         int var4 = class211.widgetSettings[var0];
         if(var7 == 1) {
            if(var4 == 1) {
               Graphics3D.setBrightness(0.9D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.9D);
            }

            if(var4 == 2) {
               Graphics3D.setBrightness(0.8D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.8D);
            }

            if(var4 == 3) {
               Graphics3D.setBrightness(0.7D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.7D);
            }

            if(var4 == 4) {
               Graphics3D.setBrightness(0.6D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.6D);
            }

            class40.method564();
         }

         if(var7 == 3) {
            short var5 = 0;
            if(var4 == 0) {
               var5 = 255;
            }

            if(var4 == 1) {
               var5 = 192;
            }

            if(var4 == 2) {
               var5 = 128;
            }

            if(var4 == 3) {
               var5 = 64;
            }

            if(var4 == 4) {
               var5 = 0;
            }

            if(var5 != Client.field1162) {
               if(Client.field1162 == 0 && Client.field1163 != -1) {
                  class29.method232(class44.indexTrack1, Client.field1163, 0, var5, false);
                  Client.field1014 = false;
               } else if(var5 == 0) {
                  class203.field2509.method3740();
                  class203.field2508 = 1;
                  class61.field785 = null;
                  Client.field1014 = false;
               } else {
                  class96.method1798(var5);
               }

               Client.field1162 = var5;
            }
         }

         if(var7 == 4) {
            if(var4 == 0) {
               Client.field1165 = 127;
            }

            if(var4 == 1) {
               Client.field1165 = 96;
            }

            if(var4 == 2) {
               Client.field1165 = 64;
            }

            if(var4 == 3) {
               Client.field1165 = 32;
            }

            if(var4 == 4) {
               Client.field1165 = 0;
            }
         }

         if(var7 == 5) {
            Client.field1064 = var4;
         }

         if(var7 == 6) {
            Client.field1089 = var4;
         }

         if(var7 == 9) {
            Client.field1141 = var4;
         }

         if(var7 == 10) {
            if(var4 == 0) {
               Client.field1098 = 127;
            }

            if(var4 == 1) {
               Client.field1098 = 96;
            }

            if(var4 == 2) {
               Client.field1098 = 64;
            }

            if(var4 == 3) {
               Client.field1098 = 32;
            }

            if(var4 == 4) {
               Client.field1098 = 0;
            }
         }

         if(var7 == 17) {
            Client.field1065 = var4 & '\uffff';
         }

         if(var7 == 18) {
            Client.field1012 = (class91)class134.forOrdinal(class48.method739(), var4);
            if(Client.field1012 == null) {
               Client.field1012 = class91.field1442;
            }
         }

         if(var7 == 19) {
            if(var4 == -1) {
               Client.field1056 = -1;
            } else {
               Client.field1056 = var4 & 2047;
            }
         }

         if(var7 == 22) {
            Client.field952 = (class91)class134.forOrdinal(class48.method739(), var4);
            if(Client.field952 == null) {
               Client.field952 = class91.field1442;
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)LWorld;",
      garbageValue = "-1288218099"
   )
   static World method1615() {
      World.field1310 = 0;
      return Actor.method1556();
   }

   static {
      field1327 = 4;
   }
}
