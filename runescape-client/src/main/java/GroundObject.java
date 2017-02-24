import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2088451299
   )
   @Export("y")
   int y;
   @ObfuscatedName("p")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1996549935
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1116080771
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 98911671
   )
   @Export("x")
   int x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 752061583
   )
   @Export("floor")
   int floor;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "234574181"
   )
   public static int method1593(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass228;I)Ljava/lang/String;",
      garbageValue = "-1132677378"
   )
   public static String method1594(CharSequence var0, class228 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         boolean var4;
         char var5;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            var5 = var0.charAt(var2);
            var4 = var5 == 160 || var5 == 32 || var5 == 95 || var5 == 45;
            if(!var4) {
               break;
            }
         }

         while(var3 > var2) {
            var5 = var0.charAt(var3 - 1);
            var4 = var5 == 160 || var5 == 32 || var5 == 95 || var5 == 45;
            if(!var4) {
               break;
            }

            --var3;
         }

         int var10 = var3 - var2;
         if(var10 >= 1 && var10 <= class159.method3076(var1)) {
            StringBuilder var9 = new StringBuilder(var10);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               if(ObjectComposition.method3658(var7)) {
                  char var8 = class57.method1115(var7);
                  if(var8 != 0) {
                     var9.append(var8);
                  }
               }
            }

            if(var9.length() == 0) {
               return null;
            } else {
               return var9.toString();
            }
         } else {
            return null;
         }
      }
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZB)V",
      garbageValue = "1"
   )
   static final void method1595(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            if(var6) {
               Client.field433 = Client.menuOptionCount;
            }

            ++Client.menuOptionCount;
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Ljava/lang/String;Ljava/lang/String;B)LFont;",
      garbageValue = "15"
   )
   public static Font method1596(class182 var0, class182 var1, String var2, String var3) {
      int var4 = var0.method3335(var2);
      int var5 = var0.method3319(var4, var3);
      return class182.method3380(var0, var1, var4, var5);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "61"
   )
   static final int method1597(int var0, int var1) {
      int var2 = class11.method149(var0 + '넵', 91923 + var1, 4) - 128 + (class11.method149(10294 + var0, '鎽' + var1, 2) - 128 >> 1) + (class11.method149(var0, var1, 1) - 128 >> 2);
      var2 = 35 + (int)(0.3D * (double)var2);
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }
}
