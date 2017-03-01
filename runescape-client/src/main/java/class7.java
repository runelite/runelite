import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
final class class7 implements Comparator {
   @ObfuscatedName("s")
   static int[] field56;
   @ObfuscatedName("eo")
   static SpritePixels[] field57;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = 1360946953
   )
   static int field60;
   @ObfuscatedName("o")
   static int[] field61;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-122"
   )
   public static void method92() {
      try {
         File var0 = new File(MessageNode.field229, "random.dat");
         int var2;
         if(var0.exists()) {
            class104.field1689 = new class72(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label38:
            for(int var1 = 0; var1 < class9.field77.length; ++var1) {
               for(var2 = 0; var2 < class176.field2655.length; ++var2) {
                  File var3 = new File(class176.field2655[var2] + class9.field77[var1] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class104.field1689 = new class72(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label38;
                  }
               }
            }
         }

         if(null == class104.field1689) {
            RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
            var2 = var4.read();
            var4.seek(0L);
            var4.write(var2);
            var4.seek(0L);
            var4.close();
            class104.field1689 = new class72(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }

   public int compare(Object var1, Object var2) {
      return this.method93((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "312680975"
   )
   int method93(class2 var1, class2 var2) {
      return var1.field11 < var2.field11?-1:(var1.field11 == var2.field11?0:1);
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "384265772"
   )
   static void method96(int var0, String var1) {
      int var2 = class45.field916;
      int[] var3 = class45.field913;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         Player var6 = Client.cachedPlayers[var3[var5]];
         if(var6 != null && WidgetNode.localPlayer != var6 && null != var6.name && var6.name.equalsIgnoreCase(var1)) {
            if(var0 == 1) {
               Client.field332.method3144(100);
               Client.field332.method2910(var3[var5]);
               Client.field332.method2873(0);
            } else if(var0 == 4) {
               Client.field332.method3144(202);
               Client.field332.method2921(var3[var5]);
               Client.field332.method2911(0);
            } else if(var0 == 6) {
               Client.field332.method3144(124);
               Client.field332.method2872(var3[var5]);
               Client.field332.method3083(0);
            } else if(var0 == 7) {
               Client.field332.method3144(108);
               Client.field332.method2911(0);
               Client.field332.method2872(var3[var5]);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class88.sendGameMessage(4, "", "Unable to find " + var1);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([LWorld;II[I[II)V",
      garbageValue = "64949628"
   )
   static void method100(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = 1 + var2;
         int var7 = (var1 + var2) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var11;
            int var12;
            int var13;
            do {
               --var6;

               for(var13 = 0; var13 < 4; ++var13) {
                  if(var3[var13] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var13] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var13] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var13] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var13] == 3) {
                     var11 = var0[var6].method658()?1:0;
                     var12 = var8.method658()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var13] != 1 || var11 <= var12) && (var4[var13] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var13 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var13 = 0; var13 < 4; ++var13) {
                  if(var3[var13] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var13] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var13] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var13] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var13] == 3) {
                     var11 = var0[var5].method658()?1:0;
                     var12 = var8.method658()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var13] != 1 || var11 >= var12) && (var4[var13] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var13 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var10 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var10;
            }
         }

         method100(var0, var1, var6, var3, var4);
         method100(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1267544436"
   )
   static final boolean method101(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass103;Ljava/awt/Component;III)Lclass57;",
      garbageValue = "-893043331"
   )
   public static final class57 method102(class103 var0, Component var1, int var2, int var3) {
      if(class57.field1053 == 0) {
         throw new IllegalStateException();
      } else if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class59 var4 = new class59();
            var4.field1050 = new int[(class57.field1059?2:1) * 256];
            var4.field1069 = var3;
            var4.vmethod1198(var1);
            var4.field1058 = 1024 + (var3 & -1024);
            if(var4.field1058 > 16384) {
               var4.field1058 = 16384;
            }

            var4.vmethod1199(var4.field1058);
            if(class57.field1052 > 0 && class57.field1051 == null) {
               class57.field1051 = new class63();
               class57.field1051.field1107 = var0;
               var0.method2067(class57.field1051, class57.field1052);
            }

            if(null != class57.field1051) {
               if(class57.field1051.field1101[var2] != null) {
                  throw new IllegalArgumentException();
               }

               class57.field1051.field1101[var2] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class57();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
