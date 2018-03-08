import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2121753603
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1983836773
   )
   @Export("height")
   int height;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1662603331
   )
   @Export("x")
   int x;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1201064895
   )
   @Export("y")
   int y;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1009009609
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2010824623
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1823542521
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 286852845
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 453037631
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1637612641
   )
   @Export("drawPriority")
   int drawPriority;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1726444151
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1860841847
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 606414333
   )
   @Export("flags")
   int flags;

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "-532153162"
   )
   static int method3072(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = GZipDecompressor.getWidget(class81.intStack[--class5.intStackSize]);
      } else {
         var3 = var2?class233.field2755:class81.field1260;
      }

      String var4 = class81.scriptStringStack[--class316.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
         int var6 = class81.intStack[--class5.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class81.intStack[--class5.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 's') {
            var8[var7] = class81.scriptStringStack[--class316.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class81.intStack[--class5.intStackSize]);
         }
      }

      var7 = class81.intStack[--class5.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.field2899 = var8;
      } else if(var0 == 1401) {
         var3.field2902 = var8;
      } else if(var0 == 1402) {
         var3.field2901 = var8;
      } else if(var0 == 1403) {
         var3.mouseEnterListener = var8;
      } else if(var0 == 1404) {
         var3.mouseExitListener = var8;
      } else if(var0 == 1405) {
         var3.field2906 = var8;
      } else if(var0 == 1406) {
         var3.field2807 = var8;
      } else if(var0 == 1407) {
         var3.configListenerArgs = var8;
         var3.configTriggers = var5;
      } else if(var0 == 1408) {
         var3.renderListener = var8;
      } else if(var0 == 1409) {
         var3.field2917 = var8;
      } else if(var0 == 1410) {
         var3.field2907 = var8;
      } else if(var0 == 1411) {
         var3.field2900 = var8;
      } else if(var0 == 1412) {
         var3.mouseHoverListener = var8;
      } else if(var0 == 1414) {
         var3.tableListenerArgs = var8;
         var3.tableModTriggers = var5;
      } else if(var0 == 1415) {
         var3.skillListenerArgs = var8;
         var3.skillTriggers = var5;
      } else if(var0 == 1416) {
         var3.field2908 = var8;
      } else if(var0 == 1417) {
         var3.scrollListener = var8;
      } else if(var0 == 1418) {
         var3.field2919 = var8;
      } else if(var0 == 1419) {
         var3.field2920 = var8;
      } else if(var0 == 1420) {
         var3.field2921 = var8;
      } else if(var0 == 1421) {
         var3.field2922 = var8;
      } else if(var0 == 1422) {
         var3.field2923 = var8;
      } else if(var0 == 1423) {
         var3.field2924 = var8;
      } else if(var0 == 1424) {
         var3.field2925 = var8;
      } else if(var0 == 1425) {
         var3.field2873 = var8;
      } else if(var0 == 1426) {
         var3.field2820 = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2926 = var8;
      }

      var3.field2878 = true;
      return 1;
   }
}
