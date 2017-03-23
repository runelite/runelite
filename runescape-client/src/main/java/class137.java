import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
public class class137 {
   @ObfuscatedName("f")
   byte[] field1924;
   @ObfuscatedName("i")
   byte[] field1925;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 452405767
   )
   int field1926;
   @ObfuscatedName("nk")
   static class57 field1927;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1531869561
   )
   int field1928;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2035069465
   )
   int field1929;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 237927359
   )
   int field1930;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -766460095
   )
   int field1931;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1045772107
   )
   int field1932;
   @ObfuscatedName("z")
   static int[] field1933;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1964326491
   )
   int field1934;

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "0"
   )
   static final void method2541(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field506; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var1 + var3) {
            Client.field508[var4] = true;
         }
      }

   }
}
