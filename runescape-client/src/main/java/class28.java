import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("Item")
public final class class28 extends class85 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1670011515
   )
   @Export("quantity")
   int field680;
   @ObfuscatedName("d")
   static class80[] field681;
   @ObfuscatedName("bt")
   static class168 field682;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1021235221
   )
   @Export("id")
   int field686;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lclass105;",
      garbageValue = "1"
   )
   protected final class105 vmethod1888() {
      return class9.method128(this.field686).method1000(this.field680);
   }
}
