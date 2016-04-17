import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class147 extends class133 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -6176770910032181049L
   )
   long field2215 = System.nanoTime();

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "70"
   )
   public void vmethod3216() {
      this.field2215 = System.nanoTime();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1224087509"
   )
   int vmethod3217(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.field2215 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class4.method55(var5 / 1000000L);
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
}
