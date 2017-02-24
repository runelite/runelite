import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public abstract class class109 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1005407619"
   )
   public abstract void vmethod2107();

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "-4340"
   )
   abstract int vmethod2108(int var1, int var2);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1266066668"
   )
   public static int method2109(int var0) {
      Varbit var1 = class164.method3157(var0);
      int var2 = var1.leastSignificantBit;
      int var3 = var1.configId;
      int var4 = var1.mostSignificantBit;
      int var5 = class165.field2165[var4 - var3];
      return class165.widgetSettings[var2] >> var3 & var5;
   }
}
