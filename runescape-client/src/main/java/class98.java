import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
public class class98 extends class109 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 7184248793427953589L
   )
   long field1640 = System.nanoTime();

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "683063643"
   )
   public void vmethod2044() {
      this.field1640 = System.nanoTime();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1908807561"
   )
   int vmethod2041(int var1, int var2) {
      long var3 = 1000000L * (long)var2;
      long var5 = this.field1640 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class104.method1988(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field1640 < var7); this.field1640 += 1000000L * (long)var1) {
         ++var9;
      }

      if(this.field1640 < var7) {
         this.field1640 = var7;
      }

      return var9;
   }
}
