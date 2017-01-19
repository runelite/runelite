import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -69232727
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1079754001
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -36391029
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 405206785
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1188045515
   )
   public static int field1298;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = -1488835639
   )
   static int field1301;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -616493863
   )
   @Export("x")
   int x;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "17200993"
   )
   public static void method1503() {
      try {
         File var0 = new File(class104.field1692, "random.dat");
         int var2;
         if(var0.exists()) {
            class104.field1684 = new class72(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label39:
            for(int var1 = 0; var1 < class104.field1690.length; ++var1) {
               for(var2 = 0; var2 < ItemLayer.field1210.length; ++var2) {
                  File var3 = new File(ItemLayer.field1210[var2] + class104.field1690[var1] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class104.field1684 = new class72(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label39;
                  }
               }
            }
         }

         if(null == class104.field1684) {
            RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
            var2 = var4.read();
            var4.seek(0L);
            var4.write(var2);
            var4.seek(0L);
            var4.close();
            class104.field1684 = new class72(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-467208873"
   )
   static final void method1504(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.field658 == 0) {
         var0.field647 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var10 = class110.getAnimation(var0.animation);
            if(var0.field663 > 0 && var10.precedenceAnimating == 0) {
               ++var0.field647;
               return;
            }

            if(var0.field663 <= 0 && var10.priority == 0) {
               ++var0.field647;
               return;
            }
         }

         int var1 = var0.x;
         int var2 = var0.y;
         int var3 = var0.field645 * 64 + var0.pathX[var0.field658 - 1] * 128;
         int var4 = var0.pathY[var0.field658 - 1] * 128 + var0.field645 * 64;
         if(var1 < var3) {
            if(var2 < var4) {
               var0.field655 = 1280;
            } else if(var2 > var4) {
               var0.field655 = 1792;
            } else {
               var0.field655 = 1536;
            }
         } else if(var1 > var3) {
            if(var2 < var4) {
               var0.field655 = 768;
            } else if(var2 > var4) {
               var0.field655 = 256;
            } else {
               var0.field655 = 512;
            }
         } else if(var2 < var4) {
            var0.field655 = 1024;
         } else if(var2 > var4) {
            var0.field655 = 0;
         }

         byte var5 = var0.field624[var0.field658 - 1];
         if(var3 - var1 <= 256 && var3 - var1 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.field655 - var0.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field613;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field636;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field615;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field614;
            }

            if(var7 == -1) {
               var7 = var0.field636;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.field655 != var0.angle && var0.interacting == -1 && var0.field646 != 0) {
                  var8 = 2;
               }

               if(var0.field658 > 2) {
                  var8 = 6;
               }

               if(var0.field658 > 3) {
                  var8 = 8;
               }

               if(var0.field647 > 0 && var0.field658 > 1) {
                  var8 = 8;
                  --var0.field647;
               }
            } else {
               if(var0.field658 > 1) {
                  var8 = 6;
               }

               if(var0.field658 > 2) {
                  var8 = 8;
               }

               if(var0.field647 > 0 && var0.field658 > 1) {
                  var8 = 8;
                  --var0.field647;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.poseAnimation == var0.field636 && var0.field639 != -1) {
               var0.poseAnimation = var0.field639;
            }

            if(var3 != var1 || var2 != var4) {
               if(var1 < var3) {
                  var0.x += var8;
                  if(var0.x > var3) {
                     var0.x = var3;
                  }
               } else if(var1 > var3) {
                  var0.x -= var8;
                  if(var0.x < var3) {
                     var0.x = var3;
                  }
               }

               if(var2 < var4) {
                  var0.y += var8;
                  if(var0.y > var4) {
                     var0.y = var4;
                  }
               } else if(var2 > var4) {
                  var0.y -= var8;
                  if(var0.y < var4) {
                     var0.y = var4;
                  }
               }
            }

            if(var3 == var0.x && var0.y == var4) {
               --var0.field658;
               if(var0.field663 > 0) {
                  --var0.field663;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.field658;
            if(var0.field663 > 0) {
               --var0.field663;
            }

         }
      }
   }
}
