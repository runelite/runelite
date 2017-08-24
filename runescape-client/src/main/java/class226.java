import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
public class class226 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)Lhj;",
      garbageValue = "1"
   )
   public static BuildType method4107(int var0) {
      BuildType[] var1 = new BuildType[]{BuildType.LIVE, BuildType.WIP, BuildType.RC, BuildType.BUILD_LIVE};
      BuildType[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         BuildType var4 = var2[var3];
         if(var0 == var4.ordinal) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfn;ILbo;II)V",
      garbageValue = "1162573082"
   )
   static final void method4108(PacketBuffer var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 16) != 0) {
         var5 = var0.readUnsignedByte();
         byte[] var6 = new byte[var5];
         Buffer var7 = new Buffer(var6);
         var0.readBytes(var6, 0, var5);
         class95.field1506[var1] = var7;
         var2.decodeApperance(var7);
      }

      int var17;
      if((var3 & 64) != 0) {
         var5 = var0.readUnsignedShort();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var17 = var0.readUnsignedByte();
         class15.method95(var2, var5, var17);
      }

      if((var3 & 128) != 0) {
         var2.interacting = var0.readUnsignedShort();
         if(var2.interacting == '\uffff') {
            var2.interacting = -1;
         }
      }

      if((var3 & 2) != 0) {
         var2.overhead = var0.readString();
         if(var2.overhead.charAt(0) == 126) {
            var2.overhead = var2.overhead.substring(1);
            Client.sendGameMessage(2, var2.name, var2.overhead);
         } else if(var2 == Player.localPlayer) {
            Client.sendGameMessage(2, var2.name, var2.overhead);
         }

         var2.field1243 = false;
         var2.field1246 = 0;
         var2.field1237 = 0;
         var2.field1245 = 150;
      }

      int var9;
      int var10;
      if((var3 & 8) != 0) {
         var5 = var0.readUnsignedByte();
         int var8;
         int var11;
         int var18;
         if(var5 > 0) {
            for(var17 = 0; var17 < var5; ++var17) {
               var8 = -1;
               var9 = -1;
               var10 = -1;
               var18 = var0.getUSmart();
               if(var18 == 32767) {
                  var18 = var0.getUSmart();
                  var9 = var0.getUSmart();
                  var8 = var0.getUSmart();
                  var10 = var0.getUSmart();
               } else if(var18 != 32766) {
                  var9 = var0.getUSmart();
               } else {
                  var18 = -1;
               }

               var11 = var0.getUSmart();
               var2.method1525(var18, var9, var8, var10, Client.gameCycle, var11);
            }
         }

         var17 = var0.readUnsignedByte();
         if(var17 > 0) {
            for(var18 = 0; var18 < var17; ++var18) {
               var8 = var0.getUSmart();
               var9 = var0.getUSmart();
               if(var9 != 32767) {
                  var10 = var0.getUSmart();
                  var11 = var0.readUnsignedByte();
                  int var12 = var9 > 0?var0.readUnsignedByte():var11;
                  var2.method1522(var8, Client.gameCycle, var9, var10, var11, var12);
               } else {
                  var2.method1527(var8);
               }
            }
         }
      }

      if((var3 & 1) != 0) {
         var2.field1257 = var0.readUnsignedShort();
         if(var2.queueSize == 0) {
            var2.orientation = var2.field1257;
            var2.field1257 = -1;
         }
      }

      if((var3 & 32) != 0) {
         var5 = var0.readUnsignedShort();
         Permission[] var20 = new Permission[]{Permission.field3175, Permission.field3174, Permission.field3177, Permission.field3179, Permission.field3178, Permission.field3181};
         Permission var21 = (Permission)class88.forOrdinal(var20, var0.readUnsignedByte());
         boolean var23 = var0.readUnsignedByte() == 1;
         var9 = var0.readUnsignedByte();
         var10 = var0.offset;
         if(var2.name != null && var2.composition != null) {
            boolean var24 = false;
            if(var21.field3183 && class24.isIgnored(var2.name)) {
               var24 = true;
            }

            if(!var24 && Client.field1050 == 0 && !var2.hidden) {
               class95.field1516.offset = 0;
               var0.readBytes(class95.field1516.payload, 0, var9);
               class95.field1516.offset = 0;
               String var19 = FontTypeFace.appendTags(class61.method1100(class165.method3151(class95.field1516)));
               var2.overhead = var19.trim();
               var2.field1246 = var5 >> 8;
               var2.field1237 = var5 & 255;
               var2.field1245 = 150;
               var2.field1243 = var23;
               var2.inSequence = var2 != Player.localPlayer && var21.field3183 && "" != Client.field1150 && var19.toLowerCase().indexOf(Client.field1150) == -1;
               int var13;
               if(var21.field3182) {
                  var13 = var23?91:1;
               } else {
                  var13 = var23?90:2;
               }

               if(var21.field3176 != -1) {
                  int var16 = var21.field3176;
                  String var15 = "<img=" + var16 + ">";
                  Client.sendGameMessage(var13, var15 + var2.name, var19);
               } else {
                  Client.sendGameMessage(var13, var2.name, var19);
               }
            }
         }

         var0.offset = var10 + var9;
      }

      if((var3 & 512) != 0) {
         var2.graphic = var0.readUnsignedShort();
         var5 = var0.readInt();
         var2.field1270 = var5 >> 16;
         var2.graphicsDelay = (var5 & '\uffff') + Client.gameCycle;
         var2.field1267 = 0;
         var2.field1240 = 0;
         if(var2.graphicsDelay > Client.gameCycle) {
            var2.field1267 = -1;
         }

         if(var2.graphic == '\uffff') {
            var2.graphic = -1;
         }
      }

      if((var3 & 1024) != 0) {
         var2.field1271 = var0.readByte();
         var2.field1229 = var0.readByte();
         var2.field1239 = var0.readByte();
         var2.field1274 = var0.readByte();
         var2.field1275 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field1276 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field1277 = var0.readUnsignedShort();
         if(var2.field909) {
            var2.field1271 += var2.field905;
            var2.field1229 += var2.field926;
            var2.field1239 += var2.field905;
            var2.field1274 += var2.field926;
            var2.queueSize = 0;
         } else {
            var2.field1271 += var2.pathX[0];
            var2.field1229 += var2.pathY[0];
            var2.field1239 += var2.pathX[0];
            var2.field1274 += var2.pathY[0];
            var2.queueSize = 1;
         }

         var2.field1249 = 0;
      }

      if((var3 & 4096) != 0) {
         class95.field1513[var1] = var0.readByte();
      }

      if((var3 & 2048) != 0) {
         var4 = var0.readByte();
      }

      if((var3 & 256) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.readString();
         }
      }

      if(var2.field909) {
         if(var4 == 127) {
            var2.method1153(var2.field905, var2.field926);
         } else {
            byte var22;
            if(var4 != -1) {
               var22 = var4;
            } else {
               var22 = class95.field1513[var1];
            }

            var2.method1152(var2.field905, var2.field926, var22);
         }
      }

   }
}
