import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("ga")
@Implements("CombatListIterator")
public class CombatListIterator implements Iterator {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   CombatInfoList field2575;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   Node field2574;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   Node field2573;

   @ObfuscatedSignature(
      signature = "(Lgo;)V"
   )
   CombatListIterator(CombatInfoList var1) {
      this.field2573 = null;
      this.field2575 = var1;
      this.field2574 = this.field2575.node.next;
      this.field2573 = null;
   }

   public boolean hasNext() {
      return this.field2575.node != this.field2574;
   }

   public void remove() {
      this.field2573.unlink();
      this.field2573 = null;
   }

   public Object next() {
      Node var1 = this.field2574;
      if(var1 == this.field2575.node) {
         var1 = null;
         this.field2574 = null;
      } else {
         this.field2574 = var1.next;
      }

      this.field2573 = var1;
      return var1;
   }
}
