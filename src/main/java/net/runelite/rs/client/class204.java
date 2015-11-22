package net.runelite.rs.client;

import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gj")
public class class204 implements Iterator {
   @ObfuscatedName("f")
   class207 field3094 = null;
   @ObfuscatedName("m")
   class207 field3095;
   @ObfuscatedName("j")
   class201 field3096;

   public Object next() {
      class207 var1 = this.field3095;
      if(var1 == this.field3096.field3090) {
         var1 = null;
         this.field3095 = null;
      } else {
         this.field3095 = var1.field3102;
      }

      this.field3094 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field3095 != this.field3096.field3090;
   }

   class204(class201 var1) {
      this.field3096 = var1;
      this.field3095 = this.field3096.field3090.field3102;
      this.field3094 = null;
   }

   public void remove() {
      if(this.field3094 == null) {
         throw new IllegalStateException();
      } else {
         this.field3094.method3965();
         this.field3094 = null;
      }
   }
}
