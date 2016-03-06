package net.runelite.rs.client;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gj")
@Implements("CacheableNode")
public class class203 extends class207 {
   @ObfuscatedName("co")
   @Export("previous")
   public class203 field3100;
   @ObfuscatedName("cd")
   @Export("next")
   public class203 field3101;

   @ObfuscatedName("el")
   public void method3835() {
      if(this.field3101 != null) {
         this.field3101.field3100 = this.field3100;
         this.field3100.field3101 = this.field3101;
         this.field3100 = null;
         this.field3101 = null;
      }
   }
}
