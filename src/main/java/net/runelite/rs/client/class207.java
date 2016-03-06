import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gu")
@Implements("Node")
public class class207 {
   @ObfuscatedName("ew")
   @Export("previous")
   class207 field3110;
   @ObfuscatedName("eo")
   @Export("next")
   public class207 field3111;
   @ObfuscatedName("ez")
   @Export("hash")
   public long field3112;

   @ObfuscatedName("hb")
   public void method3853() {
      if(this.field3110 != null) {
         this.field3110.field3111 = this.field3111;
         this.field3111.field3110 = this.field3110;
         this.field3111 = null;
         this.field3110 = null;
      }
   }

   @ObfuscatedName("ht")
   public boolean method3854() {
      return this.field3110 != null;
   }
}
