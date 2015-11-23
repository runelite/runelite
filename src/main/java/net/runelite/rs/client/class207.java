package net.runelite.rs.client;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gt")
@Implements("Node")
public class class207 {
   @ObfuscatedName("es")
   @Export("next")
   public class207 field3102;
   @ObfuscatedName("ee")
   @Export("previous")
   class207 field3103;
   @ObfuscatedName("eg")
   @Export("hash")
   public long field3104;

   @ObfuscatedName("ip")
   public void method3965() {
      if(this.field3103 != null) {
         this.field3103.field3102 = this.field3102;
         this.field3102.field3103 = this.field3103;
         this.field3102 = null;
         this.field3103 = null;
      }
   }

   @ObfuscatedName("ib")
   public boolean method3968() {
      return this.field3103 != null;
   }
}
