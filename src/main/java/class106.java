import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dd")
public abstract class class106 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -261834867
   )
   public int field1864;
   @ObfuscatedName("g")
   public static short[] field1865;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 14768683
   )
   public int field1866;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1880612437
   )
   public int field1867;
   @ObfuscatedName("v")
   public static class171 field1868;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1102143669
   )
   public int field1871;

   @ObfuscatedName("f")
   static void method2387(int var0) {
      if(-1 != var0) {
         if(class103.method2303(var0)) {
            class172[] var1 = class172.field2850[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               class172 var3 = var1[var2];
               if(null != var3.field2822) {
                  class0 var4 = new class0();
                  var4.field6 = var3;
                  var4.field8 = var3.field2822;
                  class72.method1613(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("a")
   protected abstract boolean vmethod2388(int var1, int var2);

   @ObfuscatedName("e")
   public static int method2390(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var2 + var0) / var1 - var2;
   }

   @ObfuscatedName("a")
   public static void method2392(class135 var0, Object var1) {
      if(null != var0.field2086) {
         for(int var2 = 0; var2 < 50 && var0.field2086.peekEvent() != null; ++var2) {
            class103.method2301(1L);
         }

         if(null != var1) {
            var0.field2086.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("y")
   static int method2394(int var0, int var1) {
      long var2 = (long)(var1 + (var0 << 16));
      return field1868 != null && var2 == field1868.field3111?1 + class76.field1388.field1979 * 99 / (class76.field1388.field1980.length - field1868.field2728):0;
   }
}
