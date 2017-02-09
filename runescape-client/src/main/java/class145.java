import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public class class145 extends CacheableNode {
   @ObfuscatedName("o")
   public final int[] field2003;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1323694711
   )
   public final int field2004;
   @ObfuscatedName("r")
   public final int[] field2006;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1055300833
   )
   public final int field2007;

   class145(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2007 = var1;
      this.field2004 = var2;
      this.field2003 = var3;
      this.field2006 = var4;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "78"
   )
   public boolean method2726(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2006.length) {
         int var3 = this.field2006[var2];
         if(var1 >= var3 && var1 <= this.field2003[var2] + var3) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1024043833"
   )
   public static void method2727() {
      Spotanim.field2786.reset();
      Spotanim.field2775.reset();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-27"
   )
   @Export("calculateHeight")
   public static int calculateHeight(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var2 + var0) / var1 - var2;
   }
}
