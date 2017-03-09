import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1878682307
   )
   @Export("y")
   int y;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1820532921
   )
   @Export("x")
   int x;
   @ObfuscatedName("d")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 870149933
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1729400267
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("ez")
   static ModIcon[] field1309;
   @ObfuscatedName("g")
   static ModIcon[] field1310;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1456901753
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-760924609"
   )
   public static final boolean method1593() {
      class105 var0 = class105.keyboard;
      synchronized(class105.keyboard) {
         if(class105.field1724 == class105.field1728) {
            return false;
         } else {
            FileOnDisk.field1202 = class105.field1723[class105.field1724];
            class157.field2108 = class105.field1722[class105.field1724];
            class105.field1724 = class105.field1724 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/io/File;",
      garbageValue = "15"
   )
   public static File method1594(String var0) {
      if(!class107.field1747) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class107.field1745.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class107.field1741, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class107.field1745.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-17"
   )
   public static void method1595(int var0) {
      class138.field1920 = 1;
      class138.field1916 = null;
      class138.field1922 = -1;
      class8.field86 = -1;
      Ignore.field245 = 0;
      class138.field1923 = false;
      XClanMember.field302 = var0;
   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "798707107"
   )
   static String method1596(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field381 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field381 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field381 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field381 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field381 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(null != class178.field2666) {
         var3 = "/p=" + class178.field2666;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field409 + "/a=" + Client.field316 + var3 + "/";
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "1261082487"
   )
   static final void method1597(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class25 var9 = null;

      for(class25 var10 = (class25)Client.field444.method2448(); null != var10; var10 = (class25)Client.field444.method2445()) {
         if(var0 == var10.field599 && var10.field598 == var1 && var2 == var10.field600 && var10.field597 == var3) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class25();
         var9.field599 = var0;
         var9.field597 = var3;
         var9.field598 = var1;
         var9.field600 = var2;
         class31.method691(var9);
         Client.field444.method2458(var9);
      }

      var9.field612 = var4;
      var9.field605 = var5;
      var9.field603 = var6;
      var9.field606 = var7;
      var9.field596 = var8;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass228;I)Ljava/lang/String;",
      garbageValue = "1792776982"
   )
   public static String method1598(CharSequence var0, class228 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         boolean var4;
         char var5;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            var5 = var0.charAt(var2);
            var4 = var5 == 160 || var5 == 32 || var5 == 95 || var5 == 45;
            if(!var4) {
               break;
            }
         }

         while(var3 > var2) {
            var5 = var0.charAt(var3 - 1);
            var4 = var5 == 160 || var5 == 32 || var5 == 95 || var5 == 45;
            if(!var4) {
               break;
            }

            --var3;
         }

         int var14 = var3 - var2;
         if(var14 >= 1) {
            byte var6;
            if(var1 == null) {
               var6 = 12;
            } else {
               switch(var1.field3249) {
               case 0:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var14 <= var6) {
               StringBuilder var13 = new StringBuilder(var14);

               for(int var15 = var2; var15 < var3; ++var15) {
                  char var7 = var0.charAt(var15);
                  boolean var8;
                  if(Character.isISOControl(var7)) {
                     var8 = false;
                  } else if(Projectile.method873(var7)) {
                     var8 = true;
                  } else {
                     char[] var9 = class204.field3088;
                     int var10 = 0;

                     label119:
                     while(true) {
                        char var11;
                        if(var10 >= var9.length) {
                           var9 = class204.field3089;

                           for(var10 = 0; var10 < var9.length; ++var10) {
                              var11 = var9[var10];
                              if(var7 == var11) {
                                 var8 = true;
                                 break label119;
                              }
                           }

                           var8 = false;
                           break;
                        }

                        var11 = var9[var10];
                        if(var7 == var11) {
                           var8 = true;
                           break;
                        }

                        ++var10;
                     }
                  }

                  if(var8) {
                     char var12 = class101.method2015(var7);
                     if(var12 != 0) {
                        var13.append(var12);
                     }
                  }
               }

               if(var13.length() == 0) {
                  return null;
               }

               return var13.toString();
            }
         }

         return null;
      }
   }
}
