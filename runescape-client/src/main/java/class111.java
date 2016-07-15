import java.applet.Applet;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("dc")
@Implements("CollisionData")
public class class111 {
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -857877213
   )
   @Export("height")
   int field1961;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1729281065
   )
   @Export("x")
   public int field1965 = 0;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1879189625
   )
   @Export("y")
   public int field1966 = 0;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 9380957
   )
   @Export("width")
   int field1967;
   @ObfuscatedName("aa")
   @Export("flags")
   public int[][] field1969;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-774028569"
   )
   public void method2472(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1965;
      var2 -= this.field1966;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2479(var1, var2, 128);
            this.method2479(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2479(var1, var2, 2);
            this.method2479(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2479(var1, var2, 8);
            this.method2479(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2479(var1, var2, 32);
            this.method2479(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2479(var1, var2, 1);
            this.method2479(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2479(var1, var2, 4);
            this.method2479(1 + var1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2479(var1, var2, 16);
            this.method2479(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2479(var1, var2, 64);
            this.method2479(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2479(var1, var2, 130);
            this.method2479(var1 - 1, var2, 8);
            this.method2479(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2479(var1, var2, 10);
            this.method2479(var1, var2 + 1, 32);
            this.method2479(1 + var1, var2, 128);
         }

         if(var4 == 2) {
            this.method2479(var1, var2, 40);
            this.method2479(var1 + 1, var2, 128);
            this.method2479(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2479(var1, var2, 160);
            this.method2479(var1, var2 - 1, 2);
            this.method2479(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2479(var1, var2, 65536);
               this.method2479(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2479(var1, var2, 1024);
               this.method2479(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2479(var1, var2, 4096);
               this.method2479(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2479(var1, var2, 16384);
               this.method2479(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2479(var1, var2, 512);
               this.method2479(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2479(var1, var2, 2048);
               this.method2479(1 + var1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2479(var1, var2, 8192);
               this.method2479(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2479(var1, var2, '耀');
               this.method2479(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2479(var1, var2, 66560);
               this.method2479(var1 - 1, var2, 4096);
               this.method2479(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2479(var1, var2, 5120);
               this.method2479(var1, 1 + var2, 16384);
               this.method2479(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2479(var1, var2, 20480);
               this.method2479(1 + var1, var2, 65536);
               this.method2479(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2479(var1, var2, 81920);
               this.method2479(var1, var2 - 1, 1024);
               this.method2479(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1985081335"
   )
   public void method2474(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1965;
      var2 -= this.field1966;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2476(var1, var2, 128);
            this.method2476(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2476(var1, var2, 2);
            this.method2476(var1, 1 + var2, 32);
         }

         if(var4 == 2) {
            this.method2476(var1, var2, 8);
            this.method2476(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2476(var1, var2, 32);
            this.method2476(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2476(var1, var2, 1);
            this.method2476(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2476(var1, var2, 4);
            this.method2476(1 + var1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2476(var1, var2, 16);
            this.method2476(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2476(var1, var2, 64);
            this.method2476(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2476(var1, var2, 130);
            this.method2476(var1 - 1, var2, 8);
            this.method2476(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2476(var1, var2, 10);
            this.method2476(var1, var2 + 1, 32);
            this.method2476(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2476(var1, var2, 40);
            this.method2476(1 + var1, var2, 128);
            this.method2476(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2476(var1, var2, 160);
            this.method2476(var1, var2 - 1, 2);
            this.method2476(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2476(var1, var2, 65536);
               this.method2476(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2476(var1, var2, 1024);
               this.method2476(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2476(var1, var2, 4096);
               this.method2476(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2476(var1, var2, 16384);
               this.method2476(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2476(var1, var2, 512);
               this.method2476(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2476(var1, var2, 2048);
               this.method2476(var1 + 1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2476(var1, var2, 8192);
               this.method2476(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2476(var1, var2, '耀');
               this.method2476(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2476(var1, var2, 66560);
               this.method2476(var1 - 1, var2, 4096);
               this.method2476(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2476(var1, var2, 5120);
               this.method2476(var1, 1 + var2, 16384);
               this.method2476(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2476(var1, var2, 20480);
               this.method2476(var1 + 1, var2, 65536);
               this.method2476(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2476(var1, var2, 81920);
               this.method2476(var1, var2 - 1, 1024);
               this.method2476(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-68847714"
   )
   public void method2475(int var1, int var2) {
      var1 -= this.field1965;
      var2 -= this.field1966;
      this.field1969[var1][var2] |= 262144;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1581394869"
   )
   void method2476(int var1, int var2, int var3) {
      this.field1969[var1][var2] |= var3;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIIZB)V",
      garbageValue = "95"
   )
   public void method2478(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      int var7 = 256;
      if(var6) {
         var7 += 131072;
      }

      var1 -= this.field1965;
      var2 -= this.field1966;
      int var8;
      if(var5 == 1 || var5 == 3) {
         var8 = var3;
         var3 = var4;
         var4 = var8;
      }

      for(var8 = var1; var8 < var1 + var3; ++var8) {
         if(var8 >= 0 && var8 < this.field1967) {
            for(int var9 = var2; var9 < var4 + var2; ++var9) {
               if(var9 >= 0 && var9 < this.field1961) {
                  this.method2479(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-617014996"
   )
   void method2479(int var1, int var2, int var3) {
      this.field1969[var1][var2] &= ~var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "-2477"
   )
   public void method2480(int var1, int var2) {
      var1 -= this.field1965;
      var2 -= this.field1966;
      this.field1969[var1][var2] &= -262145;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "2085882851"
   )
   static boolean method2482(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class141.field2181.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var13 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var13.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var8) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Applet var7 = class141.field2187;
            Object[] var5 = new Object[]{(new URL(class141.field2187.getCodeBase(), var0)).toString()};
            Object var3 = JSObject.getWindow(var7).call(var2, var5);
            return null != var3;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class141.field2187.getAppletContext().showDocument(new URL(class141.field2187.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class135.method2971(class141.field2187, "loggedout");
         } catch (Throwable var12) {
            ;
         }

         try {
            class141.field2187.getAppletContext().showDocument(new URL(class141.field2187.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "94"
   )
   public void method2486() {
      for(int var1 = 0; var1 < this.field1967; ++var1) {
         for(int var2 = 0; var2 < this.field1961; ++var2) {
            if(var1 != 0 && var2 != 0 && var1 < this.field1967 - 5 && var2 < this.field1961 - 5) {
               this.field1969[var1][var2] = 16777216;
            } else {
               this.field1969[var1][var2] = 16777215;
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "35"
   )
   public void method2488(int var1, int var2) {
      var1 -= this.field1965;
      var2 -= this.field1966;
      this.field1969[var1][var2] |= 2097152;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "104"
   )
   public class111(int var1, int var2) {
      this.field1967 = var1;
      this.field1961 = var2;
      this.field1969 = new int[this.field1967][this.field1961];
      this.method2486();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1989781813"
   )
   public void method2501(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.field1965;
      var2 -= this.field1966;

      for(int var7 = var1; var7 < var1 + var3; ++var7) {
         if(var7 >= 0 && var7 < this.field1967) {
            for(int var8 = var2; var8 < var4 + var2; ++var8) {
               if(var8 >= 0 && var8 < this.field1961) {
                  this.method2476(var7, var8, var6);
               }
            }
         }
      }

   }
}
