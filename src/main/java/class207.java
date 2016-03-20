import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gs")
@Implements("Node")
public class class207 {
   @ObfuscatedName("ez")
   @Export("previous")
   class207 field3109;
   @ObfuscatedName("ep")
   @Export("next")
   public class207 field3110;
   @ObfuscatedName("eq")
   @Export("hash")
   public long field3111;

   @ObfuscatedName("iz")
   public boolean method3944() {
      return this.field3109 != null;
   }

   @ObfuscatedName("if")
   public void method3946() {
      if(this.field3109 != null) {
         this.field3109.field3110 = this.field3110;
         this.field3110.field3109 = this.field3109;
         this.field3110 = null;
         this.field3109 = null;
      }
   }
}
