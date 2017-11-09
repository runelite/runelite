import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public abstract class class118 extends Node {
   @ObfuscatedName("w")
   volatile boolean field1636;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ldq;"
   )
   class118 field1633;
   @ObfuscatedName("u")
   int field1634;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ldg;"
   )
   class121 field1635;

   protected class118() {
      this.field1636 = true;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Ldq;"
   )
   protected abstract class118 vmethod4047();

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "()Ldq;"
   )
   protected abstract class118 vmethod4048();

   @ObfuscatedName("l")
   protected abstract int vmethod4068();

   @ObfuscatedName("b")
   protected abstract void vmethod4050(int[] var1, int var2, int var3);

   @ObfuscatedName("c")
   protected abstract void vmethod4051(int var1);

   @ObfuscatedName("aa")
   int vmethod2407() {
      return 255;
   }

   @ObfuscatedName("fb")
   final void method2411(int[] var1, int var2, int var3) {
      if(this.field1636) {
         this.vmethod4050(var1, var2, var3);
      } else {
         this.vmethod4051(var3);
      }

   }
}
