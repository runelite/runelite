package net.runelite.rs.client;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gd")
@Implements("XHashTable")
public final class class195 {
   @ObfuscatedName("j")
   int field3085;
   @ObfuscatedName("l")
   class207[] field3086;
   @ObfuscatedName("f")
   int field3087 = 0;
   @ObfuscatedName("i")
   class207 field3088;
   @ObfuscatedName("a")
   class207 field3089;

   @ObfuscatedName("a")
   void method3743() {
      for(int var1 = 0; var1 < this.field3085; ++var1) {
         class207 var2 = this.field3086[var1];

         while(true) {
            class207 var3 = var2.field3111;
            if(var3 == var2) {
               break;
            }

            var3.method3853();
         }
      }

      this.field3089 = null;
      this.field3088 = null;
   }

   @ObfuscatedName("j")
   public class207 method3744(long var1) {
      class207 var3 = this.field3086[(int)(var1 & (long)(this.field3085 - 1))];

      for(this.field3089 = var3.field3111; this.field3089 != var3; this.field3089 = this.field3089.field3111) {
         if(this.field3089.field3112 == var1) {
            class207 var4 = this.field3089;
            this.field3089 = this.field3089.field3111;
            return var4;
         }
      }

      this.field3089 = null;
      return null;
   }

   public class195(int var1) {
      this.field3085 = var1;
      this.field3086 = new class207[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class207 var3 = this.field3086[var2] = new class207();
         var3.field3111 = var3;
         var3.field3110 = var3;
      }

   }

   @ObfuscatedName("l")
   public void method3746(class207 var1, long var2) {
      if(var1.field3110 != null) {
         var1.method3853();
      }

      class207 var4 = this.field3086[(int)(var2 & (long)(this.field3085 - 1))];
      var1.field3110 = var4.field3110;
      var1.field3111 = var4;
      var1.field3110.field3111 = var1;
      var1.field3111.field3110 = var1;
      var1.field3112 = var2;
   }

   @ObfuscatedName("f")
   public class207 method3747() {
      class207 var1;
      if(this.field3087 > 0 && this.field3088 != this.field3086[this.field3087 - 1]) {
         var1 = this.field3088;
         this.field3088 = var1.field3111;
         return var1;
      } else {
         do {
            if(this.field3087 >= this.field3085) {
               return null;
            }

            var1 = this.field3086[this.field3087++].field3111;
         } while(var1 == this.field3086[this.field3087 - 1]);

         this.field3088 = var1.field3111;
         return var1;
      }
   }

   @ObfuscatedName("i")
   public class207 method3748() {
      this.field3087 = 0;
      return this.method3747();
   }
}
