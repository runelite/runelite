import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
public class class57 {
   @ObfuscatedName("j")
   int[] field1050;
   @ObfuscatedName("v")
   static class63 field1051;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -637464807
   )
   public static int field1052;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -596736845
   )
   public static int field1053;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 464723417
   )
   int field1055 = 0;
   @ObfuscatedName("m")
   class68 field1056;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1006909413
   )
   int field1057 = 32;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -913113067
   )
   int field1058;
   @ObfuscatedName("n")
   public static boolean field1059;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1795591085
   )
   int field1060 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1894904995
   )
   int field1061;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = -1916429120631009919L
   )
   long field1062 = 0L;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1206303205
   )
   int field1063 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -6066551241638454691L
   )
   long field1065 = WallObject.method1985();
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 2610472989009132777L
   )
   long field1066 = 0L;
   @ObfuscatedName("l")
   boolean field1067 = true;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 125688217
   )
   int field1069;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -902933535
   )
   int field1070 = 0;
   @ObfuscatedName("t")
   class68[] field1071 = new class68[8];
   @ObfuscatedName("ab")
   class68[] field1072 = new class68[8];
   @ObfuscatedName("qc")
   @Export("bufferProvider")
   public static BufferProvider bufferProvider;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass68;B)V",
      garbageValue = "44"
   )
   public final synchronized void method1122(class68 var1) {
      this.field1056 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "751621668"
   )
   public final synchronized void method1123() {
      if(null != this.field1050) {
         long var1 = WallObject.method1985();

         try {
            if(0L != this.field1062) {
               if(var1 < this.field1062) {
                  return;
               }

               this.vmethod1199(this.field1058);
               this.field1062 = 0L;
               this.field1067 = true;
            }

            int var3 = this.vmethod1204();
            if(this.field1055 - var3 > this.field1063) {
               this.field1063 = this.field1055 - var3;
            }

            int var4 = this.field1069 + this.field1061;
            if(256 + var4 > 16384) {
               var4 = 16128;
            }

            if(256 + var4 > this.field1058) {
               this.field1058 += 1024;
               if(this.field1058 > 16384) {
                  this.field1058 = 16384;
               }

               this.vmethod1202();
               this.vmethod1199(this.field1058);
               var3 = 0;
               this.field1067 = true;
               if(256 + var4 > this.field1058) {
                  var4 = this.field1058 - 256;
                  this.field1061 = var4 - this.field1069;
               }
            }

            while(var3 < var4) {
               this.method1128(this.field1050, 256);
               this.vmethod1201();
               var3 += 256;
            }

            if(var1 > this.field1066) {
               if(!this.field1067) {
                  if(this.field1063 == 0 && this.field1060 == 0) {
                     this.vmethod1202();
                     this.field1062 = var1 + 2000L;
                     return;
                  }

                  this.field1061 = Math.min(this.field1060, this.field1063);
                  this.field1060 = this.field1063;
               } else {
                  this.field1067 = false;
               }

               this.field1063 = 0;
               this.field1066 = 2000L + var1;
            }

            this.field1055 = var3;
         } catch (Exception var7) {
            this.vmethod1202();
            this.field1062 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1065) {
               var1 = this.field1065;
            }

            while(var1 > 5000L + this.field1065) {
               this.method1144(256);
               this.field1065 += (long)(256000 / field1053);
            }
         } catch (Exception var6) {
            this.field1065 = var1;
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1541212641"
   )
   public final synchronized void method1125() {
      this.field1067 = true;

      try {
         this.vmethod1203();
      } catch (Exception var2) {
         this.vmethod1202();
         this.field1062 = WallObject.method1985() + 2000L;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "436580386"
   )
   public final synchronized void method1126() {
      if(null != field1051) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == field1051.field1101[var2]) {
               field1051.field1101[var2] = null;
            }

            if(null != field1051.field1101[var2]) {
               var1 = false;
            }
         }

         if(var1) {
            field1051.field1102 = true;

            while(field1051.field1103) {
               class47.method970(50L);
            }

            field1051 = null;
         }
      }

      this.vmethod1202();
      this.field1050 = null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1128(int[] var1, int var2) {
      int var3 = var2;
      if(field1059) {
         var3 = var2 << 1;
      }

      class163.method3197(var1, 0, var3);
      this.field1070 -= var2;
      if(this.field1056 != null && this.field1070 <= 0) {
         this.field1070 += field1053 >> 4;
         class47.method968(this.field1056);
         this.method1129(this.field1056, this.field1056.vmethod1436());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class68 var10;
         label140:
         for(var6 = 7; var5 != 0; --var6) {
            int var7;
            int var8;
            if(var6 < 0) {
               var7 = var6 & 3;
               var8 = -(var6 >> 2);
            } else {
               var7 = var6;
               var8 = 0;
            }

            for(int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  class68 var11 = this.field1071[var7];

                  label134:
                  while(true) {
                     while(true) {
                        if(null == var11) {
                           break label134;
                        }

                        class71 var12 = var11.field1159;
                        if(var12 != null && var12.field1190 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1158;
                        } else {
                           var11.field1156 = true;
                           int var13 = var11.vmethod2767();
                           var4 += var13;
                           if(null != var12) {
                              var12.field1190 += var13;
                           }

                           if(var4 >= this.field1057) {
                              break label140;
                           }

                           class68 var14 = var11.vmethod2765();
                           if(null != var14) {
                              for(int var16 = var11.field1157; null != var14; var14 = var11.vmethod2775()) {
                                 this.method1129(var14, var16 * var14.vmethod1436() >> 8);
                              }
                           }

                           class68 var15 = var11.field1158;
                           var11.field1158 = null;
                           if(null == var10) {
                              this.field1071[var7] = var15;
                           } else {
                              var10.field1158 = var15;
                           }

                           if(var15 == null) {
                              this.field1072[var7] = var10;
                           }

                           var11 = var15;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class68 var17 = this.field1071[var6];
            class68[] var18 = this.field1071;
            this.field1072[var6] = null;

            for(var18[var6] = null; var17 != null; var17 = var10) {
               var10 = var17.field1158;
               var17.field1158 = null;
            }
         }
      }

      if(this.field1070 < 0) {
         this.field1070 = 0;
      }

      if(null != this.field1056) {
         this.field1056.vmethod2780(var1, 0, var2);
      }

      this.field1065 = WallObject.method1985();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass68;IB)V",
      garbageValue = "-119"
   )
   final void method1129(class68 var1, int var2) {
      int var3 = var2 >> 5;
      class68 var4 = this.field1072[var3];
      if(null == var4) {
         this.field1071[var3] = var1;
      } else {
         var4.field1158 = var1;
      }

      this.field1072[var3] = var1;
      var1.field1157 = var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "506438239"
   )
   void vmethod1198(Component var1) throws Exception {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "333530633"
   )
   int vmethod1204() throws Exception {
      return this.field1058;
   }

   @ObfuscatedName("b")
   void vmethod1201() throws Exception {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-414252588"
   )
   void vmethod1202() {
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1087122673"
   )
   void vmethod1203() throws Exception {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1962420274"
   )
   void vmethod1199(int var1) throws Exception {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-4"
   )
   final void method1144(int var1) {
      this.field1070 -= var1;
      if(this.field1070 < 0) {
         this.field1070 = 0;
      }

      if(null != this.field1056) {
         this.field1056.vmethod2769(var1);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1972711585"
   )
   public final void method1153() {
      this.field1067 = true;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1326497615"
   )
   public static int method1161() {
      return ++class115.mouseIdleTicks - 1;
   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(LWidget;B)LWidget;",
      garbageValue = "-93"
   )
   static Widget method1164(Widget var0) {
      Widget var2 = var0;
      int var4 = MessageNode.method220(var0);
      int var3 = var4 >> 17 & 7;
      int var5 = var3;
      Widget var1;
      if(var3 == 0) {
         var1 = null;
      } else {
         int var6 = 0;

         while(true) {
            if(var6 >= var5) {
               var1 = var2;
               break;
            }

            var2 = ChatLineBuffer.method993(var2.parentId);
            if(null == var2) {
               var1 = null;
               break;
            }

            ++var6;
         }
      }

      Widget var7 = var1;
      if(var1 == null) {
         var7 = var0.parent;
      }

      return var7;
   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass164;I)V",
      garbageValue = "1880744110"
   )
   static final void method1177(int var0, int var1, int var2, int var3, SpritePixels var4, class164 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle + Client.mapScale & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class84.field1460[var6];
            int var9 = class84.field1446[var6];
            var8 = var8 * 256 / (256 + Client.mapScaleDelta);
            var9 = var9 * 256 / (256 + Client.mapScaleDelta);
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var3 * var9 - var2 * var8 >> 16;
            if(var7 > 2500) {
               var4.method4246(var10 + var5.field2160 / 2 - var4.maxWidth / 2, var5.field2155 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2160, var5.field2155, var5.field2157, var5.field2156);
            } else {
               var4.method4174(var5.field2160 / 2 + var0 + var10 - var4.maxWidth / 2, var5.field2155 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-777641476"
   )
   static long method1178() {
      try {
         URL var0 = new URL(class0.method11("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         Buffer var4 = new Buffer(new byte[1000]);

         do {
            int var5 = var3.read(var4.payload, var4.offset, 1000 - var4.offset);
            if(var5 == -1) {
               var4.offset = 0;
               long var7 = var4.method2892();
               return var7;
            }

            var4.offset += var5;
         } while(var4.offset < 1000);

         return 0L;
      } catch (Exception var9) {
         return 0L;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IB)Ljava/io/File;",
      garbageValue = "65"
   )
   public static File method1179(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class104.field1692 = new File(MessageNode.field229, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      File var22;
      if(class104.field1692.exists()) {
         try {
            FileOnDisk var7 = new FileOnDisk(class104.field1692, "rw", 10000L);

            Buffer var8;
            int var9;
            for(var8 = new Buffer((int)var7.method1489()); var8.offset < var8.payload.length; var8.offset += var9) {
               var9 = var7.method1490(var8.payload, var8.offset, var8.payload.length - var8.offset);
               if(var9 == -1) {
                  throw new IOException();
               }
            }

            var8.offset = 0;
            var9 = var8.readUnsignedByte();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.readUnsignedByte();
            }

            if(var9 <= 2) {
               var4 = var8.method2895();
               if(var10 == 1) {
                  var5 = var8.method2895();
               }
            } else {
               var4 = var8.method2896();
               if(var10 == 1) {
                  var5 = var8.method2896();
               }
            }

            var7.method1488();
         } catch (IOException var20) {
            var20.printStackTrace();
         }

         if(null != var4) {
            var22 = new File(var4);
            if(!var22.exists()) {
               var4 = null;
            }
         }

         if(var4 != null) {
            var22 = new File(var4, "test.dat");
            if(!Player.method255(var22, true)) {
               var4 = null;
            }
         }
      }

      if(null == var4 && var2 == 0) {
         label123:
         for(int var15 = 0; var15 < class9.field77.length; ++var15) {
            for(int var16 = 0; var16 < class176.field2655.length; ++var16) {
               File var17 = new File(class176.field2655[var16] + class9.field77[var15] + File.separatorChar + var0 + File.separatorChar);
               if(var17.exists() && Player.method255(new File(var17, "test.dat"), true)) {
                  var4 = var17.toString();
                  var6 = true;
                  break label123;
               }
            }
         }
      }

      if(var4 == null) {
         var4 = MessageNode.field229 + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      if(null != var5) {
         File var21 = new File(var5);
         var22 = new File(var4);

         try {
            File[] var23 = var21.listFiles();
            File[] var18 = var23;

            for(int var11 = 0; var11 < var18.length; ++var11) {
               File var12 = var18[var11];
               File var13 = new File(var22, var12.getName());
               boolean var14 = var12.renameTo(var13);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var19) {
            var19.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         class30.method705(new File(var4), (File)null);
      }

      return new File(var4);
   }
}
