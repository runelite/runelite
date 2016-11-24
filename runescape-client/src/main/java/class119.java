import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public abstract class class119 {
   @ObfuscatedName("aw")
   static int[] field1848;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 63303921
   )
   public int field1849;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 722011471
   )
   public int field1850;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2064717835
   )
   public int field1851;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1162038841
   )
   public int field1856;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "-47430657"
   )
   protected abstract boolean vmethod2346(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass182;IIIZI)V",
      garbageValue = "-1725877821"
   )
   public static void method2349(class182 var0, int var1, int var2, int var3, boolean var4) {
      class138.field1917 = 1;
      class1.field12 = var0;
      class138.field1918 = var1;
      Frames.field1566 = var2;
      class101.field1649 = var3;
      class34.field742 = var4;
      class114.field1792 = 10000;
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   static final void method2350() {
      Client.field330.method3234(208);
      Client.field330.method2975(0);
   }
}
