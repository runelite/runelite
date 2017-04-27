import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
public class class98 extends class109 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -8045312740261136589L
   )
   long field1629 = System.nanoTime();

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-86"
   )
   public void vmethod2062() {
      this.field1629 = System.nanoTime();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "29"
   )
   int vmethod2063(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.field1629 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class0.method14(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field1629 < var7); this.field1629 += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.field1629 < var7) {
         this.field1629 = var7;
      }

      return var9;
   }
}
