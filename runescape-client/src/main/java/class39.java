import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
@Implements("NPCComposition")
public class class39 extends class204 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1006872441
   )
   public int field877 = -1;
   @ObfuscatedName("i")
   static class167 field878;
   @ObfuscatedName("g")
   public static class193 field879 = new class193(64);
   @ObfuscatedName("h")
   @Export("npcModelCache")
   public static class193 field880 = new class193(50);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1223950501
   )
   public int field881 = 1;
   @ObfuscatedName("d")
   int[] field882;
   @ObfuscatedName("x")
   @Export("isMinimapVisible")
   public boolean field883 = true;
   @ObfuscatedName("s")
   @Export("models")
   int[] field884;
   @ObfuscatedName("r")
   @Export("name")
   public String field885 = "null";
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1443652539
   )
   public int field886 = -1;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1393093063
   )
   int field887 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1553401949
   )
   public int field888 = -1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1717214879
   )
   public int field889 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 219738857
   )
   public int field890 = -1;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 490902627
   )
   public int field891 = -1;
   @ObfuscatedName("q")
   @Export("actions")
   public String[] field892 = new String[5];
   @ObfuscatedName("a")
   short[] field893;
   @ObfuscatedName("u")
   short[] field894;
   @ObfuscatedName("c")
   short[] field895;
   @ObfuscatedName("n")
   short[] field896;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1089567577
   )
   public int field897 = 32;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 10985755
   )
   public int field898 = -1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -27358977
   )
   @Export("combatLevel")
   public int field899 = -1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2048435889
   )
   int field900 = 128;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -962135815
   )
   int field901 = 128;
   @ObfuscatedName("e")
   @Export("isVisible")
   public boolean field902 = false;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 539335259
   )
   public int field903 = -1;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -557283681
   )
   int field904 = 0;
   @ObfuscatedName("t")
   static class167 field905;
   @ObfuscatedName("ai")
   @Export("isClickable")
   public boolean field906 = true;
   @ObfuscatedName("av")
   public int[] field907;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 2055795003
   )
   int field908 = -1;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1800919503
   )
   int field909 = -1;
   @ObfuscatedName("aq")
   public boolean field910 = true;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 62809461
   )
   @Export("id")
   public int field911;
   @ObfuscatedName("an")
   public boolean field912 = false;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1302887139
   )
   public int field913 = 30;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass42;ILclass42;IB)Lclass105;",
      garbageValue = "-5"
   )
   public final class105 method746(class42 var1, int var2, class42 var3, int var4) {
      if(null != this.field907) {
         class39 var12 = this.method752();
         return null == var12?null:var12.method746(var1, var2, var3, var4);
      } else {
         class105 var5 = (class105)field880.method3716((long)this.field911);
         if(var5 == null) {
            boolean var10 = false;

            for(int var7 = 0; var7 < this.field884.length; ++var7) {
               if(!field878.method3259(this.field884[var7], 0)) {
                  var10 = true;
               }
            }

            if(var10) {
               return null;
            }

            class100[] var8 = new class100[this.field884.length];

            int var9;
            for(var9 = 0; var9 < this.field884.length; ++var9) {
               var8[var9] = class100.method2172(field878, this.field884[var9], 0);
            }

            class100 var11;
            if(var8.length == 1) {
               var11 = var8[0];
            } else {
               var11 = new class100(var8, var8.length);
            }

            if(null != this.field893) {
               for(var9 = 0; var9 < this.field893.length; ++var9) {
                  var11.method2201(this.field893[var9], this.field894[var9]);
               }
            }

            if(this.field895 != null) {
               for(var9 = 0; var9 < this.field895.length; ++var9) {
                  var11.method2189(this.field895[var9], this.field896[var9]);
               }
            }

            var5 = var11.method2181(64 + this.field887, 850 + this.field904, -30, -50, -30);
            field880.method3724(var5, (long)this.field911);
         }

         class105 var6;
         if(null != var1 && null != var3) {
            var6 = var1.method855(var5, var2, var3, var4);
         } else if(null != var1) {
            var6 = var1.method848(var5, var2);
         } else if(var3 != null) {
            var6 = var3.method848(var5, var4);
         } else {
            var6 = var5.method2255(true);
         }

         if(this.field900 != 128 || this.field901 != 128) {
            var6.method2316(this.field900, this.field901, this.field900);
         }

         return var6;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "380419815"
   )
   void method748(class119 var1) {
      while(true) {
         int var2 = var1.method2494();
         if(var2 == 0) {
            return;
         }

         this.method749(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "52"
   )
   void method749(class119 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2494();
         this.field884 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field884[var4] = var1.method2470();
         }
      } else if(var2 == 2) {
         this.field885 = var1.method2476();
      } else if(var2 == 12) {
         this.field881 = var1.method2494();
      } else if(var2 == 13) {
         this.field886 = var1.method2470();
      } else if(var2 == 14) {
         this.field898 = var1.method2470();
      } else if(var2 == 15) {
         this.field877 = var1.method2470();
      } else if(var2 == 16) {
         this.field888 = var1.method2470();
      } else if(var2 == 17) {
         this.field898 = var1.method2470();
         this.field890 = var1.method2470();
         this.field889 = var1.method2470();
         this.field903 = var1.method2470();
      } else if(var2 >= 30 && var2 < 35) {
         this.field892[var2 - 30] = var1.method2476();
         if(this.field892[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field892[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2494();
         this.field893 = new short[var3];
         this.field894 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field893[var4] = (short)var1.method2470();
            this.field894[var4] = (short)var1.method2470();
         }
      } else if(var2 == 41) {
         var3 = var1.method2494();
         this.field895 = new short[var3];
         this.field896 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field895[var4] = (short)var1.method2470();
            this.field896[var4] = (short)var1.method2470();
         }
      } else if(var2 == 60) {
         var3 = var1.method2494();
         this.field882 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field882[var4] = var1.method2470();
         }
      } else if(var2 == 93) {
         this.field883 = false;
      } else if(var2 == 95) {
         this.field899 = var1.method2470();
      } else if(var2 == 97) {
         this.field900 = var1.method2470();
      } else if(var2 == 98) {
         this.field901 = var1.method2470();
      } else if(var2 == 99) {
         this.field902 = true;
      } else if(var2 == 100) {
         this.field887 = var1.method2469();
      } else if(var2 == 101) {
         this.field904 = var1.method2469() * 5;
      } else if(var2 == 102) {
         this.field891 = var1.method2470();
      } else if(var2 == 103) {
         this.field897 = var1.method2470();
      } else if(var2 == 106) {
         this.field908 = var1.method2470();
         if(this.field908 == '\uffff') {
            this.field908 = -1;
         }

         this.field909 = var1.method2470();
         if(this.field909 == '\uffff') {
            this.field909 = -1;
         }

         var3 = var1.method2494();
         this.field907 = new int[var3 + 1];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field907[var4] = var1.method2470();
            if(this.field907[var4] == '\uffff') {
               this.field907[var4] = -1;
            }
         }
      } else if(var2 == 107) {
         this.field910 = false;
      } else if(var2 == 109) {
         this.field906 = false;
      } else if(var2 == 111) {
         this.field912 = true;
      } else if(var2 == 112) {
         this.field913 = var1.method2494();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)Lclass100;",
      garbageValue = "105"
   )
   public final class100 method751() {
      if(null != this.field907) {
         class39 var5 = this.method752();
         return var5 == null?null:var5.method751();
      } else if(this.field882 == null) {
         return null;
      } else {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.field882.length; ++var2) {
            if(!field878.method3259(this.field882[var2], 0)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            class100[] var7 = new class100[this.field882.length];

            for(int var6 = 0; var6 < this.field882.length; ++var6) {
               var7[var6] = class100.method2172(field878, this.field882[var6], 0);
            }

            class100 var3;
            if(var7.length == 1) {
               var3 = var7[0];
            } else {
               var3 = new class100(var7, var7.length);
            }

            int var4;
            if(null != this.field893) {
               for(var4 = 0; var4 < this.field893.length; ++var4) {
                  var3.method2201(this.field893[var4], this.field894[var4]);
               }
            }

            if(null != this.field895) {
               for(var4 = 0; var4 < this.field895.length; ++var4) {
                  var3.method2189(this.field895[var4], this.field896[var4]);
               }
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Lclass39;",
      garbageValue = "0"
   )
   public final class39 method752() {
      int var1 = -1;
      if(this.field908 != -1) {
         var1 = class13.method144(this.field908);
      } else if(this.field909 != -1) {
         var1 = class176.field2923[this.field909];
      }

      return var1 >= 0 && var1 < this.field907.length && this.field907[var1] != -1?class17.method169(this.field907[var1]):null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-152627819"
   )
   public boolean method766() {
      if(this.field907 == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.field908 != -1) {
            var1 = class13.method144(this.field908);
         } else if(this.field909 != -1) {
            var1 = class176.field2923[this.field909];
         }

         return var1 >= 0 && var1 < this.field907.length && this.field907[var1] != -1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-1487880817"
   )
   public static File method775(String var0) {
      if(!class135.field2107) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class135.field2109.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class135.field2103, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class135.field2109.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-248980016"
   )
   void method782() {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-50"
   )
   static final boolean method783(char var0) {
      return var0 == 160 || var0 == 32 || var0 == 95 || var0 == 45;
   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(IIII)Lclass3;",
      garbageValue = "-1577818473"
   )
   static final class3 method785(int var0, int var1, int var2) {
      class3 var3 = new class3();
      var3.field65 = var1;
      var3.field64 = var2;
      client.field443.method3749(var3, (long)var0);
      int var5;
      if(class173.method3380(var1)) {
         class173[] var4 = class216.field3168[var1];

         for(var5 = 0; var5 < var4.length; ++var5) {
            class173 var6 = var4[var5];
            if(null != var6) {
               var6.field2898 = 0;
               var6.field2767 = 0;
            }
         }
      }

      class173 var10 = class170.method3344(var0);
      class20.method547(var10);
      if(client.field399 != null) {
         class20.method547(client.field399);
         client.field399 = null;
      }

      for(var5 = 0; var5 < client.field294; ++var5) {
         int var7 = client.field392[var5];
         boolean var9 = var7 == 57 || var7 == 58 || var7 == 1007 || var7 == 25 || var7 == 30;
         if(var9) {
            if(var5 < client.field294 - 1) {
               for(int var8 = var5; var8 < client.field294 - 1; ++var8) {
                  client.field429[var8] = client.field429[1 + var8];
                  client.field337[var8] = client.field337[var8 + 1];
                  client.field392[var8] = client.field392[var8 + 1];
                  client.field502[var8] = client.field502[var8 + 1];
                  client.field425[var8] = client.field425[var8 + 1];
                  client.field426[var8] = client.field426[1 + var8];
               }
            }

            --client.field294;
         }
      }

      class46.method935(class216.field3168[var0 >> 16], var10, false);
      class93.method2123(var1);
      if(client.field442 != -1) {
         var5 = client.field442;
         if(class173.method3380(var5)) {
            class13.method140(class216.field3168[var5], 1);
         }
      }

      return var3;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-217573893"
   )
   public static int method786(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }
}
