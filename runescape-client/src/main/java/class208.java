import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hc")
@Implements("Node")
public class class208 {
   @ObfuscatedName("eq")
   @Export("hash")
   public long field3122;
   @ObfuscatedName("eh")
   @Export("next")
   public class208 field3123;
   @ObfuscatedName("ez")
   @Export("previous")
   class208 field3124;

   @ObfuscatedName("it")
   public boolean method3882() {
      return this.field3124 != null;
   }

   @ObfuscatedName("ig")
   public void method3883() {
      if(this.field3124 != null) {
         this.field3124.field3123 = this.field3123;
         this.field3123.field3124 = this.field3124;
         this.field3123 = null;
         this.field3124 = null;
      }
   }
}
