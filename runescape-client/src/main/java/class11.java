import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class11 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ll;"
   )
   public static final class11 field276;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ll;"
   )
   public static final class11 field273;
   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field278;

   static {
      field276 = new class11();
      field273 = new class11();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lem;IIII)Z",
      garbageValue = "-1000075551"
   )
   static final boolean method63(Model var0, int var1, int var2, int var3) {
      if(!class14.method92()) {
         return false;
      } else {
         class206.method3876();
         int var4 = var0.field1963 + var1;
         int var5 = var2 + var0.field1932;
         int var6 = var3 + var0.field1965;
         int var7 = var0.field1975;
         int var8 = var0.field1982;
         int var9 = var0.field1968;
         int var10 = class133.field2005 - var4;
         int var11 = ItemContainer.field793 - var5;
         int var12 = class133.field2006 - var6;
         return Math.abs(var10) > var7 + ItemContainer.field792?false:(Math.abs(var11) > var8 + Varbit.field3386?false:(Math.abs(var12) > var9 + class133.field2008?false:(Math.abs(var12 * class170.field2345 - var11 * class39.field553) > var9 * Varbit.field3386 + var8 * class133.field2008?false:(Math.abs(var10 * class39.field553 - var12 * class133.field2007) > var9 * ItemContainer.field792 + var7 * class133.field2008?false:Math.abs(var11 * class133.field2007 - var10 * class170.field2345) <= var7 * Varbit.field3386 + var8 * ItemContainer.field792))));
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)[Lcd;",
      garbageValue = "-1534821900"
   )
   static class90[] method64() {
      return new class90[]{class90.field1425, class90.field1426, class90.field1424, class90.field1431};
   }
}
