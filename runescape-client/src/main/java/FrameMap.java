import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("f")
   static int[] field1973;
   @ObfuscatedName("fv")
   static byte[][] field1970;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1943637907
   )
   @Export("id")
   int id;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -248897639
   )
   @Export("count")
   int count;
   @ObfuscatedName("o")
   @Export("types")
   int[] types;
   @ObfuscatedName("j")
   @Export("list")
   int[][] list;

   FrameMap(int var1, byte[] var2) {
      this.id = var1;
      Buffer var3 = new Buffer(var2);
      this.count = var3.readUnsignedByte();
      this.types = new int[this.count];
      this.list = new int[this.count][];

      int var4;
      for(var4 = 0; var4 < this.count; ++var4) {
         this.types[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         this.list[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         for(int var5 = 0; var5 < this.list[var4].length; ++var5) {
            this.list[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "1753435949"
   )
   @Export("parseInt")
   public static int parseInt(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == '-') {
                  var3 = true;
                  continue;
               }

               if(var8 == '+') {
                  continue;
               }
            }

            int var10;
            if(var8 >= '0' && var8 <= '9') {
               var10 = var8 - '0';
            } else if(var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - '7';
            } else {
               if(var8 < 'a' || var8 > 'z') {
                  throw new NumberFormatException();
               }

               var10 = var8 - 'W';
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var5 * var1;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgf;IB)V",
      garbageValue = "3"
   )
   @Export("decodeMovement")
   static void decodeMovement(PacketBuffer var0, int var1) {
      boolean var2 = var0.getBits(1) == 1;
      if(var2) {
         class93.field1422[++class93.field1421 - 1] = var1;
      }

      int var3 = var0.getBits(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field837 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class93.Players_regions[var1] = (var4.field842 << 28) + (BaseVarType.baseY + var4.pathY[0] >> 13) + (PacketNode.baseX + var4.pathX[0] >> 13 << 14);
            if(var4.field1165 != -1) {
               class93.Players_orientations[var1] = var4.field1165;
            } else {
               class93.Players_orientations[var1] = var4.orientation;
            }

            class93.Players_targetIndices[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.getBits(1) != 0) {
               ScriptVarType.decodeRegionHash(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.getBits(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1159(var6, var7);
               var4.field837 = false;
            } else if(var2) {
               var4.field837 = true;
               var4.field847 = var6;
               var4.field846 = var7;
            } else {
               var4.field837 = false;
               var4.method1149(var6, var7, class93.field1409[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.getBits(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1159(var6, var7);
               var4.field837 = false;
            } else if(var2) {
               var4.field837 = true;
               var4.field847 = var6;
               var4.field846 = var7;
            } else {
               var4.field837 = false;
               var4.method1149(var6, var7, class93.field1409[var1]);
            }

         } else {
            var5 = var0.getBits(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.getBits(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var9 + var4.pathY[0];
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field837 = true;
                     var4.field847 = var10;
                     var4.field846 = var11;
                  } else {
                     var4.field837 = false;
                     var4.method1149(var10, var11, class93.field1409[var1]);
                  }
               } else {
                  var4.method1159(var10, var11);
                  var4.field837 = false;
               }

               var4.field842 = (byte)(var7 + var4.field842 & 3);
               if(Client.localInteractingIndex == var1) {
                  class237.plane = var4.field842;
               }

            } else {
               var6 = var0.getBits(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + PacketNode.baseX + var4.pathX[0] & 16383) - PacketNode.baseX;
               var11 = (var9 + BaseVarType.baseY + var4.pathY[0] & 16383) - BaseVarType.baseY;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field837 = true;
                     var4.field847 = var10;
                     var4.field846 = var11;
                  } else {
                     var4.field837 = false;
                     var4.method1149(var10, var11, class93.field1409[var1]);
                  }
               } else {
                  var4.method1159(var10, var11);
                  var4.field837 = false;
               }

               var4.field842 = (byte)(var7 + var4.field842 & 3);
               if(Client.localInteractingIndex == var1) {
                  class237.plane = var4.field842;
               }

            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "-425129957"
   )
   static int method2874(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class81.intStack[--SceneTilePaint.intStackSize];
         var3 = class3.getWidget(var4);
      } else {
         var3 = var2?class336.field4073:class61.field713;
      }

      if(var0 == 1100) {
         SceneTilePaint.intStackSize -= 2;
         var3.scrollX = class81.intStack[SceneTilePaint.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class81.intStack[SceneTilePaint.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         WorldMapType1.method274(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class81.intStack[--SceneTilePaint.intStackSize];
         WorldMapType1.method274(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.filled = class81.intStack[--SceneTilePaint.intStackSize] == 1;
         WorldMapType1.method274(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class81.intStack[--SceneTilePaint.intStackSize];
         WorldMapType1.method274(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.lineWidth = class81.intStack[--SceneTilePaint.intStackSize];
         WorldMapType1.method274(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class81.intStack[--SceneTilePaint.intStackSize];
         WorldMapType1.method274(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.textureId = class81.intStack[--SceneTilePaint.intStackSize];
         WorldMapType1.method274(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.spriteTiling = class81.intStack[--SceneTilePaint.intStackSize] == 1;
         WorldMapType1.method274(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class81.intStack[--SceneTilePaint.intStackSize];
         WorldMapType1.method274(var3);
         return 1;
      } else if(var0 == 1109) {
         SceneTilePaint.intStackSize -= 6;
         var3.offsetX2d = class81.intStack[SceneTilePaint.intStackSize];
         var3.offsetY2d = class81.intStack[SceneTilePaint.intStackSize + 1];
         var3.rotationX = class81.intStack[SceneTilePaint.intStackSize + 2];
         var3.rotationZ = class81.intStack[SceneTilePaint.intStackSize + 3];
         var3.rotationY = class81.intStack[SceneTilePaint.intStackSize + 4];
         var3.modelZoom = class81.intStack[SceneTilePaint.intStackSize + 5];
         WorldMapType1.method274(var3);
         return 1;
      } else {
         int var8;
         if(var0 == 1110) {
            var8 = class81.intStack[--SceneTilePaint.intStackSize];
            if(var8 != var3.field2831) {
               var3.field2831 = var8;
               var3.field2837 = 0;
               var3.field2806 = 0;
               WorldMapType1.method274(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2829 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
            WorldMapType1.method274(var3);
            return 1;
         } else if(var0 == 1112) {
            String var7 = class81.scriptStringStack[--World.scriptStringStackSize];
            if(!var7.equals(var3.text)) {
               var3.text = var7;
               WorldMapType1.method274(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class81.intStack[--SceneTilePaint.intStackSize];
            WorldMapType1.method274(var3);
            return 1;
         } else if(var0 == 1114) {
            SceneTilePaint.intStackSize -= 3;
            var3.field2877 = class81.intStack[SceneTilePaint.intStackSize];
            var3.field2929 = class81.intStack[SceneTilePaint.intStackSize + 1];
            var3.field2804 = class81.intStack[SceneTilePaint.intStackSize + 2];
            WorldMapType1.method274(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = class81.intStack[--SceneTilePaint.intStackSize] == 1;
            WorldMapType1.method274(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class81.intStack[--SceneTilePaint.intStackSize];
            WorldMapType1.method274(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class81.intStack[--SceneTilePaint.intStackSize];
            WorldMapType1.method274(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class81.intStack[--SceneTilePaint.intStackSize] == 1;
            WorldMapType1.method274(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class81.intStack[--SceneTilePaint.intStackSize] == 1;
            WorldMapType1.method274(var3);
            return 1;
         } else if(var0 == 1120) {
            SceneTilePaint.intStackSize -= 2;
            var3.scrollWidth = class81.intStack[SceneTilePaint.intStackSize];
            var3.scrollHeight = class81.intStack[SceneTilePaint.intStackSize + 1];
            WorldMapType1.method274(var3);
            if(var4 != -1 && var3.type == 0) {
               MapIcon.method578(class189.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            DynamicObject.method2019(var3.id, var3.index);
            Client.field1102 = var3;
            WorldMapType1.method274(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2855 = class81.intStack[--SceneTilePaint.intStackSize];
            WorldMapType1.method274(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2920 = class81.intStack[--SceneTilePaint.intStackSize];
            WorldMapType1.method274(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2846 = class81.intStack[--SceneTilePaint.intStackSize];
            WorldMapType1.method274(var3);
            return 1;
         } else if(var0 == 1125) {
            var8 = class81.intStack[--SceneTilePaint.intStackSize];
            class329 var6 = (class329)class44.forOrdinal(AbstractSoundSystem.method2198(), var8);
            if(var6 != null) {
               var3.field2896 = var6;
               WorldMapType1.method274(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
            var3.field2897 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }
}
