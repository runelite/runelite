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
   int field1325;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1035559881
   )
   static int field1327;
   @ObfuscatedName("t")
   boolean field1328;
   @ObfuscatedName("r")
   @Export("preferences")
   LinkedHashMap preferences;
   @ObfuscatedName("a")
   boolean field1335;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)LBuffer;",
      garbageValue = "1038525976"
   )
   Buffer method1609() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1327);
      var1.putByte(this.field1335?1:0);
      var1.putByte(this.field1328?1:0);
      var1.putByte(this.field1325);
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
      this.field1325 = 1;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1327) {
            if(var1.readUnsignedByte() == 1) {
               this.field1335 = true;
            }

            if(var2 > 1) {
               this.field1328 = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.field1325 = var1.readUnsignedByte();
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

   static {
      field1327 = 4;
   }

   Preferences() {
      this.field1325 = 1;
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
            var3.method1154(var8);
         }

         int var18;
         if((var4 & 2) != 0) {
            var6 = var0.readUnsignedShort();
            if(var6 == '\uffff') {
               var6 = -1;
            }

            var18 = var0.readUnsignedByte();
            RSCanvas.method810(var3, var6, var18);
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
         int var10;
         if((var4 & 64) != 0) {
            var6 = var0.readUnsignedByte();
            int var11;
            int var12;
            int var19;
            if(var6 > 0) {
               for(var18 = 0; var18 < var6; ++var18) {
                  var9 = -1;
                  var10 = -1;
                  var11 = -1;
                  var19 = var0.method3159();
                  if(var19 == 32767) {
                     var19 = var0.method3159();
                     var10 = var0.method3159();
                     var9 = var0.method3159();
                     var11 = var0.method3159();
                  } else if(var19 != 32766) {
                     var10 = var0.method3159();
                  } else {
                     var19 = -1;
                  }

                  var12 = var0.method3159();
                  var3.method1536(var19, var10, var9, var11, Client.gameCycle, var12);
               }
            }

            var18 = var0.readUnsignedByte();
            if(var18 > 0) {
               for(var19 = 0; var19 < var18; ++var19) {
                  var9 = var0.method3159();
                  var10 = var0.method3159();
                  if(var10 != 32767) {
                     var11 = var0.method3159();
                     var12 = var0.readUnsignedByte();
                     int var13 = var10 > 0?var0.readUnsignedByte():var12;
                     var3.method1537(var9, Client.gameCycle, var10, var11, var12, var13);
                  } else {
                     var3.method1550(var9);
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
            class230 var24 = (class230)class134.method2577(Widget.method4032(), var0.readUnsignedByte());
            boolean var27 = var0.readUnsignedByte() == 1;
            var9 = var0.readUnsignedByte();
            var10 = var0.offset;
            if(var3.name != null && var3.composition != null) {
               boolean var26 = false;
               if(var24.field3188 && class1.method2(var3.name)) {
                  var26 = true;
               }

               if(!var26 && Client.field1045 == 0 && !var3.hidden) {
                  class96.field1533.offset = 0;
                  var0.readBytes(class96.field1533.payload, 0, var9);
                  class96.field1533.offset = 0;
                  Buffer var20 = class96.field1533;

                  String var14;
                  int var15;
                  try {
                     var15 = var20.method3159();
                     if(var15 > 32767) {
                        var15 = 32767;
                     }

                     byte[] var16 = new byte[var15];
                     var20.offset += class265.field3665.method3062(var20.payload, var20.offset, var16, 0, var15);
                     String var17 = class48.method755(var16, 0, var15);
                     var14 = var17;
                  } catch (Exception var23) {
                     var14 = "Cabbage";
                  }

                  var14 = FontTypeFace.method4835(FaceNormal.method2870(var14));
                  var3.overhead = var14.trim();
                  var3.field1255 = var6 >> 8;
                  var3.field1256 = var6 & 255;
                  var3.field1264 = 150;
                  var3.field1284 = var27;
                  var3.inSequence = var3 != XItemContainer.localPlayer && var24.field3188 && "" != Client.field1145 && var14.toLowerCase().indexOf(Client.field1145) == -1;
                  if(var24.field3184) {
                     var15 = var27?91:1;
                  } else {
                     var15 = var27?90:2;
                  }

                  if(var24.field3186 != -1) {
                     class152.sendGameMessage(var15, class41.method609(var24.field3186) + var3.name, var14);
                  } else {
                     class152.sendGameMessage(var15, var3.name, var14);
                  }
               }
            }

            var0.offset = var10 + var9;
         }

         if((var4 & 4096) != 0) {
            var3.graphic = var0.readUnsignedShort();
            var6 = var0.readInt();
            var3.field1238 = var6 >> 16;
            var3.field1278 = (var6 & '\uffff') + Client.gameCycle;
            var3.field1244 = 0;
            var3.field1277 = 0;
            if(var3.field1278 > Client.gameCycle) {
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
               byte var25;
               if(var5 != -1) {
                  var25 = var5;
               } else {
                  var25 = class96.field1519[var2];
               }

               var3.method1158(var3.field917, var3.field915, var25);
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
      class69.method1135();

      for(class82 var1 = (class82)class82.field1349.method3584(); var1 != null; var1 = (class82)class82.field1349.method3578()) {
         if(var1.field1345 != null) {
            var1.method1617();
         }
      }

      class241 var2 = (class241)class241.field3290.get((long)var0);
      class241 var7;
      if(var2 != null) {
         var7 = var2;
      } else {
         byte[] var3 = class241.field3292.getConfigData(16, var0);
         var2 = new class241();
         if(var3 != null) {
            var2.method4281(new Buffer(var3));
         }

         class241.field3290.put(var2, (long)var0);
         var7 = var2;
      }

      int var5 = var7.field3291;
      if(var5 != 0) {
         int var6 = class211.widgetSettings[var0];
         if(var5 == 1) {
            if(var6 == 1) {
               class136.method2587(0.9D);
               ((TextureProvider)class136.field2028).method2384(0.9D);
            }

            if(var6 == 2) {
               class136.method2587(0.8D);
               ((TextureProvider)class136.field2028).method2384(0.8D);
            }

            if(var6 == 3) {
               class136.method2587(0.7D);
               ((TextureProvider)class136.field2028).method2384(0.7D);
            }

            if(var6 == 4) {
               class136.method2587(0.6D);
               ((TextureProvider)class136.field2028).method2384(0.6D);
            }

            class40.method564();
         }

         if(var5 == 3) {
            short var4 = 0;
            if(var6 == 0) {
               var4 = 255;
            }

            if(var6 == 1) {
               var4 = 192;
            }

            if(var6 == 2) {
               var4 = 128;
            }

            if(var6 == 3) {
               var4 = 64;
            }

            if(var6 == 4) {
               var4 = 0;
            }

            if(var4 != Client.field1162) {
               if(Client.field1162 == 0 && Client.field1163 != -1) {
                  class29.method232(class44.indexTrack1, Client.field1163, 0, var4, false);
                  Client.field1014 = false;
               } else if(var4 == 0) {
                  class203.field2509.method3740();
                  class203.field2508 = 1;
                  class61.field785 = null;
                  Client.field1014 = false;
               } else {
                  class96.method1798(var4);
               }

               Client.field1162 = var4;
            }
         }

         if(var5 == 4) {
            if(var6 == 0) {
               Client.field1165 = 127;
            }

            if(var6 == 1) {
               Client.field1165 = 96;
            }

            if(var6 == 2) {
               Client.field1165 = 64;
            }

            if(var6 == 3) {
               Client.field1165 = 32;
            }

            if(var6 == 4) {
               Client.field1165 = 0;
            }
         }

         if(var5 == 5) {
            Client.field1064 = var6;
         }

         if(var5 == 6) {
            Client.field1089 = var6;
         }

         if(var5 == 9) {
            Client.field1141 = var6;
         }

         if(var5 == 10) {
            if(var6 == 0) {
               Client.field1098 = 127;
            }

            if(var6 == 1) {
               Client.field1098 = 96;
            }

            if(var6 == 2) {
               Client.field1098 = 64;
            }

            if(var6 == 3) {
               Client.field1098 = 32;
            }

            if(var6 == 4) {
               Client.field1098 = 0;
            }
         }

         if(var5 == 17) {
            Client.field1065 = var6 & '\uffff';
         }

         if(var5 == 18) {
            Client.field1012 = (class91)class134.method2577(class48.method739(), var6);
            if(Client.field1012 == null) {
               Client.field1012 = class91.field1442;
            }
         }

         if(var5 == 19) {
            if(var6 == -1) {
               Client.field1056 = -1;
            } else {
               Client.field1056 = var6 & 2047;
            }
         }

         if(var5 == 22) {
            Client.field952 = (class91)class134.method2577(class48.method739(), var6);
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
}
