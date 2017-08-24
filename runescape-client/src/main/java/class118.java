import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
public abstract class class118 extends Node {
   @ObfuscatedName("e")
   volatile boolean field1729;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ldf;"
   )
   class121 field1728;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lds;"
   )
   class118 field1726;
   @ObfuscatedName("z")
   int field1727;

   protected class118() {
      this.field1729 = true;
   }

   @ObfuscatedName("k")
   protected abstract void vmethod3936(int[] var1, int var2, int var3);

   @ObfuscatedName("d")
   protected abstract void vmethod3937(int var1);

   @ObfuscatedName("fv")
   final void method2321(int[] var1, int var2, int var3) {
      if(this.field1729) {
         this.vmethod3936(var1, var2, var3);
      } else {
         this.vmethod3937(var3);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "()Lds;"
   )
   protected abstract class118 vmethod3934();

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "()Lds;"
   )
   protected abstract class118 vmethod3943();

   @ObfuscatedName("bd")
   int vmethod2317() {
      return 255;
   }

   @ObfuscatedName("b")
   protected abstract int vmethod3950();
}
