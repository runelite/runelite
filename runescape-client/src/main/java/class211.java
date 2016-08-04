import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hb")
@Implements("Node")
public class class211 {
   @ObfuscatedName("eq")
   @Export("next")
   public class211 field3173;
   @ObfuscatedName("ef")
   @Export("previous")
   class211 field3174;
   @ObfuscatedName("em")
   @Export("hash")
   public long field3175;

   @ObfuscatedName("ii")
   @Export("unlink")
   public void method4067() {
      if(this.field3174 != null) {
         this.field3174.field3173 = this.field3173;
         this.field3173.field3174 = this.field3174;
         this.field3173 = null;
         this.field3174 = null;
      }
   }

   @ObfuscatedName("jc")
   @Export("linked")
   public boolean method4068() {
      return this.field3174 != null;
   }
}
