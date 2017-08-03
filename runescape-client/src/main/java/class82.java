import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public final class class82 extends Node {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   static Deque field1286;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 173762349
   )
   int field1290;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   ObjectComposition field1295;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1844247021
   )
   int field1289;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1847289649
   )
   int field1297;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 943047513
   )
   int field1293;
   @ObfuscatedName("o")
   int[] field1294;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ldn;"
   )
   class119 field1291;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ldn;"
   )
   class119 field1296;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -118366517
   )
   int field1287;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 287213543
   )
   int field1285;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1089883245
   )
   int field1292;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2139862249
   )
   int field1298;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -71907431
   )
   int field1284;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1344072607
   )
   int field1283;

   static {
      field1286 = new Deque();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-902125081"
   )
   void method1610() {
      int var1 = this.field1290;
      ObjectComposition var2 = this.field1295.getImpostor();
      if(var2 != null) {
         this.field1290 = var2.ambientSoundId;
         this.field1289 = var2.field3460 * 128;
         this.field1297 = var2.field3461;
         this.field1293 = var2.field3462;
         this.field1294 = var2.field3449;
      } else {
         this.field1290 = -1;
         this.field1289 = 0;
         this.field1297 = 0;
         this.field1293 = 0;
         this.field1294 = null;
      }

      if(var1 != this.field1290 && this.field1291 != null) {
         class2.field18.method1938(this.field1291);
         this.field1291 = null;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfy;ILbg;II)V",
      garbageValue = "637494777"
   )
   static final void method1618(PacketBuffer var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 1) != 0) {
         var5 = var0.readUnsignedByte();
         byte[] var6 = new byte[var5];
         Buffer var7 = new Buffer(var6);
         var0.readBytes(var6, 0, var5);
         class96.field1469[var1] = var7;
         var2.decodeApperance(var7);
      }

      int var19;
      if((var3 & 8) != 0) {
         var5 = var0.readUnsignedShort();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var19 = var0.readUnsignedByte();
         class51.method793(var2, var5, var19);
      }

      if((var3 & 128) != 0) {
         var2.interacting = var0.readUnsignedShort();
         if(var2.interacting == '\uffff') {
            var2.interacting = -1;
         }
      }

      if((var3 & 16) != 0) {
         var2.overhead = var0.readString();
         if(var2.overhead.charAt(0) == 126) {
            var2.overhead = var2.overhead.substring(1);
            class202.sendGameMessage(2, var2.name, var2.overhead);
         } else if(var2 == class224.localPlayer) {
            class202.sendGameMessage(2, var2.name, var2.overhead);
         }

         var2.field1203 = false;
         var2.field1206 = 0;
         var2.field1211 = 0;
         var2.field1213 = 150;
      }

      int var9;
      int var10;
      if((var3 & 32) != 0) {
         var5 = var0.readUnsignedByte();
         int var8;
         int var11;
         int var20;
         if(var5 > 0) {
            for(var19 = 0; var19 < var5; ++var19) {
               var8 = -1;
               var9 = -1;
               var10 = -1;
               var20 = var0.getUSmart();
               if(var20 == 32767) {
                  var20 = var0.getUSmart();
                  var9 = var0.getUSmart();
                  var8 = var0.getUSmart();
                  var10 = var0.getUSmart();
               } else if(var20 != 32766) {
                  var9 = var0.getUSmart();
               } else {
                  var20 = -1;
               }

               var11 = var0.getUSmart();
               var2.method1548(var20, var9, var8, var10, Client.gameCycle, var11);
            }
         }

         var19 = var0.readUnsignedByte();
         if(var19 > 0) {
            for(var20 = 0; var20 < var19; ++var20) {
               var8 = var0.getUSmart();
               var9 = var0.getUSmart();
               if(var9 != 32767) {
                  var10 = var0.getUSmart();
                  var11 = var0.readUnsignedByte();
                  int var12 = var9 > 0?var0.readUnsignedByte():var11;
                  var2.method1537(var8, Client.gameCycle, var9, var10, var11, var12);
               } else {
                  var2.method1539(var8);
               }
            }
         }
      }

      if((var3 & 64) != 0) {
         var2.field1209 = var0.readUnsignedShort();
         if(var2.queueSize == 0) {
            var2.orientation = var2.field1209;
            var2.field1209 = -1;
         }
      }

      if((var3 & 2) != 0) {
         var5 = var0.readUnsignedShort();
         Permission[] var22 = new Permission[]{Permission.field3156, Permission.field3154, Permission.field3157, Permission.field3153, Permission.field3155, Permission.field3152};
         Permission var23 = (Permission)CollisionData.forOrdinal(var22, var0.readUnsignedByte());
         boolean var25 = var0.readUnsignedByte() == 1;
         var9 = var0.readUnsignedByte();
         var10 = var0.offset;
         if(var2.name != null && var2.composition != null) {
            boolean var26 = false;
            if(var23.field3161 && class64.isIgnored(var2.name)) {
               var26 = true;
            }

            if(!var26 && Client.field1002 == 0 && !var2.hidden) {
               class96.field1479.offset = 0;
               var0.readBytes(class96.field1479.payload, 0, var9);
               class96.field1479.offset = 0;
               Buffer var13 = class96.field1479;
               String var21 = SceneTilePaint.method2695(var13, 32767);
               String var14 = FontTypeFace.appendTags(Sequence.method4712(var21));
               var2.overhead = var14.trim();
               var2.field1206 = var5 >> 8;
               var2.field1211 = var5 & 255;
               var2.field1213 = 150;
               var2.field1203 = var25;
               var2.inSequence = var2 != class224.localPlayer && var23.field3161 && "" != Client.field1102 && var14.toLowerCase().indexOf(Client.field1102) == -1;
               int var15;
               if(var23.field3160) {
                  var15 = var25?91:1;
               } else {
                  var15 = var25?90:2;
               }

               if(var23.field3159 != -1) {
                  int var18 = var23.field3159;
                  String var17 = "<img=" + var18 + ">";
                  class202.sendGameMessage(var15, var17 + var2.name, var14);
               } else {
                  class202.sendGameMessage(var15, var2.name, var14);
               }
            }
         }

         var0.offset = var10 + var9;
      }

      if((var3 & 1024) != 0) {
         var2.graphic = var0.readUnsignedShort();
         var5 = var0.readInt();
         var2.field1230 = var5 >> 16;
         var2.graphicsDelay = (var5 & '\uffff') + Client.gameCycle;
         var2.field1227 = 0;
         var2.field1228 = 0;
         if(var2.graphicsDelay > Client.gameCycle) {
            var2.field1227 = -1;
         }

         if(var2.graphic == '\uffff') {
            var2.graphic = -1;
         }
      }

      if((var3 & 256) != 0) {
         var2.field1204 = var0.readByte();
         var2.field1233 = var0.readByte();
         var2.field1232 = var0.readByte();
         var2.field1201 = var0.readByte();
         var2.field1235 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field1207 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field1208 = var0.readUnsignedShort();
         if(var2.field879) {
            var2.field1204 += var2.field868;
            var2.field1233 += var2.field882;
            var2.field1232 += var2.field868;
            var2.field1201 += var2.field882;
            var2.queueSize = 0;
         } else {
            var2.field1204 += var2.pathX[0];
            var2.field1233 += var2.pathY[0];
            var2.field1232 += var2.pathX[0];
            var2.field1201 += var2.pathY[0];
            var2.queueSize = 1;
         }

         var2.field1248 = 0;
      }

      if((var3 & 2048) != 0) {
         class96.field1467[var1] = var0.readByte();
      }

      if((var3 & 4096) != 0) {
         var4 = var0.readByte();
      }

      if((var3 & 512) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.readString();
         }
      }

      if(var2.field879) {
         if(var4 == 127) {
            var2.method1169(var2.field868, var2.field882);
         } else {
            byte var24;
            if(var4 != -1) {
               var24 = var4;
            } else {
               var24 = class96.field1467[var1];
            }

            var2.method1149(var2.field868, var2.field882, var24);
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-30"
   )
   @Export("getSmoothNoise2D")
   static final int getSmoothNoise2D(int var0, int var1) {
      int var2 = class73.method1138(var0 - 1, var1 - 1) + class73.method1138(var0 + 1, var1 - 1) + class73.method1138(var0 - 1, var1 + 1) + class73.method1138(var0 + 1, var1 + 1);
      int var3 = class73.method1138(var0 - 1, var1) + class73.method1138(var0 + 1, var1) + class73.method1138(var0, var1 - 1) + class73.method1138(var0, var1 + 1);
      int var4 = class73.method1138(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }
}
