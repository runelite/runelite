import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
public class class116 {
   @ObfuscatedName("q")
   byte[] field2018;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = -1799695727
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("f")
   int[] field2020;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -984309589
   )
   static int field2023;
   @ObfuscatedName("k")
   int[] field2024;

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-583540088"
   )
   static void method2496(Widget var0, int var1, int var2) {
      if(var0.field2803 == 0) {
         var0.relativeX = var0.field2807;
      } else if(var0.field2803 == 1) {
         var0.relativeX = var0.field2807 + (var1 - var0.width) / 2;
      } else if(var0.field2803 == 2) {
         var0.relativeX = var1 - var0.width - var0.field2807;
      } else if(var0.field2803 == 3) {
         var0.relativeX = var1 * var0.field2807 >> 14;
      } else if(var0.field2803 == 4) {
         var0.relativeX = (var0.field2807 * var1 >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var1 * var0.field2807 >> 14);
      }

      if(var0.field2804 == 0) {
         var0.relativeY = var0.field2808;
      } else if(var0.field2804 == 1) {
         var0.relativeY = var0.field2808 + (var2 - var0.height) / 2;
      } else if(var0.field2804 == 2) {
         var0.relativeY = var2 - var0.height - var0.field2808;
      } else if(var0.field2804 == 3) {
         var0.relativeY = var0.field2808 * var2 >> 14;
      } else if(var0.field2804 == 4) {
         var0.relativeY = (var2 - var0.height) / 2 + (var0.field2808 * var2 >> 14);
      } else {
         var0.relativeY = var2 - var0.height - (var0.field2808 * var2 >> 14);
      }

      if(Client.field316 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.width + var0.relativeX > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.height + var0.relativeY > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BI[BIII)I",
      garbageValue = "-935186134"
   )
   public int method2498(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field2020[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field2020[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.field2020[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2020[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field2020[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2020[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.field2020[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2020[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.field2020[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2020[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field2020[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2020[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.field2020[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2020[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.field2020[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2020[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            ++var7;
         }

         return var7 + 1 - var2;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BII[BII)I",
      garbageValue = "1382736364"
   )
   public int method2500(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field2024[var8];
         byte var10 = this.field2018[var8];
         if(var10 == 0) {
            throw new RuntimeException("");
         }

         int var11 = var7 >> 3;
         int var12 = var7 & 7;
         var6 &= -var12 >> 31;
         int var13 = var11 + (var12 + var10 - 1 >> 3);
         var12 += 24;
         var4[var11] = (byte)(var6 |= var9 >>> var12);
         if(var11 < var13) {
            ++var11;
            var12 -= 8;
            var4[var11] = (byte)(var6 = var9 >>> var12);
            if(var11 < var13) {
               ++var11;
               var12 -= 8;
               var4[var11] = (byte)(var6 = var9 >>> var12);
               if(var11 < var13) {
                  ++var11;
                  var12 -= 8;
                  var4[var11] = (byte)(var6 = var9 >>> var12);
                  if(var11 < var13) {
                     ++var11;
                     var12 -= 8;
                     var4[var11] = (byte)(var6 = var9 << -var12);
                  }
               }
            }
         }

         var7 += var10;
      }

      return (7 + var7 >> 3) - var5;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-957894108"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class11.chatLineMap.get(Integer.valueOf(var0));
      if(null == var4) {
         var4 = new ChatLineBuffer();
         class11.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method662(var0, var1, var2, var3);
      class11.field167.method3837(var5, (long)var5.id);
      class11.field164.method3877(var5);
      Client.field472 = Client.field465;
   }

   @ObfuscatedName("rr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-711253042"
   )
   protected static final void method2506() {
      class59.field1256 = null;
      class43.field1000 = null;
      KitDefinition.field1064 = null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)LFileOnDisk;",
      garbageValue = "1350326915"
   )
   public static FileOnDisk method2507(String var0, String var1, boolean var2) {
      File var3 = new File(WidgetNode.field61, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class26.field635 == 33) {
         var4 = "_rc";
      } else if(class26.field635 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class9.field149, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   public class116(byte[] var1) {
      int var2 = var1.length;
      this.field2024 = new int[var2];
      this.field2018 = var1;
      int[] var3 = new int[33];
      this.field2020 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field2024[var5] = var8;
            int var9;
            int var10;
            int var11;
            int var12;
            if((var8 & var7) != 0) {
               var9 = var3[var6 - 1];
            } else {
               var9 = var8 | var7;

               for(var10 = var6 - 1; var10 >= 1; --var10) {
                  var11 = var3[var10];
                  if(var11 != var8) {
                     break;
                  }

                  var12 = 1 << 32 - var10;
                  if((var11 & var12) != 0) {
                     var3[var10] = var3[var10 - 1];
                     break;
                  }

                  var3[var10] = var11 | var12;
               }
            }

            var3[var6] = var9;

            for(var10 = var6 + 1; var10 <= 32; ++var10) {
               if(var8 == var3[var10]) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if((var8 & var12) != 0) {
                  if(this.field2020[var10] == 0) {
                     this.field2020[var10] = var4;
                  }

                  var10 = this.field2020[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field2020.length) {
                  int[] var13 = new int[2 * this.field2020.length];

                  for(int var14 = 0; var14 < this.field2020.length; ++var14) {
                     var13[var14] = this.field2020[var14];
                  }

                  this.field2020 = var13;
               }

               var12 >>>= 1;
            }

            this.field2020[var10] = ~var5;
            if(var10 >= var4) {
               var4 = 1 + var10;
            }
         }
      }

   }
}
