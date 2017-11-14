import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
public enum class246 implements RSEnum {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   field3335(0, 0),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   field3337(2, 1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   field3334(1, 2);

   @ObfuscatedName("l")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1095681319
   )
   public final int field3338;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1596293791
   )
   final int field3336;

   class246(int var3, int var4) {
      this.field3338 = var3;
      this.field3336 = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "369425307"
   )
   public int rsOrdinal() {
      return this.field3336;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lik;I)V",
      garbageValue = "-1972708473"
   )
   public static void method4441(IndexDataBase var0) {
      Overlay.overlay_ref = var0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)I",
      garbageValue = "17"
   )
   @Export("parseInt")
   static int parseInt(CharSequence var0, int var1, boolean var2) {
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

            int var9 = var5 * var1 + var10;
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILcw;ZI)I",
      garbageValue = "-2072279427"
   )
   static int method4442(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class82.intStack[--class56.intStackSize];
         var3 = PendingSpawn.method1612(var4);
      } else {
         var3 = var2?class285.field3789:Friend.field768;
      }

      if(var0 == 1100) {
         class56.intStackSize -= 2;
         var3.scrollX = class82.intStack[class56.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class82.intStack[class56.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         WorldMapData.method394(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class82.intStack[--class56.intStackSize];
         WorldMapData.method394(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.filled = class82.intStack[--class56.intStackSize] == 1;
         WorldMapData.method394(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class82.intStack[--class56.intStackSize];
         WorldMapData.method394(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.lineWidth = class82.intStack[--class56.intStackSize];
         WorldMapData.method394(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class82.intStack[--class56.intStackSize];
         WorldMapData.method394(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.textureId = class82.intStack[--class56.intStackSize];
         WorldMapData.method394(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.spriteTiling = class82.intStack[--class56.intStackSize] == 1;
         WorldMapData.method394(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class82.intStack[--class56.intStackSize];
         WorldMapData.method394(var3);
         return 1;
      } else if(var0 == 1109) {
         class56.intStackSize -= 6;
         var3.field2775 = class82.intStack[class56.intStackSize];
         var3.field2768 = class82.intStack[class56.intStackSize + 1];
         var3.rotationX = class82.intStack[class56.intStackSize + 2];
         var3.rotationZ = class82.intStack[class56.intStackSize + 3];
         var3.rotationY = class82.intStack[class56.intStackSize + 4];
         var3.modelZoom = class82.intStack[class56.intStackSize + 5];
         WorldMapData.method394(var3);
         return 1;
      } else {
         int var9;
         if(var0 == 1110) {
            var9 = class82.intStack[--class56.intStackSize];
            if(var9 != var3.field2773) {
               var3.field2773 = var9;
               var3.field2737 = 0;
               var3.field2849 = 0;
               WorldMapData.method394(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2783 = class82.intStack[--class56.intStackSize] == 1;
            WorldMapData.method394(var3);
            return 1;
         } else if(var0 == 1112) {
            String var8 = class82.scriptStringStack[--class24.scriptStringStackSize];
            if(!var8.equals(var3.text)) {
               var3.text = var8;
               WorldMapData.method394(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class82.intStack[--class56.intStackSize];
            WorldMapData.method394(var3);
            return 1;
         } else if(var0 == 1114) {
            class56.intStackSize -= 3;
            var3.field2853 = class82.intStack[class56.intStackSize];
            var3.field2752 = class82.intStack[class56.intStackSize + 1];
            var3.field2788 = class82.intStack[class56.intStackSize + 2];
            WorldMapData.method394(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = class82.intStack[--class56.intStackSize] == 1;
            WorldMapData.method394(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class82.intStack[--class56.intStackSize];
            WorldMapData.method394(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class82.intStack[--class56.intStackSize];
            WorldMapData.method394(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class82.intStack[--class56.intStackSize] == 1;
            WorldMapData.method394(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class82.intStack[--class56.intStackSize] == 1;
            WorldMapData.method394(var3);
            return 1;
         } else if(var0 == 1120) {
            class56.intStackSize -= 2;
            var3.scrollWidth = class82.intStack[class56.intStackSize];
            var3.scrollHeight = class82.intStack[class56.intStackSize + 1];
            WorldMapData.method394(var3);
            if(var4 != -1 && var3.type == 0) {
               class22.method179(class243.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            class35.method541(var3.id, var3.index);
            Client.field1013 = var3;
            WorldMapData.method394(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2860 = class82.intStack[--class56.intStackSize];
            WorldMapData.method394(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2753 = class82.intStack[--class56.intStackSize];
            WorldMapData.method394(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2758 = class82.intStack[--class56.intStackSize];
            WorldMapData.method394(var3);
            return 1;
         } else if(var0 == 1125) {
            var9 = class82.intStack[--class56.intStackSize];
            class292[] var6 = new class292[]{class292.field3824, class292.field3826, class292.field3822, class292.field3825, class292.field3823};
            class292 var7 = (class292)class47.forOrdinal(var6, var9);
            if(var7 != null) {
               var3.field2756 = var7;
               WorldMapData.method394(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class82.intStack[--class56.intStackSize] == 1;
            var3.field2760 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }
}
