import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
public class class188 implements Iterator {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   CombatInfoList field2450;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   Node field2449;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   Node field2448;

   @ObfuscatedSignature(
      signature = "(Lgq;)V"
   )
   class188(CombatInfoList var1) {
      this.field2448 = null;
      this.field2450 = var1;
      this.field2449 = this.field2450.node.next;
      this.field2448 = null;
   }

   public boolean hasNext() {
      return this.field2450.node != this.field2449;
   }

   public Object next() {
      Node var1 = this.field2449;
      if(var1 == this.field2450.node) {
         var1 = null;
         this.field2449 = null;
      } else {
         this.field2449 = var1.next;
      }

      this.field2448 = var1;
      return var1;
   }

   public void remove() {
      if(this.field2448 == null) {
         throw new IllegalStateException();
      } else {
         this.field2448.unlink();
         this.field2448 = null;
      }
   }
}
