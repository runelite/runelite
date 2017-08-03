import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1448873763
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1630886497
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("c")
   boolean field875;
   @ObfuscatedName("f")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1255441433
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -23775041
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -819076335
   )
   @Export("team")
   int team;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1374263543
   )
   int field878;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 483496225
   )
   int field860;
   @ObfuscatedName("m")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("z")
   boolean field879;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   @Export("model")
   Model model;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1865338409
   )
   int field867;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -631198395
   )
   int field856;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -773033983
   )
   int field864;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1327288889
   )
   int field869;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -59656157
   )
   int field881;
   @ObfuscatedName("d")
   @Export("name")
   String name;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 837937127
   )
   int field865;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 8274209
   )
   int field868;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1608186801
   )
   int field882;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -224878389
   )
   int field871;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -793604377
   )
   int field872;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -186167119
   )
   int field873;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1792159921
   )
   int field880;

   Player() {
      this.skullIcon = -1;
      this.overheadIcon = -1;
      this.actions = new String[3];

      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.totalLevel = 0;
      this.field878 = 0;
      this.field860 = 0;
      this.field875 = false;
      this.team = 0;
      this.hidden = false;
      this.field879 = false;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lev;",
      garbageValue = "1458652918"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class40.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.field875 || super.poseAnimation == super.idlePoseAnimation && var1 != null?null:class40.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3963(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2509();
            super.field1239 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field875 && super.graphic != -1 && super.field1227 != -1) {
               var4 = class36.getSpotAnimType(super.graphic).method4310(super.field1227);
               if(var4 != null) {
                  var4.method2520(0, -super.field1230, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field875 && this.model != null) {
               if(Client.gameCycle >= this.field860) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.field878 && Client.gameCycle < this.field860) {
                  var4 = this.model;
                  var4.method2520(this.field867 - super.x, this.field856 - this.field864, this.field869 - super.y);
                  if(super.orientation == 512) {
                     var4.method2516();
                     var4.method2516();
                     var4.method2516();
                  } else if(super.orientation == 1024) {
                     var4.method2516();
                     var4.method2516();
                  } else if(super.orientation == 1536) {
                     var4.method2516();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.orientation == 512) {
                     var4.method2516();
                  } else if(super.orientation == 1024) {
                     var4.method2516();
                     var4.method2516();
                  } else if(super.orientation == 1536) {
                     var4.method2516();
                     var4.method2516();
                     var4.method2516();
                  }

                  var4.method2520(super.x - this.field867, this.field864 - this.field856, super.y - this.field869);
               }
            }

            var3.field1902 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "42"
   )
   void method1169(int var1, int var2) {
      super.queueSize = 0;
      super.field1248 = 0;
      super.field1247 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = super.pathY[0] * 128 + var3 * 64;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "106"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?class60.getNpcDefinition(this.composition.transformedNpcId).field3535:1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "1941162815"
   )
   final void method1151(int var1, int var2, byte var3) {
      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var4 = super.queueSize; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field1246[var4] = super.field1246[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field1246[0] = var3;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "2"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "1198825698"
   )
   final void method1149(int var1, int var2, byte var3) {
      if(super.animation != -1 && class40.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1209 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               class28.method224(this, var1, var2, (byte)2);
            }

            this.method1151(var1, var2, var3);
         } else {
            this.method1169(var1, var2);
         }
      } else {
         this.method1169(var1, var2);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfw;B)V",
      garbageValue = "8"
   )
   @Export("decodeApperance")
   final void decodeApperance(Buffer var1) {
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
               int var8 = Friend.getItemDefinition(var4[var5] - 512).field3515;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= SceneTilePaint.colorsToReplace[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field1195 = var1.readUnsignedShort();
      if(super.field1195 == '\uffff') {
         super.field1195 = -1;
      }

      super.field1196 = super.field1195;
      super.field1197 = var1.readUnsignedShort();
      if(super.field1197 == '\uffff') {
         super.field1197 = -1;
      }

      super.field1205 = var1.readUnsignedShort();
      if(super.field1205 == '\uffff') {
         super.field1205 = -1;
      }

      super.field1249 = var1.readUnsignedShort();
      if(super.field1249 == '\uffff') {
         super.field1249 = -1;
      }

      super.field1200 = var1.readUnsignedShort();
      if(super.field1200 == '\uffff') {
         super.field1200 = -1;
      }

      super.field1217 = var1.readUnsignedShort();
      if(super.field1217 == '\uffff') {
         super.field1217 = -1;
      }

      this.name = var1.readString();
      if(this == class224.localPlayer) {
         class152.field2189 = this.name;
      }

      this.combatLevel = var1.readUnsignedByte();
      this.totalLevel = var1.readUnsignedShort();
      this.hidden = var1.readUnsignedByte() == 1;
      if(Client.socketType == 0 && Client.rights >= 2) {
         this.hidden = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3957(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "5"
   )
   public static boolean method1145(int var0) {
      return (var0 >> 29 & 1) != 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-8"
   )
   public static boolean method1165(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(Lhn;I)Z",
      garbageValue = "1981559819"
   )
   static final boolean method1156(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field946 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1155.method3958(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1155.method3959(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1155.method3960(false);
         }

         if(var1 == 325) {
            Client.field1155.method3960(true);
         }

         if(var1 == 326) {
            Client.secretPacketBuffer1.putOpcode(57);
            Client.field1155.method3961(Client.secretPacketBuffer1);
            return true;
         } else {
            return false;
         }
      }
   }
}
