import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hg")
public class class208 implements Iterator {
   @ObfuscatedName("v")
   Node field3161 = null;
   @ObfuscatedName("d")
   Node field3162;
   @ObfuscatedName("a")
   class205 field3163;

   public Object next() {
      Node var1 = this.field3162;
      if(var1 == this.field3163.field3157) {
         var1 = null;
         this.field3162 = null;
      } else {
         this.field3162 = var1.next;
      }

      this.field3161 = var1;
      return var1;
   }

   public void remove() {
      if(this.field3161 == null) {
         throw new IllegalStateException();
      } else {
         this.field3161.unlink();
         this.field3161 = null;
      }
   }

   class208(class205 var1) {
      this.field3163 = var1;
      this.field3162 = this.field3163.field3157.next;
      this.field3161 = null;
   }

   public boolean hasNext() {
      return this.field3162 != this.field3163.field3157;
   }
}
