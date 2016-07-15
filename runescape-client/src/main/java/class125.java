import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Date;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public final class class125 extends class122 {
   @ObfuscatedName("p")
   static final int[] field2072 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("o")
   class126 field2073;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -728946193
   )
   int field2074;

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1503605762"
   )
   public void method2854(int var1) {
      super.field2054[++super.field2061 - 1] = (byte)(var1 + this.field2073.method2889());
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "452801525"
   )
   public void method2855(int[] var1) {
      this.field2073 = new class126(var1);
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "625603297"
   )
   public int method2859(int var1) {
      int var2 = this.field2074 >> 3;
      int var3 = 8 - (this.field2074 & 7);
      int var4 = 0;

      for(this.field2074 += var1; var1 > var3; var3 = 8) {
         var4 += (super.field2054[var2++] & field2072[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var1 == var3) {
         var4 += super.field2054[var2] & field2072[var3];
      } else {
         var4 += super.field2054[var2] >> var3 - var1 & field2072[var1];
      }

      return var4;
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "77704226"
   )
   public void method2860() {
      super.field2061 = (7 + this.field2074) / 8;
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "914610979"
   )
   public int method2861(int var1) {
      return var1 * 8 - this.field2074;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2021610208"
   )
   static void method2862() {
      Object var0 = class173.field2753;
      synchronized(class173.field2753) {
         if(class173.field2752 == 0) {
            class107.field1869.method3005(new class173(), 5);
         }

         class173.field2752 = 600;
      }
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "367107963"
   )
   public int method2865() {
      return super.field2054[++super.field2061 - 1] - this.field2073.method2889() & 255;
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "([Lclass176;IIIZI)V",
      garbageValue = "-1889524637"
   )
   static void method2871(class176[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         class176 var6 = var0[var5];
         if(null != var6 && var1 == var6.field2813) {
            class144.method3078(var6, var2, var3, var4);
            class88.method2007(var6, var2, var3);
            if(var6.field2815 > var6.field2817 - var6.field2866) {
               var6.field2815 = var6.field2817 - var6.field2866;
            }

            if(var6.field2815 < 0) {
               var6.field2815 = 0;
            }

            if(var6.field2883 > var6.field2867 - var6.field2810) {
               var6.field2883 = var6.field2867 - var6.field2810;
            }

            if(var6.field2883 < 0) {
               var6.field2883 = 0;
            }

            if(var6.field2796 == 0) {
               class11.method138(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class125(int var1) {
      super(var1);
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1389994802"
   )
   static final boolean method2877() {
      if(null == class8.field150) {
         return false;
      } else {
         int var2;
         String var19;
         try {
            int var0 = class8.field150.method3081();
            if(var0 == 0) {
               return false;
            }

            if(client.field549 == -1) {
               class8.field150.method3082(client.field338.field2054, 0, 1);
               client.field338.field2061 = 0;
               client.field549 = client.field338.method2865();
               client.field532 = class191.field3082[client.field549];
               --var0;
            }

            if(client.field532 == -1) {
               if(var0 <= 0) {
                  return false;
               }

               class8.field150.method3082(client.field338.field2054, 0, 1);
               client.field532 = client.field338.field2054[0] & 255;
               --var0;
            }

            if(client.field532 == -2) {
               if(var0 <= 1) {
                  return false;
               }

               class8.field150.method3082(client.field338.field2054, 0, 2);
               client.field338.field2061 = 0;
               client.field532 = client.field338.method2612();
               var0 -= 2;
            }

            if(var0 < client.field532) {
               return false;
            }

            client.field338.field2061 = 0;
            class8.field150.method3082(client.field338.field2054, 0, client.field532);
            client.field442 = 0;
            client.field345 = client.field434;
            client.field434 = client.field343;
            client.field343 = client.field549;
            int var1;
            int var3;
            if(client.field549 == 101) {
               var1 = client.field338.method2612();
               var2 = client.field338.method2610();
               var3 = client.field338.method2612();
               class132.method2936(var1, var2, var3);
               client.field549 = -1;
               return true;
            }

            class176 var18;
            if(client.field549 == 225) {
               var1 = client.field338.method2612();
               var2 = client.field338.method2654();
               var18 = class19.method212(var2);
               if(var18.field2837 != 2 || var18.field2863 != var1) {
                  var18.field2837 = 2;
                  var18.field2863 = var1;
                  class51.method1124(var18);
               }

               client.field549 = -1;
               return true;
            }

            String var42;
            String var68;
            if(client.field549 == 6) {
               var19 = client.field338.method2617();
               class125 var93 = client.field338;
               var68 = class48.method1027(var93, 32767);
               var42 = class226.method4139(class46.method1015(var68));
               class25.method586(6, var19, var42);
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 181) {
               class33.method716();

               for(var1 = 0; var1 < 2048; ++var1) {
                  client.field467[var1] = null;
               }

               class165.method3279(client.field338);
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 230) {
               for(var1 = 0; var1 < client.field467.length; ++var1) {
                  if(client.field467[var1] != null) {
                     client.field467[var1].field890 = -1;
                  }
               }

               for(var1 = 0; var1 < client.field331.length; ++var1) {
                  if(client.field331[var1] != null) {
                     client.field331[var1].field890 = -1;
                  }
               }

               client.field549 = -1;
               return true;
            }

            int var71;
            if(client.field549 == 210) {
               class132.method2934();
               var1 = client.field338.method2789();
               var2 = client.field338.method2610();
               var3 = client.field338.method2654();
               client.field432[var1] = var3;
               client.field337[var1] = var2;
               client.field431[var1] = 1;

               for(var71 = 0; var71 < 98; ++var71) {
                  if(var3 >= class158.field2343[var71]) {
                     client.field431[var1] = var71 + 2;
                  }
               }

               client.field430[++client.field486 - 1 & 31] = var1;
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 32) {
               var19 = client.field338.method2617();
               Object[] var76 = new Object[var19.length() + 1];

               for(var3 = var19.length() - 1; var3 >= 0; --var3) {
                  if(var19.charAt(var3) == 115) {
                     var76[1 + var3] = client.field338.method2617();
                  } else {
                     var76[var3 + 1] = new Integer(client.field338.method2614());
                  }
               }

               var76[0] = new Integer(client.field338.method2614());
               class0 var92 = new class0();
               var92.field4 = var76;
               class143.method3071(var92);
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 45) {
               var1 = client.field338.method2649();
               var2 = client.field338.method2656();
               var18 = class19.method212(var2);
               if(var1 != var18.field2841 || var1 == -1) {
                  var18.field2841 = var1;
                  var18.field2790 = 0;
                  var18.field2917 = 0;
                  class51.method1124(var18);
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 169) {
               class186.field3002 = client.field338.method2633();
               class169.field2706 = client.field338.method2610();

               while(client.field338.field2061 < client.field532) {
                  client.field549 = client.field338.method2610();
                  class3.method39();
               }

               client.field549 = -1;
               return true;
            }

            class3 var4;
            class176 var44;
            int var49;
            if(client.field549 == 4) {
               var1 = client.field338.method2614();
               var2 = client.field338.method2614();
               class3 var87 = (class3)client.field455.method3864((long)var2);
               var4 = (class3)client.field455.method3864((long)var1);
               if(var4 != null) {
                  class214.method4018(var4, null == var87 || var87.field60 != var4.field60);
               }

               if(null != var87) {
                  var87.method4000();
                  client.field455.method3865(var87, (long)var1);
               }

               var44 = class19.method212(var2);
               if(var44 != null) {
                  class51.method1124(var44);
               }

               var44 = class19.method212(var1);
               if(var44 != null) {
                  class51.method1124(var44);
                  class11.method138(class176.field2811[var44.field2794 >>> 16], var44, true);
               }

               if(client.field454 != -1) {
                  var49 = client.field454;
                  if(class10.method112(var49)) {
                     class28.method647(class176.field2811[var49], 1);
                  }
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 236 || client.field549 == 248 || client.field549 == 148 || client.field549 == 47 || client.field549 == 253 || client.field549 == 84 || client.field549 == 49 || client.field549 == 93 || client.field549 == 143 || client.field549 == 139) {
               class3.method39();
               client.field549 = -1;
               return true;
            }

            int var7;
            int var22;
            boolean var94;
            if(client.field549 == 153) {
               var19 = client.field338.method2617();
               var2 = client.field338.method2612();
               byte var58 = client.field338.method2611();
               var94 = false;
               if(var58 == -128) {
                  var94 = true;
               }

               if(var94) {
                  if(class21.field596 == 0) {
                     client.field549 = -1;
                     return true;
                  }

                  boolean var96 = false;

                  for(var22 = 0; var22 < class21.field596 && (!class22.field603[var22].field646.equals(var19) || var2 != class22.field603[var22].field648); ++var22) {
                     ;
                  }

                  if(var22 < class21.field596) {
                     while(var22 < class21.field596 - 1) {
                        class22.field603[var22] = class22.field603[var22 + 1];
                        ++var22;
                     }

                     --class21.field596;
                     class22.field603[class21.field596] = null;
                  }
               } else {
                  client.field338.method2617();
                  class25 var52 = new class25();
                  var52.field646 = var19;
                  var52.field647 = class17.method167(var52.field646, client.field296);
                  var52.field648 = var2;
                  var52.field649 = var58;

                  for(var49 = class21.field596 - 1; var49 >= 0; --var49) {
                     var7 = class22.field603[var49].field647.compareTo(var52.field647);
                     if(var7 == 0) {
                        class22.field603[var49].field648 = var2;
                        class22.field603[var49].field649 = var58;
                        if(var19.equals(class118.field2035.field52)) {
                           client.field297 = var58;
                        }

                        client.field446 = client.field506;
                        client.field549 = -1;
                        return true;
                     }

                     if(var7 < 0) {
                        break;
                     }
                  }

                  if(class21.field596 >= class22.field603.length) {
                     client.field549 = -1;
                     return true;
                  }

                  for(var7 = class21.field596 - 1; var7 > var49; --var7) {
                     class22.field603[var7 + 1] = class22.field603[var7];
                  }

                  if(class21.field596 == 0) {
                     class22.field603 = new class25[100];
                  }

                  class22.field603[var49 + 1] = var52;
                  ++class21.field596;
                  if(var19.equals(class118.field2035.field52)) {
                     client.field297 = var58;
                  }
               }

               client.field446 = client.field506;
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 68) {
               class186.field3002 = client.field338.method2662();
               class169.field2706 = client.field338.method2610();

               for(var1 = class169.field2706; var1 < class169.field2706 + 8; ++var1) {
                  for(var2 = class186.field3002; var2 < class186.field3002 + 8; ++var2) {
                     if(client.field426[class50.field1119][var1][var2] != null) {
                        client.field426[class50.field1119][var1][var2] = null;
                        class3.method38(var1, var2);
                     }
                  }
               }

               for(class16 var74 = (class16)client.field427.method3899(); var74 != null; var74 = (class16)client.field427.method3918()) {
                  if(var74.field232 >= class169.field2706 && var74.field232 < 8 + class169.field2706 && var74.field242 >= class186.field3002 && var74.field242 < class186.field3002 + 8 && class50.field1119 == var74.field238) {
                     var74.field230 = 0;
                  }
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 71) {
               var1 = client.field338.method2610();
               if(client.field338.method2610() == 0) {
                  client.field487[var1] = new class223();
                  client.field338.field2061 += 18;
               } else {
                  --client.field338.field2061;
                  client.field487[var1] = new class223(client.field338, false);
               }

               client.field408 = client.field506;
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 251) {
               class27 var72 = new class27();
               var72.field685 = client.field338.method2617();
               var72.field674 = client.field338.method2612();
               var2 = client.field338.method2614();
               var72.field676 = var2;
               class92.method2179(45);
               class8.field150.method3088();
               class8.field150 = null;
               class151.method3219(var72);
               client.field549 = -1;
               return false;
            }

            if(client.field549 == 3) {
               class36.method767(client.field338, client.field532);
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 199) {
               class189.method3817(true);
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 96) {
               client.field543 = true;
               class96.field1663 = client.field338.method2610();
               class163.field2681 = client.field338.method2610();
               class182.field2965 = client.field338.method2612();
               class99.field1705 = client.field338.method2610();
               class10.field181 = client.field338.method2610();
               if(class10.field181 >= 100) {
                  var1 = 64 + class96.field1663 * 128;
                  var2 = 64 + class163.field2681 * 128;
                  var3 = class105.method2370(var1, var2, class50.field1119) - class182.field2965;
                  var71 = var1 - class85.field1500;
                  var22 = var3 - class41.field955;
                  var49 = var2 - class157.field2342;
                  var7 = (int)Math.sqrt((double)(var49 * var49 + var71 * var71));
                  class98.field1694 = (int)(Math.atan2((double)var22, (double)var7) * 325.949D) & 2047;
                  class99.field1703 = (int)(Math.atan2((double)var71, (double)var49) * -325.949D) & 2047;
                  if(class98.field1694 < 128) {
                     class98.field1694 = 128;
                  }

                  if(class98.field1694 > 383) {
                     class98.field1694 = 383;
                  }
               }

               client.field549 = -1;
               return true;
            }

            class176 var73;
            if(client.field549 == 231) {
               var1 = client.field338.method2656();
               var73 = class19.method212(var1);

               for(var3 = 0; var3 < var73.field2912.length; ++var3) {
                  var73.field2912[var3] = -1;
                  var73.field2912[var3] = 0;
               }

               class51.method1124(var73);
               client.field549 = -1;
               return true;
            }

            long var6;
            int var13;
            String var16;
            int var17;
            long var21;
            String var23;
            long var39;
            long var61;
            if(client.field549 == 197) {
               var19 = client.field338.method2617();
               var39 = client.field338.method2615();
               var21 = (long)client.field338.method2612();
               var6 = (long)client.field338.method2703();
               class155[] var54 = new class155[]{class155.field2313, class155.field2310, class155.field2320, class155.field2309, class155.field2311};
               class155 var60 = (class155)class25.method585(var54, client.field338.method2610());
               var61 = var6 + (var21 << 32);
               boolean var64 = false;

               for(var13 = 0; var13 < 100; ++var13) {
                  if(var61 == client.field516[var13]) {
                     var64 = true;
                     break;
                  }
               }

               if(var60.field2321 && class118.method2542(var19)) {
                  var64 = true;
               }

               if(!var64 && client.field490 == 0) {
                  client.field516[client.field517] = var61;
                  client.field517 = (client.field517 + 1) % 100;
                  class125 var14 = client.field338;
                  var23 = class48.method1027(var14, 32767);
                  String var15 = class226.method4139(class46.method1015(var23));
                  if(var60.field2314 != -1) {
                     var17 = var60.field2314;
                     var16 = "<img=" + var17 + ">";
                     class78.method1710(9, var16 + var19, var15, class35.method750(var39));
                  } else {
                     class78.method1710(9, var19, var15, class35.method750(var39));
                  }
               }

               client.field549 = -1;
               return true;
            }

            String var47;
            boolean var48;
            String var67;
            if(client.field549 == 107) {
               var1 = client.field338.method2672();
               var48 = client.field338.method2610() == 1;
               var67 = "";
               var94 = false;
               if(var48) {
                  var67 = client.field338.method2617();
                  if(class118.method2542(var67)) {
                     var94 = true;
                  }
               }

               var47 = client.field338.method2617();
               if(!var94) {
                  class25.method586(var1, var67, var47);
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 237) {
               var1 = client.field338.method2614();
               class3 var75 = (class3)client.field455.method3864((long)var1);
               if(var75 != null) {
                  class214.method4018(var75, true);
               }

               if(client.field371 != null) {
                  class51.method1124(client.field371);
                  client.field371 = null;
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 171) {
               client.field416 = 1;
               client.field515 = client.field506 * -522622283;
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 63) {
               class38.method784(client.field338, client.field532);
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 106) {
               var1 = client.field338.method2645();
               class178.method3543(var1);
               client.field483[++client.field484 - 1 & 31] = var1 & 32767;
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 37) {
               var1 = client.field338.method2633();
               var2 = client.field338.method2612();
               var3 = client.field338.method2654();
               var4 = (class3)client.field455.method3864((long)var3);
               if(var4 != null) {
                  class214.method4018(var4, var4.field60 != var2);
               }

               class3 var51 = new class3();
               var51.field60 = var2;
               var51.field59 = var1;
               client.field455.method3865(var51, (long)var3);
               class139.method3015(var2);
               class176 var83 = class19.method212(var3);
               class51.method1124(var83);
               if(null != client.field371) {
                  class51.method1124(client.field371);
                  client.field371 = null;
               }

               class126.method2895();
               class11.method138(class176.field2811[var3 >> 16], var83, false);
               class18.method173(var2);
               if(client.field454 != -1) {
                  var7 = client.field454;
                  if(class10.method112(var7)) {
                     class28.method647(class176.field2811[var7], 1);
                  }
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 50) {
               var2 = client.field338.method2610();
               class133[] var84 = class18.method175();
               var71 = 0;

               class133 var69;
               while(true) {
                  if(var71 >= var84.length) {
                     var69 = null;
                     break;
                  }

                  class133 var50 = var84[var71];
                  if(var2 == var50.field2111) {
                     var69 = var50;
                     break;
                  }

                  ++var71;
               }

               class105.field1835 = var69;
               client.field549 = -1;
               return true;
            }

            int var11;
            long var57;
            int var62;
            int var85;
            boolean var88;
            if(client.field549 == 38) {
               client.field446 = client.field506;
               if(client.field532 == 0) {
                  client.field522 = null;
                  client.field523 = null;
                  class21.field596 = 0;
                  class22.field603 = null;
                  client.field549 = -1;
                  return true;
               }

               client.field523 = client.field338.method2617();
               long var65 = client.field338.method2615();
               var21 = var65;
               if(var65 > 0L && var65 < 6582952005840035281L) {
                  if(var65 % 37L == 0L) {
                     var67 = null;
                  } else {
                     var49 = 0;

                     for(var57 = var65; 0L != var57; var57 /= 37L) {
                        ++var49;
                     }

                     StringBuilder var56 = new StringBuilder(var49);

                     while(var21 != 0L) {
                        var61 = var21;
                        var21 /= 37L;
                        var56.append(class165.field2687[(int)(var61 - var21 * 37L)]);
                     }

                     var67 = var56.reverse().toString();
                  }
               } else {
                  var67 = null;
               }

               client.field522 = var67;
               class7.field142 = client.field338.method2611();
               var49 = client.field338.method2610();
               if(var49 == 255) {
                  client.field549 = -1;
                  return true;
               }

               class21.field596 = var49;
               class25[] var91 = new class25[100];

               for(var85 = 0; var85 < class21.field596; ++var85) {
                  var91[var85] = new class25();
                  var91[var85].field646 = client.field338.method2617();
                  var91[var85].field647 = class17.method167(var91[var85].field646, client.field296);
                  var91[var85].field648 = client.field338.method2612();
                  var91[var85].field649 = client.field338.method2611();
                  client.field338.method2617();
                  if(var91[var85].field646.equals(class118.field2035.field52)) {
                     client.field297 = var91[var85].field649;
                  }
               }

               var88 = false;
               var62 = class21.field596;

               while(var62 > 0) {
                  var88 = true;
                  --var62;

                  for(var11 = 0; var11 < var62; ++var11) {
                     if(var91[var11].field647.compareTo(var91[1 + var11].field647) > 0) {
                        class25 var59 = var91[var11];
                        var91[var11] = var91[var11 + 1];
                        var91[1 + var11] = var59;
                        var88 = false;
                     }
                  }

                  if(var88) {
                     break;
                  }
               }

               class22.field603 = var91;
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 80) {
               var1 = client.field338.method2656();
               var2 = client.field338.method2612();
               var18 = class19.method212(var1);
               if(null != var18 && var18.field2796 == 0) {
                  if(var2 > var18.field2867 - var18.field2810) {
                     var2 = var18.field2867 - var18.field2810;
                  }

                  if(var2 < 0) {
                     var2 = 0;
                  }

                  if(var2 != var18.field2883) {
                     var18.field2883 = var2;
                     class51.method1124(var18);
                  }
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 58) {
               client.field529 = client.field338.method2610();
               if(client.field529 == 255) {
                  client.field529 = 0;
               }

               client.field530 = client.field338.method2610();
               if(client.field530 == 255) {
                  client.field530 = 0;
               }

               client.field549 = -1;
               return true;
            }

            int var89;
            if(client.field549 == 95) {
               var19 = client.field338.method2617();
               class28.field702 = var19;

               try {
                  var68 = client.field289.getParameter(class193.field3110.field3108);
                  var67 = client.field289.getParameter(class193.field3102.field3108);
                  var42 = var68 + "settings=" + var19 + "; version=1; path=/; domain=" + var67;
                  if(var19.length() == 0) {
                     var42 = var42 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var47 = var42 + "; Expires=";
                     var57 = client.method424() + 94608000000L;
                     class114.field2017.setTime(new Date(var57));
                     var89 = class114.field2017.get(7);
                     var62 = class114.field2017.get(5);
                     var11 = class114.field2017.get(2);
                     int var12 = class114.field2017.get(1);
                     var13 = class114.field2017.get(11);
                     int var95 = class114.field2017.get(12);
                     int var29 = class114.field2017.get(13);
                     String var81 = class114.field2016[var89 - 1] + ", " + var62 / 10 + var62 % 10 + "-" + class114.field2015[0][var11] + "-" + var12 + " " + var13 / 10 + var13 % 10 + ":" + var95 / 10 + var95 % 10 + ":" + var29 / 10 + var29 % 10 + " GMT";
                     var42 = var47 + var81 + "; Max-Age=" + 94608000L;
                  }

                  class135.method2965(client.field289, "document.cookie=\"" + var42 + "\"");
               } catch (Throwable var35) {
                  ;
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 27) {
               var1 = client.field338.method2614();
               class52.field1154 = class107.field1869.method2996(var1);
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 191) {
               var1 = client.field338.method2610();
               var2 = client.field338.method2610();
               var3 = client.field338.method2610();
               var71 = client.field338.method2610();
               client.field544[var1] = true;
               client.field545[var1] = var2;
               client.field546[var1] = var3;
               client.field566[var1] = var71;
               client.field380[var1] = 0;
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 187) {
               var1 = client.field338.method2654();
               var73 = class19.method212(var1);
               var73.field2837 = 3;
               var73.field2863 = class118.field2035.field53.method3578();
               class51.method1124(var73);
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 177) {
               client.field543 = false;

               for(var1 = 0; var1 < 5; ++var1) {
                  client.field544[var1] = false;
               }

               client.field549 = -1;
               return true;
            }

            class176 var41;
            if(client.field549 == 29) {
               var1 = client.field338.method2614();
               var2 = client.field338.method2612();
               var3 = client.field338.method2612();
               var41 = class19.method212(var1);
               var41.field2850 = (var2 << 16) + var3;
               client.field549 = -1;
               return true;
            }

            class56 var20;
            boolean var40;
            if(client.field549 == 114) {
               while(client.field338.field2061 < client.field532) {
                  var40 = client.field338.method2610() == 1;
                  var68 = client.field338.method2617();
                  var67 = client.field338.method2617();
                  var71 = client.field338.method2612();
                  var22 = client.field338.method2610();
                  var49 = client.field338.method2610();
                  boolean var55 = (var49 & 2) != 0;
                  var88 = (var49 & 1) != 0;
                  if(var71 > 0) {
                     client.field338.method2617();
                     client.field338.method2610();
                     client.field338.method2614();
                  }

                  client.field338.method2617();

                  for(var89 = 0; var89 < client.field511; ++var89) {
                     class17 var97 = client.field564[var89];
                     if(!var40) {
                        if(var68.equals(var97.field253)) {
                           if(var97.field249 != var71) {
                              boolean var63 = true;

                              for(class40 var98 = (class40)client.field558.method3861(); null != var98; var98 = (class40)client.field558.method3855()) {
                                 if(var98.field914.equals(var68)) {
                                    if(var71 != 0 && var98.field912 == 0) {
                                       var98.method3997();
                                       var63 = false;
                                    } else if(var71 == 0 && var98.field912 != 0) {
                                       var98.method3997();
                                       var63 = false;
                                    }
                                 }
                              }

                              if(var63) {
                                 client.field558.method3857(new class40(var68, var71));
                              }

                              var97.field249 = var71;
                           }

                           var97.field257 = var67;
                           var97.field248 = var22;
                           var97.field251 = var55;
                           var97.field252 = var88;
                           var20 = null;
                           break;
                        }
                     } else if(var67.equals(var97.field253)) {
                        var97.field253 = var68;
                        var97.field257 = var67;
                        var20 = null;
                        break;
                     }
                  }
               }

               client.field416 = 2;
               client.field515 = client.field506 * -522622283;
               var40 = false;
               var2 = client.field511;

               while(var2 > 0) {
                  var40 = true;
                  --var2;

                  for(var3 = 0; var3 < var2; ++var3) {
                     var94 = false;
                     class17 var45 = client.field564[var3];
                     class17 var80 = client.field564[var3 + 1];
                     if(client.field468 != var45.field249 && client.field468 == var80.field249) {
                        var94 = true;
                     }

                     if(!var94 && var45.field249 == 0 && var80.field249 != 0) {
                        var94 = true;
                     }

                     if(!var94 && !var45.field251 && var80.field251) {
                        var94 = true;
                     }

                     if(!var94 && !var45.field252 && var80.field252) {
                        var94 = true;
                     }

                     if(var94) {
                        class17 var90 = client.field564[var3];
                        client.field564[var3] = client.field564[var3 + 1];
                        client.field564[1 + var3] = var90;
                        var40 = false;
                     }
                  }

                  if(var40) {
                     break;
                  }
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 129) {
               var40 = client.field338.method2610() == 1;
               if(var40) {
                  class136.field2124 = client.method424() - client.field338.method2615();
                  class9.field172 = new class224(client.field338, true);
               } else {
                  class9.field172 = null;
               }

               client.field402 = client.field506;
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 172) {
               class186.field3002 = client.field338.method2633();
               class169.field2706 = client.field338.method2662();
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 190) {
               client.field543 = true;
               class17.field258 = client.field338.method2610();
               class98.field1684 = client.field338.method2610();
               class27.field688 = client.field338.method2612();
               class26.field668 = client.field338.method2610();
               class146.field2237 = client.field338.method2610();
               if(class146.field2237 >= 100) {
                  class85.field1500 = 64 + class17.field258 * 128;
                  class157.field2342 = class98.field1684 * 128 + 64;
                  class41.field955 = class105.method2370(class85.field1500, class157.field2342, class50.field1119) - class27.field688;
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 57) {
               var1 = client.field338.method2614();
               var2 = client.field338.method2646();
               var3 = var2 >> 10 & 31;
               var71 = var2 >> 5 & 31;
               var22 = var2 & 31;
               var49 = (var22 << 3) + (var3 << 19) + (var71 << 11);
               class176 var86 = class19.method212(var1);
               if(var86.field2798 != var49) {
                  var86.field2798 = var49;
                  class51.method1124(var86);
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 48) {
               class189.method3817(false);
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 180) {
               class134.method2961(true);
               client.field338.method2865();
               var1 = client.field338.method2612();
               class125 var70 = client.field338;
               var3 = var70.field2061;
               class34.field806 = 0;
               var71 = 0;
               var70.method2878();

               for(var22 = 0; var22 < class34.field804; ++var22) {
                  var49 = class34.field807[var22];
                  if((class34.field801[var49] & 1) == 0) {
                     if(var71 > 0) {
                        --var71;
                        class34.field801[var49] = (byte)(class34.field801[var49] | 2);
                     } else {
                        var7 = var70.method2859(1);
                        if(var7 == 0) {
                           var71 = class52.method1132(var70);
                           class34.field801[var49] = (byte)(class34.field801[var49] | 2);
                        } else {
                           class4.method42(var70, var49);
                        }
                     }
                  }
               }

               var70.method2860();
               if(var71 != 0) {
                  throw new RuntimeException();
               }

               var70.method2878();

               for(var22 = 0; var22 < class34.field804; ++var22) {
                  var49 = class34.field807[var22];
                  if((class34.field801[var49] & 1) != 0) {
                     if(var71 > 0) {
                        --var71;
                        class34.field801[var49] = (byte)(class34.field801[var49] | 2);
                     } else {
                        var7 = var70.method2859(1);
                        if(var7 == 0) {
                           var71 = class52.method1132(var70);
                           class34.field801[var49] = (byte)(class34.field801[var49] | 2);
                        } else {
                           class4.method42(var70, var49);
                        }
                     }
                  }
               }

               var70.method2860();
               if(var71 != 0) {
                  throw new RuntimeException();
               }

               var70.method2878();

               for(var22 = 0; var22 < class34.field802; ++var22) {
                  var49 = class34.field810[var22];
                  if((class34.field801[var49] & 1) != 0) {
                     if(var71 > 0) {
                        --var71;
                        class34.field801[var49] = (byte)(class34.field801[var49] | 2);
                     } else {
                        var7 = var70.method2859(1);
                        if(var7 == 0) {
                           var71 = class52.method1132(var70);
                           class34.field801[var49] = (byte)(class34.field801[var49] | 2);
                        } else if(class21.method546(var70, var49)) {
                           class34.field801[var49] = (byte)(class34.field801[var49] | 2);
                        }
                     }
                  }
               }

               var70.method2860();
               if(var71 != 0) {
                  throw new RuntimeException();
               }

               var70.method2878();

               for(var22 = 0; var22 < class34.field802; ++var22) {
                  var49 = class34.field810[var22];
                  if((class34.field801[var49] & 1) == 0) {
                     if(var71 > 0) {
                        --var71;
                        class34.field801[var49] = (byte)(class34.field801[var49] | 2);
                     } else {
                        var7 = var70.method2859(1);
                        if(var7 == 0) {
                           var71 = class52.method1132(var70);
                           class34.field801[var49] = (byte)(class34.field801[var49] | 2);
                        } else if(class21.method546(var70, var49)) {
                           class34.field801[var49] = (byte)(class34.field801[var49] | 2);
                        }
                     }
                  }
               }

               var70.method2860();
               if(var71 != 0) {
                  throw new RuntimeException();
               }

               class34.field804 = 0;
               class34.field802 = 0;

               for(var22 = 1; var22 < 2048; ++var22) {
                  class34.field801[var22] = (byte)(class34.field801[var22] >> 1);
                  class2 var79 = client.field467[var22];
                  if(var79 != null) {
                     class34.field807[++class34.field804 - 1] = var22;
                  } else {
                     class34.field810[++class34.field802 - 1] = var22;
                  }
               }

               class50.method1086(var70);
               if(var70.field2061 - var3 != var1) {
                  throw new RuntimeException(var70.field2061 - var3 + " " + var1);
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 67) {
               var1 = client.field338.method2646();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               if(var1 == -1 && !client.field411) {
                  class90.method2176();
               } else if(var1 != -1 && var1 != client.field533 && client.field354 != 0 && !client.field411) {
                  class87.method1996(2, class109.field1948, var1, 0, client.field354, false);
               }

               client.field533 = var1;
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 77) {
               var1 = client.field338.method2600();
               var2 = client.field338.method2647();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               class147.method3193(var2, var1);
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 133) {
               client.field513 = client.field338.method2610();
               client.field498 = client.field338.method2610();
               client.field549 = -1;
               return true;
            }

            long var26;
            if(client.field549 == 130) {
               var1 = client.field338.method2614();
               var2 = client.field338.method2614();
               if(null == class7.field134 || !class7.field134.isValid()) {
                  try {
                     Iterator var77 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var77.hasNext()) {
                        GarbageCollectorMXBean var43 = (GarbageCollectorMXBean)var77.next();
                        if(var43.isValid()) {
                           class7.field134 = var43;
                           client.field574 = -1L;
                           client.field542 = -1L;
                        }
                     }
                  } catch (Throwable var36) {
                     ;
                  }
               }

               long var46 = client.method424();
               var22 = -1;
               if(null != class7.field134) {
                  var6 = class7.field134.getCollectionTime();
                  if(client.field542 != -1L) {
                     var26 = var6 - client.field542;
                     var61 = var46 - client.field574;
                     if(var61 != 0L) {
                        var22 = (int)(var26 * 100L / var61);
                     }
                  }

                  client.field542 = var6;
                  client.field574 = var46;
               }

               client.field336.method2854(141);
               client.field336.method2598(var1);
               client.field336.method2652(var2);
               client.field336.method2795(var22);
               client.field336.method2635(class147.field2246);
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 103) {
               var1 = client.field338.method2662();
               var2 = client.field338.method2789();
               var67 = client.field338.method2617();
               if(var2 >= 1 && var2 <= 8) {
                  if(var67.equalsIgnoreCase("null")) {
                     var67 = null;
                  }

                  client.field422[var2 - 1] = var67;
                  client.field423[var2 - 1] = var1 == 0;
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 226) {
               var1 = client.field338.method2614();
               var2 = client.field338.method2612();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var18 = class19.method212(var1);
               } else {
                  var18 = null;
               }

               if(null != var18) {
                  for(var71 = 0; var71 < var18.field2912.length; ++var71) {
                     var18.field2912[var71] = 0;
                     var18.field2809[var71] = 0;
                  }
               }

               class42.method885(var2);
               var71 = client.field338.method2612();

               for(var22 = 0; var22 < var71; ++var22) {
                  var49 = client.field338.method2610();
                  if(var49 == 255) {
                     var49 = client.field338.method2655();
                  }

                  var7 = client.field338.method2647();
                  if(var18 != null && var22 < var18.field2912.length) {
                     var18.field2912[var22] = var7;
                     var18.field2809[var22] = var49;
                  }

                  class51.method1122(var2, var22, var7 - 1, var49);
               }

               if(var18 != null) {
                  class51.method1124(var18);
               }

               class132.method2934();
               client.field483[++client.field484 - 1 & 31] = var2 & 32767;
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 170) {
               var1 = client.field338.method2614();
               var2 = client.field338.method2645();
               class179.field2946[var2] = var1;
               if(var1 != class179.field2944[var2]) {
                  class179.field2944[var2] = var1;
               }

               class118.method2536(var2);
               client.field415[++client.field482 - 1 & 31] = var2;
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 100) {
               var1 = client.field338.method2647();
               var2 = client.field338.method2612();
               var3 = client.field338.method2655();
               var71 = client.field338.method2647();
               var44 = class19.method212(var3);
               if(var2 != var44.field2845 || var1 != var44.field2846 || var71 != var44.field2848) {
                  var44.field2845 = var2;
                  var44.field2846 = var1;
                  var44.field2848 = var71;
                  class51.method1124(var44);
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 54) {
               client.field531 = client.field338.method2610();
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 72) {
               if(client.field454 != -1) {
                  var1 = client.field454;
                  if(class10.method112(var1)) {
                     class28.method647(class176.field2811[var1], 0);
                  }
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 240) {
               for(var1 = 0; var1 < class179.field2944.length; ++var1) {
                  if(class179.field2946[var1] != class179.field2944[var1]) {
                     class179.field2944[var1] = class179.field2946[var1];
                     class118.method2536(var1);
                     client.field415[++client.field482 - 1 & 31] = var1;
                  }
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 203) {
               class132.method2934();
               client.field489 = client.field338.method2610();
               client.field476 = client.field506;
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 7) {
               var1 = client.field338.method2612();
               byte var53 = client.field338.method2639();
               class179.field2946[var1] = var53;
               if(class179.field2944[var1] != var53) {
                  class179.field2944[var1] = var53;
               }

               class118.method2536(var1);
               client.field415[++client.field482 - 1 & 31] = var1;
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 104) {
               class49.method1076();
               client.field549 = -1;
               return false;
            }

            if(client.field549 == 146) {
               var1 = client.field338.method2613();
               var2 = client.field338.method2654();
               var3 = client.field338.method2738();
               var41 = class19.method212(var2);
               if(var1 != var41.field2803 || var41.field2804 != var3 || var41.field2799 != 0 || var41.field2800 != 0) {
                  var41.field2803 = var1;
                  var41.field2804 = var3;
                  var41.field2799 = 0;
                  var41.field2800 = 0;
                  class51.method1124(var41);
                  class122.method2636(var41);
                  if(var41.field2796 == 0) {
                     class11.method138(class176.field2811[var2 >> 16], var41, false);
                  }
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 36) {
               var1 = client.field338.method2612();
               client.field454 = var1;
               class118.method2544(client.field454, class142.field2191, class132.field2109, false);
               class139.method3015(var1);
               class18.method173(client.field454);

               for(var2 = 0; var2 < 100; ++var2) {
                  client.field500[var2] = true;
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 85) {
               while(client.field338.field2061 < client.field532) {
                  var1 = client.field338.method2610();
                  var48 = (var1 & 1) == 1;
                  var67 = client.field338.method2617();
                  var42 = client.field338.method2617();
                  client.field338.method2617();

                  for(var22 = 0; var22 < client.field346; ++var22) {
                     class7 var78 = client.field560[var22];
                     if(var48) {
                        if(var42.equals(var78.field141)) {
                           var78.field141 = var67;
                           var78.field131 = var42;
                           var18 = null;
                           break;
                        }
                     } else if(var67.equals(var78.field141)) {
                        var78.field141 = var67;
                        var78.field131 = var42;
                        var18 = null;
                        break;
                     }
                  }
               }

               client.field515 = client.field506 * -522622283;
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 162) {
               client.field310 = client.field338.method2646() * 30;
               client.field476 = client.field506;
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 42) {
               class134.method2961(false);
               client.field338.method2865();
               var1 = client.field338.method2612();
               class36.method767(client.field338, var1);
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 0) {
               client.field338.field2061 += 28;
               if(client.field338.method2755()) {
                  class125 var66 = client.field338;
                  var2 = client.field338.field2061 - 28;
                  if(class152.field2283 != null) {
                     try {
                        class152.field2283.method4252(0L);
                        class152.field2283.method4255(var66.field2054, var2, 24);
                     } catch (Exception var34) {
                        ;
                     }
                  }
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 97) {
               var1 = client.field338.method2654();
               var2 = client.field338.method2647();
               var18 = class19.method212(var1);
               if(var18.field2837 != 1 || var2 != var18.field2863) {
                  var18.field2837 = 1;
                  var18.field2863 = var2;
                  class51.method1124(var18);
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 157) {
               var1 = client.field338.method2654();
               var2 = client.field338.method2655();
               var3 = client.field338.method2612();
               if(var3 == '\uffff') {
                  var3 = -1;
               }

               var41 = class19.method212(var1);
               class55 var5;
               if(!var41.field2793) {
                  if(var3 == -1) {
                     var41.field2837 = 0;
                     client.field549 = -1;
                     return true;
                  }

                  var5 = class9.method108(var3);
                  var41.field2837 = 4;
                  var41.field2863 = var3;
                  var41.field2845 = var5.field1200;
                  var41.field2846 = var5.field1186;
                  var41.field2848 = var5.field1195 * 100 / var2;
                  class51.method1124(var41);
               } else {
                  var41.field2914 = var3;
                  var41.field2915 = var2;
                  var5 = class9.method108(var3);
                  var41.field2845 = var5.field1200;
                  var41.field2846 = var5.field1186;
                  var41.field2929 = var5.field1191;
                  var41.field2843 = var5.field1192;
                  var41.field2838 = var5.field1193;
                  var41.field2848 = var5.field1195;
                  if(var5.field1194 == 1) {
                     var41.field2852 = 1;
                  } else {
                     var41.field2852 = 2;
                  }

                  if(var41.field2849 > 0) {
                     var41.field2848 = var41.field2848 * 32 / var41.field2849;
                  } else if(var41.field2805 > 0) {
                     var41.field2848 = var41.field2848 * 32 / var41.field2805;
                  }

                  class51.method1124(var41);
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 53) {
               var1 = client.field338.method2614();
               var2 = client.field338.method2612();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var18 = class19.method212(var1);
               } else {
                  var18 = null;
               }

               for(; client.field338.field2061 < client.field532; class51.method1122(var2, var71, var22 - 1, var49)) {
                  var71 = client.field338.method2672();
                  var22 = client.field338.method2612();
                  var49 = 0;
                  if(var22 != 0) {
                     var49 = client.field338.method2610();
                     if(var49 == 255) {
                        var49 = client.field338.method2614();
                     }
                  }

                  if(var18 != null && var71 >= 0 && var71 < var18.field2912.length) {
                     var18.field2912[var71] = var22;
                     var18.field2809[var71] = var49;
                  }
               }

               if(null != var18) {
                  class51.method1124(var18);
               }

               class132.method2934();
               client.field483[++client.field484 - 1 & 31] = var2 & 32767;
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 116) {
               class132.method2934();
               client.field460 = client.field338.method2613();
               client.field476 = client.field506;
               client.field549 = -1;
               return true;
            }

            if(client.field549 == 194) {
               var1 = client.field338.field2061 + client.field532;
               var2 = client.field338.method2612();
               var3 = client.field338.method2612();
               if(var2 != client.field454) {
                  client.field454 = var2;
                  class118.method2544(client.field454, class142.field2191, class132.field2109, false);
                  class139.method3015(client.field454);
                  class18.method173(client.field454);

                  for(var71 = 0; var71 < 100; ++var71) {
                     client.field500[var71] = true;
                  }
               }

               class3 var82;
               for(; var3-- > 0; var82.field58 = true) {
                  var71 = client.field338.method2614();
                  var22 = client.field338.method2612();
                  var49 = client.field338.method2610();
                  var82 = (class3)client.field455.method3864((long)var71);
                  if(var82 != null && var22 != var82.field60) {
                     class214.method4018(var82, true);
                     var82 = null;
                  }

                  if(var82 == null) {
                     class3 var9 = new class3();
                     var9.field60 = var22;
                     var9.field59 = var49;
                     client.field455.method3865(var9, (long)var71);
                     class139.method3015(var22);
                     class176 var30 = class19.method212(var71);
                     class51.method1124(var30);
                     if(null != client.field371) {
                        class51.method1124(client.field371);
                        client.field371 = null;
                     }

                     class126.method2895();
                     class11.method138(class176.field2811[var71 >> 16], var30, false);
                     class18.method173(var22);
                     if(client.field454 != -1) {
                        var11 = client.field454;
                        if(class10.method112(var11)) {
                           class28.method647(class176.field2811[var11], 1);
                        }
                     }

                     var82 = var9;
                  }
               }

               for(var4 = (class3)client.field455.method3867(); var4 != null; var4 = (class3)client.field455.method3868()) {
                  if(var4.field58) {
                     var4.field58 = false;
                  } else {
                     class214.method4018(var4, true);
                  }
               }

               client.field414 = new class199(512);

               while(client.field338.field2061 < var1) {
                  var71 = client.field338.method2614();
                  var22 = client.field338.method2612();
                  var49 = client.field338.method2612();
                  var7 = client.field338.method2614();

                  for(var85 = var22; var85 <= var49; ++var85) {
                     long var27 = ((long)var71 << 32) + (long)var85;
                     client.field414.method3865(new class204(var7), var27);
                  }
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 23) {
               client.field294 = client.field338.method2610();
               if(client.field294 == 1) {
                  client.field312 = client.field338.method2612();
               }

               if(client.field294 >= 2 && client.field294 <= 6) {
                  if(client.field294 == 2) {
                     client.field317 = 64;
                     client.field318 = 64;
                  }

                  if(client.field294 == 3) {
                     client.field317 = 0;
                     client.field318 = 64;
                  }

                  if(client.field294 == 4) {
                     client.field317 = 128;
                     client.field318 = 64;
                  }

                  if(client.field294 == 5) {
                     client.field317 = 64;
                     client.field318 = 0;
                  }

                  if(client.field294 == 6) {
                     client.field317 = 64;
                     client.field318 = 128;
                  }

                  client.field294 = 2;
                  client.field314 = client.field338.method2612();
                  client.field341 = client.field338.method2612();
                  client.field316 = client.field338.method2610();
               }

               if(client.field294 == 10) {
                  client.field313 = client.field338.method2612();
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 9) {
               var40 = client.field338.method2789() == 1;
               var2 = client.field338.method2656();
               var18 = class19.method212(var2);
               if(var40 != var18.field2814) {
                  var18.field2814 = var40;
                  class51.method1124(var18);
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 125) {
               var1 = client.field338.method2654();
               var68 = client.field338.method2617();
               var18 = class19.method212(var1);
               if(!var68.equals(var18.field2844)) {
                  var18.field2844 = var68;
                  class51.method1124(var18);
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 60) {
               var1 = client.field338.method2645();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               var2 = client.field338.method2614();
               var3 = client.field338.method2654();
               var71 = client.field338.method2647();
               if(var71 == '\uffff') {
                  var71 = -1;
               }

               for(var22 = var71; var22 <= var1; ++var22) {
                  var6 = (long)var22 + ((long)var3 << 32);
                  class211 var8 = client.field414.method3864(var6);
                  if(var8 != null) {
                     var8.method4000();
                  }

                  client.field414.method3865(new class204(var2), var6);
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 137) {
               var19 = client.field338.method2617();
               var39 = (long)client.field338.method2612();
               var21 = (long)client.field338.method2703();
               class155[] var24 = new class155[]{class155.field2313, class155.field2310, class155.field2320, class155.field2309, class155.field2311};
               class155 var25 = (class155)class25.method585(var24, client.field338.method2610());
               var26 = (var39 << 32) + var21;
               boolean var10 = false;

               for(var11 = 0; var11 < 100; ++var11) {
                  if(client.field516[var11] == var26) {
                     var10 = true;
                     break;
                  }
               }

               if(class118.method2542(var19)) {
                  var10 = true;
               }

               if(!var10 && client.field490 == 0) {
                  client.field516[client.field517] = var26;
                  client.field517 = (client.field517 + 1) % 100;
                  class125 var31 = client.field338;
                  String var32 = class48.method1027(var31, 32767);
                  var23 = class226.method4139(class46.method1015(var32));
                  byte var28;
                  if(var25.field2315) {
                     var28 = 7;
                  } else {
                     var28 = 3;
                  }

                  if(var25.field2314 != -1) {
                     var17 = var25.field2314;
                     var16 = "<img=" + var17 + ">";
                     class25.method586(var28, var16 + var19, var23);
                  } else {
                     class25.method586(var28, var19, var23);
                  }
               }

               client.field549 = -1;
               return true;
            }

            if(client.field549 == 245) {
               for(var1 = 0; var1 < class56.field1229; ++var1) {
                  var20 = class113.method2510(var1);
                  if(var20 != null) {
                     class179.field2946[var1] = 0;
                     class179.field2944[var1] = 0;
                  }
               }

               class132.method2934();
               client.field482 += 32;
               client.field549 = -1;
               return true;
            }

            class46.method1008("" + client.field549 + "," + client.field434 + "," + client.field345 + "," + client.field532, (Throwable)null);
            class49.method1076();
         } catch (IOException var37) {
            class14.method154();
         } catch (Exception var38) {
            var19 = "" + client.field549 + "," + client.field434 + "," + client.field345 + "," + client.field532 + "," + (class19.field286 + class118.field2035.field885[0]) + "," + (class118.field2035.field906[0] + class6.field128) + ",";

            for(var2 = 0; var2 < client.field532 && var2 < 50; ++var2) {
               var19 = var19 + client.field338.field2054[var2] + ",";
            }

            class46.method1008(var19, var38);
            class49.method1076();
         }

         return true;
      }
   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-874025334"
   )
   public void method2878() {
      this.field2074 = super.field2061 * 8;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)[B",
      garbageValue = "-738962818"
   )
   public static byte[] method2879(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 > 0 && var4 < 128 || var4 >= 160 && var4 <= 255) {
            var2[var3] = (byte)var4;
         } else if(var4 == 8364) {
            var2[var3] = -128;
         } else if(var4 == 8218) {
            var2[var3] = -126;
         } else if(var4 == 402) {
            var2[var3] = -125;
         } else if(var4 == 8222) {
            var2[var3] = -124;
         } else if(var4 == 8230) {
            var2[var3] = -123;
         } else if(var4 == 8224) {
            var2[var3] = -122;
         } else if(var4 == 8225) {
            var2[var3] = -121;
         } else if(var4 == 710) {
            var2[var3] = -120;
         } else if(var4 == 8240) {
            var2[var3] = -119;
         } else if(var4 == 352) {
            var2[var3] = -118;
         } else if(var4 == 8249) {
            var2[var3] = -117;
         } else if(var4 == 338) {
            var2[var3] = -116;
         } else if(var4 == 381) {
            var2[var3] = -114;
         } else if(var4 == 8216) {
            var2[var3] = -111;
         } else if(var4 == 8217) {
            var2[var3] = -110;
         } else if(var4 == 8220) {
            var2[var3] = -109;
         } else if(var4 == 8221) {
            var2[var3] = -108;
         } else if(var4 == 8226) {
            var2[var3] = -107;
         } else if(var4 == 8211) {
            var2[var3] = -106;
         } else if(var4 == 8212) {
            var2[var3] = -105;
         } else if(var4 == 732) {
            var2[var3] = -104;
         } else if(var4 == 8482) {
            var2[var3] = -103;
         } else if(var4 == 353) {
            var2[var3] = -102;
         } else if(var4 == 8250) {
            var2[var3] = -101;
         } else if(var4 == 339) {
            var2[var3] = -100;
         } else if(var4 == 382) {
            var2[var3] = -98;
         } else if(var4 == 376) {
            var2[var3] = -97;
         } else {
            var2[var3] = 63;
         }
      }

      return var2;
   }

   @ObfuscatedName("e")
   public static final void method2881(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            class110.method2467(var0 - 1L);
            class110.method2467(1L);
         } else {
            class110.method2467(var0);
         }

      }
   }
}
