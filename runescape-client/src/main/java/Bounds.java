import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kr")
@Implements("Bounds")
public class Bounds {
   @ObfuscatedName("g")
   @Export("spritePixels")
   public static byte[][] spritePixels;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 571736405
   )
   public int field3813;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1750164425
   )
   public int field3812;

   Bounds(int var1, int var2, int var3, int var4) {
      this.method5071(var1, var2);
      this.method5064(var3, var4);
   }

   public Bounds(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "38"
   )
   void method5071(int var1, int var2) {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "36"
   )
   void method5064(int var1, int var2) {
      this.field3813 = var1;
      this.field3812 = var2;
   }
}
