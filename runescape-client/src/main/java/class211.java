import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hf")
@Implements("Node")
public class class211 {
   @ObfuscatedName("em")
   @Export("previous")
   class211 field3166;
   @ObfuscatedName("ez")
   @Export("hash")
   public long field3167;
   @ObfuscatedName("eu")
   @Export("next")
   public class211 field3168;

   @ObfuscatedName("hm")
   @Export("linked")
   public boolean method3989() {
      return this.field3166 != null;
   }

   @ObfuscatedName("hc")
   @Export("unlink")
   public void method3990() {
      if(this.field3166 != null) {
         this.field3166.field3168 = this.field3168;
         this.field3168.field3166 = this.field3166;
         this.field3168 = null;
         this.field3166 = null;
      }
   }
}
