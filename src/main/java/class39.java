import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
@Implements("NPCComposition")
public class class39 extends class203 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2066492679
   )
   public int field881 = 1;
   @ObfuscatedName("j")
   int[] field882;
   @ObfuscatedName("f")
   public static class192 field883 = new class192(64);
   @ObfuscatedName("s")
   public static class192 field884 = new class192(50);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2087474737
   )
   int field885 = 128;
   @ObfuscatedName("e")
   @Export("name")
   public String field886 = "null";
   @ObfuscatedName("m")
   @Export("models")
   int[] field888;
   @ObfuscatedName("as")
   public boolean field889 = true;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -147856667
   )
   public int field890 = 1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -96182417
   )
   public int field891 = 1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1815463383
   )
   public int field892 = 1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1975136851
   )
   public int field893 = 1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1714358655
   )
   public int field894 = 1;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -523994825
   )
   public int field895 = 30;
   @ObfuscatedName("t")
   short[] field897;
   @ObfuscatedName("b")
   short[] field898;
   @ObfuscatedName("c")
   short[] field899;
   @ObfuscatedName("x")
   short[] field900;
   @ObfuscatedName("d")
   @Export("actions")
   public String[] field901 = new String[5];
   @ObfuscatedName("p")
   @Export("isMinimapVisible")
   public boolean field902 = true;
   @ObfuscatedName("o")
   @Export("isVisible")
   public boolean field903 = false;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -576767981
   )
   public int field904 = 1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -53880653
   )
   int field905 = 128;
   @ObfuscatedName("r")
   static class166 field906;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1630731233
   )
   int field907 = 0;
   @ObfuscatedName("a")
   static class166 field908;
   @ObfuscatedName("ak")
   public int[] field909;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1075165251
   )
   public int field910 = 32;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 136033589
   )
   @Export("id")
   public int field911;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1567288871
   )
   int field912 = -1;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1405843365
   )
   int field913 = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -986730153
   )
   public int field914 = 1;
   @ObfuscatedName("ao")
   @Export("isClickable")
   public boolean field915 = true;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1908010691
   )
   public int field916 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1595765817
   )
   @Export("combatLevel")
   public int field918 = -1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1782304735
   )
   int field919 = 0;
   @ObfuscatedName("am")
   public boolean field920 = false;

   @ObfuscatedName("g")
   public final class99 method770() {
      if(null != this.field909) {
         class39 var5 = this.method774();
         return null == var5?null:var5.method770();
      } else if(null == this.field882) {
         return null;
      } else {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.field882.length; ++var2) {
            if(!field906.method3265(this.field882[var2], 0)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            class99[] var6 = new class99[this.field882.length];

            for(int var3 = 0; var3 < this.field882.length; ++var3) {
               var6[var3] = class99.method2219(field906, this.field882[var3], 0);
            }

            class99 var7;
            if(1 == var6.length) {
               var7 = var6[0];
            } else {
               var7 = new class99(var6, var6.length);
            }

            int var4;
            if(null != this.field897) {
               for(var4 = 0; var4 < this.field897.length; ++var4) {
                  var7.method2254(this.field897[var4], this.field898[var4]);
               }
            }

            if(null != this.field899) {
               for(var4 = 0; var4 < this.field899.length; ++var4) {
                  var7.method2274(this.field899[var4], this.field900[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass118;II)V",
      garbageValue = "-1505812659"
   )
   void method771(class118 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2579();
         this.field888 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field888[var4] = var1.method2514();
         }
      } else if(var2 == 2) {
         this.field886 = var1.method2520();
      } else if(12 == var2) {
         this.field881 = var1.method2579();
      } else if(var2 == 13) {
         this.field890 = var1.method2514() * -1;
      } else if(14 == var2) {
         this.field893 = var1.method2514() * -1;
      } else if(var2 == 15) {
         this.field891 = var1.method2514() * -1;
      } else if(16 == var2) {
         this.field892 = var1.method2514() * -1;
      } else if(17 == var2) {
         this.field893 = var1.method2514() * -1;
         this.field894 = var1.method2514() * -1;
         this.field904 = var1.method2514() * -1;
         this.field914 = var1.method2514() * -1;
      } else if(var2 >= 30 && var2 < 35) {
         this.field901[var2 - 30] = var1.method2520();
         if(this.field901[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field901[var2 - 30] = null;
         }
      } else if(40 == var2) {
         var3 = var1.method2579();
         this.field897 = new short[var3];
         this.field898 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field897[var4] = (short)var1.method2514();
            this.field898[var4] = (short)var1.method2514();
         }
      } else if(var2 == 41) {
         var3 = var1.method2579();
         this.field899 = new short[var3];
         this.field900 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field899[var4] = (short)var1.method2514();
            this.field900[var4] = (short)var1.method2514();
         }
      } else if(60 == var2) {
         var3 = var1.method2579();
         this.field882 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field882[var4] = var1.method2514();
         }
      } else if(93 == var2) {
         this.field902 = false;
      } else if(95 == var2) {
         this.field918 = var1.method2514();
      } else if(var2 == 97) {
         this.field885 = var1.method2514();
      } else if(var2 == 98) {
         this.field905 = var1.method2514();
      } else if(var2 == 99) {
         this.field903 = true;
      } else if(100 == var2) {
         this.field907 = var1.method2707();
      } else if(101 == var2) {
         this.field919 = var1.method2707();
      } else if(102 == var2) {
         this.field916 = var1.method2514();
      } else if(103 == var2) {
         this.field910 = var1.method2514();
      } else if(var2 == 106) {
         this.field912 = var1.method2514();
         if(this.field912 == '\uffff') {
            this.field912 = -1;
         }

         this.field913 = var1.method2514();
         if('\uffff' == this.field913) {
            this.field913 = -1;
         }

         var3 = var1.method2579();
         this.field909 = new int[1 + var3];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field909[var4] = var1.method2514();
            if('\uffff' == this.field909[var4]) {
               this.field909[var4] = -1;
            }
         }
      } else if(var2 == 107) {
         this.field889 = false;
      } else if(109 == var2) {
         this.field915 = false;
      } else if(111 == var2) {
         this.field920 = true;
      } else if(112 == var2) {
         this.field895 = var1.method2579();
      }

   }

   @ObfuscatedName("e")
   public final class104 method772(class42 var1, int var2, class42 var3, int var4) {
      if(null != this.field909) {
         class39 var11 = this.method774();
         return null == var11?null:var11.method772(var1, var2, var3, var4);
      } else {
         class104 var5 = (class104)field884.method3792((long)this.field911);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.field888.length; ++var7) {
               if(!field906.method3265(this.field888[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            class99[] var8 = new class99[this.field888.length];

            int var9;
            for(var9 = 0; var9 < this.field888.length; ++var9) {
               var8[var9] = class99.method2219(field906, this.field888[var9], 0);
            }

            class99 var12;
            if(1 == var8.length) {
               var12 = var8[0];
            } else {
               var12 = new class99(var8, var8.length);
            }

            if(this.field897 != null) {
               for(var9 = 0; var9 < this.field897.length; ++var9) {
                  var12.method2254(this.field897[var9], this.field898[var9]);
               }
            }

            if(this.field899 != null) {
               for(var9 = 0; var9 < this.field899.length; ++var9) {
                  var12.method2274(this.field899[var9], this.field900[var9]);
               }
            }

            var5 = var12.method2239(this.field907 + 64, this.field919 * 5 + 850, -30, -50, -30);
            field884.method3794(var5, (long)this.field911);
         }

         class104 var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method903(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method873(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method873(var5, var4);
         } else {
            var10 = var5.method2351(true);
         }

         if(this.field885 != 128 || this.field905 != 128) {
            var10.method2321(this.field885, this.field905, this.field885);
         }

         return var10;
      }
   }

   @ObfuscatedName("m")
   public final class39 method774() {
      int var1 = -1;
      if(this.field912 != -1) {
         var1 = class126.method2820(this.field912);
      } else if(-1 != this.field913) {
         var1 = class175.field2890[this.field913];
      }

      return var1 >= 0 && var1 < this.field909.length && -1 != this.field909[var1]?class23.method593(this.field909[var1]):null;
   }

   @ObfuscatedName("j")
   public boolean method775() {
      if(null == this.field909) {
         return true;
      } else {
         int var1 = -1;
         if(-1 != this.field912) {
            var1 = class126.method2820(this.field912);
         } else if(-1 != this.field913) {
            var1 = class175.field2890[this.field913];
         }

         return var1 >= 0 && var1 < this.field909.length && this.field909[var1] != -1;
      }
   }

   @ObfuscatedName("y")
   public static int method785(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }

   @ObfuscatedName("f")
   void method789() {
   }

   @ObfuscatedName("s")
   void method796(class118 var1) {
      while(true) {
         int var2 = var1.method2579();
         if(0 == var2) {
            return;
         }

         this.method771(var1, var2);
      }
   }

   @ObfuscatedName("qy")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/awt/Color;ZI)V",
      garbageValue = "795141391"
   )
   protected static final void method801(int var0, String var1, Color var2, boolean var3) {
      try {
         Graphics var4 = class45.field1042.getGraphics();
         if(null == class50.field1099) {
            class50.field1099 = new Font("Helvetica", 1, 13);
            class137.field2124 = class45.field1042.getFontMetrics(class50.field1099);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class6.field107, class31.field749);
         }

         if(var2 == null) {
            var2 = new Color(140, 17, 17);
         }

         try {
            if(null == class101.field1754) {
               class101.field1754 = class45.field1042.createImage(304, 34);
            }

            Graphics var5 = class101.field1754.getGraphics();
            var5.setColor(var2);
            var5.drawRect(0, 0, 303, 33);
            var5.fillRect(2, 2, var0 * 3, 30);
            var5.setColor(Color.black);
            var5.drawRect(1, 1, 301, 31);
            var5.fillRect(2 + 3 * var0, 2, 300 - 3 * var0, 30);
            var5.setFont(class50.field1099);
            var5.setColor(Color.white);
            var5.drawString(var1, (304 - class137.field2124.stringWidth(var1)) / 2, 22);
            var4.drawImage(class101.field1754, class6.field107 / 2 - 152, class31.field749 / 2 - 18, (ImageObserver)null);
         } catch (Exception var8) {
            int var6 = class6.field107 / 2 - 152;
            int var7 = class31.field749 / 2 - 18;
            var4.setColor(var2);
            var4.drawRect(var6, var7, 303, 33);
            var4.fillRect(var6 + 2, 2 + var7, var0 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(1 + var6, var7 + 1, 301, 31);
            var4.fillRect(3 * var0 + var6 + 2, var7 + 2, 300 - 3 * var0, 30);
            var4.setFont(class50.field1099);
            var4.setColor(Color.white);
            var4.drawString(var1, var6 + (304 - class137.field2124.stringWidth(var1)) / 2, 22 + var7);
         }
      } catch (Exception var9) {
         class45.field1042.repaint();
      }

   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-119"
   )
   static final void method802(boolean var0) {
      client.field353 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!client.field353) {
         var1 = client.field472.method2514();
         var2 = client.field472.method2546();
         var3 = client.field472.method2514();
         class16.field241 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class16.field241[var4][var5] = client.field472.method2517();
            }
         }

         class110.field1951 = new int[var3];
         class157.field2579 = new int[var3];
         class13.field190 = new int[var3];
         class185.field2994 = new byte[var3][];
         class15.field214 = new byte[var3][];
         boolean var13 = false;
         if((var1 / 8 == 48 || 49 == var1 / 8) && var2 / 8 == 48) {
            var13 = true;
         }

         if(48 == var1 / 8 && var2 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (6 + var1) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (var2 + 6) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var13 || var6 != 49 && 149 != var6 && 147 != var6 && 50 != var5 && (var5 != 49 || 47 != var6)) {
                  class110.field1951[var3] = var7;
                  class157.field2579[var3] = class49.field1088.method3278("m" + var5 + "_" + var6);
                  class13.field190[var3] = class49.field1088.method3278("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class100.method2290(var1, var2);
      } else {
         var1 = client.field472.method2514();
         var2 = client.field472.method2514();
         var3 = client.field472.method2514();
         client.field472.method2754();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field472.method2750(1);
                  if(1 == var7) {
                     client.field354[var4][var5][var6] = client.field472.method2750(26);
                  } else {
                     client.field354[var4][var5][var6] = -1;
                  }
               }
            }
         }

         client.field472.method2755();
         class16.field241 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class16.field241[var4][var5] = client.field472.method2517();
            }
         }

         class110.field1951 = new int[var3];
         class157.field2579 = new int[var3];
         class13.field190 = new int[var3];
         class185.field2994 = new byte[var3][];
         class15.field214 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field354[var4][var5][var6];
                  if(-1 != var7) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = var9 / 8 + (var8 / 8 << 8);

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(class110.field1951[var11] == var10) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(-1 != var10) {
                        class110.field1951[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class157.field2579[var3] = class49.field1088.method3278("m" + var11 + "_" + var12);
                        class13.field190[var3] = class49.field1088.method3278("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class100.method2290(var1, var2);
      }

   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1842748131"
   )
   static final void method803(boolean var0) {
      client.field577 = 0;
      client.field330 = 0;
      client.field472.method2754();
      int var1 = client.field472.method2750(8);
      int var2;
      if(var1 < client.field331) {
         for(var2 = var1; var2 < client.field331; ++var2) {
            client.field410[++client.field577 - 1] = client.field564[var2];
         }
      }

      if(var1 > client.field331) {
         throw new RuntimeException("");
      } else {
         client.field331 = 0;

         int var5;
         int var6;
         int var7;
         int var8;
         for(var2 = 0; var2 < var1; ++var2) {
            int var3 = client.field564[var2];
            class34 var4 = client.field358[var3];
            var5 = client.field472.method2750(1);
            if(var5 == 0) {
               client.field564[++client.field331 - 1] = var3;
               var4.field851 = client.field303;
            } else {
               var6 = client.field472.method2750(2);
               if(var6 == 0) {
                  client.field564[++client.field331 - 1] = var3;
                  var4.field851 = client.field303;
                  client.field334[++client.field330 - 1] = var3;
               } else if(1 == var6) {
                  client.field564[++client.field331 - 1] = var3;
                  var4.field851 = client.field303;
                  var7 = client.field472.method2750(3);
                  var4.method718(var7, (byte)1);
                  var8 = client.field472.method2750(1);
                  if(var8 == 1) {
                     client.field334[++client.field330 - 1] = var3;
                  }
               } else if(var6 == 2) {
                  client.field564[++client.field331 - 1] = var3;
                  var4.field851 = client.field303;
                  var7 = client.field472.method2750(3);
                  var4.method718(var7, (byte)2);
                  var8 = client.field472.method2750(3);
                  var4.method718(var8, (byte)2);
                  int var9 = client.field472.method2750(1);
                  if(1 == var9) {
                     client.field334[++client.field330 - 1] = var3;
                  }
               } else if(var6 == 3) {
                  client.field410[++client.field577 - 1] = var3;
               }
            }
         }

         while(client.field472.method2756(client.field569) >= 27) {
            var1 = client.field472.method2750(15);
            if(32767 == var1) {
               break;
            }

            boolean var10 = false;
            if(client.field358[var1] == null) {
               client.field358[var1] = new class34();
               var10 = true;
            }

            class34 var11 = client.field358[var1];
            client.field564[++client.field331 - 1] = var1;
            var11.field851 = client.field303;
            int var12 = client.field472.method2750(1);
            var5 = client.field434[client.field472.method2750(3)];
            if(var10) {
               var11.field862 = var11.field814 = var5;
            }

            if(var0) {
               var6 = client.field472.method2750(8);
               if(var6 > 127) {
                  var6 -= 256;
               }
            } else {
               var6 = client.field472.method2750(5);
               if(var6 > 15) {
                  var6 -= 32;
               }
            }

            if(var0) {
               var7 = client.field472.method2750(8);
               if(var7 > 127) {
                  var7 -= 256;
               }
            } else {
               var7 = client.field472.method2750(5);
               if(var7 > 15) {
                  var7 -= 32;
               }
            }

            var8 = client.field472.method2750(1);
            if(1 == var8) {
               client.field334[++client.field330 - 1] = var1;
            }

            var11.field785 = class23.method593(client.field472.method2750(14));
            var11.field816 = var11.field785.field881;
            var11.field864 = var11.field785.field910;
            if(var11.field864 == 0) {
               var11.field814 = 0;
            }

            var11.field820 = var11.field785.field893 * -1;
            var11.field821 = var11.field785.field894 * -1;
            var11.field860 = var11.field785.field904 * -1;
            var11.field823 = var11.field785.field914 * -1;
            var11.field817 = var11.field785.field890 * -1;
            var11.field830 = var11.field785.field891 * -1;
            var11.field819 = var11.field785.field892;
            var11.method717(class151.field2253.field866[0] + var7, class151.field2253.field867[0] + var6, var12 == 1);
         }

         client.field472.method2755();
         class143.method3092();

         for(var1 = 0; var1 < client.field577; ++var1) {
            var2 = client.field410[var1];
            if(client.field358[var2].field851 != client.field303) {
               client.field358[var2].field785 = null;
               client.field358[var2] = null;
            }
         }

         if(client.field569 != client.field472.field1979) {
            throw new RuntimeException(client.field472.field1979 + "," + client.field569);
         } else {
            for(var1 = 0; var1 < client.field331; ++var1) {
               if(null == client.field358[client.field564[var1]]) {
                  throw new RuntimeException(var1 + "," + client.field331);
               }
            }

         }
      }
   }

   @ObfuscatedName("a")
   public static File method804(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class148.field2218 = new File(class140.field2161, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      File var19;
      if(class148.field2218.exists()) {
         try {
            class226 var7 = new class226(class148.field2218, "rw", 10000L);

            class118 var8;
            int var9;
            for(var8 = new class118((int)var7.method4156()); var8.field1979 < var8.field1980.length; var8.field1979 += var9) {
               var9 = var7.method4157(var8.field1980, var8.field1979, var8.field1980.length - var8.field1979);
               if(-1 == var9) {
                  throw new IOException();
               }
            }

            var8.field1979 = 0;
            var9 = var8.method2579();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.method2579();
            }

            if(var9 <= 2) {
               var4 = var8.method2609();
               if(var10 == 1) {
                  var5 = var8.method2609();
               }
            } else {
               var4 = var8.method2522();
               if(1 == var10) {
                  var5 = var8.method2522();
               }
            }

            var7.method4168();
         } catch (IOException var16) {
            var16.printStackTrace();
         }

         if(var4 != null) {
            var19 = new File(var4);
            if(!var19.exists()) {
               var4 = null;
            }
         }

         if(var4 != null) {
            var19 = new File(var4, "test.dat");
            if(!class141.method2996(var19, true)) {
               var4 = null;
            }
         }
      }

      if(null == var4 && var2 == 0) {
         label123:
         for(int var17 = 0; var17 < class122.field2013.length; ++var17) {
            for(int var20 = 0; var20 < class0.field12.length; ++var20) {
               File var21 = new File(class0.field12[var20] + class122.field2013[var17] + File.separatorChar + var0 + File.separatorChar);
               if(var21.exists() && class141.method2996(new File(var21, "test.dat"), true)) {
                  var4 = var21.toString();
                  var6 = true;
                  break label123;
               }
            }
         }
      }

      if(null == var4) {
         var4 = class140.field2161 + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      if(null != var5) {
         File var18 = new File(var5);
         var19 = new File(var4);

         try {
            File[] var22 = var18.listFiles();
            File[] var23 = var22;

            for(int var11 = 0; var11 < var23.length; ++var11) {
               File var12 = var23[var11];
               File var13 = new File(var19, var12.getName());
               boolean var14 = var12.renameTo(var13);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var15) {
            var15.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         class32.method693(new File(var4), (File)null);
      }

      return new File(var4);
   }
}
