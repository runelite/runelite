import java.awt.Component;
import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class56 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -972520995
   )
   int field1179;
   @ObfuscatedName("x")
   static boolean field1180;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2055248489
   )
   int field1181 = 0;
   @ObfuscatedName("u")
   static class72 field1182;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1133301235
   )
   int field1184 = 32;
   @ObfuscatedName("c")
   class66 field1185;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 325357093
   )
   public static int field1186;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = -2109575224586842225L
   )
   long field1187 = class12.method162();
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = -651199953
   )
   static int field1188;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1205299537
   )
   int field1189;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -635092261
   )
   int field1190;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -6322237245812923229L
   )
   long field1191 = 0L;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 826726753
   )
   int field1192 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 882565307
   )
   int field1193 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1504702667
   )
   static int field1194;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -1856635810276952831L
   )
   long field1195 = 0L;
   @ObfuscatedName("g")
   boolean field1196 = true;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 880458607
   )
   int field1197 = 0;
   @ObfuscatedName("ad")
   class66[] field1198 = new class66[8];
   @ObfuscatedName("an")
   class66[] field1199 = new class66[8];
   @ObfuscatedName("k")
   int[] field1200;
   @ObfuscatedName("nq")
   @ObfuscatedGetter(
      intValue = 1622246149
   )
   static int field1202;
   @ObfuscatedName("pm")
   static GarbageCollectorMXBean field1203;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1669290877"
   )
   public final synchronized void method1148() {
      if(null != this.field1200) {
         long var1 = class12.method162();

         try {
            if(this.field1191 != 0L) {
               if(var1 < this.field1191) {
                  return;
               }

               this.vmethod1493(this.field1179);
               this.field1191 = 0L;
               this.field1196 = true;
            }

            int var3 = this.vmethod1510();
            if(this.field1192 - var3 > this.field1181) {
               this.field1181 = this.field1192 - var3;
            }

            int var4 = this.field1190 + this.field1189;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(256 + var4 > this.field1179) {
               this.field1179 += 1024;
               if(this.field1179 > 16384) {
                  this.field1179 = 16384;
               }

               this.vmethod1491();
               this.vmethod1493(this.field1179);
               var3 = 0;
               this.field1196 = true;
               if(var4 + 256 > this.field1179) {
                  var4 = this.field1179 - 256;
                  this.field1190 = var4 - this.field1189;
               }
            }

            while(var3 < var4) {
               this.method1155(this.field1200, 256);
               this.vmethod1495();
               var3 += 256;
            }

            if(var1 > this.field1195) {
               if(!this.field1196) {
                  if(0 == this.field1181 && 0 == this.field1193) {
                     this.vmethod1491();
                     this.field1191 = 2000L + var1;
                     return;
                  }

                  this.field1190 = Math.min(this.field1193, this.field1181);
                  this.field1193 = this.field1181;
               } else {
                  this.field1196 = false;
               }

               this.field1181 = 0;
               this.field1195 = var1 + 2000L;
            }

            this.field1192 = var3;
         } catch (Exception var6) {
            this.vmethod1491();
            this.field1191 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1187) {
               var1 = this.field1187;
            }

            while(var1 > this.field1187 + 5000L) {
               this.method1154(256);
               this.field1187 += (long)(256000 / field1186);
            }
         } catch (Exception var5) {
            this.field1187 = var1;
         }
      }

   }

   @ObfuscatedName("x")
   void vmethod1495() throws Exception {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "35"
   )
   public final void method1151() {
      this.field1196 = true;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2011582053"
   )
   public final synchronized void method1153() {
      if(field1182 != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == field1182.field1357[var2]) {
               field1182.field1357[var2] = null;
            }

            if(field1182.field1357[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            field1182.field1355 = true;

            while(field1182.field1356) {
               class116.method2448(50L);
            }

            field1182 = null;
         }
      }

      this.vmethod1491();
      this.field1200 = null;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "256"
   )
   final void method1154(int var1) {
      this.field1197 -= var1;
      if(this.field1197 < 0) {
         this.field1197 = 0;
      }

      if(null != this.field1185) {
         this.field1185.vmethod3707(var1);
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1155(int[] var1, int var2) {
      int var3 = var2;
      if(field1180) {
         var3 = var2 << 1;
      }

      class120.method2717(var1, 0, var3);
      this.field1197 -= var2;
      if(null != this.field1185 && this.field1197 <= 0) {
         this.field1197 += field1186 >> 4;
         class29.method644(this.field1185);
         this.method1156(this.field1185, this.field1185.vmethod1442());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class66 var7;
         label106:
         for(var6 = 7; var5 != 0; --var6) {
            int var8;
            int var9;
            if(var6 < 0) {
               var8 = var6 & 3;
               var9 = -(var6 >> 2);
            } else {
               var8 = var6;
               var9 = 0;
            }

            for(int var10 = var5 >>> var8 & 286331153; 0 != var10; var10 >>>= 4) {
               if(0 != (var10 & 1)) {
                  var5 &= ~(1 << var8);
                  var7 = null;
                  class66 var11 = this.field1198[var8];

                  label100:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label100;
                        }

                        class65 var12 = var11.field1271;
                        if(null != var12 && var12.field1268 > var9) {
                           var5 |= 1 << var8;
                           var7 = var11;
                           var11 = var11.field1272;
                        } else {
                           var11.field1269 = true;
                           int var13 = var11.vmethod3705();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1268 += var13;
                           }

                           if(var4 >= this.field1184) {
                              break label106;
                           }

                           class66 var14 = var11.vmethod3709();
                           if(var14 != null) {
                              for(int var15 = var11.field1270; null != var14; var14 = var11.vmethod3704()) {
                                 this.method1156(var14, var15 * var14.vmethod1442() >> 8);
                              }
                           }

                           class66 var18 = var11.field1272;
                           var11.field1272 = null;
                           if(null == var7) {
                              this.field1198[var8] = var18;
                           } else {
                              var7.field1272 = var18;
                           }

                           if(var18 == null) {
                              this.field1199[var8] = var7;
                           }

                           var11 = var18;
                        }
                     }
                  }
               }

               var8 += 4;
               ++var9;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class66 var16 = this.field1198[var6];
            class66[] var17 = this.field1198;
            this.field1199[var6] = null;

            for(var17[var6] = null; null != var16; var16 = var7) {
               var7 = var16.field1272;
               var16.field1272 = null;
            }
         }
      }

      if(this.field1197 < 0) {
         this.field1197 = 0;
      }

      if(this.field1185 != null) {
         this.field1185.vmethod3706(var1, 0, var2);
      }

      this.field1187 = class12.method162();
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Lclass66;II)V",
      garbageValue = "1530087195"
   )
   final void method1156(class66 var1, int var2) {
      int var3 = var2 >> 5;
      class66 var4 = this.field1199[var3];
      if(null == var4) {
         this.field1198[var3] = var1;
      } else {
         var4.field1272 = var1;
      }

      this.field1199[var3] = var1;
      var1.field1270 = var2;
   }

   @ObfuscatedName("s")
   void vmethod1492(Component var1) throws Exception {
   }

   @ObfuscatedName("p")
   int vmethod1510() throws Exception {
      return this.field1179;
   }

   @ObfuscatedName("d")
   void vmethod1491() {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass66;I)V",
      garbageValue = "-202835082"
   )
   public final synchronized void method1164(class66 var1) {
      this.field1185 = var1;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "44"
   )
   public final synchronized void method1172() {
      this.field1196 = true;

      try {
         this.vmethod1503();
      } catch (Exception var2) {
         this.vmethod1491();
         this.field1191 = class12.method162() + 2000L;
      }

   }

   @ObfuscatedName("j")
   void vmethod1493(int var1) throws Exception {
   }

   @ObfuscatedName("u")
   void vmethod1503() throws Exception {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass25;Lclass25;IZB)I",
      garbageValue = "-55"
   )
   static int method1195(class25 var0, class25 var1, int var2, boolean var3) {
      if(1 == var2) {
         int var4 = var0.field634;
         int var5 = var1.field634;
         if(!var3) {
            if(-1 == var4) {
               var4 = 2001;
            }

            if(-1 == var5) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return 2 == var2?var0.field637 - var1.field637:(3 == var2?(var0.field641.equals("-")?(var1.field641.equals("-")?0:(var3?-1:1)):(var1.field641.equals("-")?(var3?1:-1):var0.field641.compareTo(var1.field641))):(var2 == 4?(var0.method583()?(var1.method583()?0:1):(var1.method583()?-1:0)):(var2 == 5?(var0.method581()?(var1.method581()?0:1):(var1.method581()?-1:0)):(6 == var2?(var0.method582()?(var1.method582()?0:1):(var1.method582()?-1:0)):(7 == var2?(var0.method580()?(var1.method580()?0:1):(var1.method580()?-1:0)):var0.field632 - var1.field632)))));
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Lclass25;",
      garbageValue = "-557317571"
   )
   static class25 method1203() {
      return class25.field629 < class25.field628?class25.field636[++class25.field629 - 1]:null;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lclass33;B)V",
      garbageValue = "66"
   )
   static final void method1204(class33 var0) {
      if(class106.field1881.field823 >> 7 == client.field512 && class106.field1881.field813 >> 7 == client.field513) {
         client.field512 = 0;
      }

      int var1 = class32.field755;
      int[] var2 = class32.field756;
      int var3 = var1;
      if(var0 == class33.field773 || class33.field774 == var0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         class2 var5;
         int var6;
         if(var0 == class33.field773) {
            var5 = class106.field1881;
            var6 = class106.field1881.field42 << 14;
         } else if(var0 == class33.field774) {
            var5 = client.field491[client.field409];
            var6 = client.field409 << 14;
         } else {
            var5 = client.field491[var2[var4]];
            var6 = var2[var4] << 14;
            if(class33.field778 == var0 && client.field409 == var2[var4]) {
               continue;
            }
         }

         if(null != var5 && var5.vmethod727() && !var5.field58) {
            var5.field52 = false;
            if((client.field493 && var1 > 50 || var1 > 200) && var0 != class33.field773 && var5.field840 == var5.field817) {
               var5.field52 = true;
            }

            int var7 = var5.field823 >> 7;
            int var8 = var5.field813 >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.field54 != null && client.field335 >= var5.field51 && client.field335 < var5.field56) {
                  var5.field52 = false;
                  var5.field41 = class107.method2369(var5.field823, var5.field813, class21.field581);
                  client.field339.method2059(class21.field581, var5.field823, var5.field813, var5.field41, 60, var5, var5.field814, var6, var5.field48, var5.field38, var5.field47, var5.field33);
               } else {
                  if(64 == (var5.field823 & 127) && (var5.field813 & 127) == 64) {
                     if(client.field275 == client.field552[var7][var8]) {
                        continue;
                     }

                     client.field552[var7][var8] = client.field275;
                  }

                  var5.field41 = class107.method2369(var5.field823, var5.field813, class21.field581);
                  client.field339.method1906(class21.field581, var5.field823, var5.field813, var5.field41, 60, var5, var5.field814, var6, var5.field815);
               }
            }
         }
      }

   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1159881927"
   )
   static boolean method1205(int var0) {
      return 57 == var0 || 58 == var0 || var0 == 1007 || 25 == var0 || 30 == var0;
   }
}
