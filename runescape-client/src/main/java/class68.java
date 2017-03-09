import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bo")
public abstract class class68 extends Node {
   @ObfuscatedName("f")
   class71 field1147;
   @ObfuscatedName("i")
   int field1148;
   @ObfuscatedName("w")
   volatile boolean field1149 = true;
   @ObfuscatedName("m")
   class68 field1150;

   @ObfuscatedName("as")
   int vmethod1412() {
      return 255;
   }

   @ObfuscatedName("u")
   protected abstract class68 vmethod2723();

   @ObfuscatedName("y")
   protected abstract class68 vmethod2724();

   @ObfuscatedName("e")
   protected abstract int vmethod2725();

   @ObfuscatedName("l")
   protected abstract void vmethod2729(int var1);

   @ObfuscatedName("q")
   protected abstract void vmethod2726(int[] var1, int var2, int var3);

   @ObfuscatedName("ev")
   final void method1423(int[] var1, int var2, int var3) {
      if(this.field1149) {
         this.vmethod2726(var1, var2, var3);
      } else {
         this.vmethod2729(var3);
      }

   }
}
