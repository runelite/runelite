import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bm")
public abstract class class68 extends Node {
   @ObfuscatedName("z")
   class71 field1164;
   @ObfuscatedName("v")
   int field1165;
   @ObfuscatedName("a")
   class68 field1166;
   @ObfuscatedName("w")
   volatile boolean field1167 = true;

   @ObfuscatedName("l")
   protected abstract class68 vmethod2768();

   @ObfuscatedName("fh")
   final void method1378(int[] var1, int var2, int var3) {
      if(this.field1167) {
         this.vmethod2755(var1, var2, var3);
      } else {
         this.vmethod2756(var3);
      }

   }

   @ObfuscatedName("w")
   protected abstract void vmethod2755(int[] var1, int var2, int var3);

   @ObfuscatedName("s")
   protected abstract void vmethod2756(int var1);

   @ObfuscatedName("m")
   protected abstract int vmethod2766();

   @ObfuscatedName("as")
   int vmethod1397() {
      return 255;
   }

   @ObfuscatedName("n")
   protected abstract class68 vmethod2753();
}
