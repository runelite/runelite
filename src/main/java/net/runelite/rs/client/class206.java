package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gs")
public class class206 {
   @ObfuscatedName("f")
   class206 field3108;
   @ObfuscatedName("i")
   class206 field3109;

   @ObfuscatedName("j")
   public void method3850() {
      if(this.field3108 != null) {
         this.field3108.field3109 = this.field3109;
         this.field3109.field3108 = this.field3108;
         this.field3109 = null;
         this.field3108 = null;
      }
   }
}
