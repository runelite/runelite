import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gg")
@Implements("XHashTable")
public final class class199 {
   @ObfuscatedName("m")
   @Export("size")
   int field3140;
   @ObfuscatedName("g")
   int field3141 = 0;
   @ObfuscatedName("e")
   class211 field3142;
   @ObfuscatedName("o")
   class211 field3143;
   @ObfuscatedName("w")
   @Export("buckets")
   class211[] field3144;

   @ObfuscatedName("o")
   public class211 method3847() {
      this.field3141 = 0;
      return this.method3852();
   }

   @ObfuscatedName("w")
   public void method3849(class211 var1, long var2) {
      if(var1.field3166 != null) {
         var1.method3990();
      }

      class211 var4 = this.field3144[(int)(var2 & (long)(this.field3140 - 1))];
      var1.field3166 = var4.field3166;
      var1.field3168 = var4;
      var1.field3166.field3168 = var1;
      var1.field3168.field3166 = var1;
      var1.field3167 = var2;
   }

   @ObfuscatedName("e")
   void method3851() {
      for(int var1 = 0; var1 < this.field3140; ++var1) {
         class211 var2 = this.field3144[var1];

         while(true) {
            class211 var3 = var2.field3168;
            if(var3 == var2) {
               break;
            }

            var3.method3990();
         }
      }

      this.field3142 = null;
      this.field3143 = null;
   }

   @ObfuscatedName("g")
   public class211 method3852() {
      class211 var1;
      if(this.field3141 > 0 && this.field3143 != this.field3144[this.field3141 - 1]) {
         var1 = this.field3143;
         this.field3143 = var1.field3168;
         return var1;
      } else {
         do {
            if(this.field3141 >= this.field3140) {
               return null;
            }

            var1 = this.field3144[this.field3141++].field3168;
         } while(var1 == this.field3144[this.field3141 - 1]);

         this.field3143 = var1.field3168;
         return var1;
      }
   }

   public class199(int var1) {
      this.field3140 = var1;
      this.field3144 = new class211[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class211 var3 = this.field3144[var2] = new class211();
         var3.field3168 = var3;
         var3.field3166 = var3;
      }

   }

   @ObfuscatedName("m")
   public class211 method3856(long var1) {
      class211 var3 = this.field3144[(int)(var1 & (long)(this.field3140 - 1))];

      for(this.field3142 = var3.field3168; this.field3142 != var3; this.field3142 = this.field3142.field3168) {
         if(this.field3142.field3167 == var1) {
            class211 var4 = this.field3142;
            this.field3142 = this.field3142.field3168;
            return var4;
         }
      }

      this.field3142 = null;
      return null;
   }
}
