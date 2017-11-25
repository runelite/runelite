import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class195 implements Iterator {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   CombatInfoList field2550;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   Node field2549;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   Node field2548;

   @ObfuscatedSignature(
      signature = "(Lgl;)V"
   )
   class195(CombatInfoList var1) {
      this.field2548 = null;
      this.field2550 = var1;
      this.field2549 = this.field2550.node.next;
      this.field2548 = null;
   }

   public boolean hasNext() {
      return this.field2550.node != this.field2549;
   }

   public Object next() {
      Node var1 = this.field2549;
      if(var1 == this.field2550.node) {
         var1 = null;
         this.field2549 = null;
      } else {
         this.field2549 = var1.next;
      }

      this.field2548 = var1;
      return var1;
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
