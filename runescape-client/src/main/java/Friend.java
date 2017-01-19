import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("c")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -440131327
   )
   @Export("world")
   int world;
   @ObfuscatedName("s")
   @Export("name")
   String name;
   @ObfuscatedName("a")
   boolean field161;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 879264497
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("qn")
   protected static java.awt.Font field164;
   @ObfuscatedName("g")
   boolean field166;

   @ObfuscatedName("c")
   static final void method151(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIIS)Ljava/lang/String;",
      garbageValue = "-3905"
   )
   public static String method152(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var1 + var5] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class203.field3077[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass228;B)I",
      garbageValue = "0"
   )
   static final int method153(class228 var0) {
      if(null == var0) {
         return 12;
      } else {
         switch(var0.field3243) {
         case 6:
            return 20;
         default:
            return 12;
         }
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   static final void method154() {
      int var0 = 64 + class189.field2793 * 128;
      int var1 = class5.field57 * 128 + 64;
      int var2 = XClanMember.method223(var0, var1, class118.plane) - Renderable.field1544;
      if(XItemContainer.cameraX < var0) {
         XItemContainer.cameraX += (var0 - XItemContainer.cameraX) * class0.field3 / 1000 + class5.field59;
         if(XItemContainer.cameraX > var0) {
            XItemContainer.cameraX = var0;
         }
      }

      if(XItemContainer.cameraX > var0) {
         XItemContainer.cameraX -= class0.field3 * (XItemContainer.cameraX - var0) / 1000 + class5.field59;
         if(XItemContainer.cameraX < var0) {
            XItemContainer.cameraX = var0;
         }
      }

      if(class11.cameraZ < var2) {
         class11.cameraZ += class0.field3 * (var2 - class11.cameraZ) / 1000 + class5.field59;
         if(class11.cameraZ > var2) {
            class11.cameraZ = var2;
         }
      }

      if(class11.cameraZ > var2) {
         class11.cameraZ -= class5.field59 + class0.field3 * (class11.cameraZ - var2) / 1000;
         if(class11.cameraZ < var2) {
            class11.cameraZ = var2;
         }
      }

      if(class20.cameraY < var1) {
         class20.cameraY += class5.field59 + (var1 - class20.cameraY) * class0.field3 / 1000;
         if(class20.cameraY > var1) {
            class20.cameraY = var1;
         }
      }

      if(class20.cameraY > var1) {
         class20.cameraY -= (class20.cameraY - var1) * class0.field3 / 1000 + class5.field59;
         if(class20.cameraY < var1) {
            class20.cameraY = var1;
         }
      }

      var0 = 64 + class164.field2171 * 128;
      var1 = class180.field2705 * 128 + 64;
      var2 = XClanMember.method223(var0, var1, class118.plane) - class48.field942;
      int var3 = var0 - XItemContainer.cameraX;
      int var4 = var2 - class11.cameraZ;
      int var5 = var1 - class20.cameraY;
      int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(class13.cameraPitch < var7) {
         class13.cameraPitch += class6.field69 + (var7 - class13.cameraPitch) * class183.field2735 / 1000;
         if(class13.cameraPitch > var7) {
            class13.cameraPitch = var7;
         }
      }

      if(class13.cameraPitch > var7) {
         class13.cameraPitch -= class183.field2735 * (class13.cameraPitch - var7) / 1000 + class6.field69;
         if(class13.cameraPitch < var7) {
            class13.cameraPitch = var7;
         }
      }

      int var9 = var8 - class105.cameraYaw;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class105.cameraYaw += class183.field2735 * var9 / 1000 + class6.field69;
         class105.cameraYaw &= 2047;
      }

      if(var9 < 0) {
         class105.cameraYaw -= class6.field69 + -var9 * class183.field2735 / 1000;
         class105.cameraYaw &= 2047;
      }

      int var10 = var8 - class105.cameraYaw;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class105.cameraYaw = var8;
      }

   }
}
