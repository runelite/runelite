import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
public class class123 {
   @ObfuscatedName("h")
   byte[] field1738;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -4083970579565659155L
   )
   long field1739;
   @ObfuscatedName("i")
   FileOnDisk field1740;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -193071055
   )
   int field1741;
   @ObfuscatedName("g")
   byte[] field1742;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 2648699304873245771L
   )
   long field1743;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2035239849
   )
   int field1744;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -2149095203735870983L
   )
   long field1745;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 2061680391665608605L
   )
   long field1746;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = 8798227266329429321L
   )
   long field1747;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 6181488252941637943L
   )
   long field1749;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1950219010"
   )
   public void method2356(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.field1745 > this.field1747) {
            this.field1747 = this.field1745 + (long)var3;
         }

         if(-1L != this.field1749 && (this.field1745 < this.field1749 || this.field1745 > (long)this.field1744 + this.field1749)) {
            this.method2377();
         }

         if(this.field1749 != -1L && (long)var3 + this.field1745 > (long)this.field1742.length + this.field1749) {
            int var4 = (int)((long)this.field1742.length - (this.field1745 - this.field1749));
            System.arraycopy(var1, var2, this.field1742, (int)(this.field1745 - this.field1749), var4);
            this.field1745 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1744 = this.field1742.length;
            this.method2377();
         }

         if(var3 <= this.field1742.length) {
            if(var3 > 0) {
               if(-1L == this.field1749) {
                  this.field1749 = this.field1745;
               }

               System.arraycopy(var1, var2, this.field1742, (int)(this.field1745 - this.field1749), var3);
               this.field1745 += (long)var3;
               if(this.field1745 - this.field1749 > (long)this.field1744) {
                  this.field1744 = (int)(this.field1745 - this.field1749);
               }

            }
         } else {
            if(this.field1739 != this.field1745) {
               this.field1740.method2383(this.field1745);
               this.field1739 = this.field1745;
            }

            this.field1740.method2384(var1, var2, var3);
            this.field1739 += (long)var3;
            if(this.field1739 > this.field1746) {
               this.field1746 = this.field1739;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.field1745 >= this.field1743 && this.field1745 < this.field1743 + (long)this.field1741) {
               var9 = this.field1745;
            } else if(this.field1743 >= this.field1745 && this.field1743 < (long)var3 + this.field1745) {
               var9 = this.field1743;
            }

            if((long)var3 + this.field1745 > this.field1743 && this.field1745 + (long)var3 <= this.field1743 + (long)this.field1741) {
               var6 = this.field1745 + (long)var3;
            } else if(this.field1743 + (long)this.field1741 > this.field1745 && (long)this.field1741 + this.field1743 <= (long)var3 + this.field1745) {
               var6 = this.field1743 + (long)this.field1741;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)(var9 + (long)var2 - this.field1745), this.field1738, (int)(var9 - this.field1743), var8);
            }

            this.field1745 += (long)var3;
         }
      } catch (IOException var12) {
         this.field1739 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "9"
   )
   public void method2357() throws IOException {
      this.method2377();
      this.field1740.method2385();
   }

   @ObfuscatedName("h")
   public void method2358(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field1745 = var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "475222188"
   )
   public void method2361(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var2 + var3 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var2 + var3 - var1.length);
         }

         if(-1L != this.field1749 && this.field1745 >= this.field1749 && this.field1745 + (long)var3 <= (long)this.field1744 + this.field1749) {
            System.arraycopy(this.field1742, (int)(this.field1745 - this.field1749), var1, var2, var3);
            this.field1745 += (long)var3;
            return;
         }

         long var4 = this.field1745;
         int var7 = var3;
         int var8;
         if(this.field1745 >= this.field1743 && this.field1745 < (long)this.field1741 + this.field1743) {
            var8 = (int)((long)this.field1741 - (this.field1745 - this.field1743));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field1738, (int)(this.field1745 - this.field1743), var1, var2, var8);
            this.field1745 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field1738.length) {
            this.field1740.method2383(this.field1745);

            for(this.field1739 = this.field1745; var3 > 0; var3 -= var8) {
               var8 = this.field1740.method2387(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1739 += (long)var8;
               this.field1745 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method2362();
            var8 = var3;
            if(var3 > this.field1741) {
               var8 = this.field1741;
            }

            System.arraycopy(this.field1738, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field1745 += (long)var8;
         }

         if(this.field1749 != -1L) {
            if(this.field1749 > this.field1745 && var3 > 0) {
               var8 = var2 + (int)(this.field1749 - this.field1745);
               if(var8 > var2 + var3) {
                  var8 = var2 + var3;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field1745;
               }
            }

            long var13 = -1L;
            long var10 = -1L;
            if(this.field1749 >= var4 && this.field1749 < var4 + (long)var7) {
               var13 = this.field1749;
            } else if(var4 >= this.field1749 && var4 < (long)this.field1744 + this.field1749) {
               var13 = var4;
            }

            if((long)this.field1744 + this.field1749 > var4 && (long)this.field1744 + this.field1749 <= var4 + (long)var7) {
               var10 = (long)this.field1744 + this.field1749;
            } else if(var4 + (long)var7 > this.field1749 && var4 + (long)var7 <= (long)this.field1744 + this.field1749) {
               var10 = var4 + (long)var7;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.field1742, (int)(var13 - this.field1749), var1, var2 + (int)(var13 - var4), var12);
               if(var10 > this.field1745) {
                  var3 = (int)((long)var3 - (var10 - this.field1745));
                  this.field1745 = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1739 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1803374670"
   )
   void method2362() throws IOException {
      this.field1741 = 0;
      if(this.field1739 != this.field1745) {
         this.field1740.method2383(this.field1745);
         this.field1739 = this.field1745;
      }

      int var1;
      for(this.field1743 = this.field1745; this.field1741 < this.field1738.length; this.field1741 += var1) {
         var1 = this.field1740.method2387(this.field1738, this.field1741, this.field1738.length - this.field1741);
         if(var1 == -1) {
            break;
         }

         this.field1739 += (long)var1;
      }

   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZI)V",
      garbageValue = "1844236052"
   )
   static void method2366(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            class36.method497(var6, var2, var3, var4);
            class23.method161(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class24.method176(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;S)I",
      garbageValue = "6625"
   )
   public static int method2367(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class177.method3456(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1817727827"
   )
   public long method2374() {
      return this.field1747;
   }

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class123(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1743 = -1L;
      this.field1749 = -1L;
      this.field1744 = 0;
      this.field1740 = var1;
      this.field1747 = this.field1746 = var1.method2386();
      this.field1738 = new byte[var2];
      this.field1742 = new byte[var3];
      this.field1745 = 0L;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "28"
   )
   void method2377() throws IOException {
      if(this.field1749 != -1L) {
         if(this.field1739 != this.field1749) {
            this.field1740.method2383(this.field1749);
            this.field1739 = this.field1749;
         }

         this.field1740.method2384(this.field1742, 0, this.field1744);
         this.field1739 += 2035239849L * (long)(this.field1744 * 1448773785);
         if(this.field1739 > this.field1746) {
            this.field1746 = this.field1739;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1749 >= this.field1743 && this.field1749 < this.field1743 + (long)this.field1741) {
            var1 = this.field1749;
         } else if(this.field1743 >= this.field1749 && this.field1743 < (long)this.field1744 + this.field1749) {
            var1 = this.field1743;
         }

         if((long)this.field1744 + this.field1749 > this.field1743 && this.field1749 + (long)this.field1744 <= this.field1743 + (long)this.field1741) {
            var3 = (long)this.field1744 + this.field1749;
         } else if((long)this.field1741 + this.field1743 > this.field1749 && this.field1743 + (long)this.field1741 <= this.field1749 + (long)this.field1744) {
            var3 = (long)this.field1741 + this.field1743;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field1742, (int)(var1 - this.field1749), this.field1738, (int)(var1 - this.field1743), var5);
         }

         this.field1749 = -1L;
         this.field1744 = 0;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "633230991"
   )
   public void method2380(byte[] var1) throws IOException {
      this.method2361(var1, 0, var1.length);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;IIS)LSpritePixels;",
      garbageValue = "22846"
   )
   public static SpritePixels method2381(IndexDataBase var0, int var1, int var2) {
      if(!class228.method4155(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var4 = new SpritePixels();
         var4.maxWidth = class286.field3784;
         var4.maxHeight = class286.field3787;
         var4.offsetX = class286.field3785[0];
         var4.offsetY = class286.field3783[0];
         var4.width = class252.field3387[0];
         var4.height = class267.field3667[0];
         int var5 = var4.width * var4.height;
         byte[] var6 = MessageNode.field843[0];
         var4.image = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.image[var7] = class87.field1355[var6[var7] & 255];
         }

         class286.field3785 = null;
         class286.field3783 = null;
         class252.field3387 = null;
         class267.field3667 = null;
         class87.field1355 = null;
         MessageNode.field843 = null;
         return var4;
      }
   }
}
