import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
public class class98 extends class109 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 9018301471216979575L
   )
   long field1634 = System.nanoTime();

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "1817"
   )
   public void vmethod2001() {
      this.field1634 = System.nanoTime();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1620220904"
   )
   int vmethod2002(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.field1634 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      XClanMember.method237(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field1634 < var7); this.field1634 += 1000000L * (long)var1) {
         ++var9;
      }

      if(this.field1634 < var7) {
         this.field1634 = var7;
      }

      return var9;
   }
}
