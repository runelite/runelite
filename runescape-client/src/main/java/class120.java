import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public abstract class class120 extends Node {
   @ObfuscatedName("w")
   volatile boolean field1707;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ldg;"
   )
   class123 field1704;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ldl;"
   )
   class120 field1706;
   @ObfuscatedName("a")
   int field1705;

   protected class120() {
      this.field1707 = true;
   }

   @ObfuscatedName("r")
   protected abstract void vmethod3889(int[] var1, int var2, int var3);

   @ObfuscatedName("d")
   protected abstract void vmethod3890(int var1);

   @ObfuscatedName("fv")
   final void method2315(int[] var1, int var2, int var3) {
      if(this.field1707) {
         this.vmethod3889(var1, var2, var3);
      } else {
         this.vmethod3890(var3);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Ldl;"
   )
   protected abstract class120 vmethod3908();

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "()Ldl;"
   )
   protected abstract class120 vmethod3906();

   @ObfuscatedName("af")
   int vmethod2312() {
      return 255;
   }

   @ObfuscatedName("z")
   protected abstract int vmethod3904();
}
