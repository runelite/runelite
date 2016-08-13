import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1584884575
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -708966709
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -798056087
   )
   @Export("id")
   int id;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -623429827
   )
   @Export("z1")
   int z1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 100148603
   )
   int field105;
   @ObfuscatedName("f")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("q")
   @Export("isMoving")
   boolean isMoving = false;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 790652441
   )
   int field108;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1211544365
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("t")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("p")
   @Export("x")
   double x;
   @ObfuscatedName("w")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("o")
   @Export("z")
   double z;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -101337393
   )
   int field115 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 215685155
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("z")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -283062119
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("v")
   @Export("az")
   double az;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1786955333
   )
   int field120;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1772374343
   )
   int field121;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1717330259
   )
   @Export("start")
   int start;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -647281841
   )
   int field123 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1205955213
   )
   int field124;
   @ObfuscatedName("d")
   double field126;
   @ObfuscatedName("nf")
   static class59 field127;
   @ObfuscatedName("i")
   @Export("velocityX")
   double velocityX;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-73"
   )
   public static void method92() {
      class56.field1231.reset();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "503322838"
   )
   protected final Model getModel() {
      class45 var1 = class110.method2488(this.id);
      Model var2 = var1.method952(this.field123);
      if(null == var2) {
         return null;
      } else {
         var2.method2411(this.field121);
         return var2;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1003132103"
   )
   final void method94(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.field126;
      this.velocityZ += (double)var1 * this.scalar;
      this.z += this.velocityX * (double)var1 + (double)var1 * (double)var1 * this.az * 0.5D;
      this.velocityX += this.az * (double)var1;
      this.field120 = (int)(Math.atan2(this.field126, this.scalar) * 325.949D) + 1024 & 2047;
      this.field121 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field115 += var1;

         while(true) {
            do {
               do {
                  if(this.field115 <= this.animationSequence.field1018[this.field123]) {
                     return;
                  }

                  this.field115 -= this.animationSequence.field1018[this.field123];
                  ++this.field123;
               } while(this.field123 < this.animationSequence.field1030.length);

               this.field123 -= this.animationSequence.field1020;
            } while(this.field123 >= 0 && this.field123 < this.animationSequence.field1030.length);

            this.field123 = 0;
         }
      }
   }

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.z1 = var5;
      this.startTime = var6;
      this.field124 = var7;
      this.field108 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field105 = var11;
      this.isMoving = false;
      int var12 = class110.method2488(this.id).field1042;
      if(var12 != -1) {
         this.animationSequence = class22.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-64"
   )
   static void method97() {
      class34.field783 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class34.field791[var0] = null;
         class34.field781[var0] = 1;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "101"
   )
   final void method98(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.x = var5 * (double)this.start / var9 + (double)this.x1;
         this.velocityZ = (double)this.y1 + (double)this.start * var7 / var9;
         this.z = (double)this.z1;
      }

      var5 = (double)(this.field124 + 1 - var4);
      this.field126 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.field126 * this.field126 + this.scalar * this.scalar);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan(0.02454369D * (double)this.field108);
      }

      this.az = 2.0D * ((double)var3 - this.z - var5 * this.velocityX) / (var5 * var5);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "15"
   )
   static void method103() {
      Client.field337.method2903(43);
      Client.field337.method2783(class53.method1139());
      Client.field337.method2619(class189.field3056);
      Client.field337.method2619(Actor.field892);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2071693757"
   )
   static final void method104() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(Client.packetOpcode == 19) {
         var6 = Client.field339.method2617();
         var7 = var6 >> 2;
         var0 = var6 & 3;
         var1 = Client.field532[var7];
         var2 = Client.field339.method2837();
         var3 = class4.field72 + (var2 >> 4 & 7);
         var4 = KitDefinition.field1064 + (var2 & 7);
         var5 = Client.field339.method2749();
         if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
            class1.method13(VertexNormal.plane, var3, var4, var1, var5, var7, var0, 0, -1);
         }
      } else if(Client.packetOpcode == 205) {
         var6 = Client.field339.method2633();
         var7 = (var6 >> 4 & 7) + class4.field72;
         var0 = KitDefinition.field1064 + (var6 & 7);
         var1 = Client.field339.method2635();
         var2 = Client.field339.method2633();
         var3 = Client.field339.method2635();
         if(var7 >= 0 && var0 >= 0 && var7 < 104 && var0 < 104) {
            var7 = 128 * var7 + 64;
            var0 = 64 + 128 * var0;
            class31 var8 = new class31(var1, VertexNormal.plane, var7, var0, class127.method2936(var7, var0, VertexNormal.plane) - var2, var3, Client.gameCycle);
            Client.field429.method3963(var8);
         }
      } else if(Client.packetOpcode == 33) {
         var6 = Client.field339.method2662();
         var7 = (var6 >> 4 & 7) + class4.field72;
         var0 = KitDefinition.field1064 + (var6 & 7);
         var1 = Client.field339.method2617();
         var2 = var1 >> 2;
         var3 = var1 & 3;
         var4 = Client.field532[var2];
         if(var7 >= 0 && var0 >= 0 && var7 < 104 && var0 < 104) {
            class1.method13(VertexNormal.plane, var7, var0, var4, -1, var2, var3, 0, -1);
         }
      } else {
         int var9;
         int var10;
         int var11;
         int var31;
         if(Client.packetOpcode == 38) {
            byte var12 = Client.field339.method2634();
            byte var13 = Client.field339.method2659();
            var0 = Client.field339.method2635();
            var1 = Client.field339.method2803();
            var2 = Client.field339.method2803();
            var3 = Client.field339.method2749();
            var4 = Client.field339.method2837();
            var5 = var4 >> 2;
            var11 = var4 & 3;
            var31 = Client.field532[var5];
            byte var14 = Client.field339.method2664();
            var9 = Client.field339.method2837();
            var10 = (var9 >> 4 & 7) + class4.field72;
            int var15 = (var9 & 7) + KitDefinition.field1064;
            byte var16 = Client.field339.method2632();
            Player var17;
            if(var3 == Client.localInteractingIndex) {
               var17 = WidgetNode.localPlayer;
            } else {
               var17 = Client.cachedPlayers[var3];
            }

            if(null != var17) {
               ObjectComposition var18 = class160.getObjectDefinition(var0);
               int var19;
               int var20;
               if(var11 != 1 && var11 != 3) {
                  var19 = var18.field960;
                  var20 = var18.field970;
               } else {
                  var19 = var18.field970;
                  var20 = var18.field960;
               }

               int var21 = (var19 >> 1) + var10;
               int var22 = var10 + (1 + var19 >> 1);
               int var23 = var15 + (var20 >> 1);
               int var24 = var15 + (1 + var20 >> 1);
               int[][] var25 = class5.tileHeights[VertexNormal.plane];
               int var26 = var25[var22][var23] + var25[var21][var23] + var25[var21][var24] + var25[var22][var24] >> 2;
               int var27 = (var10 << 7) + (var19 << 6);
               int var28 = (var20 << 6) + (var15 << 7);
               Model var29 = var18.method852(var5, var11, var25, var27, var26, var28);
               if(var29 != null) {
                  class1.method13(VertexNormal.plane, var10, var15, var31, -1, 0, 0, var1 + 1, var2 + 1);
                  var17.totalLevel = var1 + Client.gameCycle;
                  var17.field40 = Client.gameCycle + var2;
                  var17.model = var29;
                  var17.field41 = 128 * var10 + 64 * var19;
                  var17.field32 = 64 * var20 + var15 * 128;
                  var17.field42 = var26;
                  byte var30;
                  if(var14 > var13) {
                     var30 = var14;
                     var14 = var13;
                     var13 = var30;
                  }

                  if(var12 > var16) {
                     var30 = var12;
                     var12 = var16;
                     var16 = var30;
                  }

                  var17.field55 = var10 + var14;
                  var17.field47 = var13 + var10;
                  var17.field46 = var12 + var15;
                  var17.field48 = var15 + var16;
               }
            }
         }

         if(Client.packetOpcode == 199) {
            var6 = Client.field339.method2633();
            var7 = class4.field72 + (var6 >> 4 & 7);
            var0 = KitDefinition.field1064 + (var6 & 7);
            var1 = var7 + Client.field339.method2634();
            var2 = var0 + Client.field339.method2634();
            var3 = Client.field339.method2636();
            var4 = Client.field339.method2635();
            var5 = Client.field339.method2633() * 4;
            var11 = Client.field339.method2633() * 4;
            var31 = Client.field339.method2635();
            int var32 = Client.field339.method2635();
            var9 = Client.field339.method2633();
            var10 = Client.field339.method2633();
            if(var7 >= 0 && var0 >= 0 && var7 < 104 && var0 < 104 && var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var4 != '\uffff') {
               var7 = 64 + var7 * 128;
               var0 = 64 + 128 * var0;
               var1 = var1 * 128 + 64;
               var2 = var2 * 128 + 64;
               Projectile var35 = new Projectile(var4, VertexNormal.plane, var7, var0, class127.method2936(var7, var0, VertexNormal.plane) - var5, var31 + Client.gameCycle, var32 + Client.gameCycle, var9, var10, var3, var11);
               var35.method98(var1, var2, class127.method2936(var1, var2, VertexNormal.plane) - var11, var31 + Client.gameCycle);
               Client.projectiles.method3963(var35);
            }
         } else if(Client.packetOpcode == 15) {
            var6 = Client.field339.method2633();
            var7 = (var6 >> 4 & 7) + class4.field72;
            var0 = (var6 & 7) + KitDefinition.field1064;
            var1 = Client.field339.method2635();
            var2 = Client.field339.method2635();
            var3 = Client.field339.method2635();
            if(var7 >= 0 && var0 >= 0 && var7 < 104 && var0 < 104) {
               Deque var33 = Client.groundItemDeque[VertexNormal.plane][var7][var0];
               if(null != var33) {
                  for(Item var36 = (Item)var33.method3980(); var36 != null; var36 = (Item)var33.method3970()) {
                     if((var1 & 32767) == var36.id && var2 == var36.quantity) {
                        var36.quantity = var3;
                        break;
                     }
                  }

                  class144.groundItemSpawned(var7, var0);
               }
            }
         } else {
            Item var34;
            if(Client.packetOpcode == 152) {
               var6 = Client.field339.method2635();
               var7 = Client.field339.method2633();
               var0 = (var7 >> 4 & 7) + class4.field72;
               var1 = (var7 & 7) + KitDefinition.field1064;
               var2 = Client.field339.method2635();
               if(var0 >= 0 && var1 >= 0 && var0 < 104 && var1 < 104) {
                  var34 = new Item();
                  var34.id = var2;
                  var34.quantity = var6;
                  if(null == Client.groundItemDeque[VertexNormal.plane][var0][var1]) {
                     Client.groundItemDeque[VertexNormal.plane][var0][var1] = new Deque();
                  }

                  Client.groundItemDeque[VertexNormal.plane][var0][var1].method3963(var34);
                  class144.groundItemSpawned(var0, var1);
               }
            } else if(Client.packetOpcode == 249) {
               var6 = Client.field339.method2617();
               var7 = (var6 >> 4 & 7) + class4.field72;
               var0 = (var6 & 7) + KitDefinition.field1064;
               var1 = Client.field339.method2803();
               if(var7 >= 0 && var0 >= 0 && var7 < 104 && var0 < 104) {
                  Deque var37 = Client.groundItemDeque[VertexNormal.plane][var7][var0];
                  if(var37 != null) {
                     for(var34 = (Item)var37.method3980(); var34 != null; var34 = (Item)var37.method3970()) {
                        if((var1 & 32767) == var34.id) {
                           var34.unlink();
                           break;
                        }
                     }

                     if(var37.method3980() == null) {
                        Client.groundItemDeque[VertexNormal.plane][var7][var0] = null;
                     }

                     class144.groundItemSpawned(var7, var0);
                  }
               }
            } else if(Client.packetOpcode != 24) {
               if(Client.packetOpcode == 105) {
                  var6 = Client.field339.method2633();
                  var7 = class4.field72 + (var6 >> 4 & 7);
                  var0 = KitDefinition.field1064 + (var6 & 7);
                  var1 = Client.field339.method2635();
                  var2 = Client.field339.method2633();
                  var3 = var2 >> 4 & 15;
                  var4 = var2 & 7;
                  var5 = Client.field339.method2633();
                  if(var7 >= 0 && var0 >= 0 && var7 < 104 && var0 < 104) {
                     var11 = 1 + var3;
                     if(WidgetNode.localPlayer.pathX[0] >= var7 - var11 && WidgetNode.localPlayer.pathX[0] <= var7 + var11 && WidgetNode.localPlayer.pathY[0] >= var0 - var11 && WidgetNode.localPlayer.pathY[0] <= var0 + var11 && Client.field535 != 0 && var4 > 0 && Client.field536 < 50) {
                        Client.field319[Client.field536] = var1;
                        Client.field538[Client.field536] = var4;
                        Client.field539[Client.field536] = var5;
                        Client.field541[Client.field536] = null;
                        Client.field528[Client.field536] = var3 + (var0 << 8) + (var7 << 16);
                        ++Client.field536;
                     }
                  }
               }
            } else {
               var6 = Client.field339.method2837();
               var7 = class4.field72 + (var6 >> 4 & 7);
               var0 = KitDefinition.field1064 + (var6 & 7);
               var1 = Client.field339.method2837();
               var2 = var1 >> 2;
               var3 = var1 & 3;
               var4 = Client.field532[var2];
               var5 = Client.field339.method2803();
               if(var7 >= 0 && var0 >= 0 && var7 < 103 && var0 < 103) {
                  if(var4 == 0) {
                     WallObject var38 = class136.region.method2155(VertexNormal.plane, var7, var0);
                     if(null != var38) {
                        var31 = var38.hash >> 14 & 32767;
                        if(var2 == 2) {
                           var38.renderable1 = new class12(var31, 2, 4 + var3, VertexNormal.plane, var7, var0, var5, false, var38.renderable1);
                           var38.renderable2 = new class12(var31, 2, 1 + var3 & 3, VertexNormal.plane, var7, var0, var5, false, var38.renderable2);
                        } else {
                           var38.renderable1 = new class12(var31, var2, var3, VertexNormal.plane, var7, var0, var5, false, var38.renderable1);
                        }
                     }
                  }

                  if(var4 == 1) {
                     DecorativeObject var39 = class136.region.method2051(VertexNormal.plane, var7, var0);
                     if(var39 != null) {
                        var31 = var39.hash >> 14 & 32767;
                        if(var2 != 4 && var2 != 5) {
                           if(var2 == 6) {
                              var39.renderable1 = new class12(var31, 4, 4 + var3, VertexNormal.plane, var7, var0, var5, false, var39.renderable1);
                           } else if(var2 == 7) {
                              var39.renderable1 = new class12(var31, 4, (var3 + 2 & 3) + 4, VertexNormal.plane, var7, var0, var5, false, var39.renderable1);
                           } else if(var2 == 8) {
                              var39.renderable1 = new class12(var31, 4, 4 + var3, VertexNormal.plane, var7, var0, var5, false, var39.renderable1);
                              var39.renderable2 = new class12(var31, 4, (var3 + 2 & 3) + 4, VertexNormal.plane, var7, var0, var5, false, var39.renderable2);
                           }
                        } else {
                           var39.renderable1 = new class12(var31, 4, var3, VertexNormal.plane, var7, var0, var5, false, var39.renderable1);
                        }
                     }
                  }

                  if(var4 == 2) {
                     GameObject var40 = class136.region.method2015(VertexNormal.plane, var7, var0);
                     if(var2 == 11) {
                        var2 = 10;
                     }

                     if(var40 != null) {
                        var40.renderable = new class12(var40.hash >> 14 & 32767, var2, var3, VertexNormal.plane, var7, var0, var5, false, var40.renderable);
                     }
                  }

                  if(var4 == 3) {
                     GroundObject var41 = class136.region.method2016(VertexNormal.plane, var7, var0);
                     if(var41 != null) {
                        var41.renderable = new class12(var41.hash >> 14 & 32767, 22, var3, VertexNormal.plane, var7, var0, var5, false, var41.renderable);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1384917157"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class11.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class11.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method674(var0, var1, var2, var3);
      class11.field174.method3948(var5, (long)var5.id);
      class11.field173.method4001(var5);
      Client.field485 = Client.field478;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "556666121"
   )
   public static void method106() {
      ItemComposition.itemSpriteCache.reset();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "124"
   )
   static char method108(char var0) {
      return var0 != 181 && var0 != 402?Character.toTitleCase(var0):var0;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "236674057"
   )
   static void method109(int var0, int var1, int var2, int var3) {
      Widget var4 = class151.method3265(var0, var1);
      if(var4 != null && var4.field2898 != null) {
         class0 var5 = new class0();
         var5.field2 = var4;
         var5.field8 = var4.field2898;
         class16.method203(var5);
      }

      Client.field459 = var3;
      Client.field448 = true;
      class13.field209 = var0;
      Client.field449 = var1;
      World.field675 = var2;
      class79.method1777(var4);
   }
}
