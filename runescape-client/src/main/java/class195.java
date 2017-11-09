import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
public class class195 implements Iterator {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   CombatInfoList field2546;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   Node field2547;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   Node field2548;

   @ObfuscatedSignature(
      signature = "(Lgo;)V"
   )
   class195(CombatInfoList var1) {
      this.field2548 = null;
      this.field2546 = var1;
      this.field2547 = this.field2546.node.next;
      this.field2548 = null;
   }

   public Object next() {
      Node var1 = this.field2547;
      if(var1 == this.field2546.node) {
         var1 = null;
         this.field2547 = null;
      } else {
         this.field2547 = var1.next;
      }

      this.field2548 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2546.node != this.field2547;
   }

   public void remove() {
      if(this.field2548 == null) {
         throw new IllegalStateException();
      } else {
         this.field2548.unlink();
         this.field2548 = null;
      }
   }
}
