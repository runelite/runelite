import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public final class class213 {
   @ObfuscatedName("d")
   int field2643;
   @ObfuscatedName("z")
   int field2642;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   IterableHashTable field2641;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   IterableDualNodeQueue field2644;

   public class213(int var1, int var2) {
      this.field2644 = new IterableDualNodeQueue();
      this.field2643 = var1;
      this.field2642 = var1;

      int var3;
      for(var3 = 1; var3 + var3 < var1 && var3 < var2; var3 += var3) {
         ;
      }

      this.field2641 = new IterableHashTable(var3);
   }

   @ObfuscatedName("d")
   public Object method4044(long var1) {
      class224 var3 = (class224)this.field2641.get(var1);
      if(var3 == null) {
         return null;
      } else {
         Object var4 = var3.vmethod4197();
         if(var4 == null) {
            var3.unlink();
            var3.unlinkDual();
            this.field2642 += var3.field2670;
            return null;
         } else {
            if(var3.vmethod4201()) {
               class208 var5 = new class208(var4, var3.field2670);
               this.field2641.put(var5, var3.hash);
               this.field2644.add(var5);
               var5.field2658 = 0L;
               var3.unlink();
               var3.unlinkDual();
            } else {
               this.field2644.add(var3);
               var3.field2658 = 0L;
            }

            return var4;
         }
      }
   }

   @ObfuscatedName("z")
   void method4064(long var1) {
      class224 var3 = (class224)this.field2641.get(var1);
      this.method4067(var3);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lhy;)V"
   )
   void method4067(class224 var1) {
      if(var1 != null) {
         var1.unlink();
         var1.unlinkDual();
         this.field2642 += var1.field2670;
      }

   }

   @ObfuscatedName("r")
   public void method4046(Object var1, long var2) {
      this.method4047(var1, var2, 1);
   }

   @ObfuscatedName("e")
   public void method4047(Object var1, long var2, int var4) {
      this.method4064(var2);
      this.field2642 -= var4;

      while(this.field2642 < 0) {
         class224 var5 = (class224)this.field2644.method4216();
         this.method4067(var5);
      }

      class208 var6 = new class208(var1, var4);
      this.field2641.put(var6, var2);
      this.field2644.add(var6);
      var6.field2658 = 0L;
   }

   @ObfuscatedName("y")
   public void method4043(int var1) {
      for(class224 var2 = (class224)this.field2644.method4222(); var2 != null; var2 = (class224)this.field2644.method4219()) {
         if(var2.vmethod4201()) {
            if(var2.vmethod4197() == null) {
               var2.unlink();
               var2.unlinkDual();
               this.field2642 += var2.field2670;
            }
         } else if(++var2.field2658 > (long)var1) {
            class219 var3 = new class219(var2.vmethod4197(), var2.field2670);
            this.field2641.put(var3, var2.hash);
            Node2LinkedList.method3969(var3, var2);
            var2.unlink();
            var2.unlinkDual();
         }
      }

   }

   @ObfuscatedName("k")
   public void method4049() {
      this.field2644.clear();
      this.field2641.clear();
      this.field2642 = this.field2643;
   }
}
