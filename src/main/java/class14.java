import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class14 {
   @ObfuscatedName("s")
   String[] field202;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1569673887
   )
   int field203 = -1;
   @ObfuscatedName("gy")
   static class172 field204;
   @ObfuscatedName("ez")
   static class78[] field206;
   @ObfuscatedName("f")
   int[] field207;
   @ObfuscatedName("a")
   class22 field213;

   @ObfuscatedName("a")
   public static class130 method184() {
      try {
         return new class144();
      } catch (Throwable var1) {
         return null;
      }
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-594387168"
   )
   static final void method185(int var0, int var1) {
      if(client.field435 >= 2 || 0 != client.field446 || client.field448) {
         String var2;
         if(client.field446 == 1 && client.field435 < 2) {
            var2 = "Use" + " " + client.field447 + " " + "->";
         } else if(client.field448 && client.field435 < 2) {
            var2 = client.field451 + " " + client.field452 + " " + "->";
         } else {
            int var4 = client.field435 - 1;
            String var3;
            if(client.field445[var4].length() > 0) {
               var3 = client.field440[var4] + " " + client.field445[var4];
            } else {
               var3 = client.field440[var4];
            }

            var2 = var3;
         }

         if(client.field435 > 2) {
            var2 = var2 + class51.method1090(16777215) + " " + '/' + " " + (client.field435 - 2) + " more options";
         }

         class38.field876.method4064(var2, var0 + 4, var1 + 15, 16777215, 0, client.field303 / 1000);
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lclass2;IIB)V",
      garbageValue = "53"
   )
   static void method186(class2 var0, int var1, int var2) {
      if(var1 == var0.field869 && var1 != -1) {
         int var3 = class134.method2875(var1).field1001;
         if(1 == var3) {
            var0.field844 = 0;
            var0.field856 = 0;
            var0.field846 = var2;
            var0.field847 = 0;
         }

         if(2 == var3) {
            var0.field847 = 0;
         }
      } else if(-1 == var1 || -1 == var0.field869 || class134.method2875(var1).field983 >= class134.method2875(var0.field869).field983) {
         var0.field869 = var1;
         var0.field844 = 0;
         var0.field856 = 0;
         var0.field846 = var2;
         var0.field847 = 0;
         var0.field861 = var0.field865;
      }

   }

   @ObfuscatedName("r")
   public static int method187(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(2 == var2?7 - var1:var0));
   }

   @ObfuscatedName("s")
   static void method188(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         class25 var8 = class25.field633[var6];
         class25.field633[var6] = class25.field633[var1];
         class25.field633[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            class25 var11 = class25.field633[var9];
            int var12 = class11.method170(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = class11.method170(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               class25 var14 = class25.field633[var9];
               class25.field633[var9] = class25.field633[var7];
               class25.field633[var7++] = var14;
            }
         }

         class25.field633[var1] = class25.field633[var7];
         class25.field633[var7] = var8;
         method188(var0, var7 - 1, var2, var3, var4, var5);
         method188(1 + var7, var1, var2, var3, var4, var5);
      }

   }
}
