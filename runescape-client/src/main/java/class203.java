import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
public class class203 {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   static IndexedSprite field2476;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1439108473
   )
   int field2478;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 363567707
   )
   int field2473;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1192272269
   )
   int field2477;
   @ObfuscatedName("e")
   byte[] field2471;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1462972005
   )
   int field2475;
   @ObfuscatedName("n")
   byte[] field2472;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 906553817
   )
   int field2479;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1224606121
   )
   int field2474;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 785239833
   )
   int field2480;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lfb;ILbk;IB)V",
      garbageValue = "118"
   )
   static final void method3680(PacketBuffer var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 2) != 0) {
         var5 = var0.readUnsignedByte();
         byte[] var6 = new byte[var5];
         Buffer var7 = new Buffer(var6);
         var0.readBytes(var6, 0, var5);
         class97.field1492[var1] = var7;
         var2.decodeApperance(var7);
      }

      int var18;
      if((var3 & 8) != 0) {
         var5 = var0.readUnsignedShort();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var18 = var0.readUnsignedByte();
         class244.method4319(var2, var5, var18);
      }

      if((var3 & 16) != 0) {
         var2.interacting = var0.readUnsignedShort();
         if(var2.interacting == '\uffff') {
            var2.interacting = -1;
         }
      }

      if((var3 & 4) != 0) {
         var2.overhead = var0.readString();
         if(var2.overhead.charAt(0) == 126) {
            var2.overhead = var2.overhead.substring(1);
            WorldMapType3.sendGameMessage(2, var2.name, var2.overhead);
         } else if(var2 == class54.localPlayer) {
            WorldMapType3.sendGameMessage(2, var2.name, var2.overhead);
         }

         var2.field1219 = false;
         var2.field1222 = 0;
         var2.field1223 = 0;
         var2.field1221 = 150;
      }

      int var8;
      int var9;
      if((var3 & 64) != 0) {
         var5 = var0.readUnsignedByte();
         int var10;
         int var11;
         int var19;
         if(var5 > 0) {
            for(var18 = 0; var18 < var5; ++var18) {
               var8 = -1;
               var9 = -1;
               var10 = -1;
               var19 = var0.getUSmart();
               if(var19 == 32767) {
                  var19 = var0.getUSmart();
                  var9 = var0.getUSmart();
                  var8 = var0.getUSmart();
                  var10 = var0.getUSmart();
               } else if(var19 != 32766) {
                  var9 = var0.getUSmart();
               } else {
                  var19 = -1;
               }

               var11 = var0.getUSmart();
               var2.method1526(var19, var9, var8, var10, Client.gameCycle, var11);
            }
         }

         var18 = var0.readUnsignedByte();
         if(var18 > 0) {
            for(var19 = 0; var19 < var18; ++var19) {
               var8 = var0.getUSmart();
               var9 = var0.getUSmart();
               if(var9 != 32767) {
                  var10 = var0.getUSmart();
                  var11 = var0.readUnsignedByte();
                  int var12 = var9 > 0?var0.readUnsignedByte():var11;
                  var2.method1529(var8, Client.gameCycle, var9, var10, var11, var12);
               } else {
                  var2.method1530(var8);
               }
            }
         }
      }

      if((var3 & 128) != 0) {
         var2.field1205 = var0.readUnsignedShort();
         if(var2.queueSize == 0) {
            var2.orientation = var2.field1205;
            var2.field1205 = -1;
         }
      }

      if((var3 & 1) != 0) {
         var5 = var0.readUnsignedShort();
         Permission var25 = (Permission)GroundObject.forOrdinal(ScriptEvent.method1111(), var0.readUnsignedByte());
         boolean var28 = var0.readUnsignedByte() == 1;
         var8 = var0.readUnsignedByte();
         var9 = var0.offset;
         if(var2.name != null && var2.composition != null) {
            boolean var27 = false;
            if(var25.field3152 && class23.isIgnored(var2.name)) {
               var27 = true;
            }

            if(!var27 && Client.field1131 == 0 && !var2.hidden) {
               class97.field1502.offset = 0;
               var0.readBytes(class97.field1502.payload, 0, var8);
               class97.field1502.offset = 0;
               Buffer var20 = class97.field1502;

               String var13;
               int var14;
               String var16;
               try {
                  var14 = var20.getUSmart();
                  if(var14 > 32767) {
                     var14 = 32767;
                  }

                  byte[] var15 = new byte[var14];
                  var20.offset += class12.field274.decompress(var20.payload, var20.offset, var15, 0, var14);
                  var16 = class216.getString(var15, 0, var14);
                  var13 = var16;
               } catch (Exception var24) {
                  var13 = "Cabbage";
               }

               var13 = FontTypeFace.appendTags(class266.method4863(var13));
               var2.overhead = var13.trim();
               var2.field1222 = var5 >> 8;
               var2.field1223 = var5 & 255;
               var2.field1221 = 150;
               var2.field1219 = var28;
               var2.inSequence = var2 != class54.localPlayer && var25.field3152 && "" != Client.field1121 && var13.toLowerCase().indexOf(Client.field1121) == -1;
               if(var25.field3163) {
                  var14 = var28?91:1;
               } else {
                  var14 = var28?90:2;
               }

               if(var25.field3158 != -1) {
                  int var17 = var25.field3158;
                  var16 = "<img=" + var17 + ">";
                  WorldMapType3.sendGameMessage(var14, var16 + var2.name, var13);
               } else {
                  WorldMapType3.sendGameMessage(var14, var2.name, var13);
               }
            }
         }

         var0.offset = var8 + var9;
      }

      if((var3 & 2048) != 0) {
         var2.graphic = var0.readUnsignedShort();
         var5 = var0.readInt();
         var2.field1265 = var5 >> 16;
         var2.graphicsDelay = (var5 & '\uffff') + Client.gameCycle;
         var2.field1209 = 0;
         var2.field1244 = 0;
         if(var2.graphicsDelay > Client.gameCycle) {
            var2.field1209 = -1;
         }

         if(var2.graphic == '\uffff') {
            var2.graphic = -1;
         }
      }

      if((var3 & 512) != 0) {
         var2.field1247 = var0.readByte();
         var2.field1251 = var0.readByte();
         var2.field1248 = var0.readByte();
         var2.field1228 = var0.readByte();
         var2.field1238 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field1252 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field1253 = var0.readUnsignedShort();
         if(var2.field902) {
            var2.field1247 += var2.field896;
            var2.field1251 += var2.field888;
            var2.field1248 += var2.field896;
            var2.field1228 += var2.field888;
            var2.queueSize = 0;
         } else {
            var2.field1247 += var2.pathX[0];
            var2.field1251 += var2.pathY[0];
            var2.field1248 += var2.pathX[0];
            var2.field1228 += var2.pathY[0];
            var2.queueSize = 1;
         }

         var2.field1264 = 0;
      }

      if((var3 & 4096) != 0) {
         class97.field1491[var1] = var0.readByte();
      }

      if((var3 & 256) != 0) {
         var4 = var0.readByte();
      }

      if((var3 & 1024) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.readString();
         }
      }

      if(var2.field902) {
         if(var4 == 127) {
            var2.method1168(var2.field896, var2.field888);
         } else {
            byte var26;
            if(var4 != -1) {
               var26 = var4;
            } else {
               var26 = class97.field1491[var1];
            }

            var2.method1147(var2.field896, var2.field888, var26);
         }
      }

   }
}
