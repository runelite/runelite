import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class147 extends class133 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -6387368519204792357L
   )
   long field2219 = System.nanoTime();

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1973561307"
   )
   void vmethod3146() {
      this.field2219 = System.nanoTime();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1829064411"
   )
   int vmethod3147(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.field2219 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class98.method2264(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2219 < var7); this.field2219 += 1000000L * (long)var1) {
         ++var9;
      }

      if(this.field2219 < var7) {
         this.field2219 = var7;
      }

      return var9;
   }
}
