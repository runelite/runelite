import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hd")
@Implements("Node")
public class class208 {
   @ObfuscatedName("ea")
   @Export("next")
   public class208 field3124;
   @ObfuscatedName("ed")
   @Export("hash")
   public long field3125;
   @ObfuscatedName("eu")
   @Export("previous")
   class208 field3126;

   @ObfuscatedName("iq")
   @Export("linked")
   public boolean method3897() {
      return this.field3126 != null;
   }

   @ObfuscatedName("ia")
   @Export("unlink")
   public void method3898() {
      if(this.field3126 != null) {
         this.field3126.field3124 = this.field3124;
         this.field3124.field3126 = this.field3126;
         this.field3124 = null;
         this.field3126 = null;
      }

   }
}
