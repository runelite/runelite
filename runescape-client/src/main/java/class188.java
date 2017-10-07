import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class188 implements Iterator {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   CombatInfoList field2470;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   Node field2469;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   Node field2471;

   @ObfuscatedSignature(
      signature = "(Lgp;)V"
   )
   class188(CombatInfoList var1) {
      this.field2471 = null;
      this.field2470 = var1;
      this.field2469 = this.field2470.node.next;
      this.field2471 = null;
   }

   public boolean hasNext() {
      return this.field2470.node != this.field2469;
   }

   public void remove() {
      if(this.field2471 == null) {
         throw new IllegalStateException();
      } else {
         this.field2471.unlink();
         this.field2471 = null;
      }
   }

   public Object next() {
      Node var1 = this.field2469;
      if(var1 == this.field2470.node) {
         var1 = null;
         this.field2469 = null;
      } else {
         this.field2469 = var1.next;
      }

      this.field2471 = var1;
      return var1;
   }
}
