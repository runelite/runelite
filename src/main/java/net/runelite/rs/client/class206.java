package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gw")
public class class206 {
   @ObfuscatedName("u")
   class206 field3100;
   @ObfuscatedName("l")
   class206 field3101;

   @ObfuscatedName("j")
   public void method3963() {
      if(this.field3100 != null) {
         this.field3100.field3101 = this.field3101;
         this.field3101.field3100 = this.field3100;
         this.field3101 = null;
         this.field3100 = null;
      }
   }
}
