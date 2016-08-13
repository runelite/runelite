import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class18 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = -2399903289029594227L
   )
   long field256;
   @ObfuscatedName("g")
   class149 field257;
   @ObfuscatedName("r")
   DataInputStream field258;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2128025933
   )
   int field260;
   @ObfuscatedName("e")
   byte[] field261 = new byte[4];
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1668789211
   )
   int field262;
   @ObfuscatedName("q")
   static Widget field266;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2130811343
   )
   int field268;
   @ObfuscatedName("j")
   static int[] field269;
   @ObfuscatedName("s")
   byte[] field272;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "620344239"
   )
   byte[] method212() throws IOException {
      if(class56.method1249() > this.field256) {
         throw new IOException();
      } else {
         if(this.field262 == 0) {
            if(this.field257.field2276 == 2) {
               throw new IOException();
            }

            if(this.field257.field2276 == 1) {
               this.field258 = (DataInputStream)this.field257.field2272;
               this.field262 = 1;
            }
         }

         int var1;
         if(this.field262 == 1) {
            var1 = this.field258.available();
            if(var1 > 0) {
               if(this.field268 + var1 > 4) {
                  var1 = 4 - this.field268;
               }

               this.field268 += this.field258.read(this.field261, this.field268, var1);
               if(this.field268 == 4) {
                  int var2 = (new Buffer(this.field261)).method2620();
                  this.field272 = new byte[var2];
                  this.field262 = 2;
               }
            }
         }

         if(this.field262 == 2) {
            var1 = this.field258.available();
            if(var1 > 0) {
               if(this.field260 + var1 > this.field272.length) {
                  var1 = this.field272.length - this.field260;
               }

               this.field260 += this.field258.read(this.field272, this.field260, var1);
               if(this.field272.length == this.field260) {
                  return this.field272;
               }
            }
         }

         return null;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "201227017"
   )
   static int method213() {
      return ++class11.field184 - 1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LGameEngine;B)V",
      garbageValue = "17"
   )
   static void method217(GameEngine var0) {
      if(class143.field2217 == 1 || !class214.field3188 && class143.field2217 == 4) {
         int var1 = class33.field741 + 280;
         if(class143.field2215 >= var1 && class143.field2215 <= 14 + var1 && class143.field2216 >= 4 && class143.field2216 <= 18) {
            class145.method3129(0, 0);
            return;
         }

         if(class143.field2215 >= var1 + 15 && class143.field2215 <= var1 + 80 && class143.field2216 >= 4 && class143.field2216 <= 18) {
            class145.method3129(0, 1);
            return;
         }

         int var2 = 390 + class33.field741;
         if(class143.field2215 >= var2 && class143.field2215 <= 14 + var2 && class143.field2216 >= 4 && class143.field2216 <= 18) {
            class145.method3129(1, 0);
            return;
         }

         if(class143.field2215 >= 15 + var2 && class143.field2215 <= 80 + var2 && class143.field2216 >= 4 && class143.field2216 <= 18) {
            class145.method3129(1, 1);
            return;
         }

         int var3 = 500 + class33.field741;
         if(class143.field2215 >= var3 && class143.field2215 <= var3 + 14 && class143.field2216 >= 4 && class143.field2216 <= 18) {
            class145.method3129(2, 0);
            return;
         }

         if(class143.field2215 >= 15 + var3 && class143.field2215 <= 80 + var3 && class143.field2216 >= 4 && class143.field2216 <= 18) {
            class145.method3129(2, 1);
            return;
         }

         int var4 = 610 + class33.field741;
         if(class143.field2215 >= var4 && class143.field2215 <= var4 + 14 && class143.field2216 >= 4 && class143.field2216 <= 18) {
            class145.method3129(3, 0);
            return;
         }

         if(class143.field2215 >= 15 + var4 && class143.field2215 <= 80 + var4 && class143.field2216 >= 4 && class143.field2216 <= 18) {
            class145.method3129(3, 1);
            return;
         }

         if(class143.field2215 >= class33.field741 + 708 && class143.field2216 >= 4 && class143.field2215 <= class33.field741 + 708 + 50 && class143.field2216 <= 20) {
            class33.worldSelectShown = false;
            class33.field745.method1851(class33.field741, 0);
            class33.field746.method1851(class33.field741 + 382, 0);
            Frames.field1847.method1954(382 + class33.field741 - Frames.field1847.originalWidth / 2, 18);
            return;
         }

         if(class33.field743 != -1) {
            World var5 = World.worldList[class33.field743];
            class157.selectWorld(var5);
            class33.worldSelectShown = false;
            class33.field745.method1851(class33.field741, 0);
            class33.field746.method1851(382 + class33.field741, 0);
            Frames.field1847.method1954(class33.field741 + 382 - Frames.field1847.originalWidth / 2, 18);
            return;
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BI)Ljava/lang/String;",
      garbageValue = "2111618832"
   )
   public static String method218(byte[] var0) {
      return class134.method2984(var0, 0, var0.length);
   }

   class18(class139 var1, URL var2) {
      this.field257 = var1.method3031(var2);
      this.field262 = 0;
      this.field256 = class56.method1249() + 30000L;
   }
}
