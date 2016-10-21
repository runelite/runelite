import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public final class class16 extends Node {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 937521527
   )
   int field227;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 127839605
   )
   int field228;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1478637771
   )
   int field229;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -645005631
   )
   int field230;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1016377565
   )
   int field231;
   @ObfuscatedName("po")
   static class8 field232;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2016369203
   )
   int field233;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1958723687
   )
   int field234;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -444772509
   )
   int field235;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -387760521
   )
   int field236;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 446923453
   )
   int field237 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 286638939
   )
   int field238 = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1520455289
   )
   int field239;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Z",
      garbageValue = "705135524"
   )
   public static boolean method185(CharSequence var0) {
      boolean var2 = false;
      boolean var3 = false;
      int var4 = 0;
      int var5 = var0.length();
      int var6 = 0;

      boolean var1;
      while(true) {
         if(var6 >= var5) {
            var1 = var3;
            break;
         }

         label95: {
            char var7 = var0.charAt(var6);
            if(var6 == 0) {
               if(var7 == 45) {
                  var2 = true;
                  break label95;
               }

               if(var7 == 43) {
                  break label95;
               }
            }

            int var9;
            if(var7 >= 48 && var7 <= 57) {
               var9 = var7 - 48;
            } else if(var7 >= 65 && var7 <= 90) {
               var9 = var7 - 55;
            } else {
               if(var7 < 97 || var7 > 122) {
                  var1 = false;
                  break;
               }

               var9 = var7 - 87;
            }

            if(var9 >= 10) {
               var1 = false;
               break;
            }

            if(var2) {
               var9 = -var9;
            }

            int var8 = var9 + var4 * 10;
            if(var4 != var8 / 10) {
               var1 = false;
               break;
            }

            var4 = var8;
            var3 = true;
         }

         ++var6;
      }

      return var1;
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1718452714"
   )
   static void method186() {
      if(Client.field434) {
         Widget var0 = Player.method44(class32.field711, Client.field344);
         if(null != var0 && null != var0.field2880) {
            class0 var1 = new class0();
            var1.field2 = var0;
            var1.field1 = var0.field2880;
            class112.method2452(var1);
         }

         Client.field434 = false;
         MessageNode.method750(var0);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Lclass54;",
      garbageValue = "967557419"
   )
   public static class54 method187(int var0) {
      class54 var1 = (class54)class54.field1149.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class54.field1142.method3304(5, var0);
         var1 = new class54();
         if(null != var2) {
            var1.method1099(new Buffer(var2));
         }

         class54.field1149.put(var1, (long)var0);
         return var1;
      }
   }
}
