import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public final class class10 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1857216337
   )
   static int field93 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("bv")
   static class184 field94;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -395976639
   )
   static int field95 = 99;
   @ObfuscatedName("r")
   static final int[] field96 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1290850739
   )
   static int field97 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("c")
   @Export("overlayPaths")
   static byte[][][] overlayPaths;
   @ObfuscatedName("t")
   static int[] field99;
   @ObfuscatedName("x")
   @Export("tileSettings")
   static byte[][][] tileSettings = new byte[4][104][104];
   @ObfuscatedName("y")
   static final int[] field101 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("h")
   static final int[] field102 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("u")
   @Export("tileHeights")
   static int[][][] tileHeights = new int[4][105][105];
   @ObfuscatedName("w")
   static final int[] field104 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("n")
   static final int[] field105 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("s")
   static final int[] field106 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = 1848748705
   )
   static int field107;
   @ObfuscatedName("a")
   @Export("underlayIds")
   static byte[][][] underlayIds;
   @ObfuscatedName("f")
   @Export("overlayIds")
   static byte[][][] overlayIds;

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-105"
   )
   static final int method119() {
      if(class2.field21.field690) {
         return class60.plane;
      } else {
         int var0 = class176.method3243(class36.cameraX, GroundObject.cameraY, class60.plane);
         return var0 - class36.cameraZ < 800 && (tileSettings[class60.plane][class36.cameraX >> 7][GroundObject.cameraY >> 7] & 4) != 0?class60.plane:3;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass159;ILPlayer;II)V",
      garbageValue = "2079842499"
   )
   static final void method148(class159 var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 8) != 0) {
         var5 = var0.readUnsignedByte();
         byte[] var6 = new byte[var5];
         Buffer var7 = new Buffer(var6);
         var0.method2974(var6, 0, var5);
         class45.field887[var1] = var7;
         var2.method214(var7);
      }

      int var13;
      if((var3 & 4) != 0) {
         var5 = var0.readUnsignedShort();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var13 = var0.readUnsignedByte();
         XItemContainer.method167(var2, var5, var13);
      }

      if((var3 & 2) != 0) {
         var2.interacting = var0.readUnsignedShort();
         if(var2.interacting == '\uffff') {
            var2.interacting = -1;
         }
      }

      if((var3 & 128) != 0) {
         var2.overhead = var0.method2965();
         if(var2.overhead.charAt(0) == 126) {
            var2.overhead = var2.overhead.substring(1);
            class7.method99(2, var2.name, var2.overhead);
         } else if(var2 == class148.localPlayer) {
            class7.method99(2, var2.name, var2.overhead);
         }

         var2.field645 = false;
         var2.field599 = 0;
         var2.field617 = 0;
         var2.field615 = 150;
      }

      int var8;
      int var9;
      int var12;
      if((var3 & 64) != 0) {
         var5 = var0.readUnsignedByte();
         int var10;
         int var11;
         int var14;
         if(var5 > 0) {
            for(var13 = 0; var13 < var5; ++var13) {
               var8 = -1;
               var9 = -1;
               var10 = -1;
               var14 = var0.method2963();
               if(var14 == 32767) {
                  var14 = var0.method2963();
                  var9 = var0.method2963();
                  var8 = var0.method2963();
                  var10 = var0.method2963();
               } else if(var14 != 32766) {
                  var9 = var0.method2963();
               } else {
                  var14 = -1;
               }

               var11 = var0.method2963();
               var2.method614(var14, var9, var8, var10, Client.gameCycle, var11);
            }
         }

         var13 = var0.readUnsignedByte();
         if(var13 > 0) {
            for(var14 = 0; var14 < var13; ++var14) {
               var8 = var0.method2963();
               var9 = var0.method2963();
               if(var9 != 32767) {
                  var10 = var0.method2963();
                  var11 = var0.readUnsignedByte();
                  var12 = var9 > 0?var0.readUnsignedByte():var11;
                  var2.method605(var8, Client.gameCycle, var9, var10, var11, var12);
               } else {
                  var2.method606(var8);
               }
            }
         }
      }

      if((var3 & 16) != 0) {
         var2.field627 = var0.readUnsignedShort();
         if(var2.field653 == 0) {
            var2.field650 = var2.field627;
            var2.field627 = -1;
         }
      }

      if((var3 & 1) != 0) {
         var5 = var0.readUnsignedShort();
         class177 var16 = (class177)class181.method3258(class22.method211(), var0.readUnsignedByte());
         boolean var19 = var0.readUnsignedByte() == 1;
         var8 = var0.readUnsignedByte();
         var9 = var0.offset;
         if(var2.name != null && var2.composition != null) {
            boolean var18 = false;
            if(var16.field2648 && class164.method3115(var2.name)) {
               var18 = true;
            }

            if(!var18 && Client.field402 == 0 && !var2.field260) {
               class45.field897.offset = 0;
               var0.method2974(class45.field897.payload, 0, var8);
               class45.field897.offset = 0;
               String var15 = class209.method3866(Client.method589(class40.method738(class45.field897)));
               var2.overhead = var15.trim();
               var2.field599 = var5 >> 8;
               var2.field617 = var5 & 255;
               var2.field615 = 150;
               var2.field645 = var19;
               var2.inSequence = var2 != class148.localPlayer && var16.field2648 && Client.field554 != "" && var15.toLowerCase().indexOf(Client.field554) == -1;
               if(var16.field2649) {
                  var12 = var19?91:1;
               } else {
                  var12 = var19?90:2;
               }

               if(var16.field2641 != -1) {
                  class7.method99(var12, class109.method2012(var16.field2641) + var2.name, var15);
               } else {
                  class7.method99(var12, var2.name, var15);
               }
            }
         }

         var0.offset = var8 + var9;
      }

      if((var3 & 256) != 0) {
         var2.graphic = var0.readUnsignedShort();
         var5 = var0.method2780();
         var2.field640 = var5 >> 16;
         var2.field648 = Client.gameCycle + (var5 & '\uffff');
         var2.field634 = 0;
         var2.field638 = 0;
         if(var2.field648 > Client.gameCycle) {
            var2.field634 = -1;
         }

         if(var2.graphic == '\uffff') {
            var2.graphic = -1;
         }
      }

      if((var3 & 1024) != 0) {
         var2.field641 = var0.readByte();
         var2.field643 = var0.readByte();
         var2.field618 = var0.readByte();
         var2.field642 = var0.readByte();
         var2.field610 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field646 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field647 = var0.readUnsignedShort();
         if(var2.field263) {
            var2.field641 += var2.field264;
            var2.field643 += var2.field265;
            var2.field618 += var2.field264;
            var2.field642 += var2.field265;
            var2.field653 = 0;
         } else {
            var2.field641 += var2.pathX[0];
            var2.field643 += var2.pathY[0];
            var2.field618 += var2.pathX[0];
            var2.field642 += var2.pathY[0];
            var2.field653 = 1;
         }

         var2.field658 = 0;
      }

      if((var3 & 4096) != 0) {
         class45.field886[var1] = var0.readByte();
      }

      if((var3 & 512) != 0) {
         var4 = var0.readByte();
      }

      if((var3 & 2048) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.method2965();
         }
      }

      if(var2.field263) {
         if(var4 == 127) {
            var2.method218(var2.field264, var2.field265);
         } else {
            byte var17;
            if(var4 != -1) {
               var17 = var4;
            } else {
               var17 = class45.field886[var1];
            }

            var2.method217(var2.field264, var2.field265, var17);
         }
      }

   }
}
