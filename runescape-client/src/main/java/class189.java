import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
public class class189 implements Iterator {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   CombatInfoList field2436;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   Node field2435;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   Node field2437;

   @ObfuscatedSignature(
      signature = "(Lgf;)V"
   )
   class189(CombatInfoList var1) {
      this.field2437 = null;
      this.field2436 = var1;
      this.field2435 = this.field2436.node.next;
      this.field2437 = null;
   }

   public Object next() {
      Node var1 = this.field2435;
      if(var1 == this.field2436.node) {
         var1 = null;
         this.field2435 = null;
      } else {
         this.field2435 = var1.next;
      }

      this.field2437 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2436.node != this.field2435;
   }

   public void remove() {
      if(this.field2437 == null) {
         throw new IllegalStateException();
      } else {
         this.field2437.unlink();
         this.field2437 = null;
      }
   }
}
