import java.awt.datatransfer.Clipboard;
import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public final class class25 extends Node {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2073402521
   )
   int field596 = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1316050481
   )
   int field597;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -977239257
   )
   int field598;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1140490575
   )
   int field599;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1370928049
   )
   int field600;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 508770245
   )
   int field601;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1229958995
   )
   int field602;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -248052739
   )
   int field603;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 32398811
   )
   int field604;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 972746845
   )
   int field605;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1150294937
   )
   int field606 = 0;
   @ObfuscatedName("pl")
   static Clipboard field608;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = 1445607713
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("v")
   static Font field610;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1347248355
   )
   static int field611;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1094854415
   )
   int field612;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1370061784"
   )
   static int method597(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = World.method670(class32.field756[--class32.field752]);
      } else {
         var3 = var2?class26.field624:class32.field754;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class32.field756[--class32.field752] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.method3243(var4, class32.scriptStringStack[--class9.scriptStringStackSize]);
            return 1;
         } else {
            --class9.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class32.field752 -= 2;
         var4 = class32.field756[class32.field752];
         int var5 = class32.field756[class32.field752 + 1];
         var3.parent = class40.method826(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2264 = class32.field756[--class32.field752] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2262 = class32.field756[--class32.field752];
         return 1;
      } else if(var0 == 1304) {
         var3.field2216 = class32.field756[--class32.field752];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class32.scriptStringStack[--class9.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.field2265 = class32.scriptStringStack[--class9.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-2122768305"
   )
   static boolean method598(String var0) {
      if(null == var0) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "75"
   )
   static final void method599(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var1 + var3; ++var4) {
         for(int var5 = var0; var5 <= var2 + var0; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class10.field111[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5 - 1][var4];
               }

               if(var2 + var0 == var5 && var5 < 103) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][1 + var5][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var1 + var3 && var4 < 103) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5][1 + var4];
               }
            }
         }
      }

   }
}
