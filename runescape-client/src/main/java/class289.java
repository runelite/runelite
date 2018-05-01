import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ks")
public class class289 {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1778092126"
   )
   public static synchronized long method5267() {
      long var0 = System.currentTimeMillis();
      if(var0 < Resampler.field1592) {
         class196.field2587 += Resampler.field1592 - var0;
      }

      Resampler.field1592 = var0;
      return class196.field2587 + var0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILcr;ZB)I",
      garbageValue = "84"
   )
   static int method5268(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = UnitPriceComparator.getWidget(class81.intStack[--class171.intStackSize]);
      } else {
         var3 = var2?class49.field604:class81.field1270;
      }

      String var4 = class81.scriptStringStack[--class81.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
         int var6 = class81.intStack[--class171.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class81.intStack[--class171.intStackSize]) {
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
            var8[var7] = new Integer(class81.intStack[--class171.intStackSize]);
         }
      }

      var7 = class81.intStack[--class171.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.onClickListener = var8;
      } else if(var0 == 1401) {
         var3.onHoldListener = var8;
      } else if(var0 == 1402) {
         var3.onReleaseListener = var8;
      } else if(var0 == 1403) {
         var3.onMouseOverListener = var8;
      } else if(var0 == 1404) {
         var3.onMouseLeaveListener = var8;
      } else if(var0 == 1405) {
         var3.onDragListener = var8;
      } else if(var0 == 1406) {
         var3.onTargetLeaveListener = var8;
      } else if(var0 == 1407) {
         var3.onVarTransmitListener = var8;
         var3.varTransmitTriggers = var5;
      } else if(var0 == 1408) {
         var3.onTimerListener = var8;
      } else if(var0 == 1409) {
         var3.onOpListener = var8;
      } else if(var0 == 1410) {
         var3.onDragCompleteListener = var8;
      } else if(var0 == 1411) {
         var3.onClickRepeatListener = var8;
      } else if(var0 == 1412) {
         var3.onMouseRepeatListener = var8;
      } else if(var0 == 1414) {
         var3.onInvTransmitListener = var8;
         var3.invTransmitTriggers = var5;
      } else if(var0 == 1415) {
         var3.onStatTransmitListener = var8;
         var3.statTransmitTriggers = var5;
      } else if(var0 == 1416) {
         var3.onTargetEnterListener = var8;
      } else if(var0 == 1417) {
         var3.onScrollWheelListener = var8;
      } else if(var0 == 1418) {
         var3.onChatTransmitListener = var8;
      } else if(var0 == 1419) {
         var3.onKeyListener = var8;
      } else if(var0 == 1420) {
         var3.onFriendTransmitListener = var8;
      } else if(var0 == 1421) {
         var3.onClanTransmitListener = var8;
      } else if(var0 == 1422) {
         var3.onMiscTransmitListener = var8;
      } else if(var0 == 1423) {
         var3.onDialogAbortListener = var8;
      } else if(var0 == 1424) {
         var3.onSubChangeListener = var8;
      } else if(var0 == 1425) {
         var3.onStockTransmitListener = var8;
      } else if(var0 == 1426) {
         var3.onCamFinishedListener = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.onResizeListener = var8;
      }

      var3.hasListener = true;
      return 1;
   }
}
