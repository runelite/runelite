import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
public class class260 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -512194443
   )
   static int field3456;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "985563597"
   )
   static int method4554(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 5504) {
         class82.intStackSize -= 2;
         var3 = class82.intStack[class82.intStackSize];
         int var4 = class82.intStack[class82.intStackSize + 1];
         if(!Client.field930) {
            Client.field998 = var3;
            Client.mapAngle = var4;
         }

         return 1;
      } else if(var0 == 5505) {
         class82.intStack[++class82.intStackSize - 1] = Client.field998;
         return 1;
      } else if(var0 == 5506) {
         class82.intStack[++class82.intStackSize - 1] = Client.mapAngle;
         return 1;
      } else if(var0 == 5530) {
         var3 = class82.intStack[--class82.intStackSize];
         if(var3 < 0) {
            var3 = 0;
         }

         Client.field1014 = var3;
         return 1;
      } else if(var0 == 5531) {
         class82.intStack[++class82.intStackSize - 1] = Client.field1014;
         return 1;
      } else {
         return 2;
      }
   }
}
