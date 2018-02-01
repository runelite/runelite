import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
@Implements("TotalQuantityComparator")
final class TotalQuantityComparator implements Comparator {
   @ObfuscatedName("u")
   static int[] field284;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ln;Ln;I)I",
      garbageValue = "-1218921443"
   )
   int method100(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.totalQuantity < var2.grandExchangeOffer.totalQuantity?-1:(var2.grandExchangeOffer.totalQuantity == var1.grandExchangeOffer.totalQuantity?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method100((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1749605097"
   )
   static void method110() {
      class92.playerIndexesCount = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class92.field1377[var0] = null;
         class92.field1383[var0] = 1;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-436879440"
   )
   @Export("getSmoothNoise2D")
   static final int getSmoothNoise2D(int var0, int var1) {
      int var2 = class44.method628(var0 - 1, var1 - 1) + class44.method628(var0 + 1, var1 - 1) + class44.method628(var0 - 1, 1 + var1) + class44.method628(var0 + 1, 1 + var1);
      int var3 = class44.method628(var0 - 1, var1) + class44.method628(var0 + 1, var1) + class44.method628(var0, var1 - 1) + class44.method628(var0, var1 + 1);
      int var4 = class44.method628(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILcd;ZB)I",
      garbageValue = "67"
   )
   static int method109(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class23.field331:GrandExchangeOffer.field297;
      if(var0 == 1600) {
         class80.intStack[++class80.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 1601) {
         class80.intStack[++class80.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 1602) {
         class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 1603) {
         class80.intStack[++class80.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 1604) {
         class80.intStack[++class80.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 1605) {
         class80.intStack[++class80.intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if(var0 == 1606) {
         class80.intStack[++class80.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 1607) {
         class80.intStack[++class80.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 1608) {
         class80.intStack[++class80.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 1609) {
         class80.intStack[++class80.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 1610) {
         class80.intStack[++class80.intStackSize - 1] = var3.field2770;
         return 1;
      } else if(var0 == 1611) {
         class80.intStack[++class80.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 1612) {
         class80.intStack[++class80.intStackSize - 1] = var3.field2764;
         return 1;
      } else if(var0 == 1613) {
         class80.intStack[++class80.intStackSize - 1] = var3.field2758.rsOrdinal();
         return 1;
      } else {
         return 2;
      }
   }
}
