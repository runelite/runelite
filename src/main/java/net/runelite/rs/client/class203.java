package net.runelite.rs.client;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gx")
@Implements("CacheableNode")
public class class203 extends class207 {
   @ObfuscatedName("cg")
   @Export("previous")
   public class203 field3092;
   @ObfuscatedName("cf")
   @Export("next")
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
