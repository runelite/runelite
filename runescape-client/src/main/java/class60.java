import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
public final class class60 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1528311993
   )
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("v")
   static int[][] field762;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lit;IB)Lga;",
      garbageValue = "-33"
   )
   static class207 method1068(IndexDataBase var0, int var1) {
      byte[] var2 = var0.method4224(var1);
      return var2 == null?null:new class207(var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Ljz;",
      garbageValue = "-12426758"
   )
   public static IndexedSprite method1071() {
      IndexedSprite var0 = new IndexedSprite();
      var0.width = class287.field3808;
      var0.originalHeight = class164.field2325;
      var0.offsetX = class287.field3807[0];
      var0.offsetY = World.offsetsY[0];
      var0.originalWidth = class236.field3238[0];
      var0.height = FileSystem.field3207[0];
      var0.palette = class181.field2456;
      var0.pixels = class208.spritePixels[0];
      Actor.method1605();
      return var0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "264135181"
   )
   @Export("getColTags")
   static String getColTags(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfd;I)V",
      garbageValue = "1151243167"
   )
   static final void method1065(PacketBuffer var0) {
      for(int var1 = 0; var1 < class94.field1486; ++var1) {
         int var2 = class94.field1487[var1];
         Player var3 = Client.cachedPlayers[var2];
         int var4 = var0.readUnsignedByte();
         if((var4 & 4) != 0) {
            var4 += var0.readUnsignedByte() << 8;
         }

         byte var5 = -1;
         if((var4 & 128) != 0) {
            var3.interacting = var0.method3272();
            if(var3.interacting == 65535) {
               var3.interacting = -1;
            }
         }

         int var6;
         if((var4 & 2048) != 0) {
            var3.graphic = var0.method3274();
            var6 = var0.method3309();
            var3.field1214 = var6 >> 16;
            var3.graphicsDelay = (var6 & 65535) + Client.gameCycle;
            var3.field1249 = 0;
            var3.field1246 = 0;
            if(var3.graphicsDelay > Client.gameCycle) {
               var3.field1249 = -1;
            }

            if(var3.graphic == 65535) {
               var3.graphic = -1;
            }
         }

         if((var4 & 2) != 0) {
            var6 = var0.readUnsignedShortOb1();
            byte[] var7 = new byte[var6];
            Buffer var8 = new Buffer(var7);
            var0.method3291(var7, 0, var6);
            class94.field1478[var2] = var8;
            var3.decodeApperance(var8);
         }

         if((var4 & 4096) != 0) {
            var5 = var0.readByte();
         }

         if((var4 & 1024) != 0) {
            class94.field1477[var2] = var0.method3268();
         }

         if((var4 & 256) != 0) {
            for(var6 = 0; var6 < 3; ++var6) {
               var3.actions[var6] = var0.readString();
            }
         }

         if((var4 & 512) != 0) {
            var3.field1236 = var0.method3267();
            var3.field1229 = var0.method3267();
            var3.field1250 = var0.method3302();
            var3.field1216 = var0.method3302();
            var3.field1255 = var0.method3274() + Client.gameCycle;
            var3.field1254 = var0.method3272() + Client.gameCycle;
            var3.field1261 = var0.method3274();
            if(var3.field887) {
               var3.field1236 += var3.field907;
               var3.field1229 += var3.field908;
               var3.field1250 += var3.field907;
               var3.field1216 += var3.field908;
               var3.queueSize = 0;
            } else {
               var3.field1236 += var3.pathX[0];
               var3.field1229 += var3.pathY[0];
               var3.field1250 += var3.pathX[0];
               var3.field1216 += var3.pathY[0];
               var3.queueSize = 1;
            }

            var3.field1241 = 0;
         }

         int var9;
         int var10;
         int var13;
         int var17;
         if((var4 & 32) != 0) {
            var6 = var0.method3418();
            int var11;
            int var12;
            int var18;
            if(var6 > 0) {
               for(var17 = 0; var17 < var6; ++var17) {
                  var9 = -1;
                  var10 = -1;
                  var11 = -1;
                  var18 = var0.getUSmart();
                  if(var18 == 32767) {
                     var18 = var0.getUSmart();
                     var10 = var0.getUSmart();
                     var9 = var0.getUSmart();
                     var11 = var0.getUSmart();
                  } else if(var18 != 32766) {
                     var10 = var0.getUSmart();
                  } else {
                     var18 = -1;
                  }

                  var12 = var0.getUSmart();
                  var3.method1590(var18, var10, var9, var11, Client.gameCycle, var12);
               }
            }

            var17 = var0.readUnsignedByte();
            if(var17 > 0) {
               for(var18 = 0; var18 < var17; ++var18) {
                  var9 = var0.getUSmart();
                  var10 = var0.getUSmart();
                  if(var10 != 32767) {
                     var11 = var0.getUSmart();
                     var12 = var0.method3418();
                     var13 = var10 > 0?var0.method3418():var12;
                     var3.method1600(var9, Client.gameCycle, var10, var11, var12, var13);
                  } else {
                     var3.method1591(var9);
                  }
               }
            }
         }

         if((var4 & 8) != 0) {
            var6 = var0.method3299();
            if(var6 == 65535) {
               var6 = -1;
            }

            var17 = var0.readUnsignedByte();
            class2.method5(var3, var6, var17);
         }

         if((var4 & 16) != 0) {
            var6 = var0.method3272();
            Permission var20 = (Permission)class48.forOrdinal(ClanMember.method1195(), var0.readUnsignedByte());
            boolean var23 = var0.readUnsignedShortOb1() == 1;
            var9 = var0.method3265();
            var10 = var0.offset;
            if(var3.name != null && var3.composition != null) {
               boolean var22 = false;
               if(var20.field3183 && class162.isIgnored(var3.name)) {
                  var22 = true;
               }

               if(!var22 && Client.field1175 == 0 && !var3.hidden) {
                  class94.field1488.offset = 0;
                  var0.method3226(class94.field1488.payload, 0, var9);
                  class94.field1488.offset = 0;
                  String var19 = FontTypeFace.appendTags(DecorativeObject.method2967(class229.method4204(class94.field1488)));
                  var3.overhead = var19.trim();
                  var3.field1224 = var6 >> 8;
                  var3.field1225 = var6 & 255;
                  var3.field1223 = 150;
                  var3.field1221 = var23;
                  var3.inSequence = var3 != AbstractByteBuffer.localPlayer && var20.field3183 && "" != Client.field1131 && var19.toLowerCase().indexOf(Client.field1131) == -1;
                  if(var20.field3182) {
                     var13 = var23?91:1;
                  } else {
                     var13 = var23?90:2;
                  }

                  if(var20.field3181 != -1) {
                     int var16 = var20.field3181;
                     String var15 = "<img=" + var16 + ">";
                     MessageNode.sendGameMessage(var13, var15 + var3.name, var19);
                  } else {
                     MessageNode.sendGameMessage(var13, var3.name, var19);
                  }
               }
            }

            var0.offset = var10 + var9;
         }

         if((var4 & 64) != 0) {
            var3.field1235 = var0.method3274();
            if(var3.queueSize == 0) {
               var3.orientation = var3.field1235;
               var3.field1235 = -1;
            }
         }

         if((var4 & 1) != 0) {
            var3.overhead = var0.readString();
            if(var3.overhead.charAt(0) == '~') {
               var3.overhead = var3.overhead.substring(1);
               MessageNode.sendGameMessage(2, var3.name, var3.overhead);
            } else if(var3 == AbstractByteBuffer.localPlayer) {
               MessageNode.sendGameMessage(2, var3.name, var3.overhead);
            }

            var3.field1221 = false;
            var3.field1224 = 0;
            var3.field1225 = 0;
            var3.field1223 = 150;
         }

         if(var3.field887) {
            if(var5 == 127) {
               var3.method1173(var3.field907, var3.field908);
            } else {
               byte var21;
               if(var5 != -1) {
                  var21 = var5;
               } else {
                  var21 = class94.field1477[var2];
               }

               var3.method1168(var3.field907, var3.field908, var21);
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(CIB)C",
      garbageValue = "-96"
   )
   static char method1067(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      return var0 == 338?'O':(var0 == 339?'o':(var0 == 376?'Y':var0));
   }
}
