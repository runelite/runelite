import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
public class class88 {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "1020099546"
   )
   static int method1656(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class48.field614:FaceNormal.field2099;
      if(var0 == 1700) {
         class83.intStack[++BufferProvider.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 1701) {
         if(var3.itemId != -1) {
            class83.intStack[++BufferProvider.intStackSize - 1] = var3.itemQuantity;
         } else {
            class83.intStack[++BufferProvider.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 1702) {
         class83.intStack[++BufferProvider.intStackSize - 1] = var3.index;
         return 1;
      } else {
         return 2;
      }
   }
}
