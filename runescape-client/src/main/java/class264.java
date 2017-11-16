import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jp")
public enum class264 implements class185 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   field3595(0, 0),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   field3596(1, 1),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   field3594(2, 2);

   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -113811557
   )
   public final int field3597;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 534173235
   )
   final int field3598;

   class264(int var3, int var4) {
      this.field3597 = var3;
      this.field3598 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-4"
   )
   public int rsOrdinal() {
      return this.field3598;
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "852817846"
   )
   static final void method4631(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class64.loadWidget(var0)) {
         class148.method2914(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }
}
