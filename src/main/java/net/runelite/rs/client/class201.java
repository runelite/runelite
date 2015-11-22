package net.runelite.rs.client;

import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gm")
public class class201 implements Iterable {
   @ObfuscatedName("j")
   class207 field3090 = new class207();

   @ObfuscatedName("m")
   public class207 method3907() {
      return this.method3916((class207)null);
   }

   public Iterator iterator() {
      return new class204(this);
   }

   @ObfuscatedName("f")
   class207 method3916(class207 var1) {
      class207 var2;
      if(var1 == null) {
         var2 = this.field3090.field3102;
      } else {
         var2 = var1;
      }

      return var2 == this.field3090?null:var2;
   }

   public class201() {
      this.field3090.field3102 = this.field3090;
      this.field3090.field3103 = this.field3090;
   }

   @ObfuscatedName("j")
   public void method3921(class207 var1) {
      if(var1.field3103 != null) {
         var1.method3965();
      }

      var1.field3103 = this.field3090.field3103;
      var1.field3102 = this.field3090;
      var1.field3103.field3102 = var1;
      var1.field3102.field3103 = var1;
   }
}
