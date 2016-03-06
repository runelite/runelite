package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bf")
public abstract class class66 extends class207 {
   @ObfuscatedName("s")
   int field1271;
   @ObfuscatedName("d")
   class65 field1272;
   @ObfuscatedName("z")
   volatile boolean field1273 = true;
   @ObfuscatedName("y")
   class66 field1274;

   @ObfuscatedName("h")
   protected abstract int vmethod3679();

   @ObfuscatedName("m")
   protected abstract class66 vmethod3677();

   @ObfuscatedName("o")
   protected abstract class66 vmethod3678();

   @ObfuscatedName("r")
   protected abstract void vmethod3676(int var1);

   @ObfuscatedName("af")
   int vmethod1466() {
      return 255;
   }

   @ObfuscatedName("eb")
   final void method1469(int[] var1, int var2, int var3) {
      if(this.field1273) {
         this.vmethod3680(var1, var2, var3);
      } else {
         this.vmethod3676(var3);
      }

   }

   @ObfuscatedName("n")
   protected abstract void vmethod3680(int[] var1, int var2, int var3);
}
