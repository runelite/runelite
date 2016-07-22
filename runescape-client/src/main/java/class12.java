import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class12 extends class88 {
   @ObfuscatedName("pf")
   static class8 field162;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -243794429
   )
   int field163;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1915320345
   )
   int field164;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1063249105
   )
   int field165;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 400727107
   )
   int field166;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1691272571
   )
   int field168;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1486043359
   )
   int field169;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2050729585
   )
   int field170;
   @ObfuscatedName("cm")
   static class227 field171;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -860527121
   )
   int field172;
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = 421022207
   )
   public static int field174;
   @ObfuscatedName("j")
   class44 field175;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Lclass27;",
      garbageValue = "1618936468"
   )
   static class27 method143() {
      class27.field661 = 0;
      return class32.method678();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lclass108;",
      garbageValue = "-990594109"
   )
   protected final class108 vmethod1992() {
      if(null != this.field175) {
         int var1 = client.field282 - this.field170;
         if(var1 > 100 && this.field175.field1013 > 0) {
            var1 = 100;
         }

         label67: {
            do {
               do {
                  if(var1 <= this.field175.field1011[this.field169]) {
                     break label67;
                  }

                  var1 -= this.field175.field1011[this.field169];
                  ++this.field169;
               } while(this.field169 < this.field175.field1009.length);

               this.field169 -= this.field175.field1013;
            } while(this.field169 >= 0 && this.field169 < this.field175.field1009.length);

            this.field175 = null;
         }

         this.field170 = client.field282 - var1;
      }

      class42 var12 = class7.method100(this.field168);
      if(null != var12.field983) {
         var12 = var12.method851();
      }

      if(null == var12) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field164 != 1 && this.field164 != 3) {
            var2 = var12.field976;
            var3 = var12.field980;
         } else {
            var2 = var12.field980;
            var3 = var12.field976;
         }

         int var4 = (var2 >> 1) + this.field166;
         int var5 = this.field166 + (var2 + 1 >> 1);
         int var6 = this.field172 + (var3 >> 1);
         int var7 = this.field172 + (1 + var3 >> 1);
         int[][] var8 = class5.field77[this.field165];
         int var9 = var8[var4][var7] + var8[var5][var6] + var8[var4][var6] + var8[var5][var7] >> 2;
         int var10 = (var2 << 6) + (this.field166 << 7);
         int var11 = (this.field172 << 7) + (var3 << 6);
         return var12.method859(this.field163, this.field164, var8, var10, var9, var11, this.field175, this.field169);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1285857818"
   )
   static final void method147(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var1 + var3; ++var4) {
         for(int var5 = var0; var5 <= var2 + var0; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class78.field1455[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class5.field77[0][var5][var4] = class5.field77[0][var5 - 1][var4];
               }

               if(var5 == var2 + var0 && var5 < 103) {
                  class5.field77[0][var5][var4] = class5.field77[0][1 + var5][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class5.field77[0][var5][var4] = class5.field77[0][var5][var4 - 1];
               }

               if(var4 == var1 + var3 && var4 < 103) {
                  class5.field77[0][var5][var4] = class5.field77[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "2047"
   )
   static final void method149() {
      for(class16 var0 = (class16)client.field369.method3882(); var0 != null; var0 = (class16)client.field369.method3891()) {
         if(var0.field221 > 0) {
            --var0.field221;
         }

         if(var0.field221 == 0) {
            if(var0.field214 < 0 || class138.method2930(var0.field214, var0.field211)) {
               class40.method788(var0.field213, var0.field208, var0.field209, var0.field210, var0.field214, var0.field212, var0.field211);
               var0.method3990();
            }
         } else {
            if(var0.field217 > 0) {
               --var0.field217;
            }

            if(var0.field217 == 0 && var0.field209 >= 1 && var0.field210 >= 1 && var0.field209 <= 102 && var0.field210 <= 102 && (var0.field218 < 0 || class138.method2930(var0.field218, var0.field207))) {
               class40.method788(var0.field213, var0.field208, var0.field209, var0.field210, var0.field218, var0.field215, var0.field207);
               var0.field217 = -1;
               if(var0.field218 == var0.field214 && var0.field214 == -1) {
                  var0.method3990();
               } else if(var0.field218 == var0.field214 && var0.field215 == var0.field212 && var0.field207 == var0.field211) {
                  var0.method3990();
               }
            }
         }
      }

   }

   class12(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, class88 var9) {
      this.field168 = var1;
      this.field163 = var2;
      this.field164 = var3;
      this.field165 = var4;
      this.field166 = var5;
      this.field172 = var6;
      if(var7 != -1) {
         this.field175 = class28.method646(var7);
         this.field169 = 0;
         this.field170 = client.field282 - 1;
         if(this.field175.field1022 == 0 && null != var9 && var9 instanceof class12) {
            class12 var10 = (class12)var9;
            if(this.field175 == var10.field175) {
               this.field169 = var10.field169;
               this.field170 = var10.field170;
               return;
            }
         }

         if(var8 && this.field175.field1013 != -1) {
            this.field169 = (int)(Math.random() * (double)this.field175.field1009.length);
            this.field170 -= (int)(Math.random() * (double)this.field175.field1011[this.field169]);
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "671335098"
   )
   public static void method150() {
      class55.field1178.method3814();
      class55.field1203.method3814();
      class55.field1180.method3814();
   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(Lclass176;I)I",
      garbageValue = "967937931"
   )
   static int method151(class176 var0) {
      class204 var1 = (class204)client.field472.method3856((long)var0.field2796 + ((long)var0.field2795 << 32));
      return var1 != null?var1.field3152:var0.field2867;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(CB)B",
      garbageValue = "76"
   )
   public static byte method153(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
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

      return var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "123"
   )
   public static int method154(int var0) {
      class50 var1 = class7.method103(var0);
      int var2 = var1.field1112;
      int var3 = var1.field1107;
      int var4 = var1.field1106;
      int var5 = class179.field2952[var4 - var3];
      return class179.field2949[var2] >> var3 & var5;
   }
}
