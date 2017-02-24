import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1862281675
   )
   int field255;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 799594995
   )
   int field256;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1471329673
   )
   @Export("skullIcon")
   int skullIcon = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 508303867
   )
   @Export("overheadIcon")
   int overheadIcon = -1;
   @ObfuscatedName("kr")
   static class112 field259;
   @ObfuscatedName("n")
   @Export("actions")
   String[] actions = new String[3];
   @ObfuscatedName("g")
   boolean field261;
   @ObfuscatedName("q")
   @Export("name")
   String name;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1553783495
   )
   int field263;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1367372923
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1472385545
   )
   int field265;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -773681201
   )
   int field266;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -651274937
   )
   int field267;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1824061695
   )
   int field268;
   @ObfuscatedName("v")
   @Export("model")
   Model model;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -89259327
   )
   int field270;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2125131975
   )
   int field271;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = -674365761
   )
   @Export("clanChatCount")
   static int clanChatCount;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1787881269
   )
   int field273;
   @ObfuscatedName("w")
   boolean field274;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 589996359
   )
   @Export("team")
   int team;
   @ObfuscatedName("k")
   boolean field276;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1246520857
   )
   int field277;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 638141103
   )
   int field278;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1349267855
   )
   int field280;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1742036433
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1518103453
   )
   int field282;
   @ObfuscatedName("d")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("ew")
   static ModIcon[] field284;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = -441948781
   )
   @Export("menuHeight")
   static int menuHeight;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "887855231"
   )
   final void method226(Buffer var1) {
      var1.offset = 0;
      int var2 = var1.readUnsignedByte();
      this.skullIcon = var1.readByte();
      this.overheadIcon = var1.readByte();
      int var3 = -1;
      this.team = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.readUnsignedByte();
         if(var6 == 0) {
            var4[var5] = 0;
         } else {
            var7 = var1.readUnsignedByte();
            var4[var5] = var7 + (var6 << 8);
            if(var5 == 0 && var4[0] == '\uffff') {
               var3 = var1.readUnsignedShort();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = class103.getItemDefinition(var4[var5] - 512).field2948;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= class114.field1788[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field676 = var1.readUnsignedShort();
      if(super.field676 == '\uffff') {
         super.field676 = -1;
      }

      super.field630 = super.field676;
      super.field631 = var1.readUnsignedShort();
      if(super.field631 == '\uffff') {
         super.field631 = -1;
      }

      super.field652 = var1.readUnsignedShort();
      if(super.field652 == '\uffff') {
         super.field652 = -1;
      }

      super.field633 = var1.readUnsignedShort();
      if(super.field633 == '\uffff') {
         super.field633 = -1;
      }

      super.field634 = var1.readUnsignedShort();
      if(super.field634 == '\uffff') {
         super.field634 = -1;
      }

      super.field679 = var1.readUnsignedShort();
      if(super.field679 == '\uffff') {
         super.field679 = -1;
      }

      this.name = var1.method2868();
      if(this == class36.localPlayer) {
         class101.field1660 = this.name;
      }

      this.combatLevel = var1.readUnsignedByte();
      this.field256 = var1.readUnsignedShort();
      this.field276 = var1.readUnsignedByte() == 1;
      if(Client.field305 == 0 && Client.field472 >= 2) {
         this.field276 = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3170(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "88"
   )
   int method227() {
      return null != this.composition && this.composition.field2177 != -1?class13.getNpcDefinition(this.composition.field2177).field3010:1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "286397846"
   )
   protected final Model getModel() {
      if(null == this.composition) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class195.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.field274 || super.poseAnimation == super.idlePoseAnimation && var1 != null?null:class195.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3189(var1, super.actionFrame, var2, super.poseFrame);
         if(null == var3) {
            return null;
         } else {
            var3.method1647();
            super.field629 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field274 && super.graphic != -1 && super.field661 != -1) {
               var4 = Renderable.method1953(super.graphic).method3472(super.field661);
               if(null != var4) {
                  var4.method1627(0, -super.field664, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field274 && this.model != null) {
               if(Client.gameCycle >= this.field265) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field265) {
                  var4 = this.model;
                  var4.method1627(this.field266 - super.x, this.field267 - this.field263, this.field268 - super.y);
                  if(super.field674 == 512) {
                     var4.method1623();
                     var4.method1623();
                     var4.method1623();
                  } else if(super.field674 == 1024) {
                     var4.method1623();
                     var4.method1623();
                  } else if(super.field674 == 1536) {
                     var4.method1623();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field674 == 512) {
                     var4.method1623();
                  } else if(super.field674 == 1024) {
                     var4.method1623();
                     var4.method1623();
                  } else if(super.field674 == 1536) {
                     var4.method1623();
                     var4.method1623();
                     var4.method1623();
                  }

                  var4.method1627(super.x - this.field266, this.field263 - this.field267, super.y - this.field268);
               }
            }

            var3.field1402 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1408023298"
   )
   final void method229(int var1, int var2, byte var3) {
      if(super.field673 < 9) {
         ++super.field673;
      }

      for(int var4 = super.field673; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field680[var4] = super.field680[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field680[0] = var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-710659282"
   )
   void method230(int var1, int var2) {
      super.field673 = 0;
      super.field682 = 0;
      super.field681 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method227();
      super.x = 64 * var3 + super.pathX[0] * 128;
      super.y = super.pathY[0] * 128 + 64 * var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-848141872"
   )
   final boolean vmethod803() {
      return this.composition != null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1437809588"
   )
   public static void method236() {
      try {
         class104.field1695.method1430();

         for(int var0 = 0; var0 < class88.field1552; ++var0) {
            TextureProvider.field1222[var0].method1430();
         }

         class104.field1696.method1430();
         class104.field1692.method1430();
      } catch (Exception var2) {
         ;
      }

   }

   Player() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field256 = 0;
      this.totalLevel = 0;
      this.field265 = 0;
      this.field274 = false;
      this.team = 0;
      this.field276 = false;
      this.field261 = false;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2002684163"
   )
   public static void method242() {
      class105 var0 = class105.keyboard;
      synchronized(class105.keyboard) {
         ++class105.keyboardIdleTicks;
         class105.field1710 = class105.field1723;
         class105.field1720 = 0;
         int var1;
         if(class105.field1726 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               class105.field1713[var1] = false;
            }

            class105.field1726 = class105.field1715;
         } else {
            while(class105.field1715 != class105.field1726) {
               var1 = class105.field1714[class105.field1715];
               class105.field1715 = class105.field1715 + 1 & 127;
               if(var1 < 0) {
                  class105.field1713[~var1] = false;
               } else {
                  if(!class105.field1713[var1] && class105.field1720 < class105.field1719.length - 1) {
                     class105.field1719[++class105.field1720 - 1] = var1;
                  }

                  class105.field1713[var1] = true;
               }
            }
         }

         class105.field1723 = class105.field1722;
      }
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(IIIZB)V",
      garbageValue = "-46"
   )
   static final void method246(int var0, int var1, int var2, boolean var3) {
      if(class30.method696(var0)) {
         class99.method1995(Widget.widgets[var0], -1, var1, var2, var3);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1440273853"
   )
   final void method248(int var1, int var2, byte var3) {
      if(super.animation != -1 && class195.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field651 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Player var4 = this;
               int var5 = super.pathX[0];
               int var6 = super.pathY[0];
               int var7 = this.method227();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var8 = class159.method3094(var5, var6, this.method227(), class139.method2661(var1, var2), Client.collisionMaps[this.field277], true, Client.field586, Client.field587);
                  if(var8 >= 1) {
                     for(int var9 = 0; var9 < var8 - 1; ++var9) {
                        var4.method229(Client.field586[var9], Client.field587[var9], (byte)2);
                     }
                  }
               }
            }

            this.method229(var1, var2, var3);
         } else {
            this.method230(var1, var2);
         }
      } else {
         this.method230(var1, var2);
      }

   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-74"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.isDynamicRegion = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.isDynamicRegion) {
         var1 = Client.field350.method2869();
         var2 = Client.field350.method2867();
         var3 = Client.field350.readUnsignedShort();
         class104.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class104.xteaKeys[var4][var5] = Client.field350.method2965();
            }
         }

         class119.mapRegions = new int[var3];
         class40.field835 = new int[var3];
         class185.field2755 = new int[var3];
         class40.field828 = new byte[var3][];
         class31.field738 = new byte[var3][];
         boolean var13 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && var2 / 8 == 48) {
            var13 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (6 + var1) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (6 + var2) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class119.mapRegions[var3] = var7;
                  class40.field835[var3] = Client.field337.method3335("m" + var5 + "_" + var6);
                  class185.field2755[var3] = Client.field337.method3335("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class145.method2761(var1, var2);
      } else {
         var1 = Client.field350.method2873();
         var2 = Client.field350.readUnsignedShort();
         var3 = Client.field350.readUnsignedShort();
         Client.field350.method3072();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field350.method3095(1);
                  if(var7 == 1) {
                     Client.field367[var4][var5][var6] = Client.field350.method3095(26);
                  } else {
                     Client.field367[var4][var5][var6] = -1;
                  }
               }
            }
         }

         Client.field350.method3074();
         class104.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class104.xteaKeys[var4][var5] = Client.field350.method2965();
            }
         }

         class119.mapRegions = new int[var3];
         class40.field835 = new int[var3];
         class185.field2755 = new int[var3];
         class40.field828 = new byte[var3][];
         class31.field738 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field367[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = var9 / 8 + (var8 / 8 << 8);

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(class119.mapRegions[var11] == var10) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class119.mapRegions[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class40.field835[var3] = Client.field337.method3335("m" + var11 + "_" + var12);
                        class185.field2755[var3] = Client.field337.method3335("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class145.method2761(var2, var1);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "56"
   )
   public static int method250(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}
