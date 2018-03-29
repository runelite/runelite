import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
@Implements("MapIcon")
public class MapIcon {
   @ObfuscatedName("at")
   protected static boolean field508;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1180295891
   )
   @Export("areaId")
   public final int areaId;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   public final Coordinates field512;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   public final Coordinates field506;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1988251845
   )
   final int field507;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1249163721
   )
   final int field504;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lah;"
   )
   final MapLabel field509;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -369339579
   )
   @Export("screenX")
   int screenX;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1335900661
   )
   @Export("screenY")
   int screenY;

   @ObfuscatedSignature(
      signature = "(ILim;Lim;Lah;)V"
   )
   MapIcon(int var1, Coordinates var2, Coordinates var3, MapLabel var4) {
      this.areaId = var1;
      this.field506 = var2;
      this.field512 = var3;
      this.field509 = var4;
      Area var5 = Area.mapAreaType[this.areaId];
      SpritePixels var6 = var5.getMapIcon(false);
      if(var6 != null) {
         this.field507 = var6.width;
         this.field504 = var6.height;
      } else {
         this.field507 = 0;
         this.field504 = 0;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1655949603"
   )
   boolean method563(int var1, int var2) {
      return this.method562(var1, var2)?true:this.method573(var1, var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-453936994"
   )
   boolean method562(int var1, int var2) {
      Area var3 = Area.mapAreaType[this.areaId];
      switch(var3.horizontalAlignment.value) {
      case 0:
         if(var1 >= this.screenX && var1 < this.screenX + this.field507) {
            break;
         }

         return false;
      case 1:
         if(var1 >= this.screenX - this.field507 / 2 && var1 <= this.field507 / 2 + this.screenX) {
            break;
         }

         return false;
      case 2:
         if(var1 <= this.screenX - this.field507 || var1 > this.screenX) {
            return false;
         }
      }

      switch(var3.verticalAlignment.value) {
      case 0:
         if(var2 >= this.screenY - this.field504 / 2 && var2 <= this.field504 / 2 + this.screenY) {
            break;
         }

         return false;
      case 1:
         if(var2 < this.screenY || var2 >= this.screenY + this.field504) {
            return false;
         }
         break;
      case 2:
         if(var2 <= this.screenY - this.field504 || var2 > this.screenY) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1305894451"
   )
   boolean method573(int var1, int var2) {
      return this.field509 == null?false:(var1 >= this.screenX - this.field509.field446 / 2 && var1 <= this.field509.field446 / 2 + this.screenX?var2 >= this.screenY && var2 <= this.field509.field452 + this.screenY:false);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1815085214"
   )
   static void method570() {
      class62.field722 = 99;
      class62.tileUnderlayIds = new byte[4][104][104];
      class62.tileOverlayIds = new byte[4][104][104];
      class62.tileOverlayPath = new byte[4][104][104];
      RunException.overlayRotations = new byte[4][104][104];
      class62.field721 = new int[4][105][105];
      class62.field725 = new byte[4][105][105];
      class62.field719 = new int[105][105];
      AttackOption.floorHues = new int[104];
      class1.floorSaturations = new int[104];
      class204.field2613 = new int[104];
      class57.floorMultiplier = new int[104];
      FrameMap.field1973 = new int[104];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Led;IIIIB)V",
      garbageValue = "0"
   )
   public static final void method575(Model var0, int var1, int var2, int var3, int var4) {
      class7.boundingBoxes.addFirst(new BoundingBox3D(var0, var1, var2, var3, var4));
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([Lbz;II[I[IB)V",
      garbageValue = "107"
   )
   static void method574(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method1614()?1:0;
                     var12 = var8.method1614()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method1614()?1:0;
                     var12 = var8.method1614()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method574(var0, var1, var6, var3, var4);
         method574(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "296316541"
   )
   static void method568(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = FaceNormal.worldList[var6];
         FaceNormal.worldList[var6] = FaceNormal.worldList[var1];
         FaceNormal.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = FaceNormal.worldList[var9];
            int var12 = WorldMapType1.method278(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = WorldMapType1.method278(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = FaceNormal.worldList[var9];
               FaceNormal.worldList[var9] = FaceNormal.worldList[var7];
               FaceNormal.worldList[var7++] = var14;
            }
         }

         FaceNormal.worldList[var1] = FaceNormal.worldList[var7];
         FaceNormal.worldList[var7] = var8;
         method568(var0, var7 - 1, var2, var3, var4, var5);
         method568(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "-1999677866"
   )
   static final void method577(String var0, int var1) {
      PacketNode var2 = FaceNormal.method3078(ClientPacket.field2389, Client.field902.field1475);
      var2.packetBuffer.putByte(Projectile.getLength(var0) + 1);
      var2.packetBuffer.putShortLE(var1);
      var2.packetBuffer.putString(var0);
      Client.field902.method2036(var2);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "131759429"
   )
   protected static final void method576() {
      RunException.timer.vmethod3302();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field667[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field664[var0] = 0L;
      }

      GameEngine.field668 = 0;
   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "([Lib;Lib;ZI)V",
      garbageValue = "887549315"
   )
   static void method578(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      Tile.method2679(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         Tile.method2679(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.get((long)var1.id);
      if(var5 != null) {
         BoundingBox.method61(var5.id, var3, var4, var2);
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}
