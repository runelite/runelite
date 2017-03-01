import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bs")
public abstract class class68 extends Node {
   @ObfuscatedName("w")
   volatile boolean field1156 = true;
   @ObfuscatedName("b")
   int field1157;
   @ObfuscatedName("c")
   class68 field1158;
   @ObfuscatedName("l")
   class71 field1159;

   @ObfuscatedName("p")
   protected abstract class68 vmethod2765();

   @ObfuscatedName("j")
   protected abstract class68 vmethod2775();

   @ObfuscatedName("s")
   protected abstract int vmethod2767();

   @ObfuscatedName("k")
   protected abstract void vmethod2780(int[] var1, int var2, int var3);

   @ObfuscatedName("av")
   int vmethod1436() {
      return 255;
   }

   @ObfuscatedName("fk")
   final void method1446(int[] var1, int var2, int var3) {
      if(this.field1156) {
         this.vmethod2780(var1, var2, var3);
      } else {
         this.vmethod2769(var3);
      }

   }

   @ObfuscatedName("o")
   protected abstract void vmethod2769(int var1);
}
