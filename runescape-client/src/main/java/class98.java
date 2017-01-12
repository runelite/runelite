import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
public class class98 extends class109 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 5312832496252850497L
   )
   long field1628 = System.nanoTime();

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-489141503"
   )
   public void vmethod2003() {
      this.field1628 = System.nanoTime();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "1"
   )
   int vmethod2004(int var1, int var2) {
      long var3 = 1000000L * (long)var2;
      long var5 = this.field1628 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      VertexNormal.method1598(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field1628 < var7); this.field1628 += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.field1628 < var7) {
         this.field1628 = var7;
      }

      return var9;
   }
}
