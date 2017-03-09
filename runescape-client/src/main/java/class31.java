import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public final class class31 extends Node {
   @ObfuscatedName("ct")
   static Font field727;
   @ObfuscatedName("g")
   class66 field728;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1878420133
   )
   int field729;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 373840117
   )
   int field730;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1705585
   )
   int field731;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 996737401
   )
   int field732;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1148322367
   )
   int field733;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -59325809
   )
   int field734;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1973803733
   )
   int field736;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -697957539
   )
   int field737;
   @ObfuscatedName("q")
   int[] field738;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1972066213
   )
   int field739;
   @ObfuscatedName("l")
   class66 field740;
   @ObfuscatedName("j")
   static Deque field741 = new Deque();
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1320047843
   )
   int field742;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 156655149
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("s")
   ObjectComposition field745;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-91"
   )
   void method690() {
      int var1 = this.field734;
      ObjectComposition var2 = this.field745.getImpostor();
      if(var2 != null) {
         this.field734 = var2.ambientSoundId;
         this.field733 = var2.field2939 * 128;
         this.field736 = var2.field2923;
         this.field737 = var2.field2941;
         this.field738 = var2.field2902;
      } else {
         this.field734 = -1;
         this.field733 = 0;
         this.field736 = 0;
         this.field737 = 0;
         this.field738 = null;
      }

      if(var1 != this.field734 && null != this.field728) {
         class195.field2863.method993(this.field728);
         this.field728 = null;
      }

   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(Lclass25;I)V",
      garbageValue = "873884312"
   )
   static final void method691(class25 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field597 == 0) {
         var1 = Friend.region.method1920(var0.field599, var0.field598, var0.field600);
      }

      if(var0.field597 == 1) {
         var1 = Friend.region.method1922(var0.field599, var0.field598, var0.field600);
      }

      if(var0.field597 == 2) {
         var1 = Friend.region.method1785(var0.field599, var0.field598, var0.field600);
      }

      if(var0.field597 == 3) {
         var1 = Friend.region.method1782(var0.field599, var0.field598, var0.field600);
      }

      if(var1 != 0) {
         int var5 = Friend.region.method1783(var0.field599, var0.field598, var0.field600, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field604 = var2;
      var0.field602 = var3;
      var0.field601 = var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;B)V",
      garbageValue = "63"
   )
   public static void method703(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass184;IIIBZB)V",
      garbageValue = "-21"
   )
   static void method704(class184 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      class181 var8 = (class181)class185.field2743.method2405(var6);
      if(var8 == null) {
         var8 = (class181)class185.field2745.method2405(var6);
         if(var8 == null) {
            var8 = (class181)class185.field2757.method2405(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method2476();
                  class185.field2743.method2403(var8, var6);
                  --class185.field2749;
                  ++class185.field2744;
               }

            } else {
               if(!var5) {
                  var8 = (class181)class185.field2750.method2405(var6);
                  if(null != var8) {
                     return;
                  }
               }

               var8 = new class181();
               var8.field2695 = var0;
               var8.field2692 = var3;
               var8.field2694 = var4;
               if(var5) {
                  class185.field2743.method2403(var8, var6);
                  ++class185.field2744;
               } else {
                  class185.field2747.method2335(var8);
                  class185.field2757.method2403(var8, var6);
                  ++class185.field2749;
               }

            }
         }
      }
   }
}
