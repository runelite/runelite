import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("bx")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static Widget field787;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lct;"
   )
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1238152133
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("q")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("o")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   ScriptState() {
      this.invokedFromPc = -1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "-1676821045"
   )
   static Class method1068(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILct;ZB)I",
      garbageValue = "30"
   )
   static int method1067(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = ItemLayer.method2454(class81.intStack[--class278.intStackSize]);
      } else {
         var3 = var2?class251.field3392:class164.field2314;
      }

      String var4 = class81.scriptStringStack[--class266.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
         int var6 = class81.intStack[--class278.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class81.intStack[--class278.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 's') {
            var8[var7] = class81.scriptStringStack[--class266.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class81.intStack[--class278.intStackSize]);
         }
      }

      var7 = class81.intStack[--class278.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.field2724 = var8;
      } else if(var0 == 1401) {
         var3.field2645 = var8;
      } else if(var0 == 1402) {
         var3.field2721 = var8;
      } else if(var0 == 1403) {
         var3.mouseEnterListener = var8;
      } else if(var0 == 1404) {
         var3.mouseExitListener = var8;
      } else if(var0 == 1405) {
         var3.field2731 = var8;
      } else if(var0 == 1406) {
         var3.field2719 = var8;
      } else if(var0 == 1407) {
         var3.configListenerArgs = var8;
         var3.configTriggers = var5;
      } else if(var0 == 1408) {
         var3.renderListener = var8;
      } else if(var0 == 1409) {
         var3.field2742 = var8;
      } else if(var0 == 1410) {
         var3.field2750 = var8;
      } else if(var0 == 1411) {
         var3.field2635 = var8;
      } else if(var0 == 1412) {
         var3.mouseHoverListener = var8;
      } else if(var0 == 1414) {
         var3.tableListenerArgs = var8;
         var3.tableModTriggers = var5;
      } else if(var0 == 1415) {
         var3.skillListenerArgs = var8;
         var3.skillTriggers = var5;
      } else if(var0 == 1416) {
         var3.field2755 = var8;
      } else if(var0 == 1417) {
         var3.scrollListener = var8;
      } else if(var0 == 1418) {
         var3.field2744 = var8;
      } else if(var0 == 1419) {
         var3.field2771 = var8;
      } else if(var0 == 1420) {
         var3.field2703 = var8;
      } else if(var0 == 1421) {
         var3.field2747 = var8;
      } else if(var0 == 1422) {
         var3.field2748 = var8;
      } else if(var0 == 1423) {
         var3.field2749 = var8;
      } else if(var0 == 1424) {
         var3.field2740 = var8;
      } else if(var0 == 1425) {
         var3.field2637 = var8;
      } else if(var0 == 1426) {
         var3.field2753 = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2661 = var8;
      }

      var3.field2722 = true;
      return 1;
   }
}
