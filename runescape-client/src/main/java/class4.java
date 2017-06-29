import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public enum class4 implements RSEnum {
   @ObfuscatedName("i")
   field29(1, 0, Integer.class, new class2()),
   @ObfuscatedName("w")
   field26(0, 1, Long.class, new class3()),
   @ObfuscatedName("a")
   field27(2, 2, String.class, new class5());

   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -432387191
   )
   final int field25;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1723534235
   )
   final int field28;
   @ObfuscatedName("c")
   public static class123[] field32;

   class4(int var3, int var4, Class var5, class0 var6) {
      this.field28 = var3;
      this.field25 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1204543302"
   )
   public int rsOrdinal() {
      return this.field25;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1662318245"
   )
   static int method17(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method3530((long)var0);
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
