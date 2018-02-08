import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
public class class199 implements Iterator {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   CombatInfoList field2569;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   Node field2568;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   Node field2570;

   @ObfuscatedSignature(
      signature = "(Lgi;)V"
   )
   class199(CombatInfoList var1) {
      this.field2570 = null;
      this.field2569 = var1;
      this.field2568 = this.field2569.node.next;
      this.field2570 = null;
   }

   public Object next() {
      Node var1 = this.field2568;
      if(var1 == this.field2569.node) {
         var1 = null;
         this.field2568 = null;
      } else {
         this.field2568 = var1.next;
      }

      this.field2570 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2569.node != this.field2568;
   }

   public void remove() {
      this.field2570.unlink();
      this.field2570 = null;
   }
}
