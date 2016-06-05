import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public final class class29 extends class85 {
   @ObfuscatedName("f")
   class42 field682;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1730678827
   )
   int field683;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 241257981
   )
   int field684;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 136076113
   )
   int field685;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -33096101
   )
   int field686 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1998367355
   )
   int field687;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1521728277
   )
   int field688 = 0;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = 1750453583
   )
   protected static int field690;
   @ObfuscatedName("l")
   boolean field691 = false;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1644703035
   )
   int field692;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 792443147
   )
   int field693;
   @ObfuscatedName("y")
   static boolean field694;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "423951567"
   )
   final void method642(int var1) {
      if(!this.field691) {
         this.field686 += var1;

         while(this.field686 > this.field682.field987[this.field688]) {
            this.field686 -= this.field682.field987[this.field688];
            ++this.field688;
            if(this.field688 >= this.field682.field985.length) {
               this.field691 = true;
               break;
            }
         }

      }
   }

   class29(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field692 = var1;
      this.field684 = var2;
      this.field685 = var3;
      this.field693 = var4;
      this.field687 = var5;
      this.field683 = var7 + var6;
      int var8 = class16.method162(this.field692).field1014;
      if(var8 != -1) {
         this.field691 = false;
         this.field682 = class18.method177(var8);
      } else {
         this.field691 = true;
      }

   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1120761873"
   )
   static final void method645() {
      for(int var0 = 0; var0 < client.field323; ++var0) {
         int var1 = client.field285[var0];
         class34 var2 = client.field320[var1];
         int var3 = client.field327.method2494();
         int var4;
         int var5;
         if((var3 & 4) != 0) {
            var4 = client.field327.method2495();
            var5 = client.field327.method2495();
            var2.method736(var4, var5, client.field332);
            var2.field858 = 300 + client.field332;
            var2.field826 = client.field327.method2504();
            var2.field844 = client.field327.method2545();
         }

         if((var3 & 16) != 0) {
            var2.field836 = client.field327.method2545();
            var4 = client.field327.method2505();
            var2.field803 = var4 >> 16;
            var2.field843 = (var4 & '\uffff') + client.field332;
            var2.field840 = 0;
            var2.field841 = 0;
            if(var2.field843 > client.field332) {
               var2.field840 = -1;
            }

            if(var2.field836 == '\uffff') {
               var2.field836 = -1;
            }
         }

         if((var3 & 128) != 0) {
            var4 = client.field327.method2495();
            var5 = client.field327.method2623();
            var2.method736(var4, var5, client.field332);
            var2.field858 = 300 + client.field332;
            var2.field826 = client.field327.method2504();
            var2.field844 = client.field327.method2470();
         }

         if((var3 & 32) != 0) {
            var2.field772 = class17.method169(client.field327.method2504());
            var2.field807 = var2.field772.field881;
            var2.field863 = var2.field772.field897;
            var2.field811 = var2.field772.field898;
            var2.field812 = var2.field772.field890;
            var2.field814 = var2.field772.field889;
            var2.field857 = var2.field772.field903;
            var2.field808 = var2.field772.field886;
            var2.field837 = var2.field772.field877;
            var2.field810 = var2.field772.field888;
         }

         if((var3 & 8) != 0) {
            var2.field816 = client.field327.method2476();
            var2.field842 = 100;
         }

         if((var3 & 2) != 0) {
            var2.field828 = client.field327.method2504();
            if(var2.field828 == '\uffff') {
               var2.field828 = -1;
            }
         }

         int var6;
         if((var3 & 1) != 0) {
            var4 = client.field327.method2545();
            var5 = client.field327.method2504();
            var6 = var2.field809 - 64 * (var4 - class89.field1565 - class89.field1565);
            int var7 = var2.field804 - (var5 - client.field358 - client.field358) * 64;
            if(var6 != 0 || var7 != 0) {
               var2.field830 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if((var3 & 64) != 0) {
            var4 = client.field327.method2646();
            if(var4 == '\uffff') {
               var4 = -1;
            }

            var5 = client.field327.method2495();
            if(var4 == var2.field834 && var4 != -1) {
               var6 = class18.method177(var4).field986;
               if(var6 == 1) {
                  var2.field819 = 0;
                  var2.field818 = 0;
                  var2.field824 = var5;
                  var2.field838 = 0;
               }

               if(var6 == 2) {
                  var2.field838 = 0;
               }
            } else if(var4 == -1 || var2.field834 == -1 || class18.method177(var4).field983 >= class18.method177(var2.field834).field983) {
               var2.field834 = var4;
               var2.field819 = 0;
               var2.field818 = 0;
               var2.field824 = var5;
               var2.field838 = 0;
               var2.field861 = var2.field856;
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "2124236572"
   )
   protected final class105 vmethod1862() {
      class43 var1 = class16.method162(this.field692);
      class105 var2;
      if(!this.field691) {
         var2 = var1.method883(this.field688);
      } else {
         var2 = var1.method883(-1);
      }

      return null == var2?null:var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "4"
   )
   public static int method649(int var0) {
      return var0 >> 17 & 7;
   }
}
