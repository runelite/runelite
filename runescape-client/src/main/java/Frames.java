import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("ee")
   static ModIcon[] field1563;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 335145731
   )
   public static int field1566;
   @ObfuscatedName("n")
   Frame[] field1567;

   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IZ)V",
      garbageValue = "0"
   )
   public Frames(class182 var1, class182 var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method3339(var3);
      this.field1567 = new Frame[var6];
      int[] var7 = var1.method3338(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3329(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method2466(); var12 != null; var12 = (FrameMap)var5.method2461()) {
            if(var11 == var12.field1459) {
               var10 = var12;
               break;
            }
         }

         if(null == var10) {
            byte[] var13 = var2.method3335(var11, 0);
            var10 = new FrameMap(var11, var13);
            var5.method2454(var10);
         }

         this.field1567[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "5"
   )
   public boolean method1926(int var1) {
      return this.field1567[var1].field1319;
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZI)V",
      garbageValue = "65280"
   )
   static void method1930(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var1 == var6.parentId) {
            class103.method2018(var6, var2, var3, var4);
            class37.method766(var6, var2, var3);
            if(var6.itemId > var6.scrollWidth - var6.width) {
               var6.itemId = var6.scrollWidth - var6.width;
            }

            if(var6.itemId < 0) {
               var6.itemId = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class181.method3325(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BI)Ljava/lang/String;",
      garbageValue = "-1229286799"
   )
   public static String method1931(byte[] var0) {
      int var2 = var0.length;
      StringBuilder var3 = new StringBuilder();

      for(int var4 = 0; var4 < var2 + 0; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class206.field3077[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class206.field3077[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class206.field3077[(var6 & 15) << 2 | var7 >>> 6]).append(class206.field3077[var7 & 63]);
            } else {
               var3.append(class206.field3077[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class206.field3077[(var5 & 3) << 4]).append("==");
         }
      }

      String var1 = var3.toString();
      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "3349"
   )
   public static int method1932(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }
}
