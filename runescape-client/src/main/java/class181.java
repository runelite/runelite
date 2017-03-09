import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class181 extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 545687225
   )
   public int field2692;
   @ObfuscatedName("c")
   public byte field2694;
   @ObfuscatedName("x")
   public class184 field2695;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)LKitDefinition;",
      garbageValue = "1"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field2814.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.field2815.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.method3505(new Buffer(var2));
         }

         KitDefinition.field2814.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1085144702"
   )
   static void method3301(int var0, int var1, int var2, int var3) {
      for(class31 var4 = (class31)class31.field741.method2448(); null != var4; var4 = (class31)class31.field741.method2445()) {
         if(var4.field734 != -1 || null != var4.field738) {
            int var5 = 0;
            if(var1 > var4.field742) {
               var5 += var1 - var4.field742;
            } else if(var1 < var4.field731) {
               var5 += var4.field731 - var1;
            }

            if(var2 > var4.field732) {
               var5 += var2 - var4.field732;
            } else if(var2 < var4.field730) {
               var5 += var4.field730 - var2;
            }

            if(var5 - 64 <= var4.field733 && Client.field554 != 0 && var0 == var4.field729) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = Client.field554 * (var4.field733 - var5) / var4.field733;
               if(null == var4.field728) {
                  if(var4.field734 >= 0) {
                     class53 var7 = class53.method1060(class188.field2778, var4.field734, 0);
                     if(null != var7) {
                        class55 var8 = var7.method1051().method1093(ItemLayer.field1224);
                        class66 var9 = class66.method1261(var8, 100, var6);
                        var9.method1339(-1);
                        class195.field2863.method1001(var9);
                        var4.field728 = var9;
                     }
                  }
               } else {
                  var4.field728.method1262(var6);
               }

               if(var4.field740 == null) {
                  if(var4.field738 != null && (var4.field739 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field738.length);
                     class53 var12 = class53.method1060(class188.field2778, var4.field738[var11], 0);
                     if(null != var12) {
                        class55 var13 = var12.method1051().method1093(ItemLayer.field1224);
                        class66 var10 = class66.method1261(var13, 100, var6);
                        var10.method1339(0);
                        class195.field2863.method1001(var10);
                        var4.field740 = var10;
                        var4.field739 = var4.field736 + (int)(Math.random() * (double)(var4.field737 - var4.field736));
                     }
                  }
               } else {
                  var4.field740.method1262(var6);
                  if(!var4.field740.linked()) {
                     var4.field740 = null;
                  }
               }
            } else {
               if(null != var4.field728) {
                  class195.field2863.method993(var4.field728);
                  var4.field728 = null;
               }

               if(null != var4.field740) {
                  class195.field2863.method993(var4.field740);
                  var4.field740 = null;
               }
            }
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "487170130"
   )
   static final void method3302() {
      for(int var0 = 0; var0 < Client.field351; ++var0) {
         int var1 = Client.field570[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(var2 != null) {
            WidgetNode.method205(var2, var2.composition.field3008);
         }
      }

   }
}
