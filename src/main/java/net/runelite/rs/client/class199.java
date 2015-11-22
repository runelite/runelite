package net.runelite.rs.client;

import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("go")
public class class199 implements Iterable {
   @ObfuscatedName("j")
   public class203 field3088 = new class203();

   @ObfuscatedName("j")
   public void method3898() {
      while(this.field3088.field3093 != this.field3088) {
         this.field3088.field3093.method3945();
      }

   }

   @ObfuscatedName("m")
   public void method3899(class203 var1) {
      if(var1.field3092 != null) {
         var1.method3945();
      }

      var1.field3092 = this.field3088.field3092;
      var1.field3093 = this.field3088;
      var1.field3092.field3093 = var1;
      var1.field3093.field3092 = var1;
   }

   public Iterator iterator() {
      return new class205(this);
   }

   public class199() {
      this.field3088.field3093 = this.field3088;
      this.field3088.field3092 = this.field3088;
   }
}
