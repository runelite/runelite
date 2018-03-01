import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
public class class196 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 8434492189726375847L
   )
   @Export("currentTimeMsOffset")
   static long currentTimeMsOffset;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "170140800"
   )
   public static boolean method3828(int var0, int var1) {
      return (var0 >> var1 + 1 & 1) != 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1870263979"
   )
   public static void method3831() {
      Spotanim.spotanims.reset();
      Spotanim.SpotAnimationDefinition_cachedModels.reset();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "73"
   )
   public static boolean method3834(char var0) {
      return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(IIB)Lfj;",
      garbageValue = "29"
   )
   static class178 method3833(int var0, int var1) {
      Client.field1119.field2282 = var0;
      Client.field1119.field2279 = var1;
      Client.field1119.field2280 = 1;
      Client.field1119.field2281 = 1;
      return Client.field1119;
   }
}
