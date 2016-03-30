import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hl")
@Implements("Node")
public class class208 {
   @ObfuscatedName("eb")
   @Export("hash")
   public long field3123;
   @ObfuscatedName("ew")
   @Export("next")
   public class208 field3124;
   @ObfuscatedName("ev")
   @Export("previous")
   class208 field3125;

   @ObfuscatedName("ih")
   public void method3935() {
      if(this.field3125 != null) {
         this.field3125.field3124 = this.field3124;
         this.field3124.field3125 = this.field3125;
         this.field3124 = null;
         this.field3125 = null;
      }
   }

   @ObfuscatedName("ia")
   public boolean method3936() {
      return this.field3125 != null;
   }
}
