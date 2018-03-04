import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("ContextMenuRow")
public class ContextMenuRow {
   @ObfuscatedName("qc")
   @ObfuscatedSignature(
      signature = "Lcd;"
   )
   @Export("friendManager")
   public static FriendManager friendManager;
   @ObfuscatedName("qk")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   @Export("indexStore255")
   static IndexFile indexStore255;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 178160075
   )
   @Export("param0")
   int param0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1705035535
   )
   @Export("type")
   int type;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -560440933
   )
   @Export("param1")
   int param1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1075370855
   )
   @Export("identifier")
   int identifier;
   @ObfuscatedName("e")
   @Export("option")
   String option;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILct;ZI)I",
      garbageValue = "975135712"
   )
   static int method1893(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class5.getWidget(class81.intStack[--class81.intStackSize]);
      } else {
         var3 = var2?class20.field338:class81.field1267;
      }

      String var4 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
         int var6 = class81.intStack[--class81.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class81.intStack[--class81.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 's') {
            var8[var7] = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class81.intStack[--class81.intStackSize]);
         }
      }

      var7 = class81.intStack[--class81.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.field2907 = var8;
      } else if(var0 == 1401) {
         var3.field2910 = var8;
      } else if(var0 == 1402) {
         var3.field2858 = var8;
      } else if(var0 == 1403) {
         var3.mouseEnterListener = var8;
      } else if(var0 == 1404) {
         var3.mouseExitListener = var8;
      } else if(var0 == 1405) {
         var3.field2914 = var8;
      } else if(var0 == 1406) {
         var3.field2814 = var8;
      } else if(var0 == 1407) {
         var3.configListenerArgs = var8;
         var3.configTriggers = var5;
      } else if(var0 == 1408) {
         var3.renderListener = var8;
      } else if(var0 == 1409) {
         var3.field2925 = var8;
      } else if(var0 == 1410) {
         var3.field2841 = var8;
      } else if(var0 == 1411) {
         var3.field2908 = var8;
      } else if(var0 == 1412) {
         var3.mouseHoverListener = var8;
      } else if(var0 == 1414) {
         var3.tableListenerArgs = var8;
         var3.tableModTriggers = var5;
      } else if(var0 == 1415) {
         var3.skillListenerArgs = var8;
         var3.skillTriggers = var5;
      } else if(var0 == 1416) {
         var3.field2916 = var8;
      } else if(var0 == 1417) {
         var3.scrollListener = var8;
      } else if(var0 == 1418) {
         var3.field2828 = var8;
      } else if(var0 == 1419) {
         var3.field2906 = var8;
      } else if(var0 == 1420) {
         var3.field2929 = var8;
      } else if(var0 == 1421) {
         var3.field2930 = var8;
      } else if(var0 == 1422) {
         var3.field2931 = var8;
      } else if(var0 == 1423) {
         var3.field2932 = var8;
      } else if(var0 == 1424) {
         var3.field2933 = var8;
      } else if(var0 == 1425) {
         var3.field2935 = var8;
      } else if(var0 == 1426) {
         var3.field2936 = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2934 = var8;
      }

      var3.field2905 = true;
      return 1;
   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1459427956"
   )
   static void method1894() {
      if(Client.field969) {
         VertexNormal.method2844(TotalQuantityComparator.localPlayer, false);
      }

   }
}
