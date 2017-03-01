import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
@Implements("TextureProvider")
public class TextureProvider implements class93 {
   @ObfuscatedName("kv")
   static Widget[] field1212;
   @ObfuscatedName("n")
   Deque field1213 = new Deque();
   @ObfuscatedName("qg")
   static java.awt.Font field1214;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 524923631
   )
   int field1215 = 0;
   @ObfuscatedName("j")
   class182 field1216;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1480956233
   )
   int field1217 = 128;
   @ObfuscatedName("x")
   class79[] field1218;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1922952203
   )
   int field1219;
   @ObfuscatedName("y")
   double field1221 = 1.0D;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "12"
   )
   static void method1507() {
      for(class31 var0 = (class31)class31.field703.method2503(); var0 != null; var0 = (class31)class31.field703.method2492()) {
         if(null != var0.field715) {
            var0.method707();
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-1897519331"
   )
   @Export("load")
   public int[] load(int var1) {
      class79 var2 = this.field1218[var1];
      if(null != var2) {
         if(null != var2.field1324) {
            this.field1213.method2500(var2);
            var2.field1315 = true;
            return var2.field1324;
         }

         boolean var3 = var2.method1628(this.field1221, this.field1217, this.field1216);
         if(var3) {
            if(this.field1215 == 0) {
               class79 var4 = (class79)this.field1213.method2499();
               var4.method1635();
            } else {
               --this.field1215;
            }

            this.field1213.method2500(var2);
            var2.field1315 = true;
            return var2.field1324;
         }
      }

      return null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1015502992"
   )
   public int vmethod1999(int var1) {
      return this.field1218[var1] != null?this.field1218[var1].field1312:0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "28"
   )
   public boolean vmethod2009(int var1) {
      return this.field1217 == 64;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-996911429"
   )
   public void method1514(int var1) {
      for(int var2 = 0; var2 < this.field1218.length; ++var2) {
         class79 var3 = this.field1218[var2];
         if(var3 != null && var3.field1313 != 0 && var3.field1315) {
            var3.method1630(var1);
            var3.field1315 = false;
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SI)V",
      garbageValue = "1240378160"
   )
   public static void method1518(String[] var0, short[] var1) {
      CombatInfo2.method3607(var0, var1, 0, var0.length - 1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-29"
   )
   public boolean vmethod2000(int var1) {
      return this.field1218[var1].field1317;
   }

   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IDI)V",
      garbageValue = "64"
   )
   public TextureProvider(class182 var1, class182 var2, int var3, double var4, int var6) {
      this.field1216 = var2;
      this.field1219 = var3;
      this.field1215 = this.field1219;
      this.field1221 = var4;
      this.field1217 = var6;
      int[] var7 = var1.method3364(0);
      int var8 = var7.length;
      this.field1218 = new class79[var1.method3352(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.getConfigData(0, var7[var9]));
         this.field1218[var7[var9]] = new class79(var10);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "51142956"
   )
   public void method1539() {
      for(int var1 = 0; var1 < this.field1218.length; ++var1) {
         if(this.field1218[var1] != null) {
            this.field1218[var1].method1635();
         }
      }

      this.field1213 = new Deque();
      this.field1215 = this.field1219;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "827380691"
   )
   static final void method1541() {
      int var0;
      int var1;
      int var2;
      Item var30;
      int var35;
      if(Client.packetOpcode == 78) {
         var0 = Client.field334.method2922();
         var1 = Client.field334.readUnsignedByte();
         var2 = (var1 >> 4 & 7) + class7.field60;
         var35 = class26.field596 + (var1 & 7);
         if(var2 >= 0 && var35 >= 0 && var2 < 104 && var35 < 104) {
            Deque var29 = Client.groundItemDeque[CollisionData.plane][var2][var35];
            if(null != var29) {
               for(var30 = (Item)var29.method2503(); var30 != null; var30 = (Item)var29.method2492()) {
                  if(var30.id == (var0 & 32767)) {
                     var30.unlink();
                     break;
                  }
               }

               if(var29.method2503() == null) {
                  Client.groundItemDeque[CollisionData.plane][var2][var35] = null;
               }

               class110.groundItemSpawned(var2, var35);
            }
         }

      } else {
         int var5;
         int var6;
         int var36;
         if(Client.packetOpcode == 151) {
            var0 = Client.field334.method2914();
            var1 = (var0 >> 4 & 7) + class7.field60;
            var2 = (var0 & 7) + class26.field596;
            var35 = Client.field334.method2992();
            var36 = var35 >> 2;
            var5 = var35 & 3;
            var6 = Client.field329[var36];
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               class16.method194(CollisionData.plane, var1, var2, var6, -1, var36, var5, 0, -1);
            }

         } else {
            int var7;
            int var40;
            if(Client.packetOpcode == 37) {
               var0 = Client.field334.method2922();
               var1 = Client.field334.readUnsignedByte();
               var2 = var1 >> 2;
               var35 = var1 & 3;
               var36 = Client.field329[var2];
               var5 = Client.field334.readUnsignedByte();
               var6 = class7.field60 + (var5 >> 4 & 7);
               var7 = class26.field596 + (var5 & 7);
               if(var6 >= 0 && var7 >= 0 && var6 < 103 && var7 < 103) {
                  if(var36 == 0) {
                     WallObject var8 = Friend.region.method1811(CollisionData.plane, var6, var7);
                     if(var8 != null) {
                        var40 = var8.hash >> 14 & 32767;
                        if(var2 == 2) {
                           var8.renderable1 = new class49(var40, 2, var35 + 4, CollisionData.plane, var6, var7, var0, false, var8.renderable1);
                           var8.renderable2 = new class49(var40, 2, var35 + 1 & 3, CollisionData.plane, var6, var7, var0, false, var8.renderable2);
                        } else {
                           var8.renderable1 = new class49(var40, var2, var35, CollisionData.plane, var6, var7, var0, false, var8.renderable1);
                        }
                     }
                  }

                  if(var36 == 1) {
                     DecorativeObject var37 = Friend.region.method1967(CollisionData.plane, var6, var7);
                     if(null != var37) {
                        var40 = var37.hash >> 14 & 32767;
                        if(var2 != 4 && var2 != 5) {
                           if(var2 == 6) {
                              var37.renderable1 = new class49(var40, 4, var35 + 4, CollisionData.plane, var6, var7, var0, false, var37.renderable1);
                           } else if(var2 == 7) {
                              var37.renderable1 = new class49(var40, 4, 4 + (2 + var35 & 3), CollisionData.plane, var6, var7, var0, false, var37.renderable1);
                           } else if(var2 == 8) {
                              var37.renderable1 = new class49(var40, 4, var35 + 4, CollisionData.plane, var6, var7, var0, false, var37.renderable1);
                              var37.renderable2 = new class49(var40, 4, 4 + (2 + var35 & 3), CollisionData.plane, var6, var7, var0, false, var37.renderable2);
                           }
                        } else {
                           var37.renderable1 = new class49(var40, 4, var35, CollisionData.plane, var6, var7, var0, false, var37.renderable1);
                        }
                     }
                  }

                  if(var36 == 2) {
                     GameObject var38 = Friend.region.method1944(CollisionData.plane, var6, var7);
                     if(var2 == 11) {
                        var2 = 10;
                     }

                     if(null != var38) {
                        var38.renderable = new class49(var38.hash >> 14 & 32767, var2, var35, CollisionData.plane, var6, var7, var0, false, var38.renderable);
                     }
                  }

                  if(var36 == 3) {
                     GroundObject var39 = Friend.region.method1814(CollisionData.plane, var6, var7);
                     if(var39 != null) {
                        var39.renderable = new class49(var39.hash >> 14 & 32767, 22, var35, CollisionData.plane, var6, var7, var0, false, var39.renderable);
                     }
                  }
               }

            } else {
               int var10;
               int var12;
               int var31;
               if(Client.packetOpcode == 232) {
                  var0 = Client.field334.readUnsignedByte();
                  var1 = class7.field60 + (var0 >> 4 & 7);
                  var2 = (var0 & 7) + class26.field596;
                  byte var3 = Client.field334.method2972();
                  byte var4 = Client.field334.method2918();
                  var5 = Client.field334.method2913();
                  var6 = var5 >> 2;
                  var7 = var5 & 3;
                  var31 = Client.field329[var6];
                  byte var9 = Client.field334.method3036();
                  var10 = Client.field334.readUnsignedShort();
                  byte var11 = Client.field334.method2918();
                  var12 = Client.field334.readUnsignedShort();
                  int var13 = Client.field334.method2922();
                  int var14 = Client.field334.method2923();
                  Player var15;
                  if(Client.localInteractingIndex == var10) {
                     var15 = WidgetNode.localPlayer;
                  } else {
                     var15 = Client.cachedPlayers[var10];
                  }

                  if(var15 != null) {
                     ObjectComposition var16 = ChatMessages.getObjectDefinition(var12);
                     int var17;
                     int var18;
                     if(var7 != 1 && var7 != 3) {
                        var17 = var16.sizeX;
                        var18 = var16.sizeY;
                     } else {
                        var17 = var16.sizeY;
                        var18 = var16.sizeX;
                     }

                     int var19 = (var17 >> 1) + var1;
                     int var20 = (1 + var17 >> 1) + var1;
                     int var21 = (var18 >> 1) + var2;
                     int var22 = var2 + (var18 + 1 >> 1);
                     int[][] var23 = class10.tileHeights[CollisionData.plane];
                     int var24 = var23[var20][var22] + var23[var19][var22] + var23[var20][var21] + var23[var19][var21] >> 2;
                     int var25 = (var17 << 6) + (var1 << 7);
                     int var26 = (var2 << 7) + (var18 << 6);
                     Model var27 = var16.method3692(var6, var7, var23, var25, var24, var26);
                     if(var27 != null) {
                        class16.method194(CollisionData.plane, var1, var2, var31, -1, 0, 0, 1 + var13, var14 + 1);
                        var15.totalLevel = Client.gameCycle + var13;
                        var15.field249 = var14 + Client.gameCycle;
                        var15.model = var27;
                        var15.field246 = var17 * 64 + var1 * 128;
                        var15.field252 = var18 * 64 + var2 * 128;
                        var15.field268 = var24;
                        byte var28;
                        if(var9 > var3) {
                           var28 = var9;
                           var9 = var3;
                           var3 = var28;
                        }

                        if(var4 > var11) {
                           var28 = var4;
                           var4 = var11;
                           var11 = var28;
                        }

                        var15.field251 = var9 + var1;
                        var15.field256 = var1 + var3;
                        var15.field255 = var2 + var4;
                        var15.field262 = var2 + var11;
                     }
                  }
               }

               if(Client.packetOpcode == 27) {
                  var0 = Client.field334.readUnsignedByte();
                  var1 = (var0 >> 4 & 7) + class7.field60;
                  var2 = class26.field596 + (var0 & 7);
                  var35 = Client.field334.readUnsignedShort();
                  var36 = Client.field334.readUnsignedByte();
                  var5 = var36 >> 4 & 15;
                  var6 = var36 & 7;
                  var7 = Client.field334.readUnsignedByte();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var31 = var5 + 1;
                     if(WidgetNode.localPlayer.pathX[0] >= var1 - var31 && WidgetNode.localPlayer.pathX[0] <= var31 + var1 && WidgetNode.localPlayer.pathY[0] >= var2 - var31 && WidgetNode.localPlayer.pathY[0] <= var31 + var2 && Client.field397 != 0 && var6 > 0 && Client.field532 < 50) {
                        Client.field533[Client.field532] = var35;
                        Client.field534[Client.field532] = var6;
                        Client.field535[Client.field532] = var7;
                        Client.field537[Client.field532] = null;
                        Client.field536[Client.field532] = var5 + (var2 << 8) + (var1 << 16);
                        ++Client.field532;
                     }
                  }
               }

               if(Client.packetOpcode == 22) {
                  var0 = Client.field334.readUnsignedByte();
                  var1 = (var0 >> 4 & 7) + class7.field60;
                  var2 = (var0 & 7) + class26.field596;
                  var35 = Client.field334.readUnsignedShort();
                  var36 = Client.field334.readUnsignedByte();
                  var5 = Client.field334.readUnsignedShort();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var1 = 128 * var1 + 64;
                     var2 = 64 + 128 * var2;
                     class33 var42 = new class33(var35, CollisionData.plane, var1, var2, class25.method615(var1, var2, CollisionData.plane) - var36, var5, Client.gameCycle);
                     Client.field422.method2511(var42);
                  }

               } else if(Client.packetOpcode == 200) {
                  var0 = Client.field334.readUnsignedByte();
                  var1 = (var0 >> 4 & 7) + class7.field60;
                  var2 = (var0 & 7) + class26.field596;
                  var35 = var1 + Client.field334.readByte();
                  var36 = var2 + Client.field334.readByte();
                  var5 = Client.field334.readShort();
                  var6 = Client.field334.readUnsignedShort();
                  var7 = Client.field334.readUnsignedByte() * 4;
                  var31 = Client.field334.readUnsignedByte() * 4;
                  var40 = Client.field334.readUnsignedShort();
                  var10 = Client.field334.readUnsignedShort();
                  int var41 = Client.field334.readUnsignedByte();
                  var12 = Client.field334.readUnsignedByte();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var35 >= 0 && var36 >= 0 && var35 < 104 && var36 < 104 && var6 != '\uffff') {
                     var1 = var1 * 128 + 64;
                     var2 = 128 * var2 + 64;
                     var35 = var35 * 128 + 64;
                     var36 = 64 + 128 * var36;
                     Projectile var34 = new Projectile(var6, CollisionData.plane, var1, var2, class25.method615(var1, var2, CollisionData.plane) - var7, var40 + Client.gameCycle, var10 + Client.gameCycle, var41, var12, var5, var31);
                     var34.method866(var35, var36, class25.method615(var35, var36, CollisionData.plane) - var31, Client.gameCycle + var40);
                     Client.projectiles.method2511(var34);
                  }

               } else if(Client.packetOpcode != 19) {
                  if(Client.packetOpcode == 13) {
                     var0 = Client.field334.method2913();
                     var1 = class7.field60 + (var0 >> 4 & 7);
                     var2 = class26.field596 + (var0 & 7);
                     var35 = Client.field334.readUnsignedByte();
                     var36 = var35 >> 2;
                     var5 = var35 & 3;
                     var6 = Client.field329[var36];
                     var7 = Client.field334.method2923();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                        class16.method194(CollisionData.plane, var1, var2, var6, var7, var36, var5, 0, -1);
                     }

                  } else if(Client.packetOpcode == 137) {
                     var0 = Client.field334.method2923();
                     var1 = Client.field334.method2922();
                     var2 = Client.field334.method2913();
                     var35 = class7.field60 + (var2 >> 4 & 7);
                     var36 = (var2 & 7) + class26.field596;
                     if(var35 >= 0 && var36 >= 0 && var35 < 104 && var36 < 104) {
                        var30 = new Item();
                        var30.id = var0;
                        var30.quantity = var1;
                        if(Client.groundItemDeque[CollisionData.plane][var35][var36] == null) {
                           Client.groundItemDeque[CollisionData.plane][var35][var36] = new Deque();
                        }

                        Client.groundItemDeque[CollisionData.plane][var35][var36].method2511(var30);
                        class110.groundItemSpawned(var35, var36);
                     }

                  }
               } else {
                  var0 = Client.field334.readUnsignedByte();
                  var1 = class7.field60 + (var0 >> 4 & 7);
                  var2 = class26.field596 + (var0 & 7);
                  var35 = Client.field334.readUnsignedShort();
                  var36 = Client.field334.readUnsignedShort();
                  var5 = Client.field334.readUnsignedShort();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     Deque var32 = Client.groundItemDeque[CollisionData.plane][var1][var2];
                     if(var32 != null) {
                        for(Item var33 = (Item)var32.method2503(); var33 != null; var33 = (Item)var32.method2492()) {
                           if((var35 & 32767) == var33.id && var33.quantity == var36) {
                              var33.quantity = var5;
                              break;
                           }
                        }

                        class110.groundItemSpawned(var1, var2);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)LSequence;",
      garbageValue = "-454424658"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field3078.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = Sequence.field3072.getConfigData(12, var0);
         var1 = new Sequence();
         if(null != var2) {
            var1.method3815(new Buffer(var2));
         }

         var1.method3817();
         Sequence.field3078.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method1543(double var1) {
      this.field1221 = var1;
      this.method1539();
   }
}
