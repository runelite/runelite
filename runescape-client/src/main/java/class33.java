import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class33 {
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = -528208521
   )
   static int field454;
   @ObfuscatedName("cn")
   static boolean field461;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -390647447
   )
   static int field460;
   @ObfuscatedName("a")
   String field462;
   @ObfuscatedName("r")
   class24 field457;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 126267211
   )
   int field455;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1524407829
   )
   int field456;

   class33(String var1, int var2, int var3, class24 var4) {
      this.field462 = var1;
      this.field455 = var2;
      this.field456 = var3;
      this.field457 = var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1579946054"
   )
   @Export("loadWidget")
   public static boolean loadWidget(int var0) {
      if(Widget.validInterfaces[var0]) {
         return true;
      } else if(!class11.widgetIndex.containsFile(var0)) {
         return false;
      } else {
         int var1 = class11.widgetIndex.fileCount(var0);
         if(var1 == 0) {
            Widget.validInterfaces[var0] = true;
            return true;
         } else {
            if(Widget.widgets[var0] == null) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(Widget.widgets[var0][var2] == null) {
                  byte[] var3 = class11.widgetIndex.getConfigData(var0, var2);
                  if(var3 != null) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].decodeActive(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].decode(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("a")
   public static final void method354(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var7) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var6) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var8) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(Lclass89;III)V",
      garbageValue = "-1626532354"
   )
   static final void method353(class89 var0, int var1, int var2) {
      class34.menuAction(var0.field1402, var0.field1399, var0.field1400, var0.field1403, var0.field1401, var0.field1401, var1, var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;ZLFont;I)V",
      garbageValue = "-177003912"
   )
   public static void method349(IndexDataBase var0, IndexDataBase var1, boolean var2, Font var3) {
      FrameMap.item_ref = var0;
      ItemComposition.field3504 = var1;
      ItemComposition.isMembersWorld = var2;
      ItemComposition.field3491 = FrameMap.item_ref.fileCount(10);
      ItemComposition.field3495 = var3;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "-1813704319"
   )
   static final int method352(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - Graphics3D.COSINE[var2 * 1024 / var3] >> 1;
      return (var4 * var1 >> 16) + ((65536 - var4) * var0 >> 16);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1627678455"
   )
   static int method350(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 == 2700) {
         var3 = class61.method1038(class83.intStack[--WorldMapType2.intStackSize]);
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 2701) {
         var3 = class61.method1038(class83.intStack[--WorldMapType2.intStackSize]);
         if(var3.itemId != -1) {
            class83.intStack[++WorldMapType2.intStackSize - 1] = var3.itemQuantity;
         } else {
            class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 2702) {
         int var5 = class83.intStack[--WorldMapType2.intStackSize];
         WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var5);
         if(var4 != null) {
            class83.intStack[++WorldMapType2.intStackSize - 1] = 1;
         } else {
            class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 2706) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = Client.widgetRoot;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-20965023"
   )
   static int method348(int var0, int var1, int var2) {
      return (class61.tileSettings[var0][var1][var2] & 8) != 0?0:(var0 > 0 && (class61.tileSettings[1][var1][var2] & 2) != 0?var0 - 1:var0);
   }
}
