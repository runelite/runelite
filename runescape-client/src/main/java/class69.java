import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bd")
public abstract class class69 extends Node {
   @ObfuscatedName("h")
   int field1307;
   @ObfuscatedName("a")
   volatile boolean field1308 = true;
   @ObfuscatedName("u")
   class68 field1309;
   @ObfuscatedName("s")
   class69 field1310;

   @ObfuscatedName("b")
   protected abstract class69 vmethod3753();

   @ObfuscatedName("l")
   protected abstract class69 vmethod3746();

   @ObfuscatedName("m")
   protected abstract int vmethod3747();

   @ObfuscatedName("af")
   int vmethod1493() {
      return 255;
   }

   @ObfuscatedName("p")
   protected abstract void vmethod3748(int[] var1, int var2, int var3);

   @ObfuscatedName("d")
   protected abstract void vmethod3749(int var1);

   @ObfuscatedName("ey")
   final void method1500(int[] var1, int var2, int var3) {
      if(this.field1308) {
         this.vmethod3748(var1, var2, var3);
      } else {
         this.vmethod3749(var3);
      }

   }
}
