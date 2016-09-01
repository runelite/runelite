import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1954956911
   )
   int field26;
   @ObfuscatedName("x")
   @Export("name")
   String name;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -476059935
   )
   int field28 = -1;
   @ObfuscatedName("n")
   boolean field29;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -30818949
   )
   int field30;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2032508111
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1504381947
   )
   int field32;
   @ObfuscatedName("r")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1282542841
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -241622501
   )
   int field35;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1438749367
   )
   int field36;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 299128327
   )
   int field37;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -81912269
   )
   int field38;
   @ObfuscatedName("g")
   @Export("model")
   Model model;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 873609655
   )
   int field40;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -393888249
   )
   int field41 = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -920706319
   )
   int field42;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -379881139
   )
   int field43;
   @ObfuscatedName("e")
   boolean field44;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1687522071
   )
   int field45;
   @ObfuscatedName("b")
   @Export("actions")
   String[] actions = new String[3];
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 492073485
   )
   int field47;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1607334103
   )
   int field48;
   @ObfuscatedName("w")
   boolean field49;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -697756661
   )
   int field50;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -61287787
   )
   @Export("team")
   int team;

   Player() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field32 = 0;
      this.totalLevel = 0;
      this.field35 = 0;
      this.field44 = false;
      this.team = 0;
      this.field29 = false;
      this.field49 = false;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1904052091"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class113.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.field44 || super.idlePoseAnimation == super.poseAnimation && var1 != null?null:class113.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3503(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2391();
            super.field867 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field44 && super.graphic != -1 && super.field855 != -1) {
               var4 = Renderable.method1946(super.graphic).method906(super.field855);
               if(var4 != null) {
                  var4.method2429(0, -super.field858, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field44 && this.model != null) {
               if(Client.gameCycle >= this.field35) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field35) {
                  var4 = this.model;
                  var4.method2429(this.field36 - super.x, this.field45 - this.field37, this.field30 - super.y);
                  if(super.field835 == 512) {
                     var4.method2430();
                     var4.method2430();
                     var4.method2430();
                  } else if(super.field835 == 1024) {
                     var4.method2430();
                     var4.method2430();
                  } else if(super.field835 == 1536) {
                     var4.method2430();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field835 == 512) {
                     var4.method2430();
                  } else if(super.field835 == 1024) {
                     var4.method2430();
                     var4.method2430();
                  } else if(super.field835 == 1536) {
                     var4.method2430();
                     var4.method2430();
                     var4.method2430();
                  }

                  var4.method2429(super.x - this.field36, this.field37 - this.field45, super.y - this.field30);
               }
            }

            var3.field1866 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "76"
   )
   final void method17(int var1, int var2, byte var3) {
      if(super.animation != -1 && class113.getAnimation(super.animation).field1009 == 1) {
         super.animation = -1;
      }

      super.field845 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Projectile.method106(this, var1, var2, (byte)2);
            }

            this.method23(var1, var2, var3);
         } else {
            this.method36(var1, var2);
         }
      } else {
         this.method36(var1, var2);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-675484803"
   )
   final void method19(Buffer var1) {
      var1.offset = 0;
      int var2 = var1.method2556();
      this.field28 = var1.method2557();
      this.field41 = var1.method2557();
      int var3 = -1;
      this.team = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.method2556();
         if(var6 == 0) {
            var4[var5] = 0;
         } else {
            var7 = var1.method2556();
            var4[var5] = var7 + (var6 << 8);
            if(var5 == 0 && var4[0] == '\uffff') {
               var3 = var1.method2551();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = MessageNode.getItemDefinition(var4[var5] - 512).field1200;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.method2556();
         if(var7 < 0 || var7 >= XClanMember.field624[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.method2551();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field839 = var1.method2551();
      if(super.field839 == '\uffff') {
         super.field839 = -1;
      }

      super.field852 = super.field839;
      super.field825 = var1.method2551();
      if(super.field825 == '\uffff') {
         super.field825 = -1;
      }

      super.field826 = var1.method2551();
      if(super.field826 == '\uffff') {
         super.field826 = -1;
      }

      super.field827 = var1.method2551();
      if(super.field827 == '\uffff') {
         super.field827 = -1;
      }

      super.field869 = var1.method2551();
      if(super.field869 == '\uffff') {
         super.field869 = -1;
      }

      super.field829 = var1.method2551();
      if(super.field829 == '\uffff') {
         super.field829 = -1;
      }

      this.name = var1.method2774();
      if(class48.localPlayer == this) {
         class151.field2277 = this.name;
      }

      this.combatLevel = var1.method2556();
      this.field32 = var1.method2551();
      this.field29 = var1.method2556() == 1;
      if(Client.field560 == 0 && Client.field312 >= 2) {
         this.field29 = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3514(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1014507711"
   )
   final boolean vmethod750() {
      return this.composition != null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "32"
   )
   final void method23(int var1, int var2, byte var3) {
      if(super.field871 < 9) {
         ++super.field871;
      }

      for(int var4 = super.field871; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field830[var4] = super.field830[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field830[0] = var3;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1141848656"
   )
   int method27() {
      return null != this.composition && this.composition.field2970 != -1?GroundObject.getNpcDefinition(this.composition.field2970).field902:1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "32768"
   )
   void method36(int var1, int var2) {
      super.field871 = 0;
      super.field822 = 0;
      super.field875 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method27();
      super.x = 128 * super.pathX[0] + var3 * 64;
      super.y = super.pathY[0] * 128 + var3 * 64;
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIII)V",
      garbageValue = "791178667"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class82.method1825(var2, var3, var4, var5);
      class94.method2146();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(null != var10 && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field494)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field547] = var6 + var10.relativeX;
               Client.widgetPositionY[Client.field547] = var10.relativeY + var7;
               Client.widgetBoundsWidth[Client.field547] = var10.width;
               Client.widgetBoundsHeight[Client.field547] = var10.height;
               var11 = ++Client.field547 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2817 = Client.gameCycle;
            if(!var10.field2809 || !class34.method712(var10)) {
               int var12;
               if(var10.contentType > 0) {
                  var12 = var10.contentType;
                  if(var12 == 324) {
                     if(Client.field545 == -1) {
                        Client.field545 = var10.textureId;
                        Client.field497 = var10.field2840;
                     }

                     if(Client.field553.isFemale) {
                        var10.textureId = Client.field545;
                     } else {
                        var10.textureId = Client.field497;
                     }
                  } else if(var12 == 325) {
                     if(Client.field545 == -1) {
                        Client.field545 = var10.textureId;
                        Client.field497 = var10.field2840;
                     }

                     if(Client.field553.isFemale) {
                        var10.textureId = Client.field497;
                     } else {
                        var10.textureId = Client.field545;
                     }
                  } else if(var12 == 327) {
                     var10.rotationX = 150;
                     var10.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
                     var10.modelType = 5;
                     var10.modelId = 0;
                  } else if(var12 == 328) {
                     var10.rotationX = 150;
                     var10.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
                     var10.modelType = 5;
                     var10.modelId = 1;
                  }
               }

               var12 = var10.relativeX + var6;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(Client.field494 == var10) {
                  if(var1 != -1412584499 && !var10.field2838) {
                     class11.field170 = var0;
                     Frames.field1827 = var6;
                     Projectile.field123 = var7;
                     continue;
                  }

                  if(Client.field548 && Client.field457) {
                     var15 = class143.field2204;
                     var16 = class143.field2210;
                     var15 -= Client.field454;
                     var16 -= Client.field455;
                     if(var15 < Client.field310) {
                        var15 = Client.field310;
                     }

                     if(var10.width + var15 > Client.field453.width + Client.field310) {
                        var15 = Client.field310 + Client.field453.width - var10.width;
                     }

                     if(var16 < Client.field459) {
                        var16 = Client.field459;
                     }

                     if(var16 + var10.height > Client.field453.height + Client.field459) {
                        var16 = Client.field459 + Client.field453.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2838) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var21;
               int var22;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var19 = var12;
                  var20 = var13;
                  var21 = var10.width + var12;
                  var22 = var10.height + var13;
                  if(var21 < var12) {
                     var19 = var21;
                     var21 = var12;
                  }

                  if(var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  ++var21;
                  ++var22;
                  var15 = var19 > var2?var19:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var22 < var5?var22:var5;
               } else {
                  var19 = var10.width + var12;
                  var20 = var13 + var10.height;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2809 || var15 < var17 && var16 < var18) {
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field296) {
                           var13 += 15;
                           class158.field2347.method4045("Fps:" + GameEngine.FPS, var10.width + var12, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var52 = Runtime.getRuntime();
                           var20 = (int)((var52.totalMemory() - var52.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && Client.field314) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field314) {
                              var21 = 16711680;
                           }

                           class158.field2347.method4045("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field428 = var12;
                        Client.field510 = var13;
                        method42(var12, var13, var10.width, var10.height);
                        Client.field484[var10.boundsIndex] = true;
                        class82.method1825(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class13.method160(var10, var12, var13, var11);
                        class82.method1825(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class178 var51 = var10.method3449(false);
                        if(var51 != null) {
                           if(Client.field515 < 3) {
                              class8.field143.method1739(var12, var13, var51.field2953, var51.field2952, 25, 25, Client.mapAngle, 256, var51.field2954, var51.field2956);
                           } else {
                              class82.method1844(var12, var13, 0, var51.field2954, var51.field2956);
                           }
                        }

                        class82.method1825(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.field2809 && class34.method712(var10) && ItemComposition.field1180 != var10) {
                        continue;
                     }

                     if(!var10.field2809) {
                        if(var10.scrollY > var10.scrollHeight - var10.height) {
                           var10.scrollY = var10.scrollHeight - var10.height;
                        }

                        if(var10.scrollY < 0) {
                           var10.scrollY = 0;
                        }
                     }

                     gameDraw(var0, var10.id, var15, var16, var17, var18, var12 - var10.itemId, var13 - var10.scrollY, var11);
                     if(var10.children != null) {
                        gameDraw(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.itemId, var13 - var10.scrollY, var11);
                     }

                     WidgetNode var36 = (WidgetNode)Client.componentTable.method3830((long)var10.id);
                     if(null != var36) {
                        class18.method194(var36.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class82.method1825(var2, var3, var4, var5);
                     class94.method2146();
                  }

                  if(Client.isResized || Client.field486[var11] || Client.field491 > 1) {
                     if(var10.type == 0 && !var10.field2809 && var10.scrollHeight > var10.height) {
                        class170.method3361(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
                     }

                     if(var10.type != 1) {
                        int var24;
                        int var25;
                        int var26;
                        int var29;
                        int var39;
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2822; ++var20) {
                              for(var21 = 0; var21 < var10.field2884; ++var21) {
                                 var22 = var12 + (32 + var10.field2918) * var21;
                                 var39 = (32 + var10.field2877) * var20 + var13;
                                 if(var19 < 20) {
                                    var22 += var10.field2878[var19];
                                    var39 += var10.field2879[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(null != var10.field2880 && var19 < 20) {
                                       SpritePixels var55 = var10.method3429(var19);
                                       if(var55 != null) {
                                          var55.method1740(var22, var39);
                                       } else if(Widget.field2808) {
                                          class75.method1606(var10);
                                       }
                                    }
                                 } else {
                                    boolean var46 = false;
                                    boolean var47 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if(32 + var22 > var2 && var22 < var4 && 32 + var39 > var3 && var39 < var5 || var10 == class180.field2965 && Client.field395 == var19) {
                                       SpritePixels var41;
                                       if(Client.field432 == 1 && class75.field1391 == var19 && class119.field2040 == var10.id) {
                                          var41 = class53.createSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var41 = class53.createSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(null != var41) {
                                          if(var10 == class180.field2965 && Client.field395 == var19) {
                                             var24 = class143.field2204 - Client.field470;
                                             var25 = class143.field2210 - Client.field397;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field400 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var41.method1730(var22 + var24, var25 + var39, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & '\uffff'];
                                                if(var25 + var39 < class82.field1450 && var28.scrollY > 0) {
                                                   var29 = (class82.field1450 - var39 - var25) * Client.field329 / 3;
                                                   if(var29 > Client.field329 * 10) {
                                                      var29 = Client.field329 * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.field397 += var29;
                                                   class75.method1606(var28);
                                                }

                                                if(32 + var39 + var25 > class82.field1451 && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = (var39 + var25 + 32 - class82.field1451) * Client.field329 / 3;
                                                   if(var29 > Client.field329 * 10) {
                                                      var29 = Client.field329 * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.field397 -= var29;
                                                   class75.method1606(var28);
                                                }
                                             }
                                          } else if(class168.field2725 == var10 && var19 == Client.field394) {
                                             var41.method1730(var22, var39, 128);
                                          } else {
                                             var41.method1740(var22, var39);
                                          }
                                       } else {
                                          class75.method1606(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class45.method921(var10)) {
                              var19 = var10.field2836;
                              if(var10 == ItemComposition.field1180 && var10.field2937 != 0) {
                                 var19 = var10.field2937;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(ItemComposition.field1180 == var10 && var10.field2890 != 0) {
                                 var19 = var10.field2890;
                              }
                           }

                           if(var10.field2839) {
                              switch(var10.field2812.field1472) {
                              case 1:
                                 class82.method1893(var12, var13, var10.width, var10.height, var10.textColor, var10.field2836, 256 - (var10.opacity & 255), 256 - (var10.field2842 & 255));
                                 break;
                              case 2:
                                 class82.method1827(var12, var13, var10.width, var10.height, var10.textColor, var10.field2836, 256 - (var10.opacity & 255), 256 - (var10.field2842 & 255));
                                 break;
                              case 3:
                                 class82.method1890(var12, var13, var10.width, var10.height, var10.textColor, var10.field2836, 256 - (var10.opacity & 255), 256 - (var10.field2842 & 255));
                                 break;
                              case 4:
                                 class82.method1835(var12, var13, var10.width, var10.height, var10.textColor, var10.field2836, 256 - (var10.opacity & 255), 256 - (var10.field2842 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    class82.method1831(var12, var13, var10.width, var10.height, var19);
                                 } else {
                                    class82.method1856(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              class82.method1837(var12, var13, var10.width, var10.height, var19);
                           } else {
                              class82.method1892(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                           }
                        } else {
                           class227 var48;
                           if(var10.type == 4) {
                              var48 = var10.method3428();
                              if(null == var48) {
                                 if(Widget.field2808) {
                                    class75.method1606(var10);
                                 }
                              } else {
                                 String var53 = var10.text;
                                 if(class45.method921(var10)) {
                                    var20 = var10.field2836;
                                    if(var10 == ItemComposition.field1180 && var10.field2937 != 0) {
                                       var20 = var10.field2937;
                                    }

                                    if(var10.field2835.length() > 0) {
                                       var53 = var10.field2835;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(ItemComposition.field1180 == var10 && var10.field2890 != 0) {
                                       var20 = var10.field2890;
                                    }
                                 }

                                 if(var10.field2809 && var10.item != -1) {
                                    ItemComposition var54 = MessageNode.getItemDefinition(var10.item);
                                    var53 = var54.name;
                                    if(var53 == null) {
                                       var53 = "null";
                                    }

                                    if((var54.isStackable == 1 || var10.stackSize != 1) && var10.stackSize != -1) {
                                       var53 = class154.method3185(16748608) + var53 + "</col>" + " " + 'x' + class9.method120(var10.stackSize);
                                    }
                                 }

                                 if(var10 == Client.field443) {
                                    Object var10000 = null;
                                    var53 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.field2809) {
                                    var53 = class224.method4032(var53, var10);
                                 }

                                 var48.method4100(var53, var12, var13, var10.width, var10.height, var20, var10.field2895?0:-1, var10.field2933, var10.field2816, var10.field2823);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var49;
                              if(!var10.field2809) {
                                 var49 = var10.method3427(class45.method921(var10));
                                 if(null != var49) {
                                    var49.method1740(var12, var13);
                                 } else if(Widget.field2808) {
                                    class75.method1606(var10);
                                 }
                              } else {
                                 if(var10.item != -1) {
                                    var49 = class53.createSprite(var10.item, var10.stackSize, var10.borderThickness, var10.sprite2, var10.field2942, false);
                                 } else {
                                    var49 = var10.method3427(false);
                                 }

                                 if(var49 == null) {
                                    if(Widget.field2808) {
                                       class75.method1606(var10);
                                    }
                                 } else {
                                    var20 = var49.field1440;
                                    var21 = var49.field1441;
                                    if(!var10.field2846) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.field2919 != 0) {
                                          var49.method1753(var10.width / 2 + var12, var13 + var10.height / 2, var10.field2919, var22);
                                       } else if(var14 != 0) {
                                          var49.method1748(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var10.width == var20 && var10.height == var21) {
                                          var49.method1740(var12, var13);
                                       } else {
                                          var49.method1774(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       class82.method1826(var12, var13, var10.width + var12, var10.height + var13);
                                       var22 = (var10.width + (var20 - 1)) / var20;
                                       var39 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var39; ++var25) {
                                             if(var10.field2919 != 0) {
                                                var49.method1753(var12 + var24 * var20 + var20 / 2, var25 * var21 + var13 + var21 / 2, var10.field2919, 4096);
                                             } else if(var14 != 0) {
                                                var49.method1730(var24 * var20 + var12, var21 * var25 + var13, 256 - (var14 & 255));
                                             } else {
                                                var49.method1740(var12 + var24 * var20, var25 * var21 + var13);
                                             }
                                          }
                                       }

                                       class82.method1825(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var23;
                              if(var10.type == 6) {
                                 boolean var43 = class45.method921(var10);
                                 if(var43) {
                                    var20 = var10.field2821;
                                 } else {
                                    var20 = var10.field2857;
                                 }

                                 Model var50 = null;
                                 var22 = 0;
                                 if(var10.item != -1) {
                                    var23 = MessageNode.getItemDefinition(var10.item);
                                    if(null != var23) {
                                       var23 = var23.method1157(var10.stackSize);
                                       var50 = var23.getModel(1);
                                       if(var50 != null) {
                                          var50.method2391();
                                          var22 = var50.modelHeight / 2;
                                       } else {
                                          class75.method1606(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var50 = Client.field553.method3503((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var50 = class48.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var50 = var10.method3430((Sequence)null, -1, var43, class48.localPlayer.composition);
                                    if(var50 == null && Widget.field2808) {
                                       class75.method1606(var10);
                                    }
                                 } else {
                                    Sequence var45 = class113.getAnimation(var20);
                                    var50 = var10.method3430(var45, var10.field2932, var43, class48.localPlayer.composition);
                                    if(null == var50 && Widget.field2808) {
                                       class75.method1606(var10);
                                    }
                                 }

                                 class94.method2134(var10.width / 2 + var12, var13 + var10.height / 2);
                                 var39 = class94.field1639[var10.rotationX] * var10.field2864 >> 16;
                                 var24 = var10.field2864 * class94.field1640[var10.rotationX] >> 16;
                                 if(var50 != null) {
                                    if(!var10.field2809) {
                                       var50.method2366(0, var10.rotationZ, 0, var10.rotationX, 0, var39, var24);
                                    } else {
                                       var50.method2391();
                                       if(var10.field2867) {
                                          var50.method2376(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2873, var39 + var22 + var10.field2860, var10.field2860 + var24, var10.field2864);
                                       } else {
                                          var50.method2366(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2873, var22 + var39 + var10.field2860, var24 + var10.field2860);
                                       }
                                    }
                                 }

                                 class94.method2133();
                              } else {
                                 if(var10.type == 7) {
                                    var48 = var10.method3428();
                                    if(var48 == null) {
                                       if(Widget.field2808) {
                                          class75.method1606(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2822; ++var21) {
                                       for(var22 = 0; var22 < var10.field2884; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var23 = MessageNode.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var40;
                                             if(var23.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var40 = class154.method3185(16748608) + var23.name + "</col>";
                                             } else {
                                                var40 = class154.method3185(16748608) + var23.name + "</col>" + " " + 'x' + class9.method120(var10.itemQuantities[var20]);
                                             }

                                             var25 = var12 + var22 * (var10.field2918 + 115);
                                             var26 = var13 + (var10.field2877 + 12) * var21;
                                             if(var10.field2933 == 0) {
                                                var48.method4079(var40, var25, var26, var10.textColor, var10.field2895?0:-1);
                                             } else if(var10.field2933 == 1) {
                                                var48.method4046(var40, var10.width / 2 + var25, var26, var10.textColor, var10.field2895?0:-1);
                                             } else {
                                                var48.method4045(var40, var10.width + var25 - 1, var26, var10.textColor, var10.field2895?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 int var27;
                                 if(var10.type == 8 && var10 == BufferProvider.field1434 && Client.field430 == Client.field431) {
                                    var19 = 0;
                                    var20 = 0;
                                    class227 var37 = class158.field2347;
                                    String var38 = var10.text;

                                    String var44;
                                    for(var38 = class224.method4032(var38, var10); var38.length() > 0; var20 += 1 + var37.field3240) {
                                       var24 = var38.indexOf("<br>");
                                       if(var24 != -1) {
                                          var44 = var38.substring(0, var24);
                                          var38 = var38.substring(4 + var24);
                                       } else {
                                          var44 = var38;
                                          var38 = "";
                                       }

                                       var25 = var37.method4099(var44);
                                       if(var25 > var19) {
                                          var19 = var25;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var24 = var12 + var10.width - 5 - var19;
                                    var25 = 5 + var10.height + var13;
                                    if(var24 < var12 + 5) {
                                       var24 = 5 + var12;
                                    }

                                    if(var19 + var24 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if(var25 + var20 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    class82.method1831(var24, var25, var19, var20, 16777120);
                                    class82.method1837(var24, var25, var19, var20, 0);
                                    var38 = var10.text;
                                    var26 = var25 + var37.field3240 + 2;

                                    for(var38 = class224.method4032(var38, var10); var38.length() > 0; var26 += var37.field3240 + 1) {
                                       var27 = var38.indexOf("<br>");
                                       if(var27 != -1) {
                                          var44 = var38.substring(0, var27);
                                          var38 = var38.substring(4 + var27);
                                       } else {
                                          var44 = var38;
                                          var38 = "";
                                       }

                                       var37.method4079(var44, 3 + var24, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2843 == 1) {
                                       if(var10.field2874) {
                                          var19 = var12;
                                          var20 = var13 + var10.height;
                                          var21 = var10.width + var12;
                                          var22 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var21 = var12 + var10.width;
                                          var22 = var13 + var10.height;
                                       }

                                       class82.method1843(var19, var20, var21, var22, var10.textColor);
                                    } else {
                                       var19 = var10.width >= 0?var10.width:-var10.width;
                                       var20 = var10.height >= 0?var10.height:-var10.height;
                                       var21 = var19;
                                       if(var19 < var20) {
                                          var21 = var20;
                                       }

                                       if(var21 != 0) {
                                          var22 = (var10.width << 16) / var21;
                                          var39 = (var10.height << 16) / var21;
                                          if(var39 <= var22) {
                                             var22 = -var22;
                                          } else {
                                             var39 = -var39;
                                          }

                                          var24 = var10.field2843 * var39 >> 17;
                                          var25 = 1 + var39 * var10.field2843 >> 17;
                                          var26 = var10.field2843 * var22 >> 17;
                                          var27 = 1 + var22 * var10.field2843 >> 17;
                                          int var42 = var24 + var12;
                                          var29 = var12 - var25;
                                          int var30 = var10.width + var12 - var25;
                                          int var31 = var10.width + var12 + var24;
                                          int var32 = var13 + var26;
                                          int var33 = var13 - var27;
                                          int var34 = var13 + var10.height - var27;
                                          int var35 = var13 + var10.height + var26;
                                          class94.setRasterClippingEnabled(var42, var29, var30);
                                          class94.rasterFlat(var32, var33, var34, var42, var29, var30, var10.textColor);
                                          class94.setRasterClippingEnabled(var42, var30, var31);
                                          class94.rasterFlat(var32, var34, var35, var42, var30, var31, var10.textColor);
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Lclass48;",
      garbageValue = "-528572399"
   )
   public static class48 method41(int var0) {
      class48 var1 = (class48)class48.field1053.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class48.field1069.method3290(4, var0);
         var1 = new class48();
         if(null != var2) {
            var1.method973(new Buffer(var2), var0);
         }

         var1.method990();
         class48.field1053.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1858836019"
   )
   static final void method42(int var0, int var1, int var2, int var3) {
      ++Client.field386;
      class0.method0(class35.field782);
      boolean var4 = false;
      int var5;
      int var7;
      if(Client.field411 >= 0) {
         var5 = class34.field760;
         int[] var6 = class34.field755;

         for(var7 = 0; var7 < var5; ++var7) {
            if(var6[var7] == Client.field411) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         class0.method0(class35.field773);
      }

      class151.method3177(true);
      class0.method0(var4?class35.field778:class35.field774);
      class151.method3177(false);

      for(Projectile var16 = (Projectile)Client.projectiles.method3850(); null != var16; var16 = (Projectile)Client.projectiles.method3852()) {
         if(FrameMap.plane == var16.floor && Client.gameCycle <= var16.field105) {
            if(Client.gameCycle >= var16.startTime) {
               if(var16.interacting > 0) {
                  NPC var18 = Client.cachedNPCs[var16.interacting - 1];
                  if(null != var18 && var18.x >= 0 && var18.x < 13312 && var18.y >= 0 && var18.y < 13312) {
                     var16.method101(var18.x, var18.y, KitDefinition.method936(var18.x, var18.y, var16.floor) - var16.field103, Client.gameCycle);
                  }
               }

               if(var16.interacting < 0) {
                  var7 = -var16.interacting - 1;
                  Player var19;
                  if(Client.localInteractingIndex == var7) {
                     var19 = class48.localPlayer;
                  } else {
                     var19 = Client.cachedPlayers[var7];
                  }

                  if(null != var19 && var19.x >= 0 && var19.x < 13312 && var19.y >= 0 && var19.y < 13312) {
                     var16.method101(var19.x, var19.y, KitDefinition.method936(var19.x, var19.y, var16.floor) - var16.field103, Client.gameCycle);
                  }
               }

               var16.method102(Client.field329);
               Projectile.region.method2110(FrameMap.plane, (int)var16.x, (int)var16.velocityZ, (int)var16.z, 60, var16, var16.field118, -1, false);
            }
         } else {
            var16.unlink();
         }
      }

      class158.method3199();
      class9.method119(var0, var1, var2, var3, true);
      var0 = Client.field542;
      var1 = Client.field347;
      var2 = Client.camera2;
      var3 = Client.camera3;
      class82.method1825(var0, var1, var2 + var0, var3 + var1);
      class94.method2146();
      int var17;
      if(!Client.field418) {
         var5 = Client.field365;
         if(Client.field374 / 256 > var5) {
            var5 = Client.field374 / 256;
         }

         if(Client.field529[4] && 128 + Client.field562[4] > var5) {
            var5 = Client.field562[4] + 128;
         }

         var17 = Client.mapAngle + Client.field490 & 2047;
         class24.method576(CollisionData.field1964, KitDefinition.method936(class48.localPlayer.x, class48.localPlayer.y, FrameMap.plane) - Client.field371, class163.field2701, var5, var17, 600 + var5 * 3);
      }

      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var15;
      if(!Client.field418) {
         if(class161.field2659.field145) {
            var17 = FrameMap.plane;
         } else {
            label453: {
               var7 = 3;
               if(class53.cameraPitch < 310) {
                  var8 = Ignore.cameraX >> 7;
                  var9 = WallObject.cameraY >> 7;
                  var10 = class48.localPlayer.x >> 7;
                  var11 = class48.localPlayer.y >> 7;
                  if(var8 < 0 || var9 < 0 || var8 >= 104 || var9 >= 104) {
                     var17 = FrameMap.plane;
                     break label453;
                  }

                  if((class5.tileSettings[FrameMap.plane][var8][var9] & 4) != 0) {
                     var7 = FrameMap.plane;
                  }

                  if(var10 > var8) {
                     var12 = var10 - var8;
                  } else {
                     var12 = var8 - var10;
                  }

                  if(var11 > var9) {
                     var13 = var11 - var9;
                  } else {
                     var13 = var9 - var11;
                  }

                  int var14;
                  if(var12 > var13) {
                     var14 = 65536 * var13 / var12;
                     var15 = '耀';

                     while(var8 != var10) {
                        if(var8 < var10) {
                           ++var8;
                        } else if(var8 > var10) {
                           --var8;
                        }

                        if((class5.tileSettings[FrameMap.plane][var8][var9] & 4) != 0) {
                           var7 = FrameMap.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var9 < var11) {
                              ++var9;
                           } else if(var9 > var11) {
                              --var9;
                           }

                           if((class5.tileSettings[FrameMap.plane][var8][var9] & 4) != 0) {
                              var7 = FrameMap.plane;
                           }
                        }
                     }
                  } else {
                     var14 = var12 * 65536 / var13;
                     var15 = '耀';

                     while(var9 != var11) {
                        if(var9 < var11) {
                           ++var9;
                        } else if(var9 > var11) {
                           --var9;
                        }

                        if((class5.tileSettings[FrameMap.plane][var8][var9] & 4) != 0) {
                           var7 = FrameMap.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var8 < var10) {
                              ++var8;
                           } else if(var8 > var10) {
                              --var8;
                           }

                           if((class5.tileSettings[FrameMap.plane][var8][var9] & 4) != 0) {
                              var7 = FrameMap.plane;
                           }
                        }
                     }
                  }
               }

               if(class48.localPlayer.x >= 0 && class48.localPlayer.y >= 0 && class48.localPlayer.x < 13312 && class48.localPlayer.y < 13312) {
                  if((class5.tileSettings[FrameMap.plane][class48.localPlayer.x >> 7][class48.localPlayer.y >> 7] & 4) != 0) {
                     var7 = FrameMap.plane;
                  }

                  var17 = var7;
               } else {
                  var17 = FrameMap.plane;
               }
            }
         }

         var5 = var17;
      } else {
         if(class161.field2659.field145) {
            var17 = FrameMap.plane;
         } else {
            var7 = KitDefinition.method936(Ignore.cameraX, WallObject.cameraY, FrameMap.plane);
            if(var7 - class119.cameraZ < 800 && (class5.tileSettings[FrameMap.plane][Ignore.cameraX >> 7][WallObject.cameraY >> 7] & 4) != 0) {
               var17 = FrameMap.plane;
            } else {
               var17 = 3;
            }
         }

         var5 = var17;
      }

      var17 = Ignore.cameraX;
      var7 = class119.cameraZ;
      var8 = WallObject.cameraY;
      var9 = class53.cameraPitch;
      var10 = Client.cameraYaw;

      for(var11 = 0; var11 < 5; ++var11) {
         if(Client.field529[var11]) {
            var12 = (int)(Math.random() * (double)(2 * Client.field530[var11] + 1) - (double)Client.field530[var11] + Math.sin((double)Client.field533[var11] * ((double)Client.field503[var11] / 100.0D)) * (double)Client.field562[var11]);
            if(var11 == 0) {
               Ignore.cameraX += var12;
            }

            if(var11 == 1) {
               class119.cameraZ += var12;
            }

            if(var11 == 2) {
               WallObject.cameraY += var12;
            }

            if(var11 == 3) {
               Client.cameraYaw = var12 + Client.cameraYaw & 2047;
            }

            if(var11 == 4) {
               class53.cameraPitch += var12;
               if(class53.cameraPitch < 128) {
                  class53.cameraPitch = 128;
               }

               if(class53.cameraPitch > 383) {
                  class53.cameraPitch = 383;
               }
            }
         }
      }

      var11 = class143.field2204;
      var12 = class143.field2210;
      if(class143.field2198 != 0) {
         var11 = class143.field2211;
         var12 = class143.field2213;
      }

      if(var11 >= var0 && var11 < var2 + var0 && var12 >= var1 && var12 < var3 + var1) {
         Model.field1910 = true;
         Model.field1913 = 0;
         Model.field1898 = var11 - var0;
         Model.field1904 = var12 - var1;
      } else {
         Model.field1910 = false;
         Model.field1913 = 0;
      }

      class92.method2127();
      class82.method1831(var0, var1, var2, var3, 0);
      class92.method2127();
      var13 = class94.field1626;
      class94.field1626 = Client.scale;
      Projectile.region.method1986(Ignore.cameraX, class119.cameraZ, WallObject.cameraY, class53.cameraPitch, Client.cameraYaw, var5);
      class94.field1626 = var13;
      class92.method2127();
      Projectile.region.method2073();
      class20.method547(var0, var1, var2, var3);
      if(Client.field525 == 2) {
         class179.method3480((Client.field419 - class28.baseX << 7) + Client.field355, Client.field305 + (Client.field302 - class159.baseY << 7), Client.field303 * 2);
         if(Client.field387 > -1 && Client.gameCycle % 20 < 10) {
            class145.field2232[0].method1740(Client.field387 + var0 - 12, Client.field388 + var1 - 28);
         }
      }

      ((TextureProvider)class94.field1636).method2230(Client.field329);
      class177.method3470(var0, var1, var2, var3);
      Ignore.cameraX = var17;
      class119.cameraZ = var7;
      WallObject.cameraY = var8;
      class53.cameraPitch = var9;
      Client.cameraYaw = var10;
      if(Client.field289) {
         byte var20 = 0;
         var15 = var20 + class174.field2785 + class174.field2794;
         if(var15 == 0) {
            Client.field289 = false;
         }
      }

      if(Client.field289) {
         class82.method1831(var0, var1, var2, var3, 0);
         KitDefinition.method941("Loading - please wait.", false);
      }

   }
}
