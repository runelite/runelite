package net.runelite.rs.client;

import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gf")
public final class class197 implements Iterable {
   @ObfuscatedName("m")
   class207[] field3083;
   @ObfuscatedName("j")
   int field3084;
   @ObfuscatedName("f")
   class207 field3085;

   @ObfuscatedName("m")
   public void method3850(class207 var1, long var2) {
      if(var1.field3103 != null) {
         var1.method3965();
      }

      class207 var4 = this.field3083[(int)(var2 & (long)(this.field3084 - 1))];
      var1.field3103 = var4.field3103;
      var1.field3102 = var4;
      var1.field3103.field3102 = var1;
      var1.field3102.field3103 = var1;
      var1.field3104 = var2;
   }

   @ObfuscatedName("j")
   public class207 method3851(long var1) {
      class207 var3 = this.field3083[(int)(var1 & (long)(this.field3084 - 1))];

      for(this.field3085 = var3.field3102; this.field3085 != var3; this.field3085 = this.field3085.field3102) {
         if(this.field3085.field3104 == var1) {
            class207 var4 = this.field3085;
            this.field3085 = this.field3085.field3102;
            return var4;
         }
      }

      this.field3085 = null;
      return null;
   }

   @ObfuscatedName("f")
   public void method3853() {
      for(int var1 = 0; var1 < this.field3084; ++var1) {
         class207 var2 = this.field3083[var1];

         while(true) {
            class207 var3 = var2.field3102;
            if(var3 == var2) {
               break;
            }

            var3.method3965();
         }
      }

      this.field3085 = null;
   }

   public Iterator iterator() {
      return new class193(this);
   }

   public class197(int var1) {
      this.field3084 = var1;
      this.field3083 = new class207[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class207 var3 = this.field3083[var2] = new class207();
         var3.field3102 = var3;
         var3.field3103 = var3;
      }

   }
}
