import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 598892947
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1280381765
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("y")
   boolean field905;
   @ObfuscatedName("v")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1517425253
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2119183897
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1081358129
   )
   @Export("team")
   int team;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1894464263
   )
   int field895;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 44024975
   )
   int field903;
   @ObfuscatedName("c")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("l")
   boolean field886;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   @Export("model")
   Model model;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 685611895
   )
   int field909;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1581139783
   )
   int field898;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1433313599
   )
   int field894;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2007387177
   )
   int field897;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1051809229
   )
   int field908;
   @ObfuscatedName("w")
   @Export("name")
   String name;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 275015843
   )
   int field913;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1652007423
   )
   int field901;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 636073449
   )
   int field902;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1970607435
   )
   int field892;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 91366807
   )
   int field904;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1457569189
   )
   int field911;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -354044791
   )
   int field899;

   Player() {
      this.skullIcon = -1;
      this.overheadIcon = -1;
      this.actions = new String[3];

      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.totalLevel = 0;
      this.field895 = 0;
      this.field903 = 0;
      this.field905 = false;
      this.team = 0;
      this.hidden = false;
      this.field886 = false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Leh;",
      garbageValue = "0"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?NPCComposition.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.field905 && (super.idlePoseAnimation != super.poseAnimation || var1 == null)?NPCComposition.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method4032(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2558();
            super.field1228 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field905 && super.graphic != -1 && super.field1215 != -1) {
               var4 = class244.getSpotAnimType(super.graphic).method4404(super.field1215);
               if(var4 != null) {
                  var4.method2569(0, -super.field1250, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field905 && this.model != null) {
               if(Client.gameCycle >= this.field903) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.field895 && Client.gameCycle < this.field903) {
                  var4 = this.model;
                  var4.method2569(this.field909 - super.x, this.field898 - this.field894, this.field897 - super.y);
                  if(super.orientation == 512) {
                     var4.method2565();
                     var4.method2565();
                     var4.method2565();
                  } else if(super.orientation == 1024) {
                     var4.method2565();
                     var4.method2565();
                  } else if(super.orientation == 1536) {
                     var4.method2565();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.orientation == 512) {
                     var4.method2565();
                  } else if(super.orientation == 1024) {
                     var4.method2565();
                     var4.method2565();
                  } else if(super.orientation == 1536) {
                     var4.method2565();
                     var4.method2565();
                     var4.method2565();
                  }

                  var4.method2569(super.x - this.field909, this.field894 - this.field898, super.y - this.field897);
               }
            }

            var3.field1936 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1981906163"
   )
   void method1114(int var1, int var2) {
      super.queueSize = 0;
      super.field1213 = 0;
      super.field1267 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = super.pathX[0] * 128 + var3 * 64;
      super.y = super.pathY[0] * 128 + var3 * 64;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "76"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?class17.getNpcDefinition(this.composition.transformedNpcId).field3555:1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "887268453"
   )
   final void method1133(int var1, int var2, byte var3) {
      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var4 = super.queueSize; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field1258[var4] = super.field1258[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field1258[0] = var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "246459077"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lfz;B)V",
      garbageValue = "9"
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
            if(var5 == 0 && var4[0] == 65535) {
               var3 = var1.readUnsignedShort();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = FaceNormal.getItemDefinition(var4[var5] - 512).field3537;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= PlayerComposition.colorsToReplace[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == 65535) {
         super.idlePoseAnimation = -1;
      }

      super.field1253 = var1.readUnsignedShort();
      if(super.field1253 == 65535) {
         super.field1253 = -1;
      }

      super.field1227 = super.field1253;
      super.field1217 = var1.readUnsignedShort();
      if(super.field1217 == 65535) {
         super.field1217 = -1;
      }

      super.field1218 = var1.readUnsignedShort();
      if(super.field1218 == 65535) {
         super.field1218 = -1;
      }

      super.field1219 = var1.readUnsignedShort();
      if(super.field1219 == 65535) {
         super.field1219 = -1;
      }

      super.field1220 = var1.readUnsignedShort();
      if(super.field1220 == 65535) {
         super.field1220 = -1;
      }

      super.field1216 = var1.readUnsignedShort();
      if(super.field1216 == 65535) {
         super.field1216 = -1;
      }

      this.name = var1.readString();
      if(this == class66.localPlayer) {
         class152.field2211 = this.name;
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

      this.composition.method4030(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-286557282"
   )
   final void method1118(int var1, int var2, byte var3) {
      if(super.animation != -1 && NPCComposition.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1249 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Player var4 = this;
               int var5 = super.pathX[0];
               int var6 = super.pathY[0];
               int var7 = this.getSize();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var10 = this.getSize();
                  Client.field1189.field2307 = var1;
                  Client.field1189.field2306 = var2;
                  Client.field1189.field2309 = 1;
                  Client.field1189.field2308 = 1;
                  class72 var11 = Client.field1189;
                  int var12 = WorldMapType1.method274(var5, var6, var10, var11, Client.collisionMaps[this.field908], true, Client.field1190, Client.field1060);
                  if(var12 >= 1) {
                     for(int var13 = 0; var13 < var12 - 1; ++var13) {
                        var4.method1133(Client.field1190[var13], Client.field1060[var13], (byte)2);
                     }
                  }
               }
            }

            this.method1133(var1, var2, var3);
         } else {
            this.method1114(var1, var2);
         }
      } else {
         this.method1114(var1, var2);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "314537245"
   )
   public static void method1137() {
      try {
         class155.field2239.method2398();

         for(int var0 = 0; var0 < class223.field2836; ++var0) {
            PacketBuffer.field2417[var0].method2398();
         }

         class155.field2241.method2398();
         class155.field2240.method2398();
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfg;I)V",
      garbageValue = "1826389057"
   )
   static final void method1136(PacketBuffer var0) {
      int var1 = 0;
      var0.bitAccess();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class94.playerIndexesCount; ++var2) {
         var3 = class94.playerIndices[var2];
         if((class94.field1497[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class94.field1497[var3] = (byte)(class94.field1497[var3] | 2);
            } else {
               var4 = var0.getBits(1);
               if(var4 == 0) {
                  var1 = Script.method1896(var0);
                  class94.field1497[var3] = (byte)(class94.field1497[var3] | 2);
               } else {
                  class132.decodeMovement(var0, var3);
               }
            }
         }
      }

      var0.byteAccess();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.bitAccess();

         for(var2 = 0; var2 < class94.playerIndexesCount; ++var2) {
            var3 = class94.playerIndices[var2];
            if((class94.field1497[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class94.field1497[var3] = (byte)(class94.field1497[var3] | 2);
               } else {
                  var4 = var0.getBits(1);
                  if(var4 == 0) {
                     var1 = Script.method1896(var0);
                     class94.field1497[var3] = (byte)(class94.field1497[var3] | 2);
                  } else {
                     class132.decodeMovement(var0, var3);
                  }
               }
            }
         }

         var0.byteAccess();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.bitAccess();

            for(var2 = 0; var2 < class94.field1491; ++var2) {
               var3 = class94.field1492[var2];
               if((class94.field1497[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class94.field1497[var3] = (byte)(class94.field1497[var3] | 2);
                  } else {
                     var4 = var0.getBits(1);
                     if(var4 == 0) {
                        var1 = Script.method1896(var0);
                        class94.field1497[var3] = (byte)(class94.field1497[var3] | 2);
                     } else if(Huffman.decodeRegionHash(var0, var3)) {
                        class94.field1497[var3] = (byte)(class94.field1497[var3] | 2);
                     }
                  }
               }
            }

            var0.byteAccess();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.bitAccess();

               for(var2 = 0; var2 < class94.field1491; ++var2) {
                  var3 = class94.field1492[var2];
                  if((class94.field1497[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class94.field1497[var3] = (byte)(class94.field1497[var3] | 2);
                     } else {
                        var4 = var0.getBits(1);
                        if(var4 == 0) {
                           var1 = Script.method1896(var0);
                           class94.field1497[var3] = (byte)(class94.field1497[var3] | 2);
                        } else if(Huffman.decodeRegionHash(var0, var3)) {
                           class94.field1497[var3] = (byte)(class94.field1497[var3] | 2);
                        }
                     }
                  }
               }

               var0.byteAccess();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class94.playerIndexesCount = 0;
                  class94.field1491 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class94.field1497[var2] = (byte)(class94.field1497[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(var5 != null) {
                        class94.playerIndices[++class94.playerIndexesCount - 1] = var2;
                     } else {
                        class94.field1492[++class94.field1491 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }
}
