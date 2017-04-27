import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public class class13 {
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = -1335867747
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("ii")
   static Widget field142;
   @ObfuscatedName("l")
   static ModIcon[] field143;
   @ObfuscatedName("w")
   public static Track1 field145;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = -1036293369
   )
   @Export("cameraYaw")
   static int cameraYaw;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IZZZI)LIndexData;",
      garbageValue = "-1975920989"
   )
   static IndexData method177(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class104.field1680 != null) {
         var4 = new IndexFile(var0, class104.field1680, class104.field1683[var0], 1000000);
      }

      return new IndexData(var4, ChatMessages.field919, var0, var1, var2, var3);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "38"
   )
   static void method178(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method2773((long)var0);
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }

      }
   }

   class13() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "411797229"
   )
   static String method179(int var0) {
      return var0 < 0?"":(Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0]);
   }
}
