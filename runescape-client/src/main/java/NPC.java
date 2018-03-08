import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1287585829
   )
   static int field1282;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "1003370521"
   )
   final void method1890(int var1, byte var2) {
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

      if(super.animation != -1 && class158.getAnimation(super.animation).priority == 1) {
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "2075608925"
   )
   final void method1895(int var1, int var2, boolean var3) {
      if(super.animation != -1 && class158.getAnimation(super.animation).priority == 1) {
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
      super.field1196 = 0;
      super.field1195 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field1139 * 64 + super.pathX[0] * 128;
      super.y = super.field1139 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lek;",
      garbageValue = "22"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class158.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || super.poseAnimation == super.idlePoseAnimation && var1 != null?null:class158.getAnimation(super.poseAnimation);
         Model var3 = this.composition.getModel(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.logicalHeight = var3.modelHeight;
            if(super.graphic != -1 && super.field1175 != -1) {
               Model var4 = MapLabel.getSpotAnimType(super.graphic).getModel(super.field1175);
               if(var4 != null) {
                  var4.offsetBy(0, -super.field1178, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3710 == 1) {
               var3.field1849 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1675922393"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIIB)V",
      garbageValue = "32"
   )
   public static void method1904(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method1904(var0, var1, var2, var5 - 1);
         method1904(var0, var1, var5 + 1, var3);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-569249719"
   )
   public static void method1902() {
      try {
         File var0 = new File(class167.userHome, "random.dat");
         int var2;
         if(var0.exists()) {
            class167.randomDat = new CacheFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label38:
            for(int var1 = 0; var1 < class169.field2186.length; ++var1) {
               for(var2 = 0; var2 < class19.cacheLocations.length; ++var2) {
                  File var3 = new File(class19.cacheLocations[var2] + class169.field2186[var1] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class167.randomDat = new CacheFile(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label38;
                  }
               }
            }
         }

         if(class167.randomDat == null) {
            RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
            var2 = var4.read();
            var4.seek(0L);
            var4.write(var2);
            var4.seek(0L);
            var4.close();
            class167.randomDat = new CacheFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjc;IIIZI)V",
      garbageValue = "2094308115"
   )
   public static void method1903(int var0, IndexDataBase var1, int var2, int var3, int var4, boolean var5) {
      class229.field2674 = 1;
      class229.field2672 = var1;
      class171.field2199 = var2;
      class229.field2676 = var3;
      class229.field2677 = var4;
      class85.field1294 = var5;
      class2.field13 = var0;
   }
}
