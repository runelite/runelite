import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class49 extends class203 {
   @ObfuscatedName("bt")
   static class167 field1088;
   @ObfuscatedName("r")
   static class192 field1089 = new class192(64);
   @ObfuscatedName("f")
   public boolean field1090 = false;
   @ObfuscatedName("a")
   static class166 field1091;
   @ObfuscatedName("bd")
   static class80[] field1094;

   @ObfuscatedName("s")
   void method1020(int var1) {
      if(2 == var1) {
         this.field1090 = true;
      }

   }

   @ObfuscatedName("f")
   void method1021(class118 var1) {
      while(true) {
         int var2 = var1.method2579();
         if(0 == var2) {
            return;
         }

         this.method1020(var2);
      }
   }

   @ObfuscatedName("s")
   public static void method1022() {
      class52.field1164.method3800();
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lclass37;II)V",
      garbageValue = "-1202675495"
   )
   static final void method1026(class37 var0) {
      if(var0.field857 > client.field303) {
         class9.method138(var0);
      } else if(var0.field863 >= client.field303) {
         class1.method17(var0);
      } else {
         var0.field840 = var0.field817;
         if(0 == var0.field865) {
            var0.field848 = 0;
         } else {
            label291: {
               if(var0.field869 != -1 && var0.field846 == 0) {
                  class42 var1 = class134.method2875(var0.field869);
                  if(var0.field861 > 0 && var1.field999 == 0) {
                     ++var0.field848;
                     break label291;
                  }

                  if(var0.field861 <= 0 && var1.field992 == 0) {
                     ++var0.field848;
                     break label291;
                  }
               }

               int var10 = var0.field870;
               int var2 = var0.field813;
               int var3 = 128 * var0.field866[var0.field865 - 1] + var0.field816 * 64;
               int var4 = 128 * var0.field867[var0.field865 - 1] + var0.field816 * 64;
               if(var10 < var3) {
                  if(var2 < var4) {
                     var0.field862 = 1280;
                  } else if(var2 > var4) {
                     var0.field862 = 1792;
                  } else {
                     var0.field862 = 1536;
                  }
               } else if(var10 > var3) {
                  if(var2 < var4) {
                     var0.field862 = 768;
                  } else if(var2 > var4) {
                     var0.field862 = 256;
                  } else {
                     var0.field862 = 512;
                  }
               } else if(var2 < var4) {
                  var0.field862 = 1024;
               } else if(var2 > var4) {
                  var0.field862 = 0;
               }

               byte var5 = var0.field831[var0.field865 - 1];
               if(var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
                  int var6 = var0.field862 - var0.field814 & 2047;
                  if(var6 > 1024) {
                     var6 -= 2048;
                  }

                  int var7 = var0.field821;
                  if(var6 >= -256 && var6 <= 256) {
                     var7 = var0.field820;
                  } else if(var6 >= 256 && var6 < 768) {
                     var7 = var0.field823;
                  } else if(var6 >= -768 && var6 <= -256) {
                     var7 = var0.field860;
                  }

                  if(-1 == var7) {
                     var7 = var0.field820;
                  }

                  var0.field840 = var7;
                  int var8 = 4;
                  boolean var9 = true;
                  if(var0 instanceof class34) {
                     var9 = ((class34)var0).field785.field915;
                  }

                  if(var9) {
                     if(var0.field814 != var0.field862 && -1 == var0.field837 && 0 != var0.field864) {
                        var8 = 2;
                     }

                     if(var0.field865 > 2) {
                        var8 = 6;
                     }

                     if(var0.field865 > 3) {
                        var8 = 8;
                     }

                     if(var0.field848 > 0 && var0.field865 > 1) {
                        var8 = 8;
                        --var0.field848;
                     }
                  } else {
                     if(var0.field865 > 1) {
                        var8 = 6;
                     }

                     if(var0.field865 > 2) {
                        var8 = 8;
                     }

                     if(var0.field848 > 0 && var0.field865 > 1) {
                        var8 = 8;
                        --var0.field848;
                     }
                  }

                  if(2 == var5) {
                     var8 <<= 1;
                  }

                  if(var8 >= 8 && var0.field840 == var0.field820 && -1 != var0.field828) {
                     var0.field840 = var0.field828;
                  }

                  if(var3 != var10 || var2 != var4) {
                     if(var10 < var3) {
                        var0.field870 += var8;
                        if(var0.field870 > var3) {
                           var0.field870 = var3;
                        }
                     } else if(var10 > var3) {
                        var0.field870 -= var8;
                        if(var0.field870 < var3) {
                           var0.field870 = var3;
                        }
                     }

                     if(var2 < var4) {
                        var0.field813 += var8;
                        if(var0.field813 > var4) {
                           var0.field813 = var4;
                        }
                     } else if(var2 > var4) {
                        var0.field813 -= var8;
                        if(var0.field813 < var4) {
                           var0.field813 = var4;
                        }
                     }
                  }

                  if(var0.field870 == var3 && var4 == var0.field813) {
                     --var0.field865;
                     if(var0.field861 > 0) {
                        --var0.field861;
                     }
                  }
               } else {
                  var0.field870 = var3;
                  var0.field813 = var4;
                  --var0.field865;
                  if(var0.field861 > 0) {
                     --var0.field861;
                  }
               }
            }
         }
      }

      if(var0.field870 < 128 || var0.field813 < 128 || var0.field870 >= 13184 || var0.field813 >= 13184) {
         var0.field869 = -1;
         var0.field859 = -1;
         var0.field857 = 0;
         var0.field863 = 0;
         var0.field870 = var0.field816 * 64 + var0.field866[0] * 128;
         var0.field813 = 128 * var0.field867[0] + var0.field816 * 64;
         var0.method760();
      }

      if(class151.field2253 == var0 && (var0.field870 < 1536 || var0.field813 < 1536 || var0.field870 >= 11776 || var0.field813 >= 11776)) {
         var0.field869 = -1;
         var0.field859 = -1;
         var0.field857 = 0;
         var0.field863 = 0;
         var0.field870 = var0.field816 * 64 + var0.field866[0] * 128;
         var0.field813 = 128 * var0.field867[0] + var0.field816 * 64;
         var0.method760();
      }

      class35.method740(var0);
      class161.method3208(var0);
   }

   @ObfuscatedName("r")
   public static class47 method1029(int var0) {
      class47 var1 = (class47)class47.field1062.method3792((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class47.field1064.method3263(14, var0);
         var1 = new class47();
         if(null != var2) {
            var1.method995(new class118(var2));
         }

         class47.field1062.method3794(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(Lclass172;III)V",
      garbageValue = "-815206800"
   )
   static void method1030(class172 var0, int var1, int var2) {
      if(0 == var0.field2748) {
         var0.field2734 = var0.field2743;
      } else if(1 == var0.field2748) {
         var0.field2734 = (var1 - var0.field2752) / 2 + var0.field2743;
      } else if(var0.field2748 == 2) {
         var0.field2734 = var1 - var0.field2752 - var0.field2743;
      } else if(var0.field2748 == 3) {
         var0.field2734 = var0.field2743 * var1 >> 14;
      } else if(4 == var0.field2748) {
         var0.field2734 = (var1 - var0.field2752) / 2 + (var0.field2743 * var1 >> 14);
      } else {
         var0.field2734 = var1 - var0.field2752 - (var1 * var0.field2743 >> 14);
      }

      if(0 == var0.field2749) {
         var0.field2757 = var0.field2753;
      } else if(var0.field2749 == 1) {
         var0.field2757 = (var2 - var0.field2759) / 2 + var0.field2753;
      } else if(2 == var0.field2749) {
         var0.field2757 = var2 - var0.field2759 - var0.field2753;
      } else if(3 == var0.field2749) {
         var0.field2757 = var2 * var0.field2753 >> 14;
      } else if(var0.field2749 == 4) {
         var0.field2757 = (var2 * var0.field2753 >> 14) + (var2 - var0.field2759) / 2;
      } else {
         var0.field2757 = var2 - var0.field2759 - (var2 * var0.field2753 >> 14);
      }

      if(client.field463 && 0 == var0.field2764) {
         if(var0.field2734 < 0) {
            var0.field2734 = 0;
         } else if(var0.field2734 + var0.field2752 > var1) {
            var0.field2734 = var1 - var0.field2752;
         }

         if(var0.field2757 < 0) {
            var0.field2757 = 0;
         } else if(var0.field2757 + var0.field2759 > var2) {
            var0.field2757 = var2 - var0.field2759;
         }
      }

   }

   @ObfuscatedName("e")
   static class25 method1031() {
      return class25.field640 < class25.field634?class25.field633[++class25.field640 - 1]:null;
   }
}
