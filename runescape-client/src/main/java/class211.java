import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hs")
@Implements("Node")
public class class211 {
   @ObfuscatedName("er")
   @Export("hash")
   public long field3161;
   @ObfuscatedName("eg")
   @Export("next")
   public class211 field3162;
   @ObfuscatedName("eu")
   @Export("previous")
   class211 field3163;

   @ObfuscatedName("iu")
   @Export("unlink")
   public void method4000() {
      if(this.field3163 != null) {
         this.field3163.field3162 = this.field3162;
         this.field3162.field3163 = this.field3163;
         this.field3162 = null;
         this.field3163 = null;
      }
   }

   @ObfuscatedName("io")
   @Export("linked")
   public boolean method4001() {
      return this.field3163 != null;
   }
}
