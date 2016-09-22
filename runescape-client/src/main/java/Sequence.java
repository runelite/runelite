import java.awt.Component;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("t")
   public int[] field1009;
   @ObfuscatedName("k")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("r")
   static NodeCache field1011 = new NodeCache(64);
   @ObfuscatedName("z")
   static NodeCache field1012 = new NodeCache(100);
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1309540879
   )
   public int field1014 = -1;
   @ObfuscatedName("i")
   public int[] field1015;
   @ObfuscatedName("g")
   public int[] field1016;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -413013231
   )
   public int field1017 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 7630227
   )
   @Export("maxLoops")
   public int maxLoops = 99;
   @ObfuscatedName("x")
   @Export("stretches")
   public boolean stretches = false;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -598412019
   )
   public int field1020 = 5;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 539962959
   )
   public int field1021 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 143438883
   )
   public int field1022 = -1;
   @ObfuscatedName("d")
   public static class170 field1023;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1054101269
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating = -1;
   @ObfuscatedName("v")
   public static class170 field1025;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1648568671
   )
   @Export("replyMode")
   public int replyMode = 2;
   @ObfuscatedName("a")
   static class170 field1027;
   @ObfuscatedName("n")
   int[] field1028;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "1"
   )
   void method900(Buffer var1) {
      while(true) {
         int var2 = var1.method2528();
         if(var2 == 0) {
            return;
         }

         this.method911(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method902() {
      if(this.precedenceAnimating == -1) {
         if(null != this.interleaveLeave) {
            this.precedenceAnimating = 2;
         } else {
            this.precedenceAnimating = 0;
         }
      }

      if(this.field1017 == -1) {
         if(this.interleaveLeave != null) {
            this.field1017 = 2;
         } else {
            this.field1017 = 0;
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-1064117069"
   )
   public Model method903(Model var1, int var2) {
      var2 = this.field1009[var2];
      Frames var3 = Item.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2358(true);
      } else {
         Model var4 = var1.method2358(!var3.method2306(var2));
         var4.method2325(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LModel;III)LModel;",
      garbageValue = "1362732298"
   )
   Model method904(Model var1, int var2, int var3) {
      var2 = this.field1009[var2];
      Frames var4 = Item.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var4) {
         return var1.method2358(true);
      } else {
         Model var5 = var1.method2358(!var4.method2306(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2332();
         } else if(var3 == 2) {
            var5.method2331();
         } else if(var3 == 3) {
            var5.method2330();
         }

         var5.method2325(var4, var2);
         if(var3 == 1) {
            var5.method2330();
         } else if(var3 == 2) {
            var5.method2331();
         } else if(var3 == 3) {
            var5.method2332();
         }

         return var5;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;II)LModel;",
      garbageValue = "-2098099957"
   )
   public Model method906(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.field1009[var2];
      Frames var5 = Item.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var5) {
         return var3.method903(var1, var4);
      } else {
         var4 = var3.field1009[var4];
         Frames var6 = Item.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(var6 == null) {
            var7 = var1.method2358(!var5.method2306(var2));
            var7.method2325(var5, var2);
            return var7;
         } else {
            var7 = var1.method2358(!var5.method2306(var2) & !var6.method2306(var4));
            var7.method2328(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LModel;IB)LModel;",
      garbageValue = "93"
   )
   public Model method910(Model var1, int var2) {
      int var3 = this.field1009[var2];
      Frames var4 = Item.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(null == var4) {
         return var1.method2358(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(null != this.field1028 && var2 < this.field1028.length) {
            var6 = this.field1028[var2];
            var5 = Item.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method2358(!var4.method2306(var3) & !var5.method2306(var6));
            var7.method2325(var4, var3);
            var7.method2325(var5, var6);
            return var7;
         } else {
            var7 = var1.method2358(!var4.method2306(var3));
            var7.method2325(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-2113372070"
   )
   void method911(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2717();
         this.field1015 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1015[var4] = var1.method2717();
         }

         this.field1009 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1009[var4] = var1.method2717();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1009[var4] += var1.method2717() << 16;
         }
      } else if(var2 == 2) {
         this.field1014 = var1.method2717();
      } else if(var2 == 3) {
         var3 = var1.method2528();
         this.interleaveLeave = new int[var3 + 1];

         for(var4 = 0; var4 < var3; ++var4) {
            this.interleaveLeave[var4] = var1.method2528();
         }

         this.interleaveLeave[var3] = 9999999;
      } else if(var2 == 4) {
         this.stretches = true;
      } else if(var2 == 5) {
         this.field1020 = var1.method2528();
      } else if(var2 == 6) {
         this.field1021 = var1.method2717();
      } else if(var2 == 7) {
         this.field1022 = var1.method2717();
      } else if(var2 == 8) {
         this.maxLoops = var1.method2528();
      } else if(var2 == 9) {
         this.precedenceAnimating = var1.method2528();
      } else if(var2 == 10) {
         this.field1017 = var1.method2528();
      } else if(var2 == 11) {
         this.replyMode = var1.method2528();
      } else if(var2 == 12) {
         var3 = var1.method2528();
         this.field1028 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1028[var4] = var1.method2717();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1028[var4] += var1.method2717() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.method2528();
         this.field1016 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1016[var4] = var1.method2532();
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LModel;IB)LModel;",
      garbageValue = "-19"
   )
   Model method913(Model var1, int var2) {
      var2 = this.field1009[var2];
      Frames var3 = Item.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2353(true);
      } else {
         Model var4 = var1.method2353(!var3.method2306(var2));
         var4.method2325(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "820683825"
   )
   public static void method928() {
      KitDefinition.field1051.reset();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass139;Ljava/awt/Component;III)Lclass59;",
      garbageValue = "1783482102"
   )
   public static final class59 method931(class139 var0, Component var1, int var2, int var3) {
      if(class59.field1265 == 0) {
         throw new IllegalStateException();
      } else if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class72 var4 = new class72();
            var4.field1251 = new int[(class59.field1262?2:1) * 256];
            var4.field1255 = var3;
            var4.vmethod1561(var1);
            var4.field1254 = 1024 + (var3 & -1024);
            if(var4.field1254 > 16384) {
               var4.field1254 = 16384;
            }

            var4.vmethod1566(var4.field1254);
            if(class129.field2122 > 0 && null == class59.field1260) {
               class59.field1260 = new class75();
               class59.field1260.field1421 = var0;
               var0.method2934(class59.field1260, class129.field2122);
            }

            if(null != class59.field1260) {
               if(class59.field1260.field1424[var2] != null) {
                  throw new IllegalArgumentException();
               }

               class59.field1260.field1424[var2] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class59();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("a")
   public static String method932(long var0) {
      class114.field2033.setTime(new Date(var0));
      int var2 = class114.field2033.get(7);
      int var3 = class114.field2033.get(5);
      int var4 = class114.field2033.get(2);
      int var5 = class114.field2033.get(1);
      int var6 = class114.field2033.get(11);
      int var7 = class114.field2033.get(12);
      int var8 = class114.field2033.get(13);
      return class114.field2032[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class114.field2035[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "3"
   )
   static final void method933() {
      int var0;
      int var1;
      int var3;
      Item var29;
      int var35;
      int var36;
      if(Client.packetOpcode == 151) {
         var0 = Client.field325.method2557();
         var1 = class16.field226 + (var0 >> 4 & 7);
         var35 = (var0 & 7) + Client.field345;
         var3 = Client.field325.method2565();
         var36 = Client.field325.method2565();
         if(var1 >= 0 && var35 >= 0 && var1 < 104 && var35 < 104) {
            var29 = new Item();
            var29.id = var36;
            var29.quantity = var3;
            if(Client.groundItemDeque[Item.plane][var1][var35] == null) {
               Client.groundItemDeque[Item.plane][var1][var35] = new Deque();
            }

            Client.groundItemDeque[Item.plane][var1][var35].method3849(var29);
            class9.groundItemSpawned(var1, var35);
         }

      } else if(Client.packetOpcode == 5) {
         var0 = Client.field325.method2565();
         var1 = Client.field325.method2528();
         var35 = class16.field226 + (var1 >> 4 & 7);
         var3 = (var1 & 7) + Client.field345;
         if(var35 >= 0 && var3 >= 0 && var35 < 104 && var3 < 104) {
            Deque var31 = Client.groundItemDeque[Item.plane][var35][var3];
            if(var31 != null) {
               for(var29 = (Item)var31.method3854(); null != var29; var29 = (Item)var31.method3869()) {
                  if(var29.id == (var0 & 32767)) {
                     var29.unlink();
                     break;
                  }
               }

               if(var31.method3854() == null) {
                  Client.groundItemDeque[Item.plane][var35][var3] = null;
               }

               class9.groundItemSpawned(var35, var3);
            }
         }

      } else {
         int var5;
         int var6;
         int var7;
         int var8;
         int var11;
         int var12;
         if(Client.packetOpcode == 227) {
            var0 = Client.field325.method2565();
            var1 = Client.field325.method2731();
            byte var2 = Client.field325.method2685();
            var3 = Client.field325.method2566();
            byte var4 = Client.field325.method2650();
            var5 = Client.field325.method2557();
            var6 = var5 >> 2;
            var7 = var5 & 3;
            var8 = Client.field344[var6];
            byte var9 = Client.field325.method2650();
            byte var10 = Client.field325.method2685();
            var11 = Client.field325.method2717();
            var12 = Client.field325.method2557();
            int var13 = class16.field226 + (var12 >> 4 & 7);
            int var14 = Client.field345 + (var12 & 7);
            Player var15;
            if(var11 == Client.localInteractingIndex) {
               var15 = WidgetNode.localPlayer;
            } else {
               var15 = Client.cachedPlayers[var11];
            }

            if(var15 != null) {
               ObjectComposition var16 = class165.getObjectDefinition(var1);
               int var17;
               int var18;
               if(var7 != 1 && var7 != 3) {
                  var17 = var16.field963;
                  var18 = var16.field964;
               } else {
                  var17 = var16.field964;
                  var18 = var16.field963;
               }

               int var19 = (var17 >> 1) + var13;
               int var20 = var13 + (1 + var17 >> 1);
               int var21 = var14 + (var18 >> 1);
               int var22 = var14 + (var18 + 1 >> 1);
               int[][] var23 = class5.tileHeights[Item.plane];
               int var24 = var23[var19][var22] + var23[var19][var21] + var23[var20][var21] + var23[var20][var22] >> 2;
               int var25 = (var13 << 7) + (var17 << 6);
               int var26 = (var14 << 7) + (var18 << 6);
               Model var27 = var16.method843(var6, var7, var23, var25, var24, var26);
               if(var27 != null) {
                  class194.method3776(Item.plane, var13, var14, var8, -1, 0, 0, 1 + var3, 1 + var0);
                  var15.totalLevel = Client.gameCycle + var3;
                  var15.field31 = var0 + Client.gameCycle;
                  var15.model = var27;
                  var15.field42 = 128 * var13 + var17 * 64;
                  var15.field44 = 64 * var18 + 128 * var14;
                  var15.field43 = var24;
                  byte var28;
                  if(var4 > var2) {
                     var28 = var4;
                     var4 = var2;
                     var2 = var28;
                  }

                  if(var10 > var9) {
                     var28 = var10;
                     var10 = var9;
                     var9 = var28;
                  }

                  var15.field33 = var4 + var13;
                  var15.field48 = var2 + var13;
                  var15.field47 = var10 + var14;
                  var15.field49 = var9 + var14;
               }
            }
         }

         if(Client.packetOpcode == 166) {
            var0 = Client.field325.method2528();
            var1 = (var0 >> 4 & 7) + class16.field226;
            var35 = (var0 & 7) + Client.field345;
            var3 = Client.field325.method2717();
            var36 = Client.field325.method2528();
            var5 = var36 >> 4 & 15;
            var6 = var36 & 7;
            var7 = Client.field325.method2528();
            if(var1 >= 0 && var35 >= 0 && var1 < 104 && var35 < 104) {
               var8 = var5 + 1;
               if(WidgetNode.localPlayer.pathX[0] >= var1 - var8 && WidgetNode.localPlayer.pathX[0] <= var8 + var1 && WidgetNode.localPlayer.pathY[0] >= var35 - var8 && WidgetNode.localPlayer.pathY[0] <= var35 + var8 && Client.field414 != 0 && var6 > 0 && Client.field522 < 50) {
                  Client.field523[Client.field522] = var3;
                  Client.field428[Client.field522] = var6;
                  Client.field471[Client.field522] = var7;
                  Client.field432[Client.field522] = null;
                  Client.field526[Client.field522] = (var35 << 8) + (var1 << 16) + var5;
                  ++Client.field522;
               }
            }
         }

         int var37;
         if(Client.packetOpcode == 90) {
            var0 = Client.field325.method2528();
            var1 = (var0 >> 4 & 7) + class16.field226;
            var35 = (var0 & 7) + Client.field345;
            var3 = Client.field325.method2566();
            var36 = Client.field325.method2556();
            var5 = var36 >> 2;
            var6 = var36 & 3;
            var7 = Client.field344[var5];
            if(var1 >= 0 && var35 >= 0 && var1 < 103 && var35 < 103) {
               if(var7 == 0) {
                  WallObject var30 = class16.region.method1970(Item.plane, var1, var35);
                  if(null != var30) {
                     var37 = var30.hash >> 14 & 32767;
                     if(var5 == 2) {
                        var30.renderable1 = new class12(var37, 2, var6 + 4, Item.plane, var1, var35, var3, false, var30.renderable1);
                        var30.renderable2 = new class12(var37, 2, var6 + 1 & 3, Item.plane, var1, var35, var3, false, var30.renderable2);
                     } else {
                        var30.renderable1 = new class12(var37, var5, var6, Item.plane, var1, var35, var3, false, var30.renderable1);
                     }
                  }
               }

               if(var7 == 1) {
                  DecorativeObject var39 = class16.region.method1971(Item.plane, var1, var35);
                  if(var39 != null) {
                     var37 = var39.hash >> 14 & 32767;
                     if(var5 != 4 && var5 != 5) {
                        if(var5 == 6) {
                           var39.renderable1 = new class12(var37, 4, 4 + var6, Item.plane, var1, var35, var3, false, var39.renderable1);
                        } else if(var5 == 7) {
                           var39.renderable1 = new class12(var37, 4, (2 + var6 & 3) + 4, Item.plane, var1, var35, var3, false, var39.renderable1);
                        } else if(var5 == 8) {
                           var39.renderable1 = new class12(var37, 4, 4 + var6, Item.plane, var1, var35, var3, false, var39.renderable1);
                           var39.renderable2 = new class12(var37, 4, (var6 + 2 & 3) + 4, Item.plane, var1, var35, var3, false, var39.renderable2);
                        }
                     } else {
                        var39.renderable1 = new class12(var37, 4, var6, Item.plane, var1, var35, var3, false, var39.renderable1);
                     }
                  }
               }

               if(var7 == 2) {
                  GameObject var40 = class16.region.method1972(Item.plane, var1, var35);
                  if(var5 == 11) {
                     var5 = 10;
                  }

                  if(null != var40) {
                     var40.renderable = new class12(var40.hash >> 14 & 32767, var5, var6, Item.plane, var1, var35, var3, false, var40.renderable);
                  }
               }

               if(var7 == 3) {
                  GroundObject var41 = class16.region.method1973(Item.plane, var1, var35);
                  if(var41 != null) {
                     var41.renderable = new class12(var41.hash >> 14 & 32767, 22, var6, Item.plane, var1, var35, var3, false, var41.renderable);
                  }
               }
            }

         } else if(Client.packetOpcode == 74) {
            var0 = Client.field325.method2555();
            var1 = var0 >> 2;
            var35 = var0 & 3;
            var3 = Client.field344[var1];
            var36 = Client.field325.method2556();
            var5 = (var36 >> 4 & 7) + class16.field226;
            var6 = (var36 & 7) + Client.field345;
            var7 = Client.field325.method2731();
            if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
               class194.method3776(Item.plane, var5, var6, var3, var7, var1, var35, 0, -1);
            }

         } else if(Client.packetOpcode == 246) {
            var0 = Client.field325.method2556();
            var1 = var0 >> 2;
            var35 = var0 & 3;
            var3 = Client.field344[var1];
            var36 = Client.field325.method2556();
            var5 = (var36 >> 4 & 7) + class16.field226;
            var6 = Client.field345 + (var36 & 7);
            if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
               class194.method3776(Item.plane, var5, var6, var3, -1, var1, var35, 0, -1);
            }

         } else if(Client.packetOpcode == 159) {
            var0 = Client.field325.method2528();
            var1 = class16.field226 + (var0 >> 4 & 7);
            var35 = Client.field345 + (var0 & 7);
            var3 = var1 + Client.field325.method2529();
            var36 = var35 + Client.field325.method2529();
            var5 = Client.field325.method2618();
            var6 = Client.field325.method2717();
            var7 = Client.field325.method2528() * 4;
            var8 = Client.field325.method2528() * 4;
            var37 = Client.field325.method2717();
            int var38 = Client.field325.method2717();
            var11 = Client.field325.method2528();
            var12 = Client.field325.method2528();
            if(var1 >= 0 && var35 >= 0 && var1 < 104 && var35 < 104 && var3 >= 0 && var36 >= 0 && var3 < 104 && var36 < 104 && var6 != '\uffff') {
               var1 = 64 + var1 * 128;
               var35 = 64 + var35 * 128;
               var3 = 64 + 128 * var3;
               var36 = 64 + var36 * 128;
               Projectile var32 = new Projectile(var6, Item.plane, var1, var35, class116.method2462(var1, var35, Item.plane) - var7, var37 + Client.gameCycle, Client.gameCycle + var38, var11, var12, var5, var8);
               var32.method89(var3, var36, class116.method2462(var3, var36, Item.plane) - var8, Client.gameCycle + var37);
               Client.projectiles.method3849(var32);
            }

         } else if(Client.packetOpcode == 97) {
            var0 = Client.field325.method2528();
            var1 = class16.field226 + (var0 >> 4 & 7);
            var35 = Client.field345 + (var0 & 7);
            var3 = Client.field325.method2717();
            var36 = Client.field325.method2528();
            var5 = Client.field325.method2717();
            if(var1 >= 0 && var35 >= 0 && var1 < 104 && var35 < 104) {
               var1 = 64 + 128 * var1;
               var35 = 128 * var35 + 64;
               class31 var42 = new class31(var3, Item.plane, var1, var35, class116.method2462(var1, var35, Item.plane) - var36, var5, Client.gameCycle);
               Client.field416.method3849(var42);
            }

         } else if(Client.packetOpcode == 43) {
            var0 = Client.field325.method2528();
            var1 = class16.field226 + (var0 >> 4 & 7);
            var35 = Client.field345 + (var0 & 7);
            var3 = Client.field325.method2717();
            var36 = Client.field325.method2717();
            var5 = Client.field325.method2717();
            if(var1 >= 0 && var35 >= 0 && var1 < 104 && var35 < 104) {
               Deque var34 = Client.groundItemDeque[Item.plane][var1][var35];
               if(null != var34) {
                  for(Item var33 = (Item)var34.method3854(); null != var33; var33 = (Item)var34.method3869()) {
                     if(var33.id == (var3 & 32767) && var36 == var33.quantity) {
                        var33.quantity = var5;
                        break;
                     }
                  }

                  class9.groundItemSpawned(var1, var35);
               }
            }

         }
      }
   }
}
