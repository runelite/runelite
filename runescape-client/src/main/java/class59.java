import java.awt.Component;
import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
public class class59 {
   @ObfuscatedName("ad")
   class69[] field1243 = new class69[8];
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1425610459
   )
   public static int field1245;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 8546141870945120533L
   )
   long field1246 = 0L;
   @ObfuscatedName("k")
   int[] field1248;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1351620327
   )
   int field1249;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2109772347
   )
   int field1250 = 32;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 5514715825372256687L
   )
   long field1251 = class56.method1249();
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1804335573
   )
   int field1252;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 198457741
   )
   int field1253;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1610977157
   )
   public static int field1254;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = 794988375
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("u")
   class69 field1256;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -865306279
   )
   int field1257 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1819669961
   )
   int field1258 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 4196916772016294509L
   )
   long field1259 = 0L;
   @ObfuscatedName("i")
   boolean field1260 = true;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 926452823
   )
   int field1262 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -727752395
   )
   int field1263 = 0;
   @ObfuscatedName("g")
   public static boolean field1264;
   @ObfuscatedName("c")
   class69[] field1265 = new class69[8];
   @ObfuscatedName("e")
   public static class187 field1266;
   @ObfuscatedName("cv")
   static class227 field1268;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-41"
   )
   public final void method1292() {
      this.field1260 = true;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-958305211"
   )
   public final synchronized void method1294() {
      if(this.field1248 != null) {
         long var1 = class56.method1249();

         try {
            if(0L != this.field1246) {
               if(var1 < this.field1246) {
                  return;
               }

               this.vmethod1628(this.field1252);
               this.field1246 = 0L;
               this.field1260 = true;
            }

            int var3 = this.vmethod1629();
            if(this.field1262 - var3 > this.field1258) {
               this.field1258 = this.field1262 - var3;
            }

            int var4 = this.field1249 + this.field1253;
            if(256 + var4 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.field1252) {
               this.field1252 += 1024;
               if(this.field1252 > 16384) {
                  this.field1252 = 16384;
               }

               this.vmethod1631();
               this.vmethod1628(this.field1252);
               var3 = 0;
               this.field1260 = true;
               if(var4 + 256 > this.field1252) {
                  var4 = this.field1252 - 256;
                  this.field1249 = var4 - this.field1253;
               }
            }

            while(var3 < var4) {
               this.method1299(this.field1248, 256);
               this.vmethod1630();
               var3 += 256;
            }

            if(var1 > this.field1259) {
               if(!this.field1260) {
                  if(this.field1258 == 0 && this.field1257 == 0) {
                     this.vmethod1631();
                     this.field1246 = var1 + 2000L;
                     return;
                  }

                  this.field1249 = Math.min(this.field1257, this.field1258);
                  this.field1257 = this.field1258;
               } else {
                  this.field1260 = false;
               }

               this.field1258 = 0;
               this.field1259 = var1 + 2000L;
            }

            this.field1262 = var3;
         } catch (Exception var6) {
            this.vmethod1631();
            this.field1246 = var1 + 2000L;
         }

         try {
            if(var1 > 500000L + this.field1251) {
               var1 = this.field1251;
            }

            while(var1 > this.field1251 + 5000L) {
               this.method1298(256);
               this.field1251 += (long)(256000 / field1254);
            }
         } catch (Exception var5) {
            this.field1251 = var1;
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "1052642261"
   )
   public static boolean method1295(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-50"
   )
   public final synchronized void method1296() {
      this.field1260 = true;

      try {
         this.vmethod1641();
      } catch (Exception var2) {
         this.vmethod1631();
         this.field1246 = class56.method1249() + 2000L;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1378454640"
   )
   final void method1298(int var1) {
      this.field1263 -= var1;
      if(this.field1263 < 0) {
         this.field1263 = 0;
      }

      if(null != this.field1256) {
         this.field1256.vmethod3874(var1);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1299(int[] var1, int var2) {
      int var3 = var2;
      if(field1264) {
         var3 = var2 << 1;
      }

      class123.method2862(var1, 0, var3);
      this.field1263 -= var2;
      if(this.field1256 != null && this.field1263 <= 0) {
         this.field1263 += field1254 >> 4;
         VertexNormal.method2284(this.field1256);
         this.method1340(this.field1256, this.field1256.vmethod1597());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class69 var7;
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

            for(int var10 = var5 >>> var8 & 286331153; var10 != 0; var10 >>>= 4) {
               if((var10 & 1) != 0) {
                  var5 &= ~(1 << var8);
                  var7 = null;
                  class69 var11 = this.field1265[var8];

                  label100:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label100;
                        }

                        class68 var12 = var11.field1334;
                        if(var12 != null && var12.field1333 > var9) {
                           var5 |= 1 << var8;
                           var7 = var11;
                           var11 = var11.field1337;
                        } else {
                           var11.field1336 = true;
                           int var13 = var11.vmethod3872();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1333 += var13;
                           }

                           if(var4 >= this.field1250) {
                              break label106;
                           }

                           class69 var14 = var11.vmethod3870();
                           if(null != var14) {
                              for(int var15 = var11.field1335; var14 != null; var14 = var11.vmethod3871()) {
                                 this.method1340(var14, var15 * var14.vmethod1597() >> 8);
                              }
                           }

                           class69 var18 = var11.field1337;
                           var11.field1337 = null;
                           if(var7 == null) {
                              this.field1265[var8] = var18;
                           } else {
                              var7.field1337 = var18;
                           }

                           if(var18 == null) {
                              this.field1243[var8] = var7;
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
            class69 var16 = this.field1265[var6];
            class69[] var17 = this.field1265;
            this.field1243[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var7) {
               var7 = var16.field1337;
               var16.field1337 = null;
            }
         }
      }

      if(this.field1263 < 0) {
         this.field1263 = 0;
      }

      if(null != this.field1256) {
         this.field1256.vmethod3873(var1, 0, var2);
      }

      this.field1251 = class56.method1249();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1522696766"
   )
   void vmethod1641() throws Exception {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1853955282"
   )
   void vmethod1628(int var1) throws Exception {
   }

   @ObfuscatedName("w")
   void vmethod1630() throws Exception {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   void vmethod1631() {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass69;I)V",
      garbageValue = "1352551102"
   )
   public final synchronized void method1317(class69 var1) {
      this.field1256 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2076797630"
   )
   public final synchronized void method1322() {
      if(null != class186.field3013) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(class186.field3013.field1424[var2] == this) {
               class186.field3013.field1424[var2] = null;
            }

            if(class186.field3013.field1424[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            class186.field3013.field1420 = true;

            while(class186.field3013.field1421) {
               class22.method594(50L);
            }

            class186.field3013 = null;
         }
      }

      this.vmethod1631();
      this.field1248 = null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1444420017"
   )
   void vmethod1627(Component var1) throws Exception {
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass69;II)V",
      garbageValue = "1915640811"
   )
   final void method1340(class69 var1, int var2) {
      int var3 = var2 >> 5;
      class69 var4 = this.field1243[var3];
      if(null == var4) {
         this.field1265[var3] = var1;
      } else {
         var4.field1337 = var1;
      }

      this.field1243[var3] = var1;
      var1.field1335 = var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "885303349"
   )
   int vmethod1629() throws Exception {
      return this.field1252;
   }
}
