import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ea")
public class class144 implements Iterator {
   @ObfuscatedName("n")
   Node field2016 = null;
   @ObfuscatedName("c")
   Node field2017;
   @ObfuscatedName("d")
   CombatInfoList field2018;

   public Object next() {
      Node var1 = this.field2017;
      if(var1 == this.field2018.node) {
         var1 = null;
         this.field2017 = null;
      } else {
         this.field2017 = var1.next;
      }

      this.field2016 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2017 != this.field2018.node;
   }

   public void remove() {
      if(this.field2016 == null) {
         throw new IllegalStateException();
      } else {
         this.field2016.unlink();
         this.field2016 = null;
      }
   }

   class144(CombatInfoList var1) {
      this.field2018 = var1;
      this.field2017 = this.field2018.node.next;
      this.field2016 = null;
   }
}
