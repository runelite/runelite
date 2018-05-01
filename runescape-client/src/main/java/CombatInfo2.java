import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   public static IndexDataBase field3532;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   static IndexDataBase field3528;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   public static NodeCache field3524;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   public static NodeCache field3531;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1555162827
   )
   public int field3526;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 373895453
   )
   public int field3536;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -833849461
   )
   public int field3529;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -804361193
   )
   public int field3523;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 897693753
   )
   public int field3530;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -346286221
   )
   public int field3522;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1140037733
   )
   int field3533;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1451462111
   )
   int field3534;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1492115973
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1049118409
   )
   public int field3525;

   static {
      field3524 = new NodeCache(64);
      field3531 = new NodeCache(64);
   }

   public CombatInfo2() {
      this.field3536 = 255;
      this.field3529 = 255;
      this.field3523 = -1;
      this.field3530 = 1;
      this.field3522 = 70;
      this.field3533 = -1;
      this.field3534 = -1;
      this.healthScale = 30;
      this.field3525 = 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgc;I)V",
      garbageValue = "-597317833"
   )
   @Export("read")
   public void read(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgc;II)V",
      garbageValue = "1621287024"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3536 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3529 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3523 = 0;
      } else if(var2 == 5) {
         this.field3522 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3533 = var1.method3576();
      } else if(var2 == 8) {
         this.field3534 = var1.method3576();
      } else if(var2 == 11) {
         this.field3523 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3525 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Lld;",
      garbageValue = "1803764626"
   )
   public SpritePixels method4862() {
      if(this.field3533 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3531.get((long)this.field3533);
         if(var1 != null) {
            return var1;
         } else {
            var1 = SoundTaskDataProvider.method817(field3528, this.field3533, 0);
            if(var1 != null) {
               field3531.put(var1, (long)this.field3533);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Lld;",
      garbageValue = "-663157013"
   )
   public SpritePixels method4863() {
      if(this.field3534 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3531.get((long)this.field3534);
         if(var1 != null) {
            return var1;
         } else {
            var1 = SoundTaskDataProvider.method817(field3528, this.field3534, 0);
            if(var1 != null) {
               field3531.put(var1, (long)this.field3534);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)Ljp;",
      garbageValue = "0"
   )
   public static class278 method4877(int var0) {
      class278 var1 = (class278)class278.field3546.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class278.field3547.getConfigData(11, var0);
         var1 = new class278();
         if(var2 != null) {
            var1.method4901(new Buffer(var2));
         }

         var1.method4900();
         class278.field3546.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgs;ILbz;II)V",
      garbageValue = "-1596849188"
   )
   static final void method4869(PacketBuffer var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      if((var3 & 4) != 0) {
         var2.overhead = var0.readString();
         if(var2.overhead.charAt(0) == '~') {
            var2.overhead = var2.overhead.substring(1);
            class57.sendGameMessage(2, var2.name.getName(), var2.overhead);
         } else if(var2 == SoundTaskDataProvider.localPlayer) {
            class57.sendGameMessage(2, var2.name.getName(), var2.overhead);
         }

         var2.field1168 = false;
         var2.field1174 = 0;
         var2.field1175 = 0;
         var2.overheadTextCyclesRemaining = 150;
      }

      if((var3 & 64) != 0) {
         var2.interacting = var0.readUnsignedShort();
         if(var2.interacting == 65535) {
            var2.interacting = -1;
         }
      }

      if((var3 & 16) != 0) {
         var2.field1185 = var0.method3555();
         if(var2.queueSize == 0) {
            var2.orientation = var2.field1185;
            var2.field1185 = -1;
         }
      }

      int var5;
      int var6;
      int var9;
      int var10;
      if((var3 & 128) != 0) {
         var5 = var0.method3636();
         int var7;
         int var8;
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
               var2.method1657(var7, var9, var8, var10, Client.gameCycle, var11);
            }
         }

         var6 = var0.method3538();
         if(var6 > 0) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var0.getUSmart();
               var9 = var0.getUSmart();
               if(var9 != 32767) {
                  var10 = var0.getUSmart();
                  var11 = var0.method3538();
                  int var12 = var9 > 0?var0.readUnsignedShortOb1():var11;
                  var2.setCombatInfo(var8, Client.gameCycle, var9, var10, var11, var12);
               } else {
                  var2.method1659(var8);
               }
            }
         }
      }

      if((var3 & 2048) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.readString();
         }
      }

      if((var3 & 1) != 0) {
         var5 = var0.readUnsignedShort();
         if(var5 == 65535) {
            var5 = -1;
         }

         var6 = var0.method3538();
         GameObject.method3083(var2, var5, var6);
      }

      if((var3 & 256) != 0) {
         var2.graphic = var0.method3553();
         var5 = var0.method3563();
         var2.field1198 = var5 >> 16;
         var2.graphicsDelay = (var5 & 65535) + Client.gameCycle;
         var2.spotAnimFrame = 0;
         var2.spotAnimFrameCycle = 0;
         if(var2.graphicsDelay > Client.gameCycle) {
            var2.spotAnimFrame = -1;
         }

         if(var2.graphic == 65535) {
            var2.graphic = -1;
         }
      }

      if((var3 & 8) != 0) {
         var5 = var0.method3553();
         Permission[] var17 = new Permission[]{Permission.field3345, Permission.field3344, Permission.field3346, Permission.field3349, Permission.field3350, Permission.field3347};
         Permission var18 = (Permission)Permission.forOrdinal(var17, var0.readUnsignedShortOb1());
         boolean var21 = var0.readUnsignedByte() == 1;
         var9 = var0.method3538();
         var10 = var0.offset;
         if(var2.name != null && var2.composition != null) {
            boolean var22 = false;
            if(var18.field3352 && WorldMapRectangle.friendManager.isIgnored(var2.name)) {
               var22 = true;
            }

            if(!var22 && Client.myPlayerIndex == 0 && !var2.hidden) {
               class93.field1432.offset = 0;
               var0.method3565(class93.field1432.payload, 0, var9);
               class93.field1432.offset = 0;
               String var19 = FontTypeFace.appendTags(class303.method5406(WallObject.method3061(class93.field1432)));
               var2.overhead = var19.trim();
               var2.field1174 = var5 >> 8;
               var2.field1175 = var5 & 255;
               var2.overheadTextCyclesRemaining = 150;
               var2.field1168 = var21;
               var2.field1157 = var2 != SoundTaskDataProvider.localPlayer && var18.field3352 && "" != Client.field1085 && var19.toLowerCase().indexOf(Client.field1085) == -1;
               int var13;
               if(var18.field3351) {
                  var13 = var21?91:1;
               } else {
                  var13 = var21?90:2;
               }

               if(var18.field3348 != -1) {
                  int var16 = var18.field3348;
                  String var15 = "<img=" + var16 + ">";
                  class57.sendGameMessage(var13, var15 + var2.name.getName(), var19);
               } else {
                  class57.sendGameMessage(var13, var2.name.getName(), var19);
               }
            }
         }

         var0.offset = var10 + var9;
      }

      if((var3 & 512) != 0) {
         var4 = var0.method3548();
      }

      if((var3 & 1024) != 0) {
         var2.field1203 = var0.readByte();
         var2.field1199 = var0.method3725();
         var2.field1200 = var0.method3548();
         var2.field1202 = var0.method3634();
         var2.field1166 = var0.method3553() + Client.gameCycle;
         var2.field1204 = var0.method3554() + Client.gameCycle;
         var2.field1171 = var0.method3555();
         if(var2.field860) {
            var2.field1203 += var2.field861;
            var2.field1199 += var2.field837;
            var2.field1200 += var2.field861;
            var2.field1202 += var2.field837;
            var2.queueSize = 0;
         } else {
            var2.field1203 += var2.pathX[0];
            var2.field1199 += var2.pathY[0];
            var2.field1200 += var2.pathX[0];
            var2.field1202 += var2.pathY[0];
            var2.queueSize = 1;
         }

         var2.field1216 = 0;
      }

      if((var3 & 4096) != 0) {
         class93.field1429[var1] = var0.method3634();
      }

      if((var3 & 2) != 0) {
         var5 = var0.readUnsignedShortOb1();
         byte[] var23 = new byte[var5];
         Buffer var24 = new Buffer(var23);
         var0.method3661(var23, 0, var5);
         class93.field1430[var1] = var24;
         var2.decodeApperance(var24);
      }

      if(var2.field860) {
         if(var4 == 127) {
            var2.method1196(var2.field861, var2.field837);
         } else {
            byte var20;
            if(var4 != -1) {
               var20 = var4;
            } else {
               var20 = class93.field1429[var1];
            }

            var2.method1195(var2.field861, var2.field837, var20);
         }
      }

   }
}
