import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class150 extends class158 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -5537715616197734199L
   )
   long field2221;

   public class150() {
      this.field2221 = System.nanoTime();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-85"
   )
   public void vmethod2965() {
      this.field2221 = System.nanoTime();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-70"
   )
   public int vmethod2964(int var1, int var2) {
      long var3 = 1000000L * (long)var2;
      long var5 = this.field2221 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      XItemContainer.method1113(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2221 < var7); this.field2221 += 1000000L * (long)var1) {
         ++var9;
      }

      if(this.field2221 < var7) {
         this.field2221 = var7;
      }

      return var9;
   }
}
