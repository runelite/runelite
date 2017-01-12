import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bx")
public abstract class class68 extends Node {
   @ObfuscatedName("j")
   class68 field1133;
   @ObfuscatedName("p")
   int field1134;
   @ObfuscatedName("r")
   volatile boolean field1135 = true;
   @ObfuscatedName("k")
   class71 field1136;

   @ObfuscatedName("e")
   protected abstract void vmethod2675(int var1);

   @ObfuscatedName("ar")
   int vmethod1300() {
      return 255;
   }

   @ObfuscatedName("z")
   protected abstract class68 vmethod2672();

   @ObfuscatedName("t")
   protected abstract int vmethod2673();

   @ObfuscatedName("m")
   protected abstract void vmethod2674(int[] var1, int var2, int var3);

   @ObfuscatedName("fy")
   final void method1308(int[] var1, int var2, int var3) {
      if(this.field1135) {
         this.vmethod2674(var1, var2, var3);
      } else {
         this.vmethod2675(var3);
      }

   }

   @ObfuscatedName("g")
   protected abstract class68 vmethod2671();
}
