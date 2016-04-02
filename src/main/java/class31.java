import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class31 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1348871749
   )
   static int field693;
   @ObfuscatedName("f")
   static class80 field694;
   @ObfuscatedName("p")
   static class80[] field695;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2064324801
   )
   static int field696 = 0;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -597504039
   )
   static int field697;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1352345213
   )
   static int field699;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -219977861
   )
   static int field700;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1793078261
   )
   static int field701;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 2120777131
   )
   static int field702;
   @ObfuscatedName("am")
   @Export("username")
   static String field703;
   @ObfuscatedName("a")
   static class80 field704;
   @ObfuscatedName("k")
   static class80 field705;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1334240801
   )
   static int field706;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -583681201
   )
   static int field707;
   @ObfuscatedName("c")
   static int[] field708;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -143090935
   )
   static int field709;
   @ObfuscatedName("ay")
   static String field710;
   @ObfuscatedName("ag")
   static String field711;
   @ObfuscatedName("av")
   static String field712;
   @ObfuscatedName("af")
   static String field713;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1037534761
   )
   static int field714;
   @ObfuscatedName("aw")
   static String field715;
   @ObfuscatedName("ad")
   static class159 field716;
   @ObfuscatedName("an")
   static boolean field717;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1581946373
   )
   static int field718;
   @ObfuscatedName("h")
   static class78 field720;
   @ObfuscatedName("al")
   static boolean field721;
   @ObfuscatedName("ab")
   static String field722;
   @ObfuscatedName("y")
   static int[] field723;

   static {
      field699 = field696 + 202;
      field708 = new int[256];
      field701 = 0;
      field693 = 0;
      field697 = 0;
      field709 = 0;
      field714 = 0;
      field706 = 0;
      field707 = 10;
      field722 = "";
      field702 = 0;
      field710 = "";
      field711 = "";
      field712 = "";
      field713 = "";
      field703 = "";
      field715 = "";
      field716 = class159.field2599;
      field717 = true;
      field718 = 0;
      field721 = false;
      field700 = -1;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "296057884"
   )
   static final void method680(int var0, int var1) {
      class199 var2 = client.field410[class48.field1063][var0][var1];
      if(var2 == null) {
         class151.field2250.method1947(class48.field1063, var0, var1);
      } else {
         long var3 = -99999999L;
         class28 var5 = null;

         class28 var6;
         for(var6 = (class28)var2.method3825(); null != var6; var6 = (class28)var2.method3827()) {
            class51 var7 = class33.method711(var6.field666);
            long var8 = (long)var7.field1125;
            if(var7.field1102 == 1) {
               var8 *= (long)(1 + var6.field664);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class151.field2250.method1947(class48.field1063, var0, var1);
         } else {
            var2.method3821(var5);
            class28 var10 = null;
            class28 var11 = null;

            for(var6 = (class28)var2.method3825(); null != var6; var6 = (class28)var2.method3827()) {
               if(var5.field666 != var6.field666) {
                  if(null == var10) {
                     var10 = var6;
                  }

                  if(var6.field666 != var10.field666 && null == var11) {
                     var11 = var6;
                  }
               }
            }

            int var9 = 1610612736 + var0 + (var1 << 7);
            class151.field2250.method1933(class48.field1063, var0, var1, class59.method1263(var0 * 128 + 64, 64 + var1 * 128, class48.field1063), var5, var9, var10, var11);
         }
      }
   }

   @ObfuscatedName("e")
   public static void method699(class167 var0, class167 var1, class167 var2) {
      class42.field970 = var0;
      class42.field962 = var1;
      class42.field961 = var2;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "25"
   )
   static void method700(int var0, int var1, int var2, int var3) {
      for(class23 var4 = (class23)class23.field601.method3825(); null != var4; var4 = (class23)class23.field601.method3827()) {
         if(var4.field588 != -1 || var4.field599 != null) {
            int var5 = 0;
            if(var1 > var4.field592) {
               var5 += var1 - var4.field592;
            } else if(var1 < var4.field590) {
               var5 += var4.field590 - var1;
            }

            if(var2 > var4.field593) {
               var5 += var2 - var4.field593;
            } else if(var2 < var4.field597) {
               var5 += var4.field597 - var2;
            }

            if(var5 - 64 <= var4.field594 && 0 != client.field519 && var4.field589 == var0) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field594 - var5) * client.field519 / var4.field594;
               if(var4.field591 == null) {
                  if(var4.field588 >= 0) {
                     class58 var7 = class58.method1244(class143.field2175, var4.field588, 0);
                     if(var7 != null) {
                        class62 var8 = var7.method1246().method1279(class49.field1066);
                        class64 var9 = class64.method1322(var8, 100, var6);
                        var9.method1441(-1);
                        class135.field2074.method1128(var9);
                        var4.field591 = var9;
                     }
                  }
               } else {
                  var4.field591.method1303(var6);
               }

               if(null == var4.field596) {
                  if(var4.field599 != null && (var4.field595 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field599.length);
                     class58 var12 = class58.method1244(class143.field2175, var4.field599[var11], 0);
                     if(var12 != null) {
                        class62 var13 = var12.method1246().method1279(class49.field1066);
                        class64 var10 = class64.method1322(var13, 100, var6);
                        var10.method1441(0);
                        class135.field2074.method1128(var10);
                        var4.field596 = var10;
                        var4.field595 = var4.field600 + (int)(Math.random() * (double)(var4.field598 - var4.field600));
                     }
                  }
               } else {
                  var4.field596.method1303(var6);
                  if(!var4.field596.method3915()) {
                     var4.field596 = null;
                  }
               }
            } else {
               if(var4.field591 != null) {
                  class135.field2074.method1146(var4.field591);
                  var4.field591 = null;
               }

               if(var4.field596 != null) {
                  class135.field2074.method1146(var4.field596);
                  var4.field596 = null;
               }
            }
         }
      }

   }
}
