import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 115242721
   )
   static int field415;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -235142583
   )
   int field406;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -891597415
   )
   int field414;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1769378231
   )
   int field407;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1980177303
   )
   int field409;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1562257621
   )
   int field405;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2014289059
   )
   int field410;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1773370157
   )
   int field411;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1526432955
   )
   int field412;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -3137615
   )
   int field408;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2126751421
   )
   int field413;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "269119455"
   )
   public void vmethod751(WorldMapData var1) {
      if(var1.minX > this.field411) {
         var1.minX = this.field411;
      }

      if(var1.field431 < this.field408) {
         var1.field431 = this.field408;
      }

      if(var1.minY > this.field412) {
         var1.minY = this.field412;
      }

      if(var1.field436 < this.field413) {
         var1.field436 = this.field413;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "520265099"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.field406 && var1 < this.field406 + this.field414?var2 >> 6 >= this.field407 && var2 >> 6 <= this.field405 && var3 >> 6 >= this.field409 && var3 >> 6 <= this.field410:false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIS)Z",
      garbageValue = "9376"
   )
   public boolean vmethod758(int var1, int var2) {
      return var1 >> 6 >= this.field411 && var1 >> 6 <= this.field408 && var2 >> 6 >= this.field412 && var2 >> 6 <= this.field413;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "174791792"
   )
   public int[] vmethod754(int var1, int var2, int var3) {
      if(!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field411 * 64 - this.field407 * 64 + var2, var3 + (this.field412 * 64 - this.field409 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)Lim;",
      garbageValue = "-64"
   )
   public Coordinates vmethod777(int var1, int var2) {
      if(!this.vmethod758(var1, var2)) {
         return null;
      } else {
         int var3 = this.field407 * 64 - this.field411 * 64 + var1;
         int var4 = this.field409 * 64 - this.field412 * 64 + var2;
         return new Coordinates(this.field406, var3, var4);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "-314407075"
   )
   public void vmethod756(Buffer var1) {
      this.field406 = var1.readUnsignedByte();
      this.field414 = var1.readUnsignedByte();
      this.field407 = var1.readUnsignedShort();
      this.field409 = var1.readUnsignedShort();
      this.field405 = var1.readUnsignedShort();
      this.field410 = var1.readUnsignedShort();
      this.field411 = var1.readUnsignedShort();
      this.field412 = var1.readUnsignedShort();
      this.field408 = var1.readUnsignedShort();
      this.field413 = var1.readUnsignedShort();
      this.method294();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-14"
   )
   void method294() {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lbz;Lbz;IZI)I",
      garbageValue = "601196409"
   )
   static int method278(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1624()?(var1.method1624()?0:1):(var1.method1624()?-1:0)):(var2 == 5?(var0.method1609()?(var1.method1609()?0:1):(var1.method1609()?-1:0)):(var2 == 6?(var0.method1610()?(var1.method1610()?0:1):(var1.method1610()?-1:0)):(var2 == 7?(var0.method1614()?(var1.method1614()?0:1):(var1.method1614()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(Lbg;II)V",
      garbageValue = "517651227"
   )
   static final void method300(Actor var0, int var1) {
      int var2;
      int var3;
      int var4;
      if(var0.field1196 > Client.gameCycle) {
         var2 = var0.field1196 - Client.gameCycle;
         var3 = var0.field1192 * 128 + var0.field1153 * 64;
         var4 = var0.field1202 * 128 + var0.field1153 * 64;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field1208 = 0;
         var0.orientation = var0.field1198;
      } else if(var0.field1197 >= Client.gameCycle) {
         class44.method661(var0);
      } else {
         CombatInfoListHolder.method1823(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1196 = 0;
         var0.field1197 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1153 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1153 * 64;
         var0.method1589();
      }

      if(WorldComparator.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1196 = 0;
         var0.field1197 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1153 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1153 * 64;
         var0.method1589();
      }

      if(var0.field1203 != 0) {
         if(var0.interacting != -1) {
            Object var5 = null;
            if(var0.interacting < 32768) {
               var5 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= 32768) {
               var5 = Client.cachedPlayers[var0.interacting - 32768];
            }

            if(var5 != null) {
               var3 = var0.x - ((Actor)var5).x;
               var4 = var0.y - ((Actor)var5).y;
               if(var3 != 0 || var4 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field1177) {
               var0.interacting = -1;
               var0.field1177 = false;
            }
         }

         if(var0.field1165 != -1 && (var0.queueSize == 0 || var0.field1208 > 0)) {
            var0.orientation = var0.field1165;
            var0.field1165 = -1;
         }

         var2 = var0.orientation - var0.angle & 2047;
         if(var2 == 0 && var0.field1177) {
            var0.interacting = -1;
            var0.field1177 = false;
         }

         if(var2 != 0) {
            ++var0.field1149;
            boolean var7;
            if(var2 > 1024) {
               var0.angle -= var0.field1203;
               var7 = true;
               if(var2 < var0.field1203 || var2 > 2048 - var0.field1203) {
                  var0.angle = var0.orientation;
                  var7 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field1149 > 25 || var7)) {
                  if(var0.field1195 != -1) {
                     var0.poseAnimation = var0.field1195;
                  } else {
                     var0.poseAnimation = var0.field1158;
                  }
               }
            } else {
               var0.angle += var0.field1203;
               var7 = true;
               if(var2 < var0.field1203 || var2 > 2048 - var0.field1203) {
                  var0.angle = var0.orientation;
                  var7 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1149 > 25 || var7)) {
                  if(var0.field1157 != -1) {
                     var0.poseAnimation = var0.field1157;
                  } else {
                     var0.poseAnimation = var0.field1158;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1149 = 0;
         }
      }

      class55.method828(var0);
   }

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "(Lib;I)V",
      garbageValue = "2131281369"
   )
   static void method274(Widget var0) {
      if(var0.loopCycle == Client.field1059) {
         Client.field1060[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2030142323"
   )
   static void method298() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.first(); var0 != null; var0 = (WidgetNode)Client.componentTable.next()) {
         int var1 = var0.id;
         if(Name.loadWidget(var1)) {
            boolean var2 = true;
            Widget[] var3 = class189.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class3.getWidget(var4);
               if(var5 != null) {
                  method274(var5);
               }
            }
         }
      }

   }
}
