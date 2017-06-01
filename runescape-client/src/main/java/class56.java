import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
public class class56 {
   @ObfuscatedName("c")
   public static String field690;
   @ObfuscatedName("f")
   static ModIcon[] field692;
   @ObfuscatedName("i")
   static Applet field694;
   @ObfuscatedName("nr")
   static class276 field695;

   static {
      field694 = null;
      field690 = null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIS)I",
      garbageValue = "-21127"
   )
   static final int method802(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class277.method4896(var3, var5);
      int var8 = class277.method4896(var3 + 1, var5);
      int var9 = class277.method4896(var3, var5 + 1);
      int var10 = class277.method4896(var3 + 1, var5 + 1);
      int var11 = class40.method535(var7, var8, var4, var2);
      int var12 = class40.method535(var9, var10, var4, var2);
      return class40.method535(var11, var12, var6, var2);
   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "742313030"
   )
   static final void method804(Actor var0, int var1) {
      class34.method472(var0.x, var0.y, var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;ILPlayer;II)V",
      garbageValue = "196370896"
   )
   static final void method805(PacketBuffer var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 16) != 0) {
         var5 = var0.readUnsignedByte();
         byte[] var6 = new byte[var5];
         Buffer var7 = new Buffer(var6);
         var0.readBytes(var6, 0, var5);
         class96.field1506[var1] = var7;
         var2.method1116(var7);
      }

      int var18;
      if((var3 & 1) != 0) {
         var5 = var0.readUnsignedShort();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var18 = var0.readUnsignedByte();
         class11.method51(var2, var5, var18);
      }

      if((var3 & 128) != 0) {
         var2.interacting = var0.readUnsignedShort();
         if(var2.interacting == '\uffff') {
            var2.interacting = -1;
         }
      }

      if((var3 & 4) != 0) {
         var2.overhead = var0.readString();
         if(var2.overhead.charAt(0) == 126) {
            var2.overhead = var2.overhead.substring(1);
            class18.sendGameMessage(2, var2.name, var2.overhead);
         } else if(var2 == World.localPlayer) {
            class18.sendGameMessage(2, var2.name, var2.overhead);
         }

         var2.field1256 = false;
         var2.field1245 = 0;
         var2.field1294 = 0;
         var2.field1258 = 150;
      }

      int var8;
      int var9;
      if((var3 & 2) != 0) {
         var5 = var0.readUnsignedByte();
         int var10;
         int var11;
         int var19;
         if(var5 > 0) {
            for(var18 = 0; var18 < var5; ++var18) {
               var8 = -1;
               var9 = -1;
               var10 = -1;
               var19 = var0.method3154();
               if(var19 == 32767) {
                  var19 = var0.method3154();
                  var9 = var0.method3154();
                  var8 = var0.method3154();
                  var10 = var0.method3154();
               } else if(var19 != 32766) {
                  var9 = var0.method3154();
               } else {
                  var19 = -1;
               }

               var11 = var0.method3154();
               var2.method1516(var19, var9, var8, var10, Client.gameCycle, var11);
            }
         }

         var18 = var0.readUnsignedByte();
         if(var18 > 0) {
            for(var19 = 0; var19 < var18; ++var19) {
               var8 = var0.method3154();
               var9 = var0.method3154();
               if(var9 != 32767) {
                  var10 = var0.method3154();
                  var11 = var0.readUnsignedByte();
                  int var12 = var9 > 0?var0.readUnsignedByte():var11;
                  var2.method1529(var8, Client.gameCycle, var9, var10, var11, var12);
               } else {
                  var2.method1524(var8);
               }
            }
         }
      }

      if((var3 & 32) != 0) {
         var2.field1270 = var0.readUnsignedShort();
         if(var2.field1263 == 0) {
            var2.field1259 = var2.field1270;
            var2.field1270 = -1;
         }
      }

      if((var3 & 64) != 0) {
         var5 = var0.readUnsignedShort();
         class230 var25 = (class230)Item.method1751(class100.method1857(), var0.readUnsignedByte());
         boolean var28 = var0.readUnsignedByte() == 1;
         var8 = var0.readUnsignedByte();
         var9 = var0.offset;
         if(var2.name != null && var2.composition != null) {
            boolean var27 = false;
            if(var25.field3171 && class211.method3910(var2.name)) {
               var27 = true;
            }

            if(!var27 && Client.field985 == 0 && !var2.field913) {
               class96.field1516.offset = 0;
               var0.readBytes(class96.field1516.payload, 0, var8);
               class96.field1516.offset = 0;
               Buffer var20 = class96.field1516;

               String var13;
               int var14;
               String var16;
               try {
                  var14 = var20.method3154();
                  if(var14 > 32767) {
                     var14 = 32767;
                  }

                  byte[] var15 = new byte[var14];
                  var20.offset += class265.field3654.method3077(var20.payload, var20.offset, var15, 0, var14);
                  var16 = class243.method4326(var15, 0, var14);
                  var13 = var16;
               } catch (Exception var24) {
                  var13 = "Cabbage";
               }

               var13 = FontTypeFace.method4776(class116.method2098(var13));
               var2.overhead = var13.trim();
               var2.field1245 = var5 >> 8;
               var2.field1294 = var5 & 255;
               var2.field1258 = 150;
               var2.field1256 = var28;
               var2.inSequence = World.localPlayer != var2 && var25.field3171 && Client.field1148 != "" && var13.toLowerCase().indexOf(Client.field1148) == -1;
               if(var25.field3173) {
                  var14 = var28?91:1;
               } else {
                  var14 = var28?90:2;
               }

               if(var25.field3174 != -1) {
                  int var17 = var25.field3174;
                  var16 = "<img=" + var17 + ">";
                  class18.sendGameMessage(var14, var16 + var2.name, var13);
               } else {
                  class18.sendGameMessage(var14, var2.name, var13);
               }
            }
         }

         var0.offset = var8 + var9;
      }

      if((var3 & 2048) != 0) {
         var2.graphic = var0.readUnsignedShort();
         var5 = var0.readInt();
         var2.field1302 = var5 >> 16;
         var2.field1296 = Client.gameCycle + (var5 & '\uffff');
         var2.field1280 = 0;
         var2.field1281 = 0;
         if(var2.field1296 > Client.gameCycle) {
            var2.field1280 = -1;
         }

         if(var2.graphic == '\uffff') {
            var2.graphic = -1;
         }
      }

      if((var3 & 256) != 0) {
         var2.field1284 = var0.readByte();
         var2.field1286 = var0.readByte();
         var2.field1285 = var0.readByte();
         var2.field1287 = var0.readByte();
         var2.field1250 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field1289 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field1290 = var0.readUnsignedShort();
         if(var2.field890) {
            var2.field1284 += var2.field914;
            var2.field1286 += var2.field915;
            var2.field1285 += var2.field914;
            var2.field1287 += var2.field915;
            var2.field1263 = 0;
         } else {
            var2.field1284 += var2.pathX[0];
            var2.field1286 += var2.pathY[0];
            var2.field1285 += var2.pathX[0];
            var2.field1287 += var2.pathY[0];
            var2.field1263 = 1;
         }

         var2.field1301 = 0;
      }

      if((var3 & 1024) != 0) {
         class96.field1503[var1] = var0.readByte();
      }

      if((var3 & 4096) != 0) {
         var4 = var0.readByte();
      }

      if((var3 & 512) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.readString();
         }
      }

      if(var2.field890) {
         if(var4 == 127) {
            var2.method1120(var2.field914, var2.field915);
         } else {
            byte var26;
            if(var4 != -1) {
               var26 = var4;
            } else {
               var26 = class96.field1503[var1];
            }

            var2.method1119(var2.field914, var2.field915, var26);
         }
      }

   }
}
