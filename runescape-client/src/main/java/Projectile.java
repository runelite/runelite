import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1250584121
   )
   @Export("start")
   int start;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 112548061
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("n")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("d")
   @Export("z")
   double z;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 539848571
   )
   @Export("z1")
   int z1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 357816103
   )
   int field92;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -503751191
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1165849151
   )
   int field94;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1958738587
   )
   int field95;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -307786517
   )
   @Export("id")
   int id;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1655535379
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("w")
   @Export("isMoving")
   boolean isMoving = false;
   @ObfuscatedName("u")
   @Export("x")
   double x;
   @ObfuscatedName("o")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("a")
   double field102;
   @ObfuscatedName("b")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("q")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 223018519
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("c")
   @Export("az")
   double az;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 671358431
   )
   int field107;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 691404575
   )
   int field108;
   @ObfuscatedName("v")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 725717821
   )
   int field110 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1601829121
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1377337815
   )
   int field113 = 0;

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(LWidget;II)I",
      garbageValue = "-169507009"
   )
   static final int method87(Widget var0, int var1) {
      if(var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = Client.boostedSkillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.realSkillLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.skillExperiences[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class92.method2078(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class174.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class179.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class158.field2339[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class179.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = TextureProvider.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class158.field2338[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class92.method2078(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class174.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var10.itemIds[var12] == var11 + 1) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.energy;
               }

               if(var6 == 12) {
                  var7 = Client.weight;
               }

               if(var6 == 13) {
                  var9 = class179.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class173.method3381(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (TextureProvider.localPlayer.x >> 7) + class23.baseX;
               }

               if(var6 == 19) {
                  var7 = (TextureProvider.localPlayer.y >> 7) + class8.baseY;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1902855844"
   )
   static final void method88() {
      for(class16 var0 = (class16)Client.field401.method3808(); null != var0; var0 = (class16)Client.field401.method3810()) {
         if(var0.field211 == -1) {
            var0.field210 = 0;
            MessageNode.method753(var0);
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1329881799"
   )
   final void method89(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.field102;
      this.velocityZ += (double)var1 * this.scalar;
      this.z += (double)var1 * this.velocityX + (double)var1 * 0.5D * this.az * (double)var1;
      this.velocityX += (double)var1 * this.az;
      this.field107 = (int)(Math.atan2(this.field102, this.scalar) * 325.949D) + 1024 & 2047;
      this.field108 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(null != this.animationSequence) {
         this.field113 += var1;

         while(true) {
            do {
               do {
                  if(this.field113 <= this.animationSequence.field981[this.field110]) {
                     return;
                  }

                  this.field113 -= this.animationSequence.field981[this.field110];
                  ++this.field110;
               } while(this.field110 < this.animationSequence.field969.length);

               this.field110 -= this.animationSequence.field973;
            } while(this.field110 >= 0 && this.field110 < this.animationSequence.field969.length);

            this.field110 = 0;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1695936773"
   )
   final void method90(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.x = (double)this.start * var5 / var9 + (double)this.x1;
         this.velocityZ = (double)this.start * var7 / var9 + (double)this.y1;
         this.z = (double)this.z1;
      }

      var5 = (double)(this.field94 + 1 - var4);
      this.field102 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.scalar * this.scalar + this.field102 * this.field102);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan(0.02454369D * (double)this.field95);
      }

      this.az = ((double)var3 - this.z - this.velocityX * var5) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-26"
   )
   protected final Model getModel() {
      class45 var1 = class107.method2269(this.id);
      Model var2 = var1.method915(this.field110);
      if(var2 == null) {
         return null;
      } else {
         var2.method2284(this.field108);
         return var2;
      }
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "294657092"
   )
   static void method99(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      ChatMessages.method221(var0, var1.id, var3, var4, var2);
      if(null != var1.children) {
         ChatMessages.method221(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method3775((long)var1.id);
      if(null != var5) {
         class11.method135(var5.id, var3, var4, var2);
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.z1 = var5;
      this.startTime = var6;
      this.field94 = var7;
      this.field95 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field92 = var11;
      this.isMoving = false;
      int var12 = class107.method2269(this.id).field991;
      if(var12 != -1) {
         this.animationSequence = class4.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Ljava/lang/String;",
      garbageValue = "109618612"
   )
   static String method101(Widget var0) {
      int var2 = class11.method138(var0);
      int var1 = var2 >> 11 & 63;
      return var1 == 0?null:(var0.field2877 != null && var0.field2877.trim().length() != 0?var0.field2877:null);
   }
}
