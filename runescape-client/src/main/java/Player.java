import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("dl")
   static IndexData field881;
   @ObfuscatedName("rz")
   static GarbageCollectorMXBean field894;
   @ObfuscatedName("j")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1698173575
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 776777839
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("h")
   boolean field869;
   @ObfuscatedName("e")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1521661735
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1601165193
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2014180141
   )
   @Export("team")
   int team;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 741046763
   )
   int field878;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 564914401
   )
   int field884;
   @ObfuscatedName("i")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("q")
   boolean field891;
   @ObfuscatedName("t")
   @Export("model")
   Model model;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -931518813
   )
   int field889;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1942582307
   )
   int field895;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 962914297
   )
   int field879;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -600990407
   )
   int field886;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1461487155
   )
   int field880;
   @ObfuscatedName("a")
   @Export("name")
   String name;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1852660915
   )
   int field870;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -372908599
   )
   int field882;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2037636227
   )
   int field883;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1608311387
   )
   int field867;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 204801927
   )
   int field885;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1498271727
   )
   int field892;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -56967015
   )
   int field893;

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
      this.field884 = 0;
      this.field869 = false;
      this.team = 0;
      this.hidden = false;
      this.field891 = false;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "19"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class112.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.field869 && (super.idlePoseAnimation != super.poseAnimation || var1 == null)?class112.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method3940(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2542();
            super.field1235 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field869 && super.graphic != -1 && super.field1250 != -1) {
               var4 = InvType.getSpotAnimType(super.graphic).method4283(super.field1250);
               if(var4 != null) {
                  var4.method2575(0, -super.field1255, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field869 && this.model != null) {
               if(Client.gameCycle >= this.field884) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.field878 && Client.gameCycle < this.field884) {
                  var4 = this.model;
                  var4.method2575(this.field895 - super.x, this.field879 - this.field886, this.field880 - super.y);
                  if(super.orientation == 512) {
                     var4.method2506();
                     var4.method2506();
                     var4.method2506();
                  } else if(super.orientation == 1024) {
                     var4.method2506();
                     var4.method2506();
                  } else if(super.orientation == 1536) {
                     var4.method2506();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.orientation == 512) {
                     var4.method2506();
                  } else if(super.orientation == 1024) {
                     var4.method2506();
                     var4.method2506();
                  } else if(super.orientation == 1536) {
                     var4.method2506();
                     var4.method2506();
                     var4.method2506();
                  }

                  var4.method2575(super.x - this.field895, this.field886 - this.field879, super.y - this.field880);
               }
            }

            var3.field1975 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-521145251"
   )
   void method1116(int var1, int var2) {
      super.queueSize = 0;
      super.field1273 = 0;
      super.field1272 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = var3 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-463646530"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?class224.getNpcDefinition(this.composition.transformedNpcId).field3557:1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-659995332"
   )
   final void method1114(int var1, int var2, byte var3) {
      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var4 = super.queueSize; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field1239[var4] = super.field1239[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field1239[0] = var3;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-42"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1040101682"
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
               int var8 = class83.getItemDefinition(var4[var5] - 512).field3536;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= class203.colorsToReplace[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field1220 = var1.readUnsignedShort();
      if(super.field1220 == '\uffff') {
         super.field1220 = -1;
      }

      super.field1244 = super.field1220;
      super.field1251 = var1.readUnsignedShort();
      if(super.field1251 == '\uffff') {
         super.field1251 = -1;
      }

      super.field1223 = var1.readUnsignedShort();
      if(super.field1223 == '\uffff') {
         super.field1223 = -1;
      }

      super.field1224 = var1.readUnsignedShort();
      if(super.field1224 == '\uffff') {
         super.field1224 = -1;
      }

      super.field1225 = var1.readUnsignedShort();
      if(super.field1225 == '\uffff') {
         super.field1225 = -1;
      }

      super.field1221 = var1.readUnsignedShort();
      if(super.field1221 == '\uffff') {
         super.field1221 = -1;
      }

      this.name = var1.readString();
      if(this == Script.localPlayer) {
         class152.field2208 = this.name;
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

      this.composition.method3934(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "-21"
   )
   final void method1115(int var1, int var2, byte var3) {
      if(super.animation != -1 && class112.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1242 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Player var4 = this;
               int var5 = super.pathX[0];
               int var6 = super.pathY[0];
               int var7 = this.getSize();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var9 = this.getSize();
                  class163 var10 = RSCanvas.method796(var1, var2);
                  CollisionData var11 = Client.collisionMaps[this.field889];
                  int[] var12 = Client.field1185;
                  int[] var13 = Client.field1091;
                  int var14 = 0;

                  label738:
                  while(true) {
                     int var15;
                     if(var14 >= 128) {
                        int var16;
                        int var17;
                        byte var19;
                        int var20;
                        int var21;
                        int var23;
                        int var25;
                        int var26;
                        int var27;
                        int var28;
                        boolean var34;
                        int var36;
                        int var37;
                        int var39;
                        if(var9 == 1) {
                           var34 = class25.method173(var5, var6, var10, var11);
                        } else {
                           byte var18;
                           byte var22;
                           int[][] var33;
                           boolean var35;
                           if(var9 == 2) {
                              var16 = var5;
                              var17 = var6;
                              var18 = 64;
                              var19 = 64;
                              var20 = var5 - var18;
                              var21 = var6 - var19;
                              class162.field2304[var18][var19] = 99;
                              class162.field2299[var18][var19] = 0;
                              var22 = 0;
                              var23 = 0;
                              class162.field2301[var22] = var5;
                              var39 = var22 + 1;
                              class162.field2303[var22] = var6;
                              var33 = var11.flags;

                              while(true) {
                                 if(var23 == var39) {
                                    class162.field2302 = var16;
                                    FaceNormal.field2134 = var17;
                                    var35 = false;
                                    break;
                                 }

                                 var16 = class162.field2301[var23];
                                 var17 = class162.field2303[var23];
                                 var23 = var23 + 1 & 4095;
                                 var36 = var16 - var20;
                                 var37 = var17 - var21;
                                 var25 = var16 - var11.x;
                                 var26 = var17 - var11.y;
                                 if(var10.vmethod3052(2, var16, var17, var11)) {
                                    class162.field2302 = var16;
                                    FaceNormal.field2134 = var17;
                                    var35 = true;
                                    break;
                                 }

                                 var27 = class162.field2299[var36][var37] + 1;
                                 if(var36 > 0 && class162.field2304[var36 - 1][var37] == 0 && (var33[var25 - 1][var26] & 19136782) == 0 && (var33[var25 - 1][var26 + 1] & 19136824) == 0) {
                                    class162.field2301[var39] = var16 - 1;
                                    class162.field2303[var39] = var17;
                                    var39 = var39 + 1 & 4095;
                                    class162.field2304[var36 - 1][var37] = 2;
                                    class162.field2299[var36 - 1][var37] = var27;
                                 }

                                 if(var36 < 126 && class162.field2304[var36 + 1][var37] == 0 && (var33[var25 + 2][var26] & 19136899) == 0 && (var33[var25 + 2][var26 + 1] & 19136992) == 0) {
                                    class162.field2301[var39] = var16 + 1;
                                    class162.field2303[var39] = var17;
                                    var39 = var39 + 1 & 4095;
                                    class162.field2304[var36 + 1][var37] = 8;
                                    class162.field2299[var36 + 1][var37] = var27;
                                 }

                                 if(var37 > 0 && class162.field2304[var36][var37 - 1] == 0 && (var33[var25][var26 - 1] & 19136782) == 0 && (var33[var25 + 1][var26 - 1] & 19136899) == 0) {
                                    class162.field2301[var39] = var16;
                                    class162.field2303[var39] = var17 - 1;
                                    var39 = var39 + 1 & 4095;
                                    class162.field2304[var36][var37 - 1] = 1;
                                    class162.field2299[var36][var37 - 1] = var27;
                                 }

                                 if(var37 < 126 && class162.field2304[var36][var37 + 1] == 0 && (var33[var25][var26 + 2] & 19136824) == 0 && (var33[var25 + 1][var26 + 2] & 19136992) == 0) {
                                    class162.field2301[var39] = var16;
                                    class162.field2303[var39] = var17 + 1;
                                    var39 = var39 + 1 & 4095;
                                    class162.field2304[var36][var37 + 1] = 4;
                                    class162.field2299[var36][var37 + 1] = var27;
                                 }

                                 if(var36 > 0 && var37 > 0 && class162.field2304[var36 - 1][var37 - 1] == 0 && (var33[var25 - 1][var26] & 19136830) == 0 && (var33[var25 - 1][var26 - 1] & 19136782) == 0 && (var33[var25][var26 - 1] & 19136911) == 0) {
                                    class162.field2301[var39] = var16 - 1;
                                    class162.field2303[var39] = var17 - 1;
                                    var39 = var39 + 1 & 4095;
                                    class162.field2304[var36 - 1][var37 - 1] = 3;
                                    class162.field2299[var36 - 1][var37 - 1] = var27;
                                 }

                                 if(var36 < 126 && var37 > 0 && class162.field2304[var36 + 1][var37 - 1] == 0 && (var33[var25 + 1][var26 - 1] & 19136911) == 0 && (var33[var25 + 2][var26 - 1] & 19136899) == 0 && (var33[var25 + 2][var26] & 19136995) == 0) {
                                    class162.field2301[var39] = var16 + 1;
                                    class162.field2303[var39] = var17 - 1;
                                    var39 = var39 + 1 & 4095;
                                    class162.field2304[var36 + 1][var37 - 1] = 9;
                                    class162.field2299[var36 + 1][var37 - 1] = var27;
                                 }

                                 if(var36 > 0 && var37 < 126 && class162.field2304[var36 - 1][var37 + 1] == 0 && (var33[var25 - 1][var26 + 1] & 19136830) == 0 && (var33[var25 - 1][var26 + 2] & 19136824) == 0 && (var33[var25][var26 + 2] & 19137016) == 0) {
                                    class162.field2301[var39] = var16 - 1;
                                    class162.field2303[var39] = var17 + 1;
                                    var39 = var39 + 1 & 4095;
                                    class162.field2304[var36 - 1][var37 + 1] = 6;
                                    class162.field2299[var36 - 1][var37 + 1] = var27;
                                 }

                                 if(var36 < 126 && var37 < 126 && class162.field2304[1 + var36][var37 + 1] == 0 && (var33[var25 + 1][var26 + 2] & 19137016) == 0 && (var33[var25 + 2][var26 + 2] & 19136992) == 0 && (var33[var25 + 2][var26 + 1] & 19136995) == 0) {
                                    class162.field2301[var39] = var16 + 1;
                                    class162.field2303[var39] = var17 + 1;
                                    var39 = var39 + 1 & 4095;
                                    class162.field2304[var36 + 1][var37 + 1] = 12;
                                    class162.field2299[var36 + 1][var37 + 1] = var27;
                                 }
                              }

                              var34 = var35;
                           } else {
                              var16 = var5;
                              var17 = var6;
                              var18 = 64;
                              var19 = 64;
                              var20 = var5 - var18;
                              var21 = var6 - var19;
                              class162.field2304[var18][var19] = 99;
                              class162.field2299[var18][var19] = 0;
                              var22 = 0;
                              var23 = 0;
                              class162.field2301[var22] = var5;
                              var39 = var22 + 1;
                              class162.field2303[var22] = var6;
                              var33 = var11.flags;

                              label716:
                              while(true) {
                                 label714:
                                 while(true) {
                                    do {
                                       do {
                                          do {
                                             label691:
                                             do {
                                                if(var23 == var39) {
                                                   class162.field2302 = var16;
                                                   FaceNormal.field2134 = var17;
                                                   var35 = false;
                                                   break label716;
                                                }

                                                var16 = class162.field2301[var23];
                                                var17 = class162.field2303[var23];
                                                var23 = var23 + 1 & 4095;
                                                var36 = var16 - var20;
                                                var37 = var17 - var21;
                                                var25 = var16 - var11.x;
                                                var26 = var17 - var11.y;
                                                if(var10.vmethod3052(var9, var16, var17, var11)) {
                                                   class162.field2302 = var16;
                                                   FaceNormal.field2134 = var17;
                                                   var35 = true;
                                                   break label716;
                                                }

                                                var27 = class162.field2299[var36][var37] + 1;
                                                if(var36 > 0 && class162.field2304[var36 - 1][var37] == 0 && (var33[var25 - 1][var26] & 19136782) == 0 && (var33[var25 - 1][var26 + var9 - 1] & 19136824) == 0) {
                                                   var28 = 1;

                                                   while(true) {
                                                      if(var28 >= var9 - 1) {
                                                         class162.field2301[var39] = var16 - 1;
                                                         class162.field2303[var39] = var17;
                                                         var39 = var39 + 1 & 4095;
                                                         class162.field2304[var36 - 1][var37] = 2;
                                                         class162.field2299[var36 - 1][var37] = var27;
                                                         break;
                                                      }

                                                      if((var33[var25 - 1][var26 + var28] & 19136830) != 0) {
                                                         break;
                                                      }

                                                      ++var28;
                                                   }
                                                }

                                                if(var36 < 128 - var9 && class162.field2304[var36 + 1][var37] == 0 && (var33[var25 + var9][var26] & 19136899) == 0 && (var33[var9 + var25][var26 + var9 - 1] & 19136992) == 0) {
                                                   var28 = 1;

                                                   while(true) {
                                                      if(var28 >= var9 - 1) {
                                                         class162.field2301[var39] = var16 + 1;
                                                         class162.field2303[var39] = var17;
                                                         var39 = var39 + 1 & 4095;
                                                         class162.field2304[var36 + 1][var37] = 8;
                                                         class162.field2299[var36 + 1][var37] = var27;
                                                         break;
                                                      }

                                                      if((var33[var25 + var9][var28 + var26] & 19136995) != 0) {
                                                         break;
                                                      }

                                                      ++var28;
                                                   }
                                                }

                                                if(var37 > 0 && class162.field2304[var36][var37 - 1] == 0 && (var33[var25][var26 - 1] & 19136782) == 0 && (var33[var9 + var25 - 1][var26 - 1] & 19136899) == 0) {
                                                   var28 = 1;

                                                   while(true) {
                                                      if(var28 >= var9 - 1) {
                                                         class162.field2301[var39] = var16;
                                                         class162.field2303[var39] = var17 - 1;
                                                         var39 = var39 + 1 & 4095;
                                                         class162.field2304[var36][var37 - 1] = 1;
                                                         class162.field2299[var36][var37 - 1] = var27;
                                                         break;
                                                      }

                                                      if((var33[var25 + var28][var26 - 1] & 19136911) != 0) {
                                                         break;
                                                      }

                                                      ++var28;
                                                   }
                                                }

                                                if(var37 < 128 - var9 && class162.field2304[var36][var37 + 1] == 0 && (var33[var25][var26 + var9] & 19136824) == 0 && (var33[var25 + var9 - 1][var9 + var26] & 19136992) == 0) {
                                                   var28 = 1;

                                                   while(true) {
                                                      if(var28 >= var9 - 1) {
                                                         class162.field2301[var39] = var16;
                                                         class162.field2303[var39] = var17 + 1;
                                                         var39 = var39 + 1 & 4095;
                                                         class162.field2304[var36][var37 + 1] = 4;
                                                         class162.field2299[var36][var37 + 1] = var27;
                                                         break;
                                                      }

                                                      if((var33[var25 + var28][var9 + var26] & 19137016) != 0) {
                                                         break;
                                                      }

                                                      ++var28;
                                                   }
                                                }

                                                if(var36 > 0 && var37 > 0 && class162.field2304[var36 - 1][var37 - 1] == 0 && (var33[var25 - 1][var26 - 1] & 19136782) == 0) {
                                                   var28 = 1;

                                                   while(true) {
                                                      if(var28 >= var9) {
                                                         class162.field2301[var39] = var16 - 1;
                                                         class162.field2303[var39] = var17 - 1;
                                                         var39 = var39 + 1 & 4095;
                                                         class162.field2304[var36 - 1][var37 - 1] = 3;
                                                         class162.field2299[var36 - 1][var37 - 1] = var27;
                                                         break;
                                                      }

                                                      if((var33[var25 - 1][var26 - 1 + var28] & 19136830) != 0 || (var33[var25 - 1 + var28][var26 - 1] & 19136911) != 0) {
                                                         break;
                                                      }

                                                      ++var28;
                                                   }
                                                }

                                                if(var36 < 128 - var9 && var37 > 0 && class162.field2304[var36 + 1][var37 - 1] == 0 && (var33[var9 + var25][var26 - 1] & 19136899) == 0) {
                                                   var28 = 1;

                                                   while(true) {
                                                      if(var28 >= var9) {
                                                         class162.field2301[var39] = var16 + 1;
                                                         class162.field2303[var39] = var17 - 1;
                                                         var39 = var39 + 1 & 4095;
                                                         class162.field2304[var36 + 1][var37 - 1] = 9;
                                                         class162.field2299[var36 + 1][var37 - 1] = var27;
                                                         break;
                                                      }

                                                      if((var33[var9 + var25][var26 - 1 + var28] & 19136995) != 0 || (var33[var25 + var28][var26 - 1] & 19136911) != 0) {
                                                         break;
                                                      }

                                                      ++var28;
                                                   }
                                                }

                                                if(var36 > 0 && var37 < 128 - var9 && class162.field2304[var36 - 1][var37 + 1] == 0 && (var33[var25 - 1][var26 + var9] & 19136824) == 0) {
                                                   for(var28 = 1; var28 < var9; ++var28) {
                                                      if((var33[var25 - 1][var26 + var28] & 19136830) != 0 || (var33[var25 - 1 + var28][var9 + var26] & 19137016) != 0) {
                                                         continue label691;
                                                      }
                                                   }

                                                   class162.field2301[var39] = var16 - 1;
                                                   class162.field2303[var39] = var17 + 1;
                                                   var39 = var39 + 1 & 4095;
                                                   class162.field2304[var36 - 1][var37 + 1] = 6;
                                                   class162.field2299[var36 - 1][var37 + 1] = var27;
                                                }
                                             } while(var36 >= 128 - var9);
                                          } while(var37 >= 128 - var9);
                                       } while(class162.field2304[1 + var36][var37 + 1] != 0);
                                    } while((var33[var9 + var25][var9 + var26] & 19136992) != 0);

                                    for(var28 = 1; var28 < var9; ++var28) {
                                       if((var33[var28 + var25][var26 + var9] & 19137016) != 0 || (var33[var9 + var25][var26 + var28] & 19136995) != 0) {
                                          continue label714;
                                       }
                                    }

                                    class162.field2301[var39] = var16 + 1;
                                    class162.field2303[var39] = var17 + 1;
                                    var39 = var39 + 1 & 4095;
                                    class162.field2304[var36 + 1][var37 + 1] = 12;
                                    class162.field2299[var36 + 1][var37 + 1] = var27;
                                 }
                              }

                              var34 = var35;
                           }
                        }

                        int var8;
                        label779: {
                           var15 = var5 - 64;
                           var16 = var6 - 64;
                           var17 = class162.field2302;
                           var36 = FaceNormal.field2134;
                           if(!var34) {
                              var37 = Integer.MAX_VALUE;
                              var20 = Integer.MAX_VALUE;
                              byte var38 = 10;
                              var39 = var10.field2308;
                              var23 = var10.field2311;
                              int var24 = var10.field2307;
                              var25 = var10.field2306;

                              for(var26 = var39 - var38; var26 <= var38 + var39; ++var26) {
                                 for(var27 = var23 - var38; var27 <= var23 + var38; ++var27) {
                                    var28 = var26 - var15;
                                    int var29 = var27 - var16;
                                    if(var28 >= 0 && var29 >= 0 && var28 < 128 && var29 < 128 && class162.field2299[var28][var29] < 100) {
                                       int var30 = 0;
                                       if(var26 < var39) {
                                          var30 = var39 - var26;
                                       } else if(var26 > var24 + var39 - 1) {
                                          var30 = var26 - (var39 + var24 - 1);
                                       }

                                       int var31 = 0;
                                       if(var27 < var23) {
                                          var31 = var23 - var27;
                                       } else if(var27 > var23 + var25 - 1) {
                                          var31 = var27 - (var23 + var25 - 1);
                                       }

                                       int var32 = var30 * var30 + var31 * var31;
                                       if(var32 < var37 || var37 == var32 && class162.field2299[var28][var29] < var20) {
                                          var37 = var32;
                                          var20 = class162.field2299[var28][var29];
                                          var17 = var26;
                                          var36 = var27;
                                       }
                                    }
                                 }
                              }

                              if(var37 == Integer.MAX_VALUE) {
                                 var8 = -1;
                                 break label779;
                              }
                           }

                           if(var5 == var17 && var36 == var6) {
                              var8 = 0;
                           } else {
                              var19 = 0;
                              class162.field2301[var19] = var17;
                              var37 = var19 + 1;
                              class162.field2303[var19] = var36;

                              for(var20 = var21 = class162.field2304[var17 - var15][var36 - var16]; var17 != var5 || var6 != var36; var20 = class162.field2304[var17 - var15][var36 - var16]) {
                                 if(var20 != var21) {
                                    var21 = var20;
                                    class162.field2301[var37] = var17;
                                    class162.field2303[var37++] = var36;
                                 }

                                 if((var20 & 2) != 0) {
                                    ++var17;
                                 } else if((var20 & 8) != 0) {
                                    --var17;
                                 }

                                 if((var20 & 1) != 0) {
                                    ++var36;
                                 } else if((var20 & 4) != 0) {
                                    --var36;
                                 }
                              }

                              var39 = 0;

                              while(var37-- > 0) {
                                 var12[var39] = class162.field2301[var37];
                                 var13[var39++] = class162.field2303[var37];
                                 if(var39 >= var12.length) {
                                    break;
                                 }
                              }

                              var8 = var39;
                           }
                        }

                        var14 = var8;
                        if(var8 < 1) {
                           break;
                        }

                        var15 = 0;

                        while(true) {
                           if(var15 >= var14 - 1) {
                              break label738;
                           }

                           var4.method1114(Client.field1185[var15], Client.field1091[var15], (byte)2);
                           ++var15;
                        }
                     }

                     for(var15 = 0; var15 < 128; ++var15) {
                        class162.field2304[var14][var15] = 0;
                        class162.field2299[var14][var15] = 99999999;
                     }

                     ++var14;
                  }
               }
            }

            this.method1114(var1, var2, var3);
         } else {
            this.method1116(var1, var2);
         }
      } else {
         this.method1116(var1, var2);
      }

   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "120"
   )
   static int method1119() {
      return Client.isResized?2:1;
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   static final void method1136() {
      int var0 = class61.menuX;
      int var1 = class10.menuY;
      int var2 = class10.menuWidth;
      int var3 = class23.menuHeight;
      int var4 = 6116423;
      Rasterizer2D.method4921(var0, var1, var2, var3, var4);
      Rasterizer2D.method4921(var0 + 1, var1 + 1, var2 - 2, 16, 0);
      Rasterizer2D.drawRectangle(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
      class21.field338.method4725("Choose Option", var0 + 3, var1 + 14, var4, -1);
      int var5 = MouseInput.field722;
      int var6 = MouseInput.field723;

      int var7;
      int var8;
      int var9;
      for(var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         var8 = var1 + 31 + (Client.menuOptionCount - 1 - var7) * 15;
         var9 = 16777215;
         if(var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < var8 + 3) {
            var9 = 16776960;
         }

         Font var10 = class21.field338;
         String var11;
         if(var7 < 0) {
            var11 = "";
         } else if(Client.menuTargets[var7].length() > 0) {
            var11 = Client.menuOptions[var7] + " " + Client.menuTargets[var7];
         } else {
            var11 = Client.menuOptions[var7];
         }

         var10.method4725(var11, var0 + 3, var8, var9, 0);
      }

      var7 = class61.menuX;
      var8 = class10.menuY;
      var9 = class10.menuWidth;
      int var12 = class23.menuHeight;

      for(int var13 = 0; var13 < Client.field1006; ++var13) {
         if(Client.widgetBoundsWidth[var13] + Client.widgetPositionX[var13] > var7 && Client.widgetPositionX[var13] < var7 + var9 && Client.widgetBoundsHeight[var13] + Client.widgetPositionY[var13] > var8 && Client.widgetPositionY[var13] < var8 + var12) {
            Client.field1112[var13] = true;
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LHuffman;I)V",
      garbageValue = "-16711936"
   )
   public static void method1137(Huffman var0) {
      class265.field3657 = var0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1561905188"
   )
   @Export("hsl24to16")
   static final int hsl24to16(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var0 / 4 << 10) + (var1 / 32 << 7) + var2 / 2;
      return var3;
   }
}
