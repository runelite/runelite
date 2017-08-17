import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   @Export("compass")
   static SpritePixels compass;
   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "[Lkp;"
   )
   @Export("mapfunctions")
   static SpritePixels[] mapfunctions;
   @ObfuscatedName("j")
   @Export("component")
   Component component;

   RSCanvas(Component var1) {
      this.component = var1;
   }

   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "34"
   )
   public static void method829() {
      if(MouseInput.mouse != null) {
         MouseInput var0 = MouseInput.mouse;
         synchronized(MouseInput.mouse) {
            MouseInput.mouse = null;
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "566857091"
   )
   static int method823(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class84.method1670(class84.intStack[--class84.intStackSize]);
      } else {
         var3 = var2?class43.field582:class208.field2580;
      }

      String var4 = class84.scriptStringStack[--class91.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 89) {
         int var6 = class84.intStack[--class84.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class84.intStack[--class84.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 115) {
            var8[var7] = class84.scriptStringStack[--class91.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class84.intStack[--class84.intStackSize]);
         }
      }

      var7 = class84.intStack[--class84.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.field2740 = var8;
      } else if(var0 == 1401) {
         var3.field2661 = var8;
      } else if(var0 == 1402) {
         var3.field2733 = var8;
      } else if(var0 == 1403) {
         var3.mouseEnterListener = var8;
      } else if(var0 == 1404) {
         var3.mouseExitListener = var8;
      } else if(var0 == 1405) {
         var3.field2738 = var8;
      } else if(var0 == 1406) {
         var3.field2741 = var8;
      } else if(var0 == 1407) {
         var3.configListenerArgs = var8;
         var3.configTriggers = var5;
      } else if(var0 == 1408) {
         var3.renderListener = var8;
      } else if(var0 == 1409) {
         var3.field2749 = var8;
      } else if(var0 == 1410) {
         var3.field2739 = var8;
      } else if(var0 == 1411) {
         var3.field2769 = var8;
      } else if(var0 == 1412) {
         var3.mouseHoverListener = var8;
      } else if(var0 == 1414) {
         var3.tableListenerArgs = var8;
         var3.tableModTriggers = var5;
      } else if(var0 == 1415) {
         var3.skillListenerArgs = var8;
         var3.skillTriggers = var5;
      } else if(var0 == 1416) {
         var3.field2642 = var8;
      } else if(var0 == 1417) {
         var3.scrollListener = var8;
      } else if(var0 == 1418) {
         var3.field2751 = var8;
      } else if(var0 == 1419) {
         var3.field2752 = var8;
      } else if(var0 == 1420) {
         var3.field2782 = var8;
      } else if(var0 == 1421) {
         var3.field2754 = var8;
      } else if(var0 == 1422) {
         var3.field2761 = var8;
      } else if(var0 == 1423) {
         var3.field2756 = var8;
      } else if(var0 == 1424) {
         var3.field2744 = var8;
      } else if(var0 == 1425) {
         var3.field2655 = var8;
      } else if(var0 == 1426) {
         var3.field2759 = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2696 = var8;
      }

      var3.field2760 = true;
      return 1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILcj;ZB)I",
      garbageValue = "-16"
   )
   static int method830(int var0, Script var1, boolean var2) {
      if(var0 == 3200) {
         class84.intStackSize -= 3;
         class2.method4(class84.intStack[class84.intStackSize], class84.intStack[class84.intStackSize + 1], class84.intStack[class84.intStackSize + 2]);
         return 1;
      } else {
         int var3;
         if(var0 != 3201) {
            if(var0 == 3202) {
               class84.intStackSize -= 2;
               var3 = class84.intStack[class84.intStackSize];
               int var6 = class84.intStack[class84.intStackSize + 1];
               if(Client.field1024 != 0 && var3 != -1) {
                  class66.method1144(DState.indexTrack2, var3, 0, Client.field1024, false);
                  Client.field1163 = true;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            var3 = class84.intStack[--class84.intStackSize];
            if(var3 == -1 && !Client.field1163) {
               class204.field2501.method3758();
               class204.field2507 = 1;
               class204.field2502 = null;
            } else if(var3 != -1 && var3 != Client.field1095 && Client.field1024 != 0 && !Client.field1163) {
               IndexData var4 = class253.indexTrack1;
               int var5 = Client.field1024;
               class204.field2507 = 1;
               class204.field2502 = var4;
               class150.field2205 = var3;
               class153.field2222 = 0;
               class204.field2504 = var5;
               class99.field1532 = false;
               class204.field2505 = 2;
            }

            Client.field1095 = var3;
            return 1;
         }
      }
   }
}
