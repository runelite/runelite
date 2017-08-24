import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
public enum class240 implements RSEnum {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3275(0, 0),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3277(2, 1),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3278(1, 2);

   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1449802909
   )
   public final int field3276;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1776396785
   )
   final int field3279;

   class240(int var3, int var4) {
      this.field3276 = var3;
      this.field3279 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "959363303"
   )
   public int rsOrdinal() {
      return this.field3279;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1255914443"
   )
   static void method4273(Component var0) {
      var0.addMouseListener(MouseInput.mouse);
      var0.addMouseMotionListener(MouseInput.mouse);
      var0.addFocusListener(MouseInput.mouse);
   }
}
