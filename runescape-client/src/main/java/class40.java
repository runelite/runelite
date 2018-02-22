import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class40 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lar;"
   )
   public static final class40 field497;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lar;"
   )
   public static final class40 field503;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lar;"
   )
   public static final class40 field506;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lar;"
   )
   public static final class40 field500;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lar;"
   )
   public static final class40 field501;
   @ObfuscatedName("y")
   static ScheduledExecutorService field505;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   static IndexedSprite field504;
   @ObfuscatedName("du")
   @Export("host")
   static String host;
   @ObfuscatedName("fa")
   @Export("landRegionFileIds")
   static int[] landRegionFileIds;
   @ObfuscatedName("h")
   public final String field502;

   static {
      field497 = new class40("details");
      field503 = new class40("compositemap");
      field506 = new class40("compositetexture");
      field500 = new class40("area");
      field501 = new class40("labels");
   }

   class40(String var1) {
      this.field502 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-856358809"
   )
   static void method561(int var0) {
      ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILca;ZB)I",
      garbageValue = "78"
   )
   static int method562(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class80.intStack[--class80.intStackSize];
         var4 = NetWriter.getWidget(var3);
      } else {
         var4 = var2?class223.field2643:class80.field1228;
      }

      if(var0 == 1000) {
         class80.intStackSize -= 4;
         var4.originalX = class80.intStack[class80.intStackSize];
         var4.originalY = class80.intStack[class80.intStackSize + 1];
         var4.dynamicX = class80.intStack[class80.intStackSize + 2];
         var4.dynamicY = class80.intStack[class80.intStackSize + 3];
         ScriptEvent.method1132(var4);
         RenderOverview.clientInstance.widgetMethod0(var4);
         if(var3 != -1 && var4.type == 0) {
            GrandExchangeOffer.method119(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class80.intStackSize -= 4;
         var4.originalWidth = class80.intStack[class80.intStackSize];
         var4.originalHeight = class80.intStack[class80.intStackSize + 1];
         var4.dynamicWidth = class80.intStack[class80.intStackSize + 2];
         var4.buttonType = class80.intStack[class80.intStackSize + 3];
         ScriptEvent.method1132(var4);
         RenderOverview.clientInstance.widgetMethod0(var4);
         if(var3 != -1 && var4.type == 0) {
            GrandExchangeOffer.method119(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class80.intStack[--class80.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            ScriptEvent.method1132(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.noClickThrough = class80.intStack[--class80.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2911 = class80.intStack[--class80.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1756118807"
   )
   public static void method563() {
      VarPlayerType.varplayers.reset();
   }
}
