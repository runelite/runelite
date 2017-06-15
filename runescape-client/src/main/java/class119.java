import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("db")
public abstract class class119 extends Node {
   @ObfuscatedName("k")
   int field1715;
   @ObfuscatedName("w")
   volatile boolean field1716;
   @ObfuscatedName("r")
   class122 field1717;
   @ObfuscatedName("s")
   class119 field1718;

   @ObfuscatedName("z")
   protected abstract class119 vmethod3771();

   @ObfuscatedName("j")
   protected abstract class119 vmethod3780();

   @ObfuscatedName("c")
   protected abstract int vmethod3772();

   @ObfuscatedName("eh")
   final void method2204(int[] var1, int var2, int var3) {
      if(this.field1716) {
         this.vmethod3775(var1, var2, var3);
      } else {
         this.vmethod3773(var3);
      }

   }

   @ObfuscatedName("o")
   protected abstract void vmethod3775(int[] var1, int var2, int var3);

   @ObfuscatedName("an")
   int vmethod2209() {
      return 255;
   }

   protected class119() {
      this.field1716 = true;
   }

   @ObfuscatedName("n")
   protected abstract void vmethod3773(int var1);
}
