import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
public class class99 extends class109 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -346909707
   )
   int field1635 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 428672967
   )
   int field1637 = 1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 7225322540378194829L
   )
   long field1638 = ChatMessages.method935();
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1671388219
   )
   int field1639;
   @ObfuscatedName("ol")
   @ObfuscatedGetter(
      intValue = 1751684813
   )
   static int field1640;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -845351741
   )
   int field1641 = 256;
   @ObfuscatedName("b")
   long[] field1642 = new long[10];

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void vmethod2102() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1642[var1] = 0L;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "94"
   )
   int vmethod2103(int var1, int var2) {
      int var3 = this.field1641;
      int var4 = this.field1637;
      this.field1641 = 300;
      this.field1637 = 1;
      this.field1638 = ChatMessages.method935();
      if(this.field1642[this.field1639] == 0L) {
         this.field1641 = var3;
         this.field1637 = var4;
      } else if(this.field1638 > this.field1642[this.field1639]) {
         this.field1641 = (int)((long)(var1 * 2560) / (this.field1638 - this.field1642[this.field1639]));
      }

      if(this.field1641 < 25) {
         this.field1641 = 25;
      }

      if(this.field1641 > 256) {
         this.field1641 = 256;
         this.field1637 = (int)((long)var1 - (this.field1638 - this.field1642[this.field1639]) / 10L);
      }

      if(this.field1637 > var1) {
         this.field1637 = var1;
      }

      this.field1642[this.field1639] = this.field1638;
      this.field1639 = (this.field1639 + 1) % 10;
      int var5;
      if(this.field1637 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(this.field1642[var5] != 0L) {
               this.field1642[var5] += (long)this.field1637;
            }
         }
      }

      if(this.field1637 < var2) {
         this.field1637 = var2;
      }

      class115.method2301((long)this.field1637);

      for(var5 = 0; this.field1635 < 256; this.field1635 += this.field1641) {
         ++var5;
      }

      this.field1635 &= 255;
      return var5;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(CIB)C",
      garbageValue = "1"
   )
   public static char method1997(char var0, int var1) {
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
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-1642443882"
   )
   public static String method2000(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;
      int var5 = var1;

      int var8;
      for(int var6 = var2 + var1; var5 < var6; var3[var4++] = (char)var8) {
         int var7 = var0[var5++] & 255;
         if(var7 < 128) {
            if(var7 == 0) {
               var8 = '�';
            } else {
               var8 = var7;
            }
         } else if(var7 < 192) {
            var8 = '�';
         } else if(var7 < 224) {
            if(var5 < var6 && (var0[var5] & 192) == 128) {
               var8 = (var7 & 31) << 6 | var0[var5++] & 63;
               if(var8 < 128) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 240) {
            if(var5 + 1 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128) {
               var8 = (var7 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 < 2048) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 248) {
            if(2 + var5 < var6 && (var0[var5] & 192) == 128 && (var0[1 + var5] & 192) == 128 && (var0[var5 + 2] & 192) == 128) {
               var8 = (var7 & 7) << 18 | (var0[var5++] & 63) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 >= 65536 && var8 <= 1114111) {
                  var8 = '�';
               } else {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else {
            var8 = '�';
         }
      }

      return new String(var3, 0, var4);
   }

   class99() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1642[var1] = this.field1638;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)[Lclass216;",
      garbageValue = "2130320052"
   )
   public static class216[] method2001() {
      return new class216[]{class216.field3176, class216.field3178, class216.field3179};
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "2099719908"
   )
   static void method2002(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var1 + var0) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(class7.method111(World.worldList[var9], var8, var2, var3, var4, var5) <= 0) {
               World var10 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var10;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method2002(var0, var7 - 1, var2, var3, var4, var5);
         method2002(1 + var7, var1, var2, var3, var4, var5);
      }

   }
}
