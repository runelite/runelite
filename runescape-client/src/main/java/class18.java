import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public class class18 {
   @ObfuscatedName("k")
   static int[] field250;
   @ObfuscatedName("g")
   class146 field251;
   @ObfuscatedName("h")
   DataInputStream field252;
   @ObfuscatedName("i")
   byte[] field253 = new byte[4];
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1389060797
   )
   int field254;
   @ObfuscatedName("r")
   byte[] field255;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1774462409
   )
   int field256;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 2628989330436999179L
   )
   long field257;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1812357917
   )
   int field262;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "-26"
   )
   byte[] method172() throws IOException {
      if(class124.method2746() > this.field257) {
         throw new IOException();
      } else {
         if(this.field262 == 0) {
            if(this.field251.field2249 == 2) {
               throw new IOException();
            }

            if(this.field251.field2249 == 1) {
               this.field252 = (DataInputStream)this.field251.field2246;
               this.field262 = 1;
            }
         }

         int var1;
         if(this.field262 == 1) {
            var1 = this.field252.available();
            if(var1 > 0) {
               if(var1 + this.field254 > 4) {
                  var1 = 4 - this.field254;
               }

               this.field254 += this.field252.read(this.field253, this.field254, var1);
               if(this.field254 == 4) {
                  int var2 = (new class119(this.field253)).method2505();
                  this.field255 = new byte[var2];
                  this.field262 = 2;
               }
            }
         }

         if(this.field262 == 2) {
            var1 = this.field252.available();
            if(var1 > 0) {
               if(var1 + this.field256 > this.field255.length) {
                  var1 = this.field255.length - this.field256;
               }

               this.field256 += this.field252.read(this.field255, this.field256, var1);
               if(this.field256 == this.field255.length) {
                  return this.field255;
               }
            }
         }

         return null;
      }
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-2"
   )
   static final void method173(int var0, int var1) {
      int var2 = class4.field79.method3963("Choose Option");

      int var3;
      int var4;
      for(var3 = 0; var3 < client.field294; ++var3) {
         var4 = class4.field79.method3963(class45.method929(var3));
         if(var4 > var2) {
            var2 = var4;
         }
      }

      var2 += 8;
      var3 = 22 + client.field294 * 15;
      var4 = var0 - var2 / 2;
      if(var4 + var2 > class10.field162) {
         var4 = class10.field162 - var2;
      }

      if(var4 < 0) {
         var4 = 0;
      }

      int var5 = var1;
      if(var1 + var3 > class41.field966) {
         var5 = class41.field966 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      client.field423 = true;
      class40.field965 = var4;
      class27.field668 = var5;
      class140.field2176 = var2;
      class26.field653 = 22 + client.field294 * 15;
   }

   class18(class136 var1, URL var2) {
      this.field251 = var1.method2858(var2);
      this.field262 = 0;
      this.field257 = class124.method2746() + 30000L;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2108557196"
   )
   @Export("widgetReset")
   static final void method174() {
      class46.field1052.method3717();
      class41.field977.method3717();
      class148.method3088();
      class40.field932.method3717();
      class40.field917.method3717();
      class40.field918.method3717();
      class40.field919.method3717();
      class39.field879.method3717();
      class39.field880.method3717();
      method178();
      class19.method213();
      class43.field1005.method3717();
      class43.field1006.method3717();
      class215.method3895();
      class52.field1169.method3717();
      class179.field2944.method3717();
      class173.field2768.method3717();
      class173.field2771.method3717();
      class173.field2772.method3717();
      class173.field2878.method3717();
      ((class95)class91.field1599).method2146();
      class22.field593.method3717();
      class15.field223.method3238();
      class33.field765.method3238();
      class21.field576.method3238();
      class42.field1000.method3238();
      class19.field272.method3238();
      class103.field1783.method3238();
      class122.field2028.method3238();
      class13.field203.method3238();
      class186.field3024.method3238();
      class138.field2161.method3238();
      class106.field1878.method3238();
      class129.field2067.method3238();
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1141166722"
   )
   static final void method175() {
      client.field327.method2726();
      int var0 = client.field327.method2713(8);
      int var1;
      if(var0 < client.field293) {
         for(var1 = var0; var1 < client.field293; ++var1) {
            client.field409[++client.field516 - 1] = client.field322[var1];
         }
      }

      if(var0 > client.field293) {
         throw new RuntimeException("");
      } else {
         client.field293 = 0;

         for(var1 = 0; var1 < var0; ++var1) {
            int var2 = client.field322[var1];
            class34 var3 = client.field320[var2];
            int var4 = client.field327.method2713(1);
            if(var4 == 0) {
               client.field322[++client.field293 - 1] = var2;
               var3.field823 = client.field332;
            } else {
               int var5 = client.field327.method2713(2);
               if(var5 == 0) {
                  client.field322[++client.field293 - 1] = var2;
                  var3.field823 = client.field332;
                  client.field285[++client.field323 - 1] = var2;
               } else {
                  int var6;
                  int var7;
                  if(var5 == 1) {
                     client.field322[++client.field293 - 1] = var2;
                     var3.field823 = client.field332;
                     var6 = client.field327.method2713(3);
                     var3.method710(var6, (byte)1);
                     var7 = client.field327.method2713(1);
                     if(var7 == 1) {
                        client.field285[++client.field323 - 1] = var2;
                     }
                  } else if(var5 == 2) {
                     client.field322[++client.field293 - 1] = var2;
                     var3.field823 = client.field332;
                     var6 = client.field327.method2713(3);
                     var3.method710(var6, (byte)2);
                     var7 = client.field327.method2713(3);
                     var3.method710(var7, (byte)2);
                     int var8 = client.field327.method2713(1);
                     if(var8 == 1) {
                        client.field285[++client.field323 - 1] = var2;
                     }
                  } else if(var5 == 3) {
                     client.field409[++client.field516 - 1] = var2;
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Lclass42;",
      garbageValue = "1821201608"
   )
   @Export("getAnimation")
   public static class42 method177(int var0) {
      class42 var1 = (class42)class42.field980.method3716((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class42.field993.method3221(12, var0);
         var1 = new class42();
         if(null != var2) {
            var1.method849(new class119(var2));
         }

         var1.method851();
         class42.field980.method3724(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   public static void method178() {
      class51.field1114.method3717();
      class51.field1115.method3717();
      class51.field1133.method3717();
   }
}
