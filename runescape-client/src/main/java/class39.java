import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
@Implements("NPCComposition")
public class class39 extends class204 {
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1768615845
   )
   int field859 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1559443329
   )
   public int field860 = -1;
   @ObfuscatedName("j")
   public static class193 field861 = new class193(64);
   @ObfuscatedName("d")
   @Export("npcModelCache")
   public static class193 field862 = new class193(50);
   @ObfuscatedName("h")
   short[] field863;
   @ObfuscatedName("y")
   @Export("name")
   public String field864 = "null";
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -316669585
   )
   public int field865 = 1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -339739689
   )
   public int field866 = -1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1296518797
   )
   @Export("id")
   public int field867;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 788110557
   )
   public int field868 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1524779415
   )
   public int field869 = -1;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -169358855
   )
   public int field870 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -210079767
   )
   public int field871 = -1;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1141240209
   )
   int field872 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -672341675
   )
   public int field873 = -1;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1799485405
   )
   int field874 = -1;
   @ObfuscatedName("t")
   short[] field875;
   @ObfuscatedName("e")
   @Export("isVisible")
   public boolean field876 = false;
   @ObfuscatedName("v")
   short[] field877;
   @ObfuscatedName("a")
   short[] field878;
   @ObfuscatedName("f")
   @Export("actions")
   public String[] field879 = new String[5];
   @ObfuscatedName("q")
   @Export("isMinimapVisible")
   public boolean field880 = true;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -69484305
   )
   @Export("combatLevel")
   public int field881 = -1;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 1002938567
   )
   static int field882;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -500711969
   )
   int field883 = 128;
   @ObfuscatedName("g")
   static class167 field884;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1687937749
   )
   int field885 = 128;
   @ObfuscatedName("b")
   static class167 field886;
   @ObfuscatedName("l")
   int[] field887;
   @ObfuscatedName("ax")
   @Export("isClickable")
   public boolean field888 = true;
   @ObfuscatedName("aj")
   public int[] field889;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1448570889
   )
   int field890 = -1;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -389150829
   )
   public int field891 = 32;
   @ObfuscatedName("az")
   public boolean field892 = true;
   @ObfuscatedName("ac")
   public boolean field893 = false;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1787676701
   )
   public int field894 = -1;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -48500867
   )
   public int field895 = 30;
   @ObfuscatedName("c")
   @Export("models")
   int[] field896;
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      intValue = -820425117
   )
   static int field897;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1631955996"
   )
   void method768() {
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "619889765"
   )
   public boolean method769() {
      if(this.field889 == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.field890 != -1) {
            var1 = class7.method90(this.field890);
         } else if(this.field874 != -1) {
            var1 = class176.field2896[this.field874];
         }

         return var1 >= 0 && var1 < this.field889.length && this.field889[var1] != -1;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass42;ILclass42;II)Lclass105;",
      garbageValue = "1399489363"
   )
   public final class105 method771(class42 var1, int var2, class42 var3, int var4) {
      if(null != this.field889) {
         class39 var12 = this.method773();
         return null == var12?null:var12.method771(var1, var2, var3, var4);
      } else {
         class105 var5 = (class105)field862.method3764((long)this.field867);
         if(null == var5) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.field896.length; ++var7) {
               if(!field884.method3268(this.field896[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            class100[] var8 = new class100[this.field896.length];

            int var9;
            for(var9 = 0; var9 < this.field896.length; ++var9) {
               var8[var9] = class100.method2208(field884, this.field896[var9], 0);
            }

            class100 var11;
            if(var8.length == 1) {
               var11 = var8[0];
            } else {
               var11 = new class100(var8, var8.length);
            }

            if(this.field875 != null) {
               for(var9 = 0; var9 < this.field875.length; ++var9) {
                  var11.method2221(this.field875[var9], this.field863[var9]);
               }
            }

            if(this.field877 != null) {
               for(var9 = 0; var9 < this.field877.length; ++var9) {
                  var11.method2222(this.field877[var9], this.field878[var9]);
               }
            }

            var5 = var11.method2229(64 + this.field872, this.field859 + 850, -30, -50, -30);
            field862.method3759(var5, (long)this.field867);
         }

         class105 var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method872(var5, var2, var3, var4);
         } else if(null != var1) {
            var10 = var1.method894(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method894(var5, var4);
         } else {
            var10 = var5.method2296(true);
         }

         if(this.field885 != 128 || this.field883 != 128) {
            var10.method2310(this.field885, this.field883, this.field885);
         }

         return var10;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lclass39;",
      garbageValue = "-1489369682"
   )
   public final class39 method773() {
      int var1 = -1;
      if(this.field890 != -1) {
         var1 = class7.method90(this.field890);
      } else if(this.field874 != -1) {
         var1 = class176.field2896[this.field874];
      }

      return var1 >= 0 && var1 < this.field889.length && this.field889[var1] != -1?class176.method3460(this.field889[var1]):null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "77"
   )
   void method780(class119 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2514();
         this.field896 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field896[var4] = var1.method2516();
         }
      } else if(var2 == 2) {
         this.field864 = var1.method2522();
      } else if(var2 == 12) {
         this.field865 = var1.method2514();
      } else if(var2 == 13) {
         this.field868 = var1.method2516();
      } else if(var2 == 14) {
         this.field871 = var1.method2516();
      } else if(var2 == 15) {
         this.field869 = var1.method2516();
      } else if(var2 == 16) {
         this.field860 = var1.method2516();
      } else if(var2 == 17) {
         this.field871 = var1.method2516();
         this.field894 = var1.method2516();
         this.field873 = var1.method2516();
         this.field866 = var1.method2516();
      } else if(var2 >= 30 && var2 < 35) {
         this.field879[var2 - 30] = var1.method2522();
         if(this.field879[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field879[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2514();
         this.field875 = new short[var3];
         this.field863 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field875[var4] = (short)var1.method2516();
            this.field863[var4] = (short)var1.method2516();
         }
      } else if(var2 == 41) {
         var3 = var1.method2514();
         this.field877 = new short[var3];
         this.field878 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field877[var4] = (short)var1.method2516();
            this.field878[var4] = (short)var1.method2516();
         }
      } else if(var2 == 60) {
         var3 = var1.method2514();
         this.field887 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field887[var4] = var1.method2516();
         }
      } else if(var2 == 93) {
         this.field880 = false;
      } else if(var2 == 95) {
         this.field881 = var1.method2516();
      } else if(var2 == 97) {
         this.field885 = var1.method2516();
      } else if(var2 == 98) {
         this.field883 = var1.method2516();
      } else if(var2 == 99) {
         this.field876 = true;
      } else if(var2 == 100) {
         this.field872 = var1.method2515();
      } else if(var2 == 101) {
         this.field859 = var1.method2515() * 5;
      } else if(var2 == 102) {
         this.field870 = var1.method2516();
      } else if(var2 == 103) {
         this.field891 = var1.method2516();
      } else if(var2 == 106) {
         this.field890 = var1.method2516();
         if(this.field890 == '\uffff') {
            this.field890 = -1;
         }

         this.field874 = var1.method2516();
         if(this.field874 == '\uffff') {
            this.field874 = -1;
         }

         var3 = var1.method2514();
         this.field889 = new int[var3 + 1];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field889[var4] = var1.method2516();
            if(this.field889[var4] == '\uffff') {
               this.field889[var4] = -1;
            }
         }
      } else if(var2 == 107) {
         this.field892 = false;
      } else if(var2 == 109) {
         this.field888 = false;
      } else if(var2 == 111) {
         this.field893 = true;
      } else if(var2 == 112) {
         this.field895 = var1.method2514();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "12"
   )
   void method789(class119 var1) {
      while(true) {
         int var2 = var1.method2514();
         if(var2 == 0) {
            return;
         }

         this.method780(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lclass100;",
      garbageValue = "2006123505"
   )
   public final class100 method793() {
      if(this.field889 != null) {
         class39 var1 = this.method773();
         return null == var1?null:var1.method793();
      } else if(this.field887 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var6 = 0; var6 < this.field887.length; ++var6) {
            if(!field884.method3268(this.field887[var6], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            class100[] var2 = new class100[this.field887.length];

            for(int var3 = 0; var3 < this.field887.length; ++var3) {
               var2[var3] = class100.method2208(field884, this.field887[var3], 0);
            }

            class100 var7;
            if(var2.length == 1) {
               var7 = var2[0];
            } else {
               var7 = new class100(var2, var2.length);
            }

            int var4;
            if(null != this.field875) {
               for(var4 = 0; var4 < this.field875.length; ++var4) {
                  var7.method2221(this.field875[var4], this.field863[var4]);
               }
            }

            if(this.field877 != null) {
               for(var4 = 0; var4 < this.field877.length; ++var4) {
                  var7.method2222(this.field877[var4], this.field878[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)Lclass78;",
      garbageValue = "-36320879"
   )
   @Export("createSprite")
   public static final class78 method794(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var2 << 38) + (long)var0 + ((long)var1 << 16) + ((long)var4 << 40) + ((long)var3 << 42);
      class78 var8;
      if(!var5) {
         var8 = (class78)class51.field1081.method3764(var6);
         if(var8 != null) {
            return var8;
         }
      }

      class51 var9 = class35.method741(var0);
      if(var1 > 1 && var9.field1113 != null) {
         int var21 = -1;

         for(int var22 = 0; var22 < 10; ++var22) {
            if(var1 >= var9.field1125[var22] && var9.field1125[var22] != 0) {
               var21 = var9.field1113[var22];
            }
         }

         if(var21 != -1) {
            var9 = class35.method741(var21);
         }
      }

      class105 var10 = var9.method1024(1);
      if(null == var10) {
         return null;
      } else {
         class78 var11 = null;
         if(var9.field1116 != -1) {
            var11 = method794(var9.field1112, 10, 1, 0, 0, true);
            if(null == var11) {
               return null;
            }
         } else if(var9.field1085 != -1) {
            var11 = method794(var9.field1110, var1, var2, var3, 0, false);
            if(null == var11) {
               return null;
            }
         } else if(var9.field1127 != -1) {
            var11 = method794(var9.field1126, var1, 0, 0, 0, false);
            if(var11 == null) {
               return null;
            }
         }

         int[] var12 = class79.field1383;
         int var13 = class79.field1382;
         int var14 = class79.field1387;
         int[] var15 = new int[4];
         class79.method1795(var15);
         var8 = new class78(36, 32);
         class79.method1791(var8.field1380, 36, 32);
         class79.method1850();
         class91.method2126();
         class91.method2147(16, 16);
         class91.field1543 = false;
         if(var9.field1127 != -1) {
            var11.method1767(0, 0);
         }

         int var16 = var9.field1106;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)(1.04D * (double)var16);
         }

         int var17 = var16 * class91.field1563[var9.field1091] >> 16;
         int var18 = var16 * class91.field1564[var9.field1091] >> 16;
         var10.method2323();
         var10.method2314(0, var9.field1083, var9.field1093, var9.field1091, var9.field1089, var17 + var10.field1436 / 2 + var9.field1095, var18 + var9.field1095);
         if(var9.field1085 != -1) {
            var11.method1767(0, 0);
         }

         if(var2 >= 1) {
            var8.method1783(1);
         }

         if(var2 >= 2) {
            var8.method1783(16777215);
         }

         if(var3 != 0) {
            var8.method1711(var3);
         }

         class79.method1791(var8.field1380, 36, 32);
         if(var9.field1116 != -1) {
            var11.method1767(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.field1096 == 1) {
            class224 var19 = class51.field1124;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method4033(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            class51.field1081.method3759(var8, var6);
         }

         class79.method1791(var12, var13, var14);
         class79.method1796(var15);
         class91.method2126();
         class91.field1543 = true;
         return var8;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1861129026"
   )
   public static int method795(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass212;I)Ljava/lang/String;",
      garbageValue = "-1519777810"
   )
   public static String method796(CharSequence var0, class212 var1) {
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

         int var14 = var3 - var2;
         if(var14 >= 1) {
            byte var6;
            if(null == var1) {
               var6 = 12;
            } else {
               switch(var1.field3134) {
               case 4:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var14 <= var6) {
               StringBuilder var13 = new StringBuilder(var14);

               for(int var15 = var2; var15 < var3; ++var15) {
                  char var7 = var0.charAt(var15);
                  boolean var8;
                  if(Character.isISOControl(var7)) {
                     var8 = false;
                  } else if(class153.method3169(var7)) {
                     var8 = true;
                  } else {
                     char[] var9 = class164.field2645;
                     int var10 = 0;

                     label146:
                     while(true) {
                        char var11;
                        if(var10 >= var9.length) {
                           var9 = class164.field2643;

                           for(var10 = 0; var10 < var9.length; ++var10) {
                              var11 = var9[var10];
                              if(var7 == var11) {
                                 var8 = true;
                                 break label146;
                              }
                           }

                           var8 = false;
                           break;
                        }

                        var11 = var9[var10];
                        if(var11 == var7) {
                           var8 = true;
                           break;
                        }

                        ++var10;
                     }
                  }

                  if(var8) {
                     char var12;
                     switch(var7) {
                     case ' ':
                     case '-':
                     case '_':
                     case ' ':
                        var12 = 95;
                        break;
                     case '#':
                     case '[':
                     case ']':
                        var12 = var7;
                        break;
                     case 'À':
                     case 'Á':
                     case 'Â':
                     case 'Ã':
                     case 'Ä':
                     case 'à':
                     case 'á':
                     case 'â':
                     case 'ã':
                     case 'ä':
                        var12 = 97;
                        break;
                     case 'Ç':
                     case 'ç':
                        var12 = 99;
                        break;
                     case 'È':
                     case 'É':
                     case 'Ê':
                     case 'Ë':
                     case 'è':
                     case 'é':
                     case 'ê':
                     case 'ë':
                        var12 = 101;
                        break;
                     case 'Í':
                     case 'Î':
                     case 'Ï':
                     case 'í':
                     case 'î':
                     case 'ï':
                        var12 = 105;
                        break;
                     case 'Ñ':
                     case 'ñ':
                        var12 = 110;
                        break;
                     case 'Ò':
                     case 'Ó':
                     case 'Ô':
                     case 'Õ':
                     case 'Ö':
                     case 'ò':
                     case 'ó':
                     case 'ô':
                     case 'õ':
                     case 'ö':
                        var12 = 111;
                        break;
                     case 'Ù':
                     case 'Ú':
                     case 'Û':
                     case 'Ü':
                     case 'ù':
                     case 'ú':
                     case 'û':
                     case 'ü':
                        var12 = 117;
                        break;
                     case 'ß':
                        var12 = 98;
                        break;
                     case 'ÿ':
                     case 'Ÿ':
                        var12 = 121;
                        break;
                     default:
                        var12 = Character.toLowerCase(var7);
                     }

                     if(var12 != 0) {
                        var13.append(var12);
                     }
                  }
               }

               if(var13.length() == 0) {
                  return null;
               }

               return var13.toString();
            }
         }

         return null;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(CB)B",
      garbageValue = "0"
   )
   public static byte method797(char var0) {
      byte var1;
      if((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if(var0 == 8364) {
            var1 = -128;
         } else if(var0 == 8218) {
            var1 = -126;
         } else if(var0 == 402) {
            var1 = -125;
         } else if(var0 == 8222) {
            var1 = -124;
         } else if(var0 == 8230) {
            var1 = -123;
         } else if(var0 == 8224) {
            var1 = -122;
         } else if(var0 == 8225) {
            var1 = -121;
         } else if(var0 == 710) {
            var1 = -120;
         } else if(var0 == 8240) {
            var1 = -119;
         } else if(var0 == 352) {
            var1 = -118;
         } else if(var0 == 8249) {
            var1 = -117;
         } else if(var0 == 338) {
            var1 = -116;
         } else if(var0 == 381) {
            var1 = -114;
         } else if(var0 == 8216) {
            var1 = -111;
         } else if(var0 == 8217) {
            var1 = -110;
         } else if(var0 == 8220) {
            var1 = -109;
         } else if(var0 == 8221) {
            var1 = -108;
         } else if(var0 == 8226) {
            var1 = -107;
         } else if(var0 == 8211) {
            var1 = -106;
         } else if(var0 == 8212) {
            var1 = -105;
         } else if(var0 == 732) {
            var1 = -104;
         } else if(var0 == 8482) {
            var1 = -103;
         } else if(var0 == 353) {
            var1 = -102;
         } else if(var0 == 8250) {
            var1 = -101;
         } else if(var0 == 339) {
            var1 = -100;
         } else if(var0 == 382) {
            var1 = -98;
         } else if(var0 == 376) {
            var1 = -97;
         } else {
            var1 = 63;
         }
      } else {
         var1 = (byte)var0;
      }

      return var1;
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(Lclass173;B)V",
      garbageValue = "43"
   )
   static void method798(class173 var0) {
      class173 var1 = var0.field2777 == -1?null:class161.method3205(var0.field2777);
      int var2;
      int var3;
      if(null == var1) {
         var2 = class45.field1026;
         var3 = class143.field2169;
      } else {
         var2 = var1.field2763;
         var3 = var1.field2764;
      }

      class16.method176(var0, var2, var3, false);
      client.method548(var0, var2, var3);
   }
}
