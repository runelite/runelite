import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class143 extends class68 {
   @ObfuscatedName("ei")
   static ModIcon[] field2002;
   @ObfuscatedName("n")
   Deque field2003 = new Deque();
   @ObfuscatedName("g")
   class51 field2004 = new class51();
   @ObfuscatedName("x")
   class139 field2005;

   @ObfuscatedName("p")
   protected class68 vmethod2765() {
      class140 var1 = (class140)this.field2003.method2503();
      return (class68)(var1 == null?null:(var1.field1974 != null?var1.field1974:this.vmethod2775()));
   }

   @ObfuscatedName("s")
   protected int vmethod2767() {
      return 0;
   }

   @ObfuscatedName("o")
   protected void vmethod2769(int var1) {
      this.field2004.vmethod2769(var1);

      for(class140 var3 = (class140)this.field2003.method2503(); var3 != null; var3 = (class140)this.field2003.method2492()) {
         if(!this.field2005.method2609(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field1971) {
                  this.method2771(var3, var2);
                  var3.field1971 -= var2;
                  break;
               }

               this.method2771(var3, var3.field1971);
               var2 -= var3.field1971;
            } while(!this.field2005.method2686(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass140;IB)V",
      garbageValue = "118"
   )
   void method2771(class140 var1, int var2) {
      if((this.field2005.field1939[var1.field1968] & 4) != 0 && var1.field1970 < 0) {
         int var3 = this.field2005.field1950[var1.field1968] / class57.field1053;
         int var4 = (var3 + 1048575 - var1.field1976) / var3;
         var1.field1976 = var3 * var2 + var1.field1976 & 1048575;
         if(var4 <= var2) {
            if(this.field2005.field1943[var1.field1968] == 0) {
               var1.field1974 = class66.method1257(var1.field1958, var1.field1974.method1271(), var1.field1974.method1367(), var1.field1974.method1264());
            } else {
               var1.field1974 = class66.method1257(var1.field1958, var1.field1974.method1271(), 0, var1.field1974.method1264());
               this.field2005.method2587(var1, var1.field1957.field1992[var1.field1961] < 0);
            }

            if(var1.field1957.field1992[var1.field1961] < 0) {
               var1.field1974.method1259(-1);
            }

            var2 = var1.field1976 / var3;
         }
      }

      var1.field1974.vmethod2769(var2);
   }

   @ObfuscatedName("j")
   protected class68 vmethod2775() {
      class140 var1;
      do {
         var1 = (class140)this.field2003.method2492();
         if(var1 == null) {
            return null;
         }
      } while(var1.field1974 == null);

      return var1.field1974;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIIII)V",
      garbageValue = "538919254"
   )
   void method2776(class140 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2005.field1939[var1.field1968] & 4) != 0 && var1.field1970 < 0) {
         int var6 = this.field2005.field1950[var1.field1968] / class57.field1053;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field1976) / var6;
            if(var7 > var4) {
               var1.field1976 += var4 * var6;
               break;
            }

            var1.field1974.vmethod2780(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field1976 += var7 * var6 - 1048576;
            int var8 = class57.field1053 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class66 var10 = var1.field1974;
            if(this.field2005.field1943[var1.field1968] == 0) {
               var1.field1974 = class66.method1257(var1.field1958, var10.method1271(), var10.method1367(), var10.method1264());
            } else {
               var1.field1974 = class66.method1257(var1.field1958, var10.method1271(), 0, var10.method1264());
               this.field2005.method2587(var1, var1.field1957.field1992[var1.field1961] < 0);
               var1.field1974.method1267(var8, var10.method1367());
            }

            if(var1.field1957.field1992[var1.field1961] < 0) {
               var1.field1974.method1259(-1);
            }

            var10.method1269(var8);
            var10.vmethod2780(var2, var3, var5 - var3);
            if(var10.method1273()) {
               this.field2004.method1024(var10);
            }
         }
      }

      var1.field1974.vmethod2780(var2, var3, var4);
   }

   class143(class139 var1) {
      this.field2005 = var1;
   }

   @ObfuscatedName("k")
   protected void vmethod2780(int[] var1, int var2, int var3) {
      this.field2004.vmethod2780(var1, var2, var3);

      for(class140 var6 = (class140)this.field2003.method2503(); var6 != null; var6 = (class140)this.field2003.method2492()) {
         if(!this.field2005.method2609(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field1971) {
                  this.method2776(var6, var1, var4, var5, var5 + var4);
                  var6.field1971 -= var5;
                  break;
               }

               this.method2776(var6, var1, var4, var6.field1971, var5 + var4);
               var4 += var6.field1971;
               var5 -= var6.field1971;
            } while(!this.field2005.method2686(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(IIIZB)V",
      garbageValue = "0"
   )
   static final void method2789(int var0, int var1, int var2, boolean var3) {
      if(Projectile.method874(var0)) {
         class5.method71(class231.widgets[var0], -1, var1, var2, var3);
      }
   }
}
