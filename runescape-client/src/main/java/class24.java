import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public class class24 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ln;"
   )
   public static final class24 field364;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ln;"
   )
   public static final class24 field362;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ln;"
   )
   public static final class24 field366;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1873986189
   )
   final int field367;
   @ObfuscatedName("p")
   final String field363;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -609654029
   )
   final int field365;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1891928013
   )
   final int field361;

   static {
      field364 = new class24("SMALL", 0, 0, 4);
      field362 = new class24("MEDIUM", 1, 1, 2);
      field366 = new class24("LARGE", 2, 2, 0);
   }

   class24(String var1, int var2, int var3, int var4) {
      this.field363 = var1;
      this.field365 = var2;
      this.field361 = var3;
      this.field367 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(FI)Z",
      garbageValue = "1270846160"
   )
   boolean method165(float var1) {
      return var1 >= (float)this.field367;
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(Lcn;IIB)V",
      garbageValue = "4"
   )
   static final void method170(class87 var0, int var1, int var2) {
      class257.menuAction(var0.field1392, var0.field1391, var0.field1390, var0.field1393, var0.field1394, var0.field1394, var1, var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILcv;ZB)I",
      garbageValue = "0"
   )
   static int method171(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = PacketBuffer.method3528(class81.intStack[--class81.intStackSize]);
      } else {
         var3 = var2?class81.field1341:class81.field1340;
      }

      String var4 = class81.scriptStringStack[--class81.scriptStringStackSize];
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
            var8[var7] = class81.scriptStringStack[--class81.scriptStringStackSize];
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
         var3.field2655 = var8;
      } else if(var0 == 1401) {
         var3.field2783 = var8;
      } else if(var0 == 1402) {
         var3.field2742 = var8;
      } else if(var0 == 1403) {
         var3.mouseEnterListener = var8;
      } else if(var0 == 1404) {
         var3.mouseExitListener = var8;
      } else if(var0 == 1405) {
         var3.field2747 = var8;
      } else if(var0 == 1406) {
         var3.field2750 = var8;
      } else if(var0 == 1407) {
         var3.configListenerArgs = var8;
         var3.configTriggers = var5;
      } else if(var0 == 1408) {
         var3.renderListener = var8;
      } else if(var0 == 1409) {
         var3.field2758 = var8;
      } else if(var0 == 1410) {
         var3.field2748 = var8;
      } else if(var0 == 1411) {
         var3.field2741 = var8;
      } else if(var0 == 1412) {
         var3.mouseHoverListener = var8;
      } else if(var0 == 1414) {
         var3.tableListenerArgs = var8;
         var3.tableModTriggers = var5;
      } else if(var0 == 1415) {
         var3.skillListenerArgs = var8;
         var3.skillTriggers = var5;
      } else if(var0 == 1416) {
         var3.field2749 = var8;
      } else if(var0 == 1417) {
         var3.scrollListener = var8;
      } else if(var0 == 1418) {
         var3.field2760 = var8;
      } else if(var0 == 1419) {
         var3.field2761 = var8;
      } else if(var0 == 1420) {
         var3.field2653 = var8;
      } else if(var0 == 1421) {
         var3.field2691 = var8;
      } else if(var0 == 1422) {
         var3.field2775 = var8;
      } else if(var0 == 1423) {
         var3.field2765 = var8;
      } else if(var0 == 1424) {
         var3.field2766 = var8;
      } else if(var0 == 1425) {
         var3.field2768 = var8;
      } else if(var0 == 1426) {
         var3.field2769 = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2767 = var8;
      }

      var3.field2785 = true;
      return 1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1471983195"
   )
   public static int method168() {
      return ++MouseInput.mouseIdleTicks - 1;
   }
}
