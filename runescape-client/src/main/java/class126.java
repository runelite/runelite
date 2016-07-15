import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
public final class class126 {
   @ObfuscatedName("ay")
   static class171 field2076;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1080896487
   )
   int field2078;
   @ObfuscatedName("o")
   int[] field2080 = new int[256];
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -449534555
   )
   int field2081;
   @ObfuscatedName("u")
   int[] field2082 = new int[256];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1718355797
   )
   int field2083;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2125925787
   )
   int field2085;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "-319252328"
   )
   public static char method2882(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      if(var0 == 338) {
         return 'O';
      } else if(var0 == 339) {
         return 'o';
      } else if(var0 == 376) {
         return 'Y';
      } else {
         return var0;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2118137905"
   )
   final void method2884() {
      this.field2085 += ++this.field2083;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2080[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2081 ^= this.field2081 << 13;
            } else {
               this.field2081 ^= this.field2081 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2081 ^= this.field2081 << 2;
         } else {
            this.field2081 ^= this.field2081 >>> 16;
         }

         this.field2081 += this.field2080[128 + var1 & 255];
         int var3;
         this.field2080[var1] = var3 = this.field2080[(var2 & 1020) >> 2] + this.field2081 + this.field2085;
         this.field2082[var1] = this.field2085 = this.field2080[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1724628073"
   )
   final void method2885() {
      int var9 = -1640531527;
      int var8 = -1640531527;
      int var7 = -1640531527;
      int var6 = -1640531527;
      int var5 = -1640531527;
      int var4 = -1640531527;
      int var3 = -1640531527;
      int var2 = -1640531527;

      int var1;
      for(var1 = 0; var1 < 4; ++var1) {
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2082[var1];
         var3 += this.field2082[1 + var1];
         var4 += this.field2082[var1 + 2];
         var5 += this.field2082[var1 + 3];
         var6 += this.field2082[var1 + 4];
         var7 += this.field2082[var1 + 5];
         var8 += this.field2082[var1 + 6];
         var9 += this.field2082[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.field2080[var1] = var2;
         this.field2080[var1 + 1] = var3;
         this.field2080[2 + var1] = var4;
         this.field2080[3 + var1] = var5;
         this.field2080[var1 + 4] = var6;
         this.field2080[5 + var1] = var7;
         this.field2080[var1 + 6] = var8;
         this.field2080[7 + var1] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2080[var1];
         var3 += this.field2080[var1 + 1];
         var4 += this.field2080[2 + var1];
         var5 += this.field2080[var1 + 3];
         var6 += this.field2080[var1 + 4];
         var7 += this.field2080[var1 + 5];
         var8 += this.field2080[6 + var1];
         var9 += this.field2080[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.field2080[var1] = var2;
         this.field2080[1 + var1] = var3;
         this.field2080[var1 + 2] = var4;
         this.field2080[var1 + 3] = var5;
         this.field2080[var1 + 4] = var6;
         this.field2080[5 + var1] = var7;
         this.field2080[var1 + 6] = var8;
         this.field2080[7 + var1] = var9;
      }

      this.method2884();
      this.field2078 = 256;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-64"
   )
   final int method2889() {
      if(--this.field2078 + 1 == 0) {
         this.method2884();
         this.field2078 = 255;
      }

      return this.field2082[this.field2078];
   }

   class126(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2082[var2] = var1[var2];
      }

      this.method2885();
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1960806548"
   )
   static void method2895() {
      for(int var0 = 0; var0 < client.field435; ++var0) {
         if(class22.method571(client.field438[var0])) {
            if(var0 < client.field435 - 1) {
               for(int var1 = var0; var1 < client.field435 - 1; ++var1) {
                  client.field440[var1] = client.field440[1 + var1];
                  client.field441[var1] = client.field441[1 + var1];
                  client.field438[var1] = client.field438[var1 + 1];
                  client.field303[var1] = client.field303[var1 + 1];
                  client.field436[var1] = client.field436[var1 + 1];
                  client.field437[var1] = client.field437[var1 + 1];
               }
            }

            --client.field435;
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1688672158"
   )
   public static int method2896(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }
}
