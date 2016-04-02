import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("NPCComposition")
public class class39 extends class204 {
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = -1444974891
   )
   static int field859;
   @ObfuscatedName("c")
   short[] field860;
   @ObfuscatedName("s")
   static class193 field861 = new class193(50);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -372088273
   )
   public int field862 = -1;
   @ObfuscatedName("h")
   @Export("name")
   public String field863 = "null";
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 179849499
   )
   int field864 = 128;
   @ObfuscatedName("pk")
   static class8 field865;
   @ObfuscatedName("f")
   static class193 field866 = new class193(64);
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2137052087
   )
   public int field867 = -1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -954942225
   )
   public int field868 = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 978703561
   )
   public int field869 = -1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1900517257
   )
   public int field870 = -1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1633785853
   )
   public int field871 = 1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1915622483
   )
   public int field872 = -1;
   @ObfuscatedName("a")
   @Export("models")
   int[] field873;
   @ObfuscatedName("o")
   short[] field874;
   @ObfuscatedName("r")
   int[] field875;
   @ObfuscatedName("x")
   short[] field876;
   @ObfuscatedName("b")
   short[] field877;
   @ObfuscatedName("q")
   @Export("actions")
   public String[] field878 = new String[5];
   @ObfuscatedName("u")
   @Export("isMinimapVisible")
   public boolean field879 = true;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 594969139
   )
   @Export("combatLevel")
   public int field880 = -1;
   @ObfuscatedName("v")
   @Export("isVisible")
   public boolean field881 = false;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1358460461
   )
   @Export("id")
   public int field882;
   @ObfuscatedName("aj")
   @Export("isClickable")
   public boolean field883 = true;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1429666383
   )
   int field884 = 0;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 962045013
   )
   int field885 = 0;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1676486707
   )
   public int field886 = -1;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -478007377
   )
   public int field887 = 32;
   @ObfuscatedName("az")
   public int[] field888;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1215668755
   )
   int field889 = -1;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -297991409
   )
   int field890 = -1;
   @ObfuscatedName("ab")
   public boolean field891 = true;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1771622659
   )
   public int field892 = 30;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2111011845
   )
   int field893 = 128;
   @ObfuscatedName("e")
   static class167 field894;
   @ObfuscatedName("ay")
   public boolean field896 = false;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1759554801
   )
   public int field897 = -1;

   @ObfuscatedName("f")
   void method757() {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "-89"
   )
   void method759(class119 var1, int var2) {
      int var3;
      int var4;
      if(1 == var2) {
         var3 = var1.method2523();
         this.field873 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field873[var4] = var1.method2700();
         }
      } else if(2 == var2) {
         this.field863 = var1.method2531();
      } else if(12 == var2) {
         this.field871 = var1.method2523();
      } else if(13 == var2) {
         this.field867 = var1.method2700();
      } else if(14 == var2) {
         this.field870 = var1.method2700();
      } else if(var2 == 15) {
         this.field868 = var1.method2700();
      } else if(16 == var2) {
         this.field869 = var1.method2700();
      } else if(17 == var2) {
         this.field870 = var1.method2700();
         this.field897 = var1.method2700();
         this.field872 = var1.method2700();
         this.field862 = var1.method2700();
      } else if(var2 >= 30 && var2 < 35) {
         this.field878[var2 - 30] = var1.method2531();
         if(this.field878[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field878[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2523();
         this.field874 = new short[var3];
         this.field860 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field874[var4] = (short)var1.method2700();
            this.field860[var4] = (short)var1.method2700();
         }
      } else if(41 == var2) {
         var3 = var1.method2523();
         this.field876 = new short[var3];
         this.field877 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field876[var4] = (short)var1.method2700();
            this.field877[var4] = (short)var1.method2700();
         }
      } else if(60 == var2) {
         var3 = var1.method2523();
         this.field875 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field875[var4] = var1.method2700();
         }
      } else if(93 == var2) {
         this.field879 = false;
      } else if(var2 == 95) {
         this.field880 = var1.method2700();
      } else if(97 == var2) {
         this.field864 = var1.method2700();
      } else if(98 == var2) {
         this.field893 = var1.method2700();
      } else if(var2 == 99) {
         this.field881 = true;
      } else if(100 == var2) {
         this.field884 = var1.method2633();
      } else if(101 == var2) {
         this.field885 = var1.method2633() * 5;
      } else if(102 == var2) {
         this.field886 = var1.method2700();
      } else if(var2 == 103) {
         this.field887 = var1.method2700();
      } else if(106 == var2) {
         this.field889 = var1.method2700();
         if('\uffff' == this.field889) {
            this.field889 = -1;
         }

         this.field890 = var1.method2700();
         if('\uffff' == this.field890) {
            this.field890 = -1;
         }

         var3 = var1.method2523();
         this.field888 = new int[var3 + 1];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field888[var4] = var1.method2700();
            if(this.field888[var4] == '\uffff') {
               this.field888[var4] = -1;
            }
         }
      } else if(107 == var2) {
         this.field891 = false;
      } else if(109 == var2) {
         this.field883 = false;
      } else if(111 == var2) {
         this.field896 = true;
      } else if(112 == var2) {
         this.field892 = var1.method2523();
      }

   }

   @ObfuscatedName("h")
   public final class105 method760(class42 var1, int var2, class42 var3, int var4) {
      if(null != this.field888) {
         class39 var11 = this.method762();
         return var11 == null?null:var11.method760(var1, var2, var3, var4);
      } else {
         class105 var5 = (class105)field861.method3754((long)this.field882);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.field873.length; ++var7) {
               if(!class219.field3166.method3264(this.field873[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            class100[] var8 = new class100[this.field873.length];

            int var9;
            for(var9 = 0; var9 < this.field873.length; ++var9) {
               var8[var9] = class100.method2221(class219.field3166, this.field873[var9], 0);
            }

            class100 var12;
            if(var8.length == 1) {
               var12 = var8[0];
            } else {
               var12 = new class100(var8, var8.length);
            }

            if(this.field874 != null) {
               for(var9 = 0; var9 < this.field874.length; ++var9) {
                  var12.method2234(this.field874[var9], this.field860[var9]);
               }
            }

            if(null != this.field876) {
               for(var9 = 0; var9 < this.field876.length; ++var9) {
                  var12.method2235(this.field876[var9], this.field877[var9]);
               }
            }

            var5 = var12.method2236(64 + this.field884, this.field885 + 850, -30, -50, -30);
            field861.method3756(var5, (long)this.field882);
         }

         class105 var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method868(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method897(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method897(var5, var4);
         } else {
            var10 = var5.method2324(true);
         }

         if(128 != this.field864 || this.field893 != 128) {
            var10.method2384(this.field864, this.field893, this.field864);
         }

         return var10;
      }
   }

   @ObfuscatedName("a")
   public final class39 method762() {
      int var1 = -1;
      if(this.field889 != -1) {
         var1 = class142.method2979(this.field889);
      } else if(this.field890 != -1) {
         var1 = class176.field2903[this.field890];
      }

      return var1 >= 0 && var1 < this.field888.length && -1 != this.field888[var1]?class172.method3370(this.field888[var1]):null;
   }

   @ObfuscatedName("r")
   public boolean method763() {
      if(null == this.field888) {
         return true;
      } else {
         int var1 = -1;
         if(this.field889 != -1) {
            var1 = class142.method2979(this.field889);
         } else if(-1 != this.field890) {
            var1 = class176.field2903[this.field890];
         }

         return var1 >= 0 && var1 < this.field888.length && this.field888[var1] != -1;
      }
   }

   @ObfuscatedName("g")
   public final class100 method764() {
      if(null != this.field888) {
         class39 var5 = this.method762();
         return null == var5?null:var5.method764();
      } else if(null == this.field875) {
         return null;
      } else {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.field875.length; ++var2) {
            if(!class219.field3166.method3264(this.field875[var2], 0)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            class100[] var6 = new class100[this.field875.length];

            for(int var3 = 0; var3 < this.field875.length; ++var3) {
               var6[var3] = class100.method2221(class219.field3166, this.field875[var3], 0);
            }

            class100 var7;
            if(var6.length == 1) {
               var7 = var6[0];
            } else {
               var7 = new class100(var6, var6.length);
            }

            int var4;
            if(null != this.field874) {
               for(var4 = 0; var4 < this.field874.length; ++var4) {
                  var7.method2234(this.field874[var4], this.field860[var4]);
               }
            }

            if(this.field876 != null) {
               for(var4 = 0; var4 < this.field876.length; ++var4) {
                  var7.method2235(this.field876[var4], this.field877[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-1320380673"
   )
   void method777(class119 var1) {
      while(true) {
         int var2 = var1.method2523();
         if(var2 == 0) {
            return;
         }

         this.method759(var1, var2);
      }
   }

   @ObfuscatedName("w")
   static String method784(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("w")
   public static void method785() {
      class183.field2957.method3679();
      class183.field2958 = 1;
      class14.field209 = null;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1860628477"
   )
   public static void method786() {
      try {
         if(1 == class183.field2958) {
            int var0 = class183.field2957.method3589();
            if(var0 > 0 && class183.field2957.method3595()) {
               var0 -= class209.field3118;
               if(var0 < 0) {
                  var0 = 0;
               }

               class183.field2957.method3588(var0);
               return;
            }

            class183.field2957.method3679();
            class183.field2957.method3592();
            if(class14.field209 != null) {
               class183.field2958 = 2;
            } else {
               class183.field2958 = 0;
            }

            class183.field2955 = null;
            class226.field3214 = null;
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class183.field2957.method3679();
         class183.field2958 = 0;
         class183.field2955 = null;
         class226.field3214 = null;
         class14.field209 = null;
      }

   }
}
