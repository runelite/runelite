import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class199 implements Iterator {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   CombatInfoList field2580;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   Node field2581;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   Node field2582;

   @ObfuscatedSignature(
      signature = "(Lgs;)V"
   )
   class199(CombatInfoList var1) {
      this.field2582 = null;
      this.field2580 = var1;
      this.field2581 = this.field2580.node.next;
      this.field2582 = null;
   }

   public void remove() {
      this.field2582.unlink();
      this.field2582 = null;
   }

   public Object next() {
      Node var1 = this.field2581;
      if(var1 == this.field2580.node) {
         var1 = null;
         this.field2581 = null;
      } else {
         this.field2581 = var1.next;
      }

      this.field2582 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2580.node != this.field2581;
   }
}
