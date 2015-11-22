package net.runelite.rs.client;

import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gg")
public class class193 implements Iterator {
   @ObfuscatedName("f")
   int field3071;
   @ObfuscatedName("m")
   class207 field3072;
   @ObfuscatedName("j")
   class197 field3073;
   @ObfuscatedName("l")
   class207 field3074 = null;

   @ObfuscatedName("j")
   void method3816() {
      this.field3072 = this.field3073.field3083[0].field3102;
      this.field3071 = 1;
      this.field3074 = null;
   }

   public void remove() {
      this.field3074.method3965();
      this.field3074 = null;
   }

   class193(class197 var1) {
      this.field3073 = var1;
      this.method3816();
   }

   public Object next() {
      class207 var1;
      if(this.field3072 != this.field3073.field3083[this.field3071 - 1]) {
         var1 = this.field3072;
         this.field3072 = var1.field3102;
         this.field3074 = var1;
         return var1;
      } else {
         do {
            if(this.field3071 >= this.field3073.field3084) {
               return null;
            }

            var1 = this.field3073.field3083[this.field3071++].field3102;
         } while(var1 == this.field3073.field3083[this.field3071 - 1]);

         this.field3072 = var1.field3102;
         this.field3074 = var1;
         return var1;
      }
   }

   public boolean hasNext() {
      if(this.field3072 != this.field3073.field3083[this.field3071 - 1]) {
         return true;
      } else {
         while(this.field3071 < this.field3073.field3084) {
            if(this.field3073.field3083[this.field3071++].field3102 != this.field3073.field3083[this.field3071 - 1]) {
               this.field3072 = this.field3073.field3083[this.field3071 - 1].field3102;
               return true;
            }

            this.field3072 = this.field3073.field3083[this.field3071 - 1];
         }

         return false;
      }
   }
}
