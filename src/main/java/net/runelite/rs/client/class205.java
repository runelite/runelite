package net.runelite.rs.client;

import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gp")
public class class205 implements Iterator {
   @ObfuscatedName("j")
   class199 field3097;
   @ObfuscatedName("m")
   class203 field3098;
   @ObfuscatedName("f")
   class203 field3099 = null;

   public Object next() {
      class203 var1 = this.field3098;
      if(var1 == this.field3097.field3088) {
         var1 = null;
         this.field3098 = null;
      } else {
         this.field3098 = var1.field3093;
      }

      this.field3099 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field3098 != this.field3097.field3088;
   }

   class205(class199 var1) {
      this.field3097 = var1;
      this.field3098 = this.field3097.field3088.field3093;
      this.field3099 = null;
   }

   public void remove() {
      if(this.field3099 == null) {
         throw new IllegalStateException();
      } else {
         this.field3099.method3945();
         this.field3099 = null;
      }
   }
}
