import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
public class class123 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 8289989940273989823L
   )
   long field1750;
   @ObfuscatedName("m")
   byte[] field1751;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1293758729
   )
   int field1752;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1050133567
   )
   int field1753;
   @ObfuscatedName("w")
   byte[] field1754;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 898254111167993217L
   )
   long field1755;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 1289914103546493269L
   )
   long field1756;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -1450496199891462621L
   )
   long field1757;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 2254156453768250401L
   )
   long field1758;
   @ObfuscatedName("p")
   FileOnDisk field1759;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 3863856548493892353L
   )
   long field1760;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "419665946"
   )
   public long method2237() {
      return this.field1755;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-12"
   )
   public void method2238(byte[] var1) throws IOException {
      this.method2239(var1, 0, var1.length);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1471752838"
   )
   public void method2239(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(this.field1756 != -1L && this.field1760 >= this.field1756 && (long)var3 + this.field1760 <= (long)this.field1752 + this.field1756) {
            System.arraycopy(this.field1754, (int)(this.field1760 - this.field1756), var1, var2, var3);
            this.field1760 += (long)var3;
            return;
         }

         long var4 = this.field1760;
         int var6 = var3;
         int var7;
         if(this.field1760 >= this.field1757 && this.field1760 < this.field1757 + (long)this.field1753) {
            var7 = (int)((long)this.field1753 - (this.field1760 - this.field1757));
            if(var7 > var3) {
               var7 = var3;
            }

            System.arraycopy(this.field1751, (int)(this.field1760 - this.field1757), var1, var2, var7);
            this.field1760 += (long)var7;
            var2 += var7;
            var3 -= var7;
         }

         if(var3 > this.field1751.length) {
            this.field1759.method2263(this.field1760);

            for(this.field1750 = this.field1760; var3 > 0; var3 -= var7) {
               var7 = this.field1759.method2267(var1, var2, var3);
               if(var7 == -1) {
                  break;
               }

               this.field1750 += (long)var7;
               this.field1760 += (long)var7;
               var2 += var7;
            }
         } else if(var3 > 0) {
            this.method2240();
            var7 = var3;
            if(var3 > this.field1753) {
               var7 = this.field1753;
            }

            System.arraycopy(this.field1751, 0, var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.field1760 += (long)var7;
         }

         if(-1L != this.field1756) {
            if(this.field1756 > this.field1760 && var3 > 0) {
               var7 = (int)(this.field1756 - this.field1760) + var2;
               if(var7 > var3 + var2) {
                  var7 = var3 + var2;
               }

               while(var2 < var7) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field1760;
               }
            }

            long var8 = -1L;
            long var10 = -1L;
            if(this.field1756 >= var4 && this.field1756 < (long)var6 + var4) {
               var8 = this.field1756;
            } else if(var4 >= this.field1756 && var4 < this.field1756 + (long)this.field1752) {
               var8 = var4;
            }

            if((long)this.field1752 + this.field1756 > var4 && this.field1756 + (long)this.field1752 <= var4 + (long)var6) {
               var10 = this.field1756 + (long)this.field1752;
            } else if(var4 + (long)var6 > this.field1756 && (long)var6 + var4 <= (long)this.field1752 + this.field1756) {
               var10 = (long)var6 + var4;
            }

            if(var8 > -1L && var10 > var8) {
               int var12 = (int)(var10 - var8);
               System.arraycopy(this.field1754, (int)(var8 - this.field1756), var1, (int)(var8 - var4) + var2, var12);
               if(var10 > this.field1760) {
                  var3 = (int)((long)var3 - (var10 - this.field1760));
                  this.field1760 = var10;
               }
            }
         }
      } catch (IOException var13) {
         this.field1750 = -1L;
         throw var13;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1863489359"
   )
   void method2240() throws IOException {
      this.field1753 = 0;
      if(this.field1750 != this.field1760) {
         this.field1759.method2263(this.field1760);
         this.field1750 = this.field1760;
      }

      int var1;
      for(this.field1757 = this.field1760; this.field1753 < this.field1751.length; this.field1753 += var1) {
         var1 = this.field1759.method2267(this.field1751, this.field1753, this.field1751.length - this.field1753);
         if(var1 == -1) {
            break;
         }

         this.field1750 += (long)var1;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "810795558"
   )
   public void method2241(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.field1760 + (long)var3 > this.field1755) {
            this.field1755 = this.field1760 + (long)var3;
         }

         if(this.field1756 != -1L && (this.field1760 < this.field1756 || this.field1760 > (long)this.field1752 + this.field1756)) {
            this.method2242();
         }

         if(this.field1756 != -1L && (long)var3 + this.field1760 > (long)this.field1754.length + this.field1756) {
            int var4 = (int)((long)this.field1754.length - (this.field1760 - this.field1756));
            System.arraycopy(var1, var2, this.field1754, (int)(this.field1760 - this.field1756), var4);
            this.field1760 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1752 = this.field1754.length;
            this.method2242();
         }

         if(var3 <= this.field1754.length) {
            if(var3 > 0) {
               if(-1L == this.field1756) {
                  this.field1756 = this.field1760;
               }

               System.arraycopy(var1, var2, this.field1754, (int)(this.field1760 - this.field1756), var3);
               this.field1760 += (long)var3;
               if(this.field1760 - this.field1756 > (long)this.field1752) {
                  this.field1752 = (int)(this.field1760 - this.field1756);
               }
            }
         } else {
            if(this.field1760 != this.field1750) {
               this.field1759.method2263(this.field1760);
               this.field1750 = this.field1760;
            }

            this.field1759.method2264(var1, var2, var3);
            this.field1750 += (long)var3;
            if(this.field1750 > this.field1758) {
               this.field1758 = this.field1750;
            }

            long var10 = -1L;
            long var6 = -1L;
            if(this.field1760 >= this.field1757 && this.field1760 < (long)this.field1753 + this.field1757) {
               var10 = this.field1760;
            } else if(this.field1757 >= this.field1760 && this.field1757 < this.field1760 + (long)var3) {
               var10 = this.field1757;
            }

            if(this.field1760 + (long)var3 > this.field1757 && (long)var3 + this.field1760 <= (long)this.field1753 + this.field1757) {
               var6 = (long)var3 + this.field1760;
            } else if(this.field1757 + (long)this.field1753 > this.field1760 && this.field1757 + (long)this.field1753 <= this.field1760 + (long)var3) {
               var6 = (long)this.field1753 + this.field1757;
            }

            if(var10 > -1L && var6 > var10) {
               int var8 = (int)(var6 - var10);
               System.arraycopy(var1, (int)((long)var2 + var10 - this.field1760), this.field1751, (int)(var10 - this.field1757), var8);
            }

            this.field1760 += (long)var3;
         }

      } catch (IOException var9) {
         this.field1750 = -1L;
         throw var9;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1680005232"
   )
   void method2242() throws IOException {
      if(this.field1756 != -1L) {
         if(this.field1750 != this.field1756) {
            this.field1759.method2263(this.field1756);
            this.field1750 = this.field1756;
         }

         this.field1759.method2264(this.field1754, 0, this.field1752);
         this.field1750 += 1293758729L * (long)(this.field1752 * -1212830407);
         if(this.field1750 > this.field1758) {
            this.field1758 = this.field1750;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1756 >= this.field1757 && this.field1756 < this.field1757 + (long)this.field1753) {
            var1 = this.field1756;
         } else if(this.field1757 >= this.field1756 && this.field1757 < (long)this.field1752 + this.field1756) {
            var1 = this.field1757;
         }

         if((long)this.field1752 + this.field1756 > this.field1757 && (long)this.field1752 + this.field1756 <= (long)this.field1753 + this.field1757) {
            var3 = (long)this.field1752 + this.field1756;
         } else if(this.field1757 + (long)this.field1753 > this.field1756 && this.field1757 + (long)this.field1753 <= (long)this.field1752 + this.field1756) {
            var3 = (long)this.field1753 + this.field1757;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field1754, (int)(var1 - this.field1756), this.field1751, (int)(var1 - this.field1757), var5);
         }

         this.field1756 = -1L;
         this.field1752 = 0;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1140902821"
   )
   public void method2246() throws IOException {
      this.method2242();
      this.field1759.method2274();
   }

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class123(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1757 = -1L;
      this.field1756 = -1L;
      this.field1752 = 0;
      this.field1759 = var1;
      this.field1755 = this.field1758 = var1.method2266();
      this.field1751 = new byte[var2];
      this.field1754 = new byte[var3];
      this.field1760 = 0L;
   }

   @ObfuscatedName("m")
   public void method2256(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field1760 = var1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;ZII)V",
      garbageValue = "728777227"
   )
   static void method2261(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class92.field1422) {
         if(var3 == 4) {
            class92.loginIndex = 4;
         }
      } else {
         class92.loginIndex = var3;
         Rasterizer2D.method4827();
         byte[] var4 = var0.method4014("title.jpg", "");
         BufferedImage var5 = null;

         SpritePixels var6;
         int var7;
         int var8;
         label143: {
            try {
               var5 = ImageIO.read(new ByteArrayInputStream(var4));
               var7 = var5.getWidth();
               var8 = var5.getHeight();
               int[] var9 = new int[var8 * var7];
               PixelGrabber var10 = new PixelGrabber(var5, 0, 0, var7, var8, var9, 0, var7);
               var10.grabPixels();
               var6 = new SpritePixels(var9, var7, var8);
               break label143;
            } catch (IOException var11) {
               ;
            } catch (InterruptedException var12) {
               ;
            }

            var6 = new SpritePixels(0, 0);
         }

         class37.field519 = var6;
         class92.field1419 = class37.field519.method4930();
         if((Client.flags & 536870912) != 0) {
            class92.field1416 = class273.method4789(var1, "logo_deadman_mode", "");
         } else {
            class92.field1416 = class273.method4789(var1, "logo", "");
         }

         class92.field1415 = class273.method4789(var1, "titlebox", "");
         class92.field1447 = class273.method4789(var1, "titlebutton", "");
         class35.field503 = WidgetNode.method1033(var1, "runes", "");
         class92.field1423 = WidgetNode.method1033(var1, "title_mute", "");
         class21.field351 = class273.method4789(var1, "options_radio_buttons,0", "");
         FrameMap.field2055 = class273.method4789(var1, "options_radio_buttons,2", "");
         class48.field629 = new int[256];

         int var13;
         for(var13 = 0; var13 < 64; ++var13) {
            class48.field629[var13] = var13 * 262144;
         }

         for(var13 = 0; var13 < 64; ++var13) {
            class48.field629[var13 + 64] = var13 * 1024 + 16711680;
         }

         for(var13 = 0; var13 < 64; ++var13) {
            class48.field629[var13 + 128] = var13 * 4 + 16776960;
         }

         for(var13 = 0; var13 < 64; ++var13) {
            class48.field629[var13 + 192] = 16777215;
         }

         class43.field583 = new int[256];

         for(var13 = 0; var13 < 64; ++var13) {
            class43.field583[var13] = var13 * 1024;
         }

         for(var13 = 0; var13 < 64; ++var13) {
            class43.field583[var13 + 64] = var13 * 4 + '\uff00';
         }

         for(var13 = 0; var13 < 64; ++var13) {
            class43.field583[var13 + 128] = var13 * 262144 + '\uffff';
         }

         for(var13 = 0; var13 < 64; ++var13) {
            class43.field583[var13 + 192] = 16777215;
         }

         XClanMember.field897 = new int[256];

         for(var13 = 0; var13 < 64; ++var13) {
            XClanMember.field897[var13] = var13 * 4;
         }

         for(var13 = 0; var13 < 64; ++var13) {
            XClanMember.field897[var13 + 64] = var13 * 262144 + 255;
         }

         for(var13 = 0; var13 < 64; ++var13) {
            XClanMember.field897[var13 + 128] = var13 * 1024 + 16711935;
         }

         for(var13 = 0; var13 < 64; ++var13) {
            XClanMember.field897[var13 + 192] = 16777215;
         }

         class277.field3736 = new int[256];
         class14.field296 = new int['耀'];
         Script.field1536 = new int['耀'];
         Renderable.method2760((ModIcon)null);
         class10.field268 = new int['耀'];
         class170.field2360 = new int['耀'];
         if(var2) {
            class92.username = "";
            class92.password = "";
         }

         World.authCodeForLogin = 0;
         class82.authCode = "";
         class92.field1430 = true;
         class92.worldSelectShown = false;
         if(!Item.field1481.field1300) {
            IndexData var14 = FaceNormal.indexTrack1;
            var7 = var14.method4055("scape main");
            var8 = var14.method4020(var7, "");
            class203.field2517 = 1;
            class203.field2518 = var14;
            class203.field2519 = var7;
            class29.field438 = var8;
            class182.field2455 = 255;
            class88.field1384 = false;
            CollisionData.field2304 = 2;
         } else {
            class203.field2517 = 1;
            class203.field2518 = null;
            class203.field2519 = -1;
            class29.field438 = -1;
            class182.field2455 = 0;
            class88.field1384 = false;
            CollisionData.field2304 = 2;
         }

         class169.method3002(false);
         class92.field1422 = true;
         class92.field1414 = (class10.canvasWidth - 765) / 2;
         class92.loginWindowX = class92.field1414 + 202;
         class37.field519.method4949(class92.field1414, 0);
         class92.field1419.method4949(class92.field1414 + 382, 0);
         class92.field1416.method4923(class92.field1414 + 382 - class92.field1416.originalWidth / 2, 18);
      }

   }
}
