package net.runelite.rs.client;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("al")
@Implements("Sequence")
public class class42 extends class203 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -386180317
   )
   public int field983 = 1;
   @ObfuscatedName("i")
   public static class192 field984 = new class192(64);
   @ObfuscatedName("f")
   public static class192 field985 = new class192(100);
   @ObfuscatedName("m")
   public int[] field986;
   @ObfuscatedName("o")
   int[] field987;
   @ObfuscatedName("h")
   public int[] field988;
   @ObfuscatedName("j")
   public static class166 field989;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1389588877
   )
   @Export("replyMode")
   public int field990 = 2;
   @ObfuscatedName("r")
   @Export("interleaveLeave")
   int[] field991;
   @ObfuscatedName("b")
   @Export("stretches")
   public boolean field992 = false;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -849169701
   )
   public int field993 = 5;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1008221009
   )
   public int field994 = -1;
   @ObfuscatedName("n")
   public int[] field995;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2119768037
   )
   @Export("maxLoops")
   public int field996 = 99;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -564294431
   )
   public int field998 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -663257967
   )
   @Export("precedenceAnimating")
   public int field999 = -1;
   @ObfuscatedName("l")
   public static class166 field1001;
   @ObfuscatedName("me")
   static class78 field1002;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1531805869
   )
   public int field1004 = -1;
   @ObfuscatedName("ek")
   static class78[] field1005;

   @ObfuscatedName("l")
   void method863(class118 var1) {
      while(true) {
         int var2 = var1.method2453();
         if(0 == var2) {
            return;
         }

         this.method864(var1, var2);
      }
   }

   @ObfuscatedName("a")
   void method864(class118 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2455();
         this.field988 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field988[var4] = var1.method2455();
         }

         this.field986 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field986[var4] = var1.method2455();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field986[var4] += var1.method2455() << 16;
         }
      } else if(var2 == 2) {
         this.field983 = var1.method2455() * -1;
      } else if(3 == var2) {
         var3 = var1.method2453();
         this.field991 = new int[1 + var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field991[var4] = var1.method2453();
         }

         this.field991[var3] = 9999999;
      } else if(var2 == 4) {
         this.field992 = true;
      } else if(5 == var2) {
         this.field993 = var1.method2453();
      } else if(6 == var2) {
         this.field994 = var1.method2455();
      } else if(7 == var2) {
         this.field1004 = var1.method2455();
      } else if(8 == var2) {
         this.field996 = var1.method2453();
      } else if(var2 == 9) {
         this.field999 = var1.method2453();
      } else if(var2 == 10) {
         this.field998 = var1.method2453();
      } else if(var2 == 11) {
         this.field990 = var1.method2453();
      } else if(12 == var2) {
         var3 = var1.method2453();
         this.field987 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field987[var4] = var1.method2455();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field987[var4] += var1.method2455() << 16;
         }
      } else if(13 == var2) {
         var3 = var1.method2453();
         this.field995 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field995[var4] = var1.method2553();
         }
      }

   }

   @ObfuscatedName("i")
   void method865() {
      if(-1 == this.field999) {
         if(null != this.field991) {
            this.field999 = 2;
         } else {
            this.field999 = 0;
         }
      }

      if(this.field998 == -1) {
         if(this.field991 != null) {
            this.field998 = 2;
         } else {
            this.field998 = 0;
         }
      }

   }

   @ObfuscatedName("f")
   public class104 method866(class104 var1, int var2) {
      var2 = this.field986[var2];
      class102 var3 = class1.method5(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2313(true);
      } else {
         class104 var4 = var1.method2313(!var3.method2254(var2));
         var4.method2316(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("n")
   public class104 method868(class104 var1, int var2) {
      int var3 = this.field986[var2];
      class102 var4 = class1.method5(var3 >> 16);
      var3 &= '\uffff';
      if(null == var4) {
         return var1.method2313(true);
      } else {
         class102 var5 = null;
         int var6 = 0;
         if(this.field987 != null && var2 < this.field987.length) {
            var6 = this.field987[var2];
            var5 = class1.method5(var6 >> 16);
            var6 &= '\uffff';
         }

         class104 var7;
         if(var5 != null && '\uffff' != var6) {
            var7 = var1.method2313(!var4.method2254(var3) & !var5.method2254(var6));
            var7.method2316(var4, var3);
            var7.method2316(var5, var6);
            return var7;
         } else {
            var7 = var1.method2313(!var4.method2254(var3));
            var7.method2316(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("h")
   public class104 method870(class104 var1, int var2, class42 var3, int var4) {
      var2 = this.field986[var2];
      class102 var5 = class1.method5(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method866(var1, var4);
      } else {
         var4 = var3.field986[var4];
         class102 var6 = class1.method5(var4 >> 16);
         var4 &= '\uffff';
         class104 var7;
         if(null == var6) {
            var7 = var1.method2313(!var5.method2254(var2));
            var7.method2316(var5, var2);
            return var7;
         } else {
            var7 = var1.method2313(!var5.method2254(var2) & !var6.method2254(var4));
            var7.method2264(var5, var2, var6, var4, this.field991);
            return var7;
         }
      }
   }

   @ObfuscatedName("m")
   class104 method872(class104 var1, int var2, int var3) {
      var2 = this.field986[var2];
      class102 var4 = class1.method5(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method2313(true);
      } else {
         class104 var5 = var1.method2313(!var4.method2254(var2));
         var3 &= 3;
         if(1 == var3) {
            var5.method2262();
         } else if(2 == var3) {
            var5.method2267();
         } else if(var3 == 3) {
            var5.method2266();
         }

         var5.method2316(var4, var2);
         if(1 == var3) {
            var5.method2266();
         } else if(var3 == 2) {
            var5.method2267();
         } else if(3 == var3) {
            var5.method2262();
         }

         return var5;
      }
   }

   @ObfuscatedName("l")
   static void method878(int var0) {
      if(var0 != -1) {
         if(class149.method3102(var0)) {
            class172[] var1 = class172.field2757[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               class172 var3 = var1[var2];
               if(var3.field2835 != null) {
                  class0 var4 = new class0();
                  var4.field2 = var3;
                  var4.field5 = var3.field2835;
                  class126.method2751(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("o")
   class104 method880(class104 var1, int var2) {
      var2 = this.field986[var2];
      class102 var3 = class1.method5(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2294(true);
      } else {
         class104 var4 = var1.method2294(!var3.method2254(var2));
         var4.method2316(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("a")
   public static void method883(class142 var0, boolean var1) {
      if(null != class216.field3155) {
         try {
            class216.field3155.method2948();
         } catch (Exception var6) {
            ;
         }

         class216.field3155 = null;
      }

      class216.field3155 = var0;
      class164.method3192(var1);
      class170.field2733.field1998 = 0;
      class170.field2732 = null;
      class11.field179 = null;
      class170.field2734 = 0;

      while(true) {
         class171 var2 = (class171)class170.field2735.method3748();
         if(null == var2) {
            while(true) {
               var2 = (class171)class170.field2730.method3748();
               if(var2 == null) {
                  if(class170.field2737 != 0) {
                     try {
                        class118 var7 = new class118(4);
                        var7.method2438(4);
                        var7.method2438(class170.field2737);
                        var7.method2541(0);
                        class216.field3155.method2932(var7.field1995, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class216.field3155.method2948();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class170.field2739;
                        class216.field3155 = null;
                     }
                  }

                  class170.field2724 = 0;
                  class170.field2722 = class109.method2381();
                  return;
               }

               class170.field2727.method3818(var2);
               class170.field2728.method3746(var2, var2.field3112);
               ++class170.field2729;
               --class170.field2736;
            }
         }

         class170.field2723.method3746(var2, var2.field3112);
         ++class170.field2741;
         --class170.field2726;
      }
   }

   @ObfuscatedName("m")
   public static void method895() {
      class41.field979.method3720();
   }

   @ObfuscatedName("f")
   public static int method896(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var2 + var0) / var1 - var2;
   }

   @ObfuscatedName("dw")
   static int method898(class172 var0) {
      class200 var1 = (class200)client.field490.method3744((long)var0.field2825 + ((long)(var0.field2759 * -1) << 32));
      return null != var1?var1.field3097:var0.field2847;
   }
}
