import java.awt.Component;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
final class class21 implements Comparator {
   // $FF: synthetic field
   final boolean val$preferOwnWorld;
   @ObfuscatedName("rq")
   protected static String field587;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1204927363
   )
   public static int field589;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)[Lclass153;",
      garbageValue = "-1091785179"
   )
   static class153[] method604() {
      return new class153[]{class153.field2266, class153.field2265, class153.field2267, class153.field2272};
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "1200792467"
   )
   int method605(class214 var1, class214 var2) {
      if(var2.field3149 == var1.field3149) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(var1.field3149 == client.field386) {
               return -1;
            }

            if(var2.field3149 == client.field386) {
               return 1;
            }
         }

         return var1.field3149 < var2.field3149?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method605((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIB)V",
      garbageValue = "43"
   )
   static final void method606(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class16 var9 = null;

      for(class16 var10 = (class16)client.field421.method3852(); null != var10; var10 = (class16)client.field421.method3857()) {
         if(var10.field241 == var0 && var10.field233 == var1 && var10.field231 == var2 && var3 == var10.field242) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class16();
         var9.field241 = var0;
         var9.field242 = var3;
         var9.field233 = var1;
         var9.field231 = var2;
         class23.method626(var9);
         client.field421.method3877(var9);
      }

      var9.field238 = var4;
      var9.field240 = var5;
      var9.field237 = var6;
      var9.field232 = var7;
      var9.field239 = var8;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "-1944009003"
   )
   static void method608(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var2 + var3) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(null == var6 || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method608(var0, var1, var2, var5 - 1);
         method608(var0, var1, var5 + 1, var3);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "-31"
   )
   public static void method611(Component var0) {
      var0.addMouseListener(class140.field2147);
      var0.addMouseMotionListener(class140.field2147);
      var0.addFocusListener(class140.field2147);
   }

   class21(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "656814324"
   )
   static void method613() {
      class227 var0 = null;

      try {
         var0 = class41.method896("", class137.field2130.field2280, true);
         class119 var1 = class20.field580.method116();
         var0.method4158(var1.field2000, 0, var1.field1998);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method4149();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-413449306"
   )
   static void method614() {
      if(class31.field732) {
         class31.field713 = null;
         class31.field716 = null;
         class28.field684 = null;
         class31.field717 = null;
         class172.field2738 = null;
         class159.field2605 = null;
         class176.field2906 = null;
         class31.field718 = null;
         class31.field719 = null;
         class168.field2689 = null;
         class0.field14 = null;
         class155.field2284 = null;
         class26.field666 = null;
         class52.field1171 = null;
         class151.field2253 = null;
         class25.field644 = null;
         class10.field174 = null;
         class84.field1463 = null;
         class114.field1974 = null;
         class130.field2064 = null;
         class18.field270 = null;
         class25.field642 = null;
         class1.method6(2);
         class163.method3250(true);
         class31.field732 = false;
      }
   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-106"
   )
   static final void method615(int var0) {
      class130.method2848();

      for(class23 var4 = (class23)class23.field608.method3852(); var4 != null; var4 = (class23)class23.field608.method3857()) {
         if(null != var4.field617) {
            var4.method624();
         }
      }

      int var1 = class158.method3191(var0).field1169;
      if(var1 != 0) {
         int var2 = class176.field2905[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               class91.method2182(0.9D);
               ((class95)class91.field1594).method2238(0.9D);
            }

            if(var2 == 2) {
               class91.method2182(0.8D);
               ((class95)class91.field1594).method2238(0.8D);
            }

            if(var2 == 3) {
               class91.method2182(0.7D);
               ((class95)class91.field1594).method2238(0.7D);
            }

            if(var2 == 4) {
               class91.method2182(0.6D);
               ((class95)class91.field1594).method2238(0.6D);
            }

            class37.method803();
         }

         if(var1 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(var3 != client.field524) {
               if(client.field524 == 0 && client.field315 != -1) {
                  class96.method2261(class17.field261, client.field315, 0, var3, false);
                  client.field526 = false;
               } else if(var3 == 0) {
                  class38.method807();
                  client.field526 = false;
               } else if(class183.field2953 != 0) {
                  class183.field2956 = var3;
               } else {
                  class183.field2955.method3636(var3);
               }

               client.field524 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               client.field492 = 127;
            }

            if(var2 == 1) {
               client.field492 = 96;
            }

            if(var2 == 2) {
               client.field492 = 64;
            }

            if(var2 == 3) {
               client.field492 = 32;
            }

            if(var2 == 4) {
               client.field492 = 0;
            }
         }

         if(var1 == 5) {
            client.field474 = var2;
         }

         if(var1 == 6) {
            client.field449 = var2;
         }

         if(var1 == 9) {
            client.field450 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               client.field349 = 127;
            }

            if(var2 == 1) {
               client.field349 = 96;
            }

            if(var2 == 2) {
               client.field349 = 64;
            }

            if(var2 == 3) {
               client.field349 = 32;
            }

            if(var2 == 4) {
               client.field349 = 0;
            }
         }

         if(var1 == 17) {
            client.field332 = var2 & '\uffff';
         }

         if(var1 == 18) {
            client.field318 = (class20)class14.method177(class49.method1062(), var2);
            if(client.field318 == null) {
               client.field318 = class20.field573;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               client.field464 = -1;
            } else {
               client.field464 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            client.field319 = (class20)class14.method177(class49.method1062(), var2);
            if(null == client.field319) {
               client.field319 = class20.field573;
            }
         }

      }
   }
}
