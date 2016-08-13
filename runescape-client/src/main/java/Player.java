import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1274859667
   )
   int field30 = -1;
   @ObfuscatedName("g")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 392241571
   )
   int field32;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 819523527
   )
   int field33 = -1;
   @ObfuscatedName("o")
   @Export("model")
   Model model;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 141852359
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2035540803
   )
   int field38;
   @ObfuscatedName("v")
   boolean field39;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -555241161
   )
   int field40;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1383654013
   )
   int field41;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 270967865
   )
   int field42;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 609066455
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1689323681
   )
   @Export("team")
   int team;
   @ObfuscatedName("a")
   boolean field45;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 301986747
   )
   int field46;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 743291311
   )
   int field47;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1972707463
   )
   int field48;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1512373433
   )
   int field49;
   @ObfuscatedName("s")
   @Export("actions")
   String[] actions = new String[3];
   @ObfuscatedName("x")
   boolean field51;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -660823467
   )
   int field52;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1061991469
   )
   int field53;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1689800831
   )
   int field54;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -721741739
   )
   int field55;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 751539513
   )
   int field56;
   @ObfuscatedName("ej")
   static SpritePixels[] field57;
   @ObfuscatedName("l")
   @Export("name")
   String name;

   Player() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field54 = 0;
      this.totalLevel = 0;
      this.field40 = 0;
      this.field39 = false;
      this.team = 0;
      this.field51 = false;
      this.field45 = false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1896549502"
   )
   int method15() {
      return this.composition != null && this.composition.field2972 != -1?class16.getNpcDefinition(this.composition.field2972).field913:1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "503322838"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class22.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.field39 && (super.idlePoseAnimation != super.poseAnimation || var1 == null)?class22.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method3667(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2402();
            super.field837 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field39 && super.graphic != -1 && super.field890 != -1) {
               var4 = class110.method2488(super.graphic).method952(super.field890);
               if(var4 != null) {
                  var4.method2412(0, -super.field872, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field39 && null != this.model) {
               if(Client.gameCycle >= this.field40) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field40) {
                  var4 = this.model;
                  var4.method2412(this.field41 - super.x, this.field42 - this.field38, this.field32 - super.y);
                  if(super.field882 == 512) {
                     var4.method2455();
                     var4.method2455();
                     var4.method2455();
                  } else if(super.field882 == 1024) {
                     var4.method2455();
                     var4.method2455();
                  } else if(super.field882 == 1536) {
                     var4.method2455();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field882 == 512) {
                     var4.method2455();
                  } else if(super.field882 == 1024) {
                     var4.method2455();
                     var4.method2455();
                  } else if(super.field882 == 1536) {
                     var4.method2455();
                     var4.method2455();
                     var4.method2455();
                  }

                  var4.method2412(super.x - this.field41, this.field38 - this.field42, super.y - this.field32);
               }
            }

            var3.field1892 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "256653882"
   )
   final void method18(int var1, int var2, byte var3) {
      if(super.animation != -1 && class22.getAnimation(super.animation).field1028 == 1) {
         super.animation = -1;
      }

      super.field859 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Player var4 = this;
               int var5 = super.pathX[0];
               int var6 = super.pathY[0];
               int var7 = this.method15();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var8 = class45.method967(var5, var6, this.method15(), class164.method3333(var1, var2), Client.collisionMaps[this.field52], true, Client.field574, Client.field575);
                  if(var8 >= 1) {
                     for(int var9 = 0; var9 < var8 - 1; ++var9) {
                        var4.method20(Client.field574[var9], Client.field575[var9], (byte)2);
                     }
                  }
               }
            }

            this.method20(var1, var2, var3);
         } else {
            this.method19(var1, var2);
         }
      } else {
         this.method19(var1, var2);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1575812819"
   )
   void method19(int var1, int var2) {
      super.field849 = 0;
      super.field839 = 0;
      super.field889 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method15();
      super.x = 64 * var3 + super.pathX[0] * 128;
      super.y = 128 * super.pathY[0] + var3 * 64;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIBS)V",
      garbageValue = "502"
   )
   final void method20(int var1, int var2, byte var3) {
      if(super.field849 < 9) {
         ++super.field849;
      }

      for(int var4 = super.field849; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field888[var4] = super.field888[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field888[0] = var3;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-26697968"
   )
   static void method28(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class79.field1466 = var1.method2635();
      class79.field1457 = new int[class79.field1466];
      class180.field2962 = new int[class79.field1466];
      class192.field3106 = new int[class79.field1466];
      class79.field1458 = new int[class79.field1466];
      class145.field2236 = new byte[class79.field1466][];
      var1.offset = var0.length - 7 - class79.field1466 * 8;
      class79.field1454 = var1.method2635();
      class79.field1456 = var1.method2635();
      int var2 = (var1.method2633() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class79.field1466; ++var3) {
         class79.field1457[var3] = var1.method2635();
      }

      for(var3 = 0; var3 < class79.field1466; ++var3) {
         class180.field2962[var3] = var1.method2635();
      }

      for(var3 = 0; var3 < class79.field1466; ++var3) {
         class192.field3106[var3] = var1.method2635();
      }

      for(var3 = 0; var3 < class79.field1466; ++var3) {
         class79.field1458[var3] = var1.method2635();
      }

      var1.offset = var0.length - 7 - class79.field1466 * 8 - (var2 - 1) * 3;
      class79.field1459 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class79.field1459[var3] = var1.method2637();
         if(class79.field1459[var3] == 0) {
            class79.field1459[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class79.field1466; ++var3) {
         int var4 = class192.field3106[var3];
         int var5 = class79.field1458[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         class145.field2236[var3] = var7;
         int var8 = var1.method2633();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.method2634();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var10 * var4] = var1.method2634();
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "8"
   )
   final void method29(Buffer var1) {
      var1.offset = 0;
      int var2 = var1.method2633();
      this.field30 = var1.method2634();
      this.field33 = var1.method2634();
      int var3 = -1;
      this.team = 0;
      int[] var4 = new int[12];

      int var5;
      int var6;
      for(int var7 = 0; var7 < 12; ++var7) {
         var5 = var1.method2633();
         if(var5 == 0) {
            var4[var7] = 0;
         } else {
            var6 = var1.method2633();
            var4[var7] = (var5 << 8) + var6;
            if(var7 == 0 && var4[0] == '\uffff') {
               var3 = var1.method2635();
               break;
            }

            if(var4[var7] >= 512) {
               int var8 = class1.getItemDefinition(var4[var7] - 512).field1189;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var5 = 0; var5 < 5; ++var5) {
         var6 = var1.method2633();
         if(var6 < 0 || var6 >= class175.field2794[var5].length) {
            var6 = 0;
         }

         var9[var5] = var6;
      }

      super.idlePoseAnimation = var1.method2635();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field866 = var1.method2635();
      if(super.field866 == '\uffff') {
         super.field866 = -1;
      }

      super.field853 = super.field866;
      super.field879 = var1.method2635();
      if(super.field879 == '\uffff') {
         super.field879 = -1;
      }

      super.field840 = var1.method2635();
      if(super.field840 == '\uffff') {
         super.field840 = -1;
      }

      super.field841 = var1.method2635();
      if(super.field841 == '\uffff') {
         super.field841 = -1;
      }

      super.field831 = var1.method2635();
      if(super.field831 == '\uffff') {
         super.field831 = -1;
      }

      super.field843 = var1.method2635();
      if(super.field843 == '\uffff') {
         super.field843 = -1;
      }

      this.name = var1.method2663();
      if(WidgetNode.localPlayer == this) {
         class151.field2287 = this.name;
      }

      this.combatLevel = var1.method2633();
      this.field54 = var1.method2635();
      this.field51 = var1.method2633() == 1;
      if(Client.field297 == 0 && Client.field460 >= 2) {
         this.field51 = false;
      }

      if(null == this.composition) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3634(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1252680142"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.field355 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.field355) {
         var1 = Client.field339.method2635();
         var2 = Client.field339.method2749();
         var3 = Client.field339.method2635();
         GameObject.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               GameObject.xteaKeys[var4][var5] = Client.field339.method2620();
            }
         }

         Ignore.mapRegions = new int[var3];
         class119.field2037 = new int[var3];
         WidgetNode.field66 = new int[var3];
         class127.field2086 = new byte[var3][];
         class109.field1944 = new byte[var3][];
         boolean var8 = false;
         if((var2 / 8 == 48 || var2 / 8 == 49) && var1 / 8 == 48) {
            var8 = true;
         }

         if(var2 / 8 == 48 && var1 / 8 == 148) {
            var8 = true;
         }

         var3 = 0;

         for(var5 = (var2 - 6) / 8; var5 <= (6 + var2) / 8; ++var5) {
            for(var6 = (var1 - 6) / 8; var6 <= (var1 + 6) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var8 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  Ignore.mapRegions[var3] = var7;
                  class119.field2037[var3] = BufferProvider.field1476.method3410("m" + var5 + "_" + var6);
                  WidgetNode.field66[var3] = BufferProvider.field1476.method3410("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class92.method2161(var2, var1);
      } else {
         var1 = Client.field339.method2749();
         var2 = Client.field339.method2803();
         var3 = Client.field339.method2635();
         Client.field339.method2899();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field339.method2907(1);
                  if(var7 == 1) {
                     Client.field356[var4][var5][var6] = Client.field339.method2907(26);
                  } else {
                     Client.field356[var4][var5][var6] = -1;
                  }
               }
            }
         }

         Client.field339.method2900();
         GameObject.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               GameObject.xteaKeys[var4][var5] = Client.field339.method2620();
            }
         }

         Ignore.mapRegions = new int[var3];
         class119.field2037 = new int[var3];
         WidgetNode.field66 = new int[var3];
         class127.field2086 = new byte[var3][];
         class109.field1944 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field356[var4][var5][var6];
                  if(var7 != -1) {
                     int var13 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = (var13 / 8 << 8) + var9 / 8;

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(var10 == Ignore.mapRegions[var11]) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        Ignore.mapRegions[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class119.field2037[var3] = BufferProvider.field1476.method3410("m" + var11 + "_" + var12);
                        WidgetNode.field66[var3] = BufferProvider.field1476.method3410("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class92.method2161(var2, var1);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "76"
   )
   final boolean vmethod794() {
      return null != this.composition;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "417329951"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(null == class117.worldServersDownload) {
            class117.worldServersDownload = new class18(class125.field2070, new URL(XItemContainer.field223));
         } else {
            byte[] var0 = class117.worldServersDownload.method212();
            if(var0 != null) {
               Buffer var1 = new Buffer(var0);
               World.field663 = var1.method2635();
               World.worldList = new World[World.field663];

               World var2;
               for(int var3 = 0; var3 < World.field663; var2.index = var3++) {
                  var2 = World.worldList[var3] = new World();
                  var2.id = var1.method2635();
                  var2.mask = var1.method2620();
                  var2.address = var1.method2663();
                  var2.activity = var1.method2663();
                  var2.location = var1.method2633();
                  var2.playerCount = var1.method2636();
               }

               class9.method133(World.worldList, 0, World.worldList.length - 1, World.field666, World.field665);
               class117.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class117.worldServersDownload = null;
      }

      return false;
   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(LWidget;B)I",
      garbageValue = "55"
   )
   static int method39(Widget var0) {
      class204 var1 = (class204)Client.widgetFlags.method3936((long)var0.index + ((long)var0.id << 32));
      return null != var1?var1.field3159:var0.field2872;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-767246248"
   )
   public static int method41() {
      return class140.keyboardIdleTicks;
   }
}
