import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class199 implements Iterator {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   CombatInfoList field2429;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   Node field2428;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   Node field2430;

   @ObfuscatedSignature(
      signature = "(Lgt;)V"
   )
   class199(CombatInfoList var1) {
      this.field2430 = null;
      this.field2429 = var1;
      this.field2428 = this.field2429.node.next;
      this.field2430 = null;
   }

   public void remove() {
      if(this.field2430 == null) {
         throw new IllegalStateException();
      } else {
         this.field2430.unlink();
         this.field2430 = null;
      }
   }

   public Object next() {
      Node var1 = this.field2428;
      if(var1 == this.field2429.node) {
         var1 = null;
         this.field2428 = null;
      } else {
         this.field2428 = var1.next;
      }

      this.field2430 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2429.node != this.field2428;
   }
}
