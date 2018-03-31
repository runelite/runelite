import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
public class class88 {
   @ObfuscatedName("c")
   static final BigInteger field1330;
   @ObfuscatedName("i")
   static final BigInteger field1326;

   static {
      field1330 = new BigInteger("10001", 16);
      field1326 = new BigInteger("972ec975ec994121fc43ba6a1869a9ed0d590a506ffc75333d270677fadd618bb97e15839ae201cf23bd48dc25cc44cd14936ae07aab269c372fa8ae1a6fd14d6b69b97ed51eb1a00de131d0ecb92afea4e6fa34cf3b796ca432c190ff59a203fa84a44ce6f5c1bcc99dcb15069a1ef73b6b44869669df4775ba3443b7543149", 16);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-9495575"
   )
   @Export("getVarbit")
   public static int getVarbit(int var0) {
      Varbit var1 = class290.method5206(var0);
      int var2 = var1.configId;
      int var3 = var1.leastSignificantBit;
      int var4 = var1.mostSignificantBit;
      int var5 = class237.varpsMasks[var4 - var3];
      return class237.clientVarps[var2] >> var3 & var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lkw;Lkw;I)V",
      garbageValue = "-80484770"
   )
   static void method1852(Font var0, Font var1) {
      if(class25.field356 == null) {
         class25.field356 = class316.getSprites(class44.indexSprites, "sl_back", "");
      }

      if(class90.slFlagSprites == null) {
         class90.slFlagSprites = class199.getIndexedSprites(class44.indexSprites, "sl_flags", "");
      }

      if(AbstractSoundSystem.slArrowSprites == null) {
         AbstractSoundSystem.slArrowSprites = class199.getIndexedSprites(class44.indexSprites, "sl_arrows", "");
      }

      if(class157.slStarSprites == null) {
         class157.slStarSprites = class199.getIndexedSprites(class44.indexSprites, "sl_stars", "");
      }

      Rasterizer2D.Rasterizer2D_fillRectangle(class90.field1338, 23, 765, 480, 0);
      Rasterizer2D.method5746(class90.field1338, 0, 125, 23, 12425273, 9135624);
      Rasterizer2D.method5746(class90.field1338 + 125, 0, 640, 23, 5197647, 2697513);
      var0.drawTextCentered("Select a world", class90.field1338 + 62, 15, 0, -1);
      if(class157.slStarSprites != null) {
         class157.slStarSprites[1].method5842(class90.field1338 + 140, 1);
         var1.method5521("Members only world", class90.field1338 + 152, 10, 16777215, -1);
         class157.slStarSprites[0].method5842(class90.field1338 + 140, 12);
         var1.method5521("Free world", class90.field1338 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(AbstractSoundSystem.slArrowSprites != null) {
         int var2 = class90.field1338 + 280;
         if(World.field1220[0] == 0 && World.field1224[0] == 0) {
            AbstractSoundSystem.slArrowSprites[2].method5842(var2, 4);
         } else {
            AbstractSoundSystem.slArrowSprites[0].method5842(var2, 4);
         }

         if(World.field1220[0] == 0 && World.field1224[0] == 1) {
            AbstractSoundSystem.slArrowSprites[3].method5842(var2 + 15, 4);
         } else {
            AbstractSoundSystem.slArrowSprites[1].method5842(var2 + 15, 4);
         }

         var0.method5521("World", var2 + 32, 17, 16777215, -1);
         int var3 = class90.field1338 + 390;
         if(World.field1220[0] == 1 && World.field1224[0] == 0) {
            AbstractSoundSystem.slArrowSprites[2].method5842(var3, 4);
         } else {
            AbstractSoundSystem.slArrowSprites[0].method5842(var3, 4);
         }

         if(World.field1220[0] == 1 && World.field1224[0] == 1) {
            AbstractSoundSystem.slArrowSprites[3].method5842(var3 + 15, 4);
         } else {
            AbstractSoundSystem.slArrowSprites[1].method5842(var3 + 15, 4);
         }

         var0.method5521("Players", var3 + 32, 17, 16777215, -1);
         var4 = class90.field1338 + 500;
         if(World.field1220[0] == 2 && World.field1224[0] == 0) {
            AbstractSoundSystem.slArrowSprites[2].method5842(var4, 4);
         } else {
            AbstractSoundSystem.slArrowSprites[0].method5842(var4, 4);
         }

         if(World.field1220[0] == 2 && World.field1224[0] == 1) {
            AbstractSoundSystem.slArrowSprites[3].method5842(var4 + 15, 4);
         } else {
            AbstractSoundSystem.slArrowSprites[1].method5842(var4 + 15, 4);
         }

         var0.method5521("Location", var4 + 32, 17, 16777215, -1);
         var5 = class90.field1338 + 610;
         if(World.field1220[0] == 3 && World.field1224[0] == 0) {
            AbstractSoundSystem.slArrowSprites[2].method5842(var5, 4);
         } else {
            AbstractSoundSystem.slArrowSprites[0].method5842(var5, 4);
         }

         if(World.field1220[0] == 3 && World.field1224[0] == 1) {
            AbstractSoundSystem.slArrowSprites[3].method5842(var5 + 15, 4);
         } else {
            AbstractSoundSystem.slArrowSprites[1].method5842(var5 + 15, 4);
         }

         var0.method5521("Type", var5 + 32, 17, 16777215, -1);
      }

      Rasterizer2D.Rasterizer2D_fillRectangle(class90.field1338 + 708, 4, 50, 16, 0);
      var1.drawTextCentered("Cancel", class90.field1338 + 708 + 25, 16, 16777215, -1);
      class90.field1372 = -1;
      if(class25.field356 != null) {
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
         int var11 = var8 + class90.field1338;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < World.worldCount; ++var14) {
            World var15 = FaceNormal.worldList[var14];
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
            if(var15.method1613()) {
               if(var15.method1614()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method1612()) {
               var19 = 16711680;
               if(var15.method1614()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method1610()) {
               if(var15.method1614()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method1614()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(MouseInput.mouseLastX >= var11 && MouseInput.mouseLastY >= var10 && MouseInput.mouseLastX < var11 + var21 && MouseInput.mouseLastY < var22 + var10 && var16) {
               class90.field1372 = var14;
               class25.field356[var18].method5873(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class25.field356[var18].method5868(var11, var10);
            }

            if(class90.slFlagSprites != null) {
               class90.slFlagSprites[(var15.method1614()?8:0) + var15.location].method5842(var11 + 29, var10);
            }

            var0.drawTextCentered(Integer.toString(var15.id), var11 + 15, var22 / 2 + var10 + 5, var19, -1);
            var1.drawTextCentered(var17, var11 + 60, var22 / 2 + var10 + 5, 268435455, -1);
            var10 = var10 + var22 + var7;
            ++var12;
            if(var12 >= var5) {
               var10 = var9 + 23;
               var11 = var11 + var6 + var21;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.getTextWidth(FaceNormal.worldList[class90.field1372].activity) + 6;
            int var20 = var1.verticalSpace + 8;
            Rasterizer2D.Rasterizer2D_fillRectangle(MouseInput.mouseLastX - var14 / 2, MouseInput.mouseLastY + 20 + 5, var14, var20, 16777120);
            Rasterizer2D.drawRectangle(MouseInput.mouseLastX - var14 / 2, MouseInput.mouseLastY + 20 + 5, var14, var20, 0);
            var1.drawTextCentered(FaceNormal.worldList[class90.field1372].activity, MouseInput.mouseLastX, MouseInput.mouseLastY + var1.verticalSpace + 20 + 5 + 4, 0, -1);
         }
      }

      class324.rasterProvider.drawFull(0, 0);
   }
}
