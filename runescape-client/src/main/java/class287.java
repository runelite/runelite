import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ke")
public class class287 {
   @ObfuscatedName("az")
   @Export("clientInstance")
   @ObfuscatedSignature(
      signature = "Lclient;"
   )
   static Client clientInstance;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1764075545
   )
   public int field3793;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1682805933
   )
   public int field3791;

   class287(int var1, int var2, int var3, int var4) {
      this.method5117(var1, var2);
      this.method5122(var3, var4);
   }

   public class287(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1501823255"
   )
   void method5117(int var1, int var2) {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1065441190"
   )
   void method5122(int var1, int var2) {
      this.field3793 = var1;
      this.field3791 = var2;
   }
}
