import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
public class class87 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lds;"
   )
   public static class111 field1316;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lhx;",
      garbageValue = "-1103237674"
   )
   @Export("getWidget")
   public static Widget getWidget(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & 65535;
      if(class11.widgets[var1] == null || class11.widgets[var1][var2] == null) {
         boolean var3 = ISAACCipher.loadWidget(var1);
         if(!var3) {
            return null;
         }
      }

      return class11.widgets[var1][var2];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-35"
   )
   static final boolean method1763() {
      return class133.Viewport_containsMouse;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lcw;Lcw;IZI)I",
      garbageValue = "-167427725"
   )
   static int method1761(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1597()?(var1.method1597()?0:1):(var1.method1597()?-1:0)):(var2 == 5?(var0.method1595()?(var1.method1595()?0:1):(var1.method1595()?-1:0)):(var2 == 6?(var0.method1627()?(var1.method1627()?0:1):(var1.method1627()?-1:0)):(var2 == 7?(var0.method1624()?(var1.method1624()?0:1):(var1.method1624()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lkl;I)V",
      garbageValue = "-657120224"
   )
   static final void method1753(IndexedSprite var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class234.field3220.length; ++var2) {
         class234.field3220[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class234.field3220[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               BuildType.field3261[var5] = (class234.field3220[var5 - 128] + class234.field3220[var5 + 1] + class234.field3220[var5 + 128] + class234.field3220[var5 - 1]) / 4;
            }
         }

         int[] var8 = class234.field3220;
         class234.field3220 = BuildType.field3261;
         BuildType.field3261 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + var0.offsetX + 16;
                  int var6 = var3 + var0.offsetY + 16;
                  int var7 = var5 + (var6 << 7);
                  class234.field3220[var7] = 0;
               }
            }
         }
      }

   }
}
