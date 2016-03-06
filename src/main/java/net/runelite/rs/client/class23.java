import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("x")
public final class class23 extends class207 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -580233239
   )
   int field602;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -914734965
   )
   int field603;
   @ObfuscatedName("n")
   class64 field604;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1838531207
   )
   int field605;
   @ObfuscatedName("g")
   class64 field606;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 683654701
   )
   int field607;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 870419175
   )
   int field608;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1315495587
   )
   int field609;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -532098073
   )
   int field610;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 750046843
   )
   int field611;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 499281121
   )
   int field612;
   @ObfuscatedName("ei")
   static class80[] field613;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1276020027
   )
   int field614;
   @ObfuscatedName("j")
   static class198 field615 = new class198();
   @ObfuscatedName("r")
   class40 field616;
   @ObfuscatedName("t")
   static int[] field617;
   @ObfuscatedName("q")
   int[] field619;

   @ObfuscatedName("l")
   void method583() {
      int var1 = this.field609;
      class40 var2 = this.field616.method824();
      if(var2 != null) {
         this.field609 = var2.field967;
         this.field608 = var2.field962 * 128;
         this.field611 = var2.field963;
         this.field614 = var2.field964;
         this.field619 = var2.field965;
      } else {
         this.field609 = -1;
         this.field608 = 0;
         this.field611 = 0;
         this.field614 = 0;
         this.field619 = null;
      }

      if(this.field609 != var1 && this.field604 != null) {
         class17.field252.method1137(this.field604);
         this.field604 = null;
      }

   }

   @ObfuscatedName("a")
   static void method591(class25[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var1 + var2) / 2;
         class25 var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(2 == var3[var10]) {
                     var11 = var0[var6].field642;
                     var12 = var8.field642;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].field639;
                     var12 = var8.field639;
                     if(var11 == -1 && 1 == var4[var10]) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && 1 == var4[var10]) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method612()?1:0;
                     var12 = var8.method612()?1:0;
                  } else {
                     var11 = var0[var6].field637;
                     var12 = var8.field637;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 <= var12) && (0 != var4[var10] || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].field642;
                     var12 = var8.field642;
                  } else if(1 == var3[var10]) {
                     var11 = var0[var5].field639;
                     var12 = var8.field639;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(-1 == var12 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(3 == var3[var10]) {
                     var11 = var0[var5].method612()?1:0;
                     var12 = var8.method612()?1:0;
                  } else {
                     var11 = var0[var5].field637;
                     var12 = var8.field637;
                  }

                  if(var11 != var12) {
                     if((1 != var4[var10] || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               class25 var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method591(var0, var1, var6, var3, var4);
         method591(var0, 1 + var6, var2, var3, var4);
      }

   }
}
