import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public class class189 implements Iterator {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   CombatInfoList field2458;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   Node field2457;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   Node field2459;

   @ObfuscatedSignature(
      signature = "(Lgn;)V"
   )
   class189(CombatInfoList var1) {
      this.field2459 = null;
      this.field2458 = var1;
      this.field2457 = this.field2458.node.next;
      this.field2459 = null;
   }

   public boolean hasNext() {
      return this.field2458.node != this.field2457;
   }

   public void remove() {
      if(this.field2459 == null) {
         throw new IllegalStateException();
      } else {
         this.field2459.unlink();
         this.field2459 = null;
      }
   }

   public Object next() {
      Node var1 = this.field2457;
      if(var1 == this.field2458.node) {
         var1 = null;
         this.field2457 = null;
      } else {
         this.field2457 = var1.next;
      }

      this.field2459 = var1;
      return var1;
   }
}
