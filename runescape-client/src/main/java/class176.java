import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public final class class176 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-11"
   )
   public static void method3182() {
      class211.field3125 = null;
      class225.field3217 = null;
      FaceNormal.field1557 = null;
      FileOnDisk.field1199 = null;
      class225.field3215 = null;
      XGrandExchangeOffer.field36 = null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-792421649"
   )
   static void method3183(int var0, int var1, int var2, int var3) {
      for(class31 var4 = (class31)class31.field723.method2349(); var4 != null; var4 = (class31)class31.field723.method2351()) {
         if(var4.field715 != -1 || null != var4.field721) {
            int var5 = 0;
            if(var1 > var4.field712) {
               var5 += var1 - var4.field712;
            } else if(var1 < var4.field710) {
               var5 += var4.field710 - var1;
            }

            if(var2 > var4.field713) {
               var5 += var2 - var4.field713;
            } else if(var2 < var4.field711) {
               var5 += var4.field711 - var2;
            }

            if(var5 - 64 <= var4.field718 && Client.field525 != 0 && var4.field709 == var0) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field718 - var5) * Client.field525 / var4.field718;
               if(var4.field716 == null) {
                  if(var4.field715 >= 0) {
                     class53 var7 = class53.method955(class103.field1665, var4.field715, 0);
                     if(var7 != null) {
                        class55 var8 = var7.method944().method990(class13.field141);
                        class66 var9 = class66.method1251(var8, 100, var6);
                        var9.method1268(-1);
                        FaceNormal.field1554.method898(var9);
                        var4.field716 = var9;
                     }
                  }
               } else {
                  var4.field716.method1172(var6);
               }

               if(var4.field714 == null) {
                  if(var4.field721 != null && (var4.field720 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field721.length);
                     class53 var12 = class53.method955(class103.field1665, var4.field721[var11], 0);
                     if(null != var12) {
                        class55 var13 = var12.method944().method990(class13.field141);
                        class66 var10 = class66.method1251(var13, 100, var6);
                        var10.method1268(0);
                        FaceNormal.field1554.method898(var10);
                        var4.field714 = var10;
                        var4.field720 = var4.field722 + (int)(Math.random() * (double)(var4.field708 - var4.field722));
                     }
                  }
               } else {
                  var4.field714.method1172(var6);
                  if(!var4.field714.linked()) {
                     var4.field714 = null;
                  }
               }
            } else {
               if(null != var4.field716) {
                  FaceNormal.field1554.method923(var4.field716);
                  var4.field716 = null;
               }

               if(var4.field714 != null) {
                  FaceNormal.field1554.method923(var4.field714);
                  var4.field714 = null;
               }
            }
         }
      }

   }
}
