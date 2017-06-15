import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class14 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -5117731690902833979L
   )
   public final long field291;
   @ObfuscatedName("e")
   public final XGrandExchangeOffer field292;
   @ObfuscatedName("t")
   String field293;
   @ObfuscatedName("n")
   public static Font field294;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = 79089635
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("y")
   static int[] field296;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 305392975
   )
   public final int field297;
   @ObfuscatedName("w")
   String field298;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-782414167"
   )
   public String method80() {
      return this.field298;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1595595945"
   )
   public String method81() {
      return this.field293;
   }

   class14(Buffer var1, byte var2, int var3) {
      this.field293 = var1.readString();
      this.field298 = var1.readString();
      this.field297 = var1.readUnsignedShort();
      this.field291 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.field292 = new XGrandExchangeOffer();
      this.field292.method115(2);
      this.field292.method116(var2);
      this.field292.price = var4;
      this.field292.totalQuantity = var5;
      this.field292.quantitySold = 0;
      this.field292.spent = 0;
      this.field292.itemId = var3;
   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1503649786"
   )
   static final void method88() {
      for(int var0 = 0; var0 < Client.field930; ++var0) {
         int var1 = Client.npcIndices[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(var2 != null) {
            WorldMapType1.method272(var2, var2.composition.field3559);
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1312362472"
   )
   static final int method89(int var0, int var1) {
      int var2 = class164.method2960(var0 + '넵', var1 + 91923, 4) - 128 + (class164.method2960(var0 + 10294, var1 + '鎽', 2) - 128 >> 1) + (class164.method2960(var0, var1, 1) - 128 >> 2);
      var2 = (int)((double)var2 * 0.3D) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-724194587"
   )
   static int method90(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class83.intStack[--class83.intStackSize];
         var4 = class223.method3959(var3);
      } else {
         var4 = var2?class43.field582:class31.field457;
      }

      if(var0 == 1000) {
         class83.intStackSize -= 4;
         var4.originalX = class83.intStack[class83.intStackSize];
         var4.originalY = class83.intStack[class83.intStackSize + 1];
         var4.field2659 = class83.intStack[class83.intStackSize + 2];
         var4.field2660 = class83.intStack[class83.intStackSize + 3];
         XItemContainer.method1020(var4);
         class220.field2817.method1118(var4);
         if(var3 != -1 && var4.type == 0) {
            class95.method1670(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class83.intStackSize -= 4;
         var4.originalWidth = class83.intStack[class83.intStackSize];
         var4.field2666 = class83.intStack[class83.intStackSize + 1];
         var4.field2661 = class83.intStack[class83.intStackSize + 2];
         var4.field2662 = class83.intStack[class83.intStackSize + 3];
         XItemContainer.method1020(var4);
         class220.field2817.method1118(var4);
         if(var3 != -1 && var4.type == 0) {
            class95.method1670(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class83.intStack[--class83.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            XItemContainer.method1020(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.field2787 = class83.intStack[--class83.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2788 = class83.intStack[--class83.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }
}
