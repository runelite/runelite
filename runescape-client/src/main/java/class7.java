import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
@Implements("Ignore")
public class class7 {
   @ObfuscatedName("bq")
   static class168 field132;
   @ObfuscatedName("s")
   @Export("name")
   String field133;
   @ObfuscatedName("j")
   @Export("previousName")
   String field135;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = 1532048865
   )
   @Export("menuY")
   static int field136;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = -844026359
   )
   @Export("cameraZ")
   static int field138;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([Lclass25;II[I[II)V",
      garbageValue = "747711996"
   )
   static void method100(class25[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = 1 + var2;
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
                     var11 = var0[var6].field638;
                     var12 = var8.field638;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].field634;
                     var12 = var8.field634;
                     if(-1 == var11 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(3 == var3[var10]) {
                     var11 = var0[var6].method580()?1:0;
                     var12 = var8.method580()?1:0;
                  } else {
                     var11 = var0[var6].field632;
                     var12 = var8.field632;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(3 == var10) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].field638;
                     var12 = var8.field638;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].field634;
                     var12 = var8.field634;
                     if(var11 == -1 && 1 == var4[var10]) {
                        var11 = 2001;
                     }

                     if(-1 == var12 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method580()?1:0;
                     var12 = var8.method580()?1:0;
                  } else {
                     var11 = var0[var5].field632;
                     var12 = var8.field632;
                  }

                  if(var12 != var11) {
                     if((1 != var4[var10] || var11 >= var12) && (0 != var4[var10] || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(3 == var10) {
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

         method100(var0, var1, var6, var3, var4);
         method100(var0, 1 + var6, var2, var3, var4);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "262102730"
   )
   static void method101() {
      class227 var0 = null;

      try {
         var0 = class25.method614("", client.field459.field2292, true);
         class119 var1 = class76.field1388.method105();
         var0.method4106(var1.field2007, 0, var1.field2005);
      } catch (Exception var3) {
         ;
      }

      try {
         if(null != var0) {
            var0.method4121();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass167;B)V",
      garbageValue = "3"
   )
   public static void method102(class167 var0) {
      class209.field3129 = var0;
   }
}
