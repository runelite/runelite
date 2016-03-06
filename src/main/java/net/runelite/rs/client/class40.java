import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("an")
@Implements("ObjectComposition")
public class class40 extends class203 {
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1034496169
   )
   int field916 = 0;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -199232679
   )
   public int field917 = -1;
   @ObfuscatedName("p")
   public boolean field918 = true;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -781208995
   )
   int field919 = 128;
   @ObfuscatedName("al")
   public int[] field920;
   @ObfuscatedName("m")
   static class192 field921 = new class192(30);
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1502133959
   )
   int field922 = 0;
   @ObfuscatedName("h")
   static class99[] field923 = new class99[4];
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1656841865
   )
   public int field924;
   @ObfuscatedName("k")
   int[] field925;
   @ObfuscatedName("r")
   int[] field926;
   @ObfuscatedName("b")
   @Export("name")
   public String field927 = "null";
   @ObfuscatedName("q")
   short[] field928;
   @ObfuscatedName("u")
   short[] field929;
   @ObfuscatedName("g")
   short[] field930;
   @ObfuscatedName("y")
   short[] field931;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2110022625
   )
   public int field932 = 1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 953271157
   )
   public int field933 = 1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1404371489
   )
   public int field934 = 2;
   @ObfuscatedName("i")
   static class192 field935 = new class192(64);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1547236919
   )
   public int field936 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -482521369
   )
   int field937 = 1;
   @ObfuscatedName("x")
   public boolean field939 = false;
   @ObfuscatedName("a")
   public static class166 field940;
   @ObfuscatedName("j")
   public static boolean field941 = false;
   @ObfuscatedName("an")
   boolean field942 = false;
   @ObfuscatedName("c")
   boolean field943 = false;
   @ObfuscatedName("am")
   @Export("actions")
   public String[] field944 = new String[5];
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1583208845
   )
   public int field945 = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -340508673
   )
   public int field946 = -1;
   @ObfuscatedName("ac")
   boolean field947 = false;
   @ObfuscatedName("l")
   public static class166 field948;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1654576471
   )
   public int field949 = -1;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1890370439
   )
   int field950 = 128;
   @ObfuscatedName("o")
   static class192 field951 = new class192(30);
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1989106989
   )
   int field952 = 0;
   @ObfuscatedName("ax")
   public boolean field953 = true;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -74885653
   )
   int field954 = 0;
   @ObfuscatedName("ao")
   public boolean field955 = false;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 961741271
   )
   int field956 = 0;
   @ObfuscatedName("f")
   public static class192 field957 = new class192(500);
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1577197765
   )
   int field958 = 128;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -41749255
   )
   int field959 = -1;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -591187151
   )
   int field960 = -1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1410566287
   )
   public int field961 = 16;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1397305877
   )
   public int field962 = 0;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1420237335
   )
   public int field963 = 0;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1580346101
   )
   public int field964 = 0;
   @ObfuscatedName("av")
   public int[] field965;
   @ObfuscatedName("ey")
   static class78[] field966;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -479292991
   )
   public int field967 = -1;

   @ObfuscatedName("f")
   public static String method798(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var1 + var5] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class164.field2668[var6 - 128];
               if(0 == var7) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("l")
   void method799() {
      if(this.field936 == -1) {
         this.field936 = 0;
         if(this.field925 != null && (null == this.field926 || 10 == this.field926[0])) {
            this.field936 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.field944[var1] != null) {
               this.field936 = 1;
            }
         }
      }

      if(this.field917 == -1) {
         this.field917 = 0 != this.field934?1:0;
      }

   }

   @ObfuscatedName("a")
   void method800(class118 var1) {
      while(true) {
         int var2 = var1.method2453();
         if(0 == var2) {
            return;
         }

         this.method834(var1, var2);
      }
   }

   @ObfuscatedName("dy")
   static final void method801(String var0) {
      if(null != var0) {
         if((client.field559 < 100 || client.field412 == 1) && client.field559 < 400) {
            String var1 = class134.method2803(var0, client.field473);
            if(var1 != null) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < client.field559; ++var2) {
                  class7 var3 = client.field560[var2];
                  var4 = class134.method2803(var3.field139, client.field473);
                  if(var4 != null && var4.equals(var1)) {
                     class16.method186(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(var3.field136 != null) {
                     var5 = class134.method2803(var3.field136, client.field473);
                     if(null != var5 && var5.equals(var1)) {
                        class16.method186(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < client.field421; ++var2) {
                  class17 var6 = client.field557[var2];
                  var4 = class134.method2803(var6.field253, client.field473);
                  if(var4 != null && var4.equals(var1)) {
                     class16.method186(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(var6.field247 != null) {
                     var5 = class134.method2803(var6.field247, client.field473);
                     if(null != var5 && var5.equals(var1)) {
                        class16.method186(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(class134.method2803(class148.field2249.field48, client.field473).equals(var1)) {
                  class16.method186(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  client.field329.method2686(251);
                  client.field329.method2438(class36.method742(var0));
                  client.field329.method2444(var0);
               }
            }
         } else {
            class16.method186(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("m")
   public final boolean method803() {
      if(this.field925 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field925.length; ++var2) {
            var1 &= field940.method3216(this.field925[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("o")
   public final class84 method804(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.field926) {
         var7 = (long)((this.field924 << 10) + var2);
      } else {
         var7 = (long)((var1 << 3) + (this.field924 << 10) + var2);
      }

      Object var9 = (class84)field921.method3711(var7);
      if(null == var9) {
         class99 var10 = this.method837(var1, var2);
         if(null == var10) {
            return null;
         }

         if(!this.field943) {
            var9 = var10.method2169(64 + this.field916, this.field922 + 768, -50, -10, -50);
         } else {
            var10.field1733 = (short)(64 + this.field916);
            var10.field1734 = (short)(768 + this.field922);
            var10.method2202();
            var9 = var10;
         }

         field921.method3713((class203)var9, var7);
      }

      if(this.field943) {
         var9 = ((class99)var9).method2174();
      }

      if(this.field937 * -1 >= 0) {
         if(var9 instanceof class104) {
            var9 = ((class104)var9).method2311(var3, var4, var5, var6, true, this.field937 * -1);
         } else if(var9 instanceof class99) {
            var9 = ((class99)var9).method2184(var3, var4, var5, var6, this.field937 * -1);
         }
      }

      return (class84)var9;
   }

   @ObfuscatedName("h")
   public final class104 method805(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.field926) {
         var7 = (long)((this.field924 << 10) + var2);
      } else {
         var7 = (long)((this.field924 << 10) + (var1 << 3) + var2);
      }

      class104 var9 = (class104)field951.method3711(var7);
      if(var9 == null) {
         class99 var10 = this.method837(var1, var2);
         if(null == var10) {
            return null;
         }

         var9 = var10.method2169(64 + this.field916, this.field922 + 768, -50, -10, -50);
         field951.method3713(var9, var7);
      }

      if(this.field937 * -1 >= 0) {
         var9 = var9.method2311(var3, var4, var5, var6, true, this.field937 * -1);
      }

      return var9;
   }

   @ObfuscatedName("n")
   public final class104 method806(int var1, int var2, int[][] var3, int var4, int var5, int var6, class42 var7, int var8) {
      long var9;
      if(null == this.field926) {
         var9 = (long)((this.field924 << 10) + var2);
      } else {
         var9 = (long)(var2 + (this.field924 << 10) + (var1 << 3));
      }

      class104 var11 = (class104)field951.method3711(var9);
      if(var11 == null) {
         class99 var12 = this.method837(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method2169(this.field916 + 64, this.field922 + 768, -50, -10, -50);
         field951.method3713(var11, var9);
      }

      if(var7 == null && -1 == this.field937 * -1) {
         return var11;
      } else {
         if(null != var7) {
            var11 = var7.method872(var11, var8, var2);
         } else {
            var11 = var11.method2313(true);
         }

         if(this.field937 * -1 >= 0) {
            var11 = var11.method2311(var3, var4, var5, var6, false, this.field937 * -1);
         }

         return var11;
      }
   }

   @ObfuscatedName("f")
   static final void method807(class118 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class5.field81[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method2453();
            if(var7 == 0) {
               if(0 == var1) {
                  class5.field93[0][var2][var3] = -class9.method124(var4 + var2 + 932731, var3 + 556238 + var5) * 8;
               } else {
                  class5.field93[var1][var2][var3] = class5.field93[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(1 == var7) {
               int var8 = var0.method2453();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(0 == var1) {
                  class5.field93[0][var2][var3] = 8 * -var8;
               } else {
                  class5.field93[var1][var2][var3] = class5.field93[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class114.field1972[var1][var2][var3] = var0.method2454();
               class5.field84[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class5.field85[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class5.field81[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class5.field90[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method2453();
            if(0 == var7) {
               break;
            }

            if(1 == var7) {
               var0.method2453();
               break;
            }

            if(var7 <= 49) {
               var0.method2453();
            }
         }
      }

   }

   @ObfuscatedName("q")
   public boolean method809() {
      if(this.field920 == null) {
         return this.field967 != -1 || this.field965 != null;
      } else {
         for(int var1 = 0; var1 < this.field920.length; ++var1) {
            if(-1 != this.field920[var1]) {
               class40 var2 = class48.method996(this.field920[var1]);
               if(var2.field967 != -1 || var2.field965 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("f")
   public final boolean method822(int var1) {
      if(this.field926 != null) {
         for(int var4 = 0; var4 < this.field926.length; ++var4) {
            if(this.field926[var4] == var1) {
               return field940.method3216(this.field925[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(null == this.field925) {
         return true;
      } else if(10 != var1) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field925.length; ++var3) {
            var2 &= field940.method3216(this.field925[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("r")
   public final class40 method824() {
      int var1 = -1;
      if(this.field959 != -1) {
         var1 = class109.method2380(this.field959);
      } else if(this.field960 != -1) {
         var1 = class175.field2906[this.field960];
      }

      return var1 >= 0 && var1 < this.field920.length && this.field920[var1] != -1?class48.method996(this.field920[var1]):null;
   }

   @ObfuscatedName("i")
   void method834(class118 var1, int var2) {
      int var3;
      int var4;
      if(1 == var2) {
         var3 = var1.method2453();
         if(var3 > 0) {
            if(this.field925 != null && !field941) {
               var1.field1998 += var3 * 3;
            } else {
               this.field926 = new int[var3];
               this.field925 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field925[var4] = var1.method2455();
                  this.field926[var4] = var1.method2453();
               }
            }
         }
      } else if(var2 == 2) {
         this.field927 = var1.method2461();
      } else if(var2 == 5) {
         var3 = var1.method2453();
         if(var3 > 0) {
            if(null != this.field925 && !field941) {
               var1.field1998 += var3 * 2;
            } else {
               this.field926 = null;
               this.field925 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field925[var4] = var1.method2455();
               }
            }
         }
      } else if(14 == var2) {
         this.field932 = var1.method2453();
      } else if(15 == var2) {
         this.field933 = var1.method2453();
      } else if(var2 == 17) {
         this.field934 = 0;
         this.field918 = false;
      } else if(var2 == 18) {
         this.field918 = false;
      } else if(var2 == 19) {
         this.field936 = var1.method2453();
      } else if(var2 == 21) {
         this.field937 = 0;
      } else if(var2 == 22) {
         this.field943 = true;
      } else if(23 == var2) {
         this.field939 = true;
      } else if(24 == var2) {
         this.field949 = var1.method2455();
         if('\uffff' == this.field949) {
            this.field949 = -1;
         }
      } else if(var2 == 27) {
         this.field934 = 1;
      } else if(28 == var2) {
         this.field961 = var1.method2453();
      } else if(var2 == 29) {
         this.field916 = var1.method2454();
      } else if(39 == var2) {
         this.field922 = var1.method2454() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.field944[var2 - 30] = var1.method2461();
         if(this.field944[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field944[var2 - 30] = null;
         }
      } else if(40 == var2) {
         var3 = var1.method2453();
         this.field928 = new short[var3];
         this.field929 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field928[var4] = (short)var1.method2455();
            this.field929[var4] = (short)var1.method2455();
         }
      } else if(41 == var2) {
         var3 = var1.method2453();
         this.field930 = new short[var3];
         this.field931 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field930[var4] = (short)var1.method2455();
            this.field931[var4] = (short)var1.method2455();
         }
      } else if(60 == var2) {
         this.field945 = var1.method2455();
      } else if(var2 == 62) {
         this.field947 = true;
      } else if(var2 == 64) {
         this.field953 = false;
      } else if(var2 == 65) {
         this.field919 = var1.method2455();
      } else if(var2 == 66) {
         this.field950 = var1.method2455();
      } else if(var2 == 67) {
         this.field958 = var1.method2455();
      } else if(68 == var2) {
         this.field946 = var1.method2455();
      } else if(var2 == 69) {
         var1.method2453();
      } else if(var2 == 70) {
         this.field952 = var1.method2558();
      } else if(var2 == 71) {
         this.field956 = var1.method2558();
      } else if(72 == var2) {
         this.field954 = var1.method2558();
      } else if(var2 == 73) {
         this.field955 = true;
      } else if(74 == var2) {
         this.field942 = true;
      } else if(var2 == 75) {
         this.field917 = var1.method2453();
      } else if(77 == var2) {
         this.field959 = var1.method2455();
         if('\uffff' == this.field959) {
            this.field959 = -1;
         }

         this.field960 = var1.method2455();
         if(this.field960 == '\uffff') {
            this.field960 = -1;
         }

         var3 = var1.method2453();
         this.field920 = new int[1 + var3];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field920[var4] = var1.method2455();
            if('\uffff' == this.field920[var4]) {
               this.field920[var4] = -1;
            }
         }
      } else if(78 == var2) {
         this.field967 = var1.method2455();
         this.field962 = var1.method2453();
      } else if(79 == var2) {
         this.field963 = var1.method2455();
         this.field964 = var1.method2455();
         this.field962 = var1.method2453();
         var3 = var1.method2453();
         this.field965 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field965[var4] = var1.method2455();
         }
      } else if(81 == var2) {
         this.field937 = var1.method2453() * -256;
      }

   }

   @ObfuscatedName("k")
   final class99 method837(int var1, int var2) {
      class99 var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(this.field926 == null) {
         if(10 != var1) {
            return null;
         }

         if(this.field925 == null) {
            return null;
         }

         var4 = this.field947;
         if(2 == var1 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field925.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.field925[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (class99)field957.method3711((long)var7);
            if(var3 == null) {
               var3 = class99.method2237(field940, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2204();
               }

               field957.method3713(var3, (long)var7);
            }

            if(var5 > 1) {
               field923[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new class99(field923, var5);
         }
      } else {
         int var8 = -1;

         for(var5 = 0; var5 < this.field926.length; ++var5) {
            if(var1 == this.field926[var5]) {
               var8 = var5;
               break;
            }
         }

         if(-1 == var8) {
            return null;
         }

         var5 = this.field925[var8];
         boolean var9 = this.field947 ^ var2 > 3;
         if(var9) {
            var5 += 65536;
         }

         var3 = (class99)field957.method3711((long)var5);
         if(var3 == null) {
            var3 = class99.method2237(field940, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var9) {
               var3.method2204();
            }

            field957.method3713(var3, (long)var5);
         }
      }

      if(this.field919 == 128 && 128 == this.field950 && 128 == this.field958) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var10;
      if(this.field952 == 0 && this.field956 == 0 && this.field954 == 0) {
         var10 = false;
      } else {
         var10 = true;
      }

      class99 var11 = new class99(var3, 0 == var2 && !var4 && !var10, null == this.field928, null == this.field930, true);
      if(4 == var1 && var2 > 3) {
         var11.method2180(256);
         var11.method2181(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var11.method2203();
      } else if(var2 == 2) {
         var11.method2178();
      } else if(var2 == 3) {
         var11.method2205();
      }

      if(null != this.field928) {
         for(var7 = 0; var7 < this.field928.length; ++var7) {
            var11.method2189(this.field928[var7], this.field929[var7]);
         }
      }

      if(this.field930 != null) {
         for(var7 = 0; var7 < this.field930.length; ++var7) {
            var11.method2183(this.field930[var7], this.field931[var7]);
         }
      }

      if(var4) {
         var11.method2214(this.field919, this.field950, this.field958);
      }

      if(var10) {
         var11.method2181(this.field952, this.field956, this.field954);
      }

      return var11;
   }
}
