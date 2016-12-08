import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bi")
public abstract class class68 extends Node {
   @ObfuscatedName("x")
   class71 field1143;
   @ObfuscatedName("i")
   class68 field1144;
   @ObfuscatedName("s")
   int field1145;
   @ObfuscatedName("d")
   volatile boolean field1146 = true;

   @ObfuscatedName("j")
   protected abstract void vmethod2629(int var1);

   @ObfuscatedName("ep")
   final void method1327(int[] var1, int var2, int var3) {
      if(this.field1146) {
         this.vmethod2628(var1, var2, var3);
      } else {
         this.vmethod2629(var3);
      }

   }

   @ObfuscatedName("z")
   protected abstract void vmethod2628(int[] var1, int var2, int var3);

   @ObfuscatedName("ab")
   int vmethod1329() {
      return 255;
   }

   @ObfuscatedName("k")
   protected abstract int vmethod2624();

   @ObfuscatedName("c")
   protected abstract class68 vmethod2625();

   @ObfuscatedName("u")
   protected abstract class68 vmethod2626();
}
