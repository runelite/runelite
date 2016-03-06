package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eo")
public class class146 extends class132 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -4053398288406020905L
   )
   long field2227 = System.nanoTime();

   @ObfuscatedName("l")
   void vmethod3066() {
      this.field2227 = System.nanoTime();
   }

   @ObfuscatedName("a")
   int vmethod3067(int var1, int var2) {
      long var3 = 1000000L * (long)var2;
      long var5 = this.field2227 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class105.method2332(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2227 < var7); this.field2227 += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.field2227 < var7) {
         this.field2227 = var7;
      }

      return var9;
   }
}
