import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
public class class150 extends class158 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -4963284643223321331L
   )
   long field2215;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1909349990"
   )
   public int vmethod2985(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.field2215 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      DynamicObject.method1842(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2215 < var7); this.field2215 += 1000000L * (long)var1) {
         ++var9;
      }

      if(this.field2215 < var7) {
         this.field2215 = var7;
      }

      return var9;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2087389048"
   )
   public void vmethod2979() {
      this.field2215 = System.nanoTime();
   }

   public class150() {
      this.field2215 = System.nanoTime();
   }
}
