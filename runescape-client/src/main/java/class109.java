import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
public class class109 {
   @ObfuscatedName("i")
   static ScheduledExecutorService field1621;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 2362093309975681571L
   )
   long field1622;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -283121375
   )
   static int field1623;
   @ObfuscatedName("c")
   static class111 field1624;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1351561611
   )
   int field1625;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1287654579
   )
   int field1627;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 2045768577787710619L
   )
   long field1628;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1797918349
   )
   int field1629;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -457994763
   )
   int field1630;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1980412499
   )
   int field1631;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -3634763646632026723L
   )
   long field1632;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -934811203
   )
   int field1633;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1694036405
   )
   int field1634;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 464147447
   )
   public static int field1635;
   @ObfuscatedName("ab")
   class119[] field1636;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = -336896661
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("a")
   protected int[] field1639;
   @ObfuscatedName("al")
   class119[] field1640;
   @ObfuscatedName("u")
   boolean field1644;
   @ObfuscatedName("g")
   class119 field1645;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1177640145
   )
   int field1646;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "902185193"
   )
   public final synchronized void method1912() {
      if(this.field1639 != null) {
         long var1 = class166.method2970();

         try {
            if(0L != this.field1632) {
               if(var1 < this.field1632) {
                  return;
               }

               this.vmethod1941(this.field1629);
               this.field1632 = 0L;
               this.field1644 = true;
            }

            int var3 = this.vmethod1958();
            if(this.field1625 - var3 > this.field1633) {
               this.field1633 = this.field1625 - var3;
            }

            int var4 = this.field1630 + this.field1631;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.field1629) {
               this.field1629 += 1024;
               if(this.field1629 > 16384) {
                  this.field1629 = 16384;
               }

               this.vmethod1923();
               this.vmethod1941(this.field1629);
               var3 = 0;
               this.field1644 = true;
               if(var4 + 256 > this.field1629) {
                  var4 = this.field1629 - 256;
                  this.field1631 = var4 - this.field1630;
               }
            }

            while(var3 < var4) {
               this.method1917(this.field1639, 256);
               this.vmethod1920();
               var3 += 256;
            }

            if(var1 > this.field1622) {
               if(!this.field1644) {
                  if(this.field1633 == 0 && this.field1634 == 0) {
                     this.vmethod1923();
                     this.field1632 = var1 + 2000L;
                     return;
                  }

                  this.field1631 = Math.min(this.field1634, this.field1633);
                  this.field1634 = this.field1633;
               } else {
                  this.field1644 = false;
               }

               this.field1633 = 0;
               this.field1622 = var1 + 2000L;
            }

            this.field1625 = var3;
         } catch (Exception var7) {
            this.vmethod1923();
            this.field1632 = var1 + 2000L;
         }

         try {
            if(var1 > this.field1628 + 500000L) {
               var1 = this.field1628;
            }

            while(var1 > this.field1628 + 5000L) {
               this.method1916(256);
               this.field1628 += (long)(256000 / field1635);
            }
         } catch (Exception var6) {
            this.field1628 = var1;
         }

      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-650997624"
   )
   public final void method1913() {
      this.field1644 = true;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-950288221"
   )
   final void method1916(int var1) {
      this.field1646 -= var1;
      if(this.field1646 < 0) {
         this.field1646 = 0;
      }

      if(this.field1645 != null) {
         this.field1645.vmethod3773(var1);
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1917(int[] var1, int var2) {
      int var3 = var2;
      if(class222.field2849) {
         var3 = var2 << 1;
      }

      class183.method3344(var1, 0, var3);
      this.field1646 -= var2;
      if(this.field1645 != null && this.field1646 <= 0) {
         this.field1646 += field1635 >> 4;
         class64.method1021(this.field1645);
         this.method1945(this.field1645, this.field1645.vmethod2209());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class119 var10;
         label104:
         for(var6 = 7; var5 != 0; --var6) {
            int var7;
            int var8;
            if(var6 < 0) {
               var7 = var6 & 3;
               var8 = -(var6 >> 2);
            } else {
               var7 = var6;
               var8 = 0;
            }

            for(int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  class119 var11 = this.field1640[var7];

                  label98:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label98;
                        }

                        class122 var12 = var11.field1717;
                        if(var12 != null && var12.field1749 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1718;
                        } else {
                           var11.field1716 = true;
                           int var13 = var11.vmethod3772();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1749 += var13;
                           }

                           if(var4 >= this.field1627) {
                              break label104;
                           }

                           class119 var14 = var11.vmethod3771();
                           if(var14 != null) {
                              for(int var15 = var11.field1715; var14 != null; var14 = var11.vmethod3780()) {
                                 this.method1945(var14, var15 * var14.vmethod2209() >> 8);
                              }
                           }

                           class119 var18 = var11.field1718;
                           var11.field1718 = null;
                           if(var10 == null) {
                              this.field1640[var7] = var18;
                           } else {
                              var10.field1718 = var18;
                           }

                           if(var18 == null) {
                              this.field1636[var7] = var10;
                           }

                           var11 = var18;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class119 var16 = this.field1640[var6];
            class119[] var17 = this.field1640;
            this.field1636[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1718;
               var16.field1718 = null;
            }
         }
      }

      if(this.field1646 < 0) {
         this.field1646 = 0;
      }

      if(this.field1645 != null) {
         this.field1645.vmethod3775(var1, 0, var2);
      }

      this.field1628 = class166.method2970();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1015812313"
   )
   protected void vmethod1919() throws Exception {
   }

   @ObfuscatedName("t")
   protected void vmethod1920() throws Exception {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "467486870"
   )
   protected void vmethod1923() {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "25"
   )
   protected void vmethod1924() throws Exception {
   }

   protected class109() {
      this.field1627 = 32;
      this.field1628 = class166.method2970();
      this.field1632 = 0L;
      this.field1633 = 0;
      this.field1634 = 0;
      this.field1625 = 0;
      this.field1622 = 0L;
      this.field1644 = true;
      this.field1646 = 0;
      this.field1640 = new class119[8];
      this.field1636 = new class119[8];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "512278666"
   )
   public final synchronized void method1938(class119 var1) {
      this.field1645 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-859545744"
   )
   protected void vmethod1941(int var1) throws Exception {
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "1431655765"
   )
   final void method1945(class119 var1, int var2) {
      int var3 = var2 >> 5;
      class119 var4 = this.field1636[var3];
      if(var4 == null) {
         this.field1640[var3] = var1;
      } else {
         var4.field1718 = var1;
      }

      this.field1636[var3] = var1;
      var1.field1715 = var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "-74"
   )
   static final void method1949(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = Region.method2579(var0, var1, var2);
      int[] var8 = Region.method2579(var3, var4, var5);
      Rasterizer2D.method4838(var7[0], var7[1], var8[0], var8[1], var6);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public final synchronized void method1950() {
      if(field1624 != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == field1624.field1659[var2]) {
               field1624.field1659[var2] = null;
            }

            if(field1624.field1659[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            field1621.shutdownNow();
            field1621 = null;
            field1624 = null;
         }
      }

      this.vmethod1923();
      this.field1639 = null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-685274721"
   )
   protected int vmethod1958() throws Exception {
      return this.field1629;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "758279351"
   )
   public final synchronized void method1961() {
      this.field1644 = true;

      try {
         this.vmethod1924();
      } catch (Exception var2) {
         this.vmethod1923();
         this.field1632 = class166.method2970() + 2000L;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass289;I)Ljava/lang/String;",
      garbageValue = "1394303625"
   )
   public static String method1965(CharSequence var0, class289 var1) {
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

         int var15 = var3 - var2;
         if(var15 >= 1 && var15 <= ObjectComposition.method4435(var1)) {
            StringBuilder var13 = new StringBuilder(var15);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               boolean var8;
               if(Character.isISOControl(var7)) {
                  var8 = false;
               } else {
                  boolean var9 = var7 >= 48 && var7 <= 57 || var7 >= 65 && var7 <= 90 || var7 >= 97 && var7 <= 122;
                  if(var9) {
                     var8 = true;
                  } else {
                     char[] var10 = class267.field3667;
                     int var11 = 0;

                     label123:
                     while(true) {
                        char var12;
                        if(var11 >= var10.length) {
                           var10 = class267.field3668;

                           for(var11 = 0; var11 < var10.length; ++var11) {
                              var12 = var10[var11];
                              if(var12 == var7) {
                                 var8 = true;
                                 break label123;
                              }
                           }

                           var8 = false;
                           break;
                        }

                        var12 = var10[var11];
                        if(var7 == var12) {
                           var8 = true;
                           break;
                        }

                        ++var11;
                     }
                  }
               }

               if(var8) {
                  char var16;
                  switch(var7) {
                  case ' ':
                  case '-':
                  case '_':
                  case ' ':
                     var16 = 95;
                     break;
                  case '#':
                  case '[':
                  case ']':
                     var16 = var7;
                     break;
                  case 'À':
                  case 'Á':
                  case 'Â':
                  case 'Ã':
                  case 'Ä':
                  case 'à':
                  case 'á':
                  case 'â':
                  case 'ã':
                  case 'ä':
                     var16 = 97;
                     break;
                  case 'Ç':
                  case 'ç':
                     var16 = 99;
                     break;
                  case 'È':
                  case 'É':
                  case 'Ê':
                  case 'Ë':
                  case 'è':
                  case 'é':
                  case 'ê':
                  case 'ë':
                     var16 = 101;
                     break;
                  case 'Í':
                  case 'Î':
                  case 'Ï':
                  case 'í':
                  case 'î':
                  case 'ï':
                     var16 = 105;
                     break;
                  case 'Ñ':
                  case 'ñ':
                     var16 = 110;
                     break;
                  case 'Ò':
                  case 'Ó':
                  case 'Ô':
                  case 'Õ':
                  case 'Ö':
                  case 'ò':
                  case 'ó':
                  case 'ô':
                  case 'õ':
                  case 'ö':
                     var16 = 111;
                     break;
                  case 'Ù':
                  case 'Ú':
                  case 'Û':
                  case 'Ü':
                  case 'ù':
                  case 'ú':
                  case 'û':
                  case 'ü':
                     var16 = 117;
                     break;
                  case 'ß':
                     var16 = 98;
                     break;
                  case 'ÿ':
                  case 'Ÿ':
                     var16 = 121;
                     break;
                  default:
                     var16 = Character.toLowerCase(var7);
                  }

                  if(var16 != 0) {
                     var13.append(var16);
                  }
               }
            }

            if(var13.length() == 0) {
               return null;
            } else {
               return var13.toString();
            }
         } else {
            return null;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1594367365"
   )
   static long method1967() {
      try {
         URL var0 = new URL(class73.method1066("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         Buffer var4 = new Buffer(new byte[1000]);

         do {
            int var5 = var3.read(var4.payload, var4.offset, 1000 - var4.offset);
            if(var5 == -1) {
               var4.offset = 0;
               long var7 = var4.readLong();
               return var7;
            }

            var4.offset += var5;
         } while(var4.offset < 1000);

         return 0L;
      } catch (Exception var9) {
         return 0L;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIII)V",
      garbageValue = "-785010051"
   )
   static final void method1968(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class61.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -class14.method89(var2 + 932731 + var4, var3 + 556238 + var5) * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.readUnsignedByte();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -var8 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class61.overlayIds[var1][var2][var3] = var0.readByte();
               class90.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class275.overlayRotations[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class61.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class61.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }
}
