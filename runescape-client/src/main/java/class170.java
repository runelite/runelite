import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class170 {
   @ObfuscatedName("j")
   @Export("javaVersion")
   public static String javaVersion;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1446176351
   )
   static int field2345;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-32"
   )
   public static void method3216(int var0) {
      class204.field2507 = 1;
      class204.field2508 = null;
      class204.field2509 = -1;
      ItemContainer.field787 = -1;
      class204.field2510 = 0;
      Varcs.field1528 = false;
      class115.field1694 = var0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lii;I)V",
      garbageValue = "466103811"
   )
   public static void method3215(IndexDataBase var0) {
      class245.field3325 = var0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "-789019189"
   )
   static int method3213(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 == 2700) {
         var3 = GZipDecompressor.method3177(class82.intStack[--Ignore.intStackSize]);
         class82.intStack[++Ignore.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 2701) {
         var3 = GZipDecompressor.method3177(class82.intStack[--Ignore.intStackSize]);
         if(var3.itemId != -1) {
            class82.intStack[++Ignore.intStackSize - 1] = var3.itemQuantity;
         } else {
            class82.intStack[++Ignore.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 2702) {
         int var5 = class82.intStack[--Ignore.intStackSize];
         WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var5);
         if(var4 != null) {
            class82.intStack[++Ignore.intStackSize - 1] = 1;
         } else {
            class82.intStack[++Ignore.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 2706) {
         class82.intStack[++Ignore.intStackSize - 1] = Client.widgetRoot;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(CIB)I",
      garbageValue = "1"
   )
   static int method3214(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
