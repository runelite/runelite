import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 165580573
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 85750075
   )
   @Export("y")
   int y;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 727456879
   )
   @Export("x")
   int x;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -647891767
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1175777285
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("w")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      intValue = -346697379
   )
   static int field1870;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-905979322"
   )
   static int method2378(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class223.method3959(class83.intStack[--class83.intStackSize]);
      } else {
         var3 = var2?class43.field582:class31.field457;
      }

      String var4 = class83.scriptStringStack[--class24.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 89) {
         int var6 = class83.intStack[--class83.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class83.intStack[--class83.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 115) {
            var8[var7] = class83.scriptStringStack[--class24.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class83.intStack[--class83.intStackSize]);
         }
      }

      var7 = class83.intStack[--class83.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.field2770 = var8;
      } else if(var0 == 1401) {
         var3.field2739 = var8;
      } else if(var0 == 1402) {
         var3.field2738 = var8;
      } else if(var0 == 1403) {
         var3.field2707 = var8;
      } else if(var0 == 1404) {
         var3.field2742 = var8;
      } else if(var0 == 1405) {
         var3.field2743 = var8;
      } else if(var0 == 1406) {
         var3.field2746 = var8;
      } else if(var0 == 1407) {
         var3.field2747 = var8;
         var3.field2748 = var5;
      } else if(var0 == 1408) {
         var3.field2753 = var8;
      } else if(var0 == 1409) {
         var3.field2657 = var8;
      } else if(var0 == 1410) {
         var3.field2744 = var8;
      } else if(var0 == 1411) {
         var3.field2701 = var8;
      } else if(var0 == 1412) {
         var3.field2703 = var8;
      } else if(var0 == 1414) {
         var3.field2749 = var8;
         var3.field2782 = var5;
      } else if(var0 == 1415) {
         var3.field2751 = var8;
         var3.field2752 = var5;
      } else if(var0 == 1416) {
         var3.field2763 = var8;
      } else if(var0 == 1417) {
         var3.field2672 = var8;
      } else if(var0 == 1418) {
         var3.field2756 = var8;
      } else if(var0 == 1419) {
         var3.field2757 = var8;
      } else if(var0 == 1420) {
         var3.field2767 = var8;
      } else if(var0 == 1421) {
         var3.field2740 = var8;
      } else if(var0 == 1422) {
         var3.field2780 = var8;
      } else if(var0 == 1423) {
         var3.field2761 = var8;
      } else if(var0 == 1424) {
         var3.field2762 = var8;
      } else if(var0 == 1425) {
         var3.field2764 = var8;
      } else if(var0 == 1426) {
         var3.field2765 = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2706 = var8;
      }

      var3.field2734 = true;
      return 1;
   }
}
