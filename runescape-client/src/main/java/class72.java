import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
public class class72 implements Runnable {
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = 81945593
   )
   @Export("cameraY")
   static int field1353;
   @ObfuscatedName("s")
   class136 field1354;
   @ObfuscatedName("p")
   volatile boolean field1355 = false;
   @ObfuscatedName("x")
   volatile boolean field1356 = false;
   @ObfuscatedName("j")
   volatile class56[] field1357 = new class56[2];

   public void run() {
      this.field1356 = true;

      try {
         while(!this.field1355) {
            for(int var1 = 0; var1 < 2; ++var1) {
               class56 var2 = this.field1357[var1];
               if(var2 != null) {
                  var2.method1148();
               }
            }

            class116.method2448(10L);
            class17.method202(this.field1354, (Object)null);
         }
      } catch (Exception var6) {
         class90.method2067((String)null, var6);
      } finally {
         this.field1356 = false;
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Lclass37;IS)V",
      garbageValue = "22527"
   )
   static final void method1550(class37 var0, int var1) {
      int var2;
      int var3;
      int var4;
      class42 var11;
      if(var0.field857 > client.field335) {
         class11.method153(var0);
      } else {
         int var5;
         int var7;
         if(var0.field812 >= client.field335) {
            if(client.field335 == var0.field812 || -1 == var0.field843 || var0.field851 != 0 || var0.field845 + 1 > class4.method42(var0.field843).field999[var0.field844]) {
               var2 = var0.field812 - var0.field857;
               var3 = client.field335 - var0.field857;
               var4 = var0.field872 * 64 + var0.field853 * 128;
               var5 = var0.field872 * 64 + var0.field818 * 128;
               int var6 = var0.field854 * 128 + var0.field872 * 64;
               var7 = var0.field856 * 128 + var0.field872 * 64;
               var0.field823 = (var3 * var6 + var4 * (var2 - var3)) / var2;
               var0.field813 = (var5 * (var2 - var3) + var7 * var3) / var2;
            }

            var0.field869 = 0;
            var0.field862 = var0.field836;
            var0.field814 = var0.field862;
         } else {
            var0.field840 = var0.field817;
            if(var0.field841 == 0) {
               var0.field869 = 0;
            } else {
               label599: {
                  if(-1 != var0.field843 && var0.field851 == 0) {
                     var11 = class4.method42(var0.field843);
                     if(var0.field870 > 0 && var11.field997 == 0) {
                        ++var0.field869;
                        break label599;
                     }

                     if(var0.field870 <= 0 && var11.field1001 == 0) {
                        ++var0.field869;
                        break label599;
                     }
                  }

                  var2 = var0.field823;
                  var3 = var0.field813;
                  var4 = var0.field866[var0.field841 - 1] * 128 + var0.field872 * 64;
                  var5 = var0.field872 * 64 + var0.field863[var0.field841 - 1] * 128;
                  if(var2 < var4) {
                     if(var3 < var5) {
                        var0.field862 = 1280;
                     } else if(var3 > var5) {
                        var0.field862 = 1792;
                     } else {
                        var0.field862 = 1536;
                     }
                  } else if(var2 > var4) {
                     if(var3 < var5) {
                        var0.field862 = 768;
                     } else if(var3 > var5) {
                        var0.field862 = 256;
                     } else {
                        var0.field862 = 512;
                     }
                  } else if(var3 < var5) {
                     var0.field862 = 1024;
                  } else if(var3 > var5) {
                     var0.field862 = 0;
                  }

                  byte var15 = var0.field868[var0.field841 - 1];
                  if(var4 - var2 <= 256 && var4 - var2 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                     var7 = var0.field862 - var0.field814 & 2047;
                     if(var7 > 1024) {
                        var7 -= 2048;
                     }

                     int var8 = var0.field821;
                     if(var7 >= -256 && var7 <= 256) {
                        var8 = var0.field820;
                     } else if(var7 >= 256 && var7 < 768) {
                        var8 = var0.field855;
                     } else if(var7 >= -768 && var7 <= -256) {
                        var8 = var0.field847;
                     }

                     if(-1 == var8) {
                        var8 = var0.field820;
                     }

                     var0.field840 = var8;
                     int var9 = 4;
                     boolean var10 = true;
                     if(var0 instanceof class34) {
                        var10 = ((class34)var0).field782.field916;
                     }

                     if(var10) {
                        if(var0.field862 != var0.field814 && var0.field837 == -1 && var0.field852 != 0) {
                           var9 = 2;
                        }

                        if(var0.field841 > 2) {
                           var9 = 6;
                        }

                        if(var0.field841 > 3) {
                           var9 = 8;
                        }

                        if(var0.field869 > 0 && var0.field841 > 1) {
                           var9 = 8;
                           --var0.field869;
                        }
                     } else {
                        if(var0.field841 > 1) {
                           var9 = 6;
                        }

                        if(var0.field841 > 2) {
                           var9 = 8;
                        }

                        if(var0.field869 > 0 && var0.field841 > 1) {
                           var9 = 8;
                           --var0.field869;
                        }
                     }

                     if(var15 == 2) {
                        var9 <<= 1;
                     }

                     if(var9 >= 8 && var0.field840 == var0.field820 && -1 != var0.field850) {
                        var0.field840 = var0.field850;
                     }

                     if(var2 != var4 || var5 != var3) {
                        if(var2 < var4) {
                           var0.field823 += var9;
                           if(var0.field823 > var4) {
                              var0.field823 = var4;
                           }
                        } else if(var2 > var4) {
                           var0.field823 -= var9;
                           if(var0.field823 < var4) {
                              var0.field823 = var4;
                           }
                        }

                        if(var3 < var5) {
                           var0.field813 += var9;
                           if(var0.field813 > var5) {
                              var0.field813 = var5;
                           }
                        } else if(var3 > var5) {
                           var0.field813 -= var9;
                           if(var0.field813 < var5) {
                              var0.field813 = var5;
                           }
                        }
                     }

                     if(var4 == var0.field823 && var5 == var0.field813) {
                        --var0.field841;
                        if(var0.field870 > 0) {
                           --var0.field870;
                        }
                     }
                  } else {
                     var0.field823 = var4;
                     var0.field813 = var5;
                     --var0.field841;
                     if(var0.field870 > 0) {
                        --var0.field870;
                     }
                  }
               }
            }
         }
      }

      if(var0.field823 < 128 || var0.field813 < 128 || var0.field823 >= 13184 || var0.field813 >= 13184) {
         var0.field843 = -1;
         var0.field848 = -1;
         var0.field857 = 0;
         var0.field812 = 0;
         var0.field823 = 128 * var0.field866[0] + var0.field872 * 64;
         var0.field813 = var0.field863[0] * 128 + var0.field872 * 64;
         var0.method726();
      }

      if(var0 == class106.field1881 && (var0.field823 < 1536 || var0.field813 < 1536 || var0.field823 >= 11776 || var0.field813 >= 11776)) {
         var0.field843 = -1;
         var0.field848 = -1;
         var0.field857 = 0;
         var0.field812 = 0;
         var0.field823 = var0.field872 * 64 + 128 * var0.field866[0];
         var0.field813 = var0.field863[0] * 128 + var0.field872 * 64;
         var0.method726();
      }

      if(var0.field852 != 0) {
         if(var0.field837 != -1) {
            Object var12 = null;
            if(var0.field837 < '耀') {
               var12 = client.field515[var0.field837];
            } else if(var0.field837 >= '耀') {
               var12 = client.field491[var0.field837 - '耀'];
            }

            if(null != var12) {
               var3 = var0.field823 - ((class37)var12).field823;
               var4 = var0.field813 - ((class37)var12).field813;
               if(0 != var3 || var4 != 0) {
                  var0.field862 = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field838) {
               var0.field837 = -1;
               var0.field838 = false;
            }
         }

         if(var0.field824 != -1 && (var0.field841 == 0 || var0.field869 > 0)) {
            var0.field862 = var0.field824;
            var0.field824 = -1;
         }

         var2 = var0.field862 - var0.field814 & 2047;
         if(0 == var2 && var0.field838) {
            var0.field837 = -1;
            var0.field838 = false;
         }

         if(0 != var2) {
            ++var0.field858;
            boolean var13;
            if(var2 > 1024) {
               var0.field814 -= var0.field852;
               var13 = true;
               if(var2 < var0.field852 || var2 > 2048 - var0.field852) {
                  var0.field814 = var0.field862;
                  var13 = false;
               }

               if(var0.field817 == var0.field840 && (var0.field858 > 25 || var13)) {
                  if(-1 != var0.field860) {
                     var0.field840 = var0.field860;
                  } else {
                     var0.field840 = var0.field820;
                  }
               }
            } else {
               var0.field814 += var0.field852;
               var13 = true;
               if(var2 < var0.field852 || var2 > 2048 - var0.field852) {
                  var0.field814 = var0.field862;
                  var13 = false;
               }

               if(var0.field840 == var0.field817 && (var0.field858 > 25 || var13)) {
                  if(-1 != var0.field839) {
                     var0.field840 = var0.field839;
                  } else {
                     var0.field840 = var0.field820;
                  }
               }
            }

            var0.field814 &= 2047;
         } else {
            var0.field858 = 0;
         }
      }

      var0.field815 = false;
      if(var0.field840 != -1) {
         var11 = class4.method42(var0.field840);
         if(var11 != null && var11.field986 != null) {
            ++var0.field842;
            if(var0.field861 < var11.field986.length && var0.field842 > var11.field999[var0.field861]) {
               var0.field842 = 1;
               ++var0.field861;
               class13.method166(var11, var0.field861, var0.field823, var0.field813);
            }

            if(var0.field861 >= var11.field986.length) {
               var0.field842 = 0;
               var0.field861 = 0;
               class13.method166(var11, var0.field861, var0.field823, var0.field813);
            }
         } else {
            var0.field840 = -1;
         }
      }

      if(-1 != var0.field848 && client.field335 >= var0.field825) {
         if(var0.field849 < 0) {
            var0.field849 = 0;
         }

         var2 = class179.method3492(var0.field848).field1008;
         if(var2 != -1) {
            class42 var14 = class4.method42(var2);
            if(null != var14 && null != var14.field986) {
               ++var0.field822;
               if(var0.field849 < var14.field986.length && var0.field822 > var14.field999[var0.field849]) {
                  var0.field822 = 1;
                  ++var0.field849;
                  class13.method166(var14, var0.field849, var0.field823, var0.field813);
               }

               if(var0.field849 >= var14.field986.length && (var0.field849 < 0 || var0.field849 >= var14.field986.length)) {
                  var0.field848 = -1;
               }
            } else {
               var0.field848 = -1;
            }
         } else {
            var0.field848 = -1;
         }
      }

      if(-1 != var0.field843 && var0.field851 <= 1) {
         var11 = class4.method42(var0.field843);
         if(1 == var11.field997 && var0.field870 > 0 && var0.field857 <= client.field335 && var0.field812 < client.field335) {
            var0.field851 = 1;
            return;
         }
      }

      if(-1 != var0.field843 && 0 == var0.field851) {
         var11 = class4.method42(var0.field843);
         if(null != var11 && null != var11.field986) {
            ++var0.field845;
            if(var0.field844 < var11.field986.length && var0.field845 > var11.field999[var0.field844]) {
               var0.field845 = 1;
               ++var0.field844;
               class13.method166(var11, var0.field844, var0.field823, var0.field813);
            }

            if(var0.field844 >= var11.field986.length) {
               var0.field844 -= var11.field991;
               ++var0.field826;
               if(var0.field826 >= var11.field996) {
                  var0.field843 = -1;
               } else if(var0.field844 >= 0 && var0.field844 < var11.field986.length) {
                  class13.method166(var11, var0.field844, var0.field823, var0.field813);
               } else {
                  var0.field843 = -1;
               }
            }

            var0.field815 = var11.field992;
         } else {
            var0.field843 = -1;
         }
      }

      if(var0.field851 > 0) {
         --var0.field851;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "19"
   )
   static int method1551(int var0) {
      class35 var1 = (class35)class11.field167.method3794((long)var0);
      return null == var1?-1:(class11.field171.field3110 == var1.field3114?-1:((class35)var1.field3114).field789);
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "13"
   )
   static final void method1552() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < client.field496 - 1; ++var1) {
            if(client.field422[var1] < 1000 && client.field422[var1 + 1] > 1000) {
               String var2 = client.field425[var1];
               client.field425[var1] = client.field425[1 + var1];
               client.field425[1 + var1] = var2;
               String var3 = client.field424[var1];
               client.field424[var1] = client.field424[1 + var1];
               client.field424[1 + var1] = var3;
               int var4 = client.field422[var1];
               client.field422[var1] = client.field422[1 + var1];
               client.field422[1 + var1] = var4;
               var4 = client.field420[var1];
               client.field420[var1] = client.field420[1 + var1];
               client.field420[var1 + 1] = var4;
               var4 = client.field421[var1];
               client.field421[var1] = client.field421[1 + var1];
               client.field421[1 + var1] = var4;
               var4 = client.field378[var1];
               client.field378[var1] = client.field378[var1 + 1];
               client.field378[var1 + 1] = var4;
               var0 = false;
            }
         }
      }

   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIS)V",
      garbageValue = "-15194"
   )
   static void method1553(class173 var0, int var1, int var2) {
      if(0 == var0.field2770) {
         var0.field2768 = var0.field2774;
      } else if(var0.field2770 == 1) {
         var0.field2768 = (var1 - var0.field2886) / 2 + var0.field2774;
      } else if(var0.field2770 == 2) {
         var0.field2768 = var1 - var0.field2886 - var0.field2774;
      } else if(var0.field2770 == 3) {
         var0.field2768 = var0.field2774 * var1 >> 14;
      } else if(var0.field2770 == 4) {
         var0.field2768 = (var1 - var0.field2886) / 2 + (var1 * var0.field2774 >> 14);
      } else {
         var0.field2768 = var1 - var0.field2886 - (var1 * var0.field2774 >> 14);
      }

      if(var0.field2810 == 0) {
         var0.field2779 = var0.field2775;
      } else if(var0.field2810 == 1) {
         var0.field2779 = var0.field2775 + (var2 - var0.field2781) / 2;
      } else if(var0.field2810 == 2) {
         var0.field2779 = var2 - var0.field2781 - var0.field2775;
      } else if(var0.field2810 == 3) {
         var0.field2779 = var0.field2775 * var2 >> 14;
      } else if(4 == var0.field2810) {
         var0.field2779 = (var0.field2775 * var2 >> 14) + (var2 - var0.field2781) / 2;
      } else {
         var0.field2779 = var2 - var0.field2781 - (var0.field2775 * var2 >> 14);
      }

      if(client.field535 && 0 == var0.field2767) {
         if(var0.field2768 < 0) {
            var0.field2768 = 0;
         } else if(var0.field2886 + var0.field2768 > var1) {
            var0.field2768 = var1 - var0.field2886;
         }

         if(var0.field2779 < 0) {
            var0.field2779 = 0;
         } else if(var0.field2779 + var0.field2781 > var2) {
            var0.field2779 = var2 - var0.field2781;
         }
      }

   }
}
