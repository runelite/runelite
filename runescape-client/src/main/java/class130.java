import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("en")
public class class130 {
   @ObfuscatedName("i")
   class131 field1910;
   @ObfuscatedName("f")
   class131 field1911 = new class131();

   public class130() {
      this.field1911.field1912 = this.field1911;
      this.field1911.field1913 = this.field1911;
   }

   @ObfuscatedName("f")
   public void method2498(class131 var1) {
      if(var1.field1913 != null) {
         var1.method2511();
      }

      var1.field1913 = this.field1911.field1913;
      var1.field1912 = this.field1911;
      var1.field1913.field1912 = var1;
      var1.field1912.field1913 = var1;
   }

   @ObfuscatedName("i")
   public class131 method2499() {
      class131 var1 = this.field1911.field1912;
      if(var1 == this.field1911) {
         this.field1910 = null;
         return null;
      } else {
         this.field1910 = var1.field1912;
         return var1;
      }
   }

   @ObfuscatedName("u")
   public class131 method2500() {
      class131 var1 = this.field1910;
      if(var1 == this.field1911) {
         this.field1910 = null;
         return null;
      } else {
         this.field1910 = var1.field1912;
         return var1;
      }
   }
}
