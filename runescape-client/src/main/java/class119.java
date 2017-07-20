import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
public abstract class class119 extends Node {
   @ObfuscatedName("w")
   volatile boolean field1681;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   class122 field1682;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   class119 field1683;
   @ObfuscatedName("y")
   int field1680;

   protected class119() {
      this.field1681 = true;
   }

   @ObfuscatedName("p")
   protected abstract void vmethod3826(int[] var1, int var2, int var3);

   @ObfuscatedName("r")
   protected abstract void vmethod3827(int var1);

   @ObfuscatedName("fk")
   final void method2232(int[] var1, int var2, int var3) {
      if(this.field1681) {
         this.vmethod3826(var1, var2, var3);
      } else {
         this.vmethod3827(var3);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected abstract class119 vmethod3835();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected abstract class119 vmethod3823();

   @ObfuscatedName("aa")
   int vmethod2228() {
      return 255;
   }

   @ObfuscatedName("x")
   protected abstract int vmethod3825();
}
