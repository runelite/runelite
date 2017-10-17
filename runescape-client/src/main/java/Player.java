import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("bw")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1861618247
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1770454463
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("h")
   boolean field901;
   @ObfuscatedName("s")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1653252197
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1136569905
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 436753495
   )
   @Export("team")
   int team;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 485041957
   )
   int field891;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2043356683
   )
   int field892;
   @ObfuscatedName("z")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("n")
   boolean field887;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   @Export("model")
   Model model;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 293034689
   )
   int field906;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 571202135
   )
   int field897;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 136505983
   )
   int field890;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 752451027
   )
   int field884;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 649046179
   )
   int field894;
   @ObfuscatedName("d")
   @Export("name")
   String name;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1074352679
   )
   int field886;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2042253031
   )
   int field907;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -668386405
   )
   int field908;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1807987373
   )
   int field904;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1664490921
   )
   int field898;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1316075915
   )
   int field883;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1958293451
   )
   int field900;

   Player() {
      this.skullIcon = -1;
      this.overheadIcon = -1;
      this.actions = new String[3];

      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.totalLevel = 0;
      this.field891 = 0;
      this.field892 = 0;
      this.field901 = false;
      this.team = 0;
      this.hidden = false;
      this.field887 = false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Leb;",
      garbageValue = "1172124455"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class204.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.field901 || super.idlePoseAnimation == super.poseAnimation && var1 != null?null:class204.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method4072(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2594();
            super.field1257 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field901 && super.graphic != -1 && super.field1249 != -1) {
               var4 = class155.getSpotAnimType(super.graphic).method4436(super.field1249);
               if(var4 != null) {
                  var4.method2665(0, -super.field1214, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field901 && this.model != null) {
               if(Client.gameCycle >= this.field892) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.field891 && Client.gameCycle < this.field892) {
                  var4 = this.model;
                  var4.method2665(this.field906 - super.x, this.field897 - this.field890, this.field884 - super.y);
                  if(super.orientation == 512) {
                     var4.method2656();
                     var4.method2656();
                     var4.method2656();
                  } else if(super.orientation == 1024) {
                     var4.method2656();
                     var4.method2656();
                  } else if(super.orientation == 1536) {
                     var4.method2656();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.orientation == 512) {
                     var4.method2656();
                  } else if(super.orientation == 1024) {
                     var4.method2656();
                     var4.method2656();
                  } else if(super.orientation == 1536) {
                     var4.method2656();
                     var4.method2656();
                     var4.method2656();
                  }

                  var4.method2665(super.x - this.field906, this.field890 - this.field897, super.y - this.field884);
               }
            }

            var3.field1938 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1840141159"
   )
   void method1173(int var1, int var2) {
      super.queueSize = 0;
      super.field1241 = 0;
      super.field1251 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = var3 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "101107119"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?class72.getNpcDefinition(this.composition.transformedNpcId).field3559:1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "-67"
   )
   final void method1177(int var1, int var2, byte var3) {
      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var4 = super.queueSize; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field1264[var4] = super.field1264[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field1264[0] = var3;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1832994201"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfg;I)V",
      garbageValue = "855251364"
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
               int var8 = class46.getItemDefinition(var4[var5] - 512).field3526;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= class208.colorsToReplace[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field1266 = var1.readUnsignedShort();
      if(super.field1266 == '\uffff') {
         super.field1266 = -1;
      }

      super.field1213 = super.field1266;
      super.field1215 = var1.readUnsignedShort();
      if(super.field1215 == '\uffff') {
         super.field1215 = -1;
      }

      super.field1260 = var1.readUnsignedShort();
      if(super.field1260 == '\uffff') {
         super.field1260 = -1;
      }

      super.field1217 = var1.readUnsignedShort();
      if(super.field1217 == '\uffff') {
         super.field1217 = -1;
      }

      super.field1218 = var1.readUnsignedShort();
      if(super.field1218 == '\uffff') {
         super.field1218 = -1;
      }

      super.field1219 = var1.readUnsignedShort();
      if(super.field1219 == '\uffff') {
         super.field1219 = -1;
      }

      this.name = var1.readString();
      if(this == AbstractByteBuffer.localPlayer) {
         class152.field2224 = this.name;
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

      this.composition.method4096(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "743503338"
   )
   final void method1168(int var1, int var2, byte var3) {
      if(super.animation != -1 && class204.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1235 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               KeyFocusListener.method781(this, var1, var2, (byte)2);
            }

            this.method1177(var1, var2, var3);
         } else {
            this.method1173(var1, var2);
         }
      } else {
         this.method1173(var1, var2);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lbg;II)V",
      garbageValue = "2017564460"
   )
   static void method1188(ScriptEvent var0, int var1) {
      Object[] var2 = var0.field846;
      Script var3;
      Script var5;
      int var7;
      int var8;
      int var9;
      int var11;
      int var22;
      if(method1190(var0.field855)) {
         class147.field2194 = (class47)var2[0];
         Area var4 = class3.field24[class147.field2194.field623];
         class219 var6 = var0.field855;
         var7 = var4.field3292;
         var8 = var4.field3309;
         var9 = SoundTask.method2152(var7, var6);
         Script var10 = BaseVarType.method15(var9, var6);
         if(var10 != null) {
            var5 = var10;
         } else {
            var11 = (var8 + '鱀' << 8) + var6.field2796;
            var10 = BaseVarType.method15(var11, var6);
            if(var10 != null) {
               var5 = var10;
            } else {
               var5 = null;
            }
         }

         var3 = var5;
      } else {
         var22 = ((Integer)var2[0]).intValue();
         Script var38 = (Script)Script.field1518.get((long)var22);
         if(var38 != null) {
            var5 = var38;
         } else {
            byte[] var34 = class51.indexScripts.getConfigData(var22, 0);
            if(var34 == null) {
               var5 = null;
            } else {
               var38 = class219.method4177(var34);
               Script.field1518.put(var38, (long)var22);
               var5 = var38;
            }
         }

         var3 = var5;
      }

      if(var3 != null) {
         class81.intStackSize = 0;
         class81.scriptStringStackSize = 0;
         var22 = -1;
         int[] var41 = var3.instructions;
         int[] var39 = var3.intOperands;
         byte var40 = -1;
         class81.scriptStackCount = 0;

         int var23;
         try {
            class81.scriptLocalInts = new int[var3.localIntCount];
            var8 = 0;
            FileOnDisk.scriptLocalStrings = new String[var3.localStringCount];
            var9 = 0;

            String var24;
            for(var23 = 1; var23 < var2.length; ++var23) {
               if(var2[var23] instanceof Integer) {
                  var11 = ((Integer)var2[var23]).intValue();
                  if(var11 == -2147483647) {
                     var11 = var0.field847;
                  }

                  if(var11 == -2147483646) {
                     var11 = var0.field848;
                  }

                  if(var11 == -2147483645) {
                     var11 = var0.widget != null?var0.widget.id:-1;
                  }

                  if(var11 == -2147483644) {
                     var11 = var0.field849;
                  }

                  if(var11 == -2147483643) {
                     var11 = var0.widget != null?var0.widget.index:-1;
                  }

                  if(var11 == -2147483642) {
                     var11 = var0.field850 != null?var0.field850.id:-1;
                  }

                  if(var11 == -2147483641) {
                     var11 = var0.field850 != null?var0.field850.index:-1;
                  }

                  if(var11 == -2147483640) {
                     var11 = var0.field851;
                  }

                  if(var11 == -2147483639) {
                     var11 = var0.field844;
                  }

                  class81.scriptLocalInts[var8++] = var11;
               } else if(var2[var23] instanceof String) {
                  var24 = (String)var2[var23];
                  if(var24.equals("event_opbase")) {
                     var24 = var0.field852;
                  }

                  FileOnDisk.scriptLocalStrings[var9++] = var24;
               }
            }

            var23 = 0;
            class81.field1344 = var0.field854;

            while(true) {
               while(true) {
                  while(true) {
                     while(true) {
                        while(true) {
                           while(true) {
                              while(true) {
                                 while(true) {
                                    while(true) {
                                       while(true) {
                                          while(true) {
                                             while(true) {
                                                while(true) {
                                                   while(true) {
                                                      while(true) {
                                                         while(true) {
                                                            while(true) {
                                                               while(true) {
                                                                  while(true) {
                                                                     while(true) {
                                                                        while(true) {
                                                                           while(true) {
                                                                              while(true) {
                                                                                 while(true) {
                                                                                    while(true) {
                                                                                       label1831:
                                                                                       while(true) {
                                                                                          ++var23;
                                                                                          if(var23 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var22;
                                                                                          var7 = var41[var22];
                                                                                          int var12;
                                                                                          int var14;
                                                                                          int var15;
                                                                                          int var16;
                                                                                          int var28;
                                                                                          int var29;
                                                                                          String var48;
                                                                                          String var54;
                                                                                          String var67;
                                                                                          if(var7 < 100) {
                                                                                             if(var7 != 0) {
                                                                                                if(var7 != 1) {
                                                                                                   if(var7 != 2) {
                                                                                                      if(var7 != 3) {
                                                                                                         if(var7 != 6) {
                                                                                                            if(var7 != 7) {
                                                                                                               if(var7 != 8) {
                                                                                                                  if(var7 != 9) {
                                                                                                                     if(var7 != 10) {
                                                                                                                        if(var7 != 21) {
                                                                                                                           if(var7 != 25) {
                                                                                                                              if(var7 != 27) {
                                                                                                                                 if(var7 != 31) {
                                                                                                                                    if(var7 != 32) {
                                                                                                                                       if(var7 != 33) {
                                                                                                                                          if(var7 != 34) {
                                                                                                                                             if(var7 != 35) {
                                                                                                                                                if(var7 != 36) {
                                                                                                                                                   if(var7 != 37) {
                                                                                                                                                      if(var7 != 38) {
                                                                                                                                                         if(var7 != 39) {
                                                                                                                                                            if(var7 != 40) {
                                                                                                                                                               if(var7 != 42) {
                                                                                                                                                                  if(var7 != 43) {
                                                                                                                                                                     if(var7 == 44) {
                                                                                                                                                                        var11 = var39[var22] >> 16;
                                                                                                                                                                        var12 = var39[var22] & '\uffff';
                                                                                                                                                                        int var72 = class81.intStack[--class81.intStackSize];
                                                                                                                                                                        if(var72 >= 0 && var72 <= 5000) {
                                                                                                                                                                           class81.field1332[var11] = var72;
                                                                                                                                                                           byte var61 = -1;
                                                                                                                                                                           if(var12 == 105) {
                                                                                                                                                                              var61 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var15 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var15 >= var72) {
                                                                                                                                                                                 continue label1831;
                                                                                                                                                                              }

                                                                                                                                                                              class81.SHAPE_VERTICES[var11][var15] = var61;
                                                                                                                                                                              ++var15;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var7 == 45) {
                                                                                                                                                                        var11 = var39[var22];
                                                                                                                                                                        var12 = class81.intStack[--class81.intStackSize];
                                                                                                                                                                        if(var12 < 0 || var12 >= class81.field1332[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class81.intStack[++class81.intStackSize - 1] = class81.SHAPE_VERTICES[var11][var12];
                                                                                                                                                                     } else if(var7 == 46) {
                                                                                                                                                                        var11 = var39[var22];
                                                                                                                                                                        class81.intStackSize -= 2;
                                                                                                                                                                        var12 = class81.intStack[class81.intStackSize];
                                                                                                                                                                        if(var12 < 0 || var12 >= class81.field1332[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class81.SHAPE_VERTICES[var11][var12] = class81.intStack[class81.intStackSize + 1];
                                                                                                                                                                     } else if(var7 == 47) {
                                                                                                                                                                        var24 = GZipDecompressor.chatMessages.getVarcString(var39[var22]);
                                                                                                                                                                        if(var24 == null) {
                                                                                                                                                                           var24 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var24;
                                                                                                                                                                     } else if(var7 == 48) {
                                                                                                                                                                        GZipDecompressor.chatMessages.putVarcString(var39[var22], class81.scriptStringStack[--class81.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var7 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        IterableHashTable var53 = var3.switches[var39[var22]];
                                                                                                                                                                        IntegerNode var70 = (IntegerNode)var53.get((long)class81.intStack[--class81.intStackSize]);
                                                                                                                                                                        if(var70 != null) {
                                                                                                                                                                           var22 += var70.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     GZipDecompressor.chatMessages.putVarc(var39[var22], class81.intStack[--class81.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class81.intStack[++class81.intStackSize - 1] = GZipDecompressor.chatMessages.getVarc(var39[var22]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var11 = var39[var22];
                                                                                                                                                               Script var63 = (Script)Script.field1518.get((long)var11);
                                                                                                                                                               Script var66;
                                                                                                                                                               if(var63 != null) {
                                                                                                                                                                  var66 = var63;
                                                                                                                                                               } else {
                                                                                                                                                                  byte[] var68 = class51.indexScripts.getConfigData(var11, 0);
                                                                                                                                                                  if(var68 == null) {
                                                                                                                                                                     var66 = null;
                                                                                                                                                                  } else {
                                                                                                                                                                     var63 = class219.method4177(var68);
                                                                                                                                                                     Script.field1518.put(var63, (long)var11);
                                                                                                                                                                     var66 = var63;
                                                                                                                                                                  }
                                                                                                                                                               }

                                                                                                                                                               var63 = var66;
                                                                                                                                                               int[] var69 = new int[var66.localIntCount];
                                                                                                                                                               String[] var65 = new String[var66.localStringCount];

                                                                                                                                                               for(var16 = 0; var16 < var63.intStackCount; ++var16) {
                                                                                                                                                                  var69[var16] = class81.intStack[var16 + (class81.intStackSize - var63.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var16 = 0; var16 < var63.stringStackCount; ++var16) {
                                                                                                                                                                  var65[var16] = class81.scriptStringStack[var16 + (class81.scriptStringStackSize - var63.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class81.intStackSize -= var63.intStackCount;
                                                                                                                                                               class81.scriptStringStackSize -= var63.stringStackCount;
                                                                                                                                                               ScriptState var64 = new ScriptState();
                                                                                                                                                               var64.invokedFromScript = var3;
                                                                                                                                                               var64.invokedFromPc = var22;
                                                                                                                                                               var64.savedLocalInts = class81.scriptLocalInts;
                                                                                                                                                               var64.savedLocalStrings = FileOnDisk.scriptLocalStrings;
                                                                                                                                                               class81.scriptStack[++class81.scriptStackCount - 1] = var64;
                                                                                                                                                               var3 = var63;
                                                                                                                                                               var41 = var63.instructions;
                                                                                                                                                               var39 = var63.intOperands;
                                                                                                                                                               var22 = -1;
                                                                                                                                                               class81.scriptLocalInts = var69;
                                                                                                                                                               FileOnDisk.scriptLocalStrings = var65;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class81.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class81.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var11 = var39[var22];
                                                                                                                                                      class81.scriptStringStackSize -= var11;
                                                                                                                                                      String[] var30 = class81.scriptStringStack;
                                                                                                                                                      var14 = class81.scriptStringStackSize;
                                                                                                                                                      String var31;
                                                                                                                                                      if(var11 == 0) {
                                                                                                                                                         var31 = "";
                                                                                                                                                      } else if(var11 == 1) {
                                                                                                                                                         var54 = var30[var14];
                                                                                                                                                         if(var54 == null) {
                                                                                                                                                            var31 = "null";
                                                                                                                                                         } else {
                                                                                                                                                            var31 = var54.toString();
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         var15 = var14 + var11;
                                                                                                                                                         var16 = 0;

                                                                                                                                                         for(var29 = var14; var29 < var15; ++var29) {
                                                                                                                                                            var48 = var30[var29];
                                                                                                                                                            if(var48 == null) {
                                                                                                                                                               var16 += 4;
                                                                                                                                                            } else {
                                                                                                                                                               var16 += var48.length();
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         StringBuilder var50 = new StringBuilder(var16);

                                                                                                                                                         for(var28 = var14; var28 < var15; ++var28) {
                                                                                                                                                            var67 = var30[var28];
                                                                                                                                                            if(var67 == null) {
                                                                                                                                                               var50.append("null");
                                                                                                                                                            } else {
                                                                                                                                                               var50.append(var67);
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         var31 = var50.toString();
                                                                                                                                                      }

                                                                                                                                                      class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var31;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   FileOnDisk.scriptLocalStrings[var39[var22]] = class81.scriptStringStack[--class81.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class81.scriptStringStack[++class81.scriptStringStackSize - 1] = FileOnDisk.scriptLocalStrings[var39[var22]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class81.scriptLocalInts[var39[var22]] = class81.intStack[--class81.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class81.intStack[++class81.intStackSize - 1] = class81.scriptLocalInts[var39[var22]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class81.intStackSize -= 2;
                                                                                                                                       if(class81.intStack[class81.intStackSize] >= class81.intStack[class81.intStackSize + 1]) {
                                                                                                                                          var22 += var39[var22];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class81.intStackSize -= 2;
                                                                                                                                    if(class81.intStack[class81.intStackSize] <= class81.intStack[class81.intStackSize + 1]) {
                                                                                                                                       var22 += var39[var22];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var11 = var39[var22];
                                                                                                                                 class2.method7(var11, class81.intStack[--class81.intStackSize]);
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var11 = var39[var22];
                                                                                                                              class81.intStack[++class81.intStackSize - 1] = class88.method1777(var11);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class81.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var51 = class81.scriptStack[--class81.scriptStackCount];
                                                                                                                           var3 = var51.invokedFromScript;
                                                                                                                           var41 = var3.instructions;
                                                                                                                           var39 = var3.intOperands;
                                                                                                                           var22 = var51.invokedFromPc;
                                                                                                                           class81.scriptLocalInts = var51.savedLocalInts;
                                                                                                                           FileOnDisk.scriptLocalStrings = var51.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class81.intStackSize -= 2;
                                                                                                                        if(class81.intStack[class81.intStackSize] > class81.intStack[class81.intStackSize + 1]) {
                                                                                                                           var22 += var39[var22];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class81.intStackSize -= 2;
                                                                                                                     if(class81.intStack[class81.intStackSize] < class81.intStack[class81.intStackSize + 1]) {
                                                                                                                        var22 += var39[var22];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class81.intStackSize -= 2;
                                                                                                                  if(class81.intStack[class81.intStackSize + 1] == class81.intStack[class81.intStackSize]) {
                                                                                                                     var22 += var39[var22];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class81.intStackSize -= 2;
                                                                                                               if(class81.intStack[class81.intStackSize] != class81.intStack[class81.intStackSize + 1]) {
                                                                                                                  var22 += var39[var22];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var22 += var39[var22];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var3.stringOperands[var22];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var11 = var39[var22];
                                                                                                      class211.widgetSettings[var11] = class81.intStack[--class81.intStackSize];
                                                                                                      WidgetNode.method1139(var11);
                                                                                                   }
                                                                                                } else {
                                                                                                   var11 = var39[var22];
                                                                                                   class81.intStack[++class81.intStackSize - 1] = class211.widgetSettings[var11];
                                                                                                }
                                                                                             } else {
                                                                                                class81.intStack[++class81.intStackSize - 1] = var39[var22];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var43;
                                                                                             if(var3.intOperands[var22] == 1) {
                                                                                                var43 = true;
                                                                                             } else {
                                                                                                var43 = false;
                                                                                             }

                                                                                             byte var13;
                                                                                             Widget var17;
                                                                                             int var19;
                                                                                             Widget var25;
                                                                                             Widget var27;
                                                                                             if(var7 < 1000) {
                                                                                                if(var7 == 100) {
                                                                                                   class81.intStackSize -= 3;
                                                                                                   var14 = class81.intStack[class81.intStackSize];
                                                                                                   var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                   var16 = class81.intStack[class81.intStackSize + 2];
                                                                                                   if(var15 == 0) {
                                                                                                      throw new RuntimeException();
                                                                                                   }

                                                                                                   var17 = PacketBuffer.method3528(var14);
                                                                                                   if(var17.children == null) {
                                                                                                      var17.children = new Widget[var16 + 1];
                                                                                                   }

                                                                                                   if(var17.children.length <= var16) {
                                                                                                      Widget[] var18 = new Widget[var16 + 1];

                                                                                                      for(var19 = 0; var19 < var17.children.length; ++var19) {
                                                                                                         var18[var19] = var17.children[var19];
                                                                                                      }

                                                                                                      var17.children = var18;
                                                                                                   }

                                                                                                   if(var16 > 0 && var17.children[var16 - 1] == null) {
                                                                                                      throw new RuntimeException("" + (var16 - 1));
                                                                                                   }

                                                                                                   Widget var46 = new Widget();
                                                                                                   var46.type = var15;
                                                                                                   var46.parentId = var46.id = var17.id;
                                                                                                   var46.index = var16;
                                                                                                   var46.hasScript = true;
                                                                                                   var17.children[var16] = var46;
                                                                                                   if(var43) {
                                                                                                      class81.field1341 = var46;
                                                                                                   } else {
                                                                                                      class81.field1340 = var46;
                                                                                                   }

                                                                                                   class25.method172(var17);
                                                                                                   var13 = 1;
                                                                                                } else if(var7 == 101) {
                                                                                                   var25 = var43?class81.field1341:class81.field1340;
                                                                                                   Widget var26 = PacketBuffer.method3528(var25.id);
                                                                                                   var26.children[var25.index] = null;
                                                                                                   class25.method172(var26);
                                                                                                   var13 = 1;
                                                                                                } else if(var7 == 102) {
                                                                                                   var25 = PacketBuffer.method3528(class81.intStack[--class81.intStackSize]);
                                                                                                   var25.children = null;
                                                                                                   class25.method172(var25);
                                                                                                   var13 = 1;
                                                                                                } else if(var7 != 200) {
                                                                                                   if(var7 == 201) {
                                                                                                      var25 = PacketBuffer.method3528(class81.intStack[--class81.intStackSize]);
                                                                                                      if(var25 != null) {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = 1;
                                                                                                         if(var43) {
                                                                                                            class81.field1341 = var25;
                                                                                                         } else {
                                                                                                            class81.field1340 = var25;
                                                                                                         }
                                                                                                      } else {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                      }

                                                                                                      var13 = 1;
                                                                                                   } else {
                                                                                                      var13 = 2;
                                                                                                   }
                                                                                                } else {
                                                                                                   class81.intStackSize -= 2;
                                                                                                   var14 = class81.intStack[class81.intStackSize];
                                                                                                   var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                   var27 = class5.method18(var14, var15);
                                                                                                   if(var27 != null && var15 != -1) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = 1;
                                                                                                      if(var43) {
                                                                                                         class81.field1341 = var27;
                                                                                                      } else {
                                                                                                         class81.field1340 = var27;
                                                                                                      }
                                                                                                   } else {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                   }

                                                                                                   var13 = 1;
                                                                                                }

                                                                                                var12 = var13;
                                                                                             } else if(var7 < 1100) {
                                                                                                var12 = Friend.method1133(var7, var3, var43);
                                                                                             } else if(var7 < 1200) {
                                                                                                var12 = class40.method539(var7, var3, var43);
                                                                                             } else if(var7 < 1300) {
                                                                                                var12 = PendingSpawn.method1582(var7, var3, var43);
                                                                                             } else if(var7 < 1400) {
                                                                                                var12 = class152.method3019(var7, var3, var43);
                                                                                             } else if(var7 < 1500) {
                                                                                                var12 = class24.method171(var7, var3, var43);
                                                                                             } else if(var7 < 1600) {
                                                                                                var12 = class227.method4198(var7, var3, var43);
                                                                                             } else if(var7 < 1700) {
                                                                                                var25 = var43?class81.field1341:class81.field1340;
                                                                                                if(var7 == 1600) {
                                                                                                   class81.intStack[++class81.intStackSize - 1] = var25.scrollX;
                                                                                                   var13 = 1;
                                                                                                } else if(var7 == 1601) {
                                                                                                   class81.intStack[++class81.intStackSize - 1] = var25.scrollY;
                                                                                                   var13 = 1;
                                                                                                } else if(var7 == 1602) {
                                                                                                   class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var25.text;
                                                                                                   var13 = 1;
                                                                                                } else if(var7 == 1603) {
                                                                                                   class81.intStack[++class81.intStackSize - 1] = var25.scrollWidth;
                                                                                                   var13 = 1;
                                                                                                } else if(var7 == 1604) {
                                                                                                   class81.intStack[++class81.intStackSize - 1] = var25.scrollHeight;
                                                                                                   var13 = 1;
                                                                                                } else if(var7 == 1605) {
                                                                                                   class81.intStack[++class81.intStackSize - 1] = var25.modelZoom;
                                                                                                   var13 = 1;
                                                                                                } else if(var7 == 1606) {
                                                                                                   class81.intStack[++class81.intStackSize - 1] = var25.rotationX;
                                                                                                   var13 = 1;
                                                                                                } else if(var7 == 1607) {
                                                                                                   class81.intStack[++class81.intStackSize - 1] = var25.rotationY;
                                                                                                   var13 = 1;
                                                                                                } else if(var7 == 1608) {
                                                                                                   class81.intStack[++class81.intStackSize - 1] = var25.rotationZ;
                                                                                                   var13 = 1;
                                                                                                } else if(var7 == 1609) {
                                                                                                   class81.intStack[++class81.intStackSize - 1] = var25.opacity;
                                                                                                   var13 = 1;
                                                                                                } else if(var7 == 1610) {
                                                                                                   class81.intStack[++class81.intStackSize - 1] = var25.field2690;
                                                                                                   var13 = 1;
                                                                                                } else if(var7 == 1611) {
                                                                                                   class81.intStack[++class81.intStackSize - 1] = var25.textColor;
                                                                                                   var13 = 1;
                                                                                                } else if(var7 == 1612) {
                                                                                                   class81.intStack[++class81.intStackSize - 1] = var25.field2779;
                                                                                                   var13 = 1;
                                                                                                } else if(var7 == 1613) {
                                                                                                   class81.intStack[++class81.intStackSize - 1] = var25.field2688.rsOrdinal();
                                                                                                   var13 = 1;
                                                                                                } else {
                                                                                                   var13 = 2;
                                                                                                }

                                                                                                var12 = var13;
                                                                                             } else if(var7 < 1800) {
                                                                                                var12 = ClanMember.method1191(var7, var3, var43);
                                                                                             } else {
                                                                                                int[] var52;
                                                                                                if(var7 < 1900) {
                                                                                                   var25 = var43?class81.field1341:class81.field1340;
                                                                                                   if(var7 == 1800) {
                                                                                                      var52 = class81.intStack;
                                                                                                      var16 = ++class81.intStackSize - 1;
                                                                                                      var28 = class244.getWidgetConfig(var25);
                                                                                                      var29 = var28 >> 11 & 63;
                                                                                                      var52[var16] = var29;
                                                                                                      var13 = 1;
                                                                                                   } else if(var7 != 1801) {
                                                                                                      if(var7 == 1802) {
                                                                                                         if(var25.name == null) {
                                                                                                            class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                                                                                                         } else {
                                                                                                            class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var25.name;
                                                                                                         }

                                                                                                         var13 = 1;
                                                                                                      } else {
                                                                                                         var13 = 2;
                                                                                                      }
                                                                                                   } else {
                                                                                                      var15 = class81.intStack[--class81.intStackSize];
                                                                                                      --var15;
                                                                                                      if(var25.actions != null && var15 < var25.actions.length && var25.actions[var15] != null) {
                                                                                                         class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var25.actions[var15];
                                                                                                      } else {
                                                                                                         class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                                                                                                      }

                                                                                                      var13 = 1;
                                                                                                   }

                                                                                                   var12 = var13;
                                                                                                } else if(var7 < 2000) {
                                                                                                   var12 = class48.method735(var7, var3, var43);
                                                                                                } else if(var7 < 2100) {
                                                                                                   var12 = Friend.method1133(var7, var3, var43);
                                                                                                } else if(var7 < 2200) {
                                                                                                   var12 = class40.method539(var7, var3, var43);
                                                                                                } else if(var7 < 2300) {
                                                                                                   var12 = PendingSpawn.method1582(var7, var3, var43);
                                                                                                } else if(var7 < 2400) {
                                                                                                   var12 = class152.method3019(var7, var3, var43);
                                                                                                } else if(var7 < 2500) {
                                                                                                   var12 = class24.method171(var7, var3, var43);
                                                                                                } else if(var7 < 2600) {
                                                                                                   var12 = class35.method485(var7, var3, var43);
                                                                                                } else if(var7 < 2700) {
                                                                                                   var25 = PacketBuffer.method3528(class81.intStack[--class81.intStackSize]);
                                                                                                   if(var7 == 2600) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var25.scrollX;
                                                                                                      var13 = 1;
                                                                                                   } else if(var7 == 2601) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var25.scrollY;
                                                                                                      var13 = 1;
                                                                                                   } else if(var7 == 2602) {
                                                                                                      class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var25.text;
                                                                                                      var13 = 1;
                                                                                                   } else if(var7 == 2603) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var25.scrollWidth;
                                                                                                      var13 = 1;
                                                                                                   } else if(var7 == 2604) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var25.scrollHeight;
                                                                                                      var13 = 1;
                                                                                                   } else if(var7 == 2605) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var25.modelZoom;
                                                                                                      var13 = 1;
                                                                                                   } else if(var7 == 2606) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var25.rotationX;
                                                                                                      var13 = 1;
                                                                                                   } else if(var7 == 2607) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var25.rotationY;
                                                                                                      var13 = 1;
                                                                                                   } else if(var7 == 2608) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var25.rotationZ;
                                                                                                      var13 = 1;
                                                                                                   } else if(var7 == 2609) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var25.opacity;
                                                                                                      var13 = 1;
                                                                                                   } else if(var7 == 2610) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var25.field2690;
                                                                                                      var13 = 1;
                                                                                                   } else if(var7 == 2611) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var25.textColor;
                                                                                                      var13 = 1;
                                                                                                   } else if(var7 == 2612) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var25.field2779;
                                                                                                      var13 = 1;
                                                                                                   } else if(var7 == 2613) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var25.field2688.rsOrdinal();
                                                                                                      var13 = 1;
                                                                                                   } else {
                                                                                                      var13 = 2;
                                                                                                   }

                                                                                                   var12 = var13;
                                                                                                } else if(var7 < 2800) {
                                                                                                   var12 = CombatInfo2.method4486(var7, var3, var43);
                                                                                                } else if(var7 < 2900) {
                                                                                                   var25 = PacketBuffer.method3528(class81.intStack[--class81.intStackSize]);
                                                                                                   if(var7 == 2800) {
                                                                                                      var52 = class81.intStack;
                                                                                                      var16 = ++class81.intStackSize - 1;
                                                                                                      var28 = class244.getWidgetConfig(var25);
                                                                                                      var29 = var28 >> 11 & 63;
                                                                                                      var52[var16] = var29;
                                                                                                      var13 = 1;
                                                                                                   } else if(var7 != 2801) {
                                                                                                      if(var7 == 2802) {
                                                                                                         if(var25.name == null) {
                                                                                                            class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                                                                                                         } else {
                                                                                                            class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var25.name;
                                                                                                         }

                                                                                                         var13 = 1;
                                                                                                      } else {
                                                                                                         var13 = 2;
                                                                                                      }
                                                                                                   } else {
                                                                                                      var15 = class81.intStack[--class81.intStackSize];
                                                                                                      --var15;
                                                                                                      if(var25.actions != null && var15 < var25.actions.length && var25.actions[var15] != null) {
                                                                                                         class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var25.actions[var15];
                                                                                                      } else {
                                                                                                         class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                                                                                                      }

                                                                                                      var13 = 1;
                                                                                                   }

                                                                                                   var12 = var13;
                                                                                                } else if(var7 < 3000) {
                                                                                                   var12 = class48.method735(var7, var3, var43);
                                                                                                } else {
                                                                                                   String var55;
                                                                                                   String var57;
                                                                                                   if(var7 < 3200) {
                                                                                                      if(var7 == 3100) {
                                                                                                         var55 = class81.scriptStringStack[--class81.scriptStringStackSize];
                                                                                                         MessageNode.sendGameMessage(0, "", var55);
                                                                                                         var13 = 1;
                                                                                                      } else if(var7 == 3101) {
                                                                                                         class81.intStackSize -= 2;
                                                                                                         class2.method5(AbstractByteBuffer.localPlayer, class81.intStack[class81.intStackSize], class81.intStack[class81.intStackSize + 1]);
                                                                                                         var13 = 1;
                                                                                                      } else if(var7 == 3103) {
                                                                                                         IndexData.method4316();
                                                                                                         var13 = 1;
                                                                                                      } else if(var7 == 3104) {
                                                                                                         var55 = class81.scriptStringStack[--class81.scriptStringStackSize];
                                                                                                         var15 = 0;
                                                                                                         if(class224.method4196(var55)) {
                                                                                                            var16 = class41.parseInt(var55, 10, true);
                                                                                                            var15 = var16;
                                                                                                         }

                                                                                                         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_NUMERIC_INPUT);
                                                                                                         if(Client.RUNELITE_PACKET) {
                                                                                                            Client.secretPacketBuffer1.runeliteWriteInt(var15);
                                                                                                         } else {
                                                                                                            Client.secretPacketBuffer1.putInt(var15);
                                                                                                         }

                                                                                                         var13 = 1;
                                                                                                      } else if(var7 == 3105) {
                                                                                                         var55 = class81.scriptStringStack[--class81.scriptStringStackSize];
                                                                                                         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_198);
                                                                                                         Client.secretPacketBuffer1.putByte(var55.length() + 1);
                                                                                                         Client.secretPacketBuffer1.putString(var55);
                                                                                                         var13 = 1;
                                                                                                      } else if(var7 == 3106) {
                                                                                                         var55 = class81.scriptStringStack[--class81.scriptStringStackSize];
                                                                                                         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_94);
                                                                                                         Client.secretPacketBuffer1.putByte(var55.length() + 1);
                                                                                                         Client.secretPacketBuffer1.putString(var55);
                                                                                                         var13 = 1;
                                                                                                      } else if(var7 != 3107) {
                                                                                                         if(var7 == 3108) {
                                                                                                            class81.intStackSize -= 3;
                                                                                                            var14 = class81.intStack[class81.intStackSize];
                                                                                                            var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                            var16 = class81.intStack[class81.intStackSize + 2];
                                                                                                            var17 = PacketBuffer.method3528(var16);
                                                                                                            class2.method4(var17, var14, var15);
                                                                                                            var13 = 1;
                                                                                                         } else if(var7 == 3109) {
                                                                                                            class81.intStackSize -= 2;
                                                                                                            var14 = class81.intStack[class81.intStackSize];
                                                                                                            var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                            var27 = var43?class81.field1341:class81.field1340;
                                                                                                            class2.method4(var27, var14, var15);
                                                                                                            var13 = 1;
                                                                                                         } else if(var7 == 3110) {
                                                                                                            class110.field1650 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                            var13 = 1;
                                                                                                         } else if(var7 == 3111) {
                                                                                                            class81.intStack[++class81.intStackSize - 1] = class23.preferences.hideRoofs?1:0;
                                                                                                            var13 = 1;
                                                                                                         } else if(var7 == 3112) {
                                                                                                            class23.preferences.hideRoofs = class81.intStack[--class81.intStackSize] == 1;
                                                                                                            class10.method58();
                                                                                                            var13 = 1;
                                                                                                         } else if(var7 == 3113) {
                                                                                                            var55 = class81.scriptStringStack[--class81.scriptStringStackSize];
                                                                                                            boolean var44 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                            ClanMember.method1197(var55, var44, false);
                                                                                                            var13 = 1;
                                                                                                         } else if(var7 == 3115) {
                                                                                                            var14 = class81.intStack[--class81.intStackSize];
                                                                                                            Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ITEM_PRICE);
                                                                                                            if(Client.RUNELITE_PACKET) {
                                                                                                               Client.secretPacketBuffer1.runeliteWriteInt(var14);
                                                                                                            } else {
                                                                                                               Client.secretPacketBuffer1.putShort(var14);
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         } else if(var7 == 3116) {
                                                                                                            var14 = class81.intStack[--class81.intStackSize];
                                                                                                            class81.scriptStringStackSize -= 2;
                                                                                                            var54 = class81.scriptStringStack[class81.scriptStringStackSize];
                                                                                                            var57 = class81.scriptStringStack[class81.scriptStringStackSize + 1];
                                                                                                            if(var54.length() > 500) {
                                                                                                               var13 = 1;
                                                                                                            } else if(var57.length() > 500) {
                                                                                                               var13 = 1;
                                                                                                            } else {
                                                                                                               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_58);
                                                                                                               Client.secretPacketBuffer1.putShort(1 + class162.getLength(var54) + class162.getLength(var57));
                                                                                                               Client.secretPacketBuffer1.putLEInt(var14);
                                                                                                               Client.secretPacketBuffer1.putString(var57);
                                                                                                               Client.secretPacketBuffer1.putString(var54);
                                                                                                               var13 = 1;
                                                                                                            }
                                                                                                         } else if(var7 == 3117) {
                                                                                                            Client.field1184 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                            var13 = 1;
                                                                                                         } else {
                                                                                                            var13 = 2;
                                                                                                         }
                                                                                                      } else {
                                                                                                         var14 = class81.intStack[--class81.intStackSize];
                                                                                                         var54 = class81.scriptStringStack[--class81.scriptStringStackSize];
                                                                                                         var16 = class94.playerIndexesCount;
                                                                                                         int[] var42 = class94.field1480;
                                                                                                         boolean var59 = false;

                                                                                                         for(var19 = 0; var19 < var16; ++var19) {
                                                                                                            Player var20 = Client.cachedPlayers[var42[var19]];
                                                                                                            if(var20 != null && var20 != AbstractByteBuffer.localPlayer && var20.name != null && var20.name.equalsIgnoreCase(var54)) {
                                                                                                               if(var14 == 1) {
                                                                                                                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_166);
                                                                                                                  if(Client.RUNELITE_PACKET) {
                                                                                                                     Client.secretPacketBuffer1.runeliteWriteInt(0);
                                                                                                                     Client.secretPacketBuffer1.runeliteWriteInt(var42[var19]);
                                                                                                                  } else {
                                                                                                                     Client.secretPacketBuffer1.putLEInt(0);
                                                                                                                     Client.secretPacketBuffer1.method3365(var42[var19]);
                                                                                                                  }
                                                                                                               } else if(var14 == 4) {
                                                                                                                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_TRADE_PLAYER);
                                                                                                                  if(Client.RUNELITE_PACKET) {
                                                                                                                     Client.secretPacketBuffer1.runeliteWriteInt(var42[var19]);
                                                                                                                     Client.secretPacketBuffer1.runeliteWriteInt(0);
                                                                                                                  } else {
                                                                                                                     Client.secretPacketBuffer1.method3270(var42[var19]);
                                                                                                                     Client.secretPacketBuffer1.putLEInt(0);
                                                                                                                  }
                                                                                                               } else if(var14 == 6) {
                                                                                                                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_5);
                                                                                                                  if(Client.RUNELITE_PACKET) {
                                                                                                                     Client.secretPacketBuffer1.runeliteWriteInt(0);
                                                                                                                     Client.secretPacketBuffer1.runeliteWriteInt(var42[var19]);
                                                                                                                  } else {
                                                                                                                     Client.secretPacketBuffer1.putLEInt(0);
                                                                                                                     Client.secretPacketBuffer1.method3270(var42[var19]);
                                                                                                                  }
                                                                                                               } else if(var14 == 7) {
                                                                                                                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_4);
                                                                                                                  if(Client.RUNELITE_PACKET) {
                                                                                                                     Client.secretPacketBuffer1.runeliteWriteInt(0);
                                                                                                                     Client.secretPacketBuffer1.runeliteWriteInt(var42[var19]);
                                                                                                                  } else {
                                                                                                                     Client.secretPacketBuffer1.putLEInt(0);
                                                                                                                     Client.secretPacketBuffer1.method3270(var42[var19]);
                                                                                                                  }
                                                                                                               }

                                                                                                               var59 = true;
                                                                                                               break;
                                                                                                            }
                                                                                                         }

                                                                                                         if(!var59) {
                                                                                                            MessageNode.sendGameMessage(4, "", "Unable to find " + var54);
                                                                                                         }

                                                                                                         var13 = 1;
                                                                                                      }

                                                                                                      var12 = var13;
                                                                                                   } else if(var7 < 3300) {
                                                                                                      var12 = class72.method1165(var7, var3, var43);
                                                                                                   } else {
                                                                                                      int var21;
                                                                                                      int var33;
                                                                                                      if(var7 < 3400) {
                                                                                                         if(var7 == 3300) {
                                                                                                            class81.intStack[++class81.intStackSize - 1] = Client.gameCycle;
                                                                                                            var13 = 1;
                                                                                                         } else if(var7 == 3301) {
                                                                                                            class81.intStackSize -= 2;
                                                                                                            var14 = class81.intStack[class81.intStackSize];
                                                                                                            var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                            class81.intStack[++class81.intStackSize - 1] = class41.method589(var14, var15);
                                                                                                            var13 = 1;
                                                                                                         } else {
                                                                                                            ItemContainer var32;
                                                                                                            int[] var58;
                                                                                                            if(var7 == 3302) {
                                                                                                               class81.intStackSize -= 2;
                                                                                                               var14 = class81.intStack[class81.intStackSize];
                                                                                                               var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                               var58 = class81.intStack;
                                                                                                               var29 = ++class81.intStackSize - 1;
                                                                                                               var32 = (ItemContainer)ItemContainer.itemContainers.get((long)var14);
                                                                                                               if(var32 == null) {
                                                                                                                  var28 = 0;
                                                                                                               } else if(var15 >= 0 && var15 < var32.stackSizes.length) {
                                                                                                                  var28 = var32.stackSizes[var15];
                                                                                                               } else {
                                                                                                                  var28 = 0;
                                                                                                               }

                                                                                                               var58[var29] = var28;
                                                                                                               var13 = 1;
                                                                                                            } else if(var7 == 3303) {
                                                                                                               class81.intStackSize -= 2;
                                                                                                               var14 = class81.intStack[class81.intStackSize];
                                                                                                               var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                               var58 = class81.intStack;
                                                                                                               var29 = ++class81.intStackSize - 1;
                                                                                                               var32 = (ItemContainer)ItemContainer.itemContainers.get((long)var14);
                                                                                                               if(var32 == null) {
                                                                                                                  var28 = 0;
                                                                                                               } else if(var15 == -1) {
                                                                                                                  var28 = 0;
                                                                                                               } else {
                                                                                                                  var33 = 0;

                                                                                                                  for(var21 = 0; var21 < var32.stackSizes.length; ++var21) {
                                                                                                                     if(var15 == var32.itemIds[var21]) {
                                                                                                                        var33 += var32.stackSizes[var21];
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var28 = var33;
                                                                                                               }

                                                                                                               var58[var29] = var28;
                                                                                                               var13 = 1;
                                                                                                            } else if(var7 == 3304) {
                                                                                                               var14 = class81.intStack[--class81.intStackSize];
                                                                                                               class81.intStack[++class81.intStackSize - 1] = class147.method2981(var14).size;
                                                                                                               var13 = 1;
                                                                                                            } else if(var7 == 3305) {
                                                                                                               var14 = class81.intStack[--class81.intStackSize];
                                                                                                               class81.intStack[++class81.intStackSize - 1] = Client.boostedSkillLevels[var14];
                                                                                                               var13 = 1;
                                                                                                            } else if(var7 == 3306) {
                                                                                                               var14 = class81.intStack[--class81.intStackSize];
                                                                                                               class81.intStack[++class81.intStackSize - 1] = Client.realSkillLevels[var14];
                                                                                                               var13 = 1;
                                                                                                            } else if(var7 == 3307) {
                                                                                                               var14 = class81.intStack[--class81.intStackSize];
                                                                                                               class81.intStack[++class81.intStackSize - 1] = Client.skillExperiences[var14];
                                                                                                               var13 = 1;
                                                                                                            } else if(var7 == 3308) {
                                                                                                               var14 = class5.plane;
                                                                                                               var15 = (AbstractByteBuffer.localPlayer.x >> 7) + WallObject.baseX;
                                                                                                               var16 = (AbstractByteBuffer.localPlayer.y >> 7) + Varcs.baseY;
                                                                                                               class81.intStack[++class81.intStackSize - 1] = (var15 << 14) + var16 + (var14 << 28);
                                                                                                               var13 = 1;
                                                                                                            } else if(var7 == 3309) {
                                                                                                               var14 = class81.intStack[--class81.intStackSize];
                                                                                                               class81.intStack[++class81.intStackSize - 1] = var14 >> 14 & 16383;
                                                                                                               var13 = 1;
                                                                                                            } else if(var7 == 3310) {
                                                                                                               var14 = class81.intStack[--class81.intStackSize];
                                                                                                               class81.intStack[++class81.intStackSize - 1] = var14 >> 28;
                                                                                                               var13 = 1;
                                                                                                            } else if(var7 == 3311) {
                                                                                                               var14 = class81.intStack[--class81.intStackSize];
                                                                                                               class81.intStack[++class81.intStackSize - 1] = var14 & 16383;
                                                                                                               var13 = 1;
                                                                                                            } else if(var7 == 3312) {
                                                                                                               class81.intStack[++class81.intStackSize - 1] = Client.isMembers?1:0;
                                                                                                               var13 = 1;
                                                                                                            } else if(var7 == 3313) {
                                                                                                               class81.intStackSize -= 2;
                                                                                                               var14 = class81.intStack[class81.intStackSize] + '耀';
                                                                                                               var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                               class81.intStack[++class81.intStackSize - 1] = class41.method589(var14, var15);
                                                                                                               var13 = 1;
                                                                                                            } else if(var7 == 3314) {
                                                                                                               class81.intStackSize -= 2;
                                                                                                               var14 = class81.intStack[class81.intStackSize] + '耀';
                                                                                                               var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                               var58 = class81.intStack;
                                                                                                               var29 = ++class81.intStackSize - 1;
                                                                                                               var32 = (ItemContainer)ItemContainer.itemContainers.get((long)var14);
                                                                                                               if(var32 == null) {
                                                                                                                  var28 = 0;
                                                                                                               } else if(var15 >= 0 && var15 < var32.stackSizes.length) {
                                                                                                                  var28 = var32.stackSizes[var15];
                                                                                                               } else {
                                                                                                                  var28 = 0;
                                                                                                               }

                                                                                                               var58[var29] = var28;
                                                                                                               var13 = 1;
                                                                                                            } else if(var7 != 3315) {
                                                                                                               if(var7 == 3316) {
                                                                                                                  if(Client.rights >= 2) {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = Client.rights;
                                                                                                                  } else {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 3317) {
                                                                                                                  class81.intStack[++class81.intStackSize - 1] = Client.field983;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 3318) {
                                                                                                                  class81.intStack[++class81.intStackSize - 1] = Client.world;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 3321) {
                                                                                                                  class81.intStack[++class81.intStackSize - 1] = Client.energy;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 3322) {
                                                                                                                  class81.intStack[++class81.intStackSize - 1] = Client.weight;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 3323) {
                                                                                                                  if(Client.field1082) {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = 1;
                                                                                                                  } else {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 3324) {
                                                                                                                  class81.intStack[++class81.intStackSize - 1] = Client.flags;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 3325) {
                                                                                                                  class81.intStackSize -= 4;
                                                                                                                  var14 = class81.intStack[class81.intStackSize];
                                                                                                                  var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                                  var16 = class81.intStack[class81.intStackSize + 2];
                                                                                                                  var29 = class81.intStack[class81.intStackSize + 3];
                                                                                                                  var14 += var15 << 14;
                                                                                                                  var14 += var16 << 28;
                                                                                                                  var14 += var29;
                                                                                                                  class81.intStack[++class81.intStackSize - 1] = var14;
                                                                                                                  var13 = 1;
                                                                                                               } else {
                                                                                                                  var13 = 2;
                                                                                                               }
                                                                                                            } else {
                                                                                                               class81.intStackSize -= 2;
                                                                                                               var14 = class81.intStack[class81.intStackSize] + '耀';
                                                                                                               var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                               var58 = class81.intStack;
                                                                                                               var29 = ++class81.intStackSize - 1;
                                                                                                               var32 = (ItemContainer)ItemContainer.itemContainers.get((long)var14);
                                                                                                               if(var32 == null) {
                                                                                                                  var28 = 0;
                                                                                                               } else if(var15 == -1) {
                                                                                                                  var28 = 0;
                                                                                                               } else {
                                                                                                                  var33 = 0;

                                                                                                                  for(var21 = 0; var21 < var32.stackSizes.length; ++var21) {
                                                                                                                     if(var15 == var32.itemIds[var21]) {
                                                                                                                        var33 += var32.stackSizes[var21];
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var28 = var33;
                                                                                                               }

                                                                                                               var58[var29] = var28;
                                                                                                               var13 = 1;
                                                                                                            }
                                                                                                         }

                                                                                                         var12 = var13;
                                                                                                      } else if(var7 < 3500) {
                                                                                                         var12 = class41.method588(var7, var3, var43);
                                                                                                      } else if(var7 < 3700) {
                                                                                                         if(var7 == 3600) {
                                                                                                            if(Client.field1180 == 0) {
                                                                                                               class81.intStack[++class81.intStackSize - 1] = -2;
                                                                                                            } else if(Client.field1180 == 1) {
                                                                                                               class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                            } else {
                                                                                                               class81.intStack[++class81.intStackSize - 1] = Client.friendCount;
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         } else if(var7 == 3601) {
                                                                                                            var14 = class81.intStack[--class81.intStackSize];
                                                                                                            if(Client.field1180 == 2 && var14 < Client.friendCount) {
                                                                                                               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = Client.friends[var14].name;
                                                                                                               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = Client.friends[var14].previousName;
                                                                                                            } else {
                                                                                                               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                                                                                                               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         } else if(var7 == 3602) {
                                                                                                            var14 = class81.intStack[--class81.intStackSize];
                                                                                                            if(Client.field1180 == 2 && var14 < Client.friendCount) {
                                                                                                               class81.intStack[++class81.intStackSize - 1] = Client.friends[var14].world;
                                                                                                            } else {
                                                                                                               class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         } else if(var7 == 3603) {
                                                                                                            var14 = class81.intStack[--class81.intStackSize];
                                                                                                            if(Client.field1180 == 2 && var14 < Client.friendCount) {
                                                                                                               class81.intStack[++class81.intStackSize - 1] = Client.friends[var14].rank;
                                                                                                            } else {
                                                                                                               class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         } else if(var7 == 3604) {
                                                                                                            var55 = class81.scriptStringStack[--class81.scriptStringStackSize];
                                                                                                            var15 = class81.intStack[--class81.intStackSize];
                                                                                                            CacheFile.method2428(var55, var15);
                                                                                                            var13 = 1;
                                                                                                         } else if(var7 == 3605) {
                                                                                                            var55 = class81.scriptStringStack[--class81.scriptStringStackSize];
                                                                                                            WorldMapType2.method524(var55);
                                                                                                            var13 = 1;
                                                                                                         } else {
                                                                                                            Friend var49;
                                                                                                            boolean var71;
                                                                                                            if(var7 == 3606) {
                                                                                                               var55 = class81.scriptStringStack[--class81.scriptStringStackSize];
                                                                                                               if(var55 != null) {
                                                                                                                  var54 = class207.method3989(var55, class5.field42);
                                                                                                                  if(var54 != null) {
                                                                                                                     for(var16 = 0; var16 < Client.friendCount; ++var16) {
                                                                                                                        var49 = Client.friends[var16];
                                                                                                                        var48 = var49.name;
                                                                                                                        var67 = class207.method3989(var48, class5.field42);
                                                                                                                        if(var55 != null && var48 != null) {
                                                                                                                           if(!var55.startsWith("#") && !var48.startsWith("#")) {
                                                                                                                              var71 = var54.equals(var67);
                                                                                                                           } else {
                                                                                                                              var71 = var55.equals(var48);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           var71 = false;
                                                                                                                        }

                                                                                                                        if(var71) {
                                                                                                                           --Client.friendCount;

                                                                                                                           for(var21 = var16; var21 < Client.friendCount; ++var21) {
                                                                                                                              Client.friends[var21] = Client.friends[var21 + 1];
                                                                                                                           }

                                                                                                                           Client.field1106 = Client.cycleCntr;
                                                                                                                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_DELETE_FRIEND);
                                                                                                                           Client.secretPacketBuffer1.putByte(class162.getLength(var55));
                                                                                                                           Client.secretPacketBuffer1.putString(var55);
                                                                                                                           break;
                                                                                                                        }
                                                                                                                     }
                                                                                                                  }
                                                                                                               }

                                                                                                               var13 = 1;
                                                                                                            } else {
                                                                                                               Ignore var47;
                                                                                                               if(var7 == 3607) {
                                                                                                                  var55 = class81.scriptStringStack[--class81.scriptStringStackSize];
                                                                                                                  if(var55 != null) {
                                                                                                                     if((Client.ignoreCount < 100 || Client.field1035 == 1) && Client.ignoreCount < 400) {
                                                                                                                        var54 = class207.method3989(var55, class5.field42);
                                                                                                                        if(var54 != null) {
                                                                                                                           var16 = 0;

                                                                                                                           label1553:
                                                                                                                           while(true) {
                                                                                                                              if(var16 >= Client.ignoreCount) {
                                                                                                                                 for(var16 = 0; var16 < Client.friendCount; ++var16) {
                                                                                                                                    var49 = Client.friends[var16];
                                                                                                                                    var48 = class207.method3989(var49.name, class5.field42);
                                                                                                                                    if(var48 != null && var48.equals(var54)) {
                                                                                                                                       MessageNode.sendGameMessage(31, "", "Please remove " + var55 + " from your friend list first");
                                                                                                                                       break label1553;
                                                                                                                                    }

                                                                                                                                    if(var49.previousName != null) {
                                                                                                                                       var67 = class207.method3989(var49.previousName, class5.field42);
                                                                                                                                       if(var67 != null && var67.equals(var54)) {
                                                                                                                                          MessageNode.sendGameMessage(31, "", "Please remove " + var55 + " from your friend list first");
                                                                                                                                          break label1553;
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 }

                                                                                                                                 if(class207.method3989(AbstractByteBuffer.localPlayer.name, class5.field42).equals(var54)) {
                                                                                                                                    MessageNode.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
                                                                                                                                 } else {
                                                                                                                                    Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ADD_IGNORE);
                                                                                                                                    Client.secretPacketBuffer1.putByte(class162.getLength(var55));
                                                                                                                                    Client.secretPacketBuffer1.putString(var55);
                                                                                                                                 }
                                                                                                                                 break;
                                                                                                                              }

                                                                                                                              var47 = Client.ignores[var16];
                                                                                                                              var48 = class207.method3989(var47.name, class5.field42);
                                                                                                                              if(var48 != null && var48.equals(var54)) {
                                                                                                                                 MessageNode.sendGameMessage(31, "", var55 + " is already on your ignore list");
                                                                                                                                 break;
                                                                                                                              }

                                                                                                                              if(var47.previousName != null) {
                                                                                                                                 var67 = class207.method3989(var47.previousName, class5.field42);
                                                                                                                                 if(var67 != null && var67.equals(var54)) {
                                                                                                                                    MessageNode.sendGameMessage(31, "", var55 + " is already on your ignore list");
                                                                                                                                    break;
                                                                                                                                 }
                                                                                                                              }

                                                                                                                              ++var16;
                                                                                                                           }
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        MessageNode.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 3608) {
                                                                                                                  var55 = class81.scriptStringStack[--class81.scriptStringStackSize];
                                                                                                                  if(var55 != null) {
                                                                                                                     var54 = class207.method3989(var55, class5.field42);
                                                                                                                     if(var54 != null) {
                                                                                                                        for(var16 = 0; var16 < Client.ignoreCount; ++var16) {
                                                                                                                           var47 = Client.ignores[var16];
                                                                                                                           var48 = var47.name;
                                                                                                                           var67 = class207.method3989(var48, class5.field42);
                                                                                                                           if(var55 != null && var48 != null) {
                                                                                                                              if(!var55.startsWith("#") && !var48.startsWith("#")) {
                                                                                                                                 var71 = var54.equals(var67);
                                                                                                                              } else {
                                                                                                                                 var71 = var55.equals(var48);
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var71 = false;
                                                                                                                           }

                                                                                                                           if(var71) {
                                                                                                                              --Client.ignoreCount;

                                                                                                                              for(var21 = var16; var21 < Client.ignoreCount; ++var21) {
                                                                                                                                 Client.ignores[var21] = Client.ignores[var21 + 1];
                                                                                                                              }

                                                                                                                              Client.field1106 = Client.cycleCntr;
                                                                                                                              Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_DELETE_IGNORE);
                                                                                                                              Client.secretPacketBuffer1.putByte(class162.getLength(var55));
                                                                                                                              Client.secretPacketBuffer1.putString(var55);
                                                                                                                              break;
                                                                                                                           }
                                                                                                                        }
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 3609) {
                                                                                                                  var55 = class81.scriptStringStack[--class81.scriptStringStackSize];
                                                                                                                  Permission[] var56 = ClanMember.method1195();

                                                                                                                  for(var16 = 0; var16 < var56.length; ++var16) {
                                                                                                                     Permission var45 = var56[var16];
                                                                                                                     if(var45.field3181 != -1) {
                                                                                                                        var33 = var45.field3181;
                                                                                                                        var67 = "<img=" + var33 + ">";
                                                                                                                        if(var55.startsWith(var67)) {
                                                                                                                           var55 = var55.substring(6 + Integer.toString(var45.field3181).length());
                                                                                                                           break;
                                                                                                                        }
                                                                                                                     }
                                                                                                                  }

                                                                                                                  class81.intStack[++class81.intStackSize - 1] = class44.isFriended(var55, false)?1:0;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 3611) {
                                                                                                                  if(Client.clanChatOwner != null) {
                                                                                                                     class81.scriptStringStack[++class81.scriptStringStackSize - 1] = class203.method3795(Client.clanChatOwner);
                                                                                                                  } else {
                                                                                                                     class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 3612) {
                                                                                                                  if(Client.clanChatOwner != null) {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = class21.clanChatCount;
                                                                                                                  } else {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 3613) {
                                                                                                                  var14 = class81.intStack[--class81.intStackSize];
                                                                                                                  if(Client.clanChatOwner != null && var14 < class21.clanChatCount) {
                                                                                                                     class81.scriptStringStack[++class81.scriptStringStackSize - 1] = WorldMapType1.clanMembers[var14].username;
                                                                                                                  } else {
                                                                                                                     class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 3614) {
                                                                                                                  var14 = class81.intStack[--class81.intStackSize];
                                                                                                                  if(Client.clanChatOwner != null && var14 < class21.clanChatCount) {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = WorldMapType1.clanMembers[var14].world;
                                                                                                                  } else {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 3615) {
                                                                                                                  var14 = class81.intStack[--class81.intStackSize];
                                                                                                                  if(Client.clanChatOwner != null && var14 < class21.clanChatCount) {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = WorldMapType1.clanMembers[var14].rank;
                                                                                                                  } else {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 3616) {
                                                                                                                  class81.intStack[++class81.intStackSize - 1] = class46.field618;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 3617) {
                                                                                                                  var55 = class81.scriptStringStack[--class81.scriptStringStackSize];
                                                                                                                  MilliTimer.method3012(var55);
                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 3618) {
                                                                                                                  class81.intStack[++class81.intStackSize - 1] = Occluder.clanChatRank;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 3619) {
                                                                                                                  var55 = class81.scriptStringStack[--class81.scriptStringStackSize];
                                                                                                                  if(!var55.equals("")) {
                                                                                                                     Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_JOIN_CLANCHAT);
                                                                                                                     Client.secretPacketBuffer1.putByte(class162.getLength(var55));
                                                                                                                     Client.secretPacketBuffer1.putString(var55);
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 3620) {
                                                                                                                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_JOIN_CLANCHAT);
                                                                                                                  if(Client.RUNELITE_PACKET) {
                                                                                                                     Client.secretPacketBuffer1.runeliteWriteInt(0);
                                                                                                                  } else {
                                                                                                                     Client.secretPacketBuffer1.putByte(0);
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 3621) {
                                                                                                                  if(Client.field1180 == 0) {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                                  } else {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = Client.ignoreCount;
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 3622) {
                                                                                                                  var14 = class81.intStack[--class81.intStackSize];
                                                                                                                  if(Client.field1180 != 0 && var14 < Client.ignoreCount) {
                                                                                                                     class81.scriptStringStack[++class81.scriptStringStackSize - 1] = Client.ignores[var14].name;
                                                                                                                     class81.scriptStringStack[++class81.scriptStringStackSize - 1] = Client.ignores[var14].previousName;
                                                                                                                  } else {
                                                                                                                     class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                                                                                                                     class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 3623) {
                                                                                                                  label1635: {
                                                                                                                     var55 = class81.scriptStringStack[--class81.scriptStringStackSize];
                                                                                                                     var57 = "<img=0>";
                                                                                                                     if(!var55.startsWith(var57)) {
                                                                                                                        var48 = "<img=1>";
                                                                                                                        if(!var55.startsWith(var48)) {
                                                                                                                           break label1635;
                                                                                                                        }
                                                                                                                     }

                                                                                                                     var55 = var55.substring(7);
                                                                                                                  }

                                                                                                                  class81.intStack[++class81.intStackSize - 1] = class162.isIgnored(var55)?1:0;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 != 3624) {
                                                                                                                  if(var7 == 3625) {
                                                                                                                     if(Client.clanChatName != null) {
                                                                                                                        class81.scriptStringStack[++class81.scriptStringStackSize - 1] = class203.method3795(Client.clanChatName);
                                                                                                                     } else {
                                                                                                                        class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var13 = 1;
                                                                                                                  } else {
                                                                                                                     var13 = 2;
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  var14 = class81.intStack[--class81.intStackSize];
                                                                                                                  if(WorldMapType1.clanMembers != null && var14 < class21.clanChatCount && WorldMapType1.clanMembers[var14].username.equalsIgnoreCase(AbstractByteBuffer.localPlayer.name)) {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = 1;
                                                                                                                  } else {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               }
                                                                                                            }
                                                                                                         }

                                                                                                         var12 = var13;
                                                                                                      } else if(var7 < 4000) {
                                                                                                         var12 = KeyFocusListener.method786(var7, var3, var43);
                                                                                                      } else if(var7 < 4100) {
                                                                                                         var12 = FileOnDisk.method2449(var7, var3, var43);
                                                                                                      } else if(var7 < 4200) {
                                                                                                         var12 = class51.method788(var7, var3, var43);
                                                                                                      } else if(var7 < 4300) {
                                                                                                         if(var7 == 4200) {
                                                                                                            var14 = class81.intStack[--class81.intStackSize];
                                                                                                            class81.scriptStringStack[++class81.scriptStringStackSize - 1] = class46.getItemDefinition(var14).name;
                                                                                                            var13 = 1;
                                                                                                         } else {
                                                                                                            ItemComposition var62;
                                                                                                            if(var7 == 4201) {
                                                                                                               class81.intStackSize -= 2;
                                                                                                               var14 = class81.intStack[class81.intStackSize];
                                                                                                               var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                               var62 = class46.getItemDefinition(var14);
                                                                                                               if(var15 >= 1 && var15 <= 5 && var62.groundActions[var15 - 1] != null) {
                                                                                                                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var62.groundActions[var15 - 1];
                                                                                                               } else {
                                                                                                                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                                                                                                               }

                                                                                                               var13 = 1;
                                                                                                            } else if(var7 == 4202) {
                                                                                                               class81.intStackSize -= 2;
                                                                                                               var14 = class81.intStack[class81.intStackSize];
                                                                                                               var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                               var62 = class46.getItemDefinition(var14);
                                                                                                               if(var15 >= 1 && var15 <= 5 && var62.inventoryActions[var15 - 1] != null) {
                                                                                                                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var62.inventoryActions[var15 - 1];
                                                                                                               } else {
                                                                                                                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                                                                                                               }

                                                                                                               var13 = 1;
                                                                                                            } else if(var7 == 4203) {
                                                                                                               var14 = class81.intStack[--class81.intStackSize];
                                                                                                               class81.intStack[++class81.intStackSize - 1] = class46.getItemDefinition(var14).price;
                                                                                                               var13 = 1;
                                                                                                            } else if(var7 == 4204) {
                                                                                                               var14 = class81.intStack[--class81.intStackSize];
                                                                                                               class81.intStack[++class81.intStackSize - 1] = class46.getItemDefinition(var14).isStackable == 1?1:0;
                                                                                                               var13 = 1;
                                                                                                            } else {
                                                                                                               ItemComposition var60;
                                                                                                               if(var7 == 4205) {
                                                                                                                  var14 = class81.intStack[--class81.intStackSize];
                                                                                                                  var60 = class46.getItemDefinition(var14);
                                                                                                                  if(var60.notedTemplate == -1 && var60.note >= 0) {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = var60.note;
                                                                                                                  } else {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = var14;
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 4206) {
                                                                                                                  var14 = class81.intStack[--class81.intStackSize];
                                                                                                                  var60 = class46.getItemDefinition(var14);
                                                                                                                  if(var60.notedTemplate >= 0 && var60.note >= 0) {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = var60.note;
                                                                                                                  } else {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = var14;
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 4207) {
                                                                                                                  var14 = class81.intStack[--class81.intStackSize];
                                                                                                                  class81.intStack[++class81.intStackSize - 1] = class46.getItemDefinition(var14).isMembers?1:0;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 4208) {
                                                                                                                  var14 = class81.intStack[--class81.intStackSize];
                                                                                                                  var60 = class46.getItemDefinition(var14);
                                                                                                                  if(var60.field3542 == -1 && var60.field3541 >= 0) {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = var60.field3541;
                                                                                                                  } else {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = var14;
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 4209) {
                                                                                                                  var14 = class81.intStack[--class81.intStackSize];
                                                                                                                  var60 = class46.getItemDefinition(var14);
                                                                                                                  if(var60.field3542 >= 0 && var60.field3541 >= 0) {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = var60.field3541;
                                                                                                                  } else {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = var14;
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 == 4210) {
                                                                                                                  var55 = class81.scriptStringStack[--class81.scriptStringStackSize];
                                                                                                                  var15 = class81.intStack[--class81.intStackSize];
                                                                                                                  class7.method42(var55, var15 == 1);
                                                                                                                  class81.intStack[++class81.intStackSize - 1] = class25.field370;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var7 != 4211) {
                                                                                                                  if(var7 == 4212) {
                                                                                                                     ScriptVarType.field101 = 0;
                                                                                                                     var13 = 1;
                                                                                                                  } else {
                                                                                                                     var13 = 2;
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  if(class33.field491 != null && ScriptVarType.field101 < class25.field370) {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = class33.field491[++ScriptVarType.field101 - 1] & '\uffff';
                                                                                                                  } else {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               }
                                                                                                            }
                                                                                                         }

                                                                                                         var12 = var13;
                                                                                                      } else if(var7 < 5100) {
                                                                                                         var12 = class3.method10(var7, var3, var43);
                                                                                                      } else if(var7 < 5400) {
                                                                                                         if(var7 == 5306) {
                                                                                                            class81.intStack[++class81.intStackSize - 1] = class19.method142();
                                                                                                            var13 = 1;
                                                                                                         } else if(var7 == 5307) {
                                                                                                            var14 = class81.intStack[--class81.intStackSize];
                                                                                                            if(var14 == 1 || var14 == 2) {
                                                                                                               Friend.method1135(var14);
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         } else if(var7 == 5308) {
                                                                                                            class81.intStack[++class81.intStackSize - 1] = class23.preferences.screenType;
                                                                                                            var13 = 1;
                                                                                                         } else if(var7 != 5309) {
                                                                                                            var13 = 2;
                                                                                                         } else {
                                                                                                            var14 = class81.intStack[--class81.intStackSize];
                                                                                                            if(var14 == 1 || var14 == 2) {
                                                                                                               class23.preferences.screenType = var14;
                                                                                                               class10.method58();
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         }

                                                                                                         var12 = var13;
                                                                                                      } else if(var7 < 5600) {
                                                                                                         var12 = class29.method236(var7, var3, var43);
                                                                                                      } else if(var7 < 5700) {
                                                                                                         var12 = SoundTask.method2155(var7, var3, var43);
                                                                                                      } else if(var7 < 6300) {
                                                                                                         var12 = TextureProvider.method2494(var7, var3, var43);
                                                                                                      } else if(var7 < 6600) {
                                                                                                         var12 = ClanMember.method1194(var7, var3, var43);
                                                                                                      } else if(var7 < 6700) {
                                                                                                         var12 = class163.method3151(var7, var3, var43);
                                                                                                      } else {
                                                                                                         var12 = 2;
                                                                                                      }
                                                                                                   }
                                                                                                }
                                                                                             }

                                                                                             switch(var12) {
                                                                                             case 0:
                                                                                                return;
                                                                                             case 1:
                                                                                             default:
                                                                                                break;
                                                                                             case 2:
                                                                                                throw new IllegalStateException();
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
               }
            }
         } catch (Exception var37) {
            StringBuilder var36 = new StringBuilder(30);
            var36.append("").append(var3.hash).append(" ");

            for(var23 = class81.scriptStackCount - 1; var23 >= 0; --var23) {
               var36.append("").append(class81.scriptStack[var23].invokedFromScript.hash).append(" ");
            }

            var36.append("").append(var40);
            DynamicObject.method1932(var36.toString(), var37);
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lhh;I)Z",
      garbageValue = "217158479"
   )
   public static boolean method1190(class219 var0) {
      return class219.field2806 == var0 || class219.field2797 == var0 || class219.field2798 == var0 || class219.field2799 == var0 || class219.field2800 == var0 || class219.field2804 == var0 || class219.field2802 == var0 || class219.field2803 == var0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1257267345"
   )
   static final int method1189(int var0, int var1) {
      int var2 = Varcs.getSmoothNoise(var0 + '넵', var1 + 91923, 4) - 128 + (Varcs.getSmoothNoise(var0 + 10294, var1 + '鎽', 2) - 128 >> 1) + (Varcs.getSmoothNoise(var0, var1, 1) - 128 >> 2);
      var2 = (int)((double)var2 * 0.3D) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }
}
