import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
@Implements("SoundTask")
public class SoundTask implements Runnable {
   @ObfuscatedName("i")
   @Export("systems")
   volatile AbstractSoundSystem[] systems;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "-87"
   )
   static int method2081(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = PacketBuffer.method3403(class83.intStack[--class46.intStackSize]);
      } else {
         var3 = var2?class83.field1364:class60.field766;
      }

      String var4 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 89) {
         int var6 = class83.intStack[--class46.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class83.intStack[--class46.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 115) {
            var8[var7] = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class83.intStack[--class46.intStackSize]);
         }
      }

      var7 = class83.intStack[--class46.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.field2725 = var8;
      } else if(var0 == 1401) {
         var3.field2722 = var8;
      } else if(var0 == 1402) {
         var3.field2738 = var8;
      } else if(var0 == 1403) {
         var3.mouseEnterListener = var8;
      } else if(var0 == 1404) {
         var3.mouseExitListener = var8;
      } else if(var0 == 1405) {
         var3.field2643 = var8;
      } else if(var0 == 1406) {
         var3.field2746 = var8;
      } else if(var0 == 1407) {
         var3.configListenerArgs = var8;
         var3.configTriggers = var5;
      } else if(var0 == 1408) {
         var3.renderListener = var8;
      } else if(var0 == 1409) {
         var3.field2754 = var8;
      } else if(var0 == 1410) {
         var3.field2744 = var8;
      } else if(var0 == 1411) {
         var3.field2677 = var8;
      } else if(var0 == 1412) {
         var3.mouseHoverListener = var8;
      } else if(var0 == 1414) {
         var3.tableListenerArgs = var8;
         var3.tableModTriggers = var5;
      } else if(var0 == 1415) {
         var3.skillListenerArgs = var8;
         var3.skillTriggers = var5;
      } else if(var0 == 1416) {
         var3.field2745 = var8;
      } else if(var0 == 1417) {
         var3.scrollListener = var8;
      } else if(var0 == 1418) {
         var3.field2756 = var8;
      } else if(var0 == 1419) {
         var3.field2761 = var8;
      } else if(var0 == 1420) {
         var3.field2758 = var8;
      } else if(var0 == 1421) {
         var3.field2759 = var8;
      } else if(var0 == 1422) {
         var3.field2760 = var8;
      } else if(var0 == 1423) {
         var3.field2731 = var8;
      } else if(var0 == 1424) {
         var3.field2762 = var8;
      } else if(var0 == 1425) {
         var3.field2663 = var8;
      } else if(var0 == 1426) {
         var3.field2701 = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2763 = var8;
      }

      var3.field2734 = true;
      return 1;
   }

   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            AbstractSoundSystem var2 = this.systems[var1];
            if(var2 != null) {
               var2.method2022();
            }
         }
      } catch (Exception var3) {
         MilliTimer.method2912((String)null, var3);
      }

   }

   SoundTask() {
      this.systems = new AbstractSoundSystem[2];
   }
}
