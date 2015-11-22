package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gx")
public class class203 extends class207 {
   @ObfuscatedName("cg")
   public class203 field3092;
   @ObfuscatedName("cf")
   public class203 field3093;

   @ObfuscatedName("fn")
   public void method3945() {
      if(this.field3092 != null) {
         this.field3092.field3093 = this.field3093;
         this.field3093.field3092 = this.field3092;
         this.field3093 = null;
         this.field3092 = null;
      }
   }
}
