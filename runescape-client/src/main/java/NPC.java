import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("f")
   @Export("userHome")
   static String userHome;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1644967891
   )
   static int field1318;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IBB)V",
      garbageValue = "12"
   )
   final void method1873(int var1, byte var2) {
      int var3 = super.pathX[0];
      int var4 = super.pathY[0];
      if(var1 == 0) {
         --var3;
         ++var4;
      }

      if(var1 == 1) {
         ++var4;
      }

      if(var1 == 2) {
         ++var3;
         ++var4;
      }

      if(var1 == 3) {
         --var3;
      }

      if(var1 == 4) {
         ++var3;
      }

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(var1 == 6) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(super.animation != -1 && CombatInfo1.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var5 = super.queueSize; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.pathTraversed[var5] = super.pathTraversed[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.pathTraversed[0] = var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "48"
   )
   final void method1874(int var1, int var2, boolean var3) {
      if(super.animation != -1 && CombatInfo1.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.queueSize < 9) {
               ++super.queueSize;
            }

            for(int var6 = super.queueSize; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.pathTraversed[var6] = super.pathTraversed[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.pathTraversed[0] = 1;
            return;
         }
      }

      super.queueSize = 0;
      super.field1216 = 0;
      super.field1158 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field1172 * 64 + super.pathX[0] * 128;
      super.y = super.field1172 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lei;",
      garbageValue = "1329079562"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?CombatInfo1.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || super.idlePoseAnimation == super.poseAnimation && var1 != null?null:CombatInfo1.getAnimation(super.poseAnimation);
         Model var3 = this.composition.getModel(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.logicalHeight = var3.modelHeight;
            if(super.graphic != -1 && super.spotAnimFrame != -1) {
               Model var4 = class86.getSpotAnimType(super.graphic).getModel(super.spotAnimFrame);
               if(var4 != null) {
                  var4.offsetBy(0, -super.field1198, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.size == 1) {
               var3.field1874 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1204510929"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IILfr;Lfb;B)Z",
      garbageValue = "-108"
   )
   static final boolean method1878(int var0, int var1, class178 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class177.field2285[var6][var7] = 99;
      class177.field2286[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class177.field2290[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class177.field2287[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class177.field2290[var11];
         var5 = class177.field2287[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod3428(1, var4, var5, var3)) {
            class177.field2283 = var4;
            class177.field2289 = var5;
            return true;
         }

         int var15 = class177.field2286[var16][var17] + 1;
         if(var16 > 0 && class177.field2285[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class177.field2290[var18] = var4 - 1;
            class177.field2287[var18] = var5;
            var18 = var18 + 1 & 4095;
            class177.field2285[var16 - 1][var17] = 2;
            class177.field2286[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class177.field2285[var16 + 1][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
            class177.field2290[var18] = var4 + 1;
            class177.field2287[var18] = var5;
            var18 = var18 + 1 & 4095;
            class177.field2285[var16 + 1][var17] = 8;
            class177.field2286[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class177.field2285[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class177.field2290[var18] = var4;
            class177.field2287[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class177.field2285[var16][var17 - 1] = 1;
            class177.field2286[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class177.field2285[var16][var17 + 1] == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class177.field2290[var18] = var4;
            class177.field2287[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class177.field2285[var16][var17 + 1] = 4;
            class177.field2286[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class177.field2285[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class177.field2290[var18] = var4 - 1;
            class177.field2287[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class177.field2285[var16 - 1][var17 - 1] = 3;
            class177.field2286[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && class177.field2285[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class177.field2290[var18] = var4 + 1;
            class177.field2287[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class177.field2285[var16 + 1][var17 - 1] = 9;
            class177.field2286[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && class177.field2285[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class177.field2290[var18] = var4 - 1;
            class177.field2287[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class177.field2285[var16 - 1][var17 + 1] = 6;
            class177.field2286[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 127 && var17 < 127 && class177.field2285[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 1] & 19136992) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class177.field2290[var18] = var4 + 1;
            class177.field2287[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class177.field2285[var16 + 1][var17 + 1] = 12;
            class177.field2286[var16 + 1][var17 + 1] = var15;
         }
      }

      class177.field2283 = var4;
      class177.field2289 = var5;
      return false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZB)Ldi;",
      garbageValue = "0"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(class241.field2807, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(BoundingBox.field253 == 33) {
         var4 = "_rc";
      } else if(BoundingBox.field253 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(userHome, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }
}
