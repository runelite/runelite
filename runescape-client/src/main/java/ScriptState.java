import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 390423883
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("i")
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("e")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("h")
   public static int[] field779;
   @ObfuscatedName("ej")
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("gt")
   static SpritePixels[] field781;
   @ObfuscatedName("gi")
   static SpritePixels[] field782;
   @ObfuscatedName("v")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1457115365"
   )
   static void method1052() {
      FileOnDisk var0 = null;

      try {
         var0 = class151.getPreferencesFile("", class27.field400.field3192, true);
         Buffer var1 = XGrandExchangeOffer.field303.method1586();
         var0.method2364(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method2348();
         }
      } catch (Exception var2) {
         ;
      }

   }

   ScriptState() {
      this.invokedFromPc = -1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "-1"
   )
   static int method1053(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = WorldMapType3.method199(class83.intStack[--class83.intStackSize]);
      } else {
         var3 = var2?class232.field3187:class2.field15;
      }

      String var4 = class83.scriptStringStack[--class51.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 89) {
         int var8 = class83.intStack[--class83.intStackSize];
         if(var8 > 0) {
            for(var5 = new int[var8]; var8-- > 0; var5[var8] = class83.intStack[--class83.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var6 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var6.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 115) {
            var6[var7] = class83.scriptStringStack[--class51.scriptStringStackSize];
         } else {
            var6[var7] = new Integer(class83.intStack[--class83.intStackSize]);
         }
      }

      var7 = class83.intStack[--class83.intStackSize];
      if(var7 != -1) {
         var6[0] = new Integer(var7);
      } else {
         var6 = null;
      }

      if(var0 == 1400) {
         var3.field2733 = var6;
      } else if(var0 == 1401) {
         var3.field2744 = var6;
      } else if(var0 == 1402) {
         var3.field2735 = var6;
      } else if(var0 == 1403) {
         var3.field2737 = var6;
      } else if(var0 == 1404) {
         var3.field2739 = var6;
      } else if(var0 == 1405) {
         var3.field2740 = var6;
      } else if(var0 == 1406) {
         var3.field2648 = var6;
      } else if(var0 == 1407) {
         var3.field2729 = var6;
         var3.field2745 = var5;
      } else if(var0 == 1408) {
         var3.field2750 = var6;
      } else if(var0 == 1409) {
         var3.field2751 = var6;
      } else if(var0 == 1410) {
         var3.field2741 = var6;
      } else if(var0 == 1411) {
         var3.field2734 = var6;
      } else if(var0 == 1412) {
         var3.field2738 = var6;
      } else if(var0 == 1414) {
         var3.field2746 = var6;
         var3.field2747 = var5;
      } else if(var0 == 1415) {
         var3.field2748 = var6;
         var3.field2770 = var5;
      } else if(var0 == 1416) {
         var3.field2773 = var6;
      } else if(var0 == 1417) {
         var3.field2752 = var6;
      } else if(var0 == 1418) {
         var3.field2657 = var6;
      } else if(var0 == 1419) {
         var3.field2731 = var6;
      } else if(var0 == 1420) {
         var3.field2757 = var6;
      } else if(var0 == 1421) {
         var3.field2669 = var6;
      } else if(var0 == 1422) {
         var3.field2725 = var6;
      } else if(var0 == 1423) {
         var3.field2758 = var6;
      } else if(var0 == 1424) {
         var3.field2759 = var6;
      } else if(var0 == 1425) {
         var3.field2761 = var6;
      } else if(var0 == 1426) {
         var3.field2762 = var6;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2760 = var6;
      }

      var3.field2726 = true;
      return 1;
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZB)V",
      garbageValue = "4"
   )
   static final void method1054(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         class37.method487(var2);
      }

      for(class198 var4 = (class198)Client.widgetFlags.method3518(); var4 != null; var4 = (class198)Client.widgetFlags.method3524()) {
         if((var4.hash >> 48 & 65535L) == (long)var2) {
            var4.unlink();
         }
      }

      Widget var5 = WorldMapType3.method199(var3);
      if(var5 != null) {
         class25.method169(var5);
      }

      MessageNode.method1108();
      if(Client.widgetRoot != -1) {
         class158.method2978(Client.widgetRoot, 1);
      }

   }
}
