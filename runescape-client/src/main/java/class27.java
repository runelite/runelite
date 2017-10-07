import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public enum class27 implements RSEnum {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   field407(2, (byte)0),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   field409(0, (byte)1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   field400(1, (byte)2),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   field402(3, (byte)3);

   @ObfuscatedName("kp")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static Widget field403;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1086504679
   )
   final int field404;
   @ObfuscatedName("s")
   final byte field405;

   class27(int var3, byte var4) {
      this.field404 = var3;
      this.field405 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-41"
   )
   public int rsOrdinal() {
      return this.field405;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)[Lai;",
      garbageValue = "8"
   )
   static class27[] method205() {
      return new class27[]{field407, field400, field409, field402};
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1512147132"
   )
   public static void method204() {
      if(MouseInput.mouse != null) {
         MouseInput var0 = MouseInput.mouse;
         synchronized(MouseInput.mouse) {
            MouseInput.mouse = null;
         }
      }

   }
}
