import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class45 extends CacheableNode {
   @ObfuscatedName("r")
   static class170 field1013;
   @ObfuscatedName("d")
   short[] field1014;
   @ObfuscatedName("j")
   public static NodeCache field1015 = new NodeCache(64);
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1266840015
   )
   int field1016 = 128;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 24086113
   )
   public int field1017 = -1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -171570745
   )
   int field1018;
   @ObfuscatedName("x")
   static class170 field1019;
   @ObfuscatedName("m")
   short[] field1020;
   @ObfuscatedName("p")
   short[] field1021;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1973764635
   )
   int field1022 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -831985625
   )
   int field1023;
   @ObfuscatedName("f")
   short[] field1024;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -883658639
   )
   int field1025 = 128;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -329575041
   )
   int field1026 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1939738059
   )
   int field1028 = 0;
   @ObfuscatedName("z")
   public static NodeCache field1029 = new NodeCache(30);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1324693404"
   )
   void method904(Buffer var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method905(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "2026634318"
   )
   void method905(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1018 = var1.method2551();
      } else if(var2 == 2) {
         this.field1017 = var1.method2551();
      } else if(var2 == 4) {
         this.field1016 = var1.method2551();
      } else if(var2 == 5) {
         this.field1025 = var1.method2551();
      } else if(var2 == 6) {
         this.field1026 = var1.method2551();
      } else if(var2 == 7) {
         this.field1022 = var1.method2556();
      } else if(var2 == 8) {
         this.field1028 = var1.method2556();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2556();
            this.field1020 = new short[var3];
            this.field1021 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1020[var4] = (short)var1.method2551();
               this.field1021[var4] = (short)var1.method2551();
            }
         } else if(var2 == 41) {
            var3 = var1.method2556();
            this.field1024 = new short[var3];
            this.field1014 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1024[var4] = (short)var1.method2551();
               this.field1014[var4] = (short)var1.method2551();
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "1199546857"
   )
   public final Model method906(int var1) {
      Model var2 = (Model)field1029.get((long)this.field1023);
      if(var2 == null) {
         ModelData var3 = ModelData.method2262(field1013, this.field1018, 0);
         if(null == var3) {
            return null;
         }

         int var4;
         if(null != this.field1020) {
            for(var4 = 0; var4 < this.field1020.length; ++var4) {
               var3.method2337(this.field1020[var4], this.field1021[var4]);
            }
         }

         if(this.field1024 != null) {
            for(var4 = 0; var4 < this.field1024.length; ++var4) {
               var3.method2276(this.field1024[var4], this.field1014[var4]);
            }
         }

         var2 = var3.method2290(64 + this.field1022, this.field1028 + 850, -30, -50, -30);
         field1029.put(var2, (long)this.field1023);
      }

      Model var5;
      if(this.field1017 != -1 && var1 != -1) {
         var5 = class113.getAnimation(this.field1017).method866(var2, var1);
      } else {
         var5 = var2.method2358(true);
      }

      if(this.field1016 != 128 || this.field1025 != 128) {
         var5.method2374(this.field1016, this.field1025, this.field1016);
      }

      if(this.field1026 != 0) {
         if(this.field1026 == 90) {
            var5.method2430();
         }

         if(this.field1026 == 180) {
            var5.method2430();
            var5.method2430();
         }

         if(this.field1026 == 270) {
            var5.method2430();
            var5.method2430();
            var5.method2430();
         }
      }

      return var5;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "1069011526"
   )
   public static Object method919(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class128.field2092) {
            try {
               class121 var2 = new class121();
               var2.vmethod2852(var0);
               return var2;
            } catch (Throwable var3) {
               class128.field2092 = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1529037422"
   )
   public static boolean method920(int var0) {
      return (var0 >> 21 & 1) != 0;
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "8"
   )
   static final boolean method921(Widget var0) {
      if(null == var0.field2923) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2923.length; ++var1) {
            int var2 = class8.method112(var0, var1);
            int var3 = var0.field2924[var1];
            if(var0.field2923[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2923[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2923[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }
}
