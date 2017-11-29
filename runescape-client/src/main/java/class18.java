import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
final class class18 implements Comparator {
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      intValue = 1197973043
   )
   static int field304;
   @ObfuscatedName("s")
   static String[] field309;
   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("vorbisIndex")
   static IndexData vorbisIndex;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 710716633
   )
   @Export("cameraPitch")
   static int cameraPitch;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ly;Ly;I)I",
      garbageValue = "1184595222"
   )
   int method147(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.method93().compareTo(var2.method93());
   }

   public int compare(Object var1, Object var2) {
      return this.method147((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BZB)Ljava/lang/Object;",
      garbageValue = "-50"
   )
   @Export("byteArrayToObject")
   public static Object byteArrayToObject(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !AbstractByteBuffer.directBufferUnavailable) {
            try {
               DirectByteBuffer var2 = new DirectByteBuffer();
               var2.put(var0);
               return var2;
            } catch (Throwable var3) {
               AbstractByteBuffer.directBufferUnavailable = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "-1566713171"
   )
   static int method152(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class87.getWidget(class82.intStack[--GrandExchangeEvents.intStackSize]);
      } else {
         var3 = var2?class54.field636:class82.field1265;
      }

      String var4 = class82.scriptStringStack[--class82.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
         int var6 = class82.intStack[--GrandExchangeEvents.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class82.intStack[--GrandExchangeEvents.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 's') {
            var8[var7] = class82.scriptStringStack[--class82.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class82.intStack[--GrandExchangeEvents.intStackSize]);
         }
      }

      var7 = class82.intStack[--GrandExchangeEvents.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.field2806 = var8;
      } else if(var0 == 1401) {
         var3.field2760 = var8;
      } else if(var0 == 1402) {
         var3.field2852 = var8;
      } else if(var0 == 1403) {
         var3.mouseEnterListener = var8;
      } else if(var0 == 1404) {
         var3.mouseExitListener = var8;
      } else if(var0 == 1405) {
         var3.field2813 = var8;
      } else if(var0 == 1406) {
         var3.field2816 = var8;
      } else if(var0 == 1407) {
         var3.configListenerArgs = var8;
         var3.configTriggers = var5;
      } else if(var0 == 1408) {
         var3.renderListener = var8;
      } else if(var0 == 1409) {
         var3.field2803 = var8;
      } else if(var0 == 1410) {
         var3.field2814 = var8;
      } else if(var0 == 1411) {
         var3.field2805 = var8;
      } else if(var0 == 1412) {
         var3.mouseHoverListener = var8;
      } else if(var0 == 1414) {
         var3.tableListenerArgs = var8;
         var3.tableModTriggers = var5;
      } else if(var0 == 1415) {
         var3.skillListenerArgs = var8;
         var3.skillTriggers = var5;
      } else if(var0 == 1416) {
         var3.field2784 = var8;
      } else if(var0 == 1417) {
         var3.scrollListener = var8;
      } else if(var0 == 1418) {
         var3.field2849 = var8;
      } else if(var0 == 1419) {
         var3.field2827 = var8;
      } else if(var0 == 1420) {
         var3.field2828 = var8;
      } else if(var0 == 1421) {
         var3.field2829 = var8;
      } else if(var0 == 1422) {
         var3.field2830 = var8;
      } else if(var0 == 1423) {
         var3.field2831 = var8;
      } else if(var0 == 1424) {
         var3.field2861 = var8;
      } else if(var0 == 1425) {
         var3.field2834 = var8;
      } else if(var0 == 1426) {
         var3.field2835 = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2833 = var8;
      }

      var3.field2770 = true;
      return 1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "92903918"
   )
   static int method155(int var0, Script var1, boolean var2) {
      Widget var3 = class87.getWidget(class82.intStack[--GrandExchangeEvents.intStackSize]);
      if(var0 == 2600) {
         class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 2601) {
         class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 2602) {
         class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 2603) {
         class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 2604) {
         class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 2605) {
         class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if(var0 == 2606) {
         class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 2607) {
         class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 2608) {
         class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 2609) {
         class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 2610) {
         class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var3.field2729;
         return 1;
      } else if(var0 == 2611) {
         class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 2612) {
         class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var3.field2750;
         return 1;
      } else if(var0 == 2613) {
         class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var3.field2754.rsOrdinal();
         return 1;
      } else {
         return 2;
      }
   }
}
