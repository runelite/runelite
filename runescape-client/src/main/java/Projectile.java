import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1174493881
   )
   @Export("id")
   int id;
   @ObfuscatedName("u")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1127087787
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 860399403
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("g")
   @Export("x")
   double x;
   @ObfuscatedName("c")
   double field1458;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -829680247
   )
   int field1470;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1098739403
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -359173759
   )
   int field1465;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -864658313
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("k")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1237869111
   )
   @Export("start")
   int start;
   @ObfuscatedName("o")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -550051333
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("t")
   @Export("z")
   double z;
   @ObfuscatedName("h")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("f")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -534225593
   )
   @Export("height")
   int height;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2000525975
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("x")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1609571083
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2073933703
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1488287229
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -984622429
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("d")
   @Export("animationSequence")
   Sequence animationSequence;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.isMoving = false;
      this.field1470 = 0;
      this.field1465 = 0;
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.height = var5;
      this.startTime = var6;
      this.cycle = var7;
      this.slope = var8;
      this.start = var9;
      this.interacting = var10;
      this.endHeight = var11;
      this.isMoving = false;
      int var12 = InvType.getSpotAnimType(this.id).field3329;
      if(var12 != -1) {
         this.animationSequence = class112.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "19"
   )
   protected final Model getModel() {
      Spotanim var1 = InvType.getSpotAnimType(this.id);
      Model var2 = var1.method4283(this.field1470);
      if(var2 == null) {
         return null;
      } else {
         var2.method2509(this.rotationY);
         return var2;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-265809039"
   )
   final void method1736(int var1) {
      this.isMoving = true;
      this.x += this.field1458 * (double)var1;
      this.velocityZ += this.scalar * (double)var1;
      this.z += (double)var1 * this.heightOffset * 0.5D * (double)var1 + (double)var1 * this.velocityX;
      this.velocityX += this.heightOffset * (double)var1;
      this.rotationX = (int)(Math.atan2(this.field1458, this.scalar) * 325.949D) + 1024 & 2047;
      this.rotationY = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field1465 += var1;

         while(true) {
            do {
               do {
                  if(this.field1465 <= this.animationSequence.frameLenghts[this.field1470]) {
                     return;
                  }

                  this.field1465 -= this.animationSequence.frameLenghts[this.field1470];
                  ++this.field1470;
               } while(this.field1470 < this.animationSequence.frameIDs.length);

               this.field1470 -= this.animationSequence.frameStep;
            } while(this.field1470 >= 0 && this.field1470 < this.animationSequence.frameIDs.length);

            this.field1470 = 0;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "648974400"
   )
   final void method1735(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.x = (double)this.start * var5 / var9 + (double)this.x1;
         this.velocityZ = (double)this.start * var7 / var9 + (double)this.y1;
         this.z = (double)this.height;
      }

      var5 = (double)(this.cycle + 1 - var4);
      this.field1458 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.scalar * this.scalar + this.field1458 * this.field1458);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan(0.02454369D * (double)this.slope);
      }

      this.heightOffset = 2.0D * ((double)var3 - this.z - var5 * this.velocityX) / (var5 * var5);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;IIB)LModIcon;",
      garbageValue = "-7"
   )
   static ModIcon method1743(IndexDataBase var0, int var1, int var2) {
      if(!IndexData.method4200(var0, var1, var2)) {
         return null;
      } else {
         ModIcon var4 = new ModIcon();
         var4.width = class286.field3793;
         var4.originalHeight = class286.field3792;
         var4.offsetX = class286.field3795[0];
         var4.offsetY = class31.offsetsY[0];
         var4.originalWidth = class286.field3797[0];
         var4.height = class90.field1405[0];
         var4.palette = class286.field3796;
         var4.pixels = class177.spritePixels[0];
         class18.method138();
         return var4;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1461535418"
   )
   static int method1734(int var0, Script var1, boolean var2) {
      String var11;
      if(var0 == 3100) {
         var11 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
         WidgetNode.sendGameMessage(0, "", var11);
         return 1;
      } else if(var0 == 3101) {
         WorldMapType2.intStackSize -= 2;
         Timer.method2981(Script.localPlayer, class83.intStack[WorldMapType2.intStackSize], class83.intStack[WorldMapType2.intStackSize + 1]);
         return 1;
      } else if(var0 != 3103) {
         int var12;
         if(var0 == 3104) {
            var11 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
            var12 = 0;
            boolean var13 = class243.method4270(var11, 10, true);
            if(var13) {
               int var6 = class267.parseInt(var11, 10, true);
               var12 = var6;
            }

            Client.secretPacketBuffer1.putOpcode(38);
            Client.secretPacketBuffer1.putInt(var12);
            return 1;
         } else if(var0 == 3105) {
            var11 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
            Client.secretPacketBuffer1.putOpcode(226);
            Client.secretPacketBuffer1.putByte(var11.length() + 1);
            Client.secretPacketBuffer1.putString(var11);
            return 1;
         } else if(var0 == 3106) {
            var11 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
            Client.secretPacketBuffer1.putOpcode(165);
            Client.secretPacketBuffer1.putByte(var11.length() + 1);
            Client.secretPacketBuffer1.putString(var11);
            return 1;
         } else {
            int var7;
            String var8;
            if(var0 == 3107) {
               var7 = class83.intStack[--WorldMapType2.intStackSize];
               var8 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
               class7.method34(var7, var8);
               return 1;
            } else if(var0 == 3108) {
               WorldMapType2.intStackSize -= 3;
               var7 = class83.intStack[WorldMapType2.intStackSize];
               var12 = class83.intStack[WorldMapType2.intStackSize + 1];
               int var5 = class83.intStack[WorldMapType2.intStackSize + 2];
               Widget var9 = class61.method1038(var5);
               class91.method1699(var9, var7, var12);
               return 1;
            } else if(var0 == 3109) {
               WorldMapType2.intStackSize -= 2;
               var7 = class83.intStack[WorldMapType2.intStackSize];
               var12 = class83.intStack[WorldMapType2.intStackSize + 1];
               Widget var14 = var2?class83.field1336:class1.field9;
               class91.method1699(var14, var7, var12);
               return 1;
            } else if(var0 == 3110) {
               class33.field461 = class83.intStack[--WorldMapType2.intStackSize] == 1;
               return 1;
            } else if(var0 == 3111) {
               class83.intStack[++WorldMapType2.intStackSize - 1] = class23.preferences.hideRoofs?1:0;
               return 1;
            } else if(var0 == 3112) {
               class23.preferences.hideRoofs = class83.intStack[--WorldMapType2.intStackSize] == 1;
               PendingSpawn.method1475();
               return 1;
            } else if(var0 == 3113) {
               var11 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
               boolean var4 = class83.intStack[--WorldMapType2.intStackSize] == 1;
               class36.method485(var11, var4, false);
               return 1;
            } else if(var0 == 3115) {
               var7 = class83.intStack[--WorldMapType2.intStackSize];
               Client.secretPacketBuffer1.putOpcode(124);
               Client.secretPacketBuffer1.putShort(var7);
               return 1;
            } else if(var0 == 3116) {
               var7 = class83.intStack[--WorldMapType2.intStackSize];
               BaseVarType.scriptStringStackSize -= 2;
               var8 = class83.scriptStringStack[BaseVarType.scriptStringStackSize];
               String var10 = class83.scriptStringStack[BaseVarType.scriptStringStackSize + 1];
               if(var8.length() > 500) {
                  return 1;
               } else if(var10.length() > 500) {
                  return 1;
               } else {
                  Client.secretPacketBuffer1.putOpcode(23);
                  Client.secretPacketBuffer1.putShort(1 + DecorativeObject.getLength(var8) + DecorativeObject.getLength(var10));
                  Client.secretPacketBuffer1.putString(var10);
                  Client.secretPacketBuffer1.putString(var8);
                  Client.secretPacketBuffer1.method3127(var7);
                  return 1;
               }
            } else if(var0 == 3117) {
               Client.field1054 = class83.intStack[--WorldMapType2.intStackSize] == 1;
               return 1;
            } else {
               return 2;
            }
         }
      } else {
         Client.secretPacketBuffer1.putOpcode(89);

         for(WidgetNode var3 = (WidgetNode)Client.componentTable.method3538(); var3 != null; var3 = (WidgetNode)Client.componentTable.method3539()) {
            if(var3.owner == 0 || var3.owner == 3) {
               MilliTimer.method2909(var3, true);
            }
         }

         if(Client.field1070 != null) {
            class48.method749(Client.field1070);
            Client.field1070 = null;
         }

         return 1;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IB)I",
      garbageValue = "-52"
   )
   public static int method1742(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      byte var7 = 0;
      byte var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = (char)var7;
            boolean var14 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var10;
         if(var8 != 0) {
            var10 = (char)var8;
            boolean var15 = false;
         } else {
            var10 = var1.charAt(var6++);
         }

         byte var11;
         if(var9 == 198) {
            var11 = 69;
         } else if(var9 == 230) {
            var11 = 101;
         } else if(var9 == 223) {
            var11 = 115;
         } else if(var9 == 338) {
            var11 = 69;
         } else if(var9 == 339) {
            var11 = 101;
         } else {
            var11 = 0;
         }

         var7 = var11;
         byte var12;
         if(var10 == 198) {
            var12 = 69;
         } else if(var10 == 230) {
            var12 = 101;
         } else if(var10 == 223) {
            var12 = 115;
         } else if(var10 == 338) {
            var12 = 69;
         } else if(var10 == 339) {
            var12 = 101;
         } else {
            var12 = 0;
         }

         var8 = var12;
         var9 = DState.method3121(var9, var2);
         var10 = DState.method3121(var10, var2);
         if(var9 != var10 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if(var10 != var9) {
               return class37.method502(var9, var2) - class37.method502(var10, var2);
            }
         }
      }

      int var16 = Math.min(var3, var4);

      int var17;
      char var20;
      for(var17 = 0; var17 < var16; ++var17) {
         char var18 = var0.charAt(var17);
         var20 = var1.charAt(var17);
         if(var18 != var20 && Character.toUpperCase(var18) != Character.toUpperCase(var20)) {
            var18 = Character.toLowerCase(var18);
            var20 = Character.toLowerCase(var20);
            if(var20 != var18) {
               return class37.method502(var18, var2) - class37.method502(var20, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var19 = 0; var19 < var16; ++var19) {
            var20 = var0.charAt(var19);
            char var13 = var1.charAt(var19);
            if(var13 != var20) {
               return class37.method502(var20, var2) - class37.method502(var13, var2);
            }
         }

         return 0;
      }
   }
}
