import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class227 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "4032"
   )
   static int method4087(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.get((long)var0);
      if(var2 == null) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.stackSizes.length; ++var4) {
            if(var2.itemIds[var4] == var1) {
               var3 += var2.stackSizes[var4];
            }
         }

         return var3;
      }
   }
}
