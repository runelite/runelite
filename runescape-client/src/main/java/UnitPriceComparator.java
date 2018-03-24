import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
@Implements("UnitPriceComparator")
final class UnitPriceComparator implements Comparator {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1462483621
   )
   static int field297;
   @ObfuscatedName("x")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lu;Lu;I)I",
      garbageValue = "-262344594"
   )
   int method126(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.price < var2.grandExchangeOffer.price?-1:(var2.grandExchangeOffer.price == var1.grandExchangeOffer.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method126((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-64"
   )
   @Export("getSmoothNoise2D")
   static final int getSmoothNoise2D(int var0, int var1) {
      int var2 = MouseRecorder.method1159(var0 - 1, var1 - 1) + MouseRecorder.method1159(var0 + 1, var1 - 1) + MouseRecorder.method1159(var0 - 1, 1 + var1) + MouseRecorder.method1159(1 + var0, 1 + var1);
      int var3 = MouseRecorder.method1159(var0 - 1, var1) + MouseRecorder.method1159(var0 + 1, var1) + MouseRecorder.method1159(var0, var1 - 1) + MouseRecorder.method1159(var0, 1 + var1);
      int var4 = MouseRecorder.method1159(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1161178324"
   )
   @Export("getLength")
   public static int getLength(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILcj;ZB)I",
      garbageValue = "9"
   )
   static int method139(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 == 2700) {
         var3 = GZipDecompressor.getWidget(class81.intStack[--class5.intStackSize]);
         class81.intStack[++class5.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 2701) {
         var3 = GZipDecompressor.getWidget(class81.intStack[--class5.intStackSize]);
         if(var3.itemId != -1) {
            class81.intStack[++class5.intStackSize - 1] = var3.itemQuantity;
         } else {
            class81.intStack[++class5.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 2702) {
         int var5 = class81.intStack[--class5.intStackSize];
         WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var5);
         if(var4 != null) {
            class81.intStack[++class5.intStackSize - 1] = 1;
         } else {
            class81.intStack[++class5.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 2706) {
         class81.intStack[++class5.intStackSize - 1] = Client.widgetRoot;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-301186038"
   )
   static void method130() {
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
   }
}
