import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
public abstract class class117 extends Node {
   @ObfuscatedName("w")
   volatile boolean field1704;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lds;"
   )
   class120 field1705;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ldm;"
   )
   class117 field1703;
   @ObfuscatedName("b")
   int field1706;

   protected class117() {
      this.field1704 = true;
   }

   @ObfuscatedName("d")
   protected abstract void vmethod3968(int[] var1, int var2, int var3);

   @ObfuscatedName("u")
   protected abstract void vmethod3981(int var1);

   @ObfuscatedName("fw")
   final void method2353(int[] var1, int var2, int var3) {
      if(this.field1704) {
         this.vmethod3968(var1, var2, var3);
      } else {
         this.vmethod3981(var3);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "()Ldm;"
   )
   protected abstract class117 vmethod3967();

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Ldm;"
   )
   protected abstract class117 vmethod3966();

   @ObfuscatedName("ag")
   int vmethod2359() {
      return 255;
   }

   @ObfuscatedName("e")
   protected abstract int vmethod3974();
}
