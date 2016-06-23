import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("ItemLayer")
public final class class99 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1734412141
   )
   @Export("flags")
   int field1677;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -914515237
   )
   @Export("x")
   int field1678;
   @ObfuscatedName("l")
   @Export("middle")
   class85 field1679;
   @ObfuscatedName("b")
   @Export("bottom")
   class85 field1680;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 531955365
   )
   @Export("hash")
   int field1681;
   @ObfuscatedName("d")
   @Export("top")
   class85 field1682;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1902952859
   )
   @Export("y")
   int field1683;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1120139279
   )
   @Export("height")
   int field1684;
   @ObfuscatedName("no")
   @ObfuscatedGetter(
      intValue = -1763128399
   )
   static int field1685;

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "7613"
   )
   static final void method2268(String var0) {
      if(null != class35.field792) {
         client.field333.method2773(212);
         client.field333.method2654(class23.method629(var0));
         client.field333.method2545(var0);
      }
   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "([Lclass173;II)V",
      garbageValue = "-565479861"
   )
   static final void method2269(class173[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class173 var3 = var0[var2];
         if(var3 != null && var3.field2773 == var1 && (!var3.field2860 || !class6.method107(var3))) {
            if(var3.field2798 == 0) {
               if(!var3.field2860 && class6.method107(var3) && var3 != class59.field1234) {
                  continue;
               }

               method2269(var0, var3.field2869);
               if(null != var3.field2767) {
                  method2269(var3.field2767, var3.field2869);
               }

               class3 var4 = (class3)client.field448.method3822((long)var3.field2869);
               if(var4 != null) {
                  class24.method633(var4.field64);
               }
            }

            if(var3.field2798 == 6) {
               int var5;
               if(var3.field2756 != -1 || var3.field2783 != -1) {
                  boolean var7 = class17.method199(var3);
                  if(var7) {
                     var5 = var3.field2783;
                  } else {
                     var5 = var3.field2756;
                  }

                  if(var5 != -1) {
                     class42 var6 = class34.method768(var5);

                     for(var3.field2743 += client.field366; var3.field2743 > var6.field1004[var3.field2876]; class39.method818(var3)) {
                        var3.field2743 -= var6.field1004[var3.field2876];
                        ++var3.field2876;
                        if(var3.field2876 >= var6.field999.length) {
                           var3.field2876 -= var6.field1014;
                           if(var3.field2876 < 0 || var3.field2876 >= var6.field999.length) {
                              var3.field2876 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2810 != 0 && !var3.field2860) {
                  int var8 = var3.field2810 >> 16;
                  var5 = var3.field2810 << 16 >> 16;
                  var8 *= client.field366;
                  var5 *= client.field366;
                  var3.field2805 = var3.field2805 + var8 & 2047;
                  var3.field2806 = var5 + var3.field2806 & 2047;
                  class39.method818(var3);
               }
            }
         }
      }

   }
}
