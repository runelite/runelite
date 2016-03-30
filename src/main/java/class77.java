import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bt")
public abstract class class77 {
   @ObfuscatedName("t")
   public int[] field1395;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1802419287
   )
   public int field1396;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -102834657
   )
   int field1397;
   @ObfuscatedName("y")
   public Image field1398;

   @ObfuscatedName("p")
   public static class154[] method1668() {
      return new class154[]{class154.field2308, class154.field2307, class154.field2309, class154.field2310, class154.field2312, class154.field2315};
   }

   @ObfuscatedName("w")
   abstract void vmethod1869(int var1, int var2, Component var3);

   @ObfuscatedName("b")
   public final void method1670() {
      class79.method1771(this.field1395, this.field1396, this.field1397);
   }

   @ObfuscatedName("cb")
   static final void method1671(int var0) {
      if(class39.method817(var0)) {
         class173[] var1 = class173.field2830[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            class173 var3 = var1[var2];
            if(var3 != null) {
               var3.field2889 = 0;
               var3.field2898 = 0;
            }
         }

      }
   }

   @ObfuscatedName("t")
   public abstract void vmethod1871(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("x")
   public abstract void vmethod1870(Graphics var1, int var2, int var3);

   @ObfuscatedName("x")
   public static void method1685(boolean var0) {
      if(class171.field2742 != null) {
         try {
            class119 var1 = new class119(4);
            var1.method2573(var0?2:3);
            var1.method2653(0);
            class171.field2742.method3002(var1.field2012, 0, 4);
         } catch (IOException var4) {
            try {
               class171.field2742.method3005();
            } catch (Exception var3) {
               ;
            }

            ++class171.field2750;
            class171.field2742 = null;
         }

      }
   }
}
