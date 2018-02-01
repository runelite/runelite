import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public class class175 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("varplayer_ref")
   public static IndexDataBase varplayer_ref;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1250627150"
   )
   static int method3328() {
      return 11;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "-193687891"
   )
   static int method3327(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class23.field331:GrandExchangeOffer.field297;
      if(var0 == 1500) {
         class80.intStack[++class80.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 1501) {
         class80.intStack[++class80.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 1502) {
         class80.intStack[++class80.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 1503) {
         class80.intStack[++class80.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 1504) {
         class80.intStack[++class80.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 1505) {
         class80.intStack[++class80.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }
}
