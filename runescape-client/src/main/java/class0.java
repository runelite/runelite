import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class0 extends Node {
   @ObfuscatedName("m")
   String field0;
   @ObfuscatedName("d")
   boolean field1;
   @ObfuscatedName("v")
   Widget field2;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -886611575
   )
   int field3;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 663972551
   )
   int field4;
   @ObfuscatedName("n")
   Widget field5;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1055154621
   )
   int field6;
   @ObfuscatedName("a")
   Object[] field7;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 176423771
   )
   int field8;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 293136127
   )
   int field10;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1734392851
   )
   int field11;
   @ObfuscatedName("no")
   @ObfuscatedGetter(
      intValue = -817036143
   )
   static int field12;
   @ObfuscatedName("cv")
   static class227 field14;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = -979224239
   )
   static int field15;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-79"
   )
   static final void method0(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var1 + var3; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class137.field2149[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Lclass23;",
      garbageValue = "-1343034617"
   )
   static class23 method1(int var0) {
      class23 var1 = (class23)class23.field608.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class190.field3083.method3309(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = new class23();
            Buffer var3 = new Buffer(var2);
            var3.offset = var3.payload.length - 12;
            int var4 = var3.method2533();
            var1.field602 = var3.method2717();
            var1.field605 = var3.method2717();
            var1.field604 = var3.method2717();
            var1.field598 = var3.method2717();
            var3.offset = 0;
            var3.method2535();
            var1.field603 = new int[var4];
            var1.field600 = new int[var4];
            var1.field601 = new String[var4];

            int var6;
            for(int var5 = 0; var3.offset < var3.payload.length - 12; var1.field603[var5++] = var6) {
               var6 = var3.method2717();
               if(var6 == 3) {
                  var1.field601[var5] = var3.method2530();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.field600[var5] = var3.method2533();
               } else {
                  var1.field600[var5] = var3.method2528();
               }
            }

            class23.field608.put(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "684678077"
   )
   static final boolean method2(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }
}
