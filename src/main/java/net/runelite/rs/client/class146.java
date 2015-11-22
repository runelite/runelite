package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("es")
public class class146 extends class132 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -5731389220578900399L
   )
   long field2205 = System.nanoTime();

   @ObfuscatedName("j")
   public void vmethod3155() {
      this.field2205 = System.nanoTime();
   }

   @ObfuscatedName("m")
   int vmethod3158(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.field2205 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class29.method711(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2205 < var7); this.field2205 += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.field2205 < var7) {
         this.field2205 = var7;
      }

      return var9;
   }
}
