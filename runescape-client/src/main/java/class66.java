import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bn")
public abstract class class66 extends class208 {
   @ObfuscatedName("h")
   int field1231;
   @ObfuscatedName("t")
   class66 field1232;
   @ObfuscatedName("v")
   class65 field1233;
   @ObfuscatedName("w")
   volatile boolean field1234 = true;

   @ObfuscatedName("c")
   protected abstract int vmethod3724();

   @ObfuscatedName("as")
   int vmethod1468() {
      return 255;
   }

   @ObfuscatedName("r")
   protected abstract class66 vmethod3736();

   @ObfuscatedName("l")
   protected abstract void vmethod3721(int[] var1, int var2, int var3);

   @ObfuscatedName("p")
   protected abstract void vmethod3725(int var1);

   @ObfuscatedName("y")
   protected abstract class66 vmethod3722();

   @ObfuscatedName("fg")
   final void method1486(int[] var1, int var2, int var3) {
      if(this.field1234) {
         this.vmethod3721(var1, var2, var3);
      } else {
         this.vmethod3725(var3);
      }

   }
}
