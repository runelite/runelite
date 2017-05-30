import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -157914105
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("h")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1065729155
   )
   int field855;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1819812697
   )
   int field856;
   @ObfuscatedName("v")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -795504717
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1019217989
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 85882113
   )
   int field860;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1728558441
   )
   int field861;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -713404681
   )
   int field862;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -975733459
   )
   int field863;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1890857665
   )
   int field864;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1468231345
   )
   int field865;
   @ObfuscatedName("o")
   @Export("model")
   Model model;
   @ObfuscatedName("y")
   boolean field867;
   @ObfuscatedName("kb")
   static Widget field868;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -64528641
   )
   int field869;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 435950867
   )
   int field870;
   @ObfuscatedName("s")
   boolean field871;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 750803919
   )
   @Export("team")
   int team;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2011866497
   )
   int field873;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1577385323
   )
   int field874;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1329823355
   )
   int field875;
   @ObfuscatedName("c")
   boolean field876;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1807815131
   )
   int field877;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2003369821
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("g")
   static Thread field879;
   @ObfuscatedName("i")
   @Export("name")
   String name;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-617567897"
   )
   final void method1142(Buffer var1) {
      var1.offset = 0;
      int var2 = var1.readUnsignedByte();
      this.skullIcon = var1.readByte();
      this.overheadIcon = var1.readByte();
      int var3 = -1;
      this.team = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var9 = 0; var9 < 12; ++var9) {
         var6 = var1.readUnsignedByte();
         if(var6 == 0) {
            var4[var9] = 0;
         } else {
            var7 = var1.readUnsignedByte();
            var4[var9] = var7 + (var6 << 8);
            if(var9 == 0 && var4[0] == '\uffff') {
               var3 = var1.readUnsignedShort();
               break;
            }

            if(var4[var9] >= 512) {
               int var8 = class51.getItemDefinition(var4[var9] - 512).field3491;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var5 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= PlayerComposition.field2611[var6].length) {
            var7 = 0;
         }

         var5[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field1204 = var1.readUnsignedShort();
      if(super.field1204 == '\uffff') {
         super.field1204 = -1;
      }

      super.field1205 = super.field1204;
      super.field1227 = var1.readUnsignedShort();
      if(super.field1227 == '\uffff') {
         super.field1227 = -1;
      }

      super.field1251 = var1.readUnsignedShort();
      if(super.field1251 == '\uffff') {
         super.field1251 = -1;
      }

      super.field1208 = var1.readUnsignedShort();
      if(super.field1208 == '\uffff') {
         super.field1208 = -1;
      }

      super.field1226 = var1.readUnsignedShort();
      if(super.field1226 == '\uffff') {
         super.field1226 = -1;
      }

      super.field1210 = var1.readUnsignedShort();
      if(super.field1210 == '\uffff') {
         super.field1210 = -1;
      }

      this.name = var1.readString();
      if(XGrandExchangeOffer.localPlayer == this) {
         class152.field2196 = this.name;
      }

      this.combatLevel = var1.readUnsignedByte();
      this.field855 = var1.readUnsignedShort();
      this.field867 = var1.readUnsignedByte() == 1;
      if(Client.field926 == 0 && Client.field1057 >= 2) {
         this.field867 = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method4020(var4, var5, var2 == 1, var3);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1328776050"
   )
   int method1143() {
      return this.composition != null && this.composition.field2608 != -1?class220.getNpcDefinition(this.composition.field2608).field3548:1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1208682604"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class165.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.field871 && (super.idlePoseAnimation != super.poseAnimation || var1 == null)?class165.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method4012(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2575();
            super.field1248 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field871 && super.graphic != -1 && super.field1228 != -1) {
               var4 = class203.method3752(super.graphic).method4407(super.field1228);
               if(var4 != null) {
                  var4.method2565(0, -super.field1239, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field871 && this.model != null) {
               if(Client.gameCycle >= this.field873) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field873) {
                  var4 = this.model;
                  var4.method2565(this.field863 - super.x, this.field864 - this.field862, this.field865 - super.y);
                  if(super.field1247 == 512) {
                     var4.method2546();
                     var4.method2546();
                     var4.method2546();
                  } else if(super.field1247 == 1024) {
                     var4.method2546();
                     var4.method2546();
                  } else if(super.field1247 == 1536) {
                     var4.method2546();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field1247 == 512) {
                     var4.method2546();
                  } else if(super.field1247 == 1024) {
                     var4.method2546();
                     var4.method2546();
                  } else if(super.field1247 == 1536) {
                     var4.method2546();
                     var4.method2546();
                     var4.method2546();
                  }

                  var4.method2565(super.x - this.field863, this.field862 - this.field864, super.y - this.field865);
               }
            }

            var3.field1908 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "1853448015"
   )
   final void method1145(int var1, int var2, byte var3) {
      if(super.animation != -1 && class165.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1230 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               WorldMapType2.method537(this, var1, var2, (byte)2);
            }

            this.method1164(var1, var2, var3);
         } else {
            this.method1146(var1, var2);
         }
      } else {
         this.method1146(var1, var2);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1833328514"
   )
   void method1146(int var1, int var2) {
      super.field1252 = 0;
      super.field1236 = 0;
      super.field1257 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method1143();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = super.pathY[0] * 128 + var3 * 64;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-740818925"
   )
   final boolean vmethod1721() {
      return this.composition != null;
   }

   Player() {
      this.skullIcon = -1;
      this.overheadIcon = -1;
      this.actions = new String[3];

      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field855 = 0;
      this.totalLevel = 0;
      this.field873 = 0;
      this.field871 = false;
      this.team = 0;
      this.field867 = false;
      this.field876 = false;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "1555945152"
   )
   final void method1164(int var1, int var2, byte var3) {
      if(super.field1252 < 9) {
         ++super.field1252;
      }

      for(int var4 = super.field1252; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field1255[var4] = super.field1255[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field1255[0] = var3;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;II)Z",
      garbageValue = "1872861875"
   )
   static boolean method1166(PacketBuffer var0, int var1) {
      int var2 = var0.method3470(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method3470(1) != 0) {
            method1166(var0, var1);
         }

         var3 = var0.method3470(13);
         var4 = var0.method3470(13);
         boolean var12 = var0.method3470(1) == 1;
         if(var12) {
            class96.field1495[++class96.field1487 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var11 = Client.cachedPlayers[var1] = new Player();
            var11.field875 = var1;
            if(class96.field1486[var1] != null) {
               var11.method1142(class96.field1486[var1]);
            }

            var11.field1247 = class96.field1492[var1];
            var11.interacting = class96.field1493[var1];
            var7 = class96.field1491[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var11.field1255[0] = class96.field1485[var1];
            var11.field874 = (byte)var8;
            var11.method1146(var3 + (var9 << 13) - class166.baseX, var4 + (var10 << 13) - class146.baseY);
            var11.field876 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method3470(2);
         var4 = class96.field1491[var1];
         class96.field1491[var1] = ((var3 + (var4 >> 28) & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var6;
         if(var2 == 2) {
            var3 = var0.method3470(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var6 = class96.field1491[var1];
            var7 = var4 + (var6 >> 28) & 3;
            var8 = var6 >> 14 & 255;
            var9 = var6 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class96.field1491[var1] = var9 + (var7 << 28) + (var8 << 14);
            return false;
         } else {
            var3 = var0.method3470(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var6 = var3 & 255;
            var7 = class96.field1491[var1];
            var8 = var4 + (var7 >> 28) & 3;
            var9 = (var7 >> 14) + var5 & 255;
            var10 = var7 + var6 & 255;
            class96.field1491[var1] = var10 + (var8 << 28) + (var9 << 14);
            return false;
         }
      }
   }
}
