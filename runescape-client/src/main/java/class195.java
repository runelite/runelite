import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
public class class195 implements Iterator {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   CombatInfoList field2540;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   Node field2539;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   Node field2541;

   @ObfuscatedSignature(
      signature = "(Lgx;)V"
   )
   class195(CombatInfoList var1) {
      this.field2541 = null;
      this.field2540 = var1;
      this.field2539 = this.field2540.node.next;
      this.field2541 = null;
   }

   public Object next() {
      Node var1 = this.field2539;
      if(var1 == this.field2540.node) {
         var1 = null;
         this.field2539 = null;
      } else {
         this.field2539 = var1.next;
      }

      this.field2541 = var1;
      return var1;
   }

   public void remove() {
      if(this.field2541 == null) {
         throw new IllegalStateException();
      } else {
         this.field2541.unlink();
         this.field2541 = null;
      }
   }

   public boolean hasNext() {
      return this.field2540.node != this.field2539;
   }
}
