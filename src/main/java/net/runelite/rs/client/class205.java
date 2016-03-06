package net.runelite.rs.client;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gb")
public class class205 implements Iterator {
   @ObfuscatedName("j")
   class199 field3105;
   @ObfuscatedName("l")
   class203 field3106;
   @ObfuscatedName("a")
   class203 field3107 = null;

   public Object next() {
      class203 var1 = this.field3106;
      if(var1 == this.field3105.field3096) {
         var1 = null;
         this.field3106 = null;
      } else {
         this.field3106 = var1.field3100;
      }

      this.field3107 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field3106 != this.field3105.field3096;
   }

   public void remove() {
      this.field3107.method3835();
      this.field3107 = null;
   }

   class205(class199 var1) {
      this.field3105 = var1;
      this.field3106 = this.field3105.field3096.field3100;
      this.field3107 = null;
   }
}
