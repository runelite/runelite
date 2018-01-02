import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.File;
import java.util.Hashtable;

@ObfuscatedName("fm")
public class class160 {
   @ObfuscatedName("a")
   static boolean field2150;
   @ObfuscatedName("w")
   static File field2148;
   @ObfuscatedName("e")
   static Hashtable field2149;
   @ObfuscatedName("v")
   @Export("tt")
   static int[] tt;
   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "Lkg;"
   )
   static IndexedSprite field2151;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = -1636862767
   )
   @Export("cameraPitch")
   static int cameraPitch;

   static {
      field2150 = false;
      field2149 = new Hashtable(16);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljm;Ljm;I)V",
      garbageValue = "1778722135"
   )
   static void method3048(Font var0, Font var1) {
      if(FriendLoginUpdate.field760 == null) {
         FriendLoginUpdate.field760 = KeyFocusListener.getSprites(class43.indexSprites, "sl_back", "");
      }

      if(SpritePixels2.slFlagSprites == null) {
         SpritePixels2.slFlagSprites = Signlink.getIndexedSprites(class43.indexSprites, "sl_flags", "");
      }

      if(class7.slArrowSprites == null) {
         class7.slArrowSprites = Signlink.getIndexedSprites(class43.indexSprites, "sl_arrows", "");
      }

      if(class37.slStarSprites == null) {
         class37.slStarSprites = Signlink.getIndexedSprites(class43.indexSprites, "sl_stars", "");
      }

      Rasterizer2D.Rasterizer2D_fillRectangle(class91.field1351, 23, 765, 480, 0);
      Rasterizer2D.method5094(class91.field1351, 0, 125, 23, 12425273, 9135624);
      Rasterizer2D.method5094(class91.field1351 + 125, 0, 640, 23, 5197647, 2697513);
      var0.method4884("Select a world", class91.field1351 + 62, 15, 0, -1);
      if(class37.slStarSprites != null) {
         class37.slStarSprites[1].method5176(class91.field1351 + 140, 1);
         var1.method4891("Members only world", class91.field1351 + 152, 10, 16777215, -1);
         class37.slStarSprites[0].method5176(class91.field1351 + 140, 12);
         var1.method4891("Free world", class91.field1351 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(class7.slArrowSprites != null) {
         int var2 = class91.field1351 + 280;
         if(World.field1203[0] == 0 && World.field1197[0] == 0) {
            class7.slArrowSprites[2].method5176(var2, 4);
         } else {
            class7.slArrowSprites[0].method5176(var2, 4);
         }

         if(World.field1203[0] == 0 && World.field1197[0] == 1) {
            class7.slArrowSprites[3].method5176(var2 + 15, 4);
         } else {
            class7.slArrowSprites[1].method5176(var2 + 15, 4);
         }

         var0.method4891("World", var2 + 32, 17, 16777215, -1);
         int var3 = class91.field1351 + 390;
         if(World.field1203[0] == 1 && World.field1197[0] == 0) {
            class7.slArrowSprites[2].method5176(var3, 4);
         } else {
            class7.slArrowSprites[0].method5176(var3, 4);
         }

         if(World.field1203[0] == 1 && World.field1197[0] == 1) {
            class7.slArrowSprites[3].method5176(var3 + 15, 4);
         } else {
            class7.slArrowSprites[1].method5176(var3 + 15, 4);
         }

         var0.method4891("Players", var3 + 32, 17, 16777215, -1);
         var4 = class91.field1351 + 500;
         if(World.field1203[0] == 2 && World.field1197[0] == 0) {
            class7.slArrowSprites[2].method5176(var4, 4);
         } else {
            class7.slArrowSprites[0].method5176(var4, 4);
         }

         if(World.field1203[0] == 2 && World.field1197[0] == 1) {
            class7.slArrowSprites[3].method5176(var4 + 15, 4);
         } else {
            class7.slArrowSprites[1].method5176(var4 + 15, 4);
         }

         var0.method4891("Location", var4 + 32, 17, 16777215, -1);
         var5 = class91.field1351 + 610;
         if(World.field1203[0] == 3 && World.field1197[0] == 0) {
            class7.slArrowSprites[2].method5176(var5, 4);
         } else {
            class7.slArrowSprites[0].method5176(var5, 4);
         }

         if(World.field1203[0] == 3 && World.field1197[0] == 1) {
            class7.slArrowSprites[3].method5176(var5 + 15, 4);
         } else {
            class7.slArrowSprites[1].method5176(var5 + 15, 4);
         }

         var0.method4891("Type", var5 + 32, 17, 16777215, -1);
      }

      Rasterizer2D.Rasterizer2D_fillRectangle(class91.field1351 + 708, 4, 50, 16, 0);
      var1.method4884("Cancel", class91.field1351 + 708 + 25, 16, 16777215, -1);
      class91.field1326 = -1;
      if(FriendLoginUpdate.field760 != null) {
         byte var21 = 88;
         byte var22 = 19;
         var4 = 765 / (var21 + 1);
         var5 = 480 / (var22 + 1);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if(var5 * (var4 - 1) >= World.worldCount) {
               --var4;
            }

            if(var4 * (var5 - 1) >= World.worldCount) {
               --var5;
            }

            if(var4 * (var5 - 1) >= World.worldCount) {
               --var5;
            }
         } while(var5 != var6 || var7 != var4);

         var6 = (765 - var21 * var4) / (var4 + 1);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var5 * var22) / (var5 + 1);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var21 * var4 - var6 * (var4 - 1)) / 2;
         int var9 = (480 - var5 * var22 - var7 * (var5 - 1)) / 2;
         int var10 = var9 + 23;
         int var11 = var8 + class91.field1351;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < World.worldCount; ++var14) {
            World var15 = ItemContainer.worldList[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.playerCount);
            if(var15.playerCount == -1) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.playerCount > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method1498()) {
               if(var15.method1518()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method1497()) {
               var19 = 16711680;
               if(var15.method1518()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method1495()) {
               if(var15.method1518()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method1518()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(MouseInput.field679 >= var11 && MouseInput.field682 * -469125321 >= var10 && MouseInput.field679 < var11 + var21 && MouseInput.field682 * -469125321 < var22 + var10 && var16) {
               class91.field1326 = var14;
               FriendLoginUpdate.field760[var18].method5254(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               FriendLoginUpdate.field760[var18].method5203(var11, var10);
            }

            if(SpritePixels2.slFlagSprites != null) {
               SpritePixels2.slFlagSprites[(var15.method1518()?8:0) + var15.location].method5176(var11 + 29, var10);
            }

            var0.method4884(Integer.toString(var15.id), var11 + 15, var22 / 2 + var10 + 5, var19, -1);
            var1.method4884(var17, var11 + 60, var22 / 2 + var10 + 5, 268435455, -1);
            var10 = var10 + var22 + var7;
            ++var12;
            if(var12 >= var5) {
               var10 = var9 + 23;
               var11 = var11 + var21 + var6;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method4886(ItemContainer.worldList[class91.field1326].activity) + 6;
            int var20 = var1.verticalSpace + 8;
            Rasterizer2D.Rasterizer2D_fillRectangle(MouseInput.field679 - var14 / 2, MouseInput.field682 * -469125321 + 20 + 5, var14, var20, 16777120);
            Rasterizer2D.drawRectangle(MouseInput.field679 - var14 / 2, MouseInput.field682 * -469125321 + 20 + 5, var14, var20, 0);
            var1.method4884(ItemContainer.worldList[class91.field1326].activity, MouseInput.field679, var1.verticalSpace + MouseInput.field682 * -469125321 + 20 + 5 + 4, 0, -1);
         }
      }

      ScriptState.rasterProvider.drawFull(0, 0);
   }
}
