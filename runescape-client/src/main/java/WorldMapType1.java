import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2022928495
   )
   int field440;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1821670329
   )
   int field441;
   @ObfuscatedName("pj")
   static class102 field442;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -229727183
   )
   int field443;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 641671657
   )
   int field444;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1329851433
   )
   int field445;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -866290523
   )
   int field447;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 605342841
   )
   int field448;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2075334199
   )
   int field449;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1235793237
   )
   int field450;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1670998689
   )
   int field452;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;I)V",
      garbageValue = "-466828627"
   )
   public void vmethod680(WorldMapData var1) {
      if(var1.field459 > this.field440) {
         var1.field459 = this.field440;
      }

      if(var1.field465 < this.field449) {
         var1.field465 = this.field449;
      }

      if(var1.field466 > this.field447) {
         var1.field466 = this.field447;
      }

      if(var1.field458 < this.field452) {
         var1.field458 = this.field452;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-2095092414"
   )
   public boolean vmethod678(int var1, int var2, int var3) {
      return var1 >= this.field448 && var1 < this.field441 + this.field448?var2 >> 6 >= this.field450 && var2 >> 6 <= this.field444 && var3 >> 6 >= this.field443 && var3 >> 6 <= this.field445:false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "108"
   )
   public boolean vmethod679(int var1, int var2) {
      return var1 >> 6 >= this.field440 && var1 >> 6 <= this.field449 && var2 >> 6 >= this.field447 && var2 >> 6 <= this.field452;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "630255391"
   )
   public int[] vmethod682(int var1, int var2, int var3) {
      if(!this.vmethod678(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{var2 + (this.field440 * 64 - this.field450 * 64), var3 + (this.field447 * 64 - this.field443 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)LCoordinates;",
      garbageValue = "-1537373407"
   )
   public Coordinates vmethod685(int var1, int var2) {
      if(!this.vmethod679(var1, var2)) {
         return null;
      } else {
         int var3 = this.field450 * 64 - this.field440 * 64 + var1;
         int var4 = var2 + (this.field443 * 64 - this.field447 * 64);
         return new Coordinates(this.field448, var3, var4);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1315256502"
   )
   public void vmethod684(Buffer var1) {
      this.field448 = var1.readUnsignedByte();
      this.field441 = var1.readUnsignedByte();
      this.field450 = var1.readUnsignedShort();
      this.field443 = var1.readUnsignedShort();
      this.field444 = var1.readUnsignedShort();
      this.field445 = var1.readUnsignedShort();
      this.field440 = var1.readUnsignedShort();
      this.field447 = var1.readUnsignedShort();
      this.field449 = var1.readUnsignedShort();
      this.field452 = var1.readUnsignedShort();
      this.method269();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1868442421"
   )
   public static int method263(int var0) {
      return var0 >> 11 & 63;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1643816195"
   )
   void method269() {
   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "-2132467956"
   )
   static final void method272(Actor var0, int var1) {
      int var2;
      int var3;
      int var4;
      if(var0.field1254 > Client.gameCycle) {
         var2 = var0.field1254 - Client.gameCycle;
         var3 = var0.field1212 * 64 + var0.field1250 * 128;
         var4 = var0.field1212 * 64 + var0.field1213 * 128;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field1266 = 0;
         var0.orientation = var0.field1261;
      } else if(var0.field1259 >= Client.gameCycle) {
         if(var0.field1259 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field1242 + 1 > GameEngine.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
            var2 = var0.field1259 - var0.field1254;
            var3 = Client.gameCycle - var0.field1254;
            var4 = var0.field1212 * 64 + var0.field1250 * 128;
            int var5 = var0.field1212 * 64 + var0.field1213 * 128;
            int var6 = var0.field1212 * 64 + var0.field1256 * 128;
            int var7 = var0.field1212 * 64 + var0.field1253 * 128;
            var0.x = ((var2 - var3) * var4 + var3 * var6) / var2;
            var0.y = (var5 * (var2 - var3) + var3 * var7) / var2;
         }

         var0.field1266 = 0;
         var0.orientation = var0.field1261;
         var0.angle = var0.orientation;
      } else {
         XClanMember.method1096(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1254 = 0;
         var0.field1259 = 0;
         var0.x = var0.field1212 * 64 + var0.pathX[0] * 128;
         var0.y = var0.field1212 * 64 + var0.pathY[0] * 128;
         var0.method1441();
      }

      if(class20.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1254 = 0;
         var0.field1259 = 0;
         var0.x = var0.field1212 * 64 + var0.pathX[0] * 128;
         var0.y = var0.field1212 * 64 + var0.pathY[0] * 128;
         var0.method1441();
      }

      CollisionData.method2924(var0);
      var0.field1211 = false;
      Sequence var8;
      if(var0.poseAnimation != -1) {
         var8 = GameEngine.getAnimation(var0.poseAnimation);
         if(var8 != null && var8.frameIDs != null) {
            ++var0.field1231;
            if(var0.poseFrame < var8.frameIDs.length && var0.field1231 > var8.frameLenghts[var0.poseFrame]) {
               var0.field1231 = 1;
               ++var0.poseFrame;
               FaceNormal.method2763(var8, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var8.frameIDs.length) {
               var0.field1231 = 0;
               var0.poseFrame = 0;
               FaceNormal.method2763(var8, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.field1248) {
         if(var0.field1221 < 0) {
            var0.field1221 = 0;
         }

         var2 = Area.method4176(var0.graphic).field3335;
         if(var2 != -1) {
            Sequence var9 = GameEngine.getAnimation(var2);
            if(var9 != null && var9.frameIDs != null) {
               ++var0.field1247;
               if(var0.field1221 < var9.frameIDs.length && var0.field1247 > var9.frameLenghts[var0.field1221]) {
                  var0.field1247 = 1;
                  ++var0.field1221;
                  FaceNormal.method2763(var9, var0.field1221, var0.x, var0.y);
               }

               if(var0.field1221 >= var9.frameIDs.length && (var0.field1221 < 0 || var0.field1221 >= var9.frameIDs.length)) {
                  var0.graphic = -1;
               }
            } else {
               var0.graphic = -1;
            }
         } else {
            var0.graphic = -1;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable <= 1) {
         var8 = GameEngine.getAnimation(var0.animation);
         if(var8.precedenceAnimating == 1 && var0.field1267 > 0 && var0.field1254 <= Client.gameCycle && var0.field1259 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var8 = GameEngine.getAnimation(var0.animation);
         if(var8 != null && var8.frameIDs != null) {
            ++var0.field1242;
            if(var0.actionFrame < var8.frameIDs.length && var0.field1242 > var8.frameLenghts[var0.actionFrame]) {
               var0.field1242 = 1;
               ++var0.actionFrame;
               FaceNormal.method2763(var8, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var8.frameIDs.length) {
               var0.actionFrame -= var8.frameStep;
               ++var0.field1244;
               if(var0.field1244 >= var8.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var8.frameIDs.length) {
                  FaceNormal.method2763(var8, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1211 = var8.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "1925622714"
   )
   public static void method274(IndexDataBase var0) {
      class21.field353 = var0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1357622821"
   )
   static final int method275(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
