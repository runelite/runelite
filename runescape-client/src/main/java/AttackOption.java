import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("AttackOption")
public enum AttackOption implements Enumerated {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lcp;"
   )
   @Export("AttackOption_dependsOnCombatLevels")
   AttackOption_dependsOnCombatLevels(0),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lcp;"
   )
   @Export("AttackOption_alwaysRightClick")
   AttackOption_alwaysRightClick(1),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lcp;"
   )
   @Export("AttackOption_leftClickWhereAvailable")
   AttackOption_leftClickWhereAvailable(2),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lcp;"
   )
   @Export("AttackOption_hidden")
   AttackOption_hidden(3);

   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1285964519
   )
   static int field1316;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 179959561
   )
   @Export("id")
   final int id;

   AttackOption(int var3) {
      this.id = var3;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "744101166"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILcf;ZI)I",
      garbageValue = "-788255131"
   )
   static int method1887(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class216.getWidget(class80.intStack[--class80.intStackSize]);
      } else {
         var3 = var2?class94.field1418:ItemLayer.field1668;
      }

      String var4 = class80.scriptStringStack[--class294.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
         int var6 = class80.intStack[--class80.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class80.intStack[--class80.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 's') {
            var8[var7] = class80.scriptStringStack[--class294.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class80.intStack[--class80.intStackSize]);
         }
      }

      var7 = class80.intStack[--class80.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.field2836 = var8;
      } else if(var0 == 1401) {
         var3.field2839 = var8;
      } else if(var0 == 1402) {
         var3.field2825 = var8;
      } else if(var0 == 1403) {
         var3.mouseEnterListener = var8;
      } else if(var0 == 1404) {
         var3.mouseExitListener = var8;
      } else if(var0 == 1405) {
         var3.field2843 = var8;
      } else if(var0 == 1406) {
         var3.field2781 = var8;
      } else if(var0 == 1407) {
         var3.configListenerArgs = var8;
         var3.configTriggers = var5;
      } else if(var0 == 1408) {
         var3.renderListener = var8;
      } else if(var0 == 1409) {
         var3.field2846 = var8;
      } else if(var0 == 1410) {
         var3.field2853 = var8;
      } else if(var0 == 1411) {
         var3.field2837 = var8;
      } else if(var0 == 1412) {
         var3.mouseHoverListener = var8;
      } else if(var0 == 1414) {
         var3.tableListenerArgs = var8;
         var3.tableModTriggers = var5;
      } else if(var0 == 1415) {
         var3.skillListenerArgs = var8;
         var3.skillTriggers = var5;
      } else if(var0 == 1416) {
         var3.field2845 = var8;
      } else if(var0 == 1417) {
         var3.scrollListener = var8;
      } else if(var0 == 1418) {
         var3.field2856 = var8;
      } else if(var0 == 1419) {
         var3.field2857 = var8;
      } else if(var0 == 1420) {
         var3.field2858 = var8;
      } else if(var0 == 1421) {
         var3.field2859 = var8;
      } else if(var0 == 1422) {
         var3.field2883 = var8;
      } else if(var0 == 1423) {
         var3.field2861 = var8;
      } else if(var0 == 1424) {
         var3.field2800 = var8;
      } else if(var0 == 1425) {
         var3.field2759 = var8;
      } else if(var0 == 1426) {
         var3.field2833 = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2812 = var8;
      }

      var3.field2834 = true;
      return 1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-1482797632"
   )
   public static boolean method1885(char var0) {
      return var0 >= ' ' && var0 <= '~'?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }

   @ObfuscatedName("km")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1356048669"
   )
   static String method1886(String var0) {
      Permission[] var1 = class131.method2805();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         Permission var3 = var1[var2];
         if(var3.field3270 != -1) {
            int var6 = var3.field3270;
            String var5 = "<img=" + var6 + ">";
            if(var0.startsWith(var5)) {
               var0 = var0.substring(6 + Integer.toString(var3.field3270).length());
               break;
            }
         }
      }

      return var0;
   }
}
