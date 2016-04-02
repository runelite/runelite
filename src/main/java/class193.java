import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gz")
public final class class193 {
   @ObfuscatedName("f")
   int field3078;
   @ObfuscatedName("w")
   int field3079;
   @ObfuscatedName("e")
   class204 field3080 = new class204();
   @ObfuscatedName("s")
   class196 field3081;
   @ObfuscatedName("p")
   class203 field3082 = new class203();

   @ObfuscatedName("e")
   public class204 method3754(long var1) {
      class204 var3 = (class204)this.field3081.method3788(var1);
      if(var3 != null) {
         this.field3082.method3875(var3);
      }

      return var3;
   }

   @ObfuscatedName("w")
   public void method3755(long var1) {
      class204 var3 = (class204)this.field3081.method3788(var1);
      if(var3 != null) {
         var3.method3913();
         var3.method3891();
         ++this.field3078;
      }

   }

   @ObfuscatedName("f")
   public void method3756(class204 var1, long var2) {
      if(this.field3078 == 0) {
         class204 var4 = this.field3082.method3877();
         var4.method3913();
         var4.method3891();
         if(var4 == this.field3080) {
            var4 = this.field3082.method3877();
            var4.method3913();
            var4.method3891();
         }
      } else {
         --this.field3078;
      }

      this.field3081.method3789(var1, var2);
      this.field3082.method3875(var1);
   }

   public class193(int var1) {
      this.field3079 = var1;
      this.field3078 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.field3081 = new class196(var2);
   }

   @ObfuscatedName("s")
   public void method3760() {
      this.field3082.method3890();
      this.field3081.method3790();
      this.field3080 = new class204();
      this.field3078 = this.field3079;
   }
}
