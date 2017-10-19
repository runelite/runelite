import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
@Implements("Permission")
public enum Permission implements RSEnum {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field3173(0, -1, true, false, true),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field3170(1, 0, true, true, true),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field3171(2, 1, true, true, false),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field3177(3, 2, false, false, true),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field3178(4, 3, false, false, true),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field3174(5, 10, false, false, true);

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   static class290 field3169;
   @ObfuscatedName("x")
   public final boolean field3172;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 951129097
   )
   final int field3175;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2098096185
   )
   public final int field3176;
   @ObfuscatedName("d")
   public final boolean field3179;

   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3175 = var3;
      this.field3176 = var4;
      this.field3179 = var6;
      this.field3172 = var7;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "6"
   )
   public int rsOrdinal() {
      return this.field3175;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "139191382"
   )
   static int method4170(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
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
