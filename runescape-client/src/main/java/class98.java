import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public class class98 extends class109 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 3690583662344209461L
   )
   long field1662 = System.nanoTime();

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "299182090"
   )
   void vmethod2090() {
      this.field1662 = System.nanoTime();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1101349845"
   )
   int vmethod2091(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.field1662 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class115.method2300(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field1662 < var7); this.field1662 += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.field1662 < var7) {
         this.field1662 = var7;
      }

      return var9;
   }
}
