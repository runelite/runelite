import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public abstract class class120 extends Node {
   @ObfuscatedName("w")
   volatile boolean field1727;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lds;"
   )
   class123 field1729;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lda;"
   )
   class120 field1728;
   @ObfuscatedName("v")
   int field1726;

   protected class120() {
      this.field1727 = true;
   }

   @ObfuscatedName("w")
   protected abstract void vmethod3904(int[] var1, int var2, int var3);

   @ObfuscatedName("o")
   protected abstract void vmethod3893(int var1);

   @ObfuscatedName("fd")
   final void method2319(int[] var1, int var2, int var3) {
      if(this.field1727) {
         this.vmethod3904(var1, var2, var3);
      } else {
         this.vmethod3893(var3);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "()Lda;"
   )
   protected abstract class120 vmethod3888();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Lda;"
   )
   protected abstract class120 vmethod3894();

   @ObfuscatedName("ay")
   int vmethod2315() {
      return 255;
   }

   @ObfuscatedName("l")
   protected abstract int vmethod3889();
}
