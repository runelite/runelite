import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
public abstract class class119 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1285519265
   )
   public int field1856;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1125799215
   )
   public int field1857;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -431616281
   )
   public int field1858;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 282719355
   )
   public int field1860;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2050735558"
   )
   public static void method2295(boolean var0) {
      if(null != class185.field2757) {
         try {
            Buffer var1 = new Buffer(4);
            var1.method2799(var0?2:3);
            var1.method2801(0);
            class185.field2757.method2073(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class185.field2757.method2059();
            } catch (Exception var3) {
               ;
            }

            ++class185.field2760;
            class185.field2757 = null;
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1007774675"
   )
   public static int method2296(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.field2092[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "1289510622"
   )
   static final void method2299(Widget var0, int var1, int var2) {
      if(Client.field368 == null && !Client.isMenuOpen) {
         if(var0 != null) {
            Widget var5 = var0;
            int var7 = class36.method724(var0);
            int var10 = var7 >> 17 & 7;
            int var8 = var10;
            Widget var4;
            int var9;
            if(var10 == 0) {
               var4 = null;
            } else {
               var9 = 0;

               while(true) {
                  if(var9 >= var8) {
                     var4 = var5;
                     break;
                  }

                  var5 = class37.method736(var5.parentId);
                  if(null == var5) {
                     var4 = null;
                     break;
                  }

                  ++var9;
               }
            }

            Widget var6 = var4;
            if(var4 == null) {
               var6 = var0.parent;
            }

            if(null != var6) {
               Client.field368 = var0;
               var5 = var0;
               var7 = class36.method724(var0);
               var10 = var7 >> 17 & 7;
               var8 = var10;
               if(var10 == 0) {
                  var4 = null;
               } else {
                  var9 = 0;

                  while(true) {
                     if(var9 >= var8) {
                        var4 = var5;
                        break;
                     }

                     var5 = class37.method736(var5.parentId);
                     if(var5 == null) {
                        var4 = null;
                        break;
                     }

                     ++var9;
                  }
               }

               var6 = var4;
               if(null == var4) {
                  var6 = var0.parent;
               }

               Client.field430 = var6;
               Client.field452 = var1;
               Client.field551 = var2;
               class176.field2653 = 0;
               Client.field461 = false;
               if(Client.menuOptionCount > 0) {
                  int var11 = Client.menuOptionCount - 1;
                  class15.field164 = new class38();
                  class15.field164.field794 = Client.menuActionParams0[var11];
                  class15.field164.field791 = Client.menuActionParams1[var11];
                  class15.field164.field790 = Client.menuTypes[var11];
                  class15.field164.field793 = Client.menuIdentifiers[var11];
                  class15.field164.field796 = Client.menuOptions[var11];
               }

               return;
            }
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "1167824572"
   )
   public abstract boolean vmethod2300(int var1, int var2, int var3, CollisionData var4);
}
