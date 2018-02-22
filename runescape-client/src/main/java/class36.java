import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class36 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Las;"
   )
   static final class36 field463;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Las;"
   )
   static final class36 field464;
   @ObfuscatedName("ao")
   static int[] field471;
   @ObfuscatedName("am")
   static int[] field467;
   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("indexWorldMap")
   static IndexData indexWorldMap;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -643081307
   )
   final int field469;

   static {
      field463 = new class36(0);
      field464 = new class36(1);
   }

   class36(int var1) {
      this.field469 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II)I",
      garbageValue = "2044436693"
   )
   public static int method510(CharSequence var0, int var1) {
      return class162.parseInt(var0, var1, true);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILca;ZB)I",
      garbageValue = "-96"
   )
   static int method511(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 == 2700) {
         var3 = NetWriter.getWidget(class80.intStack[--class80.intStackSize]);
         class80.intStack[++class80.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 2701) {
         var3 = NetWriter.getWidget(class80.intStack[--class80.intStackSize]);
         if(var3.itemId != -1) {
            class80.intStack[++class80.intStackSize - 1] = var3.itemQuantity;
         } else {
            class80.intStack[++class80.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 2702) {
         int var5 = class80.intStack[--class80.intStackSize];
         WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var5);
         if(var4 != null) {
            class80.intStack[++class80.intStackSize - 1] = 1;
         } else {
            class80.intStack[++class80.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 2706) {
         class80.intStack[++class80.intStackSize - 1] = Client.widgetRoot;
         return 1;
      } else {
         return 2;
      }
   }
}
