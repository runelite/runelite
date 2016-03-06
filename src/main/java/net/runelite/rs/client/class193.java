package net.runelite.rs.client;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gg")
public class class193 implements Iterator {
   @ObfuscatedName("l")
   class207 field3079;
   @ObfuscatedName("i")
   class207 field3080 = null;
   @ObfuscatedName("a")
   int field3081;
   @ObfuscatedName("j")
   class197 field3082;

   class193(class197 var1) {
      this.field3082 = var1;
      this.method3726();
   }

   @ObfuscatedName("j")
   void method3726() {
      this.field3079 = this.field3082.field3092[0].field3111;
      this.field3081 = 1;
      this.field3080 = null;
   }

   public Object next() {
      class207 var1;
      if(this.field3079 != this.field3082.field3092[this.field3081 - 1]) {
         var1 = this.field3079;
         this.field3079 = var1.field3111;
         this.field3080 = var1;
         return var1;
      } else {
         do {
            if(this.field3081 >= this.field3082.field3091) {
               return null;
            }

            var1 = this.field3082.field3092[this.field3081++].field3111;
         } while(var1 == this.field3082.field3092[this.field3081 - 1]);

         this.field3079 = var1.field3111;
         this.field3080 = var1;
         return var1;
      }
   }

   public boolean hasNext() {
      if(this.field3079 != this.field3082.field3092[this.field3081 - 1]) {
         return true;
      } else {
         while(this.field3081 < this.field3082.field3091) {
            if(this.field3082.field3092[this.field3081++].field3111 != this.field3082.field3092[this.field3081 - 1]) {
               this.field3079 = this.field3082.field3092[this.field3081 - 1].field3111;
               return true;
            }

            this.field3079 = this.field3082.field3092[this.field3081 - 1];
         }

         return false;
      }
   }

   public void remove() {
      if(this.field3080 == null) {
         throw new IllegalStateException();
      } else {
         this.field3080.method3853();
         this.field3080 = null;
      }
   }
}
