import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class45 extends class207 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1278527581
   )
   int field1042 = 0;
   @ObfuscatedName("c")
   static class196 field1043 = new class196(64);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1032453613
   )
   int field1044 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1106182103
   )
   int field1045;
   @ObfuscatedName("i")
   short[] field1046;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 258010907
   )
   public int field1047 = -1;
   @ObfuscatedName("u")
   short[] field1048;
   @ObfuscatedName("o")
   short[] field1049;
   @ObfuscatedName("p")
   short[] field1050;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -513530607
   )
   int field1051 = 128;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1051478781
   )
   int field1052 = 128;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1396330011
   )
   int field1053;
   @ObfuscatedName("h")
   static class196 field1054 = new class196(30);
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1019715639
   )
   int field1055 = 0;
   @ObfuscatedName("e")
   static class170 field1056;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-1443194873"
   )
   public static String method961(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class164.field2684[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class164.field2684[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class164.field2684[(var6 & 15) << 2 | var7 >>> 6]).append(class164.field2684[var7 & 63]);
            } else {
               var3.append(class164.field2684[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class164.field2684[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "-909244283"
   )
   void method962(class122 var1) {
      while(true) {
         int var2 = var1.method2610();
         if(var2 == 0) {
            return;
         }

         this.method963(var1, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "1997296912"
   )
   void method963(class122 var1, int var2) {
      if(var2 == 1) {
         this.field1053 = var1.method2612();
      } else if(var2 == 2) {
         this.field1047 = var1.method2612();
      } else if(var2 == 4) {
         this.field1052 = var1.method2612();
      } else if(var2 == 5) {
         this.field1051 = var1.method2612();
      } else if(var2 == 6) {
         this.field1042 = var1.method2612();
      } else if(var2 == 7) {
         this.field1044 = var1.method2610();
      } else if(var2 == 8) {
         this.field1055 = var1.method2610();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2610();
            this.field1048 = new short[var3];
            this.field1049 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1048[var4] = (short)var1.method2612();
               this.field1049[var4] = (short)var1.method2612();
            }
         } else if(var2 == 41) {
            var3 = var1.method2610();
            this.field1050 = new short[var3];
            this.field1046 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1050[var4] = (short)var1.method2612();
               this.field1046[var4] = (short)var1.method2612();
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)Lclass108;",
      garbageValue = "0"
   )
   public final class108 method964(int var1) {
      class108 var2 = (class108)field1054.method3834((long)this.field1045);
      if(var2 == null) {
         class103 var3 = class103.method2311(class106.field1846, this.field1053, 0);
         if(null == var3) {
            return null;
         }

         int var4;
         if(null != this.field1048) {
            for(var4 = 0; var4 < this.field1048.length; ++var4) {
               var3.method2350(this.field1048[var4], this.field1049[var4]);
            }
         }

         if(this.field1050 != null) {
            for(var4 = 0; var4 < this.field1050.length; ++var4) {
               var3.method2301(this.field1050[var4], this.field1046[var4]);
            }
         }

         var2 = var3.method2308(this.field1044 + 64, this.field1055 + 850, -30, -50, -30);
         field1054.method3836(var2, (long)this.field1045);
      }

      class108 var5;
      if(this.field1047 != -1 && var1 != -1) {
         var5 = class13.method153(this.field1047).method921(var2, var1);
      } else {
         var5 = var2.method2446(true);
      }

      if(this.field1052 != 128 || this.field1051 != 128) {
         var5.method2404(this.field1052, this.field1051, this.field1052);
      }

      if(this.field1042 != 0) {
         if(this.field1042 == 90) {
            var5.method2387();
         }

         if(this.field1042 == 180) {
            var5.method2387();
            var5.method2387();
         }

         if(this.field1042 == 270) {
            var5.method2387();
            var5.method2387();
            var5.method2387();
         }
      }

      return var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-91"
   )
   static void method976() {
      class5.field80 = null;
      class5.field91 = null;
      class219.field3204 = null;
      class5.field81 = null;
      class133.field2117 = null;
      class5.field83 = null;
      class1.field25 = null;
      class5.field84 = null;
      class5.field85 = null;
      class8.field155 = null;
      class225.field3228 = null;
      class32.field752 = null;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "217"
   )
   static final void method979(int var0, int var1) {
      if(client.field435 >= 2 || client.field459 != 0 || client.field448) {
         String var2;
         if(client.field459 == 1 && client.field435 < 2) {
            var2 = "Use" + " " + client.field447 + " " + "->";
         } else if(client.field448 && client.field435 < 2) {
            var2 = client.field452 + " " + client.field369 + " " + "->";
         } else {
            var2 = class146.method3106(client.field435 - 1);
         }

         if(client.field435 > 2) {
            var2 = var2 + class117.method2530(16777215) + " " + '/' + " " + (client.field435 - 2) + " more options";
         }

         class146.field2233.method4120(var2, 4 + var0, 15 + var1, 16777215, 0, client.field567 / 1000);
      }
   }

   @ObfuscatedName("el")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-46"
   )
   static final void method982(String var0) {
      if(null != class22.field603) {
         client.field336.method2854(66);
         client.field336.method2795(class29.method650(var0));
         client.field336.method2601(var0);
      }
   }
}
