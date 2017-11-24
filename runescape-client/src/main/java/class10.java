import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public final class class10 extends class9 {
   @ObfuscatedName("y")
   static int[][][] field242;
   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "[Lkl;"
   )
   static IndexedSprite[] field248;
   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1472890497
   )
   final int field249;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1180337351
   )
   final int field243;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -123728703
   )
   final int field244;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1593994741
   )
   final int field245;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -738461295
   )
   final int field246;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -523305285
   )
   final int field247;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -532515077
   )
   final int field251;

   @ObfuscatedSignature(
      signature = "(Leh;IIII)V"
   )
   class10(Model var1, int var2, int var3, int var4, int var5) {
      this.field249 = var2 + var1.field1831 - var1.field1864;
      this.field243 = var3 + var1.field1838 - var1.field1865;
      this.field244 = var4 + var1.field1893 - var1.field1866;
      this.field245 = var2 + var1.field1831 + var1.field1864;
      this.field246 = var3 + var1.field1865 + var1.field1838;
      this.field247 = var4 + var1.field1893 + var1.field1866;
      this.field251 = var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "106"
   )
   final void vmethod57() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.field249:this.field245;
         int var2 = (var4 & 2) == 0?this.field243:this.field246;
         int var3 = (var4 & 4) == 0?this.field244:this.field247;
         if((var4 & 1) == 0) {
            method59(var1, var2, var3, this.field245, var2, var3, this.field251);
         }

         if((var4 & 2) == 0) {
            method59(var1, var2, var3, var1, this.field246, var3, this.field251);
         }

         if((var4 & 4) == 0) {
            method59(var1, var2, var3, var1, var2, this.field247, this.field251);
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "-53"
   )
   static final void method59(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = Region.method2817(var0, var1, var2);
      int[] var8 = Region.method2817(var3, var4, var5);
      Rasterizer2D.drawLine(var7[0], var7[1], var8[0], var8[1], var6);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILce;ZB)I",
      garbageValue = "1"
   )
   static int method63(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class82.intStack[--class13.intStackSize];
         var3 = class87.method1762(var4);
      } else {
         var3 = var2?class54.field636:class82.field1265;
      }

      if(var0 == 1100) {
         class13.intStackSize -= 2;
         var3.scrollX = class82.intStack[class13.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class82.intStack[class13.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         class40.method556(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class82.intStack[--class13.intStackSize];
         class40.method556(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.filled = class82.intStack[--class13.intStackSize] == 1;
         class40.method556(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class82.intStack[--class13.intStackSize];
         class40.method556(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.lineWidth = class82.intStack[--class13.intStackSize];
         class40.method556(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class82.intStack[--class13.intStackSize];
         class40.method556(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.textureId = class82.intStack[--class13.intStackSize];
         class40.method556(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.spriteTiling = class82.intStack[--class13.intStackSize] == 1;
         class40.method556(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class82.intStack[--class13.intStackSize];
         class40.method556(var3);
         return 1;
      } else if(var0 == 1109) {
         class13.intStackSize -= 6;
         var3.field2773 = class82.intStack[class13.intStackSize];
         var3.field2774 = class82.intStack[class13.intStackSize + 1];
         var3.rotationX = class82.intStack[class13.intStackSize + 2];
         var3.rotationZ = class82.intStack[class13.intStackSize + 3];
         var3.rotationY = class82.intStack[class13.intStackSize + 4];
         var3.modelZoom = class82.intStack[class13.intStackSize + 5];
         class40.method556(var3);
         return 1;
      } else {
         int var9;
         if(var0 == 1110) {
            var9 = class82.intStack[--class13.intStackSize];
            if(var9 != var3.field2844) {
               var3.field2844 = var9;
               var3.field2846 = 0;
               var3.field2783 = 0;
               class40.method556(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2843 = class82.intStack[--class13.intStackSize] == 1;
            class40.method556(var3);
            return 1;
         } else if(var0 == 1112) {
            String var8 = class82.scriptStringStack[--class82.scriptStringStackSize];
            if(!var8.equals(var3.text)) {
               var3.text = var8;
               class40.method556(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class82.intStack[--class13.intStackSize];
            class40.method556(var3);
            return 1;
         } else if(var0 == 1114) {
            class13.intStackSize -= 3;
            var3.field2787 = class82.intStack[class13.intStackSize];
            var3.field2809 = class82.intStack[class13.intStackSize + 1];
            var3.field2824 = class82.intStack[class13.intStackSize + 2];
            class40.method556(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = class82.intStack[--class13.intStackSize] == 1;
            class40.method556(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class82.intStack[--class13.intStackSize];
            class40.method556(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class82.intStack[--class13.intStackSize];
            class40.method556(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class82.intStack[--class13.intStackSize] == 1;
            class40.method556(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class82.intStack[--class13.intStackSize] == 1;
            class40.method556(var3);
            return 1;
         } else if(var0 == 1120) {
            class13.intStackSize -= 2;
            var3.scrollWidth = class82.intStack[class13.intStackSize];
            var3.scrollHeight = class82.intStack[class13.intStackSize + 1];
            class40.method556(var3);
            if(var4 != -1 && var3.type == 0) {
               NPCComposition.method4864(class11.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            class182.method3528(var3.id, var3.index);
            Client.field1018 = var3;
            class40.method556(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2764 = class82.intStack[--class13.intStackSize];
            class40.method556(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2750 = class82.intStack[--class13.intStackSize];
            class40.method556(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2729 = class82.intStack[--class13.intStackSize];
            class40.method556(var3);
            return 1;
         } else if(var0 == 1125) {
            var9 = class82.intStack[--class13.intStackSize];
            class292[] var6 = new class292[]{class292.field3818, class292.field3819, class292.field3823, class292.field3820, class292.field3822};
            class292 var7 = (class292)class94.forOrdinal(var6, var9);
            if(var7 != null) {
               var3.field2754 = var7;
               class40.method556(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class82.intStack[--class13.intStackSize] == 1;
            var3.field2756 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1676139715"
   )
   static int method60(int var0, int var1, int var2) {
      return (class61.tileSettings[var0][var1][var2] & 8) != 0?0:(var0 > 0 && (class61.tileSettings[1][var1][var2] & 2) != 0?var0 - 1:var0);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1578021475"
   )
   static final void method62() {
      short var0 = 256;
      int var1;
      if(class91.field1351 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class91.field1351 > 768) {
               class34.field459[var1] = class177.method3267(ScriptEvent.field811[var1], class295.field3851[var1], 1024 - class91.field1351);
            } else if(class91.field1351 > 256) {
               class34.field459[var1] = class295.field3851[var1];
            } else {
               class34.field459[var1] = class177.method3267(class295.field3851[var1], ScriptEvent.field811[var1], 256 - class91.field1351);
            }
         }
      } else if(class91.field1352 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class91.field1352 > 768) {
               class34.field459[var1] = class177.method3267(ScriptEvent.field811[var1], class91.field1350[var1], 1024 - class91.field1352);
            } else if(class91.field1352 > 256) {
               class34.field459[var1] = class91.field1350[var1];
            } else {
               class34.field459[var1] = class177.method3267(class91.field1350[var1], ScriptEvent.field811[var1], 256 - class91.field1352);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class34.field459[var1] = ScriptEvent.field811[var1];
         }
      }

      Rasterizer2D.setDrawRegion(class91.field1354, 9, class91.field1354 + 128, var0 + 7);
      class182.field2511.method5266(class91.field1354, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      int var2 = class86.field1309.width * 9 + class91.field1354;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class91.field1349[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class82.field1274[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class34.field459[var7];
               var10 = class86.field1309.pixels[var2];
               class86.field1309.pixels[var2++] = ((var7 & 16711935) * var8 + (var10 & 16711935) * var9 & -16711936) + (var9 * (var10 & 65280) + var8 * (var7 & 65280) & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + class86.field1309.width - 128;
      }

      Rasterizer2D.setDrawRegion(class91.field1354 + 765 - 128, 9, class91.field1354 + 765, var0 + 7);
      class91.field1347.method5266(class91.field1354 + 382, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      var2 = class86.field1309.width * 9 + class91.field1354 + 637 + 24;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class91.field1349[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class82.field1274[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class34.field459[var7];
               var10 = class86.field1309.pixels[var2];
               class86.field1309.pixels[var2++] = (var9 * (var10 & 65280) + var8 * (var7 & 65280) & 16711680) + ((var10 & 16711935) * var9 + (var7 & 16711935) * var8 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class86.field1309.width - var5 - var4;
      }

   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1960173207"
   )
   static final void method56(int var0, int var1) {
      if(Client.hintArrowTargetType == 2) {
         class35.method502((Client.hintArrowX - IndexDataBase.baseX << 7) + Client.hintArrowOffsetX, (Client.hintArrowY - Occluder.baseY << 7) + Client.hintArrowOffsetY, Client.hintArrowType * 2);
         if(Client.screenY > -1 && Client.gameCycle % 20 < 10) {
            class33.headIconsHint[0].drawAt(var0 + Client.screenY - 12, Client.screenX + var1 - 28);
         }

      }
   }
}
