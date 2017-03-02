import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
public class class98 extends class109 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -4348721873055522323L
   )
   long field1634 = System.nanoTime();

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void vmethod2102() {
      this.field1634 = System.nanoTime();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "94"
   )
   int vmethod2103(int var1, int var2) {
      long var3 = 1000000L * (long)var2;
      long var5 = this.field1634 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class115.method2301(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field1634 < var7); this.field1634 += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.field1634 < var7) {
         this.field1634 = var7;
      }

      return var9;
   }
}
